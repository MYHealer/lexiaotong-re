package com.meishu.sdk.platform.csj.reward;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.a;
import com.meishu.sdk.core.ad.reward.RewardAdMediaListener;
import com.meishu.sdk.core.ad.reward.RewardVideoAd;
import com.meishu.sdk.core.utils.o1;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RewardVideoAdAdapter extends a implements RewardVideoAd {
    private CSJRewardVideoAdWrapper adWrapper;
    private TTRewardVideoAd ttRewardVideoAd;

    public RewardVideoAdAdapter(CSJRewardVideoAdWrapper cSJRewardVideoAdWrapper, TTRewardVideoAd tTRewardVideoAd) {
        super(cSJRewardVideoAdWrapper, MSAdConfig.PLATFORM_CSJ);
        this.adWrapper = cSJRewardVideoAdWrapper;
        this.ttRewardVideoAd = tTRewardVideoAd;
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void destroy() {
    }

    public CSJRewardVideoAdWrapper getAdWrapper() {
        return this.adWrapper;
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void setMediaListener(RewardAdMediaListener rewardAdMediaListener) {
        try {
            this.adWrapper.setApiRewardAdMediaListener(rewardAdMediaListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void showAd() {
        try {
            if (this.adWrapper.getContext() instanceof Activity) {
                this.ttRewardVideoAd.showRewardVideoAd((Activity) this.adWrapper.getContext());
                CSJRewardVideoAdWrapper cSJRewardVideoAdWrapper = this.adWrapper;
                if (cSJRewardVideoAdWrapper == null || cSJRewardVideoAdWrapper.getSdkAdInfo() == null) {
                    return;
                }
                o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void showAd(Activity activity) {
        try {
            this.ttRewardVideoAd.showRewardVideoAd(activity);
            CSJRewardVideoAdWrapper cSJRewardVideoAdWrapper = this.adWrapper;
            if (cSJRewardVideoAdWrapper == null || cSJRewardVideoAdWrapper.getSdkAdInfo() == null) {
                return;
            }
            o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
