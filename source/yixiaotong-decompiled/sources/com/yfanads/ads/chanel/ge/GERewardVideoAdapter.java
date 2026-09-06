package com.yfanads.ads.chanel.ge;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.constants.BiddingConst;
import com.fancy.adsdk.lib.interf.PtgRewardVideoAd;
import com.fancy.adsdk.lib.model.AdBidLossReason;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.yfanads.ads.chanel.ge.utils.GEUtil;
import com.yfanads.android.core.reward.YFRewardServerCallBackInf;
import com.yfanads.android.core.reward.YFRewardVideoSetting;
import com.yfanads.android.custom.RewardCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class GERewardVideoAdapter extends RewardCustomAdapter {
    private PtgRewardVideoAd rewardVideoAd;

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        return "";
    }

    public GERewardVideoAdapter(YFRewardVideoSetting yFRewardVideoSetting) {
        super(yFRewardVideoSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.GE.getValue();
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        release("doDestroy");
    }

    private void release(String str) {
        try {
            PtgRewardVideoAd ptgRewardVideoAd = this.rewardVideoAd;
            if (ptgRewardVideoAd != null) {
                ptgRewardVideoAd.destroy();
                this.rewardVideoAd = null;
            }
        } catch (Exception e) {
            YFLog.error(this.tag + str + e.getMessage());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        GEUtil.initGE(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ge.GERewardVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                GERewardVideoAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                GERewardVideoAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        PtgAdSdk.get().loadRewardVideoAd(context, new AdSlot.Builder().setPtgSlotId(this.sdkSupplier.getPotId()).build(), new PtgAdNative.RewardVideoAdListener() { // from class: com.yfanads.ads.chanel.ge.GERewardVideoAdapter.2
            @Override // com.fancy.adsdk.lib.provider.PtgAdNative.RewardVideoAdListener
            public void onRewardVideoAdLoad(PtgRewardVideoAd ptgRewardVideoAd) {
                YFLog.debug(GERewardVideoAdapter.this.tag + " onAdLoaded");
                GERewardVideoAdapter.this.rewardVideoAd = ptgRewardVideoAd;
                GERewardVideoAdapter.this.setEcpm(ptgRewardVideoAd.getEcpm());
                GERewardVideoAdapter.this.handleSucceed();
            }

            @Override // com.fancy.adsdk.lib.provider.PtgAdNative.RewardVideoAdListener
            public void onRewardVideoCached(PtgRewardVideoAd ptgRewardVideoAd) {
                YFLog.debug(GERewardVideoAdapter.this.tag + " onRewardVideoCached");
                GERewardVideoAdapter.this.setVideoCached(true);
                GERewardVideoAdapter.this.handleCached();
            }

            @Override // com.fancy.adsdk.lib.interf.Error
            public void onError(AdError adError) {
                YFLog.debug(GERewardVideoAdapter.this.tag + "onError code = " + adError.getErrorCode() + " msg = " + adError.getMessage());
                GERewardVideoAdapter.this.handleFailed(YFAdError.parseErr(adError.getErrorCode(), adError.getMessage()));
            }
        });
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter
    public void doShowAD(Activity activity) {
        super.doShowAD(activity);
        showTemplateADs(activity);
    }

    private void showTemplateADs(Activity activity) {
        if (this.rewardVideoAd != null) {
            if (activity != null && !activity.isFinishing()) {
                this.rewardVideoAd.setRewardAdInteractionListener(new PtgRewardVideoAd.RewardAdInteractionListener() { // from class: com.yfanads.ads.chanel.ge.GERewardVideoAdapter.3
                    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
                    public void onVideoPause() {
                    }

                    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
                    public void onVideoProgressUpdate(long j, long j2) {
                    }

                    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
                    public void onVideoResume() {
                    }

                    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
                    public void onAdShow() {
                        YFLog.debug(GERewardVideoAdapter.this.tag + "onAdShow");
                        GERewardVideoAdapter.this.handleExposure();
                    }

                    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
                    public void onAdVideoBarClick() {
                        YFLog.debug(GERewardVideoAdapter.this.tag + "onAdClicked");
                        GERewardVideoAdapter.this.handleClick();
                    }

                    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
                    public void onAdClose() {
                        YFLog.debug(GERewardVideoAdapter.this.tag + "onAdDismiss");
                        GERewardVideoAdapter.this.handleClose();
                    }

                    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
                    public void onRenderError(AdError adError) {
                        YFLog.debug(GERewardVideoAdapter.this.tag + "onRenderError");
                        GERewardVideoAdapter.this.handleRenderFailed();
                    }

                    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
                    public void onVideoComplete() {
                        YFLog.debug(GERewardVideoAdapter.this.tag + "onVideoComplete");
                        GERewardVideoAdapter.this.handleVideoComplete();
                    }

                    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
                    public void onVideoError(int i, String str) {
                        YFLog.debug(GERewardVideoAdapter.this.tag + "onVideoError " + i + "," + str);
                        GERewardVideoAdapter.this.handleRenderFailed();
                    }

                    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
                    public void onRewardVerify(boolean z, Bundle bundle) {
                        YFLog.debug(GERewardVideoAdapter.this.tag + "onRewardVerify " + z);
                        GERewardVideoAdapter.this.rewardCallback(z);
                    }

                    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
                    public void onSkippedVideo() {
                        YFLog.debug(GERewardVideoAdapter.this.tag + "onSkippedVideo");
                    }

                    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
                    public void onVideoStart() {
                        YFLog.debug(GERewardVideoAdapter.this.tag + "onVideoStart");
                    }
                });
                this.rewardVideoAd.showRewardVideoAd(activity);
                return;
            } else {
                handleShowFailed(this.tag + " activity is null");
                return;
            }
        }
        handleShowFailed(this.tag + " interstitialAd is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewardCallback(boolean z) {
        try {
            reportSdk(YFAdsConst.ReportETypeValue.SDK_REWARD.getValue());
            YFRewardServerCallBackInf.GERewardInf gERewardInf = new YFRewardServerCallBackInf.GERewardInf(z);
            if (this.rewardSetting != null) {
                gERewardInf.setAppExtra(this.rewardSetting.getAppExtra());
            }
            YFRewardServerCallBackInf yFRewardServerCallBackInf = new YFRewardServerCallBackInf();
            yFRewardServerCallBackInf.rewardInf = gERewardInf;
            handleReward(yFRewardServerCallBackInf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        PtgRewardVideoAd ptgRewardVideoAd = this.rewardVideoAd;
        if (ptgRewardVideoAd != null) {
            ptgRewardVideoAd.notifyBidWin(ptgRewardVideoAd.getEcpm(), sdkSupplier.ecpm);
            String shortString = "";
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append(" loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (this.rewardVideoAd == null || sdkSupplier == null) {
            return;
        }
        AdBidLossReason adBidLossReason = new AdBidLossReason();
        adBidLossReason.setLossCode(BiddingConst.BIDDING_LOSS.WITH_LOW_PRICE_IN_HB);
        adBidLossReason.setWinPrice(sdkSupplier.ecpm);
        adBidLossReason.setWinAdnId(BiddingConst.ADN_ID.LOSE_TO_OTHER_ADN);
        this.rewardVideoAd.notifyBidLoss(adBidLossReason);
    }
}
