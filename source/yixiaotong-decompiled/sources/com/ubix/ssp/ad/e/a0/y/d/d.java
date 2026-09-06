package com.ubix.ssp.ad.e.a0.y.d;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f8738a;
    private long h;
    private long i;
    private a j;
    private String b = "";
    private String c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private boolean k = false;

    private d() {
    }

    public static d e() {
        if (f8738a == null) {
            f8738a = new d();
        }
        return f8738a;
    }

    public void a() {
        this.g = "";
        this.f = "";
        this.e = "";
        this.d = "";
        this.c = "";
        this.b = "";
        this.j = null;
        this.k = false;
        this.i = 0L;
        this.h = 0L;
    }

    public void a(long j) {
        this.i = j;
    }

    public void a(a aVar) {
        this.j = aVar;
    }

    public void a(String str) {
        this.g = str;
    }

    public void a(String str, String str2, String str3) {
        this.b = str;
        this.e = str2;
        this.c = str3;
        this.h = System.currentTimeMillis();
    }

    public void a(boolean z) {
        this.k = z;
    }

    public a b() {
        return this.j;
    }

    public void b(String str) {
        this.f = str;
    }

    public long c() {
        return this.h;
    }

    public void c(String str) {
        this.d = str;
    }

    public String d() {
        return this.e;
    }

    public long f() {
        return this.i;
    }

    public String g() {
        return this.c;
    }

    public String h() {
        return this.b;
    }

    public String i() {
        return this.g;
    }

    public String j() {
        return this.f;
    }

    public String k() {
        return this.d;
    }

    public boolean l() {
        return this.k;
    }

    public boolean m() {
        return TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.c) && TextUtils.isEmpty(this.d) && TextUtils.isEmpty(this.e);
    }
}
