package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class fv implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.j.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.j.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.j.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.apD = jSONObject.optInt("playableSrc");
        bVar.apE = jSONObject.optInt("isMiddleEnd");
        bVar.aaV = jSONObject.optInt("adType");
        bVar.apF = jSONObject.optString("showTime");
        if (JSONObject.NULL.toString().equals(bVar.apF)) {
            bVar.apF = "";
        }
        bVar.convertCount = jSONObject.optInt("convertCount");
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.apD != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "playableSrc", bVar.apD);
        }
        if (bVar.apE != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isMiddleEnd", bVar.apE);
        }
        if (bVar.aaV != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adType", bVar.aaV);
        }
        if (bVar.apF != null && !bVar.apF.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "showTime", bVar.apF);
        }
        if (bVar.convertCount != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "convertCount", bVar.convertCount);
        }
        return jSONObject;
    }
}
