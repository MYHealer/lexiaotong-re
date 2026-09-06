package com.ubixnow.network.baidu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.stub.StubApp;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.bean.UMNNativeExtraInfo;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class BdNativeExpressAd extends UMNCustomNativeAd {
    private final String OooO00o = "-----BdNativeExpressAd";
    public BaiduNativeManager OooO0O0;
    public ExpressResponse OooO0OO;
    private long OooO0Oo;

    public BdNativeExpressAd(Context context, UMNNativeParams uMNNativeParams, String str, oo000o oo000oVar) {
        this.configInfo = oo000oVar;
        this.OooO0O0 = new BaiduNativeManager(StubApp.getOrigApplicationContext(context.getApplicationContext()), str);
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00oOoo
    public void destroy() {
        showLog(this.OooO00o, "destroy");
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        try {
            return this.OooO0OO.getExpressAdView();
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return null;
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public boolean isValid() {
        if (this.OooO0OO == null) {
            return false;
        }
        if (ooooO000.OooO00o) {
            ooooO000.OooO0OO(this.OooO00o, "isValid " + this.OooO0OO.isReady(BaseUtils.getContext()));
        }
        return this.OooO0OO.isReady(BaseUtils.getContext());
    }

    public void loadAd(final oo000o oo000oVar, final o00O00o0 o00o00o0) {
        try {
            this.OooO0O0.setAppSid(oo000oVar.getBaseAdConfig().OooO00o.OooO0Oo);
            if (oo000oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                this.OooO0O0.setBidFloor((int) oo000oVar.getBaseAdConfig().OooO);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
        this.OooO0O0.loadExpressAd(null, new BaiduNativeManager.ExpressAdListener() { // from class: com.ubixnow.network.baidu.BdNativeExpressAd.2
            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onLpClosed() {
                BdNativeExpressAd bdNativeExpressAd = BdNativeExpressAd.this;
                bdNativeExpressAd.showLog(bdNativeExpressAd.OooO00o, "onLpClosed");
            }

            public void onNativeFail(int i, String str) {
                BdNativeExpressAd bdNativeExpressAd = BdNativeExpressAd.this;
                bdNativeExpressAd.showLog(bdNativeExpressAd.OooO00o, " onNativeFail code:" + i + "  msg:" + str);
                o00O00o0 o00o00o1 = o00o00o0;
                if (o00o00o1 != null) {
                    o00o00o1.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str).setInfo((Object) oo000oVar));
                }
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onNativeFail(int i, String str, ExpressResponse expressResponse) {
                BdNativeExpressAd bdNativeExpressAd = BdNativeExpressAd.this;
                bdNativeExpressAd.showLog(bdNativeExpressAd.OooO00o, " onNativeFail code:" + i + "  msg:" + str);
                o00O00o0 o00o00o1 = o00o00o0;
                if (o00o00o1 != null) {
                    o00o00o1.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str).setInfo((Object) oo000oVar));
                }
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onNativeLoad(List<ExpressResponse> list) {
                BdNativeExpressAd bdNativeExpressAd = BdNativeExpressAd.this;
                bdNativeExpressAd.showLog(bdNativeExpressAd.OooO00o, "onNativeLoad");
                if (list == null || list.size() <= 0) {
                    return;
                }
                BdNativeExpressAd.this.OooO0OO = list.get(0);
                BdNativeExpressAd.this.OooO0OO.render();
                try {
                    if (oo000oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                        BdNativeExpressAd bdNativeExpressAd2 = BdNativeExpressAd.this;
                        bdNativeExpressAd2.OooO0Oo = bdNativeExpressAd2.getIntegerValue(bdNativeExpressAd2.OooO0OO.getECPMLevel());
                        BdNativeExpressAd bdNativeExpressAd3 = BdNativeExpressAd.this;
                        bdNativeExpressAd3.showLog(bdNativeExpressAd3.OooO00o, "price:" + BdNativeExpressAd.this.OooO0Oo);
                        oo000oVar.setBiddingEcpm((int) BdNativeExpressAd.this.OooO0Oo);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(BdNativeExpressAd.this);
                oo000o oo000oVar2 = oo000oVar;
                oo000oVar2.OooO00o = arrayList;
                o00O00o0 o00o00o1 = o00o00o0;
                if (o00o00o1 != null) {
                    o00o00o1.onAdCacheSuccess(oo000oVar2);
                }
                BdNativeExpressAd.this.OooO0OO.setAdDislikeListener(new ExpressResponse.ExpressDislikeListener() { // from class: com.ubixnow.network.baidu.BdNativeExpressAd.2.1
                    public void onDislikeItemClick() {
                        BdNativeExpressAd bdNativeExpressAd4 = BdNativeExpressAd.this;
                        bdNativeExpressAd4.showLog(bdNativeExpressAd4.OooO00o, "onDislikeItemClick");
                        BdNativeExpressAd.this.notifyAdDislikeClick();
                    }

                    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                    public void onDislikeItemClick(String str) {
                        BdNativeExpressAd bdNativeExpressAd4 = BdNativeExpressAd.this;
                        bdNativeExpressAd4.showLog(bdNativeExpressAd4.OooO00o, "onDislikeItemClick");
                        BdNativeExpressAd.this.notifyAdDislikeClick();
                    }

                    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                    public void onDislikeWindowClose() {
                        BdNativeExpressAd bdNativeExpressAd4 = BdNativeExpressAd.this;
                        bdNativeExpressAd4.showLog(bdNativeExpressAd4.OooO00o, "onDislikeWindowClose");
                    }

                    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                    public void onDislikeWindowShow() {
                        BdNativeExpressAd bdNativeExpressAd4 = BdNativeExpressAd.this;
                        bdNativeExpressAd4.showLog(bdNativeExpressAd4.OooO00o, "onDislikeWindowShow");
                    }
                });
            }

            public void onNoAd(int i, String str) {
                BdNativeExpressAd bdNativeExpressAd = BdNativeExpressAd.this;
                bdNativeExpressAd.showLog(bdNativeExpressAd.OooO00o, " onNoAd code:" + i + "  msg:" + str);
                o00O00o0 o00o00o1 = o00o00o0;
                if (o00o00o1 != null) {
                    o00o00o1.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str).setInfo((Object) oo000oVar));
                }
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onNoAd(int i, String str, ExpressResponse expressResponse) {
                BdNativeExpressAd bdNativeExpressAd = BdNativeExpressAd.this;
                bdNativeExpressAd.showLog(bdNativeExpressAd.OooO00o, " onNoAd code:" + i + "  msg:" + str);
                o00O00o0 o00o00o1 = o00o00o0;
                if (o00o00o1 != null) {
                    o00o00o1.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str).setInfo((Object) oo000oVar));
                }
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onVideoDownloadFailed() {
                BdNativeExpressAd bdNativeExpressAd = BdNativeExpressAd.this;
                bdNativeExpressAd.showLog(bdNativeExpressAd.OooO00o, "onVideoDownloadFailed");
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onVideoDownloadSuccess() {
                BdNativeExpressAd bdNativeExpressAd = BdNativeExpressAd.this;
                bdNativeExpressAd.showLog(bdNativeExpressAd.OooO00o, "onVideoDownloadSuccess");
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyLoss(o00OO0OO o00oo0oo) {
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyWin(o00OO0OO o00oo0oo) {
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void regist(ViewGroup viewGroup, UMNNativeExtraInfo uMNNativeExtraInfo) {
        this.OooO0OO.setInteractionListener(new ExpressResponse.ExpressInteractionListener() { // from class: com.ubixnow.network.baidu.BdNativeExpressAd.1
            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdClick() {
                BdNativeExpressAd bdNativeExpressAd = BdNativeExpressAd.this;
                bdNativeExpressAd.showLog(bdNativeExpressAd.OooO00o, "onAdClicked");
                BdNativeExpressAd.this.notifyAdClicked();
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdExposed() {
                BdNativeExpressAd bdNativeExpressAd = BdNativeExpressAd.this;
                bdNativeExpressAd.showLog(bdNativeExpressAd.OooO00o, "onAdExposed");
                BdNativeExpressAd.this.notifyAdExposure();
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdRenderFail(View view, String str, int i) {
                BdNativeExpressAd bdNativeExpressAd = BdNativeExpressAd.this;
                bdNativeExpressAd.showLog(bdNativeExpressAd.OooO00o, "onAdRenderFail code" + i + " msg:" + str);
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdRenderSuccess(View view, float f, float f2) {
                BdNativeExpressAd bdNativeExpressAd = BdNativeExpressAd.this;
                bdNativeExpressAd.showLog(bdNativeExpressAd.OooO00o, "onAdRenderSuccess");
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdUnionClick() {
                BdNativeExpressAd bdNativeExpressAd = BdNativeExpressAd.this;
                bdNativeExpressAd.showLog(bdNativeExpressAd.OooO00o, "onAdUnionClick");
            }
        });
    }
}
