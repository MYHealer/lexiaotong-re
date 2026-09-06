package com.hihonor.adsdk.base.mediation.core.imp.f;

import com.hihonor.adsdk.base.api.reward.RewardExpressAd;
import com.hihonor.adsdk.base.mediation.adn.AdnAdapter;
import com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends com.hihonor.adsdk.base.mediation.core.imp.b<RewardExpressAd> {
    public b(com.hihonor.adsdk.base.mediation.core.imp.a aVar) {
        super(aVar);
    }

    @Override // com.hihonor.adsdk.base.mediation.core.imp.b
    protected BaseAdapter<RewardExpressAd> hnadsa() {
        BaseAdapter<RewardExpressAd> rewardAd = AdnAdapter.getRewardAd(hnadsn(), this.hnadsf);
        if (rewardAd != null) {
            rewardAd.setAdEventListener(this);
        }
        return rewardAd;
    }
}
