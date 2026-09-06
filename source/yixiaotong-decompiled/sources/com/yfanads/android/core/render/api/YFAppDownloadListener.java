package com.yfanads.android.core.render.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface YFAppDownloadListener {
    void onDownloadFailed();

    void onDownloadFinished();

    void onDownloadStarted();

    void onProgressUpdate(int i);
}
