package com.yfanads.ads.chanel.oppo;

import android.app.Activity;
import android.content.Context;
import com.heytap.msp.mobad.api.ad.InterstitialVideoAd;
import com.heytap.msp.mobad.api.listener.IInterstitialVideoAdListener;
import com.yfanads.ads.chanel.oppo.utls.OppoUtil;
import com.yfanads.android.core.full.YFFullScreenVideoSetting;
import com.yfanads.android.custom.FullScreenCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class OppoFullScreenVideoAdapter extends FullScreenCustomAdapter implements IInterstitialVideoAdListener {
    private InterstitialVideoAd mInterstitialVideoAd;

    public OppoFullScreenVideoAdapter(YFFullScreenVideoSetting yFFullScreenVideoSetting) {
        super(yFFullScreenVideoSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        OppoUtil.initOppo(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.oppo.OppoFullScreenVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                OppoFullScreenVideoAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                OppoFullScreenVideoAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.mFullSetting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
            return;
        }
        if (context instanceof Activity) {
            InterstitialVideoAd interstitialVideoAd = new InterstitialVideoAd((Activity) context, this.sdkSupplier.network.param.potId, this);
            this.mInterstitialVideoAd = interstitialVideoAd;
            interstitialVideoAd.loadAd();
        } else {
            YFLog.error("loadFullScreen context is not activity " + context);
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_OPPO_CONTEXT));
        }
    }

    @Override // com.yfanads.android.custom.FullScreenCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        InterstitialVideoAd interstitialVideoAd = this.mInterstitialVideoAd;
        if (interstitialVideoAd != null) {
            interstitialVideoAd.destroyAd();
            this.mInterstitialVideoAd = null;
        }
    }

    @Override // com.yfanads.android.custom.FullScreenCustomAdapter
    public void doShowAD(Activity activity) {
        if (this.mInterstitialVideoAd == null) {
            return;
        }
        if (isBidding()) {
            InterstitialVideoAd interstitialVideoAd = this.mInterstitialVideoAd;
            interstitialVideoAd.setBidECPM(interstitialVideoAd.getECPM());
        }
        this.mInterstitialVideoAd.showAd();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        InterstitialVideoAd interstitialVideoAd = this.mInterstitialVideoAd;
        if (interstitialVideoAd != null) {
            interstitialVideoAd.notifyRankWin(sdkSupplier != null ? (int) sdkSupplier.ecpm : 0);
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
        InterstitialVideoAd interstitialVideoAd = this.mInterstitialVideoAd;
        if (interstitialVideoAd == null || sdkSupplier == null) {
            return;
        }
        interstitialVideoAd.notifyRankLoss(1, "other", (int) sdkSupplier.ecpm);
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.OPPO.getValue();
    }

    @Override // com.heytap.msp.mobad.api.listener.IInterstitialVideoAdListener
    public void onVideoPlayComplete() {
        YFLog.high(this.tag + "onVideoComplete");
        handleVideoComplete();
    }

    @Override // com.heytap.msp.mobad.api.listener.IInterstitialVideoAdListener
    public void onAdReady() {
        InterstitialVideoAd interstitialVideoAd = this.mInterstitialVideoAd;
        if (interstitialVideoAd != null) {
            setEcpm(interstitialVideoAd.getECPM());
        }
        handleSucceed();
    }

    @Override // com.heytap.msp.mobad.api.listener.IInterstitialVideoAdListener
    public void onAdClose() {
        YFLog.debug(" onAdClose ");
        handleClose();
    }

    @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
    public void onAdShow() {
        handleExposure();
    }

    @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
    public void onAdFailed(String str) {
        handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_LOAD, str));
    }

    @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
    public void onAdFailed(int i, String str) {
        handleFailed(i, str);
    }

    @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
    public void onAdClick() {
        handleClick();
    }
}
