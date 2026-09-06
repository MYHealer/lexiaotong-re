package com.yfanads.ads.chanel.in;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ubixnow.adtype.splash.api.UMNSplashAd;
import com.ubixnow.adtype.splash.api.UMNSplashInfo;
import com.ubixnow.adtype.splash.api.UMNSplashListener;
import com.ubixnow.adtype.splash.api.UMNSplashParams;
import com.ubixnow.core.api.UMNError;
import com.yfanads.ads.chanel.in.utils.INUtil;
import com.yfanads.android.core.splash.YFSplashSetting;
import com.yfanads.android.custom.SplashCustomAdapter;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class INSplashAdapter extends SplashCustomAdapter implements UMNSplashListener {
    private UMNSplashAd splashAdManager;

    public INSplashAdapter(YFSplashSetting yFSplashSetting) {
        super(yFSplashSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        INUtil.initIN(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.in.INSplashAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                INSplashAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YFLog.error(INSplashAdapter.this.tag + " onNoAd msg:" + str + "_" + str2);
                INSplashAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
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
            Activity activity = context instanceof Activity ? (Activity) context : null;
            int[] sizeDp = getSizeDp();
            YFLog.high(this.tag + " doLoadAD start -- ");
            UMNSplashAd uMNSplashAd = new UMNSplashAd(activity, new UMNSplashParams.Builder().setSlotId(getPotID()).setSplashWidth(sizeDp[0]).setSplashHeight(sizeDp[1]).build(), this);
            this.splashAdManager = uMNSplashAd;
            uMNSplashAd.loadAd();
            YFLog.high(this.tag + " doLoadAD end -- ");
        } catch (Exception e) {
            YFLog.error(this.tag + " doLoadAD error:" + e.getMessage());
        }
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        UMNSplashAd uMNSplashAd;
        handleShowApiInvoke();
        YFLog.high(this.tag + " doShowAD -- " + activity);
        if (!YFUtil.isActivityDestroyed(activity) && (uMNSplashAd = this.splashAdManager) != null) {
            uMNSplashAd.show(viewGroup);
        } else {
            handleShowFailed(this.tag + " activity is isActivityDestroyed");
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        UMNSplashAd uMNSplashAd = this.splashAdManager;
        return uMNSplashAd != null ? uMNSplashAd.getRequestId() : "";
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        UMNSplashAd uMNSplashAd = this.splashAdManager;
        if (uMNSplashAd != null) {
            return uMNSplashAd.isValid();
        }
        return super.isReady();
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        YFLog.high(this.tag + "doDestroy");
        super.doDestroy();
        UMNSplashAd uMNSplashAd = this.splashAdManager;
        if (uMNSplashAd != null) {
            uMNSplashAd.destroy();
            this.splashAdManager = null;
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.IN.getValue();
    }

    @Override // com.ubixnow.adtype.splash.api.UMNSplashListener
    public void onAdClicked() {
        YFLog.debug(IAdInterListener.AdCommandType.AD_CLICK);
        handleClick();
    }

    @Override // com.ubixnow.adtype.splash.api.UMNSplashListener
    public void onAdDismiss(boolean z) {
        YFLog.debug("onAdDismiss");
        handleClose();
    }

    @Override // com.ubixnow.adtype.splash.api.UMNSplashListener
    public void onAdExposure() {
        YFLog.debug("onAdShow");
        handleExposure();
    }

    @Override // com.ubixnow.adtype.splash.api.UMNSplashListener
    public void onAdLoadSuccess(UMNSplashInfo uMNSplashInfo) {
        UMNSplashAd uMNSplashAd;
        YFLog.debug("onLoadAdSuccess");
        if (uMNSplashInfo != null && (uMNSplashAd = this.splashAdManager) != null && uMNSplashAd.getEcpmInfo() != null) {
            String ecpm = this.splashAdManager.getEcpmInfo().getEcpm();
            if (!TextUtils.isEmpty(ecpm)) {
                setEcpmByStr(ecpm);
            }
        }
        handleSucceed();
    }

    @Override // com.ubixnow.adtype.splash.api.UMNSplashListener
    public void onError(UMNError uMNError) {
        try {
            YFLog.debug("onLoadAdFail " + uMNError.code + "|" + uMNError.msg);
            handleFailed(YFAdError.parseErr(uMNError.code, uMNError.msg));
        } catch (Exception e) {
            YFLog.error(this.tag + " onError:" + e.getMessage());
        }
    }

    @Override // com.ubixnow.adtype.splash.api.UMNSplashListener
    public void showError(UMNError uMNError) {
        try {
            YFLog.debug("showError " + uMNError.code + "|" + uMNError.msg);
            handleShowFailed();
        } catch (Exception e) {
            YFLog.error(this.tag + " onError:" + e.getMessage());
        }
    }
}
