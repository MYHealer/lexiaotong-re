package com.opos.mobad.r.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class c extends com.heytap.nearx.a.a.b<c, a> {
    public static final com.heytap.nearx.a.a.e<c> c = new b();
    public static final Boolean d = false;
    public static final Integer e = 3;
    public static final Boolean f = true;
    public static final Boolean g = true;
    public static final Integer h = 0;
    private static final long serialVersionUID = 0;
    public final com.opos.mobad.r.a.a i;
    public final com.opos.mobad.r.a.a j;
    public final com.opos.mobad.r.a.a k;
    public final com.opos.mobad.r.a.a l;
    public final com.opos.mobad.r.a.a m;
    public final com.opos.mobad.r.a.a n;
    public final com.opos.mobad.r.a.a o;
    public final Boolean p;
    public final Integer q;
    public final Boolean r;
    public final Boolean s;
    public final Integer t;
    public final d u;

    public static final class a extends com.heytap.nearx.a.a.b.a<c, a> {
        public com.opos.mobad.r.a.a c;
        public com.opos.mobad.r.a.a d;
        public com.opos.mobad.r.a.a e;
        public com.opos.mobad.r.a.a f;
        public com.opos.mobad.r.a.a g;
        public com.opos.mobad.r.a.a h;
        public com.opos.mobad.r.a.a i;
        public Boolean j;
        public Integer k;
        public Boolean l;
        public Boolean m;
        public Integer n;
        public d o;

        public a a(com.opos.mobad.r.a.a aVar) {
            this.c = aVar;
            return this;
        }

        public a a(d dVar) {
            this.o = dVar;
            return this;
        }

        public a a(Boolean bool) {
            this.j = bool;
            return this;
        }

        public a a(Integer num) {
            this.k = num;
            return this;
        }

        public a b(com.opos.mobad.r.a.a aVar) {
            this.d = aVar;
            return this;
        }

        public a b(Boolean bool) {
            this.l = bool;
            return this;
        }

        public a b(Integer num) {
            this.n = num;
            return this;
        }

        public c b() {
            return new c(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, super.a());
        }

        public a c(com.opos.mobad.r.a.a aVar) {
            this.e = aVar;
            return this;
        }

        public a c(Boolean bool) {
            this.m = bool;
            return this;
        }

        public a d(com.opos.mobad.r.a.a aVar) {
            this.f = aVar;
            return this;
        }

        public a e(com.opos.mobad.r.a.a aVar) {
            this.g = aVar;
            return this;
        }

        public a f(com.opos.mobad.r.a.a aVar) {
            this.h = aVar;
            return this;
        }

        public a g(com.opos.mobad.r.a.a aVar) {
            this.i = aVar;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<c> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, c.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(c cVar) {
            return (cVar.i != null ? com.opos.mobad.r.a.a.c.a(1, cVar.i) : 0) + (cVar.j != null ? com.opos.mobad.r.a.a.c.a(2, cVar.j) : 0) + (cVar.k != null ? com.opos.mobad.r.a.a.c.a(3, cVar.k) : 0) + (cVar.l != null ? com.opos.mobad.r.a.a.c.a(4, cVar.l) : 0) + (cVar.m != null ? com.opos.mobad.r.a.a.c.a(5, cVar.m) : 0) + (cVar.n != null ? com.opos.mobad.r.a.a.c.a(6, cVar.n) : 0) + (cVar.o != null ? com.opos.mobad.r.a.a.c.a(7, cVar.o) : 0) + (cVar.p != null ? com.heytap.nearx.a.a.e.c.a(8, cVar.p) : 0) + (cVar.q != null ? com.heytap.nearx.a.a.e.d.a(9, cVar.q) : 0) + (cVar.r != null ? com.heytap.nearx.a.a.e.c.a(10, cVar.r) : 0) + (cVar.s != null ? com.heytap.nearx.a.a.e.c.a(11, cVar.s) : 0) + (cVar.t != null ? com.heytap.nearx.a.a.e.d.a(12, cVar.t) : 0) + (cVar.u != null ? d.c.a(13, cVar.u) : 0) + cVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, c cVar) throws IOException {
            if (cVar.i != null) {
                com.opos.mobad.r.a.a.c.a(gVar, 1, cVar.i);
            }
            if (cVar.j != null) {
                com.opos.mobad.r.a.a.c.a(gVar, 2, cVar.j);
            }
            if (cVar.k != null) {
                com.opos.mobad.r.a.a.c.a(gVar, 3, cVar.k);
            }
            if (cVar.l != null) {
                com.opos.mobad.r.a.a.c.a(gVar, 4, cVar.l);
            }
            if (cVar.m != null) {
                com.opos.mobad.r.a.a.c.a(gVar, 5, cVar.m);
            }
            if (cVar.n != null) {
                com.opos.mobad.r.a.a.c.a(gVar, 6, cVar.n);
            }
            if (cVar.o != null) {
                com.opos.mobad.r.a.a.c.a(gVar, 7, cVar.o);
            }
            if (cVar.p != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 8, cVar.p);
            }
            if (cVar.q != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 9, cVar.q);
            }
            if (cVar.r != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 10, cVar.r);
            }
            if (cVar.s != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 11, cVar.s);
            }
            if (cVar.t != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 12, cVar.t);
            }
            if (cVar.u != null) {
                d.c.a(gVar, 13, cVar.u);
            }
            gVar.a(cVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.a(com.opos.mobad.r.a.a.c.a(fVar));
                        break;
                    case 2:
                        aVar.b(com.opos.mobad.r.a.a.c.a(fVar));
                        break;
                    case 3:
                        aVar.c(com.opos.mobad.r.a.a.c.a(fVar));
                        break;
                    case 4:
                        aVar.d(com.opos.mobad.r.a.a.c.a(fVar));
                        break;
                    case 5:
                        aVar.e(com.opos.mobad.r.a.a.c.a(fVar));
                        break;
                    case 6:
                        aVar.f(com.opos.mobad.r.a.a.c.a(fVar));
                        break;
                    case 7:
                        aVar.g(com.opos.mobad.r.a.a.c.a(fVar));
                        break;
                    case 8:
                        aVar.a(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 9:
                        aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 10:
                        aVar.b(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 11:
                        aVar.c(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 12:
                        aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 13:
                        aVar.a(d.c.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }
    }

    public c(com.opos.mobad.r.a.a aVar, com.opos.mobad.r.a.a aVar2, com.opos.mobad.r.a.a aVar3, com.opos.mobad.r.a.a aVar4, com.opos.mobad.r.a.a aVar5, com.opos.mobad.r.a.a aVar6, com.opos.mobad.r.a.a aVar7, Boolean bool, Integer num, Boolean bool2, Boolean bool3, Integer num2, d dVar, ByteString byteString) {
        super(c, byteString);
        this.i = aVar;
        this.j = aVar2;
        this.k = aVar3;
        this.l = aVar4;
        this.m = aVar5;
        this.n = aVar6;
        this.o = aVar7;
        this.p = bool;
        this.q = num;
        this.r = bool2;
        this.s = bool3;
        this.t = num2;
        this.u = dVar;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
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
            sb.append(", bannerAdConfig=").append(this.n);
        }
        if (this.o != null) {
            sb.append(", splashAdConfig=").append(this.o);
        }
        if (this.p != null) {
            sb.append(", deviceIdRequired=").append(this.p);
        }
        if (this.q != null) {
            sb.append(", maxDownloadNums=").append(this.q);
        }
        if (this.r != null) {
            sb.append(", isShowDownloadToastBar=").append(this.r);
        }
        if (this.s != null) {
            sb.append(", isWifiRemindDownload=").append(this.s);
        }
        if (this.t != null) {
            sb.append(", controlFlags=").append(this.t);
        }
        if (this.u != null) {
            sb.append(", bottomAdConfig=").append(this.u);
        }
        return sb.replace(0, 2, "AppConfig{").append('}').toString();
    }
}
