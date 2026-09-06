package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class ak extends com.heytap.nearx.a.a.b<ak, a> {
    public static final com.heytap.nearx.a.a.e<ak> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    private static final long serialVersionUID = 0;
    public final Integer f;
    public final Integer g;

    public static final class a extends com.heytap.nearx.a.a.b.a<ak, a> {
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

        public ak b() {
            return new ak(this.c, this.d, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<ak> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, ak.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(ak akVar) {
            return (akVar.f != null ? com.heytap.nearx.a.a.e.d.a(1, akVar.f) : 0) + (akVar.g != null ? com.heytap.nearx.a.a.e.d.a(2, akVar.g) : 0) + akVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, ak akVar) throws IOException {
            if (akVar.f != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 1, akVar.f);
            }
            if (akVar.g != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 2, akVar.g);
            }
            gVar.a(akVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ak a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public ak(Integer num, Integer num2) {
        this(num, num2, ByteString.EMPTY);
    }

    public ak(Integer num, Integer num2, ByteString byteString) {
        super(c, byteString);
        this.f = num;
        this.g = num2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f != null) {
            sb.append(", wxOpenSdkVer=").append(this.f);
        }
        if (this.g != null) {
            sb.append(", wxApiVer=").append(this.g);
        }
        return sb.replace(0, 2, "WXInfo{").append('}').toString();
    }
}
