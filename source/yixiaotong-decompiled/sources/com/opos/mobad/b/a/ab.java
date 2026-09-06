package com.opos.mobad.b.a;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class ab extends com.heytap.nearx.a.a.b<ab, b> {
    private static final long serialVersionUID = 0;
    public final String Q;
    public final c R;
    public final i S;
    public final List<aa> T;
    public final String U;
    public final String V;
    public final List<aa> W;
    public final Boolean X;
    public final String Y;
    public final Long Z;
    public final Integer aA;
    public final Boolean aB;
    public final Boolean aC;
    public final com.opos.mobad.b.a.g aD;
    public final List<r> aE;
    public final String aF;
    public final String aG;
    public final p aH;
    public final t aI;
    public final i aJ;
    public final i aK;
    public final Boolean aL;
    public final Integer aM;
    public final String aN;
    public final Boolean aO;
    public final e aP;
    public final e aQ;
    public final Boolean aR;
    public final Boolean aS;
    public final String aT;
    public final List<String> aU;
    public final String aV;
    public final u aW;
    public final Boolean aX;
    public final Boolean aY;
    public final l aZ;
    public final String aa;
    public final List<String> ab;
    public final List<String> ac;
    public final List<String> ad;
    public final String ae;
    public final String af;
    public final Integer ag;
    public final Boolean ah;
    public final String ai;
    public final String aj;
    public final Long ak;
    public final Integer al;
    public final String am;
    public final List<aj> an;
    public final g ao;
    public final n ap;
    public final Boolean aq;
    public final List<aa> ar;
    public final o as;
    public final Integer at;
    public final h au;
    public final i av;
    public final i aw;
    public final Boolean ax;
    public final d ay;
    public final String az;
    public final Integer ba;
    public final List<aa> bb;
    public final Long bc;
    public final Integer bd;
    public final Integer be;
    public final String bf;
    public final String bg;
    public final j bh;
    public final String bi;
    public final String bj;
    public final k bk;
    public final String bl;
    public final List<a> bm;
    public static final com.heytap.nearx.a.a.e<ab> c = new m();
    public static final c d = c.NO_TYPE;
    public static final i e = i.NO_INTERACTION;
    public static final Boolean f = true;
    public static final Long g = 0L;
    public static final Integer h = 0;
    public static final Boolean i = true;
    public static final Long j = 0L;
    public static final Integer k = 0;
    public static final g l = g.NO_ACTION;
    public static final n m = n.WEBVIEW;
    public static final Boolean n = true;
    public static final o o = o.IMAGE_TIP_BAR;
    public static final Integer p = 0;
    public static final h q = h.NO_INSTALLED_ACTION;
    public static final i r = i.NO_INTERACTION;
    public static final i s = i.NO_INTERACTION;
    public static final Boolean t = true;
    public static final d u = d.SDK_APP;
    public static final Integer v = 3;
    public static final Boolean w = true;
    public static final Boolean x = true;
    public static final p y = p.JUMP_LANDING_PAGE;
    public static final i z = i.NO_INTERACTION;
    public static final i A = i.NO_INTERACTION;
    public static final Boolean B = false;
    public static final Integer C = 0;
    public static final Boolean D = false;
    public static final e E = e.DEFAULT;
    public static final e F = e.DEFAULT;
    public static final Boolean G = false;
    public static final Boolean H = false;
    public static final u I = u.TYPE_16_8;
    public static final Boolean J = false;
    public static final Boolean K = true;
    public static final Integer L = 0;
    public static final Long M = 0L;
    public static final Integer N = 0;
    public static final Integer O = 0;
    public static final k P = k.INTERACTIVE_MODE_UNKNOWN;

    public static final class a extends com.heytap.nearx.a.a.b<a, C0939a> {
        public static final com.heytap.nearx.a.a.e<a> c = new b();
        public static final Integer d = 0;
        private static final long serialVersionUID = 0;
        public final Integer e;
        public final List<String> f;

        /* JADX INFO: renamed from: com.opos.mobad.b.a.ab$a$a, reason: collision with other inner class name */
        public static final class C0939a extends com.heytap.nearx.a.a.b.a<a, C0939a> {
            public Integer c;
            public List<String> d = com.heytap.nearx.a.a.a.b.a();

            public C0939a a(Integer num) {
                this.c = num;
                return this;
            }

            public a b() {
                return new a(this.c, this.d, super.a());
            }
        }

        private static final class b extends com.heytap.nearx.a.a.e<a> {
            b() {
                super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, a.class);
            }

            @Override // com.heytap.nearx.a.a.e
            public int a(a aVar) {
                return (aVar.e != null ? com.heytap.nearx.a.a.e.d.a(1, aVar.e) : 0) + com.heytap.nearx.a.a.e.p.a().a(2, aVar.f) + aVar.a().size();
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(com.heytap.nearx.a.a.g gVar, a aVar) throws IOException {
                if (aVar.e != null) {
                    com.heytap.nearx.a.a.e.d.a(gVar, 1, aVar.e);
                }
                com.heytap.nearx.a.a.e.p.a().a(gVar, 2, aVar.f);
                gVar.a(aVar.a());
            }

            @Override // com.heytap.nearx.a.a.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public a a(com.heytap.nearx.a.a.f fVar) throws IOException {
                C0939a c0939a = new C0939a();
                long jA = fVar.a();
                while (true) {
                    int iB = fVar.b();
                    if (iB == -1) {
                        fVar.a(jA);
                        return c0939a.b();
                    }
                    if (iB == 1) {
                        c0939a.a(com.heytap.nearx.a.a.e.d.a(fVar));
                    } else if (iB != 2) {
                        com.heytap.nearx.a.a.a aVarC = fVar.c();
                        c0939a.a(iB, aVarC, aVarC.a().a(fVar));
                    } else {
                        c0939a.d.add(com.heytap.nearx.a.a.e.p.a(fVar));
                    }
                }
            }
        }

        public a(Integer num, List<String> list, ByteString byteString) {
            super(c, byteString);
            this.e = num;
            this.f = com.heytap.nearx.a.a.a.b.b("data", list);
        }

        @Override // com.heytap.nearx.a.a.b
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.e != null) {
                sb.append(", type=").append(this.e);
            }
            if (!this.f.isEmpty()) {
                sb.append(", data=").append(this.f);
            }
            return sb.replace(0, 2, "AdxAdExtInfo{").append('}').toString();
        }
    }

    public static final class b extends com.heytap.nearx.a.a.b.a<ab, b> {
        public g A;
        public n B;
        public Boolean C;
        public o E;
        public Integer F;
        public h G;
        public i H;
        public i I;
        public Boolean J;
        public d K;
        public String L;
        public Integer M;
        public Boolean N;
        public Boolean O;
        public com.opos.mobad.b.a.g P;
        public String R;
        public String S;
        public p T;
        public t U;
        public i V;
        public i W;
        public Boolean X;
        public Integer Y;
        public String Z;
        public Boolean aa;
        public e ab;
        public e ac;
        public Boolean ad;
        public Boolean ae;
        public String af;
        public String ah;
        public u ai;
        public Boolean aj;
        public Boolean ak;
        public l al;
        public Integer am;
        public Long ao;
        public Integer ap;
        public Integer aq;
        public String ar;
        public String as;
        public j at;
        public String au;
        public String av;
        public k aw;
        public String ax;
        public String c;
        public c d;
        public i e;
        public String g;
        public String h;
        public Boolean j;
        public String k;
        public Long l;
        public String m;
        public String q;
        public String r;
        public Integer s;
        public Boolean t;
        public String u;
        public String v;
        public Long w;
        public Integer x;
        public String y;
        public List<aa> f = com.heytap.nearx.a.a.a.b.a();
        public List<aa> i = com.heytap.nearx.a.a.a.b.a();
        public List<String> n = com.heytap.nearx.a.a.a.b.a();
        public List<String> o = com.heytap.nearx.a.a.a.b.a();
        public List<String> p = com.heytap.nearx.a.a.a.b.a();
        public List<aj> z = com.heytap.nearx.a.a.a.b.a();
        public List<aa> D = com.heytap.nearx.a.a.a.b.a();
        public List<r> Q = com.heytap.nearx.a.a.a.b.a();
        public List<String> ag = com.heytap.nearx.a.a.a.b.a();
        public List<aa> an = com.heytap.nearx.a.a.a.b.a();
        public List<a> ay = com.heytap.nearx.a.a.a.b.a();

        public b a(c cVar) {
            this.d = cVar;
            return this;
        }

        public b a(d dVar) {
            this.K = dVar;
            return this;
        }

        public b a(e eVar) {
            this.ab = eVar;
            return this;
        }

        public b a(g gVar) {
            this.A = gVar;
            return this;
        }

        public b a(h hVar) {
            this.G = hVar;
            return this;
        }

        public b a(i iVar) {
            this.e = iVar;
            return this;
        }

        public b a(j jVar) {
            this.at = jVar;
            return this;
        }

        public b a(k kVar) {
            this.aw = kVar;
            return this;
        }

        public b a(l lVar) {
            this.al = lVar;
            return this;
        }

        public b a(n nVar) {
            this.B = nVar;
            return this;
        }

        public b a(o oVar) {
            this.E = oVar;
            return this;
        }

        public b a(p pVar) {
            this.T = pVar;
            return this;
        }

        public b a(com.opos.mobad.b.a.g gVar) {
            this.P = gVar;
            return this;
        }

        public b a(t tVar) {
            this.U = tVar;
            return this;
        }

        public b a(u uVar) {
            this.ai = uVar;
            return this;
        }

        public b a(Boolean bool) {
            this.j = bool;
            return this;
        }

        public b a(Integer num) {
            this.s = num;
            return this;
        }

        public b a(Long l) {
            this.l = l;
            return this;
        }

        public b a(String str) {
            this.c = str;
            return this;
        }

        public b b(e eVar) {
            this.ac = eVar;
            return this;
        }

        public b b(i iVar) {
            this.H = iVar;
            return this;
        }

        public b b(Boolean bool) {
            this.t = bool;
            return this;
        }

        public b b(Integer num) {
            this.x = num;
            return this;
        }

        public b b(Long l) {
            this.w = l;
            return this;
        }

        public b b(String str) {
            this.g = str;
            return this;
        }

        public ab b() {
            return new ab(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, this.H, this.I, this.J, this.K, this.L, this.M, this.N, this.O, this.P, this.Q, this.R, this.S, this.T, this.U, this.V, this.W, this.X, this.Y, this.Z, this.aa, this.ab, this.ac, this.ad, this.ae, this.af, this.ag, this.ah, this.ai, this.aj, this.ak, this.al, this.am, this.an, this.ao, this.ap, this.aq, this.ar, this.as, this.at, this.au, this.av, this.aw, this.ax, this.ay, super.a());
        }

        public b c(i iVar) {
            this.I = iVar;
            return this;
        }

        public b c(Boolean bool) {
            this.C = bool;
            return this;
        }

        public b c(Integer num) {
            this.F = num;
            return this;
        }

        public b c(Long l) {
            this.ao = l;
            return this;
        }

        public b c(String str) {
            this.h = str;
            return this;
        }

        public b d(i iVar) {
            this.V = iVar;
            return this;
        }

        public b d(Boolean bool) {
            this.J = bool;
            return this;
        }

        public b d(Integer num) {
            this.M = num;
            return this;
        }

        public b d(String str) {
            this.k = str;
            return this;
        }

        public b e(i iVar) {
            this.W = iVar;
            return this;
        }

        public b e(Boolean bool) {
            this.N = bool;
            return this;
        }

        public b e(Integer num) {
            this.Y = num;
            return this;
        }

        public b e(String str) {
            this.m = str;
            return this;
        }

        public b f(Boolean bool) {
            this.O = bool;
            return this;
        }

        public b f(Integer num) {
            this.am = num;
            return this;
        }

        public b f(String str) {
            this.q = str;
            return this;
        }

        public b g(Boolean bool) {
            this.X = bool;
            return this;
        }

        public b g(Integer num) {
            this.ap = num;
            return this;
        }

        public b g(String str) {
            this.r = str;
            return this;
        }

        public b h(Boolean bool) {
            this.aa = bool;
            return this;
        }

        public b h(Integer num) {
            this.aq = num;
            return this;
        }

        public b h(String str) {
            this.u = str;
            return this;
        }

        public b i(Boolean bool) {
            this.ad = bool;
            return this;
        }

        public b i(String str) {
            this.v = str;
            return this;
        }

        public b j(Boolean bool) {
            this.ae = bool;
            return this;
        }

        public b j(String str) {
            this.y = str;
            return this;
        }

        public b k(Boolean bool) {
            this.aj = bool;
            return this;
        }

        public b k(String str) {
            this.L = str;
            return this;
        }

        public b l(Boolean bool) {
            this.ak = bool;
            return this;
        }

        public b l(String str) {
            this.R = str;
            return this;
        }

        public b m(String str) {
            this.S = str;
            return this;
        }

        public b n(String str) {
            this.Z = str;
            return this;
        }

        public b o(String str) {
            this.af = str;
            return this;
        }

        public b p(String str) {
            this.ah = str;
            return this;
        }

        public b q(String str) {
            this.ar = str;
            return this;
        }

        public b r(String str) {
            this.as = str;
            return this;
        }

        public b s(String str) {
            this.au = str;
            return this;
        }

        public b t(String str) {
            this.av = str;
            return this;
        }

        public b u(String str) {
            this.ax = str;
            return this;
        }
    }

    public enum c implements com.heytap.nearx.a.a.i {
        NO_TYPE(0),
        TEXT(1),
        IMAGE(2),
        TEXT_ICON(3),
        VIDEO(4),
        FULL_IMAGE(5),
        TEXT_ICON_640X320(6),
        TEXT_ICON_320X210(7),
        TEXT_ICON_GROUP_320X210(8),
        VIDEO_HTML(9),
        VIDEO_TIP_BAR(10),
        FULL_VIDEO(11),
        POP_WINDOW_VIDEO(12),
        RAW_VIDEO(13),
        INTERACTIVE_MT(14);

        public static final com.heytap.nearx.a.a.e<c> p = com.heytap.nearx.a.a.e.a(c.class);
        private final int q;

        c(int i) {
            this.q = i;
        }

        public static c fromValue(int i) {
            switch (i) {
                case 0:
                    return NO_TYPE;
                case 1:
                    return TEXT;
                case 2:
                    return IMAGE;
                case 3:
                    return TEXT_ICON;
                case 4:
                    return VIDEO;
                case 5:
                    return FULL_IMAGE;
                case 6:
                    return TEXT_ICON_640X320;
                case 7:
                    return TEXT_ICON_320X210;
                case 8:
                    return TEXT_ICON_GROUP_320X210;
                case 9:
                    return VIDEO_HTML;
                case 10:
                    return VIDEO_TIP_BAR;
                case 11:
                    return FULL_VIDEO;
                case 12:
                    return POP_WINDOW_VIDEO;
                case 13:
                    return RAW_VIDEO;
                case 14:
                    return INTERACTIVE_MT;
                default:
                    return null;
            }
        }

        @Override // com.heytap.nearx.a.a.i
        public int getValue() {
            return this.q;
        }
    }

    public enum d implements com.heytap.nearx.a.a.i {
        SDK_APP(1),
        DEEPLINK_APP(2),
        DOWNLOADER(3),
        SAFE_DEEPLINK_APP(4);

        public static final com.heytap.nearx.a.a.e<d> e = com.heytap.nearx.a.a.e.a(d.class);
        private final int f;

        d(int i) {
            this.f = i;
        }

        public static d fromValue(int i) {
            if (i == 1) {
                return SDK_APP;
            }
            if (i == 2) {
                return DEEPLINK_APP;
            }
            if (i == 3) {
                return DOWNLOADER;
            }
            if (i != 4) {
                return null;
            }
            return SAFE_DEEPLINK_APP;
        }

        @Override // com.heytap.nearx.a.a.i
        public int getValue() {
            return this.f;
        }
    }

    public enum e implements com.heytap.nearx.a.a.i {
        DEFAULT(0),
        MODEL_A(1),
        MODEL_INTERACTION(2);

        public static final com.heytap.nearx.a.a.e<e> d = com.heytap.nearx.a.a.e.a(e.class);
        private final int e;

        e(int i) {
            this.e = i;
        }

        public static e fromValue(int i) {
            if (i == 0) {
                return DEFAULT;
            }
            if (i == 1) {
                return MODEL_A;
            }
            if (i != 2) {
                return null;
            }
            return MODEL_INTERACTION;
        }

        @Override // com.heytap.nearx.a.a.i
        public int getValue() {
            return this.e;
        }
    }

    public enum f implements com.heytap.nearx.a.a.i {
        APP_INSTALLED(1),
        APP_UNINSTALLED(2);

        public static final com.heytap.nearx.a.a.e<f> c = com.heytap.nearx.a.a.e.a(f.class);
        private final int d;

        f(int i) {
            this.d = i;
        }

        public static f fromValue(int i) {
            if (i == 1) {
                return APP_INSTALLED;
            }
            if (i != 2) {
                return null;
            }
            return APP_UNINSTALLED;
        }

        @Override // com.heytap.nearx.a.a.i
        public int getValue() {
            return this.d;
        }
    }

    public enum g implements com.heytap.nearx.a.a.i {
        NO_ACTION(0),
        SHOW_REMINDER_TOAST(1),
        AUTO_OPEN(2);

        public static final com.heytap.nearx.a.a.e<g> d = com.heytap.nearx.a.a.e.a(g.class);
        private final int e;

        g(int i) {
            this.e = i;
        }

        public static g fromValue(int i) {
            if (i == 0) {
                return NO_ACTION;
            }
            if (i == 1) {
                return SHOW_REMINDER_TOAST;
            }
            if (i != 2) {
                return null;
            }
            return AUTO_OPEN;
        }

        @Override // com.heytap.nearx.a.a.i
        public int getValue() {
            return this.e;
        }
    }

    public enum h implements com.heytap.nearx.a.a.i {
        NO_INSTALLED_ACTION(0),
        OPEN_HOME(1),
        OPEN_DETAIL(2);

        public static final com.heytap.nearx.a.a.e<h> d = com.heytap.nearx.a.a.e.a(h.class);
        private final int e;

        h(int i) {
            this.e = i;
        }

        public static h fromValue(int i) {
            if (i == 0) {
                return NO_INSTALLED_ACTION;
            }
            if (i == 1) {
                return OPEN_HOME;
            }
            if (i != 2) {
                return null;
            }
            return OPEN_DETAIL;
        }

        @Override // com.heytap.nearx.a.a.i
        public int getValue() {
            return this.e;
        }
    }

    public enum i implements com.heytap.nearx.a.a.i {
        NO_INTERACTION(0),
        SURFING(1),
        DOWNLOAD(2),
        MIDDLE_PAGE_DOWNLOAD(3),
        OPEN_HOME_PAGE(4),
        OPEN_DETAIL_PAGE(5),
        OPEN_INSTANT(6),
        OPEN_MINI_PROGRAM(7),
        OPEN_WECHAT_NATIVE_PAGE(8);

        public static final com.heytap.nearx.a.a.e<i> j = com.heytap.nearx.a.a.e.a(i.class);
        private final int k;

        i(int i) {
            this.k = i;
        }

        public static i fromValue(int i) {
            switch (i) {
                case 0:
                    return NO_INTERACTION;
                case 1:
                    return SURFING;
                case 2:
                    return DOWNLOAD;
                case 3:
                    return MIDDLE_PAGE_DOWNLOAD;
                case 4:
                    return OPEN_HOME_PAGE;
                case 5:
                    return OPEN_DETAIL_PAGE;
                case 6:
                    return OPEN_INSTANT;
                case 7:
                    return OPEN_MINI_PROGRAM;
                case 8:
                    return OPEN_WECHAT_NATIVE_PAGE;
                default:
                    return null;
            }
        }

        @Override // com.heytap.nearx.a.a.i
        public int getValue() {
            return this.k;
        }
    }

    public static final class j extends com.heytap.nearx.a.a.b<j, a> {
        public static final com.heytap.nearx.a.a.e<j> c = new b();
        public static final Integer d = 0;
        public static final Integer e = 0;
        private static final long serialVersionUID = 0;
        public final Integer f;
        public final Map<String, String> g;
        public final Integer h;

        public static final class a extends com.heytap.nearx.a.a.b.a<j, a> {
            public Integer c;
            public Map<String, String> d = com.heytap.nearx.a.a.a.b.b();
            public Integer e;

            public a a(Integer num) {
                this.c = num;
                return this;
            }

            public a b(Integer num) {
                this.e = num;
                return this;
            }

            public j b() {
                return new j(this.c, this.d, this.e, super.a());
            }
        }

        private static final class b extends com.heytap.nearx.a.a.e<j> {
            private final com.heytap.nearx.a.a.e<Map<String, String>> r;

            b() {
                super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, j.class);
                this.r = com.heytap.nearx.a.a.e.a(com.heytap.nearx.a.a.e.p, com.heytap.nearx.a.a.e.p);
            }

            @Override // com.heytap.nearx.a.a.e
            public int a(j jVar) {
                return (jVar.f != null ? com.heytap.nearx.a.a.e.d.a(1, jVar.f) : 0) + this.r.a(2, jVar.g) + (jVar.h != null ? com.heytap.nearx.a.a.e.d.a(3, jVar.h) : 0) + jVar.a().size();
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(com.heytap.nearx.a.a.g gVar, j jVar) throws IOException {
                if (jVar.f != null) {
                    com.heytap.nearx.a.a.e.d.a(gVar, 1, jVar.f);
                }
                this.r.a(gVar, 2, jVar.g);
                if (jVar.h != null) {
                    com.heytap.nearx.a.a.e.d.a(gVar, 3, jVar.h);
                }
                gVar.a(jVar.a());
            }

            @Override // com.heytap.nearx.a.a.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public j a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.d.putAll(this.r.a(fVar));
                    } else if (iB != 3) {
                        com.heytap.nearx.a.a.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                    } else {
                        aVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                    }
                }
            }
        }

        public j(Integer num, Map<String, String> map, Integer num2, ByteString byteString) {
            super(c, byteString);
            this.f = num;
            this.g = com.heytap.nearx.a.a.a.b.a("data", map);
            this.h = num2;
        }

        @Override // com.heytap.nearx.a.a.b
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f != null) {
                sb.append(", type=").append(this.f);
            }
            if (!this.g.isEmpty()) {
                sb.append(", data=").append(this.g);
            }
            if (this.h != null) {
                sb.append(", thirdInteractiveType=").append(this.h);
            }
            return sb.replace(0, 2, "Interactive{").append('}').toString();
        }
    }

    public enum k implements com.heytap.nearx.a.a.i {
        INTERACTIVE_MODE_UNKNOWN(0),
        INTERACTIVE_MODE_CLICK(1),
        INTERACTIVE_MODE_SHAKE(2),
        INTERACTIVE_MODE_UP_SLIDE(3),
        INTERACTIVE_MODE_FORWARD(4),
        INTERACTIVE_MODE_TWIST(5),
        INTERACTIVE_MODE_TILT(6),
        INTERACTIVE_MODE_FULLSCREEN_UP_SLIDE(7),
        INTERACTIVE_MODE_SHAKE_AND_UP_SLIDE(8),
        INTERACTIVE_MODE_SLIDE_LAYER(9);

        public static final com.heytap.nearx.a.a.e<k> k = com.heytap.nearx.a.a.e.a(k.class);
        private final int l;

        k(int i) {
            this.l = i;
        }

        public static k fromValue(int i) {
            switch (i) {
                case 0:
                    return INTERACTIVE_MODE_UNKNOWN;
                case 1:
                    return INTERACTIVE_MODE_CLICK;
                case 2:
                    return INTERACTIVE_MODE_SHAKE;
                case 3:
                    return INTERACTIVE_MODE_UP_SLIDE;
                case 4:
                    return INTERACTIVE_MODE_FORWARD;
                case 5:
                    return INTERACTIVE_MODE_TWIST;
                case 6:
                    return INTERACTIVE_MODE_TILT;
                case 7:
                    return INTERACTIVE_MODE_FULLSCREEN_UP_SLIDE;
                case 8:
                    return INTERACTIVE_MODE_SHAKE_AND_UP_SLIDE;
                case 9:
                    return INTERACTIVE_MODE_SLIDE_LAYER;
                default:
                    return null;
            }
        }

        @Override // com.heytap.nearx.a.a.i
        public int getValue() {
            return this.l;
        }
    }

    public static final class l extends com.heytap.nearx.a.a.b<l, a> {
        public static final com.heytap.nearx.a.a.e<l> c = new c();
        public static final b d = b.UPPER_LEFT_CORNER;
        public static final i e = i.NO_INTERACTION;
        private static final long serialVersionUID = 0;
        public final b f;
        public final aa g;
        public final i h;

        public static final class a extends com.heytap.nearx.a.a.b.a<l, a> {
            public b c;
            public aa d;
            public i e;

            public a a(aa aaVar) {
                this.d = aaVar;
                return this;
            }

            public a a(i iVar) {
                this.e = iVar;
                return this;
            }

            public a a(b bVar) {
                this.c = bVar;
                return this;
            }

            public l b() {
                return new l(this.c, this.d, this.e, super.a());
            }
        }

        public enum b implements com.heytap.nearx.a.a.i {
            UPPER_LEFT_CORNER(0),
            BOTTOM_RIGHT_CORNER(1);

            public static final com.heytap.nearx.a.a.e<b> c = com.heytap.nearx.a.a.e.a(b.class);
            private final int d;

            b(int i) {
                this.d = i;
            }

            public static b fromValue(int i) {
                if (i == 0) {
                    return UPPER_LEFT_CORNER;
                }
                if (i != 1) {
                    return null;
                }
                return BOTTOM_RIGHT_CORNER;
            }

            @Override // com.heytap.nearx.a.a.i
            public int getValue() {
                return this.d;
            }
        }

        private static final class c extends com.heytap.nearx.a.a.e<l> {
            c() {
                super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, l.class);
            }

            @Override // com.heytap.nearx.a.a.e
            public int a(l lVar) {
                return (lVar.f != null ? b.c.a(1, lVar.f) : 0) + (lVar.g != null ? aa.c.a(2, lVar.g) : 0) + (lVar.h != null ? i.j.a(3, lVar.h) : 0) + lVar.a().size();
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(com.heytap.nearx.a.a.g gVar, l lVar) throws IOException {
                if (lVar.f != null) {
                    b.c.a(gVar, 1, lVar.f);
                }
                if (lVar.g != null) {
                    aa.c.a(gVar, 2, lVar.g);
                }
                if (lVar.h != null) {
                    i.j.a(gVar, 3, lVar.h);
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
                        aVar.a(b.c.a(fVar));
                    } else if (iB == 2) {
                        aVar.a(aa.c.a(fVar));
                    } else if (iB != 3) {
                        com.heytap.nearx.a.a.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                    } else {
                        try {
                            aVar.a(i.j.a(fVar));
                        } catch (com.heytap.nearx.a.a.e.a e) {
                            aVar.a(iB, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f3488a));
                        }
                    }
                }
            }
        }

        public l(b bVar, aa aaVar, i iVar, ByteString byteString) {
            super(c, byteString);
            this.f = bVar;
            this.g = aaVar;
            this.h = iVar;
        }

        @Override // com.heytap.nearx.a.a.b
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f != null) {
                sb.append(", position=").append(this.f);
            }
            if (this.g != null) {
                sb.append(", pendantImgFile=").append(this.g);
            }
            if (this.h != null) {
                sb.append(", pendantActionType=").append(this.h);
            }
            return sb.replace(0, 2, "PendantInfo{").append('}').toString();
        }
    }

    private static final class m extends com.heytap.nearx.a.a.e<ab> {
        m() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, ab.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(ab abVar) {
            return (abVar.Q != null ? com.heytap.nearx.a.a.e.p.a(1, abVar.Q) : 0) + (abVar.R != null ? c.p.a(2, abVar.R) : 0) + (abVar.S != null ? i.j.a(3, abVar.S) : 0) + aa.c.a().a(4, abVar.T) + (abVar.U != null ? com.heytap.nearx.a.a.e.p.a(5, abVar.U) : 0) + (abVar.V != null ? com.heytap.nearx.a.a.e.p.a(6, abVar.V) : 0) + aa.c.a().a(7, abVar.W) + (abVar.X != null ? com.heytap.nearx.a.a.e.c.a(8, abVar.X) : 0) + (abVar.Y != null ? com.heytap.nearx.a.a.e.p.a(9, abVar.Y) : 0) + (abVar.Z != null ? com.heytap.nearx.a.a.e.i.a(10, abVar.Z) : 0) + (abVar.aa != null ? com.heytap.nearx.a.a.e.p.a(11, abVar.aa) : 0) + com.heytap.nearx.a.a.e.p.a().a(12, abVar.ab) + com.heytap.nearx.a.a.e.p.a().a(13, abVar.ac) + com.heytap.nearx.a.a.e.p.a().a(14, abVar.ad) + (abVar.ae != null ? com.heytap.nearx.a.a.e.p.a(15, abVar.ae) : 0) + (abVar.af != null ? com.heytap.nearx.a.a.e.p.a(16, abVar.af) : 0) + (abVar.ag != null ? com.heytap.nearx.a.a.e.d.a(17, abVar.ag) : 0) + (abVar.ah != null ? com.heytap.nearx.a.a.e.c.a(18, abVar.ah) : 0) + (abVar.ai != null ? com.heytap.nearx.a.a.e.p.a(19, abVar.ai) : 0) + (abVar.aj != null ? com.heytap.nearx.a.a.e.p.a(20, abVar.aj) : 0) + (abVar.ak != null ? com.heytap.nearx.a.a.e.i.a(21, abVar.ak) : 0) + (abVar.al != null ? com.heytap.nearx.a.a.e.d.a(22, abVar.al) : 0) + (abVar.am != null ? com.heytap.nearx.a.a.e.p.a(23, abVar.am) : 0) + aj.c.a().a(24, abVar.an) + (abVar.ao != null ? g.d.a(25, abVar.ao) : 0) + (abVar.ap != null ? n.c.a(26, abVar.ap) : 0) + (abVar.aq != null ? com.heytap.nearx.a.a.e.c.a(27, abVar.aq) : 0) + aa.c.a().a(28, abVar.ar) + (abVar.as != null ? o.c.a(29, abVar.as) : 0) + (abVar.at != null ? com.heytap.nearx.a.a.e.d.a(30, abVar.at) : 0) + (abVar.au != null ? h.d.a(31, abVar.au) : 0) + (abVar.av != null ? i.j.a(32, abVar.av) : 0) + (abVar.aw != null ? i.j.a(33, abVar.aw) : 0) + (abVar.ax != null ? com.heytap.nearx.a.a.e.c.a(34, abVar.ax) : 0) + (abVar.ay != null ? d.e.a(35, abVar.ay) : 0) + (abVar.az != null ? com.heytap.nearx.a.a.e.p.a(36, abVar.az) : 0) + (abVar.aA != null ? com.heytap.nearx.a.a.e.d.a(37, abVar.aA) : 0) + (abVar.aB != null ? com.heytap.nearx.a.a.e.c.a(38, abVar.aB) : 0) + (abVar.aC != null ? com.heytap.nearx.a.a.e.c.a(39, abVar.aC) : 0) + (abVar.aD != null ? com.opos.mobad.b.a.g.c.a(40, abVar.aD) : 0) + r.c.a().a(41, abVar.aE) + (abVar.aF != null ? com.heytap.nearx.a.a.e.p.a(42, abVar.aF) : 0) + (abVar.aG != null ? com.heytap.nearx.a.a.e.p.a(43, abVar.aG) : 0) + (abVar.aH != null ? p.d.a(44, abVar.aH) : 0) + (abVar.aI != null ? t.c.a(45, abVar.aI) : 0) + (abVar.aJ != null ? i.j.a(46, abVar.aJ) : 0) + (abVar.aK != null ? i.j.a(47, abVar.aK) : 0) + (abVar.aL != null ? com.heytap.nearx.a.a.e.c.a(48, abVar.aL) : 0) + (abVar.aM != null ? com.heytap.nearx.a.a.e.d.a(49, abVar.aM) : 0) + (abVar.aN != null ? com.heytap.nearx.a.a.e.p.a(50, abVar.aN) : 0) + (abVar.aO != null ? com.heytap.nearx.a.a.e.c.a(51, abVar.aO) : 0) + (abVar.aP != null ? e.d.a(52, abVar.aP) : 0) + (abVar.aQ != null ? e.d.a(53, abVar.aQ) : 0) + (abVar.aR != null ? com.heytap.nearx.a.a.e.c.a(54, abVar.aR) : 0) + (abVar.aS != null ? com.heytap.nearx.a.a.e.c.a(55, abVar.aS) : 0) + (abVar.aT != null ? com.heytap.nearx.a.a.e.p.a(56, abVar.aT) : 0) + com.heytap.nearx.a.a.e.p.a().a(57, abVar.aU) + (abVar.aV != null ? com.heytap.nearx.a.a.e.p.a(58, abVar.aV) : 0) + (abVar.aW != null ? u.c.a(59, abVar.aW) : 0) + (abVar.aX != null ? com.heytap.nearx.a.a.e.c.a(60, abVar.aX) : 0) + (abVar.aY != null ? com.heytap.nearx.a.a.e.c.a(61, abVar.aY) : 0) + (abVar.aZ != null ? l.c.a(62, abVar.aZ) : 0) + (abVar.ba != null ? com.heytap.nearx.a.a.e.d.a(63, abVar.ba) : 0) + aa.c.a().a(64, abVar.bb) + (abVar.bc != null ? com.heytap.nearx.a.a.e.i.a(65, abVar.bc) : 0) + (abVar.bd != null ? com.heytap.nearx.a.a.e.d.a(66, abVar.bd) : 0) + (abVar.be != null ? com.heytap.nearx.a.a.e.d.a(67, abVar.be) : 0) + (abVar.bf != null ? com.heytap.nearx.a.a.e.p.a(68, abVar.bf) : 0) + (abVar.bg != null ? com.heytap.nearx.a.a.e.p.a(69, abVar.bg) : 0) + (abVar.bh != null ? j.c.a(70, abVar.bh) : 0) + (abVar.bi != null ? com.heytap.nearx.a.a.e.p.a(71, abVar.bi) : 0) + (abVar.bj != null ? com.heytap.nearx.a.a.e.p.a(72, abVar.bj) : 0) + (abVar.bk != null ? k.k.a(73, abVar.bk) : 0) + (abVar.bl != null ? com.heytap.nearx.a.a.e.p.a(74, abVar.bl) : 0) + a.c.a().a(75, abVar.bm) + abVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, ab abVar) throws IOException {
            if (abVar.Q != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, abVar.Q);
            }
            if (abVar.R != null) {
                c.p.a(gVar, 2, abVar.R);
            }
            if (abVar.S != null) {
                i.j.a(gVar, 3, abVar.S);
            }
            aa.c.a().a(gVar, 4, abVar.T);
            if (abVar.U != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 5, abVar.U);
            }
            if (abVar.V != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, abVar.V);
            }
            aa.c.a().a(gVar, 7, abVar.W);
            if (abVar.X != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 8, abVar.X);
            }
            if (abVar.Y != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 9, abVar.Y);
            }
            if (abVar.Z != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 10, abVar.Z);
            }
            if (abVar.aa != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 11, abVar.aa);
            }
            com.heytap.nearx.a.a.e.p.a().a(gVar, 12, abVar.ab);
            com.heytap.nearx.a.a.e.p.a().a(gVar, 13, abVar.ac);
            com.heytap.nearx.a.a.e.p.a().a(gVar, 14, abVar.ad);
            if (abVar.ae != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 15, abVar.ae);
            }
            if (abVar.af != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 16, abVar.af);
            }
            if (abVar.ag != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 17, abVar.ag);
            }
            if (abVar.ah != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 18, abVar.ah);
            }
            if (abVar.ai != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 19, abVar.ai);
            }
            if (abVar.aj != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 20, abVar.aj);
            }
            if (abVar.ak != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 21, abVar.ak);
            }
            if (abVar.al != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 22, abVar.al);
            }
            if (abVar.am != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 23, abVar.am);
            }
            aj.c.a().a(gVar, 24, abVar.an);
            if (abVar.ao != null) {
                g.d.a(gVar, 25, abVar.ao);
            }
            if (abVar.ap != null) {
                n.c.a(gVar, 26, abVar.ap);
            }
            if (abVar.aq != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 27, abVar.aq);
            }
            aa.c.a().a(gVar, 28, abVar.ar);
            if (abVar.as != null) {
                o.c.a(gVar, 29, abVar.as);
            }
            if (abVar.at != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 30, abVar.at);
            }
            if (abVar.au != null) {
                h.d.a(gVar, 31, abVar.au);
            }
            if (abVar.av != null) {
                i.j.a(gVar, 32, abVar.av);
            }
            if (abVar.aw != null) {
                i.j.a(gVar, 33, abVar.aw);
            }
            if (abVar.ax != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 34, abVar.ax);
            }
            if (abVar.ay != null) {
                d.e.a(gVar, 35, abVar.ay);
            }
            if (abVar.az != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 36, abVar.az);
            }
            if (abVar.aA != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 37, abVar.aA);
            }
            if (abVar.aB != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 38, abVar.aB);
            }
            if (abVar.aC != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 39, abVar.aC);
            }
            if (abVar.aD != null) {
                com.opos.mobad.b.a.g.c.a(gVar, 40, abVar.aD);
            }
            r.c.a().a(gVar, 41, abVar.aE);
            if (abVar.aF != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 42, abVar.aF);
            }
            if (abVar.aG != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 43, abVar.aG);
            }
            if (abVar.aH != null) {
                p.d.a(gVar, 44, abVar.aH);
            }
            if (abVar.aI != null) {
                t.c.a(gVar, 45, abVar.aI);
            }
            if (abVar.aJ != null) {
                i.j.a(gVar, 46, abVar.aJ);
            }
            if (abVar.aK != null) {
                i.j.a(gVar, 47, abVar.aK);
            }
            if (abVar.aL != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 48, abVar.aL);
            }
            if (abVar.aM != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 49, abVar.aM);
            }
            if (abVar.aN != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 50, abVar.aN);
            }
            if (abVar.aO != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 51, abVar.aO);
            }
            if (abVar.aP != null) {
                e.d.a(gVar, 52, abVar.aP);
            }
            if (abVar.aQ != null) {
                e.d.a(gVar, 53, abVar.aQ);
            }
            if (abVar.aR != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 54, abVar.aR);
            }
            if (abVar.aS != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 55, abVar.aS);
            }
            if (abVar.aT != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 56, abVar.aT);
            }
            com.heytap.nearx.a.a.e.p.a().a(gVar, 57, abVar.aU);
            if (abVar.aV != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 58, abVar.aV);
            }
            if (abVar.aW != null) {
                u.c.a(gVar, 59, abVar.aW);
            }
            if (abVar.aX != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 60, abVar.aX);
            }
            if (abVar.aY != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 61, abVar.aY);
            }
            if (abVar.aZ != null) {
                l.c.a(gVar, 62, abVar.aZ);
            }
            if (abVar.ba != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 63, abVar.ba);
            }
            aa.c.a().a(gVar, 64, abVar.bb);
            if (abVar.bc != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 65, abVar.bc);
            }
            if (abVar.bd != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 66, abVar.bd);
            }
            if (abVar.be != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 67, abVar.be);
            }
            if (abVar.bf != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 68, abVar.bf);
            }
            if (abVar.bg != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 69, abVar.bg);
            }
            if (abVar.bh != null) {
                j.c.a(gVar, 70, abVar.bh);
            }
            if (abVar.bi != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 71, abVar.bi);
            }
            if (abVar.bj != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 72, abVar.bj);
            }
            if (abVar.bk != null) {
                k.k.a(gVar, 73, abVar.bk);
            }
            if (abVar.bl != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 74, abVar.bl);
            }
            a.c.a().a(gVar, 75, abVar.bm);
            gVar.a(abVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ab a(com.heytap.nearx.a.a.f fVar) throws IOException {
            List list;
            com.heytap.nearx.a.a.e eVar;
            b bVar = new b();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return bVar.b();
                }
                switch (iB) {
                    case 1:
                        bVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 2:
                        bVar.a(c.p.a(fVar));
                        break;
                    case 3:
                        bVar.a(i.j.a(fVar));
                        break;
                    case 4:
                        list = bVar.f;
                        eVar = aa.c;
                        list.add(eVar.a(fVar));
                        break;
                    case 5:
                        bVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 6:
                        bVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 7:
                        list = bVar.i;
                        eVar = aa.c;
                        list.add(eVar.a(fVar));
                        break;
                    case 8:
                        bVar.a(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 9:
                        bVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 10:
                        bVar.a(com.heytap.nearx.a.a.e.i.a(fVar));
                        break;
                    case 11:
                        bVar.e(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 12:
                        list = bVar.n;
                        eVar = com.heytap.nearx.a.a.e.p;
                        list.add(eVar.a(fVar));
                        break;
                    case 13:
                        list = bVar.o;
                        eVar = com.heytap.nearx.a.a.e.p;
                        list.add(eVar.a(fVar));
                        break;
                    case 14:
                        list = bVar.p;
                        eVar = com.heytap.nearx.a.a.e.p;
                        list.add(eVar.a(fVar));
                        break;
                    case 15:
                        bVar.f(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 16:
                        bVar.g(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 17:
                        bVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 18:
                        bVar.b(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 19:
                        bVar.h(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 20:
                        bVar.i(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 21:
                        bVar.b(com.heytap.nearx.a.a.e.i.a(fVar));
                        break;
                    case 22:
                        bVar.b(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 23:
                        bVar.j(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 24:
                        list = bVar.z;
                        eVar = aj.c;
                        list.add(eVar.a(fVar));
                        break;
                    case 25:
                        bVar.a(g.d.a(fVar));
                        break;
                    case 26:
                        bVar.a(n.c.a(fVar));
                        break;
                    case 27:
                        bVar.c(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 28:
                        list = bVar.D;
                        eVar = aa.c;
                        list.add(eVar.a(fVar));
                        break;
                    case 29:
                        bVar.a(o.c.a(fVar));
                        break;
                    case 30:
                        bVar.c(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 31:
                        bVar.a(h.d.a(fVar));
                        break;
                    case 32:
                        bVar.b(i.j.a(fVar));
                        break;
                    case 33:
                        bVar.c(i.j.a(fVar));
                        break;
                    case 34:
                        bVar.d(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 35:
                        bVar.a(d.e.a(fVar));
                        break;
                    case 36:
                        bVar.k(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 37:
                        bVar.d(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 38:
                        bVar.e(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 39:
                        bVar.f(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 40:
                        bVar.a(com.opos.mobad.b.a.g.c.a(fVar));
                        break;
                    case 41:
                        list = bVar.Q;
                        eVar = r.c;
                        list.add(eVar.a(fVar));
                        break;
                    case 42:
                        bVar.l(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 43:
                        bVar.m(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 44:
                        bVar.a(p.d.a(fVar));
                        break;
                    case 45:
                        bVar.a(t.c.a(fVar));
                        break;
                    case 46:
                        bVar.d(i.j.a(fVar));
                        break;
                    case 47:
                        bVar.e(i.j.a(fVar));
                        break;
                    case 48:
                        bVar.g(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 49:
                        bVar.e(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 50:
                        bVar.n(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 51:
                        bVar.h(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 52:
                        bVar.a(e.d.a(fVar));
                        break;
                    case 53:
                        bVar.b(e.d.a(fVar));
                        break;
                    case 54:
                        bVar.i(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 55:
                        bVar.j(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 56:
                        bVar.o(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 57:
                        list = bVar.ag;
                        eVar = com.heytap.nearx.a.a.e.p;
                        list.add(eVar.a(fVar));
                        break;
                    case 58:
                        bVar.p(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 59:
                        bVar.a(u.c.a(fVar));
                        break;
                    case 60:
                        bVar.k(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 61:
                        bVar.l(com.heytap.nearx.a.a.e.c.a(fVar));
                        break;
                    case 62:
                        bVar.a(l.c.a(fVar));
                        break;
                    case 63:
                        bVar.f(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 64:
                        list = bVar.an;
                        eVar = aa.c;
                        list.add(eVar.a(fVar));
                        break;
                    case 65:
                        bVar.c(com.heytap.nearx.a.a.e.i.a(fVar));
                        break;
                    case 66:
                        bVar.g(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 67:
                        bVar.h(com.heytap.nearx.a.a.e.d.a(fVar));
                        break;
                    case 68:
                        bVar.q(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 69:
                        bVar.r(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 70:
                        bVar.a(j.c.a(fVar));
                        break;
                    case 71:
                        bVar.s(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 72:
                        bVar.t(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 73:
                        try {
                            bVar.a(k.k.a(fVar));
                        } catch (com.heytap.nearx.a.a.e.a e) {
                            bVar.a(iB, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f3488a));
                        }
                        break;
                    case 74:
                        bVar.u(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 75:
                        list = bVar.ay;
                        eVar = a.c;
                        list.add(eVar.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a aVarC = fVar.c();
                        bVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }
    }

    public enum n implements com.heytap.nearx.a.a.i {
        WEBVIEW(0),
        SYSTEM_BROWSER(1);

        public static final com.heytap.nearx.a.a.e<n> c = com.heytap.nearx.a.a.e.a(n.class);
        private final int d;

        n(int i) {
            this.d = i;
        }

        public static n fromValue(int i) {
            if (i == 0) {
                return WEBVIEW;
            }
            if (i != 1) {
                return null;
            }
            return SYSTEM_BROWSER;
        }

        @Override // com.heytap.nearx.a.a.i
        public int getValue() {
            return this.d;
        }
    }

    public enum o implements com.heytap.nearx.a.a.i {
        IMAGE_TIP_BAR(0),
        GRAPHIC_MIX_TIP_BAR(1);

        public static final com.heytap.nearx.a.a.e<o> c = com.heytap.nearx.a.a.e.a(o.class);
        private final int d;

        o(int i) {
            this.d = i;
        }

        public static o fromValue(int i) {
            if (i == 0) {
                return IMAGE_TIP_BAR;
            }
            if (i != 1) {
                return null;
            }
            return GRAPHIC_MIX_TIP_BAR;
        }

        @Override // com.heytap.nearx.a.a.i
        public int getValue() {
            return this.d;
        }
    }

    public enum p implements com.heytap.nearx.a.a.i {
        JUMP_LANDING_PAGE(0),
        JUMP_FLOATING_LAYER(1),
        NO_JUMP_ACTION(2);

        public static final com.heytap.nearx.a.a.e<p> d = com.heytap.nearx.a.a.e.a(p.class);
        private final int e;

        p(int i) {
            this.e = i;
        }

        public static p fromValue(int i) {
            if (i == 0) {
                return JUMP_LANDING_PAGE;
            }
            if (i == 1) {
                return JUMP_FLOATING_LAYER;
            }
            if (i != 2) {
                return null;
            }
            return NO_JUMP_ACTION;
        }

        @Override // com.heytap.nearx.a.a.i
        public int getValue() {
            return this.e;
        }
    }

    public ab(String str, c cVar, i iVar, List<aa> list, String str2, String str3, List<aa> list2, Boolean bool, String str4, Long l2, String str5, List<String> list3, List<String> list4, List<String> list5, String str6, String str7, Integer num, Boolean bool2, String str8, String str9, Long l3, Integer num2, String str10, List<aj> list6, g gVar, n nVar, Boolean bool3, List<aa> list7, o oVar, Integer num3, h hVar, i iVar2, i iVar3, Boolean bool4, d dVar, String str11, Integer num4, Boolean bool5, Boolean bool6, com.opos.mobad.b.a.g gVar2, List<r> list8, String str12, String str13, p pVar, t tVar, i iVar4, i iVar5, Boolean bool7, Integer num5, String str14, Boolean bool8, e eVar, e eVar2, Boolean bool9, Boolean bool10, String str15, List<String> list9, String str16, u uVar, Boolean bool11, Boolean bool12, l lVar, Integer num6, List<aa> list10, Long l4, Integer num7, Integer num8, String str17, String str18, j jVar, String str19, String str20, k kVar, String str21, List<a> list11, ByteString byteString) {
        super(c, byteString);
        this.Q = str;
        this.R = cVar;
        this.S = iVar;
        this.T = com.heytap.nearx.a.a.a.b.b("imgFileList", list);
        this.U = str2;
        this.V = str3;
        this.W = com.heytap.nearx.a.a.a.b.b("iconFileList", list2);
        this.X = bool;
        this.Y = str4;
        this.Z = l2;
        this.aa = str5;
        this.ab = com.heytap.nearx.a.a.a.b.b("expStartUrls", list3);
        this.ac = com.heytap.nearx.a.a.a.b.b("expEndUrls", list4);
        this.ad = com.heytap.nearx.a.a.a.b.b("clickUrls", list5);
        this.ae = str6;
        this.af = str7;
        this.ag = num;
        this.ah = bool2;
        this.ai = str8;
        this.aj = str9;
        this.ak = l3;
        this.al = num2;
        this.am = str10;
        this.an = com.heytap.nearx.a.a.a.b.b("videoTrackEvents", list6);
        this.ao = gVar;
        this.ap = nVar;
        this.aq = bool3;
        this.ar = com.heytap.nearx.a.a.a.b.b("videoFileList", list7);
        this.as = oVar;
        this.at = num3;
        this.au = hVar;
        this.av = iVar2;
        this.aw = iVar3;
        this.ax = bool4;
        this.ay = dVar;
        this.az = str11;
        this.aA = num4;
        this.aB = bool5;
        this.aC = bool6;
        this.aD = gVar2;
        this.aE = com.heytap.nearx.a.a.a.b.b("downLoadTrackEvent", list8);
        this.aF = str12;
        this.aG = str13;
        this.aH = pVar;
        this.aI = tVar;
        this.aJ = iVar4;
        this.aK = iVar5;
        this.aL = bool7;
        this.aM = num5;
        this.aN = str14;
        this.aO = bool8;
        this.aP = eVar;
        this.aQ = eVar2;
        this.aR = bool9;
        this.aS = bool10;
        this.aT = str15;
        this.aU = com.heytap.nearx.a.a.a.b.b("targetResourceList", list9);
        this.aV = str16;
        this.aW = uVar;
        this.aX = bool11;
        this.aY = bool12;
        this.aZ = lVar;
        this.ba = num6;
        this.bb = com.heytap.nearx.a.a.a.b.b("interactiveFileList", list10);
        this.bc = l4;
        this.bd = num7;
        this.be = num8;
        this.bf = str17;
        this.bg = str18;
        this.bh = jVar;
        this.bi = str19;
        this.bj = str20;
        this.bk = kVar;
        this.bl = str21;
        this.bm = com.heytap.nearx.a.a.a.b.b("adxAdExtInfo", list11);
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.Q != null) {
            sb.append(", meterialId=").append(this.Q);
        }
        if (this.R != null) {
            sb.append(", creativeType=").append(this.R);
        }
        if (this.S != null) {
            sb.append(", actionType=").append(this.S);
        }
        if (!this.T.isEmpty()) {
            sb.append(", imgFileList=").append(this.T);
        }
        if (this.U != null) {
            sb.append(", title=").append(this.U);
        }
        if (this.V != null) {
            sb.append(", desc=").append(this.V);
        }
        if (!this.W.isEmpty()) {
            sb.append(", iconFileList=").append(this.W);
        }
        if (this.X != null) {
            sb.append(", gbClick=").append(this.X);
        }
        if (this.Y != null) {
            sb.append(", appPackage=").append(this.Y);
        }
        if (this.Z != null) {
            sb.append(", apkSize=").append(this.Z);
        }
        if (this.aa != null) {
            sb.append(", targetUrl=").append(this.aa);
        }
        if (!this.ab.isEmpty()) {
            sb.append(", expStartUrls=").append(this.ab);
        }
        if (!this.ac.isEmpty()) {
            sb.append(", expEndUrls=").append(this.ac);
        }
        if (!this.ad.isEmpty()) {
            sb.append(", clickUrls=").append(this.ad);
        }
        if (this.ae != null) {
            sb.append(", traceId=").append(this.ae);
        }
        if (this.af != null) {
            sb.append(", transparent=").append(this.af);
        }
        if (this.ag != null) {
            sb.append(", currentIndex=").append(this.ag);
        }
        if (this.ah != null) {
            sb.append(", forceJsInit=").append(this.ah);
        }
        if (this.ai != null) {
            sb.append(", extraUrl=").append(this.ai);
        }
        if (this.aj != null) {
            sb.append(", dlChannel=").append(this.aj);
        }
        if (this.ak != null) {
            sb.append(", videoDuration=").append(this.ak);
        }
        if (this.al != null) {
            sb.append(", showOffBnTime=").append(this.al);
        }
        if (this.am != null) {
            sb.append(", landingPageUrl=").append(this.am);
        }
        if (!this.an.isEmpty()) {
            sb.append(", videoTrackEvents=").append(this.an);
        }
        if (this.ao != null) {
            sb.append(", installCompleteAction=").append(this.ao);
        }
        if (this.ap != null) {
            sb.append(", surfingType=").append(this.ap);
        }
        if (this.aq != null) {
            sb.append(", gbClickToast=").append(this.aq);
        }
        if (!this.ar.isEmpty()) {
            sb.append(", videoFileList=").append(this.ar);
        }
        if (this.as != null) {
            sb.append(", tipBarType=").append(this.as);
        }
        if (this.at != null) {
            sb.append(", rewardLimitTime=").append(this.at);
        }
        if (this.au != null) {
            sb.append(", installedAction=").append(this.au);
        }
        if (this.av != null) {
            sb.append(", extraActionType=").append(this.av);
        }
        if (this.aw != null) {
            sb.append(", videoActionType=").append(this.aw);
        }
        if (this.ax != null) {
            sb.append(", removeRepeatAd=").append(this.ax);
        }
        if (this.ay != null) {
            sb.append(", downloadStyle=").append(this.ay);
        }
        if (this.az != null) {
            sb.append(", downloadUrl=").append(this.az);
        }
        if (this.aA != null) {
            sb.append(", maxDownloadNums=").append(this.aA);
        }
        if (this.aB != null) {
            sb.append(", isShowDownloadToastBar=").append(this.aB);
        }
        if (this.aC != null) {
            sb.append(", isWifiRemindDownload=").append(this.aC);
        }
        if (this.aD != null) {
            sb.append(", downAppInfo=").append(this.aD);
        }
        if (!this.aE.isEmpty()) {
            sb.append(", downLoadTrackEvent=").append(this.aE);
        }
        if (this.aF != null) {
            sb.append(", ref1=").append(this.aF);
        }
        if (this.aG != null) {
            sb.append(", trackContent=").append(this.aG);
        }
        if (this.aH != null) {
            sb.append(", videoCompleteAction=").append(this.aH);
        }
        if (this.aI != null) {
            sb.append(", floatLayerInfo=").append(this.aI);
        }
        if (this.aJ != null) {
            sb.append(", floatLayerBtAction=").append(this.aJ);
        }
        if (this.aK != null) {
            sb.append(", floatLayerExtraAction=").append(this.aK);
        }
        if (this.aL != null) {
            sb.append(", isMobileAutoPlay=").append(this.aL);
        }
        if (this.aM != null) {
            sb.append(", filterFlags=").append(this.aM);
        }
        if (this.aN != null) {
            sb.append(", buttonTitle=").append(this.aN);
        }
        if (this.aO != null) {
            sb.append(", isShowMediaInfo=").append(this.aO);
        }
        if (this.aP != null) {
            sb.append(", portEndPageModelType=").append(this.aP);
        }
        if (this.aQ != null) {
            sb.append(", landEndPageModelType=").append(this.aQ);
        }
        if (this.aR != null) {
            sb.append(", isShowConvertBar=").append(this.aR);
        }
        if (this.aS != null) {
            sb.append(", isDynamicPopUpConvert=").append(this.aS);
        }
        if (this.aT != null) {
            sb.append(", webResourceUrl=").append(this.aT);
        }
        if (!this.aU.isEmpty()) {
            sb.append(", targetResourceList=").append(this.aU);
        }
        if (this.aV != null) {
            sb.append(", bizTraceId=").append(this.aV);
        }
        if (this.aW != null) {
            sb.append(", imgType=").append(this.aW);
        }
        if (this.aX != null) {
            sb.append(", isShowFeedBack=").append(this.aX);
        }
        if (this.aY != null) {
            sb.append(", verticalFlag=").append(this.aY);
        }
        if (this.aZ != null) {
            sb.append(", pendantInfo=").append(this.aZ);
        }
        if (this.ba != null) {
            sb.append(", templateId=").append(this.ba);
        }
        if (!this.bb.isEmpty()) {
            sb.append(", interactiveFileList=").append(this.bb);
        }
        if (this.bc != null) {
            sb.append(", apkDownloadTimes=").append(this.bc);
        }
        if (this.bd != null) {
            sb.append(", endPageTemplateId=").append(this.bd);
        }
        if (this.be != null) {
            sb.append(", specificationId=").append(this.be);
        }
        if (this.bf != null) {
            sb.append(", miniProgramId=").append(this.bf);
        }
        if (this.bg != null) {
            sb.append(", miniProgramPath=").append(this.bg);
        }
        if (this.bh != null) {
            sb.append(", interactive=").append(this.bh);
        }
        if (this.bi != null) {
            sb.append(", biddingCallUrl=").append(this.bi);
        }
        if (this.bj != null) {
            sb.append(", grade=").append(this.bj);
        }
        if (this.bk != null) {
            sb.append(", interactiveMode=").append(this.bk);
        }
        if (this.bl != null) {
            sb.append(", pullEachOtherPopToken=").append(this.bl);
        }
        if (!this.bm.isEmpty()) {
            sb.append(", adxAdExtInfo=").append(this.bm);
        }
        return sb.replace(0, 2, "MaterialInfo{").append('}').toString();
    }
}
