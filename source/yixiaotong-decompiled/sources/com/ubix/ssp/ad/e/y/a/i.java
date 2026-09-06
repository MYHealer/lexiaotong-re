package com.ubix.ssp.ad.e.y.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class i extends com.ubix.ssp.ad.e.y.c.f {
    private static volatile i[] b;
    public int c;
    public int d;
    public String e;

    public i() {
        e();
    }

    public static i[] f() {
        if (b == null) {
            synchronized (com.ubix.ssp.ad.e.y.c.c.c) {
                if (b == null) {
                    b = new i[0];
                }
            }
        }
        return b;
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
        int i = this.c;
        if (i != 0) {
            bVar.m(1, i);
        }
        int i2 = this.d;
        if (i2 != 0) {
            bVar.m(2, i2);
        }
        if (!this.e.equals("")) {
            bVar.b(3, this.e);
        }
        super.a(bVar);
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    protected int b() {
        int iB = super.b();
        int i = this.c;
        if (i != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.f(1, i);
        }
        int i2 = this.d;
        if (i2 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.f(2, i2);
        }
        return !this.e.equals("") ? iB + com.ubix.ssp.ad.e.y.c.b.a(3, this.e) : iB;
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
        while (true) {
            int iW = aVar.w();
            if (iW == 0) {
                return this;
            }
            if (iW == 8) {
                this.c = aVar.x();
            } else if (iW == 16) {
                this.d = aVar.x();
            } else if (iW == 26) {
                this.e = aVar.v();
            } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                return this;
            }
        }
    }

    public i e() {
        this.c = 0;
        this.d = 0;
        this.e = "";
        this.f8939a = -1;
        return this;
    }
}
