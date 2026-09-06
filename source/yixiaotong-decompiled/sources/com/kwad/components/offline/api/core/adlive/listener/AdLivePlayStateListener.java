package com.kwad.components.offline.api.core.adlive.listener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface AdLivePlayStateListener {
    void onLiveAudioEnableChange(boolean z);

    void onLivePlayCompleted();

    void onLivePlayEnd();

    void onLivePlayPause();

    void onLivePlayProgress(long j);

    void onLivePlayResume();

    void onLivePlayStart();

    void onLivePrepared();
}
