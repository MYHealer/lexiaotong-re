package com.ubixnow.network.fanwei;

import android.view.View;
import com.ptg.adsdk.lib.PtgAdSdk;
import com.ptg.adsdk.lib.interf.PtgNativeExpressAd;
import com.ptg.adsdk.lib.model.AdError;
import com.ptg.adsdk.lib.model.AdSlot;
import com.ptg.adsdk.lib.provider.PtgAdNative;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class FwNativeExpressAd extends UMNCustomNativeAd {
    private static final String OooO00o = "----FwNativeExpressAd";
    private AdSlot OooO0O0;
    private View OooO0OO;
    private PtgNativeExpressAd OooO0Oo;

    public FwNativeExpressAd(oo000o oo000oVar, String str) {
        String str2;
        boolean z;
        AdSlot.Builder builder = new AdSlot.Builder();
        if (oo000oVar.getBaseAdConfig().OooOOO0 != null) {
            z = oo000oVar.getBaseAdConfig().OooOOO0.Oooo0OO;
            str2 = oo000oVar.getBaseAdConfig().OooOOO0.Oooo0;
        } else {
            str2 = "";
            z = true;
        }
        if ("3".equals(str2)) {
            builder.setIsAutoPlay(false);
        } else {
            builder.setIsAutoPlay(true);
        }
        builder.setPlayMuted(z);
        this.OooO0O0 = builder.setPtgSlotId(str).build();
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00oOoo
    public void destroy() {
        showLog(OooO00o, "destroy");
        PtgNativeExpressAd ptgNativeExpressAd = this.OooO0Oo;
        if (ptgNativeExpressAd != null) {
            ptgNativeExpressAd.destroy();
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        return this.OooO0OO;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public String getNativeExpressType() {
        PtgNativeExpressAd ptgNativeExpressAd = this.OooO0Oo;
        if (ptgNativeExpressAd != null) {
            return ptgNativeExpressAd.isVideo() ? "1" : "2";
        }
        return "0";
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public boolean isValid() {
        try {
            PtgNativeExpressAd ptgNativeExpressAd = this.OooO0Oo;
            return ptgNativeExpressAd != null && ptgNativeExpressAd.isReady();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return super.isValid();
        }
    }

    public void loadAd(final oo000o oo000oVar, final o00O00o0 o00o00o0) {
        this.loadListener = o00o00o0;
        PtgAdSdk.get().loadNativeExpressAd(BaseUtils.getContext(), this.OooO0O0, new PtgAdNative.NativeExpressAdListener() { // from class: com.ubixnow.network.fanwei.FwNativeExpressAd.1
            public void onError(AdError adError) {
                FwNativeExpressAd.this.showLog(FwNativeExpressAd.OooO00o, "express onError: code:" + adError.getErrorCode() + " msg:" + adError.getMessage());
                o00O00o0 o00o00o1 = o00o00o0;
                if (o00o00o1 != null) {
                    o00o00o1.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, adError.getErrorCode() + "", adError.getMessage()).setInfo((Object) oo000oVar));
                }
            }

            public void onNativeExpressAdLoad(final PtgNativeExpressAd ptgNativeExpressAd) {
                FwNativeExpressAd.this.showLog(FwNativeExpressAd.OooO00o, "onNativeExpressAdLoad");
                FwNativeExpressAd.this.OooO0Oo = ptgNativeExpressAd;
                oo000oVar.material = FwUtils.getMaterialInfo(ptgNativeExpressAd.getAdvertData(), ptgNativeExpressAd);
                if (oo000oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                    try {
                        oo000oVar.setBiddingEcpm((int) ptgNativeExpressAd.getEcpm());
                        FwNativeExpressAd.this.showLog(FwNativeExpressAd.OooO00o, "price:" + ptgNativeExpressAd.getEcpm());
                    } catch (Exception e) {
                        ooooO000.OooO00o(e);
                    }
                }
                FwNativeExpressAd.this.onAdDataLoaded(oo000oVar);
                ptgNativeExpressAd.render();
                ptgNativeExpressAd.setExpressInteractionListener(new PtgNativeExpressAd.AdInteractionListener() { // from class: com.ubixnow.network.fanwei.FwNativeExpressAd.1.1
                    public void onAdClicked() {
                        FwNativeExpressAd.this.showLog(FwNativeExpressAd.OooO00o, "onAdClicked");
                        FwNativeExpressAd.this.notifyAdClicked();
                    }

                    public void onAdDismiss() {
                        FwNativeExpressAd.this.showLog(FwNativeExpressAd.OooO00o, "onAdDismiss");
                        FwNativeExpressAd.this.notifyAdDislikeClick();
                    }

                    public void onAdShow() {
                        FwNativeExpressAd.this.showLog(FwNativeExpressAd.OooO00o, "onAdShow");
                        FwNativeExpressAd.this.notifyAdExposure();
                    }

                    public void onRenderFail(AdError adError) {
                        FwNativeExpressAd.this.showLog(FwNativeExpressAd.OooO00o, "onRenderError: code:" + adError.getErrorCode() + " msg:" + adError.getMessage());
                        FwNativeExpressAd.this.onADRenderFail(adError.getErrorCode() + "", adError.getMessage(), oo000oVar);
                    }

                    public void onRenderSuccess(View view) {
                        FwNativeExpressAd.this.showLog(FwNativeExpressAd.OooO00o, "onRenderSuccess");
                        FwNativeExpressAd.this.OooO0OO = view;
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(FwNativeExpressAd.this);
                        oo000o oo000oVar2 = oo000oVar;
                        oo000oVar2.OooO00o = arrayList;
                        try {
                            if (oo000oVar2.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                                FwNativeExpressAd.this.showLog(FwNativeExpressAd.OooO00o, "price:" + ptgNativeExpressAd.getEcpm());
                                oo000oVar.setBiddingEcpm((int) ptgNativeExpressAd.getEcpm());
                            }
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            o00O00o0 o00o00o1 = o00o00o0;
                            if (o00o00o1 != null) {
                                o00o00o1.onAdCacheSuccess(oo000oVar);
                            }
                        } catch (Exception e2) {
                            ooooO000.OooO00o(e2);
                        }
                    }
                });
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            PtgNativeExpressAd ptgNativeExpressAd = this.OooO0Oo;
            if (ptgNativeExpressAd != null) {
                ptgNativeExpressAd.notifyBidLoss(FwUtils.getFailInfo(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(OooO00o, "竞价回传_notifyLoss:" + FwUtils.getFailInfo(o00oo0oo).getReason());
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            if (this.OooO0Oo != null) {
                double[] succMap = FwUtils.getSuccMap(o00oo0oo);
                this.OooO0Oo.notifyBidWin(succMap[0], succMap[1]);
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(OooO00o, "竞价回传_notifyWin: costPrice" + succMap[0] + " second price:" + succMap[1]);
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }
}
