package com.meishu.sdk.platform.ms;

import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.banner.BannerAdLoader;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.ad.paster.PasterAdLoader;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;

/* JADX INFO: compiled from: MSSdkPlatform.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e extends com.meishu.sdk.core.c {
    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public com.meishu.sdk.core.loader.d bannerLoader(BannerAdLoader bannerAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return null;
    }

    @Override // com.meishu.sdk.core.c
    public com.meishu.sdk.core.d createConfig() {
        return new f();
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public com.meishu.sdk.core.loader.d interstitialLoader(InterstitialAdLoader interstitialAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return null;
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public com.meishu.sdk.core.loader.d pasterLoader(PasterAdLoader pasterAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return null;
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public com.meishu.sdk.core.loader.d recyclerLoader(RecyclerMixAdLoader recyclerMixAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return null;
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public com.meishu.sdk.core.loader.d rewardLoader(RewardVideoLoader rewardVideoLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return null;
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public com.meishu.sdk.core.loader.d splashLoader(SplashAdLoader splashAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return null;
    }

    @Override // com.meishu.sdk.core.e
    public AdType[] support() {
        return new AdType[]{AdType.FEED, AdType.FEED_PRE_RENDER, AdType.FEED_MIX, AdType.BANNER, AdType.SPLASH, AdType.INTERSTITIAL, AdType.PASTER, AdType.REWARD, AdType.FULL_SCREEN_VIDEO, AdType.DRAW};
    }
}
