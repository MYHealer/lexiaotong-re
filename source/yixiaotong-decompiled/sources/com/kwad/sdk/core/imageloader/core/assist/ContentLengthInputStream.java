package com.kwad.sdk.core.imageloader.core.assist;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ContentLengthInputStream extends InputStream {
    private final int length;
    private final InputStream stream;

    @Override // java.io.InputStream
    public int available() {
        return this.length;
    }

    public ContentLengthInputStream(InputStream inputStream, int i) {
        this.stream = inputStream;
        this.length = i;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.stream.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.stream.mark(i);
    }

    @Override // java.io.InputStream
    public int read() {
        return this.stream.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return this.stream.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        return this.stream.read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.stream.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.stream.skip(j);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.stream.markSupported();
    }
}
