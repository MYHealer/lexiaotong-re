package com.ubixnow.network.pangle;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.cdo.oaps.ad.OapsKey;
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
public class PangleInterstitialAdapter extends UMNCustomInterstitalAdapter {
    private final String OooO00o = this.customTag + PangleInitManager.getInstance().getName();
    private TTFullScreenVideoAd OooO0O0;

    private void OooO00o() {
        this.OooO0O0.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.ubixnow.network.pangle.PangleInterstitialAdapter.3
            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdClose() {
                PangleInterstitialAdapter pangleInterstitialAdapter = PangleInterstitialAdapter.this;
                pangleInterstitialAdapter.showLog(pangleInterstitialAdapter.OooO00o, "Callback --> FullVideoAd onAdClose");
                if (PangleInterstitialAdapter.this.eventListener != null) {
                    PangleInterstitialAdapter.this.eventListener.onAdDismiss(PangleInterstitialAdapter.this.absUbixInfo);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdShow() {
                PangleInterstitialAdapter pangleInterstitialAdapter = PangleInterstitialAdapter.this;
                pangleInterstitialAdapter.showLog(pangleInterstitialAdapter.OooO00o, "Callback --> FullVideoAd show");
                if (PangleInterstitialAdapter.this.eventListener != null) {
                    PangleInterstitialAdapter.this.eventListener.onAdShow(PangleInterstitialAdapter.this.absUbixInfo);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdVideoBarClick() {
                PangleInterstitialAdapter pangleInterstitialAdapter = PangleInterstitialAdapter.this;
                pangleInterstitialAdapter.showLog(pangleInterstitialAdapter.OooO00o, "Callback --> FullVideoAd onAdVideoBarClick");
                if (PangleInterstitialAdapter.this.eventListener != null) {
                    PangleInterstitialAdapter.this.eventListener.onAdClick(PangleInterstitialAdapter.this.absUbixInfo);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onSkippedVideo() {
                PangleInterstitialAdapter pangleInterstitialAdapter = PangleInterstitialAdapter.this;
                pangleInterstitialAdapter.showLog(pangleInterstitialAdapter.OooO00o, "Callback --> onSkippedVideo");
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onVideoComplete() {
                PangleInterstitialAdapter pangleInterstitialAdapter = PangleInterstitialAdapter.this;
                pangleInterstitialAdapter.showLog(pangleInterstitialAdapter.OooO00o, "Callback --> onVideoComplete");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(TTFullScreenVideoAd tTFullScreenVideoAd) {
        try {
            if (this.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                Object obj = tTFullScreenVideoAd.getMediaExtraInfo().get(OapsKey.KEY_PRICE);
                int iIntValue = obj instanceof Number ? ((Number) obj).intValue() : 0;
                showLog(this.OooO00o, "price:" + iIntValue);
                this.absUbixInfo.setBiddingEcpm(iIntValue);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd() {
        this.mParams = (UMNInterstitalParams) this.mBaseAdConfig.OooO0o0;
        TTAdSdk.getAdManager().createAdNative(this.mContext).loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(this.adsSlotid).build(), new TTAdNative.FullScreenVideoAdListener() { // from class: com.ubixnow.network.pangle.PangleInterstitialAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onError(int i, String str) {
                PangleInterstitialAdapter.this.onAdDataLoadFailed(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
                PangleInterstitialAdapter pangleInterstitialAdapter = PangleInterstitialAdapter.this;
                pangleInterstitialAdapter.showLog(pangleInterstitialAdapter.OooO00o, "onFullScreenVideoAdLoad");
                PangleInterstitialAdapter.this.OooO0O0 = tTFullScreenVideoAd;
                PangleInterstitialAdapter pangleInterstitialAdapter2 = PangleInterstitialAdapter.this;
                if (pangleInterstitialAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    try {
                        pangleInterstitialAdapter2.OooO00o(pangleInterstitialAdapter2.OooO0O0);
                    } catch (Exception e) {
                        ooooO000.OooO00o(e);
                    }
                }
                PangleInterstitialAdapter.this.onAdDataLoaded();
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached() {
                PangleInterstitialAdapter pangleInterstitialAdapter = PangleInterstitialAdapter.this;
                pangleInterstitialAdapter.showLog(pangleInterstitialAdapter.OooO00o, "废弃：onFullScreenVideoCached");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
                PangleInterstitialAdapter pangleInterstitialAdapter;
                String str;
                String str2;
                PangleInterstitialAdapter pangleInterstitialAdapter2 = PangleInterstitialAdapter.this;
                pangleInterstitialAdapter2.showLog(pangleInterstitialAdapter2.OooO00o, "onFullScreenVideoCached");
                try {
                    PangleInterstitialAdapter.this.OooO0O0 = tTFullScreenVideoAd;
                    PangleInterstitialAdapter pangleInterstitialAdapter3 = PangleInterstitialAdapter.this;
                    if (pangleInterstitialAdapter3.loadListener != null) {
                        pangleInterstitialAdapter3.OooO00o(pangleInterstitialAdapter3.OooO0O0);
                        if (PangleInterstitialAdapter.this.isValid()) {
                            PangleInterstitialAdapter pangleInterstitialAdapter4 = PangleInterstitialAdapter.this;
                            pangleInterstitialAdapter4.loadListener.onAdCacheSuccess(pangleInterstitialAdapter4.absUbixInfo);
                            pangleInterstitialAdapter = PangleInterstitialAdapter.this;
                            str2 = pangleInterstitialAdapter.OooO00o;
                            str = "isValid:" + PangleInterstitialAdapter.this.isValid();
                        } else {
                            PangleInterstitialAdapter pangleInterstitialAdapter5 = PangleInterstitialAdapter.this;
                            oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.RENDER_FAIL;
                            pangleInterstitialAdapter5.onAdRenderFail(oooO00o.OooO00o(), oooO00o.OooO0O0());
                            pangleInterstitialAdapter = PangleInterstitialAdapter.this;
                            String str3 = pangleInterstitialAdapter.OooO00o;
                            str = "onAdRenderFail:" + PangleInterstitialAdapter.this.isValid();
                            str2 = str3;
                        }
                        pangleInterstitialAdapter.showLog(str2, str);
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
            PangleInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.pangle.PangleInterstitialAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = PangleInterstitialAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", PangleInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) PangleInterstitialAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    PangleInterstitialAdapter.this.loadAd();
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, PangleInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
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
