package com.kwad.framework.filedownloader.event;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class DownloadServiceConnectChangedEvent extends b {
    private final ConnectStatus aCn;
    private final Class<?> aCo;

    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public final ConnectStatus CF() {
        return this.aCn;
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super(com.yfanads.android.adx.thirdpart.filedownload.event.DownloadServiceConnectChangedEvent.ID);
        this.aCn = connectStatus;
        this.aCo = cls;
    }
}
