package com.ubix.ssp.open.interstitial;

import com.ubix.ssp.open.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UBiXInterstitialAdListener {
    void onAdClicked();

    void onAdClosed();

    void onAdExposeFailed(AdError adError);

    void onAdExposed();

    void onAdLoadFailed(AdError adError);

    void onAdLoadSucceed();
}
