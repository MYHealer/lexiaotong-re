package com.hihonor.adsdk.interstitial;

import com.hihonor.adsdk.base.api.interstitial.InterstitialExpressAd;
import com.hihonor.adsdk.base.mediation.adn.AdnAdapter;
import com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends com.hihonor.adsdk.base.mediation.core.imp.b<InterstitialExpressAd> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3532a = "InterstitialInstance";

    public c(com.hihonor.adsdk.base.mediation.core.imp.a aVar) {
        super(aVar);
    }

    @Override // com.hihonor.adsdk.base.mediation.core.imp.b
    protected BaseAdapter hnadsa() {
        BaseAdapter<InterstitialExpressAd> interstitialAd = AdnAdapter.getInterstitialAd(hnadsn(), this.hnadsf);
        if (interstitialAd != null) {
            com.hihonor.adsdk.common.b.b.hnadsa(f3532a, (Object) "createAdapter success");
            interstitialAd.setAdEventListener(this);
        }
        return interstitialAd;
    }
}
