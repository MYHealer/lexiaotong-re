package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ks implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.d.b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.d.b.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(aVar.url)) {
            aVar.url = "";
        }
        aVar.method = jSONObject.optString("method");
        if (JSONObject.NULL.toString().equals(aVar.method)) {
            aVar.method = "";
        }
        aVar.params = jSONObject.optString("params");
        if (JSONObject.NULL.toString().equals(aVar.params)) {
            aVar.params = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.url != null && !aVar.url.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", aVar.url);
        }
        if (aVar.method != null && !aVar.method.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "method", aVar.method);
        }
        if (aVar.params != null && !aVar.params.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "params", aVar.params);
        }
        return jSONObject;
    }
}
