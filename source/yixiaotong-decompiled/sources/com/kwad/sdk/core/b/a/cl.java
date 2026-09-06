package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class cl implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.a.a.C0696a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.a.a.C0696a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.a.a.C0696a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.a.a.C0696a c0696a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0696a.arX = jSONObject.optString("android");
        if (JSONObject.NULL.toString().equals(c0696a.arX)) {
            c0696a.arX = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.a.a.C0696a c0696a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0696a.arX != null && !c0696a.arX.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "android", c0696a.arX);
        }
        return jSONObject;
    }
}
