package com.huawei.hms.ads.instreamad;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface InstreamMediaStateListener {
    void onMediaCompletion(int i);

    void onMediaError(int i, int i2, int i3);

    void onMediaPause(int i);

    void onMediaProgress(int i, int i2);

    void onMediaStart(int i);

    void onMediaStop(int i);
}
