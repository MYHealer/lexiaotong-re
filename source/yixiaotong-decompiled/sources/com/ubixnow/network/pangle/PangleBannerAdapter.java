package com.ubixnow.network.pangle;

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
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.constant.br;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.ubixnow.adtype.banner.api.UMNBannerParams;
import com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter;
import com.ubixnow.core.api.UMNAdConstant;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.OooOO0O;
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
public class PangleBannerAdapter extends UMNCustomBannerAdapter {
    private final String OooO00o = this.customTag + PangleInitManager.getInstance().getName();
    private WeakReference<Context> OooO0O0;
    private int OooO0OO;
    private int OooO0Oo;
    private View OooO0o;
    private TTNativeExpressAd OooO0o0;

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(OooOO0O oooOO0O, TTNativeExpressAd tTNativeExpressAd) {
        try {
            if (oooOO0O.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                Object obj = tTNativeExpressAd.getMediaExtraInfo().get(OapsKey.KEY_PRICE);
                int iIntValue = obj instanceof Number ? ((Number) obj).intValue() : 0;
                showLog(this.OooO00o, "price:" + iIntValue);
                oooOO0O.setBiddingEcpm(iIntValue);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd() {
        this.absUbixInfo.bannerAdapterHashCode = hashCode();
        parseConfig();
        showLog(this.OooO00o, "--------loadAd width: " + this.OooO0OO + PPSLabelView.Code + oOO00000.OooO0o(this.OooO0O0.get()));
        TTAdSdk.getAdManager().createAdNative(this.OooO0O0.get()).loadBannerExpressAd(new AdSlot.Builder().setCodeId(this.mBaseAdConfig.OooO00o.OooO0o0).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(this.OooO0OO, this.OooO0Oo).build(), new TTAdNative.NativeExpressAdListener() { // from class: com.ubixnow.network.pangle.PangleBannerAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str) {
                PangleBannerAdapter pangleBannerAdapter = PangleBannerAdapter.this;
                pangleBannerAdapter.showLog(pangleBannerAdapter.OooO00o, "onError code:" + i + " msg:" + str);
                o00O00o0 o00o00o0 = PangleBannerAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str).setInfo((Object) PangleBannerAdapter.this.absUbixInfo));
                }
            }

            /* JADX WARN: Code duplicated, block: B:15:0x0040 A[PHI: r1
  0x0040: PHI (r1v14 int) = (r1v12 int), (r1v13 int) binds: [B:14:0x003e, B:17:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                PangleBannerAdapter pangleBannerAdapter;
                String str;
                String str2;
                PangleBannerAdapter pangleBannerAdapter2 = PangleBannerAdapter.this;
                pangleBannerAdapter2.showLog(pangleBannerAdapter2.OooO00o, "onNativeExpressAdLoad");
                if (list == null || list.isEmpty() || list.get(0) == null) {
                    o00O00o0 o00o00o0 = PangleBannerAdapter.this.loadListener;
                    if (o00o00o0 == null) {
                        return;
                    }
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, "-1000 ", oOO00O0.ubix_no_ad_msg).setInfo((Object) PangleBannerAdapter.this.absUbixInfo));
                    pangleBannerAdapter = PangleBannerAdapter.this;
                    str = pangleBannerAdapter.OooO00o;
                    str2 = "onNoAdError";
                } else {
                    if (PangleBannerAdapter.this.OooO0o0 != null) {
                        PangleBannerAdapter.this.OooO0o0.destroy();
                    }
                    PangleBannerAdapter.this.OooO0o0 = list.get(0);
                    PangleBannerAdapter pangleBannerAdapter3 = PangleBannerAdapter.this;
                    int i = pangleBannerAdapter3.bannerRefreshTime;
                    if (i > 0) {
                        int i2 = 30;
                        if (i < 30) {
                            pangleBannerAdapter3.bannerRefreshTime = i2;
                        } else {
                            i2 = 120;
                            if (i > 120) {
                                pangleBannerAdapter3.bannerRefreshTime = i2;
                            }
                        }
                        pangleBannerAdapter3.OooO0o0.setSlideIntervalTime(PangleBannerAdapter.this.bannerRefreshTime * 1000);
                    }
                    PangleBannerAdapter pangleBannerAdapter4 = PangleBannerAdapter.this;
                    pangleBannerAdapter4.OooO00o(pangleBannerAdapter4.absUbixInfo, pangleBannerAdapter4.OooO0o0);
                    PangleBannerAdapter pangleBannerAdapter5 = PangleBannerAdapter.this;
                    o00O00o0 o00o00o1 = pangleBannerAdapter5.loadListener;
                    if (o00o00o1 != null) {
                        o00o00o1.onAdDataLoaded(pangleBannerAdapter5.absUbixInfo);
                    }
                    PangleBannerAdapter.this.OooO0o0.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.ubixnow.network.pangle.PangleBannerAdapter.2.1
                        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                        public void onAdClicked(View view, int i3) {
                            PangleBannerAdapter pangleBannerAdapter6 = PangleBannerAdapter.this;
                            pangleBannerAdapter6.showLog(pangleBannerAdapter6.OooO00o, IAdInterListener.AdCommandType.AD_CLICK);
                            if (PangleBannerAdapter.this.eventListener != null) {
                                PangleBannerAdapter.this.eventListener.onAdClick(PangleBannerAdapter.this.absUbixInfo);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                        public void onAdShow(View view, int i3) {
                            PangleBannerAdapter pangleBannerAdapter6 = PangleBannerAdapter.this;
                            pangleBannerAdapter6.showLog(pangleBannerAdapter6.OooO00o, "onAdShow");
                            if (PangleBannerAdapter.this.eventListener != null) {
                                PangleBannerAdapter.this.eventListener.onAdShow(PangleBannerAdapter.this.absUbixInfo);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                        public void onRenderFail(View view, String str3, int i3) {
                            PangleBannerAdapter pangleBannerAdapter6 = PangleBannerAdapter.this;
                            pangleBannerAdapter6.showLog(pangleBannerAdapter6.OooO00o, "onRenderFail:" + str3);
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                        public void onRenderSuccess(View view, float f, float f2) {
                            PangleBannerAdapter pangleBannerAdapter6 = PangleBannerAdapter.this;
                            pangleBannerAdapter6.showLog(pangleBannerAdapter6.OooO00o, "onRenderSuccess:");
                        }
                    });
                    PangleBannerAdapter pangleBannerAdapter6 = PangleBannerAdapter.this;
                    o00O00o0 o00o00o2 = pangleBannerAdapter6.loadListener;
                    if (o00o00o2 == null) {
                        return;
                    }
                    o00o00o2.onAdCacheSuccess(pangleBannerAdapter6.absUbixInfo);
                    pangleBannerAdapter = PangleBannerAdapter.this;
                    str = pangleBannerAdapter.OooO00o;
                    str2 = "onAdCacheSuccess";
                }
                pangleBannerAdapter.showLog(str, str2);
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
        WeakReference<Context> weakReference = this.OooO0O0;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    @Override // com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter
    public View getView() {
        return this.OooO0o;
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        return this.OooO0o0 != null;
    }

    @Override // com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter
    public void loadBannerAd(Context context, o00O000 o00o000) {
        createADInfo(o00o000);
        this.OooO0O0 = new WeakReference<>(context);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            PangleInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.pangle.PangleBannerAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = PangleBannerAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", th.getMessage()).setInfo((Object) PangleBannerAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    PangleBannerAdapter.this.loadAd();
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
                    tTNativeExpressAd.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.ubixnow.network.pangle.PangleBannerAdapter.3
                        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                        public void onCancel() {
                            PangleBannerAdapter pangleBannerAdapter = PangleBannerAdapter.this;
                            pangleBannerAdapter.showLog(pangleBannerAdapter.OooO00o, "onCancel");
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                        public void onSelected(int i, String str, boolean z) {
                            PangleBannerAdapter pangleBannerAdapter = PangleBannerAdapter.this;
                            pangleBannerAdapter.showLog(pangleBannerAdapter.OooO00o, "onADClosed");
                            if (PangleBannerAdapter.this.eventListener != null) {
                                PangleBannerAdapter.this.eventListener.onAdDismiss(PangleBannerAdapter.this.absUbixInfo);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                        public void onShow() {
                            PangleBannerAdapter pangleBannerAdapter = PangleBannerAdapter.this;
                            pangleBannerAdapter.showLog(pangleBannerAdapter.OooO00o, "onShow");
                        }
                    });
                }
                this.OooO0o = this.OooO0o0.getExpressAdView();
                this.OooO0o0.render();
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
                tTNativeExpressAd.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.ubixnow.network.pangle.PangleBannerAdapter.3
                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onCancel() {
                        PangleBannerAdapter pangleBannerAdapter = PangleBannerAdapter.this;
                        pangleBannerAdapter.showLog(pangleBannerAdapter.OooO00o, "onCancel");
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onSelected(int i, String str, boolean z) {
                        PangleBannerAdapter pangleBannerAdapter = PangleBannerAdapter.this;
                        pangleBannerAdapter.showLog(pangleBannerAdapter.OooO00o, "onADClosed");
                        if (PangleBannerAdapter.this.eventListener != null) {
                            PangleBannerAdapter.this.eventListener.onAdDismiss(PangleBannerAdapter.this.absUbixInfo);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onShow() {
                        PangleBannerAdapter pangleBannerAdapter = PangleBannerAdapter.this;
                        pangleBannerAdapter.showLog(pangleBannerAdapter.OooO00o, "onShow");
                    }
                });
            }
            this.OooO0o = this.OooO0o0.getExpressAdView();
            this.OooO0o0.render();
        }
        if (viewGroup != null) {
        }
    }
}
