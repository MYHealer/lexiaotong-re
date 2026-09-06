package com.meishu.sdk.platform.ms.splash;

import com.meishu.sdk.core.safe.l;

/* JADX INFO: compiled from: SplashAdListenerAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class i extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f5250a;

    public i(g gVar) {
        this.f5250a = gVar;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        try {
            g gVar = this.f5250a;
            com.meishu.sdk.core.ad.splash.d dVar = gVar.b;
            if (dVar != null) {
                dVar.onAdTimeOver(gVar.d);
            }
            if (this.f5250a.d.getSplashFinishingTouchListener() != null) {
                g gVar2 = this.f5250a;
                if (gVar2.h) {
                    gVar2.d.getSplashFinishingTouchListener().a(false);
                } else if (gVar2.c != null) {
                    gVar2.d.getSplashFinishingTouchListener().a(((com.meishu.sdk.meishu_ad.splash.d) this.f5250a.c.f5177a).H == 1);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
