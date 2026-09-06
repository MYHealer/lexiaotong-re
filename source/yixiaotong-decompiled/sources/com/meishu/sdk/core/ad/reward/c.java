package com.meishu.sdk.core.ad.reward;

import com.meishu.sdk.core.loader.d;
import java.util.Map;

/* JADX INFO: compiled from: RewardVideoAdListenerProxy.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c extends com.meishu.sdk.core.loader.b<RewardVideoAd, a> implements a {
    public c(d dVar, a aVar) {
        super(dVar, aVar);
    }

    @Override // com.meishu.sdk.core.ad.reward.a
    public void onReward(Map<String, Object> map) {
        K k = this.b;
        if (k != 0) {
            ((a) k).onReward(map);
        }
    }

    @Override // com.meishu.sdk.core.ad.reward.a
    public void onVideoCached(RewardVideoAd rewardVideoAd) {
        K k = this.b;
        if (k != 0) {
            ((a) k).onVideoCached(rewardVideoAd);
        }
    }
}
