package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f1528a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ boolean f848a;

    public y(f0 f0Var, boolean z) {
        this.f1528a = f0Var;
        this.f848a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1528a.f270a.setVisibility(this.f848a ? 0 : 8);
    }
}
