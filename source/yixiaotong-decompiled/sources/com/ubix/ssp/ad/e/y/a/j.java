package com.ubix.ssp.ad.e.y.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class j extends com.ubix.ssp.ad.e.y.c.f {
    private static volatile j[] b;
    public int c;
    public String d;
    public long e;

    public j() {
        e();
    }

    public static j[] f() {
        if (b == null) {
            synchronized (com.ubix.ssp.ad.e.y.c.c.c) {
                if (b == null) {
                    b = new j[0];
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
        if (!this.d.equals("")) {
            bVar.b(2, this.d);
        }
        long j = this.e;
        if (j != 0) {
            bVar.j(3, j);
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
        if (!this.d.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(2, this.d);
        }
        long j = this.e;
        return j != 0 ? iB + com.ubix.ssp.ad.e.y.c.b.e(3, j) : iB;
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
                this.c = aVar.k();
            } else if (iW == 18) {
                this.d = aVar.v();
            } else if (iW == 24) {
                this.e = aVar.y();
            } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                return this;
            }
        }
    }

    public j e() {
        this.c = 0;
        this.d = "";
        this.e = 0L;
        this.f8939a = -1;
        return this;
    }
}
