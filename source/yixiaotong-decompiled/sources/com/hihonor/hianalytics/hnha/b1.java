package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import com.hihonor.hianalytics.util.SystemUtils;
import com.huawei.openalliance.ad.constant.ai;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3625a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String i;
    private String j;
    private boolean k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private boolean q;
    private int h = 5;
    private String[] r = new String[0];
    private boolean s = true;
    private int t = 14400;
    private int u = 0;
    private int v = 30;
    private boolean w = false;
    private int x = 0;
    private int y = -1;
    private int z = 5;

    public b1() {
        A();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0014 A[PHI: r2
  0x0014: PHI (r2v2 int) = (r2v0 int), (r2v1 int) binds: [B:8:0x0012, B:20:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    public void A() {
        int i;
        int iA;
        int i2 = this.t;
        int i3 = 60;
        if (i2 > 60) {
            if (i2 <= 300) {
                iA = com.hihonor.hianalytics.util.b.a(0, i3);
            } else {
                i3 = 1800;
                if (i2 <= 1800) {
                    iA = com.hihonor.hianalytics.util.b.a(0, 300);
                } else if (i2 <= 3600) {
                    i = 600;
                } else if (i2 <= 7200) {
                    i = 900;
                } else if (i2 <= 14400) {
                    i = ai.af;
                } else {
                    iA = com.hihonor.hianalytics.util.b.a(0, i3);
                }
            }
            this.u = iA;
        }
        i = 30;
        iA = com.hihonor.hianalytics.util.b.a(0, i);
        this.u = iA;
    }

    public String a() {
        return this.e;
    }

    public void a(int i) {
        this.v = i;
    }

    public void a(String str) {
        this.e = str;
    }

    public void a(boolean z) {
        this.w = z;
    }

    public void a(String[] strArr) {
        if (strArr != null) {
            this.r = (String[]) strArr.clone();
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.i)) {
            this.i = u0.d();
        }
        return this.i;
    }

    public void b(int i) {
        this.h = i;
    }

    public void b(String str) {
        this.o = str;
    }

    public void b(boolean z) {
        this.k = z;
    }

    public int c() {
        return this.v;
    }

    public void c(int i) {
        this.x = i;
    }

    public void c(String str) {
        this.p = str;
    }

    public void c(boolean z) {
        this.q = z;
    }

    public int d() {
        return this.h;
    }

    public void d(int i) {
        this.y = i;
    }

    public void d(String str) {
        this.g = str;
    }

    public void d(boolean z) {
        this.s = z;
    }

    public String e() {
        return this.o;
    }

    public void e(int i) {
        boolean z = i != this.t;
        this.t = i;
        if (z) {
            A();
        }
    }

    public void e(String str) {
        this.b = str;
    }

    public String f() {
        return this.p;
    }

    public void f(int i) {
        this.z = i;
    }

    public void f(String str) {
        this.m = str;
    }

    public int g() {
        return this.x;
    }

    public void g(String str) {
        this.n = str;
    }

    public int h() {
        return this.y;
    }

    public void h(String str) {
        this.d = str;
    }

    public String i() {
        return this.g;
    }

    public void i(String str) {
        this.c = str;
    }

    public String j() {
        return TextUtils.isEmpty(this.g) ? k() : this.g;
    }

    public void j(String str) {
        this.l = str;
    }

    public String k() {
        if (TextUtils.isEmpty(this.f)) {
            this.f = SystemUtils.f();
        }
        return this.f;
    }

    public String l() {
        return this.b;
    }

    public String m() {
        if (TextUtils.isEmpty(this.f3625a)) {
            this.f3625a = u0.b();
        }
        return this.f3625a;
    }

    public String n() {
        return this.m;
    }

    public String o() {
        return this.n;
    }

    public String p() {
        if (TextUtils.isEmpty(this.j)) {
            this.j = com.hihonor.hianalytics.util.p.a("global_v2", "app_ver", "");
        }
        return this.j;
    }

    public String[] q() {
        return (String[]) this.r.clone();
    }

    public int r() {
        return this.t + this.u;
    }

    public int s() {
        return this.z;
    }

    public String t() {
        return this.d;
    }

    public String u() {
        return this.c;
    }

    public String v() {
        return this.l;
    }

    public boolean w() {
        return this.w;
    }

    public boolean x() {
        return this.k;
    }

    public boolean y() {
        return this.q;
    }

    public boolean z() {
        return this.s;
    }
}
