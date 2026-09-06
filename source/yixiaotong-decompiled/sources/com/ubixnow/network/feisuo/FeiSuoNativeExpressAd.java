package com.ubixnow.network.feisuo;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.ubixnow.adtype.nativead.api.UMNNativeAdView;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import com.zm.fissionsdk.api.FissionSdk;
import com.zm.fissionsdk.api.FissionSlot;
import com.zm.fissionsdk.api.interfaces.IFission;
import com.zm.fissionsdk.api.interfaces.IFissionLoadManager;
import com.zm.fissionsdk.api.interfaces.IFissionNative;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class FeiSuoNativeExpressAd extends UMNCustomNativeAd {
    private final String OooO00o = "-----" + getClass().getSimpleName();
    private final WeakReference<Context> OooO0O0;
    private final o00O000 OooO0OO;
    private IFissionNative OooO0Oo;
    private int OooO0o0;

    public FeiSuoNativeExpressAd(WeakReference<Context> weakReference, o00O000 o00o000, oo000o oo000oVar) {
        this.OooO0O0 = weakReference;
        this.OooO0OO = o00o000;
        this.configInfo = oo000oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o() {
        IFissionNative iFissionNative = this.OooO0Oo;
        if (iFissionNative != null) {
            iFissionNative.setVideoListener(new IFission.VideoListener() { // from class: com.ubixnow.network.feisuo.FeiSuoNativeExpressAd.2
                public void onVideoComplete() {
                    FeiSuoNativeExpressAd feiSuoNativeExpressAd = FeiSuoNativeExpressAd.this;
                    feiSuoNativeExpressAd.showLog(feiSuoNativeExpressAd.OooO00o, "onVideoComplete");
                    FeiSuoNativeExpressAd.this.notifyAdVideoEnd();
                }

                public void onVideoContinuePlay() {
                    FeiSuoNativeExpressAd feiSuoNativeExpressAd = FeiSuoNativeExpressAd.this;
                    feiSuoNativeExpressAd.showLog(feiSuoNativeExpressAd.OooO00o, "onVideoContinuePlay");
                }

                public void onVideoError(int i, String str) {
                    FeiSuoNativeExpressAd feiSuoNativeExpressAd = FeiSuoNativeExpressAd.this;
                    feiSuoNativeExpressAd.showLog(feiSuoNativeExpressAd.OooO00o, "onVideoError");
                    FeiSuoNativeExpressAd.this.notifyAdVideoError();
                }

                public void onVideoPause() {
                    FeiSuoNativeExpressAd feiSuoNativeExpressAd = FeiSuoNativeExpressAd.this;
                    feiSuoNativeExpressAd.showLog(feiSuoNativeExpressAd.OooO00o, "onVideoPause");
                }

                public void onVideoPlay() {
                    FeiSuoNativeExpressAd feiSuoNativeExpressAd = FeiSuoNativeExpressAd.this;
                    feiSuoNativeExpressAd.showLog(feiSuoNativeExpressAd.OooO00o, "onVideoPlay");
                    FeiSuoNativeExpressAd.this.notifyAdVideoStart();
                    FeiSuoNativeExpressAd.this.OooO0Oo.setVideoMute(true);
                }
            });
            this.OooO0Oo.setNativeExpressListener(new IFissionNative.NativeExpressInteractionListener() { // from class: com.ubixnow.network.feisuo.FeiSuoNativeExpressAd.3
                public void onClick(View view) {
                    FeiSuoNativeExpressAd feiSuoNativeExpressAd = FeiSuoNativeExpressAd.this;
                    feiSuoNativeExpressAd.showLog(feiSuoNativeExpressAd.OooO00o, "onClick");
                    FeiSuoNativeExpressAd.this.notifyAdClicked();
                }

                public void onClose() {
                    FeiSuoNativeExpressAd feiSuoNativeExpressAd = FeiSuoNativeExpressAd.this;
                    feiSuoNativeExpressAd.showLog(feiSuoNativeExpressAd.OooO00o, "onClose");
                    FeiSuoNativeExpressAd.this.notifyAdDislikeClick();
                }

                public void onCreativeClick(View view) {
                    FeiSuoNativeExpressAd feiSuoNativeExpressAd = FeiSuoNativeExpressAd.this;
                    feiSuoNativeExpressAd.showLog(feiSuoNativeExpressAd.OooO00o, "onCreativeClick");
                    FeiSuoNativeExpressAd.this.notifyAdClicked();
                }

                public void onShow() {
                    FeiSuoNativeExpressAd feiSuoNativeExpressAd = FeiSuoNativeExpressAd.this;
                    feiSuoNativeExpressAd.showLog(feiSuoNativeExpressAd.OooO00o, "onShow");
                    FeiSuoNativeExpressAd.this.notifyAdExposure();
                    FeiSuoNativeExpressAd.this.OooO0Oo.setVideoMute(true);
                }

                public void onShowFailed(int i, String str) {
                    FeiSuoNativeExpressAd feiSuoNativeExpressAd = FeiSuoNativeExpressAd.this;
                    feiSuoNativeExpressAd.showLog(feiSuoNativeExpressAd.OooO00o, "onShowFailed code:" + i + " msg:" + str);
                }
            });
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00oOoo
    public void destroy() {
        showLog(this.OooO00o, "destroy");
        IFissionNative iFissionNative = this.OooO0Oo;
        if (iFissionNative != null) {
            iFissionNative.destroy();
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        try {
            if (this.OooO0Oo == null) {
                return null;
            }
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj instanceof UMNNativeAdView) {
                    UMNNativeAdView uMNNativeAdView = (UMNNativeAdView) obj;
                    if (uMNNativeAdView.getContext() != null && (uMNNativeAdView.getContext() instanceof Activity)) {
                        return this.OooO0Oo.getExpressView(uMNNativeAdView.getContext());
                    }
                    WeakReference<Context> weakReference = this.OooO0O0;
                    if (weakReference != null && weakReference.get() != null) {
                        return this.OooO0Oo.getExpressView(this.OooO0O0.get());
                    }
                }
            }
            return this.OooO0Oo.getExpressView(BaseUtils.getContext());
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return null;
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public String getNativeExpressType() {
        try {
            IFissionNative iFissionNative = this.OooO0Oo;
            if (iFissionNative != null) {
                if (FeiSuoUtils.isVideo(iFissionNative)) {
                    return "1";
                }
                return FeiSuoUtils.isImg(this.OooO0Oo) ? "2" : "0";
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
        return "0";
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public boolean isNativeExpress() {
        return true;
    }

    public void loadAd(o00O00o0 o00o00o0) {
        try {
            this.loadListener = o00o00o0;
            ooooO000.OooO0O0(this.OooO00o, "load ad");
            FissionSdk.getLoadManager().loadNative(new FissionSlot.Builder().setContext(this.OooO0O0.get()).setRequestId(this.OooO0OO.OooO0oO).setSlotType(1).setSlotId(this.OooO0OO.OooO00o.OooO0o0).setExpressType(1).setCount(1).build(), new IFissionLoadManager.AsyncNativeLoadListener() { // from class: com.ubixnow.network.feisuo.FeiSuoNativeExpressAd.1
                public void onError(int i, String str) {
                    FeiSuoNativeExpressAd feiSuoNativeExpressAd = FeiSuoNativeExpressAd.this;
                    feiSuoNativeExpressAd.showLog(feiSuoNativeExpressAd.OooO00o, "onError code" + i + " msg:" + str);
                    if (FeiSuoNativeExpressAd.this.loadListener != null) {
                        FeiSuoNativeExpressAd.this.loadListener.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str).setInfo((Object) FeiSuoNativeExpressAd.this.configInfo));
                    }
                }

                public void onLoad(List<IFissionNative> list) {
                    try {
                        FeiSuoNativeExpressAd feiSuoNativeExpressAd = FeiSuoNativeExpressAd.this;
                        feiSuoNativeExpressAd.showLog(feiSuoNativeExpressAd.OooO00o, "onLoad");
                        FeiSuoNativeExpressAd.this.OooO0Oo = list.get(0);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(FeiSuoNativeExpressAd.this);
                        FeiSuoNativeExpressAd.this.configInfo.OooO00o = arrayList;
                        FeiSuoNativeExpressAd.this.configInfo.material = FeiSuoUtils.getMaterialInfo(FeiSuoNativeExpressAd.this.OooO0Oo);
                        if (FeiSuoNativeExpressAd.this.OooO0OO.OooO00o.OooOO0O == 1) {
                            FeiSuoNativeExpressAd feiSuoNativeExpressAd2 = FeiSuoNativeExpressAd.this;
                            feiSuoNativeExpressAd2.showLog(feiSuoNativeExpressAd2.OooO00o, "price:" + FeiSuoNativeExpressAd.this.OooO0Oo.getECpm());
                            FeiSuoNativeExpressAd feiSuoNativeExpressAd3 = FeiSuoNativeExpressAd.this;
                            feiSuoNativeExpressAd3.OooO0o0 = feiSuoNativeExpressAd3.OooO0Oo.getECpm();
                            FeiSuoNativeExpressAd.this.configInfo.setBiddingEcpm(FeiSuoNativeExpressAd.this.OooO0Oo.getECpm());
                        }
                        FeiSuoNativeExpressAd.this.OooO00o();
                        if (FeiSuoNativeExpressAd.this.loadListener != null) {
                            FeiSuoNativeExpressAd.this.loadListener.onAdCacheSuccess(FeiSuoNativeExpressAd.this.configInfo);
                        }
                    } catch (Exception e) {
                        ooooO000.OooO00o(e);
                    }
                }
            });
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            IFissionNative iFissionNative = this.OooO0Oo;
            if (iFissionNative != null) {
                iFissionNative.onBidFail(FeiSuoUtils.getFailInfo(o00oo0oo), "");
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyLoss:" + FeiSuoUtils.getFailInfo(o00oo0oo));
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            IFissionNative iFissionNative = this.OooO0Oo;
            if (iFissionNative != null) {
                iFissionNative.onBidSuccess(this.OooO0o0 + "");
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyWin:" + this.OooO0o0);
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void onPause() {
        super.onPause();
        IFissionNative iFissionNative = this.OooO0Oo;
        if (iFissionNative != null) {
            iFissionNative.pause();
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void onResume() {
        super.onResume();
        IFissionNative iFissionNative = this.OooO0Oo;
        if (iFissionNative != null) {
            iFissionNative.resume();
        }
    }
}
