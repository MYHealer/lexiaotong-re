package com.meishu.sdk.platform.custom.splash;

import android.text.TextUtils;
import android.view.View;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.ad.splash.d;
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
public abstract class MsCustomSplashAdapter extends BasePlatformLoader<SplashAdLoader, d> {
    private static final String TAG = "MsCustomSplashAdapter";

    public MsCustomSplashAdapter(SplashAdLoader splashAdLoader, SdkAdInfo sdkAdInfo) {
        super(splashAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        z.a(((SplashAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
        loadCustomAd(getSdkAdInfo().getApp_id(), getSdkAdInfo().getApp_key(), getSdkAdInfo().getPid(), getSdkAdInfo().getCustom_ext());
    }

    public abstract void loadCustomAd(String str, String str2, String str3, String str4);

    public void onAdClick(MsCustomSplashAd msCustomSplashAd) {
        if (!TextUtils.isEmpty(getSdkAdInfo().getClk())) {
            LogUtil.d(TAG, "send onAdClicked");
            a.a(getContext(), f.a(getSdkAdInfo().getClk(), msCustomSplashAd));
        }
        if (msCustomSplashAd.getInteractionListener() != null) {
            msCustomSplashAd.getInteractionListener().onAdClicked();
        }
    }

    public void onAdExposure(MsCustomSplashAd msCustomSplashAd) {
        h0.a(getSdkAdInfo(), msCustomSplashAd.getAdView());
        if (getLoaderListener() != null) {
            getLoaderListener().onAdExposure();
        }
        if (msCustomSplashAd.getInteractionListener() != null) {
            msCustomSplashAd.getInteractionListener().onAdExposure();
        }
    }

    public void onAdSkip(MsCustomSplashAd msCustomSplashAd) {
        if (getLoaderListener() != null) {
            getLoaderListener().onAdSkip(msCustomSplashAd);
            getLoaderListener().onAdClosed();
        }
        if (msCustomSplashAd.getInteractionListener() != null) {
            msCustomSplashAd.getInteractionListener().onAdClosed();
        }
    }

    public void onAdTimeOver(MsCustomSplashAd msCustomSplashAd) {
        if (getLoaderListener() != null) {
            getLoaderListener().onAdTimeOver(msCustomSplashAd);
            getLoaderListener().onAdClosed();
        }
        if (msCustomSplashAd.getInteractionListener() != null) {
            msCustomSplashAd.getInteractionListener().onAdClosed();
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

    public void onRenderSuccess(View view, MsCustomSplashAd msCustomSplashAd) {
        msCustomSplashAd.setAdView(view);
        msCustomSplashAd.setAdContainer(getAdLoader().getAdContainer());
        msCustomSplashAd.setAdView(view);
        if (getLoaderListener() != null) {
            getLoaderListener().onAdLoaded(msCustomSplashAd);
            getLoaderListener().onAdReady(msCustomSplashAd);
        }
    }

    public void setEcpm(int i) {
        if (getSdkAdInfo() != null) {
            getSdkAdInfo().setEcpm(String.valueOf(i));
        }
    }
}
