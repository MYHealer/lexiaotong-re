package com.baidu.mobads.sdk.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface ExpressInterstitialListener {
    void onADExposed();

    void onADExposureFailed();

    void onADLoaded();

    void onAdCacheFailed();

    void onAdCacheSuccess();

    void onAdClick();

    void onAdClose();

    void onAdFailed(int i, String str);

    void onLpClosed();

    void onNoAd(int i, String str);
}
