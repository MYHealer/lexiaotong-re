package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class aa extends com.heytap.nearx.a.a.b<aa, a> {
    public static final com.heytap.nearx.a.a.e<aa> c = new b();
    private static final long serialVersionUID = 0;
    public final String d;
    public final String e;

    public static final class a extends com.heytap.nearx.a.a.b.a<aa, a> {
        public String c;
        public String d;

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public aa b() {
            return new aa(this.c, this.d, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<aa> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, aa.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(aa aaVar) {
            return (aaVar.d != null ? com.heytap.nearx.a.a.e.p.a(1, aaVar.d) : 0) + (aaVar.e != null ? com.heytap.nearx.a.a.e.p.a(2, aaVar.e) : 0) + aaVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, aa aaVar) throws IOException {
            if (aaVar.d != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, aaVar.d);
            }
            if (aaVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, aaVar.e);
            }
            gVar.a(aaVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public aa a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                } else if (iB != 2) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public aa(String str, String str2, ByteString byteString) {
        super(c, byteString);
        this.d = str;
        this.e = str2;
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
        return sb.replace(0, 2, "MaterialFile{").append('}').toString();
    }
}
