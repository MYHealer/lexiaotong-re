package com.kwad.components.ad.interstitial;

import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdResultData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class e {
    public static KsInterstitialAd f(AdResultData adResultData) {
        int iFg = com.kwad.sdk.core.response.helper.e.fg(com.kwad.sdk.core.response.helper.c.r(adResultData));
        if (iFg == 1) {
            return new com.kwad.components.ad.interstitial.e.a(true, adResultData);
        }
        if (iFg == 2) {
            return new com.kwad.components.ad.interstitial.e.a(false, adResultData);
        }
        return new b(adResultData);
    }
}
