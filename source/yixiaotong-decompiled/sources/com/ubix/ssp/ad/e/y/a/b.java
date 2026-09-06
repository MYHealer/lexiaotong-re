package com.ubix.ssp.ad.e.y.a;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class b extends com.ubix.ssp.ad.e.y.c.f {
    private static volatile b[] b;
    public String c;
    public int d;
    public int e;
    public a[] f;
    public int[] g;
    public j h;
    public j[] i;
    public h j;
    public int k;
    public int l;
    public boolean m;
    public int n;
    public String o;
    public String p;
    public int q;
    public int r;
    public int s;
    public C1110b t;
    public int u;
    public long v;

    public static final class a extends com.ubix.ssp.ad.e.y.c.f {
        private static volatile a[] b;
        public int c;
        public i[] d;
        public int e;
        public int f;

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
            int i = this.c;
            if (i != 0) {
                bVar.i(1, i);
            }
            i[] iVarArr = this.d;
            if (iVarArr != null && iVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    i[] iVarArr2 = this.d;
                    if (i2 >= iVarArr2.length) {
                        break;
                    }
                    i iVar = iVarArr2[i2];
                    if (iVar != null) {
                        bVar.d(2, iVar);
                    }
                    i2++;
                }
            }
            int i3 = this.e;
            if (i3 != 0) {
                bVar.i(3, i3);
            }
            int i4 = this.f;
            if (i4 != 0) {
                bVar.i(4, i4);
            }
            super.a(bVar);
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        protected int b() {
            int iB = super.b();
            int i = this.c;
            if (i != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(1, i);
            }
            i[] iVarArr = this.d;
            if (iVarArr != null && iVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    i[] iVarArr2 = this.d;
                    if (i2 >= iVarArr2.length) {
                        break;
                    }
                    i iVar = iVarArr2[i2];
                    if (iVar != null) {
                        iB += com.ubix.ssp.ad.e.y.c.b.b(2, iVar);
                    }
                    i2++;
                }
            }
            int i3 = this.e;
            if (i3 != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(3, i3);
            }
            int i4 = this.f;
            return i4 != 0 ? iB + com.ubix.ssp.ad.e.y.c.b.c(4, i4) : iB;
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
                    this.c = aVar.k();
                } else if (iW == 18) {
                    int iA = com.ubix.ssp.ad.e.y.c.h.a(aVar, 18);
                    i[] iVarArr = this.d;
                    int length = iVarArr == null ? 0 : iVarArr.length;
                    int i = iA + length;
                    i[] iVarArr2 = new i[i];
                    if (length != 0) {
                        System.arraycopy(iVarArr, 0, iVarArr2, 0, length);
                    }
                    while (length < i - 1) {
                        i iVar = new i();
                        iVarArr2[length] = iVar;
                        aVar.a(iVar);
                        aVar.w();
                        length++;
                    }
                    i iVar2 = new i();
                    iVarArr2[length] = iVar2;
                    aVar.a(iVar2);
                    this.d = iVarArr2;
                } else if (iW == 24) {
                    this.e = aVar.k();
                } else if (iW == 32) {
                    this.f = aVar.k();
                } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                    return this;
                }
            }
        }

        public a e() {
            this.c = 0;
            this.d = i.f();
            this.e = 0;
            this.f = 0;
            this.f8939a = -1;
            return this;
        }
    }

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.y.a.b$b, reason: collision with other inner class name */
    public static final class C1110b extends com.ubix.ssp.ad.e.y.c.f {
        public String b;
        public String c;

        public C1110b() {
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
        public C1110b a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
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

        public C1110b e() {
            this.b = "";
            this.c = "";
            this.f8939a = -1;
            return this;
        }
    }

    public b() {
        e();
    }

    public static b[] f() {
        if (b == null) {
            synchronized (com.ubix.ssp.ad.e.y.c.c.c) {
                if (b == null) {
                    b = new b[0];
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
        int i2 = this.e;
        if (i2 != 0) {
            bVar.i(3, i2);
        }
        a[] aVarArr = this.f;
        int i3 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i4 = 0;
            while (true) {
                a[] aVarArr2 = this.f;
                if (i4 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i4];
                if (aVar != null) {
                    bVar.d(4, aVar);
                }
                i4++;
            }
        }
        int[] iArr = this.g;
        if (iArr != null && iArr.length > 0) {
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.g;
                if (i5 >= iArr2.length) {
                    break;
                }
                bVar.i(5, iArr2[i5]);
                i5++;
            }
        }
        j jVar = this.h;
        if (jVar != null) {
            bVar.d(6, jVar);
        }
        j[] jVarArr = this.i;
        if (jVarArr != null && jVarArr.length > 0) {
            while (true) {
                j[] jVarArr2 = this.i;
                if (i3 >= jVarArr2.length) {
                    break;
                }
                j jVar2 = jVarArr2[i3];
                if (jVar2 != null) {
                    bVar.d(7, jVar2);
                }
                i3++;
            }
        }
        h hVar = this.j;
        if (hVar != null) {
            bVar.d(8, hVar);
        }
        int i6 = this.k;
        if (i6 != 0) {
            bVar.i(9, i6);
        }
        int i7 = this.l;
        if (i7 != 0) {
            bVar.i(10, i7);
        }
        boolean z = this.m;
        if (z) {
            bVar.b(11, z);
        }
        int i8 = this.n;
        if (i8 != 0) {
            bVar.i(12, i8);
        }
        if (!this.o.equals("")) {
            bVar.b(13, this.o);
        }
        if (!this.p.equals("")) {
            bVar.b(14, this.p);
        }
        int i9 = this.q;
        if (i9 != 0) {
            bVar.i(15, i9);
        }
        int i10 = this.r;
        if (i10 != 0) {
            bVar.i(16, i10);
        }
        int i11 = this.s;
        if (i11 != 0) {
            bVar.i(17, i11);
        }
        C1110b c1110b = this.t;
        if (c1110b != null) {
            bVar.d(18, c1110b);
        }
        int i12 = this.u;
        if (i12 != 0) {
            bVar.i(19, i12);
        }
        long j = this.v;
        if (j != 0) {
            bVar.g(20, j);
        }
        super.a(bVar);
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    protected int b() {
        int[] iArr;
        int iB = super.b();
        if (!this.c.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(1, this.c);
        }
        int i = this.d;
        if (i != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(2, i);
        }
        int i2 = this.e;
        if (i2 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(3, i2);
        }
        a[] aVarArr = this.f;
        int i3 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i4 = 0;
            while (true) {
                a[] aVarArr2 = this.f;
                if (i4 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i4];
                if (aVar != null) {
                    iB += com.ubix.ssp.ad.e.y.c.b.b(4, aVar);
                }
                i4++;
            }
        }
        int[] iArr2 = this.g;
        if (iArr2 != null && iArr2.length > 0) {
            int i5 = 0;
            int iC = 0;
            while (true) {
                iArr = this.g;
                if (i5 >= iArr.length) {
                    break;
                }
                iC += com.ubix.ssp.ad.e.y.c.b.c(iArr[i5]);
                i5++;
            }
            iB = iB + iC + iArr.length;
        }
        j jVar = this.h;
        if (jVar != null) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(6, jVar);
        }
        j[] jVarArr = this.i;
        if (jVarArr != null && jVarArr.length > 0) {
            while (true) {
                j[] jVarArr2 = this.i;
                if (i3 >= jVarArr2.length) {
                    break;
                }
                j jVar2 = jVarArr2[i3];
                if (jVar2 != null) {
                    iB += com.ubix.ssp.ad.e.y.c.b.b(7, jVar2);
                }
                i3++;
            }
        }
        h hVar = this.j;
        if (hVar != null) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(8, hVar);
        }
        int i6 = this.k;
        if (i6 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(9, i6);
        }
        int i7 = this.l;
        if (i7 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(10, i7);
        }
        boolean z = this.m;
        if (z) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(11, z);
        }
        int i8 = this.n;
        if (i8 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(12, i8);
        }
        if (!this.o.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(13, this.o);
        }
        if (!this.p.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(14, this.p);
        }
        int i9 = this.q;
        if (i9 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(15, i9);
        }
        int i10 = this.r;
        if (i10 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(16, i10);
        }
        int i11 = this.s;
        if (i11 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(17, i11);
        }
        C1110b c1110b = this.t;
        if (c1110b != null) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(18, c1110b);
        }
        int i12 = this.u;
        if (i12 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(19, i12);
        }
        long j = this.v;
        return j != 0 ? iB + com.ubix.ssp.ad.e.y.c.b.b(20, j) : iB;
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
        com.ubix.ssp.ad.e.y.c.f fVar;
        while (true) {
            int iW = aVar.w();
            switch (iW) {
                case 0:
                    return this;
                case 10:
                    this.c = aVar.v();
                    continue;
                case 16:
                    this.d = aVar.k();
                    continue;
                case 24:
                    this.e = aVar.k();
                    continue;
                case 34:
                    int iA = com.ubix.ssp.ad.e.y.c.h.a(aVar, 34);
                    a[] aVarArr = this.f;
                    int length = aVarArr == null ? 0 : aVarArr.length;
                    int i = iA + length;
                    a[] aVarArr2 = new a[i];
                    if (length != 0) {
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                    }
                    while (length < i - 1) {
                        a aVar2 = new a();
                        aVarArr2[length] = aVar2;
                        aVar.a(aVar2);
                        aVar.w();
                        length++;
                    }
                    a aVar3 = new a();
                    aVarArr2[length] = aVar3;
                    aVar.a(aVar3);
                    this.f = aVarArr2;
                    continue;
                case 40:
                    int iA2 = com.ubix.ssp.ad.e.y.c.h.a(aVar, 40);
                    int[] iArr = this.g;
                    int length2 = iArr == null ? 0 : iArr.length;
                    int i2 = iA2 + length2;
                    int[] iArr2 = new int[i2];
                    if (length2 != 0) {
                        System.arraycopy(iArr, 0, iArr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        iArr2[length2] = aVar.k();
                        aVar.w();
                        length2++;
                    }
                    iArr2[length2] = aVar.k();
                    this.g = iArr2;
                    continue;
                case 42:
                    int iD = aVar.d(aVar.p());
                    int iB = aVar.b();
                    int i3 = 0;
                    while (aVar.a() > 0) {
                        aVar.k();
                        i3++;
                    }
                    aVar.g(iB);
                    int[] iArr3 = this.g;
                    int length3 = iArr3 == null ? 0 : iArr3.length;
                    int i4 = i3 + length3;
                    int[] iArr4 = new int[i4];
                    if (length3 != 0) {
                        System.arraycopy(iArr3, 0, iArr4, 0, length3);
                    }
                    while (length3 < i4) {
                        iArr4[length3] = aVar.k();
                        length3++;
                    }
                    this.g = iArr4;
                    aVar.c(iD);
                    continue;
                case 50:
                    if (this.h == null) {
                        this.h = new j();
                    }
                    fVar = this.h;
                    break;
                case 58:
                    int iA3 = com.ubix.ssp.ad.e.y.c.h.a(aVar, 58);
                    j[] jVarArr = this.i;
                    int length4 = jVarArr == null ? 0 : jVarArr.length;
                    int i5 = iA3 + length4;
                    j[] jVarArr2 = new j[i5];
                    if (length4 != 0) {
                        System.arraycopy(jVarArr, 0, jVarArr2, 0, length4);
                    }
                    while (length4 < i5 - 1) {
                        j jVar = new j();
                        jVarArr2[length4] = jVar;
                        aVar.a(jVar);
                        aVar.w();
                        length4++;
                    }
                    j jVar2 = new j();
                    jVarArr2[length4] = jVar2;
                    aVar.a(jVar2);
                    this.i = jVarArr2;
                    continue;
                case 66:
                    if (this.j == null) {
                        this.j = new h();
                    }
                    fVar = this.j;
                    break;
                case 72:
                    this.k = aVar.k();
                    continue;
                case 80:
                    this.l = aVar.k();
                    continue;
                case 88:
                    this.m = aVar.d();
                    continue;
                case 96:
                    this.n = aVar.k();
                    continue;
                case 106:
                    this.o = aVar.v();
                    continue;
                case 114:
                    this.p = aVar.v();
                    continue;
                case 120:
                    this.q = aVar.k();
                    continue;
                case 128:
                    this.r = aVar.k();
                    continue;
                case MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH /* 136 */:
                    this.s = aVar.k();
                    continue;
                case 146:
                    if (this.t == null) {
                        this.t = new C1110b();
                    }
                    fVar = this.t;
                    break;
                case 152:
                    this.u = aVar.k();
                    continue;
                case 160:
                    this.v = aVar.l();
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

    public b e() {
        this.c = "";
        this.d = 0;
        this.e = 0;
        this.f = a.f();
        this.g = com.ubix.ssp.ad.e.y.c.h.f8940a;
        this.h = null;
        this.i = j.f();
        this.j = null;
        this.k = 0;
        this.l = 0;
        this.m = false;
        this.n = 0;
        this.o = "";
        this.p = "";
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = null;
        this.u = 0;
        this.v = 0L;
        this.f8939a = -1;
        return this;
    }
}
