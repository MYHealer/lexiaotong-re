package com.fancy;

import android.media.MediaDataSource;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _by extends MediaDataSource {
    public final /* synthetic */ _bz _a;

    public _by(_bz _bzVar) {
        this._a = _bzVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return this._a._f.length;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j, byte[] bArr, int i, int i2) {
        byte[] bArr2 = this._a._f;
        if (j >= bArr2.length) {
            return -1;
        }
        int i3 = (int) j;
        int iMin = Math.min(bArr2.length - i3, i2);
        System.arraycopy(this._a._f, i3, bArr, i, iMin);
        return iMin;
    }
}
