package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class z9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ eb f1552a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ mg f908a;

    public z9(aa aaVar, eb ebVar, mg mgVar) {
        this.f1552a = ebVar;
        this.f908a = mgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1552a.a(this.f908a);
    }
}
