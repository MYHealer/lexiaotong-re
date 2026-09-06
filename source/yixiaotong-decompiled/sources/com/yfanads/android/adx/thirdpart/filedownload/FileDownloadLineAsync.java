package com.yfanads.android.adx.thirdpart.filedownload;

import android.app.Notification;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FileDownloadLineAsync {
    public boolean startForeground(final int i, final Notification notification) {
        if (FileDownloader.getImpl().isServiceConnected()) {
            FileDownloader.getImpl().startForeground(i, notification);
            return true;
        }
        FileDownloader.getImpl().bindService(new Runnable() { // from class: com.yfanads.android.adx.thirdpart.filedownload.FileDownloadLineAsync.1
            @Override // java.lang.Runnable
            public void run() {
                FileDownloader.getImpl().startForeground(i, notification);
            }
        });
        return false;
    }
}
