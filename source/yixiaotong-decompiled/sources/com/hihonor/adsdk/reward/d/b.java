package com.hihonor.adsdk.reward.d;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.api.IAdLoad;
import com.hihonor.adsdk.base.api.reward.RewardAdLoadListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b implements IAdLoad<RewardAdLoadListener> {
    private static final String c = "RewardMediationLoader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected AdSlot f3561a;
    protected RewardAdLoadListener b;

    @Override // com.hihonor.adsdk.base.api.IAdLoad
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdLoadListener(RewardAdLoadListener rewardAdLoadListener) {
        this.b = rewardAdLoadListener;
    }

    @Override // com.hihonor.adsdk.base.api.IAdLoad
    public void loadAd() {
        com.hihonor.adsdk.base.mediation.core.imp.f.a.hnadsa().hnadsa(this.f3561a, this.b);
    }

    @Override // com.hihonor.adsdk.base.api.IAdLoad
    public void setAdSlot(AdSlot adSlot) {
        this.f3561a = adSlot;
    }
}
