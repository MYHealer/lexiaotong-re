package com.ubixnow.network.fanwei;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.ptg.adsdk.lib.PtgAdSdk;
import com.ptg.adsdk.lib.interf.PtgRewardVideoAd;
import com.ptg.adsdk.lib.model.AdError;
import com.ptg.adsdk.lib.model.AdSlot;
import com.ptg.adsdk.lib.provider.PtgAdNative;
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

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class FwRewardAdapter extends UMNCustomRewardAdapter {
    private final String OooO00o = this.customTag + FwInitManager.getInstance().getName();
    private PtgRewardVideoAd OooO0O0;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd() {
        PtgAdSdk.get().loadRewardVideoAd(BaseUtils.getContext(), new AdSlot.Builder().setPtgSlotId(this.adsSlotid).build(), new PtgAdNative.RewardVideoAdListener() { // from class: com.ubixnow.network.fanwei.FwRewardAdapter.2
            public void onError(AdError adError) {
                FwRewardAdapter fwRewardAdapter = FwRewardAdapter.this;
                fwRewardAdapter.showLog(fwRewardAdapter.OooO00o, "onError: code:" + adError.getErrorCode() + " msg:" + adError.getMessage());
                o00O00o0 o00o00o0 = FwRewardAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, adError.getErrorCode() + "", adError.getMessage()).setInfo((Object) FwRewardAdapter.this.absUbixInfo));
                }
            }

            public void onRewardVideoAdLoad(PtgRewardVideoAd ptgRewardVideoAd) {
                FwRewardAdapter fwRewardAdapter = FwRewardAdapter.this;
                fwRewardAdapter.showLog(fwRewardAdapter.OooO00o, "-----onRewardVideoAdLoad:");
                FwRewardAdapter.this.OooO0O0 = ptgRewardVideoAd;
                FwRewardAdapter fwRewardAdapter2 = FwRewardAdapter.this;
                if (fwRewardAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    try {
                        fwRewardAdapter2.absUbixInfo.setBiddingEcpm((int) fwRewardAdapter2.OooO0O0.getEcpm());
                        FwRewardAdapter fwRewardAdapter3 = FwRewardAdapter.this;
                        fwRewardAdapter3.showLog(fwRewardAdapter3.OooO00o, "price:" + FwRewardAdapter.this.OooO0O0.getEcpm());
                    } catch (Exception e) {
                        ooooO000.OooO00o(e);
                    }
                }
                FwRewardAdapter fwRewardAdapter4 = FwRewardAdapter.this;
                fwRewardAdapter4.absUbixInfo.material = FwUtils.getMaterialInfo(fwRewardAdapter4.OooO0O0.getAdvertData(), null);
                ptgRewardVideoAd.setRewardAdInteractionListener(new PtgRewardVideoAd.RewardAdInteractionListener() { // from class: com.ubixnow.network.fanwei.FwRewardAdapter.2.1
                    public void onAdClose() {
                        FwRewardAdapter fwRewardAdapter5 = FwRewardAdapter.this;
                        fwRewardAdapter5.showLog(fwRewardAdapter5.OooO00o, "onAdClose");
                        if (FwRewardAdapter.this.eventListener != null) {
                            FwRewardAdapter.this.eventListener.onAdDismiss(FwRewardAdapter.this.absUbixInfo);
                        }
                    }

                    public void onAdShow() {
                        FwRewardAdapter fwRewardAdapter5 = FwRewardAdapter.this;
                        fwRewardAdapter5.showLog(fwRewardAdapter5.OooO00o, "onAdShow");
                        if (FwRewardAdapter.this.eventListener != null) {
                            FwRewardAdapter.this.eventListener.onAdShow(FwRewardAdapter.this.absUbixInfo);
                        }
                    }

                    public void onAdVideoBarClick() {
                        FwRewardAdapter fwRewardAdapter5 = FwRewardAdapter.this;
                        fwRewardAdapter5.showLog(fwRewardAdapter5.OooO00o, "onAdVideoBarClick");
                        if (FwRewardAdapter.this.eventListener != null) {
                            FwRewardAdapter.this.eventListener.onAdClick(FwRewardAdapter.this.absUbixInfo);
                        }
                    }

                    public void onRenderError(AdError adError) {
                        FwRewardAdapter fwRewardAdapter5 = FwRewardAdapter.this;
                        fwRewardAdapter5.showLog(fwRewardAdapter5.OooO00o, "onRenderError: code:" + adError.getErrorCode() + " msg:" + adError.getMessage());
                        if (FwRewardAdapter.this.eventListener != null) {
                            FwRewardAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_videoshow_error_msg, adError.getErrorCode() + "", adError.getMessage()).setInfo((Object) FwRewardAdapter.this.absUbixInfo));
                        }
                    }

                    public void onRewardVerify(boolean z, int i, String str) {
                        FwRewardAdapter fwRewardAdapter5 = FwRewardAdapter.this;
                        fwRewardAdapter5.showLog(fwRewardAdapter5.OooO00o, "onRewardVerify old");
                        if (FwRewardAdapter.this.eventListener != null) {
                            FwRewardAdapter.this.eventListener.onRewardVerify(FwRewardAdapter.this.absUbixInfo);
                        }
                    }

                    public void onRewardVerify(boolean z, Bundle bundle) {
                        FwRewardAdapter fwRewardAdapter5 = FwRewardAdapter.this;
                        fwRewardAdapter5.showLog(fwRewardAdapter5.OooO00o, "onRewardVerify new");
                        if (FwRewardAdapter.this.eventListener != null) {
                            FwRewardAdapter.this.eventListener.onRewardVerify(FwRewardAdapter.this.absUbixInfo);
                        }
                    }

                    public void onSkippedVideo() {
                        FwRewardAdapter fwRewardAdapter5 = FwRewardAdapter.this;
                        fwRewardAdapter5.showLog(fwRewardAdapter5.OooO00o, "onSkippedVideo");
                        if (FwRewardAdapter.this.eventListener != null) {
                            FwRewardAdapter.this.eventListener.onVideoSkip(FwRewardAdapter.this.absUbixInfo);
                        }
                    }

                    public void onVideoComplete() {
                        FwRewardAdapter fwRewardAdapter5 = FwRewardAdapter.this;
                        fwRewardAdapter5.showLog(fwRewardAdapter5.OooO00o, "onVideoComplete");
                        if (FwRewardAdapter.this.eventListener != null) {
                            FwRewardAdapter.this.eventListener.onVideoPlayComplete(FwRewardAdapter.this.absUbixInfo);
                        }
                    }

                    public void onVideoError(int i, String str) {
                        FwRewardAdapter fwRewardAdapter5 = FwRewardAdapter.this;
                        fwRewardAdapter5.showLog(fwRewardAdapter5.OooO00o, "onVideoError: code:" + i + " msg:" + str);
                        if (FwRewardAdapter.this.eventListener != null) {
                            FwRewardAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_videoshow_error_msg, i + "", str).setInfo((Object) FwRewardAdapter.this.absUbixInfo));
                        }
                    }

                    public void onVideoPause() {
                        FwRewardAdapter fwRewardAdapter5 = FwRewardAdapter.this;
                        fwRewardAdapter5.showLog(fwRewardAdapter5.OooO00o, "onVideoPause");
                    }

                    public void onVideoProgressUpdate(long j, long j2) {
                        FwRewardAdapter fwRewardAdapter5 = FwRewardAdapter.this;
                        fwRewardAdapter5.showLog(fwRewardAdapter5.OooO00o, "onVideoProgressUpdate");
                    }

                    public void onVideoResume() {
                        FwRewardAdapter fwRewardAdapter5 = FwRewardAdapter.this;
                        fwRewardAdapter5.showLog(fwRewardAdapter5.OooO00o, "onVideoResume");
                    }

                    public void onVideoStart() {
                        FwRewardAdapter fwRewardAdapter5 = FwRewardAdapter.this;
                        fwRewardAdapter5.showLog(fwRewardAdapter5.OooO00o, "onVideoStart");
                        if (FwRewardAdapter.this.eventListener != null) {
                            FwRewardAdapter.this.eventListener.onVideoPlayStart(FwRewardAdapter.this.absUbixInfo);
                        }
                    }
                });
                FwRewardAdapter fwRewardAdapter5 = FwRewardAdapter.this;
                o00O00o0 o00o00o0 = fwRewardAdapter5.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onAdCacheSuccess(fwRewardAdapter5.absUbixInfo);
                }
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        showLog(this.OooO00o, "destroy");
        PtgRewardVideoAd ptgRewardVideoAd = this.OooO0O0;
        if (ptgRewardVideoAd != null) {
            ptgRewardVideoAd.destroy();
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        try {
            PtgRewardVideoAd ptgRewardVideoAd = this.OooO0O0;
            return ptgRewardVideoAd != null && ptgRewardVideoAd.isReady();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return super.isValid();
        }
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void loadRewardAd(Context context, o00O000 o00o000) {
        createADInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(this.adsSlotid)) {
            FwInitManager.getInstance().initSDK(StubApp.getOrigApplicationContext(context.getApplicationContext()), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.fanwei.FwRewardAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = FwRewardAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", FwInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) FwRewardAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    FwRewardAdapter.this.loadAd();
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, FwInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            PtgRewardVideoAd ptgRewardVideoAd = this.OooO0O0;
            if (ptgRewardVideoAd != null) {
                ptgRewardVideoAd.notifyBidLoss(FwUtils.getFailInfo(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyLoss:" + FwUtils.getFailInfo(o00oo0oo).getReason());
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            if (this.OooO0O0 != null) {
                double[] succMap = FwUtils.getSuccMap(o00oo0oo);
                this.OooO0O0.notifyBidWin(succMap[0], succMap[1]);
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyWin: costPrice" + succMap[0] + " second price:" + succMap[1]);
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void show(Activity activity) {
        showLog(this.OooO00o, "show ");
        if (this.OooO0O0 != null && activity != null && !activity.isFinishing()) {
            this.OooO0O0.showRewardVideoAd(activity);
            return;
        }
        showLog(this.OooO00o, "showError");
        o00000 o00000Var = this.eventListener;
        if (o00000Var != null) {
            o00000Var.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg).setInfo((Object) this.absUbixInfo));
        }
    }
}
