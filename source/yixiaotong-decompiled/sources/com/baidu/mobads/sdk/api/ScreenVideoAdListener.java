package com.baidu.mobads.sdk.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface ScreenVideoAdListener {
    void onAdClick();

    void onAdClose(float f);

    void onAdFailed(String str);

    void onAdLoaded();

    void onAdShow();

    void onAdSkip(float f);

    void onVideoDownloadFailed();

    void onVideoDownloadSuccess();

    void playCompletion();
}
