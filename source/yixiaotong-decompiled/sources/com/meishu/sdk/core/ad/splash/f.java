package com.meishu.sdk.core.ad.splash;

/* JADX INFO: compiled from: SplashAdListenerProxy.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f extends com.meishu.sdk.core.loader.b<ISplashAd, d> implements d {
    public f(com.meishu.sdk.core.loader.d dVar, d dVar2) {
        super(dVar, dVar2);
    }

    @Override // com.meishu.sdk.core.ad.splash.d
    public void onAdPresent(ISplashAd iSplashAd) {
        K k = this.b;
        if (k != 0) {
            ((d) k).onAdPresent(iSplashAd);
        }
    }

    @Override // com.meishu.sdk.core.ad.splash.d
    public void onAdSkip(ISplashAd iSplashAd) {
        K k = this.b;
        if (k != 0) {
            ((d) k).onAdSkip(iSplashAd);
        }
    }

    @Override // com.meishu.sdk.core.ad.splash.d
    public void onAdTick(long j) {
        K k = this.b;
        if (k != 0) {
            ((d) k).onAdTick(j);
        }
    }

    @Override // com.meishu.sdk.core.ad.splash.d
    public void onAdTimeOver(ISplashAd iSplashAd) {
        K k = this.b;
        if (k != 0) {
            ((d) k).onAdTimeOver(iSplashAd);
        }
    }
}
