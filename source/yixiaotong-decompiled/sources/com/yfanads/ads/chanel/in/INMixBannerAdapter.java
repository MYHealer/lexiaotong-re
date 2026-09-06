package com.yfanads.ads.chanel.in;

import android.app.Activity;
import android.content.Context;
import com.ubixnow.adtype.nativead.api.UMNNativeAd;
import com.ubixnow.adtype.nativead.api.UMNNativeAdBean;
import com.ubixnow.adtype.nativead.api.UMNNativeAdView;
import com.ubixnow.adtype.nativead.api.UMNNativeEventListener;
import com.ubixnow.adtype.nativead.api.UMNNativeListener;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.core.api.UMNError;
import com.yfanads.ads.chanel.in.model.INNativeAds;
import com.yfanads.ads.chanel.in.utils.INUtil;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.custom.NativeExpressCustomAdapter;
import com.yfanads.android.model.ExpView;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFExpView;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class INMixBannerAdapter extends NativeExpressCustomAdapter implements UMNNativeListener, YFNativeCall {
    private UMNNativeAd nativeAd;
    private UMNNativeAdBean nativeAdBean;

    public INMixBannerAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        INUtil.initIN(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.in.INMixBannerAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                INMixBannerAdapter iNMixBannerAdapter = INMixBannerAdapter.this;
                iNMixBannerAdapter.startLoadAD(iNMixBannerAdapter.getContext());
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YFLog.error(INMixBannerAdapter.this.tag + " onNoAd msg:" + str + "_" + str2);
                INMixBannerAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        UMNNativeAd uMNNativeAd = this.nativeAd;
        return uMNNativeAd != null ? uMNNativeAd.getRequestId() : "";
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
        if (this.nativeAd != null) {
            UMNNativeAdView uMNNativeAdView = new UMNNativeAdView(activity);
            YFExpView yFExpView = new YFExpView(uMNNativeAdView, getAdType(), 0);
            this.viewList.add(yFExpView);
            this.nativeAdBean.setNativeEventListener(new INNativeExpressAdListener(yFExpView, this));
            if (this.setting != null) {
                this.setting.adapterRenderSuccess(this.sdkSupplier, this.viewList);
            }
            this.nativeAdBean.renderView(uMNNativeAdView, null);
            this.nativeAdBean.register(uMNNativeAdView, null);
            return;
        }
        YFLog.error(this.tag + " doShowTemplateAd--tempPtgNativeExpressAd is null");
        this.setting.adapterRenderFailed(this.sdkSupplier);
    }

    @Override // com.ubixnow.adtype.nativead.api.UMNNativeListener
    public void onLoaded(UMNNativeAdBean uMNNativeAdBean) {
        if (uMNNativeAdBean != null && this.nativeAd != null) {
            updData(uMNNativeAdBean);
            if (this.nativeAd.getEcpmInfo() != null) {
                setEcpmByStr(this.nativeAd.getEcpmInfo().getEcpm());
            }
            handleSucceed();
            return;
        }
        handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
    }

    private void updData(UMNNativeAdBean uMNNativeAdBean) {
        if (!isDevelop()) {
            this.nativeAdBean = uMNNativeAdBean;
            return;
        }
        this.developAds.clear();
        this.developAds.add(new INNativeAds(getContext(), this.nativeAd, uMNNativeAdBean, this));
    }

    @Override // com.ubixnow.adtype.nativead.api.UMNNativeListener
    public void onError(UMNError uMNError) {
        if (uMNError != null) {
            YFLog.warn(this.tag + "onError code = " + uMNError.getCode() + " msg = " + uMNError.getDesc());
            handleFailed(YFAdError.parseErr(uMNError.getCode()));
        } else {
            YFLog.warn(this.tag + "onError null");
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
        }
    }

    private static final class INNativeExpressAdListener extends NativeExpressCustomAdapter.ExpViewListener<INMixBannerAdapter> implements UMNNativeEventListener {
        private final ExpView expView;

        public INNativeExpressAdListener(ExpView expView, INMixBannerAdapter iNMixBannerAdapter) {
            super(iNMixBannerAdapter);
            this.expView = expView;
        }

        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
        public void onAdExposure() {
            YFLog.debug("INMixBannerAdapter template onAdShow");
            if (getAdapter() != null) {
                getAdapter().handleExposure(this.expView);
            }
        }

        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
        public void onAdClicked() {
            YFLog.debug("INMixBannerAdapter template onAdClick");
            if (getAdapter() != null) {
                getAdapter().handleClick(this.expView);
            }
        }

        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
        public void onAdClose() {
            YFLog.debug("INMixBannerAdapter template onAdClose");
            if (getAdapter() != null) {
                getAdapter().handleClose(this.expView);
            }
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        UMNNativeAd uMNNativeAd = new UMNNativeAd(context, new UMNNativeParams.Builder().setSlotId(getPotID()).setWidth(ScreenUtil.dip2px(context, this.setting.getViewWidth())).setHeight(0).setAdStyle(isDevelop() ? 1 : 2).build(), this);
        this.nativeAd = uMNNativeAd;
        uMNNativeAd.loadAd();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.IN.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        UMNNativeAd uMNNativeAd = this.nativeAd;
        return uMNNativeAd != null && uMNNativeAd.isValid();
    }

    private void release() {
        UMNNativeAd uMNNativeAd = this.nativeAd;
        if (uMNNativeAd != null) {
            uMNNativeAd.destroy();
            this.nativeAd = null;
        }
        UMNNativeAdBean uMNNativeAdBean = this.nativeAdBean;
        if (uMNNativeAdBean != null) {
            uMNNativeAdBean.destory();
            this.nativeAdBean = null;
        }
    }
}
