package com.hihonor.dlinstall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface DownloadInstallListener {
    void onDownloadFail(int i, String str, int i2, String str2);

    void onDownloadPause(int i, String str);

    void onDownloadProgress(int i, String str, long j, long j2, float f);

    void onDownloadStart(int i, String str);

    void onDownloadSuccess(int i, String str);

    void onDownloadWaiting(int i, String str);

    void onInstallFail(int i, String str, int i2, String str2);

    void onInstallStart(int i, String str);

    void onInstallSuccess(int i, String str);

    void onServiceShutdown();
}
