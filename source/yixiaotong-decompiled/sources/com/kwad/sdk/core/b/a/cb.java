package com.kwad.sdk.core.b.a;

import com.fancy.adsdk.lib.constants.PtgRewardConstant;
import com.kwad.components.core.innerEc.logger.BaseInnerEcMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class cb implements com.kwad.sdk.core.d<BaseInnerEcMsg> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((BaseInnerEcMsg) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((BaseInnerEcMsg) bVar, jSONObject);
    }

    private static void a(BaseInnerEcMsg baseInnerEcMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        baseInnerEcMsg.adStyle = jSONObject.optInt("ad_style");
        baseInnerEcMsg.materialType = jSONObject.optInt("material_type");
        baseInnerEcMsg.userId = jSONObject.optString(PtgRewardConstant.REWARD_PARAMS.USER_ID);
        if (JSONObject.NULL.toString().equals(baseInnerEcMsg.userId)) {
            baseInnerEcMsg.userId = "";
        }
        baseInnerEcMsg.status = jSONObject.optInt("status");
    }

    private static JSONObject b(BaseInnerEcMsg baseInnerEcMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (baseInnerEcMsg.adStyle != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_style", baseInnerEcMsg.adStyle);
        }
        if (baseInnerEcMsg.materialType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "material_type", baseInnerEcMsg.materialType);
        }
        if (baseInnerEcMsg.userId != null && !baseInnerEcMsg.userId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, PtgRewardConstant.REWARD_PARAMS.USER_ID, baseInnerEcMsg.userId);
        }
        if (baseInnerEcMsg.status != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", baseInnerEcMsg.status);
        }
        return jSONObject;
    }
}
