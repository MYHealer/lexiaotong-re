package com.ubixnow.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.comm.util.AdError;
import com.stub.StubApp;
import com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0O0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class GdtRewardAdapter extends UMNCustomRewardAdapter {
    private RewardVideoAD OooO00o;
    private final String OooO0O0 = this.customTag + GdtInitManager.getInstance().getName();

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        showLog(this.OooO0O0, "destory");
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        RewardVideoAD rewardVideoAD = this.OooO00o;
        if (rewardVideoAD != null) {
            return rewardVideoAD.isValid();
        }
        return false;
    }

    public void loadAd(Context context) {
        showLog(this.OooO0O0, "loadAd SlotId: " + this.adsSlotid + " isMute: " + this.isMute);
        RewardVideoAD rewardVideoAD = new RewardVideoAD(context, this.adsSlotid, new RewardVideoADListener() { // from class: com.ubixnow.network.gdt.GdtRewardAdapter.2
            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADClick() {
                GdtRewardAdapter gdtRewardAdapter = GdtRewardAdapter.this;
                gdtRewardAdapter.showLog(gdtRewardAdapter.OooO0O0, "onADClick");
                if (GdtRewardAdapter.this.eventListener != null) {
                    GdtRewardAdapter.this.eventListener.onAdClick(GdtRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADClose() {
                GdtRewardAdapter gdtRewardAdapter = GdtRewardAdapter.this;
                gdtRewardAdapter.showLog(gdtRewardAdapter.OooO0O0, "onADClose");
                if (GdtRewardAdapter.this.eventListener != null) {
                    GdtRewardAdapter.this.eventListener.onAdDismiss(GdtRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADExpose() {
                GdtRewardAdapter gdtRewardAdapter = GdtRewardAdapter.this;
                gdtRewardAdapter.showLog(gdtRewardAdapter.OooO0O0, "onADExpose");
                if (GdtRewardAdapter.this.eventListener != null) {
                    GdtRewardAdapter.this.eventListener.onAdShow(GdtRewardAdapter.this.absUbixInfo);
                    GdtRewardAdapter.this.eventListener.onVideoPlayStart(GdtRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADLoad() {
                try {
                    GdtRewardAdapter gdtRewardAdapter = GdtRewardAdapter.this;
                    gdtRewardAdapter.showLog(gdtRewardAdapter.OooO0O0, "onADLoad");
                    GdtRewardAdapter gdtRewardAdapter2 = GdtRewardAdapter.this;
                    if (gdtRewardAdapter2.loadListener != null) {
                        if (gdtRewardAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            gdtRewardAdapter2.showLog(o00OO0O0.TAG, "price:" + GdtRewardAdapter.this.OooO00o.getECPM());
                            GdtRewardAdapter gdtRewardAdapter3 = GdtRewardAdapter.this;
                            gdtRewardAdapter3.absUbixInfo.setBiddingEcpm(gdtRewardAdapter3.OooO00o.getECPM());
                        }
                        GdtRewardAdapter gdtRewardAdapter4 = GdtRewardAdapter.this;
                        gdtRewardAdapter4.loadListener.onAdCacheSuccess(gdtRewardAdapter4.absUbixInfo);
                        GdtRewardAdapter.this.isLoadSuc = true;
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADShow() {
                GdtRewardAdapter gdtRewardAdapter = GdtRewardAdapter.this;
                gdtRewardAdapter.showLog(gdtRewardAdapter.OooO0O0, "onADShow");
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onError(AdError adError) {
                GdtRewardAdapter gdtRewardAdapter = GdtRewardAdapter.this;
                gdtRewardAdapter.showLog(gdtRewardAdapter.OooO0O0, "onError code:" + adError.getErrorCode() + ",msg:" + adError.getErrorMsg());
                GdtRewardAdapter gdtRewardAdapter2 = GdtRewardAdapter.this;
                if (gdtRewardAdapter2.loadListener != null) {
                    if (!gdtRewardAdapter2.isLoadSuc || GdtRewardAdapter.this.eventListener == null) {
                        GdtRewardAdapter.this.onAdDataLoadFailed(adError.getErrorCode(), adError.getErrorMsg());
                    } else {
                        GdtRewardAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_videoshow_error_msg, adError.getErrorCode() + "", GdtInitManager.getInstance().getName() + adError.getErrorMsg()).setInfo((Object) GdtRewardAdapter.this.absUbixInfo));
                    }
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onReward(Map<String, Object> map) {
                GdtRewardAdapter gdtRewardAdapter = GdtRewardAdapter.this;
                gdtRewardAdapter.showLog(gdtRewardAdapter.OooO0O0, "onReward");
                if (GdtRewardAdapter.this.eventListener != null) {
                    GdtRewardAdapter.this.eventListener.onRewardVerify(GdtRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onVideoCached() {
                GdtRewardAdapter gdtRewardAdapter = GdtRewardAdapter.this;
                gdtRewardAdapter.showLog(gdtRewardAdapter.OooO0O0, "onVideoCached");
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onVideoComplete() {
                GdtRewardAdapter gdtRewardAdapter = GdtRewardAdapter.this;
                gdtRewardAdapter.showLog(gdtRewardAdapter.OooO0O0, "onVideoComplete");
                if (GdtRewardAdapter.this.eventListener != null) {
                    GdtRewardAdapter.this.eventListener.onVideoPlayComplete(GdtRewardAdapter.this.absUbixInfo);
                }
            }
        }, !this.isMute);
        this.OooO00o = rewardVideoAD;
        rewardVideoAD.loadAD();
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void loadRewardAd(final Context context, o00O000 o00o000) {
        createADInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(this.adsSlotid)) {
            GdtInitManager.getInstance().initSDK(StubApp.getOrigApplicationContext(context.getApplicationContext()), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.gdt.GdtRewardAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = GdtRewardAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", GdtInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) GdtRewardAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    GdtRewardAdapter.this.loadAd(context);
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, GdtInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            RewardVideoAD rewardVideoAD = this.OooO00o;
            if (rewardVideoAD != null) {
                rewardVideoAD.sendLossNotification(GdtBiddingUtils.getFailInfo(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(o00OO0O0.TAG, "竞价回传_notifyLoss:" + GdtBiddingUtils.getFailInfo(o00oo0oo));
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            RewardVideoAD rewardVideoAD = this.OooO00o;
            if (rewardVideoAD != null) {
                rewardVideoAD.sendWinNotification(GdtBiddingUtils.getSuccMap(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(o00OO0O0.TAG, "竞价回传_notifyWin:" + GdtBiddingUtils.getSuccMap(o00oo0oo));
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void show(Activity activity) {
        showLog(this.OooO0O0, "show() ");
        RewardVideoAD rewardVideoAD = this.OooO00o;
        if (rewardVideoAD == null || activity == null) {
            return;
        }
        rewardVideoAD.showAD(activity);
    }
}
