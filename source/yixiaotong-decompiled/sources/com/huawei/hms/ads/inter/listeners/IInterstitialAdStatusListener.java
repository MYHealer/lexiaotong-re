package com.huawei.hms.ads.inter.listeners;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface IInterstitialAdStatusListener {
    void onAdClicked();

    void onAdClosed();

    void onAdCompleted();

    void onAdError(int i, int i2);

    void onAdShown();

    void onLeftApp();

    void onRewarded();
}
