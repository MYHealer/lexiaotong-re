package com.ubixnow.network.baidu;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.ubixnow.adtype.banner.api.UMNBannerParams;
import com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter;
import com.ubixnow.adtype.nativead.api.UMNNativeEventListener;
import com.ubixnow.adtype.nativead.api.UMNNativeMaterial;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.OooOO0O;
import com.ubixnow.ooooo.OooOOO0;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o0O0O00;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.oo00o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class BdNativeRenderBannerAdapter extends OooOOO0 {
    private final String OooOOo = this.customTag + "BdNativeRenderBannerAdapter";
    private BdNativeAd OooOOoo;
    private UMNBannerParams OooOo00;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:11:0x0021  */
    public void OooO00o(UMNNativeMaterial uMNNativeMaterial) {
        boolean z;
        String descriptionText = !TextUtils.isEmpty(uMNNativeMaterial.getDescriptionText()) ? uMNNativeMaterial.getDescriptionText() : uMNNativeMaterial.getTitle();
        if (uMNNativeMaterial.getDownloadAppinfo() != null) {
            z = uMNNativeMaterial.getNativeAdInteractionType() == 1;
        }
        inflate("百度广告", descriptionText, this.OooOo00, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context) {
        oo000o oo000oVar = new oo000o();
        oo000oVar.setAbsBaseAdapter(this);
        oo000oVar.setBaseAdConfig(this.mBaseAdConfig);
        oo000oVar.adType = "11";
        new BdNativeAd(context, new UMNNativeParams.Builder().setSlotId(this.mBaseAdConfig.OooO00o.OooO0o0).build(), this.mBaseAdConfig.OooO00o.OooO0o0, oo000oVar).loadAd("11", new o0O0O00() { // from class: com.ubixnow.network.baidu.BdNativeRenderBannerAdapter.2
            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdCacheSuccess(oo00o oo00oVar) {
                BdNativeRenderBannerAdapter bdNativeRenderBannerAdapter = BdNativeRenderBannerAdapter.this;
                bdNativeRenderBannerAdapter.showLog(bdNativeRenderBannerAdapter.OooOOo, "onAdCacheSuccess: ");
                BdNativeRenderBannerAdapter bdNativeRenderBannerAdapter2 = BdNativeRenderBannerAdapter.this;
                if (bdNativeRenderBannerAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    bdNativeRenderBannerAdapter2.showLog(bdNativeRenderBannerAdapter2.OooOOo, "price:" + oo00oVar.getBiddingEcpm());
                    BdNativeRenderBannerAdapter.this.absUbixInfo.setBiddingEcpm(oo00oVar.getBiddingEcpm());
                }
                if (oo00oVar instanceof oo000o) {
                    BdNativeRenderBannerAdapter.this.OooOOoo = (BdNativeAd) ((oo000o) oo00oVar).OooO00o.get(0);
                    BdNativeRenderBannerAdapter bdNativeRenderBannerAdapter3 = BdNativeRenderBannerAdapter.this;
                    OooOO0O<UMNCustomBannerAdapter> oooOO0O = bdNativeRenderBannerAdapter3.absUbixInfo;
                    oooOO0O.material = oo00oVar.material;
                    oooOO0O.materialStatus = oo00oVar.materialStatus;
                    int i = oo00oVar.checkMaterialStatus;
                    oooOO0O.checkMaterialStatus = i;
                    if (i > 0) {
                        bdNativeRenderBannerAdapter3.loadListener.onAdCacheSuccess(oo00oVar);
                        return;
                    }
                    bdNativeRenderBannerAdapter3.OooO00o(bdNativeRenderBannerAdapter3.OooOOoo.getMaterial());
                    if ("1".equals(BdNativeRenderBannerAdapter.this.OooOOoo.getAdType())) {
                        BdNativeRenderBannerAdapter bdNativeRenderBannerAdapter4 = BdNativeRenderBannerAdapter.this;
                        bdNativeRenderBannerAdapter4.OooOO0o = bdNativeRenderBannerAdapter4.OooOOoo.getAdMediaView(new Object[0]);
                        BdNativeRenderBannerAdapter bdNativeRenderBannerAdapter5 = BdNativeRenderBannerAdapter.this;
                        bdNativeRenderBannerAdapter5.loadImg(bdNativeRenderBannerAdapter5.OooOOoo.getVideoCoverUrl(), BdNativeRenderBannerAdapter.this.absUbixInfo, false);
                        BdNativeRenderBannerAdapter.this.loadListener.onAdCacheSuccess(oo00oVar);
                    } else {
                        String mainImageUrl = BdNativeRenderBannerAdapter.this.OooOOoo.getMainImageUrl();
                        BdNativeRenderBannerAdapter bdNativeRenderBannerAdapter6 = BdNativeRenderBannerAdapter.this;
                        bdNativeRenderBannerAdapter6.loadImg(mainImageUrl, bdNativeRenderBannerAdapter6.absUbixInfo);
                    }
                    BdNativeRenderBannerAdapter.this.OooOOoo.setNativeEventListener(new UMNNativeEventListener() { // from class: com.ubixnow.network.baidu.BdNativeRenderBannerAdapter.2.1
                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdClicked() {
                            if (BdNativeRenderBannerAdapter.this.eventListener != null) {
                                BdNativeRenderBannerAdapter.this.eventListener.onAdClick(BdNativeRenderBannerAdapter.this.absUbixInfo);
                            }
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdClose() {
                            if (BdNativeRenderBannerAdapter.this.eventListener != null) {
                                BdNativeRenderBannerAdapter.this.eventListener.onAdDismiss(BdNativeRenderBannerAdapter.this.absUbixInfo);
                            }
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdExposure() {
                            if (BdNativeRenderBannerAdapter.this.eventListener != null) {
                                BdNativeRenderBannerAdapter.this.eventListener.onAdShow(BdNativeRenderBannerAdapter.this.absUbixInfo);
                            }
                        }
                    });
                }
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdDataLoaded(oo00o oo00oVar) {
                BdNativeRenderBannerAdapter bdNativeRenderBannerAdapter = BdNativeRenderBannerAdapter.this;
                bdNativeRenderBannerAdapter.showLog(bdNativeRenderBannerAdapter.OooOOo, "onAdDataLoaded: ");
                BdNativeRenderBannerAdapter.this.onAdDataLoadSuc();
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdRenderFail(ErrorInfo errorInfo) {
                BdNativeRenderBannerAdapter bdNativeRenderBannerAdapter = BdNativeRenderBannerAdapter.this;
                bdNativeRenderBannerAdapter.showLog(bdNativeRenderBannerAdapter.OooOOo, "onAdRenderFail: " + errorInfo.msg);
                BdNativeRenderBannerAdapter bdNativeRenderBannerAdapter2 = BdNativeRenderBannerAdapter.this;
                oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.RENDER_FAIL;
                bdNativeRenderBannerAdapter2.onRenderFail(Integer.parseInt(oooO00o.OooO00o()), oooO00o.OooO0O0());
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onNoAdError(ErrorInfo errorInfo) {
                BdNativeRenderBannerAdapter bdNativeRenderBannerAdapter = BdNativeRenderBannerAdapter.this;
                bdNativeRenderBannerAdapter.showLog(bdNativeRenderBannerAdapter.OooOOo, "onNoAdError: " + errorInfo.msg);
                o00O00o0 o00o00o0 = BdNativeRenderBannerAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, errorInfo.platFormCode, errorInfo.platFormMsg).setInfo((Object) BdNativeRenderBannerAdapter.this.absUbixInfo));
                }
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onTimeout() {
                BdNativeRenderBannerAdapter bdNativeRenderBannerAdapter = BdNativeRenderBannerAdapter.this;
                bdNativeRenderBannerAdapter.showLog(bdNativeRenderBannerAdapter.OooOOo, "onTimeout");
            }
        }, oo000oVar);
    }

    @Override // com.ubixnow.ooooo.OooOOO0
    public void closeAd() {
        BdNativeAd bdNativeAd = this.OooOOoo;
        if (bdNativeAd != null) {
            bdNativeAd.notifyAdDislikeClick();
        }
    }

    @Override // com.ubixnow.ooooo.OooOOO0, com.ubixnow.ooooo.o00O
    public void destory() {
        try {
            super.destory();
            BdNativeAd bdNativeAd = this.OooOOoo;
            if (bdNativeAd != null) {
                bdNativeAd.destroy();
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        if (this.OooOOoo == null) {
            return false;
        }
        if (ooooO000.OooO00o) {
            ooooO000.OooO0OO(this.OooOOo, "isValid " + this.OooOOoo.isValid());
        }
        return this.OooOOoo.isValid();
    }

    @Override // com.ubixnow.ooooo.OooOOO0, com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter
    public void loadBannerAd(Context context, o00O000 o00o000) {
        super.loadBannerAd(context, o00o000);
        createADInfo(o00o000);
        this.OooOo00 = (UMNBannerParams) o00o000.OooO0o0;
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            BdInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.baidu.BdNativeRenderBannerAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = BdNativeRenderBannerAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", th.getMessage()).setInfo((Object) BdNativeRenderBannerAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    Context context2 = (Context) BdNativeRenderBannerAdapter.this.OooOOo0.get();
                    if (context2 == null) {
                        context2 = BaseUtils.getContext();
                    }
                    BdNativeRenderBannerAdapter.this.loadAd(context2);
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        }
    }

    @Override // com.ubixnow.ooooo.OooOOO0
    public void register(ViewGroup viewGroup) {
        try {
            super.register(viewGroup);
            this.OooOOoo.regist(viewGroup, this.OooOOOo);
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }
}
