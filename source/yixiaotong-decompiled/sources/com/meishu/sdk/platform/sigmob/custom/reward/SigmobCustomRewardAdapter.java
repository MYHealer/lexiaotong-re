package com.meishu.sdk.platform.sigmob.custom.reward;

import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.platform.custom.reward.MsCustomRewardAdapter;
import com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager;
import com.sigmob.windad.WindAdBiddingLossReason;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.rewardVideo.WindRewardAdRequest;
import com.sigmob.windad.rewardVideo.WindRewardInfo;
import com.sigmob.windad.rewardVideo.WindRewardVideoAd;
import com.sigmob.windad.rewardVideo.WindRewardVideoAdListener;
import com.unionpay.tsmservice.data.Constant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SigmobCustomRewardAdapter extends MsCustomRewardAdapter {
    private SigmobCustomRewardAd sigmobCustomRewardAd;
    private WindRewardVideoAd windRewardVideoAd;

    public SigmobCustomRewardAdapter(RewardVideoLoader rewardVideoLoader, SdkAdInfo sdkAdInfo) {
        super(rewardVideoLoader, sdkAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAdWithCallback(String str) {
        WindRewardVideoAd windRewardVideoAd = new WindRewardVideoAd(new WindRewardAdRequest(str, "", (Map) null));
        this.windRewardVideoAd = windRewardVideoAd;
        this.sigmobCustomRewardAd = new SigmobCustomRewardAd(this, windRewardVideoAd);
        this.windRewardVideoAd.setWindRewardVideoAdListener(new WindRewardVideoAdListener() { // from class: com.meishu.sdk.platform.sigmob.custom.reward.SigmobCustomRewardAdapter.2
            public void onRewardAdClicked(String str2) {
                if (SigmobCustomRewardAdapter.this.sigmobCustomRewardAd != null) {
                    SigmobCustomRewardAdapter sigmobCustomRewardAdapter = SigmobCustomRewardAdapter.this;
                    sigmobCustomRewardAdapter.onAdClick(sigmobCustomRewardAdapter.sigmobCustomRewardAd);
                }
            }

            public void onRewardAdClosed(String str2) {
                if (SigmobCustomRewardAdapter.this.sigmobCustomRewardAd != null) {
                    SigmobCustomRewardAdapter sigmobCustomRewardAdapter = SigmobCustomRewardAdapter.this;
                    sigmobCustomRewardAdapter.onAdClosed(sigmobCustomRewardAdapter.sigmobCustomRewardAd);
                }
            }

            public void onRewardAdLoadError(WindAdError windAdError, String str2) {
                SigmobCustomRewardAdapter.this.onError(windAdError.getErrorCode(), windAdError.getMessage());
            }

            public void onRewardAdLoadSuccess(String str2) {
                if (SigmobCustomRewardAdapter.this.windRewardVideoAd != null) {
                    String ecpm = SigmobCustomRewardAdapter.this.windRewardVideoAd.getEcpm();
                    if (SigmobCustomRewardAdapter.this.getSdkAdInfo() != null) {
                        SigmobCustomRewardAdapter.this.getSdkAdInfo().setEcpm(ecpm);
                    }
                }
                if (SigmobCustomRewardAdapter.this.sigmobCustomRewardAd != null) {
                    SigmobCustomRewardAdapter sigmobCustomRewardAdapter = SigmobCustomRewardAdapter.this;
                    sigmobCustomRewardAdapter.onRenderSuccess(sigmobCustomRewardAdapter.sigmobCustomRewardAd);
                }
            }

            public void onRewardAdPlayEnd(String str2) {
            }

            public void onRewardAdPlayError(WindAdError windAdError, String str2) {
            }

            public void onRewardAdPlayStart(String str2) {
                if (SigmobCustomRewardAdapter.this.sigmobCustomRewardAd != null) {
                    SigmobCustomRewardAdapter sigmobCustomRewardAdapter = SigmobCustomRewardAdapter.this;
                    sigmobCustomRewardAdapter.onAdExposure(sigmobCustomRewardAdapter.sigmobCustomRewardAd);
                }
            }

            public void onRewardAdPreLoadFail(String str2) {
            }

            public void onRewardAdPreLoadSuccess(String str2) {
            }

            public void onRewardAdRewarded(WindRewardInfo windRewardInfo, String str2) {
                if (SigmobCustomRewardAdapter.this.sigmobCustomRewardAd != null) {
                    SigmobCustomRewardAdapter sigmobCustomRewardAdapter = SigmobCustomRewardAdapter.this;
                    sigmobCustomRewardAdapter.onReward(sigmobCustomRewardAdapter.sigmobCustomRewardAd, null);
                }
            }
        });
        this.windRewardVideoAd.loadAd();
    }

    @Override // com.meishu.sdk.platform.custom.reward.MsCustomRewardAdapter
    public void loadCustomAd(String str, String str2, final String str3, String str4) {
        SigmobCustomInitManager.getInstance().initSdk(this.context, str, str2, new SigmobCustomInitManager.InitCallback() { // from class: com.meishu.sdk.platform.sigmob.custom.reward.SigmobCustomRewardAdapter.1
            @Override // com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager.InitCallback
            public void onError(int i, String str5) {
            }

            @Override // com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager.InitCallback
            public void onSuccess() {
                SigmobCustomRewardAdapter.this.loadAdWithCallback(str3);
            }
        });
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.windRewardVideoAd != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put("AUCTION_PRICE", Integer.valueOf(Integer.parseInt(this.windRewardVideoAd.getEcpm())));
                    map.put("HIGHEST_LOSS_PRICE", Integer.valueOf(t0.a(Integer.parseInt(this.windRewardVideoAd.getEcpm()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    map.put("CURRENCY", Constant.KEY_CURRENCYTYPE_CNY);
                    this.windRewardVideoAd.sendWinNotificationWithInfo(map);
                } else {
                    HashMap map2 = new HashMap();
                    map2.put("AUCTION_PRICE", Integer.valueOf(i));
                    map2.put("CURRENCY", Constant.KEY_CURRENCYTYPE_CNY);
                    map2.put("LOSS_REASON", Integer.valueOf(WindAdBiddingLossReason.LOSS_REASON_LOW_PRICE.getCode()));
                    this.windRewardVideoAd.sendLossNotificationWithInfo(map2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
