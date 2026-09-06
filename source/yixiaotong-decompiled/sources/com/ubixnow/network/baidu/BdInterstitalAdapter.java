package com.ubixnow.network.baidu;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.ubixnow.adtype.interstital.api.UMNInterstitalParams;
import com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00000;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class BdInterstitalAdapter extends UMNCustomInterstitalAdapter {
    private final String OooO00o = this.customTag + BdInitManager.getInstance().getName();
    private ExpressInterstitialAd OooO0O0;
    private boolean OooO0OO;
    private int OooO0Oo;

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        showLog(this.OooO00o, "destory");
        ExpressInterstitialAd expressInterstitialAd = this.OooO0O0;
        if (expressInterstitialAd != null) {
            expressInterstitialAd.destroy();
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        if (this.OooO0O0 == null) {
            return false;
        }
        if (ooooO000.OooO00o) {
            ooooO000.OooO0OO(this.OooO00o, "isValid " + this.OooO0O0.isReady());
        }
        return this.OooO0O0.isReady();
    }

    public void loadAd(final o00O000 o00o000) {
        UMNInterstitalParams uMNInterstitalParams = (UMNInterstitalParams) o00o000.OooO0o0;
        this.mParams = uMNInterstitalParams;
        int iOooO0O0 = uMNInterstitalParams.width;
        if (iOooO0O0 == 0) {
            oOO00000.OooO00o();
            iOooO0O0 = oOO00000.OooO0O0(oOO00000.OooO0o(this.mContext));
        }
        UMNInterstitalParams uMNInterstitalParams2 = this.mParams;
        int i = uMNInterstitalParams2.height;
        if (i == 0) {
            i = (iOooO0O0 * 2) / 3;
        } else {
            int i2 = uMNInterstitalParams2.width;
            double d = i2 / i;
            if (d < 1.2d || d > 1.8d) {
                i = (int) (((double) i2) / 1.5d);
            }
        }
        ExpressInterstitialAd expressInterstitialAd = new ExpressInterstitialAd(this.mContext, this.adsSlotid, iOooO0O0, i);
        this.OooO0O0 = expressInterstitialAd;
        expressInterstitialAd.setLoadListener(new ExpressInterstitialListener() { // from class: com.ubixnow.network.baidu.BdInterstitalAdapter.2
            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onADExposed() {
                BdInterstitalAdapter bdInterstitalAdapter = BdInterstitalAdapter.this;
                bdInterstitalAdapter.showLog(bdInterstitalAdapter.OooO00o, "onADExposed");
                if (BdInterstitalAdapter.this.eventListener != null) {
                    BdInterstitalAdapter.this.eventListener.onAdShow(BdInterstitalAdapter.this.absUbixInfo);
                }
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onADExposureFailed() {
                BdInterstitalAdapter bdInterstitalAdapter = BdInterstitalAdapter.this;
                bdInterstitalAdapter.showLog(bdInterstitalAdapter.OooO00o, "onADExposureFailed");
                if (BdInterstitalAdapter.this.eventListener != null) {
                    BdInterstitalAdapter.this.eventListener.onShowError(new ErrorInfo("-1", "onADExposureFailed").setInfo((Object) BdInterstitalAdapter.this.absUbixInfo));
                }
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onADLoaded() {
                try {
                    BdInterstitalAdapter bdInterstitalAdapter = BdInterstitalAdapter.this;
                    bdInterstitalAdapter.showLog(bdInterstitalAdapter.OooO00o, "----onADLoaded： " + (BdInterstitalAdapter.this.loadListener != null));
                    BdInterstitalAdapter bdInterstitalAdapter2 = BdInterstitalAdapter.this;
                    if (bdInterstitalAdapter2.loadListener != null) {
                        if (bdInterstitalAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            bdInterstitalAdapter2.showLog(bdInterstitalAdapter2.OooO00o, "price:" + BdInterstitalAdapter.this.OooO0O0.getECPMLevel());
                            BdInterstitalAdapter bdInterstitalAdapter3 = BdInterstitalAdapter.this;
                            bdInterstitalAdapter3.absUbixInfo.setBiddingEcpm(bdInterstitalAdapter3.getIntegerValue(bdInterstitalAdapter3.OooO0O0.getECPMLevel()));
                        }
                        BdInterstitalAdapter.this.onAdDataLoaded();
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onAdCacheFailed() {
                BdInterstitalAdapter bdInterstitalAdapter = BdInterstitalAdapter.this;
                bdInterstitalAdapter.showLog(bdInterstitalAdapter.OooO00o, "onAdCacheFailed");
                BdInterstitalAdapter bdInterstitalAdapter2 = BdInterstitalAdapter.this;
                oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.RENDER_FAIL;
                bdInterstitalAdapter2.onAdRenderFail(oooO00o.OooO00o(), BdInitManager.getInstance().getName() + oooO00o.OooO0O0());
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onAdCacheSuccess() {
                BdInterstitalAdapter bdInterstitalAdapter = BdInterstitalAdapter.this;
                bdInterstitalAdapter.showLog(bdInterstitalAdapter.OooO00o, "onAdCacheSuccess");
                try {
                    BdInterstitalAdapter bdInterstitalAdapter2 = BdInterstitalAdapter.this;
                    if (bdInterstitalAdapter2.loadListener != null) {
                        if (bdInterstitalAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            bdInterstitalAdapter2.OooO0Oo = bdInterstitalAdapter2.getIntegerValue(bdInterstitalAdapter2.OooO0O0.getECPMLevel());
                            BdInterstitalAdapter bdInterstitalAdapter3 = BdInterstitalAdapter.this;
                            bdInterstitalAdapter3.showLog(bdInterstitalAdapter3.OooO00o, "price:" + BdInterstitalAdapter.this.OooO0Oo);
                            BdInterstitalAdapter bdInterstitalAdapter4 = BdInterstitalAdapter.this;
                            bdInterstitalAdapter4.absUbixInfo.setBiddingEcpm(bdInterstitalAdapter4.OooO0Oo);
                        }
                        BdInterstitalAdapter bdInterstitalAdapter5 = BdInterstitalAdapter.this;
                        bdInterstitalAdapter5.loadListener.onAdCacheSuccess(bdInterstitalAdapter5.absUbixInfo);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onAdClick() {
                BdInterstitalAdapter bdInterstitalAdapter = BdInterstitalAdapter.this;
                bdInterstitalAdapter.showLog(bdInterstitalAdapter.OooO00o, IAdInterListener.AdCommandType.AD_CLICK);
                try {
                    if (BdInterstitalAdapter.this.eventListener != null) {
                        BdInterstitalAdapter.this.eventListener.onAdClick(BdInterstitalAdapter.this.absUbixInfo);
                    }
                    BaseDevConfig baseDevConfig = o00o000.OooO0o0;
                    if ((baseDevConfig instanceof UMNInterstitalParams) && ((UMNInterstitalParams) baseDevConfig).closeAfterClick) {
                        BaseUtils.postDelayed(new Runnable() { // from class: com.ubixnow.network.baidu.BdInterstitalAdapter.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (BdInterstitalAdapter.this.OooO0O0 == null || BdInterstitalAdapter.this.OooO0OO) {
                                    return;
                                }
                                BdInterstitalAdapter.this.OooO0OO = true;
                                if (BdInterstitalAdapter.this.eventListener != null) {
                                    BdInterstitalAdapter.this.eventListener.onAdDismiss(BdInterstitalAdapter.this.absUbixInfo);
                                }
                                BdInterstitalAdapter.this.OooO0O0.destroy();
                            }
                        }, 1000L);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onAdClose() {
                BdInterstitalAdapter bdInterstitalAdapter = BdInterstitalAdapter.this;
                bdInterstitalAdapter.showLog(bdInterstitalAdapter.OooO00o, "onAdClose");
                if (BdInterstitalAdapter.this.eventListener == null || BdInterstitalAdapter.this.OooO0OO) {
                    return;
                }
                BdInterstitalAdapter.this.OooO0OO = true;
                BdInterstitalAdapter.this.eventListener.onAdDismiss(BdInterstitalAdapter.this.absUbixInfo);
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onAdFailed(int i3, String str) {
                BdInterstitalAdapter bdInterstitalAdapter = BdInterstitalAdapter.this;
                bdInterstitalAdapter.showLog(bdInterstitalAdapter.OooO00o, "onAdFailed code:" + i3 + "msg:" + str);
                BdInterstitalAdapter.this.onAdDataLoadFailed(i3, str);
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onLpClosed() {
                BdInterstitalAdapter bdInterstitalAdapter = BdInterstitalAdapter.this;
                bdInterstitalAdapter.showLog(bdInterstitalAdapter.OooO00o, "onLpClosed");
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onNoAd(int i3, String str) {
                BdInterstitalAdapter bdInterstitalAdapter = BdInterstitalAdapter.this;
                bdInterstitalAdapter.showLog(bdInterstitalAdapter.OooO00o, "onNoAd code:" + i3 + "msg:" + str);
                BdInterstitalAdapter.this.onAdDataLoadFailed(i3, str);
            }

            public void onVideoDownloadFailed() {
                BdInterstitalAdapter bdInterstitalAdapter = BdInterstitalAdapter.this;
                bdInterstitalAdapter.showLog(bdInterstitalAdapter.OooO00o, "onVideoDownloadFailed");
            }

            public void onVideoDownloadSuccess() {
                BdInterstitalAdapter bdInterstitalAdapter = BdInterstitalAdapter.this;
                bdInterstitalAdapter.showLog(bdInterstitalAdapter.OooO00o, "onVideoDownloadSuccess");
            }
        });
        try {
            this.OooO0O0.setAppSid(o00o000.OooO00o.OooO0Oo);
            o00O000 o00o001 = this.mBaseAdConfig;
            if (o00o001.OooO00o.OooOO0O == 1) {
                this.OooO0O0.setBidFloor((int) o00o001.OooO);
            }
            this.OooO0O0.setDialogFrame(true);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
        this.OooO0O0.load();
    }

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void loadInterstitalAd(Context context, final o00O000 o00o000) {
        this.mContext = context;
        createADInfo(o00o000);
        showLog(this.OooO00o, "adsSlotid " + this.adsSlotid);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(this.adsSlotid)) {
            BdInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.baidu.BdInterstitalAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = BdInterstitalAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", BdInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) BdInterstitalAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    BdInterstitalAdapter.this.loadAd(o00o000);
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, BdInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
    }

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void show(Activity activity) {
        ExpressInterstitialAd expressInterstitialAd;
        showLog(this.OooO00o, "---show  " + (activity != null) + PPSLabelView.Code + (this.OooO0O0 != null));
        if (activity == null || activity.isFinishing() || (expressInterstitialAd = this.OooO0O0) == null) {
            return;
        }
        expressInterstitialAd.show(activity);
    }
}
