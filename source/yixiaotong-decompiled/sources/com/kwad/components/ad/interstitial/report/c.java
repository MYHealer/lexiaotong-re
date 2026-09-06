package com.kwad.components.ad.interstitial.report;

import android.os.SystemClock;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class c {

    static class a {
        private static final c os = new c();
    }

    public static c eZ() {
        return a.os;
    }

    private static void a(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        if (o.Gs().Fx()) {
            com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m983do(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).g(z ? 1.0d : 0.01d).Q("ad_sdk_interstitial_load", "status").b(BusinessType.AD_INTERSTITIAL).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
        }
    }

    public final void p(long j) {
        a(false, new InterstitialReportInfo().setStatus(1).setPosId(j));
    }

    public final void C(AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(6).setAdTemplate(adTemplate));
    }

    public final void D(AdTemplate adTemplate) {
        try {
            a(false, new InterstitialReportInfo(adTemplate).setStatus(8).setType(adTemplate.notNetworkRequest ? 2 : 1).setMaterialType(com.kwad.sdk.core.response.helper.a.bk(e.eO(adTemplate))).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void a(AdTemplate adTemplate, int i, String str) {
        a(true, new InterstitialReportInfo(adTemplate).setStatus(9).setErrorCode(i).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public final void a(AdTemplate adTemplate, boolean z) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(2).setType(z ? 2 : 1).setLoadDataTime(adTemplate.loadDataTime).setExpectedRenderType().setAdTemplate(adTemplate));
    }

    public final void b(AdTemplate adTemplate, boolean z) {
        adTemplate.notNetworkRequest = z;
        a(false, new InterstitialReportInfo(adTemplate).setStatus(3).setType(adTemplate.notNetworkRequest ? 2 : 1).setDownloadDuration(adTemplate.downloadDuration).setDownloadSize(adTemplate.getDownloadSize()).setDownloadType(adTemplate.getDownloadType()).setAdTemplate(adTemplate));
    }

    public final void E(AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(10).setAdTemplate(adTemplate));
    }

    public final void F(AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(7).setAdTemplate(adTemplate));
    }

    public final void G(AdTemplate adTemplate) {
        a(true, new InterstitialReportInfo(adTemplate).setStatus(12).setRenderType(com.kwad.sdk.core.response.helper.b.dJ(adTemplate) ? 3 : 1).setAdTemplate(adTemplate));
    }

    public final void H(AdTemplate adTemplate) {
        a(true, new InterstitialReportInfo(adTemplate).setStatus(11).setRenderType(1).setAdTemplate(adTemplate));
    }

    public final void c(AdTemplate adTemplate, int i) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(4).setType(adTemplate.notNetworkRequest ? 2 : 1).setMaterialType(com.kwad.sdk.core.response.helper.a.bk(e.eO(adTemplate))).setRenderDuration(SystemClock.elapsedRealtime() - adTemplate.adShowStartTimeStamp).setRenderType(i).setExpectedRenderType().setAdTemplate(adTemplate));
    }

    public final void a(int i, String str, long j) {
        a(true, new InterstitialReportInfo().setStatus(5).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }
}
