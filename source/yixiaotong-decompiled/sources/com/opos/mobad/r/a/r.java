package com.opos.mobad.r.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class r extends com.heytap.nearx.a.a.b<r, a> {
    public static final com.heytap.nearx.a.a.e<r> c = new b();
    public static final Integer d = 0;
    private static final long serialVersionUID = 0;
    public final Integer e;
    public final String f;

    public static final class a extends com.heytap.nearx.a.a.b.a<r, a> {
        public Integer c;
        public String d;

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public r b() {
            Integer num = this.c;
            if (num == null || this.d == null) {
                throw com.heytap.nearx.a.a.a.b.a(num, "templateId", this.d, "dyMaterialUrl");
            }
            return new r(this.c, this.d, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<r> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, r.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(r rVar) {
            return com.heytap.nearx.a.a.e.d.a(1, rVar.e) + com.heytap.nearx.a.a.e.p.a(2, rVar.f) + rVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, r rVar) throws IOException {
            com.heytap.nearx.a.a.e.d.a(gVar, 1, rVar.e);
            com.heytap.nearx.a.a.e.p.a(gVar, 2, rVar.f);
            gVar.a(rVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public r a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                } else if (iB != 2) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public r(Integer num, String str, ByteString byteString) {
        super(c, byteString);
        this.e = num;
        this.f = str;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", templateId=").append(this.e);
        sb.append(", dyMaterialUrl=").append(this.f);
        return sb.replace(0, 2, "PreLoadResource{").append('}').toString();
    }
}
