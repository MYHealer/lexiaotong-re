package com.meishu.sdk.platform.bd.reward;

import android.app.Activity;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.a;
import com.meishu.sdk.core.ad.reward.RewardAdMediaListener;
import com.meishu.sdk.core.ad.reward.RewardVideoAd;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.o1;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BDRewardAd extends a implements RewardVideoAd {
    private static final String TAG = "BDRewardAd";
    private BDRewardVideoLoader bdRewardVideoLoader;
    public com.baidu.mobads.sdk.api.RewardVideoAd mRewardVideoAd;
    public RewardAdMediaListener rewardAdMediaListener;
    private SdkAdInfo sdkAdInfo;

    public BDRewardAd(com.baidu.mobads.sdk.api.RewardVideoAd rewardVideoAd, BDRewardVideoLoader bDRewardVideoLoader) {
        super(bDRewardVideoLoader, MSAdConfig.PLATFORM_BD);
        this.mRewardVideoAd = rewardVideoAd;
        this.bdRewardVideoLoader = bDRewardVideoLoader;
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void destroy() {
    }

    public RewardAdMediaListener getMediaListener() {
        return this.rewardAdMediaListener;
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void setMediaListener(RewardAdMediaListener rewardAdMediaListener) {
        this.rewardAdMediaListener = rewardAdMediaListener;
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void showAd() {
        try {
            if (this.mRewardVideoAd.isReady()) {
                this.mRewardVideoAd.show();
                BDRewardVideoLoader bDRewardVideoLoader = this.bdRewardVideoLoader;
                if (bDRewardVideoLoader == null || bDRewardVideoLoader.getSdkAdInfo() == null) {
                    return;
                }
                o1.b(this.bdRewardVideoLoader.getSdkAdInfo().getEventUrl());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void showAd(Activity activity) {
        try {
            LogUtil.e(TAG, "" + this.mRewardVideoAd.isReady());
            if (this.mRewardVideoAd.isReady()) {
                this.mRewardVideoAd.show();
                BDRewardVideoLoader bDRewardVideoLoader = this.bdRewardVideoLoader;
                if (bDRewardVideoLoader == null || bDRewardVideoLoader.getSdkAdInfo() == null) {
                    return;
                }
                o1.b(this.bdRewardVideoLoader.getSdkAdInfo().getEventUrl());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
