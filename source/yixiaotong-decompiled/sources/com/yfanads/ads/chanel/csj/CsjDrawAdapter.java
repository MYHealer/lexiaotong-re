package com.yfanads.ads.chanel.csj;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.cdo.oaps.ad.OapsKey;
import com.yfanads.ads.chanel.csj.utils.CsjUtil;
import com.yfanads.android.core.draw.YFDrawSetting;
import com.yfanads.android.custom.DrawCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class CsjDrawAdapter extends DrawCustomAdapter implements TTAdNative.NativeExpressAdListener, TTNativeExpressAd.ExpressVideoAdListener, TTNativeExpressAd.ExpressAdInteractionListener {
    protected TTNativeExpressAd ad;
    protected String ecpm;

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onClickRetry() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onProgressUpdate(long j, long j2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdComplete() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdContinuePlay() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdPaused() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdStartPlay() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoLoad() {
    }

    public CsjDrawAdapter(YFDrawSetting yFDrawSetting) {
        super(yFDrawSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        CsjUtil.initCsj(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.csj.CsjDrawAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                CsjDrawAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                CsjDrawAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.DrawCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        TTNativeExpressAd tTNativeExpressAd = this.ad;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
            this.ad = null;
        }
    }

    @Override // com.yfanads.android.custom.DrawCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        TTNativeExpressAd tTNativeExpressAd;
        super.m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(activity, viewGroup);
        if (isBidding() && (tTNativeExpressAd = this.ad) != null) {
            tTNativeExpressAd.setPrice(Double.valueOf(YFUtil.toDouble(this.ecpm, 1.0d)));
        }
        TTNativeExpressAd tTNativeExpressAd2 = this.ad;
        if (tTNativeExpressAd2 != null && addADView(tTNativeExpressAd2.getExpressAdView(), viewGroup)) {
            this.ad.render();
        } else {
            handleShowFailed();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        TTNativeExpressAd tTNativeExpressAd = this.ad;
        return tTNativeExpressAd != null ? CsjUtil.getReqId(tTNativeExpressAd.getMediaExtraInfo()) : "";
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        TTNativeExpressAd tTNativeExpressAd = this.ad;
        return (tTNativeExpressAd == null || tTNativeExpressAd.getMediaExtraInfo() == null || !this.ad.getMediationManager().isReady()) ? false : true;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isBidding() {
        return this.sdkSupplier != null && this.sdkSupplier.isBidding() && CsjUtil.isSupportBidding;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.mDrawSetting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else {
            CsjUtil.getADManger().createAdNative(context).loadExpressDrawFeedAd(new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setSupportDeepLink(true).setExpressViewAcceptedSize(this.mDrawSetting.getExpressWidth(), this.mDrawSetting.getExpressHeight()).setAdCount(1).setAdLoadType(TTAdLoadType.PRELOAD).build(), this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onError(int i, String str) {
        YFLog.high(this.tag + "onError" + i + str);
        handleFailed(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
        try {
            YFLog.high(this.tag + "onNativeExpressAdLoad, ads = " + list);
            if (list != null && !list.isEmpty()) {
                TTNativeExpressAd tTNativeExpressAd = list.get(0);
                this.ad = tTNativeExpressAd;
                tTNativeExpressAd.setExpressInteractionListener(this);
                this.ad.setVideoAdListener(this);
                if (isBidding()) {
                    updPrice();
                    setEcpmByStr(this.ecpm);
                }
                handleSucceed();
                return;
            }
            handleFailed(YFAdError.ERROR_DATA_NULL, "ads empty");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.CSJ.getValue();
    }

    protected void updPrice() {
        try {
            TTNativeExpressAd tTNativeExpressAd = this.ad;
            if (tTNativeExpressAd == null || tTNativeExpressAd.getMediaExtraInfo() == null) {
                return;
            }
            Object obj = this.ad.getMediaExtraInfo().get(OapsKey.KEY_PRICE);
            if (obj == null) {
                obj = "1";
            }
            this.ecpm = String.valueOf(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        TTNativeExpressAd tTNativeExpressAd = this.ad;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.win(Double.valueOf(sdkSupplier != null ? sdkSupplier.ecpm : YFUtil.toDouble(this.ecpm, 1.0d)));
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
        TTNativeExpressAd tTNativeExpressAd = this.ad;
        if (tTNativeExpressAd == null || sdkSupplier == null) {
            return;
        }
        tTNativeExpressAd.loss(Double.valueOf(sdkSupplier.ecpm), "102", CsjUtil.getAdnName(sdkSupplier.getAdnId()));
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        YFLog.high(this.tag + "onAdClicked, type = " + i);
        handleClick();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        YFLog.high(this.tag + "onAdShow, type = " + i);
        handleExposure();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        YFLog.high(this.tag + "onRenderFail, log = " + ("onRenderFail : code = " + i + ",msg =" + str));
        handleRenderFailed();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        YFLog.high(this.tag + "onRenderSuccess, width = " + f + ",height = " + f2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoError(int i, int i2) {
        handleFailed(i, i2 + "");
    }
}
