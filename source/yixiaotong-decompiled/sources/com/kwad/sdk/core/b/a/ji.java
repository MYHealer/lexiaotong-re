package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ji implements com.kwad.sdk.core.d<AdGlobalConfigInfo.NeoScanAggregationSceneInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdGlobalConfigInfo.NeoScanAggregationSceneInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdGlobalConfigInfo.NeoScanAggregationSceneInfo) bVar, jSONObject);
    }

    private static void a(AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        neoScanAggregationSceneInfo.neoCountDownNeedSwipeTrigger = jSONObject.optBoolean("neoCountDownNeedSwipeTrigger");
        neoScanAggregationSceneInfo.neoCountDownTime = jSONObject.optInt("neoCountDownTime");
        neoScanAggregationSceneInfo.noActionStopCountDown = jSONObject.optBoolean("noActionStopCountDown");
        neoScanAggregationSceneInfo.noActionTime = jSONObject.optInt("noActionTime");
        neoScanAggregationSceneInfo.guidSwipezShowMore = jSONObject.optBoolean("guidSwipezShowMore");
        neoScanAggregationSceneInfo.mute = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.dd.C);
    }

    private static JSONObject b(AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (neoScanAggregationSceneInfo.neoCountDownNeedSwipeTrigger) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "neoCountDownNeedSwipeTrigger", neoScanAggregationSceneInfo.neoCountDownNeedSwipeTrigger);
        }
        if (neoScanAggregationSceneInfo.neoCountDownTime != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "neoCountDownTime", neoScanAggregationSceneInfo.neoCountDownTime);
        }
        if (neoScanAggregationSceneInfo.noActionStopCountDown) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "noActionStopCountDown", neoScanAggregationSceneInfo.noActionStopCountDown);
        }
        if (neoScanAggregationSceneInfo.noActionTime != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "noActionTime", neoScanAggregationSceneInfo.noActionTime);
        }
        if (neoScanAggregationSceneInfo.guidSwipezShowMore) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "guidSwipezShowMore", neoScanAggregationSceneInfo.guidSwipezShowMore);
        }
        if (neoScanAggregationSceneInfo.mute) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.huawei.openalliance.ad.constant.dd.C, neoScanAggregationSceneInfo.mute);
        }
        return jSONObject;
    }
}
