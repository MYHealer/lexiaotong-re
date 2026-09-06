package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: BarcodeRow.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f4297a;
    private int b = 0;

    l(int i) {
        this.f4297a = new byte[i];
    }

    private void a(int i, boolean z) {
        if (!y6.a(this.f4297a, i)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.f4297a[i] = z ? (byte) 1 : (byte) 0;
    }

    void a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.b;
            this.b = i3 + 1;
            a(i3, z);
        }
    }

    byte[] a(int i) {
        int length = this.f4297a.length * i;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = this.f4297a[i2 / i];
        }
        return bArr;
    }
}
