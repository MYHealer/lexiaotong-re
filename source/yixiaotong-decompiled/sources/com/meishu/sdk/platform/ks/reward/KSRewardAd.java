package com.meishu.sdk.platform.ks.reward;

import android.app.Activity;
import android.os.SystemClock;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.meishu.sdk.core.ad.a;
import com.meishu.sdk.core.ad.reward.RewardAdMediaListener;
import com.meishu.sdk.core.ad.reward.RewardVideoAd;
import com.meishu.sdk.core.utils.o1;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KSRewardAd extends a implements RewardVideoAd {
    public KSRewardVideoAdWrapper adWrapper;
    public KsRewardVideoAd ksRewardVideoAd;

    public KSRewardAd(KsRewardVideoAd ksRewardVideoAd, KSRewardVideoAdWrapper kSRewardVideoAdWrapper) {
        super(kSRewardVideoAdWrapper, "KS");
        this.ksRewardVideoAd = ksRewardVideoAd;
        this.adWrapper = kSRewardVideoAdWrapper;
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void destroy() {
    }

    public KSRewardVideoAdWrapper getAdWrapper() {
        return this.adWrapper;
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public boolean isAdValid() {
        try {
            if (SystemClock.uptimeMillis() - this.adWrapper.getSdkAdInfo().getLoadedTime() >= 3540000) {
                return false;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.isAdValid();
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void showAd() {
        try {
            if (this.adWrapper.getContext() instanceof Activity) {
                this.ksRewardVideoAd.showRewardVideoAd((Activity) this.adWrapper.getContext(), new KsVideoPlayConfig.Builder().videoSoundEnable(!this.adWrapper.getAdLoader().getVideoIsMute()).build());
                KSRewardVideoAdWrapper kSRewardVideoAdWrapper = this.adWrapper;
                if (kSRewardVideoAdWrapper == null || kSRewardVideoAdWrapper.getSdkAdInfo() == null) {
                    return;
                }
                o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void setMediaListener(RewardAdMediaListener rewardAdMediaListener) {
        KSRewardVideoAdWrapper kSRewardVideoAdWrapper = this.adWrapper;
        if (kSRewardVideoAdWrapper != null) {
            kSRewardVideoAdWrapper.setApiRewardAdMediaListener(rewardAdMediaListener);
        }
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void showAd(Activity activity) {
        try {
            this.ksRewardVideoAd.showRewardVideoAd(activity, new KsVideoPlayConfig.Builder().videoSoundEnable(!this.adWrapper.getAdLoader().getVideoIsMute()).build());
            KSRewardVideoAdWrapper kSRewardVideoAdWrapper = this.adWrapper;
            if (kSRewardVideoAdWrapper == null || kSRewardVideoAdWrapper.getSdkAdInfo() == null) {
                return;
            }
            o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
