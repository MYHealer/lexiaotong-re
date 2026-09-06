package com.meishu.sdk.core;

import com.meishu.sdk.core.ad.banner.BannerAdLoader;
import com.meishu.sdk.core.ad.draw.DrawAdLoader;
import com.meishu.sdk.core.ad.fullscreenvideo.FullScreenVideoAdLoader;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.ad.paster.PasterAdLoader;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;

/* JADX INFO: compiled from: BasePlatform.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class c implements e {
    public d config;

    @Override // com.meishu.sdk.core.e
    public com.meishu.sdk.core.loader.d bannerLoader(BannerAdLoader bannerAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return null;
    }

    public abstract d createConfig();

    @Override // com.meishu.sdk.core.e
    public com.meishu.sdk.core.loader.d drawLoader(DrawAdLoader drawAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return null;
    }

    @Override // com.meishu.sdk.core.e
    public com.meishu.sdk.core.loader.d fullScreenVideoLoader(FullScreenVideoAdLoader fullScreenVideoAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return null;
    }

    @Override // com.meishu.sdk.core.e
    public com.meishu.sdk.core.loader.d interstitialLoader(InterstitialAdLoader interstitialAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return null;
    }

    @Override // com.meishu.sdk.core.e
    public com.meishu.sdk.core.loader.d pasterLoader(PasterAdLoader pasterAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return null;
    }

    @Override // com.meishu.sdk.core.e
    public com.meishu.sdk.core.loader.d recyclerLoader(RecyclerMixAdLoader recyclerMixAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return null;
    }

    @Override // com.meishu.sdk.core.e
    public com.meishu.sdk.core.loader.d rewardLoader(RewardVideoLoader rewardVideoLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return null;
    }

    @Override // com.meishu.sdk.core.e
    public com.meishu.sdk.core.loader.d splashLoader(SplashAdLoader splashAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return null;
    }

    @Override // com.meishu.sdk.core.e
    public d config() {
        if (this.config == null) {
            this.config = createConfig();
        }
        return this.config;
    }
}
