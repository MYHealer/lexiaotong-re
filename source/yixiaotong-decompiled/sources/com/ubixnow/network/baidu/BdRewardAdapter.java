package com.ubixnow.network.baidu;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.stub.StubApp;
import com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class BdRewardAdapter extends UMNCustomRewardAdapter {
    private RewardVideoAd OooO00o;
    private boolean OooO0O0 = false;
    private final String OooO0OO = this.customTag + BdInitManager.getInstance().getName();
    private int OooO0Oo;

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        if (this.OooO00o == null) {
            return false;
        }
        if (ooooO000.OooO00o) {
            ooooO000.OooO0OO(this.OooO0OO, "isValid " + this.OooO00o.isReady());
        }
        return this.OooO00o.isReady();
    }

    public void loadAd(Context context) {
        showLog(this.OooO0OO, "ID " + this.adsSlotid + " appid:" + this.mBaseAdConfig.OooO00o.OooO0Oo + (this.eventListener != null) + (this.loadListener != null));
        RewardVideoAd rewardVideoAd = new RewardVideoAd(context, this.adsSlotid, new RewardVideoAd.RewardVideoAdListener() { // from class: com.ubixnow.network.baidu.BdRewardAdapter.2
            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdClick() {
                BdRewardAdapter bdRewardAdapter = BdRewardAdapter.this;
                bdRewardAdapter.showLog(bdRewardAdapter.OooO0OO, IAdInterListener.AdCommandType.AD_CLICK);
                if (BdRewardAdapter.this.eventListener != null) {
                    BdRewardAdapter.this.eventListener.onAdClick(BdRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdClose(float f) {
                BdRewardAdapter bdRewardAdapter = BdRewardAdapter.this;
                bdRewardAdapter.showLog(bdRewardAdapter.OooO0OO, "onAdClose " + f);
                if (BdRewardAdapter.this.eventListener != null) {
                    BdRewardAdapter.this.eventListener.onAdDismiss(BdRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdFailed(String str) {
                BdRewardAdapter bdRewardAdapter = BdRewardAdapter.this;
                bdRewardAdapter.showLog(bdRewardAdapter.OooO0OO, "onAdFailed  Msg：" + str);
                BdRewardAdapter bdRewardAdapter2 = BdRewardAdapter.this;
                if (bdRewardAdapter2.loadListener != null && !bdRewardAdapter2.OooO0O0) {
                    BdRewardAdapter.this.loadListener.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, "-1", BdInitManager.getInstance().getName() + str).setInfo((Object) BdRewardAdapter.this.absUbixInfo));
                }
                if (!BdRewardAdapter.this.OooO0O0 || BdRewardAdapter.this.eventListener == null) {
                    return;
                }
                BdRewardAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_videoshow_error_msg, "-1", BdInitManager.getInstance().getName() + str).setInfo((Object) BdRewardAdapter.this.absUbixInfo));
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdLoaded() {
                BdRewardAdapter bdRewardAdapter = BdRewardAdapter.this;
                bdRewardAdapter.showLog(bdRewardAdapter.OooO0OO, "onAdLoaded ");
                BdRewardAdapter.this.OooO0O0 = true;
                BdRewardAdapter bdRewardAdapter2 = BdRewardAdapter.this;
                if (bdRewardAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    try {
                        bdRewardAdapter2.OooO0Oo = bdRewardAdapter2.getIntegerValue(bdRewardAdapter2.OooO00o.getECPMLevel());
                        BdRewardAdapter bdRewardAdapter3 = BdRewardAdapter.this;
                        bdRewardAdapter3.showLog(bdRewardAdapter3.OooO0OO, "price: ecpm " + BdRewardAdapter.this.OooO00o.getECPMLevel());
                        BdRewardAdapter bdRewardAdapter4 = BdRewardAdapter.this;
                        bdRewardAdapter4.absUbixInfo.setBiddingEcpm(bdRewardAdapter4.getIntegerValue(bdRewardAdapter4.OooO00o.getECPMLevel()));
                    } catch (Exception e) {
                        ooooO000.OooO00o(e);
                    }
                }
                BdRewardAdapter.this.onAdDataLoaded();
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdShow() {
                BdRewardAdapter bdRewardAdapter = BdRewardAdapter.this;
                bdRewardAdapter.showLog(bdRewardAdapter.OooO0OO, "onAdShow");
                if (BdRewardAdapter.this.eventListener != null) {
                    BdRewardAdapter.this.eventListener.onAdShow(BdRewardAdapter.this.absUbixInfo);
                    BdRewardAdapter.this.eventListener.onVideoPlayStart(BdRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdSkip(float f) {
                BdRewardAdapter bdRewardAdapter = BdRewardAdapter.this;
                bdRewardAdapter.showLog(bdRewardAdapter.OooO0OO, "onAdSkip");
                if (BdRewardAdapter.this.eventListener != null) {
                    BdRewardAdapter.this.eventListener.onVideoSkip(BdRewardAdapter.this.absUbixInfo);
                }
            }

            public void onRewardVerify(boolean z) {
                BdRewardAdapter bdRewardAdapter = BdRewardAdapter.this;
                bdRewardAdapter.showLog(bdRewardAdapter.OooO0OO, "onRewardVerify_old");
                if (BdRewardAdapter.this.eventListener != null) {
                    BdRewardAdapter.this.eventListener.onRewardVerify(BdRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
            public void onRewardVerify(boolean z, Map<String, Object> map) {
                BdRewardAdapter bdRewardAdapter = BdRewardAdapter.this;
                bdRewardAdapter.showLog(bdRewardAdapter.OooO0OO, "onRewardVerify_9.430");
                if (BdRewardAdapter.this.eventListener != null) {
                    BdRewardAdapter.this.eventListener.onRewardVerify(BdRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onVideoDownloadFailed() {
                BdRewardAdapter bdRewardAdapter = BdRewardAdapter.this;
                bdRewardAdapter.showLog(bdRewardAdapter.OooO0OO, "onVideoDownloadFailed " + BdRewardAdapter.this.OooO0O0);
                BdRewardAdapter bdRewardAdapter2 = BdRewardAdapter.this;
                oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.RENDER_FAIL;
                bdRewardAdapter2.onAdRenderFail(oooO00o.OooO00o(), oooO00o.OooO0O0());
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onVideoDownloadSuccess() {
                BdRewardAdapter bdRewardAdapter = BdRewardAdapter.this;
                bdRewardAdapter.showLog(bdRewardAdapter.OooO0OO, "onVideoDownloadSuccess id: " + BdRewardAdapter.this.mBaseAdConfig.OooO00o.OooO0o0);
                try {
                    BdRewardAdapter bdRewardAdapter2 = BdRewardAdapter.this;
                    if (bdRewardAdapter2.loadListener != null) {
                        if (bdRewardAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            bdRewardAdapter2.OooO0Oo = bdRewardAdapter2.getIntegerValue(bdRewardAdapter2.OooO00o.getECPMLevel());
                            BdRewardAdapter bdRewardAdapter3 = BdRewardAdapter.this;
                            bdRewardAdapter3.showLog(bdRewardAdapter3.OooO0OO, "price: ecpm " + BdRewardAdapter.this.OooO00o.getECPMLevel());
                            BdRewardAdapter bdRewardAdapter4 = BdRewardAdapter.this;
                            bdRewardAdapter4.absUbixInfo.setBiddingEcpm(bdRewardAdapter4.getIntegerValue(bdRewardAdapter4.OooO00o.getECPMLevel()));
                        }
                        BdRewardAdapter bdRewardAdapter5 = BdRewardAdapter.this;
                        bdRewardAdapter5.loadListener.onAdCacheSuccess(bdRewardAdapter5.absUbixInfo);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void playCompletion() {
                BdRewardAdapter bdRewardAdapter = BdRewardAdapter.this;
                bdRewardAdapter.showLog(bdRewardAdapter.OooO0OO, "playCompletion");
                if (BdRewardAdapter.this.eventListener != null) {
                    BdRewardAdapter.this.eventListener.onVideoPlayComplete(BdRewardAdapter.this.absUbixInfo);
                }
            }
        }, false);
        this.OooO00o = rewardVideoAd;
        rewardVideoAd.setDownloadAppConfirmPolicy(2);
        try {
            this.OooO00o.setAppSid(this.mBaseAdConfig.OooO00o.OooO0Oo);
            o00O000 o00o000 = this.mBaseAdConfig;
            if (o00o000.OooO00o.OooOO0O == 1) {
                this.OooO00o.setBidFloor((int) o00o000.OooO);
            }
        } catch (Exception unused) {
        }
        this.OooO00o.load();
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void loadRewardAd(final Context context, o00O000 o00o000) {
        createADInfo(o00o000);
        showLog(this.OooO0OO, "load Id " + this.adsSlotid);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(this.adsSlotid)) {
            BdInitManager.getInstance().initSDK(StubApp.getOrigApplicationContext(context.getApplicationContext()), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.baidu.BdRewardAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = BdRewardAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", BdInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) BdRewardAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    BdRewardAdapter.this.loadAd(context);
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

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void show(Activity activity) {
        showLog(this.OooO0OO, "show()");
        RewardVideoAd rewardVideoAd = this.OooO00o;
        if (rewardVideoAd != null) {
            rewardVideoAd.show();
        }
    }
}
