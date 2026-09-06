package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TBinaryProtocol.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class bn extends bu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final int f9123a = -65536;
    protected static final int b = -2147418112;
    private static final bz h = new bz();
    protected boolean c;
    protected boolean d;
    protected int e;
    protected boolean f;
    private byte[] i;
    private byte[] j;
    private byte[] k;
    private byte[] l;
    private byte[] m;
    private byte[] n;
    private byte[] o;
    private byte[] p;

    @Override // com.umeng.analytics.pro.bu
    public void a() {
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bz bzVar) {
    }

    @Override // com.umeng.analytics.pro.bu
    public void b() {
    }

    @Override // com.umeng.analytics.pro.bu
    public void c() {
    }

    public void c(int i) {
        this.e = i;
        this.f = true;
    }

    @Override // com.umeng.analytics.pro.bu
    public void e() {
    }

    @Override // com.umeng.analytics.pro.bu
    public void f() {
    }

    @Override // com.umeng.analytics.pro.bu
    public void g() {
    }

    @Override // com.umeng.analytics.pro.bu
    public void i() {
    }

    @Override // com.umeng.analytics.pro.bu
    public bz j() {
        return h;
    }

    @Override // com.umeng.analytics.pro.bu
    public void k() {
    }

    @Override // com.umeng.analytics.pro.bu
    public void m() {
    }

    @Override // com.umeng.analytics.pro.bu
    public void o() {
    }

    @Override // com.umeng.analytics.pro.bu
    public void q() {
    }

    @Override // com.umeng.analytics.pro.bu
    public void s() {
    }

    /* JADX INFO: compiled from: TBinaryProtocol.java */
    public static class a implements bw {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected boolean f9124a;
        protected boolean b;
        protected int c;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.f9124a = z;
            this.b = z2;
            this.c = i;
        }

        @Override // com.umeng.analytics.pro.bw
        public bu a(ci ciVar) {
            bn bnVar = new bn(ciVar, this.f9124a, this.b);
            int i = this.c;
            if (i != 0) {
                bnVar.c(i);
            }
            return bnVar;
        }
    }

    public bn(ci ciVar) {
        this(ciVar, false, true);
    }

    public bn(ci ciVar, boolean z, boolean z2) {
        super(ciVar);
        this.f = false;
        this.i = new byte[1];
        this.j = new byte[2];
        this.k = new byte[4];
        this.l = new byte[8];
        this.m = new byte[1];
        this.n = new byte[2];
        this.o = new byte[4];
        this.p = new byte[8];
        this.c = z;
        this.d = z2;
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bs bsVar) throws bb {
        if (this.d) {
            a(b | bsVar.b);
            a(bsVar.f9131a);
            a(bsVar.c);
        } else {
            a(bsVar.f9131a);
            a(bsVar.b);
            a(bsVar.c);
        }
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bp bpVar) throws bb {
        a(bpVar.b);
        a(bpVar.c);
    }

    @Override // com.umeng.analytics.pro.bu
    public void d() throws bb {
        a((byte) 0);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(br brVar) throws bb {
        a(brVar.f9130a);
        a(brVar.b);
        a(brVar.c);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bq bqVar) throws bb {
        a(bqVar.f9129a);
        a(bqVar.b);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(by byVar) throws bb {
        a(byVar.f9135a);
        a(byVar.b);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(boolean z) throws bb {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(byte b2) throws bb {
        this.i[0] = b2;
        this.g.b(this.i, 0, 1);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(short s) throws bb {
        byte[] bArr = this.j;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.g.b(this.j, 0, 2);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(int i) throws bb {
        byte[] bArr = this.k;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        this.g.b(this.k, 0, 4);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(long j) throws bb {
        byte[] bArr = this.l;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        this.g.b(this.l, 0, 8);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(double d) throws bb {
        a(Double.doubleToLongBits(d));
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(String str) throws bb {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bb("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(ByteBuffer byteBuffer) throws bb {
        int iLimit = byteBuffer.limit() - byteBuffer.position();
        a(iLimit);
        this.g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), iLimit);
    }

    @Override // com.umeng.analytics.pro.bu
    public bs h() throws bb {
        int iW = w();
        if (iW < 0) {
            if (((-65536) & iW) != b) {
                throw new bv(4, "Bad version in readMessageBegin");
            }
            return new bs(z(), (byte) (iW & 255), w());
        }
        if (this.c) {
            throw new bv(4, "Missing version in readMessageBegin, old client?");
        }
        return new bs(b(iW), u(), w());
    }

    @Override // com.umeng.analytics.pro.bu
    public bp l() throws bb {
        byte bU = u();
        return new bp("", bU, bU == 0 ? (short) 0 : v());
    }

    @Override // com.umeng.analytics.pro.bu
    public br n() throws bb {
        return new br(u(), u(), w());
    }

    @Override // com.umeng.analytics.pro.bu
    public bq p() throws bb {
        return new bq(u(), w());
    }

    @Override // com.umeng.analytics.pro.bu
    public by r() throws bb {
        return new by(u(), w());
    }

    @Override // com.umeng.analytics.pro.bu
    public boolean t() throws bb {
        return u() == 1;
    }

    @Override // com.umeng.analytics.pro.bu
    public byte u() throws bb {
        if (this.g.h() >= 1) {
            byte b2 = this.g.f()[this.g.g()];
            this.g.a(1);
            return b2;
        }
        a(this.m, 0, 1);
        return this.m[0];
    }

    @Override // com.umeng.analytics.pro.bu
    public short v() throws bb {
        int iG;
        byte[] bArrF = this.n;
        if (this.g.h() >= 2) {
            bArrF = this.g.f();
            iG = this.g.g();
            this.g.a(2);
        } else {
            a(this.n, 0, 2);
            iG = 0;
        }
        return (short) ((bArrF[iG + 1] & 255) | ((bArrF[iG] & 255) << 8));
    }

    @Override // com.umeng.analytics.pro.bu
    public int w() throws bb {
        int iG;
        byte[] bArrF = this.o;
        if (this.g.h() >= 4) {
            bArrF = this.g.f();
            iG = this.g.g();
            this.g.a(4);
        } else {
            a(this.o, 0, 4);
            iG = 0;
        }
        return (bArrF[iG + 3] & 255) | ((bArrF[iG] & 255) << 24) | ((bArrF[iG + 1] & 255) << 16) | ((bArrF[iG + 2] & 255) << 8);
    }

    @Override // com.umeng.analytics.pro.bu
    public long x() throws bb {
        int iG;
        byte[] bArrF = this.p;
        if (this.g.h() >= 8) {
            bArrF = this.g.f();
            iG = this.g.g();
            this.g.a(8);
        } else {
            a(this.p, 0, 8);
            iG = 0;
        }
        return ((long) (bArrF[iG + 7] & 255)) | (((long) (bArrF[iG] & 255)) << 56) | (((long) (bArrF[iG + 1] & 255)) << 48) | (((long) (bArrF[iG + 2] & 255)) << 40) | (((long) (bArrF[iG + 3] & 255)) << 32) | (((long) (bArrF[iG + 4] & 255)) << 24) | (((long) (bArrF[iG + 5] & 255)) << 16) | (((long) (bArrF[iG + 6] & 255)) << 8);
    }

    @Override // com.umeng.analytics.pro.bu
    public double y() throws bb {
        return Double.longBitsToDouble(x());
    }

    @Override // com.umeng.analytics.pro.bu
    public String z() throws bb {
        int iW = w();
        if (this.g.h() >= iW) {
            try {
                String str = new String(this.g.f(), this.g.g(), iW, "UTF-8");
                this.g.a(iW);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new bb("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return b(iW);
    }

    public String b(int i) throws bb {
        try {
            d(i);
            byte[] bArr = new byte[i];
            this.g.d(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new bb("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.bu
    public ByteBuffer A() throws bb {
        int iW = w();
        d(iW);
        if (this.g.h() >= iW) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.g.f(), this.g.g(), iW);
            this.g.a(iW);
            return byteBufferWrap;
        }
        byte[] bArr = new byte[iW];
        this.g.d(bArr, 0, iW);
        return ByteBuffer.wrap(bArr);
    }

    private int a(byte[] bArr, int i, int i2) throws bb {
        d(i2);
        return this.g.d(bArr, i, i2);
    }

    protected void d(int i) throws bb {
        if (i < 0) {
            throw new bv("Negative length: " + i);
        }
        if (this.f) {
            int i2 = this.e - i;
            this.e = i2;
            if (i2 < 0) {
                throw new bv("Message length exceeded: " + i);
            }
        }
    }
}
