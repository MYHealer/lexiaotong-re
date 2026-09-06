package com.meishu.sdk.meishu_ad;

import android.view.View;
import com.meishu.sdk.meishu_ad.splash.SplashSkipView;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends com.meishu.sdk.core.safe.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c f5001a;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.a b;
    public final /* synthetic */ SplashSkipView c;
    public final /* synthetic */ v d;

    public b(v vVar, com.meishu.sdk.meishu_ad.splash.c cVar, com.meishu.sdk.meishu_ad.splash.a aVar, SplashSkipView splashSkipView) {
        this.d = vVar;
        this.f5001a = cVar;
        this.b = aVar;
        this.c = splashSkipView;
    }

    @Override // com.meishu.sdk.core.safe.o
    public void safeOnClick(View view) {
        if (this.f5001a.getInteractionListener() != null && this.f5001a.b.getCbc() == 0) {
            this.f5001a.getInteractionListener().onAdClicked();
        }
        com.meishu.sdk.meishu_ad.splash.a aVar = this.b;
        if (aVar != null) {
            ((com.meishu.sdk.platform.ms.splash.g) aVar).h = true;
        }
        this.f5001a.b.setClkActType(2);
        com.meishu.sdk.core.utils.f.a((com.meishu.sdk.platform.ms.c) this.f5001a, true);
        v.a(this.d, this.c);
    }
}
