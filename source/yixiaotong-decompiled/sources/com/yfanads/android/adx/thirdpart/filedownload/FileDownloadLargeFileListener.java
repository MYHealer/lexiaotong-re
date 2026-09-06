package com.yfanads.android.adx.thirdpart.filedownload;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class FileDownloadLargeFileListener extends FileDownloadListener {
    public FileDownloadLargeFileListener() {
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
    public void connected(BaseDownloadTask baseDownloadTask, String str, boolean z, int i, int i2) {
    }

    public void connected(BaseDownloadTask baseDownloadTask, String str, boolean z, long j, long j2) {
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
    public void paused(BaseDownloadTask baseDownloadTask, int i, int i2) {
    }

    public abstract void paused(BaseDownloadTask baseDownloadTask, long j, long j2);

    @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
    public void pending(BaseDownloadTask baseDownloadTask, int i, int i2) {
    }

    public abstract void pending(BaseDownloadTask baseDownloadTask, long j, long j2);

    @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
    public void progress(BaseDownloadTask baseDownloadTask, int i, int i2) {
    }

    public abstract void progress(BaseDownloadTask baseDownloadTask, long j, long j2);

    @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
    public void retry(BaseDownloadTask baseDownloadTask, Throwable th, int i, int i2) {
    }

    public void retry(BaseDownloadTask baseDownloadTask, Throwable th, int i, long j) {
    }

    public FileDownloadLargeFileListener(int i) {
        super(i);
    }
}
