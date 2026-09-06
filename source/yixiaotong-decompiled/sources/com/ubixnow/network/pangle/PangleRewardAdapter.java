package com.ubixnow.network.pangle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.cdo.oaps.ad.OapsKey;
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
public class PangleRewardAdapter extends UMNCustomRewardAdapter {
    private TTRewardVideoAd OooO00o;
    private final String OooO0O0 = this.customTag + PangleInitManager.getInstance().getName();

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o() {
        TTRewardVideoAd tTRewardVideoAd = this.OooO00o;
        if (tTRewardVideoAd != null) {
            tTRewardVideoAd.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.ubixnow.network.pangle.PangleRewardAdapter.4
                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onAdClose() {
                    PangleRewardAdapter pangleRewardAdapter = PangleRewardAdapter.this;
                    pangleRewardAdapter.showLog(pangleRewardAdapter.OooO0O0, "onAdClose");
                    if (PangleRewardAdapter.this.eventListener != null) {
                        PangleRewardAdapter.this.eventListener.onAdDismiss(PangleRewardAdapter.this.absUbixInfo);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onAdShow() {
                    PangleRewardAdapter pangleRewardAdapter = PangleRewardAdapter.this;
                    pangleRewardAdapter.showLog(pangleRewardAdapter.OooO0O0, "onAdShow");
                    if (PangleRewardAdapter.this.eventListener != null) {
                        PangleRewardAdapter.this.eventListener.onAdShow(PangleRewardAdapter.this.absUbixInfo);
                        PangleRewardAdapter.this.eventListener.onVideoPlayStart(PangleRewardAdapter.this.absUbixInfo);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onAdVideoBarClick() {
                    PangleRewardAdapter pangleRewardAdapter = PangleRewardAdapter.this;
                    pangleRewardAdapter.showLog(pangleRewardAdapter.OooO0O0, "onAdVideoBarClick");
                    if (PangleRewardAdapter.this.eventListener != null) {
                        PangleRewardAdapter.this.eventListener.onAdClick(PangleRewardAdapter.this.absUbixInfo);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onRewardArrived(boolean z, int i, Bundle bundle) {
                    PangleRewardAdapter pangleRewardAdapter = PangleRewardAdapter.this;
                    pangleRewardAdapter.showLog(pangleRewardAdapter.OooO0O0, "onRewardArrived");
                    if (PangleRewardAdapter.this.eventListener != null) {
                        PangleRewardAdapter.this.eventListener.onRewardVerify(PangleRewardAdapter.this.absUbixInfo);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
                    PangleRewardAdapter.this.showLog(o00OO0O0.TAG, "废弃：onRewardVerify");
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onSkippedVideo() {
                    PangleRewardAdapter pangleRewardAdapter = PangleRewardAdapter.this;
                    pangleRewardAdapter.showLog(pangleRewardAdapter.OooO0O0, "onSkippedVideo");
                    if (PangleRewardAdapter.this.eventListener != null) {
                        PangleRewardAdapter.this.eventListener.onVideoSkip(PangleRewardAdapter.this.absUbixInfo);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onVideoComplete() {
                    PangleRewardAdapter pangleRewardAdapter = PangleRewardAdapter.this;
                    pangleRewardAdapter.showLog(pangleRewardAdapter.OooO0O0, "onVideoComplete");
                    if (PangleRewardAdapter.this.eventListener != null) {
                        PangleRewardAdapter.this.eventListener.onVideoPlayComplete(PangleRewardAdapter.this.absUbixInfo);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onVideoError() {
                    PangleRewardAdapter pangleRewardAdapter = PangleRewardAdapter.this;
                    pangleRewardAdapter.showLog(pangleRewardAdapter.OooO0O0, "onVideoError");
                    if (PangleRewardAdapter.this.eventListener != null) {
                        PangleRewardAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_videoshow_error_msg, "-1", oOO00O0.ubix_videoshow_error_msg).setInfo((Object) PangleRewardAdapter.this.absUbixInfo));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(TTRewardVideoAd tTRewardVideoAd) {
        try {
            if (this.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                Object obj = tTRewardVideoAd.getMediaExtraInfo().get(OapsKey.KEY_PRICE);
                int iIntValue = obj instanceof Number ? ((Number) obj).intValue() : 0;
                showLog(o00OO0O0.TAG, "price:" + iIntValue);
                this.absUbixInfo.setBiddingEcpm(iIntValue);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        try {
            showLog(o00OO0O0.TAG, "destory");
            TTRewardVideoAd tTRewardVideoAd = this.OooO00o;
            if (tTRewardVideoAd != null) {
                tTRewardVideoAd.setRewardAdInteractionListener(null);
            }
            this.OooO00o = null;
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        return this.OooO00o != null;
    }

    public void loadAd(Context context) {
        showLog(this.OooO0O0, "start loadAd " + this.adsSlotid);
        TTAdSdk.getAdManager().createAdNative(context).loadRewardVideoAd(new AdSlot.Builder().setCodeId(this.adsSlotid).build(), new TTAdNative.RewardVideoAdListener() { // from class: com.ubixnow.network.pangle.PangleRewardAdapter.3
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onError(int i, String str) {
                PangleRewardAdapter pangleRewardAdapter = PangleRewardAdapter.this;
                pangleRewardAdapter.showLog(pangleRewardAdapter.OooO0O0, "onError code：" + i + "  msg:" + str);
                o00O00o0 o00o00o0 = PangleRewardAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", PangleInitManager.getInstance().getName() + str).setInfo((Object) PangleRewardAdapter.this.absUbixInfo));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
                try {
                    PangleRewardAdapter pangleRewardAdapter = PangleRewardAdapter.this;
                    pangleRewardAdapter.showLog(pangleRewardAdapter.OooO0O0, "onRewardVideoAdLoad");
                    PangleRewardAdapter.this.OooO00o = tTRewardVideoAd;
                    PangleRewardAdapter.this.OooO00o(tTRewardVideoAd);
                    PangleRewardAdapter.this.onAdDataLoaded();
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached() {
                PangleRewardAdapter.this.showLog(o00OO0O0.TAG, "废弃：onRewardVideoCached");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
                PangleRewardAdapter pangleRewardAdapter;
                String str;
                String str2;
                try {
                    PangleRewardAdapter pangleRewardAdapter2 = PangleRewardAdapter.this;
                    pangleRewardAdapter2.showLog(pangleRewardAdapter2.OooO0O0, "onRewardVideoCached");
                    PangleRewardAdapter.this.OooO00o = tTRewardVideoAd;
                    PangleRewardAdapter.this.OooO00o();
                    PangleRewardAdapter pangleRewardAdapter3 = PangleRewardAdapter.this;
                    if (pangleRewardAdapter3.loadListener != null) {
                        pangleRewardAdapter3.OooO00o(tTRewardVideoAd);
                        if (PangleRewardAdapter.this.isValid()) {
                            PangleRewardAdapter pangleRewardAdapter4 = PangleRewardAdapter.this;
                            pangleRewardAdapter4.loadListener.onAdCacheSuccess(pangleRewardAdapter4.absUbixInfo);
                            pangleRewardAdapter = PangleRewardAdapter.this;
                            str2 = pangleRewardAdapter.OooO0O0;
                            str = "isValid:" + PangleRewardAdapter.this.isValid();
                        } else {
                            PangleRewardAdapter pangleRewardAdapter5 = PangleRewardAdapter.this;
                            oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.RENDER_FAIL;
                            pangleRewardAdapter5.onAdRenderFail(oooO00o.OooO00o(), oooO00o.OooO0O0());
                            pangleRewardAdapter = PangleRewardAdapter.this;
                            String str3 = pangleRewardAdapter.OooO0O0;
                            str = "onAdRenderFail:" + PangleRewardAdapter.this.isValid();
                            str2 = str3;
                        }
                        pangleRewardAdapter.showLog(str2, str);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }
        });
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void loadRewardAd(final Context context, o00O000 o00o000) {
        Log.e(InternalFrame.ID, "mContext instanceof Activity? " + (context instanceof Activity));
        createADInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(this.adsSlotid)) {
            PangleInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.pangle.PangleRewardAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = PangleRewardAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", PangleInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) PangleRewardAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    PangleRewardAdapter.this.loadAd(context);
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, PangleInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        }
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void show(final Activity activity) {
        showLog(this.OooO0O0, "show() ");
        BaseUtils.postDelayed(new Runnable() { // from class: com.ubixnow.network.pangle.PangleRewardAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                if (PangleRewardAdapter.this.OooO00o == null || activity == null) {
                    return;
                }
                PangleRewardAdapter.this.OooO00o.showRewardVideoAd(activity);
            }
        }, 500L);
    }
}
