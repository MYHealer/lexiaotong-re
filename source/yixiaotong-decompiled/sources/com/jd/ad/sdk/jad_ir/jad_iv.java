package com.jd.ad.sdk.jad_ir;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_iv extends FilterInputStream {
    public int jad_an;

    public jad_iv(InputStream inputStream) {
        super(inputStream);
        this.jad_an = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        int i = this.jad_an;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    public final long jad_bo(long j) {
        int i = this.jad_an;
        if (i == 0) {
            return -1L;
        }
        if (i != Integer.MIN_VALUE) {
            long j2 = i;
            if (j > j2) {
                return j2;
            }
        }
        return j;
    }

    public final void jad_cp(long j) {
        int i = this.jad_an;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.jad_an = (int) (((long) i) - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.jad_an = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (jad_bo(1L) == -1) {
            return -1;
        }
        int i = super.read();
        jad_cp(1L);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int iJad_bo = (int) jad_bo(i2);
        if (iJad_bo == -1) {
            return -1;
        }
        int i3 = super.read(bArr, i, iJad_bo);
        jad_cp(i3);
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        super.reset();
        this.jad_an = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long jJad_bo = jad_bo(j);
        if (jJad_bo == -1) {
            return 0L;
        }
        long jSkip = super.skip(jJad_bo);
        jad_cp(jSkip);
        return jSkip;
    }
}
