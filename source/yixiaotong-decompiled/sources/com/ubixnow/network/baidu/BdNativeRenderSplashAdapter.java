package com.ubixnow.network.baidu;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.ubixnow.adtype.nativead.api.UMNNativeEventListener;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.adtype.splash.api.UMNSplashParams;
import com.ubixnow.adtype.splash.custom.UMNCustomSplashAdapter;
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
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class BdNativeRenderSplashAdapter extends o000OOo0 {
    private final String OooOoOO = this.customTag + "BdNativeRenderSplashAdapter";
    private UMNSplashParams OooOoo;
    private BdNativeAd OooOoo0;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context) {
        oo000o oo000oVar = new oo000o();
        oo000oVar.setAbsBaseAdapter(this);
        oo000oVar.setBaseAdConfig(this.mBaseAdConfig);
        oo000oVar.isMuteIndependent = true;
        oo000oVar.isAutoPlayIndependent = true;
        oo000oVar.adType = "7";
        new BdNativeAd(context, new UMNNativeParams.Builder().setSlotId(this.mBaseAdConfig.OooO00o.OooO0o0).build(), this.mBaseAdConfig.OooO00o.OooO0o0, oo000oVar).loadAd("7", new o0O0O00() { // from class: com.ubixnow.network.baidu.BdNativeRenderSplashAdapter.2
            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdCacheSuccess(oo00o oo00oVar) {
                BdNativeRenderSplashAdapter bdNativeRenderSplashAdapter = BdNativeRenderSplashAdapter.this;
                bdNativeRenderSplashAdapter.inflate("百度广告", bdNativeRenderSplashAdapter.OooOoo);
                BdNativeRenderSplashAdapter bdNativeRenderSplashAdapter2 = BdNativeRenderSplashAdapter.this;
                if (bdNativeRenderSplashAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    bdNativeRenderSplashAdapter2.showLog(bdNativeRenderSplashAdapter2.OooOoOO, "price:" + oo00oVar.getBiddingEcpm());
                    BdNativeRenderSplashAdapter.this.splashInfo.setBiddingEcpm(oo00oVar.getBiddingEcpm());
                }
                if (oo00oVar instanceof oo000o) {
                    BdNativeRenderSplashAdapter.this.OooOoo0 = (BdNativeAd) ((oo000o) oo00oVar).OooO00o.get(0);
                    BdNativeRenderSplashAdapter bdNativeRenderSplashAdapter3 = BdNativeRenderSplashAdapter.this;
                    o000O00O<UMNCustomSplashAdapter> o000o00o = bdNativeRenderSplashAdapter3.splashInfo;
                    o000o00o.material = oo00oVar.material;
                    o000o00o.materialStatus = oo00oVar.materialStatus;
                    int i = oo00oVar.checkMaterialStatus;
                    o000o00o.checkMaterialStatus = i;
                    if (i > 0) {
                        bdNativeRenderSplashAdapter3.loadListener.onAdCacheSuccess(oo00oVar);
                        return;
                    }
                    if (Objects.equals(bdNativeRenderSplashAdapter3.OooOoo0.getAdType(), "1")) {
                        BdNativeRenderSplashAdapter bdNativeRenderSplashAdapter4 = BdNativeRenderSplashAdapter.this;
                        bdNativeRenderSplashAdapter4.loadImg(bdNativeRenderSplashAdapter4.OooOoo0.getVideoCoverUrl(), BdNativeRenderSplashAdapter.this.splashInfo, false);
                        BdNativeRenderSplashAdapter bdNativeRenderSplashAdapter5 = BdNativeRenderSplashAdapter.this;
                        bdNativeRenderSplashAdapter5.OooO0OO = bdNativeRenderSplashAdapter5.OooOoo0.getAdMediaView(new Object[0]);
                        BdNativeRenderSplashAdapter.this.loadListener.onAdCacheSuccess(oo00oVar);
                    } else {
                        String mainImageUrl = BdNativeRenderSplashAdapter.this.OooOoo0.getMainImageUrl();
                        BdNativeRenderSplashAdapter bdNativeRenderSplashAdapter6 = BdNativeRenderSplashAdapter.this;
                        bdNativeRenderSplashAdapter6.loadImg(mainImageUrl, bdNativeRenderSplashAdapter6.splashInfo);
                    }
                    BdNativeRenderSplashAdapter.this.OooOoo0.setNativeEventListener(new UMNNativeEventListener() { // from class: com.ubixnow.network.baidu.BdNativeRenderSplashAdapter.2.1
                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdClicked() {
                            BdNativeRenderSplashAdapter.this.callAdClick();
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdClose() {
                            if (BdNativeRenderSplashAdapter.this.eventListener != null) {
                                BdNativeRenderSplashAdapter.this.eventListener.onAdDismiss(BdNativeRenderSplashAdapter.this.splashInfo);
                            }
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdExposure() {
                            if (BdNativeRenderSplashAdapter.this.eventListener != null) {
                                BdNativeRenderSplashAdapter.this.eventListener.onAdShow(BdNativeRenderSplashAdapter.this.splashInfo);
                            }
                        }
                    });
                }
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdDataLoaded(oo00o oo00oVar) {
                BdNativeRenderSplashAdapter.this.onAdDataLoadSuc();
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdRenderFail(ErrorInfo errorInfo) {
                BdNativeRenderSplashAdapter bdNativeRenderSplashAdapter = BdNativeRenderSplashAdapter.this;
                oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.RENDER_FAIL;
                bdNativeRenderSplashAdapter.onRenderFail(Integer.parseInt(oooO00o.OooO00o()), oooO00o.OooO0O0());
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onNoAdError(ErrorInfo errorInfo) {
                BdNativeRenderSplashAdapter bdNativeRenderSplashAdapter = BdNativeRenderSplashAdapter.this;
                bdNativeRenderSplashAdapter.showLog(bdNativeRenderSplashAdapter.OooOoOO, "onAdFailed: " + errorInfo.msg);
                o00O00o0 o00o00o0 = BdNativeRenderSplashAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, errorInfo.platFormCode, errorInfo.platFormMsg).setInfo((Object) BdNativeRenderSplashAdapter.this.splashInfo));
                }
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onTimeout() {
                BdNativeRenderSplashAdapter bdNativeRenderSplashAdapter = BdNativeRenderSplashAdapter.this;
                bdNativeRenderSplashAdapter.showLog(bdNativeRenderSplashAdapter.OooOoOO, "onTimeout");
            }
        }, oo000oVar);
    }

    @Override // com.ubixnow.ooooo.o000OOo0, com.ubixnow.ooooo.o00OO00O, com.ubixnow.ooooo.o00O
    public void destory() {
        try {
            super.destory();
            BdNativeAd bdNativeAd = this.OooOoo0;
            if (bdNativeAd != null) {
                bdNativeAd.destroy();
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.o000OOo0
    public View getShakeView(ViewGroup viewGroup) {
        BdNativeAd bdNativeAd = this.OooOoo0;
        if (bdNativeAd != null) {
            return bdNativeAd.getShakeView(viewGroup);
        }
        return null;
    }

    @Override // com.ubixnow.ooooo.o000OOo0
    public float getVideoWidthHeightRatio() {
        BdNativeAd bdNativeAd = this.OooOoo0;
        if (bdNativeAd == null) {
            return 0.0f;
        }
        int videoWidth = bdNativeAd.getVideoWidth();
        int videoHeight = this.OooOoo0.getVideoHeight();
        if (videoWidth <= 0 || videoHeight <= 0) {
            return 0.0f;
        }
        return (videoWidth * 1.0f) / videoHeight;
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        if (this.OooOoo0 == null) {
            return false;
        }
        if (ooooO000.OooO00o) {
            ooooO000.OooO0OO(this.OooOoOO, "isValid " + this.OooOoo0.isValid());
        }
        return this.OooOoo0.isValid();
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void loadSplashAd(Context context, o00O000 o00o000) {
        createSplashInfo(o00o000);
        this.OooOoo = (UMNSplashParams) o00o000.OooO0o0;
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            BdInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.baidu.BdNativeRenderSplashAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = BdNativeRenderSplashAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", BdInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) BdNativeRenderSplashAdapter.this.splashInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    BdNativeRenderSplashAdapter.this.loadAd(BaseUtils.getContext());
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, BdInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.splashInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
    }

    @Override // com.ubixnow.ooooo.o000OOo0
    public void regist(ViewGroup viewGroup) {
        try {
            super.regist(viewGroup);
            this.OooOoo0.regist(viewGroup, this.OooOOOo);
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }
}
