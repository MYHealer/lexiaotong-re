package com.ubix.ssp.ad.g;

import com.ubix.ssp.open.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface j {
    void a(boolean z, String str, int i, String str2, AdError adError);

    void onAdClosed();

    void onAdExposed();

    void onAdLoadSucceed();

    void onError(AdError adError);

    void onVideoCached();

    void onVideoClicked();

    void onVideoPlayCompleted();

    void onVideoPlayStarted();

    void onVideoRewarded();
}
