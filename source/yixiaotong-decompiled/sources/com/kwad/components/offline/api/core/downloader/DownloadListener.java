package com.kwad.components.offline.api.core.downloader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface DownloadListener {
    void onCanceled(int i);

    void onCompleted(int i, String str, String str2, String str3);

    void onError(int i, Throwable th);

    void onProgress(int i, long j, long j2);

    void onStart(int i);
}
