package com.yfanads.ads.chanel.csj;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.cdo.oaps.ad.OapsKey;
import com.yfanads.ads.chanel.csj.model.CsjNativeAds;
import com.yfanads.ads.chanel.csj.utils.CsjUtil;
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
import com.yfanads.android.utils.YFUtil;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class CsjNativeAdapter extends NativeCustomAdapter implements YFNativeCall, TTAdNative.FeedAdListener {
    protected String ecpm;

    public CsjNativeAdapter(YFNativeSetting yFNativeSetting) {
        super(yFNativeSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.CSJ.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        CsjUtil.initCsj(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.csj.CsjNativeAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                CsjNativeAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                CsjNativeAdapter.this.handleFailed(str, str2);
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
        CsjUtil.getADManger().createAdNative(context).loadFeedAd(new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setSupportDeepLink(true).build(), this);
    }

    private void setAdList(List<TTFeedAd> list) {
        Context context = getContext();
        for (int i = 0; i < list.size(); i++) {
            this.nativeAds.add(new CsjNativeAds(context, list.get(i), this, i));
        }
    }

    @Override // com.yfanads.android.custom.NativeCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
    }

    @Override // com.yfanads.android.custom.NativeCustomAdapter
    public void doShowAD(Activity activity) {
        YFLog.high(this.tag + " doShowAD ");
        setPrice();
        if (this.setting != null) {
            this.setting.onAdSuccess(this.nativeAds);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        if (YFListUtils.isEmpty(this.nativeAds) || i >= this.nativeAds.size()) {
            return "";
        }
        YFNativeAd yFNativeAd = this.nativeAds.get(i);
        return yFNativeAd instanceof CsjNativeAds ? ((CsjNativeAds) yFNativeAd).getAdReqId() : "";
    }

    private void setPrice() {
        try {
            if (!isBidding() || YFListUtils.isEmpty(this.nativeAds)) {
                return;
            }
            for (YFNativeAd yFNativeAd : this.nativeAds) {
                if (yFNativeAd instanceof CsjNativeAds) {
                    ((CsjNativeAds) yFNativeAd).setPrice(YFUtil.toDouble(this.ecpm, 1.0d));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onError(int i, String str) {
        handleFailed(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
    public void onFeedAdLoad(List<TTFeedAd> list) {
        YFLog.high(this.tag + "onNativeAdLoad");
        if (list != null) {
            try {
                if (!list.isEmpty() && list.get(0) != null) {
                    setAdList(list);
                    if (isBidding()) {
                        updPrice(list.get(0));
                        setEcpmByStr(this.ecpm);
                    }
                    handleSucceed();
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                return;
            }
        }
        handleFailed(YFAdError.ERROR_DATA_NULL, "");
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter, com.yfanads.android.core.render.api.YFNativeCall
    public void handleClose() {
        super.handleClose();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isBidding() {
        return this.sdkSupplier != null && this.sdkSupplier.isBidding() && CsjUtil.isSupportBidding;
    }

    protected void updPrice(TTFeedAd tTFeedAd) {
        try {
            Object obj = tTFeedAd.getMediaExtraInfo().get(OapsKey.KEY_PRICE);
            if (obj == null) {
                obj = "1";
            }
            this.ecpm = String.valueOf(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        if (YFListUtils.isEmpty(this.nativeAds)) {
            return;
        }
        for (YFNativeAd yFNativeAd : this.nativeAds) {
            if (yFNativeAd instanceof CsjNativeAds) {
                ((CsjNativeAds) yFNativeAd).win(sdkSupplier != null ? sdkSupplier.ecpm : YFUtil.toDouble(this.ecpm, 1.0d));
            }
        }
        String shortString = "";
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult size=").append(this.nativeAds.size()).append(" current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
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
            if (yFNativeAd instanceof CsjNativeAds) {
                ((CsjNativeAds) yFNativeAd).loss(sdkSupplier.ecpm, "102", CsjUtil.getAdnName(sdkSupplier.getAdnId()));
            }
        }
        YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }
}
