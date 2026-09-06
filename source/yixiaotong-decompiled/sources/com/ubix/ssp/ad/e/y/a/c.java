package com.ubix.ssp.ad.e.y.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class c extends com.ubix.ssp.ad.e.y.c.f {
    public String b;
    public String c;
    public String d;
    public String e;
    public a f;
    public boolean g;
    public String h;
    public String[] i;
    public String j;
    public String k;
    public String l;

    public static final class a extends com.ubix.ssp.ad.e.y.c.f {
        public double b;
        public double c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        public a() {
            e();
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
            if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(0.0d)) {
                bVar.b(1, this.b);
            }
            if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(0.0d)) {
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
            super.a(bVar);
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        protected int b() {
            int iB = super.b();
            if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(0.0d)) {
                iB += com.ubix.ssp.ad.e.y.c.b.a(1, this.b);
            }
            if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(0.0d)) {
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
            return !this.h.equals("") ? iB + com.ubix.ssp.ad.e.y.c.b.a(7, this.h) : iB;
        }

        @Override // com.ubix.ssp.ad.e.y.c.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
            while (true) {
                int iW = aVar.w();
                if (iW == 0) {
                    return this;
                }
                if (iW == 9) {
                    this.b = aVar.f();
                } else if (iW == 17) {
                    this.c = aVar.f();
                } else if (iW == 26) {
                    this.d = aVar.v();
                } else if (iW == 34) {
                    this.e = aVar.v();
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

        public a e() {
            this.b = 0.0d;
            this.c = 0.0d;
            this.d = "";
            this.e = "";
            this.f = "";
            this.g = "";
            this.h = "";
            this.f8939a = -1;
            return this;
        }
    }

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
        if (!this.d.equals("")) {
            bVar.b(3, this.d);
        }
        if (!this.e.equals("")) {
            bVar.b(4, this.e);
        }
        a aVar = this.f;
        if (aVar != null) {
            bVar.d(5, aVar);
        }
        boolean z = this.g;
        if (z) {
            bVar.b(6, z);
        }
        if (!this.h.equals("")) {
            bVar.b(7, this.h);
        }
        String[] strArr = this.i;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.i;
                if (i >= strArr2.length) {
                    break;
                }
                String str = strArr2[i];
                if (str != null) {
                    bVar.b(8, str);
                }
                i++;
            }
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
        a aVar = this.f;
        if (aVar != null) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(5, aVar);
        }
        boolean z = this.g;
        if (z) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(6, z);
        }
        if (!this.h.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(7, this.h);
        }
        String[] strArr = this.i;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            int iA = 0;
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.i;
                if (i >= strArr2.length) {
                    break;
                }
                String str = strArr2[i];
                if (str != null) {
                    i2++;
                    iA += com.ubix.ssp.ad.e.y.c.b.a(str);
                }
                i++;
            }
            iB = iB + iA + i2;
        }
        if (!this.j.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(9, this.j);
        }
        if (!this.k.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(10, this.k);
        }
        return !this.l.equals("") ? iB + com.ubix.ssp.ad.e.y.c.b.a(11, this.l) : iB;
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
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
                    if (this.f == null) {
                        this.f = new a();
                    }
                    aVar.a(this.f);
                    break;
                case 48:
                    this.g = aVar.d();
                    break;
                case 58:
                    this.h = aVar.v();
                    break;
                case 66:
                    int iA = com.ubix.ssp.ad.e.y.c.h.a(aVar, 66);
                    String[] strArr = this.i;
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
                    this.i = strArr2;
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
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = null;
        this.g = false;
        this.h = "";
        this.i = com.ubix.ssp.ad.e.y.c.h.f;
        this.j = "";
        this.k = "";
        this.l = "";
        this.f8939a = -1;
        return this;
    }
}
