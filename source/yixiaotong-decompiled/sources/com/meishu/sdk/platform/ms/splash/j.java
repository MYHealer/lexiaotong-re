package com.meishu.sdk.platform.ms.splash;

import com.meishu.sdk.core.safe.l;

/* JADX INFO: compiled from: SplashAdListenerAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class j extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f5251a;
    public final /* synthetic */ g b;

    public j(g gVar, long j) {
        this.b = gVar;
        this.f5251a = j;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        com.meishu.sdk.core.ad.splash.d dVar = this.b.b;
        if (dVar != null) {
            dVar.onAdTick(this.f5251a);
        }
    }
}
