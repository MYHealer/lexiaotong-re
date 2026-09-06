package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class dl implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.an.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.an.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.an.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.an.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aqY = jSONObject.optBoolean("clickActionButton");
        aVar.aqZ = jSONObject.optString("adTemplate");
        if (JSONObject.NULL.toString().equals(aVar.aqZ)) {
            aVar.aqZ = "";
        }
        aVar.ara = jSONObject.optInt("area");
        aVar.arb = new com.kwad.sdk.core.webview.d.b.d();
        aVar.arb.parseJson(jSONObject.optJSONObject("logParam"));
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.an.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.aqY) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "clickActionButton", aVar.aqY);
        }
        if (aVar.aqZ != null && !aVar.aqZ.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adTemplate", aVar.aqZ);
        }
        if (aVar.ara != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "area", aVar.ara);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "logParam", aVar.arb);
        return jSONObject;
    }
}
