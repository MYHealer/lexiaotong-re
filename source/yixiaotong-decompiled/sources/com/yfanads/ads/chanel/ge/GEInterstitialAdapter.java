package com.yfanads.ads.chanel.ge;

import android.app.Activity;
import android.content.Context;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.constants.BiddingConst;
import com.fancy.adsdk.lib.interf.PtgInteractionAd;
import com.fancy.adsdk.lib.model.AdBidLossReason;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.yfanads.ads.chanel.ge.utils.GEUtil;
import com.yfanads.android.core.inter.YFInterstitialSetting;
import com.yfanads.android.custom.InterstitialCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.InterTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class GEInterstitialAdapter extends InterstitialCustomAdapter {
    private PtgInteractionAd interstitialAd;

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void bindData(Activity activity, InterTemplateData interTemplateData, AdBaseViewHolder adBaseViewHolder) {
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        return "";
    }

    public GEInterstitialAdapter(YFInterstitialSetting yFInterstitialSetting) {
        super(yFInterstitialSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.GE.getValue();
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        release("doDestroy");
    }

    private void release(String str) {
        try {
            PtgInteractionAd ptgInteractionAd = this.interstitialAd;
            if (ptgInteractionAd != null) {
                ptgInteractionAd.destroy();
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
    public void m1208x201b9c1d(final Context context) {
        GEUtil.initGE(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ge.GEInterstitialAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                GEInterstitialAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                GEInterstitialAdapter.this.handleFailed(str, str2);
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
        PtgAdSdk.get().loadInteractionExpressAd(context, new AdSlot.Builder().setPtgSlotId(this.sdkSupplier.getPotId()).build(), new PtgAdNative.InteractionExpressAdListener() { // from class: com.yfanads.ads.chanel.ge.GEInterstitialAdapter.2
            @Override // com.fancy.adsdk.lib.provider.PtgAdNative.InteractionExpressAdListener
            public void onInteractionAdLoad(PtgInteractionAd ptgInteractionAd) {
                YFLog.debug(GEInterstitialAdapter.this.tag + " onAdLoaded");
                GEInterstitialAdapter.this.interstitialAd = ptgInteractionAd;
                GEInterstitialAdapter.this.setEcpm(ptgInteractionAd.getEcpm());
                GEInterstitialAdapter.this.handleSucceed();
            }

            @Override // com.fancy.adsdk.lib.interf.Error
            public void onError(AdError adError) {
                YFLog.debug(GEInterstitialAdapter.this.tag + "onError code = " + adError.getErrorCode() + " msg = " + adError.getMessage());
                GEInterstitialAdapter.this.handleFailed(YFAdError.parseErr(adError.getErrorCode(), adError.getMessage()));
            }
        });
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void doShowAD(Activity activity) {
        super.doShowAD(activity);
        showTemplateADs(activity);
    }

    private void showTemplateADs(Activity activity) {
        if (this.interstitialAd != null) {
            if (activity != null && !activity.isFinishing()) {
                this.interstitialAd.setAdInteractionListener(new PtgInteractionAd.AdInteractionListener() { // from class: com.yfanads.ads.chanel.ge.GEInterstitialAdapter.3
                    @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
                    public void onAdClicked() {
                        YFLog.debug(GEInterstitialAdapter.this.tag + "onAdClicked");
                        GEInterstitialAdapter.this.handleClick();
                    }

                    @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
                    public void onAdShow() {
                        YFLog.debug(GEInterstitialAdapter.this.tag + "onAdShow");
                        GEInterstitialAdapter.this.handleExposure();
                    }

                    @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
                    public void onAdDismiss() {
                        YFLog.debug(GEInterstitialAdapter.this.tag + "onAdDismiss");
                        GEInterstitialAdapter.this.handleClose();
                    }

                    @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
                    public void onRenderError(AdError adError) {
                        YFLog.debug(GEInterstitialAdapter.this.tag + "onRenderError");
                        GEInterstitialAdapter.this.handleRenderFailed();
                    }
                });
                this.interstitialAd.showInteractionAd(activity);
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
        PtgInteractionAd ptgInteractionAd = this.interstitialAd;
        if (ptgInteractionAd != null) {
            ptgInteractionAd.notifyBidWin(ptgInteractionAd.getEcpm(), sdkSupplier.ecpm);
            String shortString = "";
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append(" loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (this.interstitialAd == null || sdkSupplier == null) {
            return;
        }
        AdBidLossReason adBidLossReason = new AdBidLossReason();
        adBidLossReason.setLossCode(BiddingConst.BIDDING_LOSS.WITH_LOW_PRICE_IN_HB);
        adBidLossReason.setWinPrice(sdkSupplier.ecpm);
        adBidLossReason.setWinAdnId(BiddingConst.ADN_ID.LOSE_TO_OTHER_ADN);
        this.interstitialAd.notifyBidLoss(adBidLossReason);
    }
}
