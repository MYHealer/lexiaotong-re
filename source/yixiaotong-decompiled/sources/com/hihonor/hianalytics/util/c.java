package com.hihonor.hianalytics.util;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f3716a;
    private int b = 0;

    public c(int i) {
        this.f3716a = null;
        this.f3716a = new byte[i];
    }

    public void a(byte[] bArr, int i) {
        if (i <= 0) {
            return;
        }
        byte[] bArr2 = this.f3716a;
        int length = bArr2.length;
        int i2 = this.b;
        if (length - i2 >= i) {
            System.arraycopy(bArr, 0, bArr2, i2, i);
        } else {
            byte[] bArr3 = new byte[(bArr2.length + i) << 1];
            System.arraycopy(bArr2, 0, bArr3, 0, i2);
            System.arraycopy(bArr, 0, bArr3, this.b, i);
            this.f3716a = bArr3;
        }
        this.b += i;
    }

    public byte[] a() {
        int i = this.b;
        if (i <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.f3716a, 0, bArr, 0, i);
        return bArr;
    }

    public int b() {
        return this.b;
    }
}
