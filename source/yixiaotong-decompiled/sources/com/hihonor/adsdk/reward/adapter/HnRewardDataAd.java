package com.hihonor.adsdk.reward.adapter;

import android.app.Activity;
import com.hihonor.adsdk.base.api.HnMediationExpressDataAd;
import com.hihonor.adsdk.base.api.reward.RewardExpressAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnRewardDataAd extends HnMediationExpressDataAd<RewardExpressAd> implements RewardExpressAd {
    public HnRewardDataAd(RewardExpressAd rewardExpressAd) {
        super(rewardExpressAd);
    }

    @Override // com.hihonor.adsdk.base.api.reward.RewardExpressAd
    public void show(Activity activity) {
        if (hnadsc()) {
            ((RewardExpressAd) this.hnadsd).show(activity);
        }
    }

    @Override // com.hihonor.adsdk.base.api.reward.RewardExpressAd
    public void show(Activity activity, RewardExpressAd.RewardAdStatusListener rewardAdStatusListener) {
        if (hnadsc()) {
            ((RewardExpressAd) this.hnadsd).show(activity, rewardAdStatusListener);
        }
    }
}
