package com.meishu.sdk.platform.ks.reward;

import android.text.TextUtils;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.meishu.sdk.core.ad.reward.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KSInteractionListener implements KsRewardVideoAd.RewardAdInteractionListener {
    private static final String TAG = "KSInteractionListener";
    private KSRewardAd ad;

    public KSInteractionListener(KSRewardAd kSRewardAd) {
        this.ad = kSRewardAd;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onAdClicked() {
        try {
            if (this.ad.getAdWrapper() != null && this.ad.getAdWrapper().getSdkAdInfo() != null && !TextUtils.isEmpty(this.ad.getAdWrapper().getSdkAdInfo().getClk())) {
                LogUtil.d(TAG, "send onAdClicked");
                z.a(this.ad.getAdWrapper().getContext(), f.a(this.ad.getAdWrapper().getSdkAdInfo().getClk(), this.ad), new i());
            }
            if (this.ad.getInteractionListener() != null) {
                this.ad.getInteractionListener().onAdClicked();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onExtraRewardVerify(int i) {
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onPageDismiss() {
        try {
            if (this.ad.getAdWrapper().getAdLoader().getLoaderListener() != 0) {
                ((a) this.ad.getAdWrapper().getAdLoader().getLoaderListener()).onAdClosed();
            }
            if (this.ad.getInteractionListener() != null) {
                this.ad.getInteractionListener().onAdClosed();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardStepVerify(int i, int i2) {
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify() {
        try {
            if (this.ad.getAdWrapper().getAdLoader().getLoaderListener() != 0) {
                ((a) this.ad.getAdWrapper().getAdLoader().getLoaderListener()).onReward(null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify(Map<String, Object> map) {
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayEnd() {
        try {
            if (this.ad.getAdWrapper().getApiRewardAdMediaListener() != null) {
                this.ad.getAdWrapper().getApiRewardAdMediaListener().onVideoCompleted();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayError(int i, int i2) {
        try {
            LogUtil.d(TAG, "onVideoError: " + i);
            if (this.ad.getAdWrapper().getApiRewardAdMediaListener() != null) {
                this.ad.getAdWrapper().getApiRewardAdMediaListener().onVideoError();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayStart() {
        try {
            if (this.ad.getAdWrapper().getLoaderListener() != null) {
                this.ad.getAdWrapper().getLoaderListener().onAdExposure();
            }
            if (this.ad.getInteractionListener() != null) {
                this.ad.getInteractionListener().onAdExposure();
            }
            if (this.ad.getAdWrapper().getApiRewardAdMediaListener() != null) {
                this.ad.getAdWrapper().getApiRewardAdMediaListener().onVideoStart();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoSkipToEnd(long j) {
        try {
            if (this.ad.getAdWrapper().getApiRewardAdMediaListener() != null) {
                this.ad.getAdWrapper().getApiRewardAdMediaListener().onSkippedVideo();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
