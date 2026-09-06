package com.yfanads.ads.chanel.adx;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import com.yfanads.ads.chanel.adx.model.AdxNativeAds;
import com.yfanads.ads.chanel.adx.utils.AdxSdkUtil;
import com.yfanads.android.adx.AdxSDK;
import com.yfanads.android.adx.api.AdxScene;
import com.yfanads.android.adx.api.LoadManager;
import com.yfanads.android.adx.core.model.AdxNativeAd;
import com.yfanads.android.core.render.YFNativeSetting;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.core.render.impl.YFAbsNativeAd;
import com.yfanads.android.custom.NativeCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class AdxNativeAdapter extends NativeCustomAdapter implements YFNativeCall {
    public AdxNativeAdapter(YFNativeSetting yFNativeSetting) {
        super(yFNativeSetting);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdList(List<AdxNativeAd> list) {
        Iterator<AdxNativeAd> it = list.iterator();
        while (it.hasNext()) {
            this.nativeAds.add(new AdxNativeAds(it.next(), this.sdkSupplier.getTemplateConf(), this));
        }
    }

    @Override // com.yfanads.android.custom.NativeCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        List<YFNativeAd> list = this.nativeAds;
        if (list != null) {
            Iterator<YFNativeAd> it = list.iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
            this.nativeAds = null;
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        AdxSdkUtil.initAD(this.tag, context, getInitBean(), isListPackage(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.adx.AdxNativeAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                AdxNativeAdapter.this.handleFailed(str, str2);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                AdxNativeAdapter.this.startLoadAD(context);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.NativeCustomAdapter
    public void doShowAD(Activity activity) {
        YFLog.high(this.tag + " doShowAD ");
        YFNativeSetting yFNativeSetting = this.setting;
        if (yFNativeSetting != null) {
            yFNativeSetting.onAdSuccess(this.nativeAds);
        }
    }

    @Override // com.yfanads.android.custom.NativeCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return (YFListUtils.isEmpty(this.nativeAds) || !(this.nativeAds.get(0) instanceof AdxNativeAds)) ? super.getAdInfo() : InitUtils.getAdInfo((YFAbsNativeAd) this.nativeAds.get(0), getRequestId());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.ADX.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        if (YFListUtils.isEmpty(this.nativeAds)) {
            return;
        }
        for (YFNativeAd yFNativeAd : this.nativeAds) {
            if (yFNativeAd instanceof AdxNativeAds) {
                ((AdxNativeAds) yFNativeAd).reportAdInfo();
            }
        }
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult size=").append(this.nativeAds.size()).append(" current=");
        SdkSupplier sdkSupplier2 = this.sdkSupplier;
        String shortString = "";
        StringBuilder sbAppend2 = sbAppend.append(sdkSupplier2 != null ? sdkSupplier2.toShortString() : "").append(" loss=");
        if (UrlConst.isTestEnv() && sdkSupplier != null) {
            shortString = sdkSupplier.toShortString();
        }
        YFLog.high(sbAppend2.append(shortString).toString());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter, com.yfanads.android.core.render.api.YFNativeCall
    public void showFeedBackDialog(FragmentManager fragmentManager, String str) {
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        AdxSDK.getLoadManager().loadNativeAd(new AdxScene.Builder(AdxSdkUtil.getAdId(this.sdkSupplier)).setEcpm(getEcpm()).setReqId(getRequestId()).adStyle(2).build(), new LoadManager.NativeAdListener() { // from class: com.yfanads.ads.chanel.adx.AdxNativeAdapter.2
            @Override // com.yfanads.android.adx.api.LoadManager.NativeAdListener
            public void onError(int i, String str) {
                YFLog.high(AdxNativeAdapter.this.tag + " onError " + i + str);
                AdxNativeAdapter.this.handleFailed(i, str);
            }

            @Override // com.yfanads.android.adx.api.LoadManager.NativeAdListener
            public void onNativeAdLoad(List<AdxNativeAd> list) {
                YFLog.high(AdxNativeAdapter.this.tag + "onNativeAdLoad");
                try {
                    if (YFListUtils.isEmpty(list)) {
                        AdxNativeAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                        return;
                    }
                    AdxNativeAdapter.this.setEcpm(list.get(0).getECPM());
                    AdxNativeAdapter.this.setAdList(list);
                    AdxNativeAdapter.this.handleSucceed();
                } catch (Throwable th) {
                    th.printStackTrace();
                    AdxNativeAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                }
            }
        });
    }
}
