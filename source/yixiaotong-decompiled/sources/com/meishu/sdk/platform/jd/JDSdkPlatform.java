package com.meishu.sdk.platform.jd;

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
import com.meishu.sdk.platform.jd.banner.JDBannerAdWrapper;
import com.meishu.sdk.platform.jd.interstitial.JDInterstitialAdWrapper;
import com.meishu.sdk.platform.jd.recycler.JDFeedAdWrapper;
import com.meishu.sdk.platform.jd.splash.JDSplashAdWrapper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class JDSdkPlatform extends c {
    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d bannerLoader(BannerAdLoader bannerAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        try {
            Class.forName("com.jd.ad.sdk.banner.JADBanner");
            return new JDBannerAdWrapper(bannerAdLoader, sdkAdInfo, meishuAdInfo);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.meishu.sdk.core.c
    public com.meishu.sdk.core.d createConfig() {
        return new JDAdConfig();
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d fullScreenVideoLoader(FullScreenVideoAdLoader fullScreenVideoAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return null;
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d interstitialLoader(InterstitialAdLoader interstitialAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        try {
            Class.forName("com.jd.ad.sdk.interstitial.JADInterstitial");
            return new JDInterstitialAdWrapper(interstitialAdLoader, sdkAdInfo, meishuAdInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d pasterLoader(PasterAdLoader pasterAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return null;
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d recyclerLoader(RecyclerMixAdLoader recyclerMixAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        try {
            Class.forName("com.jd.ad.sdk.feed.JADFeed");
            return new JDFeedAdWrapper(recyclerMixAdLoader, sdkAdInfo, meishuAdInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d rewardLoader(RewardVideoLoader rewardVideoLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        return null;
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public d splashLoader(SplashAdLoader splashAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        try {
            Class.forName("com.jd.ad.sdk.splash.JADSplash");
            return new JDSplashAdWrapper(splashAdLoader, sdkAdInfo, meishuAdInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.meishu.sdk.core.e
    public AdType[] support() {
        return new AdType[]{AdType.FEED, AdType.FEED_PRE_RENDER, AdType.FEED_MIX, AdType.BANNER, AdType.SPLASH, AdType.INTERSTITIAL};
    }
}
