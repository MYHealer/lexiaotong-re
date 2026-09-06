package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class x5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y5 f1515a;

    public x5(y5 y5Var) {
        this.f1515a = y5Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        long currentPositionWhenPlaying = this.f1515a.f1531a.getCurrentPositionWhenPlaying();
        long duration = this.f1515a.f1531a.getDuration();
        fp fpVar = this.f1515a.f1531a.f898a;
        if (fpVar != null) {
            fpVar.a(currentPositionWhenPlaying, duration);
        }
    }
}
