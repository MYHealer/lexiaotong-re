package com.yfanads.android.adx.thirdpart.filedownload.download;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface ProcessCallback {
    boolean isRetry(Exception exc);

    void onCompleted(DownloadRunnable downloadRunnable, long j, long j2);

    void onError(Exception exc);

    void onProgress(long j);

    void onRetry(Exception exc);

    void syncProgressFromCache();
}
