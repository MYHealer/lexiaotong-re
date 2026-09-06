package com.opos.mobad.r.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class k extends com.heytap.nearx.a.a.b<k, a> {
    public static final com.heytap.nearx.a.a.e<k> c = new b();
    private static final long serialVersionUID = 0;
    public final String d;
    public final String e;
    public final String f;

    public static final class a extends com.heytap.nearx.a.a.b.a<k, a> {
        public String c;
        public String d;
        public String e;

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public k b() {
            return new k(this.c, this.d, this.e, super.a());
        }

        public a c(String str) {
            this.e = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<k> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, k.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(k kVar) {
            return (kVar.d != null ? com.heytap.nearx.a.a.e.p.a(1, kVar.d) : 0) + (kVar.e != null ? com.heytap.nearx.a.a.e.p.a(2, kVar.e) : 0) + (kVar.f != null ? com.heytap.nearx.a.a.e.p.a(3, kVar.f) : 0) + kVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, k kVar) throws IOException {
            if (kVar.d != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, kVar.d);
            }
            if (kVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, kVar.e);
            }
            if (kVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, kVar.f);
            }
            gVar.a(kVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public k a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                } else if (iB != 3) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public k(String str, String str2, String str3, ByteString byteString) {
        super(c, byteString);
        this.d = str;
        this.e = str2;
        this.f = str3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", osVer=").append(this.d);
        }
        if (this.e != null) {
            sb.append(", romVer=").append(this.e);
        }
        if (this.f != null) {
            sb.append(", anVer=").append(this.f);
        }
        return sb.replace(0, 2, "DevOs{").append('}').toString();
    }
}
