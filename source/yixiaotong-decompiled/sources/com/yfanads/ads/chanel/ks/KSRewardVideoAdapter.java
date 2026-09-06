package com.yfanads.ads.chanel.ks;

import android.app.Activity;
import android.content.Context;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
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
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class KSRewardVideoAdapter extends RewardCustomAdapter implements KsRewardVideoAd.RewardAdInteractionListener {
    KsRewardVideoAd ad;

    @Override // com.yfanads.android.custom.RewardCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
    }

    public KSRewardVideoAdapter(YFRewardVideoSetting yFRewardVideoSetting) {
        super(yFRewardVideoSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.KS.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        KSUtil.initAD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ks.KSRewardVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                KSRewardVideoAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                KSRewardVideoAdapter.this.handleFailed(str, str2);
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
        KSUtil.checkAppID(context, this.sdkSupplier.getAdnAppId(), this.tag);
        HashMap map = new HashMap();
        map.put("thirdUserId", getUserId());
        map.put("extraData", getJsonStr());
        KsAdSDK.getLoadManager().loadRewardVideoAd(new KsScene.Builder(KSUtil.getAdId(this.sdkSupplier)).rewardCallbackExtraData(map).build(), new KsLoadManager.RewardVideoAdListener() { // from class: com.yfanads.ads.chanel.ks.KSRewardVideoAdapter.2
            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onError(int i, String str) {
                YFLog.high(KSRewardVideoAdapter.this.tag + " onError ");
                KSRewardVideoAdapter.this.handleFailed(i, str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoResult(List<KsRewardVideoAd> list) {
                YFLog.high(KSRewardVideoAdapter.this.tag + "onRewardVideoResult  ");
                if (YFListUtils.isEmpty(list)) {
                    KSRewardVideoAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                    return;
                }
                KSRewardVideoAdapter.this.ad = list.get(0);
                KSRewardVideoAdapter kSRewardVideoAdapter = KSRewardVideoAdapter.this;
                kSRewardVideoAdapter.setEcpm(kSRewardVideoAdapter.ad.getECPM());
                if (KSRewardVideoAdapter.this.ad != null) {
                    KSRewardVideoAdapter.this.ad.setRewardAdInteractionListener(KSRewardVideoAdapter.this);
                }
                KSRewardVideoAdapter.this.handleSucceed();
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoAdLoad(List<KsRewardVideoAd> list) {
                YFLog.high(KSRewardVideoAdapter.this.tag + " onRewardVideoAdLoad");
                if (YFListUtils.isEmpty(list)) {
                    YFLog.error("onRewardVideoAdLoad fail");
                } else {
                    KSRewardVideoAdapter.this.setVideoCached(true);
                    KSRewardVideoAdapter.this.handleCached();
                }
            }
        });
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        KsRewardVideoAd ksRewardVideoAd = this.ad;
        return ksRewardVideoAd != null ? KSUtil.getReqId(ksRewardVideoAd.getMediaExtraInfo()) : "";
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onAdClicked() {
        YFLog.high(this.tag + " onAdClicked");
        handleClick();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onPageDismiss() {
        YFLog.high(this.tag + " onPageDismiss");
        handleClose();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayError(int i, int i2) {
        YFLog.error(this.tag + (" onVideoPlayError,code = " + i + ",extra = " + i2));
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayEnd() {
        YFLog.high(this.tag + " onVideoPlayEnd");
        handleVideoComplete();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoSkipToEnd(long j) {
        YFLog.high(this.tag + " onVideoSkipToEnd，l=" + j);
        handleClose(true);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayStart() {
        YFLog.high(this.tag + " onVideoPlayStart");
        handleExposure();
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify() {
        YFLog.high(this.tag + " onRewardVerify 1");
        reportSdk(YFAdsConst.ReportETypeValue.SDK_REWARD.getValue());
        YFRewardServerCallBackInf yFRewardServerCallBackInf = new YFRewardServerCallBackInf();
        yFRewardServerCallBackInf.rewardInf = new YFRewardServerCallBackInf.KsRewardInf();
        if (this.rewardSetting != null) {
            yFRewardServerCallBackInf.rewardInf.setAppExtra(this.rewardSetting.getAppExtra());
        }
        handleReward(yFRewardServerCallBackInf);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify(Map<String, Object> map) {
        YFLog.high(this.tag + " onRewardVerify 2");
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardStepVerify(int i, int i2) {
        YFLog.high(this.tag + " onRewardStepVerify , taskType :" + i + "，currentTaskStatus = " + i2);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onExtraRewardVerify(int i) {
        YFLog.high(this.tag + " onExtraRewardVerify , extraRewardType :" + i);
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter
    public void doShowAD(Activity activity) {
        YFLog.debug(this.tag + " doShowAD soundEnable:" + (!this.sdkSupplier.isMute()));
        KsVideoPlayConfig ksVideoPlayConfigBuild = new KsVideoPlayConfig.Builder().videoSoundEnable(!this.sdkSupplier.isMute()).showLandscape(getOrientation() != 1).build();
        if (activity != null) {
            this.ad.showRewardVideoAd(activity, ksVideoPlayConfigBuild);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        KsRewardVideoAd ksRewardVideoAd = this.ad;
        if (ksRewardVideoAd != null) {
            ksRewardVideoAd.setBidEcpm(ksRewardVideoAd.getECPM(), sdkSupplier != null ? sdkSupplier.ecpm : 0L);
            String shortString = "";
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        KsRewardVideoAd ksRewardVideoAd = this.ad;
        return ksRewardVideoAd != null && ksRewardVideoAd.isAdEnable();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (this.ad == null || sdkSupplier == null) {
            return;
        }
        this.ad.reportAdExposureFailed(2, KSUtil.getAdExposureFailedReason(sdkSupplier, getSDKSupplier()));
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }
}
