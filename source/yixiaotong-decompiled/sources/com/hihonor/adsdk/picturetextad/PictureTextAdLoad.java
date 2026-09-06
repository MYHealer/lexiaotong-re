package com.hihonor.adsdk.picturetextad;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.api.IAdLoad;
import com.hihonor.adsdk.base.api.feed.PictureTextAdLoadListener;
import com.hihonor.adsdk.base.mediation.core.imp.AdManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class PictureTextAdLoad {
    private final IAdLoad<PictureTextAdLoadListener> adLoad;

    public static class Builder {
        private final IAdLoad<PictureTextAdLoadListener> adLoad = new AdManager(new e(), new c());

        public PictureTextAdLoad build() {
            return new PictureTextAdLoad(this, null);
        }

        public Builder setAdSlot(AdSlot adSlot) {
            this.adLoad.setAdSlot(adSlot);
            return this;
        }

        public Builder setPictureTextAdLoadListener(PictureTextAdLoadListener pictureTextAdLoadListener) {
            this.adLoad.setAdLoadListener(pictureTextAdLoadListener);
            return this;
        }
    }

    static /* synthetic */ class a {
    }

    /* synthetic */ PictureTextAdLoad(Builder builder, a aVar) {
        this(builder);
    }

    public void loadAd() {
        this.adLoad.loadAd();
    }

    private PictureTextAdLoad(Builder builder) {
        this.adLoad = builder.adLoad;
    }
}
