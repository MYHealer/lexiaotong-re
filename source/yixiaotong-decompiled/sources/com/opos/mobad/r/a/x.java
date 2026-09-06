package com.opos.mobad.r.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class x extends com.heytap.nearx.a.a.b<x, a> {
    public static final com.heytap.nearx.a.a.e<x> c = new b();
    private static final long serialVersionUID = 0;
    public final String d;
    public final w e;
    public final j f;
    public final String g;

    public static final class a extends com.heytap.nearx.a.a.b.a<x, a> {
        public String c;
        public w d;
        public j e;
        public String f;

        public a a(j jVar) {
            this.e = jVar;
            return this;
        }

        public a a(w wVar) {
            this.d = wVar;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a b(String str) {
            this.f = str;
            return this;
        }

        public x b() {
            String str = this.c;
            if (str == null || this.d == null || this.e == null || this.f == null) {
                throw com.heytap.nearx.a.a.a.b.a(str, "posId", this.d, "userAccountInfo", this.e, "devInfo", this.f, "platformPkgName");
            }
            return new x(this.c, this.d, this.e, this.f, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<x> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, x.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(x xVar) {
            return com.heytap.nearx.a.a.e.p.a(1, xVar.d) + w.c.a(2, xVar.e) + j.c.a(3, xVar.f) + com.heytap.nearx.a.a.e.p.a(4, xVar.g) + xVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, x xVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, xVar.d);
            w.c.a(gVar, 2, xVar.e);
            j.c.a(gVar, 3, xVar.f);
            com.heytap.nearx.a.a.e.p.a(gVar, 4, xVar.g);
            gVar.a(xVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public x a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB == 2) {
                    aVar.a(w.c.a(fVar));
                } else if (iB == 3) {
                    aVar.a(j.c.a(fVar));
                } else if (iB != 4) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public x(String str, w wVar, j jVar, String str2, ByteString byteString) {
        super(c, byteString);
        this.d = str;
        this.e = wVar;
        this.f = jVar;
        this.g = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", posId=").append(this.d);
        sb.append(", userAccountInfo=").append(this.e);
        sb.append(", devInfo=").append(this.f);
        sb.append(", platformPkgName=").append(this.g);
        return sb.replace(0, 2, "VipInfoReq{").append('}').toString();
    }
}
