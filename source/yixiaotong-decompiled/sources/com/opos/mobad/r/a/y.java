package com.opos.mobad.r.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class y extends com.heytap.nearx.a.a.b<y, a> {
    public static final com.heytap.nearx.a.a.e<y> c = new b();
    public static final Integer d = 0;
    public static final z e = z.UNKNOWN_STATUS;
    public static final Boolean f = false;
    private static final long serialVersionUID = 0;
    public final Integer g;
    public final z h;
    public final Boolean i;

    public static final class a extends com.heytap.nearx.a.a.b.a<y, a> {
        public Integer c;
        public z d;
        public Boolean e;

        public a a(z zVar) {
            this.d = zVar;
            return this;
        }

        public a a(Boolean bool) {
            this.e = bool;
            return this;
        }

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public y b() {
            Integer num = this.c;
            if (num == null || this.d == null || this.e == null) {
                throw com.heytap.nearx.a.a.a.b.a(num, "code", this.d, "vipStatus", this.e, "rightValid");
            }
            return new y(this.c, this.d, this.e, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<y> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, y.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(y yVar) {
            return com.heytap.nearx.a.a.e.d.a(1, yVar.g) + z.d.a(2, yVar.h) + com.heytap.nearx.a.a.e.c.a(3, yVar.i) + yVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, y yVar) throws IOException {
            com.heytap.nearx.a.a.e.d.a(gVar, 1, yVar.g);
            z.d.a(gVar, 2, yVar.h);
            com.heytap.nearx.a.a.e.c.a(gVar, 3, yVar.i);
            gVar.a(yVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public y a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                } else if (iB == 2) {
                    try {
                        aVar.a(z.d.a(fVar));
                    } catch (com.heytap.nearx.a.a.e.a e) {
                        aVar.a(iB, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f3488a));
                    }
                } else if (iB != 3) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.a.a.e.c.a(fVar));
                }
            }
        }
    }

    public y(Integer num, z zVar, Boolean bool, ByteString byteString) {
        super(c, byteString);
        this.g = num;
        this.h = zVar;
        this.i = bool;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", code=").append(this.g);
        sb.append(", vipStatus=").append(this.h);
        sb.append(", rightValid=").append(this.i);
        return sb.replace(0, 2, "VipInfoResponse{").append('}').toString();
    }
}
