package com.yfanads.ads.chanel.bd;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import com.huawei.hms.ads.ez;
import com.yfanads.ads.chanel.bd.utils.BDUtil;
import com.yfanads.android.core.splash.YFSplashSetting;
import com.yfanads.android.custom.SplashCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class BDSplashAdapter extends SplashCustomAdapter implements SplashInteractionListener {
    private boolean isCountingEnd;
    private SplashAd splashAd;

    public BDSplashAdapter(YFSplashSetting yFSplashSetting) {
        super(yFSplashSetting);
        this.isCountingEnd = false;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        BDUtil.initBDAccount(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.bd.BDSplashAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                BDSplashAdapter bDSplashAdapter = BDSplashAdapter.this;
                bDSplashAdapter.startLoadAD(bDSplashAdapter.getContext());
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                BDSplashAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
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
        RequestParameters.Builder builder = new RequestParameters.Builder();
        builder.addExtra("timeout", (this.sdkSupplier.requestTimeout > 0 ? (int) this.sdkSupplier.requestTimeout : 3000) + "");
        builder.addExtra(SplashAd.KEY_LOAD_AFTER_CACHE_END, ez.Code);
        boolean z = false;
        builder.setWidth(sizeDp[0]);
        builder.setHeight(sizeDp[1]);
        this.splashAd = new SplashAd(context, this.sdkSupplier.getPotId(), builder.build(), this);
        InitBean initBean = getInitBean();
        if (initBean != null && !TextUtils.isEmpty(initBean.appId)) {
            YFLog.high(this.tag + " setAppSid:" + initBean.appId);
            this.splashAd.setAppSid(initBean.appId);
        }
        this.splashAd.load();
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append("doLoadAD -- ").append(Arrays.toString(sizeDp)).append(" dp, ");
        if (this.mSplashSetting != null && this.mSplashSetting.isCustom()) {
            z = true;
        }
        YFLog.high(sbAppend.append(z).toString());
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        SplashAd splashAd;
        handleShowApiInvoke();
        YFLog.high(this.tag + " doShowAD -- " + activity);
        if (!YFUtil.isActivityDestroyed(activity) && (splashAd = this.splashAd) != null) {
            splashAd.show(viewGroup);
        } else {
            handleShowFailed(this.tag + " activity is isActivityDestroyed");
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        SplashAd splashAd = this.splashAd;
        return splashAd != null ? BDUtil.getReqId(splashAd.getAdDataForKey("request_id")) : "";
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        SplashAd splashAd = this.splashAd;
        return splashAd != null && splashAd.isReady();
    }

    /* JADX INFO: renamed from: lambda$sendSucBiddingResult$0$com-yfanads-ads-chanel-bd-BDSplashAdapter, reason: not valid java name */
    /* synthetic */ void m1072x2a930cd3(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-win: " + z + " msg信息：" + str);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        SplashAd splashAd = this.splashAd;
        if (splashAd != null) {
            splashAd.biddingSuccess(BDUtil.getWindBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDSplashAdapter$$ExternalSyntheticLambda1
                @Override // com.baidu.mobads.sdk.api.BiddingListener
                public final void onBiddingResult(boolean z, String str, HashMap map) {
                    this.f$0.m1072x2a930cd3(z, str, map);
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

    /* JADX INFO: renamed from: lambda$sendLossBiddingResult$1$com-yfanads-ads-chanel-bd-BDSplashAdapter, reason: not valid java name */
    /* synthetic */ void m1071x9debafc8(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-loss: " + z + " msg信息：" + str);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        SplashAd splashAd = this.splashAd;
        if (splashAd == null || sdkSupplier == null) {
            return;
        }
        splashAd.biddingFail(BDUtil.getLossBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDSplashAdapter$$ExternalSyntheticLambda0
            @Override // com.baidu.mobads.sdk.api.BiddingListener
            public final void onBiddingResult(boolean z, String str, HashMap map) {
                this.f$0.m1071x9debafc8(z, str, map);
            }
        });
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        YFLog.high(this.tag + "doDestroy");
        super.doDestroy();
        SplashAd splashAd = this.splashAd;
        if (splashAd != null) {
            splashAd.destroy();
            this.splashAd = null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onLpClosed() {
        YFLog.high(this.tag + "onLpClosed");
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdPresent() {
        YFLog.high(this.tag + "onAdPresent");
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdSkip() {
        YFLog.high(this.tag + "onAdSkip");
        this.isCountingEnd = true;
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdExposed() {
        YFLog.high(this.tag + "onAdExposed");
        handleExposure();
    }

    @Override // com.baidu.mobads.sdk.api.SplashAdListener
    public void onADLoaded() {
        YFLog.high(this.tag + "onADLoaded ");
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdClick() {
        YFLog.high(this.tag + IAdInterListener.AdCommandType.AD_CLICK);
        handleClick();
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdCacheSuccess() {
        YFLog.high(this.tag + "onAdCacheSuccess " + this.sdkSupplier);
        SplashAd splashAd = this.splashAd;
        if (splashAd != null) {
            setEcpmByStr(splashAd.getECPMLevel());
        }
        handleSucceed();
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdCacheFailed() {
        YFLog.high(this.tag + "onAdCacheFailed isStartShow:" + isStartShow());
        if (isStartShow()) {
            handleRenderFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdDismissed() {
        YFLog.high(this.tag + "onAdDismissed");
        handleClose(!this.isCountingEnd);
    }

    @Override // com.baidu.mobads.sdk.api.SplashAdListener
    public void onAdFailed(String str) {
        YFLog.high(this.tag + "onAdFailed reason:" + str);
        if (isStartShow()) {
            handleRenderFailed();
        } else {
            handleFailed(YFAdError.ERROR_DATA_NULL, str);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.BAIDU.getValue();
    }
}
