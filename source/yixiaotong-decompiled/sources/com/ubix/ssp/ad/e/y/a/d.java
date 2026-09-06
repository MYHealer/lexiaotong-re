package com.ubix.ssp.ad.e.y.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class d extends com.ubix.ssp.ad.e.y.c.f {
    public String b;
    public String c;
    public k d;
    public c e;
    public f f;
    public b[] g;
    public String h;
    public String i;
    public int j;
    public String k;

    public d() {
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
        k kVar = this.d;
        if (kVar != null) {
            bVar.d(3, kVar);
        }
        c cVar = this.e;
        if (cVar != null) {
            bVar.d(4, cVar);
        }
        f fVar = this.f;
        if (fVar != null) {
            bVar.d(5, fVar);
        }
        b[] bVarArr = this.g;
        if (bVarArr != null && bVarArr.length > 0) {
            int i = 0;
            while (true) {
                b[] bVarArr2 = this.g;
                if (i >= bVarArr2.length) {
                    break;
                }
                b bVar2 = bVarArr2[i];
                if (bVar2 != null) {
                    bVar.d(6, bVar2);
                }
                i++;
            }
        }
        if (!this.h.equals("")) {
            bVar.b(7, this.h);
        }
        if (!this.i.equals("")) {
            bVar.b(8, this.i);
        }
        int i2 = this.j;
        if (i2 != 0) {
            bVar.i(9, i2);
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
        k kVar = this.d;
        if (kVar != null) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(3, kVar);
        }
        c cVar = this.e;
        if (cVar != null) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(4, cVar);
        }
        f fVar = this.f;
        if (fVar != null) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(5, fVar);
        }
        b[] bVarArr = this.g;
        if (bVarArr != null && bVarArr.length > 0) {
            int i = 0;
            while (true) {
                b[] bVarArr2 = this.g;
                if (i >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i];
                if (bVar != null) {
                    iB += com.ubix.ssp.ad.e.y.c.b.b(6, bVar);
                }
                i++;
            }
        }
        if (!this.h.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(7, this.h);
        }
        if (!this.i.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(8, this.i);
        }
        int i2 = this.j;
        if (i2 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(9, i2);
        }
        return !this.k.equals("") ? iB + com.ubix.ssp.ad.e.y.c.b.a(10, this.k) : iB;
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public d a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
        com.ubix.ssp.ad.e.y.c.f fVar;
        while (true) {
            int iW = aVar.w();
            switch (iW) {
                case 0:
                    return this;
                case 10:
                    this.b = aVar.v();
                    continue;
                case 18:
                    this.c = aVar.v();
                    continue;
                case 26:
                    if (this.d == null) {
                        this.d = new k();
                    }
                    fVar = this.d;
                    break;
                case 34:
                    if (this.e == null) {
                        this.e = new c();
                    }
                    fVar = this.e;
                    break;
                case 42:
                    if (this.f == null) {
                        this.f = new f();
                    }
                    fVar = this.f;
                    break;
                case 50:
                    int iA = com.ubix.ssp.ad.e.y.c.h.a(aVar, 50);
                    b[] bVarArr = this.g;
                    int length = bVarArr == null ? 0 : bVarArr.length;
                    int i = iA + length;
                    b[] bVarArr2 = new b[i];
                    if (length != 0) {
                        System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                    }
                    while (length < i - 1) {
                        b bVar = new b();
                        bVarArr2[length] = bVar;
                        aVar.a(bVar);
                        aVar.w();
                        length++;
                    }
                    b bVar2 = new b();
                    bVarArr2[length] = bVar2;
                    aVar.a(bVar2);
                    this.g = bVarArr2;
                    continue;
                case 58:
                    this.h = aVar.v();
                    continue;
                case 66:
                    this.i = aVar.v();
                    continue;
                case 72:
                    this.j = aVar.k();
                    continue;
                case 82:
                    this.k = aVar.v();
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

    public d e() {
        this.b = "";
        this.c = "";
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = b.f();
        this.h = "";
        this.i = "";
        this.j = 0;
        this.k = "";
        this.f8939a = -1;
        return this;
    }
}
