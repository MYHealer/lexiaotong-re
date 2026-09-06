package com.yfanads.ads.chanel.nal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.AdRequest;
import com.adprof.sdk.api.IBiddingNotify;
import com.adprof.sdk.api.NativeAd;
import com.adprof.sdk.api.NativeAdAllEventListener;
import com.adprof.sdk.api.NativeAdData;
import com.adprof.sdk.api.NativeAdLoadListener;
import com.yfanads.ads.chanel.nal.model.NalNativeAds;
import com.yfanads.ads.chanel.nal.utils.NalUtil;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class NalMixBannerAdapter extends NativeExpressCustomAdapter implements NativeAdLoadListener, YFNativeCall {
    private NativeAd nativeAd;
    private List<NativeAdData> nativeAdBeans;

    public NalMixBannerAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        NalUtil.initNal(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.nal.NalMixBannerAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                NalMixBannerAdapter nalMixBannerAdapter = NalMixBannerAdapter.this;
                nalMixBannerAdapter.startLoadAD(nalMixBannerAdapter.getContext());
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YFLog.error(NalMixBannerAdapter.this.tag + " onNoAd msg:" + str + "_" + str2);
                NalMixBannerAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        try {
            NativeAd nativeAd = this.nativeAd;
            return (nativeAd == null || YFListUtils.isMapEmpty(nativeAd.getExtraInfo())) ? "" : (String) this.nativeAd.getExtraInfo().get("loadId");
        } catch (Exception e) {
            YFLog.error(this.tag + " getAdReqId " + e.getMessage());
            return "";
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void doShowAD(Activity activity) {
        try {
            YFLog.high(this.tag + " doShowAD--");
            if (isDevelop()) {
                super.doShowNativeAd(activity);
            } else {
                doShowTemplateAd();
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

    private void doShowTemplateAd() {
        if (this.nativeAd != null && !YFListUtils.isEmpty(this.nativeAdBeans)) {
            for (int i = 0; i < this.nativeAdBeans.size(); i++) {
                NativeAdData nativeAdData = this.nativeAdBeans.get(i);
                YFExpView yFExpView = new YFExpView(nativeAdData.getFeedView(), getAdType(), i);
                this.viewList.add(yFExpView);
                nativeAdData.setNativeAdEventListener(new INNativeExpressAdListener(yFExpView, this));
            }
            if (this.setting != null) {
                this.setting.adapterRenderSuccess(this.sdkSupplier, this.viewList);
                return;
            }
            return;
        }
        YFLog.error(this.tag + " doShowTemplateAd--tempPtgNativeExpressAd is null");
        this.setting.adapterRenderFailed(this.sdkSupplier);
    }

    @Override // com.adprof.sdk.api.NativeAdLoadListener
    public void onAdError(AdError adError) {
        if (adError != null) {
            YFLog.warn(this.tag + "onError code = " + adError.getErrorCode() + " msg = " + adError.getMessage());
            handleFailed(YFAdError.parseErr(adError.getErrorCode()));
        } else {
            YFLog.warn(this.tag + "onError null");
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
        }
    }

    @Override // com.adprof.sdk.api.NativeAdLoadListener
    public void onAdLoad(List<NativeAdData> list) {
        if (this.nativeAd != null && !YFListUtils.isEmpty(list)) {
            updData(list);
            setEcpm(this.nativeAd.getBidPrice());
            handleSucceed();
            return;
        }
        handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
    }

    private void updData(List<NativeAdData> list) {
        if (!isDevelop()) {
            this.nativeAdBeans = list;
            return;
        }
        Iterator<NativeAdData> it = list.iterator();
        while (it.hasNext()) {
            this.developAds.add(new NalNativeAds(getContext(), this.nativeAd, it.next(), this));
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        if (this.nativeAd != null) {
            HashMap map = new HashMap();
            map.put(IBiddingNotify.WIN_FIRST_PRICE, Long.valueOf(getEcpm()));
            String shortString = "";
            map.put(IBiddingNotify.WIN_HIGHEST_LOSS_PRICE, sdkSupplier != null ? Long.valueOf(sdkSupplier.ecpm) : "");
            this.nativeAd.sendWinNotify(map);
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (this.nativeAd != null) {
            HashMap map = new HashMap();
            map.put(IBiddingNotify.LOSS_FIRST_PRICE, Long.valueOf(sdkSupplier.ecpm));
            map.put(IBiddingNotify.LOSS_REASON, 100);
            this.nativeAd.sendWinNotify(map);
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
    }

    private static final class INNativeExpressAdListener extends NativeExpressCustomAdapter.ExpViewListener<NalMixBannerAdapter> implements NativeAdAllEventListener {
        private final ExpView expView;

        public INNativeExpressAdListener(ExpView expView, NalMixBannerAdapter nalMixBannerAdapter) {
            super(nalMixBannerAdapter);
            this.expView = expView;
        }

        @Override // com.adprof.sdk.api.NativeAdEventListener
        public void onAdExposed() {
            YFLog.debug("INMixBannerAdapter template onAdShow");
            if (getAdapter() != null) {
                getAdapter().handleExposure(this.expView);
            }
        }

        @Override // com.adprof.sdk.api.NativeAdEventListener
        public void onAdClicked() {
            YFLog.debug("NalMixBannerAdapter template onAdClick");
            if (getAdapter() != null) {
                getAdapter().handleClick(this.expView);
            }
        }

        @Override // com.adprof.sdk.api.NativeAdEventListener
        public void onAdRenderFail(AdError adError) {
            YFLog.debug("NalMixBannerAdapter template onAdRenderFail");
            if (getAdapter() != null) {
                getAdapter().handleShowFailed(adError.getMessage());
            }
        }

        @Override // com.adprof.sdk.api.NativeAdAllEventListener
        public void onAdClose(View view) {
            YFLog.debug("NalMixBannerAdapter template onAdClose");
            if (getAdapter() != null) {
                getAdapter().handleClose(this.expView);
            }
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        NativeAd nativeAd = new NativeAd(new AdRequest.Builder().setCodeId(getPotID()).setIsExpressAd(!isDevelop()).setWidth(this.setting.getViewWidth()).build(), this);
        this.nativeAd = nativeAd;
        nativeAd.loadAd();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.NAL.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        NativeAd nativeAd = this.nativeAd;
        return nativeAd != null && nativeAd.isReady();
    }

    private void release() {
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            nativeAd.destroyAd();
            this.nativeAd = null;
        }
        List<NativeAdData> list = this.nativeAdBeans;
        if (list != null) {
            Iterator<NativeAdData> it = list.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            this.nativeAdBeans.clear();
            this.nativeAdBeans = null;
        }
    }
}
