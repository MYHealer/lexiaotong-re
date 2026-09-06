package com.meishu.sdk.platform.huawei.interstitial;

import android.app.Activity;
import com.meishu.sdk.core.ad.interstitial.InterstitialAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HWInterstitialAd extends InterstitialAd {
    private HWInterstitialAdWrapper adWrapper;
    private com.huawei.hms.ads.InterstitialAd interstitialAd;

    public HWInterstitialAd(HWInterstitialAdWrapper hWInterstitialAdWrapper, com.huawei.hms.ads.InterstitialAd interstitialAd) {
        super(hWInterstitialAdWrapper, "HW");
        this.adWrapper = hWInterstitialAdWrapper;
        this.interstitialAd = interstitialAd;
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd() {
        com.huawei.hms.ads.InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null && interstitialAd.isLoaded() && (this.adWrapper.getContext() instanceof Activity)) {
            this.interstitialAd.show((Activity) this.adWrapper.getContext());
            super.showAd();
        }
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd(Activity activity) {
        com.huawei.hms.ads.InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd == null || !interstitialAd.isLoaded()) {
            return;
        }
        this.interstitialAd.show(activity);
        super.showAd();
    }
}
