package com.meishu.sdk.core.ad.reward;

import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.loader.AdPlatformError;
import com.meishu.sdk.core.utils.AdErrorInfo;
import java.util.Map;

/* JADX INFO: compiled from: RewardVideoAdListenerAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RewardAdEventListener f4765a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;

    public b(RewardVideoLoader rewardVideoLoader, RewardAdEventListener rewardAdEventListener) {
        this.f4765a = rewardAdEventListener;
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdClosed() {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdExposure() {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public /* bridge */ /* synthetic */ void onAdLoaded(RewardVideoAd rewardVideoAd) {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdPlatformError(AdPlatformError adPlatformError) {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdReady(RewardVideoAd rewardVideoAd) {
        RewardVideoAd rewardVideoAd2 = rewardVideoAd;
        this.c = true;
        RewardAdEventListener rewardAdEventListener = this.f4765a;
        if (rewardAdEventListener != null) {
            rewardAdEventListener.onAdReady(rewardVideoAd2);
        }
    }

    @Override // com.meishu.sdk.core.ad.reward.a
    public void onReward(Map<String, Object> map) {
        RewardAdEventListener rewardAdEventListener = this.f4765a;
        if (rewardAdEventListener != null) {
            rewardAdEventListener.onReward(map);
        }
    }

    @Override // com.meishu.sdk.core.ad.reward.a
    public void onVideoCached(RewardVideoAd rewardVideoAd) {
        RewardAdEventListener rewardAdEventListener = this.f4765a;
        if (rewardAdEventListener != null) {
            rewardAdEventListener.onVideoCached(rewardVideoAd);
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdRenderFail(String str, int i) {
        if (this.f4765a == null || this.b || this.d) {
            return;
        }
        this.d = true;
        this.f4765a.onAdError(new AdErrorInfo(AdErrorInfo.RENDER_ERROR, i, str));
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdError() {
        AdErrorInfo adErrorInfo;
        if (this.f4765a == null || this.d || this.b) {
            return;
        }
        this.b = true;
        RewardAdEventListener rewardAdEventListener = this.f4765a;
        String str = AdSdk.adConfig() == null ? "SDK IS NOT INITED ！" : ErrorCodeUtil.AD_LOAD_ERROR_MSG;
        if (this.c) {
            adErrorInfo = new AdErrorInfo(AdErrorInfo.RENDER_ERROR, ErrorCodeUtil.RENDER_AD_RESULT, str);
        } else {
            adErrorInfo = new AdErrorInfo(AdErrorInfo.LOAD_ERROR, ErrorCodeUtil.AD_LOAD_ERROR.intValue(), str);
        }
        rewardAdEventListener.onAdError(adErrorInfo);
    }
}
