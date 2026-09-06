package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class m extends com.heytap.nearx.a.a.b<m, a> {
    public static final com.heytap.nearx.a.a.e<m> c = new b();
    public static final Integer d = 0;
    private static final long serialVersionUID = 0;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final Integer p;
    public final String q;

    public static final class a extends com.heytap.nearx.a.a.b.a<m, a> {
        public String c;
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
        public Integer n;
        public String o;

        public a a(Integer num) {
            this.n = num;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public m b() {
            return new m(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, super.a());
        }

        public a c(String str) {
            this.e = str;
            return this;
        }

        public a d(String str) {
            this.f = str;
            return this;
        }

        public a e(String str) {
            this.g = str;
            return this;
        }

        public a f(String str) {
            this.h = str;
            return this;
        }

        public a g(String str) {
            this.i = str;
            return this;
        }

        public a h(String str) {
            this.j = str;
            return this;
        }

        public a i(String str) {
            this.k = str;
            return this;
        }

        public a j(String str) {
            this.l = str;
            return this;
        }

        public a k(String str) {
            this.m = str;
            return this;
        }

        public a l(String str) {
            this.o = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<m> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, m.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(m mVar) {
            return (mVar.e != null ? com.heytap.nearx.a.a.e.p.a(1, mVar.e) : 0) + (mVar.f != null ? com.heytap.nearx.a.a.e.p.a(2, mVar.f) : 0) + (mVar.g != null ? com.heytap.nearx.a.a.e.p.a(3, mVar.g) : 0) + (mVar.h != null ? com.heytap.nearx.a.a.e.p.a(4, mVar.h) : 0) + (mVar.i != null ? com.heytap.nearx.a.a.e.p.a(5, mVar.i) : 0) + (mVar.j != null ? com.heytap.nearx.a.a.e.p.a(6, mVar.j) : 0) + (mVar.k != null ? com.heytap.nearx.a.a.e.p.a(7, mVar.k) : 0) + (mVar.l != null ? com.heytap.nearx.a.a.e.p.a(8, mVar.l) : 0) + (mVar.m != null ? com.heytap.nearx.a.a.e.p.a(9, mVar.m) : 0) + (mVar.n != null ? com.heytap.nearx.a.a.e.p.a(10, mVar.n) : 0) + (mVar.o != null ? com.heytap.nearx.a.a.e.p.a(11, mVar.o) : 0) + (mVar.p != null ? com.heytap.nearx.a.a.e.d.a(12, mVar.p) : 0) + (mVar.q != null ? com.heytap.nearx.a.a.e.p.a(13, mVar.q) : 0) + mVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, m mVar) throws IOException {
            if (mVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, mVar.e);
            }
            if (mVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, mVar.f);
            }
            if (mVar.g != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, mVar.g);
            }
            if (mVar.h != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 4, mVar.h);
            }
            if (mVar.i != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 5, mVar.i);
            }
            if (mVar.j != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, mVar.j);
            }
            if (mVar.k != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 7, mVar.k);
            }
            if (mVar.l != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 8, mVar.l);
            }
            if (mVar.m != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 9, mVar.m);
            }
            if (mVar.n != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 10, mVar.n);
            }
            if (mVar.o != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 11, mVar.o);
            }
            if (mVar.p != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 12, mVar.p);
            }
            if (mVar.q != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 13, mVar.q);
            }
            gVar.a(mVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public m a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 4:
                        aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 5:
                        aVar.e(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 6:
                        aVar.f(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.g(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 8:
                        aVar.h(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 9:
                        aVar.i(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 10:
                        aVar.j(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 11:
                        aVar.k(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 12:
                        aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 13:
                        aVar.l(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }
    }

    public m(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Integer num, String str12, ByteString byteString) {
        super(c, byteString);
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = str5;
        this.j = str6;
        this.k = str7;
        this.l = str8;
        this.m = str9;
        this.n = str10;
        this.o = str11;
        this.p = num;
        this.q = str12;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", imei=").append(this.e);
        }
        if (this.f != null) {
            sb.append(", anId=").append(this.f);
        }
        if (this.g != null) {
            sb.append(", mac=").append(this.g);
        }
        if (this.h != null) {
            sb.append(", oaId=").append(this.h);
        }
        if (this.i != null) {
            sb.append(", vaId=").append(this.i);
        }
        if (this.j != null) {
            sb.append(", udId=").append(this.j);
        }
        if (this.k != null) {
            sb.append(", ouId=").append(this.k);
        }
        if (this.l != null) {
            sb.append(", duId=").append(this.l);
        }
        if (this.m != null) {
            sb.append(", guId=").append(this.m);
        }
        if (this.n != null) {
            sb.append(", mkDuId=").append(this.n);
        }
        if (this.o != null) {
            sb.append(", serialId=").append(this.o);
        }
        if (this.p != null) {
            sb.append(", imeiType=").append(this.p);
        }
        if (this.q != null) {
            sb.append(", osId=").append(this.q);
        }
        return sb.replace(0, 2, "DevId{").append('}').toString();
    }
}
