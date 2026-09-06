package com.meishu.sdk.platform.bd;

import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.banner.BannerAdLoader;
import com.meishu.sdk.core.ad.draw.DrawAdLoader;
import com.meishu.sdk.core.ad.fullscreenvideo.FullScreenVideoAdLoader;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.ad.paster.PasterAdLoader;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.c;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.d;
import com.meishu.sdk.platform.bd.banner.BDBannerAdLoader;
import com.meishu.sdk.platform.bd.draw.BDDrawAdWrapper;
import com.meishu.sdk.platform.bd.fullscreenvideo.BDFullscreenVideoLoader;
import com.meishu.sdk.platform.bd.interstitial.BDInterstitialAdLoader;
import com.meishu.sdk.platform.bd.paster.BDPasterAdLoader;
import com.meishu.sdk.platform.bd.recycler.BDRecyclerLoader;
import com.meishu.sdk.platform.bd.reward.BDRewardVideoLoader;
import com.meishu.sdk.platform.bd.splash.BDSplashAdLoader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BDSdkPlatform extends c {
    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d bannerLoader(BannerAdLoader bannerAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new BDBannerAdLoader(bannerAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.c
    public com.meishu.sdk.core.d createConfig() {
        return new BDSdkConfig();
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d drawLoader(DrawAdLoader drawAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new BDDrawAdWrapper(drawAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d fullScreenVideoLoader(FullScreenVideoAdLoader fullScreenVideoAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new BDFullscreenVideoLoader(fullScreenVideoAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d interstitialLoader(InterstitialAdLoader interstitialAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new BDInterstitialAdLoader(interstitialAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d pasterLoader(PasterAdLoader pasterAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new BDPasterAdLoader(pasterAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d recyclerLoader(RecyclerMixAdLoader recyclerMixAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new BDRecyclerLoader(recyclerMixAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d rewardLoader(RewardVideoLoader rewardVideoLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new BDRewardVideoLoader(rewardVideoLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d splashLoader(SplashAdLoader splashAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new BDSplashAdLoader(splashAdLoader, sdkAdInfo, meishuAdInfo);
    }

    @Override // com.meishu.sdk.core.e
    public AdType[] support() {
        return new AdType[]{AdType.FEED, AdType.FEED_PRE_RENDER, AdType.FEED_MIX, AdType.SPLASH, AdType.FULL_SCREEN_VIDEO, AdType.INTERSTITIAL, AdType.REWARD};
    }
}
