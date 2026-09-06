package com.adprof.sdk.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface RewardAdListener {
    void onAdSkip();

    void onRewardAdClick();

    void onRewardAdClosed();

    void onRewardAdLoadCached();

    void onRewardAdLoadError(AdError adError);

    void onRewardAdLoadSuccess();

    void onRewardAdPlayEnd();

    void onRewardAdPlayStart();

    void onRewardAdShow();

    void onRewardAdShowError(AdError adError);

    void onRewardVerify();
}
