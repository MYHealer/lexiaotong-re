package com.meishu.sdk.meishu_ad;

import com.meishu.sdk.meishu_ad.splash.MeishuSplashRootView;
import com.meishu.sdk.meishu_ad.splash.SplashSkipView;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class k0 extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c f5031a;
    public final /* synthetic */ MeishuSplashRootView b;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.a c;
    public final /* synthetic */ SplashSkipView d;
    public final /* synthetic */ v e;

    public k0(v vVar, com.meishu.sdk.meishu_ad.splash.c cVar, MeishuSplashRootView meishuSplashRootView, com.meishu.sdk.meishu_ad.splash.a aVar, SplashSkipView splashSkipView) {
        this.e = vVar;
        this.f5031a = cVar;
        this.b = meishuSplashRootView;
        this.c = aVar;
        this.d = splashSkipView;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        v.a(this.e, this.f5031a, this.b, this.c, this.d);
    }
}
