package com.ubix.ssp.ad.e.y.b;

import com.ubix.ssp.ad.e.y.c.c;
import com.ubix.ssp.ad.e.y.c.d;
import com.ubix.ssp.ad.e.y.c.e;
import com.ubix.ssp.ad.e.y.c.f;
import com.ubix.ssp.ad.e.y.c.h;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a extends f {
    private static volatile a[] b;
    public long c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public Map<String, String> p;

    public a() {
        e();
    }

    public static a a(byte[] bArr) {
        return (a) f.a(new a(), bArr);
    }

    public static a[] f() {
        if (b == null) {
            synchronized (c.c) {
                if (b == null) {
                    b = new a[0];
                }
            }
        }
        return b;
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws IOException {
        long j = this.c;
        if (j != 0) {
            bVar.g(1, j);
        }
        if (!this.d.equals("")) {
            bVar.b(2, this.d);
        }
        if (!this.e.equals("")) {
            bVar.b(3, this.e);
        }
        if (!this.f.equals("")) {
            bVar.b(4, this.f);
        }
        if (!this.g.equals("")) {
            bVar.b(5, this.g);
        }
        if (!this.h.equals("")) {
            bVar.b(6, this.h);
        }
        if (!this.i.equals("")) {
            bVar.b(7, this.i);
        }
        if (!this.j.equals("")) {
            bVar.b(8, this.j);
        }
        if (!this.k.equals("")) {
            bVar.b(9, this.k);
        }
        if (!this.l.equals("")) {
            bVar.b(10, this.l);
        }
        if (!this.m.equals("")) {
            bVar.b(11, this.m);
        }
        if (!this.n.equals("")) {
            bVar.b(12, this.n);
        }
        if (!this.o.equals("")) {
            bVar.b(13, this.o);
        }
        Map<String, String> map = this.p;
        if (map != null) {
            c.a(bVar, map, 14, 9, 9);
        }
        super.a(bVar);
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    protected int b() {
        int iB = super.b();
        long j = this.c;
        if (j != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.b(1, j);
        }
        if (!this.d.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(2, this.d);
        }
        if (!this.e.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(3, this.e);
        }
        if (!this.f.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(4, this.f);
        }
        if (!this.g.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(5, this.g);
        }
        if (!this.h.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(6, this.h);
        }
        if (!this.i.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(7, this.i);
        }
        if (!this.j.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(8, this.j);
        }
        if (!this.k.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(9, this.k);
        }
        if (!this.l.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(10, this.l);
        }
        if (!this.m.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(11, this.m);
        }
        if (!this.n.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(12, this.n);
        }
        if (!this.o.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(13, this.o);
        }
        Map<String, String> map = this.p;
        return map != null ? iB + c.a(map, 14, 9, 9) : iB;
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a a(com.ubix.ssp.ad.e.y.c.a aVar) throws d {
        e.c cVarA = e.a();
        while (true) {
            int iW = aVar.w();
            switch (iW) {
                case 0:
                    return this;
                case 8:
                    this.c = aVar.l();
                    break;
                case 18:
                    this.d = aVar.v();
                    break;
                case 26:
                    this.e = aVar.v();
                    break;
                case 34:
                    this.f = aVar.v();
                    break;
                case 42:
                    this.g = aVar.v();
                    break;
                case 50:
                    this.h = aVar.v();
                    break;
                case 58:
                    this.i = aVar.v();
                    break;
                case 66:
                    this.j = aVar.v();
                    break;
                case 74:
                    this.k = aVar.v();
                    break;
                case 82:
                    this.l = aVar.v();
                    break;
                case 90:
                    this.m = aVar.v();
                    break;
                case 98:
                    this.n = aVar.v();
                    break;
                case 106:
                    this.o = aVar.v();
                    break;
                case 114:
                    this.p = c.a(aVar, this.p, cVarA, 9, 9, null, 10, 18);
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

    public a e() {
        this.c = 0L;
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = null;
        this.f8939a = -1;
        return this;
    }
}
