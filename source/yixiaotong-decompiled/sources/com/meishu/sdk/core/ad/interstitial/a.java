package com.meishu.sdk.core.ad.interstitial;

import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.loader.AdPlatformError;
import com.meishu.sdk.core.utils.AdErrorInfo;

/* JADX INFO: compiled from: InsterstitialAdListenerAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterstitialAdEventListener f4759a;
    public volatile boolean b;
    public volatile boolean c;

    public a(InterstitialAdLoader interstitialAdLoader, InterstitialAdEventListener interstitialAdEventListener) {
        this.f4759a = interstitialAdEventListener;
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdClosed() {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdExposure() {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public /* bridge */ /* synthetic */ void onAdLoaded(InterstitialAd interstitialAd) {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdPlatformError(AdPlatformError adPlatformError) {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdReady(InterstitialAd interstitialAd) {
        InterstitialAd interstitialAd2 = interstitialAd;
        InterstitialAdEventListener interstitialAdEventListener = this.f4759a;
        if (interstitialAdEventListener != null) {
            interstitialAdEventListener.onAdReady(interstitialAd2);
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdError() {
        if (this.f4759a == null || this.b || this.c) {
            return;
        }
        this.b = true;
        if (AdSdk.adConfig() == null) {
            this.f4759a.onAdError(new AdErrorInfo(AdErrorInfo.LOAD_ERROR, ErrorCodeUtil.AD_LOAD_ERROR.intValue(), "SDK IS NOT INITED ！"));
        } else {
            this.f4759a.onAdError(new AdErrorInfo(AdErrorInfo.LOAD_ERROR, ErrorCodeUtil.AD_LOAD_ERROR.intValue(), ErrorCodeUtil.AD_LOAD_ERROR_MSG));
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdRenderFail(String str, int i) {
        if (this.f4759a == null || this.b || this.c) {
            return;
        }
        this.c = true;
        this.f4759a.onAdError(new AdErrorInfo(AdErrorInfo.RENDER_ERROR, i, str));
    }
}
