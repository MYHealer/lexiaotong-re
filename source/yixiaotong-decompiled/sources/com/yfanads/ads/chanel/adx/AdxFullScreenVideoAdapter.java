package com.yfanads.ads.chanel.adx;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.yfanads.ads.chanel.adx.utils.AdxSdkUtil;
import com.yfanads.android.adx.AdxSDK;
import com.yfanads.android.adx.api.AdVideoPlayConfig;
import com.yfanads.android.adx.api.AdxScene;
import com.yfanads.android.adx.api.LoadManager;
import com.yfanads.android.adx.core.model.AdxNativeAd;
import com.yfanads.android.adx.service.a;
import com.yfanads.android.adx.service.c;
import com.yfanads.android.core.full.YFFullScreenVideoSetting;
import com.yfanads.android.custom.FullScreenCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.FeedCom;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class AdxFullScreenVideoAdapter extends FullScreenCustomAdapter implements AdxNativeAd.AdInteractionListener2 {
    private static final String TAG = "AdxFullScreenVideoAdapter";
    private boolean isAuto;
    private AdxNativeAd nativeAds;
    private YFFullScreenVideoSetting setting;

    public AdxFullScreenVideoAdapter(YFFullScreenVideoSetting yFFullScreenVideoSetting) {
        super(yFFullScreenVideoSetting);
        this.setting = yFFullScreenVideoSetting;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadByNative() {
        AdxSDK.getLoadManager().loadNativeAd(new AdxScene.Builder(AdxSdkUtil.getAdId(this.sdkSupplier)).setEcpm(getEcpm()).setReqId(getRequestId()).adStyle(6).build(), new LoadManager.NativeAdListener() { // from class: com.yfanads.ads.chanel.adx.AdxFullScreenVideoAdapter.2
            @Override // com.yfanads.android.adx.api.LoadManager.NativeAdListener
            public void onError(int i, String str) {
                YFLog.high(AdxFullScreenVideoAdapter.this.tag + " onError " + i + str);
                AdxFullScreenVideoAdapter.this.handleFailed(i, str);
            }

            /* JADX WARN: Code duplicated, block: B:10:0x004b A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #0 {all -> 0x0053, blocks: (B:4:0x001e, B:6:0x0024, B:9:0x002c, B:10:0x004b), top: B:16:0x001e }] */
            @Override // com.yfanads.android.adx.api.LoadManager.NativeAdListener
            public void onNativeAdLoad(List<AdxNativeAd> list) {
                YFLog.high(AdxFullScreenVideoAdapter.this.tag + "onNativeAdLoad");
                if (list != null) {
                    try {
                        if (list.size() == 0 || list.get(0) == null) {
                            AdxFullScreenVideoAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                        } else {
                            AdxFullScreenVideoAdapter.this.nativeAds = list.get(0);
                            AdxFullScreenVideoAdapter adxFullScreenVideoAdapter = AdxFullScreenVideoAdapter.this;
                            adxFullScreenVideoAdapter.setEcpm(adxFullScreenVideoAdapter.nativeAds.getECPM());
                            AdxFullScreenVideoAdapter.this.handleSucceed();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        AdxFullScreenVideoAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                    }
                } else {
                    AdxFullScreenVideoAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                }
            }
        });
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        AdxSdkUtil.initAD(this.tag, context, getInitBean(), isListPackage(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.adx.AdxFullScreenVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                AdxFullScreenVideoAdapter.this.handleFailed(str, str2);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                AdxFullScreenVideoAdapter.this.loadByNative();
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.FullScreenCustomAdapter
    public void doShowAD(Activity activity) {
        YFLog.debug("AdxFullScreenVideoAdapter doShowAD ");
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
        YFLog.debug("AdxFullScreenVideoAdapter onAdClose ");
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
    public void onDownloadTipsDismiss() {
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onDownloadTipsShow() {
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
        YFLog.debug("AdxFullScreenVideoAdapter onHandleClick");
        handleClick(z);
    }

    private void bindData(Activity activity) {
        if (this.nativeAds == null) {
            YFLog.debug(this.tag + " nativeAds is null, return. ");
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_NATIVE));
            return;
        }
        YFLog.debug(this.tag + " adId = " + this.sdkSupplier.getAdId() + " showNativeADs = " + this.nativeAds.getMaterialType());
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
            baseTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        }
        this.isAuto = baseTemplateData.isAutoClick();
        this.nativeAds.setAdsListener(a.FULL_VIDEO, this);
        AdVideoPlayConfig adVideoPlayConfigBuild = new AdVideoPlayConfig.Builder().videoAutoPlayType(1).videoSoundEnable(true ^ this.sdkSupplier.isMute()).build();
        if (activity != null) {
            this.nativeAds.showFullScreenVideoAd(activity, adVideoPlayConfigBuild, this.sdkSupplier.getTemplateConf(), new FeedCom(c.a.f9618a.e, AdxSdkUtil.getReqAdId(this.sdkSupplier), getRequestId()));
        }
    }

    @Override // com.yfanads.android.custom.FullScreenCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        AdxNativeAd adxNativeAd = this.nativeAds;
        if (adxNativeAd != null) {
            adxNativeAd.destroy(a.FULL_VIDEO);
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
