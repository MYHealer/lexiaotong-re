package com.opos.exoplayer.core.c.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f6331a;
    private final int b;
    private int c;
    private int d;

    public j(byte[] bArr) {
        this.f6331a = bArr;
        this.b = bArr.length;
    }

    private void c() {
        int i;
        int i2 = this.c;
        com.opos.exoplayer.core.i.a.b(i2 >= 0 && (i2 < (i = this.b) || (i2 == i && this.d == 0)));
    }

    public int a(int i) {
        int i2 = this.c;
        int iMin = Math.min(i, 8 - this.d);
        int i3 = i2 + 1;
        int i4 = ((this.f6331a[i2] & 255) >> this.d) & (255 >> (8 - iMin));
        while (iMin < i) {
            i4 |= (this.f6331a[i3] & 255) << iMin;
            iMin += 8;
            i3++;
        }
        int i5 = i4 & ((-1) >>> (32 - i));
        b(i);
        return i5;
    }

    public boolean a() {
        boolean z = (((this.f6331a[this.c] & 255) >> this.d) & 1) == 1;
        b(1);
        return z;
    }

    public int b() {
        return (this.c * 8) + this.d;
    }

    public void b(int i) {
        int i2 = i / 8;
        int i3 = this.c + i2;
        this.c = i3;
        int i4 = this.d + (i - (i2 * 8));
        this.d = i4;
        if (i4 > 7) {
            this.c = i3 + 1;
            this.d = i4 - 8;
        }
        c();
    }
}
