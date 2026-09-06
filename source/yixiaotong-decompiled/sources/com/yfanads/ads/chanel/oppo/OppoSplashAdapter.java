package com.yfanads.ads.chanel.oppo;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.msp.mobad.api.ad.HotSplashAd;
import com.heytap.msp.mobad.api.listener.IHotSplashListener;
import com.heytap.msp.mobad.api.params.SplashAdParams;
import com.yfanads.ads.chanel.oppo.utls.OppoUtil;
import com.yfanads.android.core.splash.YFSplashSetting;
import com.yfanads.android.custom.SplashCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class OppoSplashAdapter extends SplashCustomAdapter implements IHotSplashListener {
    private HotSplashAd hotSplashAd;
    private String tag;

    public OppoSplashAdapter(YFSplashSetting yFSplashSetting) {
        super(yFSplashSetting);
        this.tag = "[OppoSplashAdapter] ";
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        OppoUtil.initOppo(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.oppo.OppoSplashAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                OppoSplashAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                OppoSplashAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        super.m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(activity, viewGroup);
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter
    public void doShowAD(Activity activity) {
        if (this.hotSplashAd == null) {
            handleShowFailed(this.tag + " hotSplashAd is null");
            return;
        }
        if (isBidding()) {
            HotSplashAd hotSplashAd = this.hotSplashAd;
            hotSplashAd.setBidECPM(hotSplashAd.getECPM());
        }
        this.hotSplashAd.showAd(activity);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        HotSplashAd hotSplashAd = this.hotSplashAd;
        if (hotSplashAd != null) {
            hotSplashAd.notifyRankWin(sdkSupplier != null ? (int) sdkSupplier.ecpm : 0);
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
        HotSplashAd hotSplashAd = this.hotSplashAd;
        if (hotSplashAd == null || sdkSupplier == null) {
            return;
        }
        hotSplashAd.notifyRankLoss(1, "other", (int) sdkSupplier.ecpm);
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        HotSplashAd hotSplashAd = this.hotSplashAd;
        if (hotSplashAd != null) {
            hotSplashAd.destroyAd();
            this.hotSplashAd = null;
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.OPPO.getValue();
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.mSplashSetting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else {
            loadSplashAd(context);
        }
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter
    public void loadSplashAd(Context context) {
        try {
            SplashAdParams.Builder fetchTimeout = new SplashAdParams.Builder().setFetchTimeout(this.sdkSupplier.requestTimeout > 0 ? (int) this.sdkSupplier.requestTimeout : 3000);
            View bottomView = getBottomView();
            if (bottomView != null) {
                if (bottomView.getParent() instanceof ViewGroup) {
                    ((ViewGroup) bottomView.getParent()).removeView(bottomView);
                }
                bottomView.setVisibility(0);
                fetchTimeout.setBottomArea(bottomView);
            }
            YFLog.debug(this.tag + fetchTimeout.toString());
            this.hotSplashAd = new HotSplashAd(context, this.sdkSupplier.getPotId(), this, fetchTimeout.build());
        } catch (Exception e) {
            e.printStackTrace();
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_LOAD));
        }
    }

    @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
    public void onAdReady() {
        HotSplashAd hotSplashAd = this.hotSplashAd;
        if (hotSplashAd != null) {
            setEcpm(hotSplashAd.getECPM());
        }
        handleSucceed();
    }

    @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
    public void onAdDismissed() {
        handleClose();
    }

    @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
    public void onAdShow(String str) {
        handleExposure();
    }

    @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
    public void onAdFailed(int i, String str) {
        if (isStartShow()) {
            YFLog.error(this.tag + " handleRenderFailed onAdFailed, msg:" + str + "_" + i);
            handleRenderFailed(i, str);
        } else {
            YFLog.error(this.tag + " handleFailed onAdFailed, msg:" + str + "_" + i);
            handleFailed(i, str);
        }
    }

    @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
    public void onAdClick() {
        handleClick();
    }

    private View getBottomView() {
        if (this.mSplashSetting != null) {
            return this.mSplashSetting.getBottomView();
        }
        return null;
    }
}
