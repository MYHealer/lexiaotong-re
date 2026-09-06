package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class ai extends com.heytap.nearx.a.a.b<ai, a> {
    public static final com.heytap.nearx.a.a.e<ai> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    private static final long serialVersionUID = 0;
    public final Integer f;
    public final Integer g;

    public static final class a extends com.heytap.nearx.a.a.b.a<ai, a> {
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

        public ai b() {
            Integer num = this.c;
            if (num == null || this.d == null) {
                throw com.heytap.nearx.a.a.a.b.a(num, "code", this.d, "validTime");
            }
            return new ai(this.c, this.d, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<ai> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, ai.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(ai aiVar) {
            return com.heytap.nearx.a.a.e.d.a(1, aiVar.f) + com.heytap.nearx.a.a.e.d.a(10, aiVar.g) + aiVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, ai aiVar) throws IOException {
            com.heytap.nearx.a.a.e.d.a(gVar, 1, aiVar.f);
            com.heytap.nearx.a.a.e.d.a(gVar, 10, aiVar.g);
            gVar.a(aiVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ai a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                } else if (iB != 10) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                }
            }
        }
    }

    public ai(Integer num, Integer num2, ByteString byteString) {
        super(c, byteString);
        this.f = num;
        this.g = num2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", code=").append(this.f);
        sb.append(", validTime=").append(this.g);
        return sb.replace(0, 2, "StateResponse{").append('}').toString();
    }
}
