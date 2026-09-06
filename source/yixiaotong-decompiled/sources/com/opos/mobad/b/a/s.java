package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class s extends com.heytap.nearx.a.a.b<s, a> {
    public static final com.heytap.nearx.a.a.e<s> c = new b();
    public static final Integer d = 0;
    private static final long serialVersionUID = 0;
    public final Integer e;
    public final String f;

    public static final class a extends com.heytap.nearx.a.a.b.a<s, a> {
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

        public s b() {
            Integer num = this.c;
            if (num != null) {
                return new s(this.c, this.d, super.a());
            }
            throw com.heytap.nearx.a.a.a.b.a(num, "feedBackType");
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<s> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, s.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(s sVar) {
            return com.heytap.nearx.a.a.e.d.a(1, sVar.e) + (sVar.f != null ? com.heytap.nearx.a.a.e.p.a(2, sVar.f) : 0) + sVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, s sVar) throws IOException {
            com.heytap.nearx.a.a.e.d.a(gVar, 1, sVar.e);
            if (sVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, sVar.f);
            }
            gVar.a(sVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public s a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public s(Integer num, String str, ByteString byteString) {
        super(c, byteString);
        this.e = num;
        this.f = str;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", feedBackType=").append(this.e);
        if (this.f != null) {
            sb.append(", feedBackUrl=").append(this.f);
        }
        return sb.replace(0, 2, "FeedBackInfo{").append('}').toString();
    }
}
