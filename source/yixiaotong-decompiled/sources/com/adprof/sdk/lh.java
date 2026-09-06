package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class lh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ lh f1288a;

    public lh(mh mhVar, lh lhVar) {
        this.f1288a = lhVar;
    }

    public void a() {
        lh lhVar = this.f1288a;
        if (lhVar != null) {
            lhVar.a();
        }
    }

    public void a(Throwable th) {
        lh lhVar = this.f1288a;
        if (lhVar != null) {
            lhVar.a(th);
        }
        pk.b("MTA failed cb: " + th.getMessage());
    }
}
