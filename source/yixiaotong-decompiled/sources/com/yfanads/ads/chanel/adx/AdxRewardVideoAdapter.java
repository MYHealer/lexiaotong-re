package com.yfanads.ads.chanel.adx;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.yfanads.ads.chanel.adx.utils.AdxSdkUtil;
import com.yfanads.android.adx.AdxSDK;
import com.yfanads.android.adx.api.AdVideoPlayConfig;
import com.yfanads.android.adx.api.AdxScene;
import com.yfanads.android.adx.api.LoadManager;
import com.yfanads.android.adx.core.model.AdxNativeAd;
import com.yfanads.android.adx.service.a;
import com.yfanads.android.adx.service.c;
import com.yfanads.android.core.reward.YFRewardServerCallBackInf;
import com.yfanads.android.core.reward.YFRewardVideoSetting;
import com.yfanads.android.custom.RewardCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.FeedCom;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class AdxRewardVideoAdapter extends RewardCustomAdapter implements AdxNativeAd.RewardAdInteractionListener {
    private static final String TAG = "AdxRewardVideoAdapter";
    private AdxNativeAd nativeAds;
    private String userId;

    public AdxRewardVideoAdapter(YFRewardVideoSetting yFRewardVideoSetting) {
        super(yFRewardVideoSetting);
        this.userId = getUserId();
    }

    private void bindData(Activity activity) {
        boolean zIsInit = AdxSDK.isInit();
        if (this.nativeAds == null || !zIsInit) {
            YFLog.debug("AdxRewardVideoAdapter nativeAds is null or not init, return. " + zIsInit);
            handleShowFailed();
            return;
        }
        YFLog.debug("AdxRewardVideoAdapter adId = " + this.sdkSupplier.getAdId() + " showNativeADs = " + this.nativeAds.getMaterialType());
        if (isBidding()) {
            AdxNativeAd adxNativeAd = this.nativeAds;
            adxNativeAd.setBidEcpm(adxNativeAd.getECPM(), 0L);
        }
        BaseTemplateData baseTemplateData = new BaseTemplateData("");
        baseTemplateData.setConf(this.sdkSupplier.getTemplateConf());
        if (!this.isSupportShake && baseTemplateData.isAction()) {
            if (baseTemplateData.isOnlyAction()) {
                baseTemplateData.setWholeClick();
            }
            baseTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER.getValue());
        }
        this.nativeAds.setAdsListener(a.REWARD, this);
        AdVideoPlayConfig adVideoPlayConfigBuild = new AdVideoPlayConfig.Builder().videoAutoPlayType(1).videoSoundEnable(true ^ isMute()).build();
        if (activity != null) {
            FeedCom feedCom = new FeedCom(c.a.f9618a.e, AdxSdkUtil.getReqAdId(this.sdkSupplier), getRequestId());
            Map<String, Object> appExtra = this.rewardSetting.getAppExtra();
            if (appExtra == null) {
                appExtra = new HashMap<>();
            }
            Map<String, Object> map = appExtra;
            map.put("adID", this.sdkSupplier.getAdId());
            map.put("adnAppID", this.sdkSupplier.getAdnAppId());
            map.put("adnAdID", this.sdkSupplier.getAdnAdId());
            map.put("adnID", this.sdkSupplier.getAdnId());
            this.nativeAds.showRewardVideoAd(activity, adVideoPlayConfigBuild, this.sdkSupplier.getTemplateConf(), map, feedCom);
        }
    }

    private boolean isMute() {
        TemplateConf templateConf = this.sdkSupplier.getTemplateConf();
        return templateConf == null || templateConf.vm == 1;
    }

    private boolean isSVSupport() {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        return sdkSupplier == null || sdkSupplier.getTemplateConf() == null || this.sdkSupplier.getTemplateConf().sv != 1 || !TextUtils.isEmpty(this.userId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadByNative() {
        if (!isSVSupport()) {
            handleFailed(YFAdError.REWARD_SERVER_FAIL, "open server verify, but not has userId");
        } else {
            AdxSDK.getLoadManager().loadNativeAd(new AdxScene.Builder(AdxSdkUtil.getAdId(this.sdkSupplier)).setEcpm(getEcpm()).setReqId(getRequestId()).adStyle(7).build(), new LoadManager.NativeAdListener() { // from class: com.yfanads.ads.chanel.adx.AdxRewardVideoAdapter.2
                @Override // com.yfanads.android.adx.api.LoadManager.NativeAdListener
                public void onError(int i, String str) {
                    YFLog.high("AdxRewardVideoAdapter onError " + i + str);
                    AdxRewardVideoAdapter.this.handleFailed(i, str);
                }

                /* JADX WARN: Code duplicated, block: B:10:0x0041 A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #0 {all -> 0x0049, blocks: (B:4:0x0009, B:6:0x000f, B:9:0x0017, B:10:0x0041), top: B:16:0x0009 }] */
                @Override // com.yfanads.android.adx.api.LoadManager.NativeAdListener
                public void onNativeAdLoad(List<AdxNativeAd> list) {
                    YFLog.high("AdxRewardVideoAdapteronNativeAdLoad");
                    if (list != null) {
                        try {
                            if (list.size() == 0 || list.get(0) == null) {
                                AdxRewardVideoAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                            } else {
                                AdxRewardVideoAdapter.this.nativeAds = list.get(0);
                                AdxRewardVideoAdapter adxRewardVideoAdapter = AdxRewardVideoAdapter.this;
                                adxRewardVideoAdapter.setEcpm(adxRewardVideoAdapter.nativeAds.getECPM());
                                AdxRewardVideoAdapter.this.handleSucceed();
                                AdxRewardVideoAdapter.this.setVideoCached(true);
                                AdxRewardVideoAdapter.this.handleCached();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                            AdxRewardVideoAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                        }
                    } else {
                        AdxRewardVideoAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                    }
                }
            });
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        AdxSdkUtil.initAD(this.tag, context, getInitBean(), isListPackage(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.adx.AdxRewardVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                AdxRewardVideoAdapter.this.handleFailed(str, str2);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                AdxRewardVideoAdapter.this.loadByNative();
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter
    public void doShowAD(Activity activity) {
        YFLog.debug("doShowAD");
        bindData(activity);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return AdxSdkUtil.getAdInfo(this.nativeAds, getRequestId());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.ADX.getValue();
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
        return false;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener2
    public void onAdClose(AdxNativeAd adxNativeAd) {
        YFLog.debug("AdxRewardVideoAdapter onAdClose ");
        this.nativeAds.reportAdInfo(18, null);
        handleClose();
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onAdHide() {
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onAdShow() {
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onExposure(boolean z) {
        if (z) {
            handleExposure();
        } else {
            handleFailed(YFAdError.ERROR_ADX_EXPOSURE, "exposure url empty");
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onHandleClick(boolean z) {
        YFLog.debug(this.tag + " onAdClicked");
        handleClick(z);
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.RewardAdInteractionListener
    public void onRewardVerify(boolean z, String str) {
        YFLog.high(this.tag + " onRewardVerify " + z + "|" + str);
        reportSdk(YFAdsConst.ReportETypeValue.SDK_REWARD.getValue());
        YFRewardServerCallBackInf yFRewardServerCallBackInf = new YFRewardServerCallBackInf();
        YFRewardServerCallBackInf.YFRewardInf yFRewardInf = new YFRewardServerCallBackInf.YFRewardInf(z);
        yFRewardServerCallBackInf.rewardInf = yFRewardInf;
        YFRewardVideoSetting yFRewardVideoSetting = this.rewardSetting;
        if (yFRewardVideoSetting != null) {
            yFRewardInf.setAppExtra(yFRewardVideoSetting.getAppExtra());
        }
        handleReward(yFRewardServerCallBackInf);
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        AdxNativeAd adxNativeAd = this.nativeAds;
        if (adxNativeAd != null) {
            adxNativeAd.destroy(a.REWARD);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        AdxNativeAd adxNativeAd = this.nativeAds;
        if (adxNativeAd != null) {
            adxNativeAd.reportAdInfo(19, null);
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=");
            SdkSupplier sdkSupplier2 = this.sdkSupplier;
            String shortString = "";
            StringBuilder sbAppend2 = sbAppend.append(sdkSupplier2 != null ? sdkSupplier2.toShortString() : "").append(" loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend2.append(shortString).toString());
        }
    }
}
