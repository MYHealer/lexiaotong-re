package com.meishu.sdk.meishu_ad;

import com.meishu.sdk.core.view.SwipeView;
import com.meishu.sdk.meishu_ad.splash.SplashSkipView;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class m implements SwipeView.OnSwipeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.a f5038a;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c b;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.d c;
    public final /* synthetic */ SplashSkipView d;
    public final /* synthetic */ v e;

    public m(v vVar, com.meishu.sdk.meishu_ad.splash.a aVar, com.meishu.sdk.meishu_ad.splash.c cVar, com.meishu.sdk.meishu_ad.splash.d dVar, SplashSkipView splashSkipView) {
        this.e = vVar;
        this.f5038a = aVar;
        this.b = cVar;
        this.c = dVar;
        this.d = splashSkipView;
    }

    @Override // com.meishu.sdk.core.view.SwipeView.OnSwipeListener
    public void onSwipe() {
        try {
            if (((com.meishu.sdk.platform.ms.splash.g) this.f5038a).e) {
                if (this.b.getInteractionListener() != null) {
                    this.b.getInteractionListener().onAdClicked();
                }
                com.meishu.sdk.meishu_ad.splash.a aVar = this.f5038a;
                if (aVar != null) {
                    ((com.meishu.sdk.platform.ms.splash.g) aVar).h = true;
                }
                if ((this.c.getAct_type() & 128) != 128) {
                    this.b.b.setClkActType(32);
                } else {
                    this.b.b.setClkActType(128);
                }
                com.meishu.sdk.core.utils.f.a((com.meishu.sdk.platform.ms.c) this.b, true);
                v.a(this.e, this.d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
