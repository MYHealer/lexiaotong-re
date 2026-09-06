package com.ubixnow.network.wangmai;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.constant.br;
import com.stub.StubApp;
import com.ubix.wm.appsdkdex.ads.WMAdSplashad;
import com.ubix.wm.common.Ilistener.XAdSplashListener;
import com.ubix.wm.common.bean.WMAdSlot;
import com.ubixnow.adtype.splash.api.UMNSplashParams;
import com.ubixnow.adtype.splash.custom.UMNCustomSplashAdapter;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o000O0O0;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oO;
import com.ubixnow.ooooo.oO0000O;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class WangMaiSplashAdapter extends UMNCustomSplashAdapter {
    private final String OooO00o = this.customTag + getClass().getSimpleName();
    private WMAdSplashad OooO0O0;
    private int OooO0OO;
    public int OooO0Oo;
    public int OooO0o0;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context) {
        parseConfig();
        WMAdSlot wMAdSlotBuilder = new WMAdSlot.Builder().setSlotId(this.mBaseAdConfig.OooO00o.OooO0o0).setAdSize(oO0000O.OooO00o(this.OooO0Oo), oO0000O.OooO00o(this.OooO0o0)).builder();
        WMAdSplashad wMAdSplashad = new WMAdSplashad();
        this.OooO0O0 = wMAdSplashad;
        wMAdSplashad.load(wMAdSlotBuilder, new XAdSplashListener() { // from class: com.ubixnow.network.wangmai.WangMaiSplashAdapter.2
            public void onAdDismissed() {
                WangMaiSplashAdapter wangMaiSplashAdapter = WangMaiSplashAdapter.this;
                wangMaiSplashAdapter.showLog(wangMaiSplashAdapter.OooO00o, "onAdDismissed");
                if (WangMaiSplashAdapter.this.eventListener != null) {
                    WangMaiSplashAdapter.this.eventListener.onAdDismiss(WangMaiSplashAdapter.this.splashInfo);
                }
            }

            public void onAdRequest() {
                WangMaiSplashAdapter wangMaiSplashAdapter = WangMaiSplashAdapter.this;
                wangMaiSplashAdapter.showLog(wangMaiSplashAdapter.OooO00o, "onAdRequest ");
                WangMaiSplashAdapter wangMaiSplashAdapter2 = WangMaiSplashAdapter.this;
                if (wangMaiSplashAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    int ecpm = wangMaiSplashAdapter2.OooO0O0.getECPM();
                    WangMaiSplashAdapter wangMaiSplashAdapter3 = WangMaiSplashAdapter.this;
                    wangMaiSplashAdapter3.showLog(wangMaiSplashAdapter3.OooO00o, "ecpm:" + ecpm + "分");
                    WangMaiSplashAdapter.this.splashInfo.setBiddingEcpm(ecpm);
                }
                WangMaiSplashAdapter.this.onAdDataLoaded();
                WangMaiSplashAdapter wangMaiSplashAdapter4 = WangMaiSplashAdapter.this;
                o00O00o0 o00o00o0 = wangMaiSplashAdapter4.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onAdCacheSuccess(wangMaiSplashAdapter4.splashInfo);
                }
            }

            public void onAdZoomOut() {
                WangMaiSplashAdapter wangMaiSplashAdapter = WangMaiSplashAdapter.this;
                wangMaiSplashAdapter.showLog(wangMaiSplashAdapter.OooO00o, "onAdZoomOut");
            }

            public void onAdZoomOutClick() {
                WangMaiSplashAdapter wangMaiSplashAdapter = WangMaiSplashAdapter.this;
                wangMaiSplashAdapter.showLog(wangMaiSplashAdapter.OooO00o, "onAdZoomOutDismissed");
            }

            public void onAdZoomOutDismissed() {
                WangMaiSplashAdapter wangMaiSplashAdapter = WangMaiSplashAdapter.this;
                wangMaiSplashAdapter.showLog(wangMaiSplashAdapter.OooO00o, "onAdZoomOutDismissed");
            }

            public void onClick() {
                WangMaiSplashAdapter wangMaiSplashAdapter = WangMaiSplashAdapter.this;
                wangMaiSplashAdapter.showLog(wangMaiSplashAdapter.OooO00o, "onClick");
                if (WangMaiSplashAdapter.this.eventListener != null) {
                    WangMaiSplashAdapter.this.eventListener.onAdClick(WangMaiSplashAdapter.this.splashInfo);
                }
            }

            public void onExposure() {
                WangMaiSplashAdapter wangMaiSplashAdapter = WangMaiSplashAdapter.this;
                wangMaiSplashAdapter.showLog(wangMaiSplashAdapter.OooO00o, "onExposure");
                if (WangMaiSplashAdapter.this.eventListener != null) {
                    WangMaiSplashAdapter.this.eventListener.onAdShow(WangMaiSplashAdapter.this.splashInfo);
                }
            }

            public void onNoAd(String str) {
                WangMaiSplashAdapter wangMaiSplashAdapter = WangMaiSplashAdapter.this;
                wangMaiSplashAdapter.showLog(wangMaiSplashAdapter.OooO00o, "onNoAd -> " + str);
                if (WangMaiSplashAdapter.this.OooO0OO == oO.EXECUTE_SHOW.OooO00o()) {
                    if (WangMaiSplashAdapter.this.eventListener != null) {
                        WangMaiSplashAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, oOO00O0.ubix_show_error, str));
                    }
                } else {
                    o00O00o0 o00o00o0 = WangMaiSplashAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, oOO00O0.ubix_no_ad, str));
                    }
                }
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00OO00O, com.ubixnow.ooooo.o00O
    public void destory() {
        showLog(this.OooO00o, "destory");
        WMAdSplashad wMAdSplashad = this.OooO0O0;
        if (wMAdSplashad != null) {
            wMAdSplashad.destroy();
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        try {
            WMAdSplashad wMAdSplashad = this.OooO0O0;
            return wMAdSplashad != null && wMAdSplashad.isReady();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return super.isValid();
        }
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void loadSplashAd(final Context context, o00O000 o00o000) {
        createSplashInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            WangMaiInitManager.getInstance().initSDK(StubApp.getOrigApplicationContext(context.getApplicationContext()), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.wangmai.WangMaiSplashAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = WangMaiSplashAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", WangMaiInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) WangMaiSplashAdapter.this.splashInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    WangMaiSplashAdapter.this.loadAd(context);
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, WangMaiInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.splashInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            WMAdSplashad wMAdSplashad = this.OooO0O0;
            if (wMAdSplashad != null) {
                wMAdSplashad.sendWinNotificationWithInfo((Bundle) null);
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public void parseConfig() {
        BaseDevConfig baseDevConfig = this.mBaseAdConfig.OooO0o0;
        if (baseDevConfig instanceof UMNSplashParams) {
            UMNSplashParams uMNSplashParams = (UMNSplashParams) baseDevConfig;
            this.OooO0Oo = uMNSplashParams.width;
            this.OooO0o0 = uMNSplashParams.height;
        }
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void show(ViewGroup viewGroup) {
        showLog(this.OooO00o, br.b.V);
        this.OooO0OO = oO.EXECUTE_SHOW.OooO00o();
        if (this.OooO0O0 != null && viewGroup != null && isValid()) {
            this.OooO0O0.show(viewGroup);
            return;
        }
        showLog(this.OooO00o, "showError");
        o000O0O0 o000o0o0 = this.eventListener;
        if (o000o0o0 != null) {
            o000o0o0.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, oOO00O0.ubix_show_error, "展示失败 group:" + (viewGroup == null)).setInfo((Object) this.splashInfo));
        }
    }
}
