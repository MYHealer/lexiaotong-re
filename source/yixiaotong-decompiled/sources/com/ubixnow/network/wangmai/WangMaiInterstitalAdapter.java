package com.ubixnow.network.wangmai;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.ubix.wm.appsdkdex.ads.WMAdInterstitial;
import com.ubix.wm.common.Ilistener.XAdInterstitialListener;
import com.ubix.wm.common.bean.WMAdSlot;
import com.ubixnow.adtype.interstital.api.UMNInterstitalParams;
import com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.OooOo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class WangMaiInterstitalAdapter extends UMNCustomInterstitalAdapter {
    private final String OooO00o = this.customTag + WangMaiInitManager.getInstance().getName();
    private WMAdInterstitial OooO0O0;
    private int OooO0OO;
    private boolean OooO0Oo;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd() {
        WMAdInterstitial wMAdInterstitial = new WMAdInterstitial(new WMAdSlot.Builder().setSlotId(this.mBaseAdConfig.OooO00o.OooO0o0).setMuted(this.isMute).builder(), new XAdInterstitialListener() { // from class: com.ubixnow.network.wangmai.WangMaiInterstitalAdapter.2
            public void onAdClose() {
                WangMaiInterstitalAdapter wangMaiInterstitalAdapter = WangMaiInterstitalAdapter.this;
                wangMaiInterstitalAdapter.showLog(wangMaiInterstitalAdapter.OooO00o, "--onAdClosed: ");
                if (!WangMaiInterstitalAdapter.this.OooO0Oo && WangMaiInterstitalAdapter.this.eventListener != null) {
                    WangMaiInterstitalAdapter.this.eventListener.onAdDismiss(WangMaiInterstitalAdapter.this.absUbixInfo);
                }
                WangMaiInterstitalAdapter.this.OooO0Oo = true;
            }

            public void onAdRequest() {
                WangMaiInterstitalAdapter wangMaiInterstitalAdapter = WangMaiInterstitalAdapter.this;
                wangMaiInterstitalAdapter.showLog(wangMaiInterstitalAdapter.OooO00o, "onInterstitialAdLoaded");
                WangMaiInterstitalAdapter wangMaiInterstitalAdapter2 = WangMaiInterstitalAdapter.this;
                if (wangMaiInterstitalAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    int ecpm = wangMaiInterstitalAdapter2.OooO0O0.getECPM();
                    WangMaiInterstitalAdapter wangMaiInterstitalAdapter3 = WangMaiInterstitalAdapter.this;
                    wangMaiInterstitalAdapter3.showLog(wangMaiInterstitalAdapter3.OooO00o, "ecpm:" + ecpm + "分");
                    WangMaiInterstitalAdapter.this.absUbixInfo.setBiddingEcpm(ecpm);
                }
                WangMaiInterstitalAdapter.this.onAdDataLoaded();
                WangMaiInterstitalAdapter wangMaiInterstitalAdapter4 = WangMaiInterstitalAdapter.this;
                o00O00o0 o00o00o0 = wangMaiInterstitalAdapter4.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onAdCacheSuccess(wangMaiInterstitalAdapter4.absUbixInfo);
                }
            }

            public void onClick() {
                WangMaiInterstitalAdapter wangMaiInterstitalAdapter = WangMaiInterstitalAdapter.this;
                wangMaiInterstitalAdapter.showLog(wangMaiInterstitalAdapter.OooO00o, "onAdClicked");
                if (WangMaiInterstitalAdapter.this.eventListener != null) {
                    WangMaiInterstitalAdapter.this.eventListener.onAdClick(WangMaiInterstitalAdapter.this.absUbixInfo);
                }
                BaseDevConfig baseDevConfig = WangMaiInterstitalAdapter.this.mBaseAdConfig.OooO0o0;
                if ((baseDevConfig instanceof UMNInterstitalParams) && ((UMNInterstitalParams) baseDevConfig).closeAfterClick) {
                    BaseUtils.postDelayed(new Runnable() { // from class: com.ubixnow.network.wangmai.WangMaiInterstitalAdapter.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (WangMaiInterstitalAdapter.this.OooO0O0 == null || WangMaiInterstitalAdapter.this.OooO0Oo) {
                                return;
                            }
                            WangMaiInterstitalAdapter.this.OooO0Oo = true;
                            if (WangMaiInterstitalAdapter.this.eventListener != null) {
                                WangMaiInterstitalAdapter.this.eventListener.onAdDismiss(WangMaiInterstitalAdapter.this.absUbixInfo);
                            }
                            WangMaiInterstitalAdapter.this.OooO0O0.destroy();
                        }
                    }, 1000L);
                }
            }

            public void onExposure() {
                WangMaiInterstitalAdapter wangMaiInterstitalAdapter = WangMaiInterstitalAdapter.this;
                wangMaiInterstitalAdapter.showLog(wangMaiInterstitalAdapter.OooO00o, "--onAdShow: " + (WangMaiInterstitalAdapter.this.eventListener != null));
                if (WangMaiInterstitalAdapter.this.eventListener != null) {
                    WangMaiInterstitalAdapter.this.eventListener.onAdShow(WangMaiInterstitalAdapter.this.absUbixInfo);
                }
            }

            public void onNoAd(String str) {
                WangMaiInterstitalAdapter wangMaiInterstitalAdapter = WangMaiInterstitalAdapter.this;
                wangMaiInterstitalAdapter.showLog(wangMaiInterstitalAdapter.OooO00o, "onNoAd -> " + str);
                if (WangMaiInterstitalAdapter.this.OooO0OO == oO.EXECUTE_SHOW.OooO00o()) {
                    if (WangMaiInterstitalAdapter.this.eventListener != null) {
                        WangMaiInterstitalAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, oOO00O0.ubix_show_error, str));
                    }
                } else {
                    o00O00o0 o00o00o0 = WangMaiInterstitalAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, oOO00O0.ubix_no_ad, str));
                    }
                }
            }
        });
        this.OooO0O0 = wMAdInterstitial;
        wMAdInterstitial.load();
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        showLog(this.OooO00o, "destory ");
        WMAdInterstitial wMAdInterstitial = this.OooO0O0;
        if (wMAdInterstitial != null) {
            wMAdInterstitial.destroy();
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        WMAdInterstitial wMAdInterstitial = this.OooO0O0;
        boolean z = wMAdInterstitial != null && wMAdInterstitial.isReady();
        if (ooooO000.OooO00o) {
            ooooO000.OooO0OO(this.OooO00o, "---isValid " + z);
        }
        return z;
    }

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void loadInterstitalAd(Context context, o00O000 o00o000) {
        createADInfo(o00o000);
        showLog(this.OooO00o, "adsSlotid " + this.adsSlotid);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(this.adsSlotid)) {
            WangMaiInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.wangmai.WangMaiInterstitalAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = WangMaiInterstitalAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", WangMaiInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) WangMaiInterstitalAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    WangMaiInterstitalAdapter.this.loadAd();
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, WangMaiInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            WMAdInterstitial wMAdInterstitial = this.OooO0O0;
            if (wMAdInterstitial != null) {
                wMAdInterstitial.sendWinNotificationWithInfo((Bundle) null);
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void show(Activity activity) {
        showLog(this.OooO00o, "show ");
        this.OooO0OO = oO.EXECUTE_SHOW.OooO00o();
        if (activity != null && this.OooO0O0 != null && !activity.isFinishing() && isValid()) {
            this.OooO0O0.show(activity);
            return;
        }
        OooOo oooOo = this.eventListener;
        if (oooOo != null) {
            oooOo.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, "展示失败 isValid:" + isValid()).setInfo((Object) this.absUbixInfo));
        }
    }
}
