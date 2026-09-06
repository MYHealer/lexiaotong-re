package com.kwad.components.core.webview.tachikoma.a;

import com.kwad.components.core.webview.jshandler.n;
import com.kwad.sdk.components.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class d implements m {
    public abstract AdTemplate zq();

    @Override // com.kwad.sdk.components.m
    public final Object call(Object... objArr) {
        try {
            n.a aVar = new n.a();
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj instanceof String) {
                    aVar.parseJson(new JSONObject((String) obj));
                }
            }
            com.kwad.sdk.core.download.a.ew(com.kwad.sdk.core.response.helper.e.eO(a(aVar)).adConversionInfo.appDownloadUrl);
            return Boolean.TRUE;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    private AdTemplate a(n.a aVar) {
        if (aVar.adTemplate != null) {
            return aVar.adTemplate;
        }
        return zq();
    }
}
