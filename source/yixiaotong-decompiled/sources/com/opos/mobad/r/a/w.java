package com.opos.mobad.r.a;

import com.cdo.oaps.ad.OapsKey;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class w extends com.heytap.nearx.a.a.b<w, a> {
    public static final com.heytap.nearx.a.a.e<w> c = new b();
    public static final z d = z.UNKNOWN_STATUS;
    private static final long serialVersionUID = 0;
    public final String e;
    public final z f;

    public static final class a extends com.heytap.nearx.a.a.b.a<w, a> {
        public String c;
        public z d;

        public a a(z zVar) {
            this.d = zVar;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public w b() {
            String str = this.c;
            if (str != null) {
                return new w(this.c, this.d, super.a());
            }
            throw com.heytap.nearx.a.a.a.b.a(str, OapsKey.KEY_TOKEN);
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<w> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, w.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(w wVar) {
            return com.heytap.nearx.a.a.e.p.a(1, wVar.e) + (wVar.f != null ? z.d.a(2, wVar.f) : 0) + wVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, w wVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, wVar.e);
            if (wVar.f != null) {
                z.d.a(gVar, 2, wVar.f);
            }
            gVar.a(wVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public w a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                    try {
                        aVar.a(z.d.a(fVar));
                    } catch (com.heytap.nearx.a.a.e.a e) {
                        aVar.a(iB, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f3488a));
                    }
                }
            }
        }
    }

    public w(String str, z zVar, ByteString byteString) {
        super(c, byteString);
        this.e = str;
        this.f = zVar;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", token=").append(this.e);
        if (this.f != null) {
            sb.append(", vipStatus=").append(this.f);
        }
        return sb.replace(0, 2, "UserAccountInfo{").append('}').toString();
    }
}
