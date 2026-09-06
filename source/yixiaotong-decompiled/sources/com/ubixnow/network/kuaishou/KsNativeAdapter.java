package com.ubixnow.network.kuaishou;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAdapter;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.oO0O0OoO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class KsNativeAdapter extends UMNCustomNativeAdapter {
    private final String OooO00o = this.customTag + KsInitManager.getInstance().getName();
    public int OooO0O0 = 1;
    public WeakReference<Context> OooO0OO;

    public void loadAd() {
        BaseDevConfig baseDevConfig = this.mBaseAdConfig.OooO0o0;
        if (baseDevConfig instanceof UMNNativeParams) {
            UMNNativeParams uMNNativeParams = (UMNNativeParams) baseDevConfig;
            if (uMNNativeParams.adStyle == 1) {
                loadNative(uMNNativeParams);
            } else {
                loadExpress(uMNNativeParams);
            }
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public void loadCustomAd(Context context, o00O000 o00o000, Object... objArr) {
        createNativeInfo(o00o000);
        this.OooO0OO = new WeakReference<>(context);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0) && objArr != null) {
            KsInitManager.getInstance().initSDK(context, o00o000, new o00O0OO0() { // from class: com.ubixnow.network.kuaishou.KsNativeAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = KsNativeAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", KsInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) KsNativeAdapter.this.nativeInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    KsNativeAdapter.this.loadAd();
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, KsInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.nativeInfo));
        }
    }

    public void loadExpress(UMNNativeParams uMNNativeParams) {
        KsAdSDK.getLoadManager().loadConfigFeedAd(new KsScene.Builder(KsInitManager.getKSLongValue(this.mBaseAdConfig.OooO00o.OooO0o0)).width(uMNNativeParams.width).adNum(this.OooO0O0).build(), new KsLoadManager.FeedAdListener() { // from class: com.ubixnow.network.kuaishou.KsNativeAdapter.2
            @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
            public void onError(int i, String str) {
                KsNativeAdapter ksNativeAdapter = KsNativeAdapter.this;
                ksNativeAdapter.showLog(ksNativeAdapter.OooO00o, "express onError code:" + i + ",msg:" + str);
                o00O00o0 o00o00o0 = KsNativeAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str).setInfo((Object) KsNativeAdapter.this.nativeInfo));
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
            public void onFeedAdLoad(List<KsFeedAd> list) {
                KsNativeAdapter ksNativeAdapter = KsNativeAdapter.this;
                ksNativeAdapter.showLog(ksNativeAdapter.OooO00o, "onNativeAdLoad ");
                if (list == null || list.size() == 0) {
                    o00O00o0 o00o00o0 = KsNativeAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg).setInfo((Object) KsNativeAdapter.this.nativeInfo));
                        return;
                    }
                    return;
                }
                ArrayList arrayList = new ArrayList();
                KsNativeExpressAd ksNativeExpressAd = new KsNativeExpressAd(KsNativeAdapter.this.OooO0OO.get(), list.get(0), KsNativeAdapter.this.nativeInfo);
                KsNativeAdapter.this.customNativeAd = ksNativeExpressAd;
                arrayList.add(ksNativeExpressAd);
                if (KsNativeAdapter.this.nativeInfo.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                    KsNativeAdapter ksNativeAdapter2 = KsNativeAdapter.this;
                    ksNativeAdapter2.showLog(ksNativeAdapter2.OooO00o, "price:" + list.get(0).getECPM());
                    KsNativeAdapter.this.nativeInfo.setBiddingEcpm(list.get(0).getECPM());
                }
                KsNativeAdapter ksNativeAdapter3 = KsNativeAdapter.this;
                oo000o<UMNCustomNativeAdapter> oo000oVar = ksNativeAdapter3.nativeInfo;
                oo000oVar.OooO00o = arrayList;
                o00O00o0 o00o00o1 = ksNativeAdapter3.loadListener;
                if (o00o00o1 != null) {
                    o00o00o1.onAdCacheSuccess(oo000oVar);
                }
            }
        });
    }

    public void loadNative(UMNNativeParams uMNNativeParams) {
        Context context = this.OooO0OO.get();
        o00O000 o00o000 = this.mBaseAdConfig;
        oO0O0OoO oo0o0ooo = o00o000.OooO00o;
        KsNativeAd ksNativeAd = new KsNativeAd(context, oo0o0ooo.OooO0o0, "", o00o000.OooOOO0, oo0o0ooo);
        this.customNativeAd = ksNativeAd;
        ksNativeAd.loadAd("3", this.nativeInfo, this.loadListener);
    }
}
