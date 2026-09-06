package com.meishu.sdk.platform.oppo.interstitial;

import android.app.Activity;
import com.byazt.bv.BaseConstants;
import com.meishu.sdk.core.ad.interstitial.InterstitialAd;
import com.meishu.sdk.core.loader.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class OPPOInterstitialAd extends InterstitialAd {
    private com.heytap.msp.mobad.api.ad.InterstitialAd interstitialAd;

    public OPPOInterstitialAd(d dVar) {
        super(dVar, BaseConstants.ROM_OPPO_UPPER_CONSTANT);
    }

    public com.heytap.msp.mobad.api.ad.InterstitialAd getInterstitialAd() {
        return this.interstitialAd;
    }

    public void setInterstitialAd(com.heytap.msp.mobad.api.ad.InterstitialAd interstitialAd) {
        this.interstitialAd = interstitialAd;
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd() {
        this.interstitialAd.showAd();
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd(Activity activity) {
    }
}
