package com.opos.mobad.r.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class i extends com.heytap.nearx.a.a.b<i, a> {
    public static final com.heytap.nearx.a.a.e<i> c = new b();
    public static final Boolean d = true;
    public static final Boolean e = true;
    public static final Integer f = 0;
    private static final long serialVersionUID = 0;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final Boolean m;
    public final Boolean n;
    public final String o;
    public final Integer p;

    public static final class a extends com.heytap.nearx.a.a.b.a<i, a> {
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public Boolean i;
        public Boolean j;
        public String k;
        public Integer l;

        public a a(Boolean bool) {
            this.i = bool;
            return this;
        }

        public a a(Integer num) {
            this.l = num;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a b(Boolean bool) {
            this.j = bool;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public i b() {
            return new i(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, super.a());
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
            this.k = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<i> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, i.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(i iVar) {
            return (iVar.g != null ? com.heytap.nearx.a.a.e.p.a(1, iVar.g) : 0) + (iVar.h != null ? com.heytap.nearx.a.a.e.p.a(2, iVar.h) : 0) + (iVar.i != null ? com.heytap.nearx.a.a.e.p.a(3, iVar.i) : 0) + (iVar.j != null ? com.heytap.nearx.a.a.e.p.a(4, iVar.j) : 0) + (iVar.k != null ? com.heytap.nearx.a.a.e.p.a(5, iVar.k) : 0) + (iVar.l != null ? com.heytap.nearx.a.a.e.p.a(6, iVar.l) : 0) + (iVar.m != null ? com.heytap.nearx.a.a.e.c.a(7, iVar.m) : 0) + (iVar.n != null ? com.heytap.nearx.a.a.e.c.a(8, iVar.n) : 0) + (iVar.o != null ? com.heytap.nearx.a.a.e.p.a(9, iVar.o) : 0) + (iVar.p != null ? com.heytap.nearx.a.a.e.d.a(10, iVar.p) : 0) + iVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, i iVar) throws IOException {
            if (iVar.g != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, iVar.g);
            }
            if (iVar.h != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, iVar.h);
            }
            if (iVar.i != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, iVar.i);
            }
            if (iVar.j != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 4, iVar.j);
            }
            if (iVar.k != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 5, iVar.k);
            }
            if (iVar.l != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, iVar.l);
            }
            if (iVar.m != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 7, iVar.m);
            }
            if (iVar.n != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 8, iVar.n);
            }
            if (iVar.o != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 9, iVar.o);
            }
            if (iVar.p != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 10, iVar.p);
            }
            gVar.a(iVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public i a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.a(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 8:
                        aVar.b(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 9:
                        aVar.g(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 10:
                        aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }
    }

    public i(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, String str7, Integer num, ByteString byteString) {
        super(c, byteString);
        this.g = str;
        this.h = str2;
        this.i = str3;
        this.j = str4;
        this.k = str5;
        this.l = str6;
        this.m = bool;
        this.n = bool2;
        this.o = str7;
        this.p = num;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append(", imei=").append(this.g);
        }
        if (this.h != null) {
            sb.append(", anId=").append(this.h);
        }
        if (this.i != null) {
            sb.append(", mac=").append(this.i);
        }
        if (this.j != null) {
            sb.append(", ouId=").append(this.j);
        }
        if (this.k != null) {
            sb.append(", duId=").append(this.k);
        }
        if (this.l != null) {
            sb.append(", guId=").append(this.l);
        }
        if (this.m != null) {
            sb.append(", ouIdOpenStatus=").append(this.m);
        }
        if (this.n != null) {
            sb.append(", appOuidStatus=").append(this.n);
        }
        if (this.o != null) {
            sb.append(", gaId=").append(this.o);
        }
        if (this.p != null) {
            sb.append(", imeiType=").append(this.p);
        }
        return sb.replace(0, 2, "DevId{").append('}').toString();
    }
}
