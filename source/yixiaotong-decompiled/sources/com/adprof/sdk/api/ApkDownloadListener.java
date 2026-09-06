package com.adprof.sdk.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface ApkDownloadListener {
    void onDownloadEnd(boolean z);

    void onDownloadPaused(boolean z);

    void onDownloadStart(boolean z);

    void onInstallEnd(boolean z);

    void onInstallStart(boolean z);
}
