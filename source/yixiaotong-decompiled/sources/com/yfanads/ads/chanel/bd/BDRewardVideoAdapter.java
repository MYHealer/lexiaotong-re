package com.yfanads.ads.chanel.bd;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.yfanads.ads.chanel.bd.utils.BDUtil;
import com.yfanads.android.core.reward.YFRewardServerCallBackInf;
import com.yfanads.android.core.reward.YFRewardVideoSetting;
import com.yfanads.android.custom.RewardCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class BDRewardVideoAdapter extends RewardCustomAdapter implements RewardVideoAd.RewardVideoAdListener {
    private RewardVideoAd mRewardVideoAd;

    public BDRewardVideoAdapter(YFRewardVideoSetting yFRewardVideoSetting) {
        super(yFRewardVideoSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        BDUtil.initBDAccount(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.bd.BDRewardVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                BDRewardVideoAdapter bDRewardVideoAdapter = BDRewardVideoAdapter.this;
                bDRewardVideoAdapter.startLoadAD(bDRewardVideoAdapter.getContext());
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                BDRewardVideoAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.rewardSetting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
            return;
        }
        this.mRewardVideoAd = new RewardVideoAd(context, this.sdkSupplier.getPotId(), this, false);
        InitBean initBean = getInitBean();
        if (initBean != null && !TextUtils.isEmpty(initBean.appId)) {
            YFLog.high(this.tag + " setAppSid:" + initBean.appId);
            this.mRewardVideoAd.setAppSid(initBean.appId);
        }
        this.mRewardVideoAd.setExtraInfo(getJsonStr());
        this.mRewardVideoAd.setUserId(getUserId());
        this.mRewardVideoAd.load();
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter
    public void doShowAD(Activity activity) {
        YFLog.high(this.tag + " doShowAD--");
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        if (rewardVideoAd == null) {
            handleShowFailed();
        } else {
            rewardVideoAd.setShowDialogOnSkip(true);
            this.mRewardVideoAd.show();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        return rewardVideoAd != null ? BDUtil.getReqId(rewardVideoAd.getAdDataForKey("request_id")) : "";
    }

    /* JADX INFO: renamed from: lambda$sendSucBiddingResult$0$com-yfanads-ads-chanel-bd-BDRewardVideoAdapter, reason: not valid java name */
    /* synthetic */ void m1070xb2d65818(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-win: " + z + " msg信息：" + str);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.biddingSuccess(BDUtil.getWindBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDRewardVideoAdapter$$ExternalSyntheticLambda0
                @Override // com.baidu.mobads.sdk.api.BiddingListener
                public final void onBiddingResult(boolean z, String str, HashMap map) {
                    this.f$0.m1070xb2d65818(z, str, map);
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

    /* JADX INFO: renamed from: lambda$sendLossBiddingResult$1$com-yfanads-ads-chanel-bd-BDRewardVideoAdapter, reason: not valid java name */
    /* synthetic */ void m1069xa9a64643(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-loss: " + z + " msg信息：" + str);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        if (rewardVideoAd == null || sdkSupplier == null) {
            return;
        }
        rewardVideoAd.biddingFail(BDUtil.getLossBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDRewardVideoAdapter$$ExternalSyntheticLambda1
            @Override // com.baidu.mobads.sdk.api.BiddingListener
            public final void onBiddingResult(boolean z, String str, HashMap map) {
                this.f$0.m1069xa9a64643(z, str, map);
            }
        });
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        if (this.mRewardVideoAd != null) {
            this.mRewardVideoAd = null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdShow() {
        YFLog.high(this.tag + "onAdShow");
        handleExposure();
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdClick() {
        YFLog.high(this.tag + IAdInterListener.AdCommandType.AD_CLICK);
        handleClick();
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdClose(float f) {
        YFLog.high(this.tag + "onAdClose " + f);
        handleClose();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        return rewardVideoAd != null && rewardVideoAd.isReady();
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdFailed(String str) {
        YFLog.error(this.tag + "onAdFailed ，reason ：" + str);
        handleFailed(YFAdError.ERROR_BD_FAILED, str);
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onVideoDownloadSuccess() {
        YFLog.high(this.tag + "onVideoDownloadSuccess");
        setVideoCached(true);
        handleCached();
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onVideoDownloadFailed() {
        YFLog.error(this.tag + "onVideoDownloadFailed");
        setVideoCacheFailed(true);
        handleCacheFail();
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void playCompletion() {
        YFLog.high(this.tag + "playCompletion");
        handleVideoComplete();
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdSkip(float f) {
        YFLog.high(this.tag + " onSkip: playScale = " + f);
        handleClose(true);
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
    public void onRewardVerify(boolean z, Map<String, Object> map) {
        try {
            YFLog.high(this.tag + " onRewardVerify : rewardVerify = " + z);
            reportSdk(YFAdsConst.ReportETypeValue.SDK_REWARD.getValue());
            YFRewardServerCallBackInf yFRewardServerCallBackInf = new YFRewardServerCallBackInf();
            yFRewardServerCallBackInf.rewardInf = new YFRewardServerCallBackInf.BDRewardInf(z);
            if (this.rewardSetting != null) {
                yFRewardServerCallBackInf.rewardInf.setAppExtra(this.rewardSetting.getAppExtra());
            }
            handleReward(yFRewardServerCallBackInf);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdLoaded() {
        RewardVideoAd rewardVideoAd;
        YFLog.high(this.tag + "onAdLoaded");
        if (isBidding() && (rewardVideoAd = this.mRewardVideoAd) != null) {
            setEcpmByStr(rewardVideoAd.getECPMLevel());
        }
        handleSucceed();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.BAIDU.getValue();
    }
}
