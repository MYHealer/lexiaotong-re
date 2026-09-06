package com.hihonor.dlinstall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface DownloadInstallV2Listener extends DownloadInstallListener {
    void onDownloadFail(int i, String str, int i2, String str2, int i3);

    void onDownloadPause(int i, String str, long j, long j2, int i2);

    void onDownloadProgress(int i, String str, long j, long j2, float f, int i2);

    void onDownloadStart(int i, String str, long j, long j2, int i2);

    void onDownloadSuccess(int i, String str, int i2);

    void onDownloadWaiting(int i, String str, long j, long j2, int i2, int i3);

    void onTrafficDownload(int i, String str);
}
