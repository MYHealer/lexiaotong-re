package com.yfanads.ads.chanel.zd;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.reward.RewardAdEventListener;
import com.meishu.sdk.core.ad.reward.RewardVideoAd;
import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.yfanads.ads.chanel.zd.utils.ZDUtil;
import com.yfanads.android.core.reward.YFRewardServerCallBackInf;
import com.yfanads.android.core.reward.YFRewardVideoSetting;
import com.yfanads.android.custom.RewardCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ZDRewardVideoAdapter extends RewardCustomAdapter implements RewardAdEventListener, InteractionListener {
    private RewardVideoLoader adLoader;
    private RewardVideoAd rewardVideoAd;

    public ZDRewardVideoAdapter(YFRewardVideoSetting yFRewardVideoSetting) {
        super(yFRewardVideoSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        ZDUtil.initZD(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.zd.ZDRewardVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                ZDRewardVideoAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YFLog.error(ZDRewardVideoAdapter.this.tag + " onNoAd msg:" + str + "_" + str2);
                ZDRewardVideoAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        try {
            if (context instanceof Activity) {
                YFLog.high(this.tag + " doLoadAD start -- ");
                RewardVideoLoader rewardVideoLoader = new RewardVideoLoader((Activity) context, new MsAdSlot.Builder().setPid(getPotID()).setVideoMute(true).setFetchCount(1).build(), this);
                this.adLoader = rewardVideoLoader;
                rewardVideoLoader.loadAd();
                YFLog.high(this.tag + " doLoadAD end -- ");
            } else {
                handleFailed(YFAdError.parseErr(YFAdError.ERROR_MEISHU_CONTEXT));
            }
        } catch (Exception e) {
            try {
                YFLog.error(this.tag + " doLoadAD error:" + e.getMessage());
            } catch (Exception e2) {
                YFLog.error(this.tag + " doLoadAD error:" + e2.getMessage());
            }
        }
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        handleShowApiInvoke();
        YFLog.high(this.tag + " doShowAD -- " + activity);
        RewardVideoAd rewardVideoAd = this.rewardVideoAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.showAd(activity);
        } else {
            handleShowFailed(this.tag + " ad is null");
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        RewardVideoAd rewardVideoAd = this.rewardVideoAd;
        return (rewardVideoAd == null || rewardVideoAd.getData() == null) ? "" : this.rewardVideoAd.getData().getReqId();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        RewardVideoAd rewardVideoAd = this.rewardVideoAd;
        if (rewardVideoAd != null) {
            return rewardVideoAd.isAdValid();
        }
        return super.isReady();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        if (this.rewardVideoAd != null) {
            HashMap map = new HashMap();
            String shortString = "";
            map.put("winPrice", Integer.valueOf(YFUtil.toInt(getEcpm() + "", 0)));
            map.put("highestLossPrice", Integer.valueOf(sdkSupplier != null ? YFUtil.toInt(sdkSupplier.ecpm + "", 0) : 0));
            this.rewardVideoAd.sendWinNotification(map);
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
        HashMap map = new HashMap();
        map.put("winPrice", Integer.valueOf(YFUtil.toInt(sdkSupplier.ecpm + "", 0)));
        map.put("lossReason", 1);
        map.put("adnId", 2);
        this.rewardVideoAd.sendLossNotification(map);
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        YFLog.high(this.tag + "doDestroy");
        super.doDestroy();
        RewardVideoAd rewardVideoAd = this.rewardVideoAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.destroy();
            this.rewardVideoAd = null;
        }
        RewardVideoLoader rewardVideoLoader = this.adLoader;
        if (rewardVideoLoader != null) {
            rewardVideoLoader.destroy();
            this.adLoader = null;
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.ZD.getValue();
    }

    @Override // com.meishu.sdk.core.ad.IAdEventListener
    public void onAdError(AdErrorInfo adErrorInfo) {
        try {
            YFLog.debug("onAdFailed " + adErrorInfo);
            handleFailed(adErrorInfo.getErrorType(), " ad fail " + adErrorInfo.getMessage());
        } catch (Exception e) {
            YFLog.error(this.tag + " onError:" + e.getMessage());
        }
    }

    @Override // com.meishu.sdk.core.ad.IAdEventListener
    public void onAdReady(RewardVideoAd rewardVideoAd) {
        try {
            if (rewardVideoAd == null) {
                handleFailed(YFAdError.ERROR_DATA_NULL, this.tag + " KsSplashScreenAd null");
                return;
            }
            this.rewardVideoAd = rewardVideoAd;
            rewardVideoAd.setInteractionListener(this);
            if (rewardVideoAd.getData() != null) {
                setEcpmByStr(rewardVideoAd.getData().getEcpm());
            }
            handleSucceed();
        } catch (Throwable unused) {
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_LOAD));
        }
    }

    @Override // com.meishu.sdk.core.loader.InteractionListener
    public void onAdClicked() {
        YFLog.debug("onAdClicked ");
        handleClick();
    }

    @Override // com.meishu.sdk.core.loader.InteractionListener
    public void onAdExposure() {
        YFLog.debug("onAdExposure");
        handleExposure();
    }

    @Override // com.meishu.sdk.core.loader.InteractionListener
    public void onAdClosed() {
        YFLog.debug("onAdClosed ");
        handleClose();
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardAdEventListener
    public void onVideoCached(RewardVideoAd rewardVideoAd) {
        YFLog.debug("onVideoRewarded");
        setVideoCached(true);
        handleCached();
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardAdEventListener
    public void onReward(Map<String, Object> map) {
        YFLog.debug("onVideoRewarded");
        try {
            reportSdk(YFAdsConst.ReportETypeValue.SDK_REWARD.getValue());
            YFRewardServerCallBackInf.RewardInf rewardInf = new YFRewardServerCallBackInf.RewardInf(YFRewardServerCallBackInf.Type.ZD);
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
}
