package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TCompactProtocol.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class bo extends bu {
    private static final bz d = new bz("");
    private static final bp e = new bp("", (byte) 0, 0);
    private static final byte[] f = {0, 0, 1, 3, 7, 0, 4, 0, 5, 0, 6, 8, 12, 11, 10, 9};
    private static final byte h = -126;
    private static final byte i = 1;
    private static final byte j = 31;
    private static final byte k = -32;
    private static final int l = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    byte[] f9125a;
    byte[] b;
    byte[] c;
    private at m;
    private short n;
    private bp o;
    private Boolean p;
    private final long q;
    private byte[] r;

    private int c(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    private long c(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    private boolean c(byte b2) {
        int i2 = b2 & 15;
        return i2 == 1 || i2 == 2;
    }

    private long d(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private int g(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void c() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void e() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void f() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void g() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void i() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void m() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void o() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void q() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void s() throws bb {
    }

    /* JADX INFO: compiled from: TCompactProtocol.java */
    public static class a implements bw {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f9126a;

        public a() {
            this.f9126a = -1L;
        }

        public a(int i) {
            this.f9126a = i;
        }

        @Override // com.umeng.analytics.pro.bw
        public bu a(ci ciVar) {
            return new bo(ciVar, this.f9126a);
        }
    }

    /* JADX INFO: compiled from: TCompactProtocol.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final byte f9127a = 1;
        public static final byte b = 2;
        public static final byte c = 3;
        public static final byte d = 4;
        public static final byte e = 5;
        public static final byte f = 6;
        public static final byte g = 7;
        public static final byte h = 8;
        public static final byte i = 9;
        public static final byte j = 10;
        public static final byte k = 11;
        public static final byte l = 12;

        private b() {
        }
    }

    public bo(ci ciVar, long j2) {
        super(ciVar);
        this.m = new at(15);
        this.n = (short) 0;
        this.o = null;
        this.p = null;
        this.f9125a = new byte[5];
        this.b = new byte[10];
        this.r = new byte[1];
        this.c = new byte[1];
        this.q = j2;
    }

    public bo(ci ciVar) {
        this(ciVar, -1L);
    }

    @Override // com.umeng.analytics.pro.bu
    public void B() {
        this.m.c();
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bs bsVar) throws bb {
        b(h);
        d(((bsVar.b << 5) & (-32)) | 1);
        b(bsVar.c);
        a(bsVar.f9131a);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bz bzVar) throws bb {
        this.m.a(this.n);
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.bu
    public void b() throws bb {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bp bpVar) throws bb {
        if (bpVar.b == 2) {
            this.o = bpVar;
        } else {
            a(bpVar, (byte) -1);
        }
    }

    private void a(bp bpVar, byte b2) throws bb {
        if (b2 == -1) {
            b2 = e(bpVar.b);
        }
        if (bpVar.c > this.n && bpVar.c - this.n <= 15) {
            d(b2 | ((bpVar.c - this.n) << 4));
        } else {
            b(b2);
            a(bpVar.c);
        }
        this.n = bpVar.c;
    }

    @Override // com.umeng.analytics.pro.bu
    public void d() throws bb {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(br brVar) throws bb {
        if (brVar.c == 0) {
            d(0);
            return;
        }
        b(brVar.c);
        d(e(brVar.b) | (e(brVar.f9130a) << 4));
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bq bqVar) throws bb {
        a(bqVar.f9129a, bqVar.b);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(by byVar) throws bb {
        a(byVar.f9135a, byVar.b);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(boolean z) throws bb {
        bp bpVar = this.o;
        if (bpVar != null) {
            a(bpVar, z ? (byte) 1 : (byte) 2);
            this.o = null;
        } else {
            b(z ? (byte) 1 : (byte) 2);
        }
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(byte b2) throws bb {
        b(b2);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(short s) throws bb {
        b(c((int) s));
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(int i2) throws bb {
        b(c(i2));
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(long j2) throws bb {
        b(c(j2));
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(double d2) throws bb {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d2), bArr, 0);
        this.g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(String str) throws bb {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bb("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(ByteBuffer byteBuffer) throws bb {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i2, int i3) throws bb {
        b(i3);
        this.g.b(bArr, i2, i3);
    }

    protected void a(byte b2, int i2) throws bb {
        if (i2 <= 14) {
            d(e(b2) | (i2 << 4));
        } else {
            d(e(b2) | 240);
            b(i2);
        }
    }

    private void b(int i2) throws bb {
        int i3 = 0;
        while ((i2 & (-128)) != 0) {
            this.f9125a[i3] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i3++;
        }
        this.f9125a[i3] = (byte) i2;
        this.g.b(this.f9125a, 0, i3 + 1);
    }

    private void b(long j2) throws bb {
        int i2 = 0;
        while (((-128) & j2) != 0) {
            this.b[i2] = (byte) ((127 & j2) | 128);
            j2 >>>= 7;
            i2++;
        }
        this.b[i2] = (byte) j2;
        this.g.b(this.b, 0, i2 + 1);
    }

    private void a(long j2, byte[] bArr, int i2) {
        bArr[i2] = (byte) (j2 & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 24) & 255);
        bArr[i2 + 4] = (byte) ((j2 >> 32) & 255);
        bArr[i2 + 5] = (byte) ((j2 >> 40) & 255);
        bArr[i2 + 6] = (byte) ((j2 >> 48) & 255);
        bArr[i2 + 7] = (byte) ((j2 >> 56) & 255);
    }

    private void b(byte b2) throws bb {
        this.r[0] = b2;
        this.g.b(this.r);
    }

    private void d(int i2) throws bb {
        b((byte) i2);
    }

    @Override // com.umeng.analytics.pro.bu
    public bs h() throws bb {
        byte bU = u();
        if (bU != -126) {
            throw new bv("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(bU));
        }
        byte bU2 = u();
        byte b2 = (byte) (bU2 & 31);
        if (b2 != 1) {
            throw new bv("Expected version 1 but got " + ((int) b2));
        }
        return new bs(z(), (byte) ((bU2 >> 5) & 3), E());
    }

    @Override // com.umeng.analytics.pro.bu
    public bz j() throws bb {
        this.m.a(this.n);
        this.n = (short) 0;
        return d;
    }

    @Override // com.umeng.analytics.pro.bu
    public void k() throws bb {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.bu
    public bp l() throws bb {
        byte bU = u();
        if (bU == 0) {
            return e;
        }
        short s = (short) ((bU & 240) >> 4);
        byte b2 = (byte) (bU & 15);
        bp bpVar = new bp("", d(b2), s == 0 ? v() : (short) (this.n + s));
        if (c(bU)) {
            this.p = b2 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.n = bpVar.c;
        return bpVar;
    }

    @Override // com.umeng.analytics.pro.bu
    public br n() throws bb {
        int iE = E();
        byte bU = iE == 0 ? (byte) 0 : u();
        return new br(d((byte) (bU >> 4)), d((byte) (bU & 15)), iE);
    }

    @Override // com.umeng.analytics.pro.bu
    public bq p() throws bb {
        byte bU = u();
        int iE = (bU >> 4) & 15;
        if (iE == 15) {
            iE = E();
        }
        return new bq(d(bU), iE);
    }

    @Override // com.umeng.analytics.pro.bu
    public by r() throws bb {
        return new by(p());
    }

    @Override // com.umeng.analytics.pro.bu
    public boolean t() throws bb {
        Boolean bool = this.p;
        if (bool == null) {
            return u() == 1;
        }
        boolean zBooleanValue = bool.booleanValue();
        this.p = null;
        return zBooleanValue;
    }

    @Override // com.umeng.analytics.pro.bu
    public byte u() throws bb {
        if (this.g.h() > 0) {
            byte b2 = this.g.f()[this.g.g()];
            this.g.a(1);
            return b2;
        }
        this.g.d(this.c, 0, 1);
        return this.c[0];
    }

    @Override // com.umeng.analytics.pro.bu
    public short v() throws bb {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.bu
    public int w() throws bb {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.bu
    public long x() throws bb {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.bu
    public double y() throws bb {
        byte[] bArr = new byte[8];
        this.g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.bu
    public String z() throws bb {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return "";
        }
        try {
            if (this.g.h() >= iE) {
                String str = new String(this.g.f(), this.g.g(), iE, "UTF-8");
                this.g.a(iE);
                return str;
            }
            return new String(e(iE), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new bb("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.bu
    public ByteBuffer A() throws bb {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[iE];
        this.g.d(bArr, 0, iE);
        return ByteBuffer.wrap(bArr);
    }

    private byte[] e(int i2) throws bb {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        this.g.d(bArr, 0, i2);
        return bArr;
    }

    private void f(int i2) throws bv {
        if (i2 < 0) {
            throw new bv("Negative length: " + i2);
        }
        long j2 = this.q;
        if (j2 != -1 && i2 > j2) {
            throw new bv("Length exceeded max allowed: " + i2);
        }
    }

    private int E() throws bb {
        int i2 = 0;
        if (this.g.h() >= 5) {
            byte[] bArrF = this.g.f();
            int iG = this.g.g();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte b2 = bArrF[iG + i2];
                i3 |= (b2 & 127) << i4;
                if ((b2 & 128) != 128) {
                    this.g.a(i2 + 1);
                    return i3;
                }
                i4 += 7;
                i2++;
            }
        } else {
            int i5 = 0;
            while (true) {
                byte bU = u();
                i2 |= (bU & 127) << i5;
                if ((bU & 128) != 128) {
                    return i2;
                }
                i5 += 7;
            }
        }
    }

    private long F() throws bb {
        int i2 = 0;
        long j2 = 0;
        if (this.g.h() >= 10) {
            byte[] bArrF = this.g.f();
            int iG = this.g.g();
            long j3 = 0;
            int i3 = 0;
            while (true) {
                byte b2 = bArrF[iG + i2];
                j3 |= ((long) (b2 & 127)) << i3;
                if ((b2 & 128) != 128) {
                    this.g.a(i2 + 1);
                    return j3;
                }
                i3 += 7;
                i2++;
            }
        } else {
            while (true) {
                byte bU = u();
                j2 |= ((long) (bU & 127)) << i2;
                if ((bU & 128) != 128) {
                    return j2;
                }
                i2 += 7;
            }
        }
    }

    private long a(byte[] bArr) {
        return ((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48) | ((((long) bArr[5]) & 255) << 40) | ((((long) bArr[4]) & 255) << 32) | ((((long) bArr[3]) & 255) << 24) | ((((long) bArr[2]) & 255) << 16) | ((((long) bArr[1]) & 255) << 8) | (255 & ((long) bArr[0]));
    }

    private byte d(byte b2) throws bv {
        byte b3 = (byte) (b2 & 15);
        switch (b3) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return (byte) 15;
            case 10:
                return (byte) 14;
            case 11:
                return (byte) 13;
            case 12:
                return (byte) 12;
            default:
                throw new bv("don't know what type: " + ((int) b3));
        }
    }

    private byte e(byte b2) {
        return f[b2];
    }
}
