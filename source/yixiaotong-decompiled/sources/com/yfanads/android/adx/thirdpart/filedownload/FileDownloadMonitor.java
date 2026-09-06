package com.yfanads.android.adx.thirdpart.filedownload;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FileDownloadMonitor {
    private static IMonitor monitor;

    public interface IMonitor {
        void onRequestStart(int i, boolean z, FileDownloadListener fileDownloadListener);

        void onRequestStart(BaseDownloadTask baseDownloadTask);

        void onTaskBegin(BaseDownloadTask baseDownloadTask);

        void onTaskOver(BaseDownloadTask baseDownloadTask);

        void onTaskStarted(BaseDownloadTask baseDownloadTask);
    }

    public static IMonitor getMonitor() {
        return monitor;
    }

    public static boolean isValid() {
        return getMonitor() != null;
    }

    public static void releaseGlobalMonitor() {
        monitor = null;
    }

    public static void setGlobalMonitor(IMonitor iMonitor) {
        monitor = iMonitor;
    }
}
