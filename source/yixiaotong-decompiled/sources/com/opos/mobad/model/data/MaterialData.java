package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.mobad.b.a.ab;
import com.opos.mobad.b.a.aj;
import com.opos.mobad.b.a.g;
import com.opos.mobad.b.a.r;
import com.opos.mobad.b.a.u;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class MaterialData extends a implements Parcelable, Comparable {
    public static final Parcelable.Creator<MaterialData> CREATOR = new Parcelable.Creator<MaterialData>() { // from class: com.opos.mobad.model.data.MaterialData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MaterialData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            MaterialData materialData = new MaterialData();
            materialData.a(parcel.readString());
            materialData.a(parcel.readInt());
            materialData.a(parcel.createTypedArrayList(MaterialFileData.CREATOR));
            materialData.b(parcel.readString());
            materialData.c(parcel.readString());
            materialData.b(parcel.createTypedArrayList(MaterialFileData.CREATOR));
            materialData.a(parcel.readByte() != 0);
            materialData.d(parcel.readString());
            materialData.a(parcel.readLong());
            materialData.e(parcel.readString());
            materialData.c(parcel.createStringArrayList());
            materialData.d(parcel.createStringArrayList());
            materialData.e(parcel.createStringArrayList());
            materialData.f(parcel.readString());
            materialData.g(parcel.readString());
            materialData.b(parcel.readInt());
            materialData.b(parcel.readByte() != 0);
            materialData.h(parcel.readString());
            materialData.i(parcel.readString());
            materialData.b(parcel.readLong());
            materialData.c(parcel.readInt());
            materialData.j(parcel.readString());
            materialData.f(parcel.createStringArrayList());
            materialData.g(parcel.createStringArrayList());
            materialData.h(parcel.createStringArrayList());
            materialData.i(parcel.createStringArrayList());
            materialData.j(parcel.createStringArrayList());
            materialData.k(parcel.createStringArrayList());
            materialData.l(parcel.createStringArrayList());
            materialData.d(parcel.readInt());
            materialData.e(parcel.readInt());
            materialData.c(parcel.readByte() != 0);
            materialData.m(parcel.createTypedArrayList(MaterialFileData.CREATOR));
            materialData.f(parcel.readInt());
            materialData.g(parcel.readInt());
            materialData.h(parcel.readInt());
            materialData.i(parcel.readInt());
            materialData.j(parcel.readInt());
            materialData.d(parcel.readByte() != 0);
            materialData.k(parcel.readInt());
            materialData.k(parcel.readString());
            materialData.e(parcel.readByte() != 0);
            materialData.f(parcel.readByte() != 0);
            materialData.l(parcel.readInt());
            materialData.a((AppDownloadData) parcel.readParcelable(AppDownloadData.class.getClassLoader()));
            materialData.n(parcel.createStringArrayList());
            materialData.o(parcel.createStringArrayList());
            materialData.p(parcel.createStringArrayList());
            materialData.l(parcel.readString());
            materialData.m(parcel.readString());
            materialData.m(parcel.readInt());
            materialData.a((FloatLayerData) parcel.readParcelable(FloatLayerData.class.getClassLoader()));
            materialData.n(parcel.readInt());
            materialData.o(parcel.readInt());
            materialData.g(parcel.readByte() != 0);
            materialData.n(parcel.readString());
            materialData.h(parcel.readByte() != 0);
            materialData.q(parcel.readInt());
            materialData.p(parcel.readInt());
            materialData.i(parcel.readByte() != 0);
            materialData.j(parcel.readByte() != 0);
            materialData.r(parcel.readInt());
            materialData.k(parcel.readByte() != 0);
            materialData.o(parcel.readString());
            materialData.ap = parcel.readByte() == 1;
            materialData.aq = parcel.readInt();
            materialData.p = parcel.createTypedArrayList(MaterialFileData.CREATOR);
            materialData.ar = parcel.readLong();
            materialData.as = parcel.readInt();
            materialData.at = parcel.readInt();
            materialData.au = parcel.readString();
            materialData.av = parcel.readString();
            materialData.aw = (InteractiveData) parcel.readParcelable(InteractiveData.class.getClassLoader());
            materialData.ax = parcel.readInt();
            materialData.ay = parcel.readString();
            materialData.az = parcel.readInt();
            materialData.aA = parcel.readString();
            materialData.aB = parcel.createTypedArrayList(AdxAdExtInfoData.CREATOR);
            return materialData;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MaterialData[] newArray(int i) {
            return new MaterialData[i];
        }
    };
    private boolean A;
    private String B;
    private String C;
    private long D;
    private int E;
    private String F;
    private List<String> G;
    private List<String> H;
    private List<String> I;
    private List<String> J;
    private List<String> K;
    private List<String> L;
    private List<String> M;
    private int N;
    private int O;
    private boolean P;
    private List<MaterialFileData> Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private boolean W;
    private int X;
    private String Y;
    private boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7196a;
    private String aA;
    private List<AdxAdExtInfoData> aB;
    private int aa;
    private boolean ab;
    private AppDownloadData ac;
    private List<String> ad;
    private List<String> ae;
    private List<String> af;
    private String ag;
    private String ah;
    private int ai;
    private FloatLayerData aj;
    private int ak;
    private int al;
    private boolean am;
    private boolean an;
    private String ao;
    private boolean ap;
    private int aq;
    private long ar;
    private int as;
    private int at;
    private String au;
    private String av;
    private InteractiveData aw;
    private int ax;
    private String ay;
    private int az;
    public boolean b;
    public int c;
    public int d;
    public boolean e;
    public boolean f;
    public int g;
    public List<String> h;
    public String i;
    private String j;
    private int k;
    private List<MaterialFileData> l;
    private String m;
    private String n;
    private List<MaterialFileData> o;
    private List<MaterialFileData> p;
    private boolean q;
    private String r;
    private long s;
    private String t;
    private List<String> u;
    private List<String> v;
    private List<String> w;
    private String x;
    private String y;
    private int z;

    /* JADX INFO: renamed from: com.opos.mobad.model.data.MaterialData$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7197a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;
        static final /* synthetic */ int[] d;
        static final /* synthetic */ int[] e;
        static final /* synthetic */ int[] f;
        static final /* synthetic */ int[] g;
        static final /* synthetic */ int[] h;
        static final /* synthetic */ int[] i;
        static final /* synthetic */ int[] j;
        static final /* synthetic */ int[] k;

        static {
            int[] iArr = new int[u.values().length];
            k = iArr;
            try {
                iArr[u.TYPE_16_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                k[u.TYPE_16_9.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[ab.h.values().length];
            j = iArr2;
            try {
                iArr2[ab.h.OPEN_HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                j[ab.h.OPEN_DETAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[ab.i.values().length];
            i = iArr3;
            try {
                iArr3[ab.i.SURFING.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                i[ab.i.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                i[ab.i.MIDDLE_PAGE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                i[ab.i.OPEN_HOME_PAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                i[ab.i.OPEN_DETAIL_PAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                i[ab.i.OPEN_INSTANT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                i[ab.i.OPEN_MINI_PROGRAM.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                i[ab.i.OPEN_WECHAT_NATIVE_PAGE.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr4 = new int[ab.g.values().length];
            h = iArr4;
            try {
                iArr4[ab.g.SHOW_REMINDER_TOAST.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                h[ab.g.AUTO_OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr5 = new int[ab.n.values().length];
            g = iArr5;
            try {
                iArr5[ab.n.WEBVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                g[ab.n.SYSTEM_BROWSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            int[] iArr6 = new int[ab.o.values().length];
            f = iArr6;
            try {
                iArr6[ab.o.IMAGE_TIP_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f[ab.o.GRAPHIC_MIX_TIP_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr7 = new int[ab.d.values().length];
            e = iArr7;
            try {
                iArr7[ab.d.SDK_APP.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                e[ab.d.DEEPLINK_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                e[ab.d.DOWNLOADER.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                e[ab.d.SAFE_DEEPLINK_APP.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            int[] iArr8 = new int[ab.p.values().length];
            d = iArr8;
            try {
                iArr8[ab.p.JUMP_LANDING_PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                d[ab.p.JUMP_FLOATING_LAYER.ordinal()] = 2;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                d[ab.p.NO_JUMP_ACTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused25) {
            }
            int[] iArr9 = new int[ab.e.values().length];
            c = iArr9;
            try {
                iArr9[ab.e.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                c[ab.e.MODEL_A.ordinal()] = 2;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                c[ab.e.MODEL_INTERACTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused28) {
            }
            int[] iArr10 = new int[aj.c.values().length];
            b = iArr10;
            try {
                iArr10[aj.c.VIDEO_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                b[aj.c.VIDEO_PROCESS_25_PERCENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                b[aj.c.VIDEO_PROCESS_50_PERCENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                b[aj.c.VIDEO_PROCESS_75_PERCENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                b[aj.c.VIDEO_COMPLETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                b[aj.c.VIDEO_CLICK.ordinal()] = 6;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                b[aj.c.VIDEO_CLOSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused35) {
            }
            int[] iArr11 = new int[r.b.values().length];
            f7197a = iArr11;
            try {
                iArr11[r.b.DOWNLOAD_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f7197a[r.b.DOWNLOAD_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                f7197a[r.b.INSTALL_COMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused38) {
            }
        }
    }

    public MaterialData() {
        this.A = true;
        this.O = 0;
    }

    public MaterialData(ab abVar, List<MaterialFileData> list, List<MaterialFileData> list2, List<MaterialFileData> list3, List<MaterialFileData> list4, FloatLayerData floatLayerData) {
        List<String> list5;
        List<String> list6;
        this.A = true;
        this.O = 0;
        this.j = abVar.Q != null ? abVar.Q : "";
        this.k = a(abVar.S);
        this.U = a(abVar.av);
        this.V = a(abVar.aw);
        this.T = a(abVar.au);
        this.m = abVar.U != null ? abVar.U : "";
        this.n = abVar.V != null ? abVar.V : "";
        this.l = list;
        this.o = list2;
        this.Q = list3;
        this.p = list4;
        this.q = (abVar.X != null ? abVar.X : ab.f).booleanValue();
        this.r = abVar.Y != null ? abVar.Y : "";
        this.s = (abVar.Z != null ? abVar.Z : ab.g).longValue();
        this.t = abVar.aa != null ? abVar.aa : "";
        List<String> list7 = abVar.ab;
        if (list7 != null && list7.size() > 0) {
            this.u = list7;
        }
        List<String> list8 = abVar.ac;
        if (list8 != null && list8.size() > 0) {
            this.v = list8;
        }
        List<String> list9 = abVar.ad;
        if (list9 != null && list9.size() > 0) {
            this.w = list9;
        }
        this.x = abVar.ae != null ? abVar.ae : "";
        this.y = abVar.af != null ? abVar.af : "";
        this.z = (abVar.ag != null ? abVar.ag : ab.h).intValue();
        this.A = (abVar.ah != null ? abVar.ah : ab.i).booleanValue();
        this.B = abVar.ai != null ? abVar.ai : "";
        this.C = abVar.aj != null ? abVar.aj : "";
        this.D = (abVar.ak != null ? abVar.ak : ab.j).longValue();
        this.E = (abVar.al != null ? abVar.al : ab.k).intValue();
        this.F = abVar.am != null ? abVar.am : "";
        r(abVar.an);
        this.N = a(abVar.ao);
        this.O = a(abVar.ap);
        this.P = (abVar.aq != null ? abVar.aq : ab.n).booleanValue();
        this.R = a(abVar.as);
        this.S = (abVar.at != null ? abVar.at : ab.p).intValue();
        this.W = (abVar.ax != null ? abVar.ax : ab.t).booleanValue();
        this.X = a(abVar.ay);
        this.Y = abVar.az != null ? abVar.az : "";
        this.ag = abVar.aG != null ? abVar.aG : "";
        this.ah = abVar.aF != null ? abVar.aF : "";
        this.ai = a(abVar.aH);
        this.am = (abVar.aL != null ? abVar.aL : ab.B).booleanValue();
        this.f7196a = abVar.aN != null ? abVar.aN : "";
        this.b = (abVar.aO != null ? abVar.aO : ab.D).booleanValue();
        this.d = a(abVar.aP);
        this.c = a(abVar.aQ);
        this.e = (abVar.aR != null ? abVar.aR : ab.G).booleanValue();
        this.f = (abVar.aS != null ? abVar.aS : ab.H).booleanValue();
        this.Z = (abVar.aC != null ? abVar.aC : ab.x).booleanValue();
        this.ab = (abVar.aB != null ? abVar.aB : ab.w).booleanValue();
        this.aa = (abVar.aA != null ? abVar.aA : ab.v).intValue();
        this.ac = a(abVar.aD);
        q(abVar.aE);
        this.aj = floatLayerData;
        this.ak = a(abVar.aJ);
        this.al = a(abVar.aK);
        this.i = abVar.aT;
        this.h = abVar.aU;
        this.g = a(abVar.aW);
        this.an = (abVar.aX != null ? abVar.aX : ab.J).booleanValue();
        this.ao = abVar.aV != null ? abVar.aV : "";
        this.ap = (abVar.aY != null ? abVar.aY : ab.K).booleanValue();
        this.aq = (abVar.ba != null ? abVar.ba : ab.L).intValue();
        List<String> list10 = this.w;
        if ((list10 == null || list10.size() <= 0) && (list5 = this.L) != null && list5.size() > 0) {
            this.w = this.L;
        }
        List<String> list11 = this.v;
        if ((list11 == null || list11.size() <= 0) && (list6 = this.M) != null && list6.size() > 0) {
            this.v = this.M;
        }
        this.ar = (abVar.bc != null ? abVar.bc : ab.M).longValue();
        this.as = (abVar.be != null ? abVar.be : ab.O).intValue();
        this.at = (abVar.bd != null ? abVar.bd : ab.N).intValue();
        this.au = abVar.bf != null ? abVar.bf : "";
        this.av = abVar.bg != null ? abVar.bg : "";
        this.aw = InteractiveData.a(abVar.bh);
        this.ay = abVar.bj;
        if (abVar.bk != null) {
            this.az = abVar.bk.getValue();
        }
        if (abVar.bl != null) {
            this.aA = abVar.bl != null ? abVar.bl : "";
        }
        if (abVar.bm != null) {
            this.aB = AdxAdExtInfoData.a(abVar.bm);
        }
    }

    private static int a(ab.d dVar) {
        if (dVar == null) {
            return 0;
        }
        int i = AnonymousClass2.e[dVar.ordinal()];
        int i2 = 1;
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            i2 = 3;
            if (i == 3) {
                return 2;
            }
            if (i != 4) {
                return 0;
            }
        }
        return i2;
    }

    private static int a(ab.e eVar) {
        int i;
        if (eVar == null || (i = AnonymousClass2.c[eVar.ordinal()]) == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }

    private static int a(ab.g gVar) {
        if (gVar != null) {
            int i = AnonymousClass2.h[gVar.ordinal()];
            if (i == 1) {
                return 1;
            }
            if (i == 2) {
                return 2;
            }
        }
        return 0;
    }

    private static int a(ab.h hVar) {
        if (hVar != null) {
            int i = AnonymousClass2.j[hVar.ordinal()];
            if (i == 1) {
                return 1;
            }
            if (i == 2) {
                return 2;
            }
        }
        return 0;
    }

    public static int a(ab.i iVar) {
        if (iVar != null) {
            switch (AnonymousClass2.i[iVar.ordinal()]) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                case 8:
                    return 8;
            }
        }
        return 0;
    }

    private static int a(ab.n nVar) {
        int i;
        return (nVar == null || (i = AnonymousClass2.g[nVar.ordinal()]) == 1 || i != 2) ? 0 : 1;
    }

    private static int a(ab.o oVar) {
        int i;
        return (oVar == null || (i = AnonymousClass2.f[oVar.ordinal()]) == 1 || i != 2) ? 0 : 1;
    }

    private static int a(ab.p pVar) {
        int i;
        if (pVar == null || (i = AnonymousClass2.d[pVar.ordinal()]) == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }

    private int a(u uVar) {
        return (uVar == null || AnonymousClass2.k[uVar.ordinal()] != 1) ? 1 : 0;
    }

    private AppDownloadData a(g gVar) {
        if (gVar == null) {
            return null;
        }
        AppDownloadData appDownloadData = new AppDownloadData();
        appDownloadData.a(gVar.d != null ? gVar.d : "");
        appDownloadData.c(gVar.f != null ? gVar.f : "");
        appDownloadData.d(gVar.g != null ? gVar.g : "");
        appDownloadData.b(gVar.e != null ? gVar.e : "");
        return appDownloadData;
    }

    private void q(List<r> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (r rVar : list) {
            int i = AnonymousClass2.f7197a[rVar.e.ordinal()];
            if (i == 1) {
                this.ad = rVar.f;
            } else if (i == 2) {
                this.ae = rVar.f;
            } else if (i == 3) {
                this.af = rVar.f;
            }
        }
    }

    private void r(List<aj> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (aj ajVar : list) {
            switch (AnonymousClass2.b[ajVar.e.ordinal()]) {
                case 1:
                    this.G = ajVar.f;
                    break;
                case 2:
                    this.H = ajVar.f;
                    break;
                case 3:
                    this.I = ajVar.f;
                    break;
                case 4:
                    this.J = ajVar.f;
                    break;
                case 5:
                    this.K = ajVar.f;
                    break;
                case 6:
                    this.L = ajVar.f;
                    break;
                case 7:
                    this.M = ajVar.f;
                    break;
            }
        }
    }

    public int A() {
        return this.N;
    }

    public int B() {
        return this.O;
    }

    public boolean C() {
        return this.P;
    }

    public List<MaterialFileData> D() {
        return this.Q;
    }

    public int E() {
        return this.S;
    }

    public int F() {
        return this.T;
    }

    public int G() {
        return this.U;
    }

    public int H() {
        return this.V;
    }

    public int I() {
        return this.X;
    }

    public String J() {
        return this.Y;
    }

    public AppDownloadData K() {
        return this.ac;
    }

    public List<String> L() {
        return this.ad;
    }

    public List<String> M() {
        return this.ae;
    }

    public List<String> N() {
        return this.af;
    }

    public String O() {
        return this.ag;
    }

    public String P() {
        return this.ah;
    }

    public int Q() {
        return this.ai;
    }

    public FloatLayerData R() {
        return this.aj;
    }

    public int S() {
        return this.ak;
    }

    public int T() {
        return this.al;
    }

    public boolean U() {
        return this.am;
    }

    public String V() {
        return this.f7196a;
    }

    public boolean W() {
        return this.an;
    }

    public String X() {
        return this.ao;
    }

    public long Y() {
        return this.ar;
    }

    public int Z() {
        return this.as;
    }

    public void a(int i) {
        this.k = i;
    }

    public void a(long j) {
        this.s = j;
    }

    public void a(AppDownloadData appDownloadData) {
        this.ac = appDownloadData;
    }

    public void a(FloatLayerData floatLayerData) {
        this.aj = floatLayerData;
    }

    public void a(String str) {
        this.j = str;
    }

    public void a(List<MaterialFileData> list) {
        this.l = list;
    }

    public void a(boolean z) {
        this.q = z;
    }

    public boolean a() {
        return this.ap;
    }

    public int aa() {
        return this.at;
    }

    public String ab() {
        return this.au;
    }

    public String ac() {
        return this.av;
    }

    public InteractiveData ad() {
        return this.aw;
    }

    public String ae() {
        return this.ay;
    }

    public int af() {
        return this.az;
    }

    public String ag() {
        return this.aA;
    }

    public List<AdxAdExtInfoData> ah() {
        return this.aB;
    }

    public int b() {
        return this.aq;
    }

    public void b(int i) {
        this.z = i;
    }

    public void b(long j) {
        this.D = j;
    }

    public void b(String str) {
        this.m = str;
    }

    public void b(List<MaterialFileData> list) {
        this.o = list;
    }

    public void b(boolean z) {
        this.A = z;
    }

    public String c() {
        return this.j;
    }

    public void c(int i) {
        this.E = i;
    }

    public void c(String str) {
        this.n = str;
    }

    public void c(List<String> list) {
        this.u = list;
    }

    public void c(boolean z) {
        this.P = z;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof AdItemData) {
            return this.z <= ((MaterialData) obj).z ? -1 : 1;
        }
        return 0;
    }

    public int d() {
        return this.k;
    }

    public void d(int i) {
        this.N = i;
    }

    public void d(String str) {
        this.r = str;
    }

    public void d(List<String> list) {
        this.v = list;
    }

    public void d(boolean z) {
        this.W = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<MaterialFileData> e() {
        return this.l;
    }

    public void e(int i) {
        this.O = i;
    }

    public void e(String str) {
        this.t = str;
    }

    public void e(List<String> list) {
        this.w = list;
    }

    public void e(boolean z) {
        this.Z = z;
    }

    public String f() {
        return this.m;
    }

    public void f(int i) {
        this.R = i;
    }

    public void f(String str) {
        this.x = str;
    }

    public void f(List<String> list) {
        this.G = list;
    }

    public void f(boolean z) {
        this.ab = z;
    }

    public String g() {
        return this.n;
    }

    public void g(int i) {
        this.S = i;
    }

    public void g(String str) {
        this.y = str;
    }

    public void g(List<String> list) {
        this.H = list;
    }

    public void g(boolean z) {
        this.am = z;
    }

    public List<MaterialFileData> h() {
        return this.o;
    }

    public void h(int i) {
        this.T = i;
    }

    public void h(String str) {
        this.B = str;
    }

    public void h(List<String> list) {
        this.I = list;
    }

    public void h(boolean z) {
        this.b = z;
    }

    public String i() {
        return this.r;
    }

    public void i(int i) {
        this.U = i;
    }

    public void i(String str) {
        this.C = str;
    }

    public void i(List<String> list) {
        this.J = list;
    }

    public void i(boolean z) {
        this.e = z;
    }

    public long j() {
        return this.s;
    }

    public void j(int i) {
        this.V = i;
    }

    public void j(String str) {
        this.F = str;
    }

    public void j(List<String> list) {
        this.K = list;
    }

    public void j(boolean z) {
        this.f = z;
    }

    public String k() {
        return this.t;
    }

    public void k(int i) {
        this.X = i;
    }

    public void k(String str) {
        this.Y = str;
    }

    public void k(List<String> list) {
        this.L = list;
    }

    public void k(boolean z) {
        this.an = z;
    }

    public List<String> l() {
        return this.u;
    }

    public void l(int i) {
        this.aa = i;
    }

    public void l(String str) {
        this.ag = str;
    }

    public void l(List<String> list) {
        this.M = list;
    }

    public List<String> m() {
        return this.v;
    }

    public void m(int i) {
        this.ai = i;
    }

    public void m(String str) {
        this.ah = str;
    }

    public void m(List<MaterialFileData> list) {
        this.Q = list;
    }

    public List<String> n() {
        return this.w;
    }

    public void n(int i) {
        this.ak = i;
    }

    public void n(String str) {
        this.f7196a = str;
    }

    public void n(List<String> list) {
        this.ad = list;
    }

    public String o() {
        return this.x;
    }

    public void o(int i) {
        this.al = i;
    }

    public void o(String str) {
        this.ao = str;
    }

    public void o(List<String> list) {
        this.ae = list;
    }

    public String p() {
        return this.y;
    }

    public void p(int i) {
        this.c = i;
    }

    public void p(List<String> list) {
        this.af = list;
    }

    public String q() {
        return this.B;
    }

    public void q(int i) {
        this.d = i;
    }

    public String r() {
        return this.C;
    }

    public void r(int i) {
        this.g = i;
    }

    public long s() {
        return this.D;
    }

    public int t() {
        return this.E;
    }

    public String toString() {
        return "MaterialData{materialId='" + this.j + "', interactionType=" + this.k + ", imgFileList=" + this.l + ", interactiveFileList=" + this.p + ", title='" + this.m + "', desc='" + this.n + "', iconFileList=" + this.o + ", gbClick=" + this.q + ", downloadPkgName='" + this.r + "', apkSize=" + this.s + ", targetUrl='" + this.t + "', expStartUrls=" + this.u + ", expEndUrls=" + this.v + ", clickUrls=" + this.w + ", traceId='" + this.x + "', transparent='" + this.y + "', currentIndex=" + this.z + ", forceJsInit=" + this.A + ", extraUrl='" + this.B + "', dlChannel='" + this.C + "', videoDuration=" + this.D + ", showOffBnTime=" + this.E + ", landingPageUrl='" + this.F + "', videoStartUrls=" + this.G + ", video25PercentUrls=" + this.H + ", video50PercentUrls=" + this.I + ", video75PercentUrls=" + this.J + ", videoCompleteUrls=" + this.K + ", videoClickUrls=" + this.L + ", videoCloseUrls=" + this.M + ", installCompleteAction=" + this.N + ", surfingType=" + this.O + ", isGbClickToast=" + this.P + ", videoFileList=" + this.Q + ", tipBarType=" + this.R + ", rewardLimitTime=" + this.S + ", installedAction=" + this.T + ", extraActionType=" + this.U + ", videoActionType=" + this.V + ", isRemoveRepeatAd=" + this.W + ", downloadStyle=" + this.X + ", downloadUrl=" + this.Y + ", maxDownloaderNums='" + this.aa + "', showDownloadNotification='" + this.ab + "', wifiRemindAtCellular='" + this.Z + "', trackContent=" + this.ag + ", trackReference=" + this.ah + ", appDownloadData=" + this.ac + "', downloadStartUrls=" + this.ad + "', downloadCompleteUrls=" + this.ae + "', downloadInstalledUrls=" + this.af + "', videoCompleteAction=" + this.ai + "', floatLayerData=" + this.aj + "', floatLayerBtAction=" + this.ak + "', floatLayerExtraAction=" + this.al + "', isMobileAutoPlay=" + this.am + "', buttonTitle=" + this.f7196a + "', isShowMediaInfo=" + this.b + "', isShowConvertBar=" + this.e + "', isDynamicPopUpConvert=" + this.f + "', portEndPageModelType=" + this.d + "', landEndPageModelType=" + this.c + "', imgType=" + this.g + "', isShowFeedBack=" + this.an + "', isVertical=" + this.ap + "', templateId=" + this.aq + "', apkDownloadTimes=" + this.ar + "', specificationId=" + this.as + "', creativeType=" + this.ax + "', grade=" + this.ay + "', interactiveMode=" + this.az + "', dpToken=" + this.aA + "', adxAdExtInfo=" + this.aB + "'}";
    }

    public String u() {
        return this.F;
    }

    public List<String> v() {
        return this.G;
    }

    public List<String> w() {
        return this.H;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.j);
        parcel.writeInt(this.k);
        parcel.writeTypedList(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeTypedList(this.o);
        parcel.writeByte(this.q ? (byte) 1 : (byte) 0);
        parcel.writeString(this.r);
        parcel.writeLong(this.s);
        parcel.writeString(this.t);
        parcel.writeStringList(this.u);
        parcel.writeStringList(this.v);
        parcel.writeStringList(this.w);
        parcel.writeString(this.x);
        parcel.writeString(this.y);
        parcel.writeInt(this.z);
        parcel.writeByte(this.A ? (byte) 1 : (byte) 0);
        parcel.writeString(this.B);
        parcel.writeString(this.C);
        parcel.writeLong(this.D);
        parcel.writeInt(this.E);
        parcel.writeString(this.F);
        parcel.writeStringList(this.G);
        parcel.writeStringList(this.H);
        parcel.writeStringList(this.I);
        parcel.writeStringList(this.J);
        parcel.writeStringList(this.K);
        parcel.writeStringList(this.L);
        parcel.writeStringList(this.M);
        parcel.writeInt(this.N);
        parcel.writeInt(this.O);
        parcel.writeByte(this.P ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.Q);
        parcel.writeInt(this.R);
        parcel.writeInt(this.S);
        parcel.writeInt(this.T);
        parcel.writeInt(this.U);
        parcel.writeInt(this.V);
        parcel.writeByte(this.W ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.X);
        parcel.writeString(this.Y);
        parcel.writeByte(this.Z ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.ab ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.aa);
        parcel.writeParcelable(this.ac, i);
        parcel.writeStringList(this.ad);
        parcel.writeStringList(this.ae);
        parcel.writeStringList(this.af);
        parcel.writeString(this.ag);
        parcel.writeString(this.ah);
        parcel.writeInt(this.ai);
        parcel.writeParcelable(this.aj, i);
        parcel.writeInt(this.ak);
        parcel.writeInt(this.al);
        parcel.writeByte(this.am ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7196a);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.c);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.g);
        parcel.writeByte(this.an ? (byte) 1 : (byte) 0);
        parcel.writeString(this.ao);
        parcel.writeByte(this.ap ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.aq);
        parcel.writeTypedList(this.p);
        parcel.writeLong(this.ar);
        parcel.writeInt(this.as);
        parcel.writeInt(this.at);
        parcel.writeString(this.au);
        parcel.writeString(this.av);
        parcel.writeParcelable(this.aw, i);
        parcel.writeInt(this.ax);
        parcel.writeString(this.ay);
        parcel.writeInt(this.az);
        parcel.writeString(this.aA);
        parcel.writeTypedList(this.aB);
    }

    public List<String> x() {
        return this.I;
    }

    public List<String> y() {
        return this.J;
    }

    public List<String> z() {
        return this.K;
    }
}
