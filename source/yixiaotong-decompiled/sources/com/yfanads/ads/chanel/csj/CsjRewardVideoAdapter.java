package com.yfanads.ads.chanel.csj;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.cdo.oaps.ad.OapsKey;
import com.yfanads.ads.chanel.csj.utils.CsjUtil;
import com.yfanads.android.core.reward.YFRewardServerCallBackInf;
import com.yfanads.android.core.reward.YFRewardVideoSetting;
import com.yfanads.android.custom.RewardCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class CsjRewardVideoAdapter extends RewardCustomAdapter implements TTAdNative.RewardVideoAdListener, TTRewardVideoAd.RewardAdInteractionListener {
    protected String ecpm;
    protected TTRewardVideoAd ttRewardVideoAd;

    protected boolean useMediation() {
        return false;
    }

    public CsjRewardVideoAdapter(YFRewardVideoSetting yFRewardVideoSetting) {
        super(yFRewardVideoSetting);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onError(int i, String str) {
        YFLog.high(this.tag + "onError，" + i + str);
        handleFailed(YFAdError.parseErr(i, str));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
        try {
            YFLog.high(this.tag + "onRewardVideoAdLoad");
            this.ttRewardVideoAd = tTRewardVideoAd;
            if (isBidding()) {
                updPrice();
                setEcpmByStr(this.ecpm);
            }
            handleSucceed();
        } catch (Throwable th) {
            th.printStackTrace();
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_LOAD));
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        TTRewardVideoAd tTRewardVideoAd = this.ttRewardVideoAd;
        return tTRewardVideoAd != null ? CsjUtil.getReqId(tTRewardVideoAd.getMediaExtraInfo()) : "";
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoCached() {
        YFLog.high(this.tag + "onRewardVideoCached");
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
        YFLog.high(this.tag + "onRewardVideoCached");
        setVideoCached(true);
        handleCached();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        CsjUtil.initCsj(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.csj.CsjRewardVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                CsjRewardVideoAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                CsjRewardVideoAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.rewardSetting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else {
            CsjUtil.getADManger().createAdNative(context).loadRewardVideoAd(new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(500.0f, 500.0f).setUserID(YFAdsPhone.getInstance().getDeviceId()).setOrientation(getOrientation() == 1 ? 1 : 2).setMediaExtra(getJsonStr()).setMediationAdSlot(new MediationAdSlot.Builder().setMuted(this.sdkSupplier.isMute()).setVolume(0.7f).setBidNotify(true).build()).setUserID(getUserId()).build(), this);
        }
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        try {
            TTRewardVideoAd tTRewardVideoAd = this.ttRewardVideoAd;
            if (tTRewardVideoAd != null && tTRewardVideoAd.getMediationManager() != null) {
                this.ttRewardVideoAd.getMediationManager().destroy();
            }
            this.ttRewardVideoAd = null;
            YFLog.debug(this.tag + " doDestroy ");
        } catch (Exception e) {
            YFLog.error(this.tag + " doDestroy " + e.getMessage());
        }
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter
    public void doShowAD(Activity activity) {
        if (this.ttRewardVideoAd == null) {
            handleShowFailed();
            return;
        }
        if (isBidding()) {
            this.ttRewardVideoAd.setPrice(Double.valueOf(YFUtil.toDouble(this.ecpm, 1.0d)));
        }
        this.ttRewardVideoAd.setRewardAdInteractionListener(this);
        if (activity != null) {
            this.ttRewardVideoAd.showRewardVideoAd(activity);
        }
    }

    public void onAdItemRewardVerify(boolean z, int i, int i2, String str, int i3, String str2, float f) {
        try {
            YFLog.high(this.tag + "onRewardVerify; rewardVerify = " + z + ",rewardAmount = " + i2 + ",rewardName = " + str + " errorCode:" + i3 + " errMsg:" + str2);
            reportSdk(YFAdsConst.ReportETypeValue.SDK_REWARD.getValue());
            YFRewardServerCallBackInf yFRewardServerCallBackInf = new YFRewardServerCallBackInf();
            yFRewardServerCallBackInf.rewardInf = new YFRewardServerCallBackInf.CsjRewardInf(z, i, i2, str, f, i3, str2);
            if (this.rewardSetting != null) {
                yFRewardServerCallBackInf.rewardInf.setAppExtra(this.rewardSetting.getAppExtra());
            }
            handleReward(yFRewardServerCallBackInf);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.CSJ.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isBidding() {
        return this.sdkSupplier != null && this.sdkSupplier.isBidding() && CsjUtil.isSupportBidding;
    }

    protected void updPrice() {
        try {
            TTRewardVideoAd tTRewardVideoAd = this.ttRewardVideoAd;
            if (tTRewardVideoAd == null || tTRewardVideoAd.getMediaExtraInfo() == null) {
                return;
            }
            Object obj = this.ttRewardVideoAd.getMediaExtraInfo().get(OapsKey.KEY_PRICE);
            if (obj == null) {
                obj = "1";
            }
            this.ecpm = String.valueOf(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        TTRewardVideoAd tTRewardVideoAd = this.ttRewardVideoAd;
        if (tTRewardVideoAd != null) {
            tTRewardVideoAd.win(Double.valueOf(sdkSupplier != null ? sdkSupplier.ecpm : YFUtil.toDouble(this.ecpm, 1.0d)));
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
        TTRewardVideoAd tTRewardVideoAd = this.ttRewardVideoAd;
        if (tTRewardVideoAd == null || sdkSupplier == null) {
            return;
        }
        tTRewardVideoAd.loss(Double.valueOf(sdkSupplier.ecpm), "102", CsjUtil.getAdnName(sdkSupplier.getAdnId()));
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        TTRewardVideoAd tTRewardVideoAd = this.ttRewardVideoAd;
        return (tTRewardVideoAd == null || tTRewardVideoAd.getMediationManager() == null || !this.ttRewardVideoAd.getMediationManager().isReady()) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdShow() {
        TTRewardVideoAd tTRewardVideoAd;
        MediationAdEcpmInfo showEcpm;
        if (isGromoreAdn() && isBidding() && (tTRewardVideoAd = this.ttRewardVideoAd) != null && tTRewardVideoAd.getMediationManager() != null && (showEcpm = this.ttRewardVideoAd.getMediationManager().getShowEcpm()) != null) {
            String mShowEcpm = CsjUtil.getMShowEcpm(showEcpm);
            this.ecpm = mShowEcpm;
            if (!TextUtils.isEmpty(mShowEcpm)) {
                setEcpmByStr(this.ecpm);
            }
        }
        YFLog.high(this.tag + "onAdShow ep_" + this.ecpm);
        handleExposure();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdVideoBarClick() {
        YFLog.high(this.tag + "onAdVideoBarClick");
        handleClick();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdClose() {
        YFLog.high(this.tag + "onAdClose");
        handleClose();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoComplete() {
        YFLog.high(this.tag + "onVideoComplete");
        handleVideoComplete();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoError() {
        YFLog.error(this.tag + " onVideoError");
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
        YFLog.high(this.tag + " onRewardVerify");
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onRewardArrived(boolean z, int i, Bundle bundle) {
        YFLog.high(this.tag + " onRewardArrived");
        onAdItemRewardVerify(z, i, bundle.getInt("reward_extra_key_reward_amount"), bundle.getString("reward_extra_key_reward_name"), bundle.getInt("reward_extra_key_error_code"), bundle.getString("reward_extra_key_error_msg"), bundle.getFloat("reward_extra_key_reward_propose"));
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onSkippedVideo() {
        YFLog.high(this.tag + "onSkippedVideo");
        handleClose(true);
    }

    private boolean isGromoreAdn() {
        return getAdnId() == YFAdsConst.ReportAdnIdValue.CSJ_GROMORE.getValue();
    }
}
