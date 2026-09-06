package com.ubixnow.adtype.nativead.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UMNNativeApkDownloadListener {
    void onDownloadFailed();

    void onDownloadFinished();

    void onPaused(int i);

    void onProgressUpdate(int i);
}
