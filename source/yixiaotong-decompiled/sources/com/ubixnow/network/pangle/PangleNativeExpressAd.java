package com.ubixnow.network.pangle;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.cdo.oaps.ad.OapsKey;
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
public class PangleNativeExpressAd extends UMNCustomNativeAd {
    private final String OooO00o = "-----PangleNativeExpressAd";
    public TTAdNative OooO0O0;
    public TTNativeExpressAd OooO0OO;
    public AdSlot OooO0Oo;
    private oo000o OooO0o;
    private final WeakReference<Context> OooO0o0;
    public Activity OooO0oO;

    public PangleNativeExpressAd(Context context, UMNNativeParams uMNNativeParams, String str) {
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
        this.OooO0Oo = new AdSlot.Builder().setCodeId(str).setAdCount(1).setSupportDeepLink(true).setExpressViewAcceptedSize(iOooO00o, iOooO00o2).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(oo000o oo000oVar, TTNativeExpressAd tTNativeExpressAd) {
        try {
            if (oo000oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                Object obj = tTNativeExpressAd.getMediaExtraInfo().get(OapsKey.KEY_PRICE);
                int iIntValue = obj instanceof Number ? ((Number) obj).intValue() : 0;
                showLog(this.OooO00o, "price:" + iIntValue);
                oo000oVar.setBiddingEcpm(iIntValue);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00oOoo
    public void destroy() {
        super.destroy();
        showLog(this.OooO00o, "destroy");
        TTNativeExpressAd tTNativeExpressAd = this.OooO0OO;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) null);
            this.OooO0OO.destroy();
        }
        this.OooO0OO = null;
        this.OooO0oO = null;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        try {
            return this.OooO0OO.getExpressAdView();
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return null;
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public String getNativeExpressType() {
        TTNativeExpressAd tTNativeExpressAd = this.OooO0OO;
        if (tTNativeExpressAd != null && (tTNativeExpressAd.getImageMode() == 5 || this.OooO0OO.getImageMode() == 15)) {
            return "1";
        }
        TTNativeExpressAd tTNativeExpressAd2 = this.OooO0OO;
        if (tTNativeExpressAd2 != null) {
            return (tTNativeExpressAd2.getImageMode() == 3 || this.OooO0OO.getImageMode() == 2 || this.OooO0OO.getImageMode() == 4 || this.OooO0OO.getImageMode() == 16) ? "2" : "0";
        }
        return "0";
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public boolean isValid() {
        return this.OooO0OO != null;
    }

    public void loadAd(final oo000o oo000oVar, final o00O00o0 o00o00o0) {
        this.OooO0o = oo000oVar;
        this.loadListener = o00o00o0;
        this.OooO0O0.loadNativeExpressAd(this.OooO0Oo, new TTAdNative.NativeExpressAdListener() { // from class: com.ubixnow.network.pangle.PangleNativeExpressAd.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str) {
                PangleNativeExpressAd pangleNativeExpressAd = PangleNativeExpressAd.this;
                pangleNativeExpressAd.showLog(pangleNativeExpressAd.OooO00o, " onError " + str);
                o00O00o0 o00o00o1 = o00o00o0;
                if (o00o00o1 != null) {
                    o00o00o1.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str).setInfo((Object) oo000oVar));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                PangleNativeExpressAd pangleNativeExpressAd = PangleNativeExpressAd.this;
                pangleNativeExpressAd.showLog(pangleNativeExpressAd.OooO00o, "onNativeExpressAdLoad");
                if (list == null || list.isEmpty()) {
                    return;
                }
                PangleNativeExpressAd.this.OooO0OO = list.get(0);
                PangleNativeExpressAd pangleNativeExpressAd2 = PangleNativeExpressAd.this;
                pangleNativeExpressAd2.OooO00o(oo000oVar, pangleNativeExpressAd2.OooO0OO);
                PangleNativeExpressAd pangleNativeExpressAd3 = PangleNativeExpressAd.this;
                pangleNativeExpressAd3.onAdDataLoaded(pangleNativeExpressAd3.OooO0o);
                PangleNativeExpressAd.this.registSelf();
                ArrayList arrayList = new ArrayList();
                arrayList.add(PangleNativeExpressAd.this);
                oo000oVar.OooO00o = arrayList;
                PangleNativeExpressAd.this.OooO0OO.render();
            }
        });
    }

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
            if (activity != null || this.OooO0OO == null) {
            }
            showLog(this.OooO00o, "setDislikeCallback");
            this.OooO0OO.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.ubixnow.network.pangle.PangleNativeExpressAd.4
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                    PangleNativeExpressAd pangleNativeExpressAd = PangleNativeExpressAd.this;
                    pangleNativeExpressAd.showLog(pangleNativeExpressAd.OooO00o, "onCancel");
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int i, String str, boolean z) {
                    PangleNativeExpressAd pangleNativeExpressAd = PangleNativeExpressAd.this;
                    pangleNativeExpressAd.showLog(pangleNativeExpressAd.OooO00o, "---onSelected-onDislikeClicked");
                    PangleNativeExpressAd.this.notifyAdDislikeClick();
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                    PangleNativeExpressAd pangleNativeExpressAd = PangleNativeExpressAd.this;
                    pangleNativeExpressAd.showLog(pangleNativeExpressAd.OooO00o, "onShow");
                }
            });
            return;
        }
        context = viewGroup.getContext();
        activity = (Activity) context;
        if (activity != null) {
        }
    }

    public void registSelf() {
        TTNativeExpressAd tTNativeExpressAd = this.OooO0OO;
        if (tTNativeExpressAd == null) {
            return;
        }
        tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.ubixnow.network.pangle.PangleNativeExpressAd.2
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                PangleNativeExpressAd pangleNativeExpressAd = PangleNativeExpressAd.this;
                pangleNativeExpressAd.showLog(pangleNativeExpressAd.OooO00o, "onAdClicked");
                PangleNativeExpressAd.this.notifyAdClicked();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
                PangleNativeExpressAd pangleNativeExpressAd = PangleNativeExpressAd.this;
                pangleNativeExpressAd.showLog(pangleNativeExpressAd.OooO00o, "onAdShow");
                PangleNativeExpressAd.this.notifyAdExposure();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
                PangleNativeExpressAd pangleNativeExpressAd = PangleNativeExpressAd.this;
                pangleNativeExpressAd.showLog(pangleNativeExpressAd.OooO00o, "onRenderFail");
                PangleNativeExpressAd.this.onADRenderFail(i + "", str, PangleNativeExpressAd.this.OooO0o);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f, float f2) {
                PangleNativeExpressAd pangleNativeExpressAd = PangleNativeExpressAd.this;
                pangleNativeExpressAd.showLog(pangleNativeExpressAd.OooO00o, "onRenderSuccess");
                if (PangleNativeExpressAd.this.loadListener != null) {
                    PangleNativeExpressAd.this.loadListener.onAdCacheSuccess(PangleNativeExpressAd.this.OooO0o);
                }
            }
        });
        this.OooO0OO.setVideoAdListener(new TTNativeExpressAd.ExpressVideoAdListener() { // from class: com.ubixnow.network.pangle.PangleNativeExpressAd.3
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onClickRetry() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onProgressUpdate(long j, long j2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdComplete() {
                PangleNativeExpressAd pangleNativeExpressAd = PangleNativeExpressAd.this;
                pangleNativeExpressAd.showLog(pangleNativeExpressAd.OooO00o, "onVideoAdComplete");
                PangleNativeExpressAd.this.notifyAdVideoEnd();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdContinuePlay() {
                PangleNativeExpressAd pangleNativeExpressAd = PangleNativeExpressAd.this;
                pangleNativeExpressAd.showLog(pangleNativeExpressAd.OooO00o, "onVideoAdContinuePlay");
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdPaused() {
                PangleNativeExpressAd pangleNativeExpressAd = PangleNativeExpressAd.this;
                pangleNativeExpressAd.showLog(pangleNativeExpressAd.OooO00o, "onVideoAdPaused");
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdStartPlay() {
                PangleNativeExpressAd pangleNativeExpressAd = PangleNativeExpressAd.this;
                pangleNativeExpressAd.showLog(pangleNativeExpressAd.OooO00o, "onVideoAdStartPlay");
                PangleNativeExpressAd.this.notifyAdVideoStart();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoError(int i, int i2) {
                PangleNativeExpressAd pangleNativeExpressAd = PangleNativeExpressAd.this;
                pangleNativeExpressAd.showLog(pangleNativeExpressAd.OooO00o, "onVideoError");
                PangleNativeExpressAd.this.notifyAdVideoError();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoLoad() {
                PangleNativeExpressAd pangleNativeExpressAd = PangleNativeExpressAd.this;
                pangleNativeExpressAd.showLog(pangleNativeExpressAd.OooO00o, "onVideoLoad");
            }
        });
    }
}
