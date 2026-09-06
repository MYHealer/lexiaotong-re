package com.fancy.adsdk.lib.interf;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface PtgAppDownloadListener {
    void onDownloadActive(long j, long j2, String str);

    void onDownloadCancel();

    void onDownloadFailed(String str);

    void onDownloadFinished(String str);

    void onDownloadPaused(long j, long j2, String str);

    void onIdle();

    void onInstalled(String str);
}
