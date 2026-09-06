package com.yfanads.ads.chanel.zd;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.splash.ISplashAd;
import com.meishu.sdk.core.ad.splash.SplashAdEventListener;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.yfanads.ads.chanel.zd.utils.ZDUtil;
import com.yfanads.android.core.splash.YFSplashSetting;
import com.yfanads.android.custom.SplashCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ZDSplashAdapter extends SplashCustomAdapter implements SplashAdEventListener, InteractionListener {
    SplashAdLoader adLoader;
    private RelativeLayout rootView;
    private ISplashAd splashAdManager;

    public ZDSplashAdapter(YFSplashSetting yFSplashSetting) {
        super(yFSplashSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        ZDUtil.initZD(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.zd.ZDSplashAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                ZDSplashAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YFLog.error(ZDSplashAdapter.this.tag + " onNoAd msg:" + str + "_" + str2);
                ZDSplashAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
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
            int[] sizePx = getSizePx();
            RelativeLayout relativeLayout = new RelativeLayout(context);
            this.rootView = relativeLayout;
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(sizePx[0], sizePx[1]));
            SplashAdLoader splashAdLoader = new SplashAdLoader(context, this.rootView, new MsAdSlot.Builder().setPid(getPotID()).setFetchCount(1).setVideoMute(true).setWidth(sizePx[0]).setHeight(sizePx[1]).setIsHideSkipBtn(false).build(), this, 5000);
            this.adLoader = splashAdLoader;
            splashAdLoader.loadAd();
            YFLog.high(this.tag + " doLoadAD end -- ");
        } catch (Exception e) {
            YFLog.error(this.tag + " doLoadAD error:" + e.getMessage());
        }
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        handleShowApiInvoke();
        YFLog.high(this.tag + " doShowAD -- " + activity);
        if (!YFUtil.isActivityDestroyed(activity) && this.splashAdManager != null) {
            if (viewGroup != null) {
                viewGroup.addView(this.rootView);
            }
            this.splashAdManager.showAd(this.rootView);
            return;
        }
        handleShowFailed(this.tag + " activity is isActivityDestroyed");
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        ISplashAd iSplashAd = this.splashAdManager;
        return iSplashAd != null && iSplashAd.isAdValid();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        ISplashAd iSplashAd = this.splashAdManager;
        return (iSplashAd == null || iSplashAd.getData() == null) ? "" : this.splashAdManager.getData().getReqId();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        if (this.splashAdManager != null) {
            HashMap map = new HashMap();
            String shortString = "";
            map.put("winPrice", Integer.valueOf(YFUtil.toInt(getEcpm() + "", 0)));
            map.put("highestLossPrice", Integer.valueOf(sdkSupplier != null ? YFUtil.toInt(sdkSupplier.ecpm + "", 0) : 0));
            this.splashAdManager.sendWinNotification(map);
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (this.splashAdManager == null || sdkSupplier == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("winPrice", Integer.valueOf(YFUtil.toInt(sdkSupplier.ecpm + "", 0)));
        map.put("lossReason", 1);
        map.put("adnId", 2);
        this.splashAdManager.sendLossNotification(map);
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        YFLog.high(this.tag + "doDestroy");
        super.doDestroy();
        SplashAdLoader splashAdLoader = this.adLoader;
        if (splashAdLoader != null) {
            splashAdLoader.destroy();
            this.adLoader = null;
        }
        if (this.splashAdManager != null) {
            this.splashAdManager = null;
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.ZD.getValue();
    }

    @Override // com.meishu.sdk.core.ad.IAdEventListener
    public void onAdError(AdErrorInfo adErrorInfo) {
        try {
            YFLog.debug("onAdFailed " + adErrorInfo);
            handleFailed(adErrorInfo.getErrorType(), " ad fail " + adErrorInfo.getMessage());
        } catch (Exception e) {
            YFLog.error(this.tag + " onError:" + e.getMessage());
        }
    }

    @Override // com.meishu.sdk.core.ad.IAdEventListener
    public void onAdReady(ISplashAd iSplashAd) {
        try {
            if (iSplashAd == null) {
                handleFailed(YFAdError.ERROR_DATA_NULL, this.tag + " KsSplashScreenAd null");
                return;
            }
            this.splashAdManager = iSplashAd;
            iSplashAd.setInteractionListener(this);
            if (iSplashAd.getData() != null) {
                setEcpmByStr(iSplashAd.getData().getEcpm());
            }
            handleSucceed();
        } catch (Throwable unused) {
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_LOAD));
        }
    }

    @Override // com.meishu.sdk.core.ad.splash.SplashAdEventListener
    public void onAdSkip(ISplashAd iSplashAd) {
        YFLog.debug("onAdSkip ");
        handleClose();
    }

    @Override // com.meishu.sdk.core.ad.splash.SplashAdEventListener
    public void onAdTimeOver(ISplashAd iSplashAd) {
        YFLog.debug("onAdTimeOver ");
        handleClose();
    }

    @Override // com.meishu.sdk.core.loader.InteractionListener
    public void onAdClicked() {
        YFLog.debug("onAdClicked ");
        handleClick();
    }

    @Override // com.meishu.sdk.core.loader.InteractionListener
    public void onAdExposure() {
        YFLog.debug("onAdExposure");
        handleExposure();
    }

    @Override // com.meishu.sdk.core.loader.InteractionListener
    public void onAdClosed() {
        YFLog.debug("onAdClosed ");
        handleClose();
    }
}
