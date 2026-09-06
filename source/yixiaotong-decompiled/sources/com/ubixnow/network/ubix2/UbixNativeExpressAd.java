package com.ubixnow.network.ubix2;

import android.content.Context;
import android.view.View;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.AdSize;
import com.ubix.ssp.open.UBiXAdLossInfo;
import com.ubix.ssp.open.manager.UBiXAdManager;
import com.ubix.ssp.open.nativee.express.NativeExpressAd;
import com.ubix.ssp.open.nativee.express.UBiXNativeExpressAdListener;
import com.ubix.ssp.open.nativee.express.UBiXNativeExpressInteractionListener;
import com.ubix.ssp.open.nativee.express.UBiXNativeExpressManager;
import com.ubix.ssp.open.nativee.express.UBiXNativeExpressVideoListener;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oO00000o;
import com.ubixnow.ooooo.oOO00000;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UbixNativeExpressAd extends UMNCustomNativeAd {
    private NativeExpressAd OooO0O0;
    private View OooO0OO;
    public final String OooO00o = InternalFrame.ID + getClass().getSimpleName();
    private UBiXNativeExpressManager OooO0Oo = UBiXAdManager.createNativeExpressAd();

    public UbixNativeExpressAd(Context context, UMNNativeParams uMNNativeParams, String str, final oo000o oo000oVar) {
        this.OooO0Oo.loadNativeExpressAd(BaseUtils.getContext(), str, (uMNNativeParams == null || uMNNativeParams.width <= 0) ? new AdSize(-1, -2) : new AdSize(oOO00000.OooO0O0(uMNNativeParams.width), -2), new UBiXNativeExpressAdListener() { // from class: com.ubixnow.network.ubix2.UbixNativeExpressAd.1
            @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressAdListener
            public void onAdLoadFailed(AdError adError) {
                if (UbixNativeExpressAd.this.loadListener == null || adError == null) {
                    return;
                }
                UbixNativeExpressAd ubixNativeExpressAd = UbixNativeExpressAd.this;
                ubixNativeExpressAd.showLog(ubixNativeExpressAd.OooO00o, "onAdLoadFailed express onError code:" + adError.getErrorCode() + ",msg:" + adError.getErrorMessage());
                UbixNativeExpressAd.this.loadListener.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, adError.getErrorCode() + "", adError.getErrorMessage()).setInfo((Object) oo000oVar));
            }

            @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressAdListener
            public void onAdLoadSucceed(List<NativeExpressAd> list) {
                try {
                    UbixNativeExpressAd ubixNativeExpressAd = UbixNativeExpressAd.this;
                    ubixNativeExpressAd.showLog(ubixNativeExpressAd.OooO00o, "onAdLoadSucceed");
                    if (list != null && list.size() != 0) {
                        UbixNativeExpressAd.this.OooO0O0 = list.get(0);
                        try {
                            if (oo000oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                                UbixNativeExpressAd ubixNativeExpressAd2 = UbixNativeExpressAd.this;
                                ubixNativeExpressAd2.showLog(ubixNativeExpressAd2.OooO00o, "price:" + UbixNativeExpressAd.this.OooO0O0.getPrice());
                                oo000oVar.setBiddingEcpm((int) UbixNativeExpressAd.this.OooO0O0.getPrice());
                            }
                        } catch (Exception e) {
                            ooooO000.OooO00o(e);
                        }
                        oo000oVar.getBaseAdConfig().OooOOo0 = UbixUtils.getPR(UbixNativeExpressAd.this.OooO0O0);
                        UbixNativeExpressAd.this.onAdDataLoaded(oo000oVar);
                        UbixNativeExpressAd.this.OooO00o(oo000oVar);
                        return;
                    }
                    if (UbixNativeExpressAd.this.loadListener != null) {
                        UbixNativeExpressAd.this.loadListener.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg).setInfo((Object) oo000oVar));
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    private void OooO00o() {
        try {
            if (this.OooO0Oo != null) {
                HashMap<String, String> map = new HashMap<>();
                map.put("sensor_disabled", oO00000o.o00O0O.OooOOOo ? "0" : "1");
                this.OooO0Oo.setExtraInfo(map);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(final oo000o oo000oVar) {
        this.OooO0O0.renderExpressNativeAd(new UBiXNativeExpressInteractionListener() { // from class: com.ubixnow.network.ubix2.UbixNativeExpressAd.2
            @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressInteractionListener
            public void onAdClicked(View view) {
                UbixNativeExpressAd ubixNativeExpressAd = UbixNativeExpressAd.this;
                ubixNativeExpressAd.showLog(ubixNativeExpressAd.OooO00o, "onAdClicked");
                UbixNativeExpressAd.this.notifyAdClicked();
            }

            @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressInteractionListener
            public void onAdClosed() {
                UbixNativeExpressAd ubixNativeExpressAd = UbixNativeExpressAd.this;
                ubixNativeExpressAd.showLog(ubixNativeExpressAd.OooO00o, "onDislikeClicked");
                UbixNativeExpressAd.this.notifyAdDislikeClick();
            }

            @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressInteractionListener
            public void onAdExposeFailed(AdError adError) {
                UbixNativeExpressAd ubixNativeExpressAd = UbixNativeExpressAd.this;
                ubixNativeExpressAd.showLog(ubixNativeExpressAd.OooO00o, "onAdExposeFailed:" + adError.getErrorMessage());
            }

            @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressInteractionListener
            public void onAdExposed() {
                UbixNativeExpressAd ubixNativeExpressAd = UbixNativeExpressAd.this;
                ubixNativeExpressAd.showLog(ubixNativeExpressAd.OooO00o, "onAdShow");
                UbixNativeExpressAd.this.notifyAdExposure();
            }

            @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressInteractionListener
            public void onAdRenderFailed(AdError adError) {
                UbixNativeExpressAd ubixNativeExpressAd = UbixNativeExpressAd.this;
                ubixNativeExpressAd.showLog(ubixNativeExpressAd.OooO00o, "onAdRenderFailed code:" + adError.getErrorCode() + ",msg:" + adError.getErrorMessage());
                UbixNativeExpressAd ubixNativeExpressAd2 = UbixNativeExpressAd.this;
                oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.RENDER_FAIL;
                ubixNativeExpressAd2.onADRenderFail(oooO00o.OooO00o(), oooO00o.OooO0O0(), oo000oVar);
            }

            @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressInteractionListener
            public void onAdRenderSucceed(View view) {
                try {
                    UbixNativeExpressAd ubixNativeExpressAd = UbixNativeExpressAd.this;
                    ubixNativeExpressAd.showLog(ubixNativeExpressAd.OooO00o, "onAdRenderSucceed");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(UbixNativeExpressAd.this);
                    oo000oVar.OooO00o = arrayList;
                    if (UbixNativeExpressAd.this.loadListener != null) {
                        if (oo000oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                            UbixNativeExpressAd ubixNativeExpressAd2 = UbixNativeExpressAd.this;
                            ubixNativeExpressAd2.showLog(ubixNativeExpressAd2.OooO00o, "price:" + UbixNativeExpressAd.this.OooO0O0.getPrice());
                            oo000oVar.setBiddingEcpm((int) UbixNativeExpressAd.this.OooO0O0.getPrice());
                        }
                        oo000oVar.material = UbixUtils.getMaterialInfo(UbixNativeExpressAd.this.OooO0O0);
                        UbixNativeExpressAd.this.loadListener.onAdCacheSuccess(oo000oVar);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }
        });
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00oOoo
    public void destroy() {
        if (this.OooO0O0 != null) {
            this.OooO0O0 = null;
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        NativeExpressAd nativeExpressAd;
        try {
            boolean z = true;
            showLog(this.OooO00o, "getAdMediaView " + (this.OooO0OO != null));
            if (this.OooO0OO == null && (nativeExpressAd = this.OooO0O0) != null) {
                this.OooO0OO = nativeExpressAd.getNativeExpressView();
                String str = this.OooO00o;
                StringBuilder sb = new StringBuilder("getAdMediaView ");
                if (this.OooO0OO == null) {
                    z = false;
                }
                showLog(str, sb.append(z).toString());
                this.OooO0O0.setNativeExpressVideoListener(new UBiXNativeExpressVideoListener() { // from class: com.ubixnow.network.ubix2.UbixNativeExpressAd.3
                    @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressVideoListener
                    public void onVideoComplete() {
                        UbixNativeExpressAd ubixNativeExpressAd = UbixNativeExpressAd.this;
                        ubixNativeExpressAd.showLog(ubixNativeExpressAd.OooO00o, "onVideoComplete");
                        UbixNativeExpressAd.this.notifyAdVideoEnd();
                    }

                    @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressVideoListener
                    public void onVideoError(AdError adError) {
                        UbixNativeExpressAd ubixNativeExpressAd = UbixNativeExpressAd.this;
                        ubixNativeExpressAd.showLog(ubixNativeExpressAd.OooO00o, "onVideoError");
                        UbixNativeExpressAd.this.notifyAdVideoError();
                    }

                    @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressVideoListener
                    public void onVideoPause() {
                        UbixNativeExpressAd ubixNativeExpressAd = UbixNativeExpressAd.this;
                        ubixNativeExpressAd.showLog(ubixNativeExpressAd.OooO00o, "onVideoPause");
                    }

                    @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressVideoListener
                    public void onVideoProgressUpdate(long j, long j2) {
                    }

                    @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressVideoListener
                    public void onVideoResume() {
                        UbixNativeExpressAd ubixNativeExpressAd = UbixNativeExpressAd.this;
                        ubixNativeExpressAd.showLog(ubixNativeExpressAd.OooO00o, "onVideoResume");
                    }

                    @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressVideoListener
                    public void onVideoStart() {
                        UbixNativeExpressAd ubixNativeExpressAd = UbixNativeExpressAd.this;
                        ubixNativeExpressAd.showLog(ubixNativeExpressAd.OooO00o, "onVideoStart");
                        UbixNativeExpressAd.this.notifyAdVideoStart();
                    }
                });
            }
            return this.OooO0OO;
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return null;
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public String getNativeExpressType() {
        try {
            NativeExpressAd nativeExpressAd = this.OooO0O0;
            return (nativeExpressAd == null || !nativeExpressAd.isVideoAd()) ? "0" : "1";
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return "0";
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public boolean isValid() {
        try {
            if (this.OooO0O0 == null) {
                ooooO000.OooO0OO(this.OooO00o, "isValid false");
                return false;
            }
            if (ooooO000.OooO00o) {
                ooooO000.OooO0OO(this.OooO00o, "isValid " + this.OooO0O0.isValid());
            }
            return this.OooO0O0.isValid();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return true;
        }
    }

    public void loadAd(o00O00o0 o00o00o0) {
        this.loadListener = o00o00o0;
        OooO00o();
        this.OooO0Oo.loadAd();
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            if (this.OooO0O0 != null) {
                UBiXAdLossInfo failInfo = Ubix2BiddingUtils.getFailInfo(o00oo0oo);
                this.OooO0O0.lossNotice(failInfo);
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyLoss:" + failInfo.getInfo().toString());
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            NativeExpressAd nativeExpressAd = this.OooO0O0;
            if (nativeExpressAd != null) {
                nativeExpressAd.winNotice(Ubix2BiddingUtils.getSecondPrice(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyWin:" + Ubix2BiddingUtils.getSecondPrice(o00oo0oo));
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }
}
