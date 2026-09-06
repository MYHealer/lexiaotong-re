package com.yfanads.android.adx.thirdpart.filedownload;

import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class FileDownloadListener {
    public FileDownloadListener() {
    }

    public void blockComplete(BaseDownloadTask baseDownloadTask) throws Throwable {
    }

    public abstract void completed(BaseDownloadTask baseDownloadTask);

    public void connected(BaseDownloadTask baseDownloadTask, String str, boolean z, int i, int i2) {
    }

    public abstract void error(BaseDownloadTask baseDownloadTask, Throwable th);

    public boolean isInvalid() {
        return false;
    }

    public abstract void paused(BaseDownloadTask baseDownloadTask, int i, int i2);

    public abstract void pending(BaseDownloadTask baseDownloadTask, int i, int i2);

    public abstract void progress(BaseDownloadTask baseDownloadTask, int i, int i2);

    public void retry(BaseDownloadTask baseDownloadTask, Throwable th, int i, int i2) {
    }

    public void started(BaseDownloadTask baseDownloadTask) {
    }

    public abstract void warn(BaseDownloadTask baseDownloadTask);

    public FileDownloadListener(int i) {
        FileDownloadLog.w(this, "not handle priority any more", new Object[0]);
    }
}
