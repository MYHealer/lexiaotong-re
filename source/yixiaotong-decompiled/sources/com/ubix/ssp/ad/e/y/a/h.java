package com.ubix.ssp.ad.e.y.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class h extends com.ubix.ssp.ad.e.y.c.f {
    public b b;
    public a c;

    public static final class a extends com.ubix.ssp.ad.e.y.c.f {
        public String b;

        public a() {
            e();
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
            if (!this.b.equals("")) {
                bVar.b(1, this.b);
            }
            super.a(bVar);
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        protected int b() {
            int iB = super.b();
            return !this.b.equals("") ? iB + com.ubix.ssp.ad.e.y.c.b.a(1, this.b) : iB;
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
                    this.b = aVar.v();
                } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                    return this;
                }
            }
        }

        public a e() {
            this.b = "";
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
        public float g;
        public String h;
        public String i;
        public String j;

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
            if (Float.floatToIntBits(this.g) != Float.floatToIntBits(0.0f)) {
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
            if (Float.floatToIntBits(this.g) != Float.floatToIntBits(0.0f)) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(6, this.g);
            }
            if (!this.h.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(7, this.h);
            }
            if (!this.i.equals("")) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(8, this.i);
            }
            return !this.j.equals("") ? iB + com.ubix.ssp.ad.e.y.c.b.a(9, this.j) : iB;
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
                } else if (iW == 26) {
                    this.d = aVar.v();
                } else if (iW == 34) {
                    this.e = aVar.v();
                } else if (iW == 42) {
                    this.f = aVar.v();
                } else if (iW == 53) {
                    this.g = aVar.j();
                } else if (iW == 58) {
                    this.h = aVar.v();
                } else if (iW == 66) {
                    this.i = aVar.v();
                } else if (iW == 74) {
                    this.j = aVar.v();
                } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                    return this;
                }
            }
        }

        public b e() {
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = "";
            this.g = 0.0f;
            this.h = "";
            this.i = "";
            this.j = "";
            this.f8939a = -1;
            return this;
        }
    }

    public h() {
        e();
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
        b bVar2 = this.b;
        if (bVar2 != null) {
            bVar.d(1, bVar2);
        }
        a aVar = this.c;
        if (aVar != null) {
            bVar.d(2, aVar);
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
        a aVar = this.c;
        return aVar != null ? iB + com.ubix.ssp.ad.e.y.c.b.b(2, aVar) : iB;
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public h a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
        com.ubix.ssp.ad.e.y.c.f fVar;
        while (true) {
            int iW = aVar.w();
            if (iW == 0) {
                return this;
            }
            if (iW == 10) {
                if (this.b == null) {
                    this.b = new b();
                }
                fVar = this.b;
            } else if (iW == 18) {
                if (this.c == null) {
                    this.c = new a();
                }
                fVar = this.c;
            } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                return this;
            }
            aVar.a(fVar);
        }
    }

    public h e() {
        this.b = null;
        this.c = null;
        this.f8939a = -1;
        return this;
    }
}
