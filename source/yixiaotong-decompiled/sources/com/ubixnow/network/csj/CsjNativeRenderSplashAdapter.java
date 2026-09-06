package com.ubixnow.network.csj;

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
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.o0O0O00;
import com.ubixnow.ooooo.oOO00000;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.oo00o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class CsjNativeRenderSplashAdapter extends o000OOo0 {
    private final String OooOoOO = this.customTag + "CsjNativeRenderSplashAdapter";
    private UMNSplashParams OooOoo;
    private CsjNativeAd OooOoo0;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context) {
        oo000o oo000oVar = new oo000o();
        oo000oVar.setAbsBaseAdapter(this);
        oo000oVar.setBaseAdConfig(this.mBaseAdConfig);
        oo000oVar.isMuteIndependent = true;
        oo000oVar.isAutoPlayIndependent = true;
        oo000oVar.adType = "7";
        new CsjNativeAd(context, new UMNNativeParams.Builder().setSlotId(this.mBaseAdConfig.OooO00o.OooO0o0).setHeight(oOO00000.OooO00o(this.OooOoo.height)).setWidth(oOO00000.OooO00o(this.OooOoo.width)).build(), this.mBaseAdConfig.OooO00o.OooO0o0, oo000oVar).loadAd("7", oo000oVar, new o0O0O00() { // from class: com.ubixnow.network.csj.CsjNativeRenderSplashAdapter.2
            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdCacheSuccess(oo00o oo00oVar) {
                List<UMNImageInfo> imageUrlList;
                CsjNativeRenderSplashAdapter csjNativeRenderSplashAdapter = CsjNativeRenderSplashAdapter.this;
                csjNativeRenderSplashAdapter.inflate("穿山甲广告", csjNativeRenderSplashAdapter.OooOoo);
                CsjNativeRenderSplashAdapter csjNativeRenderSplashAdapter2 = CsjNativeRenderSplashAdapter.this;
                if (csjNativeRenderSplashAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    csjNativeRenderSplashAdapter2.showLog(csjNativeRenderSplashAdapter2.OooOoOO, "price:" + oo00oVar.getBiddingEcpm());
                    CsjNativeRenderSplashAdapter.this.splashInfo.setBiddingEcpm(oo00oVar.getBiddingEcpm());
                }
                if (oo00oVar instanceof oo000o) {
                    CsjNativeRenderSplashAdapter.this.OooOoo0 = (CsjNativeAd) ((oo000o) oo00oVar).OooO00o.get(0);
                    CsjNativeRenderSplashAdapter csjNativeRenderSplashAdapter3 = CsjNativeRenderSplashAdapter.this;
                    o000O00O<UMNCustomSplashAdapter> o000o00o = csjNativeRenderSplashAdapter3.splashInfo;
                    o000o00o.material = oo00oVar.material;
                    o000o00o.materialStatus = oo00oVar.materialStatus;
                    int i = oo00oVar.checkMaterialStatus;
                    o000o00o.checkMaterialStatus = i;
                    if (i > 0) {
                        csjNativeRenderSplashAdapter3.loadListener.onAdCacheSuccess(oo00oVar);
                        return;
                    }
                    if (Objects.equals(csjNativeRenderSplashAdapter3.OooOoo0.getAdType(), "1")) {
                        CsjNativeRenderSplashAdapter csjNativeRenderSplashAdapter4 = CsjNativeRenderSplashAdapter.this;
                        csjNativeRenderSplashAdapter4.loadImg(csjNativeRenderSplashAdapter4.OooOoo0.getVideoCoverUrl(), CsjNativeRenderSplashAdapter.this.splashInfo, false);
                        CsjNativeRenderSplashAdapter csjNativeRenderSplashAdapter5 = CsjNativeRenderSplashAdapter.this;
                        csjNativeRenderSplashAdapter5.OooO0OO = csjNativeRenderSplashAdapter5.OooOoo0.getAdMediaView(new Object[0]);
                        CsjNativeRenderSplashAdapter.this.loadListener.onAdCacheSuccess(oo00oVar);
                    } else {
                        String mainImageUrl = CsjNativeRenderSplashAdapter.this.OooOoo0.getMainImageUrl();
                        if (TextUtils.isEmpty(mainImageUrl) && (imageUrlList = CsjNativeRenderSplashAdapter.this.OooOoo0.getImageUrlList()) != null && !imageUrlList.isEmpty()) {
                            mainImageUrl = imageUrlList.get(0).url;
                        }
                        CsjNativeRenderSplashAdapter csjNativeRenderSplashAdapter6 = CsjNativeRenderSplashAdapter.this;
                        csjNativeRenderSplashAdapter6.loadImg(mainImageUrl, csjNativeRenderSplashAdapter6.splashInfo);
                    }
                    CsjNativeRenderSplashAdapter.this.OooOoo0.setNativeEventListener(new UMNNativeEventListener() { // from class: com.ubixnow.network.csj.CsjNativeRenderSplashAdapter.2.1
                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdClicked() {
                            CsjNativeRenderSplashAdapter csjNativeRenderSplashAdapter7 = CsjNativeRenderSplashAdapter.this;
                            csjNativeRenderSplashAdapter7.showLog(csjNativeRenderSplashAdapter7.OooOoOO, "onAdClicked");
                            CsjNativeRenderSplashAdapter.this.callAdClick();
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdClose() {
                            CsjNativeRenderSplashAdapter csjNativeRenderSplashAdapter7 = CsjNativeRenderSplashAdapter.this;
                            csjNativeRenderSplashAdapter7.showLog(csjNativeRenderSplashAdapter7.OooOoOO, "onAdClose");
                            if (CsjNativeRenderSplashAdapter.this.eventListener != null) {
                                CsjNativeRenderSplashAdapter.this.eventListener.onAdDismiss(CsjNativeRenderSplashAdapter.this.splashInfo);
                            }
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdExposure() {
                            CsjNativeRenderSplashAdapter csjNativeRenderSplashAdapter7 = CsjNativeRenderSplashAdapter.this;
                            csjNativeRenderSplashAdapter7.showLog(csjNativeRenderSplashAdapter7.OooOoOO, "onAdExposure");
                            if (CsjNativeRenderSplashAdapter.this.eventListener != null) {
                                CsjNativeRenderSplashAdapter.this.eventListener.onAdShow(CsjNativeRenderSplashAdapter.this.splashInfo);
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
                CsjNativeRenderSplashAdapter csjNativeRenderSplashAdapter = CsjNativeRenderSplashAdapter.this;
                csjNativeRenderSplashAdapter.showLog(csjNativeRenderSplashAdapter.OooOoOO, "onAdFailed: " + errorInfo.toString());
                o00O00o0 o00o00o0 = CsjNativeRenderSplashAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, errorInfo.platFormCode, errorInfo.platFormMsg).setInfo((Object) CsjNativeRenderSplashAdapter.this.splashInfo));
                }
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onTimeout() {
                CsjNativeRenderSplashAdapter csjNativeRenderSplashAdapter = CsjNativeRenderSplashAdapter.this;
                csjNativeRenderSplashAdapter.showLog(csjNativeRenderSplashAdapter.OooOoOO, "onTimeout");
            }
        });
    }

    @Override // com.ubixnow.ooooo.o000OOo0, com.ubixnow.ooooo.o00OO00O, com.ubixnow.ooooo.o00O
    public void destory() {
        try {
            super.destory();
            CsjNativeAd csjNativeAd = this.OooOoo0;
            if (csjNativeAd != null) {
                csjNativeAd.destroy();
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
        CsjNativeAd csjNativeAd = this.OooOoo0;
        if (csjNativeAd != null) {
            return csjNativeAd.getShakeView(viewGroup);
        }
        return null;
    }

    @Override // com.ubixnow.ooooo.o000OOo0
    public float getVideoWidthHeightRatio() {
        CsjNativeAd csjNativeAd = this.OooOoo0;
        if (csjNativeAd == null) {
            return 0.0f;
        }
        int videoWidth = csjNativeAd.getVideoWidth();
        int videoHeight = this.OooOoo0.getVideoHeight();
        if (videoWidth <= 0 || videoHeight <= 0) {
            return 0.0f;
        }
        return (videoWidth * 1.0f) / videoHeight;
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        CsjNativeAd csjNativeAd = this.OooOoo0;
        if (csjNativeAd != null) {
            return csjNativeAd.isValid();
        }
        return false;
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void loadSplashAd(final Context context, o00O000 o00o000) {
        createSplashInfo(o00o000);
        this.OooOoo = (UMNSplashParams) o00o000.OooO0o0;
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            CsjInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.csj.CsjNativeRenderSplashAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = CsjNativeRenderSplashAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", CsjInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) CsjNativeRenderSplashAdapter.this.splashInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    CsjNativeRenderSplashAdapter.this.loadAd(context);
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, CsjInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.splashInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            CsjNativeAd csjNativeAd = this.OooOoo0;
            if (csjNativeAd != null) {
                csjNativeAd.notifyLoss(o00oo0oo);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            CsjNativeAd csjNativeAd = this.OooOoo0;
            if (csjNativeAd != null) {
                csjNativeAd.notifyWin(o00oo0oo);
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
