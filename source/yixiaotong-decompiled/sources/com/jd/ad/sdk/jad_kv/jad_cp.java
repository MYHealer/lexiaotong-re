package com.jd.ad.sdk.jad_kv;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_cp extends OutputStream {
    public final OutputStream jad_an;
    public byte[] jad_bo;
    public com.jd.ad.sdk.jad_ny.jad_bo jad_cp;
    public int jad_dq;

    public jad_cp(OutputStream outputStream, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar, int i) {
        this.jad_an = outputStream;
        this.jad_cp = jad_boVar;
        this.jad_bo = (byte[]) jad_boVar.jad_an(i, byte[].class);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.jad_an.close();
            byte[] bArr = this.jad_bo;
            if (bArr != null) {
                this.jad_cp.jad_an(bArr);
                this.jad_bo = null;
            }
        } catch (Throwable th) {
            this.jad_an.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        int i = this.jad_dq;
        if (i > 0) {
            this.jad_an.write(this.jad_bo, 0, i);
            this.jad_dq = 0;
        }
        this.jad_an.flush();
    }

    public final void jad_bo() throws IOException {
        int i = this.jad_dq;
        byte[] bArr = this.jad_bo;
        if (i != bArr.length || i <= 0) {
            return;
        }
        this.jad_an.write(bArr, 0, i);
        this.jad_dq = 0;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.jad_bo;
        int i2 = this.jad_dq;
        this.jad_dq = i2 + 1;
        bArr[i2] = (byte) i;
        jad_bo();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            int i6 = this.jad_dq;
            if (i6 == 0 && i4 >= this.jad_bo.length) {
                this.jad_an.write(bArr, i5, i4);
                return;
            }
            int iMin = Math.min(i4, this.jad_bo.length - i6);
            System.arraycopy(bArr, i5, this.jad_bo, this.jad_dq, iMin);
            this.jad_dq += iMin;
            i3 += iMin;
            jad_bo();
        } while (i3 < i2);
    }
}
