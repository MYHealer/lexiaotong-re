package com.ubixnow.network.gdt;

import android.content.Context;
import android.view.View;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.util.AdError;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oO0000O;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.ooooO000;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class GdtNativeExpressAd extends UMNCustomNativeAd {
    private static final String OooO00o = "----GdtNativeExpressAd";
    public NativeExpressAD OooO0O0;
    public o00O00o0 OooO0OO;
    public NativeExpressADView OooO0Oo;

    public GdtNativeExpressAd(Context context, UMNNativeParams uMNNativeParams, String str, final oo000o oo000oVar) {
        String str2;
        boolean z;
        int i = uMNNativeParams.width;
        int iOooO00o = i > 0 ? oO0000O.OooO00o(i) : -1;
        int i2 = uMNNativeParams.height;
        int iOooO00o2 = i2 > 0 ? oO0000O.OooO00o(i2) : -2;
        this.configInfo = oo000oVar;
        ooooO000.OooO0O0(OooO00o, "----gdt express height wid:" + iOooO00o + " hei:" + iOooO00o2);
        this.OooO0O0 = new NativeExpressAD(context, new ADSize(iOooO00o, iOooO00o2), str, new NativeExpressAD.NativeExpressADListener() { // from class: com.ubixnow.network.gdt.GdtNativeExpressAd.1
            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClicked(NativeExpressADView nativeExpressADView) {
                GdtNativeExpressAd.this.showLog(GdtNativeExpressAd.OooO00o, "onADClicked");
                GdtNativeExpressAd.this.notifyAdClicked();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClosed(NativeExpressADView nativeExpressADView) {
                GdtNativeExpressAd.this.showLog(GdtNativeExpressAd.OooO00o, "onADClosed");
                GdtNativeExpressAd.this.notifyAdDislikeClick();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADExposure(NativeExpressADView nativeExpressADView) {
                GdtNativeExpressAd.this.showLog(GdtNativeExpressAd.OooO00o, "onADExposure");
                GdtNativeExpressAd.this.notifyAdExposure();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
                GdtNativeExpressAd.this.showLog(GdtNativeExpressAd.OooO00o, "onADLeftApplication");
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLoaded(List<NativeExpressADView> list) {
                if (list.size() > 0) {
                    NativeExpressADView nativeExpressADView = list.get(0);
                    try {
                        if (oo000oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                            GdtNativeExpressAd.this.showLog(GdtNativeExpressAd.OooO00o, "price:" + nativeExpressADView.getECPM());
                            oo000oVar.setBiddingEcpm(nativeExpressADView.getECPM());
                        }
                    } catch (Exception e) {
                        ooooO000.OooO00o(e);
                    }
                    GdtNativeExpressAd.this.onAdDataLoaded(oo000oVar);
                    nativeExpressADView.render();
                    nativeExpressADView.setMediaListener(new NativeExpressMediaListener() { // from class: com.ubixnow.network.gdt.GdtNativeExpressAd.1.1
                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoCached(NativeExpressADView nativeExpressADView2) {
                            GdtNativeExpressAd.this.showLog(GdtNativeExpressAd.OooO00o, "onVideoCached");
                        }

                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoComplete(NativeExpressADView nativeExpressADView2) {
                            GdtNativeExpressAd.this.showLog(GdtNativeExpressAd.OooO00o, "onVideoComplete");
                            GdtNativeExpressAd.this.notifyAdVideoEnd();
                        }

                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoError(NativeExpressADView nativeExpressADView2, AdError adError) {
                            GdtNativeExpressAd.this.showLog(GdtNativeExpressAd.OooO00o, "onVideoError");
                            GdtNativeExpressAd.this.notifyAdVideoError();
                        }

                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoInit(NativeExpressADView nativeExpressADView2) {
                            GdtNativeExpressAd.this.showLog(GdtNativeExpressAd.OooO00o, "onVideoInit");
                        }

                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoLoading(NativeExpressADView nativeExpressADView2) {
                            GdtNativeExpressAd.this.showLog(GdtNativeExpressAd.OooO00o, "onVideoLoading");
                        }

                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoPageClose(NativeExpressADView nativeExpressADView2) {
                            GdtNativeExpressAd.this.showLog(GdtNativeExpressAd.OooO00o, "onVideoPageClose");
                        }

                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoPageOpen(NativeExpressADView nativeExpressADView2) {
                            GdtNativeExpressAd.this.showLog(GdtNativeExpressAd.OooO00o, "onVideoPageOpen");
                        }

                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoPause(NativeExpressADView nativeExpressADView2) {
                            GdtNativeExpressAd.this.showLog(GdtNativeExpressAd.OooO00o, "onVideoPause");
                        }

                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoReady(NativeExpressADView nativeExpressADView2, long j) {
                            GdtNativeExpressAd.this.showLog(GdtNativeExpressAd.OooO00o, "onVideoReady");
                        }

                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoStart(NativeExpressADView nativeExpressADView2) {
                            GdtNativeExpressAd.this.showLog(GdtNativeExpressAd.OooO00o, "onVideoStart");
                            GdtNativeExpressAd.this.notifyAdVideoStart();
                        }
                    });
                }
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                GdtNativeExpressAd.this.showLog(GdtNativeExpressAd.OooO00o, "express onError " + adError.getErrorMsg());
                o00O00o0 o00o00o0 = GdtNativeExpressAd.this.OooO0OO;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, adError.getErrorCode() + "", adError.getErrorMsg()).setInfo((Object) oo000oVar));
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderFail(NativeExpressADView nativeExpressADView) {
                GdtNativeExpressAd.this.showLog(GdtNativeExpressAd.OooO00o, "onRenderFail");
                GdtNativeExpressAd gdtNativeExpressAd = GdtNativeExpressAd.this;
                oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.RENDER_FAIL;
                gdtNativeExpressAd.onADRenderFail(oooO00o.OooO00o(), oooO00o.OooO0O0(), oo000oVar);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
                GdtNativeExpressAd.this.showLog(GdtNativeExpressAd.OooO00o, "onRenderSuccess");
                GdtNativeExpressAd.this.OooO0Oo = nativeExpressADView;
                ArrayList arrayList = new ArrayList();
                arrayList.add(GdtNativeExpressAd.this);
                oo000o oo000oVar2 = oo000oVar;
                oo000oVar2.OooO00o = arrayList;
                try {
                    if (GdtNativeExpressAd.this.OooO0OO != null) {
                        if (oo000oVar2.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                            GdtNativeExpressAd.this.showLog(GdtNativeExpressAd.OooO00o, "price:" + nativeExpressADView.getECPM());
                            oo000oVar.setBiddingEcpm(nativeExpressADView.getECPM());
                        }
                        GdtNativeExpressAd.this.OooO0OO.onAdCacheSuccess(oo000oVar);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }
        });
        int i3 = 1;
        if (oo000oVar.getBaseAdConfig().OooOOO0 != null) {
            z = oo000oVar.getBaseAdConfig().OooOOO0.Oooo0OO;
            str2 = oo000oVar.getBaseAdConfig().OooOOO0.Oooo0;
        } else {
            str2 = "";
            z = true;
        }
        str2.hashCode();
        if (str2.equals("2")) {
            i3 = 0;
        } else if (str2.equals("3")) {
            i3 = 2;
        }
        this.OooO0O0.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(z).setAutoPlayPolicy(i3).build());
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00oOoo
    public void destroy() {
        try {
            NativeExpressADView nativeExpressADView = this.OooO0Oo;
            if (nativeExpressADView != null) {
                nativeExpressADView.destroy();
            }
            this.OooO0Oo = null;
            this.OooO0O0 = null;
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        return this.OooO0Oo;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public String getNativeExpressType() {
        NativeExpressADView nativeExpressADView = this.OooO0Oo;
        if (nativeExpressADView == null || nativeExpressADView.getBoundData() == null || this.OooO0Oo.getBoundData().getVideoDuration() <= 0) {
            return "0";
        }
        showLog(OooO00o, this.OooO0Oo.getBoundData().getVideoDuration() + "");
        return "1";
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public boolean isValid() {
        NativeExpressADView nativeExpressADView = this.OooO0Oo;
        if (nativeExpressADView != null) {
            return nativeExpressADView.isValid();
        }
        return false;
    }

    public void loadAd(o00O00o0 o00o00o0) {
        this.OooO0OO = o00o00o0;
        this.OooO0O0.loadAD(1);
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            NativeExpressADView nativeExpressADView = this.OooO0Oo;
            if (nativeExpressADView != null) {
                nativeExpressADView.sendLossNotification(GdtBiddingUtils.getFailInfo(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(OooO00o, "竞价回传_notifyLoss:" + GdtBiddingUtils.getFailInfo(o00oo0oo));
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            NativeExpressADView nativeExpressADView = this.OooO0Oo;
            if (nativeExpressADView != null) {
                nativeExpressADView.sendWinNotification(GdtBiddingUtils.getSuccMap(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(OooO00o, "竞价回传_notifyWin:" + GdtBiddingUtils.getSuccMap(o00oo0oo));
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }
}
