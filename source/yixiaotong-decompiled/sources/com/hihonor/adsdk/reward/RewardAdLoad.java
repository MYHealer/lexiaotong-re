package com.hihonor.adsdk.reward;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.api.IAdLoad;
import com.hihonor.adsdk.base.api.reward.RewardAdLoadListener;
import com.hihonor.adsdk.base.mediation.core.imp.AdManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class RewardAdLoad {
    private final IAdLoad<RewardAdLoadListener> adLoad;

    public static class Builder {
        private final IAdLoad<RewardAdLoadListener> adLoad = new AdManager(new com.hihonor.adsdk.reward.d.a(), new com.hihonor.adsdk.reward.d.b());

        public RewardAdLoad build() {
            return new RewardAdLoad(this, null);
        }

        public Builder setAdSlot(AdSlot adSlot) {
            this.adLoad.setAdSlot(adSlot);
            return this;
        }

        public Builder setRewardAdLoadListener(RewardAdLoadListener rewardAdLoadListener) {
            this.adLoad.setAdLoadListener(rewardAdLoadListener);
            return this;
        }
    }

    static /* synthetic */ class a {
    }

    /* synthetic */ RewardAdLoad(Builder builder, a aVar) {
        this(builder);
    }

    public void loadAd() {
        this.adLoad.loadAd();
    }

    private RewardAdLoad(Builder builder) {
        this.adLoad = builder.adLoad;
    }
}
