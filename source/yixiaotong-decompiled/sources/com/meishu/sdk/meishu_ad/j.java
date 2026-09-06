package com.meishu.sdk.meishu_ad;

import com.meishu.sdk.core.view.SwipeView;
import com.meishu.sdk.meishu_ad.splash.SplashSkipView;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class j implements SwipeView.OnSwipeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.a f5028a;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c b;
    public final /* synthetic */ SplashSkipView c;
    public final /* synthetic */ v d;

    public j(v vVar, com.meishu.sdk.meishu_ad.splash.a aVar, com.meishu.sdk.meishu_ad.splash.c cVar, SplashSkipView splashSkipView) {
        this.d = vVar;
        this.f5028a = aVar;
        this.b = cVar;
        this.c = splashSkipView;
    }

    @Override // com.meishu.sdk.core.view.SwipeView.OnSwipeListener
    public void onSwipe() {
        try {
            if (((com.meishu.sdk.platform.ms.splash.g) this.f5028a).e) {
                if (this.b.getInteractionListener() != null) {
                    this.b.getInteractionListener().onAdClicked();
                }
                com.meishu.sdk.meishu_ad.splash.a aVar = this.f5028a;
                if (aVar != null) {
                    ((com.meishu.sdk.platform.ms.splash.g) aVar).h = true;
                }
                this.b.b.setClkActType(128);
                com.meishu.sdk.core.utils.f.a((com.meishu.sdk.platform.ms.c) this.b, true);
                v.a(this.d, this.c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
