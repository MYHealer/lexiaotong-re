package com.kwad.sdk.api.manager;

import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.api.model.KSAdRewardRetryTaskResult;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
@KsAdSdkApi
public interface RewardRetryTaskManager {

    @KsAdSdkApi
    public interface RetryRewardConvertResultListener {
        @KsAdSdkApi
        void onError(int i, String str);

        @KsAdSdkApi
        void onSuccess();
    }

    @KsAdSdkApi
    public interface RetryRewardResultListener {
        @KsAdSdkApi
        void onError(int i, String str);

        @KsAdSdkApi
        void onSuccess(List<KSAdRewardRetryTaskResult> list);
    }

    @KsAdSdkApi
    void rewardAdRetryTaskUpdate(KSAdInfoData kSAdInfoData, RetryRewardConvertResultListener retryRewardConvertResultListener);

    @KsAdSdkApi
    void setRetryRewardResultListener(List<KSAdInfoData> list, RetryRewardResultListener retryRewardResultListener);

    @KsAdSdkApi
    public static class Builder {
        @KsAdSdkApi
        public static RewardRetryTaskManager build() {
            return (RewardRetryTaskManager) Loader.get().newInstance(RewardRetryTaskManager.class);
        }
    }
}
