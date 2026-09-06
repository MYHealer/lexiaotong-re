package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class j extends com.heytap.nearx.a.a.b<j, a> {
    public static final com.heytap.nearx.a.a.e<j> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    public static final Boolean f = true;
    public static final Boolean g = true;
    private static final long serialVersionUID = 0;
    public final String h;
    public final String i;
    public final Integer j;
    public final Integer k;
    public final n l;
    public final Boolean m;
    public final Boolean n;

    public static final class a extends com.heytap.nearx.a.a.b.a<j, a> {
        public String c;
        public String d;
        public Integer e;
        public Integer f;
        public n g;
        public Boolean h;
        public Boolean i;

        public a a(n nVar) {
            this.g = nVar;
            return this;
        }

        public a a(Boolean bool) {
            this.h = bool;
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

        public a b(Boolean bool) {
            this.i = bool;
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

        public j b() {
            String str = this.c;
            if (str == null || this.d == null || this.e == null || this.f == null) {
                throw com.heytap.nearx.a.a.a.b.a(str, "appId", this.d, "packageName", this.e, "platform", this.f, "sdkVerCode");
            }
            return new j(this.c, this.d, this.e, this.f, this.g, this.h, this.i, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<j> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, j.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(j jVar) {
            return com.heytap.nearx.a.a.e.p.a(1, jVar.h) + com.heytap.nearx.a.a.e.p.a(2, jVar.i) + com.heytap.nearx.a.a.e.d.a(3, jVar.j) + com.heytap.nearx.a.a.e.d.a(4, jVar.k) + (jVar.l != null ? n.c.a(5, jVar.l) : 0) + (jVar.m != null ? com.heytap.nearx.a.a.e.c.a(6, jVar.m) : 0) + (jVar.n != null ? com.heytap.nearx.a.a.e.c.a(7, jVar.n) : 0) + jVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, j jVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, jVar.h);
            com.heytap.nearx.a.a.e.p.a(gVar, 2, jVar.i);
            com.heytap.nearx.a.a.e.d.a(gVar, 3, jVar.j);
            com.heytap.nearx.a.a.e.d.a(gVar, 4, jVar.k);
            if (jVar.l != null) {
                n.c.a(gVar, 5, jVar.l);
            }
            if (jVar.m != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 6, jVar.m);
            }
            if (jVar.n != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 7, jVar.n);
            }
            gVar.a(jVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public j a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.a(n.c.a(fVar));
                        break;
                    case 6:
                        aVar.a(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 7:
                        aVar.b(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }
    }

    public j(String str, String str2, Integer num, Integer num2, n nVar, Boolean bool, Boolean bool2, ByteString byteString) {
        super(c, byteString);
        this.h = str;
        this.i = str2;
        this.j = num;
        this.k = num2;
        this.l = nVar;
        this.m = bool;
        this.n = bool2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", appId=").append(this.h);
        sb.append(", packageName=").append(this.i);
        sb.append(", platform=").append(this.j);
        sb.append(", sdkVerCode=").append(this.k);
        if (this.l != null) {
            sb.append(", devInfo=").append(this.l);
        }
        if (this.m != null) {
            sb.append(", ouIdOpenStatus=").append(this.m);
        }
        if (this.n != null) {
            sb.append(", appOuidStatus=").append(this.n);
        }
        return sb.replace(0, 2, "ControlRequest{").append('}').toString();
    }
}
