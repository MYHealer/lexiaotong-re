package com.yfanads.android.adx.thirdpart.filedownload.event;

import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class IDownloadEvent {
    public Runnable callback = null;
    protected final String id;

    public IDownloadEvent(String str) {
        this.id = str;
    }

    public final String getId() {
        return this.id;
    }

    public IDownloadEvent(String str, boolean z) {
        this.id = str;
        if (z) {
            FileDownloadLog.w(this, "do not handle ORDER any more, %s", str);
        }
    }
}
