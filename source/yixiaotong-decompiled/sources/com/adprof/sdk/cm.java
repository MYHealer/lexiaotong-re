package com.adprof.sdk;

import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.SplashAdListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class cm extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdError f1116a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ hm f177a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ boolean f178a;

    public cm(hm hmVar, boolean z, AdError adError) {
        this.f177a = hmVar;
        this.f178a = z;
        this.f1116a = adError;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        SplashAdListener splashAdListener = this.f177a.f365a;
        if (splashAdListener != null) {
            if (this.f178a) {
                splashAdListener.onSplashAdLoadFail(this.f1116a);
            } else {
                splashAdListener.onSplashAdShowError(this.f1116a);
            }
            this.f177a.b();
        }
    }
}
