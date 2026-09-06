package com.ubix.ssp.open.video;

import com.ubix.ssp.open.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UBiXRewardVideoAdListener {
    void onAdClosed();

    void onAdExposed();

    void onAdLoadSucceed();

    void onError(AdError adError);

    void onVideoCached();

    void onVideoClicked();

    void onVideoPlayCompleted();

    void onVideoPlayStarted();

    void onVideoRewardVerify(boolean z, UBiXRewardInfo uBiXRewardInfo);

    void onVideoRewarded();

    void onVideoSkipped();
}
