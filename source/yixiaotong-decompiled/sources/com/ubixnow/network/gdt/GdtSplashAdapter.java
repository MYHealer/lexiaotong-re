package com.ubixnow.network.gdt;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.constant.br;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.AdError;
import com.ubixnow.adtype.splash.custom.UMNCustomSplashAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oO00000o;
import com.ubixnow.ooooo.oOO00O;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class GdtSplashAdapter extends UMNCustomSplashAdapter {
    private boolean OooO0O0;
    private SplashAD OooO0OO;
    private Context OooO0Oo;
    private ViewGroup OooO0o0;
    private long OooO0oO;
    private boolean OooO0oo;
    private final String OooO00o = this.customTag + GdtInitManager.getInstance().getName();
    private boolean OooO0o = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context) {
        try {
            this.OooO0o = oOO00O.OooO00o(this.mBaseAdConfig.OooO00o.OooOOO0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        showLog(this.OooO00o, "------loadAd--mubixExt: " + this.OooO0o);
        this.OooO0OO = new SplashAD(context, this.mBaseAdConfig.OooO00o.OooO0o0, new SplashADListener() { // from class: com.ubixnow.network.gdt.GdtSplashAdapter.2
            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADClicked() {
                GdtSplashAdapter gdtSplashAdapter = GdtSplashAdapter.this;
                gdtSplashAdapter.showLog(gdtSplashAdapter.OooO00o, "onADClicked");
                GdtSplashAdapter.this.OooO0oo = true;
                if (GdtSplashAdapter.this.eventListener != null) {
                    GdtSplashAdapter.this.eventListener.onAdClick(GdtSplashAdapter.this.splashInfo);
                }
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADDismissed() {
                ooooO000.OooO0OO(GdtSplashAdapter.this.OooO00o, "onADDismissed");
                GdtSplashAdapter gdtSplashAdapter = GdtSplashAdapter.this;
                gdtSplashAdapter.splashInfo.OooO00o = gdtSplashAdapter.OooO0oO > 500 && !GdtSplashAdapter.this.OooO0oo;
                if (GdtSplashAdapter.this.eventListener != null) {
                    GdtSplashAdapter.this.eventListener.onAdDismiss(GdtSplashAdapter.this.splashInfo);
                }
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADExposure() {
                GdtSplashAdapter gdtSplashAdapter = GdtSplashAdapter.this;
                gdtSplashAdapter.showLog(gdtSplashAdapter.OooO00o, "onADExposure");
                if (GdtSplashAdapter.this.eventListener != null) {
                    GdtSplashAdapter.this.eventListener.onAdShow(GdtSplashAdapter.this.splashInfo);
                }
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADLoaded(long j) {
                GdtSplashAdapter gdtSplashAdapter = GdtSplashAdapter.this;
                gdtSplashAdapter.showLog(gdtSplashAdapter.OooO00o, "onADLoaded");
                GdtSplashAdapter.this.OooO0O0 = true;
                GdtSplashAdapter gdtSplashAdapter2 = GdtSplashAdapter.this;
                if (gdtSplashAdapter2.loadListener != null) {
                    if (gdtSplashAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                        gdtSplashAdapter2.showLog(gdtSplashAdapter2.OooO00o, "price:" + GdtSplashAdapter.this.OooO0OO.getECPM());
                        GdtSplashAdapter gdtSplashAdapter3 = GdtSplashAdapter.this;
                        gdtSplashAdapter3.splashInfo.setBiddingEcpm(gdtSplashAdapter3.OooO0OO.getECPM());
                    }
                    GdtSplashAdapter gdtSplashAdapter4 = GdtSplashAdapter.this;
                    gdtSplashAdapter4.loadListener.onAdCacheSuccess(gdtSplashAdapter4.splashInfo);
                }
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADPresent() {
                GdtSplashAdapter gdtSplashAdapter = GdtSplashAdapter.this;
                gdtSplashAdapter.showLog(gdtSplashAdapter.OooO00o, "onADPresent");
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADTick(long j) {
                GdtSplashAdapter gdtSplashAdapter = GdtSplashAdapter.this;
                gdtSplashAdapter.showLog(gdtSplashAdapter.OooO00o, "onADTick:" + j);
                GdtSplashAdapter.this.OooO0oO = j;
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onNoAD(AdError adError) {
                GdtSplashAdapter gdtSplashAdapter = GdtSplashAdapter.this;
                gdtSplashAdapter.showLog(gdtSplashAdapter.OooO00o, "-----onNoAD:code= " + adError.getErrorCode() + ", msg=" + adError.getErrorMsg());
                if (GdtSplashAdapter.this.OooO0O0) {
                    if (GdtSplashAdapter.this.eventListener != null) {
                        GdtSplashAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, adError.getErrorCode() + "", adError.getErrorMsg()).setInfo((Object) GdtSplashAdapter.this.splashInfo));
                    }
                } else {
                    o00O00o0 o00o00o0 = GdtSplashAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, adError.getErrorCode() + "", adError.getErrorMsg()).setInfo((Object) GdtSplashAdapter.this.splashInfo));
                    }
                }
            }
        });
        HashMap map = new HashMap();
        map.put("shakable", oO00000o.o00O0O.OooOOOo ? "1" : "0");
        GlobalSetting.setExtraUserData(map);
        this.OooO0OO.fetchAdOnly();
    }

    @Override // com.ubixnow.ooooo.o00OO00O, com.ubixnow.ooooo.o00O
    public void destory() {
        ooooO000.OooO0OO(this.OooO00o, "destory");
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        if (this.OooO0OO == null) {
            ooooO000.OooO0OO(this.OooO00o, "isValid false");
            return false;
        }
        if (ooooO000.OooO00o) {
            ooooO000.OooO0OO(this.OooO00o, "isValid " + this.OooO0OO.isValid());
        }
        return this.OooO0OO.isValid();
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void loadSplashAd(Context context, o00O000 o00o000) {
        createSplashInfo(o00o000);
        this.OooO0Oo = context;
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            GdtInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.gdt.GdtSplashAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    ooooO000.OooO0OO(GdtSplashAdapter.this.OooO00o, "initSDK error");
                    o00O00o0 o00o00o0 = GdtSplashAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", GdtInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) GdtSplashAdapter.this.splashInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    ooooO000.OooO0OO(GdtSplashAdapter.this.OooO00o, "initSDK success");
                    GdtSplashAdapter gdtSplashAdapter = GdtSplashAdapter.this;
                    gdtSplashAdapter.loadAd(gdtSplashAdapter.OooO0Oo);
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, GdtInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.splashInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            SplashAD splashAD = this.OooO0OO;
            if (splashAD != null) {
                splashAD.sendLossNotification(GdtBiddingUtils.getFailInfo(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyLoss:" + GdtBiddingUtils.getFailInfo(o00oo0oo));
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            SplashAD splashAD = this.OooO0OO;
            if (splashAD != null) {
                splashAD.sendWinNotification(GdtBiddingUtils.getSuccMap(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyWin:" + GdtBiddingUtils.getSuccMap(o00oo0oo));
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void show(ViewGroup viewGroup) {
        showLog(this.OooO00o, "prepare show");
        if (this.OooO0OO == null || viewGroup == null) {
            return;
        }
        showLog(this.OooO00o, br.b.V);
        this.OooO0o0 = viewGroup;
        this.OooO0OO.showAd(viewGroup);
    }
}
