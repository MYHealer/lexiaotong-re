package com.kwad.sdk.core.report;

import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.ac;
import com.umeng.analytics.pro.am;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BatchReportResult extends BaseResultData implements com.kwad.sdk.core.b {
    private long interval;

    public long getInterval() {
        return this.interval;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.interval = jSONObject.optLong(am.aT);
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        ac.putValue(json, am.aT, this.interval);
        return json;
    }

    public long getResult() {
        return this.result;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }
}
