package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class la implements com.kwad.sdk.core.d<AdMatrixInfo.RewardVideoInteractInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.RewardVideoInteractInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.RewardVideoInteractInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.RewardVideoInteractInfo rewardVideoInteractInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardVideoInteractInfo.templateId = jSONObject.optString("templateId");
        if (JSONObject.NULL.toString().equals(rewardVideoInteractInfo.templateId)) {
            rewardVideoInteractInfo.templateId = "";
        }
        rewardVideoInteractInfo.showTime = jSONObject.optInt("showTime", new Integer("15").intValue());
        rewardVideoInteractInfo.duration = jSONObject.optInt("duration", new Integer("10").intValue());
        rewardVideoInteractInfo.rewardTime = jSONObject.optInt("rewardTime", new Integer("5").intValue());
        rewardVideoInteractInfo.intervalShow = jSONObject.optInt("intervalShow", new Integer("3").intValue());
        rewardVideoInteractInfo.dayMaxLimit = jSONObject.optInt("dayMaxLimit", new Integer("2").intValue());
        rewardVideoInteractInfo.style = jSONObject.optInt("style");
        rewardVideoInteractInfo.successfulMsg = jSONObject.optString("successfulMsg");
        if (JSONObject.NULL.toString().equals(rewardVideoInteractInfo.successfulMsg)) {
            rewardVideoInteractInfo.successfulMsg = "";
        }
        rewardVideoInteractInfo.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (JSONObject.NULL.toString().equals(rewardVideoInteractInfo.errorMsg)) {
            rewardVideoInteractInfo.errorMsg = "";
        }
        rewardVideoInteractInfo.styleInfo = new AdMatrixInfo.StyleInfo();
        rewardVideoInteractInfo.styleInfo.parseJson(jSONObject.optJSONObject("styleInfo"));
    }

    private static JSONObject b(AdMatrixInfo.RewardVideoInteractInfo rewardVideoInteractInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (rewardVideoInteractInfo.templateId != null && !rewardVideoInteractInfo.templateId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "templateId", rewardVideoInteractInfo.templateId);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "showTime", rewardVideoInteractInfo.showTime);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "duration", rewardVideoInteractInfo.duration);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "rewardTime", rewardVideoInteractInfo.rewardTime);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "intervalShow", rewardVideoInteractInfo.intervalShow);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "dayMaxLimit", rewardVideoInteractInfo.dayMaxLimit);
        if (rewardVideoInteractInfo.style != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "style", rewardVideoInteractInfo.style);
        }
        if (rewardVideoInteractInfo.successfulMsg != null && !rewardVideoInteractInfo.successfulMsg.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "successfulMsg", rewardVideoInteractInfo.successfulMsg);
        }
        if (rewardVideoInteractInfo.errorMsg != null && !rewardVideoInteractInfo.errorMsg.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, rewardVideoInteractInfo.errorMsg);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "styleInfo", rewardVideoInteractInfo.styleInfo);
        return jSONObject;
    }
}
