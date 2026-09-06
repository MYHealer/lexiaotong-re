package com.meishu.sdk.core.ad.reward;

import com.meishu.sdk.core.ad.IAdEventListener;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface RewardAdEventListener extends IAdEventListener<RewardVideoAd> {
    void onReward(Map<String, Object> map);

    void onVideoCached(RewardVideoAd rewardVideoAd);
}
