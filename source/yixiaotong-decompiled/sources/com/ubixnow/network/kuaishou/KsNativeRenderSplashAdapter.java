package com.ubixnow.network.kuaishou;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.ubixnow.adtype.nativead.api.UMNNativeEventListener;
import com.ubixnow.adtype.splash.api.UMNSplashParams;
import com.ubixnow.adtype.splash.custom.UMNCustomSplashAdapter;
import com.ubixnow.core.api.UMNImageInfo;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o000O00O;
import com.ubixnow.ooooo.o000OOo0;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.o0O0O00;
import com.ubixnow.ooooo.oO0O0OoO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.oo00o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class KsNativeRenderSplashAdapter extends o000OOo0 {
    private final String OooOoOO = this.customTag + "KsNativeRenderSplashAdapter";
    private UMNSplashParams OooOoo;
    private KsNativeAd OooOoo0;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context) {
        oo000o oo000oVar = new oo000o();
        oo000oVar.setAbsBaseAdapter(this);
        oo000oVar.setBaseAdConfig(this.mBaseAdConfig);
        oo000oVar.isMuteIndependent = true;
        oo000oVar.isAutoPlayIndependent = true;
        oo000oVar.adType = "7";
        o00O000 o00o000 = this.mBaseAdConfig;
        oO0O0OoO oo0o0ooo = o00o000.OooO00o;
        new KsNativeAd(context, oo0o0ooo.OooO0o0, o00o000.OooOOOO, o00o000.OooOOO0, oo0o0ooo).loadAd("7", oo000oVar, new o0O0O00() { // from class: com.ubixnow.network.kuaishou.KsNativeRenderSplashAdapter.2
            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdCacheSuccess(oo00o oo00oVar) {
                List<UMNImageInfo> imageUrlList;
                KsNativeRenderSplashAdapter ksNativeRenderSplashAdapter = KsNativeRenderSplashAdapter.this;
                ksNativeRenderSplashAdapter.inflate("快手广告", ksNativeRenderSplashAdapter.OooOoo);
                KsNativeRenderSplashAdapter ksNativeRenderSplashAdapter2 = KsNativeRenderSplashAdapter.this;
                o000O00O<UMNCustomSplashAdapter> o000o00o = ksNativeRenderSplashAdapter2.splashInfo;
                o000o00o.material = oo00oVar.material;
                o000o00o.materialStatus = oo00oVar.materialStatus;
                if (ksNativeRenderSplashAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    ksNativeRenderSplashAdapter2.showLog(ksNativeRenderSplashAdapter2.OooOoOO, "price:" + oo00oVar.getBiddingEcpm());
                    KsNativeRenderSplashAdapter ksNativeRenderSplashAdapter3 = KsNativeRenderSplashAdapter.this;
                    o00O000 o00o001 = ksNativeRenderSplashAdapter3.mBaseAdConfig;
                    ksNativeRenderSplashAdapter3.splashInfo.setBiddingEcpm(o00o001.OooO00o.OooOOo0 == 2 ? (int) o00o001.OooOOOo : oo00oVar.getBiddingEcpm());
                }
                if (oo00oVar instanceof oo000o) {
                    KsNativeRenderSplashAdapter.this.OooOoo0 = (KsNativeAd) ((oo000o) oo00oVar).OooO00o.get(0);
                    KsNativeRenderSplashAdapter ksNativeRenderSplashAdapter4 = KsNativeRenderSplashAdapter.this;
                    o000O00O<UMNCustomSplashAdapter> o000o00o2 = ksNativeRenderSplashAdapter4.splashInfo;
                    int i = oo00oVar.checkMaterialStatus;
                    o000o00o2.checkMaterialStatus = i;
                    if (i > 0) {
                        ksNativeRenderSplashAdapter4.loadListener.onAdCacheSuccess(oo00oVar);
                        return;
                    }
                    if (Objects.equals(ksNativeRenderSplashAdapter4.OooOoo0.getAdType(), "1")) {
                        KsNativeRenderSplashAdapter ksNativeRenderSplashAdapter5 = KsNativeRenderSplashAdapter.this;
                        ksNativeRenderSplashAdapter5.loadImg(ksNativeRenderSplashAdapter5.OooOoo0.getVideoCoverUrl(), KsNativeRenderSplashAdapter.this.splashInfo, false);
                        KsNativeRenderSplashAdapter ksNativeRenderSplashAdapter6 = KsNativeRenderSplashAdapter.this;
                        ksNativeRenderSplashAdapter6.OooO0OO = ksNativeRenderSplashAdapter6.OooOoo0.getAdMediaView(new Object[0]);
                        KsNativeRenderSplashAdapter.this.loadListener.onAdCacheSuccess(oo00oVar);
                    } else {
                        String mainImageUrl = KsNativeRenderSplashAdapter.this.OooOoo0.getMainImageUrl();
                        if (TextUtils.isEmpty(mainImageUrl) && (imageUrlList = KsNativeRenderSplashAdapter.this.OooOoo0.getImageUrlList()) != null && !imageUrlList.isEmpty()) {
                            mainImageUrl = imageUrlList.get(0).url;
                        }
                        KsNativeRenderSplashAdapter ksNativeRenderSplashAdapter7 = KsNativeRenderSplashAdapter.this;
                        ksNativeRenderSplashAdapter7.loadImg(mainImageUrl, ksNativeRenderSplashAdapter7.splashInfo);
                    }
                    KsNativeRenderSplashAdapter.this.OooOoo0.setNativeEventListener(new UMNNativeEventListener() { // from class: com.ubixnow.network.kuaishou.KsNativeRenderSplashAdapter.2.1
                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdClicked() {
                            KsNativeRenderSplashAdapter ksNativeRenderSplashAdapter8 = KsNativeRenderSplashAdapter.this;
                            ksNativeRenderSplashAdapter8.showLog(ksNativeRenderSplashAdapter8.OooOoOO, "onAdClicked");
                            KsNativeRenderSplashAdapter.this.callAdClick();
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdClose() {
                            KsNativeRenderSplashAdapter ksNativeRenderSplashAdapter8 = KsNativeRenderSplashAdapter.this;
                            ksNativeRenderSplashAdapter8.showLog(ksNativeRenderSplashAdapter8.OooOoOO, "onAdClose");
                            if (KsNativeRenderSplashAdapter.this.eventListener != null) {
                                KsNativeRenderSplashAdapter.this.eventListener.onAdDismiss(KsNativeRenderSplashAdapter.this.splashInfo);
                            }
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdExposure() {
                            KsNativeRenderSplashAdapter ksNativeRenderSplashAdapter8 = KsNativeRenderSplashAdapter.this;
                            ksNativeRenderSplashAdapter8.showLog(ksNativeRenderSplashAdapter8.OooOoOO, "onAdExposure");
                            if (KsNativeRenderSplashAdapter.this.eventListener != null) {
                                KsNativeRenderSplashAdapter.this.eventListener.onAdShow(KsNativeRenderSplashAdapter.this.splashInfo);
                            }
                        }
                    });
                }
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdDataLoaded(oo00o oo00oVar) {
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdRenderFail(ErrorInfo errorInfo) {
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onNoAdError(ErrorInfo errorInfo) {
                KsNativeRenderSplashAdapter ksNativeRenderSplashAdapter = KsNativeRenderSplashAdapter.this;
                ksNativeRenderSplashAdapter.showLog(ksNativeRenderSplashAdapter.OooOoOO, "onAdFailed: " + errorInfo.toString());
                o00O00o0 o00o00o0 = KsNativeRenderSplashAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, errorInfo.platFormCode, errorInfo.platFormMsg).setInfo((Object) KsNativeRenderSplashAdapter.this.splashInfo));
                }
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onTimeout() {
                KsNativeRenderSplashAdapter ksNativeRenderSplashAdapter = KsNativeRenderSplashAdapter.this;
                ksNativeRenderSplashAdapter.showLog(ksNativeRenderSplashAdapter.OooOoOO, "onTimeout");
            }
        });
    }

    @Override // com.ubixnow.ooooo.o000OOo0, com.ubixnow.ooooo.o00OO00O, com.ubixnow.ooooo.o00O
    public void destory() {
        try {
            super.destory();
            KsNativeAd ksNativeAd = this.OooOoo0;
            if (ksNativeAd != null) {
                ksNativeAd.destroy();
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.o000OOo0
    public ViewGroup getCustomView() {
        return this.OooOoo0.getCustomAdContainer();
    }

    @Override // com.ubixnow.ooooo.o00O
    public void getServerBiddingToken(Context context, o00O000 o00o000, Object... objArr) {
        createSplashInfo(o00o000);
        KsInitManager.getInstance().getBiddingToken(context, o00o000, this.splashInfo, this.loadListener);
    }

    @Override // com.ubixnow.ooooo.o000OOo0
    public View getShakeView(ViewGroup viewGroup) {
        KsNativeAd ksNativeAd = this.OooOoo0;
        if (ksNativeAd != null) {
            return ksNativeAd.getShakeView(viewGroup);
        }
        return null;
    }

    @Override // com.ubixnow.ooooo.o000OOo0
    public float getVideoWidthHeightRatio() {
        KsNativeAd ksNativeAd = this.OooOoo0;
        if (ksNativeAd == null) {
            return 0.0f;
        }
        int videoWidth = ksNativeAd.getVideoWidth();
        int videoHeight = this.OooOoo0.getVideoHeight();
        if (videoWidth <= 0 || videoHeight <= 0) {
            return 0.0f;
        }
        return (videoWidth * 1.0f) / videoHeight;
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void loadSplashAd(final Context context, o00O000 o00o000) {
        createSplashInfo(o00o000);
        this.OooOoo = (UMNSplashParams) o00o000.OooO0o0;
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            KsInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.kuaishou.KsNativeRenderSplashAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = KsNativeRenderSplashAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", KsInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) KsNativeRenderSplashAdapter.this.splashInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    KsNativeRenderSplashAdapter.this.loadAd(context);
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
            KsNativeAd ksNativeAd = this.OooOoo0;
            if (ksNativeAd != null) {
                ksNativeAd.notifyClick();
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            KsNativeAd ksNativeAd = this.OooOoo0;
            if (ksNativeAd != null) {
                ksNativeAd.notifyLoss(o00oo0oo);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyShow() {
        try {
            KsNativeAd ksNativeAd = this.OooOoo0;
            if (ksNativeAd != null) {
                ksNativeAd.notifyShow();
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            KsNativeAd ksNativeAd = this.OooOoo0;
            if (ksNativeAd != null) {
                ksNativeAd.notifyWin(o00oo0oo);
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.o000OOo0
    public void regist(ViewGroup viewGroup) {
        super.regist(viewGroup);
        this.OooOoo0.regist(viewGroup, this.OooOOOo);
    }
}
