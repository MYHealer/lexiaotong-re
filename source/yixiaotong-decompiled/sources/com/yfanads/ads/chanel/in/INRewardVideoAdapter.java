package com.yfanads.ads.chanel.in;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ubixnow.adtype.reward.api.UMNRewardAd;
import com.ubixnow.adtype.reward.api.UMNRewardListener;
import com.ubixnow.adtype.reward.api.UMNRewardParams;
import com.ubixnow.core.api.UMNError;
import com.ubixnow.core.bean.UMNAdInfo;
import com.yfanads.ads.chanel.in.utils.INUtil;
import com.yfanads.android.core.reward.YFRewardServerCallBackInf;
import com.yfanads.android.core.reward.YFRewardVideoSetting;
import com.yfanads.android.custom.RewardCustomAdapter;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class INRewardVideoAdapter extends RewardCustomAdapter implements UMNRewardListener {
    private UMNRewardAd rewardAd;

    @Override // com.ubixnow.adtype.reward.api.UMNRewardListener
    public void onVideoSkip() {
    }

    public INRewardVideoAdapter(YFRewardVideoSetting yFRewardVideoSetting) {
        super(yFRewardVideoSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.IN.getValue();
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        release("doDestroy");
    }

    private void release(String str) {
        try {
            UMNRewardAd uMNRewardAd = this.rewardAd;
            if (uMNRewardAd != null) {
                uMNRewardAd.destroy();
                this.rewardAd = null;
            }
        } catch (Exception e) {
            YFLog.error(this.tag + str + e.getMessage());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        INUtil.initIN(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.in.INRewardVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                INRewardVideoAdapter iNRewardVideoAdapter = INRewardVideoAdapter.this;
                iNRewardVideoAdapter.startLoadAD(iNRewardVideoAdapter.getContext());
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YFLog.error(INRewardVideoAdapter.this.tag + " onNoAd msg:" + str + "_" + str2);
                INRewardVideoAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        UMNRewardAd uMNRewardAd = new UMNRewardAd(context, new UMNRewardParams.Builder().setSlotId(getPotID()).build(), this);
        this.rewardAd = uMNRewardAd;
        uMNRewardAd.loadAd();
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter
    public void doShowAD(Activity activity) {
        super.doShowAD(activity);
        showTemplateADs(activity);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        UMNRewardAd uMNRewardAd = this.rewardAd;
        return uMNRewardAd != null ? uMNRewardAd.getRequestId() : "";
    }

    private void showTemplateADs(Activity activity) {
        if (this.rewardAd != null) {
            if (activity != null && !activity.isFinishing()) {
                this.rewardAd.show(activity);
                return;
            } else {
                handleShowFailed(this.tag + " activity is null");
                return;
            }
        }
        handleShowFailed(this.tag + " interstitialAd is null");
    }

    @Override // com.ubixnow.adtype.reward.api.UMNRewardListener
    public void onAdLoadSuccess(UMNAdInfo uMNAdInfo) {
        UMNRewardAd uMNRewardAd;
        YFLog.debug("onLoadAdSuccess");
        if (uMNAdInfo != null && (uMNRewardAd = this.rewardAd) != null && uMNRewardAd.getEcpmInfo() != null) {
            String ecpm = this.rewardAd.getEcpmInfo().getEcpm();
            if (!TextUtils.isEmpty(ecpm)) {
                setEcpmByStr(ecpm);
            }
        }
        handleSucceed();
        setVideoCached(true);
        handleCached();
    }

    @Override // com.ubixnow.adtype.reward.api.UMNRewardListener
    public void onAdClicked() {
        YFLog.debug(IAdInterListener.AdCommandType.AD_CLICK);
        handleClick();
    }

    @Override // com.ubixnow.adtype.reward.api.UMNRewardListener
    public void onAdDismiss() {
        YFLog.debug("onAdDismiss");
        handleClose();
    }

    @Override // com.ubixnow.adtype.reward.api.UMNRewardListener
    public void onAdShow() {
        YFLog.debug("onAdShow");
        handleExposure();
    }

    @Override // com.ubixnow.adtype.reward.api.UMNRewardListener
    public void onVideoPlayStart() {
        YFLog.debug("onVideoPlayStart");
    }

    @Override // com.ubixnow.adtype.reward.api.UMNRewardListener
    public void onVideoPlayComplete() {
        YFLog.debug("onVideoPlayComplete");
        handleVideoComplete();
    }

    @Override // com.ubixnow.adtype.reward.api.UMNRewardListener
    public void onRewardVerify() {
        YFLog.debug("onRewardVerify");
        try {
            reportSdk(YFAdsConst.ReportETypeValue.SDK_REWARD.getValue());
            YFRewardServerCallBackInf.RewardInf rewardInf = new YFRewardServerCallBackInf.RewardInf(YFRewardServerCallBackInf.Type.IN);
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

    @Override // com.ubixnow.adtype.reward.api.UMNRewardListener
    public void onVideoPlayError(UMNError uMNError) {
        try {
            YFLog.debug("onVideoPlayError " + uMNError.code + "|" + uMNError.msg);
            handleShowFailed();
        } catch (Exception e) {
            YFLog.error(this.tag + " onError:" + e.getMessage());
        }
    }

    @Override // com.ubixnow.adtype.reward.api.UMNRewardListener
    public void onError(UMNError uMNError) {
        try {
            YFLog.debug("onLoadAdFail " + uMNError.code + "|" + uMNError.msg);
            handleFailed(YFAdError.parseErr(uMNError.code, uMNError.msg));
        } catch (Exception e) {
            YFLog.error(this.tag + " onError:" + e.getMessage());
        }
    }
}
