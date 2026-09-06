package com.adprof.sdk;

import android.view.View;
import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.NativeAdData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class w implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NativeAdData.NativeAdMediaListener f1488a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ f0 f786a;

    public w(f0 f0Var, NativeAdData.NativeAdMediaListener nativeAdMediaListener) {
        this.f786a = f0Var;
        this.f1488a = nativeAdMediaListener;
    }

    @Override // com.adprof.sdk.e
    public void onProgressUpdate(long j, long j2) {
        i3.f1222a.a(this.f786a.f277a.f188a, j);
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoCompleted() {
        pk.a("NativeAdRender invoke onVideoCompleted: " + this.f1488a);
        NativeAdData.NativeAdMediaListener nativeAdMediaListener = this.f1488a;
        if (nativeAdMediaListener != null) {
            nativeAdMediaListener.onVideoCompleted();
        }
        if (this.f786a.m618a() != null) {
            this.f786a.m618a().a(this.f786a.f277a, "video_play_end");
        }
        this.f786a.b = false;
        this.f786a.e = true;
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoError(AdError adError) {
        this.f786a.b = false;
        pk.a("NativeAdRender invoke onVideoError: " + this.f1488a + " error = " + adError);
        NativeAdData.NativeAdMediaListener nativeAdMediaListener = this.f1488a;
        if (nativeAdMediaListener != null) {
            nativeAdMediaListener.onVideoError(adError);
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoLoad() {
        if (this.f786a.e) {
            return;
        }
        pk.a("NativeAdRender invoke onVideoLoad: " + this.f1488a);
        NativeAdData.NativeAdMediaListener nativeAdMediaListener = this.f1488a;
        if (nativeAdMediaListener != null) {
            nativeAdMediaListener.onVideoLoad();
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoPause() {
        pk.a("NativeAdRender invoke onVideoPause: " + this.f1488a);
        NativeAdData.NativeAdMediaListener nativeAdMediaListener = this.f1488a;
        if (nativeAdMediaListener != null) {
            nativeAdMediaListener.onVideoPause();
        }
    }

    @Override // com.adprof.sdk.e
    public void onVideoRestart() {
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoResume() {
        pk.a("NativeAdRender invoke onVideoResume: " + this.f1488a);
        NativeAdData.NativeAdMediaListener nativeAdMediaListener = this.f1488a;
        if (nativeAdMediaListener != null) {
            nativeAdMediaListener.onVideoResume();
        }
        this.f786a.b = false;
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoStart() {
        f0 f0Var = this.f786a;
        if (f0Var.e) {
            return;
        }
        View viewA = f0Var.a();
        if (viewA != null) {
            this.f786a.f277a.a(viewA.getWidth(), viewA.getHeight());
        }
        pk.a("NativeAdRender invoke onVideoStart: " + this.f1488a);
        NativeAdData.NativeAdMediaListener nativeAdMediaListener = this.f1488a;
        if (nativeAdMediaListener != null) {
            nativeAdMediaListener.onVideoStart();
        }
        this.f786a.b = false;
        if (this.f786a.m618a() != null) {
            this.f786a.m618a().a(this.f786a.f277a, "video_play_start");
        }
    }
}
