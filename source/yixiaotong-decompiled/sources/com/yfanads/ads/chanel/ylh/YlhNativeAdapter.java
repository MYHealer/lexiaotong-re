package com.yfanads.ads.chanel.ylh;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import com.yfanads.ads.chanel.ylh.model.YlhNativeAds;
import com.yfanads.ads.chanel.ylh.utils.YlhUtil;
import com.yfanads.android.core.render.YFNativeSetting;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.custom.NativeCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YlhNativeAdapter extends NativeCustomAdapter implements YFNativeCall {
    public YlhNativeAdapter(YFNativeSetting yFNativeSetting) {
        super(yFNativeSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.YLH.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        YlhUtil.initAD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ylh.YlhNativeAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                YlhNativeAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YlhNativeAdapter.this.handleFailed(str, str2);
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
        new NativeUnifiedAD(context, this.sdkSupplier.getPotId(), new NativeADUnifiedListener() { // from class: com.yfanads.ads.chanel.ylh.YlhNativeAdapter.2
            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                YlhNativeAdapter.this.handleFailed(adError.getErrorCode(), adError.getErrorMsg());
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0047 A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #0 {all -> 0x004f, blocks: (B:4:0x001e, B:6:0x0024, B:9:0x002c, B:10:0x0047), top: B:16:0x001e }] */
            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(List<NativeUnifiedADData> list) {
                YFLog.high(YlhNativeAdapter.this.tag + "onNativeAdLoad");
                if (list != null) {
                    try {
                        if (list.size() != 0 && list.get(0) != null) {
                            YlhNativeAdapter.this.setAdList(list);
                            YlhNativeAdapter.this.setEcpm(list.get(0).getECPM());
                            YlhNativeAdapter.this.handleSucceed();
                        } else {
                            YlhNativeAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                        }
                    } catch (Throwable th) {
                        YFLog.error("onADLoaded = " + th.getMessage());
                        YlhNativeAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                    }
                } else {
                    YlhNativeAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                }
            }
        }).loadData(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdList(List<NativeUnifiedADData> list) {
        Context context = getContext();
        for (int i = 0; i < list.size(); i++) {
            this.nativeAds.add(new YlhNativeAds(context, list.get(i), this, i));
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        if (YFListUtils.isEmpty(this.nativeAds) || i >= this.nativeAds.size()) {
            return "";
        }
        YFNativeAd yFNativeAd = this.nativeAds.get(i);
        return yFNativeAd instanceof YlhNativeAds ? ((YlhNativeAds) yFNativeAd).getAdReqId() : "";
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        if (YFListUtils.isEmpty(this.nativeAds)) {
            return;
        }
        for (YFNativeAd yFNativeAd : this.nativeAds) {
            if (yFNativeAd instanceof YlhNativeAds) {
                YlhNativeAds ylhNativeAds = (YlhNativeAds) yFNativeAd;
                ylhNativeAds.sendWinNotification(YlhUtil.getWindBiddingMap(ylhNativeAds.getECPM(), sdkSupplier != null ? (int) sdkSupplier.ecpm : 0));
            }
        }
        String shortString = "";
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult size=").append(this.nativeAds.size()).append(" current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append(" los=");
        if (UrlConst.isTestEnv() && sdkSupplier != null) {
            shortString = sdkSupplier.toShortString();
        }
        YFLog.high(sbAppend.append(shortString).toString());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (YFListUtils.isEmpty(this.nativeAds)) {
            return;
        }
        for (YFNativeAd yFNativeAd : this.nativeAds) {
            if (yFNativeAd instanceof YlhNativeAds) {
                YlhNativeAds ylhNativeAds = (YlhNativeAds) yFNativeAd;
                ylhNativeAds.sendLossNotification(YlhUtil.getWindBiddingMap(ylhNativeAds.getECPM(), sdkSupplier2 != null ? (int) sdkSupplier2.ecpm : 0));
            }
        }
        YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.custom.NativeCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
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
