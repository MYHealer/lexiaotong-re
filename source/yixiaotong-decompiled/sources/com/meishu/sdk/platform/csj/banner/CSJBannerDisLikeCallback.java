package com.meishu.sdk.platform.csj.banner;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJBannerDisLikeCallback implements TTAdDislike.DislikeInteractionCallback {
    private TTNativeExpressAd ad;
    private CSJBannerAdWrapper adNativeWrapper;
    private CSJBannerAd csjBannerAd;

    public CSJBannerDisLikeCallback(CSJBannerAdWrapper cSJBannerAdWrapper, TTNativeExpressAd tTNativeExpressAd, CSJBannerAd cSJBannerAd) {
        this.adNativeWrapper = cSJBannerAdWrapper;
        this.ad = tTNativeExpressAd;
        this.csjBannerAd = cSJBannerAd;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onCancel() {
    }

    public void onRefuse() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onSelected(int i, String str, boolean z) {
        try {
            if (this.adNativeWrapper.getLoaderListener() != null) {
                this.adNativeWrapper.getLoaderListener().onAdClosed();
            }
            CSJBannerAd cSJBannerAd = this.csjBannerAd;
            if (cSJBannerAd != null && cSJBannerAd.getInteractionListener() != null) {
                this.csjBannerAd.getInteractionListener().onAdClosed();
            }
            View expressAdView = this.ad.getExpressAdView();
            if (expressAdView != null && expressAdView.getParent() != null && (expressAdView.getParent() instanceof ViewGroup)) {
                ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
            }
            this.ad.destroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onShow() {
    }

    public void onSelected(int i, String str) {
        try {
            if (this.adNativeWrapper.getLoaderListener() != null) {
                this.adNativeWrapper.getLoaderListener().onAdClosed();
            }
            View expressAdView = this.ad.getExpressAdView();
            if (expressAdView != null && expressAdView.getParent() != null && (expressAdView.getParent() instanceof ViewGroup)) {
                ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
            }
            this.ad.destroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
