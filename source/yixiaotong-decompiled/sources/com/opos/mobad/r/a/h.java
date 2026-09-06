package com.opos.mobad.r.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class h extends com.heytap.nearx.a.a.b<h, a> {
    public static final com.heytap.nearx.a.a.e<h> c = new b();
    public static final Integer d = 0;
    public static final Long e = 0L;
    public static final e f = e.UNKNOWN;
    public static final Integer g = 0;
    public static final Integer h = 0;
    public static final Integer i = 0;
    public static final Float j = Float.valueOf(0.0f);
    public static final Long k = 0L;
    private static final long serialVersionUID = 0;
    public final String l;
    public final Integer m;
    public final Long n;
    public final e o;
    public final Integer p;
    public final Integer q;
    public final Integer r;
    public final Float s;
    public final Long t;

    public static final class a extends com.heytap.nearx.a.a.b.a<h, a> {
        public String c;
        public Integer d;
        public Long e;
        public e f;
        public Integer g;
        public Integer h;
        public Integer i;
        public Float j;
        public Long k;

        public a a(e eVar) {
            this.f = eVar;
            return this;
        }

        public a a(Float f) {
            this.j = f;
            return this;
        }

        public a a(Integer num) {
            this.d = num;
            return this;
        }

        public a a(Long l) {
            this.e = l;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a b(Integer num) {
            this.g = num;
            return this;
        }

        public a b(Long l) {
            this.k = l;
            return this;
        }

        public h b() {
            String str = this.c;
            if (str == null || this.d == null || this.e == null || this.f == null) {
                throw com.heytap.nearx.a.a.a.b.a(str, "channelPosId", this.d, "percent", this.e, "timeout", this.f, "channel");
            }
            return new h(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, super.a());
        }

        public a c(Integer num) {
            this.h = num;
            return this;
        }

        public a d(Integer num) {
            this.i = num;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<h> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, h.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(h hVar) {
            return com.heytap.nearx.a.a.e.p.a(1, hVar.l) + com.heytap.nearx.a.a.e.d.a(2, hVar.m) + com.heytap.nearx.a.a.e.i.a(3, hVar.n) + e.n.a(4, hVar.o) + (hVar.p != null ? com.heytap.nearx.a.a.e.d.a(5, hVar.p) : 0) + (hVar.q != null ? com.heytap.nearx.a.a.e.d.a(6, hVar.q) : 0) + (hVar.r != null ? com.heytap.nearx.a.a.e.d.a(7, hVar.r) : 0) + (hVar.s != null ? com.heytap.nearx.a.a.e.n.a(8, hVar.s) : 0) + (hVar.t != null ? com.heytap.nearx.a.a.e.i.a(9, hVar.t) : 0) + hVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, h hVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, hVar.l);
            com.heytap.nearx.a.a.e.d.a(gVar, 2, hVar.m);
            com.heytap.nearx.a.a.e.i.a(gVar, 3, hVar.n);
            e.n.a(gVar, 4, hVar.o);
            if (hVar.p != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 5, hVar.p);
            }
            if (hVar.q != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 6, hVar.q);
            }
            if (hVar.r != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 7, hVar.r);
            }
            if (hVar.s != null) {
                com.heytap.nearx.a.a.e.n.a(gVar, 8, hVar.s);
            }
            if (hVar.t != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 9, hVar.t);
            }
            gVar.a(hVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                switch (iB) {
                    case 1:
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 2:
                        aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 3:
                        aVar.a(com.heytap.nearx.a.a.e.i.a(fVar));
                        break;
                    case 4:
                        try {
                            aVar.a(e.n.a(fVar));
                        } catch (com.heytap.nearx.a.a.e.a e) {
                            aVar.a(iB, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f3488a));
                        }
                        break;
                    case 5:
                        aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 6:
                        aVar.c(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 7:
                        aVar.d(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 8:
                        aVar.a(com.heytap.nearx.a.a.e.n.a(fVar));
                        break;
                    case 9:
                        aVar.b(com.heytap.nearx.a.a.e.i.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }
    }

    public h(String str, Integer num, Long l, e eVar, Integer num2, Integer num3, Integer num4, Float f2, Long l2, ByteString byteString) {
        super(c, byteString);
        this.l = str;
        this.m = num;
        this.n = l;
        this.o = eVar;
        this.p = num2;
        this.q = num3;
        this.r = num4;
        this.s = f2;
        this.t = l2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", channelPosId=").append(this.l);
        sb.append(", percent=").append(this.m);
        sb.append(", timeout=").append(this.n);
        sb.append(", channel=").append(this.o);
        if (this.p != null) {
            sb.append(", imgHeight=").append(this.p);
        }
        if (this.q != null) {
            sb.append(", imgWidth=").append(this.q);
        }
        if (this.r != null) {
            sb.append(", posEcpm=").append(this.r);
        }
        if (this.s != null) {
            sb.append(", ecpmFactor=").append(this.s);
        }
        if (this.t != null) {
            sb.append(", ecpmFilterThreshold=").append(this.t);
        }
        return sb.replace(0, 2, "ChannelStrategy{").append('}').toString();
    }
}
