package com.hihonor.hianalytics.hnha;

import com.hihonor.hianalytics.module.config.HiAnalyticsAutoConfig;
import com.hihonor.hianalytics.util.SystemUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z0 f3629a;
    private z0 b;
    private z0 c;
    private z0 d;
    private HiAnalyticsAutoConfig e;
    private final String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l = null;

    public c1(String str) {
        this.f = str;
    }

    public z0 a(int i) {
        if (i == 0) {
            return i();
        }
        if (1 == i) {
            return h();
        }
        if (3 == i) {
            return e();
        }
        if (2 == i) {
            return j();
        }
        j2.e("HiAnalyticsInstData", "getConfig tag=" + this.f + " with illegalType=" + i);
        return null;
    }

    public z0 a(String str) {
        if ("oper".equals(str)) {
            return i();
        }
        if ("maint".equals(str)) {
            return h();
        }
        if ("diffprivacy".equals(str)) {
            return e();
        }
        if ("preins".equals(str)) {
            return j();
        }
        j2.e("HiAnalyticsInstData", "getConfig tag=" + this.f + " with wrong type=" + str);
        return null;
    }

    public String a() {
        return this.j;
    }

    public void a(z0 z0Var) {
        this.c = z0Var;
    }

    public void a(HiAnalyticsAutoConfig hiAnalyticsAutoConfig) {
        this.e = hiAnalyticsAutoConfig;
    }

    public String b() {
        return this.h;
    }

    public void b(z0 z0Var) {
        this.b = z0Var;
    }

    public void b(String str) {
        this.j = str;
    }

    public String c() {
        return this.g;
    }

    public void c(z0 z0Var) {
        this.f3629a = z0Var;
    }

    public void c(String str) {
        this.h = str;
    }

    public HiAnalyticsAutoConfig d() {
        return this.e;
    }

    public void d(z0 z0Var) {
        this.d = z0Var;
    }

    public void d(String str) {
        this.g = str;
    }

    public z0 e() {
        return this.c;
    }

    public void e(String str) {
        this.k = str;
    }

    public String f() {
        return this.k;
    }

    public void f(String str) {
        this.i = str;
    }

    public String g() {
        return this.i;
    }

    public synchronized boolean g(String str) {
        boolean z;
        z0 z0Var;
        j2.a("HiAnalyticsInstData", "setInstanceUUID haTag=" + this.f + ",instanceUUID=" + SystemUtils.a(str));
        z0 z0Var2 = this.f3629a;
        boolean z2 = z0Var2 != null && z0Var2.e(str);
        z0 z0Var3 = this.b;
        boolean z3 = z2 | (z0Var3 != null && z0Var3.e(str));
        z0 z0Var4 = this.c;
        z = z3 | (z0Var4 != null && z0Var4.e(str));
        z0Var = this.d;
        return z | (z0Var != null && z0Var.e(str));
    }

    public z0 h() {
        return this.b;
    }

    public void h(String str) {
        this.l = str;
    }

    public z0 i() {
        return this.f3629a;
    }

    public z0 j() {
        return this.d;
    }

    public String k() {
        return this.l;
    }
}
