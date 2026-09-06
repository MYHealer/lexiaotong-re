package com.meishu.sdk.core.ad.paster;

import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.loader.AdPlatformError;
import com.meishu.sdk.core.utils.AdErrorInfo;

/* JADX INFO: compiled from: PasterAdListenerAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PasterAdEventListener f4762a;
    public volatile boolean b;
    public volatile boolean c;

    public c(PasterAdLoader pasterAdLoader, PasterAdEventListener pasterAdEventListener) {
        this.f4762a = pasterAdEventListener;
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdClosed() {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdExposure() {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public /* bridge */ /* synthetic */ void onAdLoaded(PasterAd pasterAd) {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdPlatformError(AdPlatformError adPlatformError) {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdReady(PasterAd pasterAd) {
        PasterAd pasterAd2 = pasterAd;
        PasterAdEventListener pasterAdEventListener = this.f4762a;
        if (pasterAdEventListener != null) {
            pasterAdEventListener.onAdReady(pasterAd2);
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.b
    public void onVideoError() {
    }

    @Override // com.meishu.sdk.core.ad.paster.b
    public void onVideoComplete() {
        PasterAdEventListener pasterAdEventListener = this.f4762a;
        if (pasterAdEventListener != null) {
            pasterAdEventListener.onVideoComplete();
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.b
    public void onVideoLoaded() {
        PasterAdEventListener pasterAdEventListener = this.f4762a;
        if (pasterAdEventListener != null) {
            pasterAdEventListener.onVideoLoaded();
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdError() {
        if (this.f4762a == null || this.b || this.c) {
            return;
        }
        this.b = true;
        if (AdSdk.adConfig() == null) {
            this.f4762a.onAdError(new AdErrorInfo(AdErrorInfo.LOAD_ERROR, ErrorCodeUtil.AD_LOAD_ERROR.intValue(), "SDK IS NOT INITED ！"));
        } else {
            this.f4762a.onAdError(new AdErrorInfo(AdErrorInfo.LOAD_ERROR, ErrorCodeUtil.AD_LOAD_ERROR.intValue(), ErrorCodeUtil.AD_LOAD_ERROR_MSG));
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdRenderFail(String str, int i) {
        if (this.f4762a == null || this.b || this.c) {
            return;
        }
        this.c = true;
        this.f4762a.onAdError(new AdErrorInfo(AdErrorInfo.RENDER_ERROR, i, str));
    }
}
