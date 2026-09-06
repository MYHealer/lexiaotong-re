package com.meishu.sdk.platform.mimo.insterstitial;

import android.app.Activity;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.interstitial.InterstitialAd;
import com.meishu.sdk.core.loader.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.meishu_ad.lifecycle.c;
import com.meishu.sdk.meishu_ad.lifecycle.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoInterstitialAd extends InterstitialAd {
    private static final String TAG = "MimoInterstitialAd";
    private MimoInterstitialAdLoader adWrapper;
    private boolean isClick;
    private c lifecycleHelper;
    private d lifecycleListener;
    private com.miui.zeus.mimo.sdk.InterstitialAd nativeInterstitialAd;

    public MimoInterstitialAd(com.miui.zeus.mimo.sdk.InterstitialAd interstitialAd, MimoInterstitialAdLoader mimoInterstitialAdLoader) {
        super(mimoInterstitialAdLoader, "MIMO");
        this.lifecycleListener = new d() { // from class: com.meishu.sdk.platform.mimo.insterstitial.MimoInterstitialAd.3
            @Override // com.meishu.sdk.meishu_ad.lifecycle.d
            public void onDestroy() {
            }

            @Override // com.meishu.sdk.meishu_ad.lifecycle.d
            public void onPause() {
                if (MimoInterstitialAd.this.nativeInterstitialAd == null || MimoInterstitialAd.this.isClick) {
                    MimoInterstitialAd.this.isClick = false;
                } else {
                    MimoInterstitialAd.this.nativeInterstitialAd.destroy();
                }
            }

            @Override // com.meishu.sdk.meishu_ad.lifecycle.d
            public void onResume() {
            }

            @Override // com.meishu.sdk.meishu_ad.lifecycle.d
            public void onStart() {
            }

            @Override // com.meishu.sdk.meishu_ad.lifecycle.d
            public void onStop() {
            }
        };
        this.nativeInterstitialAd = interstitialAd;
        this.adWrapper = mimoInterstitialAdLoader;
    }

    public void setClick() {
        this.isClick = true;
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd() {
        if (AdSdk.adConfig().getEnableInterstitialAutoClose()) {
            if (this.lifecycleHelper == null) {
                this.lifecycleHelper = new c();
            }
            if (this.adWrapper.getContext() != null) {
                this.lifecycleHelper.b = (Activity) this.adWrapper.getContext();
                this.lifecycleHelper.a(this.lifecycleListener);
            }
        }
        this.nativeInterstitialAd.show((Activity) this.adWrapper.getContext(), new com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener() { // from class: com.meishu.sdk.platform.mimo.insterstitial.MimoInterstitialAd.1
            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
            public void onAdClick() {
                LogUtil.d(MimoInterstitialAd.TAG, "send onAdClick");
                MimoInterstitialAd.this.setClick();
                a.a(MimoInterstitialAd.this.adWrapper.getContext(), f.a(MimoInterstitialAd.this.adWrapper.getSdkAdInfo().getClk(), MimoInterstitialAd.this));
                if (MimoInterstitialAd.this.getInteractionListener() != null) {
                    MimoInterstitialAd.this.getInteractionListener().onAdClicked();
                }
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
            public void onAdClosed() {
                LogUtil.d(MimoInterstitialAd.TAG, "send onAdClosed");
                if (MimoInterstitialAd.this.adWrapper.getLoaderListener() != null) {
                    MimoInterstitialAd.this.adWrapper.getLoaderListener().onAdClosed();
                }
                if (MimoInterstitialAd.this.getInteractionListener() != null) {
                    MimoInterstitialAd.this.getInteractionListener().onAdClosed();
                }
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
            public void onAdShow() {
                LogUtil.d(MimoInterstitialAd.TAG, "send onAdShow");
                if (MimoInterstitialAd.this.adWrapper.getLoaderListener() != null) {
                    MimoInterstitialAd.this.adWrapper.getLoaderListener().onAdExposure();
                }
                if (MimoInterstitialAd.this.getInteractionListener() != null) {
                    MimoInterstitialAd.this.getInteractionListener().onAdExposure();
                }
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
            public void onRenderFail(int i, String str) {
                if (MimoInterstitialAd.this.adWrapper.getLoaderListener() != null) {
                    MimoInterstitialAd.this.adWrapper.getLoaderListener().onAdRenderFail(str, i);
                }
                LogUtil.e(MimoInterstitialAd.TAG, "onRenderFail, code: " + i + ", msg: " + str);
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
            public void onVideoEnd() {
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
            public void onVideoPause() {
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
            public void onVideoResume() {
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
            public void onVideoStart() {
            }
        });
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd(Activity activity) {
        if (AdSdk.adConfig().getEnableInterstitialAutoClose()) {
            if (this.lifecycleHelper == null) {
                this.lifecycleHelper = new c();
            }
            if (activity != null) {
                c cVar = this.lifecycleHelper;
                cVar.b = activity;
                cVar.a(this.lifecycleListener);
            }
        }
        this.nativeInterstitialAd.show(activity, new com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener() { // from class: com.meishu.sdk.platform.mimo.insterstitial.MimoInterstitialAd.2
            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
            public void onAdClick() {
                LogUtil.d(MimoInterstitialAd.TAG, "send onAdClick");
                MimoInterstitialAd.this.setClick();
                a.a(MimoInterstitialAd.this.adWrapper.getContext(), f.a(MimoInterstitialAd.this.adWrapper.getSdkAdInfo().getClk(), MimoInterstitialAd.this));
                if (MimoInterstitialAd.this.getInteractionListener() != null) {
                    MimoInterstitialAd.this.getInteractionListener().onAdClicked();
                }
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
            public void onAdClosed() {
                LogUtil.d(MimoInterstitialAd.TAG, "send onAdClosed");
                if (MimoInterstitialAd.this.adWrapper.getLoaderListener() != null) {
                    MimoInterstitialAd.this.adWrapper.getLoaderListener().onAdClosed();
                }
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
            public void onAdShow() {
                LogUtil.d(MimoInterstitialAd.TAG, "send onAdShow");
                if (MimoInterstitialAd.this.adWrapper.getLoaderListener() != null) {
                    MimoInterstitialAd.this.adWrapper.getLoaderListener().onAdExposure();
                }
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
            public void onRenderFail(int i, String str) {
                if (MimoInterstitialAd.this.adWrapper.getLoaderListener() != null) {
                    MimoInterstitialAd.this.adWrapper.getLoaderListener().onAdRenderFail(str, i);
                }
                LogUtil.e(MimoInterstitialAd.TAG, "onRenderFail, code: " + i + ", msg: " + str);
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
            public void onVideoEnd() {
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
            public void onVideoPause() {
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
            public void onVideoResume() {
            }

            @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
            public void onVideoStart() {
            }
        });
    }
}
