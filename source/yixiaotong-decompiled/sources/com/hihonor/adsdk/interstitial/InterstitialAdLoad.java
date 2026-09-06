package com.hihonor.adsdk.interstitial;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.api.IAdLoad;
import com.hihonor.adsdk.base.api.interstitial.InterstitialAdLoadListener;
import com.hihonor.adsdk.base.mediation.core.imp.AdManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class InterstitialAdLoad {
    private final IAdLoad<InterstitialAdLoadListener> adLoad;

    public static class Builder {
        private final IAdLoad<InterstitialAdLoadListener> adLoad = new AdManager(new com.hihonor.adsdk.interstitial.f.a(), new com.hihonor.adsdk.interstitial.f.b());

        public InterstitialAdLoad build() {
            return new InterstitialAdLoad(this, null);
        }

        public Builder setAdSlot(AdSlot adSlot) {
            this.adLoad.setAdSlot(adSlot);
            return this;
        }

        public Builder setInterstitialAdLoadListener(InterstitialAdLoadListener interstitialAdLoadListener) {
            this.adLoad.setAdLoadListener(interstitialAdLoadListener);
            return this;
        }
    }

    static /* synthetic */ class a {
    }

    /* synthetic */ InterstitialAdLoad(Builder builder, a aVar) {
        this(builder);
    }

    public void loadAd() {
        this.adLoad.loadAd();
    }

    private InterstitialAdLoad(Builder builder) {
        this.adLoad = builder.adLoad;
    }
}
