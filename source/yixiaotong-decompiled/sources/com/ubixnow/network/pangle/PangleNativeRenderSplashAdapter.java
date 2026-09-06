package com.ubixnow.network.pangle;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.ubixnow.adtype.nativead.api.UMNNativeEventListener;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.adtype.splash.api.UMNSplashParams;
import com.ubixnow.adtype.splash.custom.UMNCustomSplashAdapter;
import com.ubixnow.core.api.UMNImageInfo;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o000O00O;
import com.ubixnow.ooooo.o000OOo0;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o0O0O00;
import com.ubixnow.ooooo.oOO00000;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.oo00o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class PangleNativeRenderSplashAdapter extends o000OOo0 {
    private final String OooOoOO = this.customTag + "PangleNativeRenderSplashAdapter";
    private UMNSplashParams OooOoo;
    private PangleNativeAd OooOoo0;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context) {
        oo000o oo000oVar = new oo000o();
        oo000oVar.setAbsBaseAdapter(this);
        oo000oVar.setBaseAdConfig(this.mBaseAdConfig);
        oo000oVar.isMuteIndependent = true;
        oo000oVar.isAutoPlayIndependent = true;
        oo000oVar.adType = "7";
        new PangleNativeAd(context, new UMNNativeParams.Builder().setSlotId(this.mBaseAdConfig.OooO00o.OooO0o0).setHeight(oOO00000.OooO00o(this.OooOoo.height)).setWidth(oOO00000.OooO00o(this.OooOoo.width)).build(), this.mBaseAdConfig.OooO00o.OooO0o0, oo000oVar).loadAd("7", oo000oVar, new o0O0O00() { // from class: com.ubixnow.network.pangle.PangleNativeRenderSplashAdapter.2
            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdCacheSuccess(oo00o oo00oVar) {
                List<UMNImageInfo> imageUrlList;
                PangleNativeRenderSplashAdapter pangleNativeRenderSplashAdapter = PangleNativeRenderSplashAdapter.this;
                pangleNativeRenderSplashAdapter.inflate("穿山甲广告", pangleNativeRenderSplashAdapter.OooOoo);
                PangleNativeRenderSplashAdapter pangleNativeRenderSplashAdapter2 = PangleNativeRenderSplashAdapter.this;
                if (pangleNativeRenderSplashAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    pangleNativeRenderSplashAdapter2.showLog(pangleNativeRenderSplashAdapter2.OooOoOO, "price:" + oo00oVar.getBiddingEcpm());
                    PangleNativeRenderSplashAdapter.this.splashInfo.setBiddingEcpm(oo00oVar.getBiddingEcpm());
                }
                if (oo00oVar instanceof oo000o) {
                    PangleNativeRenderSplashAdapter.this.OooOoo0 = (PangleNativeAd) ((oo000o) oo00oVar).OooO00o.get(0);
                    PangleNativeRenderSplashAdapter pangleNativeRenderSplashAdapter3 = PangleNativeRenderSplashAdapter.this;
                    o000O00O<UMNCustomSplashAdapter> o000o00o = pangleNativeRenderSplashAdapter3.splashInfo;
                    o000o00o.material = oo00oVar.material;
                    o000o00o.materialStatus = oo00oVar.materialStatus;
                    int i = oo00oVar.checkMaterialStatus;
                    o000o00o.checkMaterialStatus = i;
                    if (i > 0) {
                        pangleNativeRenderSplashAdapter3.loadListener.onAdCacheSuccess(oo00oVar);
                        return;
                    }
                    if (pangleNativeRenderSplashAdapter3.OooOoo0.getAdType().equals("1")) {
                        PangleNativeRenderSplashAdapter pangleNativeRenderSplashAdapter4 = PangleNativeRenderSplashAdapter.this;
                        pangleNativeRenderSplashAdapter4.loadImg(pangleNativeRenderSplashAdapter4.OooOoo0.getVideoCoverUrl(), PangleNativeRenderSplashAdapter.this.splashInfo, false);
                        PangleNativeRenderSplashAdapter pangleNativeRenderSplashAdapter5 = PangleNativeRenderSplashAdapter.this;
                        pangleNativeRenderSplashAdapter5.OooO0OO = pangleNativeRenderSplashAdapter5.OooOoo0.getAdMediaView(new Object[0]);
                        PangleNativeRenderSplashAdapter.this.loadListener.onAdCacheSuccess(oo00oVar);
                    } else {
                        String mainImageUrl = PangleNativeRenderSplashAdapter.this.OooOoo0.getMainImageUrl();
                        if (TextUtils.isEmpty(mainImageUrl) && (imageUrlList = PangleNativeRenderSplashAdapter.this.OooOoo0.getImageUrlList()) != null && !imageUrlList.isEmpty()) {
                            mainImageUrl = imageUrlList.get(0).url;
                        }
                        PangleNativeRenderSplashAdapter pangleNativeRenderSplashAdapter6 = PangleNativeRenderSplashAdapter.this;
                        pangleNativeRenderSplashAdapter6.loadImg(mainImageUrl, pangleNativeRenderSplashAdapter6.splashInfo);
                    }
                    PangleNativeRenderSplashAdapter.this.OooOoo0.setNativeEventListener(new UMNNativeEventListener() { // from class: com.ubixnow.network.pangle.PangleNativeRenderSplashAdapter.2.1
                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdClicked() {
                            PangleNativeRenderSplashAdapter pangleNativeRenderSplashAdapter7 = PangleNativeRenderSplashAdapter.this;
                            pangleNativeRenderSplashAdapter7.showLog(pangleNativeRenderSplashAdapter7.OooOoOO, "onAdClicked");
                            PangleNativeRenderSplashAdapter.this.callAdClick();
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdClose() {
                            PangleNativeRenderSplashAdapter pangleNativeRenderSplashAdapter7 = PangleNativeRenderSplashAdapter.this;
                            pangleNativeRenderSplashAdapter7.showLog(pangleNativeRenderSplashAdapter7.OooOoOO, "onAdClose");
                            if (PangleNativeRenderSplashAdapter.this.eventListener != null) {
                                PangleNativeRenderSplashAdapter.this.eventListener.onAdDismiss(PangleNativeRenderSplashAdapter.this.splashInfo);
                            }
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdExposure() {
                            PangleNativeRenderSplashAdapter pangleNativeRenderSplashAdapter7 = PangleNativeRenderSplashAdapter.this;
                            pangleNativeRenderSplashAdapter7.showLog(pangleNativeRenderSplashAdapter7.OooOoOO, "onAdExposure");
                            if (PangleNativeRenderSplashAdapter.this.eventListener != null) {
                                PangleNativeRenderSplashAdapter.this.eventListener.onAdShow(PangleNativeRenderSplashAdapter.this.splashInfo);
                            }
                        }
                    });
                }
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdDataLoaded(oo00o oo00oVar) {
                PangleNativeRenderSplashAdapter pangleNativeRenderSplashAdapter = PangleNativeRenderSplashAdapter.this;
                pangleNativeRenderSplashAdapter.showLog(pangleNativeRenderSplashAdapter.OooOoOO, "onAdDataLoaded: ");
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdRenderFail(ErrorInfo errorInfo) {
                PangleNativeRenderSplashAdapter pangleNativeRenderSplashAdapter = PangleNativeRenderSplashAdapter.this;
                pangleNativeRenderSplashAdapter.showLog(pangleNativeRenderSplashAdapter.OooOoOO, "onAdRenderFail: " + errorInfo.toString());
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onNoAdError(ErrorInfo errorInfo) {
                PangleNativeRenderSplashAdapter pangleNativeRenderSplashAdapter = PangleNativeRenderSplashAdapter.this;
                pangleNativeRenderSplashAdapter.showLog(pangleNativeRenderSplashAdapter.OooOoOO, "onAdFailed: " + errorInfo.toString());
                o00O00o0 o00o00o0 = PangleNativeRenderSplashAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, errorInfo.platFormCode, errorInfo.platFormMsg).setInfo((Object) PangleNativeRenderSplashAdapter.this.splashInfo));
                }
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onTimeout() {
                PangleNativeRenderSplashAdapter pangleNativeRenderSplashAdapter = PangleNativeRenderSplashAdapter.this;
                pangleNativeRenderSplashAdapter.showLog(pangleNativeRenderSplashAdapter.OooOoOO, "onTimeout");
            }
        });
    }

    @Override // com.ubixnow.ooooo.o000OOo0, com.ubixnow.ooooo.o00OO00O, com.ubixnow.ooooo.o00O
    public void destory() {
        try {
            super.destory();
            PangleNativeAd pangleNativeAd = this.OooOoo0;
            if (pangleNativeAd != null) {
                pangleNativeAd.destroy();
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.o000OOo0
    public View getShakeView(ViewGroup viewGroup) {
        PangleNativeAd pangleNativeAd = this.OooOoo0;
        if (pangleNativeAd != null) {
            return pangleNativeAd.getShakeView(viewGroup);
        }
        return null;
    }

    @Override // com.ubixnow.ooooo.o000OOo0
    public float getVideoWidthHeightRatio() {
        PangleNativeAd pangleNativeAd = this.OooOoo0;
        if (pangleNativeAd == null) {
            return 0.0f;
        }
        int videoWidth = pangleNativeAd.getVideoWidth();
        int videoHeight = this.OooOoo0.getVideoHeight();
        if (videoWidth <= 0 || videoHeight <= 0) {
            return 0.0f;
        }
        return (videoWidth * 1.0f) / videoHeight;
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        PangleNativeAd pangleNativeAd = this.OooOoo0;
        if (pangleNativeAd != null) {
            return pangleNativeAd.isValid();
        }
        return false;
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void loadSplashAd(final Context context, o00O000 o00o000) {
        createSplashInfo(o00o000);
        this.OooOoo = (UMNSplashParams) o00o000.OooO0o0;
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            PangleInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.pangle.PangleNativeRenderSplashAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = PangleNativeRenderSplashAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", PangleInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) PangleNativeRenderSplashAdapter.this.splashInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    PangleNativeRenderSplashAdapter.this.loadAd(context);
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, PangleInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.splashInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o000OOo0
    public void regist(ViewGroup viewGroup) {
        super.regist(viewGroup);
        this.OooOoo0.regist(viewGroup, this.OooOOOo);
    }
}
