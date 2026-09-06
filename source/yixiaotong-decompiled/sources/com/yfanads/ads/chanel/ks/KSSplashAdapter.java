package com.yfanads.ads.chanel.ks;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
import com.yfanads.android.core.splash.YFSplashSetting;
import com.yfanads.android.custom.SplashCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class KSSplashAdapter extends SplashCustomAdapter implements KsSplashScreenAd.SplashScreenAdInteractionListener {
    private KsSplashScreenAd splashAd;

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        if (this.splashAd != null) {
            this.splashAd = null;
        }
    }

    public KSSplashAdapter(YFSplashSetting yFSplashSetting) {
        super(yFSplashSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.KS.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        KSUtil.initAD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ks.KSSplashAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                KSSplashAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                KSSplashAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append("isReady ").append(this.splashAd != null).append(PPSLabelView.Code);
        KsSplashScreenAd ksSplashScreenAd = this.splashAd;
        YFLog.debug(sbAppend.append(ksSplashScreenAd != null && ksSplashScreenAd.isAdEnable()).append(" super:").append(super.isReady()).toString());
        KsSplashScreenAd ksSplashScreenAd2 = this.splashAd;
        return ksSplashScreenAd2 != null && ksSplashScreenAd2.isAdEnable() && super.isReady();
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.mSplashSetting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else {
            KSUtil.checkAppID(context, this.sdkSupplier.getAdnAppId(), this.tag);
            loadSplashAd(context);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        KsSplashScreenAd ksSplashScreenAd = this.splashAd;
        return ksSplashScreenAd != null ? KSUtil.getReqId(ksSplashScreenAd.getMediaExtraInfo()) : "";
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter
    public void loadSplashAd(Context context) {
        int[] sizePx = getSizePx();
        boolean z = false;
        KsAdSDK.getLoadManager().loadSplashScreenAd(new KsScene.Builder(KSUtil.getAdId(this.sdkSupplier)).width(sizePx[0]).height(sizePx[1]).build(), new KsLoadManager.SplashScreenAdListener() { // from class: com.yfanads.ads.chanel.ks.KSSplashAdapter.2
            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onError(int i, String str) {
                YFLog.high(KSSplashAdapter.this.tag + " onError " + str + " appid: " + KsAdSDK.getAppId() + " adid:" + KSUtil.getAdId(KSSplashAdapter.this.sdkSupplier));
                KSSplashAdapter.this.handleFailed(i, str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onRequestResult(int i) {
                YFLog.high(KSSplashAdapter.this.tag + "onRequestResult，广告填充数量：" + i);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
                YFLog.high(KSSplashAdapter.this.tag + "onSplashScreenAdLoad");
                try {
                    if (ksSplashScreenAd != null) {
                        KSSplashAdapter.this.splashAd = ksSplashScreenAd;
                        KSSplashAdapter kSSplashAdapter = KSSplashAdapter.this;
                        kSSplashAdapter.setEcpm(kSSplashAdapter.splashAd.getECPM());
                        KSSplashAdapter.this.handleSucceed();
                        return;
                    }
                    KSSplashAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, KSSplashAdapter.this.tag + " KsSplashScreenAd null");
                } catch (Throwable th) {
                    th.printStackTrace();
                    KSSplashAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_LOAD));
                }
            }
        });
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append("doLoadAD-- ").append(Arrays.toString(sizePx)).append(" px, ");
        if (this.mSplashSetting != null && this.mSplashSetting.isCustom()) {
            z = true;
        }
        YFLog.high(sbAppend.append(z).toString());
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        handleShowApiInvoke();
        if (YFUtil.isActivityDestroyed(activity)) {
            handleShowFailed(this.tag + " activity is Destroyed~");
        } else {
            doShowTemplateAD(activity, viewGroup);
        }
    }

    private void doShowTemplateAD(Activity activity, ViewGroup viewGroup) {
        KsSplashScreenAd ksSplashScreenAd = this.splashAd;
        if (ksSplashScreenAd != null) {
            View view = ksSplashScreenAd.getView(activity, this);
            if (view != null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                doShowAD(viewGroup, view);
                return;
            } else {
                handleShowFailed(this.tag + " splashAd.getView() == null");
                return;
            }
        }
        handleShowFailed(this.tag + " splashAd == null");
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        KsSplashScreenAd ksSplashScreenAd = this.splashAd;
        if (ksSplashScreenAd != null) {
            ksSplashScreenAd.setBidEcpm(ksSplashScreenAd.getECPM(), sdkSupplier != null ? sdkSupplier.ecpm : 0L);
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
        if (this.splashAd == null || sdkSupplier == null) {
            return;
        }
        this.splashAd.reportAdExposureFailed(2, KSUtil.getAdExposureFailedReason(sdkSupplier, getSDKSupplier()));
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdClicked() {
        YFLog.high(this.tag + "onAdClicked");
        handleClick();
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowError(int i, String str) {
        YFLog.high(this.tag + "onAdShowError, code " + i);
        if (isStartShow()) {
            handleRenderFailed(i, str);
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowEnd() {
        YFLog.high(this.tag + "onAdShowEnd");
        handleClose(false);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowStart() {
        YFLog.high(this.tag + "onAdShowStart");
        handleExposure();
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onSkippedAd() {
        YFLog.high(this.tag + "onSkippedAd");
        handleClose(true);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onDownloadTipsDialogShow() {
        YFLog.high(this.tag + "onDownloadTipsDialogShow");
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onDownloadTipsDialogDismiss() {
        YFLog.high(this.tag + "onDownloadTipsDialogDismiss");
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onDownloadTipsDialogCancel() {
        YFLog.high(this.tag + "onDownloadTipsDialogCancel");
    }
}
