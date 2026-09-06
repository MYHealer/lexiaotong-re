package com.fancy.adsdk.lib.provider;

import android.content.Context;
import com.fancy._jx;
import com.fancy._k5;
import com.fancy.adsdk.lib.interf.Error;
import com.fancy.adsdk.lib.interf.PtgInteractionAd;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.interf.PtgRewardVideoAd;
import com.fancy.adsdk.lib.interf.PtgSplashAd;
import com.fancy.adsdk.lib.model.AdSlot;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface PtgAdNative {

    public interface FeedAdListener extends Error {
        void onFeedAdLoad(_jx _jxVar);
    }

    public interface InteractionExpressAdListener extends Error {
        void onInteractionAdLoad(PtgInteractionAd ptgInteractionAd);
    }

    public interface InteractiveActivityAdListener extends Error {
        void onInteractiveActivityAdLoad(_k5 _k5Var);
    }

    public interface NativeExpressAdListener extends Error {
        void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd);
    }

    public interface RewardVideoAdListener extends Error {
        void onRewardVideoAdLoad(PtgRewardVideoAd ptgRewardVideoAd);

        void onRewardVideoCached(PtgRewardVideoAd ptgRewardVideoAd);
    }

    public interface SplashAdListener extends Error {
        void onSplashAdLoad(PtgSplashAd ptgSplashAd);

        void onTimeout();
    }

    String getBiddingToken(AdSlot adSlot, int i);

    String getName();

    void init(Context context);

    void loadBannerExpressAd(Context context, AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    @Deprecated
    void loadDrawExpressAd(Context context, AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadInteractionExpressAd(Context context, AdSlot adSlot, InteractionExpressAdListener interactionExpressAdListener);

    void loadNativeExpressAd(Context context, AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadRewardVideoAd(Context context, AdSlot adSlot, RewardVideoAdListener rewardVideoAdListener);

    void loadSplashAd(Context context, AdSlot adSlot, SplashAdListener splashAdListener);
}
