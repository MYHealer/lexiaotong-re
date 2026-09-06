package com.kwad.components.core.innerEc.live.config.net;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class LiveStartPlayResult extends BaseResultData {
    private static final long serialVersionUID = -978212481692450618L;
    public g mStartPlayConfig = new g();

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String responseData = com.kwad.sdk.core.a.d.getResponseData(jSONObject.optString("data"));
            if (TextUtils.isEmpty(responseData)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(responseData);
            this.mStartPlayConfig.a(responseData, jSONObject2);
            this.mStartPlayConfig.parseJson(jSONObject2);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }
}
