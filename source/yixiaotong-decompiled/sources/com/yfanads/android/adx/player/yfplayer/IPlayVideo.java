package com.yfanads.android.adx.player.yfplayer;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface IPlayVideo {
    int getCurrentTime();

    View getView();

    void pause();

    void reStart();

    void release();

    void setVolume(boolean z);

    void start();

    void stop();
}
