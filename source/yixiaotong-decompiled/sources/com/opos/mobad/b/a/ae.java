package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class ae extends com.heytap.nearx.a.a.b<ae, a> {
    public static final com.heytap.nearx.a.a.e<ae> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    public static final Integer f = 0;
    private static final long serialVersionUID = 0;
    public final Integer g;
    public final String h;
    public final Integer i;
    public final Integer j;

    public static final class a extends com.heytap.nearx.a.a.b.a<ae, a> {
        public Integer c;
        public String d;
        public Integer e;
        public Integer f;

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a b(Integer num) {
            this.e = num;
            return this;
        }

        public ae b() {
            return new ae(this.c, this.d, this.e, this.f, super.a());
        }

        public a c(Integer num) {
            this.f = num;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<ae> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, ae.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(ae aeVar) {
            return (aeVar.g != null ? com.heytap.nearx.a.a.e.d.a(1, aeVar.g) : 0) + (aeVar.h != null ? com.heytap.nearx.a.a.e.p.a(2, aeVar.h) : 0) + (aeVar.i != null ? com.heytap.nearx.a.a.e.d.a(3, aeVar.i) : 0) + (aeVar.j != null ? com.heytap.nearx.a.a.e.d.a(4, aeVar.j) : 0) + aeVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, ae aeVar) throws IOException {
            if (aeVar.g != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 1, aeVar.g);
            }
            if (aeVar.h != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, aeVar.h);
            }
            if (aeVar.i != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 3, aeVar.i);
            }
            if (aeVar.j != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 4, aeVar.j);
            }
            gVar.a(aeVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ae a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB == 3) {
                    aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                } else if (iB != 4) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.c(com.heytap.nearx.a.a.e.d.a(fVar));
                }
            }
        }
    }

    public ae(Integer num, String str, Integer num2, Integer num3, ByteString byteString) {
        super(c, byteString);
        this.g = num;
        this.h = str;
        this.i = num2;
        this.j = num3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append(", verCode=").append(this.g);
        }
        if (this.h != null) {
            sb.append(", verName=").append(this.h);
        }
        if (this.i != null) {
            sb.append(", cVerCode=").append(this.i);
        }
        if (this.j != null) {
            sb.append(", statSdkVc=").append(this.j);
        }
        return sb.replace(0, 2, "SdkInfo{").append('}').toString();
    }
}
