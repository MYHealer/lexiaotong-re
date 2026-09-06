package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: TByteArrayOutputStream.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ax extends ByteArrayOutputStream {
    public ax(int i) {
        super(i);
    }

    public ax() {
    }

    public byte[] a() {
        return this.buf;
    }

    public int b() {
        return this.count;
    }
}
