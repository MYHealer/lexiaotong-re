package com.hihonor.adsdk.common.video;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface OnVideoStatusChangeListener {
    void onProgressUpdate(long j, long j2, long j3);

    void onVideoBuffering(boolean z);

    void onVideoEnd();

    void onVideoError(int i, String str, int i2);

    void onVideoMute(boolean z);

    void onVideoPause();

    void onVideoPrepare();

    void onVideoPrepared(long j, long j2);

    void onVideoResume();

    void onVideoSizeChange(AdVideoSize adVideoSize);

    void onVideoStart();
}
