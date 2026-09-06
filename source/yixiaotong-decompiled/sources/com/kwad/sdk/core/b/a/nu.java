package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class nu implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.g> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.request.model.g) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.request.model.g) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.aXy = jSONObject.optString("thirdUserId");
        if (JSONObject.NULL.toString().equals(gVar.aXy)) {
            gVar.aXy = "";
        }
        gVar.aXz = jSONObject.optString("thirdUserName");
        if (JSONObject.NULL.toString().equals(gVar.aXz)) {
            gVar.aXz = "";
        }
        gVar.thirdAge = jSONObject.optInt("thirdAge");
        gVar.thirdGender = jSONObject.optInt("thirdGender");
        gVar.thirdInterest = jSONObject.optString("thirdInterest");
        if (JSONObject.NULL.toString().equals(gVar.thirdInterest)) {
            gVar.thirdInterest = "";
        }
        gVar.aXA = jSONObject.optString("authCode");
        if (JSONObject.NULL.toString().equals(gVar.aXA)) {
            gVar.aXA = "";
        }
        gVar.serviceToken = jSONObject.optString("serviceToken");
        if (JSONObject.NULL.toString().equals(gVar.serviceToken)) {
            gVar.serviceToken = "";
        }
        gVar.aXB = jSONObject.optString("authAppId");
        if (JSONObject.NULL.toString().equals(gVar.aXB)) {
            gVar.aXB = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (gVar.aXy != null && !gVar.aXy.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "thirdUserId", gVar.aXy);
        }
        if (gVar.aXz != null && !gVar.aXz.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "thirdUserName", gVar.aXz);
        }
        if (gVar.thirdAge != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "thirdAge", gVar.thirdAge);
        }
        if (gVar.thirdGender != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "thirdGender", gVar.thirdGender);
        }
        if (gVar.thirdInterest != null && !gVar.thirdInterest.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "thirdInterest", gVar.thirdInterest);
        }
        if (gVar.aXA != null && !gVar.aXA.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "authCode", gVar.aXA);
        }
        if (gVar.serviceToken != null && !gVar.serviceToken.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "serviceToken", gVar.serviceToken);
        }
        if (gVar.aXB != null && !gVar.aXB.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "authAppId", gVar.aXB);
        }
        return jSONObject;
    }
}
