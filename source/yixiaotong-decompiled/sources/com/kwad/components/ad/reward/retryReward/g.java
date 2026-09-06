package com.kwad.components.ad.reward.retryReward;

import com.kwad.sdk.api.manager.RewardRetryTaskManager;
import com.kwad.sdk.api.model.KSAdRewardRetryTaskResult;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class g {
    public static synchronized void a(final List<KSAdRewardRetryTaskResult> list, final RewardRetryTaskManager.RetryRewardResultListener retryRewardResultListener) {
        i.execute(new bi() { // from class: com.kwad.components.ad.reward.retryReward.g.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                List list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                com.kwad.sdk.core.d.c.d("RewardRetryTaskNetWorker", "requestIndustryInfo start");
                new l<RewardRetryTaskNetRequest, RewardRetryTaskParams>() { // from class: com.kwad.components.ad.reward.retryReward.g.1.1
                    @Override // com.kwad.sdk.core.network.l
                    public final /* synthetic */ BaseResultData parseData(String str) {
                        return aa(str);
                    }

                    private static RewardRetryTaskParams aa(String str) {
                        RewardRetryTaskParams rewardRetryTaskParams = new RewardRetryTaskParams();
                        try {
                            rewardRetryTaskParams.parseJson(new JSONObject(str));
                        } catch (Throwable th) {
                            ServiceProvider.reportSdkCaughtException(th);
                        }
                        return rewardRetryTaskParams;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.a
                    /* JADX INFO: renamed from: kL, reason: merged with bridge method [inline-methods] */
                    public RewardRetryTaskNetRequest createRequest() {
                        return new RewardRetryTaskNetRequest(list);
                    }
                }.request(new o<RewardRetryTaskNetRequest, RewardRetryTaskParams>() { // from class: com.kwad.components.ad.reward.retryReward.g.1.2
                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                        a((RewardRetryTaskParams) baseResultData);
                    }

                    private void a(RewardRetryTaskParams rewardRetryTaskParams) {
                        String llsid;
                        RewardRetryTaskParams.a aVar;
                        com.kwad.sdk.core.d.c.d("RewardRetryTaskNetWorker", "rewardTask query successfully");
                        try {
                            Map<Long, RewardRetryTaskParams.a> taskResultMap = rewardRetryTaskParams.getTaskResultMap();
                            if (taskResultMap.keySet().isEmpty()) {
                                return;
                            }
                            for (KSAdRewardRetryTaskResult kSAdRewardRetryTaskResult : list) {
                                if (kSAdRewardRetryTaskResult != null && kSAdRewardRetryTaskResult.ksAdInfoData != null && (llsid = kSAdRewardRetryTaskResult.ksAdInfoData.getLlsid()) != null && (aVar = taskResultMap.get(Long.valueOf(Long.parseLong(llsid)))) != null) {
                                    kSAdRewardRetryTaskResult.conversionStatus = aVar.conversionStatus;
                                }
                            }
                            retryRewardResultListener.onSuccess(list);
                        } catch (Throwable th) {
                            ServiceProvider.reportSdkCaughtException(th);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onError(RewardRetryTaskNetRequest rewardRetryTaskNetRequest, int i, String str) {
                        super.onError(rewardRetryTaskNetRequest, i, str);
                        com.kwad.sdk.core.d.c.d("RewardRetryTaskNetWorker", "onError errorCode=" + i + " errorMsg=" + str);
                        retryRewardResultListener.onError(i, str);
                    }
                });
            }
        });
    }
}
