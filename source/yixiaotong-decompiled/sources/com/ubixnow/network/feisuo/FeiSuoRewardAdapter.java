package com.ubixnow.network.feisuo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.huawei.openalliance.ad.constant.br;
import com.stub.StubApp;
import com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00000;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import com.zm.fissionsdk.api.FissionSdk;
import com.zm.fissionsdk.api.FissionSlot;
import com.zm.fissionsdk.api.interfaces.IFission;
import com.zm.fissionsdk.api.interfaces.IFissionLoadManager;
import com.zm.fissionsdk.api.interfaces.IFissionRewardVideo;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class FeiSuoRewardAdapter extends UMNCustomRewardAdapter {
    private final String OooO00o = this.customTag + getClass().getSimpleName();
    private IFissionRewardVideo OooO0O0;
    private int OooO0OO;

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o() {
        IFissionRewardVideo iFissionRewardVideo = this.OooO0O0;
        if (iFissionRewardVideo != null) {
            iFissionRewardVideo.setVideoListener(new IFission.VideoListener() { // from class: com.ubixnow.network.feisuo.FeiSuoRewardAdapter.3
                public void onVideoComplete() {
                    FeiSuoRewardAdapter feiSuoRewardAdapter = FeiSuoRewardAdapter.this;
                    feiSuoRewardAdapter.showLog(feiSuoRewardAdapter.OooO00o, "onVideoComplete");
                }

                public void onVideoContinuePlay() {
                    FeiSuoRewardAdapter feiSuoRewardAdapter = FeiSuoRewardAdapter.this;
                    feiSuoRewardAdapter.showLog(feiSuoRewardAdapter.OooO00o, "onVideoContinuePlay");
                }

                public void onVideoError(int i, String str) {
                    FeiSuoRewardAdapter feiSuoRewardAdapter = FeiSuoRewardAdapter.this;
                    feiSuoRewardAdapter.showLog(feiSuoRewardAdapter.OooO00o, "onVideoError");
                    if (FeiSuoRewardAdapter.this.eventListener != null) {
                        FeiSuoRewardAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_videoshow_error_msg, i + "", str).setInfo((Object) FeiSuoRewardAdapter.this.absUbixInfo));
                    }
                }

                public void onVideoPause() {
                    FeiSuoRewardAdapter feiSuoRewardAdapter = FeiSuoRewardAdapter.this;
                    feiSuoRewardAdapter.showLog(feiSuoRewardAdapter.OooO00o, "onVideoPause");
                }

                public void onVideoPlay() {
                    FeiSuoRewardAdapter feiSuoRewardAdapter = FeiSuoRewardAdapter.this;
                    feiSuoRewardAdapter.showLog(feiSuoRewardAdapter.OooO00o, "onVideoPlay1");
                    if (FeiSuoRewardAdapter.this.eventListener != null) {
                        FeiSuoRewardAdapter feiSuoRewardAdapter2 = FeiSuoRewardAdapter.this;
                        if (feiSuoRewardAdapter2.adFlowStatus < 60) {
                            feiSuoRewardAdapter2.showLog(feiSuoRewardAdapter2.OooO00o, "onVideoPlay2");
                            FeiSuoRewardAdapter feiSuoRewardAdapter3 = FeiSuoRewardAdapter.this;
                            feiSuoRewardAdapter3.adFlowStatus = 60;
                            feiSuoRewardAdapter3.eventListener.onVideoPlayStart(FeiSuoRewardAdapter.this.absUbixInfo);
                        }
                    }
                }
            });
            this.OooO0O0.setRewardInteractionListener(new IFissionRewardVideo.RewardVideoInteractionListener() { // from class: com.ubixnow.network.feisuo.FeiSuoRewardAdapter.4
                public void onClick(View view) {
                    FeiSuoRewardAdapter feiSuoRewardAdapter = FeiSuoRewardAdapter.this;
                    feiSuoRewardAdapter.showLog(feiSuoRewardAdapter.OooO00o, "onClick");
                    if (FeiSuoRewardAdapter.this.eventListener != null) {
                        FeiSuoRewardAdapter.this.eventListener.onAdClick(FeiSuoRewardAdapter.this.absUbixInfo);
                    }
                }

                public void onClose() {
                    FeiSuoRewardAdapter feiSuoRewardAdapter = FeiSuoRewardAdapter.this;
                    feiSuoRewardAdapter.showLog(feiSuoRewardAdapter.OooO00o, "onClose");
                    if (FeiSuoRewardAdapter.this.eventListener != null) {
                        FeiSuoRewardAdapter.this.eventListener.onAdDismiss(FeiSuoRewardAdapter.this.absUbixInfo);
                    }
                }

                public void onRewardVerify(boolean z, int i, Bundle bundle) {
                    FeiSuoRewardAdapter feiSuoRewardAdapter = FeiSuoRewardAdapter.this;
                    feiSuoRewardAdapter.showLog(feiSuoRewardAdapter.OooO00o, "onReward");
                    if (FeiSuoRewardAdapter.this.eventListener != null) {
                        FeiSuoRewardAdapter.this.eventListener.onRewardVerify(FeiSuoRewardAdapter.this.absUbixInfo);
                    }
                }

                public void onShow() {
                    FeiSuoRewardAdapter feiSuoRewardAdapter = FeiSuoRewardAdapter.this;
                    feiSuoRewardAdapter.showLog(feiSuoRewardAdapter.OooO00o, "onShow");
                    if (FeiSuoRewardAdapter.this.eventListener != null) {
                        FeiSuoRewardAdapter.this.eventListener.onAdShow(FeiSuoRewardAdapter.this.absUbixInfo);
                    }
                }

                public void onShowFailed(int i, String str) {
                    FeiSuoRewardAdapter feiSuoRewardAdapter = FeiSuoRewardAdapter.this;
                    feiSuoRewardAdapter.showLog(feiSuoRewardAdapter.OooO00o, "onShowFailed");
                    if (FeiSuoRewardAdapter.this.eventListener != null) {
                        FeiSuoRewardAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, i + "", str).setInfo((Object) FeiSuoRewardAdapter.this.absUbixInfo));
                    }
                }

                public void onVideoComplete() {
                    FeiSuoRewardAdapter feiSuoRewardAdapter = FeiSuoRewardAdapter.this;
                    feiSuoRewardAdapter.showLog(feiSuoRewardAdapter.OooO00o, "onVideoComplete");
                    if (FeiSuoRewardAdapter.this.eventListener != null) {
                        FeiSuoRewardAdapter.this.eventListener.onVideoPlayComplete(FeiSuoRewardAdapter.this.absUbixInfo);
                    }
                }

                public void onVideoError() {
                    FeiSuoRewardAdapter feiSuoRewardAdapter = FeiSuoRewardAdapter.this;
                    feiSuoRewardAdapter.showLog(feiSuoRewardAdapter.OooO00o, "onVideoError");
                    if (FeiSuoRewardAdapter.this.eventListener != null) {
                        FeiSuoRewardAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_videoshow_error_msg, oOO00O0.ubix_show_error, oOO00O0.ubix_videoshow_error_msg).setInfo((Object) FeiSuoRewardAdapter.this.absUbixInfo));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(Context context, o00O000 o00o000) {
        FissionSdk.getLoadManager().loadRewardVideo(new FissionSlot.Builder().setContext(context).setRequestId(o00o000.OooO0oO).setSlotType(5).setSlotId(o00o000.OooO00o.OooO0o0).setCount(1).build(), new IFissionLoadManager.AsyncRewardVideoLoadListener() { // from class: com.ubixnow.network.feisuo.FeiSuoRewardAdapter.2
            public void onError(int i, String str) {
                FeiSuoRewardAdapter feiSuoRewardAdapter = FeiSuoRewardAdapter.this;
                feiSuoRewardAdapter.showLog(feiSuoRewardAdapter.OooO00o, "onError:code:" + i + "  msg:" + str);
                FeiSuoRewardAdapter.this.onAdDataLoadFailed(i, str);
            }

            public void onLoad(List<IFissionRewardVideo> list) {
                try {
                    FeiSuoRewardAdapter feiSuoRewardAdapter = FeiSuoRewardAdapter.this;
                    feiSuoRewardAdapter.showLog(feiSuoRewardAdapter.OooO00o, "onLoad");
                    FeiSuoRewardAdapter.this.OooO0O0 = list.get(0);
                    FeiSuoRewardAdapter feiSuoRewardAdapter2 = FeiSuoRewardAdapter.this;
                    if (feiSuoRewardAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                        feiSuoRewardAdapter2.showLog(feiSuoRewardAdapter2.OooO00o, "price:" + FeiSuoRewardAdapter.this.OooO0O0.getECpm());
                        FeiSuoRewardAdapter feiSuoRewardAdapter3 = FeiSuoRewardAdapter.this;
                        feiSuoRewardAdapter3.OooO0OO = feiSuoRewardAdapter3.OooO0O0.getECpm();
                        FeiSuoRewardAdapter feiSuoRewardAdapter4 = FeiSuoRewardAdapter.this;
                        feiSuoRewardAdapter4.absUbixInfo.setBiddingEcpm(feiSuoRewardAdapter4.OooO0O0.getECpm());
                    }
                    FeiSuoRewardAdapter.this.OooO00o();
                    FeiSuoRewardAdapter.this.onAdDataLoaded();
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            public void onMaterialCacheFailed(int i, String str) {
                FeiSuoRewardAdapter feiSuoRewardAdapter = FeiSuoRewardAdapter.this;
                feiSuoRewardAdapter.showLog(feiSuoRewardAdapter.OooO00o, "onMaterialCacheFailed");
                FeiSuoRewardAdapter.this.onAdRenderFail(i + "", str);
            }

            public void onMaterialCached() {
                FeiSuoRewardAdapter feiSuoRewardAdapter = FeiSuoRewardAdapter.this;
                feiSuoRewardAdapter.showLog(feiSuoRewardAdapter.OooO00o, "onMaterialCached");
                FeiSuoRewardAdapter feiSuoRewardAdapter2 = FeiSuoRewardAdapter.this;
                if (feiSuoRewardAdapter2.loadListener == null || feiSuoRewardAdapter2.OooO0O0 == null) {
                    return;
                }
                FeiSuoRewardAdapter feiSuoRewardAdapter3 = FeiSuoRewardAdapter.this;
                feiSuoRewardAdapter3.loadListener.onAdCacheSuccess(feiSuoRewardAdapter3.absUbixInfo);
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        try {
            showLog(this.OooO00o, "destroy");
            IFissionRewardVideo iFissionRewardVideo = this.OooO0O0;
            if (iFissionRewardVideo != null) {
                iFissionRewardVideo.destroy();
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void loadRewardAd(Context context, final o00O000 o00o000) {
        createADInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(this.adsSlotid)) {
            FeiSuoInitManager.getInstance().initSDK(StubApp.getOrigApplicationContext(context.getApplicationContext()), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.feisuo.FeiSuoRewardAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = FeiSuoRewardAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", FeiSuoInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) FeiSuoRewardAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    FeiSuoRewardAdapter.this.OooO00o(BaseUtils.getContext(), o00o000);
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
            IFissionRewardVideo iFissionRewardVideo = this.OooO0O0;
            if (iFissionRewardVideo != null) {
                iFissionRewardVideo.onBidFail(FeiSuoUtils.getFailInfo(o00oo0oo), "");
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
            IFissionRewardVideo iFissionRewardVideo = this.OooO0O0;
            if (iFissionRewardVideo != null) {
                iFissionRewardVideo.onBidSuccess(this.OooO0OO + "");
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyWin:" + this.OooO0OO);
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void show(Activity activity) {
        showLog(this.OooO00o, br.b.V);
        IFissionRewardVideo iFissionRewardVideo = this.OooO0O0;
        if (iFissionRewardVideo != null && activity != null) {
            iFissionRewardVideo.showReward(activity);
            return;
        }
        o00000 o00000Var = this.eventListener;
        if (o00000Var != null) {
            o00000Var.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg).setInfo((Object) this.absUbixInfo));
        }
    }
}
