package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class mq implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.v.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.v.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.v.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.v.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.packageName = jSONObject.optString("packageName");
        if (JSONObject.NULL.toString().equals(bVar.packageName)) {
            bVar.packageName = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.v.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.packageName != null && !bVar.packageName.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "packageName", bVar.packageName);
        }
        return jSONObject;
    }
}
