package com.kwad.framework.filedownloader.download;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    final long aAW;
    final long aAX;
    final long aAY;
    final long contentLength;

    a(long j, long j2, long j3, long j4) {
        this.aAW = j;
        this.aAX = j2;
        this.aAY = j3;
        this.contentLength = j4;
    }

    public final String toString() {
        return com.kwad.framework.filedownloader.f.f.c("range[%d, %d) current offset[%d]", Long.valueOf(this.aAW), Long.valueOf(this.aAY), Long.valueOf(this.aAX));
    }
}
