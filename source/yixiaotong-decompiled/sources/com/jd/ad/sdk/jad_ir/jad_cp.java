package com.jd.ad.sdk.jad_ir;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_cp extends FilterInputStream {
    public final long jad_an;
    public int jad_bo;

    public jad_cp(InputStream inputStream, long j) {
        super(inputStream);
        this.jad_an = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.jad_an - ((long) this.jad_bo), ((FilterInputStream) this).in.available());
    }

    public final int jad_an(int i) throws IOException {
        if (i >= 0) {
            this.jad_bo += i;
        } else if (this.jad_an - ((long) this.jad_bo) > 0) {
            throw new IOException(com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Failed to read all expected data, expected: ").append(this.jad_an).append(", but read: ").append(this.jad_bo).toString());
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int i;
        i = super.read();
        jad_an(i >= 0 ? 1 : -1);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        int iJad_an;
        int length = bArr.length;
        synchronized (this) {
            iJad_an = jad_an(super.read(bArr, 0, length));
        }
        return iJad_an;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        return jad_an(super.read(bArr, i, i2));
    }
}
