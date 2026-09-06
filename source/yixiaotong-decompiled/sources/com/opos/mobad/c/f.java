package com.opos.mobad.c;

import android.os.SystemClock;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile e f6745a;
    private volatile String c;
    private volatile com.opos.mobad.service.e.d.c d;
    private volatile String b = "";
    private volatile String e = "";
    private volatile int f = 0;
    private volatile int g = 0;
    private volatile int h = 0;

    private boolean a(e eVar) {
        return eVar != null;
    }

    public void a(e eVar, String str, com.opos.mobad.service.e.d.c cVar, int i, int i2, int i3) {
        this.f6745a = eVar;
        this.c = str;
        this.d = cVar;
        this.f = i;
        this.g = i2;
        this.h = i3;
    }

    public boolean a() {
        return a(this.f6745a);
    }

    public String b() {
        e eVar = this.f6745a;
        return !a(eVar) ? "" : eVar.b;
    }

    public String c() {
        e eVar = this.f6745a;
        return !a(eVar) ? "" : eVar.c;
    }

    public int d() {
        e eVar = this.f6745a;
        if (a(eVar)) {
            return eVar.d;
        }
        return -1;
    }

    public String e() {
        e eVar = this.f6745a;
        return !a(eVar) ? "" : eVar.e;
    }

    public boolean f() {
        e eVar = this.f6745a;
        if (a(eVar)) {
            return eVar.h;
        }
        return false;
    }

    public String g() {
        e eVar = this.f6745a;
        String str = a(eVar) ? eVar.m : "";
        com.opos.cmn.an.f.a.b("InfoProvider", "getEnterSource()=", str);
        return str;
    }

    public String h() {
        return this.b;
    }

    public String i() {
        return this.c;
    }

    public String j() {
        com.opos.mobad.service.e.d.c cVar = this.d;
        if (this.d == null) {
            return "";
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.e = cVar.a();
        if (TextUtils.isEmpty(this.e) || (!"ADULT".equals(this.e) && !"CHILD".equals(this.e) && !"TEEN".equals(this.e))) {
            this.e = "UNKNOWN";
        }
        com.opos.cmn.an.f.a.b("InfoProvider", "getClassifyByAgeProvider() mAgeGrading=", this.e, ", time=", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        return this.e;
    }

    public String k() {
        if (this.d == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.e)) {
            j();
        }
        return this.e;
    }

    public int l() {
        return this.f;
    }

    public int m() {
        return this.g;
    }

    public int n() {
        return this.h;
    }

    public void o() {
        this.f6745a = null;
        this.c = "";
        this.b = "";
        this.d = null;
        this.e = "";
        this.f = 0;
        this.g = 0;
        this.h = 0;
    }
}
