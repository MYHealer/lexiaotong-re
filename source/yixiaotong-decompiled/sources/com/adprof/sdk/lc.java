package com.adprof.sdk;

import com.adprof.sdk.api.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class lc extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdError f1284a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ pc f441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ boolean f442a;

    public lc(pc pcVar, boolean z, AdError adError) {
        this.f441a = pcVar;
        this.f442a = z;
        this.f1284a = adError;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        ho hoVar;
        if (this.f441a.m702a()) {
            if (this.f442a) {
                this.f441a.f1363a.onInterstitialAdLoadError(this.f1284a);
            } else {
                this.f441a.f1363a.onInterstitialAdShowError(this.f1284a);
            }
        }
        if (this.f441a.m703b()) {
            if (this.f442a) {
                this.f441a.f571a.onRewardAdLoadError(this.f1284a);
            } else {
                this.f441a.f571a.onRewardAdShowError(this.f1284a);
            }
        }
        try {
            jo joVar = this.f441a.f572a;
            if (joVar != null && (hoVar = joVar.f406a) != null) {
                hoVar.b();
                joVar.f406a = null;
            }
            this.f441a.a();
        } catch (Throwable unused) {
        }
    }
}
