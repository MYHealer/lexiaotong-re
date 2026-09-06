package com.yfanads.ads.chanel.bd;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.yfanads.ads.chanel.bd.utils.BDUtil;
import com.yfanads.android.core.full.YFFullScreenVideoSetting;
import com.yfanads.android.custom.FullScreenCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class BDFullScreenVideoAdapter extends FullScreenCustomAdapter implements FullScreenVideoAd.FullScreenVideoAdListener {
    private FullScreenVideoAd mFullScreenVideoAd;

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        return "";
    }

    public BDFullScreenVideoAdapter(YFFullScreenVideoSetting yFFullScreenVideoSetting) {
        super(yFFullScreenVideoSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        BDUtil.initBDAccount(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.bd.BDFullScreenVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                BDFullScreenVideoAdapter bDFullScreenVideoAdapter = BDFullScreenVideoAdapter.this;
                bDFullScreenVideoAdapter.startLoadAD(bDFullScreenVideoAdapter.getContext());
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YFLog.error(BDFullScreenVideoAdapter.this.tag + " onNoAd msg:" + str + "_" + str2);
                BDFullScreenVideoAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
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
        this.mFullScreenVideoAd = new FullScreenVideoAd(context, this.sdkSupplier.getPotId(), this, false);
        InitBean initBean = getInitBean();
        if (initBean != null && !TextUtils.isEmpty(initBean.appId)) {
            YFLog.high(this.tag + " setAppSid:" + initBean.appId);
            this.mFullScreenVideoAd.setAppSid(initBean.appId);
        }
        this.mFullScreenVideoAd.load();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        FullScreenVideoAd fullScreenVideoAd = this.mFullScreenVideoAd;
        return fullScreenVideoAd != null && fullScreenVideoAd.isReady();
    }

    @Override // com.yfanads.android.custom.FullScreenCustomAdapter
    public void doShowAD(Activity activity) {
        try {
            FullScreenVideoAd fullScreenVideoAd = this.mFullScreenVideoAd;
            YFLog.high(this.tag + " doShowAD isReady = " + (fullScreenVideoAd != null && fullScreenVideoAd.isReady()));
            FullScreenVideoAd fullScreenVideoAd2 = this.mFullScreenVideoAd;
            if (fullScreenVideoAd2 == null) {
                handleShowFailed();
            } else {
                fullScreenVideoAd2.show();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            handleShowFailed();
        }
    }

    /* JADX INFO: renamed from: lambda$sendSucBiddingResult$0$com-yfanads-ads-chanel-bd-BDFullScreenVideoAdapter, reason: not valid java name */
    /* synthetic */ void m1049xd9d64c44(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-win: " + z + " msg信息：" + str);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        FullScreenVideoAd fullScreenVideoAd = this.mFullScreenVideoAd;
        if (fullScreenVideoAd != null) {
            fullScreenVideoAd.biddingSuccess(BDUtil.getWindBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDFullScreenVideoAdapter$$ExternalSyntheticLambda0
                @Override // com.baidu.mobads.sdk.api.BiddingListener
                public final void onBiddingResult(boolean z, String str, HashMap map) {
                    this.f$0.m1049xd9d64c44(z, str, map);
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

    /* JADX INFO: renamed from: lambda$sendLossBiddingResult$1$com-yfanads-ads-chanel-bd-BDFullScreenVideoAdapter, reason: not valid java name */
    /* synthetic */ void m1048xed5d2cef(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-loss: " + z + " msg信息：" + str);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        FullScreenVideoAd fullScreenVideoAd = this.mFullScreenVideoAd;
        if (fullScreenVideoAd == null || sdkSupplier == null) {
            return;
        }
        fullScreenVideoAd.biddingFail(BDUtil.getLossBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDFullScreenVideoAdapter$$ExternalSyntheticLambda1
            @Override // com.baidu.mobads.sdk.api.BiddingListener
            public final void onBiddingResult(boolean z, String str, HashMap map) {
                this.f$0.m1048xed5d2cef(z, str, map);
            }
        });
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.custom.FullScreenCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        if (this.mFullScreenVideoAd != null) {
            this.mFullScreenVideoAd = null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdShow() {
        YFLog.high(this.tag + "onAdShow");
        handleExposure();
    }

    @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdClick() {
        YFLog.high(this.tag + IAdInterListener.AdCommandType.AD_CLICK);
        handleClick();
    }

    @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdClose(float f) {
        YFLog.high(this.tag + "onAdClose，playScale = " + f);
        handleClose();
    }

    @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdFailed(String str) {
        YFLog.high(this.tag + " onAdFailed " + str);
        handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "onAdFailed" + str);
    }

    @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onVideoDownloadSuccess() {
        YFLog.high(this.tag + "onVideoDownloadSuccess");
        handleCached();
    }

    @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onVideoDownloadFailed() {
        YFLog.error(this.tag + "onVideoDownloadFailed");
    }

    @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void playCompletion() {
        YFLog.high(this.tag + "playCompletion");
        handleVideoComplete();
    }

    @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdSkip(float f) {
        YFLog.high(this.tag + "onAdSkip，playScale = " + f);
        handleClose(true);
    }

    @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdLoaded() {
        YFLog.high(this.tag + "onAdLoaded ");
        FullScreenVideoAd fullScreenVideoAd = this.mFullScreenVideoAd;
        if (fullScreenVideoAd != null) {
            setEcpmByStr(fullScreenVideoAd.getECPMLevel());
        }
        handleSucceed();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.BAIDU.getValue();
    }
}
