package com.kwad.components.ad.reward.retryReward;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class f extends com.kwad.sdk.core.response.a.a {
    public long BO;
    public long BP;
    public String key;
    public AdTemplate mAdTemplate;

    public f() {
    }

    public f(String str, AdTemplate adTemplate, long j) {
        this.key = str;
        this.mAdTemplate = adTemplate;
        this.BO = j;
        this.BP = System.currentTimeMillis();
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.key = jSONObject.optString("key");
            String strOptString = jSONObject.optString("adTemplate");
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(strOptString));
            this.BO = jSONObject.optLong("storeTime");
            this.BP = jSONObject.optLong("stageTime");
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", this.key);
            ac.a(jSONObject, "adTemplate", this.mAdTemplate);
            ac.putValue(jSONObject, "storeTime", this.BO);
            ac.putValue(jSONObject, "stageTime", this.BP);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return jSONObject;
    }
}
