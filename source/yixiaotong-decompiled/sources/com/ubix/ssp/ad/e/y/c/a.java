package com.ubix.ssp.ad.e.y.c;

import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f8935a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int h;
    private int g = Integer.MAX_VALUE;
    private int i = 64;
    private int j = 67108864;

    private a(byte[] bArr, int i, int i2) {
        this.f8935a = bArr;
        this.b = i;
        this.c = i2 + i;
        this.e = i;
    }

    public static long a(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static a a(byte[] bArr, int i, int i2) {
        return new a(bArr, i, i2);
    }

    public static int b(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    private void z() {
        int i = this.c + this.d;
        this.c = i;
        int i2 = this.g;
        if (i <= i2) {
            this.d = 0;
            return;
        }
        int i3 = i - i2;
        this.d = i3;
        this.c = i - i3;
    }

    public void A() throws d {
        int iW;
        do {
            iW = w();
            if (iW == 0) {
                return;
            }
        } while (h(iW));
    }

    public int a() {
        int i = this.g;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - this.e;
    }

    public void a(int i) throws d {
        if (this.f != i) {
            throw d.a();
        }
    }

    public void a(f fVar) throws d {
        int iP = p();
        if (this.h >= this.i) {
            throw d.f();
        }
        int iD = d(iP);
        this.h++;
        fVar.a(this);
        a(0);
        this.h--;
        c(iD);
    }

    public int b() {
        return this.e - this.b;
    }

    public void c(int i) {
        this.g = i;
        z();
    }

    public boolean c() {
        return this.e == this.c;
    }

    public int d(int i) throws d {
        if (i < 0) {
            throw d.e();
        }
        int i2 = i + this.e;
        int i3 = this.g;
        if (i2 > i3) {
            throw d.g();
        }
        this.g = i2;
        z();
        return i3;
    }

    public boolean d() {
        return p() != 0;
    }

    Object e(int i) {
        switch (i) {
            case 1:
                return Double.valueOf(f());
            case 2:
                return Float.valueOf(j());
            case 3:
                return Long.valueOf(l());
            case 4:
                return Long.valueOf(y());
            case 5:
                return Integer.valueOf(k());
            case 6:
                return Long.valueOf(i());
            case 7:
                return Integer.valueOf(h());
            case 8:
                return Boolean.valueOf(d());
            case 9:
                return v();
            case 10:
            case 11:
            default:
                throw new IllegalArgumentException("Unknown type " + i);
            case 12:
                return e();
            case 13:
                return Integer.valueOf(x());
            case 14:
                return Integer.valueOf(g());
            case 15:
                return Integer.valueOf(r());
            case 16:
                return Long.valueOf(s());
            case 17:
                return Integer.valueOf(t());
            case 18:
                return Long.valueOf(u());
        }
    }

    public byte[] e() throws d {
        int iP = p();
        int i = this.c;
        int i2 = this.e;
        if (iP > i - i2 || iP <= 0) {
            return iP == 0 ? h.h : f(iP);
        }
        byte[] bArr = new byte[iP];
        System.arraycopy(this.f8935a, i2, bArr, 0, iP);
        this.e += iP;
        return bArr;
    }

    public double f() {
        return Double.longBitsToDouble(o());
    }

    public byte[] f(int i) throws d {
        if (i < 0) {
            throw d.e();
        }
        int i2 = this.e;
        int i3 = i2 + i;
        int i4 = this.g;
        if (i3 > i4) {
            i(i4 - i2);
            throw d.g();
        }
        if (i > this.c - i2) {
            throw d.g();
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.f8935a, i2, bArr, 0, i);
        this.e += i;
        return bArr;
    }

    public int g() {
        return p();
    }

    public void g(int i) {
        int i2 = this.e;
        int i3 = this.b;
        if (i > i2 - i3) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.e - this.b));
        }
        if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        }
        this.e = i3 + i;
    }

    public int h() {
        return n();
    }

    public boolean h(int i) throws d {
        int iB = h.b(i);
        if (iB == 0) {
            k();
            return true;
        }
        if (iB == 1) {
            o();
            return true;
        }
        if (iB == 2) {
            i(p());
            return true;
        }
        if (iB == 3) {
            A();
            a(h.a(h.a(i), 4));
            return true;
        }
        if (iB == 4) {
            return false;
        }
        if (iB != 5) {
            throw d.c();
        }
        n();
        return true;
    }

    public long i() {
        return o();
    }

    public void i(int i) throws d {
        if (i < 0) {
            throw d.e();
        }
        int i2 = this.e;
        int i3 = i2 + i;
        int i4 = this.g;
        if (i3 > i4) {
            i(i4 - i2);
            throw d.g();
        }
        if (i > this.c - i2) {
            throw d.g();
        }
        this.e = i3;
    }

    public float j() {
        return Float.intBitsToFloat(n());
    }

    public int k() {
        return p();
    }

    public long l() {
        return q();
    }

    public byte m() throws d {
        int i = this.e;
        if (i == this.c) {
            throw d.g();
        }
        byte[] bArr = this.f8935a;
        this.e = i + 1;
        return bArr[i];
    }

    public int n() throws d {
        return (m() & 255) | ((m() & 255) << 8) | ((m() & 255) << 16) | ((m() & 255) << 24);
    }

    public long o() throws d {
        byte bM = m();
        return ((((long) m()) & 255) << 8) | (((long) bM) & 255) | ((((long) m()) & 255) << 16) | ((((long) m()) & 255) << 24) | ((((long) m()) & 255) << 32) | ((((long) m()) & 255) << 40) | ((((long) m()) & 255) << 48) | ((((long) m()) & 255) << 56);
    }

    public int p() throws d {
        int i;
        byte bM = m();
        if (bM >= 0) {
            return bM;
        }
        int i2 = bM & 127;
        byte bM2 = m();
        if (bM2 >= 0) {
            i = bM2 << 7;
        } else {
            i2 |= (bM2 & 127) << 7;
            byte bM3 = m();
            if (bM3 >= 0) {
                i = bM3 << 14;
            } else {
                i2 |= (bM3 & 127) << 14;
                byte bM4 = m();
                if (bM4 < 0) {
                    int i3 = i2 | ((bM4 & 127) << 21);
                    byte bM5 = m();
                    int i4 = i3 | (bM5 << Ascii.FS);
                    if (bM5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        if (m() >= 0) {
                            return i4;
                        }
                    }
                    throw d.d();
                }
                i = bM4 << Ascii.NAK;
            }
        }
        return i2 | i;
    }

    public long q() throws d {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bM = m();
            j |= ((long) (bM & 127)) << i;
            if ((bM & 128) == 0) {
                return j;
            }
        }
        throw d.d();
    }

    public int r() {
        return n();
    }

    public long s() {
        return o();
    }

    public int t() {
        return b(p());
    }

    public long u() {
        return a(q());
    }

    public String v() throws d {
        int iP = p();
        if (iP > this.c - this.e || iP <= 0) {
            return new String(f(iP), c.f8937a);
        }
        String str = new String(this.f8935a, this.e, iP, c.f8937a);
        this.e += iP;
        return str;
    }

    public int w() throws d {
        if (c()) {
            this.f = 0;
            return 0;
        }
        int iP = p();
        this.f = iP;
        if (iP != 0) {
            return iP;
        }
        throw d.b();
    }

    public int x() {
        return p();
    }

    public long y() {
        return q();
    }
}
