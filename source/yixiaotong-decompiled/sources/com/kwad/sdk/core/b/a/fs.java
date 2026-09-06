package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class fs implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.h.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.h.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.h.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.loadType = jSONObject.optInt("loadType");
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.loadType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "loadType", aVar.loadType);
        }
        return jSONObject;
    }
}
