package com.hihonor.adsdk.base.mediation.core.imp.g;

import com.hihonor.adsdk.base.api.splash.SplashExpressAd;
import com.hihonor.adsdk.base.mediation.adn.AdnAdapter;
import com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a extends com.hihonor.adsdk.base.mediation.core.imp.b<SplashExpressAd> {
    public a(com.hihonor.adsdk.base.mediation.core.imp.a aVar) {
        super(aVar);
    }

    @Override // com.hihonor.adsdk.base.mediation.core.imp.b
    protected BaseAdapter<SplashExpressAd> hnadsa() {
        BaseAdapter<SplashExpressAd> splashAd = AdnAdapter.getSplashAd(hnadsn(), this.hnadsf);
        if (splashAd != null) {
            splashAd.setAdEventListener(this);
        }
        return splashAd;
    }
}
