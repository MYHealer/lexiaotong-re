package com.qq.e.ads.nativ;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface CustomizeVideo {
    String getVideoUrl();

    void reportVideoCompleted();

    void reportVideoError(long j, int i, int i2);

    void reportVideoPause(long j);

    void reportVideoPreload();

    void reportVideoResume(long j);

    void reportVideoStart();
}
