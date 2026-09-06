package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class e extends com.heytap.nearx.a.a.b<e, a> {
    public static final com.heytap.nearx.a.a.e<e> c = new b();
    public static final Integer d = 0;
    private static final long serialVersionUID = 0;
    public final String e;
    public final Integer f;

    public static final class a extends com.heytap.nearx.a.a.b.a<e, a> {
        public String c;
        public Integer d;

        public a a(Integer num) {
            this.d = num;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public e b() {
            return new e(this.c, this.d, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<e> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, e.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(e eVar) {
            return (eVar.e != null ? com.heytap.nearx.a.a.e.p.a(1, eVar.e) : 0) + (eVar.f != null ? com.heytap.nearx.a.a.e.d.a(2, eVar.f) : 0) + eVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, e eVar) throws IOException {
            if (eVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, eVar.e);
            }
            if (eVar.f != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 2, eVar.f);
            }
            gVar.a(eVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                    aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                }
            }
        }
    }

    public e(String str, Integer num, ByteString byteString) {
        super(c, byteString);
        this.e = str;
        this.f = num;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", verName=").append(this.e);
        }
        if (this.f != null) {
            sb.append(", verCode=").append(this.f);
        }
        return sb.replace(0, 2, "ApkInfo{").append('}').toString();
    }
}
