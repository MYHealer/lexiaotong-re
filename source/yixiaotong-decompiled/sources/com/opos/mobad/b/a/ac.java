package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class ac extends com.heytap.nearx.a.a.b<ac, a> {
    public static final com.heytap.nearx.a.a.e<ac> c = new c();
    public static final b d = b.UNKNOWN;
    public static final ag e = ag.UNKNOWN;
    public static final Integer f = -1;
    private static final long serialVersionUID = 0;
    public final String g;
    public final b h;
    public final ad i;
    public final ag j;
    public final Integer k;

    public static final class a extends com.heytap.nearx.a.a.b.a<ac, a> {
        public String c;
        public b d;
        public ad e;
        public ag f;
        public Integer g;

        public a a(b bVar) {
            this.d = bVar;
            return this;
        }

        public a a(ad adVar) {
            this.e = adVar;
            return this;
        }

        public a a(ag agVar) {
            this.f = agVar;
            return this;
        }

        public a a(Integer num) {
            this.g = num;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public ac b() {
            return new ac(this.c, this.d, this.e, this.f, this.g, super.a());
        }
    }

    public enum b implements com.heytap.nearx.a.a.i {
        UNKNOWN(0),
        BANNER(1),
        POP_WINDOW(2),
        SPLASH_SCREEN(4),
        RAW(8),
        REWARD_VIDEO(64);

        public static final com.heytap.nearx.a.a.e<b> g = com.heytap.nearx.a.a.e.a(b.class);
        private final int h;

        b(int i2) {
            this.h = i2;
        }

        public static b fromValue(int i2) {
            if (i2 == 0) {
                return UNKNOWN;
            }
            if (i2 == 1) {
                return BANNER;
            }
            if (i2 == 2) {
                return POP_WINDOW;
            }
            if (i2 == 4) {
                return SPLASH_SCREEN;
            }
            if (i2 == 8) {
                return RAW;
            }
            if (i2 != 64) {
                return null;
            }
            return REWARD_VIDEO;
        }

        @Override // com.heytap.nearx.a.a.i
        public int getValue() {
            return this.h;
        }
    }

    private static final class c extends com.heytap.nearx.a.a.e<ac> {
        c() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, ac.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(ac acVar) {
            return (acVar.g != null ? com.heytap.nearx.a.a.e.p.a(1, acVar.g) : 0) + (acVar.h != null ? b.g.a(2, acVar.h) : 0) + (acVar.i != null ? ad.c.a(3, acVar.i) : 0) + (acVar.j != null ? ag.d.a(4, acVar.j) : 0) + (acVar.k != null ? com.heytap.nearx.a.a.e.d.a(5, acVar.k) : 0) + acVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, ac acVar) throws IOException {
            if (acVar.g != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, acVar.g);
            }
            if (acVar.h != null) {
                b.g.a(gVar, 2, acVar.h);
            }
            if (acVar.i != null) {
                ad.c.a(gVar, 3, acVar.i);
            }
            if (acVar.j != null) {
                ag.d.a(gVar, 4, acVar.j);
            }
            if (acVar.k != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 5, acVar.k);
            }
            gVar.a(acVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ac a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                } else if (iB == 2) {
                    aVar.a(b.g.a(fVar));
                } else if (iB == 3) {
                    aVar.a(ad.c.a(fVar));
                } else if (iB == 4) {
                    try {
                        aVar.a(ag.d.a(fVar));
                    } catch (com.heytap.nearx.a.a.e.a e) {
                        aVar.a(iB, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f3488a));
                    }
                } else if (iB != 5) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                }
            }
        }
    }

    public ac(String str, b bVar, ad adVar, ag agVar, Integer num, ByteString byteString) {
        super(c, byteString);
        this.g = str;
        this.h = bVar;
        this.i = adVar;
        this.j = agVar;
        this.k = num;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append(", posId=").append(this.g);
        }
        if (this.h != null) {
            sb.append(", posType=").append(this.h);
        }
        if (this.i != null) {
            sb.append(", posSize=").append(this.i);
        }
        if (this.j != null) {
            sb.append(", startMode=").append(this.j);
        }
        if (this.k != null) {
            sb.append(", renderOri=").append(this.k);
        }
        return sb.replace(0, 2, "PosInfo{").append('}').toString();
    }
}
