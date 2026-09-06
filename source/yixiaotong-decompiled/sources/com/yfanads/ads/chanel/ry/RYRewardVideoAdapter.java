package com.yfanads.ads.chanel.ry;

import android.app.Activity;
import android.content.Context;
import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.reward.RewardAdLoadListener;
import com.hihonor.adsdk.base.api.reward.RewardExpressAd;
import com.hihonor.adsdk.base.api.reward.RewardItem;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.reward.RewardAdLoad;
import com.yfanads.ads.chanel.ry.utils.RYUtil;
import com.yfanads.android.core.reward.YFRewardServerCallBackInf;
import com.yfanads.android.core.reward.YFRewardVideoSetting;
import com.yfanads.android.custom.RewardCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class RYRewardVideoAdapter extends RewardCustomAdapter implements RewardAdLoadListener {
    RewardExpressAd ad;

    public RYRewardVideoAdapter(YFRewardVideoSetting yFRewardVideoSetting) {
        super(yFRewardVideoSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.RY.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        RYUtil.initRY(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ry.RYRewardVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                RYRewardVideoAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                RYRewardVideoAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        return isStartShow();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.rewardSetting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else {
            new RewardAdLoad.Builder().setRewardAdLoadListener(this).setAdSlot(new AdSlot.Builder().setSlotId(this.sdkSupplier.getPotId()).build()).build().loadAd();
        }
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter
    public void doShowAD(Activity activity) {
        RewardExpressAd rewardExpressAd = this.ad;
        if (rewardExpressAd != null) {
            rewardExpressAd.setAdListener(new AdListener() { // from class: com.yfanads.ads.chanel.ry.RYRewardVideoAdapter.2
                @Override // com.hihonor.adsdk.base.callback.AdListener
                public void onAdClosed() {
                    YFLog.debug(RYRewardVideoAdapter.this.tag + " onAdClosed ");
                    RYRewardVideoAdapter.this.handleClose();
                }

                @Override // com.hihonor.adsdk.base.callback.AdListener
                public void onAdSkip(int i) {
                    YFLog.debug(RYRewardVideoAdapter.this.tag + " onAdSkip ");
                    RYRewardVideoAdapter.this.handleClose(true);
                }

                @Override // com.hihonor.adsdk.base.callback.AdListener
                public void onAdClicked() {
                    YFLog.debug(RYRewardVideoAdapter.this.tag + " onAdClicked ");
                    RYRewardVideoAdapter.this.handleClick();
                }

                @Override // com.hihonor.adsdk.base.callback.AdListener
                public void onAdImpression() {
                    YFLog.debug(RYRewardVideoAdapter.this.tag + " onAdImpression ");
                    RYRewardVideoAdapter.this.handleExposure();
                }

                @Override // com.hihonor.adsdk.base.callback.AdListener
                public void onAdImpressionFailed(int i, String str) {
                    YFLog.debug(RYRewardVideoAdapter.this.tag + " onAdImpressionFailed ");
                    if (RYRewardVideoAdapter.this.isStartShow()) {
                        RYRewardVideoAdapter.this.handleRenderFailed(i, str);
                    }
                }

                @Override // com.hihonor.adsdk.base.callback.AdListener
                public void onMiniAppStarted() {
                    super.onMiniAppStarted();
                }
            });
            this.ad.show(activity, new RewardExpressAd.RewardAdStatusListener() { // from class: com.yfanads.ads.chanel.ry.RYRewardVideoAdapter.3
                @Override // com.hihonor.adsdk.base.api.reward.RewardExpressAd.RewardAdStatusListener
                public void onRewardAdClosed() {
                    YFLog.debug(RYRewardVideoAdapter.this.tag + " onRewardAdClosed ");
                    RYRewardVideoAdapter.this.handleClose();
                }

                @Override // com.hihonor.adsdk.base.api.reward.RewardExpressAd.RewardAdStatusListener
                public void onVideoError(int i) {
                    YFLog.high(RYRewardVideoAdapter.this.tag + "onVideoError " + i);
                }

                @Override // com.hihonor.adsdk.base.api.reward.RewardExpressAd.RewardAdStatusListener
                public void onRewardAdOpened() {
                    YFLog.debug(RYRewardVideoAdapter.this.tag + " onRewardAdOpened ");
                }

                @Override // com.hihonor.adsdk.base.api.reward.RewardExpressAd.RewardAdStatusListener
                public void onRewarded(RewardItem rewardItem) {
                    try {
                        YFLog.high(RYRewardVideoAdapter.this.tag + " onReward");
                        RYRewardVideoAdapter.this.reportSdk(YFAdsConst.ReportETypeValue.SDK_REWARD.getValue());
                        YFRewardServerCallBackInf yFRewardServerCallBackInf = new YFRewardServerCallBackInf();
                        yFRewardServerCallBackInf.rewardInf = new YFRewardServerCallBackInf.RyRewardInf(rewardItem.getType(), 0.0d);
                        if (RYRewardVideoAdapter.this.rewardSetting != null) {
                            yFRewardServerCallBackInf.rewardInf.setAppExtra(RYRewardVideoAdapter.this.rewardSetting.getAppExtra());
                        }
                        RYRewardVideoAdapter.this.handleReward(yFRewardServerCallBackInf);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        RewardExpressAd rewardExpressAd = this.ad;
        if (rewardExpressAd != null) {
            rewardExpressAd.release();
            this.ad = null;
        }
    }

    @Override // com.hihonor.adsdk.base.api.reward.RewardAdLoadListener
    public void onLoadSuccess(RewardExpressAd rewardExpressAd) {
        YFLog.high(this.tag + " onLoadSuccess");
        this.ad = rewardExpressAd;
        handleSucceed();
        setVideoCached(true);
        handleCached();
    }

    @Override // com.hihonor.adsdk.base.callback.BaseListener
    public void onFailed(String str, String str2) {
        handleFailed(str, str2);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        RewardExpressAd rewardExpressAd = this.ad;
        if (rewardExpressAd != null) {
            rewardExpressAd.sendWinNotification(sdkSupplier != null ? (int) sdkSupplier.ecpm : 0L);
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
        RewardExpressAd rewardExpressAd = this.ad;
        if (rewardExpressAd == null || sdkSupplier == null) {
            return;
        }
        rewardExpressAd.sendLossNotification(sdkSupplier.ecpm, ErrorCode.AD_BID_FAILED, sdkSupplier.getAdnId());
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }
}
