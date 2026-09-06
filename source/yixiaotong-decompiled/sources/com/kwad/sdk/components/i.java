package com.kwad.sdk.components;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface i {
    void onDownloadFailed();

    void onDownloadFinished();

    void onDownloadStarted();

    void onIdle();

    void onInstalled();

    void onPaused(int i, long j, long j2);

    void onProgressUpdate(int i, long j, long j2);
}
