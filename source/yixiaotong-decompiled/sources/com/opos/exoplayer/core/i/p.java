package com.opos.exoplayer.core.i;

import java.nio.charset.Charset;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f6510a;
    private int b;
    private int c;

    public p() {
    }

    public p(int i) {
        this.f6510a = new byte[i];
        this.c = i;
    }

    public p(byte[] bArr) {
        this.f6510a = bArr;
        this.c = bArr.length;
    }

    public p(byte[] bArr, int i) {
        this.f6510a = bArr;
        this.c = i;
    }

    public long A() {
        int i;
        int i2;
        long j = this.f6510a[this.b];
        int i3 = 7;
        while (true) {
            if (i3 >= 0) {
                int i4 = 1 << i3;
                if ((((long) i4) & j) == 0) {
                    if (i3 < 6) {
                        j &= (long) (i4 - 1);
                        i2 = 7 - i3;
                        break;
                    }
                    if (i3 == 7) {
                        i2 = 1;
                        break;
                    }
                } else {
                    i3--;
                }
            }
            i2 = 0;
            break;
        }
        if (i2 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
        }
        for (i = 1; i < i2; i++) {
            byte b = this.f6510a[this.b + i];
            if ((b & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
            }
            j = (j << 6) | ((long) (b & Utf8.REPLACEMENT_BYTE));
        }
        this.b += i2;
        return j;
    }

    public String a(int i, Charset charset) {
        String str = new String(this.f6510a, this.b, i, charset);
        this.b += i;
        return str;
    }

    public void a() {
        this.b = 0;
        this.c = 0;
    }

    public void a(int i) {
        a(e() < i ? new byte[i] : this.f6510a, i);
    }

    public void a(o oVar, int i) {
        a(oVar.f6509a, 0, i);
        oVar.a(0);
    }

    public void a(byte[] bArr, int i) {
        this.f6510a = bArr;
        this.c = i;
        this.b = 0;
    }

    public void a(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f6510a, this.b, bArr, i, i2);
        this.b += i2;
    }

    public int b() {
        return this.c - this.b;
    }

    public void b(int i) {
        a.a(i >= 0 && i <= this.f6510a.length);
        this.c = i;
    }

    public int c() {
        return this.c;
    }

    public void c(int i) {
        a.a(i >= 0 && i <= this.c);
        this.b = i;
    }

    public int d() {
        return this.b;
    }

    public void d(int i) {
        c(this.b + i);
    }

    public int e() {
        byte[] bArr = this.f6510a;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public String e(int i) {
        return a(i, Charset.forName("UTF-8"));
    }

    public char f() {
        byte[] bArr = this.f6510a;
        int i = this.b;
        return (char) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public String f(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = (this.b + i) - 1;
        String str = new String(this.f6510a, this.b, (i2 >= this.c || this.f6510a[i2] != 0) ? i : i - 1);
        this.b += i;
        return str;
    }

    public int g() {
        byte[] bArr = this.f6510a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i] & 255;
    }

    public int h() {
        byte[] bArr = this.f6510a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i] & 255) << 8;
        this.b = i + 2;
        return (bArr[i2] & 255) | i3;
    }

    public int i() {
        byte[] bArr = this.f6510a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.b = i + 2;
        return ((bArr[i2] & 255) << 8) | i3;
    }

    public short j() {
        byte[] bArr = this.f6510a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i] & 255) << 8;
        this.b = i + 2;
        return (short) ((bArr[i2] & 255) | i3);
    }

    public int k() {
        byte[] bArr = this.f6510a;
        int i = this.b;
        int i2 = i + 2;
        int i3 = ((bArr[i + 1] & 255) << 8) | ((bArr[i] & 255) << 16);
        this.b = i + 3;
        return (bArr[i2] & 255) | i3;
    }

    public int l() {
        byte[] bArr = this.f6510a;
        int i = this.b;
        int i2 = i + 2;
        int i3 = ((bArr[i + 1] & 255) << 8) | (((bArr[i] & 255) << 24) >> 8);
        this.b = i + 3;
        return (bArr[i2] & 255) | i3;
    }

    public long m() {
        byte[] bArr = this.f6510a;
        int i = this.b;
        int i2 = i + 3;
        long j = ((((long) bArr[i]) & 255) << 24) | ((((long) bArr[i + 1]) & 255) << 16) | ((((long) bArr[i + 2]) & 255) << 8);
        this.b = i + 4;
        return (((long) bArr[i2]) & 255) | j;
    }

    public long n() {
        byte[] bArr = this.f6510a;
        int i = this.b;
        int i2 = i + 3;
        long j = (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16);
        this.b = i + 4;
        return ((((long) bArr[i2]) & 255) << 24) | j;
    }

    public int o() {
        byte[] bArr = this.f6510a;
        int i = this.b;
        int i2 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24);
        int i3 = i + 3;
        int i4 = i2 | ((bArr[i + 2] & 255) << 8);
        this.b = i + 4;
        return (bArr[i3] & 255) | i4;
    }

    public int p() {
        byte[] bArr = this.f6510a;
        int i = this.b;
        int i2 = ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
        int i3 = i + 3;
        int i4 = i2 | ((bArr[i + 2] & 255) << 16);
        this.b = i + 4;
        return ((bArr[i3] & 255) << 24) | i4;
    }

    public long q() {
        byte[] bArr = this.f6510a;
        int i = this.b;
        int i2 = i + 7;
        long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
        this.b = i + 8;
        return (((long) bArr[i2]) & 255) | j;
    }

    public long r() {
        byte[] bArr = this.f6510a;
        int i = this.b;
        int i2 = i + 7;
        long j = (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        this.b = i + 8;
        return ((((long) bArr[i2]) & 255) << 56) | j;
    }

    public int s() {
        byte[] bArr = this.f6510a;
        int i = this.b;
        int i2 = (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
        this.b = i + 4;
        return i2;
    }

    public int t() {
        return (g() << 21) | (g() << 14) | (g() << 7) | g();
    }

    public int u() {
        int iO = o();
        if (iO >= 0) {
            return iO;
        }
        throw new IllegalStateException("Top bit not zero: " + iO);
    }

    public int v() {
        int iP = p();
        if (iP >= 0) {
            return iP;
        }
        throw new IllegalStateException("Top bit not zero: " + iP);
    }

    public long w() {
        long jQ = q();
        if (jQ >= 0) {
            return jQ;
        }
        throw new IllegalStateException("Top bit not zero: " + jQ);
    }

    public double x() {
        return Double.longBitsToDouble(q());
    }

    public String y() {
        if (b() == 0) {
            return null;
        }
        int i = this.b;
        while (i < this.c && this.f6510a[i] != 0) {
            i++;
        }
        byte[] bArr = this.f6510a;
        int i2 = this.b;
        String str = new String(bArr, i2, i - i2);
        this.b = i;
        if (i < this.c) {
            this.b = i + 1;
        }
        return str;
    }

    public String z() {
        if (b() == 0) {
            return null;
        }
        int i = this.b;
        while (i < this.c && !y.a(this.f6510a[i])) {
            i++;
        }
        int i2 = this.b;
        if (i - i2 >= 3) {
            byte[] bArr = this.f6510a;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.b = i2 + 3;
            }
        }
        byte[] bArr2 = this.f6510a;
        int i3 = this.b;
        String str = new String(bArr2, i3, i - i3);
        this.b = i;
        int i4 = this.c;
        if (i == i4) {
            return str;
        }
        byte[] bArr3 = this.f6510a;
        if (bArr3[i] == 13) {
            int i5 = i + 1;
            this.b = i5;
            if (i5 == i4) {
                return str;
            }
        }
        int i6 = this.b;
        if (bArr3[i6] == 10) {
            this.b = i6 + 1;
        }
        return str;
    }
}
