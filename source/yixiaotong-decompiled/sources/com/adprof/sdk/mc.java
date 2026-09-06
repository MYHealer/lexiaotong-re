package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class mc extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pc f1305a;

    public mc(pc pcVar) {
        this.f1305a = pcVar;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        h2 h2Var;
        if (this.f1305a.m702a()) {
            this.f1305a.f1363a.onInterstitialAdLoadSuccess();
        }
        if (this.f1305a.m703b()) {
            this.f1305a.f571a.onRewardAdLoadSuccess();
        }
        synchronized (h2.class) {
            if (h2.f1202a == null) {
                h2.f1202a = new h2();
            }
            h2Var = h2.f1202a;
        }
        pc pcVar = this.f1305a;
        h2Var.a(((p5) pcVar).f546a, pcVar);
    }
}
