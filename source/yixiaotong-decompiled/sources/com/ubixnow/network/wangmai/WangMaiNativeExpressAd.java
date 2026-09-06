package com.ubixnow.network.wangmai;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.ubix.wm.appsdkdex.ads.WMAdNativeExpress;
import com.ubix.wm.common.Ilistener.XAdNativeExpressListener;
import com.ubix.wm.common.bean.WMAdSlot;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oO;
import com.ubixnow.ooooo.oOO00000;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.ooooO000;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class WangMaiNativeExpressAd extends UMNCustomNativeAd {
    private final String OooO00o = "-----WangMaiNativeExpressAd";
    private WMAdNativeExpress OooO0O0;
    private final String OooO0OO;
    private View OooO0Oo;
    private int OooO0o;
    private final UMNNativeParams OooO0o0;
    private boolean OooO0oO;
    private boolean OooO0oo;

    public WangMaiNativeExpressAd(Context context, UMNNativeParams uMNNativeParams, String str, oo000o oo000oVar) {
        this.OooO0OO = str;
        this.OooO0o0 = uMNNativeParams;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00oOoo
    public void destroy() {
        showLog(this.OooO00o, "destroy");
        WMAdNativeExpress wMAdNativeExpress = this.OooO0O0;
        if (wMAdNativeExpress != null) {
            wMAdNativeExpress.destroy();
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        return this.OooO0Oo;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public String getNativeExpressType() {
        if (this.OooO0oo) {
            return this.OooO0oO ? "1" : "2";
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
            WMAdNativeExpress wMAdNativeExpress = this.OooO0O0;
            return wMAdNativeExpress != null && wMAdNativeExpress.isReady();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return super.isValid();
        }
    }

    public void loadAd(String str, final oo000o oo000oVar, o00O00o0 o00o00o0) {
        this.loadListener = o00o00o0;
        this.configInfo = oo000oVar;
        WMAdSlot.Builder slotId = new WMAdSlot.Builder().setSlotId(this.OooO0OO);
        slotId.setAdSize(oOO00000.OooO0O0(this.OooO0o0.width), oOO00000.OooO0O0(this.OooO0o0.height));
        this.OooO0O0 = new WMAdNativeExpress(slotId.builder(), new XAdNativeExpressListener() { // from class: com.ubixnow.network.wangmai.WangMaiNativeExpressAd.1
            public void onADIsVideo(boolean z) {
                WangMaiNativeExpressAd wangMaiNativeExpressAd = WangMaiNativeExpressAd.this;
                wangMaiNativeExpressAd.showLog(wangMaiNativeExpressAd.OooO00o, "onADIsVideo");
                WangMaiNativeExpressAd.this.OooO0oo = true;
                WangMaiNativeExpressAd.this.OooO0oO = z;
            }

            public void onAdClose() {
                WangMaiNativeExpressAd wangMaiNativeExpressAd = WangMaiNativeExpressAd.this;
                wangMaiNativeExpressAd.showLog(wangMaiNativeExpressAd.OooO00o, "onAdClose");
                WangMaiNativeExpressAd.this.notifyAdDislikeClick();
            }

            public void onAdRequest() {
                WangMaiNativeExpressAd wangMaiNativeExpressAd = WangMaiNativeExpressAd.this;
                wangMaiNativeExpressAd.showLog(wangMaiNativeExpressAd.OooO00o, "onAdRequest");
                try {
                    WangMaiNativeExpressAd.this.OooO0o = oO.LOAD_SUCC.OooO00o();
                    if (oo000oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                        int ecpm = WangMaiNativeExpressAd.this.OooO0O0.getECPM();
                        WangMaiNativeExpressAd wangMaiNativeExpressAd2 = WangMaiNativeExpressAd.this;
                        wangMaiNativeExpressAd2.showLog(wangMaiNativeExpressAd2.OooO00o, "ecpm:" + ecpm + "分");
                        oo000oVar.setBiddingEcpm(ecpm);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(WangMaiNativeExpressAd.this);
                    oo000o oo000oVar2 = oo000oVar;
                    oo000oVar2.OooO00o = arrayList;
                    WangMaiNativeExpressAd.this.onAdDataLoaded(oo000oVar2);
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            public void onClick() {
                WangMaiNativeExpressAd wangMaiNativeExpressAd = WangMaiNativeExpressAd.this;
                wangMaiNativeExpressAd.showLog(wangMaiNativeExpressAd.OooO00o, "onClick");
                WangMaiNativeExpressAd.this.notifyAdClicked();
            }

            public void onExposure() {
                WangMaiNativeExpressAd wangMaiNativeExpressAd = WangMaiNativeExpressAd.this;
                wangMaiNativeExpressAd.showLog(wangMaiNativeExpressAd.OooO00o, "onExposure");
                WangMaiNativeExpressAd.this.notifyAdExposure();
            }

            public void onNoAd(String str2) {
                WangMaiNativeExpressAd wangMaiNativeExpressAd = WangMaiNativeExpressAd.this;
                wangMaiNativeExpressAd.showLog(wangMaiNativeExpressAd.OooO00o, "onNoAd -> " + str2);
                if (WangMaiNativeExpressAd.this.OooO0o == oO.LOAD_SUCC.OooO00o()) {
                    if (WangMaiNativeExpressAd.this.OooO0oO) {
                        WangMaiNativeExpressAd.this.notifyAdVideoError();
                    }
                } else if (WangMaiNativeExpressAd.this.loadListener != null) {
                    WangMaiNativeExpressAd.this.loadListener.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, oOO00O0.ubix_no_ad, str2).setInfo((Object) oo000oVar));
                }
            }

            public void onRenderSuccess(View view, int i, int i2) {
                WangMaiNativeExpressAd wangMaiNativeExpressAd = WangMaiNativeExpressAd.this;
                wangMaiNativeExpressAd.showLog(wangMaiNativeExpressAd.OooO00o, "onRenderSuccess");
                if (view == null) {
                    WangMaiNativeExpressAd wangMaiNativeExpressAd2 = WangMaiNativeExpressAd.this;
                    oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.RENDER_FAIL;
                    wangMaiNativeExpressAd2.onADRenderFail(oooO00o.OooO00o(), oooO00o.OooO0O0(), oo000oVar);
                } else {
                    WangMaiNativeExpressAd.this.OooO0Oo = view;
                    if (WangMaiNativeExpressAd.this.loadListener != null) {
                        WangMaiNativeExpressAd.this.loadListener.onAdCacheSuccess(oo000oVar);
                    }
                }
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            WMAdNativeExpress wMAdNativeExpress = this.OooO0O0;
            if (wMAdNativeExpress != null) {
                wMAdNativeExpress.sendWinNotificationWithInfo((Bundle) null);
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }
}
