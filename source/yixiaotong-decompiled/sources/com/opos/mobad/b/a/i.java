package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class i extends com.heytap.nearx.a.a.b<i, a> {
    public static final com.heytap.nearx.a.a.e<i> c = new b();
    private static final long serialVersionUID = 0;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    public static final class a extends com.heytap.nearx.a.a.b.a<i, a> {
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public i b() {
            String str = this.c;
            if (str == null || this.d == null || this.e == null || this.f == null || this.g == null) {
                throw com.heytap.nearx.a.a.a.b.a(str, "permissionUrl", this.d, "privacyUrl", this.e, "versionName", this.f, "developerName", this.g, "appDescUrl");
            }
            return new i(this.c, this.d, this.e, this.f, this.g, super.a());
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
    }

    private static final class b extends com.heytap.nearx.a.a.e<i> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, i.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(i iVar) {
            return com.heytap.nearx.a.a.e.p.a(1, iVar.d) + com.heytap.nearx.a.a.e.p.a(2, iVar.e) + com.heytap.nearx.a.a.e.p.a(3, iVar.f) + com.heytap.nearx.a.a.e.p.a(4, iVar.g) + com.heytap.nearx.a.a.e.p.a(5, iVar.h) + iVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, i iVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, iVar.d);
            com.heytap.nearx.a.a.e.p.a(gVar, 2, iVar.e);
            com.heytap.nearx.a.a.e.p.a(gVar, 3, iVar.f);
            com.heytap.nearx.a.a.e.p.a(gVar, 4, iVar.g);
            com.heytap.nearx.a.a.e.p.a(gVar, 5, iVar.h);
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
                if (iB == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB == 2) {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB == 3) {
                    aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB == 4) {
                    aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB != 5) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.e(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public i(String str, String str2, String str3, String str4, String str5, ByteString byteString) {
        super(c, byteString);
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = str5;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", permissionUrl=").append(this.d);
        sb.append(", privacyUrl=").append(this.e);
        sb.append(", versionName=").append(this.f);
        sb.append(", developerName=").append(this.g);
        sb.append(", appDescUrl=").append(this.h);
        return sb.replace(0, 2, "AppPrivacyInfo{").append('}').toString();
    }
}
