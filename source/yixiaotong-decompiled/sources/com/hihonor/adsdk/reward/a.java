package com.hihonor.adsdk.reward;

import com.hihonor.adsdk.base.api.reward.RewardExpressAd;
import com.hihonor.adsdk.base.api.reward.RewardItem;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a implements com.hihonor.adsdk.base.api.reward.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3555a = "RewardVideoPlayerManager";
    private final Map<String, RewardExpressAd.RewardAdStatusListener> b = new com.hihonor.adsdk.common.safe.a();

    /* JADX INFO: renamed from: com.hihonor.adsdk.reward.a$a, reason: collision with other inner class name */
    private static class C0469a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f3556a = new a();

        private C0469a() {
        }
    }

    public static a a() {
        return C0469a.f3556a;
    }

    @Override // com.hihonor.adsdk.base.api.reward.a
    public void hnadsa(String str, int i) {
        RewardExpressAd.RewardAdStatusListener rewardAdStatusListener = this.b.get(str);
        if (rewardAdStatusListener != null) {
            rewardAdStatusListener.onVideoError(i);
        }
    }

    @Override // com.hihonor.adsdk.base.api.reward.a
    public void hnadsb(String str) {
        RewardExpressAd.RewardAdStatusListener rewardAdStatusListener = this.b.get(str);
        if (rewardAdStatusListener != null) {
            rewardAdStatusListener.onRewardAdClosed();
            a(str);
        }
    }

    public void a(String str, RewardExpressAd.RewardAdStatusListener rewardAdStatusListener) {
        boolean zContainsKey = this.b.containsKey(str);
        com.hihonor.adsdk.common.b.b.hnadsc("RewardVideoPlayerManager", "addRewardListener isLisExist: " + zContainsKey, new Object[0]);
        if (zContainsKey) {
            return;
        }
        this.b.put(str, rewardAdStatusListener);
    }

    @Override // com.hihonor.adsdk.base.api.reward.a
    public void hnadsa(String str) {
        RewardExpressAd.RewardAdStatusListener rewardAdStatusListener = this.b.get(str);
        if (rewardAdStatusListener != null) {
            rewardAdStatusListener.onRewardAdOpened();
        }
    }

    public void a(String str) {
        this.b.remove(str);
    }

    @Override // com.hihonor.adsdk.base.api.reward.a
    public void hnadsa(String str, RewardItem rewardItem) {
        RewardExpressAd.RewardAdStatusListener rewardAdStatusListener = this.b.get(str);
        if (rewardAdStatusListener != null) {
            rewardAdStatusListener.onRewarded(rewardItem);
        }
    }
}
