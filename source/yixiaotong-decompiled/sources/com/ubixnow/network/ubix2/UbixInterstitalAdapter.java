package com.ubixnow.network.ubix2;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.UBiXAdLossInfo;
import com.ubix.ssp.open.interstitial.UBiXInterstitialAdListener;
import com.ubix.ssp.open.interstitial.UBiXInterstitialManager;
import com.ubix.ssp.open.manager.UBiXAdManager;
import com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oO00000o;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UbixInterstitalAdapter extends UMNCustomInterstitalAdapter {
    private final String OooO00o = this.customTag + getClass().getSimpleName();
    private UBiXInterstitialManager OooO0O0;

    private void OooO00o() {
        try {
            if (this.OooO0O0 != null) {
                HashMap<String, String> map = new HashMap<>();
                map.put("sensor_disabled", oO00000o.o00O0O.OooOOOo ? "0" : "1");
                this.OooO0O0.setExtraInfo(map);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd() {
        showLog(this.OooO00o, "SlotId:" + this.adsSlotid);
        UBiXInterstitialManager uBiXInterstitialManagerCreateInterstitialAd = UBiXAdManager.createInterstitialAd();
        this.OooO0O0 = uBiXInterstitialManagerCreateInterstitialAd;
        uBiXInterstitialManagerCreateInterstitialAd.loadInterstitialAd(this.mContext, this.adsSlotid, new UBiXInterstitialAdListener() { // from class: com.ubixnow.network.ubix2.UbixInterstitalAdapter.2
            @Override // com.ubix.ssp.open.interstitial.UBiXInterstitialAdListener
            public void onAdClicked() {
                UbixInterstitalAdapter ubixInterstitalAdapter = UbixInterstitalAdapter.this;
                ubixInterstitalAdapter.showLog(ubixInterstitalAdapter.OooO00o, "onAdClicked");
                if (UbixInterstitalAdapter.this.eventListener != null) {
                    UbixInterstitalAdapter.this.eventListener.onAdClick(UbixInterstitalAdapter.this.absUbixInfo);
                }
            }

            @Override // com.ubix.ssp.open.interstitial.UBiXInterstitialAdListener
            public void onAdClosed() {
                UbixInterstitalAdapter ubixInterstitalAdapter = UbixInterstitalAdapter.this;
                ubixInterstitalAdapter.showLog(ubixInterstitalAdapter.OooO00o, "onAdClosed");
                if (UbixInterstitalAdapter.this.eventListener != null) {
                    UbixInterstitalAdapter.this.eventListener.onAdDismiss(UbixInterstitalAdapter.this.absUbixInfo);
                }
            }

            @Override // com.ubix.ssp.open.interstitial.UBiXInterstitialAdListener
            public void onAdExposeFailed(AdError adError) {
                UbixInterstitalAdapter ubixInterstitalAdapter = UbixInterstitalAdapter.this;
                ubixInterstitalAdapter.showLog(ubixInterstitalAdapter.OooO00o, "onAdExposeFailed: ");
                if (UbixInterstitalAdapter.this.eventListener == null || adError == null) {
                    return;
                }
                UbixInterstitalAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, adError.getErrorCode() + "", adError.getErrorMessage()).setInfo((Object) UbixInterstitalAdapter.this.absUbixInfo));
            }

            @Override // com.ubix.ssp.open.interstitial.UBiXInterstitialAdListener
            public void onAdExposed() {
                UbixInterstitalAdapter ubixInterstitalAdapter = UbixInterstitalAdapter.this;
                ubixInterstitalAdapter.showLog(ubixInterstitalAdapter.OooO00o, "onAdExposed");
                if (UbixInterstitalAdapter.this.eventListener != null) {
                    UbixInterstitalAdapter.this.eventListener.onAdShow(UbixInterstitalAdapter.this.absUbixInfo);
                }
            }

            @Override // com.ubix.ssp.open.interstitial.UBiXInterstitialAdListener
            public void onAdLoadFailed(AdError adError) {
                UbixInterstitalAdapter ubixInterstitalAdapter = UbixInterstitalAdapter.this;
                ubixInterstitalAdapter.showLog(ubixInterstitalAdapter.OooO00o, "onAdLoadFailed: code" + adError.getErrorCode() + " msg:" + adError.getErrorMessage());
                o00O00o0 o00o00o0 = UbixInterstitalAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, adError.getErrorCode() + "", adError.getErrorMessage()).setInfo((Object) UbixInterstitalAdapter.this.absUbixInfo));
                }
            }

            @Override // com.ubix.ssp.open.interstitial.UBiXInterstitialAdListener
            public void onAdLoadSucceed() {
                try {
                    UbixInterstitalAdapter ubixInterstitalAdapter = UbixInterstitalAdapter.this;
                    ubixInterstitalAdapter.showLog(ubixInterstitalAdapter.OooO00o, "onAdLoadSucceed");
                    UbixInterstitalAdapter ubixInterstitalAdapter2 = UbixInterstitalAdapter.this;
                    if (ubixInterstitalAdapter2.loadListener != null) {
                        if (ubixInterstitalAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            ubixInterstitalAdapter2.showLog(ubixInterstitalAdapter2.OooO00o, "price:" + UbixInterstitalAdapter.this.OooO0O0.getPrice());
                            UbixInterstitalAdapter ubixInterstitalAdapter3 = UbixInterstitalAdapter.this;
                            ubixInterstitalAdapter3.absUbixInfo.setBiddingEcpm((int) ubixInterstitalAdapter3.OooO0O0.getPrice());
                        }
                        UbixInterstitalAdapter ubixInterstitalAdapter4 = UbixInterstitalAdapter.this;
                        ubixInterstitalAdapter4.absUbixInfo.material = UbixUtils.getMaterialInfo(ubixInterstitalAdapter4.OooO0O0);
                        UbixInterstitalAdapter.this.absUbixInfo.getBaseAdConfig().OooOOo0 = UbixUtils.getPR(UbixInterstitalAdapter.this.OooO0O0);
                        UbixInterstitalAdapter ubixInterstitalAdapter5 = UbixInterstitalAdapter.this;
                        ubixInterstitalAdapter5.loadListener.onAdCacheSuccess(ubixInterstitalAdapter5.absUbixInfo);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }
        });
        OooO00o();
        this.OooO0O0.loadAd();
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        UBiXInterstitialManager uBiXInterstitialManager = this.OooO0O0;
        if (uBiXInterstitialManager != null) {
            uBiXInterstitialManager.destroy();
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        try {
            if (this.OooO0O0 == null) {
                ooooO000.OooO0OO(this.OooO00o, "isValid false");
                return false;
            }
            if (ooooO000.OooO00o) {
                ooooO000.OooO0OO(this.OooO00o, "isValid " + this.OooO0O0.isValid());
            }
            return this.OooO0O0.isValid();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return true;
        }
    }

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void loadInterstitalAd(Context context, o00O000 o00o000) {
        this.mContext = context;
        createADInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(this.adsSlotid)) {
            Ubix2InitManager.getInstance().initSDK(StubApp.getOrigApplicationContext(context.getApplicationContext()), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.ubix2.UbixInterstitalAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = UbixInterstitalAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        StringBuilder sb = new StringBuilder();
                        Ubix2InitManager.getInstance();
                        o00o00o0.onNoAdError(new ErrorInfo("500041", sb.append(Ubix2InitManager.getName()).append(oOO00O0.ubix_initError_msg).append(th.getMessage()).toString()).setInfo((Object) UbixInterstitalAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    UbixInterstitalAdapter.this.loadAd();
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            StringBuilder sb = new StringBuilder();
            Ubix2InitManager.getInstance();
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, sb.append(Ubix2InitManager.getName()).append(oOO00O0.ubix_appIdorPlaceIdNull_msg).toString()).setInfo((Object) this.absUbixInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            if (this.OooO0O0 != null) {
                UBiXAdLossInfo failInfo = Ubix2BiddingUtils.getFailInfo(o00oo0oo);
                this.OooO0O0.lossNotice(failInfo);
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
            UBiXInterstitialManager uBiXInterstitialManager = this.OooO0O0;
            if (uBiXInterstitialManager != null) {
                uBiXInterstitialManager.winNotice(Ubix2BiddingUtils.getSecondPrice(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyWin:" + Ubix2BiddingUtils.getSecondPrice(o00oo0oo));
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void show(Activity activity) {
        UBiXInterstitialManager uBiXInterstitialManager = this.OooO0O0;
        if (uBiXInterstitialManager == null || activity == null) {
            return;
        }
        uBiXInterstitialManager.showAd(activity);
    }
}
