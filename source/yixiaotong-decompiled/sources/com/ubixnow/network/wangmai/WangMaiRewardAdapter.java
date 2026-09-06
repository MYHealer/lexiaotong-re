package com.ubixnow.network.wangmai;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.br;
import com.stub.StubApp;
import com.ubix.wm.appsdkdex.ads.WMAdRewardVideo;
import com.ubix.wm.common.Ilistener.XAdRewardVideoListener;
import com.ubix.wm.common.bean.WMAdSlot;
import com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00000;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class WangMaiRewardAdapter extends UMNCustomRewardAdapter {
    public final String OooO00o = "----WangMaiRewardAdapter";
    private WMAdRewardVideo OooO0O0;
    private int OooO0OO;

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        showLog(this.OooO00o, "destory");
        WMAdRewardVideo wMAdRewardVideo = this.OooO0O0;
        if (wMAdRewardVideo != null) {
            wMAdRewardVideo.destroy();
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        try {
            WMAdRewardVideo wMAdRewardVideo = this.OooO0O0;
            return wMAdRewardVideo != null && wMAdRewardVideo.isReady();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return super.isValid();
        }
    }

    public void loadAd(o00O000 o00o000) {
        showLog(this.OooO00o, "SlotId:" + this.adsSlotid + " appId:" + o00o000.OooO00o.OooO0Oo);
        WMAdRewardVideo wMAdRewardVideo = new WMAdRewardVideo(new WMAdSlot.Builder().setSlotId(this.mBaseAdConfig.OooO00o.OooO0o0).builder(), new XAdRewardVideoListener() { // from class: com.ubixnow.network.wangmai.WangMaiRewardAdapter.2
            public void onAdClose() {
                WangMaiRewardAdapter wangMaiRewardAdapter = WangMaiRewardAdapter.this;
                wangMaiRewardAdapter.showLog(wangMaiRewardAdapter.OooO00o, "onAdClose");
                if (WangMaiRewardAdapter.this.eventListener != null) {
                    WangMaiRewardAdapter.this.eventListener.onAdDismiss(WangMaiRewardAdapter.this.absUbixInfo);
                }
            }

            public void onAdLoad() {
                WangMaiRewardAdapter wangMaiRewardAdapter = WangMaiRewardAdapter.this;
                if (wangMaiRewardAdapter.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    int ecpm = wangMaiRewardAdapter.OooO0O0.getECPM();
                    WangMaiRewardAdapter wangMaiRewardAdapter2 = WangMaiRewardAdapter.this;
                    wangMaiRewardAdapter2.showLog(wangMaiRewardAdapter2.OooO00o, "ecpm:" + ecpm + "分");
                    WangMaiRewardAdapter.this.absUbixInfo.setBiddingEcpm(ecpm);
                }
                WangMaiRewardAdapter wangMaiRewardAdapter3 = WangMaiRewardAdapter.this;
                o00O00o0 o00o00o0 = wangMaiRewardAdapter3.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onAdCacheSuccess(wangMaiRewardAdapter3.absUbixInfo);
                }
            }

            public void onAdRequest() {
                WangMaiRewardAdapter wangMaiRewardAdapter = WangMaiRewardAdapter.this;
                wangMaiRewardAdapter.showLog(wangMaiRewardAdapter.OooO00o, "onAdRequest ");
                WangMaiRewardAdapter wangMaiRewardAdapter2 = WangMaiRewardAdapter.this;
                if (wangMaiRewardAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    int ecpm = wangMaiRewardAdapter2.OooO0O0.getECPM();
                    WangMaiRewardAdapter wangMaiRewardAdapter3 = WangMaiRewardAdapter.this;
                    wangMaiRewardAdapter3.showLog(wangMaiRewardAdapter3.OooO00o, "ecpm:" + ecpm + "分");
                    WangMaiRewardAdapter.this.absUbixInfo.setBiddingEcpm(ecpm);
                }
                WangMaiRewardAdapter.this.onAdDataLoaded();
            }

            public void onClick() {
                WangMaiRewardAdapter wangMaiRewardAdapter = WangMaiRewardAdapter.this;
                wangMaiRewardAdapter.showLog(wangMaiRewardAdapter.OooO00o, "onRewardedVideoAdPlayClicked");
                if (WangMaiRewardAdapter.this.eventListener != null) {
                    WangMaiRewardAdapter.this.eventListener.onAdClick(WangMaiRewardAdapter.this.absUbixInfo);
                }
            }

            public void onExposure() {
                WangMaiRewardAdapter wangMaiRewardAdapter = WangMaiRewardAdapter.this;
                wangMaiRewardAdapter.showLog(wangMaiRewardAdapter.OooO00o, "onExposure");
                if (WangMaiRewardAdapter.this.eventListener != null) {
                    WangMaiRewardAdapter.this.eventListener.onAdShow(WangMaiRewardAdapter.this.absUbixInfo);
                    WangMaiRewardAdapter.this.eventListener.onVideoPlayStart(WangMaiRewardAdapter.this.absUbixInfo);
                }
            }

            public void onNoAd(String str) {
                WangMaiRewardAdapter wangMaiRewardAdapter = WangMaiRewardAdapter.this;
                wangMaiRewardAdapter.showLog(wangMaiRewardAdapter.OooO00o, "onNoAd -> " + str);
                if (WangMaiRewardAdapter.this.OooO0OO == oO.EXECUTE_SHOW.OooO00o()) {
                    if (WangMaiRewardAdapter.this.eventListener != null) {
                        WangMaiRewardAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, oOO00O0.ubix_show_error, str));
                    }
                } else {
                    o00O00o0 o00o00o0 = WangMaiRewardAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, oOO00O0.ubix_no_ad, str));
                    }
                }
            }

            public void onRewarded(boolean z, Bundle bundle) {
                WangMaiRewardAdapter wangMaiRewardAdapter = WangMaiRewardAdapter.this;
                wangMaiRewardAdapter.showLog(wangMaiRewardAdapter.OooO00o, "onRewarded");
                if (WangMaiRewardAdapter.this.eventListener != null) {
                    WangMaiRewardAdapter.this.eventListener.onRewardVerify(WangMaiRewardAdapter.this.absUbixInfo);
                }
            }

            public void onVideoComplete() {
                WangMaiRewardAdapter wangMaiRewardAdapter = WangMaiRewardAdapter.this;
                wangMaiRewardAdapter.showLog(wangMaiRewardAdapter.OooO00o, "onVideoComplete");
                if (WangMaiRewardAdapter.this.eventListener != null) {
                    WangMaiRewardAdapter.this.eventListener.onVideoPlayComplete(WangMaiRewardAdapter.this.absUbixInfo);
                }
            }

            public void onVideoError(String str) {
                WangMaiRewardAdapter wangMaiRewardAdapter = WangMaiRewardAdapter.this;
                wangMaiRewardAdapter.showLog(wangMaiRewardAdapter.OooO00o, "-----onVideoError:" + str);
                if (WangMaiRewardAdapter.this.eventListener != null) {
                    WangMaiRewardAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, oOO00O0.ubix_show_error, str));
                }
            }
        });
        this.OooO0O0 = wMAdRewardVideo;
        wMAdRewardVideo.load();
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void loadRewardAd(Context context, final o00O000 o00o000) {
        createADInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(this.adsSlotid)) {
            WangMaiInitManager.getInstance().initSDK(StubApp.getOrigApplicationContext(context.getApplicationContext()), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.wangmai.WangMaiRewardAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = WangMaiRewardAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", WangMaiInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) WangMaiRewardAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    WangMaiRewardAdapter.this.loadAd(o00o000);
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
            WMAdRewardVideo wMAdRewardVideo = this.OooO0O0;
            if (wMAdRewardVideo != null) {
                wMAdRewardVideo.sendWinNotificationWithInfo((Bundle) null);
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void show(Activity activity) {
        showLog(this.OooO00o, br.b.V);
        this.OooO0OO = oO.EXECUTE_SHOW.OooO00o();
        if (this.OooO0O0 != null && activity != null && !activity.isFinishing() && isValid()) {
            this.OooO0O0.show(activity);
            return;
        }
        o00000 o00000Var = this.eventListener;
        if (o00000Var != null) {
            o00000Var.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg).setInfo((Object) this.absUbixInfo));
        }
    }
}
