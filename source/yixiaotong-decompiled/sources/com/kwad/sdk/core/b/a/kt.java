package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.check.RewardCheckMonitorInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class kt implements com.kwad.sdk.core.d<RewardCheckMonitorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((RewardCheckMonitorInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((RewardCheckMonitorInfo) bVar, jSONObject);
    }

    private static void a(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardCheckMonitorInfo.checkType = jSONObject.optInt("check_type");
        rewardCheckMonitorInfo.requestStatus = jSONObject.optInt("request_state");
        rewardCheckMonitorInfo.code = jSONObject.optInt("code");
        rewardCheckMonitorInfo.creativeId = jSONObject.optLong("creative_id");
        rewardCheckMonitorInfo.dataLoadInterval = jSONObject.optLong("data_load_interval_duration_ms");
        rewardCheckMonitorInfo.posId = jSONObject.optLong("pos_Id");
        rewardCheckMonitorInfo.enviType = jSONObject.optInt("enviType");
    }

    private static JSONObject b(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (rewardCheckMonitorInfo.checkType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "check_type", rewardCheckMonitorInfo.checkType);
        }
        if (rewardCheckMonitorInfo.requestStatus != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_state", rewardCheckMonitorInfo.requestStatus);
        }
        if (rewardCheckMonitorInfo.code != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "code", rewardCheckMonitorInfo.code);
        }
        if (rewardCheckMonitorInfo.creativeId != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creative_id", rewardCheckMonitorInfo.creativeId);
        }
        if (rewardCheckMonitorInfo.dataLoadInterval != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "data_load_interval_duration_ms", rewardCheckMonitorInfo.dataLoadInterval);
        }
        if (rewardCheckMonitorInfo.posId != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pos_Id", rewardCheckMonitorInfo.posId);
        }
        if (rewardCheckMonitorInfo.enviType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "enviType", rewardCheckMonitorInfo.enviType);
        }
        return jSONObject;
    }
}
