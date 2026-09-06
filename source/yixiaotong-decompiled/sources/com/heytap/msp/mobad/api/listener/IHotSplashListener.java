package com.heytap.msp.mobad.api.listener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface IHotSplashListener {
    void onAdClick();

    void onAdDismissed();

    void onAdFailed(int i, String str);

    void onAdReady();

    void onAdShow(String str);
}
