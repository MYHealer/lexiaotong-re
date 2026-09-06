package com.kwad.sdk.crash.report.request;

import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CrashReportResult extends BaseResultData implements com.kwad.sdk.core.b {
    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        return super.toJson();
    }

    public long getResult() {
        return this.result;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }
}
