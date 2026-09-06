package com.ubixnow.network.qumeng;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.ubixnow.adtype.banner.api.UMNBannerParams;
import com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter;
import com.ubixnow.adtype.nativead.api.UMNNativeEventListener;
import com.ubixnow.adtype.nativead.api.UMNNativeMaterial;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.OooOO0O;
import com.ubixnow.ooooo.OooOOO0;
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
public class QmNativeRenderBannerAdapter extends OooOOO0 {
    private final String OooOOo = this.customTag + "QmNativeRenderBannerAdapter";
    private QmNativeAd OooOOoo;
    private UMNBannerParams OooOo00;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:11:0x0021  */
    public void OooO00o(UMNNativeMaterial uMNNativeMaterial) {
        boolean z;
        String descriptionText = !TextUtils.isEmpty(uMNNativeMaterial.getDescriptionText()) ? uMNNativeMaterial.getDescriptionText() : uMNNativeMaterial.getTitle();
        if (uMNNativeMaterial.getDownloadAppinfo() != null) {
            z = uMNNativeMaterial.getNativeAdInteractionType() == 1;
        }
        showLog(this.OooOOo, "t=" + descriptionText + ", d=" + z);
        inflate("趣盟广告", descriptionText, this.OooOo00, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context) {
        oo000o oo000oVar = new oo000o();
        oo000oVar.setAbsBaseAdapter(this);
        oo000oVar.setBaseAdConfig(this.mBaseAdConfig);
        oo000oVar.adType = "11";
        new QmNativeAd(context, "11", this.mBaseAdConfig.OooO00o.OooO0o0, oo000oVar).loadNativeAd(new o0O0O00() { // from class: com.ubixnow.network.qumeng.QmNativeRenderBannerAdapter.2
            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdCacheSuccess(oo00o oo00oVar) {
                QmNativeRenderBannerAdapter qmNativeRenderBannerAdapter = QmNativeRenderBannerAdapter.this;
                qmNativeRenderBannerAdapter.showLog(qmNativeRenderBannerAdapter.OooOOo, "onAdCacheSuccess");
                QmNativeRenderBannerAdapter qmNativeRenderBannerAdapter2 = QmNativeRenderBannerAdapter.this;
                if (qmNativeRenderBannerAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    qmNativeRenderBannerAdapter2.showLog(qmNativeRenderBannerAdapter2.OooOOo, "price:" + oo00oVar.getBiddingEcpm());
                    QmNativeRenderBannerAdapter.this.absUbixInfo.setBiddingEcpm(oo00oVar.getBiddingEcpm());
                }
                if (oo00oVar instanceof oo000o) {
                    QmNativeRenderBannerAdapter.this.OooOOoo = (QmNativeAd) ((oo000o) oo00oVar).OooO00o.get(0);
                    QmNativeRenderBannerAdapter qmNativeRenderBannerAdapter3 = QmNativeRenderBannerAdapter.this;
                    OooOO0O<UMNCustomBannerAdapter> oooOO0O = qmNativeRenderBannerAdapter3.absUbixInfo;
                    oooOO0O.material = oo00oVar.material;
                    oooOO0O.materialStatus = oo00oVar.materialStatus;
                    int i = oo00oVar.checkMaterialStatus;
                    oooOO0O.checkMaterialStatus = i;
                    if (i > 0) {
                        qmNativeRenderBannerAdapter3.loadListener.onAdCacheSuccess(oo00oVar);
                        return;
                    }
                    qmNativeRenderBannerAdapter3.OooO00o(qmNativeRenderBannerAdapter3.OooOOoo.getMaterial());
                    QmNativeRenderBannerAdapter qmNativeRenderBannerAdapter4 = QmNativeRenderBannerAdapter.this;
                    OooOO0O<UMNCustomBannerAdapter> oooOO0O2 = qmNativeRenderBannerAdapter4.absUbixInfo;
                    oooOO0O2.material = oo00oVar.material;
                    oooOO0O2.materialStatus = oo00oVar.materialStatus;
                    if (Objects.equals(qmNativeRenderBannerAdapter4.OooOOoo.getAdType(), "1")) {
                        QmNativeRenderBannerAdapter qmNativeRenderBannerAdapter5 = QmNativeRenderBannerAdapter.this;
                        qmNativeRenderBannerAdapter5.OooOO0o = qmNativeRenderBannerAdapter5.OooOOoo.getAdMediaView(new Object[0]);
                        QmNativeRenderBannerAdapter qmNativeRenderBannerAdapter6 = QmNativeRenderBannerAdapter.this;
                        qmNativeRenderBannerAdapter6.loadImg(qmNativeRenderBannerAdapter6.OooOOoo.getVideoCoverUrl(), QmNativeRenderBannerAdapter.this.absUbixInfo, false);
                        QmNativeRenderBannerAdapter.this.loadListener.onAdCacheSuccess(oo00oVar);
                    } else {
                        String mainImageUrl = QmNativeRenderBannerAdapter.this.OooOOoo.getMainImageUrl();
                        QmNativeRenderBannerAdapter qmNativeRenderBannerAdapter7 = QmNativeRenderBannerAdapter.this;
                        qmNativeRenderBannerAdapter7.loadImg(mainImageUrl, qmNativeRenderBannerAdapter7.absUbixInfo);
                    }
                    QmNativeRenderBannerAdapter.this.OooOOoo.setNativeEventListener(new UMNNativeEventListener() { // from class: com.ubixnow.network.qumeng.QmNativeRenderBannerAdapter.2.1
                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdClicked() {
                            if (QmNativeRenderBannerAdapter.this.eventListener != null) {
                                QmNativeRenderBannerAdapter.this.eventListener.onAdClick(QmNativeRenderBannerAdapter.this.absUbixInfo);
                            }
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdClose() {
                            if (QmNativeRenderBannerAdapter.this.eventListener != null) {
                                QmNativeRenderBannerAdapter.this.eventListener.onAdDismiss(QmNativeRenderBannerAdapter.this.absUbixInfo);
                            }
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
                        public void onAdExposure() {
                            if (QmNativeRenderBannerAdapter.this.eventListener != null) {
                                QmNativeRenderBannerAdapter.this.eventListener.onAdShow(QmNativeRenderBannerAdapter.this.absUbixInfo);
                            }
                        }
                    });
                }
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdDataLoaded(oo00o oo00oVar) {
                QmNativeRenderBannerAdapter qmNativeRenderBannerAdapter = QmNativeRenderBannerAdapter.this;
                qmNativeRenderBannerAdapter.showLog(qmNativeRenderBannerAdapter.OooOOo, "onAdDataLoaded");
                QmNativeRenderBannerAdapter.this.onAdDataLoadSuc();
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdRenderFail(ErrorInfo errorInfo) {
                QmNativeRenderBannerAdapter qmNativeRenderBannerAdapter = QmNativeRenderBannerAdapter.this;
                qmNativeRenderBannerAdapter.showLog(qmNativeRenderBannerAdapter.OooOOo, "onAdRenderFail: " + errorInfo.msg);
                QmNativeRenderBannerAdapter qmNativeRenderBannerAdapter2 = QmNativeRenderBannerAdapter.this;
                oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.RENDER_FAIL;
                qmNativeRenderBannerAdapter2.onRenderFail(Integer.parseInt(oooO00o.OooO00o()), oooO00o.OooO0O0());
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onNoAdError(ErrorInfo errorInfo) {
                QmNativeRenderBannerAdapter qmNativeRenderBannerAdapter = QmNativeRenderBannerAdapter.this;
                qmNativeRenderBannerAdapter.showLog(qmNativeRenderBannerAdapter.OooOOo, "onNoAdError: " + errorInfo.msg);
                o00O00o0 o00o00o0 = QmNativeRenderBannerAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, errorInfo.platFormCode, errorInfo.platFormMsg).setInfo((Object) QmNativeRenderBannerAdapter.this.absUbixInfo));
                }
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onTimeout() {
                QmNativeRenderBannerAdapter qmNativeRenderBannerAdapter = QmNativeRenderBannerAdapter.this;
                qmNativeRenderBannerAdapter.showLog(qmNativeRenderBannerAdapter.OooOOo, "onTimeout");
            }
        });
    }

    @Override // com.ubixnow.ooooo.OooOOO0
    public void closeAd() {
        QmNativeAd qmNativeAd = this.OooOOoo;
        if (qmNativeAd != null) {
            qmNativeAd.notifyAdDislikeClick();
        }
    }

    @Override // com.ubixnow.ooooo.OooOOO0, com.ubixnow.ooooo.o00O
    public void destory() {
        try {
            super.destory();
            QmNativeAd qmNativeAd = this.OooOOoo;
            if (qmNativeAd != null) {
                qmNativeAd.destroy();
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
            QmInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.qumeng.QmNativeRenderBannerAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = QmNativeRenderBannerAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", th.getMessage()).setInfo((Object) QmNativeRenderBannerAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    Context context2 = (Context) QmNativeRenderBannerAdapter.this.OooOOo0.get();
                    if (context2 == null) {
                        context2 = BaseUtils.getContext();
                    }
                    QmNativeRenderBannerAdapter.this.loadAd(context2);
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            QmNativeAd qmNativeAd = this.OooOOoo;
            if (qmNativeAd != null) {
                qmNativeAd.notifyLoss(o00oo0oo);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            QmNativeAd qmNativeAd = this.OooOOoo;
            if (qmNativeAd != null) {
                qmNativeAd.notifyWin(o00oo0oo);
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
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
