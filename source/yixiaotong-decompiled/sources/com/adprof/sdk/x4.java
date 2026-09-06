package com.adprof.sdk;

import com.adprof.sdk.api.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class x4 implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g5 f1514a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ po f827a;

    public x4(g5 g5Var, po poVar) {
        this.f1514a = g5Var;
        this.f827a = poVar;
    }

    @Override // com.adprof.sdk.e
    public void onProgressUpdate(long j, long j2) {
        d dVar;
        g5 g5Var = this.f1514a;
        if (g5Var.f1185a <= 0 || (dVar = g5Var.f304a) == null) {
            return;
        }
        i3.f1222a.a(dVar.f188a, j);
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoCompleted() {
        d dVar = this.f1514a.f304a;
        kl klVar = dVar.f185a;
        if (klVar != null) {
            klVar.a(dVar, "video_play_end");
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoError(AdError adError) {
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoLoad() {
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoPause() {
    }

    @Override // com.adprof.sdk.e
    public void onVideoRestart() {
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoResume() {
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoStart() {
        this.f1514a.f1185a = (int) this.f827a.getDuration();
        d dVar = this.f1514a.f304a;
        kl klVar = dVar.f185a;
        if (klVar != null) {
            klVar.a(dVar, "video_play_start");
        }
    }
}
