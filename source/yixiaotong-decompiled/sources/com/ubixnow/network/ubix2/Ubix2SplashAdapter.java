package com.ubixnow.network.ubix2;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.stub.StubApp;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.UBiXAdLossInfo;
import com.ubix.ssp.open.manager.UBiXAdManager;
import com.ubix.ssp.open.splash.UBiXSplashAdListener;
import com.ubix.ssp.open.splash.UBiXSplashManager;
import com.ubixnow.adtype.splash.api.UMNSplashParams;
import com.ubixnow.adtype.splash.custom.UMNCustomSplashAdapter;
import com.ubixnow.core.api.UbixDefaultConstants;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o000O00O;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.o0OO000o;
import com.ubixnow.ooooo.oO00000o;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class Ubix2SplashAdapter extends UMNCustomSplashAdapter {
    private final String OooO00o = this.customTag + getClass().getSimpleName();
    private Context OooO0O0;
    private UBiXSplashManager OooO0OO;

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o() {
        if (this.OooO0OO != null) {
            return;
        }
        showLog(this.OooO00o, "---loadAd " + this.adsSlotid);
        UBiXSplashManager uBiXSplashManagerCreateSpreadAd = UBiXAdManager.createSpreadAd();
        this.OooO0OO = uBiXSplashManagerCreateSpreadAd;
        uBiXSplashManagerCreateSpreadAd.loadSplashAd(this.OooO0O0, this.adsSlotid, new UBiXSplashAdListener() { // from class: com.ubixnow.network.ubix2.Ubix2SplashAdapter.3
            @Override // com.ubix.ssp.open.splash.UBiXSplashAdListener
            public void onAdClicked() {
                Ubix2SplashAdapter ubix2SplashAdapter = Ubix2SplashAdapter.this;
                ubix2SplashAdapter.showLog(ubix2SplashAdapter.OooO00o, "onAdClicked");
                if (Ubix2SplashAdapter.this.eventListener != null) {
                    Ubix2SplashAdapter.this.eventListener.onAdClick(Ubix2SplashAdapter.this.splashInfo);
                }
            }

            @Override // com.ubix.ssp.open.splash.UBiXSplashAdListener
            public void onAdClosed() {
                Ubix2SplashAdapter ubix2SplashAdapter = Ubix2SplashAdapter.this;
                ubix2SplashAdapter.showLog(ubix2SplashAdapter.OooO00o, "onAdClosed");
                if (Ubix2SplashAdapter.this.eventListener != null) {
                    Ubix2SplashAdapter ubix2SplashAdapter2 = Ubix2SplashAdapter.this;
                    ubix2SplashAdapter2.splashInfo.OooO00o = false;
                    ubix2SplashAdapter2.eventListener.onAdDismiss(Ubix2SplashAdapter.this.splashInfo);
                }
            }

            @Override // com.ubix.ssp.open.splash.UBiXSplashAdListener
            public void onAdExposeFailed(AdError adError) {
                Ubix2SplashAdapter ubix2SplashAdapter = Ubix2SplashAdapter.this;
                ubix2SplashAdapter.showLog(ubix2SplashAdapter.OooO00o, "onError: code:" + adError.getErrorCode() + " ,msg:" + adError.getErrorMessage());
                if (Ubix2SplashAdapter.this.eventListener != null) {
                    Ubix2SplashAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, "-1", "").setInfo((Object) Ubix2SplashAdapter.this.splashInfo));
                }
            }

            @Override // com.ubix.ssp.open.splash.UBiXSplashAdListener
            public void onAdExposed() {
                Ubix2SplashAdapter ubix2SplashAdapter = Ubix2SplashAdapter.this;
                ubix2SplashAdapter.showLog(ubix2SplashAdapter.OooO00o, "onAdExposed");
                if (Ubix2SplashAdapter.this.eventListener != null) {
                    Ubix2SplashAdapter ubix2SplashAdapter2 = Ubix2SplashAdapter.this;
                    ubix2SplashAdapter2.splashInfo.OooO00o = false;
                    ubix2SplashAdapter2.eventListener.onAdShow(Ubix2SplashAdapter.this.splashInfo);
                }
            }

            @Override // com.ubix.ssp.open.splash.UBiXSplashAdListener
            public void onAdLoadFailed(AdError adError) {
                Ubix2SplashAdapter ubix2SplashAdapter = Ubix2SplashAdapter.this;
                ubix2SplashAdapter.showLog(ubix2SplashAdapter.OooO00o, "onAdLoadFailed: code" + adError.getErrorCode() + " msg:" + adError.getErrorMessage());
                o00O00o0 o00o00o0 = Ubix2SplashAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, adError.getErrorCode() + "", adError.getErrorMessage()).setInfo((Object) Ubix2SplashAdapter.this.splashInfo));
                }
            }

            @Override // com.ubix.ssp.open.splash.UBiXSplashAdListener
            public void onAdLoadSucceed() {
                int price;
                o000O00O<UMNCustomSplashAdapter> o000o00o;
                try {
                    Ubix2SplashAdapter ubix2SplashAdapter = Ubix2SplashAdapter.this;
                    ubix2SplashAdapter.showLog(ubix2SplashAdapter.OooO00o, "----onAdLoadSucceed");
                    Ubix2SplashAdapter ubix2SplashAdapter2 = Ubix2SplashAdapter.this;
                    if (ubix2SplashAdapter2.loadListener != null) {
                        if (ubix2SplashAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            ubix2SplashAdapter2.showLog(ubix2SplashAdapter2.OooO00o, "price:" + Ubix2SplashAdapter.this.OooO0OO.getPrice());
                            Ubix2SplashAdapter ubix2SplashAdapter3 = Ubix2SplashAdapter.this;
                            o00O000 o00o000 = ubix2SplashAdapter3.mBaseAdConfig;
                            if (o00o000.OooO00o.OooOOo0 == 2) {
                                o000o00o = ubix2SplashAdapter3.splashInfo;
                                price = (int) o00o000.OooOOOo;
                            } else {
                                o000O00O<UMNCustomSplashAdapter> o000o00o2 = ubix2SplashAdapter3.splashInfo;
                                price = (int) ubix2SplashAdapter3.OooO0OO.getPrice();
                                o000o00o = o000o00o2;
                            }
                            o000o00o.setBiddingEcpm(price);
                        }
                        Ubix2SplashAdapter ubix2SplashAdapter4 = Ubix2SplashAdapter.this;
                        ubix2SplashAdapter4.splashInfo.material = UbixUtils.getMaterialInfo(ubix2SplashAdapter4.OooO0OO);
                        Ubix2SplashAdapter.this.splashInfo.getBaseAdConfig().OooOOo0 = UbixUtils.getPR(Ubix2SplashAdapter.this.OooO0OO);
                        Ubix2SplashAdapter ubix2SplashAdapter5 = Ubix2SplashAdapter.this;
                        ubix2SplashAdapter5.loadListener.onAdCacheSuccess(ubix2SplashAdapter5.splashInfo);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            @Override // com.ubix.ssp.open.splash.UBiXSplashAdListener
            public void onAdResponseSucceed() {
                Ubix2SplashAdapter ubix2SplashAdapter = Ubix2SplashAdapter.this;
                ubix2SplashAdapter.showLog(ubix2SplashAdapter.OooO00o, "onAdResponseSucceed");
                Ubix2SplashAdapter ubix2SplashAdapter2 = Ubix2SplashAdapter.this;
                if (ubix2SplashAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    ubix2SplashAdapter2.showLog(ubix2SplashAdapter2.OooO00o, "price:" + Ubix2SplashAdapter.this.OooO0OO.getPrice());
                    Ubix2SplashAdapter ubix2SplashAdapter3 = Ubix2SplashAdapter.this;
                    o00O000 o00o000 = ubix2SplashAdapter3.mBaseAdConfig;
                    if (o00o000.OooO00o.OooOOo0 == 2) {
                        ubix2SplashAdapter3.splashInfo.setBiddingEcpm((int) o00o000.OooOOOo);
                    } else {
                        ubix2SplashAdapter3.splashInfo.setBiddingEcpm((int) ubix2SplashAdapter3.OooO0OO.getPrice());
                    }
                }
                Ubix2SplashAdapter.this.onAdDataLoaded();
            }

            @Override // com.ubix.ssp.open.splash.UBiXSplashAdListener
            public void onAdSkipped() {
                Ubix2SplashAdapter ubix2SplashAdapter = Ubix2SplashAdapter.this;
                ubix2SplashAdapter.showLog(ubix2SplashAdapter.OooO00o, "onAdSkipped");
                if (Ubix2SplashAdapter.this.eventListener != null) {
                    Ubix2SplashAdapter ubix2SplashAdapter2 = Ubix2SplashAdapter.this;
                    ubix2SplashAdapter2.splashInfo.OooO00o = true;
                    ubix2SplashAdapter2.eventListener.onAdDismiss(Ubix2SplashAdapter.this.splashInfo);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(String str) {
        UBiXSplashManager uBiXSplashManager = this.OooO0OO;
        if (uBiXSplashManager != null) {
            uBiXSplashManager.loadBiddingAd(str);
        }
    }

    private void OooO0O0() {
        try {
            if (this.OooO0OO != null) {
                HashMap<String, String> map = new HashMap<>();
                map.put("sensor_disabled", oO00000o.o00O0O.OooOOOo ? "0" : "1");
                this.OooO0OO.setExtraInfo(map);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd() {
        int i;
        OooO00o();
        OooO0O0();
        BaseDevConfig baseDevConfig = this.mBaseAdConfig.OooO0o0;
        if ((baseDevConfig instanceof UMNSplashParams) && (i = ((UMNSplashParams) baseDevConfig).skipTime) >= UbixDefaultConstants.splashSkipTime) {
            this.OooO0OO.setSkipTime(i * 1000);
        }
        this.OooO0OO.loadAd();
    }

    @Override // com.ubixnow.ooooo.o00OO00O, com.ubixnow.ooooo.o00O
    public void destory() {
        UBiXSplashManager uBiXSplashManager = this.OooO0OO;
        if (uBiXSplashManager != null) {
            uBiXSplashManager.destroy();
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public void getServerBiddingToken(Context context, final o00O000 o00o000, Object... objArr) {
        this.OooO0O0 = context;
        createSplashInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            Ubix2InitManager.getInstance().initSDK(StubApp.getOrigApplicationContext(context.getApplicationContext()), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.ubix2.Ubix2SplashAdapter.2
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = Ubix2SplashAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        StringBuilder sb = new StringBuilder();
                        Ubix2InitManager.getInstance();
                        o00o00o0.getTokenFail(new ErrorInfo("500041", sb.append(Ubix2InitManager.getName()).append(oOO00O0.ubix_initError_msg).append(th.getMessage()).toString()));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    Ubix2SplashAdapter.this.OooO00o();
                    String biddingToken = Ubix2SplashAdapter.this.OooO0OO.getBiddingToken();
                    if (Ubix2SplashAdapter.this.loadListener != null) {
                        if (TextUtils.isEmpty(biddingToken)) {
                            Ubix2SplashAdapter.this.loadListener.getTokenFail(new ErrorInfo(o0OO000o.o00O0ooo, o0OO000o.o00O));
                            return;
                        }
                        o00o000.OooOOO = biddingToken;
                        Ubix2SplashAdapter ubix2SplashAdapter = Ubix2SplashAdapter.this;
                        ubix2SplashAdapter.loadListener.getTokenSucc(ubix2SplashAdapter.splashInfo);
                    }
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.getTokenFail(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, Ubix2InitManager.getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.splashInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        try {
            if (this.OooO0OO == null) {
                ooooO000.OooO0OO(this.OooO00o, "isValid false");
                return false;
            }
            if (ooooO000.OooO00o) {
                ooooO000.OooO0OO(this.OooO00o, "isValid " + this.OooO0OO.isValid());
            }
            return this.OooO0OO.isValid();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return true;
        }
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void loadSplashAd(Context context, final o00O000 o00o000) {
        this.OooO0O0 = StubApp.getOrigApplicationContext(context.getApplicationContext());
        createSplashInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            Ubix2InitManager.getInstance().initSDK(StubApp.getOrigApplicationContext(context.getApplicationContext()), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.ubix2.Ubix2SplashAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = Ubix2SplashAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        StringBuilder sb = new StringBuilder();
                        Ubix2InitManager.getInstance();
                        o00o00o0.onNoAdError(new ErrorInfo("500041", sb.append(Ubix2InitManager.getName()).append(oOO00O0.ubix_initError_msg).append(th.getMessage()).toString()).setInfo((Object) Ubix2SplashAdapter.this.splashInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    if (TextUtils.isEmpty(o00o000.OooOOOO)) {
                        Ubix2SplashAdapter.this.loadAd();
                    } else {
                        Ubix2SplashAdapter.this.OooO00o(o00o000.OooOOOO);
                    }
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            StringBuilder sb = new StringBuilder();
            Ubix2InitManager.getInstance();
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, sb.append(Ubix2InitManager.getName()).append(oOO00O0.ubix_appIdorPlaceIdNull_msg).toString()).setInfo((Object) this.splashInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            if (this.OooO0OO != null) {
                UBiXAdLossInfo failInfo = Ubix2BiddingUtils.getFailInfo(o00oo0oo);
                this.OooO0OO.lossNotice(failInfo);
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyLoss:" + failInfo.getInfo().toString());
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            UBiXSplashManager uBiXSplashManager = this.OooO0OO;
            if (uBiXSplashManager != null) {
                uBiXSplashManager.winNotice(Ubix2BiddingUtils.getSecondPrice(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyWin:" + Ubix2BiddingUtils.getSecondPrice(o00oo0oo));
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void show(ViewGroup viewGroup) {
        UBiXSplashManager uBiXSplashManager;
        showLog(this.OooO00o, "----show");
        if (viewGroup == null || (uBiXSplashManager = this.OooO0OO) == null) {
            return;
        }
        uBiXSplashManager.showAd(viewGroup);
    }
}
