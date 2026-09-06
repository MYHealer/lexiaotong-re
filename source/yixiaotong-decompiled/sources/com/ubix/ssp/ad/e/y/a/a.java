package com.ubix.ssp.ad.e.y.a;

import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.facebook.imageutils.JfifUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a extends com.ubix.ssp.ad.e.y.c.f {
    private static volatile a[] b;
    public String c;
    public b d;
    public long e;
    public c f;
    public int g;
    public int h;
    public String i;
    public long j;
    public boolean k;
    public C1107a l;
    public String m;

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.y.a.a$a, reason: collision with other inner class name */
    public static final class C1107a extends com.ubix.ssp.ad.e.y.c.f {
        public int b;

        public C1107a() {
            e();
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
            int i = this.b;
            if (i != 0) {
                bVar.i(1, i);
            }
            super.a(bVar);
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        protected int b() {
            int iB = super.b();
            int i = this.b;
            return i != 0 ? iB + com.ubix.ssp.ad.e.y.c.b.c(1, i) : iB;
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1107a a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
            while (true) {
                int iW = aVar.w();
                if (iW == 0) {
                    return this;
                }
                if (iW == 8) {
                    this.b = aVar.k();
                } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                    return this;
                }
            }
        }

        public C1107a e() {
            this.b = 0;
            this.f8939a = -1;
            return this;
        }
    }

    public static final class b extends com.ubix.ssp.ad.e.y.c.f {
        public String A;
        public String B;
        public String C;
        public String D;
        public String E;
        public String F;
        public long G;
        public String H;
        public String I;
        public String J;
        public i K;
        public f L;
        public int M;
        public boolean N;
        public C1108a O;
        public d P;
        public g Q;
        public String R;
        public j S;
        public String b;
        public int c;
        public int d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public C1109b[] j;
        public l k;
        public int l;
        public String m;
        public String n;
        public String o;
        public k[] p;
        public String[] q;
        public String r;
        public int s;
        public String t;
        public m u;
        public String v;
        public String w;
        public String x;
        public float y;
        public String z;

        /* JADX INFO: renamed from: com.ubix.ssp.ad.e.y.a.a$b$a, reason: collision with other inner class name */
        public static final class C1108a extends com.ubix.ssp.ad.e.y.c.f {
            public e b;

            public C1108a() {
                e();
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
                e eVar = this.b;
                if (eVar != null) {
                    bVar.d(1, eVar);
                }
                super.a(bVar);
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            protected int b() {
                int iB = super.b();
                e eVar = this.b;
                return eVar != null ? iB + com.ubix.ssp.ad.e.y.c.b.b(1, eVar) : iB;
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public C1108a a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
                while (true) {
                    int iW = aVar.w();
                    if (iW == 0) {
                        return this;
                    }
                    if (iW == 10) {
                        if (this.b == null) {
                            this.b = new e();
                        }
                        aVar.a(this.b);
                    } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                        return this;
                    }
                }
            }

            public C1108a e() {
                this.b = null;
                this.f8939a = -1;
                return this;
            }
        }

        /* JADX INFO: renamed from: com.ubix.ssp.ad.e.y.a.a$b$b, reason: collision with other inner class name */
        public static final class C1109b extends com.ubix.ssp.ad.e.y.c.f {
            private static volatile C1109b[] b;
            public String c;
            public int d;
            public int e;
            public String f;

            public C1109b() {
                e();
            }

            public static C1109b[] f() {
                if (b == null) {
                    synchronized (com.ubix.ssp.ad.e.y.c.c.c) {
                        if (b == null) {
                            b = new C1109b[0];
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
                    bVar.m(2, i);
                }
                int i2 = this.e;
                if (i2 != 0) {
                    bVar.m(3, i2);
                }
                if (!this.f.equals("")) {
                    bVar.b(4, this.f);
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
                if (i != 0) {
                    iB += com.ubix.ssp.ad.e.y.c.b.f(2, i);
                }
                int i2 = this.e;
                if (i2 != 0) {
                    iB += com.ubix.ssp.ad.e.y.c.b.f(3, i2);
                }
                return !this.f.equals("") ? iB + com.ubix.ssp.ad.e.y.c.b.a(4, this.f) : iB;
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public C1109b a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
                while (true) {
                    int iW = aVar.w();
                    if (iW == 0) {
                        return this;
                    }
                    if (iW == 10) {
                        this.c = aVar.v();
                    } else if (iW == 16) {
                        this.d = aVar.x();
                    } else if (iW == 24) {
                        this.e = aVar.x();
                    } else if (iW == 34) {
                        this.f = aVar.v();
                    } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                        return this;
                    }
                }
            }

            public C1109b e() {
                this.c = "";
                this.d = 0;
                this.e = 0;
                this.f = "";
                this.f8939a = -1;
                return this;
            }
        }

        public static final class c extends com.ubix.ssp.ad.e.y.c.f {
            private static volatile c[] b;
            public String c;
            public String d;
            public int e;

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
                int i = this.e;
                if (i != 0) {
                    bVar.i(3, i);
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
                int i = this.e;
                return i != 0 ? iB + com.ubix.ssp.ad.e.y.c.b.c(3, i) : iB;
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
                    } else if (iW == 24) {
                        this.e = aVar.k();
                    } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                        return this;
                    }
                }
            }

            public c e() {
                this.c = "";
                this.d = "";
                this.e = 0;
                this.f8939a = -1;
                return this;
            }
        }

        public static final class d extends com.ubix.ssp.ad.e.y.c.f {
            public h b;
            public String c;
            public String d;
            public String e;
            public int f;

            public d() {
                e();
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
                h hVar = this.b;
                if (hVar != null) {
                    bVar.d(1, hVar);
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
                int i = this.f;
                if (i != 0) {
                    bVar.i(5, i);
                }
                super.a(bVar);
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            protected int b() {
                int iB = super.b();
                h hVar = this.b;
                if (hVar != null) {
                    iB += com.ubix.ssp.ad.e.y.c.b.b(1, hVar);
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
                int i = this.f;
                return i != 0 ? iB + com.ubix.ssp.ad.e.y.c.b.c(5, i) : iB;
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
                while (true) {
                    int iW = aVar.w();
                    if (iW == 0) {
                        return this;
                    }
                    if (iW == 10) {
                        if (this.b == null) {
                            this.b = new h();
                        }
                        aVar.a(this.b);
                    } else if (iW == 18) {
                        this.c = aVar.v();
                    } else if (iW == 26) {
                        this.d = aVar.v();
                    } else if (iW == 34) {
                        this.e = aVar.v();
                    } else if (iW == 40) {
                        this.f = aVar.k();
                    } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                        return this;
                    }
                }
            }

            public d e() {
                this.b = null;
                this.c = "";
                this.d = "";
                this.e = "";
                this.f = 0;
                this.f8939a = -1;
                return this;
            }
        }

        public static final class e extends com.ubix.ssp.ad.e.y.c.f {
            public float b;
            public float c;
            public float d;
            public float e;

            public e() {
                e();
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
                if (Float.floatToIntBits(this.b) != Float.floatToIntBits(0.0f)) {
                    bVar.b(1, this.b);
                }
                if (Float.floatToIntBits(this.c) != Float.floatToIntBits(0.0f)) {
                    bVar.b(2, this.c);
                }
                if (Float.floatToIntBits(this.d) != Float.floatToIntBits(0.0f)) {
                    bVar.b(3, this.d);
                }
                if (Float.floatToIntBits(this.e) != Float.floatToIntBits(0.0f)) {
                    bVar.b(4, this.e);
                }
                super.a(bVar);
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            protected int b() {
                int iB = super.b();
                if (Float.floatToIntBits(this.b) != Float.floatToIntBits(0.0f)) {
                    iB += com.ubix.ssp.ad.e.y.c.b.a(1, this.b);
                }
                if (Float.floatToIntBits(this.c) != Float.floatToIntBits(0.0f)) {
                    iB += com.ubix.ssp.ad.e.y.c.b.a(2, this.c);
                }
                if (Float.floatToIntBits(this.d) != Float.floatToIntBits(0.0f)) {
                    iB += com.ubix.ssp.ad.e.y.c.b.a(3, this.d);
                }
                return Float.floatToIntBits(this.e) != Float.floatToIntBits(0.0f) ? iB + com.ubix.ssp.ad.e.y.c.b.a(4, this.e) : iB;
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public e a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
                while (true) {
                    int iW = aVar.w();
                    if (iW == 0) {
                        return this;
                    }
                    if (iW == 13) {
                        this.b = aVar.j();
                    } else if (iW == 21) {
                        this.c = aVar.j();
                    } else if (iW == 29) {
                        this.d = aVar.j();
                    } else if (iW == 37) {
                        this.e = aVar.j();
                    } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                        return this;
                    }
                }
            }

            public e e() {
                this.b = 0.0f;
                this.c = 0.0f;
                this.d = 0.0f;
                this.e = 0.0f;
                this.f8939a = -1;
                return this;
            }
        }

        public static final class f extends com.ubix.ssp.ad.e.y.c.f {
            public int b;
            public int c;
            public int d;
            public int e;

            public f() {
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
                int i3 = this.d;
                if (i3 != 0) {
                    bVar.i(3, i3);
                }
                int i4 = this.e;
                if (i4 != 0) {
                    bVar.i(4, i4);
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
                int i3 = this.d;
                if (i3 != 0) {
                    iB += com.ubix.ssp.ad.e.y.c.b.c(3, i3);
                }
                int i4 = this.e;
                return i4 != 0 ? iB + com.ubix.ssp.ad.e.y.c.b.c(4, i4) : iB;
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public f a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
                while (true) {
                    int iW = aVar.w();
                    if (iW == 0) {
                        return this;
                    }
                    if (iW == 8) {
                        this.b = aVar.k();
                    } else if (iW == 16) {
                        this.c = aVar.k();
                    } else if (iW == 24) {
                        this.d = aVar.k();
                    } else if (iW == 32) {
                        this.e = aVar.k();
                    } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                        return this;
                    }
                }
            }

            public f e() {
                this.b = 0;
                this.c = 0;
                this.d = 0;
                this.e = 0;
                this.f8939a = -1;
                return this;
            }
        }

        public static final class g extends com.ubix.ssp.ad.e.y.c.f {
            public String b;
            public String c;
            public int d;
            public boolean e;
            public String f;

            public g() {
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
                int i = this.d;
                if (i != 0) {
                    bVar.i(3, i);
                }
                boolean z = this.e;
                if (z) {
                    bVar.b(4, z);
                }
                if (!this.f.equals("")) {
                    bVar.b(5, this.f);
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
                int i = this.d;
                if (i != 0) {
                    iB += com.ubix.ssp.ad.e.y.c.b.c(3, i);
                }
                boolean z = this.e;
                if (z) {
                    iB += com.ubix.ssp.ad.e.y.c.b.a(4, z);
                }
                return !this.f.equals("") ? iB + com.ubix.ssp.ad.e.y.c.b.a(5, this.f) : iB;
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public g a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
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
                        this.d = aVar.k();
                    } else if (iW == 32) {
                        this.e = aVar.d();
                    } else if (iW == 42) {
                        this.f = aVar.v();
                    } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                        return this;
                    }
                }
            }

            public g e() {
                this.b = "";
                this.c = "";
                this.d = 0;
                this.e = false;
                this.f = "";
                this.f8939a = -1;
                return this;
            }
        }

        public static final class h extends com.ubix.ssp.ad.e.y.c.f {
            public String b;
            public String c;

            public h() {
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
            public h a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
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

            public h e() {
                this.b = "";
                this.c = "";
                this.f8939a = -1;
                return this;
            }
        }

        public static final class i extends com.ubix.ssp.ad.e.y.c.f {
            public String b;
            public String c;
            public c[] d;

            public i() {
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
                c[] cVarArr = this.d;
                if (cVarArr != null && cVarArr.length > 0) {
                    int i = 0;
                    while (true) {
                        c[] cVarArr2 = this.d;
                        if (i >= cVarArr2.length) {
                            break;
                        }
                        c cVar = cVarArr2[i];
                        if (cVar != null) {
                            bVar.d(3, cVar);
                        }
                        i++;
                    }
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
                c[] cVarArr = this.d;
                if (cVarArr != null && cVarArr.length > 0) {
                    int i = 0;
                    while (true) {
                        c[] cVarArr2 = this.d;
                        if (i >= cVarArr2.length) {
                            break;
                        }
                        c cVar = cVarArr2[i];
                        if (cVar != null) {
                            iB += com.ubix.ssp.ad.e.y.c.b.b(3, cVar);
                        }
                        i++;
                    }
                }
                return iB;
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public i a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
                while (true) {
                    int iW = aVar.w();
                    if (iW == 0) {
                        return this;
                    }
                    if (iW == 10) {
                        this.b = aVar.v();
                    } else if (iW == 18) {
                        this.c = aVar.v();
                    } else if (iW == 26) {
                        int iA = com.ubix.ssp.ad.e.y.c.h.a(aVar, 26);
                        c[] cVarArr = this.d;
                        int length = cVarArr == null ? 0 : cVarArr.length;
                        int i = iA + length;
                        c[] cVarArr2 = new c[i];
                        if (length != 0) {
                            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                        }
                        while (length < i - 1) {
                            c cVar = new c();
                            cVarArr2[length] = cVar;
                            aVar.a(cVar);
                            aVar.w();
                            length++;
                        }
                        c cVar2 = new c();
                        cVarArr2[length] = cVar2;
                        aVar.a(cVar2);
                        this.d = cVarArr2;
                    } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                        return this;
                    }
                }
            }

            public i e() {
                this.b = "";
                this.c = "";
                this.d = c.f();
                this.f8939a = -1;
                return this;
            }
        }

        public static final class j extends com.ubix.ssp.ad.e.y.c.f {
            public int b;
            public String c;
            public String d;

            public j() {
                e();
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
                int i = this.b;
                if (i != 0) {
                    bVar.i(1, i);
                }
                if (!this.c.equals("")) {
                    bVar.b(2, this.c);
                }
                if (!this.d.equals("")) {
                    bVar.b(3, this.d);
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
                if (!this.c.equals("")) {
                    iB += com.ubix.ssp.ad.e.y.c.b.a(2, this.c);
                }
                return !this.d.equals("") ? iB + com.ubix.ssp.ad.e.y.c.b.a(3, this.d) : iB;
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public j a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
                while (true) {
                    int iW = aVar.w();
                    if (iW == 0) {
                        return this;
                    }
                    if (iW == 8) {
                        this.b = aVar.k();
                    } else if (iW == 18) {
                        this.c = aVar.v();
                    } else if (iW == 26) {
                        this.d = aVar.v();
                    } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                        return this;
                    }
                }
            }

            public j e() {
                this.b = 0;
                this.c = "";
                this.d = "";
                this.f8939a = -1;
                return this;
            }
        }

        public static final class k extends com.ubix.ssp.ad.e.y.c.f {
            private static volatile k[] b;
            public int c;
            public String[] d;

            public k() {
                e();
            }

            public static k[] f() {
                if (b == null) {
                    synchronized (com.ubix.ssp.ad.e.y.c.c.c) {
                        if (b == null) {
                            b = new k[0];
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
                String[] strArr = this.d;
                if (strArr != null && strArr.length > 0) {
                    int i2 = 0;
                    while (true) {
                        String[] strArr2 = this.d;
                        if (i2 >= strArr2.length) {
                            break;
                        }
                        String str = strArr2[i2];
                        if (str != null) {
                            bVar.b(2, str);
                        }
                        i2++;
                    }
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
                String[] strArr = this.d;
                if (strArr == null || strArr.length <= 0) {
                    return iB;
                }
                int i2 = 0;
                int iA = 0;
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.d;
                    if (i2 >= strArr2.length) {
                        return iB + iA + i3;
                    }
                    String str = strArr2[i2];
                    if (str != null) {
                        i3++;
                        iA += com.ubix.ssp.ad.e.y.c.b.a(str);
                    }
                    i2++;
                }
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public k a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
                while (true) {
                    int iW = aVar.w();
                    if (iW == 0) {
                        return this;
                    }
                    if (iW == 8) {
                        this.c = aVar.k();
                    } else if (iW == 18) {
                        int iA = com.ubix.ssp.ad.e.y.c.h.a(aVar, 18);
                        String[] strArr = this.d;
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
                        this.d = strArr2;
                    } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                        return this;
                    }
                }
            }

            public k e() {
                this.c = 0;
                this.d = com.ubix.ssp.ad.e.y.c.h.f;
                this.f8939a = -1;
                return this;
            }
        }

        public static final class l extends com.ubix.ssp.ad.e.y.c.f {
            public String b;
            public String c;
            public float d;
            public float e;
            public int f;
            public int g;
            public int h;
            public String i;
            public String j;
            public String k;

            public l() {
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
                if (Float.floatToIntBits(this.d) != Float.floatToIntBits(0.0f)) {
                    bVar.b(3, this.d);
                }
                if (Float.floatToIntBits(this.e) != Float.floatToIntBits(0.0f)) {
                    bVar.b(4, this.e);
                }
                int i = this.f;
                if (i != 0) {
                    bVar.i(5, i);
                }
                int i2 = this.g;
                if (i2 != 0) {
                    bVar.i(6, i2);
                }
                int i3 = this.h;
                if (i3 != 0) {
                    bVar.i(7, i3);
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
                if (Float.floatToIntBits(this.d) != Float.floatToIntBits(0.0f)) {
                    iB += com.ubix.ssp.ad.e.y.c.b.a(3, this.d);
                }
                if (Float.floatToIntBits(this.e) != Float.floatToIntBits(0.0f)) {
                    iB += com.ubix.ssp.ad.e.y.c.b.a(4, this.e);
                }
                int i = this.f;
                if (i != 0) {
                    iB += com.ubix.ssp.ad.e.y.c.b.c(5, i);
                }
                int i2 = this.g;
                if (i2 != 0) {
                    iB += com.ubix.ssp.ad.e.y.c.b.c(6, i2);
                }
                int i3 = this.h;
                if (i3 != 0) {
                    iB += com.ubix.ssp.ad.e.y.c.b.c(7, i3);
                }
                if (!this.i.equals("")) {
                    iB += com.ubix.ssp.ad.e.y.c.b.a(8, this.i);
                }
                if (!this.j.equals("")) {
                    iB += com.ubix.ssp.ad.e.y.c.b.a(9, this.j);
                }
                return !this.k.equals("") ? iB + com.ubix.ssp.ad.e.y.c.b.a(10, this.k) : iB;
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public l a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
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
                        case 29:
                            this.d = aVar.j();
                            break;
                        case 37:
                            this.e = aVar.j();
                            break;
                        case 40:
                            this.f = aVar.k();
                            break;
                        case 48:
                            this.g = aVar.k();
                            break;
                        case 56:
                            this.h = aVar.k();
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
                        default:
                            if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                                return this;
                            }
                            break;
                            break;
                    }
                }
            }

            public l e() {
                this.b = "";
                this.c = "";
                this.d = 0.0f;
                this.e = 0.0f;
                this.f = 0;
                this.g = 0;
                this.h = 0;
                this.i = "";
                this.j = "";
                this.k = "";
                this.f8939a = -1;
                return this;
            }
        }

        public static final class m extends com.ubix.ssp.ad.e.y.c.f {
            public String b;
            public String c;
            public String d;
            public String e;

            public m() {
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
                return !this.e.equals("") ? iB + com.ubix.ssp.ad.e.y.c.b.a(4, this.e) : iB;
            }

            @Override // com.ubix.ssp.ad.e.y.c.f
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public m a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
                while (true) {
                    int iW = aVar.w();
                    if (iW == 0) {
                        return this;
                    }
                    if (iW == 10) {
                        this.b = aVar.v();
                    } else if (iW == 18) {
                        this.c = aVar.v();
                    } else if (iW == 26) {
                        this.d = aVar.v();
                    } else if (iW == 34) {
                        this.e = aVar.v();
                    } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                        return this;
                    }
                }
            }

            public m e() {
                this.b = "";
                this.c = "";
                this.d = "";
                this.e = "";
                this.f8939a = -1;
                return this;
            }
        }

        public b() {
            e();
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
            if (!this.b.equals("")) {
                bVar.b(1, this.b);
            }
            int i2 = this.c;
            if (i2 != 0) {
                bVar.i(2, i2);
            }
            int i3 = this.d;
            if (i3 != 0) {
                bVar.i(3, i3);
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
            C1109b[] c1109bArr = this.j;
            int i4 = 0;
            if (c1109bArr != null && c1109bArr.length > 0) {
                int i5 = 0;
                while (true) {
                    C1109b[] c1109bArr2 = this.j;
                    if (i5 >= c1109bArr2.length) {
                        break;
                    }
                    C1109b c1109b = c1109bArr2[i5];
                    if (c1109b != null) {
                        bVar.d(9, c1109b);
                    }
                    i5++;
                }
            }
            l lVar = this.k;
            if (lVar != null) {
                bVar.d(10, lVar);
            }
            int i6 = this.l;
            if (i6 != 0) {
                bVar.i(11, i6);
            }
            if (!this.m.equals("")) {
                bVar.b(12, this.m);
            }
            if (!this.n.equals("")) {
                bVar.b(13, this.n);
            }
            if (!this.o.equals("")) {
                bVar.b(14, this.o);
            }
            k[] kVarArr = this.p;
            if (kVarArr != null && kVarArr.length > 0) {
                int i7 = 0;
                while (true) {
                    k[] kVarArr2 = this.p;
                    if (i7 >= kVarArr2.length) {
                        break;
                    }
                    k kVar = kVarArr2[i7];
                    if (kVar != null) {
                        bVar.d(15, kVar);
                    }
                    i7++;
                }
            }
            String[] strArr = this.q;
            if (strArr != null && strArr.length > 0) {
                while (true) {
                    String[] strArr2 = this.q;
                    if (i4 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i4];
                    if (str != null) {
                        bVar.b(16, str);
                    }
                    i4++;
                }
            }
            if (!this.r.equals("")) {
                bVar.b(17, this.r);
            }
            int i8 = this.s;
            if (i8 != 0) {
                bVar.i(18, i8);
            }
            if (!this.t.equals("")) {
                bVar.b(19, this.t);
            }
            m mVar = this.u;
            if (mVar != null) {
                bVar.d(20, mVar);
            }
            if (!this.v.equals("")) {
                bVar.b(21, this.v);
            }
            if (!this.w.equals("")) {
                bVar.b(22, this.w);
            }
            if (!this.x.equals("")) {
                bVar.b(23, this.x);
            }
            if (Float.floatToIntBits(this.y) != Float.floatToIntBits(0.0f)) {
                bVar.b(24, this.y);
            }
            if (!this.z.equals("")) {
                bVar.b(25, this.z);
            }
            if (!this.A.equals("")) {
                bVar.b(26, this.A);
            }
            if (!this.B.equals("")) {
                bVar.b(27, this.B);
            }
            if (!this.C.equals("")) {
                bVar.b(28, this.C);
            }
            if (!this.D.equals("")) {
                bVar.b(29, this.D);
            }
            if (!this.E.equals("")) {
                bVar.b(30, this.E);
            }
            if (!this.F.equals("")) {
                bVar.b(35, this.F);
            }
            long j2 = this.G;
            if (j2 != 0) {
                bVar.g(36, j2);
            }
            if (!this.H.equals("")) {
                bVar.b(37, this.H);
            }
            if (!this.I.equals("")) {
                bVar.b(38, this.I);
            }
            if (!this.J.equals("")) {
                bVar.b(39, this.J);
            }
            i iVar = this.K;
            if (iVar != null) {
                bVar.d(40, iVar);
            }
            f fVar = this.L;
            if (fVar != null) {
                bVar.d(41, fVar);
            }
            int i9 = this.M;
            if (i9 != 0) {
                bVar.i(42, i9);
            }
            boolean z = this.N;
            if (z) {
                bVar.b(43, z);
            }
            C1108a c1108a = this.O;
            if (c1108a != null) {
                bVar.d(44, c1108a);
            }
            d dVar = this.P;
            if (dVar != null) {
                bVar.d(45, dVar);
            }
            g gVar = this.Q;
            if (gVar != null) {
                bVar.d(46, gVar);
            }
            if (!this.R.equals("")) {
                bVar.b(47, this.R);
            }
            j jVar = this.S;
            if (jVar != null) {
                bVar.d(48, jVar);
            }
            super.a(bVar);
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        protected int b() {
            int iB = super.b();
            if (!this.b.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(1, this.b);
            }
            int i2 = this.c;
            if (i2 != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(2, i2);
            }
            int i3 = this.d;
            if (i3 != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(3, i3);
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
            C1109b[] c1109bArr = this.j;
            int i4 = 0;
            if (c1109bArr != null && c1109bArr.length > 0) {
                int i5 = 0;
                while (true) {
                    C1109b[] c1109bArr2 = this.j;
                    if (i5 >= c1109bArr2.length) {
                        break;
                    }
                    C1109b c1109b = c1109bArr2[i5];
                    if (c1109b != null) {
                        iB += com.ubix.ssp.ad.e.y.c.b.b(9, c1109b);
                    }
                    i5++;
                }
            }
            l lVar = this.k;
            if (lVar != null) {
                iB += com.ubix.ssp.ad.e.y.c.b.b(10, lVar);
            }
            int i6 = this.l;
            if (i6 != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(11, i6);
            }
            if (!this.m.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(12, this.m);
            }
            if (!this.n.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(13, this.n);
            }
            if (!this.o.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(14, this.o);
            }
            k[] kVarArr = this.p;
            if (kVarArr != null && kVarArr.length > 0) {
                int i7 = 0;
                while (true) {
                    k[] kVarArr2 = this.p;
                    if (i7 >= kVarArr2.length) {
                        break;
                    }
                    k kVar = kVarArr2[i7];
                    if (kVar != null) {
                        iB += com.ubix.ssp.ad.e.y.c.b.b(15, kVar);
                    }
                    i7++;
                }
            }
            String[] strArr = this.q;
            if (strArr != null && strArr.length > 0) {
                int iA = 0;
                int i8 = 0;
                while (true) {
                    String[] strArr2 = this.q;
                    if (i4 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i4];
                    if (str != null) {
                        i8++;
                        iA += com.ubix.ssp.ad.e.y.c.b.a(str);
                    }
                    i4++;
                }
                iB = iB + iA + (i8 * 2);
            }
            if (!this.r.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(17, this.r);
            }
            int i9 = this.s;
            if (i9 != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(18, i9);
            }
            if (!this.t.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(19, this.t);
            }
            m mVar = this.u;
            if (mVar != null) {
                iB += com.ubix.ssp.ad.e.y.c.b.b(20, mVar);
            }
            if (!this.v.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(21, this.v);
            }
            if (!this.w.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(22, this.w);
            }
            if (!this.x.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(23, this.x);
            }
            if (Float.floatToIntBits(this.y) != Float.floatToIntBits(0.0f)) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(24, this.y);
            }
            if (!this.z.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(25, this.z);
            }
            if (!this.A.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(26, this.A);
            }
            if (!this.B.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(27, this.B);
            }
            if (!this.C.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(28, this.C);
            }
            if (!this.D.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(29, this.D);
            }
            if (!this.E.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(30, this.E);
            }
            if (!this.F.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(35, this.F);
            }
            long j2 = this.G;
            if (j2 != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.b(36, j2);
            }
            if (!this.H.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(37, this.H);
            }
            if (!this.I.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(38, this.I);
            }
            if (!this.J.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(39, this.J);
            }
            i iVar = this.K;
            if (iVar != null) {
                iB += com.ubix.ssp.ad.e.y.c.b.b(40, iVar);
            }
            f fVar = this.L;
            if (fVar != null) {
                iB += com.ubix.ssp.ad.e.y.c.b.b(41, fVar);
            }
            int i10 = this.M;
            if (i10 != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(42, i10);
            }
            boolean z = this.N;
            if (z) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(43, z);
            }
            C1108a c1108a = this.O;
            if (c1108a != null) {
                iB += com.ubix.ssp.ad.e.y.c.b.b(44, c1108a);
            }
            d dVar = this.P;
            if (dVar != null) {
                iB += com.ubix.ssp.ad.e.y.c.b.b(45, dVar);
            }
            g gVar = this.Q;
            if (gVar != null) {
                iB += com.ubix.ssp.ad.e.y.c.b.b(46, gVar);
            }
            if (!this.R.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(47, this.R);
            }
            j jVar = this.S;
            return jVar != null ? iB + com.ubix.ssp.ad.e.y.c.b.b(48, jVar) : iB;
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
                        this.b = aVar.v();
                        continue;
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
                        int iA = com.ubix.ssp.ad.e.y.c.h.a(aVar, 74);
                        C1109b[] c1109bArr = this.j;
                        int length = c1109bArr == null ? 0 : c1109bArr.length;
                        int i2 = iA + length;
                        C1109b[] c1109bArr2 = new C1109b[i2];
                        if (length != 0) {
                            System.arraycopy(c1109bArr, 0, c1109bArr2, 0, length);
                        }
                        while (length < i2 - 1) {
                            C1109b c1109b = new C1109b();
                            c1109bArr2[length] = c1109b;
                            aVar.a(c1109b);
                            aVar.w();
                            length++;
                        }
                        C1109b c1109b2 = new C1109b();
                        c1109bArr2[length] = c1109b2;
                        aVar.a(c1109b2);
                        this.j = c1109bArr2;
                        continue;
                    case 82:
                        if (this.k == null) {
                            this.k = new l();
                        }
                        fVar = this.k;
                        break;
                    case 88:
                        this.l = aVar.k();
                        continue;
                    case 98:
                        this.m = aVar.v();
                        continue;
                    case 106:
                        this.n = aVar.v();
                        continue;
                    case 114:
                        this.o = aVar.v();
                        continue;
                    case 122:
                        int iA2 = com.ubix.ssp.ad.e.y.c.h.a(aVar, 122);
                        k[] kVarArr = this.p;
                        int length2 = kVarArr == null ? 0 : kVarArr.length;
                        int i3 = iA2 + length2;
                        k[] kVarArr2 = new k[i3];
                        if (length2 != 0) {
                            System.arraycopy(kVarArr, 0, kVarArr2, 0, length2);
                        }
                        while (length2 < i3 - 1) {
                            k kVar = new k();
                            kVarArr2[length2] = kVar;
                            aVar.a(kVar);
                            aVar.w();
                            length2++;
                        }
                        k kVar2 = new k();
                        kVarArr2[length2] = kVar2;
                        aVar.a(kVar2);
                        this.p = kVarArr2;
                        continue;
                    case 130:
                        int iA3 = com.ubix.ssp.ad.e.y.c.h.a(aVar, 130);
                        String[] strArr = this.q;
                        int length3 = strArr == null ? 0 : strArr.length;
                        int i4 = iA3 + length3;
                        String[] strArr2 = new String[i4];
                        if (length3 != 0) {
                            System.arraycopy(strArr, 0, strArr2, 0, length3);
                        }
                        while (length3 < i4 - 1) {
                            strArr2[length3] = aVar.v();
                            aVar.w();
                            length3++;
                        }
                        strArr2[length3] = aVar.v();
                        this.q = strArr2;
                        continue;
                    case 138:
                        this.r = aVar.v();
                        continue;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_SPADE /* 144 */:
                        this.s = aVar.k();
                        continue;
                    case 154:
                        this.t = aVar.v();
                        continue;
                    case 162:
                        if (this.u == null) {
                            this.u = new m();
                        }
                        fVar = this.u;
                        break;
                    case 170:
                        this.v = aVar.v();
                        continue;
                    case 178:
                        this.w = aVar.v();
                        continue;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS /* 186 */:
                        this.x = aVar.v();
                        continue;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY /* 197 */:
                        this.y = aVar.j();
                        continue;
                    case 202:
                        this.z = aVar.v();
                        continue;
                    case 210:
                        this.A = aVar.v();
                        continue;
                    case JfifUtil.MARKER_SOS /* 218 */:
                        this.B = aVar.v();
                        continue;
                    case 226:
                        this.C = aVar.v();
                        continue;
                    case 234:
                        this.D = aVar.v();
                        continue;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE /* 242 */:
                        this.E = aVar.v();
                        continue;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS /* 282 */:
                        this.F = aVar.v();
                        continue;
                    case 288:
                        this.G = aVar.l();
                        continue;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX /* 298 */:
                        this.H = aVar.v();
                        continue;
                    case 306:
                        this.I = aVar.v();
                        continue;
                    case 314:
                        this.J = aVar.v();
                        continue;
                    case 322:
                        if (this.K == null) {
                            this.K = new i();
                        }
                        fVar = this.K;
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_OPEN_VIDEO_FIRST /* 330 */:
                        if (this.L == null) {
                            this.L = new f();
                        }
                        fVar = this.L;
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME /* 336 */:
                        this.M = aVar.k();
                        continue;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS /* 344 */:
                        this.N = aVar.d();
                        continue;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_CERT_VERIFY /* 354 */:
                        if (this.O == null) {
                            this.O = new C1108a();
                        }
                        fVar = this.O;
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_STALL_THRESHOLD /* 362 */:
                        if (this.P == null) {
                            this.P = new d();
                        }
                        fVar = this.P;
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT /* 370 */:
                        if (this.Q == null) {
                            this.Q = new g();
                        }
                        fVar = this.Q;
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_SET_AUDIO_DEVICE_TYPE /* 378 */:
                        this.R = aVar.v();
                        continue;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_PRE_STALL_500 /* 386 */:
                        if (this.S == null) {
                            this.S = new j();
                        }
                        fVar = this.S;
                        break;
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
            this.b = "";
            this.c = 0;
            this.d = 0;
            this.e = "";
            this.f = "";
            this.g = "";
            this.h = "";
            this.i = "";
            this.j = C1109b.f();
            this.k = null;
            this.l = 0;
            this.m = "";
            this.n = "";
            this.o = "";
            this.p = k.f();
            this.q = com.ubix.ssp.ad.e.y.c.h.f;
            this.r = "";
            this.s = 0;
            this.t = "";
            this.u = null;
            this.v = "";
            this.w = "";
            this.x = "";
            this.y = 0.0f;
            this.z = "";
            this.A = "";
            this.B = "";
            this.C = "";
            this.D = "";
            this.E = "";
            this.F = "";
            this.G = 0L;
            this.H = "";
            this.I = "";
            this.J = "";
            this.K = null;
            this.L = null;
            this.M = 0;
            this.N = false;
            this.O = null;
            this.P = null;
            this.Q = null;
            this.R = "";
            this.S = null;
            this.f8939a = -1;
            return this;
        }
    }

    public static final class c extends com.ubix.ssp.ad.e.y.c.f {
        public String b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public String n;
        public boolean o;
        public float p;
        public String q;
        public boolean r;
        public int s;

        public c() {
            e();
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
            if (!this.b.equals("")) {
                bVar.b(5, this.b);
            }
            int i = this.c;
            if (i != 0) {
                bVar.i(6, i);
            }
            int i2 = this.d;
            if (i2 != 0) {
                bVar.i(7, i2);
            }
            int i3 = this.e;
            if (i3 != 0) {
                bVar.i(8, i3);
            }
            int i4 = this.f;
            if (i4 != 0) {
                bVar.i(9, i4);
            }
            int i5 = this.g;
            if (i5 != 0) {
                bVar.i(10, i5);
            }
            int i6 = this.h;
            if (i6 != 0) {
                bVar.i(11, i6);
            }
            int i7 = this.i;
            if (i7 != 0) {
                bVar.i(12, i7);
            }
            int i8 = this.j;
            if (i8 != 0) {
                bVar.i(13, i8);
            }
            int i9 = this.k;
            if (i9 != 0) {
                bVar.i(14, i9);
            }
            int i10 = this.l;
            if (i10 != 0) {
                bVar.i(15, i10);
            }
            int i11 = this.m;
            if (i11 != 0) {
                bVar.i(16, i11);
            }
            if (!this.n.equals("")) {
                bVar.b(17, this.n);
            }
            boolean z = this.o;
            if (z) {
                bVar.b(18, z);
            }
            if (Float.floatToIntBits(this.p) != Float.floatToIntBits(0.0f)) {
                bVar.b(19, this.p);
            }
            if (!this.q.equals("")) {
                bVar.b(20, this.q);
            }
            boolean z2 = this.r;
            if (z2) {
                bVar.b(21, z2);
            }
            int i12 = this.s;
            if (i12 != 0) {
                bVar.i(22, i12);
            }
            super.a(bVar);
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        protected int b() {
            int iB = super.b();
            if (!this.b.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(5, this.b);
            }
            int i = this.c;
            if (i != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(6, i);
            }
            int i2 = this.d;
            if (i2 != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(7, i2);
            }
            int i3 = this.e;
            if (i3 != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(8, i3);
            }
            int i4 = this.f;
            if (i4 != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(9, i4);
            }
            int i5 = this.g;
            if (i5 != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(10, i5);
            }
            int i6 = this.h;
            if (i6 != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(11, i6);
            }
            int i7 = this.i;
            if (i7 != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(12, i7);
            }
            int i8 = this.j;
            if (i8 != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(13, i8);
            }
            int i9 = this.k;
            if (i9 != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(14, i9);
            }
            int i10 = this.l;
            if (i10 != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(15, i10);
            }
            int i11 = this.m;
            if (i11 != 0) {
                iB += com.ubix.ssp.ad.e.y.c.b.c(16, i11);
            }
            if (!this.n.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(17, this.n);
            }
            boolean z = this.o;
            if (z) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(18, z);
            }
            if (Float.floatToIntBits(this.p) != Float.floatToIntBits(0.0f)) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(19, this.p);
            }
            if (!this.q.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(20, this.q);
            }
            boolean z2 = this.r;
            if (z2) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(21, z2);
            }
            int i12 = this.s;
            return i12 != 0 ? iB + com.ubix.ssp.ad.e.y.c.b.c(22, i12) : iB;
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
            while (true) {
                int iW = aVar.w();
                switch (iW) {
                    case 0:
                        return this;
                    case 42:
                        this.b = aVar.v();
                        break;
                    case 48:
                        this.c = aVar.k();
                        break;
                    case 56:
                        this.d = aVar.k();
                        break;
                    case 64:
                        this.e = aVar.k();
                        break;
                    case 72:
                        this.f = aVar.k();
                        break;
                    case 80:
                        this.g = aVar.k();
                        break;
                    case 88:
                        this.h = aVar.k();
                        break;
                    case 96:
                        this.i = aVar.k();
                        break;
                    case 104:
                        this.j = aVar.k();
                        break;
                    case 112:
                        this.k = aVar.k();
                        break;
                    case 120:
                        this.l = aVar.k();
                        break;
                    case 128:
                        this.m = aVar.k();
                        break;
                    case 138:
                        this.n = aVar.v();
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_SPADE /* 144 */:
                        this.o = aVar.d();
                        break;
                    case 157:
                        this.p = aVar.j();
                        break;
                    case 162:
                        this.q = aVar.v();
                        break;
                    case Opcodes.JSR /* 168 */:
                        this.r = aVar.d();
                        break;
                    case 176:
                        this.s = aVar.k();
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

        public c e() {
            this.b = "";
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0;
            this.m = 0;
            this.n = "";
            this.o = false;
            this.p = 0.0f;
            this.q = "";
            this.r = false;
            this.s = 0;
            this.f8939a = -1;
            return this;
        }
    }

    public a() {
        e();
    }

    public static a a(byte[] bArr) {
        return (a) com.ubix.ssp.ad.e.y.c.f.a(new a(), bArr);
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
        b bVar2 = this.d;
        if (bVar2 != null) {
            bVar.d(2, bVar2);
        }
        long j = this.e;
        if (j != 0) {
            bVar.j(3, j);
        }
        c cVar = this.f;
        if (cVar != null) {
            bVar.d(4, cVar);
        }
        int i = this.g;
        if (i != 0) {
            bVar.i(5, i);
        }
        int i2 = this.h;
        if (i2 != 0) {
            bVar.i(6, i2);
        }
        if (!this.i.equals("")) {
            bVar.b(7, this.i);
        }
        long j2 = this.j;
        if (j2 != 0) {
            bVar.g(8, j2);
        }
        boolean z = this.k;
        if (z) {
            bVar.b(9, z);
        }
        C1107a c1107a = this.l;
        if (c1107a != null) {
            bVar.d(10, c1107a);
        }
        if (!this.m.equals("")) {
            bVar.b(11, this.m);
        }
        super.a(bVar);
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    protected int b() {
        int iB = super.b();
        if (!this.c.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(1, this.c);
        }
        b bVar = this.d;
        if (bVar != null) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(2, bVar);
        }
        long j = this.e;
        if (j != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.e(3, j);
        }
        c cVar = this.f;
        if (cVar != null) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(4, cVar);
        }
        int i = this.g;
        if (i != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(5, i);
        }
        int i2 = this.h;
        if (i2 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(6, i2);
        }
        if (!this.i.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(7, this.i);
        }
        long j2 = this.j;
        if (j2 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(8, j2);
        }
        boolean z = this.k;
        if (z) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(9, z);
        }
        C1107a c1107a = this.l;
        if (c1107a != null) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(10, c1107a);
        }
        return !this.m.equals("") ? iB + com.ubix.ssp.ad.e.y.c.b.a(11, this.m) : iB;
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
        com.ubix.ssp.ad.e.y.c.f fVar;
        while (true) {
            int iW = aVar.w();
            switch (iW) {
                case 0:
                    return this;
                case 10:
                    this.c = aVar.v();
                    continue;
                case 18:
                    if (this.d == null) {
                        this.d = new b();
                    }
                    fVar = this.d;
                    break;
                case 24:
                    this.e = aVar.y();
                    continue;
                case 34:
                    if (this.f == null) {
                        this.f = new c();
                    }
                    fVar = this.f;
                    break;
                case 40:
                    this.g = aVar.k();
                    continue;
                case 48:
                    this.h = aVar.k();
                    continue;
                case 58:
                    this.i = aVar.v();
                    continue;
                case 64:
                    this.j = aVar.l();
                    continue;
                case 72:
                    this.k = aVar.d();
                    continue;
                case 82:
                    if (this.l == null) {
                        this.l = new C1107a();
                    }
                    fVar = this.l;
                    break;
                case 90:
                    this.m = aVar.v();
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

    public a e() {
        this.c = "";
        this.d = null;
        this.e = 0L;
        this.f = null;
        this.g = 0;
        this.h = 0;
        this.i = "";
        this.j = 0L;
        this.k = false;
        this.l = null;
        this.m = "";
        this.f8939a = -1;
        return this;
    }
}
