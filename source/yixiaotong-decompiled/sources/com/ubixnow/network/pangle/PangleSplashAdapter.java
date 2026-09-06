package com.ubixnow.network.pangle;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.ubixnow.adtype.splash.api.UMNSplashParams;
import com.ubixnow.adtype.splash.custom.UMNCustomSplashAdapter;
import com.ubixnow.core.api.UMNAdConstant;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.oO0000O;
import com.ubixnow.ooooo.oOO00O;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class PangleSplashAdapter extends UMNCustomSplashAdapter {
    private View OooO0O0;
    private int OooO0OO;
    private int OooO0Oo;
    private CSJSplashAd OooO0o;
    private final String OooO00o = this.customTag + getClass().getSimpleName();
    private boolean OooO0o0 = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(CSJSplashAd cSJSplashAd) {
        try {
            if (this.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                Object obj = cSJSplashAd.getMediaExtraInfo().get(OapsKey.KEY_PRICE);
                int iIntValue = obj instanceof Number ? ((Number) obj).intValue() : 0;
                showLog(this.OooO00o, "price:" + iIntValue);
                this.splashInfo.setBiddingEcpm(iIntValue);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO0O0(CSJSplashAd cSJSplashAd) {
        cSJSplashAd.setSplashAdListener(new CSJSplashAd.SplashAdListener() { // from class: com.ubixnow.network.pangle.PangleSplashAdapter.3
            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdClick(CSJSplashAd cSJSplashAd2) {
                PangleSplashAdapter pangleSplashAdapter = PangleSplashAdapter.this;
                pangleSplashAdapter.showLog(pangleSplashAdapter.OooO00o, "onSplashAdClick");
                if (PangleSplashAdapter.this.eventListener != null) {
                    PangleSplashAdapter.this.eventListener.onAdClick(PangleSplashAdapter.this.splashInfo);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdClose(CSJSplashAd cSJSplashAd2, int i) {
                PangleSplashAdapter pangleSplashAdapter = PangleSplashAdapter.this;
                pangleSplashAdapter.showLog(pangleSplashAdapter.OooO00o, "onAdDismiss");
                if (PangleSplashAdapter.this.eventListener != null) {
                    PangleSplashAdapter.this.eventListener.onAdDismiss(PangleSplashAdapter.this.splashInfo);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdShow(CSJSplashAd cSJSplashAd2) {
                PangleSplashAdapter pangleSplashAdapter = PangleSplashAdapter.this;
                pangleSplashAdapter.showLog(pangleSplashAdapter.OooO00o, "onADExposure");
                if (PangleSplashAdapter.this.eventListener != null) {
                    PangleSplashAdapter.this.eventListener.onAdShow(PangleSplashAdapter.this.splashInfo);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context) {
        parseConfig();
        showLog(this.OooO00o, "width:" + this.OooO0OO + "height:" + this.OooO0Oo);
        TTAdSdk.getAdManager().createAdNative(context).loadSplashAd(new AdSlot.Builder().setCodeId(this.mBaseAdConfig.OooO00o.OooO0o0).setImageAcceptedSize(oO0000O.OooO00o(this.OooO0OO), oO0000O.OooO00o(this.OooO0Oo)).setExpressViewAcceptedSize(this.OooO0OO, this.OooO0Oo).build(), new TTAdNative.CSJSplashAdListener() { // from class: com.ubixnow.network.pangle.PangleSplashAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadFail(CSJAdError cSJAdError) {
                PangleSplashAdapter pangleSplashAdapter = PangleSplashAdapter.this;
                pangleSplashAdapter.showLog(pangleSplashAdapter.OooO00o, "onSplashLoadFail:code:" + cSJAdError.getCode() + "  msg:" + cSJAdError.getMsg());
                PangleSplashAdapter.this.onAdDataLoadFailed(cSJAdError.getCode() + "", cSJAdError.getMsg());
            }

            public void onSplashLoadSuccess() {
                PangleSplashAdapter pangleSplashAdapter = PangleSplashAdapter.this;
                pangleSplashAdapter.showLog(pangleSplashAdapter.OooO00o, "onSplashLoadSuccess");
                PangleSplashAdapter.this.onAdDataLoaded();
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadSuccess(CSJSplashAd cSJSplashAd) {
                PangleSplashAdapter pangleSplashAdapter = PangleSplashAdapter.this;
                pangleSplashAdapter.showLog(pangleSplashAdapter.OooO00o, "onSplashLoadSuccess1");
                PangleSplashAdapter.this.OooO00o(cSJSplashAd);
                PangleSplashAdapter.this.onAdDataLoaded();
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
                PangleSplashAdapter pangleSplashAdapter = PangleSplashAdapter.this;
                pangleSplashAdapter.showLog(pangleSplashAdapter.OooO00o, "onSplashRenderFail:code:" + cSJAdError.getCode() + "  msg:" + cSJAdError.getMsg());
                PangleSplashAdapter.this.onRenderFail(cSJAdError.getCode(), cSJAdError.getMsg());
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
                PangleSplashAdapter pangleSplashAdapter = PangleSplashAdapter.this;
                pangleSplashAdapter.showLog(pangleSplashAdapter.OooO00o, "onSplashRenderSuccess");
                PangleSplashAdapter.this.OooO0o = cSJSplashAd;
                PangleSplashAdapter pangleSplashAdapter2 = PangleSplashAdapter.this;
                pangleSplashAdapter2.OooO00o(pangleSplashAdapter2.OooO0o);
                try {
                    PangleSplashAdapter pangleSplashAdapter3 = PangleSplashAdapter.this;
                    pangleSplashAdapter3.OooO0O0 = pangleSplashAdapter3.OooO0o.getSplashView();
                    PangleSplashAdapter pangleSplashAdapter4 = PangleSplashAdapter.this;
                    o00O00o0 o00o00o0 = pangleSplashAdapter4.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onAdCacheSuccess(pangleSplashAdapter4.splashInfo);
                    }
                    PangleSplashAdapter pangleSplashAdapter5 = PangleSplashAdapter.this;
                    pangleSplashAdapter5.OooO0O0(pangleSplashAdapter5.OooO0o);
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }
        }, 5000);
    }

    private void parseConfig() {
        BaseDevConfig baseDevConfig = this.mBaseAdConfig.OooO0o0;
        if (baseDevConfig instanceof UMNSplashParams) {
            UMNSplashParams uMNSplashParams = (UMNSplashParams) baseDevConfig;
            this.OooO0OO = uMNSplashParams.width;
            this.OooO0Oo = uMNSplashParams.height;
            Map<String, Object> map = uMNSplashParams.map;
            if (map != null) {
                try {
                    if (map.containsKey(UMNAdConstant.PangleConstant.PANGLE_WIDTH)) {
                        this.OooO0OO = Integer.parseInt(uMNSplashParams.map.get(UMNAdConstant.PangleConstant.PANGLE_WIDTH).toString());
                        this.OooO0Oo = Integer.parseInt(uMNSplashParams.map.get(UMNAdConstant.PangleConstant.PANGLE_HEIGHT).toString());
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }
        }
    }

    @Override // com.ubixnow.ooooo.o00OO00O, com.ubixnow.ooooo.o00O
    public void destory() {
        try {
            CSJSplashAd cSJSplashAd = this.OooO0o;
            if (cSJSplashAd == null || cSJSplashAd.getMediationManager() == null) {
                return;
            }
            this.OooO0o.getMediationManager().destroy();
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void loadSplashAd(final Context context, o00O000 o00o000) {
        createSplashInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            PangleInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.pangle.PangleSplashAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    PangleSplashAdapter pangleSplashAdapter = PangleSplashAdapter.this;
                    pangleSplashAdapter.showLog(pangleSplashAdapter.OooO00o, "init error：" + th.getMessage());
                    o00O00o0 o00o00o0 = PangleSplashAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", PangleInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) PangleSplashAdapter.this.splashInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    try {
                        PangleSplashAdapter pangleSplashAdapter = PangleSplashAdapter.this;
                        pangleSplashAdapter.OooO0o0 = oOO00O.OooO00o(pangleSplashAdapter.mBaseAdConfig.OooO00o.OooOOO0);
                    } catch (Exception e) {
                        ooooO000.OooO00o(e);
                    }
                    PangleSplashAdapter pangleSplashAdapter2 = PangleSplashAdapter.this;
                    pangleSplashAdapter2.showLog(pangleSplashAdapter2.OooO00o, "--------loadAd:isSplashPlus " + PangleSplashAdapter.this.OooO0o0 + PPSLabelView.Code + PangleSplashAdapter.this.adsSlotid);
                    PangleSplashAdapter.this.loadAd(context);
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, PangleInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.splashInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void show(ViewGroup viewGroup) {
        showLog(this.OooO00o, "---prepare show");
        View view = this.OooO0O0;
        if (view == null || viewGroup == null) {
            return;
        }
        viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
    }
}
