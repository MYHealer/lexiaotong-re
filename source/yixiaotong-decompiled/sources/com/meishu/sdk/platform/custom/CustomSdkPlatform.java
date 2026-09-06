package com.meishu.sdk.platform.custom;

import android.text.TextUtils;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.banner.BannerAdLoader;
import com.meishu.sdk.core.ad.draw.DrawAdLoader;
import com.meishu.sdk.core.ad.fullscreenvideo.FullScreenVideoAdLoader;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.c;
import com.meishu.sdk.core.d;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.platform.custom.banner.MsCustomBannerAdapter;
import com.meishu.sdk.platform.custom.draw.MsCustomDrawAdapter;
import com.meishu.sdk.platform.custom.fullscreen.MsCustomFullScreenAdapter;
import com.meishu.sdk.platform.custom.interstitial.MsCustomInterstitialAdapter;
import com.meishu.sdk.platform.custom.recycler.MsCustomRecyclerAdapter;
import com.meishu.sdk.platform.custom.reward.MsCustomRewardAdapter;
import com.meishu.sdk.platform.custom.splash.MsCustomSplashAdapter;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CustomSdkPlatform extends c {
    @Override // com.meishu.sdk.core.c
    public d createConfig() {
        return new MsCustomAdConfig();
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public com.meishu.sdk.core.loader.d drawLoader(DrawAdLoader drawAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        if (TextUtils.isEmpty(sdkAdInfo.getCls())) {
            return null;
        }
        try {
            Constructor<?> constructor = Class.forName(sdkAdInfo.getCls()).getConstructor(DrawAdLoader.class, SdkAdInfo.class);
            constructor.setAccessible(true);
            return (MsCustomDrawAdapter) constructor.newInstance(drawAdLoader, sdkAdInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public com.meishu.sdk.core.loader.d fullScreenVideoLoader(FullScreenVideoAdLoader fullScreenVideoAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        if (TextUtils.isEmpty(sdkAdInfo.getCls())) {
            return null;
        }
        try {
            Constructor<?> constructor = Class.forName(sdkAdInfo.getCls()).getConstructor(FullScreenVideoAdLoader.class, SdkAdInfo.class);
            constructor.setAccessible(true);
            return (MsCustomFullScreenAdapter) constructor.newInstance(fullScreenVideoAdLoader, sdkAdInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.meishu.sdk.core.e
    public AdType[] support() {
        return new AdType[]{AdType.FEED_MIX, AdType.BANNER, AdType.SPLASH, AdType.INTERSTITIAL, AdType.REWARD, AdType.DRAW, AdType.FULL_SCREEN_VIDEO};
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public MsCustomBannerAdapter bannerLoader(BannerAdLoader bannerAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        if (TextUtils.isEmpty(sdkAdInfo.getCls())) {
            return null;
        }
        try {
            Constructor<?> constructor = Class.forName(sdkAdInfo.getCls()).getConstructor(BannerAdLoader.class, SdkAdInfo.class);
            constructor.setAccessible(true);
            return (MsCustomBannerAdapter) constructor.newInstance(bannerAdLoader, sdkAdInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public MsCustomInterstitialAdapter interstitialLoader(InterstitialAdLoader interstitialAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        if (TextUtils.isEmpty(sdkAdInfo.getCls())) {
            return null;
        }
        try {
            Constructor<?> constructor = Class.forName(sdkAdInfo.getCls()).getConstructor(InterstitialAdLoader.class, SdkAdInfo.class);
            constructor.setAccessible(true);
            return (MsCustomInterstitialAdapter) constructor.newInstance(interstitialAdLoader, sdkAdInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public MsCustomRecyclerAdapter recyclerLoader(RecyclerMixAdLoader recyclerMixAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        if (TextUtils.isEmpty(sdkAdInfo.getCls())) {
            return null;
        }
        try {
            Constructor<?> constructor = Class.forName(sdkAdInfo.getCls()).getConstructor(RecyclerMixAdLoader.class, SdkAdInfo.class);
            constructor.setAccessible(true);
            return (MsCustomRecyclerAdapter) constructor.newInstance(recyclerMixAdLoader, sdkAdInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public MsCustomRewardAdapter rewardLoader(RewardVideoLoader rewardVideoLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        if (TextUtils.isEmpty(sdkAdInfo.getCls())) {
            return null;
        }
        try {
            Constructor<?> constructor = Class.forName(sdkAdInfo.getCls()).getConstructor(RewardVideoLoader.class, SdkAdInfo.class);
            constructor.setAccessible(true);
            return (MsCustomRewardAdapter) constructor.newInstance(rewardVideoLoader, sdkAdInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.meishu.sdk.core.c, com.meishu.sdk.core.e
    public MsCustomSplashAdapter splashLoader(SplashAdLoader splashAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        if (TextUtils.isEmpty(sdkAdInfo.getCls())) {
            return null;
        }
        try {
            Constructor<?> constructor = Class.forName(sdkAdInfo.getCls()).getConstructor(SplashAdLoader.class, SdkAdInfo.class);
            constructor.setAccessible(true);
            return (MsCustomSplashAdapter) constructor.newInstance(splashAdLoader, sdkAdInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
