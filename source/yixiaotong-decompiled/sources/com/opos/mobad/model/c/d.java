package com.opos.mobad.model.c;

import com.opos.mobad.model.data.InstantData;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7177a = com.opos.cmn.an.b.b.a("b3Bwb19hZHg=");
    public static final String b = com.opos.cmn.an.b.b.a("b3Bwb19mZWVk");
    public static final String c = com.opos.cmn.an.b.b.a("b3Bwb19jcGQ=");
    private int d;
    private String e;
    private List<com.opos.mobad.b.a.b> f;
    private long g;
    private String h;
    private InstantData i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private int n;
    private boolean o;
    private com.opos.mobad.b.a.d p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private String u;
    private String v;
    private String w;

    /* JADX INFO: renamed from: com.opos.mobad.model.c.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7178a;

        static {
            int[] iArr = new int[com.opos.mobad.b.a.d.b.values().length];
            f7178a = iArr;
            try {
                iArr[com.opos.mobad.b.a.d.b.NO_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7178a[com.opos.mobad.b.a.d.b.GAME_BOX_BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7178a[com.opos.mobad.b.a.d.b.GAME_BOX_INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public d() {
        this.o = true;
        this.q = false;
        this.r = 0;
        this.s = 0;
        this.t = 0;
    }

    public d(com.opos.mobad.b.a.d dVar) {
        this(dVar, null, 0L);
    }

    public d(com.opos.mobad.b.a.d dVar, List<com.opos.mobad.b.a.b> list, long j) {
        this.o = true;
        this.q = false;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        if (dVar == null) {
            return;
        }
        this.d = dVar.p != null ? dVar.p.intValue() : -1;
        this.e = dVar.q != null ? dVar.q : "";
        if (j > 0) {
            this.g = j;
        } else {
            int iIntValue = (dVar.y != null ? dVar.y : com.opos.mobad.b.a.d.h).intValue();
            if (iIntValue <= 0) {
                j = dVar.t != null ? dVar.t.longValue() : System.currentTimeMillis();
                this.g = j;
            } else {
                this.g = System.currentTimeMillis() + ((long) iIntValue);
            }
        }
        this.j = dVar.w.intValue();
        this.k = (dVar.x != null ? dVar.x : com.opos.mobad.b.a.d.g).intValue();
        if (list == null) {
            this.f = dVar.s;
            this.q = false;
        } else {
            this.f = list;
            this.q = true;
        }
        this.r = (dVar.A != null ? dVar.A : com.opos.mobad.b.a.d.j).intValue();
        this.h = dVar.u != null ? dVar.u : "";
        if (dVar.v != null) {
            this.i = new InstantData(dVar.v.d, dVar.v.e);
        }
        com.opos.mobad.b.a.d.b bVar = dVar.z != null ? dVar.z : com.opos.mobad.b.a.d.i;
        this.m = (dVar.B != null ? dVar.B : com.opos.mobad.b.a.d.k).booleanValue();
        this.l = a(bVar);
        this.n = (dVar.C != null ? dVar.C : com.opos.mobad.b.a.d.l).intValue();
        this.o = (dVar.D != null ? dVar.D : com.opos.mobad.b.a.b.p).booleanValue();
        this.p = dVar;
        this.s = (dVar.E != null ? dVar.E : com.opos.mobad.b.a.d.n).intValue();
        this.t = (dVar.F != null ? dVar.F : com.opos.mobad.b.a.d.o).intValue();
        this.u = dVar.G;
        this.v = dVar != null ? dVar.H : "";
        this.w = dVar != null ? dVar.I : "";
    }

    private int a(com.opos.mobad.b.a.d.b bVar) {
        int i;
        if (bVar == null || (i = AnonymousClass1.f7178a[bVar.ordinal()]) == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }

    protected void a(int i) {
        this.d = i;
    }

    protected void a(String str) {
        this.e = str;
    }

    public boolean a() {
        return this.q;
    }

    public int b() {
        return this.r;
    }

    public com.opos.mobad.b.a.d c() {
        return this.p;
    }

    public boolean d() {
        return this.o;
    }

    public int e() {
        return this.n;
    }

    public int f() {
        return this.d;
    }

    public String g() {
        return this.e;
    }

    public List<com.opos.mobad.b.a.b> h() {
        return this.f;
    }

    public long i() {
        return this.g;
    }

    public String j() {
        return this.h;
    }

    public InstantData k() {
        return this.i;
    }

    public int l() {
        return this.j;
    }

    public int m() {
        return this.k;
    }

    public int n() {
        return this.l;
    }

    public boolean o() {
        return this.m;
    }

    public boolean p() {
        return (this.s & 1) == 1;
    }

    public boolean q() {
        return this.t == 1;
    }

    public String r() {
        return this.u;
    }

    public String s() {
        return this.v;
    }

    public String t() {
        return this.w;
    }

    public String toString() {
        return "FetchAdResponse{code=" + this.d + ", msg='" + this.e + "', requestInterval='" + this.j + "', adEntityList=" + this.f + ", expireTime=" + this.g + ", respId='" + this.h + "', instantIdsEntity=" + this.i + ", dispatchMode=" + this.k + ", gameBoxType=" + this.l + "', customSkip=" + this.m + "', cacheNum=" + this.r + "', recordShowEvent=" + this.o + "', cmType=" + this.s + "', strategyState=" + this.t + "', clkScore='" + this.w + "'}";
    }
}
