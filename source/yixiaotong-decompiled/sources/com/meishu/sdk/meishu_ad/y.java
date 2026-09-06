package com.meishu.sdk.meishu_ad;

import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.meishu_ad.splash.SplashSkipView;
import com.meishu.sdk.platform.ms.splash.ShakeResult;
import com.meishu.sdk.platform.ms.splash.ShakeUtil;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class y implements com.meishu.sdk.platform.ms.splash.g.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean[] f5153a;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c b;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.a c;
    public final /* synthetic */ SplashSkipView d;
    public final /* synthetic */ v e;

    /* JADX INFO: compiled from: AdNative.java */
    public class a implements ShakeUtil.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f5154a;

        public a(long j) {
            this.f5154a = j;
        }

        @Override // com.meishu.sdk.platform.ms.splash.ShakeUtil.c
        public void onShake(int i, boolean z, int i2, ShakeResult shakeResult) {
            ShakeUtil.getInstance().a(y.this.e.b);
            if (y.this.b.getInteractionListener() != null && y.this.b.b.getCbc() == 0) {
                y.this.b.getInteractionListener().onAdClicked();
            }
            com.meishu.sdk.meishu_ad.splash.a aVar = y.this.c;
            if (aVar != null) {
                ((com.meishu.sdk.platform.ms.splash.g) aVar).h = true;
            }
            if (shakeResult != null) {
                shakeResult.setTotalTurnTime(System.currentTimeMillis() - this.f5154a);
            }
            com.meishu.sdk.meishu_ad.splash.d dVar = y.this.b.b;
            dVar.setClkActType(i);
            dVar.setDynamic(z);
            dVar.setClkPower(i2);
            dVar.setShakeResult(shakeResult);
            com.meishu.sdk.core.utils.f.a(y.this.b, i2 >= 50);
            y yVar = y.this;
            v.a(yVar.e, yVar.d);
        }
    }

    public y(v vVar, boolean[] zArr, com.meishu.sdk.meishu_ad.splash.c cVar, com.meishu.sdk.meishu_ad.splash.a aVar, SplashSkipView splashSkipView) {
        this.e = vVar;
        this.f5153a = zArr;
        this.b = cVar;
        this.c = aVar;
        this.d = splashSkipView;
    }

    public void a() {
        boolean[] zArr = this.f5153a;
        if (zArr[0]) {
            return;
        }
        zArr[0] = true;
        com.meishu.sdk.meishu_ad.splash.c cVar = this.b;
        if (cVar != null) {
            try {
                com.meishu.sdk.core.utils.v vVar = new com.meishu.sdk.core.utils.v();
                com.meishu.sdk.meishu_ad.splash.f fVar = new com.meishu.sdk.meishu_ad.splash.f(cVar, vVar);
                cVar.e.addOnAttachStateChangeListener(new com.meishu.sdk.meishu_ad.splash.g(fVar, vVar));
                try {
                    if (AdSdk.adConfig() != null && AdSdk.adConfig().enableInstallBroadcast()) {
                        AdSdk.getContext().registerReceiver(vVar.b, vVar.f4951a);
                        vVar.e = true;
                    }
                } catch (Throwable th) {
                    LogUtil.dev("HW", th);
                }
                com.meishu.sdk.core.service.d.a(fVar);
            } catch (Exception unused) {
            }
        }
        if (com.meishu.sdk.core.utils.h.e(this.b.b.getAct_type()) || com.meishu.sdk.core.utils.h.d(this.b.b.getAct_type())) {
            com.meishu.sdk.meishu_ad.splash.d dVar = this.b.b;
            int i = dVar.F;
            int power_index2 = dVar.getPower_index2();
            this.b.b.getClass();
            if (ShakeUtil.getInstance().indexLocal != 0 && AdSdk.adConfig().isTest()) {
                i = ShakeUtil.getInstance().indexLocal;
            }
            int i2 = i;
            v vVar2 = this.e;
            if (vVar2.b == 0) {
                vVar2.b = ShakeUtil.getInstance().b();
            }
            int iB = com.meishu.sdk.core.utils.h.b(this.b.b.getAct_type());
            long jCurrentTimeMillis = System.currentTimeMillis();
            ShakeUtil.getInstance().a(this.b.b.getPosId(), this.b.b.getLoadedTime(), this.b.b.getDclk());
            ShakeUtil.getInstance().a(power_index2, i2, iB, this.b.b.getPower_delay(), this.b.b.getPower_count(), this.e.b, this.b.b.getEcpm(), new a(jCurrentTimeMillis));
            if (com.meishu.sdk.core.utils.h.c(this.b.b.getAct_type())) {
                ShakeUtil.getInstance().a(true);
                ShakeUtil.getInstance().f();
            }
        }
    }
}
