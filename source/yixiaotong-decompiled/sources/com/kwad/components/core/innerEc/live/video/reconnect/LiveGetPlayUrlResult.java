package com.kwad.components.core.innerEc.live.video.reconnect;

import android.text.TextUtils;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class LiveGetPlayUrlResult extends BaseResultData {
    private static final long serialVersionUID = 9222360725822433120L;
    public a mPlayUrlConfig = new a();

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String responseData = d.getResponseData(jSONObject.optString("data"));
            if (TextUtils.isEmpty(responseData)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(responseData);
            this.mPlayUrlConfig.a(responseData, jSONObject2);
            this.mPlayUrlConfig.parseJson(jSONObject2);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }
}
