package com.ubixnow.adtype.nativead.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UMNCustomVideoCallBack {
    String getVideoUrl();

    void reportVideoAutoStart();

    void reportVideoBreak(long j);

    void reportVideoContinue(long j);

    void reportVideoError(long j, int i, int i2);

    void reportVideoFinish();

    void reportVideoPause(long j);

    void reportVideoStart();

    void reportVideoStartError(int i, int i2);
}
