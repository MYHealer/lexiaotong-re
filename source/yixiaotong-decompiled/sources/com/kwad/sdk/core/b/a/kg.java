package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class kg implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.ag.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.ag.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.ag.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.ag.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.playableExtraData = jSONObject.optString("playableExtraData");
        if (JSONObject.NULL.toString().equals(aVar.playableExtraData)) {
            aVar.playableExtraData = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.ag.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.playableExtraData != null && !aVar.playableExtraData.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "playableExtraData", aVar.playableExtraData);
        }
        return jSONObject;
    }
}
