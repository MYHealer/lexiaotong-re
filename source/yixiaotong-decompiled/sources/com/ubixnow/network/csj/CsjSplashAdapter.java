package com.ubixnow.network.csj;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
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
public class CsjSplashAdapter extends UMNCustomSplashAdapter {
    private View OooO0O0;
    private int OooO0OO;
    private int OooO0Oo;
    private CSJSplashAd OooO0o;
    private final String OooO00o = this.customTag + getClass().getSimpleName();
    private boolean OooO0o0 = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(CSJSplashAd cSJSplashAd) {
        cSJSplashAd.setSplashAdListener(new CSJSplashAd.SplashAdListener() { // from class: com.ubixnow.network.csj.CsjSplashAdapter.3
            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdClick(CSJSplashAd cSJSplashAd2) {
                CsjSplashAdapter csjSplashAdapter = CsjSplashAdapter.this;
                csjSplashAdapter.showLog(csjSplashAdapter.OooO00o, "onSplashAdClick");
                if (CsjSplashAdapter.this.eventListener != null) {
                    CsjSplashAdapter.this.eventListener.onAdClick(CsjSplashAdapter.this.splashInfo);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdClose(CSJSplashAd cSJSplashAd2, int i) {
                CsjSplashAdapter csjSplashAdapter = CsjSplashAdapter.this;
                csjSplashAdapter.showLog(csjSplashAdapter.OooO00o, "onAdDismiss");
                if (CsjSplashAdapter.this.eventListener != null) {
                    CsjSplashAdapter.this.eventListener.onAdDismiss(CsjSplashAdapter.this.splashInfo);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdShow(CSJSplashAd cSJSplashAd2) {
                CsjSplashAdapter csjSplashAdapter = CsjSplashAdapter.this;
                csjSplashAdapter.showLog(csjSplashAdapter.OooO00o, "onADExposure");
                if (cSJSplashAd2 != null && cSJSplashAd2.getMediationManager() != null && cSJSplashAd2.getMediationManager().getShowEcpm() != null) {
                    CsjSplashAdapter csjSplashAdapter2 = CsjSplashAdapter.this;
                    csjSplashAdapter2.showLog(csjSplashAdapter2.OooO00o, "show price:" + cSJSplashAd2.getMediationManager().getShowEcpm().getEcpm());
                }
                if (CsjSplashAdapter.this.eventListener != null) {
                    CsjSplashAdapter.this.eventListener.onAdShow(CsjSplashAdapter.this.splashInfo);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context) {
        parseConfig();
        showLog(this.OooO00o, "width:" + this.OooO0OO + "height:" + this.OooO0Oo);
        TTAdSdk.getAdManager().createAdNative(context).loadSplashAd(new AdSlot.Builder().setCodeId(this.mBaseAdConfig.OooO00o.OooO0o0).setImageAcceptedSize(oO0000O.OooO00o(this.OooO0OO), oO0000O.OooO00o(this.OooO0Oo)).setExpressViewAcceptedSize(this.OooO0OO, this.OooO0Oo).build(), new TTAdNative.CSJSplashAdListener() { // from class: com.ubixnow.network.csj.CsjSplashAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadFail(CSJAdError cSJAdError) {
                CsjSplashAdapter csjSplashAdapter = CsjSplashAdapter.this;
                csjSplashAdapter.showLog(csjSplashAdapter.OooO00o, "onSplashLoadFail:code:" + cSJAdError.getCode() + "  msg:" + cSJAdError.getMsg());
                CsjSplashAdapter.this.onAdDataLoadFailed(cSJAdError.getCode() + "", cSJAdError.getMsg());
            }

            public void onSplashLoadSuccess() {
                CsjSplashAdapter csjSplashAdapter = CsjSplashAdapter.this;
                csjSplashAdapter.showLog(csjSplashAdapter.OooO00o, "onSplashLoadSuccess");
                CsjSplashAdapter.this.onAdDataLoaded();
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadSuccess(CSJSplashAd cSJSplashAd) {
                CsjSplashAdapter csjSplashAdapter = CsjSplashAdapter.this;
                csjSplashAdapter.showLog(csjSplashAdapter.OooO00o, "onSplashLoadSuccess1");
                CsjSplashAdapter csjSplashAdapter2 = CsjSplashAdapter.this;
                if (csjSplashAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    csjSplashAdapter2.splashInfo.csjPriceMethod = "1";
                    int integerValue = CsjSplashAdapter.this.getIntegerValue(cSJSplashAd.getMediationManager().getBestEcpm().getEcpm());
                    CsjSplashAdapter csjSplashAdapter3 = CsjSplashAdapter.this;
                    csjSplashAdapter3.showLog(csjSplashAdapter3.OooO00o, "price:" + integerValue);
                    if (integerValue <= 0) {
                        integerValue = (int) CsjUtils.getBestPriceInCacheNew(cSJSplashAd, CsjSplashAdapter.this.splashInfo);
                        CsjSplashAdapter csjSplashAdapter4 = CsjSplashAdapter.this;
                        csjSplashAdapter4.showLog(csjSplashAdapter4.OooO00o, "price1:" + integerValue);
                    }
                    CsjSplashAdapter.this.splashInfo.setBiddingEcpm(integerValue);
                }
                CsjSplashAdapter.this.onAdDataLoaded();
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
                CsjSplashAdapter csjSplashAdapter = CsjSplashAdapter.this;
                csjSplashAdapter.showLog(csjSplashAdapter.OooO00o, "onSplashRenderFail:code:" + cSJAdError.getCode() + "  msg:" + cSJAdError.getMsg());
                CsjSplashAdapter.this.onRenderFail(cSJAdError.getCode(), cSJAdError.getMsg());
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
                o00O00o0 o00o00o0;
                CsjSplashAdapter csjSplashAdapter = CsjSplashAdapter.this;
                csjSplashAdapter.showLog(csjSplashAdapter.OooO00o, "onSplashRenderSuccess");
                CsjSplashAdapter.this.OooO0o = cSJSplashAd;
                if (cSJSplashAd == null && (o00o00o0 = CsjSplashAdapter.this.loadListener) != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, oOO00O0.ubix_timeout, oOO00O0.ubix_timeout_msg).setInfo((Object) CsjSplashAdapter.this.splashInfo));
                    return;
                }
                try {
                    CsjSplashAdapter csjSplashAdapter2 = CsjSplashAdapter.this;
                    if (csjSplashAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                        csjSplashAdapter2.splashInfo.csjPriceMethod = "1";
                        int integerValue = CsjSplashAdapter.this.getIntegerValue(cSJSplashAd.getMediationManager().getBestEcpm().getEcpm());
                        CsjSplashAdapter csjSplashAdapter3 = CsjSplashAdapter.this;
                        csjSplashAdapter3.showLog(csjSplashAdapter3.OooO00o, "price:" + integerValue);
                        if (integerValue <= 0) {
                            integerValue = (int) CsjUtils.getBestPriceInCacheNew(cSJSplashAd, CsjSplashAdapter.this.splashInfo);
                            CsjSplashAdapter csjSplashAdapter4 = CsjSplashAdapter.this;
                            csjSplashAdapter4.showLog(csjSplashAdapter4.OooO00o, "price1:" + integerValue);
                        }
                        CsjSplashAdapter.this.splashInfo.setBiddingEcpm(integerValue);
                    }
                    CsjSplashAdapter csjSplashAdapter5 = CsjSplashAdapter.this;
                    o00O00o0 o00o00o1 = csjSplashAdapter5.loadListener;
                    if (o00o00o1 != null) {
                        o00o00o1.onAdCacheSuccess(csjSplashAdapter5.splashInfo);
                    }
                    CsjSplashAdapter.this.OooO00o(cSJSplashAd);
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

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        CSJSplashAd cSJSplashAd = this.OooO0o;
        if (cSJSplashAd == null || cSJSplashAd.getMediationManager() == null) {
            return false;
        }
        return this.OooO0o.getMediationManager().isReady();
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void loadSplashAd(final Context context, o00O000 o00o000) {
        createSplashInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            CsjInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.csj.CsjSplashAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    CsjSplashAdapter csjSplashAdapter = CsjSplashAdapter.this;
                    csjSplashAdapter.showLog(csjSplashAdapter.OooO00o, "init error：" + th.getMessage());
                    o00O00o0 o00o00o0 = CsjSplashAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", CsjInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) CsjSplashAdapter.this.splashInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    try {
                        CsjSplashAdapter csjSplashAdapter = CsjSplashAdapter.this;
                        csjSplashAdapter.OooO0o0 = oOO00O.OooO00o(csjSplashAdapter.mBaseAdConfig.OooO00o.OooOOO0);
                    } catch (Exception e) {
                        ooooO000.OooO00o(e);
                    }
                    CsjSplashAdapter csjSplashAdapter2 = CsjSplashAdapter.this;
                    csjSplashAdapter2.showLog(csjSplashAdapter2.OooO00o, "--------loadAd:isSplashPlus " + CsjSplashAdapter.this.OooO0o0 + PPSLabelView.Code + CsjSplashAdapter.this.adsSlotid);
                    CsjSplashAdapter.this.loadAd(context);
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, CsjInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.splashInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void show(ViewGroup viewGroup) {
        this.OooO0O0 = this.OooO0o.getSplashView();
        showLog(this.OooO00o, "---prepare show");
        View view = this.OooO0O0;
        if (view == null || viewGroup == null) {
            return;
        }
        viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
    }
}
