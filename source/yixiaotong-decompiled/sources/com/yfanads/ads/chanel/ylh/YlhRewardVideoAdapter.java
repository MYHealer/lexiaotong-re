package com.yfanads.ads.chanel.ylh;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.util.AdError;
import com.yfanads.ads.chanel.ylh.utils.YlhUtil;
import com.yfanads.android.core.reward.YFRewardServerCallBackInf;
import com.yfanads.android.core.reward.YFRewardVideoSetting;
import com.yfanads.android.custom.RewardCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YlhRewardVideoAdapter extends RewardCustomAdapter implements RewardVideoADListener {
    public RewardVideoAD rewardVideoAd;

    @Override // com.yfanads.android.custom.RewardCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
    }

    public YlhRewardVideoAdapter(YFRewardVideoSetting yFRewardVideoSetting) {
        super(yFRewardVideoSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.YLH.getValue();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADLoad() {
        YFLog.high(this.tag + "onADLoad");
        RewardVideoAD rewardVideoAD = this.rewardVideoAd;
        if (rewardVideoAD != null) {
            setEcpm(rewardVideoAD.getECPM());
        }
        handleSucceed();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onVideoCached() {
        YFLog.high(this.tag + "onVideoCached");
        setVideoCached(true);
        handleCached();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADShow() {
        YFLog.high(this.tag + "onADShow");
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        RewardVideoAD rewardVideoAD = this.rewardVideoAd;
        return rewardVideoAD != null && rewardVideoAD.isValid();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADExpose() {
        YFLog.high(this.tag + "onADExpose");
        handleExposure();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onReward(Map<String, Object> map) {
        try {
            YFLog.high(this.tag + "onReward");
            reportSdk(YFAdsConst.ReportETypeValue.SDK_REWARD.getValue());
            YFRewardServerCallBackInf yFRewardServerCallBackInf = new YFRewardServerCallBackInf();
            yFRewardServerCallBackInf.rewardInf = new YFRewardServerCallBackInf.YlhRewardInf(!YFListUtils.isMapEmpty(map) ? (String) map.get("transId") : "");
            if (this.rewardSetting != null) {
                yFRewardServerCallBackInf.rewardInf.setAppExtra(this.rewardSetting.getAppExtra());
            }
            handleReward(yFRewardServerCallBackInf);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADClick() {
        YFLog.high(this.tag + "onADClick");
        handleClick();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onVideoComplete() {
        YFLog.high(this.tag + "onVideoComplete");
        handleVideoComplete();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADClose() {
        YFLog.high(this.tag + "onADClose");
        handleClose();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onError(AdError adError) {
        int errorCode;
        String errorMsg;
        if (adError != null) {
            try {
                errorCode = adError.getErrorCode();
                errorMsg = adError.getErrorMsg();
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        } else {
            errorCode = -1;
            errorMsg = "default onNoAD";
        }
        YFLog.high(this.tag + "onError");
        handleFailed(errorCode, errorMsg);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        YlhUtil.initAD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ylh.YlhRewardVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                YlhRewardVideoAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YlhRewardVideoAdapter.this.handleFailed(str, str2);
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
        this.rewardVideoAd = new RewardVideoAD(context, this.sdkSupplier.getPotId(), this, !this.sdkSupplier.isMuted());
        this.rewardVideoAd.setServerSideVerificationOptions(new ServerSideVerificationOptions.Builder().setCustomData(getJsonStr()).setUserId(getUserId()).build());
        this.rewardVideoAd.loadAD();
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter
    public void doShowAD(Activity activity) {
        if (checkRewardOk()) {
            this.rewardVideoAd.showAD();
        } else {
            YFLog.error(this.tag + " rewardVideoAd is null, return. ");
            handleShowFailed();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        RewardVideoAD rewardVideoAD = this.rewardVideoAd;
        return rewardVideoAD != null ? YlhUtil.getReqId(rewardVideoAD.getExtraInfo()) : "";
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        RewardVideoAD rewardVideoAD = this.rewardVideoAd;
        if (rewardVideoAD != null) {
            rewardVideoAD.sendWinNotification(YlhUtil.getWindBiddingMap(rewardVideoAD.getECPM(), sdkSupplier != null ? (int) sdkSupplier.ecpm : 0));
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
        if (this.rewardVideoAd == null || sdkSupplier == null) {
            return;
        }
        this.rewardVideoAd.sendLossNotification(YlhUtil.getLossBiddingMap((int) sdkSupplier.ecpm, YlhUtil.getAdnId(isBidding(), sdkSupplier, getSDKSupplier())));
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    public boolean checkRewardOk() {
        try {
            return this.rewardVideoAd.isValid();
        } catch (Throwable th) {
            YFLog.error("checkRewardOk : " + th.getMessage());
            return true;
        }
    }
}
