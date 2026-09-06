package com.meishu.sdk.platform.pangle.reward;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.meishu.sdk.platform.custom.reward.MsCustomRewardAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class PangleRewardAd extends MsCustomRewardAd {
    private PAGRewardedAd rewardedAd;

    public PangleRewardAd(PangleRewardAdapter pangleRewardAdapter, PAGRewardedAd pAGRewardedAd) {
        super(pangleRewardAdapter);
        this.rewardedAd = pAGRewardedAd;
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void destroy() {
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void showAd(Activity activity) {
        PAGRewardedAd pAGRewardedAd = this.rewardedAd;
        if (pAGRewardedAd != null) {
            pAGRewardedAd.show(activity);
        }
    }
}
