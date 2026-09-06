package com.meishu.sdk.platform.csj.draw;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJDrawDisLikeCallback implements TTAdDislike.DislikeInteractionCallback {
    private TTNativeExpressAd ad;
    private CSJDrawAdWrapper adNativeWrapper;
    private CSJDrawAd csjDrawAd;

    public CSJDrawDisLikeCallback(CSJDrawAdWrapper cSJDrawAdWrapper, TTNativeExpressAd tTNativeExpressAd, CSJDrawAd cSJDrawAd) {
        this.adNativeWrapper = cSJDrawAdWrapper;
        this.ad = tTNativeExpressAd;
        this.csjDrawAd = cSJDrawAd;
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
            CSJDrawAd cSJDrawAd = this.csjDrawAd;
            if (cSJDrawAd != null && cSJDrawAd.getInteractionListener() != null) {
                this.csjDrawAd.getInteractionListener().onAdClosed();
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
