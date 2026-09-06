package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class nc extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pc f1322a;

    public nc(pc pcVar) {
        this.f1322a = pcVar;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        if (this.f1322a.m702a()) {
            this.f1322a.f1363a.onInterstitialAdLoadCached();
        }
        if (this.f1322a.m703b()) {
            this.f1322a.f571a.onRewardAdLoadCached();
        }
    }
}
