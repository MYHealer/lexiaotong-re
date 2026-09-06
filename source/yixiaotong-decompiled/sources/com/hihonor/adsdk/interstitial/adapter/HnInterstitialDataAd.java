package com.hihonor.adsdk.interstitial.adapter;

import android.app.Activity;
import com.hihonor.adsdk.base.api.HnMediationExpressDataAd;
import com.hihonor.adsdk.base.api.interstitial.InterstitialExpressAd;
import com.hihonor.adsdk.base.callback.AdListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnInterstitialDataAd extends HnMediationExpressDataAd<InterstitialExpressAd> implements InterstitialExpressAd {
    public HnInterstitialDataAd(InterstitialExpressAd interstitialExpressAd) {
        super(interstitialExpressAd);
    }

    @Override // com.hihonor.adsdk.base.api.HnMediationExpressDataAd, com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public void setAdListener(AdListener adListener) {
        super.setAdListener(adListener);
    }

    @Override // com.hihonor.adsdk.base.api.interstitial.InterstitialExpressAd
    public void show(Activity activity) {
        if (hnadsc()) {
            ((InterstitialExpressAd) this.hnadsd).show(activity);
        }
    }
}
