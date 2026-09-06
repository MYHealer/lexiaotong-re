package com.meishu.sdk.platform.pangle.reward;

import com.bytedance.sdk.openadsdk.api.reward.PAGRewardItem;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedRequest;
import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.platform.custom.reward.MsCustomRewardAdapter;
import com.meishu.sdk.platform.pangle.PangleInitManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class PangleRewardAdapter extends MsCustomRewardAdapter {
    private PangleRewardAd pangleRewardAd;

    public PangleRewardAdapter(RewardVideoLoader rewardVideoLoader, SdkAdInfo sdkAdInfo) {
        super(rewardVideoLoader, sdkAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAdWithCallback(String str) {
        PAGRewardedAd.loadAd(str, new PAGRewardedRequest(), new PAGRewardedAdLoadListener() { // from class: com.meishu.sdk.platform.pangle.reward.PangleRewardAdapter.2
            public void onError(int i, String str2) {
                PangleRewardAdapter.this.onError(i, str2);
            }

            public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
                if (pAGRewardedAd != null) {
                    PangleRewardAdapter pangleRewardAdapter = PangleRewardAdapter.this;
                    pangleRewardAdapter.pangleRewardAd = new PangleRewardAd(pangleRewardAdapter, pAGRewardedAd);
                    pAGRewardedAd.setAdInteractionListener(new PAGRewardedAdInteractionListener() { // from class: com.meishu.sdk.platform.pangle.reward.PangleRewardAdapter.2.1
                        public void onAdClicked() {
                            if (PangleRewardAdapter.this.pangleRewardAd != null) {
                                PangleRewardAdapter pangleRewardAdapter2 = PangleRewardAdapter.this;
                                pangleRewardAdapter2.onAdClick(pangleRewardAdapter2.pangleRewardAd);
                            }
                        }

                        public void onAdDismissed() {
                            if (PangleRewardAdapter.this.pangleRewardAd != null) {
                                PangleRewardAdapter pangleRewardAdapter2 = PangleRewardAdapter.this;
                                pangleRewardAdapter2.onAdClosed(pangleRewardAdapter2.pangleRewardAd);
                            }
                        }

                        public void onAdShowed() {
                            if (PangleRewardAdapter.this.pangleRewardAd != null) {
                                PangleRewardAdapter pangleRewardAdapter2 = PangleRewardAdapter.this;
                                pangleRewardAdapter2.onAdExposure(pangleRewardAdapter2.pangleRewardAd);
                            }
                        }

                        public void onUserEarnedReward(PAGRewardItem pAGRewardItem) {
                        }

                        public void onUserEarnedRewardFail(int i, String str2) {
                        }
                    });
                    PangleRewardAdapter pangleRewardAdapter2 = PangleRewardAdapter.this;
                    pangleRewardAdapter2.onRenderSuccess(pangleRewardAdapter2.pangleRewardAd);
                }
            }
        });
    }

    @Override // com.meishu.sdk.platform.custom.reward.MsCustomRewardAdapter
    public void loadCustomAd(String str, String str2, final String str3, String str4) {
        PangleInitManager.getInstance().initSdk(this.context, str, new PangleInitManager.InitCallback() { // from class: com.meishu.sdk.platform.pangle.reward.PangleRewardAdapter.1
            @Override // com.meishu.sdk.platform.pangle.PangleInitManager.InitCallback
            public void onError(int i, String str5) {
            }

            @Override // com.meishu.sdk.platform.pangle.PangleInitManager.InitCallback
            public void onSuccess() {
                PangleRewardAdapter.this.loadAdWithCallback(str3);
            }
        });
    }
}
