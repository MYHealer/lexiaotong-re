package com.ubix.ssp.ad.e.y.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class e extends com.ubix.ssp.ad.e.y.c.f {
    public String b;
    public a[] c;
    public long d;
    public long e;
    public long f;
    public String g;

    public e() {
        e();
    }

    public static e a(byte[] bArr) {
        return (e) com.ubix.ssp.ad.e.y.c.f.a(new e(), bArr);
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
        if (!this.b.equals("")) {
            bVar.b(1, this.b);
        }
        a[] aVarArr = this.c;
        if (aVarArr != null && aVarArr.length > 0) {
            int i = 0;
            while (true) {
                a[] aVarArr2 = this.c;
                if (i >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i];
                if (aVar != null) {
                    bVar.d(2, aVar);
                }
                i++;
            }
        }
        long j = this.d;
        if (j != 0) {
            bVar.g(3, j);
        }
        long j2 = this.e;
        if (j2 != 0) {
            bVar.g(4, j2);
        }
        long j3 = this.f;
        if (j3 != 0) {
            bVar.g(5, j3);
        }
        if (!this.g.equals("")) {
            bVar.b(6, this.g);
        }
        super.a(bVar);
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    protected int b() {
        int iB = super.b();
        if (!this.b.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(1, this.b);
        }
        a[] aVarArr = this.c;
        if (aVarArr != null && aVarArr.length > 0) {
            int i = 0;
            while (true) {
                a[] aVarArr2 = this.c;
                if (i >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i];
                if (aVar != null) {
                    iB += com.ubix.ssp.ad.e.y.c.b.b(2, aVar);
                }
                i++;
            }
        }
        long j = this.d;
        if (j != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(3, j);
        }
        long j2 = this.e;
        if (j2 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(4, j2);
        }
        long j3 = this.f;
        if (j3 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(5, j3);
        }
        return !this.g.equals("") ? iB + com.ubix.ssp.ad.e.y.c.b.a(6, this.g) : iB;
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
        while (true) {
            int iW = aVar.w();
            if (iW == 0) {
                return this;
            }
            if (iW == 10) {
                this.b = aVar.v();
            } else if (iW == 18) {
                int iA = com.ubix.ssp.ad.e.y.c.h.a(aVar, 18);
                a[] aVarArr = this.c;
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
                this.c = aVarArr2;
            } else if (iW == 24) {
                this.d = aVar.l();
            } else if (iW == 32) {
                this.e = aVar.l();
            } else if (iW == 40) {
                this.f = aVar.l();
            } else if (iW == 50) {
                this.g = aVar.v();
            } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                return this;
            }
        }
    }

    public e e() {
        this.b = "";
        this.c = a.f();
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = "";
        this.f8939a = -1;
        return this;
    }
}
