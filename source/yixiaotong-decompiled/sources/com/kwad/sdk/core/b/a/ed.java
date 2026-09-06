package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ed implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.C0692a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.a.C0692a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.a.C0692a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.a.a.C0692a c0692a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0692a.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c0692a.url)) {
            c0692a.url = "";
        }
        c0692a.packageName = jSONObject.optString("packageName");
        if (JSONObject.NULL.toString().equals(c0692a.packageName)) {
            c0692a.packageName = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.a.a.C0692a c0692a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0692a.url != null && !c0692a.url.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", c0692a.url);
        }
        if (c0692a.packageName != null && !c0692a.packageName.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "packageName", c0692a.packageName);
        }
        return jSONObject;
    }
}
