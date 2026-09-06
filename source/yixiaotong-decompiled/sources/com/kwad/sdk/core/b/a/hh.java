package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class hh implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.ap.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.ap.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.ap.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.ap.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.arg = jSONObject.optDouble("progress");
        bVar.status = jSONObject.optInt("status");
        bVar.totalBytes = jSONObject.optLong("totalBytes");
        bVar.soFarBytes = jSONObject.optLong("soFarBytes");
        bVar.arh = jSONObject.optDouble("realProgress");
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.ap.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.arg != 0.0d) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "progress", bVar.arg);
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", bVar.status);
        }
        if (bVar.totalBytes != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "totalBytes", bVar.totalBytes);
        }
        if (bVar.soFarBytes != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "soFarBytes", bVar.soFarBytes);
        }
        if (bVar.arh != 0.0d) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "realProgress", bVar.arh);
        }
        return jSONObject;
    }
}
