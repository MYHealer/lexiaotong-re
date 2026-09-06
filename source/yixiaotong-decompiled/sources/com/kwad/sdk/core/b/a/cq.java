package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class cq implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.a.f.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.a.f.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.a.f.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.a.f.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.text = jSONObject.optString("text");
        if (JSONObject.NULL.toString().equals(aVar.text)) {
            aVar.text = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.a.f.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.text != null && !aVar.text.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "text", aVar.text);
        }
        return jSONObject;
    }
}
