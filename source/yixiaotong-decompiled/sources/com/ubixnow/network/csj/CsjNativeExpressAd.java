package com.ubixnow.network.csj;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import com.stub.StubApp;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.bean.UMNNativeExtraInfo;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.oO0000O;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.ooooO000;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class CsjNativeExpressAd extends UMNCustomNativeAd {
    private final String OooO00o = "-----CsjNativeExpressAd";
    public TTAdNative OooO0O0;
    public TTFeedAd OooO0OO;
    public AdSlot OooO0Oo;
    private oo000o OooO0o;
    private WeakReference<Context> OooO0o0;
    public Activity OooO0oO;

    public CsjNativeExpressAd(Context context, UMNNativeParams uMNNativeParams, String str) {
        this.OooO0o0 = new WeakReference<>(context);
        if (!uMNNativeParams.cacheAd && (context instanceof Activity)) {
            this.OooO0oO = (Activity) context;
        }
        int i = uMNNativeParams.width;
        int iOooO00o = i > 0 ? oO0000O.OooO00o(i) : -1;
        int i2 = uMNNativeParams.height;
        int iOooO00o2 = i2 > 0 ? oO0000O.OooO00o(i2) : 0;
        iOooO00o = iOooO00o <= 0 ? MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK : iOooO00o;
        ooooO000.OooO00o("pangle express height dp:" + iOooO00o2);
        this.OooO0O0 = TTAdSdk.getAdManager().createAdNative(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.OooO0Oo = new AdSlot.Builder().setCodeId(str).setAdCount(1).setExpressViewAcceptedSize(iOooO00o, iOooO00o2).build();
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00oOoo
    public void destroy() {
        super.destroy();
        showLog(this.OooO00o, "destroy");
        TTFeedAd tTFeedAd = this.OooO0OO;
        if (tTFeedAd != null) {
            tTFeedAd.destroy();
        }
        this.OooO0oO = null;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        try {
            return this.OooO0OO.getAdView();
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return null;
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public String getNativeExpressType() {
        TTFeedAd tTFeedAd = this.OooO0OO;
        if (tTFeedAd != null) {
            return (tTFeedAd.getImageMode() == 5 || this.OooO0OO.getImageMode() == 15) ? "1" : "0";
        }
        return "0";
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public boolean isValid() {
        TTFeedAd tTFeedAd = this.OooO0OO;
        if (tTFeedAd == null || tTFeedAd.getMediationManager() == null) {
            return false;
        }
        return this.OooO0OO.getMediationManager().isReady();
    }

    public void loadAd(final oo000o oo000oVar, final o00O00o0 o00o00o0) {
        this.OooO0o = oo000oVar;
        this.loadListener = o00o00o0;
        this.OooO0O0.loadFeedAd(this.OooO0Oo, new TTAdNative.FeedAdListener() { // from class: com.ubixnow.network.csj.CsjNativeExpressAd.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str) {
                CsjNativeExpressAd csjNativeExpressAd = CsjNativeExpressAd.this;
                csjNativeExpressAd.showLog(csjNativeExpressAd.OooO00o, " onError " + str);
                o00O00o0 o00o00o1 = o00o00o0;
                if (o00o00o1 != null) {
                    o00o00o1.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str).setInfo((Object) oo000oVar));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                CsjNativeExpressAd csjNativeExpressAd = CsjNativeExpressAd.this;
                csjNativeExpressAd.showLog(csjNativeExpressAd.OooO00o, "onNativeExpressAdLoad");
                if (list == null || list.size() <= 0) {
                    return;
                }
                CsjNativeExpressAd.this.OooO0OO = list.get(0);
                try {
                    if (oo000oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                        oo000oVar.csjPriceMethod = "1";
                        int integerValue = CsjNativeExpressAd.this.getIntegerValue(list.get(0).getMediationManager().getBestEcpm().getEcpm());
                        CsjNativeExpressAd csjNativeExpressAd2 = CsjNativeExpressAd.this;
                        csjNativeExpressAd2.showLog(csjNativeExpressAd2.OooO00o, "price:" + integerValue);
                        if (integerValue <= 0) {
                            integerValue = (int) CsjUtils.getBestPriceInCacheNew(CsjNativeExpressAd.this.OooO0OO, oo000oVar);
                            CsjNativeExpressAd csjNativeExpressAd3 = CsjNativeExpressAd.this;
                            csjNativeExpressAd3.showLog(csjNativeExpressAd3.OooO00o, "price1:" + integerValue);
                        }
                        oo000oVar.setBiddingEcpm(integerValue);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
                CsjNativeExpressAd csjNativeExpressAd4 = CsjNativeExpressAd.this;
                csjNativeExpressAd4.onAdDataLoaded(csjNativeExpressAd4.OooO0o);
                if (!CsjNativeExpressAd.this.OooO0OO.getMediationManager().isExpress()) {
                    if (o00o00o0 != null) {
                        CsjNativeExpressAd.this.OooO0o.checkMaterialStatus = 10;
                        o00o00o0.onAdCacheSuccess(CsjNativeExpressAd.this.OooO0o);
                        return;
                    }
                    return;
                }
                CsjNativeExpressAd.this.registSelf();
                ArrayList arrayList = new ArrayList();
                arrayList.add(CsjNativeExpressAd.this);
                oo000oVar.OooO00o = arrayList;
                CsjNativeExpressAd.this.OooO0OO.render();
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0041  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void regist(ViewGroup viewGroup, UMNNativeExtraInfo uMNNativeExtraInfo) {
        Activity activity;
        Context context;
        showLog(this.OooO00o, "regist");
        if (viewGroup == null || viewGroup.getContext() == null || !(viewGroup.getContext() instanceof Activity)) {
            WeakReference<Context> weakReference = this.OooO0o0;
            if (weakReference == null || weakReference.get() == null || !(this.OooO0o0.get() instanceof Activity)) {
                activity = this.OooO0oO;
                if (activity == null) {
                    activity = null;
                }
            } else {
                context = this.OooO0o0.get();
            }
            if (activity != null) {
                showLog(this.OooO00o, "setDislikeCallback");
                this.OooO0OO.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.ubixnow.network.csj.CsjNativeExpressAd.4
                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onCancel() {
                        CsjNativeExpressAd csjNativeExpressAd = CsjNativeExpressAd.this;
                        csjNativeExpressAd.showLog(csjNativeExpressAd.OooO00o, "onCancel");
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onSelected(int i, String str, boolean z) {
                        CsjNativeExpressAd csjNativeExpressAd = CsjNativeExpressAd.this;
                        csjNativeExpressAd.showLog(csjNativeExpressAd.OooO00o, "---onSelected-onDislikeClicked");
                        CsjNativeExpressAd.this.notifyAdDislikeClick();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onShow() {
                        CsjNativeExpressAd csjNativeExpressAd = CsjNativeExpressAd.this;
                        csjNativeExpressAd.showLog(csjNativeExpressAd.OooO00o, "onShow");
                    }
                });
            }
        }
        context = viewGroup.getContext();
        activity = (Activity) context;
        if (activity != null) {
            showLog(this.OooO00o, "setDislikeCallback");
            this.OooO0OO.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.ubixnow.network.csj.CsjNativeExpressAd.4
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                    CsjNativeExpressAd csjNativeExpressAd = CsjNativeExpressAd.this;
                    csjNativeExpressAd.showLog(csjNativeExpressAd.OooO00o, "onCancel");
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int i, String str, boolean z) {
                    CsjNativeExpressAd csjNativeExpressAd = CsjNativeExpressAd.this;
                    csjNativeExpressAd.showLog(csjNativeExpressAd.OooO00o, "---onSelected-onDislikeClicked");
                    CsjNativeExpressAd.this.notifyAdDislikeClick();
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                    CsjNativeExpressAd csjNativeExpressAd = CsjNativeExpressAd.this;
                    csjNativeExpressAd.showLog(csjNativeExpressAd.OooO00o, "onShow");
                }
            });
        }
    }

    public void registSelf() {
        this.OooO0OO.setExpressRenderListener(new MediationExpressRenderListener() { // from class: com.ubixnow.network.csj.CsjNativeExpressAd.2
            @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
            public void onAdClick() {
                CsjNativeExpressAd csjNativeExpressAd = CsjNativeExpressAd.this;
                csjNativeExpressAd.showLog(csjNativeExpressAd.OooO00o, "onAdClicked");
                CsjNativeExpressAd.this.notifyAdClicked();
            }

            @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
            public void onAdShow() {
                CsjNativeExpressAd csjNativeExpressAd = CsjNativeExpressAd.this;
                csjNativeExpressAd.showLog(csjNativeExpressAd.OooO00o, "onAdShow");
                TTFeedAd tTFeedAd = CsjNativeExpressAd.this.OooO0OO;
                if (tTFeedAd != null && tTFeedAd.getMediationManager() != null && CsjNativeExpressAd.this.OooO0OO.getMediationManager().getShowEcpm() != null) {
                    CsjNativeExpressAd csjNativeExpressAd2 = CsjNativeExpressAd.this;
                    csjNativeExpressAd2.showLog(csjNativeExpressAd2.OooO00o, "show price:" + CsjNativeExpressAd.this.OooO0OO.getMediationManager().getShowEcpm().getEcpm());
                }
                CsjNativeExpressAd.this.notifyAdExposure();
            }

            @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
            public void onRenderFail(View view, String str, int i) {
                CsjNativeExpressAd.this.onADRenderFail(i + "", str, CsjNativeExpressAd.this.OooO0o);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.ExpressRenderListener
            public void onRenderSuccess(View view, float f, float f2, boolean z) {
                CsjNativeExpressAd csjNativeExpressAd = CsjNativeExpressAd.this;
                csjNativeExpressAd.showLog(csjNativeExpressAd.OooO00o, "onRenderSuccess");
                if (CsjNativeExpressAd.this.loadListener != null) {
                    CsjNativeExpressAd.this.loadListener.onAdCacheSuccess(CsjNativeExpressAd.this.OooO0o);
                }
            }
        });
        this.OooO0OO.setVideoAdListener(new TTFeedAd.VideoAdListener() { // from class: com.ubixnow.network.csj.CsjNativeExpressAd.3
            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onProgressUpdate(long j, long j2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdComplete(TTFeedAd tTFeedAd) {
                CsjNativeExpressAd csjNativeExpressAd = CsjNativeExpressAd.this;
                csjNativeExpressAd.showLog(csjNativeExpressAd.OooO00o, "onVideoAdComplete");
                CsjNativeExpressAd.this.notifyAdVideoEnd();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
                CsjNativeExpressAd csjNativeExpressAd = CsjNativeExpressAd.this;
                csjNativeExpressAd.showLog(csjNativeExpressAd.OooO00o, "onVideoAdContinuePlay");
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdPaused(TTFeedAd tTFeedAd) {
                CsjNativeExpressAd csjNativeExpressAd = CsjNativeExpressAd.this;
                csjNativeExpressAd.showLog(csjNativeExpressAd.OooO00o, "onVideoAdPaused");
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
                CsjNativeExpressAd csjNativeExpressAd = CsjNativeExpressAd.this;
                csjNativeExpressAd.showLog(csjNativeExpressAd.OooO00o, "onVideoAdStartPlay");
                CsjNativeExpressAd.this.notifyAdVideoStart();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoError(int i, int i2) {
                CsjNativeExpressAd csjNativeExpressAd = CsjNativeExpressAd.this;
                csjNativeExpressAd.showLog(csjNativeExpressAd.OooO00o, "onVideoError");
                CsjNativeExpressAd.this.notifyAdVideoError();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoLoad(TTFeedAd tTFeedAd) {
                CsjNativeExpressAd csjNativeExpressAd = CsjNativeExpressAd.this;
                csjNativeExpressAd.showLog(csjNativeExpressAd.OooO00o, "onVideoLoad");
            }
        });
    }
}
