package com.adprof.sdk;

import com.adprof.sdk.api.SplashAdListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class dm extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hm f1134a;

    public dm(hm hmVar) {
        this.f1134a = hmVar;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        h2 h2Var;
        SplashAdListener splashAdListener = this.f1134a.f365a;
        if (splashAdListener != null) {
            splashAdListener.onAdLoadSuccess();
        }
        synchronized (h2.class) {
            if (h2.f1202a == null) {
                h2.f1202a = new h2();
            }
            h2Var = h2.f1202a;
        }
        hm hmVar = this.f1134a;
        h2Var.a(((p5) hmVar).f546a, hmVar);
    }
}
