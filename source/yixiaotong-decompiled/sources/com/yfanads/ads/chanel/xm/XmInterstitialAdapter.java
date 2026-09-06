package com.yfanads.ads.chanel.xm;

import android.app.Activity;
import android.content.Context;
import com.cdo.oaps.ad.OapsKey;
import com.miui.zeus.mimo.sdk.ADParams;
import com.miui.zeus.mimo.sdk.InterstitialAd;
import com.yfanads.ads.chanel.xm.utils.XmUtil;
import com.yfanads.android.core.inter.YFInterstitialSetting;
import com.yfanads.android.custom.InterstitialCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.template.InterTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class XmInterstitialAdapter extends InterstitialCustomAdapter implements InterstitialAd.InterstitialAdLoadListener, InterstitialAd.InterstitialAdInteractionListener {
    private InterstitialAd interstitialAd;

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void bindData(Activity activity, InterTemplateData interTemplateData, AdBaseViewHolder adBaseViewHolder) {
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public boolean isSupportAutoClick() {
        return true;
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdLoadListener
    public void onAdRequestSuccess() {
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onVideoEnd() {
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onVideoPause() {
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onVideoResume() {
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onVideoStart() {
    }

    public XmInterstitialAdapter(YFInterstitialSetting yFInterstitialSetting) {
        super(yFInterstitialSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        XmUtil.initXm(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.xm.XmInterstitialAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                XmInterstitialAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                XmInterstitialAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void doShowAD(Activity activity) {
        super.doShowAD(activity);
        showTemplateADs(activity);
    }

    private void showTemplateADs(final Activity activity) {
        try {
            if (this.interstitialAd == null) {
                handleShowFailed(this.tag + " interstitialAd is null");
                return;
            }
            if (isBidding()) {
                this.interstitialAd.setPrice(getPrice());
            }
            if (activity != null && !activity.isFinishing()) {
                Util.MAIN_HANDLER.post(new Runnable() { // from class: com.yfanads.ads.chanel.xm.XmInterstitialAdapter$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m1160x1dc5e5ae(activity);
                    }
                });
            } else {
                handleShowFailed(this.tag + " activity is null or finish");
            }
        } catch (Exception e) {
            e.printStackTrace();
            handleShowFailed();
        }
    }

    /* JADX INFO: renamed from: lambda$showTemplateADs$0$com-yfanads-ads-chanel-xm-XmInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1160x1dc5e5ae(Activity activity) {
        this.interstitialAd.show(activity, this);
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        release("doDestroy");
    }

    private void release(String str) {
        try {
            InterstitialAd interstitialAd = this.interstitialAd;
            if (interstitialAd != null) {
                interstitialAd.destroy();
                this.interstitialAd = null;
            }
        } catch (Exception e) {
            YFLog.error(this.tag + str + e.getMessage());
        }
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void closeAds(boolean z) {
        release("closeAds");
        super.closeAds(z);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else {
            loadInterstitialAd();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            interstitialAd.win(XmUtil.getWinParams(this.sdkSupplier, sdkSupplier));
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
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            interstitialAd.loss(XmUtil.getLossParams(sdkSupplier));
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
    }

    private long getPrice() {
        Map<String, Object> mediaExtraInfo;
        Object obj;
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd == null || (mediaExtraInfo = interstitialAd.getMediaExtraInfo()) == null || mediaExtraInfo.isEmpty() || (obj = mediaExtraInfo.get(OapsKey.KEY_PRICE)) == null) {
            return 0L;
        }
        return ((Long) obj).longValue();
    }

    private void loadInterstitialAd() {
        this.interstitialAd = new InterstitialAd();
        ADParams.Builder builder = new ADParams.Builder();
        builder.setUpId(this.sdkSupplier.getPotId());
        this.interstitialAd.setMute(this.sdkSupplier.isMute());
        this.interstitialAd.loadAd(builder.build(), this);
        this.interstitialAd.setDownloadListener(new InterstitialAd.InterstitialDownloadListener() { // from class: com.yfanads.ads.chanel.xm.XmInterstitialAdapter.2
            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialDownloadListener, com.miui.zeus.mimo.sdk.r3
            public void onDownloadCancel() {
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialDownloadListener, com.miui.zeus.mimo.sdk.r3
            public void onDownloadFailed(int i) {
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialDownloadListener, com.miui.zeus.mimo.sdk.r3
            public void onDownloadFinished() {
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialDownloadListener, com.miui.zeus.mimo.sdk.r3
            public void onDownloadPaused() {
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialDownloadListener, com.miui.zeus.mimo.sdk.r3
            public void onDownloadProgressUpdated(int i) {
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialDownloadListener, com.miui.zeus.mimo.sdk.r3
            public void onDownloadStarted() {
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialDownloadListener, com.miui.zeus.mimo.sdk.r3
            public void onInstallFailed(int i) {
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialDownloadListener, com.miui.zeus.mimo.sdk.r3
            public void onInstallStart() {
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialDownloadListener, com.miui.zeus.mimo.sdk.r3
            public void onInstallSuccess() {
            }
        });
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.XM.getValue();
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdLoadListener
    public void onAdLoadSuccess() {
        YFLog.debug(this.tag + " InterstitialAd cache display. ");
        if (this.interstitialAd != null) {
            setEcpm(getPrice());
        }
        handleSucceed();
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdLoadListener
    public void onAdLoadFailed(int i, String str) {
        handleFailed(i, str);
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onAdClick() {
        YFLog.high(this.tag + "newVersionAd onAdVideoBarClick");
        handleClick();
        closeAdsDelay();
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onAdShow() {
        YFLog.high(this.tag + "newVersionAd onAdShow");
        handleExposure();
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onAdClosed() {
        handleClose();
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onRenderFail(int i, String str) {
        handleFailed(i, str);
    }
}
