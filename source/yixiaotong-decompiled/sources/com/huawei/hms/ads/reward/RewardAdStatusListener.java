package com.huawei.hms.ads.reward;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class RewardAdStatusListener {

    public interface ErrorCode {
        public static final int BACKGROUND = 3;
        public static final int INTERNAL = 0;
        public static final int NOT_LOADED = 2;
        public static final int REUSED = 1;
    }

    public void onRewardAdClosed() {
    }

    public void onRewardAdFailedToShow(int i) {
    }

    public void onRewardAdOpened() {
    }

    public void onRewarded(Reward reward) {
    }
}
