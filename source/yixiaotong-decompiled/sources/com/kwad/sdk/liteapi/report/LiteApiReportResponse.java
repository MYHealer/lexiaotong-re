package com.kwad.sdk.liteapi.report;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class LiteApiReportResponse {
    String errorMsg;
    long result;

    boolean isLegal() {
        return this.result == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.result = jSONObject.optLong("result");
        this.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
    }

    public String toString() {
        return "LiteApiReportResponse{result=" + this.result + ", errorMsg='" + this.errorMsg + "'}";
    }
}
