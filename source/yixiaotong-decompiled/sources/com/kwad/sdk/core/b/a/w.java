package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class w implements com.kwad.sdk.core.d<AdGlobalConfigInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdGlobalConfigInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdGlobalConfigInfo) bVar, jSONObject);
    }

    private static void a(AdGlobalConfigInfo adGlobalConfigInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adGlobalConfigInfo.neoPageType = jSONObject.optInt("neoPageType");
        adGlobalConfigInfo.neoScanAggregationSceneInfo = new AdGlobalConfigInfo.NeoScanAggregationSceneInfo();
        adGlobalConfigInfo.neoScanAggregationSceneInfo.parseJson(jSONObject.optJSONObject("neoScanAggregationSceneInfo"));
        adGlobalConfigInfo.cycleAggregationInfo = new AdGlobalConfigInfo.CycleAggregationInfo();
        adGlobalConfigInfo.cycleAggregationInfo.parseJson(jSONObject.optJSONObject("cycleAggregationInfo"));
        adGlobalConfigInfo.uaidEnable = jSONObject.optBoolean("uaidEnable");
        adGlobalConfigInfo.adVideoPreCacheConfig = new AdVideoPreCacheConfig();
        adGlobalConfigInfo.adVideoPreCacheConfig.parseJson(jSONObject.optJSONObject("adVideoPreCacheConfig"));
        adGlobalConfigInfo.refreshToken = new AdGlobalConfigInfo.RefreshToken();
        adGlobalConfigInfo.refreshToken.parseJson(jSONObject.optJSONObject("refreshToken"));
        adGlobalConfigInfo.authError = jSONObject.optLong("authError");
    }

    private static JSONObject b(AdGlobalConfigInfo adGlobalConfigInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adGlobalConfigInfo.neoPageType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "neoPageType", adGlobalConfigInfo.neoPageType);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "neoScanAggregationSceneInfo", adGlobalConfigInfo.neoScanAggregationSceneInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "cycleAggregationInfo", adGlobalConfigInfo.cycleAggregationInfo);
        if (adGlobalConfigInfo.uaidEnable) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "uaidEnable", adGlobalConfigInfo.uaidEnable);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "adVideoPreCacheConfig", adGlobalConfigInfo.adVideoPreCacheConfig);
        com.kwad.sdk.utils.ac.a(jSONObject, "refreshToken", adGlobalConfigInfo.refreshToken);
        if (adGlobalConfigInfo.authError != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "authError", adGlobalConfigInfo.authError);
        }
        return jSONObject;
    }
}
