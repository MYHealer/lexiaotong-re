package com.yfanads.ads.chanel.hw;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.BiddingParam;
import com.huawei.hms.ads.ReportUrlListener;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.reward.Reward;
import com.huawei.hms.ads.reward.RewardAd;
import com.huawei.hms.ads.reward.RewardAdLoadListener;
import com.huawei.hms.ads.reward.RewardAdStatusListener;
import com.unionpay.tsmservice.data.Constant;
import com.yfanads.ads.chanel.hw.utls.HwUtil;
import com.yfanads.android.core.reward.YFRewardServerCallBackInf;
import com.yfanads.android.core.reward.YFRewardVideoSetting;
import com.yfanads.android.custom.RewardCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class HwRewardVideoAdapter extends RewardCustomAdapter {
    private RewardAd rewardedAd;

    public HwRewardVideoAdapter(YFRewardVideoSetting yFRewardVideoSetting) {
        super(yFRewardVideoSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        HwUtil.initHw(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.hw.HwRewardVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                HwRewardVideoAdapter.this.loadRewardAd(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                HwRewardVideoAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadRewardAd(Context context) {
        if (this.isDestroy || this.rewardSetting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
            return;
        }
        this.rewardedAd = new RewardAd(context, getPotID());
        AdParam.Builder builder = new AdParam.Builder();
        if (isBidding()) {
            BiddingParam.Builder builder2 = new BiddingParam.Builder();
            builder2.setBidFloor(Float.valueOf(getEcpm()));
            builder2.setBidFloorCur(Constant.KEY_CURRENCYTYPE_CNY);
            builder.addBiddingParamMap(this.sdkSupplier.getPotId(), builder2.build());
        }
        this.rewardedAd.loadAd(builder.build(), new RewardAdLoadListener() { // from class: com.yfanads.ads.chanel.hw.HwRewardVideoAdapter.2
            @Override // com.huawei.hms.ads.reward.RewardAdLoadListener
            public void onRewardedLoaded() {
                YFLog.high(HwRewardVideoAdapter.this.tag + " onRewardAdLoaded");
                if (HwRewardVideoAdapter.this.isBidding()) {
                    HwRewardVideoAdapter.this.setEcpm();
                }
                HwRewardVideoAdapter.this.handleSucceed();
                HwRewardVideoAdapter.this.setVideoCached(true);
                HwRewardVideoAdapter.this.handleCached();
            }

            @Override // com.huawei.hms.ads.reward.RewardAdLoadListener
            public void onRewardAdFailedToLoad(int i) {
                YFLog.high(HwRewardVideoAdapter.this.tag + " onRewardAdFailedToLoad " + i);
                HwRewardVideoAdapter.this.handleFailed(i, "");
            }
        });
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter
    public void doShowAD(Activity activity) {
        showRewardAd(activity);
    }

    private void showRewardAd(Activity activity) {
        RewardAd rewardAd = this.rewardedAd;
        if (rewardAd != null && rewardAd.isLoaded()) {
            VideoConfiguration.Builder builder = new VideoConfiguration.Builder();
            builder.setAutoPlayNetwork(1);
            builder.setStartMuted(this.sdkSupplier.isMuted());
            this.rewardedAd.setVideoConfiguration(builder.build());
            this.rewardedAd.show(activity, new RewardAdStatusListener() { // from class: com.yfanads.ads.chanel.hw.HwRewardVideoAdapter.3
                @Override // com.huawei.hms.ads.reward.RewardAdStatusListener
                public void onRewardAdClosed() {
                    if (HwRewardVideoAdapter.this.isStartShow() || HwRewardVideoAdapter.this.isExposure()) {
                        HwRewardVideoAdapter.this.handleClose();
                    }
                }

                @Override // com.huawei.hms.ads.reward.RewardAdStatusListener
                public void onRewardAdFailedToShow(int i) {
                    YFLog.error(HwRewardVideoAdapter.this.tag + " onRewardAdFailedToShow: " + i);
                    HwRewardVideoAdapter.this.handleRenderFailed(i, "");
                }

                @Override // com.huawei.hms.ads.reward.RewardAdStatusListener
                public void onRewardAdOpened() {
                    HwRewardVideoAdapter.this.handleExposure();
                }

                @Override // com.huawei.hms.ads.reward.RewardAdStatusListener
                public void onRewarded(Reward reward) {
                    try {
                        YFLog.high(HwRewardVideoAdapter.this.tag + " onReward");
                        HwRewardVideoAdapter.this.reportSdk(YFAdsConst.ReportETypeValue.SDK_REWARD.getValue());
                        YFRewardServerCallBackInf yFRewardServerCallBackInf = new YFRewardServerCallBackInf();
                        yFRewardServerCallBackInf.rewardInf = new YFRewardServerCallBackInf.RewardInf(YFRewardServerCallBackInf.Type.HW);
                        if (HwRewardVideoAdapter.this.rewardSetting != null) {
                            yFRewardServerCallBackInf.rewardInf.setAppExtra(HwRewardVideoAdapter.this.rewardSetting.getAppExtra());
                        }
                        HwRewardVideoAdapter.this.handleReward(yFRewardServerCallBackInf);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return;
        }
        handleShowFailed(this.tag + " rewardedAd is null, return. ");
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        RewardAd rewardAd = this.rewardedAd;
        if (rewardAd != null) {
            rewardAd.destroy();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        RewardAd rewardAd = this.rewardedAd;
        return rewardAd != null && rewardAd.isLoaded();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.HW.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEcpm() {
        try {
            RewardAd rewardAd = this.rewardedAd;
            if (rewardAd != null && rewardAd.isLoaded()) {
                BiddingInfo biddingInfo = this.rewardedAd.getBiddingInfo();
                if (biddingInfo != null && biddingInfo.getPrice() != null) {
                    setEcpmByStr(HwUtil.price2penny(biddingInfo.getPrice()));
                } else {
                    setEcpmByStr("0");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        RewardAd rewardAd = this.rewardedAd;
        if (rewardAd != null) {
            rewardAd.sendBiddingSuccess(HwUtil.getWinBiddingInfo(sdkSupplier), new ReportUrlListener() { // from class: com.yfanads.ads.chanel.hw.HwRewardVideoAdapter.4
                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportSuccess() {
                    YFLog.high(HwRewardVideoAdapter.this.tag + " sendBiddingSucResult reportSuccess");
                }

                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportFailed(String str, int i) {
                    YFLog.high(HwRewardVideoAdapter.this.tag + " sendBiddingSucResult reportFailed " + str + " code=" + i);
                }
            });
            String shortString = "";
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        RewardAd rewardAd = this.rewardedAd;
        if (rewardAd != null) {
            rewardAd.sendBiddingFailed(HwUtil.getLossBiddingInfo(sdkSupplier), new ReportUrlListener() { // from class: com.yfanads.ads.chanel.hw.HwRewardVideoAdapter.5
                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportSuccess() {
                    YFLog.high(HwRewardVideoAdapter.this.tag + " sendBiddingLossResult reportSuccess");
                }

                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportFailed(String str, int i) {
                    YFLog.high(HwRewardVideoAdapter.this.tag + " sendBiddingLossResult reportFailed " + str + " code=" + i);
                }
            });
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
    }
}
