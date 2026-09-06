package com.yfanads.android.adx.thirdpart.filedownload;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface ILostServiceConnectedHandler {
    boolean dispatchTaskStart(BaseDownloadTask.IRunningTask iRunningTask);

    boolean isInWaitingList(BaseDownloadTask.IRunningTask iRunningTask);

    void taskWorkFine(BaseDownloadTask.IRunningTask iRunningTask);
}
