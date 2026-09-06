package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class ad extends com.heytap.nearx.a.a.b<ad, a> {
    public static final com.heytap.nearx.a.a.e<ad> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    private static final long serialVersionUID = 0;
    public final Integer f;
    public final Integer g;

    public static final class a extends com.heytap.nearx.a.a.b.a<ad, a> {
        public Integer c;
        public Integer d;

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public a b(Integer num) {
            this.d = num;
            return this;
        }

        public ad b() {
            return new ad(this.c, this.d, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<ad> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, ad.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(ad adVar) {
            return (adVar.f != null ? com.heytap.nearx.a.a.e.d.a(1, adVar.f) : 0) + (adVar.g != null ? com.heytap.nearx.a.a.e.d.a(2, adVar.g) : 0) + adVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, ad adVar) throws IOException {
            if (adVar.f != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 1, adVar.f);
            }
            if (adVar.g != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 2, adVar.g);
            }
            gVar.a(adVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ad a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                    aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                }
            }
        }
    }

    public ad(Integer num, Integer num2, ByteString byteString) {
        super(c, byteString);
        this.f = num;
        this.g = num2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f != null) {
            sb.append(", height=").append(this.f);
        }
        if (this.g != null) {
            sb.append(", width=").append(this.g);
        }
        return sb.replace(0, 2, "PosSize{").append('}').toString();
    }
}
