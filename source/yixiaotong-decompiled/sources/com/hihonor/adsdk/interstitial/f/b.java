package com.hihonor.adsdk.interstitial.f;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.api.IAdLoad;
import com.hihonor.adsdk.base.api.interstitial.InterstitialAdLoadListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b implements IAdLoad<InterstitialAdLoadListener> {
    private static final String c = "InterstitialMediationLoader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected AdSlot f3536a;
    protected InterstitialAdLoadListener b;

    @Override // com.hihonor.adsdk.base.api.IAdLoad
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdLoadListener(InterstitialAdLoadListener interstitialAdLoadListener) {
        this.b = interstitialAdLoadListener;
    }

    @Override // com.hihonor.adsdk.base.api.IAdLoad
    public void loadAd() {
        com.hihonor.adsdk.interstitial.a.a().a(this.f3536a, this.b);
    }

    @Override // com.hihonor.adsdk.base.api.IAdLoad
    public void setAdSlot(AdSlot adSlot) {
        this.f3536a = adSlot;
    }
}
