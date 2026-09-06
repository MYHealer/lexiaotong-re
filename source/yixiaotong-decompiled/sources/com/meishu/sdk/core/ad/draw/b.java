package com.meishu.sdk.core.ad.draw;

import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.loader.AdPlatformError;
import com.meishu.sdk.core.utils.AdErrorInfo;

/* JADX INFO: compiled from: DrawAdListenerAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DrawAdEventListener f4757a;
    public volatile boolean b;
    public volatile boolean c;

    public b(DrawAdLoader drawAdLoader, DrawAdEventListener drawAdEventListener) {
        this.f4757a = drawAdEventListener;
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdClosed() {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdExposure() {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public /* bridge */ /* synthetic */ void onAdLoaded(IDrawAd iDrawAd) {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdPlatformError(AdPlatformError adPlatformError) {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdReady(IDrawAd iDrawAd) {
        IDrawAd iDrawAd2 = iDrawAd;
        DrawAdEventListener drawAdEventListener = this.f4757a;
        if (drawAdEventListener != null) {
            drawAdEventListener.onAdReady(iDrawAd2);
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdError() {
        if (this.f4757a == null || this.b || this.c) {
            return;
        }
        this.b = true;
        if (AdSdk.adConfig() == null) {
            this.f4757a.onAdError(new AdErrorInfo(AdErrorInfo.LOAD_ERROR, ErrorCodeUtil.AD_LOAD_ERROR.intValue(), "SDK IS NOT INITED ！"));
        } else {
            this.f4757a.onAdError(new AdErrorInfo(AdErrorInfo.LOAD_ERROR, ErrorCodeUtil.AD_LOAD_ERROR.intValue(), ErrorCodeUtil.AD_LOAD_ERROR_MSG));
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdRenderFail(String str, int i) {
        if (this.f4757a == null || this.b || this.c) {
            return;
        }
        this.c = true;
        this.f4757a.onAdError(new AdErrorInfo(AdErrorInfo.RENDER_ERROR, i, str));
    }
}
