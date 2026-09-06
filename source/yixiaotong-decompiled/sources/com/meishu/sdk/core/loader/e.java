package com.meishu.sdk.core.loader;

import com.meishu.sdk.core.ad.splash.f;

/* JADX INFO: compiled from: ListenerProxyFactory.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T a(d dVar, IAdLoadListener iAdLoadListener) {
        if (iAdLoadListener instanceof com.meishu.sdk.core.ad.recycler.a) {
            return (T) new com.meishu.sdk.core.ad.recycler.c(dVar, (com.meishu.sdk.core.ad.recycler.a) iAdLoadListener);
        }
        if (iAdLoadListener instanceof com.meishu.sdk.core.ad.banner.b) {
            return (T) new com.meishu.sdk.core.ad.banner.d(dVar, (com.meishu.sdk.core.ad.banner.b) iAdLoadListener);
        }
        if (iAdLoadListener instanceof com.meishu.sdk.core.ad.splash.d) {
            return (T) new f(dVar, (com.meishu.sdk.core.ad.splash.d) iAdLoadListener);
        }
        if (iAdLoadListener instanceof com.meishu.sdk.core.ad.reward.a) {
            return (T) new com.meishu.sdk.core.ad.reward.c(dVar, (com.meishu.sdk.core.ad.reward.a) iAdLoadListener);
        }
        if (iAdLoadListener instanceof com.meishu.sdk.core.ad.interstitial.b) {
            return (T) new com.meishu.sdk.core.ad.interstitial.c(dVar, (com.meishu.sdk.core.ad.interstitial.b) iAdLoadListener);
        }
        if (iAdLoadListener instanceof com.meishu.sdk.core.ad.media.a) {
            return (T) new com.meishu.sdk.core.ad.media.b(dVar, (com.meishu.sdk.core.ad.media.a) iAdLoadListener);
        }
        if (iAdLoadListener instanceof com.meishu.sdk.core.ad.image.b) {
            return (T) new com.meishu.sdk.core.ad.image.c(dVar, (com.meishu.sdk.core.ad.image.b) iAdLoadListener);
        }
        if (iAdLoadListener instanceof com.meishu.sdk.core.ad.draw.a) {
            return (T) new com.meishu.sdk.core.ad.draw.c(dVar, (com.meishu.sdk.core.ad.draw.a) iAdLoadListener);
        }
        if (iAdLoadListener instanceof com.meishu.sdk.core.ad.paster.b) {
            return (T) new com.meishu.sdk.core.ad.paster.d(dVar, (com.meishu.sdk.core.ad.paster.b) iAdLoadListener);
        }
        return iAdLoadListener instanceof com.meishu.sdk.core.ad.fullscreenvideo.c ? (T) new com.meishu.sdk.core.ad.fullscreenvideo.d(dVar, (com.meishu.sdk.core.ad.fullscreenvideo.c) iAdLoadListener) : iAdLoadListener;
    }
}
