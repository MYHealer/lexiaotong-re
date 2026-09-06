package com.yfanads.ads.chanel.bd;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.yfanads.ads.chanel.bd.model.BDNativeAds;
import com.yfanads.ads.chanel.bd.utils.BDUtil;
import com.yfanads.android.core.render.YFNativeSetting;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.custom.NativeCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class BDNativeAdapter extends NativeCustomAdapter implements YFNativeCall, BaiduNativeManager.FeedAdListener {
    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onLpClosed() {
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onVideoDownloadFailed() {
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onVideoDownloadSuccess() {
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter, com.yfanads.android.core.render.api.YFNativeCall
    public void showFeedBackDialog(FragmentManager fragmentManager, String str) {
    }

    public BDNativeAdapter(YFNativeSetting yFNativeSetting) {
        super(yFNativeSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.BAIDU.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        BDUtil.initBDAccount(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.bd.BDNativeAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                BDNativeAdapter bDNativeAdapter = BDNativeAdapter.this;
                bDNativeAdapter.startLoadAD(bDNativeAdapter.getContext());
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YFLog.error(BDNativeAdapter.this.tag + " fail msg:" + str + "_" + str2);
                BDNativeAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
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
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(context, this.sdkSupplier.getPotId());
        RequestParameters requestParametersBuild = new RequestParameters.Builder().build();
        InitBean initBean = getInitBean();
        if (initBean != null && !TextUtils.isEmpty(initBean.appId)) {
            YFLog.high(this.tag + " setAppSid:" + initBean.appId);
            baiduNativeManager.setAppSid(initBean.appId);
        }
        baiduNativeManager.loadFeedAd(requestParametersBuild, this);
    }

    private void setAdList(List<NativeResponse> list) {
        Context context = getContext();
        for (int i = 0; i < list.size(); i++) {
            this.nativeAds.add(new BDNativeAds(context, list.get(i), this.sdkSupplier.getTemplateConf(), this, i));
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        if (YFListUtils.isEmpty(this.nativeAds)) {
            return;
        }
        for (YFNativeAd yFNativeAd : this.nativeAds) {
            if (yFNativeAd instanceof BDNativeAds) {
                ((BDNativeAds) yFNativeAd).biddingSuccess(BDUtil.getWindBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDNativeAdapter$$ExternalSyntheticLambda0
                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                    public final void onBiddingResult(boolean z, String str, HashMap map) {
                        this.f$0.m1059xdd362123(z, str, map);
                    }
                });
            }
        }
        String shortString = "";
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult size=").append(this.nativeAds.size()).append(" current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
        if (UrlConst.isTestEnv() && sdkSupplier != null) {
            shortString = sdkSupplier.toShortString();
        }
        YFLog.high(sbAppend.append(shortString).toString());
    }

    /* JADX INFO: renamed from: lambda$sendSucBiddingResult$0$com-yfanads-ads-chanel-bd-BDNativeAdapter, reason: not valid java name */
    /* synthetic */ void m1059xdd362123(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-win: " + z + " msg信息：" + str);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (YFListUtils.isEmpty(this.nativeAds)) {
            return;
        }
        for (YFNativeAd yFNativeAd : this.nativeAds) {
            if (yFNativeAd instanceof BDNativeAds) {
                ((BDNativeAds) yFNativeAd).biddingFail(BDUtil.getLossBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDNativeAdapter$$ExternalSyntheticLambda1
                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                    public final void onBiddingResult(boolean z, String str, HashMap map) {
                        this.f$0.m1058x508ec418(z, str, map);
                    }
                });
            }
        }
        YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    /* JADX INFO: renamed from: lambda$sendLossBiddingResult$1$com-yfanads-ads-chanel-bd-BDNativeAdapter, reason: not valid java name */
    /* synthetic */ void m1058x508ec418(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-loss: " + z + " msg信息：" + str);
    }

    @Override // com.yfanads.android.custom.NativeCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        if (this.nativeAds != null) {
            this.nativeAds = null;
        }
    }

    @Override // com.yfanads.android.custom.NativeCustomAdapter
    public void doShowAD(Activity activity) {
        YFLog.high(this.tag + " doShowAD ");
        if (this.setting != null) {
            this.setting.onAdSuccess(this.nativeAds);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        return (YFListUtils.isEmpty(this.nativeAds) || i >= this.nativeAds.size()) ? "" : ((BDNativeAds) this.nativeAds.get(i)).getReqId();
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onNativeLoad(List<NativeResponse> list) {
        YFLog.high(this.tag + "onNativeAdLoad");
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    handleFailed(YFAdError.ERROR_DATA_NULL, "");
                } else {
                    setEcpmByStr(list.get(0).getECPMLevel());
                    setAdList(list);
                    handleSucceed();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                YFLog.error(this.tag + " error:" + th.getMessage());
                handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
            }
        } else {
            handleFailed(YFAdError.ERROR_DATA_NULL, "");
        }
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onNativeFail(int i, String str, NativeResponse nativeResponse) {
        YFLog.error(this.tag + " onNativeFail msg:" + str + "_" + i);
        handleFailed(i, str);
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onNoAd(int i, String str, NativeResponse nativeResponse) {
        handleFailed(i, str);
    }
}
