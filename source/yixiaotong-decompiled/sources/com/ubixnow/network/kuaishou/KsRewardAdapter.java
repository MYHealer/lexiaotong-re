package com.ubixnow.network.kuaishou;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.stub.StubApp;
import com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class KsRewardAdapter extends UMNCustomRewardAdapter {
    private KsRewardVideoAd OooO00o;
    private final String OooO0O0 = this.customTag + KsInitManager.getInstance().getName();
    private boolean OooO0OO = false;
    private AdExposureFailedReason OooO0Oo;

    private void OooO00o(Activity activity, KsRewardVideoAd ksRewardVideoAd, KsVideoPlayConfig ksVideoPlayConfig) {
        if (ksRewardVideoAd == null || !ksRewardVideoAd.isAdEnable()) {
            return;
        }
        ksRewardVideoAd.setRewardAdInteractionListener(new KsRewardVideoAd.RewardAdInteractionListener() { // from class: com.ubixnow.network.kuaishou.KsRewardAdapter.3
            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onAdClicked() {
                KsRewardAdapter ksRewardAdapter = KsRewardAdapter.this;
                ksRewardAdapter.showLog(ksRewardAdapter.OooO0O0, "onAdClicked");
                if (KsRewardAdapter.this.eventListener != null) {
                    KsRewardAdapter.this.eventListener.onAdClick(KsRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onExtraRewardVerify(int i) {
                KsRewardAdapter ksRewardAdapter = KsRewardAdapter.this;
                ksRewardAdapter.showLog(ksRewardAdapter.OooO0O0, "onExtraRewardVerify ");
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onPageDismiss() {
                KsRewardAdapter ksRewardAdapter = KsRewardAdapter.this;
                ksRewardAdapter.showLog(ksRewardAdapter.OooO0O0, "onPageDismiss");
                if (KsRewardAdapter.this.eventListener != null) {
                    KsRewardAdapter.this.eventListener.onAdDismiss(KsRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onRewardStepVerify(int i, int i2) {
                KsRewardAdapter ksRewardAdapter = KsRewardAdapter.this;
                ksRewardAdapter.showLog(ksRewardAdapter.OooO0O0, "onRewardStepVerify ");
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify() {
                KsRewardAdapter ksRewardAdapter = KsRewardAdapter.this;
                ksRewardAdapter.showLog(ksRewardAdapter.OooO0O0, "onRewardVerify ");
                if (KsRewardAdapter.this.eventListener != null) {
                    KsRewardAdapter.this.eventListener.onRewardVerify(KsRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify(Map<String, Object> map) {
                KsRewardAdapter ksRewardAdapter = KsRewardAdapter.this;
                ksRewardAdapter.showLog(ksRewardAdapter.OooO0O0, "onRewardVerify ");
                if (KsRewardAdapter.this.eventListener != null) {
                    KsRewardAdapter.this.eventListener.onRewardVerify(KsRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayEnd() {
                KsRewardAdapter ksRewardAdapter = KsRewardAdapter.this;
                ksRewardAdapter.showLog(ksRewardAdapter.OooO0O0, "onVideoPlayEnd ");
                if (KsRewardAdapter.this.eventListener != null) {
                    KsRewardAdapter.this.eventListener.onVideoPlayComplete(KsRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayError(int i, int i2) {
                KsRewardAdapter ksRewardAdapter = KsRewardAdapter.this;
                ksRewardAdapter.showLog(ksRewardAdapter.OooO0O0, "onVideoPlayError code" + i + "   extra:" + i2);
                if (KsRewardAdapter.this.eventListener != null) {
                    KsRewardAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_videoshow_error_msg, i + "", i2 + "").setInfo((Object) KsRewardAdapter.this.absUbixInfo));
                }
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayStart() {
                KsRewardAdapter ksRewardAdapter = KsRewardAdapter.this;
                ksRewardAdapter.showLog(ksRewardAdapter.OooO0O0, "onVideoPlayStart ");
                if (KsRewardAdapter.this.eventListener != null) {
                    KsRewardAdapter.this.eventListener.onAdShow(KsRewardAdapter.this.absUbixInfo);
                    KsRewardAdapter.this.eventListener.onVideoPlayStart(KsRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoSkipToEnd(long j) {
                KsRewardAdapter ksRewardAdapter = KsRewardAdapter.this;
                ksRewardAdapter.showLog(ksRewardAdapter.OooO0O0, "onVideoSkipToEnd ");
                if (KsRewardAdapter.this.eventListener != null) {
                    KsRewardAdapter.this.eventListener.onVideoSkip(KsRewardAdapter.this.absUbixInfo);
                }
            }
        });
        ksRewardVideoAd.showRewardVideoAd(activity, ksVideoPlayConfig);
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        KsRewardVideoAd ksRewardVideoAd = this.OooO00o;
        if (ksRewardVideoAd != null) {
            return ksRewardVideoAd.isAdEnable();
        }
        return false;
    }

    public void loadAd(o00O000 o00o000) {
        showLog(this.OooO0O0, "SlotId:" + this.adsSlotid + " appId:" + o00o000.OooO00o.OooO0Oo);
        KsAdSDK.getLoadManager().loadRewardVideoAd(new KsScene.Builder(KsInitManager.getKSLongValue(this.adsSlotid)).build(), new KsLoadManager.RewardVideoAdListener() { // from class: com.ubixnow.network.kuaishou.KsRewardAdapter.2
            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onError(int i, String str) {
                KsRewardAdapter ksRewardAdapter = KsRewardAdapter.this;
                if (ksRewardAdapter.adFlowStatus == 10) {
                    ksRewardAdapter.onAdRenderFail(i + "", str);
                } else {
                    ksRewardAdapter.onAdDataLoadFailed(i, str);
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoAdLoad(List<KsRewardVideoAd> list) {
                try {
                    KsRewardAdapter ksRewardAdapter = KsRewardAdapter.this;
                    ksRewardAdapter.showLog(ksRewardAdapter.OooO0O0, "onRewardVideoAdLoad size " + list.size());
                    if (list.size() > 0) {
                        KsRewardAdapter.this.OooO00o = list.get(0);
                        KsRewardAdapter ksRewardAdapter2 = KsRewardAdapter.this;
                        ksRewardAdapter2.absUbixInfo.material = KsUtils.getMaterialInfo(ksRewardAdapter2.OooO00o);
                        KsRewardAdapter ksRewardAdapter3 = KsRewardAdapter.this;
                        if (ksRewardAdapter3.loadListener != null) {
                            if (ksRewardAdapter3.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                                ksRewardAdapter3.showLog(ksRewardAdapter3.OooO0O0, "price:" + KsRewardAdapter.this.OooO00o.getECPM());
                                KsRewardAdapter ksRewardAdapter4 = KsRewardAdapter.this;
                                ksRewardAdapter4.absUbixInfo.setBiddingEcpm(ksRewardAdapter4.OooO00o.getECPM());
                            }
                            KsRewardAdapter ksRewardAdapter5 = KsRewardAdapter.this;
                            ksRewardAdapter5.loadListener.onAdCacheSuccess(ksRewardAdapter5.absUbixInfo);
                        }
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoResult(List<KsRewardVideoAd> list) {
                KsRewardAdapter ksRewardAdapter = KsRewardAdapter.this;
                ksRewardAdapter.adFlowStatus = 10;
                if (list != null) {
                    ksRewardAdapter.showLog(ksRewardAdapter.OooO0O0, "onRequestResult number:" + list.size());
                    if (KsRewardAdapter.this.OooO0OO) {
                        return;
                    }
                    if (KsRewardAdapter.this.mBaseAdConfig.OooO00o.OooOO0O == 1 && list.size() > 0) {
                        KsRewardAdapter.this.absUbixInfo.setBiddingEcpm(list.get(0).getECPM());
                    }
                    KsRewardAdapter.this.OooO0OO = true;
                    KsRewardAdapter.this.onAdDataLoaded();
                }
            }
        });
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void loadRewardAd(Context context, final o00O000 o00o000) {
        createADInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(this.adsSlotid)) {
            KsInitManager.getInstance().initSDK(StubApp.getOrigApplicationContext(context.getApplicationContext()), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.kuaishou.KsRewardAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = KsRewardAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", KsInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) KsRewardAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    KsRewardAdapter.this.loadAd(o00o000);
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, KsInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyClick() {
        try {
            KsBiddingUtils.notifyClick(this.adsSlotid, this.OooO0Oo, this.OooO00o);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            this.OooO0Oo = KsBiddingUtils.notifyLoss(this.adsSlotid, o00oo0oo, this.OooO00o);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyShow() {
        try {
            KsBiddingUtils.notifyShow(this.adsSlotid, this.OooO0Oo, this.OooO00o);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            KsBiddingUtils.notifyWin(o00oo0oo, this.OooO00o);
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void show(Activity activity) {
        showLog(this.OooO0O0, "show()");
        OooO00o(activity, this.OooO00o, new KsVideoPlayConfig.Builder().videoSoundEnable(!this.isMute).build());
    }
}
