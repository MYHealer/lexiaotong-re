package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.opos.cmn.an.b.b;
import com.opos.mobad.b.a.f;
import com.opos.mobad.b.a.i;
import com.opos.mobad.b.a.s;
import com.opos.mobad.b.a.x;
import com.opos.mobad.j.b.c;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class AdItemData extends a implements Parcelable {
    private boolean A;
    private boolean B;
    private int C;
    private ActivatingData D;
    private int E;
    private boolean F;
    private String G;
    private String H;
    private int I;
    private volatile boolean J;
    private volatile boolean K;
    private long L;
    private AppPrivacyData M;
    private CustomInfoData N;
    private int O;
    private String P;
    private int Q;
    private int R;
    private String S;
    private String T;
    private String U;
    private String V;
    private int W;
    private String X;
    private long Y;
    private InteractionSensorData Z;
    private FeedbackData aa;
    private MaterialFileData ab;
    private MaterialFileData ac;
    private boolean ad;
    private String ae;
    List<MaterialData> d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private boolean l;
    private int m;
    private MaterialFileData n;
    private int o;
    private String p;
    private long q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private int v;
    private long w;
    private boolean x;
    private int y;
    private String z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7184a = b.a("b3Bwb19hZHg=");
    public static final String b = b.a("b3Bwb19mZWVk");
    public static final String c = b.a("b3Bwb19jcGQ=");
    public static final Parcelable.Creator<AdItemData> CREATOR = new Parcelable.Creator<AdItemData>() { // from class: com.opos.mobad.model.data.AdItemData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdItemData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            AdItemData adItemData = new AdItemData();
            adItemData.a(parcel.readString());
            adItemData.b(parcel.readString());
            adItemData.c(parcel.readString());
            adItemData.d(parcel.readString());
            adItemData.e(parcel.readString());
            adItemData.f(parcel.readString());
            adItemData.g(parcel.readString());
            adItemData.a(parcel.createTypedArrayList(MaterialData.CREATOR));
            adItemData.a(parcel.readByte() != 0);
            adItemData.a(parcel.readInt());
            adItemData.a((MaterialFileData) parcel.readParcelable(MaterialFileData.class.getClassLoader()));
            adItemData.b(parcel.readInt());
            adItemData.h(parcel.readString());
            adItemData.a(parcel.readLong());
            adItemData.b(parcel.readByte() != 0);
            adItemData.c(parcel.readInt());
            adItemData.d(parcel.readInt());
            adItemData.e(parcel.readInt());
            adItemData.f(parcel.readInt());
            adItemData.b(parcel.readLong());
            adItemData.c(parcel.readByte() != 0);
            adItemData.g(parcel.readInt());
            adItemData.i(parcel.readString());
            adItemData.f(parcel.readByte() != 0);
            adItemData.i(parcel.readInt());
            adItemData.j(parcel.readInt());
            adItemData.a((ActivatingData) parcel.readParcelable(ActivatingData.class.getClassLoader()));
            adItemData.k(parcel.readString());
            adItemData.H = parcel.readString();
            adItemData.I = parcel.readInt();
            adItemData.g(parcel.readByte() != 0);
            adItemData.h(parcel.readByte() != 0);
            adItemData.L = parcel.readLong();
            adItemData.a((AppPrivacyData) parcel.readParcelable(AppPrivacyData.class.getClassLoader()));
            adItemData.N = (CustomInfoData) parcel.readParcelable(CustomInfoData.class.getClassLoader());
            adItemData.O = parcel.readInt();
            adItemData.P = parcel.readString();
            adItemData.Q = parcel.readInt();
            adItemData.S = parcel.readString();
            adItemData.R = parcel.readInt();
            adItemData.T = parcel.readString();
            adItemData.U = parcel.readString();
            adItemData.V = parcel.readString();
            adItemData.h(parcel.readInt());
            adItemData.X = parcel.readString();
            adItemData.Y = parcel.readLong();
            adItemData.Z = (InteractionSensorData) parcel.readParcelable(InteractionSensorData.class.getClassLoader());
            adItemData.aa = (FeedbackData) parcel.readParcelable(FeedbackData.class.getClassLoader());
            adItemData.b((MaterialFileData) parcel.readParcelable(MaterialFileData.class.getClassLoader()));
            adItemData.c((MaterialFileData) parcel.readParcelable(MaterialFileData.class.getClassLoader()));
            adItemData.e(parcel.readByte() != 0);
            adItemData.j(parcel.readString());
            return adItemData;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdItemData[] newArray(int i) {
            return new AdItemData[i];
        }
    };

    /* JADX INFO: renamed from: com.opos.mobad.model.data.AdItemData$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7185a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[com.opos.mobad.b.a.b.EnumC0940b.values().length];
            d = iArr;
            try {
                iArr[com.opos.mobad.b.a.b.EnumC0940b.LINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[com.opos.mobad.b.a.b.EnumC0940b.APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[com.opos.mobad.b.a.b.EnumC0940b.INSTANT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                d[com.opos.mobad.b.a.b.EnumC0940b.BRAND_TOPIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                d[com.opos.mobad.b.a.b.EnumC0940b.THIRD_PARTY_APP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                d[com.opos.mobad.b.a.b.EnumC0940b.LINK_APP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                d[com.opos.mobad.b.a.b.EnumC0940b.WECHAT_APPLET.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                d[com.opos.mobad.b.a.b.EnumC0940b.LIVE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                d[com.opos.mobad.b.a.b.EnumC0940b.WECHAT_NATIVE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[com.opos.mobad.b.a.b.d.values().length];
            c = iArr2;
            try {
                iArr2[com.opos.mobad.b.a.b.d.PLAY_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                c[com.opos.mobad.b.a.b.d.PLAY_STREAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr3 = new int[com.opos.mobad.b.a.b.g.values().length];
            b = iArr3;
            try {
                iArr3[com.opos.mobad.b.a.b.g.TOP_RIGHT_CORNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                b[com.opos.mobad.b.a.b.g.MIDDLE_RIGHT_CORNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                b[com.opos.mobad.b.a.b.g.BOTTOM_RIGHT_CORNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr4 = new int[com.opos.mobad.b.a.b.c.values().length];
            f7185a = iArr4;
            try {
                iArr4[com.opos.mobad.b.a.b.c.SENSOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f7185a[com.opos.mobad.b.a.b.c.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f7185a[com.opos.mobad.b.a.b.c.VERTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private AdItemData() {
        this.z = "广告";
        this.A = false;
        this.B = false;
        this.F = false;
        this.J = false;
        this.K = false;
        this.ad = false;
        this.ae = "";
    }

    public AdItemData(com.opos.mobad.b.a.b bVar, List<MaterialData> list, MaterialFileData materialFileData, InstantData instantData, long j, String str, String str2, CustomInfoData customInfoData, int i, String str3, String str4, String str5, String str6) {
        this.z = "广告";
        this.A = false;
        this.B = false;
        this.F = false;
        this.J = false;
        this.K = false;
        this.ad = false;
        this.ae = "";
        this.i = bVar.A != null ? bVar.A : "";
        this.j = bVar.B != null ? bVar.B : "";
        this.k = bVar.C != null ? bVar.C : "";
        this.p = bVar.I != null ? bVar.I : "";
        this.e = bVar.U != null ? bVar.U : "";
        this.d = list;
        this.m = (bVar.F != null ? bVar.F : com.opos.mobad.b.a.b.e).intValue();
        this.n = materialFileData;
        this.l = (bVar.E != null ? bVar.E : com.opos.mobad.b.a.b.d).booleanValue();
        this.o = (bVar.H != null ? bVar.H : com.opos.mobad.b.a.b.f).intValue();
        this.q = (bVar.J != null ? bVar.J : com.opos.mobad.b.a.b.g).longValue();
        this.r = (bVar.K != null ? bVar.K : com.opos.mobad.b.a.b.h).booleanValue();
        this.s = (bVar.L != null ? bVar.L : com.opos.mobad.b.a.b.i).intValue();
        this.t = (bVar.M != null ? bVar.M : com.opos.mobad.b.a.b.j).intValue();
        this.u = (bVar.O != null ? bVar.O : com.opos.mobad.b.a.b.l).intValue();
        this.v = a(bVar.P != null ? bVar.P : com.opos.mobad.b.a.b.m);
        this.x = (bVar.Q != null ? bVar.Q : com.opos.mobad.b.a.b.n).booleanValue();
        this.y = (bVar.ac != null ? bVar.ac : com.opos.mobad.b.a.b.u).intValue();
        if (bVar.S != null) {
            this.z = bVar.S;
        }
        this.B = (bVar.V != null ? bVar.V : com.opos.mobad.b.a.b.q).booleanValue();
        this.C = a(bVar.W != null ? bVar.W : com.opos.mobad.b.a.b.r);
        this.E = a(bVar.Y);
        if (instantData != null) {
            this.g = instantData.f7193a;
            this.h = instantData.b;
        }
        this.w = j;
        this.f = str == null ? "" : str;
        this.G = bVar.Z != null ? bVar.Z : "";
        this.H = str2;
        this.I = (bVar.aa != null ? bVar.aa : com.opos.mobad.b.a.b.t).intValue();
        a(bVar.X);
        this.L = SystemClock.elapsedRealtime();
        this.M = a(bVar);
        this.N = customInfoData;
        this.O = i;
        this.P = str3;
        this.Q = (bVar.ad != null ? bVar.ad : com.opos.mobad.b.a.b.v).intValue();
        this.R = (bVar.ae != null ? bVar.ae : com.opos.mobad.b.a.b.w).intValue();
        this.S = str4;
        this.T = bVar.af != null ? bVar.af : "";
        this.U = str5;
        this.W = a(bVar.ag != null ? bVar.ag : com.opos.mobad.b.a.b.x);
        this.X = bVar.ah != null ? bVar.ah : "";
        this.Y = (bVar.ak != null ? bVar.ak : com.opos.mobad.b.a.b.y).longValue();
        this.Z = a(bVar.al);
        this.aa = b(bVar.am);
    }

    private static int a(com.opos.mobad.b.a.b.EnumC0940b enumC0940b) {
        if (enumC0940b != null) {
            switch (AnonymousClass2.d[enumC0940b.ordinal()]) {
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
                case 9:
                    return 9;
            }
        }
        return 0;
    }

    private static int a(com.opos.mobad.b.a.b.c cVar) {
        int i;
        if (cVar == null || (i = AnonymousClass2.f7185a[cVar.ordinal()]) == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }

    private static int a(com.opos.mobad.b.a.b.d dVar) {
        if (dVar != null) {
            int i = AnonymousClass2.c[dVar.ordinal()];
            if (i == 1) {
                return 1;
            }
            if (i == 2) {
                return 2;
            }
        }
        return 0;
    }

    private static int a(com.opos.mobad.b.a.b.g gVar) {
        int i;
        if (gVar == null || (i = AnonymousClass2.b[gVar.ordinal()]) == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }

    private AppPrivacyData a(com.opos.mobad.b.a.b bVar) {
        i iVar = bVar.ab;
        if (iVar == null || TextUtils.isEmpty(iVar.e) || TextUtils.isEmpty(iVar.d) || TextUtils.isEmpty(iVar.g) || TextUtils.isEmpty(iVar.f) || TextUtils.isEmpty(iVar.h)) {
            return null;
        }
        List<MaterialData> list = this.d;
        return new AppPrivacyData(iVar.d, iVar.e, iVar.g, iVar.f, (list == null || list.get(0) == null) ? "" : this.d.get(0).f(), iVar.h);
    }

    private InteractionSensorData a(x xVar) {
        return new InteractionSensorData(((xVar == null || xVar.q == null) ? x.d : xVar.q).intValue(), ((xVar == null || xVar.r == null) ? x.e : xVar.r).intValue(), ((xVar == null || xVar.s == null) ? x.f : xVar.s).intValue(), ((xVar == null || xVar.t == null) ? x.g : xVar.t).intValue(), ((xVar == null || xVar.u == null) ? x.h : xVar.u).booleanValue(), ((xVar == null || xVar.v == null) ? x.i : xVar.v).intValue(), ((xVar == null || xVar.w == null) ? x.j : xVar.w).intValue());
    }

    private void a(com.opos.mobad.b.a.a aVar) {
        ArrayList arrayList;
        if (aVar == null) {
            return;
        }
        if (aVar.g == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (f fVar : aVar.g) {
                arrayList.add(new ApkSignerData(fVar.d, fVar.e, fVar.f));
            }
        }
        this.D = new ActivatingData(aVar.e, aVar.f, arrayList, aVar.h.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppPrivacyData appPrivacyData) {
        this.M = appPrivacyData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        this.w = j;
    }

    public boolean A() {
        return (this.y & 8) == 8;
    }

    public boolean B() {
        return (this.y & 16) == 16;
    }

    public boolean C() {
        return (this.y & 32) == 32;
    }

    public boolean D() {
        return this.y == 0;
    }

    public String E() {
        return this.z;
    }

    public int F() {
        return this.W;
    }

    public boolean G() {
        return this.A;
    }

    public String H() {
        return this.ae;
    }

    public boolean I() {
        return this.B;
    }

    public int J() {
        return this.C;
    }

    public int K() {
        return this.E;
    }

    public ActivatingData L() {
        return this.D;
    }

    public void M() {
        this.F = true;
    }

    public boolean N() {
        return this.F;
    }

    public String O() {
        return this.G;
    }

    public int P() {
        return this.I;
    }

    public boolean Q() {
        return this.J;
    }

    public boolean R() {
        return this.K;
    }

    public long S() {
        return this.L;
    }

    public AppPrivacyData T() {
        return this.M;
    }

    public String U() {
        FeedbackData feedbackData = this.aa;
        if (feedbackData == null || feedbackData.a() == null || this.aa.a().isEmpty()) {
            return null;
        }
        for (String str : this.aa.a()) {
            if (str != null && !str.isEmpty()) {
                return str;
            }
        }
        return null;
    }

    public int V() {
        CustomInfoData customInfoData = this.N;
        return customInfoData != null ? customInfoData.b() : c.b();
    }

    public int W() {
        CustomInfoData customInfoData = this.N;
        if (customInfoData != null) {
            return customInfoData.c();
        }
        return 0;
    }

    public int X() {
        CustomInfoData customInfoData = this.N;
        if (customInfoData != null) {
            return customInfoData.d();
        }
        return 3000;
    }

    public int Y() {
        CustomInfoData customInfoData = this.N;
        if (customInfoData != null) {
            return customInfoData.e();
        }
        return 2000;
    }

    public int Z() {
        return this.O;
    }

    public String a() {
        return this.H;
    }

    public void a(int i) {
        this.m = i;
    }

    public void a(long j) {
        this.q = j;
    }

    public void a(ActivatingData activatingData) {
        this.D = activatingData;
    }

    public void a(MaterialFileData materialFileData) {
        this.n = materialFileData;
    }

    public void a(String str) {
        this.e = str;
    }

    public void a(List<MaterialData> list) {
        this.d = list;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public String aa() {
        return this.P;
    }

    public int ab() {
        return this.Q;
    }

    public int ac() {
        return this.R;
    }

    public String ad() {
        return this.S;
    }

    public String ae() {
        return this.T;
    }

    public String af() {
        return this.U;
    }

    public String ag() {
        return this.V;
    }

    public String ah() {
        return this.X;
    }

    public long ai() {
        return this.Y;
    }

    public InteractionSensorData aj() {
        return this.Z;
    }

    public FeedbackData b(List<s> list) {
        FeedbackData feedbackData = new FeedbackData();
        if (list == null || list.isEmpty()) {
            feedbackData.a(s.d.intValue(), "");
        } else {
            for (s sVar : list) {
                feedbackData.a((sVar.e != null ? sVar.e : s.d).intValue(), sVar.f != null ? sVar.f : "");
            }
        }
        return feedbackData;
    }

    public String b() {
        return this.e;
    }

    public void b(int i) {
        this.o = i;
    }

    public void b(MaterialFileData materialFileData) {
        this.ab = materialFileData;
    }

    public void b(String str) {
        this.f = str;
    }

    public void b(boolean z) {
        this.r = z;
    }

    public String c() {
        return this.f;
    }

    public void c(int i) {
        this.s = i;
    }

    public void c(MaterialFileData materialFileData) {
        this.ac = materialFileData;
    }

    public void c(String str) {
        this.g = str;
    }

    public void c(boolean z) {
        this.x = z;
    }

    public String d() {
        return this.g;
    }

    public void d(int i) {
        this.t = i;
    }

    public void d(String str) {
        this.h = str;
    }

    public void d(boolean z) {
        this.A = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.h;
    }

    public void e(int i) {
        this.u = i;
    }

    public void e(String str) {
        this.i = str;
    }

    public void e(boolean z) {
        this.ad = z;
    }

    public String f() {
        return this.i;
    }

    public void f(int i) {
        this.v = i;
    }

    public void f(String str) {
        this.j = str;
    }

    public void f(boolean z) {
        this.B = z;
    }

    public String g() {
        return this.j;
    }

    public void g(int i) {
        this.y = i;
    }

    public void g(String str) {
        this.k = str;
    }

    public void g(boolean z) {
        this.J = z;
    }

    public String h() {
        return this.k;
    }

    public void h(int i) {
        this.W = i;
    }

    public void h(String str) {
        this.p = str;
    }

    public void h(boolean z) {
        this.K = z;
    }

    public List<MaterialData> i() {
        return this.d;
    }

    public void i(int i) {
        this.C = i;
    }

    public void i(String str) {
        if (com.opos.cmn.an.d.a.a(str)) {
            return;
        }
        this.z = str;
    }

    public void j(int i) {
        this.E = i;
    }

    public void j(String str) {
        this.ae = str;
    }

    public boolean j() {
        return this.l;
    }

    public int k() {
        return this.m;
    }

    public void k(String str) {
        this.G = str;
    }

    public MaterialFileData l() {
        return this.n;
    }

    public MaterialFileData m() {
        return this.ab;
    }

    public MaterialFileData n() {
        return this.ac;
    }

    public int o() {
        return this.o;
    }

    public String p() {
        return this.p;
    }

    public long q() {
        return this.q;
    }

    public int r() {
        return this.s;
    }

    public int s() {
        return this.t;
    }

    public int t() {
        return this.v;
    }

    public String toString() {
        return "AdItemData{adSource='" + this.e + ", respId='" + this.f + ", adId='" + this.i + ", posId='" + this.j + ", planId='" + this.k + ", materialDataList=" + this.d + ", showLogo=" + this.l + ", closeBnStyle=" + this.m + ", logoFile=" + this.n + ", refreshTime=" + this.o + ", ext='" + this.p + ", countdown=" + this.q + ", showSkipBn=" + this.r + ", showInterval=" + this.s + ", clickInterval=" + this.t + ", reqInterval=" + this.u + ", playMode=" + this.v + ", expTime=" + this.w + ", playRemindAtCellular=" + this.x + ", rewardScene=" + this.y + ", logoText='" + this.z + ", hasReward='" + this.A + ", isFallback=" + this.ad + ", errorReqId=" + this.ae + ", playVideoInSilence='" + this.B + ", splashSkipBtPosition='" + this.C + ", videoOrientation='" + this.E + ", activatingData='" + this.D + ", isDownloaderStartReport=" + this.J + ", isDownloaderCompleteReport=" + this.K + ", appPrivacyData=" + this.M + ", customInfo= " + this.N + ", posType= " + this.O + ", ageGrading= " + this.P + ", bidIds= " + this.T + ", clkScore= " + this.U + ", contentType= " + this.W + ", wechatExtInfo= " + this.X + ", dspId= " + this.Y + ", interactionSensorData= " + this.Z + ", feedbackData= " + this.aa + ", darkLogoFile=" + this.ab + ", surfaceLogoFile=" + this.ac + '}';
    }

    public long u() {
        return this.w;
    }

    public boolean v() {
        return this.x;
    }

    public int w() {
        return this.y;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeTypedList(this.d);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.m);
        parcel.writeParcelable(this.n, i);
        parcel.writeInt(this.o);
        parcel.writeString(this.p);
        parcel.writeLong(this.q);
        parcel.writeByte(this.r ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.s);
        parcel.writeInt(this.t);
        parcel.writeInt(this.u);
        parcel.writeInt(this.v);
        parcel.writeLong(this.w);
        parcel.writeByte(this.x ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.y);
        parcel.writeString(this.z);
        parcel.writeByte(this.B ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.C);
        parcel.writeInt(this.E);
        parcel.writeParcelable(this.D, i);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeInt(this.I);
        parcel.writeByte(this.J ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.K ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.L);
        parcel.writeParcelable(this.M, i);
        parcel.writeParcelable(this.N, i);
        parcel.writeInt(this.O);
        parcel.writeString(this.P);
        parcel.writeInt(this.Q);
        parcel.writeString(this.S);
        parcel.writeInt(this.R);
        parcel.writeString(this.T);
        parcel.writeString(this.U);
        parcel.writeString(this.V);
        parcel.writeInt(this.W);
        parcel.writeString(this.X);
        parcel.writeLong(this.Y);
        parcel.writeParcelable(this.Z, i);
        parcel.writeParcelable(this.aa, i);
        parcel.writeParcelable(this.ab, i);
        parcel.writeParcelable(this.ac, i);
        parcel.writeByte(this.ad ? (byte) 1 : (byte) 0);
        parcel.writeString(this.ae);
    }

    public boolean x() {
        return (this.y & 1) == 1;
    }

    public boolean y() {
        return (this.y & 2) == 2;
    }

    public boolean z() {
        return (this.y & 4) == 4;
    }
}
