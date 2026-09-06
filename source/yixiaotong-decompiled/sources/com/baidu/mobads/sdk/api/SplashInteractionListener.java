package com.baidu.mobads.sdk.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface SplashInteractionListener extends SplashAdListener {
    void onAdCacheFailed();

    void onAdCacheSuccess();

    void onAdClick();

    void onAdDismissed();

    void onAdExposed();

    void onAdPresent();

    void onAdSkip();

    void onLpClosed();
}
