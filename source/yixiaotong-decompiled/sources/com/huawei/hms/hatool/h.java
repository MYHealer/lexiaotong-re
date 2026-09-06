package com.huawei.hms.hatool;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f4082a;
    private int b = 0;

    public h(int i) {
        this.f4082a = null;
        this.f4082a = new byte[i];
    }

    public void a(byte[] bArr, int i) {
        if (i <= 0) {
            return;
        }
        byte[] bArr2 = this.f4082a;
        int length = bArr2.length;
        int i2 = this.b;
        if (length - i2 >= i) {
            System.arraycopy(bArr, 0, bArr2, i2, i);
        } else {
            byte[] bArr3 = new byte[(bArr2.length + i) << 1];
            System.arraycopy(bArr2, 0, bArr3, 0, i2);
            System.arraycopy(bArr, 0, bArr3, this.b, i);
            this.f4082a = bArr3;
        }
        this.b += i;
    }

    public byte[] a() {
        int i = this.b;
        if (i <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.f4082a, 0, bArr, 0, i);
        return bArr;
    }

    public int b() {
        return this.b;
    }
}
