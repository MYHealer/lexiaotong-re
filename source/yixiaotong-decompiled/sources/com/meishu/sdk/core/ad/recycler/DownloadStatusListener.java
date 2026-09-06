package com.meishu.sdk.core.ad.recycler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface DownloadStatusListener {
    void onDownloadError(String str);

    void onDownloadFinish();

    void onDownloadProgress(int i);

    void onDownloadStart();

    void onInstallStart();

    void onInstallSuccess();
}
