package com.meishu.sdk.core.ad.reward;

import com.meishu.sdk.core.loader.IAdLoadListener;
import java.util.Map;

/* JADX INFO: compiled from: RewardVideoAdListener.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface a extends IAdLoadListener<RewardVideoAd> {
    void onReward(Map<String, Object> map);

    void onVideoCached(RewardVideoAd rewardVideoAd);
}
