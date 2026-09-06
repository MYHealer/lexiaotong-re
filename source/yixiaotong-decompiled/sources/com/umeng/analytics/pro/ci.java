package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TTransport.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class ci {
    public abstract int a(byte[] bArr, int i, int i2) throws cj;

    public void a(int i) {
    }

    public abstract boolean a();

    public abstract void b() throws cj;

    public abstract void b(byte[] bArr, int i, int i2) throws cj;

    public abstract void c();

    public void d() throws cj {
    }

    public byte[] f() {
        return null;
    }

    public int g() {
        return 0;
    }

    public int h() {
        return -1;
    }

    public boolean i() {
        return a();
    }

    public int d(byte[] bArr, int i, int i2) throws cj {
        int i3 = 0;
        while (i3 < i2) {
            int iA = a(bArr, i + i3, i2 - i3);
            if (iA <= 0) {
                throw new cj("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i3 += iA;
        }
        return i3;
    }

    public void b(byte[] bArr) throws cj {
        b(bArr, 0, bArr.length);
    }
}
