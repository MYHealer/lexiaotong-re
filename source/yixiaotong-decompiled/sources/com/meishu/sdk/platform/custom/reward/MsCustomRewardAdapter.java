package com.meishu.sdk.platform.custom.reward;

import android.text.TextUtils;
import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.ad.reward.a;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.AdPlatformError;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class MsCustomRewardAdapter extends BasePlatformLoader<RewardVideoLoader, a> {
    private static final String TAG = "MsCustomRewardAdapter";

    public MsCustomRewardAdapter(RewardVideoLoader rewardVideoLoader, SdkAdInfo sdkAdInfo) {
        super(rewardVideoLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        z.a(((RewardVideoLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
        loadCustomAd(getSdkAdInfo().getApp_id(), getSdkAdInfo().getApp_key(), getSdkAdInfo().getPid(), getSdkAdInfo().getCustom_ext());
    }

    public abstract void loadCustomAd(String str, String str2, String str3, String str4);

    public void onAdClick(MsCustomRewardAd msCustomRewardAd) {
        if (!TextUtils.isEmpty(getSdkAdInfo().getClk())) {
            LogUtil.d(TAG, "send onAdClicked");
            com.meishu.sdk.core.loader.a.a(getContext(), f.a(getSdkAdInfo().getClk(), msCustomRewardAd));
        }
        if (msCustomRewardAd.getInteractionListener() != null) {
            msCustomRewardAd.getInteractionListener().onAdClicked();
        }
    }

    public void onAdClosed(MsCustomRewardAd msCustomRewardAd) {
        if (getLoaderListener() != null) {
            getLoaderListener().onAdClosed();
        }
        if (msCustomRewardAd.getInteractionListener() != null) {
            msCustomRewardAd.getInteractionListener().onAdClosed();
        }
    }

    public void onAdExposure(MsCustomRewardAd msCustomRewardAd) {
        h0.a(getSdkAdInfo(), msCustomRewardAd.getAdView());
        if (getLoaderListener() != null) {
            getLoaderListener().onAdExposure();
        }
        if (msCustomRewardAd.getInteractionListener() != null) {
            msCustomRewardAd.getInteractionListener().onAdExposure();
        }
    }

    public void onError(int i, String str) {
        getLoaderListener().onAdPlatformError(new AdPlatformError(str, Integer.valueOf(i)));
    }

    public void onRenderFail(int i, String str) {
        if (getLoaderListener() != null) {
            getLoaderListener().onAdError();
            getLoaderListener().onAdRenderFail(str, i);
        }
    }

    public void onRenderSuccess(MsCustomRewardAd msCustomRewardAd) {
        if (getLoaderListener() != null) {
            getLoaderListener().onAdLoaded(msCustomRewardAd);
            getLoaderListener().onAdReady(msCustomRewardAd);
        }
    }

    public void onReward(MsCustomRewardAd msCustomRewardAd, Map<String, Object> map) {
        if (getLoaderListener() != null) {
            getLoaderListener().onReward(map);
        }
    }

    public void onSkippedVideo(MsCustomRewardAd msCustomRewardAd) {
        if (msCustomRewardAd == null || msCustomRewardAd.getRewardAdMediaListener() == null) {
            return;
        }
        msCustomRewardAd.getRewardAdMediaListener().onSkippedVideo();
    }

    public void onVideoCached(MsCustomRewardAd msCustomRewardAd) {
        if (getLoaderListener() != null) {
            getLoaderListener().onVideoCached(msCustomRewardAd);
        }
    }

    public void onVideoCompleted(MsCustomRewardAd msCustomRewardAd) {
        if (msCustomRewardAd == null || msCustomRewardAd.getRewardAdMediaListener() == null) {
            return;
        }
        msCustomRewardAd.getRewardAdMediaListener().onVideoCompleted();
    }

    public void onVideoError(MsCustomRewardAd msCustomRewardAd) {
        if (msCustomRewardAd == null || msCustomRewardAd.getRewardAdMediaListener() == null) {
            return;
        }
        msCustomRewardAd.getRewardAdMediaListener().onVideoError();
    }

    public void onVideoPause(MsCustomRewardAd msCustomRewardAd) {
        if (msCustomRewardAd == null || msCustomRewardAd.getRewardAdMediaListener() == null) {
            return;
        }
        msCustomRewardAd.getRewardAdMediaListener().onVideoPause();
    }

    public void onVideoResume(MsCustomRewardAd msCustomRewardAd) {
        if (msCustomRewardAd == null || msCustomRewardAd.getRewardAdMediaListener() == null) {
            return;
        }
        msCustomRewardAd.getRewardAdMediaListener().onVideoResume();
    }

    public void onVideoStart(MsCustomRewardAd msCustomRewardAd) {
        if (msCustomRewardAd == null || msCustomRewardAd.getRewardAdMediaListener() == null) {
            return;
        }
        msCustomRewardAd.getRewardAdMediaListener().onVideoStart();
    }

    public void setEcpm(int i) {
        if (getSdkAdInfo() == null || !"bidding".equals(getSdkAdInfo().getOtype())) {
            return;
        }
        getSdkAdInfo().setEcpm(String.valueOf(i));
    }
}
