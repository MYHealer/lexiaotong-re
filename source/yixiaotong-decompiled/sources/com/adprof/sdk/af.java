package com.adprof.sdk;

import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.NativeAdLoadListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class af extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdError f1032a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ df f17a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ boolean f18a;

    public af(df dfVar, boolean z, AdError adError) {
        this.f17a = dfVar;
        this.f18a = z;
        this.f1032a = adError;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        NativeAdLoadListener nativeAdLoadListener = this.f17a.f214a;
        if (nativeAdLoadListener != null) {
            if (this.f18a) {
                nativeAdLoadListener.onAdError(this.f1032a);
            }
            this.f17a.a();
        }
    }
}
