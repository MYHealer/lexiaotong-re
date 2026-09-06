package com.opos.mobad.r.a;

import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class v extends com.heytap.nearx.a.a.b<v, a> {
    public static final com.heytap.nearx.a.a.e<v> c = new b();
    public static final Boolean d = false;
    public static final q e = q.HORIZONTAL;
    public static final e f = e.UNKNOWN;
    public static final Long g = Long.valueOf(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    public static final Integer h = 0;
    public static final Boolean i = true;
    public static final l j = l.UNKNOWN_MODE;
    public static final Boolean k = false;
    public static final Boolean l = false;
    public static final Integer m = 0;
    public static final Integer n = 0;
    public static final Boolean o = false;
    public static final Boolean p = true;
    private static final long serialVersionUID = 0;
    public final Boolean A;
    public final Integer B;
    public final Integer C;
    public final Boolean D;
    public final Boolean E;
    public final String q;
    public final List<h> r;
    public final Boolean s;
    public final q t;
    public final e u;
    public final Long v;
    public final Integer w;
    public final Boolean x;
    public final l y;
    public final Boolean z;

    public static final class a extends com.heytap.nearx.a.a.b.a<v, a> {
        public String c;
        public List<h> d = com.heytap.nearx.a.a.a.b.a();
        public Boolean e;
        public q f;
        public e g;
        public Long h;
        public Integer i;
        public Boolean j;
        public l k;
        public Boolean l;
        public Boolean m;
        public Integer n;
        public Integer o;
        public Boolean p;
        public Boolean q;

        public a a(e eVar) {
            this.g = eVar;
            return this;
        }

        public a a(l lVar) {
            this.k = lVar;
            return this;
        }

        public a a(q qVar) {
            this.f = qVar;
            return this;
        }

        public a a(Boolean bool) {
            this.e = bool;
            return this;
        }

        public a a(Integer num) {
            this.i = num;
            return this;
        }

        public a a(Long l) {
            this.h = l;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a b(Boolean bool) {
            this.j = bool;
            return this;
        }

        public a b(Integer num) {
            this.n = num;
            return this;
        }

        public v b() {
            String str = this.c;
            if (str == null || this.e == null || this.k == null) {
                throw com.heytap.nearx.a.a.a.b.a(str, "posId", this.e, "isConcurrentEnable", this.k, "distributionMode");
            }
            return new v(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, super.a());
        }

        public a c(Boolean bool) {
            this.l = bool;
            return this;
        }

        public a c(Integer num) {
            this.o = num;
            return this;
        }

        public a d(Boolean bool) {
            this.m = bool;
            return this;
        }

        public a e(Boolean bool) {
            this.p = bool;
            return this;
        }

        public a f(Boolean bool) {
            this.q = bool;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<v> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, v.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(v vVar) {
            return com.heytap.nearx.a.a.e.p.a(1, vVar.q) + h.c.a().a(2, vVar.r) + com.heytap.nearx.a.a.e.c.a(3, vVar.s) + (vVar.t != null ? q.c.a(4, vVar.t) : 0) + (vVar.u != null ? e.n.a(5, vVar.u) : 0) + (vVar.v != null ? com.heytap.nearx.a.a.e.i.a(6, vVar.v) : 0) + (vVar.w != null ? com.heytap.nearx.a.a.e.g.a(7, vVar.w) : 0) + (vVar.x != null ? com.heytap.nearx.a.a.e.c.a(8, vVar.x) : 0) + l.e.a(9, vVar.y) + (vVar.z != null ? com.heytap.nearx.a.a.e.c.a(10, vVar.z) : 0) + (vVar.A != null ? com.heytap.nearx.a.a.e.c.a(11, vVar.A) : 0) + (vVar.B != null ? com.heytap.nearx.a.a.e.d.a(12, vVar.B) : 0) + (vVar.C != null ? com.heytap.nearx.a.a.e.d.a(13, vVar.C) : 0) + (vVar.D != null ? com.heytap.nearx.a.a.e.c.a(14, vVar.D) : 0) + (vVar.E != null ? com.heytap.nearx.a.a.e.c.a(15, vVar.E) : 0) + vVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, v vVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, vVar.q);
            h.c.a().a(gVar, 2, vVar.r);
            com.heytap.nearx.a.a.e.c.a(gVar, 3, vVar.s);
            if (vVar.t != null) {
                q.c.a(gVar, 4, vVar.t);
            }
            if (vVar.u != null) {
                e.n.a(gVar, 5, vVar.u);
            }
            if (vVar.v != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 6, vVar.v);
            }
            if (vVar.w != null) {
                com.heytap.nearx.a.a.e.g.a(gVar, 7, vVar.w);
            }
            if (vVar.x != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 8, vVar.x);
            }
            l.e.a(gVar, 9, vVar.y);
            if (vVar.z != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 10, vVar.z);
            }
            if (vVar.A != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 11, vVar.A);
            }
            if (vVar.B != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 12, vVar.B);
            }
            if (vVar.C != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 13, vVar.C);
            }
            if (vVar.D != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 14, vVar.D);
            }
            if (vVar.E != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 15, vVar.E);
            }
            gVar.a(vVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public v a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.d.add(h.c.a(fVar));
                        break;
                    case 3:
                        aVar.a(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 4:
                        aVar.a(q.c.a(fVar));
                        break;
                    case 5:
                        aVar.a(e.n.a(fVar));
                        break;
                    case 6:
                        aVar.a(com.heytap.nearx.a.a.e.i.a(fVar));
                        break;
                    case 7:
                        aVar.a(com.heytap.nearx.a.a.e.g.a(fVar));
                        break;
                    case 8:
                        aVar.b(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 9:
                        try {
                            aVar.a(l.e.a(fVar));
                        } catch (com.heytap.nearx.a.a.e.a e) {
                            aVar.a(iB, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f3488a));
                        }
                        break;
                    case 10:
                        aVar.c(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 11:
                        aVar.d(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 12:
                        aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 13:
                        aVar.c(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 14:
                        aVar.e(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 15:
                        aVar.f(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }
    }

    public v(String str, List<h> list, Boolean bool, q qVar, e eVar, Long l2, Integer num, Boolean bool2, l lVar, Boolean bool3, Boolean bool4, Integer num2, Integer num3, Boolean bool5, Boolean bool6, ByteString byteString) {
        super(c, byteString);
        this.q = str;
        this.r = com.heytap.nearx.a.a.a.b.b("channelStrategy", list);
        this.s = bool;
        this.t = qVar;
        this.u = eVar;
        this.v = l2;
        this.w = num;
        this.x = bool2;
        this.y = lVar;
        this.z = bool3;
        this.A = bool4;
        this.B = num2;
        this.C = num3;
        this.D = bool5;
        this.E = bool6;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", posId=").append(this.q);
        if (!this.r.isEmpty()) {
            sb.append(", channelStrategy=").append(this.r);
        }
        sb.append(", isConcurrentEnable=").append(this.s);
        if (this.t != null) {
            sb.append(", orientation=").append(this.t);
        }
        if (this.u != null) {
            sb.append(", baseChannel=").append(this.u);
        }
        if (this.v != null) {
            sb.append(", unionTimeout=").append(this.v);
        }
        if (this.w != null) {
            sb.append(", backgroundColor=").append(this.w);
        }
        if (this.x != null) {
            sb.append(", isGameDrawerClose=").append(this.x);
        }
        sb.append(", distributionMode=").append(this.y);
        if (this.z != null) {
            sb.append(", isBiddingOutEnable=").append(this.z);
        }
        if (this.A != null) {
            sb.append(", isUsedADS=").append(this.A);
        }
        if (this.B != null) {
            sb.append(", posHeight=").append(this.B);
        }
        if (this.C != null) {
            sb.append(", posWidth=").append(this.C);
        }
        if (this.D != null) {
            sb.append(", isFullScreen=").append(this.D);
        }
        if (this.E != null) {
            sb.append(", isCloseNative=").append(this.E);
        }
        return sb.replace(0, 2, "StrategyInfo{").append('}').toString();
    }
}
