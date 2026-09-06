package com.meishu.sdk.core.ad.reward;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface RewardAdMediaListener {
    void onSkippedVideo();

    void onVideoCompleted();

    void onVideoError();

    void onVideoPause();

    void onVideoResume();

    void onVideoStart();
}
