package com.kwad.sdk.core.report;

import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ad;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class e extends com.kwad.sdk.core.response.a.a {
    public String actionId;
    private JSONObject mMergeJsonData;

    public void setJsonMergeData(JSONObject jSONObject) {
        this.mMergeJsonData = jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null) {
            this.mMergeJsonData = jSONObject.optJSONObject("mMergeJsonData");
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        JSONObject jSONObject2 = this.mMergeJsonData;
        if (jSONObject2 != null) {
            ac.putValue(jSONObject, "mMergeJsonData", jSONObject2);
        }
    }

    public JSONObject buildReportData() {
        JSONObject json = toJson();
        if (this.mMergeJsonData != null) {
            json.remove("mMergeJsonData");
            ad.merge(json, this.mMergeJsonData);
        }
        return json;
    }
}
