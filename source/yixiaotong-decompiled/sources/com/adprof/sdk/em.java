package com.adprof.sdk;

import com.adprof.sdk.api.SplashAdListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class em extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hm f1155a;

    public em(hm hmVar) {
        this.f1155a = hmVar;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        SplashAdListener splashAdListener = this.f1155a.f365a;
        if (splashAdListener != null) {
            splashAdListener.onAdCacheSuccess();
        }
    }
}
