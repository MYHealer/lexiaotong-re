package com.ubixnow.network.qumeng;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qumeng.advlib.api.AiClkAdManager;
import com.qumeng.advlib.core.AdRequestParam;
import com.qumeng.advlib.core.IMultiAdObject;
import com.qumeng.advlib.core.IMultiAdRequest;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class QmNativeExpressAd extends UMNCustomNativeAd {
    private static final String OooO00o = "----QmNativeExpressAd";
    public AdRequestParam OooO0O0;
    public IMultiAdRequest OooO0OO;
    public IMultiAdObject OooO0Oo;
    private WeakReference<Context> OooO0o0;

    public QmNativeExpressAd(Context context, UMNNativeParams uMNNativeParams, String str, final oo000o oo000oVar) {
        this.OooO0o0 = new WeakReference<>(context);
        showLog(OooO00o, "---QmNativeExpressAd: " + str);
        this.OooO0OO = AiClkAdManager.getInstance().createAdRequest();
        this.OooO0O0 = new AdRequestParam.Builder().adslotID(str).adCount(1).adType(3).adLoadListener(new AdRequestParam.ADLoadListener() { // from class: com.ubixnow.network.qumeng.QmNativeExpressAd.1
            public void onADLoaded(IMultiAdObject iMultiAdObject) {
                QmNativeExpressAd.this.showLog(QmNativeExpressAd.OooO00o, "---onADLoaded: ");
                ArrayList arrayList = new ArrayList();
                arrayList.add(QmNativeExpressAd.this);
                oo000o oo000oVar2 = oo000oVar;
                oo000oVar2.OooO00o = arrayList;
                oo000oVar2.material = QmUtils.getMaterialInfo(iMultiAdObject);
                if (iMultiAdObject != null) {
                    QmNativeExpressAd.this.OooO0Oo = iMultiAdObject;
                    if (oo000oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                        QmNativeExpressAd.this.showLog(QmNativeExpressAd.OooO00o, "price:" + iMultiAdObject.getECPM());
                        oo000oVar.setBiddingEcpm(iMultiAdObject.getECPM());
                    }
                    if (QmNativeExpressAd.this.OooO0Oo.getImageUrls() != null && QmNativeExpressAd.this.OooO0Oo.getImageUrls().size() > 0) {
                        QmNativeExpressAd qmNativeExpressAd = QmNativeExpressAd.this;
                        qmNativeExpressAd.setMainImageUrl((String) qmNativeExpressAd.OooO0Oo.getImageUrls().get(0));
                    }
                } else {
                    oo000oVar.checkMaterialStatus = 7;
                }
                QmNativeExpressAd.this.loadListener.onAdCacheSuccess(oo000oVar);
            }

            public void onAdFailed(String str2) {
                QmNativeExpressAd.this.showLog(QmNativeExpressAd.OooO00o, "---onAdFailed: " + str2);
                if (QmNativeExpressAd.this.loadListener != null) {
                    QmNativeExpressAd.this.loadListener.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, "-1", str2).setInfo((Object) oo000oVar));
                }
            }
        }).build();
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00oOoo
    public void destroy() {
        try {
            IMultiAdObject iMultiAdObject = this.OooO0Oo;
            if (iMultiAdObject != null) {
                iMultiAdObject.destroy();
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002b  */
    /* JADX WARN: Code duplicated, block: B:16:0x0043  */
    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        WeakReference<Context> weakReference;
        FrameLayout frameLayout;
        showLog(OooO00o, "---getAdMediaView: ");
        if (objArr == null || objArr.length <= 0) {
            weakReference = this.OooO0o0;
            if (weakReference != null || weakReference.get() == null) {
                frameLayout = new FrameLayout(BaseUtils.getContext());
            } else {
                frameLayout = new FrameLayout(this.OooO0o0.get());
            }
        } else {
            Object obj = objArr[0];
            if ((obj instanceof ViewGroup) && (((ViewGroup) obj).getContext() instanceof Activity)) {
                frameLayout = new FrameLayout(((ViewGroup) objArr[0]).getContext());
            } else {
                weakReference = this.OooO0o0;
                if (weakReference != null) {
                    frameLayout = new FrameLayout(BaseUtils.getContext());
                } else {
                    frameLayout = new FrameLayout(BaseUtils.getContext());
                }
            }
        }
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof ViewGroup)) {
            this.OooO0Oo.bindView(frameLayout, new IMultiAdObject.ADEventListener() { // from class: com.ubixnow.network.qumeng.QmNativeExpressAd.2
                public void onADExposed() {
                    QmNativeExpressAd.this.showLog(QmNativeExpressAd.OooO00o, "---QmNativeExpressAd: onADExposed ");
                    QmNativeExpressAd.this.notifyAdExposure();
                }

                public void onAdClick() {
                    QmNativeExpressAd.this.showLog(QmNativeExpressAd.OooO00o, "---QmNativeExpressAd: onAdClick ");
                    QmNativeExpressAd.this.notifyAdClicked();
                }

                public void onAdFailed(String str) {
                    QmNativeExpressAd.this.showLog(QmNativeExpressAd.OooO00o, "---QmNativeExpressAd: onAdFailed " + str);
                }
            });
            this.OooO0Oo.setADStateListener(new IMultiAdObject.ADStateListener() { // from class: com.ubixnow.network.qumeng.QmNativeExpressAd.3
                public void onAdEvent(int i, Bundle bundle) {
                    QmNativeExpressAd.this.showLog(QmNativeExpressAd.OooO00o, "---QmNativeExpressAd: onAdClose " + i);
                    if (i == 2) {
                        QmNativeExpressAd.this.notifyAdDislikeClick();
                    }
                }
            });
            this.OooO0Oo.setOnMediaStateListener(new IMultiAdObject.MediaStateListener() { // from class: com.ubixnow.network.qumeng.QmNativeExpressAd.4
                public void onVideoCompleted() {
                    QmNativeExpressAd.this.showLog(QmNativeExpressAd.OooO00o, "onVideoCompleted");
                    QmNativeExpressAd.this.notifyAdVideoEnd();
                }

                public void onVideoPause() {
                    QmNativeExpressAd.this.showLog(QmNativeExpressAd.OooO00o, "onVideoPause");
                }

                public void onVideoReady() {
                    QmNativeExpressAd.this.showLog(QmNativeExpressAd.OooO00o, "onVideoReady");
                }

                public void onVideoResume() {
                    QmNativeExpressAd.this.showLog(QmNativeExpressAd.OooO00o, "onVideoResume");
                }

                public void onVideoStart() {
                    QmNativeExpressAd.this.showLog(QmNativeExpressAd.OooO00o, "onVideoStart");
                    QmNativeExpressAd.this.notifyAdVideoStart();
                }

                public void onVideoStop() {
                    QmNativeExpressAd.this.showLog(QmNativeExpressAd.OooO00o, "onVideoStop");
                }
            });
        }
        return frameLayout;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public String getNativeExpressType() {
        IMultiAdObject iMultiAdObject = this.OooO0Oo;
        if (iMultiAdObject == null) {
            return "0";
        }
        int videoDuration = iMultiAdObject.getVideoDuration();
        showLog(OooO00o, "---getNativeExpressType: " + videoDuration);
        return videoDuration > 0 ? "1" : "2";
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public boolean isValid() {
        if (this.OooO0Oo == null) {
            ooooO000.OooO0OO(OooO00o, "multiAdObject == null ");
            return false;
        }
        try {
            if (ooooO000.OooO00o) {
                ooooO000.OooO0OO(OooO00o, "---isValid " + this.OooO0Oo.isValid());
            }
            return this.OooO0Oo.isValid();
        } catch (Throwable unused) {
            return true;
        }
    }

    public void loadAd(o00O00o0 o00o00o0) {
        AdRequestParam adRequestParam;
        this.loadListener = o00o00o0;
        showLog(OooO00o, "---QmNativeExpressAd: loadAd " + (this.OooO0OO != null));
        IMultiAdRequest iMultiAdRequest = this.OooO0OO;
        if (iMultiAdRequest == null || (adRequestParam = this.OooO0O0) == null) {
            return;
        }
        iMultiAdRequest.invokeADV(adRequestParam);
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            if (this.OooO0Oo != null) {
                QmBiddingUtils.QmBiddingFeedbackBean failInfo = QmBiddingUtils.getFailInfo(o00oo0oo);
                this.OooO0Oo.lossNotice(failInfo.OooO00o, failInfo.OooO0O0, failInfo.OooO0OO);
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(OooO00o, "竞价回传_notifyLoss:胜出者价格:" + failInfo.OooO00o + "  竞价失败原因:" + failInfo.OooO0O0 + "  胜出者:" + failInfo.OooO0OO);
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            IMultiAdObject iMultiAdObject = this.OooO0Oo;
            if (iMultiAdObject != null) {
                iMultiAdObject.winNotice(QmBiddingUtils.getSecondPrice(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(OooO00o, "竞价回传_notifyWin:" + QmBiddingUtils.getSecondPrice(o00oo0oo));
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }
}
