package com.ubixnow.network.ubix2;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.UBiXAdLossInfo;
import com.ubix.ssp.open.manager.UBiXAdManager;
import com.ubix.ssp.open.video.UBiXRewardInfo;
import com.ubix.ssp.open.video.UBiXRewardVideoAdListener;
import com.ubix.ssp.open.video.UBiXRewardVideoManager;
import com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oO00000o;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UbixRewardAdapter extends UMNCustomRewardAdapter {
    private UBiXRewardVideoManager OooO00o;
    private final String OooO0O0 = this.customTag + getClass().getSimpleName();
    private boolean OooO0OO = false;

    private void OooO00o() {
        try {
            if (this.OooO00o != null) {
                HashMap<String, String> map = new HashMap<>();
                map.put("sensor_disabled", oO00000o.o00O0O.OooOOOo ? "0" : "1");
                this.OooO00o.setExtraInfo(map);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        UBiXRewardVideoManager uBiXRewardVideoManager = this.OooO00o;
        if (uBiXRewardVideoManager != null) {
            uBiXRewardVideoManager.destroy();
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        if (this.OooO00o == null) {
            ooooO000.OooO0OO(this.OooO0O0, "isValid false");
            return false;
        }
        if (ooooO000.OooO00o) {
            ooooO000.OooO0OO(this.OooO0O0, "isValid " + this.OooO00o.isValid());
        }
        return this.OooO00o.isValid();
    }

    public void loadAd(o00O000 o00o000) {
        showLog(this.OooO0O0, "SlotId:" + this.adsSlotid + " appId:" + o00o000.OooO00o.OooO0Oo);
        UBiXRewardVideoManager uBiXRewardVideoManagerCreateRewardVideoAd = UBiXAdManager.createRewardVideoAd();
        this.OooO00o = uBiXRewardVideoManagerCreateRewardVideoAd;
        uBiXRewardVideoManagerCreateRewardVideoAd.loadRewardVideoAd(BaseUtils.getContext(), this.adsSlotid, new UBiXRewardVideoAdListener() { // from class: com.ubixnow.network.ubix2.UbixRewardAdapter.2
            @Override // com.ubix.ssp.open.video.UBiXRewardVideoAdListener
            public void onAdClosed() {
                UbixRewardAdapter ubixRewardAdapter = UbixRewardAdapter.this;
                ubixRewardAdapter.showLog(ubixRewardAdapter.OooO0O0, "onAdClosed");
                if (UbixRewardAdapter.this.eventListener != null) {
                    UbixRewardAdapter.this.eventListener.onAdDismiss(UbixRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.ubix.ssp.open.video.UBiXRewardVideoAdListener
            public void onAdExposed() {
                UbixRewardAdapter ubixRewardAdapter = UbixRewardAdapter.this;
                ubixRewardAdapter.showLog(ubixRewardAdapter.OooO0O0, "----onAdExposed");
                UbixRewardAdapter.this.OooO0OO = true;
                if (UbixRewardAdapter.this.eventListener != null) {
                    UbixRewardAdapter.this.eventListener.onAdShow(UbixRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.ubix.ssp.open.video.UBiXRewardVideoAdListener
            public void onAdLoadSucceed() {
                UbixRewardAdapter ubixRewardAdapter = UbixRewardAdapter.this;
                ubixRewardAdapter.showLog(ubixRewardAdapter.OooO0O0, "----onAdLoadSucceed");
                UbixRewardAdapter ubixRewardAdapter2 = UbixRewardAdapter.this;
                if (ubixRewardAdapter2.loadListener != null) {
                    if (ubixRewardAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                        ubixRewardAdapter2.showLog(ubixRewardAdapter2.OooO0O0, "price:" + UbixRewardAdapter.this.OooO00o.getPrice());
                        UbixRewardAdapter ubixRewardAdapter3 = UbixRewardAdapter.this;
                        ubixRewardAdapter3.absUbixInfo.setBiddingEcpm((int) ubixRewardAdapter3.OooO00o.getPrice());
                    }
                    UbixRewardAdapter ubixRewardAdapter4 = UbixRewardAdapter.this;
                    ubixRewardAdapter4.absUbixInfo.material = UbixUtils.getMaterialInfo(ubixRewardAdapter4.OooO00o);
                    UbixRewardAdapter.this.absUbixInfo.getBaseAdConfig().OooOOo0 = UbixUtils.getPR(UbixRewardAdapter.this.OooO00o);
                    UbixRewardAdapter ubixRewardAdapter5 = UbixRewardAdapter.this;
                    ubixRewardAdapter5.loadListener.onAdCacheSuccess(ubixRewardAdapter5.absUbixInfo);
                }
            }

            @Override // com.ubix.ssp.open.video.UBiXRewardVideoAdListener
            public void onError(AdError adError) {
                UbixRewardAdapter ubixRewardAdapter = UbixRewardAdapter.this;
                ubixRewardAdapter.showLog(ubixRewardAdapter.OooO0O0, "onAdLoadFailed: code" + adError.getErrorCode() + " msg:" + adError.getErrorMessage());
                UbixRewardAdapter ubixRewardAdapter2 = UbixRewardAdapter.this;
                if (ubixRewardAdapter2.loadListener != null && !ubixRewardAdapter2.OooO0OO) {
                    UbixRewardAdapter.this.loadListener.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, adError.getErrorCode() + "", adError.getErrorMessage()).setInfo((Object) UbixRewardAdapter.this.absUbixInfo));
                }
                if (UbixRewardAdapter.this.eventListener == null || !UbixRewardAdapter.this.OooO0OO) {
                    return;
                }
                UbixRewardAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, adError.getErrorCode() + "", adError.getErrorMessage()).setInfo((Object) UbixRewardAdapter.this.absUbixInfo));
            }

            @Override // com.ubix.ssp.open.video.UBiXRewardVideoAdListener
            public void onVideoCached() {
                UbixRewardAdapter ubixRewardAdapter = UbixRewardAdapter.this;
                ubixRewardAdapter.showLog(ubixRewardAdapter.OooO0O0, "----onVideoCached");
            }

            @Override // com.ubix.ssp.open.video.UBiXRewardVideoAdListener
            public void onVideoClicked() {
                UbixRewardAdapter ubixRewardAdapter = UbixRewardAdapter.this;
                ubixRewardAdapter.showLog(ubixRewardAdapter.OooO0O0, "onAdClicked");
                if (UbixRewardAdapter.this.eventListener != null) {
                    UbixRewardAdapter.this.eventListener.onAdClick(UbixRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.ubix.ssp.open.video.UBiXRewardVideoAdListener
            public void onVideoPlayCompleted() {
                UbixRewardAdapter ubixRewardAdapter = UbixRewardAdapter.this;
                ubixRewardAdapter.showLog(ubixRewardAdapter.OooO0O0, "onVideoPlayCompleted");
                if (UbixRewardAdapter.this.eventListener != null) {
                    UbixRewardAdapter.this.eventListener.onVideoPlayComplete(UbixRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.ubix.ssp.open.video.UBiXRewardVideoAdListener
            public void onVideoPlayStarted() {
                UbixRewardAdapter ubixRewardAdapter = UbixRewardAdapter.this;
                ubixRewardAdapter.showLog(ubixRewardAdapter.OooO0O0, "onVideoPlayStarted");
                if (UbixRewardAdapter.this.eventListener != null) {
                    UbixRewardAdapter.this.eventListener.onVideoPlayStart(UbixRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.ubix.ssp.open.video.UBiXRewardVideoAdListener
            public void onVideoRewardVerify(boolean z, UBiXRewardInfo uBiXRewardInfo) {
                UbixRewardAdapter ubixRewardAdapter = UbixRewardAdapter.this;
                ubixRewardAdapter.showLog(ubixRewardAdapter.OooO0O0, "onVideoRewardVerify");
            }

            @Override // com.ubix.ssp.open.video.UBiXRewardVideoAdListener
            public void onVideoRewarded() {
                UbixRewardAdapter ubixRewardAdapter = UbixRewardAdapter.this;
                ubixRewardAdapter.showLog(ubixRewardAdapter.OooO0O0, "onVideoRewarded");
                if (UbixRewardAdapter.this.eventListener != null) {
                    UbixRewardAdapter.this.eventListener.onRewardVerify(UbixRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.ubix.ssp.open.video.UBiXRewardVideoAdListener
            public void onVideoSkipped() {
                UbixRewardAdapter ubixRewardAdapter = UbixRewardAdapter.this;
                ubixRewardAdapter.showLog(ubixRewardAdapter.OooO0O0, "onVideoSkipped");
                if (UbixRewardAdapter.this.eventListener != null) {
                    UbixRewardAdapter.this.eventListener.onVideoSkip(UbixRewardAdapter.this.absUbixInfo);
                }
            }
        });
        OooO00o();
        this.OooO00o.loadAd();
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void loadRewardAd(Context context, final o00O000 o00o000) {
        createADInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(this.adsSlotid)) {
            Ubix2InitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.ubix2.UbixRewardAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = UbixRewardAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", Ubix2InitManager.getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) UbixRewardAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    UbixRewardAdapter.this.loadAd(o00o000);
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, Ubix2InitManager.getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            if (this.OooO00o != null) {
                UBiXAdLossInfo failInfo = Ubix2BiddingUtils.getFailInfo(o00oo0oo);
                this.OooO00o.lossNotice(failInfo);
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO0O0, "竞价回传_notifyLoss:" + failInfo.getInfo().toString());
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            UBiXRewardVideoManager uBiXRewardVideoManager = this.OooO00o;
            if (uBiXRewardVideoManager != null) {
                uBiXRewardVideoManager.winNotice(Ubix2BiddingUtils.getSecondPrice(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO0O0, "竞价回传_notifyWin:" + Ubix2BiddingUtils.getSecondPrice(o00oo0oo));
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void show(Activity activity) {
        showLog(this.OooO0O0, "onVideoRewarded");
        if (!this.OooO00o.isValid() || activity == null) {
            return;
        }
        this.OooO00o.showRewardVideo(activity);
    }
}
