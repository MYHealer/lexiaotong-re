package com.huawei.hms.ads;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface IAppDownloadButton {
    void cancel();

    void continueDownload();

    AppDownloadStatus refreshAppStatus();

    void setAllowedNonWifiNetwork(boolean z);

    void setAppDownloadButtonStyle(AppDownloadButtonStyle appDownloadButtonStyle);

    void setOnDownloadStatusChangedListener(AppDownloadButton.OnDownloadStatusChangedListener onDownloadStatusChangedListener);

    void setOnNonWifiDownloadListener(AppDownloadButton.OnNonWifiDownloadListener onNonWifiDownloadListener);

    void setShowPermissionDialog(boolean z);
}
