package com.yfanads.ads.chanel.hw;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.BiddingParam;
import com.huawei.hms.ads.ReportUrlListener;
import com.huawei.hms.ads.splash.SplashAd;
import com.huawei.hms.ads.splash.SplashAdDisplayListener;
import com.huawei.hms.ads.splash.SplashView;
import com.huawei.hms.ads.splash.listener.SplashListener;
import com.huawei.hms.ads.splash.listener.SplashLoadListener;
import com.unionpay.tsmservice.data.Constant;
import com.yfanads.ads.chanel.hw.utls.HwUtil;
import com.yfanads.android.core.splash.YFSplashSetting;
import com.yfanads.android.custom.SplashCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class HwSplashAdapter extends SplashCustomAdapter {
    private SplashAd splashAd;

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public boolean isSupportCache() {
        return false;
    }

    public HwSplashAdapter(YFSplashSetting yFSplashSetting) {
        super(yFSplashSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        HwUtil.initHw(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.hw.HwSplashAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                HwSplashAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                HwSplashAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        handleShowApiInvoke();
        SplashView splashView = getSplashView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            viewGroup.addView(splashView, new RelativeLayout.LayoutParams(-1, -1));
            viewGroup.bringToFront();
            if (this.splashAd.isLoaded()) {
                this.splashAd.showAd(false);
                return;
            } else {
                handleShowFailed(this.tag + " splashAd is not loaded");
                return;
            }
        }
        handleShowFailed(this.tag + " splashView is null");
    }

    private SplashView getSplashView() {
        SplashView splashViewM974getSplashView = this.splashAd.m974getSplashView();
        splashViewM974getSplashView.setAudioFocusType(1);
        splashViewM974getSplashView.setAdDisplayListener(new SplashAdDisplayListener() { // from class: com.yfanads.ads.chanel.hw.HwSplashAdapter.2
            @Override // com.huawei.hms.ads.splash.SplashAdDisplayListener
            public void onAdShowed() {
                YFLog.high(HwSplashAdapter.this.tag + " onAdShowed");
                HwSplashAdapter.this.handleExposure();
            }

            @Override // com.huawei.hms.ads.splash.SplashAdDisplayListener
            public void onAdClick() {
                YFLog.high(HwSplashAdapter.this.tag + " onAdClick");
                HwSplashAdapter.this.handleClick();
            }
        });
        return splashViewM974getSplashView;
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        try {
            if (this.splashAd != null) {
                this.splashAd = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.mSplashSetting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else {
            loadInterstitialAd(context);
        }
    }

    private void loadInterstitialAd(Context context) {
        int screenOrientation;
        AdParam.Builder builder = new AdParam.Builder();
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.setRequestedOrientation(14);
            screenOrientation = getScreenOrientation(activity);
        } else {
            screenOrientation = 1;
        }
        if (isBidding()) {
            BiddingParam.Builder builder2 = new BiddingParam.Builder();
            builder2.setBidFloor(Float.valueOf(getEcpm()));
            builder2.setBidFloorCur(Constant.KEY_CURRENCYTYPE_CNY);
            builder.addBiddingParamMap(this.sdkSupplier.getPotId(), builder2.build());
        }
        SplashAd splashAd = new SplashAd(context);
        this.splashAd = splashAd;
        splashAd.setAdParam(getPotID(), screenOrientation, builder.build());
        this.splashAd.setSplashListener(new SplashListener() { // from class: com.yfanads.ads.chanel.hw.HwSplashAdapter.3
            @Override // com.huawei.hms.ads.splash.listener.SplashListener
            public void onAdShowStart() {
                YFLog.high(HwSplashAdapter.this.tag + " onAdShowStart");
            }

            @Override // com.huawei.hms.ads.splash.listener.SplashListener
            public void onAdError(int i) {
                YFLog.high(HwSplashAdapter.this.tag + " onAdError " + i);
                HwSplashAdapter.this.handleRenderFailed(i, "");
            }

            @Override // com.huawei.hms.ads.splash.listener.SplashListener
            public void onAdDismissed() {
                YFLog.high(HwSplashAdapter.this.tag + " onAdDismissed");
                HwSplashAdapter.this.handleClose();
            }
        });
        this.splashAd.loadAd(new SplashLoadListener() { // from class: com.yfanads.ads.chanel.hw.HwSplashAdapter.4
            @Override // com.huawei.hms.ads.splash.listener.SplashLoadListener
            public void onAdLoaded() {
                YFLog.high(HwSplashAdapter.this.tag + " handleSucceed");
                if (HwSplashAdapter.this.isBidding()) {
                    HwSplashAdapter.this.setEcpm();
                }
                HwSplashAdapter.this.handleSucceed();
            }

            @Override // com.huawei.hms.ads.splash.listener.SplashLoadListener
            public void onAdFailed(int i) {
                YFLog.high(HwSplashAdapter.this.tag + " onAdFailed" + i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEcpm() {
        try {
            SplashAd splashAd = this.splashAd;
            if (splashAd != null) {
                BiddingInfo biddingInfo = splashAd.getBiddingInfo();
                if (biddingInfo != null && biddingInfo.getPrice() != null) {
                    setEcpmByStr(HwUtil.price2penny(biddingInfo.getPrice()));
                } else {
                    setEcpmByStr("0");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getScreenOrientation(Activity activity) {
        return activity.getResources().getConfiguration().orientation == 2 ? 0 : 1;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        SplashAd splashAd = this.splashAd;
        if (splashAd != null) {
            splashAd.sendBiddingSuccess(HwUtil.getWinBiddingInfo(sdkSupplier), new ReportUrlListener() { // from class: com.yfanads.ads.chanel.hw.HwSplashAdapter.5
                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportSuccess() {
                    YFLog.high(HwSplashAdapter.this.tag + " sendBiddingSucResult reportSuccess");
                }

                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportFailed(String str, int i) {
                    YFLog.high(HwSplashAdapter.this.tag + " sendBiddingSucResult reportFailed " + str + " code=" + i);
                }
            });
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
        SplashAd splashAd = this.splashAd;
        if (splashAd != null) {
            splashAd.sendBiddingFailed(HwUtil.getLossBiddingInfo(sdkSupplier), new ReportUrlListener() { // from class: com.yfanads.ads.chanel.hw.HwSplashAdapter.6
                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportSuccess() {
                    YFLog.high(HwSplashAdapter.this.tag + " sendBiddingLossResult reportSuccess");
                }

                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportFailed(String str, int i) {
                    YFLog.high(HwSplashAdapter.this.tag + " sendBiddingLossResult reportFailed " + str + " code=" + i);
                }
            });
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.HW.getValue();
    }
}
