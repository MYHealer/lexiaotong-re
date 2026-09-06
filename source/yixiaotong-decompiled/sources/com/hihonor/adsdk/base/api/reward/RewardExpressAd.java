package com.hihonor.adsdk.base.api.reward;

import android.app.Activity;
import com.hihonor.adsdk.base.api.BaseExpressAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface RewardExpressAd extends BaseExpressAd {

    public interface RewardAdStatusListener {
        @Deprecated
        void onRewardAdClosed();

        void onRewardAdOpened();

        void onRewarded(RewardItem rewardItem);

        void onVideoError(int i);
    }

    void show(Activity activity);

    void show(Activity activity, RewardAdStatusListener rewardAdStatusListener);
}
