package com.bytedance.android.live.base.api.outer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface ILiveStatusListener {
    void onError(String str);

    void onFirstFrame();

    void onLiveStatusChange(boolean z);

    void onPrepare();

    void onRoomInvalid();

    void onVideoSizeChanged(int i, int i2);
}
