package com.adprof.sdk;

import com.adprof.sdk.api.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class o5 extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p5 f1337a;

    public o5(p5 p5Var) {
        this.f1337a = p5Var;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        if (isCancelled()) {
            return;
        }
        this.f1337a.a(AdError.ERROR_AD_LOAD_TIMEOUT);
    }
}
