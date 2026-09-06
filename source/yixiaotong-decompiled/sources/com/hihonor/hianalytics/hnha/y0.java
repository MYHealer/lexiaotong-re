package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3697a;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private boolean g;
    private String h;

    public String a() {
        return this.h;
    }

    public void a(String str) {
        this.h = str;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public int b() {
        int i = !TextUtils.isEmpty(this.f) ? 100 : 0;
        if (!TextUtils.isEmpty(this.b)) {
            i += 100;
        }
        if (!TextUtils.isEmpty(this.d)) {
            i += 100;
        }
        if (!TextUtils.isEmpty(this.h)) {
            i += 100;
        }
        if (this.e) {
            i += 10;
        }
        if (this.f3697a) {
            i += 10;
        }
        if (this.c) {
            i += 10;
        }
        return this.g ? i + 10 : i;
    }

    public void b(String str) {
        this.b = str;
    }

    public void b(boolean z) {
        this.f3697a = z;
    }

    public String c() {
        return this.b;
    }

    public void c(String str) {
        this.f = str;
    }

    public void c(boolean z) {
        this.c = z;
    }

    public String d() {
        return this.f;
    }

    public void d(String str) {
        this.d = str;
    }

    public void d(boolean z) {
        this.e = z;
    }

    public String e() {
        return this.d;
    }

    public boolean f() {
        return (this.e && !TextUtils.isEmpty(this.f)) || (this.f3697a && !TextUtils.isEmpty(this.b)) || ((this.c && !TextUtils.isEmpty(this.d)) || (this.g && !TextUtils.isEmpty(this.h)));
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.f3697a;
    }

    public boolean i() {
        return this.c;
    }

    public boolean j() {
        return this.e;
    }
}
