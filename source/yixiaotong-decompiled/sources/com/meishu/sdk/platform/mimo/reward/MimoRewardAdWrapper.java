package com.meishu.sdk.platform.mimo.reward;

import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.ad.reward.a;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.mimo.MimoPlatformError;
import com.miui.zeus.mimo.sdk.RewardVideoAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoRewardAdWrapper extends BasePlatformLoader<RewardVideoLoader, a> {
    private static final String TAG = "MimoRewardAdWrapper";

    public MimoRewardAdWrapper(RewardVideoLoader rewardVideoLoader, SdkAdInfo sdkAdInfo) {
        super(rewardVideoLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        z.a(((RewardVideoLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
        final RewardVideoAd rewardVideoAd = new RewardVideoAd();
        rewardVideoAd.loadAd(this.sdkAdInfo.getPid(), new RewardVideoAd.RewardVideoLoadListener() { // from class: com.meishu.sdk.platform.mimo.reward.MimoRewardAdWrapper.1
            @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoLoadListener
            public void onAdLoadFailed(int i, String str) {
                LogUtil.e(MimoRewardAdWrapper.TAG, "onAdLoadFailed, code: " + i + ", msg: " + str);
                new MimoPlatformError(str, Integer.valueOf(i), MimoRewardAdWrapper.this.getSdkAdInfo()).post(MimoRewardAdWrapper.this.loadListener);
            }

            @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoLoadListener
            public void onAdLoadSuccess() {
                LogUtil.d(MimoRewardAdWrapper.TAG, "send onBannerAdLoadSuccess");
                if (MimoRewardAdWrapper.this.loadListener != null) {
                    MimoRewardAd mimoRewardAd = new MimoRewardAd(rewardVideoAd, MimoRewardAdWrapper.this);
                    ((a) MimoRewardAdWrapper.this.loadListener).onAdLoaded(mimoRewardAd);
                    ((a) MimoRewardAdWrapper.this.loadListener).onAdReady(mimoRewardAd);
                }
            }

            @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoLoadListener
            public void onAdRequestSuccess() {
            }
        });
    }
}
