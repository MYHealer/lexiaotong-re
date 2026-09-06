package com.ubixnow.network.feisuo;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.constant.br;
import com.ubixnow.adtype.splash.custom.UMNCustomSplashAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o000O0O0;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import com.zm.fissionsdk.api.FissionSdk;
import com.zm.fissionsdk.api.FissionSlot;
import com.zm.fissionsdk.api.interfaces.IFissionLoadManager;
import com.zm.fissionsdk.api.interfaces.IFissionSplash;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class FeiSuoSplashAdapter extends UMNCustomSplashAdapter {
    private final String OooO00o = this.customTag + getClass().getSimpleName();
    private IFissionSplash OooO0O0;
    private int OooO0OO;

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o() {
        IFissionSplash iFissionSplash = this.OooO0O0;
        if (iFissionSplash != null) {
            iFissionSplash.setSplashInteractionListener(new IFissionSplash.SplashInteractionListener() { // from class: com.ubixnow.network.feisuo.FeiSuoSplashAdapter.3
                public void onClick(View view) {
                    FeiSuoSplashAdapter feiSuoSplashAdapter = FeiSuoSplashAdapter.this;
                    feiSuoSplashAdapter.showLog(feiSuoSplashAdapter.OooO00o, "onClick");
                    if (FeiSuoSplashAdapter.this.eventListener != null) {
                        FeiSuoSplashAdapter.this.eventListener.onAdClick(FeiSuoSplashAdapter.this.splashInfo);
                    }
                }

                public void onClose() {
                    FeiSuoSplashAdapter feiSuoSplashAdapter = FeiSuoSplashAdapter.this;
                    feiSuoSplashAdapter.showLog(feiSuoSplashAdapter.OooO00o, "onClose");
                    if (FeiSuoSplashAdapter.this.eventListener != null) {
                        FeiSuoSplashAdapter.this.eventListener.onAdDismiss(FeiSuoSplashAdapter.this.splashInfo);
                    }
                }

                public void onPresent() {
                    FeiSuoSplashAdapter feiSuoSplashAdapter = FeiSuoSplashAdapter.this;
                    feiSuoSplashAdapter.showLog(feiSuoSplashAdapter.OooO00o, "onPresent");
                }

                public void onShow() {
                    FeiSuoSplashAdapter feiSuoSplashAdapter = FeiSuoSplashAdapter.this;
                    feiSuoSplashAdapter.showLog(feiSuoSplashAdapter.OooO00o, "onShow");
                    if (FeiSuoSplashAdapter.this.eventListener != null) {
                        FeiSuoSplashAdapter.this.eventListener.onAdShow(FeiSuoSplashAdapter.this.splashInfo);
                    }
                }

                public void onShowFailed(int i, String str) {
                    FeiSuoSplashAdapter feiSuoSplashAdapter = FeiSuoSplashAdapter.this;
                    feiSuoSplashAdapter.showLog(feiSuoSplashAdapter.OooO00o, "onAdShowError code:" + i + " msg:" + str);
                    if (FeiSuoSplashAdapter.this.eventListener != null) {
                        FeiSuoSplashAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, i + "", str).setInfo((Object) FeiSuoSplashAdapter.this.splashInfo));
                    }
                }

                public void onSkip() {
                    FeiSuoSplashAdapter feiSuoSplashAdapter = FeiSuoSplashAdapter.this;
                    feiSuoSplashAdapter.showLog(feiSuoSplashAdapter.OooO00o, "onSkip");
                    if (FeiSuoSplashAdapter.this.eventListener != null) {
                        FeiSuoSplashAdapter feiSuoSplashAdapter2 = FeiSuoSplashAdapter.this;
                        feiSuoSplashAdapter2.splashInfo.OooO00o = true;
                        feiSuoSplashAdapter2.eventListener.onAdDismiss(FeiSuoSplashAdapter.this.splashInfo);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(Context context, o00O000 o00o000) {
        FissionSdk.getLoadManager().loadSplash(new FissionSlot.Builder().setContext(context).setRequestId(o00o000.OooO0oO).setSlotType(2).setSlotId(o00o000.OooO00o.OooO0o0).setCount(1).build(), new IFissionLoadManager.AsyncSplashLoadListener() { // from class: com.ubixnow.network.feisuo.FeiSuoSplashAdapter.2
            public void onError(int i, String str) {
                FeiSuoSplashAdapter feiSuoSplashAdapter = FeiSuoSplashAdapter.this;
                feiSuoSplashAdapter.showLog(feiSuoSplashAdapter.OooO00o, "onError:code:" + i + "  msg:" + str);
                FeiSuoSplashAdapter.this.onAdDataLoadFailed(i + "", str);
            }

            public void onLoad(List<IFissionSplash> list) {
                try {
                    FeiSuoSplashAdapter feiSuoSplashAdapter = FeiSuoSplashAdapter.this;
                    feiSuoSplashAdapter.showLog(feiSuoSplashAdapter.OooO00o, "onLoad");
                    FeiSuoSplashAdapter.this.OooO0O0 = list.get(0);
                    FeiSuoSplashAdapter feiSuoSplashAdapter2 = FeiSuoSplashAdapter.this;
                    if (feiSuoSplashAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                        feiSuoSplashAdapter2.showLog(feiSuoSplashAdapter2.OooO00o, "price:" + FeiSuoSplashAdapter.this.OooO0O0.getECpm());
                        FeiSuoSplashAdapter feiSuoSplashAdapter3 = FeiSuoSplashAdapter.this;
                        feiSuoSplashAdapter3.OooO0OO = feiSuoSplashAdapter3.OooO0O0.getECpm();
                        FeiSuoSplashAdapter feiSuoSplashAdapter4 = FeiSuoSplashAdapter.this;
                        feiSuoSplashAdapter4.splashInfo.setBiddingEcpm(feiSuoSplashAdapter4.OooO0O0.getECpm());
                    }
                    FeiSuoSplashAdapter.this.onAdDataLoaded();
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            public void onMaterialCacheFailed(int i, String str) {
                FeiSuoSplashAdapter feiSuoSplashAdapter = FeiSuoSplashAdapter.this;
                feiSuoSplashAdapter.showLog(feiSuoSplashAdapter.OooO00o, "onMaterialCacheFailed");
                FeiSuoSplashAdapter.this.onRenderFail(i, str);
            }

            public void onMaterialCached() {
                FeiSuoSplashAdapter feiSuoSplashAdapter = FeiSuoSplashAdapter.this;
                feiSuoSplashAdapter.showLog(feiSuoSplashAdapter.OooO00o, "onMaterialCached");
                FeiSuoSplashAdapter.this.OooO00o();
                FeiSuoSplashAdapter feiSuoSplashAdapter2 = FeiSuoSplashAdapter.this;
                if (feiSuoSplashAdapter2.loadListener == null || feiSuoSplashAdapter2.OooO0O0 == null) {
                    return;
                }
                FeiSuoSplashAdapter feiSuoSplashAdapter3 = FeiSuoSplashAdapter.this;
                feiSuoSplashAdapter3.loadListener.onAdCacheSuccess(feiSuoSplashAdapter3.splashInfo);
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00OO00O, com.ubixnow.ooooo.o00O
    public void destory() {
        showLog(this.OooO00o, "destroy");
        IFissionSplash iFissionSplash = this.OooO0O0;
        if (iFissionSplash != null) {
            iFissionSplash.destroy();
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        showLog(this.OooO00o, "isValid");
        IFissionSplash iFissionSplash = this.OooO0O0;
        if (iFissionSplash != null) {
            return iFissionSplash.isReady();
        }
        return false;
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void loadSplashAd(Context context, final o00O000 o00o000) {
        createSplashInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            FeiSuoInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.feisuo.FeiSuoSplashAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    ooooO000.OooO0OO(FeiSuoSplashAdapter.this.OooO00o, "initSDK error");
                    o00O00o0 o00o00o0 = FeiSuoSplashAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", FeiSuoInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) FeiSuoSplashAdapter.this.splashInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    ooooO000.OooO0OO(FeiSuoSplashAdapter.this.OooO00o, "initSDK success");
                    FeiSuoSplashAdapter.this.OooO00o(BaseUtils.getContext(), o00o000);
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, FeiSuoInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.splashInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            IFissionSplash iFissionSplash = this.OooO0O0;
            if (iFissionSplash != null) {
                iFissionSplash.onBidFail(FeiSuoUtils.getFailInfo(o00oo0oo), "");
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
            IFissionSplash iFissionSplash = this.OooO0O0;
            if (iFissionSplash != null) {
                iFissionSplash.onBidSuccess(this.OooO0OO + "");
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyWin:" + this.OooO0OO);
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void show(ViewGroup viewGroup) {
        showLog(this.OooO00o, br.b.V);
        IFissionSplash iFissionSplash = this.OooO0O0;
        if (iFissionSplash != null && viewGroup != null) {
            iFissionSplash.showSplash(viewGroup);
            return;
        }
        showLog(this.OooO00o, "showError");
        o000O0O0 o000o0o0 = this.eventListener;
        if (o000o0o0 != null) {
            o000o0o0.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg).setInfo((Object) this.splashInfo));
        }
    }
}
