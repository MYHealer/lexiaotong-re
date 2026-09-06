package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class l extends com.heytap.nearx.a.a.b<l, a> {
    public static final com.heytap.nearx.a.a.e<l> c = new b();
    public static final Double d;
    public static final Double e;
    public static final Long f;
    private static final long serialVersionUID = 0;
    public final Double g;
    public final Double h;
    public final Long i;
    public final String j;
    public final String k;

    public static final class a extends com.heytap.nearx.a.a.b.a<l, a> {
        public Double c;
        public Double d;
        public Long e;
        public String f;
        public String g;

        public a a(Double d) {
            this.c = d;
            return this;
        }

        public a a(Long l) {
            this.e = l;
            return this;
        }

        public a a(String str) {
            this.f = str;
            return this;
        }

        public a b(Double d) {
            this.d = d;
            return this;
        }

        public a b(String str) {
            this.g = str;
            return this;
        }

        public l b() {
            return new l(this.c, this.d, this.e, this.f, this.g, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<l> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, l.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(l lVar) {
            return (lVar.g != null ? com.heytap.nearx.a.a.e.o.a(1, lVar.g) : 0) + (lVar.h != null ? com.heytap.nearx.a.a.e.o.a(2, lVar.h) : 0) + (lVar.i != null ? com.heytap.nearx.a.a.e.i.a(3, lVar.i) : 0) + (lVar.j != null ? com.heytap.nearx.a.a.e.p.a(4, lVar.j) : 0) + (lVar.k != null ? com.heytap.nearx.a.a.e.p.a(5, lVar.k) : 0) + lVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, l lVar) throws IOException {
            if (lVar.g != null) {
                com.heytap.nearx.a.a.e.o.a(gVar, 1, lVar.g);
            }
            if (lVar.h != null) {
                com.heytap.nearx.a.a.e.o.a(gVar, 2, lVar.h);
            }
            if (lVar.i != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 3, lVar.i);
            }
            if (lVar.j != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 4, lVar.j);
            }
            if (lVar.k != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 5, lVar.k);
            }
            gVar.a(lVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public l a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.o.a(fVar));
                } else if (iB == 2) {
                    aVar.b(com.heytap.nearx.a.a.e.o.a(fVar));
                } else if (iB == 3) {
                    aVar.a(com.heytap.nearx.a.a.e.i.a(fVar));
                } else if (iB == 4) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB != 5) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    static {
        Double dValueOf = Double.valueOf(0.0d);
        d = dValueOf;
        e = dValueOf;
        f = 0L;
    }

    public l(Double d2, Double d3, Long l, String str, String str2, ByteString byteString) {
        super(c, byteString);
        this.g = d2;
        this.h = d3;
        this.i = l;
        this.j = str;
        this.k = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append(", longitude=").append(this.g);
        }
        if (this.h != null) {
            sb.append(", latitude=").append(this.h);
        }
        if (this.i != null) {
            sb.append(", timestamp=").append(this.i);
        }
        if (this.j != null) {
            sb.append(", cryptLon=").append(this.j);
        }
        if (this.k != null) {
            sb.append(", cryptLat=").append(this.k);
        }
        return sb.replace(0, 2, "DevGps{").append('}').toString();
    }
}
