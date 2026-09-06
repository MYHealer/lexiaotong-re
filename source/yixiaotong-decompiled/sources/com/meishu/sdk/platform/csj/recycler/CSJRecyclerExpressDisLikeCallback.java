package com.meishu.sdk.platform.csj.recycler;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJRecyclerExpressDisLikeCallback implements TTAdDislike.DislikeInteractionCallback {
    private TTNativeExpressAd ad;
    private CSJTTAdNativeWrapper adNativeWrapper;
    private RecylcerAdInteractionListener recylcerAdInteractionListener;

    public CSJRecyclerExpressDisLikeCallback(CSJTTAdNativeWrapper cSJTTAdNativeWrapper, TTNativeExpressAd tTNativeExpressAd, RecylcerAdInteractionListener recylcerAdInteractionListener) {
        this.adNativeWrapper = cSJTTAdNativeWrapper;
        this.ad = tTNativeExpressAd;
        this.recylcerAdInteractionListener = recylcerAdInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onCancel() {
    }

    public void onRefuse() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onSelected(int i, String str, boolean z) {
        try {
            CSJTTAdNativeWrapper cSJTTAdNativeWrapper = this.adNativeWrapper;
            if (cSJTTAdNativeWrapper != null && cSJTTAdNativeWrapper.getLoaderListener() != null) {
                this.adNativeWrapper.getLoaderListener().onAdClosed();
            }
            RecylcerAdInteractionListener recylcerAdInteractionListener = this.recylcerAdInteractionListener;
            if (recylcerAdInteractionListener != null) {
                recylcerAdInteractionListener.onAdClosed();
            }
            TTNativeExpressAd tTNativeExpressAd = this.ad;
            if (tTNativeExpressAd != null) {
                View expressAdView = tTNativeExpressAd.getExpressAdView();
                if (expressAdView != null && expressAdView.getParent() != null && (expressAdView.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
                }
                this.ad.destroy();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onShow() {
    }

    public void onSelected(int i, String str) {
        try {
            CSJTTAdNativeWrapper cSJTTAdNativeWrapper = this.adNativeWrapper;
            if (cSJTTAdNativeWrapper != null && cSJTTAdNativeWrapper.getLoaderListener() != null) {
                this.adNativeWrapper.getLoaderListener().onAdClosed();
            }
            RecylcerAdInteractionListener recylcerAdInteractionListener = this.recylcerAdInteractionListener;
            if (recylcerAdInteractionListener != null) {
                recylcerAdInteractionListener.onAdClosed();
            }
            TTNativeExpressAd tTNativeExpressAd = this.ad;
            if (tTNativeExpressAd != null) {
                View expressAdView = tTNativeExpressAd.getExpressAdView();
                if (expressAdView != null && expressAdView.getParent() != null && (expressAdView.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
                }
                this.ad.destroy();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
