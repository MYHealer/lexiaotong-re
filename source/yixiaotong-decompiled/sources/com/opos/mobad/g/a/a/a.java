package com.opos.mobad.g.a.a;

import android.os.SystemClock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.service.h.d f6918a = new com.opos.mobad.service.h.d();
    private String b;
    private String c;
    private String d;
    private volatile long e;
    private long f;

    public a(String str, long j) {
        this.b = str;
        this.f = j;
        this.f = j;
    }

    public void a() {
        a("t", 0);
    }

    public void a(int i) {
        a(this.b, this.f, this.c, i, SystemClock.elapsedRealtime() - this.e, this.f6918a.b(), this.d);
        this.c = null;
        this.d = null;
        this.f6918a = new com.opos.mobad.service.h.d();
    }

    public void a(int i, int i2) {
        a(String.valueOf(i), i2);
    }

    protected final void a(String str, int i) {
        if (this.f6918a.a() >= 1024) {
            com.opos.cmn.an.f.a.b("", "illegal append report");
        } else {
            this.f6918a.a(str, String.valueOf(i));
        }
    }

    protected abstract void a(String str, long j, String str2, int i, long j2, String str3, String str4);

    public void a(String str, String str2) {
        this.c = str;
        this.d = str2;
        this.e = SystemClock.elapsedRealtime();
    }

    public void b() {
        a("t", 2);
    }

    public void b(int i) {
        b(this.b, this.f, this.c, i, SystemClock.elapsedRealtime() - this.e, this.f6918a.b(), this.d);
        this.c = null;
        this.d = null;
        this.f6918a = new com.opos.mobad.service.h.d();
    }

    protected abstract void b(String str, long j, String str2, int i, long j2, String str3, String str4);

    public void c(int i) {
        if (i != 1035) {
            b(i);
        } else {
            com.opos.mobad.c.b.j().a(this.b);
            this.f6918a = new com.opos.mobad.service.h.d();
        }
    }
}
