package com.ubixnow.network.kuaishou;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.stub.StubApp;
import com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class KsInterstitalAdapter extends UMNCustomInterstitalAdapter {
    private final String OooO00o = this.customTag + KsInitManager.getInstance().getName();
    private KsInterstitialAd OooO0O0;
    private o00O000 OooO0OO;
    private AdExposureFailedReason OooO0Oo;

    private void OooO00o(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        KsInterstitialAd ksInterstitialAd = this.OooO0O0;
        if (ksInterstitialAd != null) {
            ksInterstitialAd.setAdInteractionListener(new KsInterstitialAd.AdInteractionListener() { // from class: com.ubixnow.network.kuaishou.KsInterstitalAdapter.3
                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onAdClicked() {
                    KsInterstitalAdapter ksInterstitalAdapter = KsInterstitalAdapter.this;
                    ksInterstitalAdapter.showLog(ksInterstitalAdapter.OooO00o, "--onAdClicked: " + (KsInterstitalAdapter.this.eventListener != null));
                    if (KsInterstitalAdapter.this.eventListener != null) {
                        KsInterstitalAdapter.this.eventListener.onAdClick(KsInterstitalAdapter.this.absUbixInfo);
                    }
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onAdClosed() {
                    KsInterstitalAdapter ksInterstitalAdapter = KsInterstitalAdapter.this;
                    ksInterstitalAdapter.showLog(ksInterstitalAdapter.OooO00o, "--onAdClosed: ");
                    if (KsInterstitalAdapter.this.eventListener != null) {
                        KsInterstitalAdapter.this.eventListener.onAdDismiss(KsInterstitalAdapter.this.absUbixInfo);
                    }
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onAdShow() {
                    KsInterstitalAdapter ksInterstitalAdapter = KsInterstitalAdapter.this;
                    ksInterstitalAdapter.showLog(ksInterstitalAdapter.OooO00o, "--onAdShow: " + (KsInterstitalAdapter.this.eventListener != null));
                    if (KsInterstitalAdapter.this.eventListener != null) {
                        KsInterstitalAdapter.this.eventListener.onAdShow(KsInterstitalAdapter.this.absUbixInfo);
                    }
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onPageDismiss() {
                    KsInterstitalAdapter ksInterstitalAdapter = KsInterstitalAdapter.this;
                    ksInterstitalAdapter.showLog(ksInterstitalAdapter.OooO00o, "--onPageDismiss: ");
                    if (KsInterstitalAdapter.this.eventListener != null) {
                        KsInterstitalAdapter.this.eventListener.onAdDismiss(KsInterstitalAdapter.this.absUbixInfo);
                    }
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onSkippedAd() {
                    KsInterstitalAdapter ksInterstitalAdapter = KsInterstitalAdapter.this;
                    ksInterstitalAdapter.showLog(ksInterstitalAdapter.OooO00o, "--onSkippedAd: ");
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onVideoPlayEnd() {
                    KsInterstitalAdapter ksInterstitalAdapter = KsInterstitalAdapter.this;
                    ksInterstitalAdapter.showLog(ksInterstitalAdapter.OooO00o, "--onVideoPlayEnd: ");
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onVideoPlayError(int i, int i2) {
                    if (KsInterstitalAdapter.this.eventListener != null) {
                        KsInterstitalAdapter.this.eventListener.onShowError(new ErrorInfo(i + "", i2 + "").setInfo((Object) KsInterstitalAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onVideoPlayStart() {
                    KsInterstitalAdapter ksInterstitalAdapter = KsInterstitalAdapter.this;
                    ksInterstitalAdapter.showLog(ksInterstitalAdapter.OooO00o, "--onVideoPlayStart: ");
                }
            });
            this.OooO0O0.showInterstitialAd(activity, ksVideoPlayConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd() {
        KsScene ksSceneBuild = new KsScene.Builder(KsInitManager.getKSLongValue(this.adsSlotid)).adNum(1).build();
        showLog(this.OooO00o, "mubixSlotId：" + this.adsSlotid);
        KsAdSDK.getLoadManager().loadInterstitialAd(ksSceneBuild, new KsLoadManager.InterstitialAdListener() { // from class: com.ubixnow.network.kuaishou.KsInterstitalAdapter.2
            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            public void onError(int i, String str) {
                KsInterstitalAdapter ksInterstitalAdapter = KsInterstitalAdapter.this;
                ksInterstitalAdapter.showLog(ksInterstitalAdapter.OooO00o, "onError: code" + i + " msg:" + str);
                o00O00o0 o00o00o0 = KsInterstitalAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str).setInfo((Object) KsInterstitalAdapter.this.absUbixInfo));
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            public void onInterstitialAdLoad(List<KsInterstitialAd> list) {
                try {
                    KsInterstitalAdapter ksInterstitalAdapter = KsInterstitalAdapter.this;
                    ksInterstitalAdapter.showLog(ksInterstitalAdapter.OooO00o, "onInterstitialAdLoad " + list.size());
                    KsInterstitalAdapter.this.OooO0O0 = list.get(0);
                    KsInterstitalAdapter.this.OooO0O0.getECPM();
                    KsInterstitalAdapter ksInterstitalAdapter2 = KsInterstitalAdapter.this;
                    ksInterstitalAdapter2.absUbixInfo.material = KsUtils.getMaterialInfo(ksInterstitalAdapter2.OooO0O0);
                    KsInterstitalAdapter ksInterstitalAdapter3 = KsInterstitalAdapter.this;
                    if (ksInterstitalAdapter3.loadListener != null) {
                        if (ksInterstitalAdapter3.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            ksInterstitalAdapter3.showLog(ksInterstitalAdapter3.OooO00o, "price:" + KsInterstitalAdapter.this.OooO0O0.getECPM());
                            KsInterstitalAdapter ksInterstitalAdapter4 = KsInterstitalAdapter.this;
                            ksInterstitalAdapter4.absUbixInfo.setBiddingEcpm(ksInterstitalAdapter4.OooO0O0.getECPM());
                            KsInterstitalAdapter.this.onAdDataLoaded();
                        }
                        KsInterstitalAdapter ksInterstitalAdapter5 = KsInterstitalAdapter.this;
                        ksInterstitalAdapter5.loadListener.onAdCacheSuccess(ksInterstitalAdapter5.absUbixInfo);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            public void onRequestResult(int i) {
                KsInterstitalAdapter ksInterstitalAdapter = KsInterstitalAdapter.this;
                ksInterstitalAdapter.showLog(ksInterstitalAdapter.OooO00o, "onRequestResult ");
                KsInterstitalAdapter ksInterstitalAdapter2 = KsInterstitalAdapter.this;
                if (ksInterstitalAdapter2.mBaseAdConfig.OooO00o.OooOO0O != 1) {
                    ksInterstitalAdapter2.onAdDataLoaded();
                }
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
    }

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void loadInterstitalAd(Context context, o00O000 o00o000) {
        this.mContext = context;
        this.OooO0OO = o00o000;
        createADInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(this.adsSlotid)) {
            KsInitManager.getInstance().initSDK(StubApp.getOrigApplicationContext(context.getApplicationContext()), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.kuaishou.KsInterstitalAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = KsInterstitalAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", KsInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) KsInterstitalAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    KsInterstitalAdapter.this.loadAd();
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, KsInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
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

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void show(Activity activity) {
        OooO00o(activity, new KsVideoPlayConfig.Builder().videoSoundEnable(!this.isMute).build());
    }
}
