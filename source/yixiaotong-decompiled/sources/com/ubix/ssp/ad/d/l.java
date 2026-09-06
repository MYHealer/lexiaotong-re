package com.ubix.ssp.ad.d;

import android.graphics.Rect;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.am;
import java.math.BigDecimal;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class l {
    private a A;
    private boolean D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8622a = true;
    private boolean b = false;
    private boolean c = false;
    private int d = 0;
    private int e = 3;
    private int f = 0;
    private double g = 3.0d;
    private double h = 0.2d;
    private int i = 1;
    private int j = 0;
    private String k = "";
    private long l = 0;
    private boolean m = false;
    private boolean n = false;
    private int o = 2;
    private boolean p = true;
    private int q = 30;
    private int r = 150;
    private int s = 0;
    private boolean t = false;
    private double u = 0.2d;
    private int v = 35;
    private String w = "";
    private String x = "";
    private boolean y = false;
    private boolean z = false;
    private int B = 0;
    private int C = 0;
    private boolean E = false;
    private int F = 0;
    private boolean G = true;
    private boolean H = false;
    private int I = 100;
    private int J = 0;
    private int[] K = {35, 35};
    private int L = 5000;
    private boolean M = false;
    private boolean N = false;
    private int O = 100;
    private int P = -1;
    private int Q = 50;
    private int R = 0;
    private int S = 5;
    private boolean T = true;
    private int U = 1;
    private double V = 1.0d;
    private int W = 0;
    private int X = -999;
    private String Y = "";
    private boolean Z = true;
    private int a0 = 1;
    private int b0 = -1;
    private boolean c0 = false;
    private int d0 = 0;
    private int e0 = 90;
    private int f0 = -1;
    private boolean g0 = true;
    private boolean h0 = false;
    private boolean i0 = false;
    private int j0 = 0;
    private boolean k0 = false;
    private String l0 = "";
    private int m0 = 50;
    private int n0 = 50;
    private int o0 = 80;
    private int p0 = 0;
    private int q0 = 0;
    private boolean r0 = false;
    private int s0 = 0;
    private int t0 = 0;
    private boolean u0 = false;
    private int v0 = 0;
    private int w0 = 0;
    private int x0 = 0;
    private long y0 = 216000000;
    private int z0 = 0;
    private String A0 = "";
    private long B0 = 259200000;
    private int C0 = 30;
    private int D0 = 2;
    private int E0 = 5;
    private int F0 = 10;
    private int G0 = 0;
    private boolean H0 = false;
    private int I0 = 0;
    private boolean J0 = false;
    private long K0 = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    private long L0 = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    private long M0 = 86400000;
    private boolean N0 = false;
    private boolean O0 = false;
    private boolean P0 = false;
    private boolean Q0 = false;
    private boolean R0 = false;
    private boolean S0 = false;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f8623a;
        private String c;
        private boolean e;
        private int f;
        private int g;
        private int b = 1;
        private int d = 5;

        public a() {
        }

        public int a() {
            return this.d;
        }

        public int b() {
            return this.g;
        }

        public int c() {
            return this.b;
        }

        public int d() {
            return this.f;
        }

        public String e() {
            return this.c;
        }

        public boolean f() {
            return this.e;
        }

        public boolean g() {
            return this.f8623a;
        }

        public boolean h() {
            int i = this.b;
            return i >= 1 && i <= 3;
        }
    }

    public String A() {
        return this.x;
    }

    public void A(int i) {
        if (i > 6) {
            i = 0;
        }
        this.W = i;
    }

    public void A(boolean z) {
        this.i0 = z;
    }

    public boolean A0() {
        return this.T;
    }

    public String B() {
        return this.w;
    }

    public void B(int i) {
        this.v = i;
    }

    public void B(boolean z) {
        this.R0 = z;
    }

    public boolean B0() {
        return this.Q0;
    }

    public int C() {
        return this.i;
    }

    public void C(int i) {
        this.L = i;
    }

    public void C(boolean z) {
        this.b = z;
    }

    public boolean C0() {
        return this.N0;
    }

    public int D() {
        return this.f;
    }

    public void D(int i) {
        if (i > 2) {
            i = 0;
        }
        this.j0 = i;
    }

    public void D(boolean z) {
        this.f8622a = z;
    }

    public boolean D0() {
        return this.O0;
    }

    public a E() {
        a aVar = this.A;
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        this.A = aVar2;
        return aVar2;
    }

    public void E(int i) {
        if (i < 150) {
            i = 150;
        }
        this.r = i;
    }

    public void E(boolean z) {
        this.n = z;
    }

    public boolean E0() {
        a aVar = this.A;
        if (aVar != null) {
            return aVar.g();
        }
        return false;
    }

    public void F(int i) {
        int iRandom = (int) (Math.random() * ((double) i));
        if (iRandom < 50) {
            iRandom = 0;
        }
        this.s = iRandom;
    }

    public int[] F() {
        return this.K;
    }

    public boolean F0() {
        return this.M;
    }

    public String G() {
        return this.l0;
    }

    public void G(int i) {
        this.J = i;
    }

    public boolean G0() {
        return this.H0;
    }

    public int H() {
        return this.t0;
    }

    public void H(int i) {
        if (i > 2 || i < 0) {
            i = 0;
        }
        this.z0 = i;
    }

    public boolean H0() {
        return this.i0;
    }

    public int I() {
        return this.j;
    }

    public void I(int i) {
        if (i > 1 || i < 0) {
            i = 0;
        }
        this.x0 = i;
    }

    public boolean I0() {
        return this.R0;
    }

    public int J() {
        return this.b0;
    }

    public void J(int i) {
        this.y0 = i < 0 ? 0L : ((long) (i * 60)) * 1000;
    }

    public boolean J0() {
        return this.f8622a;
    }

    public long K() {
        return this.B0;
    }

    public void K(int i) {
        this.d = i;
    }

    public boolean K0() {
        return this.n;
    }

    public int L() {
        return this.U;
    }

    public void L(int i) {
        this.e = i;
    }

    public double L0() {
        return this.V;
    }

    public int M() {
        return this.s0;
    }

    public void M(int i) {
        int i2 = 30;
        if (i <= 30) {
            i2 = 3;
            if (i >= 3) {
                this.f0 = i;
                return;
            }
        }
        this.f0 = i2;
    }

    public int N() {
        return this.G0;
    }

    public void N(int i) {
        this.S = i;
    }

    public String O() {
        return this.Y;
    }

    public void O(int i) {
        if (i > 1 || i < 0) {
            i = 0;
        }
        this.w0 = i;
    }

    public long P() {
        return ((long) this.C0) * 1000;
    }

    public void P(int i) {
        this.d0 = i;
    }

    public int Q() {
        return this.e0;
    }

    public long R() {
        return ((long) this.F0) * 1000;
    }

    public int S() {
        return this.W;
    }

    public int T() {
        return this.v;
    }

    public int U() {
        return this.L;
    }

    public int V() {
        return this.j0;
    }

    public double W() {
        return new BigDecimal(this.g).setScale(3, 4).doubleValue();
    }

    public int X() {
        return this.r;
    }

    public int Y() {
        return this.s;
    }

    public int Z() {
        return this.J;
    }

    public void a(double d) {
        this.V = d;
    }

    public void a(int i) {
        this.o = i;
    }

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("ver")) {
                this.m0 = jSONObject.optInt("ver", 50);
            }
            if (jSONObject.has("hor")) {
                this.n0 = jSONObject.optInt("hor", 50);
            }
            if (jSONObject.has("height")) {
                int iOptInt = jSONObject.optInt("height", 80);
                this.o0 = iOptInt;
                if (iOptInt <= 0) {
                    this.o0 = 80;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(boolean z) {
        this.D = z;
    }

    public boolean a() {
        return this.E;
    }

    public Rect a0() {
        int iOptInt;
        int iOptInt2;
        int iOptInt3;
        try {
            if (TextUtils.isEmpty(this.A0)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(this.A0);
            int iOptInt4 = jSONObject.optInt(t.d, -1);
            if (iOptInt4 < 0 || (iOptInt = jSONObject.optInt("t", -1)) < 0 || (iOptInt2 = jSONObject.optInt(t.k, -1)) < 0 || (iOptInt3 = jSONObject.optInt(t.l, -1)) < 0) {
                this.A0 = "";
                return null;
            }
            if (iOptInt4 + iOptInt2 >= 100 || iOptInt + iOptInt3 >= 100) {
                return null;
            }
            return new Rect(iOptInt4, iOptInt, iOptInt2, iOptInt3);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void b(double d) {
        this.u = d;
    }

    public void b(int i) {
        this.q = i;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("rd")) {
                long jOptInt = jSONObject.optInt("rd", 3);
                this.K0 = jOptInt;
                if (jOptInt < 0) {
                    this.K0 = 0L;
                } else {
                    this.K0 = jOptInt * 1000;
                }
            }
            if (jSONObject.has("of")) {
                long jOptInt2 = jSONObject.optInt("of", 3);
                this.L0 = jOptInt2;
                if (jOptInt2 < 0) {
                    this.L0 = 0L;
                } else {
                    this.L0 = (long) (jOptInt2 * Math.random() * 1000.0d);
                }
            }
            if (jSONObject.has("inr")) {
                long jOptInt3 = jSONObject.optInt("inr", 1440);
                this.M0 = jOptInt3;
                if (jOptInt3 < 0) {
                    this.M0 = 0L;
                } else {
                    this.M0 = jOptInt3 * 60000;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(boolean z) {
        this.Z = z;
    }

    public boolean b() {
        return this.D;
    }

    public int b0() {
        return this.z0;
    }

    public int c() {
        return this.o;
    }

    public void c(double d) {
        this.g = d;
    }

    public void c(int i) {
        this.B = i;
    }

    public void c(String str) {
        this.k = str;
    }

    public void c(boolean z) {
        this.t = z;
    }

    public int c0() {
        return this.x0;
    }

    public int d() {
        return this.q;
    }

    public void d(double d) {
        this.h = d;
    }

    public void d(int i) {
        this.C = i;
    }

    public void d(String str) {
        this.x = str;
    }

    public void d(boolean z) {
        this.S0 = z;
    }

    public long d0() {
        return this.y0;
    }

    public int e() {
        return this.B;
    }

    public void e(int i) {
        this.F = i;
    }

    public void e(String str) {
        this.w = str;
    }

    public void e(boolean z) {
        this.g0 = z;
    }

    public int e0() {
        return this.d;
    }

    public int f() {
        return this.C;
    }

    public void f(int i) {
        this.I = i;
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.A = new a();
            if (jSONObject.has("enable")) {
                this.A.f8623a = jSONObject.optBoolean("enable");
            }
            if (jSONObject.has("style")) {
                this.A.b = jSONObject.optInt("style");
            }
            if (jSONObject.has("url")) {
                this.A.c = jSONObject.optString("url");
            }
            if (jSONObject.has("duration")) {
                this.A.d = jSONObject.optInt("duration");
            }
            if (jSONObject.has("clickable")) {
                this.A.e = jSONObject.optBoolean("clickable");
            }
            if (jSONObject.has("times")) {
                this.A.f = jSONObject.optInt("times");
            }
            if (jSONObject.has(am.aT)) {
                this.A.g = jSONObject.optInt(am.aT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void f(boolean z) {
        this.r0 = z;
    }

    public int f0() {
        return this.e;
    }

    public int g() {
        return this.F;
    }

    public void g(int i) {
        if (i > 1 || i < 0) {
            i = 0;
        }
        this.v0 = i;
    }

    public void g(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length > 0) {
                int[] iArr = new int[strArrSplit.length];
                for (int i = 0; i < strArrSplit.length; i++) {
                    iArr[i] = Integer.parseInt(strArrSplit[i]);
                }
                this.K = iArr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void g(boolean z) {
        this.J0 = z;
    }

    public int g0() {
        return this.f0;
    }

    public int h() {
        return this.o0;
    }

    public void h(int i) {
        this.a0 = i;
    }

    public void h(String str) {
        this.l0 = str;
    }

    public void h(boolean z) {
        this.N = z;
    }

    public int h0() {
        return this.S;
    }

    public int i() {
        return this.n0;
    }

    public void i(int i) {
        this.R = i;
    }

    public void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("r_m_t")) {
                int iOptInt = jSONObject.optInt("r_m_t", 30);
                this.C0 = iOptInt;
                if (iOptInt < 5) {
                    this.C0 = 5;
                }
            }
            if (jSONObject.has("g_s_t")) {
                this.D0 = jSONObject.optInt("g_s_t", 2);
            }
            if (jSONObject.has("g_t")) {
                this.E0 = jSONObject.optInt("g_t", 5);
            }
            if (jSONObject.has("t_t")) {
                int iOptInt2 = jSONObject.optInt("t_t", 10);
                this.F0 = iOptInt2;
                if (iOptInt2 < 1) {
                    this.F0 = 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void i(boolean z) {
        this.u0 = z;
    }

    public double i0() {
        return new BigDecimal(this.h).setScale(3, 4).doubleValue();
    }

    public int j() {
        return this.m0;
    }

    public void j(int i) {
        if (i > 2 || i < 0) {
            i = 0;
        }
        this.I0 = i;
    }

    public void j(String str) {
        this.Y = str;
    }

    public void j(boolean z) {
        this.z = z;
    }

    public int j0() {
        return this.w0;
    }

    public int k() {
        return this.I;
    }

    public void k(int i) {
        this.O = i;
    }

    public void k(String str) {
        this.A0 = str;
    }

    public void k(boolean z) {
        this.y = z;
    }

    public int k0() {
        return this.d0;
    }

    public long l() {
        return this.L0;
    }

    public void l(int i) {
        this.P = i;
    }

    public void l(boolean z) {
        this.k0 = z;
    }

    public boolean l0() {
        return this.Z;
    }

    public long m() {
        return this.M0;
    }

    public void m(int i) {
        if (i > 100 || i < 0) {
            i = 50;
        }
        this.Q = i;
    }

    public void m(boolean z) {
        this.P0 = z;
    }

    public boolean m0() {
        return this.t;
    }

    public long n() {
        return this.K0;
    }

    public void n(int i) {
        if (i > 1) {
            i = 0;
        }
        this.p0 = i;
    }

    public void n(boolean z) {
        this.G = z;
    }

    public boolean n0() {
        return this.S0;
    }

    public int o() {
        return this.v0;
    }

    public void o(int i) {
        this.q0 = i;
    }

    public void o(boolean z) {
        this.h0 = z;
    }

    public boolean o0() {
        return this.g0;
    }

    public int p() {
        return this.a0;
    }

    public void p(int i) {
        this.i = i;
    }

    public void p(boolean z) {
        this.H = z;
    }

    public boolean p0() {
        return this.r0;
    }

    public int q() {
        return this.R;
    }

    public void q(int i) {
        this.f = i;
    }

    public void q(boolean z) {
        this.c0 = z;
    }

    public boolean q0() {
        return this.J0;
    }

    public int r() {
        return this.I0;
    }

    public void r(int i) {
        if (i > 1 || i < 0) {
            i = 0;
        }
        this.t0 = i;
    }

    public void r(boolean z) {
        this.T = z;
    }

    public boolean r0() {
        return this.N;
    }

    public float s() {
        return (100 - this.Q) / 100.0f;
    }

    public void s(int i) {
        this.j = i;
    }

    public void s(boolean z) {
        this.Q0 = z;
    }

    public boolean s0() {
        return this.u0;
    }

    public long t() {
        return ((long) this.E0) * 1000;
    }

    public void t(int i) {
        this.b0 = i;
    }

    public void t(boolean z) {
        this.p = z;
    }

    public boolean t0() {
        return this.z;
    }

    public long u() {
        return ((long) this.D0) * 1000;
    }

    public void u(int i) {
        this.B0 = i < 0 ? 0L : ((long) (i * 60)) * 1000;
    }

    public void u(boolean z) {
        this.N0 = z;
    }

    public boolean u0() {
        return this.y;
    }

    public double v() {
        return this.u;
    }

    public void v(int i) {
        this.U = i;
    }

    public void v(boolean z) {
        this.O0 = z;
    }

    public boolean v0() {
        return this.k0;
    }

    public Rect w() {
        int iOptInt;
        int iOptInt2;
        int iOptInt3;
        try {
            if (TextUtils.isEmpty(this.k)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(this.k);
            int iOptInt4 = jSONObject.optInt(t.d, -1);
            if (iOptInt4 >= 0 && (iOptInt = jSONObject.optInt("t", -1)) >= 0 && (iOptInt2 = jSONObject.optInt(t.k, -1)) >= 0 && (iOptInt3 = jSONObject.optInt(t.l, -1)) >= 0) {
                return new Rect(iOptInt4, iOptInt, iOptInt2, iOptInt3);
            }
            this.k = "";
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void w(int i) {
        if (i < 0) {
            i = 0;
        }
        this.s0 = i;
    }

    public void w(boolean z) {
        this.c = z;
    }

    public boolean w0() {
        return this.P0;
    }

    public long x() {
        try {
            if (this.m) {
                return this.l;
            }
            if (!TextUtils.isEmpty(this.k)) {
                JSONObject jSONObject = new JSONObject(this.k);
                if (jSONObject.has("i")) {
                    long jOptInt = ((long) jSONObject.optInt("i", 0)) * 60000;
                    this.m = true;
                    this.l = jOptInt;
                    return jOptInt;
                }
            }
            return this.l;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void x(int i) {
        this.G0 = i;
    }

    public void x(boolean z) {
        this.M = z;
    }

    public boolean x0() {
        return this.h0;
    }

    public int y() {
        return this.p0;
    }

    public void y(int i) {
        if (i < 0) {
            i = 0;
        }
        this.X = i;
    }

    public void y(boolean z) {
        this.E = z;
    }

    public boolean y0() {
        return this.H;
    }

    public int z() {
        return this.q0;
    }

    @Deprecated
    public void z(int i) {
        this.e0 = 90;
    }

    public void z(boolean z) {
        this.H0 = z;
    }

    public boolean z0() {
        return this.c0;
    }
}
