package com.yfanads.ads.chanel.ge;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.constants.BiddingConst;
import com.fancy.adsdk.lib.interf.PtgSplashAd;
import com.fancy.adsdk.lib.model.AdBidLossReason;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.yfanads.ads.chanel.ge.utils.GEUtil;
import com.yfanads.android.core.splash.YFSplashSetting;
import com.yfanads.android.custom.SplashCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class GESplashAdapter extends SplashCustomAdapter {
    private PtgSplashAd splashAd;

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        return "";
    }

    public GESplashAdapter(YFSplashSetting yFSplashSetting) {
        super(yFSplashSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        GEUtil.initGE(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ge.GESplashAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                GESplashAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                GESplashAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
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
        int[] sizeDp = getSizeDp();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        PtgAdSdk.get().loadSplashAd(context, new AdSlot.Builder().setPtgSlotId(this.sdkSupplier.getPotId()).setExpressViewAcceptedDpSize(sizeDp[0], sizeDp[1]).build(), new PtgAdNative.SplashAdListener() { // from class: com.yfanads.ads.chanel.ge.GESplashAdapter.2
            @Override // com.fancy.adsdk.lib.provider.PtgAdNative.SplashAdListener
            public void onTimeout() {
                GESplashAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
            }

            @Override // com.fancy.adsdk.lib.provider.PtgAdNative.SplashAdListener
            public void onSplashAdLoad(PtgSplashAd ptgSplashAd) {
                GESplashAdapter.this.splashAd = ptgSplashAd;
                YFLog.debug(GESplashAdapter.this.tag + " onAdLoaded ecpm:" + ptgSplashAd.getEcpm() + "; 耗时：" + (System.currentTimeMillis() - jCurrentTimeMillis));
                GESplashAdapter.this.setEcpmByStr(GESplashAdapter.this.splashAd.getEcpm() + "");
                GESplashAdapter.this.handleSucceed();
            }

            @Override // com.fancy.adsdk.lib.interf.Error
            public void onError(AdError adError) {
                YFLog.debug(GESplashAdapter.this.tag + " onError " + adError.getErrorCode() + PPSLabelView.Code + adError.getMessage());
                GESplashAdapter.this.handleFailed(adError.getErrorCode(), adError.getMessage());
            }
        });
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append("doLoadAD -- ").append(Arrays.toString(sizeDp)).append(" dp, ");
        if (this.mSplashSetting != null && this.mSplashSetting.isCustom()) {
            z = true;
        }
        YFLog.high(sbAppend.append(z).toString());
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        PtgSplashAd ptgSplashAd;
        handleShowApiInvoke();
        YFLog.high(this.tag + " doShowAD -- " + activity);
        if (!YFUtil.isActivityDestroyed(activity) && (ptgSplashAd = this.splashAd) != null) {
            ptgSplashAd.setSplashInteractionListener(new PtgSplashAd.AdInteractionListener() { // from class: com.yfanads.ads.chanel.ge.GESplashAdapter.3
                @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
                public void onAdClicked() {
                    YFLog.debug(GESplashAdapter.this.tag + " onAdClicked");
                    GESplashAdapter.this.handleClick();
                }

                @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
                public void onAdShow() {
                    YFLog.debug(GESplashAdapter.this.tag + " onAdShow");
                    GESplashAdapter.this.handleExposure();
                }

                @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
                public void onAdSkip() {
                    YFLog.debug(GESplashAdapter.this.tag + " onAdSkip");
                    GESplashAdapter.this.handleClose();
                }

                @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
                public void onAdTimeOver() {
                    YFLog.debug(GESplashAdapter.this.tag + " onAdTimeOver");
                    GESplashAdapter.this.handleClose();
                }

                @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
                public void onRenderSuccess() {
                    YFLog.debug(GESplashAdapter.this.tag + " onRenderSuccess");
                }

                @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
                public void onRenderError(AdError adError) {
                    YFLog.debug(GESplashAdapter.this.tag + " onRenderError");
                    GESplashAdapter.this.handleRenderFailed();
                }

                @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
                public void onDismiss(int i) {
                    YFLog.debug(GESplashAdapter.this.tag + " onDismiss " + i);
                    GESplashAdapter.this.handleClose();
                }
            });
            this.splashAd.showAd(viewGroup);
        } else {
            handleShowFailed(this.tag + " activity is isActivityDestroyed");
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        PtgSplashAd ptgSplashAd = this.splashAd;
        if (ptgSplashAd != null) {
            return ptgSplashAd.isReady();
        }
        return super.isReady();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        PtgSplashAd ptgSplashAd = this.splashAd;
        if (ptgSplashAd != null) {
            ptgSplashAd.notifyBidWin(ptgSplashAd.getEcpm(), this.sdkSupplier.ecpm);
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
        if (this.splashAd == null || sdkSupplier == null) {
            return;
        }
        AdBidLossReason adBidLossReason = new AdBidLossReason();
        adBidLossReason.setLossCode(BiddingConst.BIDDING_LOSS.WITH_LOW_PRICE_IN_HB);
        adBidLossReason.setWinPrice(sdkSupplier.ecpm);
        adBidLossReason.setWinAdnId(BiddingConst.ADN_ID.LOSE_TO_OTHER_ADN);
        this.splashAd.notifyBidLoss(adBidLossReason);
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        YFLog.high(this.tag + "doDestroy");
        super.doDestroy();
        PtgSplashAd ptgSplashAd = this.splashAd;
        if (ptgSplashAd != null) {
            ptgSplashAd.destroy();
            this.splashAd = null;
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.XU.getValue();
    }
}
