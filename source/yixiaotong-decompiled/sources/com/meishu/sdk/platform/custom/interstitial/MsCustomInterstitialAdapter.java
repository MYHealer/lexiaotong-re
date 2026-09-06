package com.meishu.sdk.platform.custom.interstitial;

import android.text.TextUtils;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.ad.interstitial.b;
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
public abstract class MsCustomInterstitialAdapter extends BasePlatformLoader<InterstitialAdLoader, b> {
    private static final String TAG = "MsCustomInterstitialAda";

    public MsCustomInterstitialAdapter(InterstitialAdLoader interstitialAdLoader, SdkAdInfo sdkAdInfo) {
        super(interstitialAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        z.a(((InterstitialAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
        loadCustomAd(getSdkAdInfo().getApp_id(), getSdkAdInfo().getApp_key(), getSdkAdInfo().getPid(), getSdkAdInfo().getCustom_ext());
    }

    public abstract void loadCustomAd(String str, String str2, String str3, String str4);

    public void onAdClick(MsCustomInterstitialAd msCustomInterstitialAd) {
        if (!TextUtils.isEmpty(getSdkAdInfo().getClk())) {
            LogUtil.d(TAG, "send onAdClicked");
            a.a(getContext(), f.a(getSdkAdInfo().getClk(), msCustomInterstitialAd));
        }
        if (msCustomInterstitialAd.getInteractionListener() != null) {
            msCustomInterstitialAd.getInteractionListener().onAdClicked();
        }
    }

    public void onAdClosed(MsCustomInterstitialAd msCustomInterstitialAd) {
        if (getLoaderListener() != null) {
            getLoaderListener().onAdClosed();
        }
        if (msCustomInterstitialAd.getInteractionListener() != null) {
            msCustomInterstitialAd.getInteractionListener().onAdClosed();
        }
    }

    public void onAdExposure(MsCustomInterstitialAd msCustomInterstitialAd) {
        if (getLoaderListener() != null) {
            getLoaderListener().onAdExposure();
        }
        if (msCustomInterstitialAd.getInteractionListener() != null) {
            msCustomInterstitialAd.getInteractionListener().onAdExposure();
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

    public void onRenderSuccess(MsCustomInterstitialAd msCustomInterstitialAd) {
        if (getLoaderListener() != null) {
            getLoaderListener().onAdLoaded(msCustomInterstitialAd);
            getLoaderListener().onAdReady(msCustomInterstitialAd);
        }
    }

    public void setEcpm(int i) {
        if (getSdkAdInfo() == null || !"bidding".equals(getSdkAdInfo().getOtype())) {
            return;
        }
        getSdkAdInfo().setEcpm(String.valueOf(i));
    }
}
