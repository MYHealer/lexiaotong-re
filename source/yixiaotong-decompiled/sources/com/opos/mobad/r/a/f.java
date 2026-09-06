package com.opos.mobad.r.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class f extends com.heytap.nearx.a.a.b<f, a> {
    public static final com.heytap.nearx.a.a.e<f> c = new b();
    public static final Integer d = 0;
    private static final long serialVersionUID = 0;
    public final Integer e;

    public static final class a extends com.heytap.nearx.a.a.b.a<f, a> {
        public Integer c;

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public f b() {
            Integer num = this.c;
            if (num != null) {
                return new f(this.c, super.a());
            }
            throw com.heytap.nearx.a.a.a.b.a(num, "cacheInternal");
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<f> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, f.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(f fVar) {
            return com.heytap.nearx.a.a.e.d.a(1, fVar.e) + fVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, f fVar) throws IOException {
            com.heytap.nearx.a.a.e.d.a(gVar, 1, fVar.e);
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
                if (iB != 1) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                }
            }
        }
    }

    public f(Integer num, ByteString byteString) {
        super(c, byteString);
        this.e = num;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", cacheInternal=").append(this.e);
        return sb.replace(0, 2, "ChannelAdConfig{").append('}').toString();
    }
}
