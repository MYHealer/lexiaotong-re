package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class hk implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.bj.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.bj.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.bj.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.bj.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.nm = jSONObject.optInt("itemClickType");
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.bj.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.nm != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "itemClickType", aVar.nm);
        }
        return jSONObject;
    }
}
