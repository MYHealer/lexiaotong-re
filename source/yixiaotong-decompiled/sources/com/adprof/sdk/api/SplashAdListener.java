package com.adprof.sdk.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface SplashAdListener {
    void onAdCacheSuccess();

    void onAdLoadSuccess();

    void onSplashAdClick();

    void onSplashAdClose(boolean z);

    void onSplashAdLoadFail(AdError adError);

    void onSplashAdShow();

    void onSplashAdShowError(AdError adError);
}
