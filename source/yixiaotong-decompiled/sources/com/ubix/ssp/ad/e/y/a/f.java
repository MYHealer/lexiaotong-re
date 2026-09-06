package com.ubix.ssp.ad.e.y.a;

import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.facebook.imageutils.JfifUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class f extends com.ubix.ssp.ad.e.y.c.f {
    public String A;
    public String[] B;
    public String C;
    public String D;
    public c E;
    public String[] F;
    public String[] G;
    public float H;
    public String I;
    public String J;
    public a[] K;
    public int L;
    public boolean M;
    public int N;
    public String O;
    public b b;
    public int c;
    public int d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public int k;
    public i l;
    public float m;
    public String n;
    public int o;
    public String p;
    public int q;
    public String r;
    public String s;
    public int t;
    public long u;
    public long v;
    public int w;
    public int x;
    public String y;
    public String z;

    public static final class a extends com.ubix.ssp.ad.e.y.c.f {
        private static volatile a[] b;
        public String c;
        public int d;

        public a() {
            e();
        }

        public static a[] f() {
            if (b == null) {
                synchronized (com.ubix.ssp.ad.e.y.c.c.c) {
                    if (b == null) {
                        b = new a[0];
                    }
                }
            }
            return b;
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
            if (!this.c.equals("")) {
                bVar.b(1, this.c);
            }
            int i = this.d;
            if (i != 0) {
                bVar.i(2, i);
            }
            super.a(bVar);
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        protected int b() {
            int iB = super.b();
            if (!this.c.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(1, this.c);
            }
            int i = this.d;
            return i != 0 ? iB + com.ubix.ssp.ad.e.y.c.b.c(2, i) : iB;
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
            while (true) {
                int iW = aVar.w();
                if (iW == 0) {
                    return this;
                }
                if (iW == 10) {
                    this.c = aVar.v();
                } else if (iW == 16) {
                    this.d = aVar.k();
                } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                    return this;
                }
            }
        }

        public a e() {
            this.c = "";
            this.d = 0;
            this.f8939a = -1;
            return this;
        }
    }

    public static final class b extends com.ubix.ssp.ad.e.y.c.f {
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;

        public b() {
            e();
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
            if (!this.b.equals("")) {
                bVar.b(1, this.b);
            }
            if (!this.c.equals("")) {
                bVar.b(2, this.c);
            }
            if (!this.d.equals("")) {
                bVar.b(3, this.d);
            }
            if (!this.e.equals("")) {
                bVar.b(4, this.e);
            }
            if (!this.f.equals("")) {
                bVar.b(5, this.f);
            }
            if (!this.g.equals("")) {
                bVar.b(6, this.g);
            }
            if (!this.h.equals("")) {
                bVar.b(7, this.h);
            }
            if (!this.i.equals("")) {
                bVar.b(8, this.i);
            }
            if (!this.j.equals("")) {
                bVar.b(9, this.j);
            }
            if (!this.k.equals("")) {
                bVar.b(10, this.k);
            }
            if (!this.l.equals("")) {
                bVar.b(11, this.l);
            }
            if (!this.m.equals("")) {
                bVar.b(12, this.m);
            }
            if (!this.n.equals("")) {
                bVar.b(14, this.n);
            }
            if (!this.o.equals("")) {
                bVar.b(15, this.o);
            }
            if (!this.p.equals("")) {
                bVar.b(16, this.p);
            }
            if (!this.q.equals("")) {
                bVar.b(17, this.q);
            }
            super.a(bVar);
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        protected int b() {
            int iB = super.b();
            if (!this.b.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(1, this.b);
            }
            if (!this.c.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(2, this.c);
            }
            if (!this.d.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(3, this.d);
            }
            if (!this.e.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(4, this.e);
            }
            if (!this.f.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(5, this.f);
            }
            if (!this.g.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(6, this.g);
            }
            if (!this.h.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(7, this.h);
            }
            if (!this.i.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(8, this.i);
            }
            if (!this.j.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(9, this.j);
            }
            if (!this.k.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(10, this.k);
            }
            if (!this.l.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(11, this.l);
            }
            if (!this.m.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(12, this.m);
            }
            if (!this.n.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(14, this.n);
            }
            if (!this.o.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(15, this.o);
            }
            if (!this.p.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(16, this.p);
            }
            return !this.q.equals("") ? iB + com.ubix.ssp.ad.e.y.c.b.a(17, this.q) : iB;
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
            while (true) {
                int iW = aVar.w();
                switch (iW) {
                    case 0:
                        return this;
                    case 10:
                        this.b = aVar.v();
                        break;
                    case 18:
                        this.c = aVar.v();
                        break;
                    case 26:
                        this.d = aVar.v();
                        break;
                    case 34:
                        this.e = aVar.v();
                        break;
                    case 42:
                        this.f = aVar.v();
                        break;
                    case 50:
                        this.g = aVar.v();
                        break;
                    case 58:
                        this.h = aVar.v();
                        break;
                    case 66:
                        this.i = aVar.v();
                        break;
                    case 74:
                        this.j = aVar.v();
                        break;
                    case 82:
                        this.k = aVar.v();
                        break;
                    case 90:
                        this.l = aVar.v();
                        break;
                    case 98:
                        this.m = aVar.v();
                        break;
                    case 114:
                        this.n = aVar.v();
                        break;
                    case 122:
                        this.o = aVar.v();
                        break;
                    case 130:
                        this.p = aVar.v();
                        break;
                    case 138:
                        this.q = aVar.v();
                        break;
                    default:
                        if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                            return this;
                        }
                        break;
                        break;
                }
            }
        }

        public b e() {
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = "";
            this.g = "";
            this.h = "";
            this.i = "";
            this.j = "";
            this.k = "";
            this.l = "";
            this.m = "";
            this.n = "";
            this.o = "";
            this.p = "";
            this.q = "";
            this.f8939a = -1;
            return this;
        }
    }

    public static final class c extends com.ubix.ssp.ad.e.y.c.f {
        public String b;
        public String c;
        public long d;
        public long e;
        public String f;
        public String g;
        public String h;

        public c() {
            e();
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
            if (!this.b.equals("")) {
                bVar.b(1, this.b);
            }
            if (!this.c.equals("")) {
                bVar.b(2, this.c);
            }
            long j = this.d;
            if (j != 0) {
                bVar.g(3, j);
            }
            long j2 = this.e;
            if (j2 != 0) {
                bVar.g(4, j2);
            }
            if (!this.f.equals("")) {
                bVar.b(5, this.f);
            }
            if (!this.g.equals("")) {
                bVar.b(6, this.g);
            }
            if (!this.h.equals("")) {
                bVar.b(7, this.h);
            }
            super.a(bVar);
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        protected int b() {
            int iB = super.b();
            if (!this.b.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(1, this.b);
            }
            if (!this.c.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(2, this.c);
            }
            long j = this.d;
            if (j != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.b(3, j);
            }
            long j2 = this.e;
            if (j2 != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.b(4, j2);
            }
            if (!this.f.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(5, this.f);
            }
            if (!this.g.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(6, this.g);
            }
            return !this.h.equals("") ? iB + com.ubix.ssp.ad.e.y.c.b.a(7, this.h) : iB;
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
            while (true) {
                int iW = aVar.w();
                if (iW == 0) {
                    return this;
                }
                if (iW == 10) {
                    this.b = aVar.v();
                } else if (iW == 18) {
                    this.c = aVar.v();
                } else if (iW == 24) {
                    this.d = aVar.l();
                } else if (iW == 32) {
                    this.e = aVar.l();
                } else if (iW == 42) {
                    this.f = aVar.v();
                } else if (iW == 50) {
                    this.g = aVar.v();
                } else if (iW == 58) {
                    this.h = aVar.v();
                } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                    return this;
                }
            }
        }

        public c e() {
            this.b = "";
            this.c = "";
            this.d = 0L;
            this.e = 0L;
            this.f = "";
            this.g = "";
            this.h = "";
            this.f8939a = -1;
            return this;
        }
    }

    public f() {
        e();
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
        b bVar2 = this.b;
        if (bVar2 != null) {
            bVar.d(1, bVar2);
        }
        int i = this.c;
        if (i != 0) {
            bVar.i(2, i);
        }
        int i2 = this.d;
        if (i2 != 0) {
            bVar.i(3, i2);
        }
        if (!this.e.equals("")) {
            bVar.b(4, this.e);
        }
        if (!this.f.equals("")) {
            bVar.b(5, this.f);
        }
        if (!this.g.equals("")) {
            bVar.b(6, this.g);
        }
        if (!this.h.equals("")) {
            bVar.b(7, this.h);
        }
        if (!this.i.equals("")) {
            bVar.b(8, this.i);
        }
        if (!this.j.equals("")) {
            bVar.b(9, this.j);
        }
        int i3 = this.k;
        if (i3 != 0) {
            bVar.i(10, i3);
        }
        i iVar = this.l;
        if (iVar != null) {
            bVar.d(11, iVar);
        }
        if (Float.floatToIntBits(this.m) != Float.floatToIntBits(0.0f)) {
            bVar.b(12, this.m);
        }
        if (!this.n.equals("")) {
            bVar.b(13, this.n);
        }
        int i4 = this.o;
        if (i4 != 0) {
            bVar.i(14, i4);
        }
        if (!this.p.equals("")) {
            bVar.b(15, this.p);
        }
        int i5 = this.q;
        if (i5 != 0) {
            bVar.i(16, i5);
        }
        if (!this.r.equals("")) {
            bVar.b(18, this.r);
        }
        if (!this.s.equals("")) {
            bVar.b(19, this.s);
        }
        int i6 = this.t;
        if (i6 != 0) {
            bVar.i(20, i6);
        }
        long j = this.u;
        if (j != 0) {
            bVar.g(21, j);
        }
        long j2 = this.v;
        if (j2 != 0) {
            bVar.g(22, j2);
        }
        int i7 = this.w;
        if (i7 != 0) {
            bVar.i(23, i7);
        }
        int i8 = this.x;
        if (i8 != 0) {
            bVar.i(24, i8);
        }
        if (!this.y.equals("")) {
            bVar.b(25, this.y);
        }
        if (!this.z.equals("")) {
            bVar.b(26, this.z);
        }
        if (!this.A.equals("")) {
            bVar.b(27, this.A);
        }
        String[] strArr = this.B;
        int i9 = 0;
        if (strArr != null && strArr.length > 0) {
            int i10 = 0;
            while (true) {
                String[] strArr2 = this.B;
                if (i10 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i10];
                if (str != null) {
                    bVar.b(28, str);
                }
                i10++;
            }
        }
        if (!this.C.equals("")) {
            bVar.b(29, this.C);
        }
        if (!this.D.equals("")) {
            bVar.b(30, this.D);
        }
        c cVar = this.E;
        if (cVar != null) {
            bVar.d(31, cVar);
        }
        String[] strArr3 = this.F;
        if (strArr3 != null && strArr3.length > 0) {
            int i11 = 0;
            while (true) {
                String[] strArr4 = this.F;
                if (i11 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i11];
                if (str2 != null) {
                    bVar.b(32, str2);
                }
                i11++;
            }
        }
        String[] strArr5 = this.G;
        if (strArr5 != null && strArr5.length > 0) {
            int i12 = 0;
            while (true) {
                String[] strArr6 = this.G;
                if (i12 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i12];
                if (str3 != null) {
                    bVar.b(33, str3);
                }
                i12++;
            }
        }
        if (Float.floatToIntBits(this.H) != Float.floatToIntBits(0.0f)) {
            bVar.b(34, this.H);
        }
        if (!this.I.equals("")) {
            bVar.b(35, this.I);
        }
        if (!this.J.equals("")) {
            bVar.b(36, this.J);
        }
        a[] aVarArr = this.K;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.K;
                if (i9 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i9];
                if (aVar != null) {
                    bVar.d(37, aVar);
                }
                i9++;
            }
        }
        int i13 = this.L;
        if (i13 != 0) {
            bVar.i(38, i13);
        }
        boolean z = this.M;
        if (z) {
            bVar.b(39, z);
        }
        int i14 = this.N;
        if (i14 != 0) {
            bVar.i(40, i14);
        }
        if (!this.O.equals("")) {
            bVar.b(41, this.O);
        }
        super.a(bVar);
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    protected int b() {
        int iB = super.b();
        b bVar = this.b;
        if (bVar != null) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(1, bVar);
        }
        int i = this.c;
        if (i != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(2, i);
        }
        int i2 = this.d;
        if (i2 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(3, i2);
        }
        if (!this.e.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(4, this.e);
        }
        if (!this.f.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(5, this.f);
        }
        if (!this.g.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(6, this.g);
        }
        if (!this.h.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(7, this.h);
        }
        if (!this.i.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(8, this.i);
        }
        if (!this.j.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(9, this.j);
        }
        int i3 = this.k;
        if (i3 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(10, i3);
        }
        i iVar = this.l;
        if (iVar != null) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(11, iVar);
        }
        if (Float.floatToIntBits(this.m) != Float.floatToIntBits(0.0f)) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(12, this.m);
        }
        if (!this.n.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(13, this.n);
        }
        int i4 = this.o;
        if (i4 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(14, i4);
        }
        if (!this.p.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(15, this.p);
        }
        int i5 = this.q;
        if (i5 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(16, i5);
        }
        if (!this.r.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(18, this.r);
        }
        if (!this.s.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(19, this.s);
        }
        int i6 = this.t;
        if (i6 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(20, i6);
        }
        long j = this.u;
        if (j != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(21, j);
        }
        long j2 = this.v;
        if (j2 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(22, j2);
        }
        int i7 = this.w;
        if (i7 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(23, i7);
        }
        int i8 = this.x;
        if (i8 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(24, i8);
        }
        if (!this.y.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(25, this.y);
        }
        if (!this.z.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(26, this.z);
        }
        if (!this.A.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(27, this.A);
        }
        String[] strArr = this.B;
        int i9 = 0;
        if (strArr != null && strArr.length > 0) {
            int i10 = 0;
            int iA = 0;
            int i11 = 0;
            while (true) {
                String[] strArr2 = this.B;
                if (i10 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i10];
                if (str != null) {
                    i11++;
                    iA += com.ubix.ssp.ad.e.y.c.b.a(str);
                }
                i10++;
            }
            iB = iB + iA + (i11 * 2);
        }
        if (!this.C.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(29, this.C);
        }
        if (!this.D.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(30, this.D);
        }
        c cVar = this.E;
        if (cVar != null) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(31, cVar);
        }
        String[] strArr3 = this.F;
        if (strArr3 != null && strArr3.length > 0) {
            int i12 = 0;
            int iA2 = 0;
            int i13 = 0;
            while (true) {
                String[] strArr4 = this.F;
                if (i12 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i12];
                if (str2 != null) {
                    i13++;
                    iA2 += com.ubix.ssp.ad.e.y.c.b.a(str2);
                }
                i12++;
            }
            iB = iB + iA2 + (i13 * 2);
        }
        String[] strArr5 = this.G;
        if (strArr5 != null && strArr5.length > 0) {
            int i14 = 0;
            int iA3 = 0;
            int i15 = 0;
            while (true) {
                String[] strArr6 = this.G;
                if (i14 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i14];
                if (str3 != null) {
                    i15++;
                    iA3 += com.ubix.ssp.ad.e.y.c.b.a(str3);
                }
                i14++;
            }
            iB = iB + iA3 + (i15 * 2);
        }
        if (Float.floatToIntBits(this.H) != Float.floatToIntBits(0.0f)) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(34, this.H);
        }
        if (!this.I.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(35, this.I);
        }
        if (!this.J.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(36, this.J);
        }
        a[] aVarArr = this.K;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.K;
                if (i9 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i9];
                if (aVar != null) {
                    iB += com.ubix.ssp.ad.e.y.c.b.b(37, aVar);
                }
                i9++;
            }
        }
        int i16 = this.L;
        if (i16 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(38, i16);
        }
        boolean z = this.M;
        if (z) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(39, z);
        }
        int i17 = this.N;
        if (i17 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(40, i17);
        }
        return !this.O.equals("") ? iB + com.ubix.ssp.ad.e.y.c.b.a(41, this.O) : iB;
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public f a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
        com.ubix.ssp.ad.e.y.c.f fVar;
        while (true) {
            int iW = aVar.w();
            switch (iW) {
                case 0:
                    return this;
                case 10:
                    if (this.b == null) {
                        this.b = new b();
                    }
                    fVar = this.b;
                    break;
                case 16:
                    this.c = aVar.k();
                    continue;
                case 24:
                    this.d = aVar.k();
                    continue;
                case 34:
                    this.e = aVar.v();
                    continue;
                case 42:
                    this.f = aVar.v();
                    continue;
                case 50:
                    this.g = aVar.v();
                    continue;
                case 58:
                    this.h = aVar.v();
                    continue;
                case 66:
                    this.i = aVar.v();
                    continue;
                case 74:
                    this.j = aVar.v();
                    continue;
                case 80:
                    this.k = aVar.k();
                    continue;
                case 90:
                    if (this.l == null) {
                        this.l = new i();
                    }
                    fVar = this.l;
                    break;
                case 101:
                    this.m = aVar.j();
                    continue;
                case 106:
                    this.n = aVar.v();
                    continue;
                case 112:
                    this.o = aVar.k();
                    continue;
                case 122:
                    this.p = aVar.v();
                    continue;
                case 128:
                    this.q = aVar.k();
                    continue;
                case 146:
                    this.r = aVar.v();
                    continue;
                case 154:
                    this.s = aVar.v();
                    continue;
                case 160:
                    this.t = aVar.k();
                    continue;
                case Opcodes.JSR /* 168 */:
                    this.u = aVar.l();
                    continue;
                case 176:
                    this.v = aVar.l();
                    continue;
                case 184:
                    this.w = aVar.k();
                    continue;
                case 192:
                    this.x = aVar.k();
                    continue;
                case 202:
                    this.y = aVar.v();
                    continue;
                case 210:
                    this.z = aVar.v();
                    continue;
                case JfifUtil.MARKER_SOS /* 218 */:
                    this.A = aVar.v();
                    continue;
                case 226:
                    int iA = com.ubix.ssp.ad.e.y.c.h.a(aVar, 226);
                    String[] strArr = this.B;
                    int length = strArr == null ? 0 : strArr.length;
                    int i = iA + length;
                    String[] strArr2 = new String[i];
                    if (length != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length);
                    }
                    while (length < i - 1) {
                        strArr2[length] = aVar.v();
                        aVar.w();
                        length++;
                    }
                    strArr2[length] = aVar.v();
                    this.B = strArr2;
                    continue;
                case 234:
                    this.C = aVar.v();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE /* 242 */:
                    this.D = aVar.v();
                    continue;
                case 250:
                    if (this.E == null) {
                        this.E = new c();
                    }
                    fVar = this.E;
                    break;
                case 258:
                    int iA2 = com.ubix.ssp.ad.e.y.c.h.a(aVar, 258);
                    String[] strArr3 = this.F;
                    int length2 = strArr3 == null ? 0 : strArr3.length;
                    int i2 = iA2 + length2;
                    String[] strArr4 = new String[i2];
                    if (length2 != 0) {
                        System.arraycopy(strArr3, 0, strArr4, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        strArr4[length2] = aVar.v();
                        aVar.w();
                        length2++;
                    }
                    strArr4[length2] = aVar.v();
                    this.F = strArr4;
                    continue;
                case 266:
                    int iA3 = com.ubix.ssp.ad.e.y.c.h.a(aVar, 266);
                    String[] strArr5 = this.G;
                    int length3 = strArr5 == null ? 0 : strArr5.length;
                    int i3 = iA3 + length3;
                    String[] strArr6 = new String[i3];
                    if (length3 != 0) {
                        System.arraycopy(strArr5, 0, strArr6, 0, length3);
                    }
                    while (length3 < i3 - 1) {
                        strArr6[length3] = aVar.v();
                        aVar.w();
                        length3++;
                    }
                    strArr6[length3] = aVar.v();
                    this.G = strArr6;
                    continue;
                case 277:
                    this.H = aVar.j();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS /* 282 */:
                    this.I = aVar.v();
                    continue;
                case 290:
                    this.J = aVar.v();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX /* 298 */:
                    int iA4 = com.ubix.ssp.ad.e.y.c.h.a(aVar, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX);
                    a[] aVarArr = this.K;
                    int length4 = aVarArr == null ? 0 : aVarArr.length;
                    int i4 = iA4 + length4;
                    a[] aVarArr2 = new a[i4];
                    if (length4 != 0) {
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length4);
                    }
                    while (length4 < i4 - 1) {
                        a aVar2 = new a();
                        aVarArr2[length4] = aVar2;
                        aVar.a(aVar2);
                        aVar.w();
                        length4++;
                    }
                    a aVar3 = new a();
                    aVarArr2[length4] = aVar3;
                    aVar.a(aVar3);
                    this.K = aVarArr2;
                    continue;
                case 304:
                    this.L = aVar.k();
                    continue;
                case 312:
                    this.M = aVar.d();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME /* 320 */:
                    this.N = aVar.k();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_OPEN_VIDEO_FIRST /* 330 */:
                    this.O = aVar.v();
                    continue;
                default:
                    if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                        return this;
                    }
                    continue;
                    break;
            }
            aVar.a(fVar);
        }
    }

    public f e() {
        this.b = null;
        this.c = 0;
        this.d = 0;
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = 0;
        this.l = null;
        this.m = 0.0f;
        this.n = "";
        this.o = 0;
        this.p = "";
        this.q = 0;
        this.r = "";
        this.s = "";
        this.t = 0;
        this.u = 0L;
        this.v = 0L;
        this.w = 0;
        this.x = 0;
        this.y = "";
        this.z = "";
        this.A = "";
        String[] strArr = com.ubix.ssp.ad.e.y.c.h.f;
        this.B = strArr;
        this.C = "";
        this.D = "";
        this.E = null;
        this.F = strArr;
        this.G = strArr;
        this.H = 0.0f;
        this.I = "";
        this.J = "";
        this.K = a.f();
        this.L = 0;
        this.M = false;
        this.N = 0;
        this.O = "";
        this.f8939a = -1;
        return this;
    }
}
