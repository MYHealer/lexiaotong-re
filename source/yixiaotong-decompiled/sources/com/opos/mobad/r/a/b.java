package com.opos.mobad.r.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class b extends com.heytap.nearx.a.a.b<b, a> {
    public static final com.heytap.nearx.a.a.e<b> c = new C0984b();
    public static final Integer d = 0;
    private static final long serialVersionUID = 0;
    public final String e;
    public final Integer f;

    public static final class a extends com.heytap.nearx.a.a.b.a<b, a> {
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

        public b b() {
            return new b(this.c, this.d, super.a());
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.r.a.b$b, reason: collision with other inner class name */
    private static final class C0984b extends com.heytap.nearx.a.a.e<b> {
        C0984b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, b.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(b bVar) {
            return (bVar.e != null ? com.heytap.nearx.a.a.e.p.a(1, bVar.e) : 0) + (bVar.f != null ? com.heytap.nearx.a.a.e.d.a(2, bVar.f) : 0) + bVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, b bVar) throws IOException {
            if (bVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, bVar.e);
            }
            if (bVar.f != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 2, bVar.f);
            }
            gVar.a(bVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public b(String str, Integer num, ByteString byteString) {
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
