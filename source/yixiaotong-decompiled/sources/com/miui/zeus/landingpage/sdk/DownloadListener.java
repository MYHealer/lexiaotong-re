package com.miui.zeus.landingpage.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface DownloadListener {
    void onCancelDownload(String str);

    void onDownloadFailed(String str, int i);

    void onDownloadFinished(String str);

    void onDownloadPaused(String str);

    void onDownloadProgressUpdated(String str, int i);

    void onDownloadStarted(String str);

    void onInstallFailed(String str, int i);

    void onInstallStart(String str);

    void onInstallSuccess(String str);

    void onOtherOperation(String str, int i, int i2);
}
