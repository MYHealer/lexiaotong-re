package com.yfanads.ads.chanel.nal;

import android.app.Activity;
import android.content.Context;
import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.AdRequest;
import com.adprof.sdk.api.IBiddingNotify;
import com.adprof.sdk.api.NativeAd;
import com.adprof.sdk.api.NativeAdData;
import com.adprof.sdk.api.NativeAdLoadListener;
import com.yfanads.ads.chanel.nal.model.NalNativeAds;
import com.yfanads.ads.chanel.nal.utils.NalUtil;
import com.yfanads.android.core.render.YFNativeSetting;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.custom.NativeCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class NalNativeAdapter extends NativeCustomAdapter implements YFNativeCall, NativeAdLoadListener {
    private NativeAd nativeAd;

    @Override // com.adprof.sdk.api.NativeAdLoadListener
    public void onAdError(AdError adError) {
    }

    public NalNativeAdapter(YFNativeSetting yFNativeSetting) {
        super(yFNativeSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.NAL.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        NalUtil.initNal(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.nal.NalNativeAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                NalNativeAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                NalNativeAdapter.this.handleFailed(str, str2);
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

    private void loadAdByNative(Context context) {
        NativeAd nativeAd = new NativeAd(new AdRequest.Builder().setCodeId(getPotID()).setIsExpressAd(false).setWidth(ScreenUtil.getScreenWidth(context)).build(), this);
        this.nativeAd = nativeAd;
        nativeAd.loadAd();
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

    @Override // com.adprof.sdk.api.NativeAdLoadListener
    public void onAdLoad(List<NativeAdData> list) {
        if (this.nativeAd != null && !YFListUtils.isEmpty(list)) {
            Iterator<NativeAdData> it = list.iterator();
            while (it.hasNext()) {
                this.nativeAds.add(new NalNativeAds(getContext(), this.nativeAd, it.next(), this));
            }
            setEcpm(this.nativeAd.getBidPrice());
            handleSucceed();
            return;
        }
        handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
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

    @Override // com.yfanads.android.custom.NativeCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            nativeAd.destroyAd();
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
