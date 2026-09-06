package com.yfanads.ads.chanel.in;

import android.app.Activity;
import android.content.Context;
import com.ubixnow.adtype.nativead.api.UMNNativeAd;
import com.ubixnow.adtype.nativead.api.UMNNativeAdBean;
import com.ubixnow.adtype.nativead.api.UMNNativeListener;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.core.api.UMNError;
import com.yfanads.ads.chanel.in.model.INNativeAds;
import com.yfanads.ads.chanel.in.utils.INUtil;
import com.yfanads.android.core.render.YFNativeSetting;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.custom.NativeCustomAdapter;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class INNativeAdapter extends NativeCustomAdapter implements YFNativeCall {
    private UMNNativeAd nativeAd;

    public INNativeAdapter(YFNativeSetting yFNativeSetting) {
        super(yFNativeSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.IN.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        INUtil.initIN(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.in.INNativeAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                INNativeAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                INNativeAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else {
            loadAdByNative(context);
        }
    }

    private void loadAdByNative(final Context context) {
        UMNNativeAd uMNNativeAd = new UMNNativeAd(context, new UMNNativeParams.Builder().setSlotId(getPotID()).setWidth(ScreenUtil.getScreenWidth(context)).setHeight(0).setAdStyle(1).build(), new UMNNativeListener() { // from class: com.yfanads.ads.chanel.in.INNativeAdapter.2
            @Override // com.ubixnow.adtype.nativead.api.UMNNativeListener
            public void onLoaded(UMNNativeAdBean uMNNativeAdBean) {
                if (uMNNativeAdBean != null) {
                    INNativeAdapter.this.nativeAds.add(new INNativeAds(context, INNativeAdapter.this.nativeAd, uMNNativeAdBean, INNativeAdapter.this));
                    if (INNativeAdapter.this.nativeAd.getEcpmInfo() != null) {
                        INNativeAdapter iNNativeAdapter = INNativeAdapter.this;
                        iNNativeAdapter.setEcpmByStr(iNNativeAdapter.nativeAd.getEcpmInfo().getEcpm());
                    }
                    INNativeAdapter.this.handleSucceed();
                    return;
                }
                YFLog.debug(INNativeAdapter.this.tag + " onNativeExpressAdLoad null");
                INNativeAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeListener
            public void onError(UMNError uMNError) {
                YFLog.debug(INNativeAdapter.this.tag + " onError " + uMNError.getDesc());
                INNativeAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, uMNError.getDesc());
            }
        });
        this.nativeAd = uMNNativeAd;
        uMNNativeAd.loadAd();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        UMNNativeAd uMNNativeAd = this.nativeAd;
        return uMNNativeAd != null ? uMNNativeAd.getRequestId() : "";
    }

    @Override // com.yfanads.android.custom.NativeCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        UMNNativeAd uMNNativeAd = this.nativeAd;
        if (uMNNativeAd != null) {
            uMNNativeAd.destroy();
            this.nativeAd = null;
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
