package com.fancy.adsdk.lib.provider;

import android.content.Context;
import android.util.Log;
import com.fancy._c4;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.utils.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _a implements PtgAdNative {
    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final String getBiddingToken(AdSlot adSlot, int i) {
        return "";
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final String getName() {
        Log.e(Logger.ILogger.TAG, "PtgAdSdk.init is not executed, skip PtgAdNative.getName()");
        return "";
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void init(Context context) {
        Log.e(Logger.ILogger.TAG, "PtgAdSdk.init is not executed, skip PtgAdNative.init(Context)");
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadBannerExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        Log.e(Logger.ILogger.TAG, "PtgAdSdk.init is not executed, skip PtgAdNative.loadBannerExpressAd(Context, AdSlot, NativeExpressAdListener)");
        if (nativeExpressAdListener != null) {
            _c4._a(10007, "PtgAdSdk.init is not executed, skip PtgAdNative.loadBannerExpressAd(Context, AdSlot, NativeExpressAdListener)", null, nativeExpressAdListener);
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadDrawExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        Log.e(Logger.ILogger.TAG, "PtgAdSdk.init is not executed, skip PtgAdNative.loadDrawFeedAd(Context, AdSlot, NativeExpressAdListener)");
        if (nativeExpressAdListener != null) {
            _c4._a(10007, "PtgAdSdk.init is not executed, skip PtgAdNative.loadDrawFeedAd(Context, AdSlot, NativeExpressAdListener)", null, nativeExpressAdListener);
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadInteractionExpressAd(Context context, AdSlot adSlot, PtgAdNative.InteractionExpressAdListener interactionExpressAdListener) {
        Log.e(Logger.ILogger.TAG, "PtgAdSdk.init is not executed, skip PtgAdNative.loadInteractionExpressAd(Context, AdSlot, InteractionExpressAdListener)");
        if (interactionExpressAdListener != null) {
            interactionExpressAdListener.onError(new AdErrorImpl(10007, "PtgAdSdk.init is not executed, skip PtgAdNative.loadInteractionExpressAd(Context, AdSlot, InteractionExpressAdListener)", (Object) null));
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadNativeExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        Log.e(Logger.ILogger.TAG, "PtgAdSdk.init is not executed, skip PtgAdNative.loadNativeExpressAd(Context, AdSlot, NativeExpressAdListener)");
        if (nativeExpressAdListener != null) {
            _c4._a(10007, "PtgAdSdk.init is not executed, skip PtgAdNative.loadNativeExpressAd(Context, AdSlot, NativeExpressAdListener)", null, nativeExpressAdListener);
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadRewardVideoAd(Context context, AdSlot adSlot, PtgAdNative.RewardVideoAdListener rewardVideoAdListener) {
        Log.e(Logger.ILogger.TAG, "PtgAdSdk.init is not executed, skip PtgAdNative.loadRewardVideoAd(Context, AdSlot, RewardVideoAdListener)");
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onError(new AdErrorImpl(10007, "PtgAdSdk.init is not executed, skip PtgAdNative.loadRewardVideoAd(Context, AdSlot, RewardVideoAdListener)", (Object) null));
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadSplashAd(Context context, AdSlot adSlot, PtgAdNative.SplashAdListener splashAdListener) {
        Log.e(Logger.ILogger.TAG, "PtgAdSdk.init is not executed, skip PtgAdNative.loadSplashAd(Context, AdSlot, SplashAdListener)");
        if (splashAdListener != null) {
            splashAdListener.onError(new AdErrorImpl(10007, "PtgAdSdk.init is not executed, skip PtgAdNative.loadSplashAd(Context, AdSlot, SplashAdListener)", (Object) null));
        }
    }
}
