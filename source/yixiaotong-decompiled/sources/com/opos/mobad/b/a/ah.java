package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class ah extends com.heytap.nearx.a.a.b<ah, a> {
    public static final com.heytap.nearx.a.a.e<ah> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    private static final long serialVersionUID = 0;
    public final String f;
    public final String g;
    public final Integer h;
    public final Integer i;
    public final String j;
    public final String k;
    public final n l;
    public final z m;
    public final w n;
    public final al o;
    public final y p;
    public final String q;

    public static final class a extends com.heytap.nearx.a.a.b.a<ah, a> {
        public String c;
        public String d;
        public Integer e;
        public Integer f;
        public String g;
        public String h;
        public n i;
        public z j;
        public w k;
        public al l;
        public y m;
        public String n;

        public a a(al alVar) {
            this.l = alVar;
            return this;
        }

        public a a(n nVar) {
            this.i = nVar;
            return this;
        }

        public a a(w wVar) {
            this.k = wVar;
            return this;
        }

        public a a(y yVar) {
            this.m = yVar;
            return this;
        }

        public a a(z zVar) {
            this.j = zVar;
            return this;
        }

        public a a(Integer num) {
            this.e = num;
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

        public a b(String str) {
            this.d = str;
            return this;
        }

        public ah b() {
            String str = this.c;
            if (str == null || this.d == null || this.e == null || this.f == null || this.g == null) {
                throw com.heytap.nearx.a.a.a.b.a(str, "appId", this.d, "packageName", this.e, "platform", this.f, "sdkVerCode", this.g, "posId");
            }
            return new ah(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, super.a());
        }

        public a c(String str) {
            this.g = str;
            return this;
        }

        public a d(String str) {
            this.h = str;
            return this;
        }

        public a e(String str) {
            this.n = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<ah> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, ah.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(ah ahVar) {
            return com.heytap.nearx.a.a.e.p.a(1, ahVar.f) + com.heytap.nearx.a.a.e.p.a(2, ahVar.g) + com.heytap.nearx.a.a.e.d.a(3, ahVar.h) + com.heytap.nearx.a.a.e.d.a(4, ahVar.i) + com.heytap.nearx.a.a.e.p.a(5, ahVar.j) + (ahVar.k != null ? com.heytap.nearx.a.a.e.p.a(6, ahVar.k) : 0) + (ahVar.l != null ? n.c.a(7, ahVar.l) : 0) + (ahVar.m != null ? z.c.a(8, ahVar.m) : 0) + (ahVar.n != null ? w.c.a(9, ahVar.n) : 0) + (ahVar.o != null ? al.c.a(10, ahVar.o) : 0) + (ahVar.p != null ? y.c.a(11, ahVar.p) : 0) + (ahVar.q != null ? com.heytap.nearx.a.a.e.p.a(12, ahVar.q) : 0) + ahVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, ah ahVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, ahVar.f);
            com.heytap.nearx.a.a.e.p.a(gVar, 2, ahVar.g);
            com.heytap.nearx.a.a.e.d.a(gVar, 3, ahVar.h);
            com.heytap.nearx.a.a.e.d.a(gVar, 4, ahVar.i);
            com.heytap.nearx.a.a.e.p.a(gVar, 5, ahVar.j);
            if (ahVar.k != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, ahVar.k);
            }
            if (ahVar.l != null) {
                n.c.a(gVar, 7, ahVar.l);
            }
            if (ahVar.m != null) {
                z.c.a(gVar, 8, ahVar.m);
            }
            if (ahVar.n != null) {
                w.c.a(gVar, 9, ahVar.n);
            }
            if (ahVar.o != null) {
                al.c.a(gVar, 10, ahVar.o);
            }
            if (ahVar.p != null) {
                y.c.a(gVar, 11, ahVar.p);
            }
            if (ahVar.q != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 12, ahVar.q);
            }
            gVar.a(ahVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ah a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 6:
                        aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.a(n.c.a(fVar));
                        break;
                    case 8:
                        aVar.a(z.c.a(fVar));
                        break;
                    case 9:
                        aVar.a(w.c.a(fVar));
                        break;
                    case 10:
                        aVar.a(al.c.a(fVar));
                        break;
                    case 11:
                        aVar.a(y.c.a(fVar));
                        break;
                    case 12:
                        aVar.e(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }
    }

    public ah(String str, String str2, Integer num, Integer num2, String str3, String str4, n nVar, z zVar, w wVar, al alVar, y yVar, String str5, ByteString byteString) {
        super(c, byteString);
        this.f = str;
        this.g = str2;
        this.h = num;
        this.i = num2;
        this.j = str3;
        this.k = str4;
        this.l = nVar;
        this.m = zVar;
        this.n = wVar;
        this.o = alVar;
        this.p = yVar;
        this.q = str5;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", appId=").append(this.f);
        sb.append(", packageName=").append(this.g);
        sb.append(", platform=").append(this.h);
        sb.append(", sdkVerCode=").append(this.i);
        sb.append(", posId=").append(this.j);
        if (this.k != null) {
            sb.append(", platformPkgName=").append(this.k);
        }
        if (this.l != null) {
            sb.append(", devInfo=").append(this.l);
        }
        if (this.m != null) {
            sb.append(", marketInfo=").append(this.m);
        }
        if (this.n != null) {
            sb.append(", instantInfo=").append(this.n);
        }
        if (this.o != null) {
            sb.append(", xgameInfo=").append(this.o);
        }
        if (this.p != null) {
            sb.append(", localInfo=").append(this.p);
        }
        if (this.q != null) {
            sb.append(", enterSource=").append(this.q);
        }
        return sb.replace(0, 2, "StateRequest{").append('}').toString();
    }
}
