package com.kwad.sdk.core.video.videoview;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface c {
    boolean OO();

    int getBufferPercentage();

    long getCurrentPosition();

    long getDuration();

    int getMediaPlayerType();

    boolean isIdle();

    boolean isPaused();

    void pause();

    void release();

    void restart();

    void setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a aVar);

    void start();
}
