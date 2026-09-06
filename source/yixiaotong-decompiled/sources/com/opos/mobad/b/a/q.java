package com.opos.mobad.b.a;

import androidx.room.RoomDatabase;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class q extends com.heytap.nearx.a.a.b<q, a> {
    public static final com.heytap.nearx.a.a.e<q> c = new d();
    public static final b d = b.CONNECTION_UNKNOWN;
    public static final c e = c.UNKNOWN_OPERATOR;
    public static final Integer f = 0;
    public static final Integer g = 0;
    private static final long serialVersionUID = 0;
    public final b h;
    public final c i;
    public final Integer j;
    public final l k;
    public final Integer l;

    public static final class a extends com.heytap.nearx.a.a.b.a<q, a> {
        public b c;
        public c d;
        public Integer e;
        public l f;
        public Integer g;

        public a a(l lVar) {
            this.f = lVar;
            return this;
        }

        public a a(b bVar) {
            this.c = bVar;
            return this;
        }

        public a a(c cVar) {
            this.d = cVar;
            return this;
        }

        public a a(Integer num) {
            this.e = num;
            return this;
        }

        public a b(Integer num) {
            this.g = num;
            return this;
        }

        public q b() {
            return new q(this.c, this.d, this.e, this.f, this.g, super.a());
        }
    }

    public enum b implements com.heytap.nearx.a.a.i {
        CONNECTION_UNKNOWN(0),
        CELL_2G(2),
        CELL_3G(3),
        CELL_4G(4),
        CELL_5G(5),
        WIFI(100),
        NEW_TYPE(RoomDatabase.MAX_BIND_PARAMETER_CNT);

        public static final com.heytap.nearx.a.a.e<b> h = com.heytap.nearx.a.a.e.a(b.class);
        private final int i;

        b(int i) {
            this.i = i;
        }

        public static b fromValue(int i) {
            if (i == 0) {
                return CONNECTION_UNKNOWN;
            }
            if (i == 100) {
                return WIFI;
            }
            if (i == 999) {
                return NEW_TYPE;
            }
            if (i == 2) {
                return CELL_2G;
            }
            if (i == 3) {
                return CELL_3G;
            }
            if (i == 4) {
                return CELL_4G;
            }
            if (i != 5) {
                return null;
            }
            return CELL_5G;
        }

        @Override // com.heytap.nearx.a.a.i
        public int getValue() {
            return this.i;
        }
    }

    public enum c implements com.heytap.nearx.a.a.i {
        UNKNOWN_OPERATOR(0),
        CHINA_MOBILE(1),
        CHINA_TELECOM(2),
        CHINA_UNICOM(3);

        public static final com.heytap.nearx.a.a.e<c> e = com.heytap.nearx.a.a.e.a(c.class);
        private final int f;

        c(int i) {
            this.f = i;
        }

        public static c fromValue(int i) {
            if (i == 0) {
                return UNKNOWN_OPERATOR;
            }
            if (i == 1) {
                return CHINA_MOBILE;
            }
            if (i == 2) {
                return CHINA_TELECOM;
            }
            if (i != 3) {
                return null;
            }
            return CHINA_UNICOM;
        }

        @Override // com.heytap.nearx.a.a.i
        public int getValue() {
            return this.f;
        }
    }

    private static final class d extends com.heytap.nearx.a.a.e<q> {
        d() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, q.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(q qVar) {
            return (qVar.h != null ? b.h.a(1, qVar.h) : 0) + (qVar.i != null ? c.e.a(2, qVar.i) : 0) + (qVar.j != null ? com.heytap.nearx.a.a.e.d.a(3, qVar.j) : 0) + (qVar.k != null ? l.c.a(4, qVar.k) : 0) + (qVar.l != null ? com.heytap.nearx.a.a.e.d.a(5, qVar.l) : 0) + qVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, q qVar) throws IOException {
            if (qVar.h != null) {
                b.h.a(gVar, 1, qVar.h);
            }
            if (qVar.i != null) {
                c.e.a(gVar, 2, qVar.i);
            }
            if (qVar.j != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 3, qVar.j);
            }
            if (qVar.k != null) {
                l.c.a(gVar, 4, qVar.k);
            }
            if (qVar.l != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 5, qVar.l);
            }
            gVar.a(qVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public q a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    aVar.a(b.h.a(fVar));
                } else if (iB == 2) {
                    try {
                        aVar.a(c.e.a(fVar));
                    } catch (com.heytap.nearx.a.a.e.a e) {
                        aVar.a(iB, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f3488a));
                    }
                } else if (iB == 3) {
                    aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                } else if (iB == 4) {
                    aVar.a(l.c.a(fVar));
                } else if (iB != 5) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                }
            }
        }
    }

    public q(b bVar, c cVar, Integer num, l lVar, Integer num2, ByteString byteString) {
        super(c, byteString);
        this.h = bVar;
        this.i = cVar;
        this.j = num;
        this.k = lVar;
        this.l = num2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.h != null) {
            sb.append(", netType=").append(this.h);
        }
        if (this.i != null) {
            sb.append(", operator=").append(this.i);
        }
        if (this.j != null) {
            sb.append(", ori=").append(this.j);
        }
        if (this.k != null) {
            sb.append(", devGps=").append(this.k);
        }
        if (this.l != null) {
            sb.append(", linkSpeed=").append(this.l);
        }
        return sb.replace(0, 2, "DevStatus{").append('}').toString();
    }
}
