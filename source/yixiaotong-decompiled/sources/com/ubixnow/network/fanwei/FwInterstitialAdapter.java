package com.ubixnow.network.fanwei;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ptg.adsdk.lib.PtgAdSdk;
import com.ptg.adsdk.lib.interf.PtgInteractionAd;
import com.ptg.adsdk.lib.model.AdError;
import com.ptg.adsdk.lib.model.AdSlot;
import com.ptg.adsdk.lib.provider.PtgAdNative;
import com.stub.StubApp;
import com.ubixnow.adtype.interstital.api.UMNInterstitalParams;
import com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.OooOo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class FwInterstitialAdapter extends UMNCustomInterstitalAdapter {
    private final String OooO00o = this.customTag + FwInitManager.getInstance().getName();
    private PtgInteractionAd OooO0O0;
    private o00O000 OooO0OO;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd() {
        PtgAdSdk.get().loadInteractionExpressAd(BaseUtils.getContext(), new AdSlot.Builder().setPtgSlotId(this.adsSlotid).build(), new PtgAdNative.InteractionExpressAdListener() { // from class: com.ubixnow.network.fanwei.FwInterstitialAdapter.2
            public void onError(AdError adError) {
                FwInterstitialAdapter fwInterstitialAdapter = FwInterstitialAdapter.this;
                fwInterstitialAdapter.showLog(fwInterstitialAdapter.OooO00o, "onError: code:" + adError.getErrorCode() + " msg:" + adError.getMessage());
                o00O00o0 o00o00o0 = FwInterstitialAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, adError.getErrorCode() + "", adError.getMessage()).setInfo((Object) FwInterstitialAdapter.this.absUbixInfo));
                }
            }

            public void onInteractionAdLoad(PtgInteractionAd ptgInteractionAd) {
                FwInterstitialAdapter fwInterstitialAdapter = FwInterstitialAdapter.this;
                fwInterstitialAdapter.showLog(fwInterstitialAdapter.OooO00o, "-----onInteractionAdLoad");
                FwInterstitialAdapter.this.OooO0O0 = ptgInteractionAd;
                FwInterstitialAdapter fwInterstitialAdapter2 = FwInterstitialAdapter.this;
                fwInterstitialAdapter2.absUbixInfo.material = FwUtils.getMaterialInfo(fwInterstitialAdapter2.OooO0O0.getAdvertData(), null);
                FwInterstitialAdapter fwInterstitialAdapter3 = FwInterstitialAdapter.this;
                if (fwInterstitialAdapter3.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    try {
                        fwInterstitialAdapter3.absUbixInfo.setBiddingEcpm((int) fwInterstitialAdapter3.OooO0O0.getEcpm());
                        FwInterstitialAdapter fwInterstitialAdapter4 = FwInterstitialAdapter.this;
                        fwInterstitialAdapter4.showLog(fwInterstitialAdapter4.OooO00o, "price:" + FwInterstitialAdapter.this.OooO0O0.getEcpm());
                    } catch (Exception e) {
                        ooooO000.OooO00o(e);
                    }
                }
                FwInterstitialAdapter.this.OooO0O0.setAdInteractionListener(new PtgInteractionAd.AdInteractionListener() { // from class: com.ubixnow.network.fanwei.FwInterstitialAdapter.2.1
                    public void onAdClicked() {
                        FwInterstitialAdapter fwInterstitialAdapter5 = FwInterstitialAdapter.this;
                        fwInterstitialAdapter5.showLog(fwInterstitialAdapter5.OooO00o, "-----onAdClicked");
                        if (FwInterstitialAdapter.this.eventListener != null) {
                            FwInterstitialAdapter.this.eventListener.onAdClick(FwInterstitialAdapter.this.absUbixInfo);
                        }
                        if ((FwInterstitialAdapter.this.OooO0OO.OooO0o0 instanceof UMNInterstitalParams) && ((UMNInterstitalParams) FwInterstitialAdapter.this.OooO0OO.OooO0o0).closeAfterClick) {
                            FwInterstitialAdapter.this.OooO0O0.closureInterstitialAd();
                        }
                    }

                    public void onAdDismiss() {
                        FwInterstitialAdapter fwInterstitialAdapter5 = FwInterstitialAdapter.this;
                        fwInterstitialAdapter5.showLog(fwInterstitialAdapter5.OooO00o, "--onAdDismiss: ");
                        if (FwInterstitialAdapter.this.eventListener != null) {
                            FwInterstitialAdapter.this.eventListener.onAdDismiss(FwInterstitialAdapter.this.absUbixInfo);
                        }
                    }

                    public void onAdShow() {
                        FwInterstitialAdapter fwInterstitialAdapter5 = FwInterstitialAdapter.this;
                        fwInterstitialAdapter5.showLog(fwInterstitialAdapter5.OooO00o, "--onAdShow: " + (FwInterstitialAdapter.this.eventListener != null));
                        if (FwInterstitialAdapter.this.eventListener != null) {
                            FwInterstitialAdapter.this.eventListener.onAdShow(FwInterstitialAdapter.this.absUbixInfo);
                        }
                    }

                    public void onRenderError(int i, String str) {
                        FwInterstitialAdapter fwInterstitialAdapter5 = FwInterstitialAdapter.this;
                        fwInterstitialAdapter5.showLog(fwInterstitialAdapter5.OooO00o, "onRenderError old: code" + i + " msg:" + str);
                        if (FwInterstitialAdapter.this.eventListener != null) {
                            FwInterstitialAdapter fwInterstitialAdapter6 = FwInterstitialAdapter.this;
                            if (fwInterstitialAdapter6.adFlowStatus == 50) {
                                fwInterstitialAdapter6.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, i + "", str).setInfo((Object) FwInterstitialAdapter.this.absUbixInfo));
                            }
                        }
                    }

                    public void onRenderError(AdError adError) {
                        FwInterstitialAdapter fwInterstitialAdapter5 = FwInterstitialAdapter.this;
                        fwInterstitialAdapter5.showLog(fwInterstitialAdapter5.OooO00o, "onRenderError new: code:" + adError.getErrorCode() + " msg:" + adError.getMessage());
                        if (FwInterstitialAdapter.this.eventListener != null) {
                            FwInterstitialAdapter fwInterstitialAdapter6 = FwInterstitialAdapter.this;
                            if (fwInterstitialAdapter6.adFlowStatus == 50) {
                                fwInterstitialAdapter6.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, adError.getErrorCode() + "", adError.getMessage()).setInfo((Object) FwInterstitialAdapter.this.absUbixInfo));
                            }
                        }
                    }
                });
                FwInterstitialAdapter fwInterstitialAdapter5 = FwInterstitialAdapter.this;
                o00O00o0 o00o00o0 = fwInterstitialAdapter5.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onAdCacheSuccess(fwInterstitialAdapter5.absUbixInfo);
                }
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        showLog(this.OooO00o, "destroy");
        PtgInteractionAd ptgInteractionAd = this.OooO0O0;
        if (ptgInteractionAd != null) {
            ptgInteractionAd.destroy();
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        try {
            PtgInteractionAd ptgInteractionAd = this.OooO0O0;
            return ptgInteractionAd != null && ptgInteractionAd.isReady();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return super.isValid();
        }
    }

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void loadInterstitalAd(Context context, o00O000 o00o000) {
        createADInfo(o00o000);
        this.OooO0OO = o00o000;
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(this.adsSlotid)) {
            FwInitManager.getInstance().initSDK(StubApp.getOrigApplicationContext(context.getApplicationContext()), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.fanwei.FwInterstitialAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = FwInterstitialAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", FwInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) FwInterstitialAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    FwInterstitialAdapter.this.loadAd();
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, FwInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            PtgInteractionAd ptgInteractionAd = this.OooO0O0;
            if (ptgInteractionAd != null) {
                ptgInteractionAd.notifyBidLoss(FwUtils.getFailInfo(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyLoss:" + FwUtils.getFailInfo(o00oo0oo).getReason());
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            if (this.OooO0O0 != null) {
                double[] succMap = FwUtils.getSuccMap(o00oo0oo);
                this.OooO0O0.notifyBidWin(succMap[0], succMap[1]);
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyWin: costPrice" + succMap[0] + " second price:" + succMap[1]);
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void show(Activity activity) {
        showLog(this.OooO00o, "show ");
        this.adFlowStatus = 50;
        if (this.OooO0O0 != null && activity != null && !activity.isFinishing()) {
            this.OooO0O0.showInteractionAd(activity);
            return;
        }
        showLog(this.OooO00o, "showError");
        OooOo oooOo = this.eventListener;
        if (oooOo != null) {
            oooOo.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg).setInfo((Object) this.absUbixInfo));
        }
    }
}
