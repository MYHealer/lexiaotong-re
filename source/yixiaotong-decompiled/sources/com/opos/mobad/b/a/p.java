package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class p extends com.heytap.nearx.a.a.b<p, a> {
    public static final com.heytap.nearx.a.a.e<p> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    public static final Float f = Float.valueOf(0.0f);
    private static final long serialVersionUID = 0;
    public final Integer g;
    public final Integer h;
    public final Float i;

    public static final class a extends com.heytap.nearx.a.a.b.a<p, a> {
        public Integer c;
        public Integer d;
        public Float e;

        public a a(Float f) {
            this.e = f;
            return this;
        }

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public a b(Integer num) {
            this.d = num;
            return this;
        }

        public p b() {
            return new p(this.c, this.d, this.e, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<p> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, p.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(p pVar) {
            return (pVar.g != null ? com.heytap.nearx.a.a.e.d.a(1, pVar.g) : 0) + (pVar.h != null ? com.heytap.nearx.a.a.e.d.a(2, pVar.h) : 0) + (pVar.i != null ? com.heytap.nearx.a.a.e.n.a(3, pVar.i) : 0) + pVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, p pVar) throws IOException {
            if (pVar.g != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 1, pVar.g);
            }
            if (pVar.h != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 2, pVar.h);
            }
            if (pVar.i != null) {
                com.heytap.nearx.a.a.e.n.a(gVar, 3, pVar.i);
            }
            gVar.a(pVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public p a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                    aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                } else if (iB != 3) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.a.a.e.n.a(fVar));
                }
            }
        }
    }

    public p(Integer num, Integer num2, Float f2, ByteString byteString) {
        super(c, byteString);
        this.g = num;
        this.h = num2;
        this.i = f2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append(", height=").append(this.g);
        }
        if (this.h != null) {
            sb.append(", width=").append(this.h);
        }
        if (this.i != null) {
            sb.append(", density=").append(this.i);
        }
        return sb.replace(0, 2, "DevScreen{").append('}').toString();
    }
}
