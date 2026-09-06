package com.hihonor.adsdk.banner.api;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.api.IAdLoad;
import com.hihonor.adsdk.base.api.banner.BannerAdLoadListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class BannerAdLoad {
    private final IAdLoad<BannerAdLoadListener> mAdLoad;

    public static class Builder {
        private final IAdLoad<BannerAdLoadListener> adLoad = new com.hihonor.adsdk.banner.api.a();

        public BannerAdLoad build() {
            return new BannerAdLoad(this, null);
        }

        public Builder setAdSlot(AdSlot adSlot) {
            this.adLoad.setAdSlot(adSlot);
            return this;
        }

        public Builder setBannerAdLoadListener(BannerAdLoadListener bannerAdLoadListener) {
            this.adLoad.setAdLoadListener(bannerAdLoadListener);
            return this;
        }
    }

    static /* synthetic */ class a {
    }

    /* synthetic */ BannerAdLoad(Builder builder, a aVar) {
        this(builder);
    }

    public void loadAd() {
        this.mAdLoad.loadAd();
    }

    private BannerAdLoad(Builder builder) {
        this.mAdLoad = builder.adLoad;
    }
}
