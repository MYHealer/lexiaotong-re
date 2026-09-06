package com.meishu.sdk.platform.ks.interstitial;

import android.app.Activity;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.meishu.sdk.core.ad.interstitial.InterstitialAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KsIntersititialAd extends InterstitialAd {
    public KSIntersititialAdWrapper adWrapper;
    public KsInterstitialAd mKsInterstitialAd;

    public KsIntersititialAd(KsInterstitialAd ksInterstitialAd, KSIntersititialAdWrapper kSIntersititialAdWrapper) {
        super(kSIntersititialAdWrapper, "KS");
        this.mKsInterstitialAd = ksInterstitialAd;
        this.adWrapper = kSIntersititialAdWrapper;
    }

    public KSIntersititialAdWrapper getAdWrapper() {
        return this.adWrapper;
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd() {
        try {
            this.mKsInterstitialAd.showInterstitialAd((Activity) this.adWrapper.getContext(), new KsVideoPlayConfig.Builder().videoSoundEnable(false).build());
            super.showAd();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd(Activity activity) {
        try {
            this.mKsInterstitialAd.showInterstitialAd(activity, new KsVideoPlayConfig.Builder().videoSoundEnable(false).build());
            super.showAd(activity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
