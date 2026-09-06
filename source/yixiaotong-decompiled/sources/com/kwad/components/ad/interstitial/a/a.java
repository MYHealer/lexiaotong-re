package com.kwad.components.ad.interstitial.a;

import android.text.TextUtils;
import com.kwad.components.ad.interstitial.report.b;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.y;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a {
    public static boolean w(AdTemplate adTemplate) {
        boolean zA;
        f fVarCm;
        String strM = com.kwad.sdk.core.response.helper.a.M(e.eO(adTemplate));
        if (TextUtils.isEmpty(strM)) {
            b.eX().b(adTemplate, "empty videoUrl");
            return false;
        }
        b.eX().B(adTemplate);
        int iGa = com.kwad.sdk.core.config.e.Ga();
        String str = "";
        if (iGa < 0) {
            File fileCO = com.kwad.sdk.core.diskcache.b.a.Lx().cO(strM);
            if (y.Q(fileCO)) {
                zA = true;
            } else {
                com.kwad.sdk.core.network.a.a.C0746a c0746a = new com.kwad.sdk.core.network.a.a.C0746a();
                zA = com.kwad.sdk.core.diskcache.b.a.Lx().a(strM, c0746a);
                str = c0746a.msg;
            }
            adTemplate.setDownloadSize(fileCO != null ? fileCO.length() : 0L);
            adTemplate.setDownloadType(2);
        } else if (iGa > 0) {
            com.kwad.sdk.core.network.a.a.C0746a c0746a2 = new com.kwad.sdk.core.network.a.a.C0746a();
            if (com.kwad.sdk.core.config.e.KA() == 1) {
                fVarCm = com.kwad.sdk.core.videocache.c.a.b(ServiceProvider.getContext(), 1, 0);
            } else if (com.kwad.sdk.core.config.e.KA() == 2) {
                fVarCm = com.kwad.sdk.core.videocache.c.a.b(ServiceProvider.getContext(), 1, 1);
            } else {
                fVarCm = com.kwad.sdk.core.videocache.c.a.cm(ServiceProvider.getContext());
            }
            zA = !fVarCm.fz(strM) ? fVarCm.a(strM, iGa * 1024, c0746a2, null) : true;
            str = c0746a2.msg;
            adTemplate.setDownloadSize(((long) iGa) * 1024);
            adTemplate.setDownloadType(3);
        } else {
            adTemplate.setDownloadSize(0L);
            adTemplate.setDownloadType(1);
            zA = true;
        }
        if (!zA) {
            adTemplate.setDownloadStatus(2);
            b.eX().b(adTemplate, str);
            com.kwad.components.ad.interstitial.report.realtime.a.fd();
            com.kwad.components.ad.interstitial.report.realtime.a.b(str, adTemplate);
        } else {
            adTemplate.setDownloadStatus(1);
        }
        return zA;
    }
}
