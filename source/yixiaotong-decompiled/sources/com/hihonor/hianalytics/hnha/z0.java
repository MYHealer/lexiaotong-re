package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class z0 implements Comparator<z0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private y0 f3699a;
    private boolean b;
    private String c;
    private String d;
    private String e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private Map<String, String> j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private long q;

    public z0() {
        this.f3699a = new y0();
        this.f = 10;
        this.g = 7;
        this.i = false;
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.q = 0L;
    }

    public z0(z0 z0Var) {
        this.f3699a = new y0();
        this.f = 10;
        this.g = 7;
        this.i = false;
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.q = 0L;
        this.f3699a = z0Var.f3699a;
        a(z0Var.b);
        b(z0Var.c);
        c(z0Var.d);
        g(z0Var.l);
        d(z0Var.n);
        i(z0Var.m);
        f(z0Var.o);
        h(z0Var.k);
        b(z0Var.h);
        b(z0Var.f);
        a(z0Var.g);
        c(z0Var.i);
        a(z0Var.j);
        a(z0Var.q);
        a(z0Var.e);
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(z0 z0Var, z0 z0Var2) {
        if (z0Var == z0Var2) {
            return 0;
        }
        if (z0Var == null) {
            return -1;
        }
        if (z0Var2 == null) {
            return 1;
        }
        boolean zP = z0Var.p();
        boolean zP2 = z0Var2.p();
        if (zP && !zP2) {
            return 1;
        }
        if (!zP && zP2) {
            return -1;
        }
        y0 y0Var = z0Var.f3699a;
        boolean z = y0Var != null && y0Var.f();
        y0 y0Var2 = z0Var2.f3699a;
        boolean z2 = y0Var2 != null && y0Var2.f();
        if (z && !z2) {
            return 1;
        }
        if (!z && z2) {
            return -1;
        }
        boolean zO = z0Var.o();
        boolean zO2 = z0Var2.o();
        if (!zO || zO2) {
            return (zO || !zO2) ? 0 : -1;
        }
        return 1;
    }

    public String a() {
        return this.e;
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(long j) {
        this.q = j;
    }

    public void a(String str) {
        this.e = str;
    }

    public void a(Map<String, String> map) {
        this.j = map;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public int b() {
        return this.g;
    }

    public void b(int i) {
        this.f = i;
    }

    public void b(String str) {
        this.c = str;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.d = str;
    }

    public void c(boolean z) {
        this.i = z;
    }

    public String d() {
        return this.d;
    }

    public synchronized boolean d(String str) {
        if (Objects.equals(this.n, str)) {
            return false;
        }
        this.n = str;
        return true;
    }

    public y0 e() {
        return this.f3699a;
    }

    public synchronized boolean e(String str) {
        if (Objects.equals(str, this.p)) {
            return false;
        }
        this.p = str;
        return true;
    }

    public String f() {
        return this.n;
    }

    public void f(String str) {
        this.o = str;
    }

    public int g() {
        if (!p()) {
            return -1;
        }
        y0 y0Var = this.f3699a;
        int iB = y0Var == null ? 0 : y0Var.b();
        if (this.i) {
            iB++;
        }
        if (!TextUtils.isEmpty(this.e)) {
            iB++;
        }
        if (!TextUtils.isEmpty(this.l)) {
            iB++;
        }
        if (!TextUtils.isEmpty(this.n)) {
            iB++;
        }
        return !TextUtils.isEmpty(this.k) ? iB + 1 : iB;
    }

    public synchronized boolean g(String str) {
        if (Objects.equals(str, this.l)) {
            return false;
        }
        this.l = str;
        return true;
    }

    public String h() {
        return this.p;
    }

    public synchronized boolean h(String str) {
        if (Objects.equals(str, this.k)) {
            return false;
        }
        this.k = str;
        return true;
    }

    public long i() {
        return this.q;
    }

    public synchronized boolean i(String str) {
        if (Objects.equals(this.m, str)) {
            return false;
        }
        this.m = str;
        return true;
    }

    public int j() {
        return this.f;
    }

    public String k() {
        return this.o;
    }

    public String l() {
        return this.l;
    }

    public String m() {
        return this.k;
    }

    public String n() {
        return this.m;
    }

    public boolean o() {
        y0 y0Var = this.f3699a;
        return (y0Var != null && y0Var.f()) || !((!this.i || TextUtils.isEmpty(this.p)) && TextUtils.isEmpty(this.e) && TextUtils.isEmpty(this.k) && TextUtils.isEmpty(this.l) && TextUtils.isEmpty(this.n));
    }

    public boolean p() {
        String str = this.d;
        return (str == null || str.isEmpty()) ? false : true;
    }

    public boolean q() {
        return this.b;
    }

    public boolean r() {
        return this.h;
    }

    public boolean s() {
        return this.i;
    }
}
