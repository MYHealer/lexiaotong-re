package com.kwad.components.ad.reward.retryReward;

import com.kwad.sdk.api.model.KSAdRewardRetryTaskResult;
import com.kwad.sdk.i;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class RewardRetryTaskNetRequest extends com.kwad.sdk.core.network.d {
    @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    public RewardRetryTaskNetRequest(List<KSAdRewardRetryTaskResult> list) {
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (KSAdRewardRetryTaskResult kSAdRewardRetryTaskResult : list) {
                    if (kSAdRewardRetryTaskResult != null && kSAdRewardRetryTaskResult.ksAdInfoData != null) {
                        arrayList.add(new TaskInfo(Long.parseLong(kSAdRewardRetryTaskResult.ksAdInfoData.getLlsid()), kSAdRewardRetryTaskResult.ksAdInfoData.getCreativeId()));
                    }
                }
                putBody("taskInfoList", arrayList);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return i.Fc();
    }

    public static class TaskInfo implements com.kwad.sdk.core.b, Serializable {
        public long creativeId;
        public long llsid;

        public TaskInfo(long j, long j2) {
            this.llsid = j;
            this.creativeId = j2;
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.llsid = jSONObject.optLong(KSUtil.REQUEST_ID);
            this.creativeId = jSONObject.optLong("creativeId");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, KSUtil.REQUEST_ID, this.llsid);
            ac.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }
    }
}
