package com.yfanads.ads.chanel.ry;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.splash.SplashAdLoadListener;
import com.hihonor.adsdk.base.api.splash.SplashExpressAd;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.splash.SplashAdLoad;
import com.yfanads.ads.chanel.ry.utils.RYUtil;
import com.yfanads.android.core.splash.YFSplashSetting;
import com.yfanads.android.custom.SplashCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class RYSplashAdapter extends SplashCustomAdapter implements SplashAdLoadListener {
    private SplashExpressAd splashExpressAd;
    private final String tag;

    public RYSplashAdapter(YFSplashSetting yFSplashSetting) {
        super(yFSplashSetting);
        this.tag = "[RYSplashAdapter] ";
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.RY.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        RYUtil.initRY("[RYSplashAdapter] ", this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ry.RYSplashAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                RYSplashAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                RYSplashAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.mSplashSetting == null) {
            YFLog.error("[RYSplashAdapter]  isDestroy or setting null");
            return;
        }
        int[] sizePx = getSizePx();
        new SplashAdLoad.Builder().setSplashAdLoadListener(this).setAdSlot(new AdSlot.Builder().setSlotId(this.sdkSupplier.getPotId()).setTimeOutMillis(this.sdkSupplier.requestTimeout > 0 ? (int) this.sdkSupplier.requestTimeout : 3000).setLoadType(-1).build()).build().loadAd();
        YFLog.high("[RYSplashAdapter] doLoadAD-- " + Arrays.toString(sizePx) + " px, " + (this.mSplashSetting != null && this.mSplashSetting.isCustom()));
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        SplashExpressAd splashExpressAd;
        handleShowApiInvoke();
        if (!YFUtil.isActivityDestroyed(activity) && (splashExpressAd = this.splashExpressAd) != null && viewGroup != null) {
            splashExpressAd.setAdListener(new AdListener() { // from class: com.yfanads.ads.chanel.ry.RYSplashAdapter.2
                @Override // com.hihonor.adsdk.base.callback.AdListener
                public void onAdClosed() {
                    YFLog.high("[RYSplashAdapter]  onAdClosed ");
                    RYSplashAdapter.this.handleClose();
                }

                @Override // com.hihonor.adsdk.base.callback.AdListener
                public void onAdSkip(int i) {
                    YFLog.high("[RYSplashAdapter]  onAdSkip " + i);
                    RYSplashAdapter.this.handleClose(true);
                }

                @Override // com.hihonor.adsdk.base.callback.AdListener
                public void onAdClicked() {
                    YFLog.high("[RYSplashAdapter]  onAdClicked ");
                    RYSplashAdapter.this.handleClick();
                }

                @Override // com.hihonor.adsdk.base.callback.AdListener
                public void onAdImpression() {
                    YFLog.high("[RYSplashAdapter]  onAdImpression ");
                    RYSplashAdapter.this.handleExposure();
                }

                @Override // com.hihonor.adsdk.base.callback.AdListener
                public void onAdImpressionFailed(int i, String str) {
                    YFLog.high("[RYSplashAdapter]  onAdImpressionFailed " + i + "," + str);
                    if (RYSplashAdapter.this.isStartShow()) {
                        RYSplashAdapter.this.handleRenderFailed(i, str);
                    }
                }

                @Override // com.hihonor.adsdk.base.callback.AdListener
                public void onMiniAppStarted() {
                    YFLog.high("[RYSplashAdapter]  onMiniAppStarted ");
                    super.onMiniAppStarted();
                }
            });
            super.doShowAD(viewGroup, this.splashExpressAd.getExpressAdView());
        } else {
            handleShowFailed("[RYSplashAdapter]  activity is isActivityDestroyed");
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        SplashExpressAd splashExpressAd = this.splashExpressAd;
        if (splashExpressAd != null) {
            splashExpressAd.sendWinNotification(sdkSupplier != null ? (int) sdkSupplier.ecpm : 0L);
            String shortString = "";
            StringBuilder sbAppend = new StringBuilder("[RYSplashAdapter]  sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        SplashExpressAd splashExpressAd = this.splashExpressAd;
        if (splashExpressAd == null || sdkSupplier == null) {
            return;
        }
        splashExpressAd.sendLossNotification(sdkSupplier.ecpm, ErrorCode.AD_BID_FAILED, sdkSupplier.getAdnId());
        YFLog.high("[RYSplashAdapter]  sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        SplashExpressAd splashExpressAd = this.splashExpressAd;
        if (splashExpressAd != null) {
            splashExpressAd.release();
            this.splashExpressAd = null;
        }
    }

    @Override // com.hihonor.adsdk.base.api.splash.SplashAdLoadListener
    public void onLoadSuccess(SplashExpressAd splashExpressAd) {
        this.splashExpressAd = splashExpressAd;
        handleSucceed();
    }

    @Override // com.hihonor.adsdk.base.callback.BaseListener
    public void onFailed(String str, String str2) {
        YFLog.high("[RYSplashAdapter]  onFailed " + str + "," + str2);
        handleFailed(str, str2);
    }
}
