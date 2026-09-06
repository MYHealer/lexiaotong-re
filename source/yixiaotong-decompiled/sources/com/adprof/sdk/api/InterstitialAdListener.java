package com.adprof.sdk.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface InterstitialAdListener {
    void onInterstitialAdClick();

    void onInterstitialAdClosed();

    void onInterstitialAdLoadCached();

    void onInterstitialAdLoadError(AdError adError);

    void onInterstitialAdLoadSuccess();

    void onInterstitialAdPlayEnd();

    void onInterstitialAdShow();

    void onInterstitialAdShowError(AdError adError);
}
