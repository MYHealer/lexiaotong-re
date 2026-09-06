package com.yfanads.ads.chanel.jd;

import android.app.Activity;
import android.content.Context;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.nativead.JADNative;
import com.jd.ad.sdk.nativead.JADNativeLoadListener;
import com.yfanads.ads.chanel.jd.model.JDNativeAds;
import com.yfanads.ads.chanel.jd.utls.JDUtil;
import com.yfanads.android.core.render.YFNativeSetting;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.custom.NativeCustomAdapter;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class JDNativeAdapter extends NativeCustomAdapter implements YFNativeCall {
    JADNative jdNative;

    public JDNativeAdapter(YFNativeSetting yFNativeSetting) {
        super(yFNativeSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.JD.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        JDUtil.initJD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.jd.JDNativeAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                JDNativeAdapter.this.loadBannerAdByNative(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                JDNativeAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadBannerAdByNative(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
            return;
        }
        JADNative jADNative = new JADNative(new JADSlot.Builder().setSlotID(this.sdkSupplier.getPotId()).setImageSize(ScreenUtil.px2dip(getContext(), ScreenUtil.getScreenWidth(getContext())), 0.0f).setAdType(2).build());
        this.jdNative = jADNative;
        jADNative.loadAd(new JADNativeLoadListener() { // from class: com.yfanads.ads.chanel.jd.JDNativeAdapter.2
            @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
            public void onLoadSuccess() {
                YFLog.high(JDNativeAdapter.this.tag + "onNativeAdLoad");
                try {
                    List<JADMaterialData> dataList = JDNativeAdapter.this.jdNative.getDataList();
                    if (dataList != null && dataList.size() != 0 && dataList.get(0) != null) {
                        JDNativeAdapter.this.setAdList(dataList);
                        if (JDNativeAdapter.this.jdNative != null) {
                            JDNativeAdapter jDNativeAdapter = JDNativeAdapter.this;
                            jDNativeAdapter.setEcpm(jDNativeAdapter.jdNative.getJADExtra().getPrice());
                        }
                        JDNativeAdapter.this.handleSucceed();
                        return;
                    }
                    JDNativeAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                } catch (Throwable th) {
                    th.printStackTrace();
                    JDNativeAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                }
            }

            @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
            public void onLoadFailure(int i, String str) {
                JDNativeAdapter.this.handleFailed(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdList(List<JADMaterialData> list) {
        this.nativeAds.add(new JDNativeAds(getContext(), this.jdNative, list.get(0), this));
    }

    @Override // com.yfanads.android.custom.NativeCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        JADNative jADNative = this.jdNative;
        if (jADNative != null) {
            jADNative.destroy();
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
        super.handleClose();
    }
}
