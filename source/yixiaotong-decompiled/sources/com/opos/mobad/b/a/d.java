package com.opos.mobad.b.a;

import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class d extends com.heytap.nearx.a.a.b<d, a> {
    public static final com.heytap.nearx.a.a.e<d> c = new c();
    public static final Integer d = 0;
    public static final Long e = 0L;
    public static final Integer f = 0;
    public static final Integer g = 0;
    public static final Integer h = 0;
    public static final b i = b.NO_TYPE;
    public static final Integer j = 0;
    public static final Boolean k = false;
    public static final Integer l = 1;
    public static final Boolean m = false;
    public static final Integer n = 0;
    public static final Integer o = 0;
    private static final long serialVersionUID = 0;
    public final Integer A;
    public final Boolean B;
    public final Integer C;
    public final Boolean D;
    public final Integer E;
    public final Integer F;
    public final String G;
    public final String H;
    public final String I;
    public final Integer p;
    public final String q;
    public final String r;
    public final List<com.opos.mobad.b.a.b> s;
    public final Long t;
    public final String u;
    public final v v;
    public final Integer w;
    public final Integer x;
    public final Integer y;
    public final b z;

    public static final class a extends com.heytap.nearx.a.a.b.a<d, a> {
        public Integer c;
        public String d;
        public String e;
        public List<com.opos.mobad.b.a.b> f = com.heytap.nearx.a.a.a.b.a();
        public Long g;
        public String h;
        public v i;
        public Integer j;
        public Integer k;
        public Integer l;
        public b m;
        public Integer n;
        public Boolean o;
        public Integer p;
        public Boolean q;
        public Integer r;
        public Integer s;
        public String t;
        public String u;
        public String v;

        public a a(b bVar) {
            this.m = bVar;
            return this;
        }

        public a a(v vVar) {
            this.i = vVar;
            return this;
        }

        public a a(Boolean bool) {
            this.o = bool;
            return this;
        }

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public a a(Long l) {
            this.g = l;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a b(Boolean bool) {
            this.q = bool;
            return this;
        }

        public a b(Integer num) {
            this.j = num;
            return this;
        }

        public a b(String str) {
            this.e = str;
            return this;
        }

        public d b() {
            return new d(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, super.a());
        }

        public a c(Integer num) {
            this.k = num;
            return this;
        }

        public a c(String str) {
            this.h = str;
            return this;
        }

        public a d(Integer num) {
            this.l = num;
            return this;
        }

        public a d(String str) {
            this.t = str;
            return this;
        }

        public a e(Integer num) {
            this.n = num;
            return this;
        }

        public a e(String str) {
            this.u = str;
            return this;
        }

        public a f(Integer num) {
            this.p = num;
            return this;
        }

        public a f(String str) {
            this.v = str;
            return this;
        }

        public a g(Integer num) {
            this.r = num;
            return this;
        }

        public a h(Integer num) {
            this.s = num;
            return this;
        }
    }

    public enum b implements com.heytap.nearx.a.a.i {
        NO_TYPE(0),
        GAME_BOX_BANNER(1),
        GAME_BOX_INTERSTITIAL(2);

        public static final com.heytap.nearx.a.a.e<b> d = com.heytap.nearx.a.a.e.a(b.class);
        private final int e;

        b(int i) {
            this.e = i;
        }

        public static b fromValue(int i) {
            if (i == 0) {
                return NO_TYPE;
            }
            if (i == 1) {
                return GAME_BOX_BANNER;
            }
            if (i != 2) {
                return null;
            }
            return GAME_BOX_INTERSTITIAL;
        }

        @Override // com.heytap.nearx.a.a.i
        public int getValue() {
            return this.e;
        }
    }

    private static final class c extends com.heytap.nearx.a.a.e<d> {
        c() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, d.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(d dVar) {
            return (dVar.p != null ? com.heytap.nearx.a.a.e.d.a(1, dVar.p) : 0) + (dVar.q != null ? com.heytap.nearx.a.a.e.p.a(2, dVar.q) : 0) + (dVar.r != null ? com.heytap.nearx.a.a.e.p.a(3, dVar.r) : 0) + com.opos.mobad.b.a.b.c.a().a(4, dVar.s) + (dVar.t != null ? com.heytap.nearx.a.a.e.i.a(5, dVar.t) : 0) + (dVar.u != null ? com.heytap.nearx.a.a.e.p.a(6, dVar.u) : 0) + (dVar.v != null ? v.c.a(7, dVar.v) : 0) + (dVar.w != null ? com.heytap.nearx.a.a.e.d.a(8, dVar.w) : 0) + (dVar.x != null ? com.heytap.nearx.a.a.e.d.a(9, dVar.x) : 0) + (dVar.y != null ? com.heytap.nearx.a.a.e.d.a(10, dVar.y) : 0) + (dVar.z != null ? b.d.a(11, dVar.z) : 0) + (dVar.A != null ? com.heytap.nearx.a.a.e.d.a(12, dVar.A) : 0) + (dVar.B != null ? com.heytap.nearx.a.a.e.c.a(13, dVar.B) : 0) + (dVar.C != null ? com.heytap.nearx.a.a.e.d.a(14, dVar.C) : 0) + (dVar.D != null ? com.heytap.nearx.a.a.e.c.a(15, dVar.D) : 0) + (dVar.E != null ? com.heytap.nearx.a.a.e.d.a(16, dVar.E) : 0) + (dVar.F != null ? com.heytap.nearx.a.a.e.d.a(17, dVar.F) : 0) + (dVar.G != null ? com.heytap.nearx.a.a.e.p.a(18, dVar.G) : 0) + (dVar.H != null ? com.heytap.nearx.a.a.e.p.a(19, dVar.H) : 0) + (dVar.I != null ? com.heytap.nearx.a.a.e.p.a(20, dVar.I) : 0) + dVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, d dVar) throws IOException {
            if (dVar.p != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 1, dVar.p);
            }
            if (dVar.q != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, dVar.q);
            }
            if (dVar.r != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, dVar.r);
            }
            com.opos.mobad.b.a.b.c.a().a(gVar, 4, dVar.s);
            if (dVar.t != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 5, dVar.t);
            }
            if (dVar.u != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, dVar.u);
            }
            if (dVar.v != null) {
                v.c.a(gVar, 7, dVar.v);
            }
            if (dVar.w != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 8, dVar.w);
            }
            if (dVar.x != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 9, dVar.x);
            }
            if (dVar.y != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 10, dVar.y);
            }
            if (dVar.z != null) {
                b.d.a(gVar, 11, dVar.z);
            }
            if (dVar.A != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 12, dVar.A);
            }
            if (dVar.B != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 13, dVar.B);
            }
            if (dVar.C != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 14, dVar.C);
            }
            if (dVar.D != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 15, dVar.D);
            }
            if (dVar.E != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 16, dVar.E);
            }
            if (dVar.F != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 17, dVar.F);
            }
            if (dVar.G != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 18, dVar.G);
            }
            if (dVar.H != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 19, dVar.H);
            }
            if (dVar.I != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 20, dVar.I);
            }
            gVar.a(dVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public d a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        break;
                    case 2:
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 3:
                        aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 4:
                        aVar.f.add(com.opos.mobad.b.a.b.c.a(fVar));
                        break;
                    case 5:
                        aVar.a(com.heytap.nearx.a.a.e.i.a(fVar));
                        break;
                    case 6:
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.a(v.c.a(fVar));
                        break;
                    case 8:
                        aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 9:
                        aVar.c(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 10:
                        aVar.d(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 11:
                        try {
                            aVar.a(b.d.a(fVar));
                        } catch (com.heytap.nearx.a.a.e.a e) {
                            aVar.a(iB, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f3488a));
                        }
                        break;
                    case 12:
                        aVar.e(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 13:
                        aVar.a(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 14:
                        aVar.f(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 15:
                        aVar.b(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 16:
                        aVar.g(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 17:
                        aVar.h(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 18:
                        aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 19:
                        aVar.e(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 20:
                        aVar.f(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }
    }

    public d(Integer num, String str, String str2, List<com.opos.mobad.b.a.b> list, Long l2, String str3, v vVar, Integer num2, Integer num3, Integer num4, b bVar, Integer num5, Boolean bool, Integer num6, Boolean bool2, Integer num7, Integer num8, String str4, String str5, String str6, ByteString byteString) {
        super(c, byteString);
        this.p = num;
        this.q = str;
        this.r = str2;
        this.s = com.heytap.nearx.a.a.a.b.b("adList", list);
        this.t = l2;
        this.u = str3;
        this.v = vVar;
        this.w = num2;
        this.x = num3;
        this.y = num4;
        this.z = bVar;
        this.A = num5;
        this.B = bool;
        this.C = num6;
        this.D = bool2;
        this.E = num7;
        this.F = num8;
        this.G = str4;
        this.H = str5;
        this.I = str6;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.p != null) {
            sb.append(", code=").append(this.p);
        }
        if (this.q != null) {
            sb.append(", msg=").append(this.q);
        }
        if (this.r != null) {
            sb.append(", adSource=").append(this.r);
        }
        if (!this.s.isEmpty()) {
            sb.append(", adList=").append(this.s);
        }
        if (this.t != null) {
            sb.append(", expTime=").append(this.t);
        }
        if (this.u != null) {
            sb.append(", respId=").append(this.u);
        }
        if (this.v != null) {
            sb.append(", instantIds=").append(this.v);
        }
        if (this.w != null) {
            sb.append(", reqInterval=").append(this.w);
        }
        if (this.x != null) {
            sb.append(", dispatch=").append(this.x);
        }
        if (this.y != null) {
            sb.append(", validTime=").append(this.y);
        }
        if (this.z != null) {
            sb.append(", gameBoxType=").append(this.z);
        }
        if (this.A != null) {
            sb.append(", cacheAdNum=").append(this.A);
        }
        if (this.B != null) {
            sb.append(", customSkip=").append(this.B);
        }
        if (this.C != null) {
            sb.append(", limitNum=").append(this.C);
        }
        if (this.D != null) {
            sb.append(", recordShowEvent=").append(this.D);
        }
        if (this.E != null) {
            sb.append(", cmType=").append(this.E);
        }
        if (this.F != null) {
            sb.append(", strategyState=").append(this.F);
        }
        if (this.G != null) {
            sb.append(", customInfo=").append(this.G);
        }
        if (this.H != null) {
            sb.append(", miniProgramAppId=").append(this.H);
        }
        if (this.I != null) {
            sb.append(", clkScore=").append(this.I);
        }
        return sb.replace(0, 2, "AdResponse{").append('}').toString();
    }
}
