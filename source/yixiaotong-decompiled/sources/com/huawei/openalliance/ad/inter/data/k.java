package com.huawei.openalliance.ad.inter.data;

import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class k extends c implements f {
    private int B;
    private int C;
    private String D;
    private int E;
    private MetaData F;
    private List<Integer> G;
    private boolean H;
    private String J;
    private String K;
    private String L;
    private String Q;
    private boolean R;
    private String S;
    private String T;
    private boolean W;
    private boolean aa;
    private String ab;
    private String ad;
    private int b;
    private String c;
    private String d;
    private String e;
    private int f;
    private int g;
    private String h;
    private boolean i;
    private boolean j;
    private int k;
    private String m;
    private String n;
    private String r;
    private long s;
    private int t;
    private String u;
    private String v;
    private VideoInfo w;
    private List<String> x;
    private List<String> y;
    private AppInfo z;

    public k(AdContentData adContentData) {
        super(adContentData);
        this.i = false;
        this.j = false;
        this.H = false;
        this.R = false;
        this.W = false;
        this.aa = false;
    }

    public void B(int i) {
        this.t = i;
    }

    public void B(String str) {
        this.h = str;
    }

    public VideoInfo C() {
        return this.w;
    }

    public void C(int i) {
        this.E = i;
    }

    public void C(String str) {
        this.d = str;
    }

    public void Code(int i) {
        this.b = i;
    }

    public void Code(MetaData metaData) {
        this.F = metaData;
    }

    public void Code(AdContentData adContentData) {
        this.I = adContentData;
    }

    public void Code(AppInfo appInfo) {
        this.z = appInfo;
    }

    public void Code(VideoInfo videoInfo) {
        this.w = videoInfo;
    }

    public void Code(boolean z) {
        this.i = z;
    }

    public void D(String str) {
        this.m = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public AppInfo E() {
        return this.z;
    }

    public void F(int i) {
        this.C = i;
    }

    public void F(boolean z) {
        this.aa = z;
    }

    public void I(int i) {
        this.g = i;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public void I(String str) {
        this.Z = str;
    }

    public void I(List<String> list) {
        this.y = list;
    }

    public void I(boolean z) {
        this.H = z;
    }

    public boolean I() {
        return this.i;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public String K() {
        return this.K;
    }

    public String L() {
        return this.h;
    }

    public void L(String str) {
        this.n = str;
    }

    public void S(int i) {
        this.B = i;
    }

    public void S(String str) {
        this.e = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public String U() {
        return this.Z;
    }

    public void V(int i) {
        this.f = i;
    }

    public void V(long j) {
        this.s = j;
    }

    public void V(List<String> list) {
        this.x = list;
    }

    public void V(boolean z) {
        this.j = z;
    }

    public void Z(int i) {
        this.k = i;
    }

    public void Z(String str) {
        this.c = str;
    }

    public void Z(List<Integer> list) {
        this.G = list;
    }

    public void Z(boolean z) {
        this.R = z;
    }

    public void a(String str) {
        this.r = str;
    }

    public boolean aB() {
        return this.R;
    }

    public boolean aH() {
        return this.aa;
    }

    public AdContentData aJ() {
        return this.I;
    }

    public List<AdvertiserInfo> aL() {
        if (this.I == null) {
            return null;
        }
        return this.I.aL();
    }

    public String ar() {
        return this.u;
    }

    public String as() {
        return this.v;
    }

    public boolean aw() {
        return this.H;
    }

    public void b(String str) {
        this.u = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public String c() {
        return this.D;
    }

    public void c(String str) {
        this.v = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public String d() {
        return this.S;
    }

    public void e(String str) {
        this.J = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public int f() {
        return this.C;
    }

    public void f(String str) {
        this.K = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public String h() {
        return this.L;
    }

    public void i(String str) {
        this.Q = str;
    }

    public void j(String str) {
        this.T = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public MetaData j_() {
        return this.F;
    }

    public void m(String str) {
        this.ab = str;
    }

    public void n(String str) {
        this.S = str;
    }

    public void o(String str) {
        this.D = str;
    }

    public void p(String str) {
        this.L = str;
    }

    public void q(String str) {
        this.ad = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public String r() {
        return this.Q;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public int s() {
        return this.B;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public String u() {
        return this.ab;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public long x() {
        return this.s;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public int y() {
        return this.t;
    }
}
