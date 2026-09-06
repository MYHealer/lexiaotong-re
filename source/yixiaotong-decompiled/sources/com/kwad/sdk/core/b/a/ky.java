package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ky implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.retryReward.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.retryReward.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.retryReward.c) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.reward.retryReward.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.status = jSONObject.optInt("status");
        cVar.Bz = jSONObject.optString("convert_url");
        if (JSONObject.NULL.toString().equals(cVar.Bz)) {
            cVar.Bz = "";
        }
        cVar.convertType = jSONObject.optInt("convert_type");
        cVar.BA = jSONObject.optString("ad_desc");
        if (JSONObject.NULL.toString().equals(cVar.BA)) {
            cVar.BA = "";
        }
        cVar.productName = jSONObject.optString("product_name");
        if (JSONObject.NULL.toString().equals(cVar.productName)) {
            cVar.productName = "";
        }
        cVar.tT = jSONObject.optString("icon_url");
        if (JSONObject.NULL.toString().equals(cVar.tT)) {
            cVar.tT = "";
        }
        cVar.errorCode = jSONObject.optInt("error_code");
        cVar.errorMsg = jSONObject.optString(com.hihonor.adsdk.base.g.j.e.a.hnadst);
        if (JSONObject.NULL.toString().equals(cVar.errorMsg)) {
            cVar.errorMsg = "";
        }
    }

    private static JSONObject b(com.kwad.components.ad.reward.retryReward.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.status != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", cVar.status);
        }
        if (cVar.Bz != null && !cVar.Bz.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "convert_url", cVar.Bz);
        }
        if (cVar.convertType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "convert_type", cVar.convertType);
        }
        if (cVar.BA != null && !cVar.BA.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_desc", cVar.BA);
        }
        if (cVar.productName != null && !cVar.productName.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "product_name", cVar.productName);
        }
        if (cVar.tT != null && !cVar.tT.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "icon_url", cVar.tT);
        }
        if (cVar.errorCode != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "error_code", cVar.errorCode);
        }
        if (cVar.errorMsg != null && !cVar.errorMsg.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.hihonor.adsdk.base.g.j.e.a.hnadst, cVar.errorMsg);
        }
        return jSONObject;
    }
}
