package com.meishu.sdk.platform.jd.interstitial;

import android.app.Activity;
import com.jd.ad.sdk.interstitial.JADInterstitial;
import com.meishu.sdk.core.ad.interstitial.InterstitialAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class JDIntersititialAd extends InterstitialAd {
    private Activity activity;
    private JDInterstitialAdWrapper adWrapper;
    private JADInterstitial interstitialAd;

    public JDIntersititialAd(JDInterstitialAdWrapper jDInterstitialAdWrapper, Activity activity) {
        super(jDInterstitialAdWrapper, "JD");
        this.adWrapper = jDInterstitialAdWrapper;
        this.activity = activity;
    }

    public JADInterstitial getInterstitialAd() {
        return this.interstitialAd;
    }

    public void setInterstitialAd(JADInterstitial jADInterstitial) {
        this.interstitialAd = jADInterstitial;
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd() {
        try {
            this.interstitialAd.showAd(this.activity);
            super.showAd();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd(Activity activity) {
        try {
            this.interstitialAd.showAd(activity);
            super.showAd(activity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
