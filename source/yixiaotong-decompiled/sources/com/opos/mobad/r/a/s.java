package com.opos.mobad.r.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class s extends com.heytap.nearx.a.a.b<s, a> {
    public static final com.heytap.nearx.a.a.e<s> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    public static final Long f = 0L;
    public static final Long g = 0L;
    public static final Long h = 0L;
    private static final long serialVersionUID = 0;
    public final String i;
    public final String j;
    public final Integer k;
    public final Integer l;
    public final Long m;
    public final String n;
    public final j o;
    public final p p;
    public final n q;
    public final aa r;
    public final o s;
    public final Long t;
    public final w u;
    public final com.opos.mobad.r.a.b v;
    public final Long w;

    public static final class a extends com.heytap.nearx.a.a.b.a<s, a> {
        public String c;
        public String d;
        public Integer e;
        public Integer f;
        public Long g;
        public String h;
        public j i;
        public p j;
        public n k;
        public aa l;
        public o m;
        public Long n;
        public w o;
        public com.opos.mobad.r.a.b p;
        public Long q;

        public a a(aa aaVar) {
            this.l = aaVar;
            return this;
        }

        public a a(com.opos.mobad.r.a.b bVar) {
            this.p = bVar;
            return this;
        }

        public a a(j jVar) {
            this.i = jVar;
            return this;
        }

        public a a(n nVar) {
            this.k = nVar;
            return this;
        }

        public a a(o oVar) {
            this.m = oVar;
            return this;
        }

        public a a(p pVar) {
            this.j = pVar;
            return this;
        }

        public a a(w wVar) {
            this.o = wVar;
            return this;
        }

        public a a(Integer num) {
            this.e = num;
            return this;
        }

        public a a(Long l) {
            this.g = l;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a b(Integer num) {
            this.f = num;
            return this;
        }

        public a b(Long l) {
            this.n = l;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public s b() {
            String str = this.c;
            if (str == null || this.d == null || this.e == null || this.f == null) {
                throw com.heytap.nearx.a.a.a.b.a(str, "appId", this.d, "packageName", this.e, "platform", this.f, "sdkVerCode");
            }
            return new s(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, super.a());
        }

        public a c(Long l) {
            this.q = l;
            return this;
        }

        public a c(String str) {
            this.h = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<s> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, s.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(s sVar) {
            return com.heytap.nearx.a.a.e.p.a(1, sVar.i) + com.heytap.nearx.a.a.e.p.a(2, sVar.j) + com.heytap.nearx.a.a.e.d.a(3, sVar.k) + com.heytap.nearx.a.a.e.d.a(4, sVar.l) + (sVar.m != null ? com.heytap.nearx.a.a.e.i.a(5, sVar.m) : 0) + (sVar.n != null ? com.heytap.nearx.a.a.e.p.a(6, sVar.n) : 0) + (sVar.o != null ? j.c.a(7, sVar.o) : 0) + (sVar.p != null ? p.c.a(8, sVar.p) : 0) + (sVar.q != null ? n.c.a(9, sVar.q) : 0) + (sVar.r != null ? aa.c.a(10, sVar.r) : 0) + (sVar.s != null ? o.c.a(11, sVar.s) : 0) + (sVar.t != null ? com.heytap.nearx.a.a.e.i.a(12, sVar.t) : 0) + (sVar.u != null ? w.c.a(13, sVar.u) : 0) + (sVar.v != null ? com.opos.mobad.r.a.b.c.a(14, sVar.v) : 0) + (sVar.w != null ? com.heytap.nearx.a.a.e.i.a(15, sVar.w) : 0) + sVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, s sVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, sVar.i);
            com.heytap.nearx.a.a.e.p.a(gVar, 2, sVar.j);
            com.heytap.nearx.a.a.e.d.a(gVar, 3, sVar.k);
            com.heytap.nearx.a.a.e.d.a(gVar, 4, sVar.l);
            if (sVar.m != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 5, sVar.m);
            }
            if (sVar.n != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, sVar.n);
            }
            if (sVar.o != null) {
                j.c.a(gVar, 7, sVar.o);
            }
            if (sVar.p != null) {
                p.c.a(gVar, 8, sVar.p);
            }
            if (sVar.q != null) {
                n.c.a(gVar, 9, sVar.q);
            }
            if (sVar.r != null) {
                aa.c.a(gVar, 10, sVar.r);
            }
            if (sVar.s != null) {
                o.c.a(gVar, 11, sVar.s);
            }
            if (sVar.t != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 12, sVar.t);
            }
            if (sVar.u != null) {
                w.c.a(gVar, 13, sVar.u);
            }
            if (sVar.v != null) {
                com.opos.mobad.r.a.b.c.a(gVar, 14, sVar.v);
            }
            if (sVar.w != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 15, sVar.w);
            }
            gVar.a(sVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public s a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 2:
                        aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 3:
                        aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 4:
                        aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 5:
                        aVar.a(com.heytap.nearx.a.a.e.i.a(fVar));
                        break;
                    case 6:
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.a(j.c.a(fVar));
                        break;
                    case 8:
                        aVar.a(p.c.a(fVar));
                        break;
                    case 9:
                        aVar.a(n.c.a(fVar));
                        break;
                    case 10:
                        aVar.a(aa.c.a(fVar));
                        break;
                    case 11:
                        aVar.a(o.c.a(fVar));
                        break;
                    case 12:
                        aVar.b(com.heytap.nearx.a.a.e.i.a(fVar));
                        break;
                    case 13:
                        aVar.a(w.c.a(fVar));
                        break;
                    case 14:
                        aVar.a(com.opos.mobad.r.a.b.c.a(fVar));
                        break;
                    case 15:
                        aVar.c(com.heytap.nearx.a.a.e.i.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }
    }

    public s(String str, String str2, Integer num, Integer num2, Long l, String str3, j jVar, p pVar, n nVar, aa aaVar, o oVar, Long l2, w wVar, com.opos.mobad.r.a.b bVar, Long l3, ByteString byteString) {
        super(c, byteString);
        this.i = str;
        this.j = str2;
        this.k = num;
        this.l = num2;
        this.m = l;
        this.n = str3;
        this.o = jVar;
        this.p = pVar;
        this.q = nVar;
        this.r = aaVar;
        this.s = oVar;
        this.t = l2;
        this.u = wVar;
        this.v = bVar;
        this.w = l3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", appId=").append(this.i);
        sb.append(", packageName=").append(this.j);
        sb.append(", platform=").append(this.k);
        sb.append(", sdkVerCode=").append(this.l);
        if (this.m != null) {
            sb.append(", firstActiveTime=").append(this.m);
        }
        if (this.n != null) {
            sb.append(", platformPkgName=").append(this.n);
        }
        if (this.o != null) {
            sb.append(", devInfo=").append(this.o);
        }
        if (this.p != null) {
            sb.append(", marketInfo=").append(this.p);
        }
        if (this.q != null) {
            sb.append(", instantInfo=").append(this.q);
        }
        if (this.r != null) {
            sb.append(", xgameInfo=").append(this.r);
        }
        if (this.s != null) {
            sb.append(", localInfo=").append(this.s);
        }
        if (this.t != null) {
            sb.append(", curStrategyVersionCode=").append(this.t);
        }
        if (this.u != null) {
            sb.append(", userAccountInfo=").append(this.u);
        }
        if (this.v != null) {
            sb.append(", adsInfo=").append(this.v);
        }
        if (this.w != null) {
            sb.append(", bottomAdCacheTime=").append(this.w);
        }
        return sb.replace(0, 2, "Request{").append('}').toString();
    }
}
