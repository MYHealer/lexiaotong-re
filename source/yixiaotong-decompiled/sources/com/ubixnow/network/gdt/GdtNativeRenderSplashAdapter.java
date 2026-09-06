package com.ubixnow.network.gdt;

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
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.oo00o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class GdtNativeRenderSplashAdapter extends o000OOo0 {
    private final String OooOoOO = this.customTag + "GdtNativeRenderSplashAdapter";
    private UMNSplashParams OooOoo;
    private GdtNativeAd OooOoo0;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context) {
        oo000o oo000oVar = new oo000o();
        oo000oVar.setAbsBaseAdapter(this);
        oo000oVar.setBaseAdConfig(this.mBaseAdConfig);
        oo000oVar.isMuteIndependent = true;
        oo000oVar.isAutoPlayIndependent = true;
        oo000oVar.adType = "7";
        new GdtNativeAd(context, "7", this.mBaseAdConfig.OooO00o.OooO0o0, oo000oVar).loadNativeAd(new o0O0O00() { // from class: com.ubixnow.network.gdt.GdtNativeRenderSplashAdapter.2
            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdCacheSuccess(oo00o oo00oVar) {
                List<UMNImageInfo> imageUrlList;
                GdtNativeRenderSplashAdapter gdtNativeRenderSplashAdapter = GdtNativeRenderSplashAdapter.this;
                gdtNativeRenderSplashAdapter.inflate("优量汇广告", gdtNativeRenderSplashAdapter.OooOoo);
                GdtNativeRenderSplashAdapter gdtNativeRenderSplashAdapter2 = GdtNativeRenderSplashAdapter.this;
                if (gdtNativeRenderSplashAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    gdtNativeRenderSplashAdapter2.showLog(gdtNativeRenderSplashAdapter2.OooOoOO, "price:" + oo00oVar.getBiddingEcpm());
                    GdtNativeRenderSplashAdapter.this.splashInfo.setBiddingEcpm(oo00oVar.getBiddingEcpm());
                }
                if (oo00oVar instanceof oo000o) {
                    GdtNativeRenderSplashAdapter.this.OooOoo0 = (GdtNativeAd) ((oo000o) oo00oVar).OooO00o.get(0);
                    GdtNativeRenderSplashAdapter gdtNativeRenderSplashAdapter3 = GdtNativeRenderSplashAdapter.this;
                    o000O00O<UMNCustomSplashAdapter> o000o00o = gdtNativeRenderSplashAdapter3.splashInfo;
                    o000o00o.material = oo00oVar.material;
                    o000o00o.materialStatus = oo00oVar.materialStatus;
                    int i = oo00oVar.checkMaterialStatus;
                    o000o00o.checkMaterialStatus = i;
                    if (i > 0) {
                        gdtNativeRenderSplashAdapter3.loadListener.onAdCacheSuccess(oo00oVar);
                        return;
                    }
                    if (Objects.equals(gdtNativeRenderSplashAdapter3.OooOoo0.getAdType(), "1")) {
                        GdtNativeRenderSplashAdapter gdtNativeRenderSplashAdapter4 = GdtNativeRenderSplashAdapter.this;
                        gdtNativeRenderSplashAdapter4.loadImg(gdtNativeRenderSplashAdapter4.OooOoo0.getVideoCoverUrl(), GdtNativeRenderSplashAdapter.this.splashInfo, false);
                        GdtNativeRenderSplashAdapter gdtNativeRenderSplashAdapter5 = GdtNativeRenderSplashAdapter.this;
                        gdtNativeRenderSplashAdapter5.OooO0OO = gdtNativeRenderSplashAdapter5.OooOoo0.getAdMediaView(new Object[0]);
                        GdtNativeRenderSplashAdapter.this.loadListener.onAdCacheSuccess(oo00oVar);
                    } else {
                        String mainImageUrl = GdtNativeRenderSplashAdapter.this.OooOoo0.getMainImageUrl();
                        if (TextUtils.isEmpty(mainImageUrl) && (imageUrlList = GdtNativeRenderSplashAdapter.this.OooOoo0.getImageUrlList()) != null && !imageUrlList.isEmpty()) {
                            mainImageUrl = imageUrlList.get(0).url;
                        }
                        GdtNativeRenderSplashAdapter gdtNativeRenderSplashAdapter6 = GdtNativeRenderSplashAdapter.this;
                        gdtNativeRenderSplashAdapter6.loadImg(mainImageUrl, gdtNativeRenderSplashAdapter6.splashInfo);
                    }
                    GdtNativeRenderSplashAdapter.this.OooOoo0.setNativeEventListener(new UMNNativeEventListener() { // from class: com.ubixnow.network.gdt.GdtNativeRenderSplashAdapter.2.1
                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdClicked() {
                            GdtNativeRenderSplashAdapter gdtNativeRenderSplashAdapter7 = GdtNativeRenderSplashAdapter.this;
                            gdtNativeRenderSplashAdapter7.showLog(gdtNativeRenderSplashAdapter7.OooOoOO, "onAdClicked");
                            GdtNativeRenderSplashAdapter.this.callAdClick();
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdClose() {
                            GdtNativeRenderSplashAdapter gdtNativeRenderSplashAdapter7 = GdtNativeRenderSplashAdapter.this;
                            gdtNativeRenderSplashAdapter7.showLog(gdtNativeRenderSplashAdapter7.OooOoOO, "onAdClose");
                            if (GdtNativeRenderSplashAdapter.this.eventListener != null) {
                                GdtNativeRenderSplashAdapter.this.eventListener.onAdDismiss(GdtNativeRenderSplashAdapter.this.splashInfo);
                            }
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdExposure() {
                            GdtNativeRenderSplashAdapter gdtNativeRenderSplashAdapter7 = GdtNativeRenderSplashAdapter.this;
                            gdtNativeRenderSplashAdapter7.showLog(gdtNativeRenderSplashAdapter7.OooOoOO, "onAdExposure");
                            if (GdtNativeRenderSplashAdapter.this.eventListener != null) {
                                GdtNativeRenderSplashAdapter.this.eventListener.onAdShow(GdtNativeRenderSplashAdapter.this.splashInfo);
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
                GdtNativeRenderSplashAdapter gdtNativeRenderSplashAdapter = GdtNativeRenderSplashAdapter.this;
                gdtNativeRenderSplashAdapter.showLog(gdtNativeRenderSplashAdapter.OooOoOO, "onAdFailed: " + errorInfo.toString());
                o00O00o0 o00o00o0 = GdtNativeRenderSplashAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, errorInfo.platFormCode, errorInfo.platFormMsg).setInfo((Object) GdtNativeRenderSplashAdapter.this.splashInfo));
                }
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onTimeout() {
                GdtNativeRenderSplashAdapter gdtNativeRenderSplashAdapter = GdtNativeRenderSplashAdapter.this;
                gdtNativeRenderSplashAdapter.showLog(gdtNativeRenderSplashAdapter.OooOoOO, "onTimeout");
            }
        });
    }

    @Override // com.ubixnow.ooooo.o000OOo0, com.ubixnow.ooooo.o00OO00O, com.ubixnow.ooooo.o00O
    public void destory() {
        try {
            super.destory();
            GdtNativeAd gdtNativeAd = this.OooOoo0;
            if (gdtNativeAd != null) {
                gdtNativeAd.destroy();
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.o000OOo0
    public ViewGroup getCustomView() {
        return this.OooOoo0.getCustomAdContainer();
    }

    @Override // com.ubixnow.ooooo.o000OOo0
    public View getShakeView(ViewGroup viewGroup) {
        GdtNativeAd gdtNativeAd = this.OooOoo0;
        if (gdtNativeAd != null) {
            return gdtNativeAd.getShakeView(viewGroup);
        }
        return null;
    }

    @Override // com.ubixnow.ooooo.o000OOo0
    public float getVideoWidthHeightRatio() {
        GdtNativeAd gdtNativeAd = this.OooOoo0;
        if (gdtNativeAd == null) {
            return 0.0f;
        }
        int videoWidth = gdtNativeAd.getVideoWidth();
        int videoHeight = this.OooOoo0.getVideoHeight();
        if (videoWidth <= 0 || videoHeight <= 0) {
            return 0.0f;
        }
        return (videoWidth * 1.0f) / videoHeight;
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        GdtNativeAd gdtNativeAd = this.OooOoo0;
        if (gdtNativeAd != null) {
            return gdtNativeAd.isValid();
        }
        return false;
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void loadSplashAd(Context context, o00O000 o00o000) {
        createSplashInfo(o00o000);
        this.OooOoo = (UMNSplashParams) o00o000.OooO0o0;
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            GdtInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.gdt.GdtNativeRenderSplashAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = GdtNativeRenderSplashAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", GdtInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) GdtNativeRenderSplashAdapter.this.splashInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    GdtNativeRenderSplashAdapter.this.loadAd(BaseUtils.getContext());
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
            GdtNativeAd gdtNativeAd = this.OooOoo0;
            if (gdtNativeAd != null) {
                gdtNativeAd.notifyLoss(o00oo0oo);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            GdtNativeAd gdtNativeAd = this.OooOoo0;
            if (gdtNativeAd != null) {
                gdtNativeAd.notifyWin(o00oo0oo);
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
