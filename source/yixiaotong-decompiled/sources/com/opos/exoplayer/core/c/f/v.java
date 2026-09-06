package com.opos.exoplayer.core.c.f;

import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f6362a;
    public int b;
    private final int c;
    private boolean d;
    private boolean e;

    public v(int i, int i2) {
        this.c = i;
        byte[] bArr = new byte[i2 + 3];
        this.f6362a = bArr;
        bArr[2] = 1;
    }

    public void a() {
        this.d = false;
        this.e = false;
    }

    public void a(int i) {
        com.opos.exoplayer.core.i.a.b(!this.d);
        boolean z = i == this.c;
        this.d = z;
        if (z) {
            this.b = 3;
            this.e = false;
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.d) {
            int i3 = i2 - i;
            byte[] bArr2 = this.f6362a;
            int length = bArr2.length;
            int i4 = this.b + i3;
            if (length < i4) {
                this.f6362a = Arrays.copyOf(bArr2, i4 * 2);
            }
            System.arraycopy(bArr, i, this.f6362a, this.b, i3);
            this.b += i3;
        }
    }

    public boolean b() {
        return this.e;
    }

    public boolean b(int i) {
        if (!this.d) {
            return false;
        }
        this.b -= i;
        this.d = false;
        this.e = true;
        return true;
    }
}
