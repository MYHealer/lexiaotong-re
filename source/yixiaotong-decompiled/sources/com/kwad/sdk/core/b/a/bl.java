package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class bl implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.au.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.au.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.au.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.au.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.arg = jSONObject.optDouble("progress");
        aVar.status = jSONObject.optInt("status");
        aVar.totalBytes = jSONObject.optLong("totalBytes");
        aVar.soFarBytes = jSONObject.optLong("soFarBytes");
        aVar.arh = jSONObject.optDouble("realProgress");
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.au.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.arg != 0.0d) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "progress", aVar.arg);
        }
        if (aVar.status != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", aVar.status);
        }
        if (aVar.totalBytes != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "totalBytes", aVar.totalBytes);
        }
        if (aVar.soFarBytes != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "soFarBytes", aVar.soFarBytes);
        }
        if (aVar.arh != 0.0d) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "realProgress", aVar.arh);
        }
        return jSONObject;
    }
}
