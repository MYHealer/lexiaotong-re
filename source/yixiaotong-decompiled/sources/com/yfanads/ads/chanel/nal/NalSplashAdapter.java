package com.yfanads.ads.chanel.nal;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.AdRequest;
import com.adprof.sdk.api.IBiddingNotify;
import com.adprof.sdk.api.SplashAd;
import com.adprof.sdk.api.SplashAdListener;
import com.yfanads.ads.chanel.nal.utils.NalUtil;
import com.yfanads.android.core.splash.YFSplashSetting;
import com.yfanads.android.custom.SplashCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class NalSplashAdapter extends SplashCustomAdapter implements SplashAdListener {
    private SplashAd splashAdManager;

    public NalSplashAdapter(YFSplashSetting yFSplashSetting) {
        super(yFSplashSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        NalUtil.initNal(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.nal.NalSplashAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                NalSplashAdapter nalSplashAdapter = NalSplashAdapter.this;
                nalSplashAdapter.startLoadAD(nalSplashAdapter.getContext());
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YFLog.error(NalSplashAdapter.this.tag + " onNoAd msg:" + str + "_" + str2);
                NalSplashAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.mSplashSetting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
            return;
        }
        try {
            YFLog.high(this.tag + " doLoadAD start -- ");
            SplashAd splashAd = new SplashAd(new AdRequest.Builder().setCodeId(getPotID()).setVideoMute(this.sdkSupplier.isMute()).build(), this, 5000L);
            this.splashAdManager = splashAd;
            splashAd.loadAd();
            YFLog.high(this.tag + " doLoadAD end -- ");
        } catch (Exception e) {
            YFLog.error(this.tag + " doLoadAD error:" + e.getMessage());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        if (this.splashAdManager != null) {
            HashMap map = new HashMap();
            map.put(IBiddingNotify.WIN_FIRST_PRICE, Long.valueOf(getEcpm()));
            String shortString = "";
            map.put(IBiddingNotify.WIN_HIGHEST_LOSS_PRICE, sdkSupplier != null ? Long.valueOf(sdkSupplier.ecpm) : "");
            this.splashAdManager.sendWinNotify(map);
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (this.splashAdManager != null) {
            HashMap map = new HashMap();
            map.put(IBiddingNotify.LOSS_FIRST_PRICE, Long.valueOf(sdkSupplier.ecpm));
            map.put(IBiddingNotify.LOSS_REASON, 100);
            this.splashAdManager.sendWinNotify(map);
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        SplashAd splashAd;
        handleShowApiInvoke();
        YFLog.high(this.tag + " doShowAD -- " + activity);
        if (!YFUtil.isActivityDestroyed(activity) && (splashAd = this.splashAdManager) != null) {
            splashAd.showAd(viewGroup);
        } else {
            handleShowFailed(this.tag + " activity is isActivityDestroyed");
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        try {
            SplashAd splashAd = this.splashAdManager;
            return (splashAd == null || YFListUtils.isMapEmpty(splashAd.getExtraInfo())) ? "" : (String) this.splashAdManager.getExtraInfo().get("loadId");
        } catch (Exception e) {
            YFLog.error(this.tag + " getAdReqId " + e.getMessage());
            return "";
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        SplashAd splashAd = this.splashAdManager;
        if (splashAd != null) {
            return splashAd.isReady();
        }
        return super.isReady();
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        YFLog.high(this.tag + "doDestroy");
        super.doDestroy();
        SplashAd splashAd = this.splashAdManager;
        if (splashAd != null) {
            splashAd.destroyAd();
            this.splashAdManager = null;
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.NAL.getValue();
    }

    @Override // com.adprof.sdk.api.SplashAdListener
    public void onAdLoadSuccess() {
        YFLog.debug("onLoadAdSuccess");
        SplashAd splashAd = this.splashAdManager;
        if (splashAd != null) {
            setEcpm(splashAd.getBidPrice());
        }
        handleSucceed();
    }

    @Override // com.adprof.sdk.api.SplashAdListener
    public void onAdCacheSuccess() {
        YFLog.debug("onAdCacheSuccess");
    }

    @Override // com.adprof.sdk.api.SplashAdListener
    public void onSplashAdLoadFail(AdError adError) {
        try {
            YFLog.debug("onSplashAdLoadFail " + adError.getErrorCode() + "|" + adError.getMessage());
            handleFailed(YFAdError.parseErr(adError.getErrorCode(), adError.getMessage()));
        } catch (Exception e) {
            YFLog.error(this.tag + " onError:" + e.getMessage());
        }
    }

    @Override // com.adprof.sdk.api.SplashAdListener
    public void onSplashAdShow() {
        YFLog.debug("onSplashAdShow");
        handleExposure();
    }

    @Override // com.adprof.sdk.api.SplashAdListener
    public void onSplashAdShowError(AdError adError) {
        try {
            YFLog.debug("onSplashAdShowError " + adError.getErrorCode() + "|" + adError.getErrorCode());
            handleShowFailed();
        } catch (Exception e) {
            YFLog.error(this.tag + " onError:" + e.getMessage());
        }
    }

    @Override // com.adprof.sdk.api.SplashAdListener
    public void onSplashAdClick() {
        YFLog.debug("onSplashAdClick");
        handleClick();
    }

    @Override // com.adprof.sdk.api.SplashAdListener
    public void onSplashAdClose(boolean z) {
        YFLog.debug("onSplashAdClose " + z);
        handleClose();
    }
}
