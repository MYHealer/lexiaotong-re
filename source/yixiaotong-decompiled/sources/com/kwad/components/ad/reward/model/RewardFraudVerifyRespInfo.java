package com.kwad.components.ad.reward.model;

import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.br;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class RewardFraudVerifyRespInfo extends BaseResultData {
    private static final long serialVersionUID = -8657363515914699792L;
    private FraudDataInfo data = new FraudDataInfo();

    public static class FraudDataInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -8657363515914699792L;
        public int code;
        public boolean fraud;

        public int getCode() {
            return this.code;
        }

        public boolean isFraud() {
            return this.fraud;
        }
    }

    public boolean isFraud() {
        return this.data.isFraud();
    }

    public int getCode() {
        return this.data.getCode();
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            String strOptString = jSONObject.optString("data");
            if (!br.isNullString(strOptString)) {
                strOptString = ((e) com.kwad.sdk.components.d.f(e.class)).getResponseData(strOptString);
            }
            this.data.parseJson(new JSONObject(strOptString));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public JSONObject baseToJson() {
        JSONObject json = super.toJson();
        ac.a(json, "data", this.data);
        return json;
    }
}
