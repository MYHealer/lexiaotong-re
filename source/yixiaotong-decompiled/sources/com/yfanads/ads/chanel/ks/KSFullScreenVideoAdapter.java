package com.yfanads.ads.chanel.ks;

import android.app.Activity;
import android.content.Context;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
import com.yfanads.android.core.full.YFFullScreenVideoSetting;
import com.yfanads.android.custom.FullScreenCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class KSFullScreenVideoAdapter extends FullScreenCustomAdapter implements KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {
    KsFullScreenVideoAd ad;

    @Override // com.yfanads.android.custom.FullScreenCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
    }

    public KSFullScreenVideoAdapter(YFFullScreenVideoSetting yFFullScreenVideoSetting) {
        super(yFFullScreenVideoSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.KS.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        KSUtil.initAD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ks.KSFullScreenVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                KSFullScreenVideoAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                KSFullScreenVideoAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.mFullSetting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
            return;
        }
        KSUtil.checkAppID(context, this.sdkSupplier.getAdnAppId(), this.tag);
        KsAdSDK.getLoadManager().loadFullScreenVideoAd(new KsScene.Builder(KSUtil.getAdId(this.sdkSupplier)).build(), new KsLoadManager.FullScreenVideoAdListener() { // from class: com.yfanads.ads.chanel.ks.KSFullScreenVideoAdapter.2
            @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
            public void onError(int i, String str) {
                YFLog.high(KSFullScreenVideoAdapter.this.tag + " onError " + i + str);
                KSFullScreenVideoAdapter.this.handleFailed(i, str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
            public void onFullScreenVideoResult(List<KsFullScreenVideoAd> list) {
                YFLog.high(KSFullScreenVideoAdapter.this.tag + "onFullScreenVideoResult  ");
            }

            @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
            public void onFullScreenVideoAdLoad(List<KsFullScreenVideoAd> list) {
                YFLog.high(KSFullScreenVideoAdapter.this.tag + " onFullScreenVideoAdLoad");
                if (list != null) {
                    try {
                        if (list.size() != 0 && list.get(0) != null) {
                            KSFullScreenVideoAdapter.this.ad = list.get(0);
                            KSFullScreenVideoAdapter kSFullScreenVideoAdapter = KSFullScreenVideoAdapter.this;
                            kSFullScreenVideoAdapter.setEcpm(kSFullScreenVideoAdapter.ad.getECPM());
                            if (KSFullScreenVideoAdapter.this.ad != null && KSFullScreenVideoAdapter.this.ad.isAdEnable()) {
                                KSFullScreenVideoAdapter.this.ad.setFullScreenVideoAdInteractionListener(KSFullScreenVideoAdapter.this);
                            }
                            KSFullScreenVideoAdapter.this.handleSucceed();
                            return;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        KSFullScreenVideoAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                        return;
                    }
                }
                KSFullScreenVideoAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
            }
        });
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        KsFullScreenVideoAd ksFullScreenVideoAd = this.ad;
        return ksFullScreenVideoAd != null && ksFullScreenVideoAd.isAdEnable() && super.isReady();
    }

    @Override // com.yfanads.android.custom.FullScreenCustomAdapter
    public void doShowAD(Activity activity) {
        KsVideoPlayConfig ksVideoPlayConfigBuild = new KsVideoPlayConfig.Builder().videoSoundEnable(!this.sdkSupplier.isMute()).showLandscape(false).build();
        if (activity != null) {
            this.ad.showFullScreenVideoAd(activity, ksVideoPlayConfigBuild);
        } else {
            handleShowFailed("activity is null");
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        KsFullScreenVideoAd ksFullScreenVideoAd = this.ad;
        return ksFullScreenVideoAd != null ? KSUtil.getReqId(ksFullScreenVideoAd.getMediaExtraInfo()) : "";
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        KsFullScreenVideoAd ksFullScreenVideoAd = this.ad;
        if (ksFullScreenVideoAd != null) {
            ksFullScreenVideoAd.setBidEcpm(ksFullScreenVideoAd.getECPM(), sdkSupplier != null ? sdkSupplier.ecpm : 0L);
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
        if (this.ad == null || sdkSupplier == null) {
            return;
        }
        this.ad.reportAdExposureFailed(2, KSUtil.getAdExposureFailedReason(sdkSupplier, getSDKSupplier()));
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClicked() {
        YFLog.high(this.tag + " onAdClicked");
        handleClick();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onPageDismiss() {
        YFLog.high(this.tag + " onPageDismiss");
        handleClose();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayError(int i, int i2) {
        YFLog.error(this.tag + (" onVideoPlayError,code = " + i + ",extra = " + i2));
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayEnd() {
        YFLog.high(this.tag + " onVideoPlayEnd");
        handleVideoComplete();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayStart() {
        YFLog.high(this.tag + " onVideoPlayStart");
        handleExposure();
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        YFLog.high(this.tag + " onSkippedVideo");
        handleClose(true);
    }
}
