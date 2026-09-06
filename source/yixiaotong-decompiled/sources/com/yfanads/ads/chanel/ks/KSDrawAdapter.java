package com.yfanads.ads.chanel.ks;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
import com.yfanads.android.core.draw.YFDrawSetting;
import com.yfanads.android.custom.DrawCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class KSDrawAdapter extends DrawCustomAdapter implements KsDrawAd.AdInteractionListener {
    private KsDrawAd drawAd;

    @Override // com.yfanads.android.custom.DrawCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
    }

    public KSDrawAdapter(YFDrawSetting yFDrawSetting) {
        super(yFDrawSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        KSUtil.initAD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ks.KSDrawAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                KSDrawAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                KSDrawAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        KSUtil.checkAppID(context, this.sdkSupplier.getAdnAppId(), this.tag);
        KsAdSDK.getLoadManager().loadDrawAd(new KsScene.Builder(KSUtil.getAdId(this.sdkSupplier)).build(), new KsLoadManager.DrawAdListener() { // from class: com.yfanads.ads.chanel.ks.KSDrawAdapter.2
            @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
            public void onError(int i, String str) {
                YFLog.high(KSDrawAdapter.this.tag + " onError " + i + str);
                KSDrawAdapter.this.handleFailed(i, str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
            public void onDrawAdLoad(List<KsDrawAd> list) {
                YFLog.high(KSDrawAdapter.this.tag + "onDrawAdLoad");
                if (list != null) {
                    try {
                        if (list.size() != 0 && list.get(0) != null) {
                            KSDrawAdapter.this.drawAd = list.get(0);
                            KSDrawAdapter kSDrawAdapter = KSDrawAdapter.this;
                            kSDrawAdapter.setEcpm(kSDrawAdapter.drawAd.getECPM());
                            if (KSDrawAdapter.this.drawAd != null) {
                                KSDrawAdapter.this.drawAd.setAdInteractionListener(KSDrawAdapter.this);
                            }
                            KSDrawAdapter.this.handleSucceed();
                            return;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        KSDrawAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                        return;
                    }
                }
                KSDrawAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
            }
        });
    }

    @Override // com.yfanads.android.custom.DrawCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        super.m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(activity, viewGroup);
        View drawView = this.drawAd.getDrawView(activity);
        if (this.sdkSupplier != null) {
            this.drawAd.setVideoSoundEnable(!this.sdkSupplier.isMute());
        }
        addADView(drawView, viewGroup);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        KsDrawAd ksDrawAd = this.drawAd;
        return ksDrawAd != null ? KSUtil.getReqId(ksDrawAd.getMediaExtraInfo()) : "";
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        KsDrawAd ksDrawAd = this.drawAd;
        if (ksDrawAd != null) {
            ksDrawAd.setBidEcpm(ksDrawAd.getECPM(), sdkSupplier != null ? sdkSupplier.ecpm : 0L);
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
        if (this.drawAd == null || sdkSupplier == null) {
            return;
        }
        this.drawAd.reportAdExposureFailed(2, KSUtil.getAdExposureFailedReason(sdkSupplier, getSDKSupplier()));
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdClicked() {
        YFLog.high(this.tag + " onAdClicked");
        handleClick();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdShow() {
        YFLog.high(this.tag + " onAdShow");
        handleExposure();
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayStart() {
        YFLog.high(this.tag + " onVideoPlayStart");
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayPause() {
        YFLog.high(this.tag + " onVideoPlayPause");
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayResume() {
        YFLog.high(this.tag + " onVideoPlayResume");
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayEnd() {
        YFLog.high(this.tag + " onVideoPlayEnd");
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayError() {
        YFLog.high(this.tag + " onVideoPlayError");
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.KS.getValue();
    }
}
