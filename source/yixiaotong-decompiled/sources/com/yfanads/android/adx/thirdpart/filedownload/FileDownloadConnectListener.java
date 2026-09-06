package com.yfanads.android.adx.thirdpart.filedownload;

import com.yfanads.android.adx.thirdpart.filedownload.event.DownloadServiceConnectChangedEvent;
import com.yfanads.android.adx.thirdpart.filedownload.event.IDownloadEvent;
import com.yfanads.android.adx.thirdpart.filedownload.event.IDownloadListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class FileDownloadConnectListener extends IDownloadListener {
    private DownloadServiceConnectChangedEvent.ConnectStatus mConnectStatus;

    @Override // com.yfanads.android.adx.thirdpart.filedownload.event.IDownloadListener
    public boolean callback(IDownloadEvent iDownloadEvent) {
        if (!(iDownloadEvent instanceof DownloadServiceConnectChangedEvent)) {
            return false;
        }
        DownloadServiceConnectChangedEvent.ConnectStatus status = ((DownloadServiceConnectChangedEvent) iDownloadEvent).getStatus();
        this.mConnectStatus = status;
        if (status == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
            connected();
            return false;
        }
        disconnected();
        return false;
    }

    public abstract void connected();

    public abstract void disconnected();

    public DownloadServiceConnectChangedEvent.ConnectStatus getConnectStatus() {
        return this.mConnectStatus;
    }
}
