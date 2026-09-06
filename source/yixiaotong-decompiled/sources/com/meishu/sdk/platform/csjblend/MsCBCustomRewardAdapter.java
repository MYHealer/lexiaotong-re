package com.meishu.sdk.platform.csjblend;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.reward.MediationCustomRewardVideoLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem;
import com.meishu.sdk.activity.a;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.reward.RewardAdEventListener;
import com.meishu.sdk.core.ad.reward.RewardVideoAd;
import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.meishu.sdk.core.utils.LogUtil;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsCBCustomRewardAdapter extends MediationCustomRewardVideoLoader {
    private static final String TAG = "MsCBCustomRewardAdapter";
    private RewardVideoAd rewardVideoAd;
    private boolean calledLoadSuccess = false;
    private boolean calledExposure = false;

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.reward.MediationCustomRewardVideoLoader
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        RewardVideoAd rewardVideoAd = this.rewardVideoAd;
        return (rewardVideoAd == null || !rewardVideoAd.isAdValid()) ? MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED : MediationConstant.AdIsReadyStatus.AD_IS_READY;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
        LogUtil.e(TAG, a.a("开始加载gromore自定义平台激励视频，pid=").append(mediationCustomServiceConfig.getADNNetworkSlotId()).toString());
        this.calledLoadSuccess = false;
        this.calledExposure = false;
        new RewardVideoLoader(context, new MsAdSlot.Builder().setPid(mediationCustomServiceConfig.getADNNetworkSlotId()).build(), new RewardAdEventListener() { // from class: com.meishu.sdk.platform.csjblend.MsCBCustomRewardAdapter.1
            @Override // com.meishu.sdk.core.ad.IAdEventListener
            public void onAdError(AdErrorInfo adErrorInfo) {
                MsCBCustomRewardAdapter.this.callLoadFail(-1, "loadAdError");
            }

            @Override // com.meishu.sdk.core.ad.reward.RewardAdEventListener
            public void onReward(Map<String, Object> map) {
                MsCBCustomRewardAdapter.this.callRewardVideoRewardVerify(new MediationRewardItem() { // from class: com.meishu.sdk.platform.csjblend.MsCBCustomRewardAdapter.1.1
                    @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
                    public float getAmount() {
                        return 0.0f;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
                    public Map<String, Object> getCustomData() {
                        return null;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
                    public String getRewardName() {
                        return null;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
                    public boolean rewardVerify() {
                        return true;
                    }
                });
            }

            @Override // com.meishu.sdk.core.ad.reward.RewardAdEventListener
            public void onVideoCached(RewardVideoAd rewardVideoAd) {
            }

            @Override // com.meishu.sdk.core.ad.IAdEventListener
            public void onAdReady(RewardVideoAd rewardVideoAd) {
                double d;
                try {
                    MsCBCustomRewardAdapter.this.rewardVideoAd = rewardVideoAd;
                    if (rewardVideoAd != null) {
                        rewardVideoAd.setInteractionListener(new InteractionListener() { // from class: com.meishu.sdk.platform.csjblend.MsCBCustomRewardAdapter.1.2
                            @Override // com.meishu.sdk.core.loader.InteractionListener
                            public void onAdClicked() {
                                MsCBCustomRewardAdapter.this.callRewardVideoAdClick();
                            }

                            @Override // com.meishu.sdk.core.loader.InteractionListener
                            public void onAdClosed() {
                                MsCBCustomRewardAdapter.this.callRewardVideoAdClosed();
                            }

                            @Override // com.meishu.sdk.core.loader.InteractionListener
                            public void onAdExposure() {
                                if (MsCBCustomRewardAdapter.this.calledExposure) {
                                    return;
                                }
                                MsCBCustomRewardAdapter.this.calledExposure = true;
                                MsCBCustomRewardAdapter.this.callRewardVideoAdShow();
                            }
                        });
                        if (!MsCBCustomRewardAdapter.this.isClientBidding()) {
                            if (MsCBCustomRewardAdapter.this.calledLoadSuccess) {
                                return;
                            }
                            MsCBCustomRewardAdapter.this.calledLoadSuccess = true;
                            MsCBCustomRewardAdapter.this.callLoadSuccess();
                            return;
                        }
                        if (rewardVideoAd.getData() != null) {
                            try {
                                d = Double.parseDouble(rewardVideoAd.getData().getEcpm());
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                                d = 0.0d;
                            }
                        } else {
                            d = 0.0d;
                        }
                        if (MsCBCustomRewardAdapter.this.calledLoadSuccess) {
                            return;
                        }
                        MsCBCustomRewardAdapter.this.calledLoadSuccess = true;
                        MsCBCustomRewardAdapter.this.callLoadSuccess(d);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }).loadAd();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.reward.MediationCustomRewardVideoLoader
    public void showAd(Activity activity) {
        RewardVideoAd rewardVideoAd = this.rewardVideoAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.showAd(activity);
        }
    }
}
