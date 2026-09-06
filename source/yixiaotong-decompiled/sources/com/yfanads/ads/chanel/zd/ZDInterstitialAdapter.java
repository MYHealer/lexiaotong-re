package com.yfanads.ads.chanel.zd;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.interstitial.InterstitialAd;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdEventListener;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.yfanads.ads.chanel.zd.utils.ZDUtil;
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
import com.yfanads.android.utils.YFUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ZDInterstitialAdapter extends InterstitialCustomAdapter implements InterstitialAdEventListener, InteractionListener {
    private InterstitialAdLoader adLoader;
    private InterstitialAd interstitialAd;

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void bindData(Activity activity, InterTemplateData interTemplateData, AdBaseViewHolder adBaseViewHolder) {
    }

    public ZDInterstitialAdapter(YFInterstitialSetting yFInterstitialSetting) {
        super(yFInterstitialSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        ZDUtil.initZD(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.zd.ZDInterstitialAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                ZDInterstitialAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YFLog.error(ZDInterstitialAdapter.this.tag + " onNoAd msg:" + str + "_" + str2);
                ZDInterstitialAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        try {
            if (context instanceof Activity) {
                YFLog.high(this.tag + " doLoadAD start -- ");
                InterstitialAdLoader interstitialAdLoader = new InterstitialAdLoader((Activity) context, new MsAdSlot.Builder().setPid(getPotID()).setFetchCount(1).setVideoMute(true).build(), this);
                this.adLoader = interstitialAdLoader;
                interstitialAdLoader.loadAd();
                YFLog.high(this.tag + " doLoadAD end -- ");
            } else {
                handleFailed(YFAdError.parseErr(YFAdError.ERROR_MEISHU_CONTEXT));
            }
        } catch (Exception e) {
            YFLog.error(this.tag + " doLoadAD error:" + e.getMessage());
        }
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        handleShowApiInvoke();
        YFLog.high(this.tag + " doShowAD -- " + activity);
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            interstitialAd.showAd(activity);
        } else {
            handleShowFailed(this.tag + " interstitialAd is null");
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        InterstitialAd interstitialAd = this.interstitialAd;
        return (interstitialAd == null || interstitialAd.getData() == null) ? "" : this.interstitialAd.getData().getReqId();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            return interstitialAd.isAdValid();
        }
        return super.isReady();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        if (this.interstitialAd != null) {
            HashMap map = new HashMap();
            String shortString = "";
            map.put("winPrice", Integer.valueOf(YFUtil.toInt(getEcpm() + "", 0)));
            map.put("highestLossPrice", Integer.valueOf(sdkSupplier != null ? YFUtil.toInt(sdkSupplier.ecpm + "", 0) : 0));
            this.interstitialAd.sendWinNotification(map);
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
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
        HashMap map = new HashMap();
        map.put("winPrice", Integer.valueOf(YFUtil.toInt(sdkSupplier.ecpm + "", 0)));
        map.put("lossReason", 1);
        map.put("adnId", 2);
        this.interstitialAd.sendLossNotification(map);
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        YFLog.high(this.tag + "doDestroy");
        super.doDestroy();
        InterstitialAdLoader interstitialAdLoader = this.adLoader;
        if (interstitialAdLoader != null) {
            interstitialAdLoader.destroy();
            this.adLoader = null;
        }
        if (this.interstitialAd != null) {
            this.interstitialAd = null;
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
    public void onAdReady(InterstitialAd interstitialAd) {
        try {
            if (interstitialAd == null) {
                handleFailed(YFAdError.ERROR_DATA_NULL, this.tag + " KsSplashScreenAd null");
                return;
            }
            this.interstitialAd = interstitialAd;
            interstitialAd.setInteractionListener(this);
            if (interstitialAd.getData() != null) {
                setEcpmByStr(interstitialAd.getData().getEcpm());
            }
            handleSucceed();
        } catch (Throwable unused) {
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_LOAD));
        }
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
