package com.ubix.ssp.open;

import com.ubix.ssp.ad.e.a0.c;
import com.ubix.ssp.open.icon.UBiXIconManager;
import com.ubix.ssp.open.interstitial.UBiXInterstitialManager;
import com.ubix.ssp.open.manager.UBiXAdManager;
import com.ubix.ssp.open.nativee.UBiXNativeManager;
import com.ubix.ssp.open.nativee.express.UBiXNativeExpressManager;
import com.ubix.ssp.open.splash.UBiXSplashManager;
import com.ubix.ssp.open.video.UBiXRewardVideoManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UBiXTokenBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9055a;
    private int b;
    private int c = 1;

    public UBiXTokenBuilder(String str, int i) {
        this.f9055a = str;
        this.b = i;
    }

    private String a() {
        try {
            if (this.c == 2) {
                UBiXNativeManager uBiXNativeManagerCreateNativeAd = UBiXAdManager.createNativeAd();
                uBiXNativeManagerCreateNativeAd.loadNativeAd(c.e(), this.f9055a, this.b, null);
                return uBiXNativeManagerCreateNativeAd.getBiddingToken();
            }
            int i = this.b;
            if (i == 1) {
                UBiXSplashManager uBiXSplashManagerCreateSpreadAd = UBiXAdManager.createSpreadAd();
                uBiXSplashManagerCreateSpreadAd.loadSplashAd(c.e(), this.f9055a, null);
                return uBiXSplashManagerCreateSpreadAd.getBiddingToken();
            }
            if (i == 2) {
                UBiXNativeExpressManager uBiXNativeExpressManagerCreateNativeExpressAd = UBiXAdManager.createNativeExpressAd();
                uBiXNativeExpressManagerCreateNativeExpressAd.loadNativeExpressAd(c.e(), this.f9055a, null);
                return uBiXNativeExpressManagerCreateNativeExpressAd.getBiddingToken();
            }
            if (i == 3) {
                UBiXIconManager uBiXIconManagerCreateIconAd = UBiXAdManager.createIconAd();
                uBiXIconManagerCreateIconAd.loadIconAd(c.e(), this.f9055a, null, null);
                return uBiXIconManagerCreateIconAd.getBiddingToken();
            }
            if (i == 6) {
                UBiXInterstitialManager uBiXInterstitialManagerCreateInterstitialAd = UBiXAdManager.createInterstitialAd();
                uBiXInterstitialManagerCreateInterstitialAd.loadInterstitialAd(c.e(), this.f9055a, null);
                return uBiXInterstitialManagerCreateInterstitialAd.getBiddingToken();
            }
            if (i != 9) {
                return null;
            }
            UBiXRewardVideoManager uBiXRewardVideoManagerCreateRewardVideoAd = UBiXAdManager.createRewardVideoAd();
            uBiXRewardVideoManagerCreateRewardVideoAd.loadRewardVideoAd(c.e(), this.f9055a, null);
            return uBiXRewardVideoManagerCreateRewardVideoAd.getBiddingToken();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String build() {
        return a();
    }

    public UBiXTokenBuilder setRenderType(int i) {
        this.c = i;
        return this;
    }
}
