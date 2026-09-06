package com.hihonor.updater.installsdk.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface DownloadInstallListener {
    void onAppUninstalled(DIInfo dIInfo, AppStatusInfo appStatusInfo);

    void onDownloadFail(DIInfo dIInfo, AppStatusInfo appStatusInfo);

    void onDownloadInstallCancel(DIInfo dIInfo, AppStatusInfo appStatusInfo);

    void onDownloadPause(DIInfo dIInfo, AppStatusInfo appStatusInfo);

    void onDownloadProgress(DIInfo dIInfo, AppStatusInfo appStatusInfo);

    void onDownloadStart(DIInfo dIInfo, AppStatusInfo appStatusInfo);

    void onDownloadSuccess(DIInfo dIInfo, AppStatusInfo appStatusInfo);

    void onDownloadWaiting(DIInfo dIInfo, AppStatusInfo appStatusInfo);

    void onInstallFail(DIInfo dIInfo, AppStatusInfo appStatusInfo);

    void onInstallStart(DIInfo dIInfo, AppStatusInfo appStatusInfo);

    void onInstallSuccess(DIInfo dIInfo, AppStatusInfo appStatusInfo);

    void onServiceConnected();

    void onServiceShutdown();
}
