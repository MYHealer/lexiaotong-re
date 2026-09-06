package com.bytedance.android.live.base.api.outer;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface ILiveView {
    View getView();

    void onDislike();

    void openLive();

    void release();

    void reportShow();

    void setLiveStatusListener(ILiveStatusListener iLiveStatusListener);

    void setMute(boolean z);

    void show();

    void stream();
}
