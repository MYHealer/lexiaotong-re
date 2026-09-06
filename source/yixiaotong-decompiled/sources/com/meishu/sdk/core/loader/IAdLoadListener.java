package com.meishu.sdk.core.loader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IAdLoadListener<T> {
    void onAdClosed();

    void onAdError();

    void onAdExposure();

    void onAdLoaded(T t);

    void onAdPlatformError(AdPlatformError adPlatformError);

    void onAdReady(T t);

    void onAdRenderFail(String str, int i);
}
