package com.yfanads.ads.chanel.nal;

import android.app.Activity;
import android.content.Context;
import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.AdRequest;
import com.adprof.sdk.api.IBiddingNotify;
import com.adprof.sdk.api.InterstitialAd;
import com.adprof.sdk.api.InterstitialAdListener;
import com.yfanads.ads.chanel.nal.utils.NalUtil;
import com.yfanads.android.core.inter.YFInterstitialSetting;
import com.yfanads.android.custom.InterstitialCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.InterTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class NalInterstitialAdapter extends InterstitialCustomAdapter implements InterstitialAdListener {
    private InterstitialAd interstitialAd;

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void bindData(Activity activity, InterTemplateData interTemplateData, AdBaseViewHolder adBaseViewHolder) {
    }

    public NalInterstitialAdapter(YFInterstitialSetting yFInterstitialSetting) {
        super(yFInterstitialSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.NAL.getValue();
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
                interstitialAd.destroyAd();
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
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        NalUtil.initNal(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.nal.NalInterstitialAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                NalInterstitialAdapter nalInterstitialAdapter = NalInterstitialAdapter.this;
                nalInterstitialAdapter.startLoadAD(nalInterstitialAdapter.getContext());
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YFLog.error(NalInterstitialAdapter.this.tag + " onNoAd msg:" + str + "_" + str2);
                NalInterstitialAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else if (isNative()) {
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
        } else {
            loadInterstitialAd(context);
        }
    }

    private void loadInterstitialAd(Context context) {
        InterstitialAd interstitialAd = new InterstitialAd(new AdRequest.Builder().setCodeId(getPotID()).build(), this);
        this.interstitialAd = interstitialAd;
        interstitialAd.loadAd();
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void doShowAD(Activity activity) {
        showTemplateADs(activity);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        try {
            InterstitialAd interstitialAd = this.interstitialAd;
            return (interstitialAd == null || YFListUtils.isMapEmpty(interstitialAd.getExtraInfo())) ? "" : (String) this.interstitialAd.getExtraInfo().get("loadId");
        } catch (Exception e) {
            YFLog.error(this.tag + " getAdReqId " + e.getMessage());
            return "";
        }
    }

    private void showTemplateADs(Activity activity) {
        if (this.interstitialAd != null) {
            if (activity != null && !activity.isFinishing()) {
                this.interstitialAd.showAd(activity);
                return;
            } else {
                handleShowFailed(this.tag + " activity is null");
                return;
            }
        }
        handleShowFailed(this.tag + " interstitialAd is null");
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        if (this.interstitialAd != null) {
            HashMap map = new HashMap();
            map.put(IBiddingNotify.WIN_FIRST_PRICE, Long.valueOf(getEcpm()));
            String shortString = "";
            map.put(IBiddingNotify.WIN_HIGHEST_LOSS_PRICE, sdkSupplier != null ? Long.valueOf(sdkSupplier.ecpm) : "");
            this.interstitialAd.sendWinNotify(map);
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (this.interstitialAd != null) {
            HashMap map = new HashMap();
            map.put(IBiddingNotify.LOSS_FIRST_PRICE, Long.valueOf(sdkSupplier.ecpm));
            map.put(IBiddingNotify.LOSS_REASON, 100);
            this.interstitialAd.sendWinNotify(map);
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
    }

    @Override // com.adprof.sdk.api.InterstitialAdListener
    public void onInterstitialAdLoadError(AdError adError) {
        try {
            YFLog.debug("onLoadAdFail " + adError.getErrorCode() + "|" + adError.getMessage());
            handleFailed(YFAdError.parseErr(adError.getErrorCode(), adError.getMessage()));
        } catch (Exception e) {
            YFLog.error(this.tag + " onError:" + e.getMessage());
        }
    }

    @Override // com.adprof.sdk.api.InterstitialAdListener
    public void onInterstitialAdLoadSuccess() {
        YFLog.debug("onLoadAdSuccess");
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            setEcpm(interstitialAd.getBidPrice());
        }
        handleSucceed();
    }

    @Override // com.adprof.sdk.api.InterstitialAdListener
    public void onInterstitialAdLoadCached() {
        YFLog.debug("onInterstitialAdLoadCached");
    }

    @Override // com.adprof.sdk.api.InterstitialAdListener
    public void onInterstitialAdShow() {
        YFLog.debug("onInterstitialAdShow");
        handleExposure();
    }

    @Override // com.adprof.sdk.api.InterstitialAdListener
    public void onInterstitialAdPlayEnd() {
        YFLog.debug("onInterstitialAdPlayEnd");
    }

    @Override // com.adprof.sdk.api.InterstitialAdListener
    public void onInterstitialAdClick() {
        YFLog.debug("onInterstitialAdClick");
        handleClick();
    }

    @Override // com.adprof.sdk.api.InterstitialAdListener
    public void onInterstitialAdClosed() {
        YFLog.debug("onInterstitialAdClosed");
        handleClose();
    }

    @Override // com.adprof.sdk.api.InterstitialAdListener
    public void onInterstitialAdShowError(AdError adError) {
        try {
            YFLog.debug("showError " + adError.getErrorCode() + "|" + adError.getMessage());
            handleShowFailed();
        } catch (Exception e) {
            YFLog.error(this.tag + " onError:" + e.getMessage());
        }
    }
}
