package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class f extends com.heytap.nearx.a.a.b<f, a> {
    public static final com.heytap.nearx.a.a.e<f> c = new b();
    private static final long serialVersionUID = 0;
    public final String d;
    public final String e;
    public final String f;

    public static final class a extends com.heytap.nearx.a.a.b.a<f, a> {
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

        public f b() {
            return new f(this.c, this.d, this.e, super.a());
        }

        public a c(String str) {
            this.e = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<f> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, f.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(f fVar) {
            return (fVar.d != null ? com.heytap.nearx.a.a.e.p.a(1, fVar.d) : 0) + (fVar.e != null ? com.heytap.nearx.a.a.e.p.a(2, fVar.e) : 0) + (fVar.f != null ? com.heytap.nearx.a.a.e.p.a(3, fVar.f) : 0) + fVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, f fVar) throws IOException {
            if (fVar.d != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, fVar.d);
            }
            if (fVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, fVar.e);
            }
            if (fVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, fVar.f);
            }
            gVar.a(fVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public f(String str, String str2, String str3) {
        this(str, str2, str3, ByteString.EMPTY);
    }

    public f(String str, String str2, String str3, ByteString byteString) {
        super(c, byteString);
        this.d = str;
        this.e = str2;
        this.f = str3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", md5=").append(this.d);
        }
        if (this.e != null) {
            sb.append(", sha1=").append(this.e);
        }
        if (this.f != null) {
            sb.append(", sha256=").append(this.f);
        }
        return sb.replace(0, 2, "ApkSigner{").append('}').toString();
    }
}
