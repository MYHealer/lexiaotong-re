package com.hihonor.adsdk.splash.c;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.api.IAdLoad;
import com.hihonor.adsdk.base.api.splash.SplashAdLoadListener;
import com.hihonor.adsdk.base.mediation.core.imp.g.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a implements IAdLoad<SplashAdLoadListener> {
    private static final String c = "MediationLoad";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected AdSlot f3583a;
    protected SplashAdLoadListener b;

    @Override // com.hihonor.adsdk.base.api.IAdLoad
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdLoadListener(SplashAdLoadListener splashAdLoadListener) {
        this.b = splashAdLoadListener;
    }

    @Override // com.hihonor.adsdk.base.api.IAdLoad
    public void loadAd() {
        c.hnadsa().hnadsa(this.f3583a, this.b);
    }

    @Override // com.hihonor.adsdk.base.api.IAdLoad
    public void setAdSlot(AdSlot adSlot) {
        this.f3583a = adSlot;
    }
}
