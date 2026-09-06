package com.meishu.sdk.platform.pangle.interstitial;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.meishu.sdk.platform.custom.interstitial.MsCustomInterstitialAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class PangleInterstitialAd extends MsCustomInterstitialAd {
    private PAGInterstitialAd interstitialAd;

    public PangleInterstitialAd(PangleInterstitialAdapter pangleInterstitialAdapter, PAGInterstitialAd pAGInterstitialAd) {
        super(pangleInterstitialAdapter);
        this.interstitialAd = pAGInterstitialAd;
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd(Activity activity) {
        PAGInterstitialAd pAGInterstitialAd = this.interstitialAd;
        if (pAGInterstitialAd != null) {
            pAGInterstitialAd.show(activity);
        }
    }
}
