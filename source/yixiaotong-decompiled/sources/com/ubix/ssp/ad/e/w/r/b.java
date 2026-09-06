package com.ubix.ssp.ad.e.w.r;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8917a;

    public b(String str, int i) {
        super(str);
        this.f8917a = i;
    }

    public b(Throwable th, int i) {
        super(th);
        this.f8917a = i;
    }

    public int a() {
        return this.f8917a;
    }
}
