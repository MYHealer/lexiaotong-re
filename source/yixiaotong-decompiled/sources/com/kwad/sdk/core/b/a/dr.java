package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class dr implements com.kwad.sdk.core.d<AdGlobalConfigInfo.CycleAggregationInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdGlobalConfigInfo.CycleAggregationInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdGlobalConfigInfo.CycleAggregationInfo) bVar, jSONObject);
    }

    private static void a(AdGlobalConfigInfo.CycleAggregationInfo cycleAggregationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cycleAggregationInfo.cycleAggregationSwitch = jSONObject.optBoolean("cycleAggregationSwitch");
        cycleAggregationInfo.cycleAggregationInterval = jSONObject.optInt("cycleAggregationInterval");
    }

    private static JSONObject b(AdGlobalConfigInfo.CycleAggregationInfo cycleAggregationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cycleAggregationInfo.cycleAggregationSwitch) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cycleAggregationSwitch", cycleAggregationInfo.cycleAggregationSwitch);
        }
        if (cycleAggregationInfo.cycleAggregationInterval != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cycleAggregationInterval", cycleAggregationInfo.cycleAggregationInterval);
        }
        return jSONObject;
    }
}
