package com.ubix.ssp.ad.e.y.a;

import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class g extends com.ubix.ssp.ad.e.y.c.f {
    public String[] A;
    public boolean B;
    public int C;
    public String D;
    public String E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public String L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public int T;
    public int U;
    public int b;
    public int c;
    public b d;
    public a e;
    public String[] f;
    public int g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public c[] l;
    public int m;
    public boolean n;
    public c[] o;
    public int p;
    public int q;
    public String r;
    public boolean s;
    public int t;
    public boolean u;
    public int v;
    public boolean w;
    public int x;
    public int y;
    public boolean z;

    public static final class a extends com.ubix.ssp.ad.e.y.c.f {
        public int b;
        public C1111a c;
        public String d;
        public int e;
        public int f;

        /* JADX INFO: renamed from: com.ubix.ssp.ad.e.y.a.g$a$a, reason: collision with other inner class name */
        public static final class C1111a extends com.ubix.ssp.ad.e.y.c.f {
            public int b;
            public int c;

            public C1111a() {
                e();
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
                int i = this.b;
                if (i != 0) {
                    bVar.i(1, i);
                }
                int i2 = this.c;
                if (i2 != 0) {
                    bVar.i(2, i2);
                }
                super.a(bVar);
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            protected int b() {
                int iB = super.b();
                int i = this.b;
                if (i != 0) {
                    iB += com.ubix.ssp.ad.e.y.c.b.c(1, i);
                }
                int i2 = this.c;
                return i2 != 0 ? iB + com.ubix.ssp.ad.e.y.c.b.c(2, i2) : iB;
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public C1111a a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
                while (true) {
                    int iW = aVar.w();
                    if (iW == 0) {
                        return this;
                    }
                    if (iW == 8) {
                        this.b = aVar.k();
                    } else if (iW == 16) {
                        this.c = aVar.k();
                    } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                        return this;
                    }
                }
            }

            public C1111a e() {
                this.b = 0;
                this.c = 0;
                this.f8939a = -1;
                return this;
            }
        }

        public a() {
            e();
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
            int i = this.b;
            if (i != 0) {
                bVar.i(1, i);
            }
            C1111a c1111a = this.c;
            if (c1111a != null) {
                bVar.d(2, c1111a);
            }
            if (!this.d.equals("")) {
                bVar.b(3, this.d);
            }
            int i2 = this.e;
            if (i2 != 0) {
                bVar.i(4, i2);
            }
            int i3 = this.f;
            if (i3 != 0) {
                bVar.i(5, i3);
            }
            super.a(bVar);
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        protected int b() {
            int iB = super.b();
            int i = this.b;
            if (i != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(1, i);
            }
            C1111a c1111a = this.c;
            if (c1111a != null) {
                iB += com.ubix.ssp.ad.e.y.c.b.b(2, c1111a);
            }
            if (!this.d.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(3, this.d);
            }
            int i2 = this.e;
            if (i2 != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(4, i2);
            }
            int i3 = this.f;
            return i3 != 0 ? iB + com.ubix.ssp.ad.e.y.c.b.c(5, i3) : iB;
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
            while (true) {
                int iW = aVar.w();
                if (iW == 0) {
                    return this;
                }
                if (iW == 8) {
                    this.b = aVar.k();
                } else if (iW == 18) {
                    if (this.c == null) {
                        this.c = new C1111a();
                    }
                    aVar.a(this.c);
                } else if (iW == 26) {
                    this.d = aVar.v();
                } else if (iW == 32) {
                    this.e = aVar.k();
                } else if (iW == 40) {
                    this.f = aVar.k();
                } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                    return this;
                }
            }
        }

        public a e() {
            this.b = 0;
            this.c = null;
            this.d = "";
            this.e = 0;
            this.f = 0;
            this.f8939a = -1;
            return this;
        }
    }

    public static final class b extends com.ubix.ssp.ad.e.y.c.f {
        public String b;
        public String c;

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
            super.a(bVar);
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        protected int b() {
            int iB = super.b();
            if (!this.b.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(1, this.b);
            }
            return !this.c.equals("") ? iB + com.ubix.ssp.ad.e.y.c.b.a(2, this.c) : iB;
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
            while (true) {
                int iW = aVar.w();
                if (iW == 0) {
                    return this;
                }
                if (iW == 10) {
                    this.b = aVar.v();
                } else if (iW == 18) {
                    this.c = aVar.v();
                } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                    return this;
                }
            }
        }

        public b e() {
            this.b = "";
            this.c = "";
            this.f8939a = -1;
            return this;
        }
    }

    public static final class c extends com.ubix.ssp.ad.e.y.c.f {
        private static volatile c[] b;
        public String c;
        public String d;
        public String e;

        public c() {
            e();
        }

        public static c[] f() {
            if (b == null) {
                synchronized (com.ubix.ssp.ad.e.y.c.c.c) {
                    if (b == null) {
                        b = new c[0];
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
            if (!this.d.equals("")) {
                bVar.b(2, this.d);
            }
            if (!this.e.equals("")) {
                bVar.b(3, this.e);
            }
            super.a(bVar);
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        protected int b() {
            int iB = super.b();
            if (!this.c.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(1, this.c);
            }
            if (!this.d.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(2, this.d);
            }
            return !this.e.equals("") ? iB + com.ubix.ssp.ad.e.y.c.b.a(3, this.e) : iB;
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
                    this.c = aVar.v();
                } else if (iW == 18) {
                    this.d = aVar.v();
                } else if (iW == 26) {
                    this.e = aVar.v();
                } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                    return this;
                }
            }
        }

        public c e() {
            this.c = "";
            this.d = "";
            this.e = "";
            this.f8939a = -1;
            return this;
        }
    }

    public g() {
        e();
    }

    public static g a(byte[] bArr) {
        return (g) com.ubix.ssp.ad.e.y.c.f.a(new g(), bArr);
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
        int i = this.b;
        if (i != 0) {
            bVar.i(1, i);
        }
        int i2 = this.c;
        if (i2 != 0) {
            bVar.i(2, i2);
        }
        b bVar2 = this.d;
        if (bVar2 != null) {
            bVar.d(3, bVar2);
        }
        a aVar = this.e;
        if (aVar != null) {
            bVar.d(4, aVar);
        }
        String[] strArr = this.f;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.f;
                if (i4 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i4];
                if (str != null) {
                    bVar.b(5, str);
                }
                i4++;
            }
        }
        int i5 = this.g;
        if (i5 != 0) {
            bVar.i(6, i5);
        }
        int i6 = this.h;
        if (i6 != 0) {
            bVar.i(7, i6);
        }
        int i7 = this.i;
        if (i7 != 0) {
            bVar.i(8, i7);
        }
        boolean z = this.j;
        if (z) {
            bVar.b(9, z);
        }
        boolean z2 = this.k;
        if (z2) {
            bVar.b(10, z2);
        }
        c[] cVarArr = this.l;
        if (cVarArr != null && cVarArr.length > 0) {
            int i8 = 0;
            while (true) {
                c[] cVarArr2 = this.l;
                if (i8 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i8];
                if (cVar != null) {
                    bVar.d(11, cVar);
                }
                i8++;
            }
        }
        int i9 = this.m;
        if (i9 != 0) {
            bVar.i(12, i9);
        }
        boolean z3 = this.n;
        if (z3) {
            bVar.b(13, z3);
        }
        c[] cVarArr3 = this.o;
        if (cVarArr3 != null && cVarArr3.length > 0) {
            int i10 = 0;
            while (true) {
                c[] cVarArr4 = this.o;
                if (i10 >= cVarArr4.length) {
                    break;
                }
                c cVar2 = cVarArr4[i10];
                if (cVar2 != null) {
                    bVar.d(14, cVar2);
                }
                i10++;
            }
        }
        int i11 = this.p;
        if (i11 != 0) {
            bVar.i(15, i11);
        }
        int i12 = this.q;
        if (i12 != 0) {
            bVar.i(16, i12);
        }
        if (!this.r.equals("")) {
            bVar.b(17, this.r);
        }
        boolean z4 = this.s;
        if (z4) {
            bVar.b(18, z4);
        }
        int i13 = this.t;
        if (i13 != 0) {
            bVar.i(19, i13);
        }
        boolean z5 = this.u;
        if (z5) {
            bVar.b(20, z5);
        }
        int i14 = this.v;
        if (i14 != 0) {
            bVar.i(21, i14);
        }
        boolean z6 = this.w;
        if (z6) {
            bVar.b(22, z6);
        }
        int i15 = this.x;
        if (i15 != 0) {
            bVar.i(23, i15);
        }
        int i16 = this.y;
        if (i16 != 0) {
            bVar.i(24, i16);
        }
        boolean z7 = this.z;
        if (z7) {
            bVar.b(25, z7);
        }
        String[] strArr3 = this.A;
        if (strArr3 != null && strArr3.length > 0) {
            while (true) {
                String[] strArr4 = this.A;
                if (i3 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i3];
                if (str2 != null) {
                    bVar.b(26, str2);
                }
                i3++;
            }
        }
        boolean z8 = this.B;
        if (z8) {
            bVar.b(27, z8);
        }
        int i17 = this.C;
        if (i17 != 0) {
            bVar.i(28, i17);
        }
        if (!this.D.equals("")) {
            bVar.b(29, this.D);
        }
        if (!this.E.equals("")) {
            bVar.b(30, this.E);
        }
        int i18 = this.F;
        if (i18 != 0) {
            bVar.i(31, i18);
        }
        int i19 = this.G;
        if (i19 != 0) {
            bVar.i(32, i19);
        }
        int i20 = this.H;
        if (i20 != 0) {
            bVar.i(33, i20);
        }
        int i21 = this.I;
        if (i21 != 0) {
            bVar.i(34, i21);
        }
        int i22 = this.J;
        if (i22 != 0) {
            bVar.i(35, i22);
        }
        int i23 = this.K;
        if (i23 != 0) {
            bVar.i(36, i23);
        }
        if (!this.L.equals("")) {
            bVar.b(37, this.L);
        }
        int i24 = this.M;
        if (i24 != 0) {
            bVar.i(38, i24);
        }
        int i25 = this.N;
        if (i25 != 0) {
            bVar.i(39, i25);
        }
        int i26 = this.O;
        if (i26 != 0) {
            bVar.i(40, i26);
        }
        int i27 = this.P;
        if (i27 != 0) {
            bVar.i(41, i27);
        }
        int i28 = this.Q;
        if (i28 != 0) {
            bVar.i(42, i28);
        }
        int i29 = this.R;
        if (i29 != 0) {
            bVar.i(43, i29);
        }
        boolean z9 = this.S;
        if (z9) {
            bVar.b(44, z9);
        }
        int i30 = this.T;
        if (i30 != 0) {
            bVar.i(45, i30);
        }
        int i31 = this.U;
        if (i31 != 0) {
            bVar.i(46, i31);
        }
        super.a(bVar);
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    protected int b() {
        int iB = super.b();
        int i = this.b;
        if (i != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(1, i);
        }
        int i2 = this.c;
        if (i2 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(2, i2);
        }
        b bVar = this.d;
        if (bVar != null) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(3, bVar);
        }
        a aVar = this.e;
        if (aVar != null) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(4, aVar);
        }
        String[] strArr = this.f;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i4 = 0;
            int iA = 0;
            int i5 = 0;
            while (true) {
                String[] strArr2 = this.f;
                if (i4 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i4];
                if (str != null) {
                    i5++;
                    iA += com.ubix.ssp.ad.e.y.c.b.a(str);
                }
                i4++;
            }
            iB = iB + iA + i5;
        }
        int i6 = this.g;
        if (i6 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(6, i6);
        }
        int i7 = this.h;
        if (i7 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(7, i7);
        }
        int i8 = this.i;
        if (i8 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(8, i8);
        }
        boolean z = this.j;
        if (z) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(9, z);
        }
        boolean z2 = this.k;
        if (z2) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(10, z2);
        }
        c[] cVarArr = this.l;
        if (cVarArr != null && cVarArr.length > 0) {
            int i9 = 0;
            while (true) {
                c[] cVarArr2 = this.l;
                if (i9 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i9];
                if (cVar != null) {
                    iB += com.ubix.ssp.ad.e.y.c.b.b(11, cVar);
                }
                i9++;
            }
        }
        int i10 = this.m;
        if (i10 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(12, i10);
        }
        boolean z3 = this.n;
        if (z3) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(13, z3);
        }
        c[] cVarArr3 = this.o;
        if (cVarArr3 != null && cVarArr3.length > 0) {
            int i11 = 0;
            while (true) {
                c[] cVarArr4 = this.o;
                if (i11 >= cVarArr4.length) {
                    break;
                }
                c cVar2 = cVarArr4[i11];
                if (cVar2 != null) {
                    iB += com.ubix.ssp.ad.e.y.c.b.b(14, cVar2);
                }
                i11++;
            }
        }
        int i12 = this.p;
        if (i12 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(15, i12);
        }
        int i13 = this.q;
        if (i13 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(16, i13);
        }
        if (!this.r.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(17, this.r);
        }
        boolean z4 = this.s;
        if (z4) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(18, z4);
        }
        int i14 = this.t;
        if (i14 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(19, i14);
        }
        boolean z5 = this.u;
        if (z5) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(20, z5);
        }
        int i15 = this.v;
        if (i15 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(21, i15);
        }
        boolean z6 = this.w;
        if (z6) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(22, z6);
        }
        int i16 = this.x;
        if (i16 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(23, i16);
        }
        int i17 = this.y;
        if (i17 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(24, i17);
        }
        boolean z7 = this.z;
        if (z7) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(25, z7);
        }
        String[] strArr3 = this.A;
        if (strArr3 != null && strArr3.length > 0) {
            int iA2 = 0;
            int i18 = 0;
            while (true) {
                String[] strArr4 = this.A;
                if (i3 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i3];
                if (str2 != null) {
                    i18++;
                    iA2 += com.ubix.ssp.ad.e.y.c.b.a(str2);
                }
                i3++;
            }
            iB = iB + iA2 + (i18 * 2);
        }
        boolean z8 = this.B;
        if (z8) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(27, z8);
        }
        int i19 = this.C;
        if (i19 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(28, i19);
        }
        if (!this.D.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(29, this.D);
        }
        if (!this.E.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(30, this.E);
        }
        int i20 = this.F;
        if (i20 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(31, i20);
        }
        int i21 = this.G;
        if (i21 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(32, i21);
        }
        int i22 = this.H;
        if (i22 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(33, i22);
        }
        int i23 = this.I;
        if (i23 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(34, i23);
        }
        int i24 = this.J;
        if (i24 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(35, i24);
        }
        int i25 = this.K;
        if (i25 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(36, i25);
        }
        if (!this.L.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(37, this.L);
        }
        int i26 = this.M;
        if (i26 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(38, i26);
        }
        int i27 = this.N;
        if (i27 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(39, i27);
        }
        int i28 = this.O;
        if (i28 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(40, i28);
        }
        int i29 = this.P;
        if (i29 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(41, i29);
        }
        int i30 = this.Q;
        if (i30 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(42, i30);
        }
        int i31 = this.R;
        if (i31 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(43, i31);
        }
        boolean z9 = this.S;
        if (z9) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(44, z9);
        }
        int i32 = this.T;
        if (i32 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(45, i32);
        }
        int i33 = this.U;
        return i33 != 0 ? iB + com.ubix.ssp.ad.e.y.c.b.c(46, i33) : iB;
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
        com.ubix.ssp.ad.e.y.c.f fVar;
        while (true) {
            int iW = aVar.w();
            switch (iW) {
                case 0:
                    return this;
                case 8:
                    this.b = aVar.k();
                    continue;
                case 16:
                    this.c = aVar.k();
                    continue;
                case 26:
                    if (this.d == null) {
                        this.d = new b();
                    }
                    fVar = this.d;
                    break;
                case 34:
                    if (this.e == null) {
                        this.e = new a();
                    }
                    fVar = this.e;
                    break;
                case 42:
                    int iA = com.ubix.ssp.ad.e.y.c.h.a(aVar, 42);
                    String[] strArr = this.f;
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
                    this.f = strArr2;
                    continue;
                case 48:
                    this.g = aVar.k();
                    continue;
                case 56:
                    this.h = aVar.k();
                    continue;
                case 64:
                    this.i = aVar.k();
                    continue;
                case 72:
                    this.j = aVar.d();
                    continue;
                case 80:
                    this.k = aVar.d();
                    continue;
                case 90:
                    int iA2 = com.ubix.ssp.ad.e.y.c.h.a(aVar, 90);
                    c[] cVarArr = this.l;
                    int length2 = cVarArr == null ? 0 : cVarArr.length;
                    int i2 = iA2 + length2;
                    c[] cVarArr2 = new c[i2];
                    if (length2 != 0) {
                        System.arraycopy(cVarArr, 0, cVarArr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        c cVar = new c();
                        cVarArr2[length2] = cVar;
                        aVar.a(cVar);
                        aVar.w();
                        length2++;
                    }
                    c cVar2 = new c();
                    cVarArr2[length2] = cVar2;
                    aVar.a(cVar2);
                    this.l = cVarArr2;
                    continue;
                case 96:
                    this.m = aVar.k();
                    continue;
                case 104:
                    this.n = aVar.d();
                    continue;
                case 114:
                    int iA3 = com.ubix.ssp.ad.e.y.c.h.a(aVar, 114);
                    c[] cVarArr3 = this.o;
                    int length3 = cVarArr3 == null ? 0 : cVarArr3.length;
                    int i3 = iA3 + length3;
                    c[] cVarArr4 = new c[i3];
                    if (length3 != 0) {
                        System.arraycopy(cVarArr3, 0, cVarArr4, 0, length3);
                    }
                    while (length3 < i3 - 1) {
                        c cVar3 = new c();
                        cVarArr4[length3] = cVar3;
                        aVar.a(cVar3);
                        aVar.w();
                        length3++;
                    }
                    c cVar4 = new c();
                    cVarArr4[length3] = cVar4;
                    aVar.a(cVar4);
                    this.o = cVarArr4;
                    continue;
                case 120:
                    this.p = aVar.k();
                    continue;
                case 128:
                    this.q = aVar.k();
                    continue;
                case 138:
                    this.r = aVar.v();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_SPADE /* 144 */:
                    this.s = aVar.d();
                    continue;
                case 152:
                    this.t = aVar.k();
                    continue;
                case 160:
                    this.u = aVar.d();
                    continue;
                case Opcodes.JSR /* 168 */:
                    this.v = aVar.k();
                    continue;
                case 176:
                    this.w = aVar.d();
                    continue;
                case 184:
                    this.x = aVar.k();
                    continue;
                case 192:
                    this.y = aVar.k();
                    continue;
                case 200:
                    this.z = aVar.d();
                    continue;
                case 210:
                    int iA4 = com.ubix.ssp.ad.e.y.c.h.a(aVar, 210);
                    String[] strArr3 = this.A;
                    int length4 = strArr3 == null ? 0 : strArr3.length;
                    int i4 = iA4 + length4;
                    String[] strArr4 = new String[i4];
                    if (length4 != 0) {
                        System.arraycopy(strArr3, 0, strArr4, 0, length4);
                    }
                    while (length4 < i4 - 1) {
                        strArr4[length4] = aVar.v();
                        aVar.w();
                        length4++;
                    }
                    strArr4[length4] = aVar.v();
                    this.A = strArr4;
                    continue;
                case 216:
                    this.B = aVar.d();
                    continue;
                case 224:
                    this.C = aVar.k();
                    continue;
                case 234:
                    this.D = aVar.v();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE /* 242 */:
                    this.E = aVar.v();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT /* 248 */:
                    this.F = aVar.k();
                    continue;
                case 256:
                    this.G = aVar.k();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME /* 264 */:
                    this.H = aVar.k();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME /* 272 */:
                    this.I = aVar.k();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN /* 280 */:
                    this.J = aVar.k();
                    continue;
                case 288:
                    this.K = aVar.k();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX /* 298 */:
                    this.L = aVar.v();
                    continue;
                case 304:
                    this.M = aVar.k();
                    continue;
                case 312:
                    this.N = aVar.k();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME /* 320 */:
                    this.O = aVar.k();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE /* 328 */:
                    this.P = aVar.k();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME /* 336 */:
                    this.Q = aVar.k();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS /* 344 */:
                    this.R = aVar.k();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CHLO_COUNT /* 352 */:
                    this.S = aVar.d();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL /* 360 */:
                    this.T = aVar.k();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION /* 368 */:
                    this.U = aVar.k();
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

    public g e() {
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = null;
        String[] strArr = com.ubix.ssp.ad.e.y.c.h.f;
        this.f = strArr;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.k = false;
        this.l = c.f();
        this.m = 0;
        this.n = false;
        this.o = c.f();
        this.p = 0;
        this.q = 0;
        this.r = "";
        this.s = false;
        this.t = 0;
        this.u = false;
        this.v = 0;
        this.w = false;
        this.x = 0;
        this.y = 0;
        this.z = false;
        this.A = strArr;
        this.B = false;
        this.C = 0;
        this.D = "";
        this.E = "";
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = "";
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = false;
        this.T = 0;
        this.U = 0;
        this.f8939a = -1;
        return this;
    }
}
