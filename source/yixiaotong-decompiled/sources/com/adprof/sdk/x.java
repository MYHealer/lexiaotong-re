package com.adprof.sdk;

import android.view.View;
import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.NativeAdData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class x implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f1510a;

    public x(f0 f0Var) {
        this.f1510a = f0Var;
    }

    @Override // com.adprof.sdk.e
    public void onProgressUpdate(long j, long j2) {
        i3.f1222a.a(this.f1510a.f277a.f188a, j);
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoCompleted() {
        NativeAdData.NativeAdMediaListener nativeAdMediaListener = this.f1510a.f273a;
        pk.a("NativeAdRender invoke onVideoCompleted: " + nativeAdMediaListener);
        if (nativeAdMediaListener != null) {
            nativeAdMediaListener.onVideoCompleted();
        }
        if (this.f1510a.m618a() != null) {
            this.f1510a.m618a().a(this.f1510a.f277a, "video_play_end");
        }
        this.f1510a.b = false;
        this.f1510a.e = true;
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoError(AdError adError) {
        this.f1510a.b = false;
        NativeAdData.NativeAdMediaListener nativeAdMediaListener = this.f1510a.f273a;
        pk.a("NativeAdRender invoke onVideoError: " + nativeAdMediaListener + " error = " + adError);
        if (nativeAdMediaListener != null) {
            nativeAdMediaListener.onVideoError(adError);
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoLoad() {
        f0 f0Var = this.f1510a;
        if (f0Var.e) {
            return;
        }
        NativeAdData.NativeAdMediaListener nativeAdMediaListener = f0Var.f273a;
        pk.a("NativeAdRender invoke onVideoLoad: " + nativeAdMediaListener);
        if (nativeAdMediaListener != null) {
            nativeAdMediaListener.onVideoLoad();
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoPause() {
        NativeAdData.NativeAdMediaListener nativeAdMediaListener = this.f1510a.f273a;
        pk.a("NativeAdRender invoke onVideoPause: " + nativeAdMediaListener);
        if (nativeAdMediaListener != null) {
            nativeAdMediaListener.onVideoPause();
        }
    }

    @Override // com.adprof.sdk.e
    public void onVideoRestart() {
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoResume() {
        NativeAdData.NativeAdMediaListener nativeAdMediaListener = this.f1510a.f273a;
        pk.a("NativeAdRender invoke onVideoResume: " + nativeAdMediaListener);
        if (nativeAdMediaListener != null) {
            nativeAdMediaListener.onVideoResume();
        }
        this.f1510a.b = false;
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoStart() {
        f0 f0Var = this.f1510a;
        if (f0Var.e) {
            return;
        }
        View viewA = f0Var.a();
        if (viewA != null) {
            this.f1510a.f277a.a(viewA.getWidth(), viewA.getHeight());
        }
        NativeAdData.NativeAdMediaListener nativeAdMediaListener = this.f1510a.f273a;
        pk.a("NativeAdRender invoke onVideoStart: " + nativeAdMediaListener);
        if (nativeAdMediaListener != null) {
            nativeAdMediaListener.onVideoStart();
        }
        this.f1510a.b = false;
        if (this.f1510a.m618a() != null) {
            this.f1510a.m618a().a(this.f1510a.f277a, "video_play_start");
        }
    }
}
