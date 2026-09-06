package com.adprof.sdk;

import android.content.Context;
import com.adprof.sdk.api.NativeAdData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class h0 extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g0 f1200a;

    public h0(Context context) {
        super(context);
    }

    public xe getAdConfig() {
        g0 g0Var = this.f1200a;
        if (g0Var != null) {
            return ((f0) g0Var).m619a();
        }
        return null;
    }

    public d getAdUnit() {
        g0 g0Var = this.f1200a;
        if (g0Var != null) {
            return ((f0) g0Var).f277a;
        }
        return null;
    }

    public NativeAdData getNativeAdUnit() {
        g0 g0Var = this.f1200a;
        if (g0Var != null) {
            return ((f0) g0Var).f274a;
        }
        return null;
    }

    public double getVideoDuration() {
        return 0.0d;
    }

    public double getVideoProgress() {
        return 0.0d;
    }

    public void setUIStyle(b bVar) {
        super.f1159a = bVar;
    }
}
