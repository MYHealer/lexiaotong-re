package com.meishu.sdk.platform.oppo.reward;

import android.app.Activity;
import com.byazt.bv.BaseConstants;
import com.meishu.sdk.core.ad.a;
import com.meishu.sdk.core.ad.reward.RewardAdMediaListener;
import com.meishu.sdk.core.ad.reward.RewardVideoAd;
import com.meishu.sdk.core.loader.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
class OPPORewardAd extends a implements RewardVideoAd {
    private RewardAdMediaListener rewardAdMediaListener;
    private com.heytap.msp.mobad.api.ad.RewardVideoAd rewardVideoAd;
    private boolean showed;

    public OPPORewardAd(d dVar) {
        super(dVar, BaseConstants.ROM_OPPO_UPPER_CONSTANT);
        this.showed = false;
    }

    public RewardAdMediaListener getRewardAdMediaListener() {
        return this.rewardAdMediaListener;
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void setMediaListener(RewardAdMediaListener rewardAdMediaListener) {
        this.rewardAdMediaListener = rewardAdMediaListener;
    }

    public void setRewardAd(com.heytap.msp.mobad.api.ad.RewardVideoAd rewardVideoAd) {
        this.rewardVideoAd = rewardVideoAd;
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void showAd(Activity activity) {
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void destroy() {
        com.heytap.msp.mobad.api.ad.RewardVideoAd rewardVideoAd = this.rewardVideoAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.destroyAd();
        }
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void showAd() {
        if (this.showed) {
            return;
        }
        this.showed = true;
        com.heytap.msp.mobad.api.ad.RewardVideoAd rewardVideoAd = this.rewardVideoAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.showAd();
        }
    }
}
