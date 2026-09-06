package com.ubixnow.adtype.splash.api;

import com.ubixnow.core.api.UMNError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UMNSplashListener {
    void onAdClicked();

    void onAdDismiss(boolean z);

    void onAdExposure();

    void onAdLoadSuccess(UMNSplashInfo uMNSplashInfo);

    void onError(UMNError uMNError);

    void showError(UMNError uMNError);
}
