package com.opos.mobad.b.a;

import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class c extends com.heytap.nearx.a.a.b<c, a> {
    public static final com.heytap.nearx.a.a.e<c> c = new b();
    public static final Integer d = 1;
    public static final Boolean e = true;
    public static final EnumC0941c f = EnumC0941c.SDK;
    public static final af g = af.MODE_ONE;
    public static final Boolean h = true;
    public static final Long i = 0L;
    public static final Long j = 0L;
    public static final Boolean k = false;
    private static final long serialVersionUID = 0;
    public final String A;
    public final Long B;
    public final String C;
    public final String D;
    public final String E;
    public final String F;
    public final e G;
    public final List<String> H;
    public final Long I;
    public final ak J;
    public final String K;
    public final Boolean L;
    public final Integer l;
    public final h m;
    public final ae n;
    public final ac o;
    public final n p;
    public final String q;
    public final z r;
    public final w s;
    public final Boolean t;
    public final al u;
    public final EnumC0941c v;
    public final String w;
    public final af x;
    public final List<f> y;
    public final Boolean z;

    public static final class a extends com.heytap.nearx.a.a.b.a<c, a> {
        public ak A;
        public String B;
        public Boolean C;
        public Integer c;
        public h d;
        public ae e;
        public ac f;
        public n g;
        public String h;
        public z i;
        public w j;
        public Boolean k;
        public al l;
        public EnumC0941c m;
        public String n;
        public af o;
        public Boolean q;
        public String r;
        public Long s;
        public String t;
        public String u;
        public String v;
        public String w;
        public e x;
        public Long z;
        public List<f> p = com.heytap.nearx.a.a.a.b.a();
        public List<String> y = com.heytap.nearx.a.a.a.b.a();

        public a a(ac acVar) {
            this.f = acVar;
            return this;
        }

        public a a(ae aeVar) {
            this.e = aeVar;
            return this;
        }

        public a a(af afVar) {
            this.o = afVar;
            return this;
        }

        public a a(ak akVar) {
            this.A = akVar;
            return this;
        }

        public a a(al alVar) {
            this.l = alVar;
            return this;
        }

        public a a(EnumC0941c enumC0941c) {
            this.m = enumC0941c;
            return this;
        }

        public a a(e eVar) {
            this.x = eVar;
            return this;
        }

        public a a(h hVar) {
            this.d = hVar;
            return this;
        }

        public a a(n nVar) {
            this.g = nVar;
            return this;
        }

        public a a(w wVar) {
            this.j = wVar;
            return this;
        }

        public a a(z zVar) {
            this.i = zVar;
            return this;
        }

        public a a(Boolean bool) {
            this.k = bool;
            return this;
        }

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public a a(Long l) {
            this.s = l;
            return this;
        }

        public a a(String str) {
            this.h = str;
            return this;
        }

        public a a(List<f> list) {
            com.heytap.nearx.a.a.a.b.a(list);
            this.p = list;
            return this;
        }

        public a b(Boolean bool) {
            this.q = bool;
            return this;
        }

        public a b(Long l) {
            this.z = l;
            return this;
        }

        public a b(String str) {
            this.n = str;
            return this;
        }

        public a b(List<String> list) {
            com.heytap.nearx.a.a.a.b.a(list);
            this.y = list;
            return this;
        }

        public c b() {
            return new c(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, super.a());
        }

        public a c(Boolean bool) {
            this.C = bool;
            return this;
        }

        public a c(String str) {
            this.r = str;
            return this;
        }

        public a d(String str) {
            this.t = str;
            return this;
        }

        public a e(String str) {
            this.u = str;
            return this;
        }

        public a f(String str) {
            this.v = str;
            return this;
        }

        public a g(String str) {
            this.w = str;
            return this;
        }

        public a h(String str) {
            this.B = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<c> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, c.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(c cVar) {
            return (cVar.l != null ? com.heytap.nearx.a.a.e.d.a(1, cVar.l) : 0) + (cVar.m != null ? h.c.a(2, cVar.m) : 0) + (cVar.n != null ? ae.c.a(3, cVar.n) : 0) + (cVar.o != null ? ac.c.a(4, cVar.o) : 0) + (cVar.p != null ? n.c.a(5, cVar.p) : 0) + (cVar.q != null ? com.heytap.nearx.a.a.e.p.a(6, cVar.q) : 0) + (cVar.r != null ? z.c.a(7, cVar.r) : 0) + (cVar.s != null ? w.c.a(8, cVar.s) : 0) + (cVar.t != null ? com.heytap.nearx.a.a.e.c.a(9, cVar.t) : 0) + (cVar.u != null ? al.c.a(10, cVar.u) : 0) + (cVar.v != null ? EnumC0941c.e.a(11, cVar.v) : 0) + (cVar.w != null ? com.heytap.nearx.a.a.e.p.a(12, cVar.w) : 0) + (cVar.x != null ? af.c.a(13, cVar.x) : 0) + f.c.a().a(14, cVar.y) + (cVar.z != null ? com.heytap.nearx.a.a.e.c.a(15, cVar.z) : 0) + (cVar.A != null ? com.heytap.nearx.a.a.e.p.a(16, cVar.A) : 0) + (cVar.B != null ? com.heytap.nearx.a.a.e.i.a(17, cVar.B) : 0) + (cVar.C != null ? com.heytap.nearx.a.a.e.p.a(18, cVar.C) : 0) + (cVar.D != null ? com.heytap.nearx.a.a.e.p.a(19, cVar.D) : 0) + (cVar.E != null ? com.heytap.nearx.a.a.e.p.a(20, cVar.E) : 0) + (cVar.F != null ? com.heytap.nearx.a.a.e.p.a(21, cVar.F) : 0) + (cVar.G != null ? e.c.a(22, cVar.G) : 0) + com.heytap.nearx.a.a.e.p.a().a(23, cVar.H) + (cVar.I != null ? com.heytap.nearx.a.a.e.i.a(24, cVar.I) : 0) + (cVar.J != null ? ak.c.a(25, cVar.J) : 0) + (cVar.K != null ? com.heytap.nearx.a.a.e.p.a(26, cVar.K) : 0) + (cVar.L != null ? com.heytap.nearx.a.a.e.c.a(27, cVar.L) : 0) + cVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, c cVar) throws IOException {
            if (cVar.l != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 1, cVar.l);
            }
            if (cVar.m != null) {
                h.c.a(gVar, 2, cVar.m);
            }
            if (cVar.n != null) {
                ae.c.a(gVar, 3, cVar.n);
            }
            if (cVar.o != null) {
                ac.c.a(gVar, 4, cVar.o);
            }
            if (cVar.p != null) {
                n.c.a(gVar, 5, cVar.p);
            }
            if (cVar.q != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, cVar.q);
            }
            if (cVar.r != null) {
                z.c.a(gVar, 7, cVar.r);
            }
            if (cVar.s != null) {
                w.c.a(gVar, 8, cVar.s);
            }
            if (cVar.t != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 9, cVar.t);
            }
            if (cVar.u != null) {
                al.c.a(gVar, 10, cVar.u);
            }
            if (cVar.v != null) {
                EnumC0941c.e.a(gVar, 11, cVar.v);
            }
            if (cVar.w != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 12, cVar.w);
            }
            if (cVar.x != null) {
                af.c.a(gVar, 13, cVar.x);
            }
            f.c.a().a(gVar, 14, cVar.y);
            if (cVar.z != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 15, cVar.z);
            }
            if (cVar.A != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 16, cVar.A);
            }
            if (cVar.B != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 17, cVar.B);
            }
            if (cVar.C != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 18, cVar.C);
            }
            if (cVar.D != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 19, cVar.D);
            }
            if (cVar.E != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 20, cVar.E);
            }
            if (cVar.F != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 21, cVar.F);
            }
            if (cVar.G != null) {
                e.c.a(gVar, 22, cVar.G);
            }
            com.heytap.nearx.a.a.e.p.a().a(gVar, 23, cVar.H);
            if (cVar.I != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 24, cVar.I);
            }
            if (cVar.J != null) {
                ak.c.a(gVar, 25, cVar.J);
            }
            if (cVar.K != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 26, cVar.K);
            }
            if (cVar.L != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 27, cVar.L);
            }
            gVar.a(cVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(com.heytap.nearx.a.a.f fVar) throws IOException {
            List list;
            com.heytap.nearx.a.a.e eVar;
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
                        aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                        continue;
                    case 2:
                        aVar.a(h.c.a(fVar));
                        continue;
                    case 3:
                        aVar.a(ae.c.a(fVar));
                        continue;
                    case 4:
                        aVar.a(ac.c.a(fVar));
                        continue;
                    case 5:
                        aVar.a(n.c.a(fVar));
                        continue;
                    case 6:
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        continue;
                    case 7:
                        aVar.a(z.c.a(fVar));
                        continue;
                    case 8:
                        aVar.a(w.c.a(fVar));
                        continue;
                    case 9:
                        aVar.a(com.heytap.nearx.a.a.e.c.a(fVar));
                        continue;
                    case 10:
                        aVar.a(al.c.a(fVar));
                        continue;
                    case 11:
                        aVar.a(EnumC0941c.e.a(fVar));
                        continue;
                    case 12:
                        aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                        continue;
                    case 13:
                        try {
                            aVar.a(af.c.a(fVar));
                            continue;
                        } catch (com.heytap.nearx.a.a.e.a e) {
                            aVar.a(iB, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f3488a));
                        }
                        break;
                    case 14:
                        list = aVar.p;
                        eVar = f.c;
                        break;
                    case 15:
                        aVar.b(com.heytap.nearx.a.a.e.c.a(fVar));
                        continue;
                    case 16:
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        continue;
                    case 17:
                        aVar.a(com.heytap.nearx.a.a.e.i.a(fVar));
                        continue;
                    case 18:
                        aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                        continue;
                    case 19:
                        aVar.e(com.heytap.nearx.a.a.e.p.a(fVar));
                        continue;
                    case 20:
                        aVar.f(com.heytap.nearx.a.a.e.p.a(fVar));
                        continue;
                    case 21:
                        aVar.g(com.heytap.nearx.a.a.e.p.a(fVar));
                        continue;
                    case 22:
                        aVar.a(e.c.a(fVar));
                        continue;
                    case 23:
                        list = aVar.y;
                        eVar = com.heytap.nearx.a.a.e.p;
                        break;
                    case 24:
                        aVar.b(com.heytap.nearx.a.a.e.i.a(fVar));
                        continue;
                    case 25:
                        aVar.a(ak.c.a(fVar));
                        continue;
                    case 26:
                        aVar.h(com.heytap.nearx.a.a.e.p.a(fVar));
                        continue;
                    case 27:
                        aVar.c(com.heytap.nearx.a.a.e.c.a(fVar));
                        continue;
                    default:
                        com.heytap.nearx.a.a.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        continue;
                }
                list.add(eVar.a(fVar));
            }
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.b.a.c$c, reason: collision with other inner class name */
    public enum EnumC0941c implements com.heytap.nearx.a.a.i {
        SDK(0),
        QG(1),
        ADS(2),
        SDK_SERVER(3);

        public static final com.heytap.nearx.a.a.e<EnumC0941c> e = com.heytap.nearx.a.a.e.a(EnumC0941c.class);
        private final int f;

        EnumC0941c(int i) {
            this.f = i;
        }

        public static EnumC0941c fromValue(int i) {
            if (i == 0) {
                return SDK;
            }
            if (i == 1) {
                return QG;
            }
            if (i == 2) {
                return ADS;
            }
            if (i != 3) {
                return null;
            }
            return SDK_SERVER;
        }

        @Override // com.heytap.nearx.a.a.i
        public int getValue() {
            return this.f;
        }
    }

    public c(Integer num, h hVar, ae aeVar, ac acVar, n nVar, String str, z zVar, w wVar, Boolean bool, al alVar, EnumC0941c enumC0941c, String str2, af afVar, List<f> list, Boolean bool2, String str3, Long l, String str4, String str5, String str6, String str7, e eVar, List<String> list2, Long l2, ak akVar, String str8, Boolean bool3, ByteString byteString) {
        super(c, byteString);
        this.l = num;
        this.m = hVar;
        this.n = aeVar;
        this.o = acVar;
        this.p = nVar;
        this.q = str;
        this.r = zVar;
        this.s = wVar;
        this.t = bool;
        this.u = alVar;
        this.v = enumC0941c;
        this.w = str2;
        this.x = afVar;
        this.y = com.heytap.nearx.a.a.a.b.b("apkSigner", list);
        this.z = bool2;
        this.A = str3;
        this.B = l;
        this.C = str4;
        this.D = str5;
        this.E = str6;
        this.F = str7;
        this.G = eVar;
        this.H = com.heytap.nearx.a.a.a.b.b("bidIds", list2);
        this.I = l2;
        this.J = akVar;
        this.K = str8;
        this.L = bool3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.l != null) {
            sb.append(", apiVer=").append(this.l);
        }
        if (this.m != null) {
            sb.append(", appInfo=").append(this.m);
        }
        if (this.n != null) {
            sb.append(", sdkInfo=").append(this.n);
        }
        if (this.o != null) {
            sb.append(", posInfo=").append(this.o);
        }
        if (this.p != null) {
            sb.append(", devInfo=").append(this.p);
        }
        if (this.q != null) {
            sb.append(", ext=").append(this.q);
        }
        if (this.r != null) {
            sb.append(", marketInfo=").append(this.r);
        }
        if (this.s != null) {
            sb.append(", instantInfo=").append(this.s);
        }
        if (this.t != null) {
            sb.append(", ouIdOpenStatus=").append(this.t);
        }
        if (this.u != null) {
            sb.append(", xgameInfo=").append(this.u);
        }
        if (this.v != null) {
            sb.append(", scenes=").append(this.v);
        }
        if (this.w != null) {
            sb.append(", clReqId=").append(this.w);
        }
        if (this.x != null) {
            sb.append(", selfType=").append(this.x);
        }
        if (!this.y.isEmpty()) {
            sb.append(", apkSigner=").append(this.y);
        }
        if (this.z != null) {
            sb.append(", appOuidStatus=").append(this.z);
        }
        if (this.A != null) {
            sb.append(", platformPkgName=").append(this.A);
        }
        if (this.B != null) {
            sb.append(", strategyVersionCode=").append(this.B);
        }
        if (this.C != null) {
            sb.append(", classifyByAge=").append(this.C);
        }
        if (this.D != null) {
            sb.append(", enterSource=").append(this.D);
        }
        if (this.E != null) {
            sb.append(", keyWords=").append(this.E);
        }
        if (this.F != null) {
            sb.append(", adTraceData=").append(this.F);
        }
        if (this.G != null) {
            sb.append(", adsInfo=").append(this.G);
        }
        if (!this.H.isEmpty()) {
            sb.append(", bidIds=").append(this.H);
        }
        if (this.I != null) {
            sb.append(", switchFlags=").append(this.I);
        }
        if (this.J != null) {
            sb.append(", wxInfo=").append(this.J);
        }
        if (this.K != null) {
            sb.append(", adAbilities=").append(this.K);
        }
        if (this.L != null) {
            sb.append(", isBottomReq=").append(this.L);
        }
        return sb.replace(0, 2, "AdRequest{").append('}').toString();
    }
}
