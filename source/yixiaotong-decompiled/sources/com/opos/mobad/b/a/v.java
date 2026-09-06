package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class v extends com.heytap.nearx.a.a.b<v, a> {
    public static final com.heytap.nearx.a.a.e<v> c = new b();
    private static final long serialVersionUID = 0;
    public final String d;
    public final String e;

    public static final class a extends com.heytap.nearx.a.a.b.a<v, a> {
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

        public v b() {
            return new v(this.c, this.d, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<v> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, v.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(v vVar) {
            return (vVar.d != null ? com.heytap.nearx.a.a.e.p.a(1, vVar.d) : 0) + (vVar.e != null ? com.heytap.nearx.a.a.e.p.a(2, vVar.e) : 0) + vVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, v vVar) throws IOException {
            if (vVar.d != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, vVar.d);
            }
            if (vVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, vVar.e);
            }
            gVar.a(vVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public v a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public v(String str, String str2, ByteString byteString) {
        super(c, byteString);
        this.d = str;
        this.e = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", origin=").append(this.d);
        }
        if (this.e != null) {
            sb.append(", secret=").append(this.e);
        }
        return sb.replace(0, 2, "InstantIds{").append('}').toString();
    }
}
