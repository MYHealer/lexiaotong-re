package com.huawei.hms.ads;

import com.huawei.hms.ads.inter.data.IInterstitialAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class g {
    private static final byte[] I = new byte[0];
    private static IInterstitialAd V;

    public static IInterstitialAd Code() {
        IInterstitialAd iInterstitialAd;
        synchronized (I) {
            iInterstitialAd = V;
        }
        return iInterstitialAd;
    }

    public static void Code(IInterstitialAd iInterstitialAd) {
        synchronized (I) {
            try {
                if (iInterstitialAd == null) {
                    fh.Code("InterstitialGlobalDataShare", "set interstitial ad null");
                    V = null;
                } else {
                    V = iInterstitialAd;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
