package com.meishu.sdk.platform.gdt;

import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.banner.BannerAdLoader;
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
import com.meishu.sdk.platform.gdt.banner.GDTViewWrapper;
import com.meishu.sdk.platform.gdt.fullscreenvideo.GDTFullScreenVideoAdWrapper;
import com.meishu.sdk.platform.gdt.interstitial.GDTInterstitialAdWrapper;
import com.meishu.sdk.platform.gdt.paster.GDTPasterAdWrapper;
import com.meishu.sdk.platform.gdt.recycler.GDTRecyclerAdWrapper;
import com.meishu.sdk.platform.gdt.reward.GDTRewardVideoAdWrapper;
import com.meishu.sdk.platform.gdt.splash.GDTSplashAdWrapper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTSdkPlatform extends c {
    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d bannerLoader(BannerAdLoader bannerAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new GDTViewWrapper(bannerAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.c
    public com.meishu.sdk.core.d createConfig() {
        return new GDTAdConfig();
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d fullScreenVideoLoader(FullScreenVideoAdLoader fullScreenVideoAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new GDTFullScreenVideoAdWrapper(fullScreenVideoAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d interstitialLoader(InterstitialAdLoader interstitialAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new GDTInterstitialAdWrapper(interstitialAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d pasterLoader(PasterAdLoader pasterAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new GDTPasterAdWrapper(pasterAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d recyclerLoader(RecyclerMixAdLoader recyclerMixAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new GDTRecyclerAdWrapper(recyclerMixAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d rewardLoader(RewardVideoLoader rewardVideoLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new GDTRewardVideoAdWrapper(rewardVideoLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d splashLoader(SplashAdLoader splashAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new GDTSplashAdWrapper(splashAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.e
    public AdType[] support() {
        return new AdType[]{AdType.FEED, AdType.FEED_PRE_RENDER, AdType.FEED_MIX, AdType.BANNER, AdType.SPLASH, AdType.INTERSTITIAL, AdType.PASTER, AdType.REWARD, AdType.FULL_SCREEN_VIDEO};
    }
}
