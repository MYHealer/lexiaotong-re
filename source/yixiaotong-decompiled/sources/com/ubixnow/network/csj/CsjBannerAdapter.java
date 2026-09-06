package com.ubixnow.network.csj;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.huawei.openalliance.ad.constant.br;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.ubixnow.adtype.banner.api.UMNBannerParams;
import com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter;
import com.ubixnow.core.api.UMNAdConstant;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.oOO00000;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class CsjBannerAdapter extends UMNCustomBannerAdapter {
    private final String OooO00o = this.customTag + CsjInitManager.getInstance().getName();
    private WeakReference<Context> OooO0O0;
    private int OooO0OO;
    private int OooO0Oo;
    private View OooO0o;
    private TTNativeExpressAd OooO0o0;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd() {
        this.absUbixInfo.bannerAdapterHashCode = hashCode();
        parseConfig();
        showLog(this.OooO00o, "--------loadAd width: " + this.OooO0OO + PPSLabelView.Code + oOO00000.OooO0o(this.OooO0O0.get()));
        TTAdSdk.getAdManager().createAdNative(this.OooO0O0.get()).loadBannerExpressAd(new AdSlot.Builder().setCodeId(this.mBaseAdConfig.OooO00o.OooO0o0).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(this.OooO0OO, this.OooO0Oo).build(), new TTAdNative.NativeExpressAdListener() { // from class: com.ubixnow.network.csj.CsjBannerAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str) {
                CsjBannerAdapter csjBannerAdapter = CsjBannerAdapter.this;
                csjBannerAdapter.showLog(csjBannerAdapter.OooO00o, "onError code:" + i + " msg:" + str);
                o00O00o0 o00o00o0 = CsjBannerAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str).setInfo((Object) CsjBannerAdapter.this.absUbixInfo));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                CsjBannerAdapter csjBannerAdapter;
                String str;
                String str2;
                CsjBannerAdapter csjBannerAdapter2 = CsjBannerAdapter.this;
                csjBannerAdapter2.showLog(csjBannerAdapter2.OooO00o, "onNativeExpressAdLoad");
                if (list == null || list.isEmpty() || list.get(0) == null) {
                    o00O00o0 o00o00o0 = CsjBannerAdapter.this.loadListener;
                    if (o00o00o0 == null) {
                        return;
                    }
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg).setInfo((Object) CsjBannerAdapter.this.absUbixInfo));
                    csjBannerAdapter = CsjBannerAdapter.this;
                    str = csjBannerAdapter.OooO00o;
                    str2 = "onNoAdError";
                } else {
                    CsjBannerAdapter.this.OooO0o0 = list.get(0);
                    try {
                        CsjBannerAdapter csjBannerAdapter3 = CsjBannerAdapter.this;
                        if (csjBannerAdapter3.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            csjBannerAdapter3.absUbixInfo.csjPriceMethod = "1";
                            int integerValue = CsjBannerAdapter.this.getIntegerValue(list.get(0).getMediationManager().getBestEcpm().getEcpm());
                            CsjBannerAdapter csjBannerAdapter4 = CsjBannerAdapter.this;
                            csjBannerAdapter4.showLog(csjBannerAdapter4.OooO00o, "price:" + integerValue);
                            if (integerValue <= 0) {
                                integerValue = (int) CsjUtils.getBestPriceInCacheNew(CsjBannerAdapter.this.OooO0o0, CsjBannerAdapter.this.absUbixInfo);
                                CsjBannerAdapter csjBannerAdapter5 = CsjBannerAdapter.this;
                                csjBannerAdapter5.showLog(csjBannerAdapter5.OooO00o, "price1:" + integerValue);
                            }
                            CsjBannerAdapter.this.absUbixInfo.setBiddingEcpm(integerValue);
                        }
                    } catch (Exception e) {
                        ooooO000.OooO00o(e);
                    }
                    CsjBannerAdapter csjBannerAdapter6 = CsjBannerAdapter.this;
                    o00O00o0 o00o00o1 = csjBannerAdapter6.loadListener;
                    if (o00o00o1 != null) {
                        o00o00o1.onAdDataLoaded(csjBannerAdapter6.absUbixInfo);
                    }
                    CsjBannerAdapter.this.OooO0o0.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.ubixnow.network.csj.CsjBannerAdapter.2.1
                        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                        public void onAdClicked(View view, int i) {
                            CsjBannerAdapter csjBannerAdapter7 = CsjBannerAdapter.this;
                            csjBannerAdapter7.showLog(csjBannerAdapter7.OooO00o, IAdInterListener.AdCommandType.AD_CLICK);
                            if (CsjBannerAdapter.this.eventListener != null) {
                                CsjBannerAdapter.this.eventListener.onAdClick(CsjBannerAdapter.this.absUbixInfo);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                        public void onAdShow(View view, int i) {
                            CsjBannerAdapter csjBannerAdapter7 = CsjBannerAdapter.this;
                            csjBannerAdapter7.showLog(csjBannerAdapter7.OooO00o, "onAdShow");
                            if (CsjBannerAdapter.this.OooO0o0 != null && CsjBannerAdapter.this.OooO0o0.getMediationManager() != null && CsjBannerAdapter.this.OooO0o0.getMediationManager().getShowEcpm() != null) {
                                CsjBannerAdapter csjBannerAdapter8 = CsjBannerAdapter.this;
                                csjBannerAdapter8.showLog(csjBannerAdapter8.OooO00o, "show price:" + CsjBannerAdapter.this.OooO0o0.getMediationManager().getShowEcpm().getEcpm());
                            }
                            if (CsjBannerAdapter.this.eventListener != null) {
                                CsjBannerAdapter.this.eventListener.onAdShow(CsjBannerAdapter.this.absUbixInfo);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                        public void onRenderFail(View view, String str3, int i) {
                            CsjBannerAdapter csjBannerAdapter7 = CsjBannerAdapter.this;
                            csjBannerAdapter7.showLog(csjBannerAdapter7.OooO00o, "onRenderFail:聚合不支持:错误信息:" + str3);
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                        public void onRenderSuccess(View view, float f, float f2) {
                            CsjBannerAdapter csjBannerAdapter7 = CsjBannerAdapter.this;
                            csjBannerAdapter7.showLog(csjBannerAdapter7.OooO00o, "onRenderSuccess:聚合不支持");
                        }
                    });
                    CsjBannerAdapter csjBannerAdapter7 = CsjBannerAdapter.this;
                    o00O00o0 o00o00o2 = csjBannerAdapter7.loadListener;
                    if (o00o00o2 == null) {
                        return;
                    }
                    o00o00o2.onAdCacheSuccess(csjBannerAdapter7.absUbixInfo);
                    csjBannerAdapter = CsjBannerAdapter.this;
                    str = csjBannerAdapter.OooO00o;
                    str2 = "onAdCacheSuccess";
                }
                csjBannerAdapter.showLog(str, str2);
            }
        });
    }

    private void parseConfig() {
        BaseDevConfig baseDevConfig = this.mBaseAdConfig.OooO0o0;
        if (baseDevConfig instanceof UMNBannerParams) {
            UMNBannerParams uMNBannerParams = (UMNBannerParams) baseDevConfig;
            this.OooO0OO = uMNBannerParams.width;
            this.OooO0Oo = uMNBannerParams.height;
            Map<String, Object> map = uMNBannerParams.map;
            if (map != null) {
                try {
                    if (map.containsKey(UMNAdConstant.PangleConstant.PANGLE_WIDTH)) {
                        this.OooO0OO = Integer.parseInt(Objects.requireNonNull(uMNBannerParams.map.get(UMNAdConstant.PangleConstant.PANGLE_WIDTH)).toString());
                        this.OooO0Oo = Integer.parseInt(Objects.requireNonNull(uMNBannerParams.map.get(UMNAdConstant.PangleConstant.PANGLE_HEIGHT)).toString());
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        TTNativeExpressAd tTNativeExpressAd = this.OooO0o0;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    @Override // com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter
    public View getView() {
        return this.OooO0o;
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        TTNativeExpressAd tTNativeExpressAd = this.OooO0o0;
        if (tTNativeExpressAd == null || tTNativeExpressAd.getMediationManager() == null) {
            return false;
        }
        return this.OooO0o0.getMediationManager().isReady();
    }

    @Override // com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter
    public void loadBannerAd(Context context, o00O000 o00o000) {
        createADInfo(o00o000);
        this.OooO0O0 = new WeakReference<>(context);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            CsjInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.csj.CsjBannerAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = CsjBannerAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", th.getMessage()).setInfo((Object) CsjBannerAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    CsjBannerAdapter.this.loadAd();
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x0040  */
    @Override // com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter
    public void show(ViewGroup viewGroup) {
        Activity activity;
        Context context;
        TTNativeExpressAd tTNativeExpressAd;
        showLog(this.OooO00o, "prepare show");
        if (viewGroup == null || viewGroup.getContext() == null || !(viewGroup.getContext() instanceof Activity)) {
            WeakReference<Context> weakReference = this.OooO0O0;
            if (weakReference == null || weakReference.get() == null || !(this.OooO0O0.get() instanceof Activity)) {
                activity = null;
            } else {
                context = this.OooO0O0.get();
            }
            tTNativeExpressAd = this.OooO0o0;
            if (tTNativeExpressAd != null) {
                if (activity != null) {
                    tTNativeExpressAd.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.ubixnow.network.csj.CsjBannerAdapter.3
                        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                        public void onCancel() {
                            CsjBannerAdapter csjBannerAdapter = CsjBannerAdapter.this;
                            csjBannerAdapter.showLog(csjBannerAdapter.OooO00o, "onCancel");
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                        public void onSelected(int i, String str, boolean z) {
                            CsjBannerAdapter csjBannerAdapter = CsjBannerAdapter.this;
                            csjBannerAdapter.showLog(csjBannerAdapter.OooO00o, "onADClosed");
                            if (CsjBannerAdapter.this.eventListener != null) {
                                CsjBannerAdapter.this.eventListener.onAdDismiss(CsjBannerAdapter.this.absUbixInfo);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                        public void onShow() {
                            CsjBannerAdapter csjBannerAdapter = CsjBannerAdapter.this;
                            csjBannerAdapter.showLog(csjBannerAdapter.OooO00o, "onShow");
                        }
                    });
                }
                this.OooO0o = this.OooO0o0.getExpressAdView();
            }
            if (viewGroup != null || this.OooO0o == null) {
            }
            showLog(this.OooO00o, br.b.V);
            viewGroup.addView(this.OooO0o, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        context = viewGroup.getContext();
        activity = (Activity) context;
        tTNativeExpressAd = this.OooO0o0;
        if (tTNativeExpressAd != null) {
            if (activity != null) {
                tTNativeExpressAd.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.ubixnow.network.csj.CsjBannerAdapter.3
                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onCancel() {
                        CsjBannerAdapter csjBannerAdapter = CsjBannerAdapter.this;
                        csjBannerAdapter.showLog(csjBannerAdapter.OooO00o, "onCancel");
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onSelected(int i, String str, boolean z) {
                        CsjBannerAdapter csjBannerAdapter = CsjBannerAdapter.this;
                        csjBannerAdapter.showLog(csjBannerAdapter.OooO00o, "onADClosed");
                        if (CsjBannerAdapter.this.eventListener != null) {
                            CsjBannerAdapter.this.eventListener.onAdDismiss(CsjBannerAdapter.this.absUbixInfo);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onShow() {
                        CsjBannerAdapter csjBannerAdapter = CsjBannerAdapter.this;
                        csjBannerAdapter.showLog(csjBannerAdapter.OooO00o, "onShow");
                    }
                });
            }
            this.OooO0o = this.OooO0o0.getExpressAdView();
        }
        if (viewGroup != null) {
        }
    }
}
