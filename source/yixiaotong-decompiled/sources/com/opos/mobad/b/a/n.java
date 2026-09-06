package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class n extends com.heytap.nearx.a.a.b<n, a> {
    public static final com.heytap.nearx.a.a.e<n> c = new b();
    public static final Boolean d = false;
    public static final Integer e = 0;
    public static final Integer f = 0;
    public static final Integer g = 0;
    private static final long serialVersionUID = 0;
    public final m h;
    public final o i;
    public final p j;
    public final q k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final Boolean q;
    public final Integer r;
    public final Integer s;
    public final Integer t;

    public static final class a extends com.heytap.nearx.a.a.b.a<n, a> {
        public m c;
        public o d;
        public p e;
        public q f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public Boolean l;
        public Integer m;
        public Integer n;
        public Integer o;

        public a a(m mVar) {
            this.c = mVar;
            return this;
        }

        public a a(o oVar) {
            this.d = oVar;
            return this;
        }

        public a a(p pVar) {
            this.e = pVar;
            return this;
        }

        public a a(q qVar) {
            this.f = qVar;
            return this;
        }

        public a a(Boolean bool) {
            this.l = bool;
            return this;
        }

        public a a(Integer num) {
            this.m = num;
            return this;
        }

        public a a(String str) {
            this.g = str;
            return this;
        }

        public a b(Integer num) {
            this.n = num;
            return this;
        }

        public a b(String str) {
            this.h = str;
            return this;
        }

        public n b() {
            return new n(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, super.a());
        }

        public a c(Integer num) {
            this.o = num;
            return this;
        }

        public a c(String str) {
            this.i = str;
            return this;
        }

        public a d(String str) {
            this.j = str;
            return this;
        }

        public a e(String str) {
            this.k = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<n> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, n.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(n nVar) {
            return (nVar.h != null ? m.c.a(1, nVar.h) : 0) + (nVar.i != null ? o.c.a(2, nVar.i) : 0) + (nVar.j != null ? p.c.a(3, nVar.j) : 0) + (nVar.k != null ? q.c.a(4, nVar.k) : 0) + (nVar.l != null ? com.heytap.nearx.a.a.e.p.a(5, nVar.l) : 0) + (nVar.m != null ? com.heytap.nearx.a.a.e.p.a(6, nVar.m) : 0) + (nVar.n != null ? com.heytap.nearx.a.a.e.p.a(7, nVar.n) : 0) + (nVar.o != null ? com.heytap.nearx.a.a.e.p.a(8, nVar.o) : 0) + (nVar.p != null ? com.heytap.nearx.a.a.e.p.a(9, nVar.p) : 0) + (nVar.q != null ? com.heytap.nearx.a.a.e.c.a(10, nVar.q) : 0) + (nVar.r != null ? com.heytap.nearx.a.a.e.d.a(11, nVar.r) : 0) + (nVar.s != null ? com.heytap.nearx.a.a.e.d.a(12, nVar.s) : 0) + (nVar.t != null ? com.heytap.nearx.a.a.e.d.a(13, nVar.t) : 0) + nVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, n nVar) throws IOException {
            if (nVar.h != null) {
                m.c.a(gVar, 1, nVar.h);
            }
            if (nVar.i != null) {
                o.c.a(gVar, 2, nVar.i);
            }
            if (nVar.j != null) {
                p.c.a(gVar, 3, nVar.j);
            }
            if (nVar.k != null) {
                q.c.a(gVar, 4, nVar.k);
            }
            if (nVar.l != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 5, nVar.l);
            }
            if (nVar.m != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, nVar.m);
            }
            if (nVar.n != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 7, nVar.n);
            }
            if (nVar.o != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 8, nVar.o);
            }
            if (nVar.p != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 9, nVar.p);
            }
            if (nVar.q != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 10, nVar.q);
            }
            if (nVar.r != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 11, nVar.r);
            }
            if (nVar.s != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 12, nVar.s);
            }
            if (nVar.t != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 13, nVar.t);
            }
            gVar.a(nVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public n a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                switch (iB) {
                    case 1:
                        aVar.a(m.c.a(fVar));
                        break;
                    case 2:
                        aVar.a(o.c.a(fVar));
                        break;
                    case 3:
                        aVar.a(p.c.a(fVar));
                        break;
                    case 4:
                        aVar.a(q.c.a(fVar));
                        break;
                    case 5:
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 6:
                        aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 8:
                        aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 9:
                        aVar.e(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 10:
                        aVar.a(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 11:
                        aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 12:
                        aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 13:
                        aVar.c(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }
    }

    public n(m mVar, o oVar, p pVar, q qVar, String str, String str2, String str3, String str4, String str5, Boolean bool, Integer num, Integer num2, Integer num3, ByteString byteString) {
        super(c, byteString);
        this.h = mVar;
        this.i = oVar;
        this.j = pVar;
        this.k = qVar;
        this.l = str;
        this.m = str2;
        this.n = str3;
        this.o = str4;
        this.p = str5;
        this.q = bool;
        this.r = num;
        this.s = num2;
        this.t = num3;
    }

    public a c() {
        a aVar = new a();
        aVar.c = this.h;
        aVar.d = this.i;
        aVar.e = this.j;
        aVar.f = this.k;
        aVar.g = this.l;
        aVar.h = this.m;
        aVar.i = this.n;
        aVar.j = this.o;
        aVar.k = this.p;
        aVar.l = this.q;
        aVar.m = this.r;
        aVar.n = this.s;
        aVar.o = this.t;
        aVar.a(a());
        return aVar;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.h != null) {
            sb.append(", devId=").append(this.h);
        }
        if (this.i != null) {
            sb.append(", devOs=").append(this.i);
        }
        if (this.j != null) {
            sb.append(", devScreen=").append(this.j);
        }
        if (this.k != null) {
            sb.append(", devStatus=").append(this.k);
        }
        if (this.l != null) {
            sb.append(", model=").append(this.l);
        }
        if (this.m != null) {
            sb.append(", ua=").append(this.m);
        }
        if (this.n != null) {
            sb.append(", brand=").append(this.n);
        }
        if (this.o != null) {
            sb.append(", bootMark=").append(this.o);
        }
        if (this.p != null) {
            sb.append(", updateMark=").append(this.p);
        }
        if (this.q != null) {
            sb.append(", touristMode=").append(this.q);
        }
        if (this.r != null) {
            sb.append(", minorsMode=").append(this.r);
        }
        if (this.s != null) {
            sb.append(", minorsModeEnable=").append(this.s);
        }
        if (this.t != null) {
            sb.append(", minorsModeAgeRange=").append(this.t);
        }
        return sb.replace(0, 2, "DevInfo{").append('}').toString();
    }
}
