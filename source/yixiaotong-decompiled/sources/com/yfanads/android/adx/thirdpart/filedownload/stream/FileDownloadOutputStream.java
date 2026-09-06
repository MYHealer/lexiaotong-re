package com.yfanads.android.adx.thirdpart.filedownload.stream;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface FileDownloadOutputStream {
    void close() throws IOException;

    void flushAndSync() throws IOException;

    void seek(long j) throws IllegalAccessException, IOException;

    void setLength(long j) throws IllegalAccessException, IOException;

    void write(byte[] bArr, int i, int i2) throws IOException;
}
