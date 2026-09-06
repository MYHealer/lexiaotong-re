package com.meishu.sdk.platform.bd.reward;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.meishu.sdk.core.ad.reward.a;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.c;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.platform.bd.BDPlatformError;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BDRewardVideoListener implements RewardVideoAd.RewardVideoAdListener {
    private static final String TAG = "BDRewardVideoListener";
    private c adLoader;
    private BDRewardVideoLoader bdRewardVideoLoader;
    private BDRewardAd mBDRewardAd;
    private RewardVideoAd mRewardVideoAd;
    private a msListener;
    private SdkAdInfo sdkAdInfo;

    public BDRewardVideoListener(a aVar, c cVar, SdkAdInfo sdkAdInfo, BDRewardVideoLoader bDRewardVideoLoader) {
        this.msListener = aVar;
        this.sdkAdInfo = sdkAdInfo;
        this.adLoader = cVar;
        this.bdRewardVideoLoader = bDRewardVideoLoader;
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdClick() {
        BDRewardAd bDRewardAd;
        SdkAdInfo sdkAdInfo = this.sdkAdInfo;
        if (sdkAdInfo != null && !TextUtils.isEmpty(sdkAdInfo.getClk())) {
            LogUtil.d(TAG, "send onAdClick");
            com.meishu.sdk.core.loader.a.a(this.adLoader.getContext(), f.a(this.sdkAdInfo.getClk(), this.mBDRewardAd));
            this.sdkAdInfo.getMsLoadedTime();
            this.adLoader.getPosId();
        }
        if (this.mRewardVideoAd == null || (bDRewardAd = this.mBDRewardAd) == null || bDRewardAd.getInteractionListener() == null) {
            return;
        }
        this.mBDRewardAd.getInteractionListener().onAdClicked();
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdClose(float f) {
        BDRewardAd bDRewardAd;
        if (this.mRewardVideoAd == null || (bDRewardAd = this.mBDRewardAd) == null || bDRewardAd.getInteractionListener() == null) {
            return;
        }
        this.mBDRewardAd.getInteractionListener().onAdClosed();
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdFailed(String str) {
        LogUtil.e(TAG, "onAdFailed, msg: " + str);
        if (str == null || str.startsWith("exception")) {
            return;
        }
        new BDPlatformError(str, this.sdkAdInfo).post(this.msListener);
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdSkip(float f) {
        BDRewardAd bDRewardAd;
        if (this.mRewardVideoAd == null || (bDRewardAd = this.mBDRewardAd) == null || bDRewardAd.getMediaListener() == null) {
            return;
        }
        this.mBDRewardAd.getMediaListener().onSkippedVideo();
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onVideoDownloadFailed() {
        LogUtil.e(TAG, "onVideoDownloadFailed, onVideoDownloadFailed");
        a aVar = this.msListener;
        if (aVar != null) {
            aVar.onAdError();
        }
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void playCompletion() {
        BDRewardAd bDRewardAd;
        if (this.mRewardVideoAd == null || (bDRewardAd = this.mBDRewardAd) == null || bDRewardAd.getMediaListener() == null) {
            return;
        }
        this.mBDRewardAd.getMediaListener().onVideoCompleted();
    }

    public void setRewardVideoAd(RewardVideoAd rewardVideoAd) {
        this.mRewardVideoAd = rewardVideoAd;
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdLoaded() {
        if (this.msListener != null) {
            this.mBDRewardAd = new BDRewardAd(this.mRewardVideoAd, this.bdRewardVideoLoader);
            try {
                this.sdkAdInfo.setEcpm(this.mRewardVideoAd.getECPMLevel());
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.msListener.onAdLoaded(this.mBDRewardAd);
            this.msListener.onAdReady(this.mBDRewardAd);
        }
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdShow() {
        BDRewardAd bDRewardAd;
        BDRewardAd bDRewardAd2;
        try {
            a aVar = this.msListener;
            if (aVar != null) {
                aVar.onAdExposure();
            }
            if (this.mRewardVideoAd != null && (bDRewardAd2 = this.mBDRewardAd) != null && bDRewardAd2.getInteractionListener() != null) {
                this.mBDRewardAd.getInteractionListener().onAdExposure();
            }
            if (this.mRewardVideoAd == null || (bDRewardAd = this.mBDRewardAd) == null || bDRewardAd.getMediaListener() == null) {
                return;
            }
            this.mBDRewardAd.getMediaListener().onVideoStart();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
    public void onRewardVerify(boolean z, Map<String, Object> map) {
        if (this.msListener != null) {
            map.put("rewardVerify", Boolean.valueOf(z));
            this.msListener.onReward(map);
        }
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onVideoDownloadSuccess() {
        a aVar = this.msListener;
        if (aVar != null) {
            aVar.onVideoCached(this.mBDRewardAd);
        }
    }

    public void onRewardVerify(boolean z) {
        if (this.msListener != null) {
            HashMap map = new HashMap();
            map.put("rewardVerify", Boolean.valueOf(z));
            this.msListener.onReward(map);
        }
    }
}
