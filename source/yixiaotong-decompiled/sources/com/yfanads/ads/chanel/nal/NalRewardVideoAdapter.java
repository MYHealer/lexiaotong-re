package com.yfanads.ads.chanel.nal;

import android.app.Activity;
import android.content.Context;
import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.AdRequest;
import com.adprof.sdk.api.IBiddingNotify;
import com.adprof.sdk.api.RewardAd;
import com.adprof.sdk.api.RewardAdListener;
import com.yfanads.ads.chanel.nal.utils.NalUtil;
import com.yfanads.android.core.reward.YFRewardServerCallBackInf;
import com.yfanads.android.core.reward.YFRewardVideoSetting;
import com.yfanads.android.custom.RewardCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class NalRewardVideoAdapter extends RewardCustomAdapter implements RewardAdListener {
    private RewardAd rewardAd;

    @Override // com.adprof.sdk.api.RewardAdListener
    public void onRewardAdPlayStart() {
    }

    public NalRewardVideoAdapter(YFRewardVideoSetting yFRewardVideoSetting) {
        super(yFRewardVideoSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.NAL.getValue();
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        release("doDestroy");
    }

    private void release(String str) {
        try {
            RewardAd rewardAd = this.rewardAd;
            if (rewardAd != null) {
                rewardAd.destroyAd();
                this.rewardAd = null;
            }
        } catch (Exception e) {
            YFLog.error(this.tag + str + e.getMessage());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        NalUtil.initNal(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.nal.NalRewardVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                NalRewardVideoAdapter nalRewardVideoAdapter = NalRewardVideoAdapter.this;
                nalRewardVideoAdapter.startLoadAD(nalRewardVideoAdapter.getContext());
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YFLog.error(NalRewardVideoAdapter.this.tag + " onNoAd msg:" + str + "_" + str2);
                NalRewardVideoAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        RewardAd rewardAd = new RewardAd(new AdRequest.Builder().setCodeId(getPotID()).setBidFloor(1).build(), this);
        this.rewardAd = rewardAd;
        rewardAd.loadAd();
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter
    public void doShowAD(Activity activity) {
        showTemplateADs(activity);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        try {
            RewardAd rewardAd = this.rewardAd;
            return (rewardAd == null || YFListUtils.isMapEmpty(rewardAd.getExtraInfo())) ? "" : (String) this.rewardAd.getExtraInfo().get("loadId");
        } catch (Exception e) {
            YFLog.error(this.tag + " getAdReqId " + e.getMessage());
            return "";
        }
    }

    private void showTemplateADs(Activity activity) {
        if (this.rewardAd != null) {
            if (activity != null && !activity.isFinishing()) {
                this.rewardAd.showAd(activity);
                return;
            } else {
                handleShowFailed(this.tag + " activity is null");
                return;
            }
        }
        handleShowFailed(this.tag + " reward is null");
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        if (this.rewardAd != null) {
            HashMap map = new HashMap();
            map.put(IBiddingNotify.WIN_FIRST_PRICE, Long.valueOf(getEcpm()));
            String shortString = "";
            map.put(IBiddingNotify.WIN_HIGHEST_LOSS_PRICE, sdkSupplier != null ? Long.valueOf(sdkSupplier.ecpm) : "");
            this.rewardAd.sendWinNotify(map);
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (this.rewardAd != null) {
            HashMap map = new HashMap();
            map.put(IBiddingNotify.LOSS_FIRST_PRICE, Long.valueOf(sdkSupplier.ecpm));
            map.put(IBiddingNotify.LOSS_REASON, 100);
            this.rewardAd.sendWinNotify(map);
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
    }

    @Override // com.adprof.sdk.api.RewardAdListener
    public void onRewardAdLoadSuccess() {
        YFLog.debug("onRewardAdLoadSuccess");
        RewardAd rewardAd = this.rewardAd;
        if (rewardAd != null) {
            setEcpm(rewardAd.getBidPrice());
        }
        handleSucceed();
    }

    @Override // com.adprof.sdk.api.RewardAdListener
    public void onRewardAdLoadCached() {
        YFLog.debug("onRewardAdLoadCached");
        setVideoCached(true);
        handleCached();
    }

    @Override // com.adprof.sdk.api.RewardAdListener
    public void onRewardAdShow() {
        YFLog.debug("onRewardAdShow");
        handleExposure();
    }

    @Override // com.adprof.sdk.api.RewardAdListener
    public void onRewardAdPlayEnd() {
        YFLog.debug("onRewardAdPlayEnd");
        handleVideoComplete();
    }

    @Override // com.adprof.sdk.api.RewardAdListener
    public void onRewardAdClick() {
        YFLog.debug("onRewardAdClick");
        handleClick();
    }

    @Override // com.adprof.sdk.api.RewardAdListener
    public void onRewardAdClosed() {
        YFLog.debug("onRewardAdClosed");
        handleClose();
    }

    @Override // com.adprof.sdk.api.RewardAdListener
    public void onRewardAdLoadError(AdError adError) {
        try {
            YFLog.debug("onLoadAdFail " + adError.getErrorCode() + "|" + adError.getMessage());
            handleFailed(YFAdError.parseErr(adError.getErrorCode(), adError.getMessage()));
        } catch (Exception e) {
            YFLog.error(this.tag + " onError:" + e.getMessage());
        }
    }

    @Override // com.adprof.sdk.api.RewardAdListener
    public void onRewardAdShowError(AdError adError) {
        try {
            YFLog.debug("showError " + adError.getErrorCode() + "|" + adError.getMessage());
            handleShowFailed();
        } catch (Exception e) {
            YFLog.error(this.tag + " onError:" + e.getMessage());
        }
    }

    @Override // com.adprof.sdk.api.RewardAdListener
    public void onRewardVerify() {
        try {
            reportSdk(YFAdsConst.ReportETypeValue.SDK_REWARD.getValue());
            YFRewardServerCallBackInf.RewardInf rewardInf = new YFRewardServerCallBackInf.RewardInf(YFRewardServerCallBackInf.Type.NAL);
            if (this.rewardSetting != null) {
                rewardInf.setAppExtra(this.rewardSetting.getAppExtra());
            }
            YFRewardServerCallBackInf yFRewardServerCallBackInf = new YFRewardServerCallBackInf();
            yFRewardServerCallBackInf.rewardInf = rewardInf;
            handleReward(yFRewardServerCallBackInf);
        } catch (Exception e) {
            YFLog.error(this.tag + " onRewardVerify:" + e.getMessage());
        }
    }

    @Override // com.adprof.sdk.api.RewardAdListener
    public void onAdSkip() {
        YFLog.debug("onAdSkip");
    }
}
