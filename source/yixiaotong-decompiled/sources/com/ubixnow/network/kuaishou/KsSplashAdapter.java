package com.ubixnow.network.kuaishou;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.SplashAdExtraData;
import com.stub.StubApp;
import com.ubixnow.adtype.splash.custom.UMNCustomSplashAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o000O00O;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oO00000o;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class KsSplashAdapter extends UMNCustomSplashAdapter {
    private final String OooO00o = this.customTag + KsInitManager.getInstance().getName();
    private KsSplashScreenAd OooO0O0;
    private Context OooO0OO;
    private AdExposureFailedReason OooO0Oo;
    private View OooO0o0;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd() {
        showLog(this.OooO00o, "start loadAd");
        KsScene.Builder builderAdNum = new KsScene.Builder(KsInitManager.getKSLongValue(this.mBaseAdConfig.OooO00o.OooO0o0)).adNum(1);
        SplashAdExtraData splashAdExtraData = new SplashAdExtraData();
        splashAdExtraData.setDisableShakeStatus(!oO00000o.o00O0O.OooOOOo);
        splashAdExtraData.setDisableRotateStatus(true ^ oO00000o.o00O0O.OooOOOo);
        builderAdNum.setSplashExtraData(splashAdExtraData);
        if (!TextUtils.isEmpty(this.mBaseAdConfig.OooOOOO)) {
            builderAdNum.setBidResponse(this.mBaseAdConfig.OooOOOO);
        }
        KsAdSDK.getLoadManager().loadSplashScreenAd(builderAdNum.build(), new KsLoadManager.SplashScreenAdListener() { // from class: com.ubixnow.network.kuaishou.KsSplashAdapter.2
            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onError(int i, String str) {
                KsSplashAdapter ksSplashAdapter = KsSplashAdapter.this;
                ksSplashAdapter.showLog(ksSplashAdapter.OooO00o, "onError: code" + i + " msg:" + str);
                KsSplashAdapter ksSplashAdapter2 = KsSplashAdapter.this;
                if (ksSplashAdapter2.adFlowStatus == 10) {
                    ksSplashAdapter2.onRenderFail(i, str);
                } else {
                    ksSplashAdapter2.onAdDataLoadFailed(i + "", str);
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onRequestResult(int i) {
                KsSplashAdapter ksSplashAdapter = KsSplashAdapter.this;
                ksSplashAdapter.showLog(ksSplashAdapter.OooO00o, "onRequestResult");
                KsSplashAdapter ksSplashAdapter2 = KsSplashAdapter.this;
                ksSplashAdapter2.adFlowStatus = 10;
                if (ksSplashAdapter2.mBaseAdConfig.OooO00o.OooOO0O != 1) {
                    ksSplashAdapter2.onAdDataLoaded();
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
                int ecpm;
                o000O00O<UMNCustomSplashAdapter> o000o00o;
                KsSplashAdapter ksSplashAdapter = KsSplashAdapter.this;
                ksSplashAdapter.showLog(ksSplashAdapter.OooO00o, "onSplashScreenAdLoad");
                KsSplashAdapter.this.OooO0O0 = ksSplashScreenAd;
                try {
                    KsSplashAdapter ksSplashAdapter2 = KsSplashAdapter.this;
                    if (ksSplashAdapter2.loadListener != null) {
                        if (ksSplashAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            ksSplashAdapter2.showLog(ksSplashAdapter2.OooO00o, "price:" + KsSplashAdapter.this.OooO0O0.getECPM());
                            KsSplashAdapter ksSplashAdapter3 = KsSplashAdapter.this;
                            o00O000 o00o000 = ksSplashAdapter3.mBaseAdConfig;
                            if (o00o000.OooO00o.OooOOo0 == 2) {
                                o000o00o = ksSplashAdapter3.splashInfo;
                                ecpm = (int) o00o000.OooOOOo;
                            } else {
                                o000O00O<UMNCustomSplashAdapter> o000o00o2 = ksSplashAdapter3.splashInfo;
                                ecpm = ksSplashAdapter3.OooO0O0.getECPM();
                                o000o00o = o000o00o2;
                            }
                            o000o00o.setBiddingEcpm(ecpm);
                            KsSplashAdapter.this.onAdDataLoaded();
                        }
                        KsSplashAdapter ksSplashAdapter4 = KsSplashAdapter.this;
                        ksSplashAdapter4.splashInfo.material = KsUtils.getMaterialInfo(ksSplashAdapter4.OooO0O0);
                        KsSplashAdapter ksSplashAdapter5 = KsSplashAdapter.this;
                        ksSplashAdapter5.loadListener.onAdCacheSuccess(ksSplashAdapter5.splashInfo);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00OO00O, com.ubixnow.ooooo.o00O
    public void destory() {
        showLog(this.OooO00o, "destroy");
        try {
            View view = this.OooO0o0;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) this.OooO0o0.getParent()).removeAllViews();
            }
            this.OooO0o0 = null;
        } catch (Exception unused) {
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public void getServerBiddingToken(Context context, o00O000 o00o000, Object... objArr) {
        this.OooO0OO = StubApp.getOrigApplicationContext(context.getApplicationContext());
        createSplashInfo(o00o000);
        KsInitManager.getInstance().getBiddingToken(context, o00o000, this.splashInfo, this.loadListener);
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        KsSplashScreenAd ksSplashScreenAd = this.OooO0O0;
        if (ksSplashScreenAd != null) {
            return ksSplashScreenAd.isAdEnable();
        }
        return false;
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void loadSplashAd(Context context, o00O000 o00o000) {
        this.OooO0OO = StubApp.getOrigApplicationContext(context.getApplicationContext());
        createSplashInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            KsInitManager.getInstance().initSDK(StubApp.getOrigApplicationContext(context.getApplicationContext()), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.kuaishou.KsSplashAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = KsSplashAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", KsInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) KsSplashAdapter.this.splashInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    KsSplashAdapter.this.loadAd();
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, KsInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.splashInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyClick() {
        try {
            KsBiddingUtils.notifyClick(this.adsSlotid, this.OooO0Oo, this.OooO0O0);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            this.OooO0Oo = KsBiddingUtils.notifyLoss(this.adsSlotid, o00oo0oo, this.OooO0O0);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyShow() {
        try {
            KsBiddingUtils.notifyShow(this.adsSlotid, this.OooO0Oo, this.OooO0O0);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            KsBiddingUtils.notifyWin(o00oo0oo, this.OooO0O0);
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void show(ViewGroup viewGroup) {
        boolean z = true;
        showLog(this.OooO00o, "show: splashScreenAd" + (this.OooO0O0 == null) + "  group:" + (viewGroup == null) + "mContext: " + (this.OooO0OO == null));
        if (this.OooO0O0 == null || viewGroup == null || this.OooO0OO == null) {
            return;
        }
        showLog(this.OooO00o, "getView");
        if (viewGroup.getContext() != null) {
            showLog(this.OooO00o, "group.getContext() is Activity?" + (viewGroup.getContext() instanceof Activity));
        }
        this.OooO0o0 = this.OooO0O0.getView(this.OooO0OO, new KsSplashScreenAd.SplashScreenAdInteractionListener() { // from class: com.ubixnow.network.kuaishou.KsSplashAdapter.3
            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdClicked() {
                KsSplashAdapter ksSplashAdapter = KsSplashAdapter.this;
                ksSplashAdapter.showLog(ksSplashAdapter.OooO00o, "onAdClicked");
                if (KsSplashAdapter.this.eventListener != null) {
                    KsSplashAdapter.this.eventListener.onAdClick(KsSplashAdapter.this.splashInfo);
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowEnd() {
                KsSplashAdapter ksSplashAdapter = KsSplashAdapter.this;
                ksSplashAdapter.showLog(ksSplashAdapter.OooO00o, "onAdShowEnd");
                if (KsSplashAdapter.this.eventListener != null) {
                    KsSplashAdapter ksSplashAdapter2 = KsSplashAdapter.this;
                    ksSplashAdapter2.splashInfo.OooO00o = false;
                    ksSplashAdapter2.eventListener.onAdDismiss(KsSplashAdapter.this.splashInfo);
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowError(int i, String str) {
                KsSplashAdapter ksSplashAdapter = KsSplashAdapter.this;
                ksSplashAdapter.showLog(ksSplashAdapter.OooO00o, "onAdShowError code:" + i + " msg:" + str);
                if (KsSplashAdapter.this.eventListener != null) {
                    KsSplashAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, i + "", str).setInfo((Object) KsSplashAdapter.this.splashInfo));
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowStart() {
                KsSplashAdapter ksSplashAdapter = KsSplashAdapter.this;
                ksSplashAdapter.showLog(ksSplashAdapter.OooO00o, "onAdShowStart");
                if (KsSplashAdapter.this.eventListener != null) {
                    KsSplashAdapter.this.eventListener.onAdShow(KsSplashAdapter.this.splashInfo);
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogCancel() {
                KsSplashAdapter ksSplashAdapter = KsSplashAdapter.this;
                ksSplashAdapter.showLog(ksSplashAdapter.OooO00o, "onDownloadTipsDialogCancel");
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogDismiss() {
                KsSplashAdapter ksSplashAdapter = KsSplashAdapter.this;
                ksSplashAdapter.showLog(ksSplashAdapter.OooO00o, "onDownloadTipsDialogDismiss");
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogShow() {
                KsSplashAdapter ksSplashAdapter = KsSplashAdapter.this;
                ksSplashAdapter.showLog(ksSplashAdapter.OooO00o, "onDownloadTipsDialogShow");
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onSkippedAd() {
                KsSplashAdapter ksSplashAdapter = KsSplashAdapter.this;
                ksSplashAdapter.showLog(ksSplashAdapter.OooO00o, "onSkippedAd");
                if (KsSplashAdapter.this.eventListener != null) {
                    KsSplashAdapter ksSplashAdapter2 = KsSplashAdapter.this;
                    ksSplashAdapter2.splashInfo.OooO00o = true;
                    ksSplashAdapter2.eventListener.onAdDismiss(KsSplashAdapter.this.splashInfo);
                }
            }
        });
        try {
            String str = this.OooO00o;
            StringBuilder sb = new StringBuilder("view is null?");
            if (this.OooO0o0 != null) {
                z = false;
            }
            showLog(str, sb.append(z).toString());
            View view = this.OooO0o0;
            if (view != null) {
                viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }
}
