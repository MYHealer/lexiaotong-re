package com.meishu.sdk.meishu_ad;

import android.view.View;
import com.meishu.sdk.meishu_ad.splash.SplashSkipView;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class w extends com.meishu.sdk.core.safe.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c f5151a;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.a b;
    public final /* synthetic */ SplashSkipView c;
    public final /* synthetic */ v d;

    public w(v vVar, com.meishu.sdk.meishu_ad.splash.c cVar, com.meishu.sdk.meishu_ad.splash.a aVar, SplashSkipView splashSkipView) {
        this.d = vVar;
        this.f5151a = cVar;
        this.b = aVar;
        this.c = splashSkipView;
    }

    @Override // com.meishu.sdk.core.safe.o
    public void safeOnClick(View view) {
        if (this.f5151a.getInteractionListener() != null && this.f5151a.b.getCbc() == 0) {
            this.f5151a.getInteractionListener().onAdClicked();
        }
        com.meishu.sdk.meishu_ad.splash.a aVar = this.b;
        if (aVar != null) {
            ((com.meishu.sdk.platform.ms.splash.g) aVar).h = true;
        }
        this.f5151a.b.setClkActType(1);
        com.meishu.sdk.core.utils.f.a((com.meishu.sdk.platform.ms.c) this.f5151a, false);
        v.a(this.d, this.c);
    }
}
