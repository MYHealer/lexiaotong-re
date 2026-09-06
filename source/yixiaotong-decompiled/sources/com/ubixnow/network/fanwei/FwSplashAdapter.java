package com.ubixnow.network.fanwei;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.constant.br;
import com.ptg.adsdk.lib.PtgAdSdk;
import com.ptg.adsdk.lib.interf.PtgSplashAd;
import com.ptg.adsdk.lib.model.AdError;
import com.ptg.adsdk.lib.model.AdSlot;
import com.ptg.adsdk.lib.model.PtgAdLoadType;
import com.ptg.adsdk.lib.provider.PtgAdNative;
import com.stub.StubApp;
import com.ubixnow.adtype.splash.api.UMNSplashParams;
import com.ubixnow.adtype.splash.custom.UMNCustomSplashAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o000O0O0;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class FwSplashAdapter extends UMNCustomSplashAdapter {
    private final String OooO00o = this.customTag + FwInitManager.getInstance().getName();
    private PtgSplashAd OooO0O0;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd() {
        UMNSplashParams uMNSplashParams = (UMNSplashParams) this.mBaseAdConfig.OooO0o0;
        showLog(this.OooO00o, "start loadAd");
        PtgAdSdk.get().loadSplashAd(BaseUtils.getContext(), new AdSlot.Builder().setPtgSlotId(this.mBaseAdConfig.OooO00o.OooO0o0).setExpressViewAcceptedDpSize(uMNSplashParams.width, uMNSplashParams.height).setAdLoadType(PtgAdLoadType.PRELOAD).build(), new PtgAdNative.SplashAdListener() { // from class: com.ubixnow.network.fanwei.FwSplashAdapter.2
            public void onError(AdError adError) {
                FwSplashAdapter fwSplashAdapter = FwSplashAdapter.this;
                fwSplashAdapter.showLog(fwSplashAdapter.OooO00o, "onError: code:" + adError.getErrorCode() + " msg:" + adError.getMessage());
                o00O00o0 o00o00o0 = FwSplashAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, adError.getErrorCode() + "", adError.getMessage()).setInfo((Object) FwSplashAdapter.this.splashInfo));
                }
            }

            public void onSplashAdLoad(final PtgSplashAd ptgSplashAd) {
                FwSplashAdapter fwSplashAdapter = FwSplashAdapter.this;
                fwSplashAdapter.showLog(fwSplashAdapter.OooO00o, "-----onSplashAdLoad");
                FwSplashAdapter.this.OooO0O0 = ptgSplashAd;
                FwSplashAdapter.this.splashInfo.material = FwUtils.getMaterialInfo(ptgSplashAd.getAdvertData(), null);
                FwSplashAdapter fwSplashAdapter2 = FwSplashAdapter.this;
                if (fwSplashAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    try {
                        fwSplashAdapter2.splashInfo.setBiddingEcpm((int) ptgSplashAd.getEcpm());
                        FwSplashAdapter fwSplashAdapter3 = FwSplashAdapter.this;
                        fwSplashAdapter3.showLog(fwSplashAdapter3.OooO00o, "price:" + ptgSplashAd.getEcpm());
                    } catch (Exception e) {
                        ooooO000.OooO00o(e);
                    }
                }
                FwSplashAdapter fwSplashAdapter4 = FwSplashAdapter.this;
                o00O00o0 o00o00o0 = fwSplashAdapter4.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onAdDataLoaded(fwSplashAdapter4.splashInfo);
                }
                ptgSplashAd.setSplashInteractionListener(new PtgSplashAd.AdInteractionListener() { // from class: com.ubixnow.network.fanwei.FwSplashAdapter.2.1
                    public void onAdClicked() {
                        FwSplashAdapter fwSplashAdapter5 = FwSplashAdapter.this;
                        fwSplashAdapter5.showLog(fwSplashAdapter5.OooO00o, "onAdClicked");
                        if (FwSplashAdapter.this.eventListener != null) {
                            FwSplashAdapter.this.eventListener.onAdClick(FwSplashAdapter.this.splashInfo);
                        }
                    }

                    public void onAdShow() {
                        FwSplashAdapter fwSplashAdapter5 = FwSplashAdapter.this;
                        fwSplashAdapter5.showLog(fwSplashAdapter5.OooO00o, "onAdShow");
                        if (FwSplashAdapter.this.eventListener != null) {
                            FwSplashAdapter.this.eventListener.onAdShow(FwSplashAdapter.this.splashInfo);
                        }
                    }

                    public void onAdSkip() {
                        FwSplashAdapter fwSplashAdapter5 = FwSplashAdapter.this;
                        fwSplashAdapter5.showLog(fwSplashAdapter5.OooO00o, "onAdSkip");
                        if (FwSplashAdapter.this.eventListener != null) {
                            FwSplashAdapter fwSplashAdapter6 = FwSplashAdapter.this;
                            fwSplashAdapter6.splashInfo.OooO00o = true;
                            fwSplashAdapter6.eventListener.onAdDismiss(FwSplashAdapter.this.splashInfo);
                        }
                    }

                    public void onAdTimeOver() {
                        FwSplashAdapter fwSplashAdapter5 = FwSplashAdapter.this;
                        fwSplashAdapter5.showLog(fwSplashAdapter5.OooO00o, "onAdTimeOver");
                        if (FwSplashAdapter.this.eventListener != null) {
                            FwSplashAdapter fwSplashAdapter6 = FwSplashAdapter.this;
                            fwSplashAdapter6.splashInfo.OooO00o = false;
                            fwSplashAdapter6.eventListener.onAdDismiss(FwSplashAdapter.this.splashInfo);
                        }
                    }

                    public void onDismiss(int i) {
                        FwSplashAdapter fwSplashAdapter5 = FwSplashAdapter.this;
                        fwSplashAdapter5.showLog(fwSplashAdapter5.OooO00o, "onDismiss=" + i);
                    }

                    public void onRenderError(AdError adError) {
                        FwSplashAdapter fwSplashAdapter5 = FwSplashAdapter.this;
                        fwSplashAdapter5.showLog(fwSplashAdapter5.OooO00o, "onRenderError: code:" + adError.getErrorCode() + " msg:" + adError.getMessage());
                        if (FwSplashAdapter.this.eventListener != null) {
                            FwSplashAdapter fwSplashAdapter6 = FwSplashAdapter.this;
                            if (fwSplashAdapter6.adFlowStatus == 50) {
                                fwSplashAdapter6.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, adError.getErrorCode() + "", adError.getMessage()).setInfo((Object) FwSplashAdapter.this.splashInfo));
                            }
                        }
                    }

                    public void onRenderSuccess() {
                        FwSplashAdapter fwSplashAdapter5 = FwSplashAdapter.this;
                        fwSplashAdapter5.showLog(fwSplashAdapter5.OooO00o, "onRenderSuccess");
                        FwSplashAdapter fwSplashAdapter6 = FwSplashAdapter.this;
                        if (fwSplashAdapter6.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            try {
                                fwSplashAdapter6.splashInfo.setBiddingEcpm((int) ptgSplashAd.getEcpm());
                                FwSplashAdapter fwSplashAdapter7 = FwSplashAdapter.this;
                                fwSplashAdapter7.showLog(fwSplashAdapter7.OooO00o, "price:" + ptgSplashAd.getEcpm());
                            } catch (Exception e2) {
                                ooooO000.OooO00o(e2);
                            }
                        }
                        FwSplashAdapter fwSplashAdapter8 = FwSplashAdapter.this;
                        o00O00o0 o00o00o1 = fwSplashAdapter8.loadListener;
                        if (o00o00o1 != null) {
                            o00o00o1.onAdCacheSuccess(fwSplashAdapter8.splashInfo);
                        }
                    }
                });
                FwSplashAdapter.this.OooO0O0.preload();
            }

            public void onTimeout() {
                FwSplashAdapter fwSplashAdapter = FwSplashAdapter.this;
                fwSplashAdapter.showLog(fwSplashAdapter.OooO00o, "onTimeout: code");
                o00O00o0 o00o00o0 = FwSplashAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.ADS_RESPONSE_TIMEOUT;
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, oooO00o.OooO00o(), oooO00o.OooO0O0()).setInfo((Object) FwSplashAdapter.this.splashInfo));
                }
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00OO00O, com.ubixnow.ooooo.o00O
    public void destory() {
        showLog(this.OooO00o, "destroy");
        PtgSplashAd ptgSplashAd = this.OooO0O0;
        if (ptgSplashAd != null) {
            ptgSplashAd.destroy();
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        try {
            PtgSplashAd ptgSplashAd = this.OooO0O0;
            return ptgSplashAd != null && ptgSplashAd.isReady();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return super.isValid();
        }
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void loadSplashAd(Context context, o00O000 o00o000) {
        createSplashInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            FwInitManager.getInstance().initSDK(StubApp.getOrigApplicationContext(context.getApplicationContext()), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.fanwei.FwSplashAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = FwSplashAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", FwInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) FwSplashAdapter.this.splashInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    FwSplashAdapter.this.loadAd();
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, FwInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.splashInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            PtgSplashAd ptgSplashAd = this.OooO0O0;
            if (ptgSplashAd != null) {
                ptgSplashAd.notifyBidLoss(FwUtils.getFailInfo(o00oo0oo));
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

    @Override // com.ubixnow.ooooo.o00OO00O
    public void show(ViewGroup viewGroup) {
        showLog(this.OooO00o, "prepare show");
        this.adFlowStatus = 50;
        if (this.OooO0O0 != null && viewGroup != null) {
            showLog(this.OooO00o, br.b.V);
            this.OooO0O0.showAd(viewGroup);
            return;
        }
        showLog(this.OooO00o, "showError");
        o000O0O0 o000o0o0 = this.eventListener;
        if (o000o0o0 != null) {
            o000o0o0.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg).setInfo((Object) this.splashInfo));
        }
    }
}
