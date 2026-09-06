package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class lu implements com.kwad.sdk.core.d<com.kwad.components.core.innerEc.live.f.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.innerEc.live.f.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.innerEc.live.f.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.innerEc.live.f.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.Xv = jSONObject.optString("areaCode");
        if (JSONObject.NULL.toString().equals(bVar.Xv)) {
            bVar.Xv = "";
        }
        bVar.Xw = jSONObject.optLong("pendantResourceId");
        bVar.Xx = jSONObject.optString("pendantCode");
        if (JSONObject.NULL.toString().equals(bVar.Xx)) {
            bVar.Xx = "";
        }
        bVar.action = jSONObject.optInt("action");
        bVar.Xy = jSONObject.optString("eventData");
        if (JSONObject.NULL.toString().equals(bVar.Xy)) {
            bVar.Xy = "";
        }
        bVar.XA = jSONObject.optBoolean("needServerProcess");
        bVar.XB = jSONObject.optBoolean("needBusinessHandle");
        bVar.XC = jSONObject.optString("callbackApi");
        if (JSONObject.NULL.toString().equals(bVar.XC)) {
            bVar.XC = "";
        }
        bVar.XD = jSONObject.optBoolean("needRandomCall");
        bVar.XE = jSONObject.optLong("randomRangeMillis");
        bVar.XF = jSONObject.optBoolean("needSignalFallback");
        bVar.XG = jSONObject.optString("callbackPath");
        if (JSONObject.NULL.toString().equals(bVar.XG)) {
            bVar.XG = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.innerEc.live.f.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.Xv != null && !bVar.Xv.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "areaCode", bVar.Xv);
        }
        if (bVar.Xw != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pendantResourceId", bVar.Xw);
        }
        if (bVar.Xx != null && !bVar.Xx.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pendantCode", bVar.Xx);
        }
        if (bVar.action != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "action", bVar.action);
        }
        if (bVar.Xy != null && !bVar.Xy.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "eventData", bVar.Xy);
        }
        if (bVar.XA) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "needServerProcess", bVar.XA);
        }
        if (bVar.XB) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "needBusinessHandle", bVar.XB);
        }
        if (bVar.XC != null && !bVar.XC.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "callbackApi", bVar.XC);
        }
        if (bVar.XD) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "needRandomCall", bVar.XD);
        }
        if (bVar.XE != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "randomRangeMillis", bVar.XE);
        }
        if (bVar.XF) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "needSignalFallback", bVar.XF);
        }
        if (bVar.XG != null && !bVar.XG.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "callbackPath", bVar.XG);
        }
        return jSONObject;
    }
}
