package com.yfanads.android.adx.thirdpart.filedownload;

import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface IThreadPoolMonitor {
    int findRunningTaskIdBySameTempPath(String str, int i);

    boolean isDownloading(FileDownloadModel fileDownloadModel);
}
