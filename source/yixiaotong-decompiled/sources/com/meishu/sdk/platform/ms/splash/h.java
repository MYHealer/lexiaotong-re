package com.meishu.sdk.platform.ms.splash;

import com.meishu.sdk.core.safe.l;

/* JADX INFO: compiled from: SplashAdListenerAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class h extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f5249a;

    public h(g gVar) {
        this.f5249a = gVar;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        try {
            g gVar = this.f5249a;
            com.meishu.sdk.core.ad.splash.d dVar = gVar.b;
            if (dVar != null) {
                dVar.onAdSkip(gVar.d);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
