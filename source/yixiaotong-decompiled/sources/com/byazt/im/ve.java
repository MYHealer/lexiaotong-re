package com.byazt.im;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, 1352, 54})
public class ve extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f2343a;
    public com.byazt.dj.tt da;
    public int i;
    public a n;
    public boolean sl;
    public String sp;
    public boolean t;
    public x uj;
    public int x = 1;

    public String a() {
        return this.sp;
    }

    public boolean da() {
        return this.t;
    }

    public Context getContext() {
        return this.f2343a;
    }

    public boolean i() {
        return this.sl;
    }

    public x n() {
        return this.uj;
    }

    public com.byazt.dj.tt sp() {
        return this.da;
    }

    public a uj() {
        return this.n;
    }

    public int x() {
        return this.i;
    }

    public ve(Context context, String str, a aVar, x xVar, com.byazt.dj.tt ttVar, boolean z) {
        this.f2343a = context;
        this.sp = str;
        this.n = aVar;
        this.sl = aVar.n();
        this.tt = aVar.tt();
        this.uj = xVar;
        this.da = ttVar;
        this.t = z;
    }
}
