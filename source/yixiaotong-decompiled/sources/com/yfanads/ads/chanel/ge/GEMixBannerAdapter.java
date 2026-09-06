package com.yfanads.ads.chanel.ge;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.constants.BiddingConst;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.model.AdBidLossReason;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.stub.StubApp;
import com.yfanads.ads.chanel.ge.model.GENativeAds;
import com.yfanads.ads.chanel.ge.utils.GEUtil;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.custom.NativeExpressCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.ExpView;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFExpView;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class GEMixBannerAdapter extends NativeExpressCustomAdapter implements PtgAdNative.NativeExpressAdListener, YFNativeCall {
    private PtgNativeExpressAd tempPtgNativeExpressAd;

    public GEMixBannerAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        GEUtil.initGE(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ge.GEMixBannerAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                GEMixBannerAdapter gEMixBannerAdapter = GEMixBannerAdapter.this;
                gEMixBannerAdapter.startLoadAD(gEMixBannerAdapter.getContext());
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YFLog.error(GEMixBannerAdapter.this.tag + " onNoAd msg:" + str + "_" + str2);
                GEMixBannerAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void doShowAD(Activity activity) {
        try {
            YFLog.high(this.tag + " doShowAD--");
            if (isTemplate()) {
                doShowTemplateAd(activity);
            } else if (isDevelop()) {
                super.doShowNativeAd(activity);
            }
        } catch (Throwable th) {
            YFLog.error(this.tag + " doShowAD--" + th.getMessage());
            handleShowFailed();
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        release();
    }

    private void doShowTemplateAd(Activity activity) {
        PtgNativeExpressAd ptgNativeExpressAd = this.tempPtgNativeExpressAd;
        if (ptgNativeExpressAd != null) {
            View expressAdView = ptgNativeExpressAd.getExpressAdView();
            RelativeLayout relativeLayout = new RelativeLayout(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
            relativeLayout.addView(expressAdView, new RelativeLayout.LayoutParams(-1, -2));
            YFExpView yFExpView = new YFExpView(relativeLayout, getAdType(), 0);
            this.viewList.add(yFExpView);
            if (this.setting != null) {
                this.setting.adapterRenderSuccess(this.sdkSupplier, this.viewList);
            }
            this.tempPtgNativeExpressAd.setExpressInteractionListener(new GMNativeExpressAdListener(yFExpView, this));
            this.tempPtgNativeExpressAd.render();
            return;
        }
        YFLog.error(this.tag + " doShowTemplateAd--tempPtgNativeExpressAd is null");
        this.setting.adapterRenderFailed(this.sdkSupplier);
    }

    private static final class GMNativeExpressAdListener extends NativeExpressCustomAdapter.ExpViewListener<GEMixBannerAdapter> implements PtgNativeExpressAd.AdInteractionListener {
        private final ExpView expView;

        public GMNativeExpressAdListener(ExpView expView, GEMixBannerAdapter gEMixBannerAdapter) {
            super(gEMixBannerAdapter);
            this.expView = expView;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public void onAdDismiss() {
            YFLog.debug("GEMixBannerAdapter template onAdDismiss");
            if (getAdapter() != null) {
                getAdapter().handleClose(this.expView);
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked() {
            YFLog.debug("GEMixBannerAdapter template onAdClick");
            if (getAdapter() != null) {
                getAdapter().handleClick(this.expView);
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow() {
            YFLog.debug("GEMixBannerAdapter template onAdShow");
            if (getAdapter() != null) {
                getAdapter().handleExposure(this.expView);
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(AdError adError) {
            if (getAdapter() != null) {
                YFLog.debug("GEMixBannerAdapter template onAdRenderFail" + (adError != null ? adError.getMessage() : ""));
                getAdapter().handleRenderFailed(this.expView);
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view) {
            YFLog.debug("GEMixBannerAdapter template onRenderSuccess");
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        PtgAdSdk.get().loadNativeExpressAd(context, new AdSlot.Builder().setPtgSlotId(getPotID()).setSelfRender(isDevelop()).build(), this);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.GE.getValue();
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.NativeExpressAdListener
    public void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
        release();
        if (ptgNativeExpressAd != null) {
            updData(ptgNativeExpressAd);
            setEcpm(ptgNativeExpressAd.getEcpm());
            handleSucceed();
            return;
        }
        handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
    }

    private void updData(PtgNativeExpressAd ptgNativeExpressAd) {
        if (!isDevelop()) {
            this.tempPtgNativeExpressAd = ptgNativeExpressAd;
            return;
        }
        this.developAds.clear();
        this.developAds.add(new GENativeAds(ptgNativeExpressAd, this));
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        PtgNativeExpressAd ptgNativeExpressAd = this.tempPtgNativeExpressAd;
        String shortString = "";
        if (ptgNativeExpressAd != null) {
            ptgNativeExpressAd.notifyBidWin(ptgNativeExpressAd.getEcpm(), sdkSupplier.ecpm);
            YFLog.high(this.tag + " sendBiddingSucResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        if (YFListUtils.isEmpty(this.developAds)) {
            return;
        }
        for (YFNativeAd yFNativeAd : this.developAds) {
            if (yFNativeAd instanceof GENativeAds) {
                GENativeAds gENativeAds = (GENativeAds) yFNativeAd;
                gENativeAds.sendWinNotification(gENativeAds.getECPM(), (int) sdkSupplier.ecpm);
            }
        }
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult size=").append(this.developAds.size()).append(" current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append(" los=");
        if (UrlConst.isTestEnv() && sdkSupplier != null) {
            shortString = sdkSupplier.toShortString();
        }
        YFLog.high(sbAppend.append(shortString).toString());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (this.tempPtgNativeExpressAd != null && sdkSupplier != null) {
            AdBidLossReason adBidLossReason = new AdBidLossReason();
            adBidLossReason.setLossCode(BiddingConst.BIDDING_LOSS.WITH_LOW_PRICE_IN_HB);
            adBidLossReason.setWinPrice(sdkSupplier.ecpm);
            adBidLossReason.setWinAdnId(BiddingConst.ADN_ID.LOSE_TO_OTHER_ADN);
            this.tempPtgNativeExpressAd.notifyBidLoss(adBidLossReason);
        }
        if (YFListUtils.isEmpty(this.developAds)) {
            return;
        }
        for (YFNativeAd yFNativeAd : this.developAds) {
            if (yFNativeAd instanceof GENativeAds) {
                ((GENativeAds) yFNativeAd).sendLossNotification((int) sdkSupplier.ecpm);
            }
        }
        YFLog.high(this.tag + " sendBiddingLossResult size=" + this.developAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.fancy.adsdk.lib.interf.Error
    public void onError(AdError adError) {
        if (adError != null) {
            YFLog.warn(this.tag + "onError code = " + adError.getErrorCode() + " msg = " + adError.getMessage());
            handleFailed(YFAdError.parseErr(adError.getErrorCode()));
        } else {
            YFLog.warn(this.tag + "onError null");
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        if (isDevelop()) {
            super.isReady();
        }
        PtgNativeExpressAd ptgNativeExpressAd = this.tempPtgNativeExpressAd;
        return ptgNativeExpressAd != null && ptgNativeExpressAd.isReady();
    }

    private void release() {
        PtgNativeExpressAd ptgNativeExpressAd = this.tempPtgNativeExpressAd;
        if (ptgNativeExpressAd != null) {
            ptgNativeExpressAd.destroy();
            this.tempPtgNativeExpressAd = null;
        }
    }
}
