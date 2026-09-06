package com.adprof.sdk;

import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.BannerAdListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class h4 extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdError f1204a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n4 f331a;

    public h4(n4 n4Var, AdError adError) {
        this.f331a = n4Var;
        this.f1204a = adError;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        BannerAdListener bannerAdListener = this.f331a.f499a;
        if (bannerAdListener != null) {
            bannerAdListener.onBannerAdLoadError(this.f1204a);
        }
    }
}
