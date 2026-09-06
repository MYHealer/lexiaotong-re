package com.hihonor.adsdk.common.video;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface IPlayer {
    void addOnAdVideoListener(String str, OnVideoStatusChangeListener onVideoStatusChangeListener);

    int getBufferedPercentage();

    long getBufferedPosition();

    long getCurrentPosition();

    long getDuration();

    View getPlayerView();

    int getState();

    boolean isMuted();

    boolean isPlaying();

    void notifyVisibilityChange(boolean z);

    void pause();

    void release();

    void removeAdVideoListener(String str);

    void removeAllAdVideoListener();

    void replay();

    void resume();

    void seekTo(long j);

    void setCacheEnable(boolean z);

    void setMuted(boolean z);

    void setVideoViewSize(AdVideoSize adVideoSize, int i, int i2);

    void startUri(String str);
}
