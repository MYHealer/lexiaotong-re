package com.ubixnow.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.util.AdError;
import com.ubixnow.adtype.interstital.api.UMNInterstitalParams;
import com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class GdtInterstitalAdapter extends UMNCustomInterstitalAdapter {
    private final String OooO00o = this.customTag + GdtInitManager.getInstance().getName();
    private UnifiedInterstitialAD OooO0O0;
    private boolean OooO0OO;
    private o00O000 OooO0Oo;

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o() {
        int i;
        this.OooO0O0 = new UnifiedInterstitialAD((Activity) this.mContext, this.adsSlotid, new UnifiedInterstitialADListener() { // from class: com.ubixnow.network.gdt.GdtInterstitalAdapter.2
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClicked() {
                GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                gdtInterstitalAdapter.showLog(gdtInterstitalAdapter.OooO00o, "onADClicked");
                if (GdtInterstitalAdapter.this.eventListener != null) {
                    GdtInterstitalAdapter.this.eventListener.onAdClick(GdtInterstitalAdapter.this.absUbixInfo);
                }
                if ((GdtInterstitalAdapter.this.OooO0Oo.OooO0o0 instanceof UMNInterstitalParams) && ((UMNInterstitalParams) GdtInterstitalAdapter.this.OooO0Oo.OooO0o0).closeAfterClick) {
                    try {
                        GdtInterstitalAdapter.this.OooO0O0.close();
                    } catch (Throwable th) {
                        ooooO000.OooO00o(th);
                    }
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClosed() {
                GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                gdtInterstitalAdapter.showLog(gdtInterstitalAdapter.OooO00o, "onADClosed");
                if (GdtInterstitalAdapter.this.eventListener != null) {
                    GdtInterstitalAdapter.this.eventListener.onAdDismiss(GdtInterstitalAdapter.this.absUbixInfo);
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADExposure() {
                GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                gdtInterstitalAdapter.showLog(gdtInterstitalAdapter.OooO00o, "onADExposure");
                if (GdtInterstitalAdapter.this.eventListener != null) {
                    GdtInterstitalAdapter.this.eventListener.onAdShow(GdtInterstitalAdapter.this.absUbixInfo);
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADLeftApplication() {
                GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                gdtInterstitalAdapter.showLog(gdtInterstitalAdapter.OooO00o, "onADLeftApplication");
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADOpened() {
                GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                gdtInterstitalAdapter.showLog(gdtInterstitalAdapter.OooO00o, "onADOpened");
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADReceive() {
                try {
                    GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                    gdtInterstitalAdapter.showLog(gdtInterstitalAdapter.OooO00o, "onADReceive");
                    GdtInterstitalAdapter gdtInterstitalAdapter2 = GdtInterstitalAdapter.this;
                    if (gdtInterstitalAdapter2.adFlowStatus >= 30) {
                        return;
                    }
                    gdtInterstitalAdapter2.adFlowStatus = 30;
                    if (gdtInterstitalAdapter2.loadListener != null) {
                        if (gdtInterstitalAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            gdtInterstitalAdapter2.showLog(gdtInterstitalAdapter2.OooO00o, "price:" + GdtInterstitalAdapter.this.OooO0O0.getECPM());
                            GdtInterstitalAdapter gdtInterstitalAdapter3 = GdtInterstitalAdapter.this;
                            gdtInterstitalAdapter3.absUbixInfo.setBiddingEcpm(gdtInterstitalAdapter3.OooO0O0.getECPM());
                        }
                        GdtInterstitalAdapter gdtInterstitalAdapter4 = GdtInterstitalAdapter.this;
                        gdtInterstitalAdapter4.loadListener.onAdCacheSuccess(gdtInterstitalAdapter4.absUbixInfo);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onNoAD(AdError adError) {
                ooooO000.OooO0O0(GdtInterstitalAdapter.this.OooO00o, "onNoAD code:" + adError.getErrorCode() + ",msg:" + adError.getErrorMsg());
                GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                int i2 = gdtInterstitalAdapter.adFlowStatus;
                if (i2 < 30 && gdtInterstitalAdapter.loadListener != null) {
                    gdtInterstitalAdapter.onAdDataLoadFailed(adError.getErrorCode(), adError.getErrorMsg());
                } else {
                    if (i2 != 50 || gdtInterstitalAdapter.eventListener == null) {
                        return;
                    }
                    GdtInterstitalAdapter.this.eventListener.onShowError(new ErrorInfo(adError.getErrorCode() + "", adError.getErrorMsg()).setInfo((Object) GdtInterstitalAdapter.this.absUbixInfo));
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderFail() {
                GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                gdtInterstitalAdapter.showLog(gdtInterstitalAdapter.OooO00o, "onRenderFail");
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderSuccess() {
                try {
                    GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                    gdtInterstitalAdapter.showLog(gdtInterstitalAdapter.OooO00o, "onRenderSuccess");
                    GdtInterstitalAdapter gdtInterstitalAdapter2 = GdtInterstitalAdapter.this;
                    if (gdtInterstitalAdapter2.adFlowStatus >= 30) {
                        return;
                    }
                    gdtInterstitalAdapter2.adFlowStatus = 30;
                    if (gdtInterstitalAdapter2.loadListener != null) {
                        if (gdtInterstitalAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            gdtInterstitalAdapter2.showLog(gdtInterstitalAdapter2.OooO00o, "price:" + GdtInterstitalAdapter.this.OooO0O0.getECPM());
                            GdtInterstitalAdapter gdtInterstitalAdapter3 = GdtInterstitalAdapter.this;
                            gdtInterstitalAdapter3.absUbixInfo.setBiddingEcpm(gdtInterstitalAdapter3.OooO0O0.getECPM());
                        }
                        GdtInterstitalAdapter gdtInterstitalAdapter4 = GdtInterstitalAdapter.this;
                        gdtInterstitalAdapter4.loadListener.onAdCacheSuccess(gdtInterstitalAdapter4.absUbixInfo);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onVideoCached() {
                GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                gdtInterstitalAdapter.showLog(gdtInterstitalAdapter.OooO00o, "onVideoCached");
            }
        });
        String videoPlayPolicy = getVideoPlayPolicy();
        videoPlayPolicy.hashCode();
        if (videoPlayPolicy.equals("2")) {
            i = 0;
        } else {
            i = !videoPlayPolicy.equals("3") ? 1 : 2;
        }
        this.OooO0O0.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(i).setAutoPlayMuted(this.isMute).build());
        this.OooO0O0.loadFullScreenAD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO0O0() {
        int i;
        this.OooO0O0 = new UnifiedInterstitialAD((Activity) this.mContext, this.adsSlotid, new UnifiedInterstitialADListener() { // from class: com.ubixnow.network.gdt.GdtInterstitalAdapter.3
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClicked() {
                GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                gdtInterstitalAdapter.showLog(gdtInterstitalAdapter.OooO00o, "onADClicked");
                if (GdtInterstitalAdapter.this.eventListener != null) {
                    GdtInterstitalAdapter.this.eventListener.onAdClick(GdtInterstitalAdapter.this.absUbixInfo);
                }
                if ((GdtInterstitalAdapter.this.OooO0Oo.OooO0o0 instanceof UMNInterstitalParams) && ((UMNInterstitalParams) GdtInterstitalAdapter.this.OooO0Oo.OooO0o0).closeAfterClick) {
                    try {
                        GdtInterstitalAdapter.this.OooO0O0.close();
                    } catch (Throwable th) {
                        ooooO000.OooO00o(th);
                    }
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClosed() {
                GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                gdtInterstitalAdapter.showLog(gdtInterstitalAdapter.OooO00o, "onADClosed");
                if (GdtInterstitalAdapter.this.eventListener != null) {
                    GdtInterstitalAdapter.this.eventListener.onAdDismiss(GdtInterstitalAdapter.this.absUbixInfo);
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADExposure() {
                GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                gdtInterstitalAdapter.showLog(gdtInterstitalAdapter.OooO00o, "onADExposure");
                if (GdtInterstitalAdapter.this.eventListener != null) {
                    GdtInterstitalAdapter.this.eventListener.onAdShow(GdtInterstitalAdapter.this.absUbixInfo);
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADLeftApplication() {
                GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                gdtInterstitalAdapter.showLog(gdtInterstitalAdapter.OooO00o, "onADLeftApplication");
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADOpened() {
                GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                gdtInterstitalAdapter.showLog(gdtInterstitalAdapter.OooO00o, "onADOpened");
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADReceive() {
                try {
                    GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                    gdtInterstitalAdapter.adFlowStatus = 10;
                    gdtInterstitalAdapter.showLog(gdtInterstitalAdapter.OooO00o, "onADReceive");
                    GdtInterstitalAdapter gdtInterstitalAdapter2 = GdtInterstitalAdapter.this;
                    if (gdtInterstitalAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                        gdtInterstitalAdapter2.showLog(gdtInterstitalAdapter2.OooO00o, "price:" + GdtInterstitalAdapter.this.OooO0O0.getECPM());
                        GdtInterstitalAdapter gdtInterstitalAdapter3 = GdtInterstitalAdapter.this;
                        gdtInterstitalAdapter3.absUbixInfo.setBiddingEcpm(gdtInterstitalAdapter3.OooO0O0.getECPM());
                    }
                    GdtInterstitalAdapter.this.onAdDataLoaded();
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onNoAD(AdError adError) {
                ooooO000.OooO0O0(GdtInterstitalAdapter.this.OooO00o, "onNoAD code:" + adError.getErrorCode() + ",msg:" + adError.getErrorMsg());
                GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                int i2 = gdtInterstitalAdapter.adFlowStatus;
                if (i2 < 10 && gdtInterstitalAdapter.loadListener != null) {
                    gdtInterstitalAdapter.onAdDataLoadFailed(adError.getErrorCode(), adError.getErrorMsg());
                } else {
                    if (i2 != 50 || gdtInterstitalAdapter.eventListener == null) {
                        return;
                    }
                    GdtInterstitalAdapter.this.eventListener.onShowError(new ErrorInfo(adError.getErrorCode() + "", adError.getErrorMsg()).setInfo((Object) GdtInterstitalAdapter.this.absUbixInfo));
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderFail() {
                GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                gdtInterstitalAdapter.showLog(gdtInterstitalAdapter.OooO00o, "onRenderFail");
                GdtInterstitalAdapter gdtInterstitalAdapter2 = GdtInterstitalAdapter.this;
                oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.RENDER_FAIL;
                gdtInterstitalAdapter2.onAdRenderFail(oooO00o.OooO00o(), GdtInitManager.getInstance().getName() + oooO00o.OooO0O0());
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderSuccess() {
                try {
                    GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                    gdtInterstitalAdapter.showLog(gdtInterstitalAdapter.OooO00o, "onRenderSuccess");
                    GdtInterstitalAdapter gdtInterstitalAdapter2 = GdtInterstitalAdapter.this;
                    if (gdtInterstitalAdapter2.loadListener != null) {
                        if (gdtInterstitalAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            gdtInterstitalAdapter2.showLog(gdtInterstitalAdapter2.OooO00o, "price:" + GdtInterstitalAdapter.this.OooO0O0.getECPM());
                            GdtInterstitalAdapter gdtInterstitalAdapter3 = GdtInterstitalAdapter.this;
                            gdtInterstitalAdapter3.absUbixInfo.setBiddingEcpm(gdtInterstitalAdapter3.OooO0O0.getECPM());
                        }
                        GdtInterstitalAdapter gdtInterstitalAdapter4 = GdtInterstitalAdapter.this;
                        gdtInterstitalAdapter4.loadListener.onAdCacheSuccess(gdtInterstitalAdapter4.absUbixInfo);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onVideoCached() {
                GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                gdtInterstitalAdapter.showLog(gdtInterstitalAdapter.OooO00o, "onVideoCached");
            }
        });
        String videoPlayPolicy = getVideoPlayPolicy();
        videoPlayPolicy.hashCode();
        if (videoPlayPolicy.equals("2")) {
            i = 0;
        } else {
            i = !videoPlayPolicy.equals("3") ? 1 : 2;
        }
        this.OooO0O0.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(i).setAutoPlayMuted(this.isMute).build());
        this.OooO0O0.loadAD();
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        showLog(this.OooO00o, "destory");
        UnifiedInterstitialAD unifiedInterstitialAD = this.OooO0O0;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.OooO0O0;
        if (unifiedInterstitialAD != null) {
            return unifiedInterstitialAD.isValid();
        }
        return false;
    }

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void loadInterstitalAd(Context context, o00O000 o00o000) {
        this.mContext = context;
        this.OooO0Oo = o00o000;
        showLog(this.OooO00o, "loadInterstitalAd mubixSlotId: " + this.adsSlotid);
        createADInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(this.adsSlotid)) {
            GdtInitManager.getInstance().initSDK(context, o00o000, new o00O0OO0() { // from class: com.ubixnow.network.gdt.GdtInterstitalAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = GdtInterstitalAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", GdtInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) GdtInterstitalAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    GdtInterstitalAdapter gdtInterstitalAdapter = GdtInterstitalAdapter.this;
                    gdtInterstitalAdapter.OooO0OO = gdtInterstitalAdapter.getInterstitialType();
                    if (GdtInterstitalAdapter.this.OooO0OO) {
                        GdtInterstitalAdapter.this.OooO00o();
                    } else {
                        GdtInterstitalAdapter.this.OooO0O0();
                    }
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, GdtInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            UnifiedInterstitialAD unifiedInterstitialAD = this.OooO0O0;
            if (unifiedInterstitialAD != null) {
                unifiedInterstitialAD.sendLossNotification(GdtBiddingUtils.getFailInfo(o00oo0oo));
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
            UnifiedInterstitialAD unifiedInterstitialAD = this.OooO0O0;
            if (unifiedInterstitialAD != null) {
                unifiedInterstitialAD.sendWinNotification(GdtBiddingUtils.getSuccMap(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyWin:" + GdtBiddingUtils.getSuccMap(o00oo0oo));
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void show(Activity activity) {
        UnifiedInterstitialAD unifiedInterstitialAD;
        showLog(this.OooO00o, "show ");
        if (activity == null || activity.isFinishing() || (unifiedInterstitialAD = this.OooO0O0) == null) {
            return;
        }
        this.adFlowStatus = 50;
        if (this.OooO0OO) {
            unifiedInterstitialAD.showFullScreenAD(activity);
        } else {
            unifiedInterstitialAD.show(activity);
        }
    }
}
