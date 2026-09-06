package com.yfanads.ads.chanel.ge;

import android.app.Activity;
import android.content.Context;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.yfanads.ads.chanel.ge.model.GENativeAds;
import com.yfanads.ads.chanel.ge.utils.GEUtil;
import com.yfanads.android.core.render.YFNativeSetting;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.custom.NativeCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class GENativeAdapter extends NativeCustomAdapter implements YFNativeCall {
    private PtgNativeExpressAd nativeExpressAd;

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        return "";
    }

    public GENativeAdapter(YFNativeSetting yFNativeSetting) {
        super(yFNativeSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.GE.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        GEUtil.initGE(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ge.GENativeAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                GENativeAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                GENativeAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else {
            loadBannerAdByNative(context);
        }
    }

    private void loadBannerAdByNative(Context context) {
        PtgAdSdk.get().loadNativeExpressAd(context, new AdSlot.Builder().setPtgSlotId(this.sdkSupplier.getPotId()).setSelfRender(true).build(), new PtgAdNative.NativeExpressAdListener() { // from class: com.yfanads.ads.chanel.ge.GENativeAdapter.2
            @Override // com.fancy.adsdk.lib.interf.Error
            public void onError(AdError adError) {
                YFLog.debug(GENativeAdapter.this.tag + " onError " + adError.getMessage());
                GENativeAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, adError.getMessage());
            }

            @Override // com.fancy.adsdk.lib.provider.PtgAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
                if (ptgNativeExpressAd != null) {
                    YFLog.debug(GENativeAdapter.this.tag + " onNativeExpressAdLoad " + ptgNativeExpressAd.getEcpm());
                    GENativeAdapter.this.nativeExpressAd = ptgNativeExpressAd;
                    GENativeAdapter.this.nativeAds.add(new GENativeAds(GENativeAdapter.this.nativeExpressAd, GENativeAdapter.this));
                    GENativeAdapter.this.setEcpm(ptgNativeExpressAd.getEcpm());
                    GENativeAdapter.this.handleSucceed();
                    return;
                }
                YFLog.debug(GENativeAdapter.this.tag + " onNativeExpressAdLoad null");
                GENativeAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
            }
        });
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        if (YFListUtils.isEmpty(this.nativeAds)) {
            return;
        }
        for (YFNativeAd yFNativeAd : this.nativeAds) {
            if (yFNativeAd instanceof GENativeAds) {
                GENativeAds gENativeAds = (GENativeAds) yFNativeAd;
                gENativeAds.sendWinNotification(gENativeAds.getECPM(), (int) sdkSupplier.ecpm);
            }
        }
        String shortString = "";
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult size=").append(this.nativeAds.size()).append(" current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append(" los=");
        if (UrlConst.isTestEnv() && sdkSupplier != null) {
            shortString = sdkSupplier.toShortString();
        }
        YFLog.high(sbAppend.append(shortString).toString());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (YFListUtils.isEmpty(this.nativeAds)) {
            return;
        }
        for (YFNativeAd yFNativeAd : this.nativeAds) {
            if (yFNativeAd instanceof GENativeAds) {
                ((GENativeAds) yFNativeAd).sendLossNotification((int) sdkSupplier.ecpm);
            }
        }
        YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.custom.NativeCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        PtgNativeExpressAd ptgNativeExpressAd = this.nativeExpressAd;
        if (ptgNativeExpressAd != null) {
            ptgNativeExpressAd.destroy();
        }
    }

    @Override // com.yfanads.android.custom.NativeCustomAdapter
    public void doShowAD(Activity activity) {
        YFLog.high(this.tag + " doShowAD ");
        if (this.setting != null) {
            this.setting.onAdSuccess(this.nativeAds);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter, com.yfanads.android.core.render.api.YFNativeCall
    public void handleClose() {
        YFLog.high(this.tag + " handleClose ");
        super.handleClose();
    }
}
