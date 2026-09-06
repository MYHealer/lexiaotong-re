package com.ubix.ssp.open.manager;

import com.ubix.ssp.open.banner.UBiXBannerManager;
import com.ubix.ssp.open.icon.UBiXIconManager;
import com.ubix.ssp.open.interstitial.UBiXInterstitialManager;
import com.ubix.ssp.open.nativee.UBiXNativeManager;
import com.ubix.ssp.open.nativee.express.UBiXNativeExpressManager;
import com.ubix.ssp.open.splash.UBiXSplashManager;
import com.ubix.ssp.open.video.UBiXRewardVideoManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UBiXAdManager {
    public static UBiXBannerManager createBannerAd() {
        return new a();
    }

    public static UBiXIconManager createIconAd() {
        return new b();
    }

    public static UBiXInterstitialManager createInterstitialAd() {
        return new c();
    }

    public static UBiXNativeManager createNativeAd() {
        return new e();
    }

    public static UBiXNativeExpressManager createNativeExpressAd() {
        return new d();
    }

    public static UBiXRewardVideoManager createRewardVideoAd() {
        return new f();
    }

    public static UBiXSplashManager createSpreadAd() {
        return new g();
    }
}
