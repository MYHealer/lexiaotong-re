package com.kwad.framework.filedownloader.e;

import java.io.Closeable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface a extends Closeable {
    void Du();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void seek(long j);

    void setLength(long j);

    void write(byte[] bArr, int i, int i2);
}
