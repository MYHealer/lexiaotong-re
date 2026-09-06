package com.ubixnow.network.csj;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.ubixnow.adtype.interstital.api.UMNInterstitalParams;
import com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class CsjInterstitalAdapter extends UMNCustomInterstitalAdapter {
    private final String OooO00o = this.customTag + CsjInitManager.getInstance().getName();
    private TTFullScreenVideoAd OooO0O0;

    private void OooO00o() {
        this.OooO0O0.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.ubixnow.network.csj.CsjInterstitalAdapter.3
            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdClose() {
                CsjInterstitalAdapter csjInterstitalAdapter = CsjInterstitalAdapter.this;
                csjInterstitalAdapter.showLog(csjInterstitalAdapter.OooO00o, "Callback --> FullVideoAd onAdClose");
                if (CsjInterstitalAdapter.this.eventListener != null) {
                    CsjInterstitalAdapter.this.eventListener.onAdDismiss(CsjInterstitalAdapter.this.absUbixInfo);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdShow() {
                CsjInterstitalAdapter csjInterstitalAdapter = CsjInterstitalAdapter.this;
                csjInterstitalAdapter.showLog(csjInterstitalAdapter.OooO00o, "Callback --> FullVideoAd show");
                if (CsjInterstitalAdapter.this.OooO0O0 != null && CsjInterstitalAdapter.this.OooO0O0.getMediationManager() != null && CsjInterstitalAdapter.this.OooO0O0.getMediationManager().getShowEcpm() != null) {
                    CsjInterstitalAdapter csjInterstitalAdapter2 = CsjInterstitalAdapter.this;
                    csjInterstitalAdapter2.showLog(csjInterstitalAdapter2.OooO00o, "show price:" + CsjInterstitalAdapter.this.OooO0O0.getMediationManager().getShowEcpm().getEcpm());
                }
                if (CsjInterstitalAdapter.this.eventListener != null) {
                    CsjInterstitalAdapter.this.eventListener.onAdShow(CsjInterstitalAdapter.this.absUbixInfo);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdVideoBarClick() {
                CsjInterstitalAdapter csjInterstitalAdapter = CsjInterstitalAdapter.this;
                csjInterstitalAdapter.showLog(csjInterstitalAdapter.OooO00o, "Callback --> FullVideoAd onAdVideoBarClick");
                if (CsjInterstitalAdapter.this.eventListener != null) {
                    CsjInterstitalAdapter.this.eventListener.onAdClick(CsjInterstitalAdapter.this.absUbixInfo);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onSkippedVideo() {
                CsjInterstitalAdapter csjInterstitalAdapter = CsjInterstitalAdapter.this;
                csjInterstitalAdapter.showLog(csjInterstitalAdapter.OooO00o, "Callback --> onSkippedVideo");
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onVideoComplete() {
                CsjInterstitalAdapter csjInterstitalAdapter = CsjInterstitalAdapter.this;
                csjInterstitalAdapter.showLog(csjInterstitalAdapter.OooO00o, "Callback --> onVideoComplete");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd() {
        this.mParams = (UMNInterstitalParams) this.mBaseAdConfig.OooO0o0;
        TTAdSdk.getAdManager().createAdNative(this.mContext).loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(this.adsSlotid).build(), new TTAdNative.FullScreenVideoAdListener() { // from class: com.ubixnow.network.csj.CsjInterstitalAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onError(int i, String str) {
                CsjInterstitalAdapter.this.onAdDataLoadFailed(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
                CsjInterstitalAdapter csjInterstitalAdapter = CsjInterstitalAdapter.this;
                csjInterstitalAdapter.showLog(csjInterstitalAdapter.OooO00o, "onFullScreenVideoAdLoad");
                CsjInterstitalAdapter.this.OooO0O0 = tTFullScreenVideoAd;
                CsjInterstitalAdapter csjInterstitalAdapter2 = CsjInterstitalAdapter.this;
                if (csjInterstitalAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    try {
                        csjInterstitalAdapter2.absUbixInfo.csjPriceMethod = "1";
                        int integerValue = CsjInterstitalAdapter.this.getIntegerValue(csjInterstitalAdapter2.OooO0O0.getMediationManager().getBestEcpm().getEcpm());
                        CsjInterstitalAdapter csjInterstitalAdapter3 = CsjInterstitalAdapter.this;
                        csjInterstitalAdapter3.showLog(csjInterstitalAdapter3.OooO00o, "price:" + integerValue);
                        if (integerValue <= 0) {
                            integerValue = (int) CsjUtils.getBestPriceInCacheNew(tTFullScreenVideoAd, CsjInterstitalAdapter.this.absUbixInfo);
                            CsjInterstitalAdapter csjInterstitalAdapter4 = CsjInterstitalAdapter.this;
                            csjInterstitalAdapter4.showLog(csjInterstitalAdapter4.OooO00o, "price1:" + integerValue);
                        }
                        CsjInterstitalAdapter.this.absUbixInfo.setBiddingEcpm(integerValue);
                    } catch (Exception e) {
                        ooooO000.OooO00o(e);
                    }
                }
                CsjInterstitalAdapter.this.onAdDataLoaded();
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached() {
                CsjInterstitalAdapter csjInterstitalAdapter = CsjInterstitalAdapter.this;
                csjInterstitalAdapter.showLog(csjInterstitalAdapter.OooO00o, "废弃：onFullScreenVideoCached");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
                CsjInterstitalAdapter csjInterstitalAdapter = CsjInterstitalAdapter.this;
                csjInterstitalAdapter.showLog(csjInterstitalAdapter.OooO00o, "onFullScreenVideoCached");
                try {
                    CsjInterstitalAdapter.this.OooO0O0 = tTFullScreenVideoAd;
                    CsjInterstitalAdapter csjInterstitalAdapter2 = CsjInterstitalAdapter.this;
                    if (csjInterstitalAdapter2.loadListener != null) {
                        if (csjInterstitalAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            csjInterstitalAdapter2.absUbixInfo.csjPriceMethod = "1";
                            int integerValue = CsjInterstitalAdapter.this.getIntegerValue(csjInterstitalAdapter2.OooO0O0.getMediationManager().getBestEcpm().getEcpm());
                            CsjInterstitalAdapter csjInterstitalAdapter3 = CsjInterstitalAdapter.this;
                            csjInterstitalAdapter3.showLog(csjInterstitalAdapter3.OooO00o, "price:" + integerValue);
                            if (integerValue <= 0) {
                                integerValue = (int) CsjUtils.getBestPriceInCacheNew(tTFullScreenVideoAd, CsjInterstitalAdapter.this.absUbixInfo);
                                CsjInterstitalAdapter csjInterstitalAdapter4 = CsjInterstitalAdapter.this;
                                csjInterstitalAdapter4.showLog(csjInterstitalAdapter4.OooO00o, "price1:" + integerValue);
                            }
                            CsjInterstitalAdapter.this.absUbixInfo.setBiddingEcpm(integerValue);
                        }
                        CsjInterstitalAdapter csjInterstitalAdapter5 = CsjInterstitalAdapter.this;
                        csjInterstitalAdapter5.loadListener.onAdCacheSuccess(csjInterstitalAdapter5.absUbixInfo);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        try {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.OooO0O0;
            if (tTFullScreenVideoAd == null || tTFullScreenVideoAd.getMediationManager() == null) {
                return;
            }
            this.OooO0O0.getMediationManager().destroy();
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        TTFullScreenVideoAd tTFullScreenVideoAd = this.OooO0O0;
        return (tTFullScreenVideoAd == null || tTFullScreenVideoAd.getMediationManager() == null || !this.OooO0O0.getMediationManager().isReady()) ? false : true;
    }

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void loadInterstitalAd(Context context, o00O000 o00o000) {
        this.mContext = context;
        createADInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(this.adsSlotid)) {
            CsjInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.csj.CsjInterstitalAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = CsjInterstitalAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", CsjInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) CsjInterstitalAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    CsjInterstitalAdapter.this.loadAd();
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, CsjInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        }
    }

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void show(Activity activity) {
        showLog(this.OooO00o, "show ");
        if (activity == null || activity.isFinishing() || this.OooO0O0 == null) {
            return;
        }
        OooO00o();
        this.OooO0O0.showFullScreenVideoAd(activity);
    }
}
