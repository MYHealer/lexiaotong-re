package com.huawei.hms.ads.reward;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface RewardAdListener {
    void onRewardAdClosed();

    void onRewardAdCompleted();

    void onRewardAdFailedToLoad(int i);

    void onRewardAdLeftApp();

    void onRewardAdLoaded();

    void onRewardAdOpened();

    void onRewardAdStarted();

    void onRewarded(Reward reward);
}
