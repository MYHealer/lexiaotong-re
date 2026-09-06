package com.meishu.sdk.platform.custom.fullscreen;

import android.text.TextUtils;
import com.meishu.sdk.core.ad.fullscreenvideo.FullScreenVideoAdLoader;
import com.meishu.sdk.core.ad.fullscreenvideo.c;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.AdPlatformError;
import com.meishu.sdk.core.loader.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class MsCustomFullScreenAdapter extends BasePlatformLoader<FullScreenVideoAdLoader, c> {
    private static final String TAG = "MsCustomFullScreenAdapt";

    public MsCustomFullScreenAdapter(FullScreenVideoAdLoader fullScreenVideoAdLoader, SdkAdInfo sdkAdInfo) {
        super(fullScreenVideoAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        z.a(((FullScreenVideoAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
        loadCustomAd(getSdkAdInfo().getApp_id(), getSdkAdInfo().getApp_key(), getSdkAdInfo().getPid(), getSdkAdInfo().getCustom_ext());
    }

    public abstract void loadCustomAd(String str, String str2, String str3, String str4);

    public void onAdClick(MsCustomFullScreenAd msCustomFullScreenAd) {
        if (!TextUtils.isEmpty(getSdkAdInfo().getClk())) {
            LogUtil.d(TAG, "send onAdClicked");
            a.a(getContext(), f.a(getSdkAdInfo().getClk(), msCustomFullScreenAd));
        }
        if (msCustomFullScreenAd.getInteractionListener() != null) {
            msCustomFullScreenAd.getInteractionListener().onAdClicked();
        }
    }

    public void onAdClosed(MsCustomFullScreenAd msCustomFullScreenAd) {
        if (getLoaderListener() != null) {
            getLoaderListener().onAdClosed();
        }
        if (msCustomFullScreenAd.getInteractionListener() != null) {
            msCustomFullScreenAd.getInteractionListener().onAdClosed();
        }
    }

    public void onAdExposure(MsCustomFullScreenAd msCustomFullScreenAd) {
        h0.a(getSdkAdInfo(), msCustomFullScreenAd.getAdView());
        if (getLoaderListener() != null) {
            getLoaderListener().onAdExposure();
        }
        if (msCustomFullScreenAd.getInteractionListener() != null) {
            msCustomFullScreenAd.getInteractionListener().onAdExposure();
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

    public void onRenderSuccess(MsCustomFullScreenAd msCustomFullScreenAd) {
        if (getLoaderListener() != null) {
            getLoaderListener().onAdLoaded(msCustomFullScreenAd);
            getLoaderListener().onAdReady(msCustomFullScreenAd);
        }
    }

    public void onSkippedVideo(MsCustomFullScreenAd msCustomFullScreenAd) {
        if (msCustomFullScreenAd.getMediaListener() != null) {
            msCustomFullScreenAd.getMediaListener().onSkippedVideo();
        }
    }

    public void onVideoCompleted(MsCustomFullScreenAd msCustomFullScreenAd) {
        if (msCustomFullScreenAd == null || msCustomFullScreenAd.getMediaListener() == null) {
            return;
        }
        msCustomFullScreenAd.getMediaListener().onVideoCompleted();
    }

    public void setEcpm(int i) {
        if (getSdkAdInfo() == null || !"bidding".equals(getSdkAdInfo().getOtype())) {
            return;
        }
        getSdkAdInfo().setEcpm(String.valueOf(i));
    }
}
