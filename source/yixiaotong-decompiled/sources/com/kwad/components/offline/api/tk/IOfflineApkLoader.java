package com.kwad.components.offline.api.tk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IOfflineApkLoader {
    void addLoadStatusListener(IOfflineApkLoadStatusListener iOfflineApkLoadStatusListener);

    void cancelDownload();

    void clearFileCache();

    void installApp();

    void openApp();

    void pauseDownload();

    void resumeDownload();

    void setCustomReportParam(String str);

    void startDownload();

    void stopDownload();

    void uninstallApp();
}
