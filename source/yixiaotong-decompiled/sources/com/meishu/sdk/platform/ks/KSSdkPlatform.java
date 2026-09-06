package com.meishu.sdk.platform.ks;

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
import com.meishu.sdk.platform.ks.draw.KSDrawAdWrapper;
import com.meishu.sdk.platform.ks.fullscreenvideo.KSFullScreenAdWrapper;
import com.meishu.sdk.platform.ks.interstitial.KSIntersititialAdWrapper;
import com.meishu.sdk.platform.ks.recycler.KSRecyclerAdWrapper;
import com.meishu.sdk.platform.ks.reward.KSRewardVideoAdWrapper;
import com.meishu.sdk.platform.ks.splash.KSSplashAdWrapper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KSSdkPlatform extends c {
    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d bannerLoader(BannerAdLoader bannerAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return null;
    }

    @Override // com.meishu.sdk.core.c
    public com.meishu.sdk.core.d createConfig() {
        return new KSAdConfig();
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d drawLoader(DrawAdLoader drawAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new KSDrawAdWrapper(drawAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d fullScreenVideoLoader(FullScreenVideoAdLoader fullScreenVideoAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new KSFullScreenAdWrapper(fullScreenVideoAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d interstitialLoader(InterstitialAdLoader interstitialAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new KSIntersititialAdWrapper(interstitialAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d pasterLoader(PasterAdLoader pasterAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return null;
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d recyclerLoader(RecyclerMixAdLoader recyclerMixAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new KSRecyclerAdWrapper(recyclerMixAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d rewardLoader(RewardVideoLoader rewardVideoLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new KSRewardVideoAdWrapper(rewardVideoLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d splashLoader(SplashAdLoader splashAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return new KSSplashAdWrapper(splashAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.e
    public AdType[] support() {
        return new AdType[]{AdType.FEED, AdType.FEED_PRE_RENDER, AdType.FEED_MIX, AdType.SPLASH, AdType.FULL_SCREEN_VIDEO, AdType.INTERSTITIAL, AdType.REWARD, AdType.DRAW};
    }
}
