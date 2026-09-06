package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class n implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.convert.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.convert.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.convert.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.convert.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.methodName = jSONObject.optString("method_name");
        if (JSONObject.NULL.toString().equals(bVar.methodName)) {
            bVar.methodName = "";
        }
        bVar.aKo = jSONObject.optBoolean("is_convert");
        bVar.adNum = jSONObject.optInt("ad_num");
        bVar.aKp = jSONObject.optBoolean("is_api_native");
        bVar.aKq = jSONObject.optString("ad_request_type");
        if (JSONObject.NULL.toString().equals(bVar.aKq)) {
            bVar.aKq = "";
        }
        bVar.adSource = jSONObject.optString("ad_require_source");
        if (JSONObject.NULL.toString().equals(bVar.adSource)) {
            bVar.adSource = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.commercial.convert.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.methodName != null && !bVar.methodName.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "method_name", bVar.methodName);
        }
        if (bVar.aKo) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_convert", bVar.aKo);
        }
        if (bVar.adNum != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_num", bVar.adNum);
        }
        if (bVar.aKp) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_api_native", bVar.aKp);
        }
        if (bVar.aKq != null && !bVar.aKq.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_request_type", bVar.aKq);
        }
        if (bVar.adSource != null && !bVar.adSource.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_require_source", bVar.adSource);
        }
        return jSONObject;
    }
}
