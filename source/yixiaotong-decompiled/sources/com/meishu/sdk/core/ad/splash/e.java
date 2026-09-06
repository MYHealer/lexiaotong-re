package com.meishu.sdk.core.ad.splash;

import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.loader.AdPlatformError;
import com.meishu.sdk.core.utils.AdErrorInfo;

/* JADX INFO: compiled from: SplashAdListenerAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SplashAdEventListener f4766a;
    public volatile boolean b;
    public volatile boolean c;

    public e(SplashAdLoader splashAdLoader, SplashAdEventListener splashAdEventListener) {
        this.f4766a = splashAdEventListener;
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdClosed() {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdExposure() {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public /* bridge */ /* synthetic */ void onAdLoaded(ISplashAd iSplashAd) {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdPlatformError(AdPlatformError adPlatformError) {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdReady(ISplashAd iSplashAd) {
        ISplashAd iSplashAd2 = iSplashAd;
        SplashAdEventListener splashAdEventListener = this.f4766a;
        if (splashAdEventListener != null) {
            splashAdEventListener.onAdReady(iSplashAd2);
        }
    }

    @Override // com.meishu.sdk.core.ad.splash.d
    public void onAdSkip(ISplashAd iSplashAd) {
        SplashAdEventListener splashAdEventListener = this.f4766a;
        if (splashAdEventListener != null) {
            splashAdEventListener.onAdSkip(iSplashAd);
        }
    }

    @Override // com.meishu.sdk.core.ad.splash.d
    public void onAdTick(long j) {
        SplashAdEventListener splashAdEventListener = this.f4766a;
        if (splashAdEventListener != null) {
            splashAdEventListener.onAdTick(j);
        }
    }

    @Override // com.meishu.sdk.core.ad.splash.d
    public void onAdTimeOver(ISplashAd iSplashAd) {
        SplashAdEventListener splashAdEventListener = this.f4766a;
        if (splashAdEventListener != null) {
            splashAdEventListener.onAdTimeOver(iSplashAd);
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdError() {
        if (this.f4766a == null || this.c || this.b) {
            return;
        }
        this.b = true;
        if (AdSdk.adConfig() == null) {
            this.f4766a.onAdError(new AdErrorInfo(AdErrorInfo.LOAD_ERROR, ErrorCodeUtil.AD_LOAD_ERROR.intValue(), "SDK IS NOT INITED ！"));
        } else {
            this.f4766a.onAdError(new AdErrorInfo(AdErrorInfo.LOAD_ERROR, ErrorCodeUtil.AD_LOAD_ERROR.intValue(), ErrorCodeUtil.AD_LOAD_ERROR_MSG));
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdRenderFail(String str, int i) {
        if (this.f4766a == null || this.b || this.c) {
            return;
        }
        this.c = true;
        this.f4766a.onAdError(new AdErrorInfo(AdErrorInfo.RENDER_ERROR, i, str));
    }
}
