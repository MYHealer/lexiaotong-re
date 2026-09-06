package com.hihonor.adsdk.splash;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.api.IAdLoad;
import com.hihonor.adsdk.base.api.splash.SplashAdLoadListener;
import com.hihonor.adsdk.base.mediation.core.imp.AdManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class SplashAdLoad {
    private IAdLoad<SplashAdLoadListener> mAdLoad;

    public static class Builder {
        private IAdLoad<SplashAdLoadListener> adLoad = new AdManager(new com.hihonor.adsdk.splash.c.b(), new com.hihonor.adsdk.splash.c.a());

        public SplashAdLoad build() {
            return new SplashAdLoad(this, null);
        }

        public Builder setAdSlot(AdSlot adSlot) {
            this.adLoad.setAdSlot(adSlot);
            return this;
        }

        public Builder setSplashAdLoadListener(SplashAdLoadListener splashAdLoadListener) {
            this.adLoad.setAdLoadListener(splashAdLoadListener);
            return this;
        }
    }

    static /* synthetic */ class a {
    }

    /* synthetic */ SplashAdLoad(Builder builder, a aVar) {
        this(builder);
    }

    public void loadAd() {
        this.mAdLoad.loadAd();
    }

    private SplashAdLoad(Builder builder) {
        this.mAdLoad = builder.adLoad;
    }
}
