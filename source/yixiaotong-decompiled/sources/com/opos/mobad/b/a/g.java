package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class g extends com.heytap.nearx.a.a.b<g, a> {
    public static final com.heytap.nearx.a.a.e<g> c = new b();
    private static final long serialVersionUID = 0;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public static final class a extends com.heytap.nearx.a.a.b.a<g, a> {
        public String c;
        public String d;
        public String e;
        public String f;

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public g b() {
            return new g(this.c, this.d, this.e, this.f, super.a());
        }

        public a c(String str) {
            this.e = str;
            return this;
        }

        public a d(String str) {
            this.f = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<g> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, g.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(g gVar) {
            return (gVar.d != null ? com.heytap.nearx.a.a.e.p.a(1, gVar.d) : 0) + (gVar.e != null ? com.heytap.nearx.a.a.e.p.a(2, gVar.e) : 0) + (gVar.f != null ? com.heytap.nearx.a.a.e.p.a(3, gVar.f) : 0) + (gVar.g != null ? com.heytap.nearx.a.a.e.p.a(4, gVar.g) : 0) + gVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, g gVar2) throws IOException {
            if (gVar2.d != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, gVar2.d);
            }
            if (gVar2.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, gVar2.e);
            }
            if (gVar2.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, gVar2.f);
            }
            if (gVar2.g != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 4, gVar2.g);
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
                if (iB == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB == 2) {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB == 3) {
                    aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB != 4) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public g(String str, String str2, String str3, String str4, ByteString byteString) {
        super(c, byteString);
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", url=").append(this.d);
        }
        if (this.e != null) {
            sb.append(", md5=").append(this.e);
        }
        if (this.f != null) {
            sb.append(", pkgName=").append(this.f);
        }
        if (this.g != null) {
            sb.append(", appName=").append(this.g);
        }
        return sb.replace(0, 2, "AppDownInfo{").append('}').toString();
    }
}
