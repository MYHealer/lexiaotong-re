package com.heytap.msp.mobad.api.listener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface IRewardVideoAdListener extends IRewardListener {
    void onAdClick(long j);

    void onAdFailed(int i, String str);

    @Deprecated
    void onAdFailed(String str);

    void onAdSuccess();

    void onLandingPageClose();

    void onLandingPageOpen();

    void onVideoPlayClose(long j);

    void onVideoPlayComplete();

    void onVideoPlayError(String str);

    void onVideoPlayStart();
}
