package com.kwad.components.ad.reward.retryReward;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.service.ServiceProvider;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class RewardRetryTaskParams extends BaseResultData {
    private final Map<Long, a> mTaskResultMap = new HashMap();

    public Map<Long, a> getTaskResultMap() {
        return this.mTaskResultMap;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("data");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            com.kwad.sdk.core.a.e eVar = (com.kwad.sdk.core.a.e) com.kwad.sdk.components.d.f(com.kwad.sdk.core.a.e.class);
            if (eVar != null) {
                strOptString = eVar.getResponseData(strOptString);
            }
            JSONArray jSONArrayOptJSONArray = new JSONObject(strOptString).optJSONArray("taskInfoList");
            if (jSONArrayOptJSONArray == null) {
                return;
            }
            for (int i = 0; jSONArrayOptJSONArray.length() > i; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                long jOptLong = jSONObjectOptJSONObject.optLong(KSUtil.REQUEST_ID);
                this.mTaskResultMap.put(Long.valueOf(jOptLong), new a(jOptLong, jSONObjectOptJSONObject.optLong("creativeId"), jSONObjectOptJSONObject.optInt("conversionStatus")));
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static class a {
        public int conversionStatus;
        public long creativeId;
        public long llsid;

        public a(long j, long j2, int i) {
            this.llsid = j;
            this.conversionStatus = i;
            this.creativeId = j2;
        }
    }
}
