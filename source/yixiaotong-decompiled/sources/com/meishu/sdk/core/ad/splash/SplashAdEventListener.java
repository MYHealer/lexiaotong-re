package com.meishu.sdk.core.ad.splash;

import com.meishu.sdk.core.ad.IAdEventListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface SplashAdEventListener extends IAdEventListener<ISplashAd> {
    default void onAdPresent(ISplashAd iSplashAd) {
    }

    default void onAdSkip(ISplashAd iSplashAd) {
    }

    default void onAdTick(long j) {
    }

    default void onAdTimeOver(ISplashAd iSplashAd) {
    }
}
