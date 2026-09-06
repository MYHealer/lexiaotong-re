package com.opos.mobad.r.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class d extends com.heytap.nearx.a.a.b<d, a> {
    public static final com.heytap.nearx.a.a.e<d> c = new b();
    public static final Boolean d = false;
    private static final long serialVersionUID = 0;
    public final Boolean e;
    public final String f;

    public static final class a extends com.heytap.nearx.a.a.b.a<d, a> {
        public Boolean c;
        public String d;

        public a a(Boolean bool) {
            this.c = bool;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public d b() {
            Boolean bool = this.c;
            if (bool != null) {
                return new d(this.c, this.d, super.a());
            }
            throw com.heytap.nearx.a.a.a.b.a(bool, "isRefreshBottomAd");
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<d> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, d.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(d dVar) {
            return com.heytap.nearx.a.a.e.c.a(1, dVar.e) + (dVar.f != null ? com.heytap.nearx.a.a.e.p.a(2, dVar.f) : 0) + dVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, d dVar) throws IOException {
            com.heytap.nearx.a.a.e.c.a(gVar, 1, dVar.e);
            if (dVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, dVar.f);
            }
            gVar.a(dVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public d a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.c.a(fVar));
                } else if (iB != 2) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public d(Boolean bool, String str, ByteString byteString) {
        super(c, byteString);
        this.e = bool;
        this.f = str;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", isRefreshBottomAd=").append(this.e);
        if (this.f != null) {
            sb.append(", bottomReqAdPosId=").append(this.f);
        }
        return sb.replace(0, 2, "BottomAdConfig{").append('}').toString();
    }
}
