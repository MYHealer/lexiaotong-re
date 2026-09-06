package com.ubixnow.network.csj;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0O0;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class CsjRewardAdapter extends UMNCustomRewardAdapter {
    private TTRewardVideoAd OooO00o;
    private final String OooO0O0 = this.customTag + CsjInitManager.getInstance().getName();

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o() {
        this.OooO00o.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.ubixnow.network.csj.CsjRewardAdapter.4
            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdClose() {
                CsjRewardAdapter csjRewardAdapter = CsjRewardAdapter.this;
                csjRewardAdapter.showLog(csjRewardAdapter.OooO0O0, "onAdClose");
                if (CsjRewardAdapter.this.eventListener != null) {
                    CsjRewardAdapter.this.eventListener.onAdDismiss(CsjRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdShow() {
                CsjRewardAdapter csjRewardAdapter = CsjRewardAdapter.this;
                csjRewardAdapter.showLog(csjRewardAdapter.OooO0O0, "onAdShow");
                if (CsjRewardAdapter.this.OooO00o != null && CsjRewardAdapter.this.OooO00o.getMediationManager() != null && CsjRewardAdapter.this.OooO00o.getMediationManager().getShowEcpm() != null) {
                    CsjRewardAdapter.this.showLog(o00OO0O0.TAG, "show price:" + CsjRewardAdapter.this.OooO00o.getMediationManager().getShowEcpm().getEcpm());
                }
                if (CsjRewardAdapter.this.eventListener != null) {
                    CsjRewardAdapter.this.eventListener.onAdShow(CsjRewardAdapter.this.absUbixInfo);
                    CsjRewardAdapter.this.eventListener.onVideoPlayStart(CsjRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdVideoBarClick() {
                CsjRewardAdapter csjRewardAdapter = CsjRewardAdapter.this;
                csjRewardAdapter.showLog(csjRewardAdapter.OooO0O0, "onAdVideoBarClick");
                if (CsjRewardAdapter.this.eventListener != null) {
                    CsjRewardAdapter.this.eventListener.onAdClick(CsjRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onRewardArrived(boolean z, int i, Bundle bundle) {
                CsjRewardAdapter csjRewardAdapter = CsjRewardAdapter.this;
                csjRewardAdapter.showLog(csjRewardAdapter.OooO0O0, "onRewardArrived");
                if (CsjRewardAdapter.this.eventListener != null) {
                    CsjRewardAdapter.this.eventListener.onRewardVerify(CsjRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
                CsjRewardAdapter.this.showLog(o00OO0O0.TAG, "废弃：onRewardVerify");
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onSkippedVideo() {
                CsjRewardAdapter csjRewardAdapter = CsjRewardAdapter.this;
                csjRewardAdapter.showLog(csjRewardAdapter.OooO0O0, "onSkippedVideo");
                if (CsjRewardAdapter.this.eventListener != null) {
                    CsjRewardAdapter.this.eventListener.onVideoSkip(CsjRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onVideoComplete() {
                CsjRewardAdapter csjRewardAdapter = CsjRewardAdapter.this;
                csjRewardAdapter.showLog(csjRewardAdapter.OooO0O0, "onVideoComplete");
                if (CsjRewardAdapter.this.eventListener != null) {
                    CsjRewardAdapter.this.eventListener.onVideoPlayComplete(CsjRewardAdapter.this.absUbixInfo);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onVideoError() {
                CsjRewardAdapter csjRewardAdapter = CsjRewardAdapter.this;
                csjRewardAdapter.showLog(csjRewardAdapter.OooO0O0, "onVideoError");
                if (CsjRewardAdapter.this.eventListener != null) {
                    CsjRewardAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_videoshow_error_msg, "-1", oOO00O0.ubix_videoshow_error_msg).setInfo((Object) CsjRewardAdapter.this.absUbixInfo));
                }
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        try {
            showLog(o00OO0O0.TAG, "destory");
            TTRewardVideoAd tTRewardVideoAd = this.OooO00o;
            if (tTRewardVideoAd == null || tTRewardVideoAd.getMediationManager() == null) {
                return;
            }
            this.OooO00o.getMediationManager().destroy();
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        TTRewardVideoAd tTRewardVideoAd = this.OooO00o;
        return (tTRewardVideoAd == null || tTRewardVideoAd.getMediationManager() == null || !this.OooO00o.getMediationManager().isReady()) ? false : true;
    }

    public void loadAd(Context context) {
        showLog(this.OooO0O0, "start loadAd " + this.adsSlotid);
        TTAdSdk.getAdManager().createAdNative(context).loadRewardVideoAd(new AdSlot.Builder().setCodeId(this.adsSlotid).build(), new TTAdNative.RewardVideoAdListener() { // from class: com.ubixnow.network.csj.CsjRewardAdapter.3
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onError(int i, String str) {
                CsjRewardAdapter csjRewardAdapter = CsjRewardAdapter.this;
                csjRewardAdapter.showLog(csjRewardAdapter.OooO0O0, "onError code：" + i + "  msg:" + str);
                o00O00o0 o00o00o0 = CsjRewardAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", CsjInitManager.getInstance().getName() + str).setInfo((Object) CsjRewardAdapter.this.absUbixInfo));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
                try {
                    CsjRewardAdapter csjRewardAdapter = CsjRewardAdapter.this;
                    csjRewardAdapter.showLog(csjRewardAdapter.OooO0O0, "onRewardVideoAdLoad");
                    CsjRewardAdapter.this.OooO00o = tTRewardVideoAd;
                    CsjRewardAdapter csjRewardAdapter2 = CsjRewardAdapter.this;
                    if (csjRewardAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                        csjRewardAdapter2.absUbixInfo.csjPriceMethod = "1";
                        int integerValue = CsjRewardAdapter.this.getIntegerValue(csjRewardAdapter2.OooO00o.getMediationManager().getBestEcpm().getEcpm());
                        CsjRewardAdapter csjRewardAdapter3 = CsjRewardAdapter.this;
                        csjRewardAdapter3.showLog(csjRewardAdapter3.OooO0O0, "price:" + integerValue);
                        if (integerValue <= 0) {
                            integerValue = (int) CsjUtils.getBestPriceInCacheNew(tTRewardVideoAd, CsjRewardAdapter.this.absUbixInfo);
                            CsjRewardAdapter.this.showLog(o00OO0O0.TAG, "price1:" + integerValue);
                        }
                        CsjRewardAdapter.this.absUbixInfo.setBiddingEcpm(integerValue);
                    }
                    CsjRewardAdapter.this.onAdDataLoaded();
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached() {
                CsjRewardAdapter.this.showLog(o00OO0O0.TAG, "废弃：onRewardVideoCached");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
                try {
                    CsjRewardAdapter csjRewardAdapter = CsjRewardAdapter.this;
                    csjRewardAdapter.showLog(csjRewardAdapter.OooO0O0, "onRewardVideoCached");
                    CsjRewardAdapter.this.OooO00o = tTRewardVideoAd;
                    CsjRewardAdapter.this.OooO00o();
                    CsjRewardAdapter csjRewardAdapter2 = CsjRewardAdapter.this;
                    if (csjRewardAdapter2.loadListener != null) {
                        if (csjRewardAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            csjRewardAdapter2.absUbixInfo.csjPriceMethod = "1";
                            int integerValue = CsjRewardAdapter.this.getIntegerValue(csjRewardAdapter2.OooO00o.getMediationManager().getBestEcpm().getEcpm());
                            CsjRewardAdapter csjRewardAdapter3 = CsjRewardAdapter.this;
                            csjRewardAdapter3.showLog(csjRewardAdapter3.OooO0O0, "price:" + integerValue);
                            if (integerValue <= 0) {
                                integerValue = (int) CsjUtils.getBestPriceInCacheNew(tTRewardVideoAd, CsjRewardAdapter.this.absUbixInfo);
                                CsjRewardAdapter.this.showLog(o00OO0O0.TAG, "price1:" + integerValue);
                            }
                            CsjRewardAdapter.this.absUbixInfo.setBiddingEcpm(integerValue);
                        }
                        CsjRewardAdapter csjRewardAdapter4 = CsjRewardAdapter.this;
                        csjRewardAdapter4.loadListener.onAdCacheSuccess(csjRewardAdapter4.absUbixInfo);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }
        });
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void loadRewardAd(final Context context, o00O000 o00o000) {
        Log.e(InternalFrame.ID, "context instanceof Activity? " + (context instanceof Activity));
        createADInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(this.adsSlotid)) {
            CsjInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.csj.CsjRewardAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = CsjRewardAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", CsjInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) CsjRewardAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    CsjRewardAdapter.this.loadAd(context);
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, CsjInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        }
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void show(final Activity activity) {
        showLog(this.OooO0O0, "show() ");
        BaseUtils.postDelayed(new Runnable() { // from class: com.ubixnow.network.csj.CsjRewardAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                if (CsjRewardAdapter.this.OooO00o == null || (activity2 = activity) == null || activity2.isFinishing()) {
                    return;
                }
                CsjRewardAdapter.this.OooO00o.showRewardVideoAd(activity);
            }
        }, 500L);
    }
}
