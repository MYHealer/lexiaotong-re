package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class e extends com.kwad.framework.filedownloader.event.c {
    private DownloadServiceConnectChangedEvent.ConnectStatus azG;

    public abstract void Bi();

    public abstract void Bj();

    public final DownloadServiceConnectChangedEvent.ConnectStatus Bk() {
        return this.azG;
    }

    @Override // com.kwad.framework.filedownloader.event.c
    public final boolean a(com.kwad.framework.filedownloader.event.b bVar) {
        if (!(bVar instanceof DownloadServiceConnectChangedEvent)) {
            return false;
        }
        DownloadServiceConnectChangedEvent.ConnectStatus connectStatusCF = ((DownloadServiceConnectChangedEvent) bVar).CF();
        this.azG = connectStatusCF;
        if (connectStatusCF == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
            Bi();
            return false;
        }
        Bj();
        return false;
    }
}
