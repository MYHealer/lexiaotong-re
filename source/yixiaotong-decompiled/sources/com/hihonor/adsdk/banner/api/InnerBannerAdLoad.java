package com.hihonor.adsdk.banner.api;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.api.IAdLoad;
import com.hihonor.adsdk.base.api.banner.BannerAdLoadListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
final class InnerBannerAdLoad {
    private final IAdLoad<BannerAdLoadListener> mInnerAdLoad;

    public static class Builder {
        private final IAdLoad<BannerAdLoadListener> innerAdLoad = new com.hihonor.adsdk.banner.api.a();

        public InnerBannerAdLoad build() {
            return new InnerBannerAdLoad(this, null);
        }

        public Builder setAdSlot(AdSlot adSlot) {
            com.hihonor.adsdk.base.b bVar = new com.hihonor.adsdk.base.b(adSlot.getBuilder());
            bVar.hnadsa(1);
            this.innerAdLoad.setAdSlot(bVar);
            return this;
        }

        public Builder setBannerAdLoadListener(BannerAdLoadListener bannerAdLoadListener) {
            this.innerAdLoad.setAdLoadListener(bannerAdLoadListener);
            return this;
        }
    }

    static /* synthetic */ class a {
    }

    /* synthetic */ InnerBannerAdLoad(Builder builder, a aVar) {
        this(builder);
    }

    public void loadAd() {
        this.mInnerAdLoad.loadAd();
    }

    private InnerBannerAdLoad(Builder builder) {
        this.mInnerAdLoad = builder.innerAdLoad;
    }
}
