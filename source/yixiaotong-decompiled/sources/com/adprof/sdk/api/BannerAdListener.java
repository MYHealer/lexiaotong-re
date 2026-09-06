package com.adprof.sdk.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface BannerAdListener {
    void onBannerAdClick();

    void onBannerAdClosed();

    void onBannerAdLoadError(AdError adError);

    void onBannerAdLoadSuccess();

    void onBannerAdShow();

    void onBannerAdShowError(AdError adError);
}
