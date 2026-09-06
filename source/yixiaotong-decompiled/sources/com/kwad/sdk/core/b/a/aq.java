package com.kwad.sdk.core.b.a;

import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class aq implements com.kwad.sdk.core.d<AdInfo.AdRewardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdRewardInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdRewardInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adRewardInfo.skipShowTime = jSONObject.optInt("skipShowTime", new Integer(BaseWrapper.ENTER_ID_TOOLKIT).intValue());
        adRewardInfo.rewardTime = jSONObject.optInt("rewardTime", new Integer(BaseWrapper.ENTER_ID_TOOLKIT).intValue());
        adRewardInfo.showLandingPage = jSONObject.optInt("showLandingPage");
        adRewardInfo.rewardVideoEndCardSwitch = jSONObject.optBoolean("rewardVideoEndCardSwitch");
        adRewardInfo.recommendAggregateSwitch = jSONObject.optBoolean("recommendAggregateSwitch");
        adRewardInfo.callBackStrategyInfo = new AdInfo.CallBackStrategyInfo();
        adRewardInfo.callBackStrategyInfo.parseJson(jSONObject.optJSONObject("callBackStrategyInfo"));
        adRewardInfo.rewardFraudVerifyInfo = new AdInfo.RewardFraudVerifyInfo();
        adRewardInfo.rewardFraudVerifyInfo.parseJson(jSONObject.optJSONObject("rewardFraudVerifyInfo"));
        adRewardInfo.rewardRetryTaskInfo = new AdInfo.RewardRetryTaskInfo();
        adRewardInfo.rewardRetryTaskInfo.parseJson(jSONObject.optJSONObject("rewardRetryTaskInfo"));
    }

    private static JSONObject b(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "skipShowTime", adRewardInfo.skipShowTime);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "rewardTime", adRewardInfo.rewardTime);
        if (adRewardInfo.showLandingPage != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "showLandingPage", adRewardInfo.showLandingPage);
        }
        if (adRewardInfo.rewardVideoEndCardSwitch) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "rewardVideoEndCardSwitch", adRewardInfo.rewardVideoEndCardSwitch);
        }
        if (adRewardInfo.recommendAggregateSwitch) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "recommendAggregateSwitch", adRewardInfo.recommendAggregateSwitch);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "callBackStrategyInfo", adRewardInfo.callBackStrategyInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "rewardFraudVerifyInfo", adRewardInfo.rewardFraudVerifyInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "rewardRetryTaskInfo", adRewardInfo.rewardRetryTaskInfo);
        return jSONObject;
    }
}
