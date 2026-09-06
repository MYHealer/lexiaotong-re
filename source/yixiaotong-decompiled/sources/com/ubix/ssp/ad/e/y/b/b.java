package com.ubix.ssp.ad.e.y.b;

import com.ubix.ssp.ad.e.y.c.d;
import com.ubix.ssp.ad.e.y.c.f;
import com.ubix.ssp.ad.e.y.c.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class b extends f {
    public String b;
    public String c;
    public long d;
    public int e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public a[] m;
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
        long j = this.d;
        if (j != 0) {
            bVar.g(3, j);
        }
        int i = this.e;
        if (i != 0) {
            bVar.i(4, i);
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
        a[] aVarArr = this.m;
        if (aVarArr != null && aVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                a[] aVarArr2 = this.m;
                if (i2 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i2];
                if (aVar != null) {
                    bVar.d(12, aVar);
                }
                i2++;
            }
        }
        if (!this.n.equals("")) {
            bVar.b(13, this.n);
        }
        if (!this.o.equals("")) {
            bVar.b(14, this.o);
        }
        if (!this.p.equals("")) {
            bVar.b(15, this.p);
        }
        if (!this.q.equals("")) {
            bVar.b(16, this.q);
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
        int i = this.e;
        if (i != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.c(4, i);
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
        a[] aVarArr = this.m;
        if (aVarArr != null && aVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                a[] aVarArr2 = this.m;
                if (i2 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i2];
                if (aVar != null) {
                    iB += com.ubix.ssp.ad.e.y.c.b.b(12, aVar);
                }
                i2++;
            }
        }
        if (!this.n.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(13, this.n);
        }
        if (!this.o.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(14, this.o);
        }
        if (!this.p.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(15, this.p);
        }
        return !this.q.equals("") ? iB + com.ubix.ssp.ad.e.y.c.b.a(16, this.q) : iB;
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(com.ubix.ssp.ad.e.y.c.a aVar) throws d {
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
                case 24:
                    this.d = aVar.l();
                    break;
                case 32:
                    this.e = aVar.k();
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
                    int iA = h.a(aVar, 98);
                    a[] aVarArr = this.m;
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
                    this.m = aVarArr2;
                    break;
                case 106:
                    this.n = aVar.v();
                    break;
                case 114:
                    this.o = aVar.v();
                    break;
                case 122:
                    this.p = aVar.v();
                    break;
                case 130:
                    this.q = aVar.v();
                    break;
                default:
                    if (!h.b(aVar, iW)) {
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
        this.d = 0L;
        this.e = 0;
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = a.f();
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.f8939a = -1;
        return this;
    }
}
