package com.opos.mobad.r.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class g extends com.heytap.nearx.a.a.b<g, a> {
    public static final com.heytap.nearx.a.a.e<g> c = new b();
    public static final e d = e.UNKNOWN;
    private static final long serialVersionUID = 0;
    public final e e;
    public final String f;
    public final String g;
    public final f h;
    public final f i;
    public final f j;
    public final f k;
    public final f l;
    public final f m;
    public final f n;
    public final String o;

    public static final class a extends com.heytap.nearx.a.a.b.a<g, a> {
        public e c;
        public String d;
        public String e;
        public f f;
        public f g;
        public f h;
        public f i;
        public f j;
        public f k;
        public f l;
        public String m;

        public a a(e eVar) {
            this.c = eVar;
            return this;
        }

        public a a(f fVar) {
            this.f = fVar;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a b(f fVar) {
            this.g = fVar;
            return this;
        }

        public a b(String str) {
            this.e = str;
            return this;
        }

        public g b() {
            e eVar = this.c;
            if (eVar == null || this.d == null) {
                throw com.heytap.nearx.a.a.a.b.a(eVar, "channel", this.d, "appId");
            }
            return new g(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, super.a());
        }

        public a c(f fVar) {
            this.h = fVar;
            return this;
        }

        public a c(String str) {
            this.m = str;
            return this;
        }

        public a d(f fVar) {
            this.i = fVar;
            return this;
        }

        public a e(f fVar) {
            this.j = fVar;
            return this;
        }

        public a f(f fVar) {
            this.k = fVar;
            return this;
        }

        public a g(f fVar) {
            this.l = fVar;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<g> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, g.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(g gVar) {
            return e.n.a(1, gVar.e) + com.heytap.nearx.a.a.e.p.a(2, gVar.f) + (gVar.g != null ? com.heytap.nearx.a.a.e.p.a(3, gVar.g) : 0) + (gVar.h != null ? f.c.a(4, gVar.h) : 0) + (gVar.i != null ? f.c.a(5, gVar.i) : 0) + (gVar.j != null ? f.c.a(6, gVar.j) : 0) + (gVar.k != null ? f.c.a(7, gVar.k) : 0) + (gVar.l != null ? f.c.a(8, gVar.l) : 0) + (gVar.m != null ? f.c.a(9, gVar.m) : 0) + (gVar.n != null ? f.c.a(10, gVar.n) : 0) + (gVar.o != null ? com.heytap.nearx.a.a.e.p.a(11, gVar.o) : 0) + gVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, g gVar2) throws IOException {
            e.n.a(gVar, 1, gVar2.e);
            com.heytap.nearx.a.a.e.p.a(gVar, 2, gVar2.f);
            if (gVar2.g != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, gVar2.g);
            }
            if (gVar2.h != null) {
                f.c.a(gVar, 4, gVar2.h);
            }
            if (gVar2.i != null) {
                f.c.a(gVar, 5, gVar2.i);
            }
            if (gVar2.j != null) {
                f.c.a(gVar, 6, gVar2.j);
            }
            if (gVar2.k != null) {
                f.c.a(gVar, 7, gVar2.k);
            }
            if (gVar2.l != null) {
                f.c.a(gVar, 8, gVar2.l);
            }
            if (gVar2.m != null) {
                f.c.a(gVar, 9, gVar2.m);
            }
            if (gVar2.n != null) {
                f.c.a(gVar, 10, gVar2.n);
            }
            if (gVar2.o != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 11, gVar2.o);
            }
            gVar.a(gVar2.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        try {
                            aVar.a(e.n.a(fVar));
                        } catch (com.heytap.nearx.a.a.e.a e) {
                            aVar.a(iB, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f3488a));
                        }
                        break;
                    case 2:
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 3:
                        aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 4:
                        aVar.a(f.c.a(fVar));
                        break;
                    case 5:
                        aVar.b(f.c.a(fVar));
                        break;
                    case 6:
                        aVar.c(f.c.a(fVar));
                        break;
                    case 7:
                        aVar.d(f.c.a(fVar));
                        break;
                    case 8:
                        aVar.e(f.c.a(fVar));
                        break;
                    case 9:
                        aVar.f(f.c.a(fVar));
                        break;
                    case 10:
                        aVar.g(f.c.a(fVar));
                        break;
                    case 11:
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }
    }

    public g(e eVar, String str, String str2, f fVar, f fVar2, f fVar3, f fVar4, f fVar5, f fVar6, f fVar7, String str3, ByteString byteString) {
        super(c, byteString);
        this.e = eVar;
        this.f = str;
        this.g = str2;
        this.h = fVar;
        this.i = fVar2;
        this.j = fVar3;
        this.k = fVar4;
        this.l = fVar5;
        this.m = fVar6;
        this.n = fVar7;
        this.o = str3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", channel=").append(this.e);
        sb.append(", appId=").append(this.f);
        if (this.g != null) {
            sb.append(", logoUrl=").append(this.g);
        }
        if (this.h != null) {
            sb.append(", bannerAdConfig=").append(this.h);
        }
        if (this.i != null) {
            sb.append(", interstitialAdConfig=").append(this.i);
        }
        if (this.j != null) {
            sb.append(", interstitialVideoAdConfig=").append(this.j);
        }
        if (this.k != null) {
            sb.append(", rewardVideoAdConfig=").append(this.k);
        }
        if (this.l != null) {
            sb.append(", nativeAdConfig=").append(this.l);
        }
        if (this.m != null) {
            sb.append(", nativeTemplateAdConfig=").append(this.m);
        }
        if (this.n != null) {
            sb.append(", splashAdConfig=").append(this.n);
        }
        if (this.o != null) {
            sb.append(", appKey=").append(this.o);
        }
        return sb.replace(0, 2, "ChannelInfo{").append('}').toString();
    }
}
