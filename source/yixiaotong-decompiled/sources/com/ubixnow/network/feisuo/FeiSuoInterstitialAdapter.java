package com.ubixnow.network.feisuo;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.huawei.openalliance.ad.constant.br;
import com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.OooOo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import com.zm.fissionsdk.api.FissionSdk;
import com.zm.fissionsdk.api.FissionSlot;
import com.zm.fissionsdk.api.interfaces.IFissionInterstitial;
import com.zm.fissionsdk.api.interfaces.IFissionLoadManager;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class FeiSuoInterstitialAdapter extends UMNCustomInterstitalAdapter {
    private final String OooO00o = this.customTag + getClass().getSimpleName();
    private IFissionInterstitial OooO0O0;
    private int OooO0OO;

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o() {
        IFissionInterstitial iFissionInterstitial = this.OooO0O0;
        if (iFissionInterstitial != null) {
            iFissionInterstitial.setInterstitialInteractionListener(new IFissionInterstitial.InterstitialInteractionListener() { // from class: com.ubixnow.network.feisuo.FeiSuoInterstitialAdapter.3
                public void onClick(View view) {
                    FeiSuoInterstitialAdapter feiSuoInterstitialAdapter = FeiSuoInterstitialAdapter.this;
                    feiSuoInterstitialAdapter.showLog(feiSuoInterstitialAdapter.OooO00o, "onClick");
                    if (FeiSuoInterstitialAdapter.this.eventListener != null) {
                        FeiSuoInterstitialAdapter.this.eventListener.onAdClick(FeiSuoInterstitialAdapter.this.absUbixInfo);
                    }
                }

                public void onClose() {
                    FeiSuoInterstitialAdapter feiSuoInterstitialAdapter = FeiSuoInterstitialAdapter.this;
                    feiSuoInterstitialAdapter.showLog(feiSuoInterstitialAdapter.OooO00o, "onClose");
                    if (FeiSuoInterstitialAdapter.this.eventListener != null) {
                        FeiSuoInterstitialAdapter.this.eventListener.onAdDismiss(FeiSuoInterstitialAdapter.this.absUbixInfo);
                    }
                }

                public void onShow() {
                    FeiSuoInterstitialAdapter feiSuoInterstitialAdapter = FeiSuoInterstitialAdapter.this;
                    feiSuoInterstitialAdapter.showLog(feiSuoInterstitialAdapter.OooO00o, "onShow");
                    if (FeiSuoInterstitialAdapter.this.eventListener != null) {
                        FeiSuoInterstitialAdapter.this.eventListener.onAdShow(FeiSuoInterstitialAdapter.this.absUbixInfo);
                    }
                }

                public void onShowFailed(int i, String str) {
                    FeiSuoInterstitialAdapter feiSuoInterstitialAdapter = FeiSuoInterstitialAdapter.this;
                    feiSuoInterstitialAdapter.showLog(feiSuoInterstitialAdapter.OooO00o, "onAdShowError code:" + i + " msg:" + str);
                    if (FeiSuoInterstitialAdapter.this.eventListener != null) {
                        FeiSuoInterstitialAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, i + "", str).setInfo((Object) FeiSuoInterstitialAdapter.this.absUbixInfo));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(Context context, o00O000 o00o000) {
        FissionSdk.getLoadManager().loadInterstitial(new FissionSlot.Builder().setContext(context).setRequestId(o00o000.OooO0oO).setSlotType(3).setSlotId(o00o000.OooO00o.OooO0o0).setCount(1).build(), new IFissionLoadManager.AsyncInterstitialLoadListener() { // from class: com.ubixnow.network.feisuo.FeiSuoInterstitialAdapter.2
            public void onError(int i, String str) {
                FeiSuoInterstitialAdapter feiSuoInterstitialAdapter = FeiSuoInterstitialAdapter.this;
                feiSuoInterstitialAdapter.showLog(feiSuoInterstitialAdapter.OooO00o, "onError:code:" + i + "  msg:" + str);
                FeiSuoInterstitialAdapter.this.onAdDataLoadFailed(i, str);
            }

            public void onLoad(List<IFissionInterstitial> list) {
                try {
                    FeiSuoInterstitialAdapter feiSuoInterstitialAdapter = FeiSuoInterstitialAdapter.this;
                    feiSuoInterstitialAdapter.showLog(feiSuoInterstitialAdapter.OooO00o, "onLoad");
                    FeiSuoInterstitialAdapter.this.OooO0O0 = list.get(0);
                    FeiSuoInterstitialAdapter feiSuoInterstitialAdapter2 = FeiSuoInterstitialAdapter.this;
                    if (feiSuoInterstitialAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                        feiSuoInterstitialAdapter2.showLog(feiSuoInterstitialAdapter2.OooO00o, "price:" + FeiSuoInterstitialAdapter.this.OooO0O0.getECpm());
                        FeiSuoInterstitialAdapter feiSuoInterstitialAdapter3 = FeiSuoInterstitialAdapter.this;
                        feiSuoInterstitialAdapter3.OooO0OO = feiSuoInterstitialAdapter3.OooO0O0.getECpm();
                        FeiSuoInterstitialAdapter feiSuoInterstitialAdapter4 = FeiSuoInterstitialAdapter.this;
                        feiSuoInterstitialAdapter4.absUbixInfo.setBiddingEcpm(feiSuoInterstitialAdapter4.OooO0O0.getECpm());
                    }
                    FeiSuoInterstitialAdapter.this.onAdDataLoaded();
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            public void onMaterialCacheFailed(int i, String str) {
                FeiSuoInterstitialAdapter feiSuoInterstitialAdapter = FeiSuoInterstitialAdapter.this;
                feiSuoInterstitialAdapter.showLog(feiSuoInterstitialAdapter.OooO00o, "onMaterialCacheFailed");
                FeiSuoInterstitialAdapter.this.onAdRenderFail(i + "", str);
            }

            public void onMaterialCached() {
                FeiSuoInterstitialAdapter feiSuoInterstitialAdapter = FeiSuoInterstitialAdapter.this;
                feiSuoInterstitialAdapter.showLog(feiSuoInterstitialAdapter.OooO00o, "onMaterialCached");
                FeiSuoInterstitialAdapter.this.OooO00o();
                FeiSuoInterstitialAdapter feiSuoInterstitialAdapter2 = FeiSuoInterstitialAdapter.this;
                if (feiSuoInterstitialAdapter2.loadListener == null || feiSuoInterstitialAdapter2.OooO0O0 == null) {
                    return;
                }
                FeiSuoInterstitialAdapter feiSuoInterstitialAdapter3 = FeiSuoInterstitialAdapter.this;
                feiSuoInterstitialAdapter3.loadListener.onAdCacheSuccess(feiSuoInterstitialAdapter3.absUbixInfo);
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        showLog(this.OooO00o, "destroy");
        IFissionInterstitial iFissionInterstitial = this.OooO0O0;
        if (iFissionInterstitial != null) {
            iFissionInterstitial.destroy();
        }
    }

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void loadInterstitalAd(Context context, final o00O000 o00o000) {
        createADInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(this.adsSlotid)) {
            FeiSuoInitManager.getInstance().initSDK(context, o00o000, new o00O0OO0() { // from class: com.ubixnow.network.feisuo.FeiSuoInterstitialAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = FeiSuoInterstitialAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", FeiSuoInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) FeiSuoInterstitialAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    FeiSuoInterstitialAdapter.this.OooO00o(BaseUtils.getContext(), o00o000);
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, FeiSuoInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            IFissionInterstitial iFissionInterstitial = this.OooO0O0;
            if (iFissionInterstitial != null) {
                iFissionInterstitial.onBidFail(FeiSuoUtils.getFailInfo(o00oo0oo), "");
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyLoss:" + FeiSuoUtils.getFailInfo(o00oo0oo));
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            IFissionInterstitial iFissionInterstitial = this.OooO0O0;
            if (iFissionInterstitial != null) {
                iFissionInterstitial.onBidSuccess(this.OooO0OO + "");
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyWin:" + this.OooO0OO);
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void show(Activity activity) {
        showLog(this.OooO00o, br.b.V);
        IFissionInterstitial iFissionInterstitial = this.OooO0O0;
        if (iFissionInterstitial != null && activity != null) {
            iFissionInterstitial.showInterstitial(activity);
            return;
        }
        showLog(this.OooO00o, "showError");
        OooOo oooOo = this.eventListener;
        if (oooOo != null) {
            oooOo.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg).setInfo((Object) this.absUbixInfo));
        }
    }
}
