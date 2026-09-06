package com.meishu.sdk.platform.csj.reward;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationRewardManager;
import com.meishu.sdk.core.ad.reward.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJInteractionListener implements TTRewardVideoAd.RewardAdInteractionListener {
    private static final String TAG = "CSJInteractionListenerA";
    private RewardVideoAdAdapter ad;
    private CSJRewardVideoAdWrapper adWrapper;
    private TTRewardVideoAd ttRewardVideoAd;

    public CSJInteractionListener(CSJRewardVideoAdWrapper cSJRewardVideoAdWrapper, RewardVideoAdAdapter rewardVideoAdAdapter, TTRewardVideoAd tTRewardVideoAd) {
        this.adWrapper = cSJRewardVideoAdWrapper;
        this.ad = rewardVideoAdAdapter;
        this.ttRewardVideoAd = tTRewardVideoAd;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdClose() {
        try {
            if (this.ad.getAdWrapper().getAdLoader().getLoaderListener() != 0) {
                ((a) this.ad.getAdWrapper().getAdLoader().getLoaderListener()).onAdClosed();
            }
            if (this.ad.getInteractionListener() != null) {
                this.ad.getInteractionListener().onAdClosed();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdShow() {
        MediationAdEcpmInfo showEcpm;
        try {
            MediationRewardManager mediationManager = this.ttRewardVideoAd.getMediationManager();
            if (mediationManager != null && (showEcpm = mediationManager.getShowEcpm()) != null) {
                this.adWrapper.getSdkAdInfo().setGmShowEcpm(showEcpm.getEcpm());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            if (this.ad.getAdWrapper().getLoaderListener() != null) {
                this.ad.getAdWrapper().getLoaderListener().onAdExposure();
            }
            if (this.ad.getAdWrapper().getApiRewardAdMediaListener() != null) {
                this.ad.getAdWrapper().getApiRewardAdMediaListener().onVideoStart();
            }
            if (this.ad.getInteractionListener() != null) {
                this.ad.getInteractionListener().onAdExposure();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdVideoBarClick() {
        try {
            if (this.ad.getAdWrapper() != null && this.ad.getAdWrapper().getSdkAdInfo() != null && !TextUtils.isEmpty(this.ad.getAdWrapper().getSdkAdInfo().getClk())) {
                LogUtil.d(TAG, "send onAdVideoBarClick");
                z.a(this.ad.getAdWrapper().getContext(), f.a(this.ad.getAdWrapper().getSdkAdInfo().getClk(), this.ad), new i());
                this.ad.getAdWrapper().getSdkAdInfo().getMsLoadedTime();
                this.ad.getAdWrapper().getAdLoader().getPosId();
            }
            if (this.ad.getInteractionListener() != null) {
                this.ad.getInteractionListener().onAdClicked();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onRewardArrived(boolean z, int i, Bundle bundle) {
        try {
            if (this.ad.getAdWrapper().getAdLoader().getLoaderListener() != 0) {
                HashMap map = new HashMap();
                map.put("rewardVerify", Boolean.valueOf(z));
                map.put(MediationConstant.KEY_REWARD_TYPE, Integer.valueOf(i));
                map.put("extraInfo", bundle);
                ((a) this.ad.getAdWrapper().getAdLoader().getLoaderListener()).onReward(map);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onRewardVerify(boolean z, int i, String str) {
        try {
            if (this.ad.getAdWrapper().getAdLoader().getLoaderListener() != 0) {
                HashMap map = new HashMap();
                map.put("rewardVerify", Boolean.valueOf(z));
                ((a) this.ad.getAdWrapper().getAdLoader().getLoaderListener()).onReward(map);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onSkippedVideo() {
        try {
            LogUtil.d(TAG, "onSkippedVideo: ");
            if (this.ad.getAdWrapper().getApiRewardAdMediaListener() != null) {
                this.ad.getAdWrapper().getApiRewardAdMediaListener().onSkippedVideo();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoComplete() {
        try {
            if (this.ad.getAdWrapper().getApiRewardAdMediaListener() != null) {
                this.ad.getAdWrapper().getApiRewardAdMediaListener().onVideoCompleted();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoError() {
        try {
            LogUtil.d(TAG, "onVideoError: ");
            if (this.ad.getAdWrapper().getApiRewardAdMediaListener() != null) {
                this.ad.getAdWrapper().getApiRewardAdMediaListener().onVideoError();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
