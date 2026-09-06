package com.meishu.sdk.platform.csj.interstitial;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.ad.interstitial.b;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.csj.CSJAdConfig;
import com.meishu.sdk.platform.csj.CSJPlatformError;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJInterstitialAdWrapper extends BasePlatformLoader<InterstitialAdLoader, b> {
    private static final String TAG = "CSJInterstitialAdWrappe";
    private MeishuAdInfo meishuAdInfo;
    private TTAdNative ttAdNative;
    private TTNativeExpressAd ttNativeExpressAd;

    public CSJInterstitialAdWrapper(InterstitialAdLoader interstitialAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        super(interstitialAdLoader, sdkAdInfo);
        this.ttAdNative = CSJAdConfig.getTtAdManager().createAdNative(interstitialAdLoader.getContext());
        this.meishuAdInfo = meishuAdInfo;
    }

    private void loadNewInterstitial() {
        int width;
        int height;
        int i;
        if (this.meishuAdInfo.getWidth() == 0 || this.meishuAdInfo.getHeight() == 0 || this.meishuAdInfo.getWidth() <= 0 || this.meishuAdInfo.getHeight() <= 0) {
            try {
                DisplayMetrics displayMetrics = ((InterstitialAdLoader) this.adLoader).getContext().getResources().getDisplayMetrics();
                int i2 = displayMetrics.widthPixels;
                if (i2 <= 0 || (i = displayMetrics.heightPixels) <= 0) {
                    width = 1080;
                    height = 1920;
                } else {
                    height = i;
                    width = i2;
                }
            } catch (Exception unused) {
            }
        } else {
            width = this.meishuAdInfo.getWidth();
            height = this.meishuAdInfo.getHeight();
        }
        this.ttAdNative.loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(getSdkAdInfo().getPid()).setExpressViewAcceptedSize(width, height).setSupportDeepLink(true).build(), new TTAdNative.FullScreenVideoAdListener() { // from class: com.meishu.sdk.platform.csj.interstitial.CSJInterstitialAdWrapper.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onError(int i3, String str) {
                try {
                    new CSJPlatformError(str, Integer.valueOf(i3), CSJInterstitialAdWrapper.this.getSdkAdInfo()).post(CSJInterstitialAdWrapper.this.getLoaderListener());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoAdLoad(final TTFullScreenVideoAd tTFullScreenVideoAd) {
                CSJInterstitialAdWrapper cSJInterstitialAdWrapper = CSJInterstitialAdWrapper.this;
                final CSJNewInterstitialAd cSJNewInterstitialAd = new CSJNewInterstitialAd(cSJInterstitialAdWrapper, (b) cSJInterstitialAdWrapper.loadListener, tTFullScreenVideoAd);
                tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.meishu.sdk.platform.csj.interstitial.CSJInterstitialAdWrapper.1.1
                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdClose() {
                        try {
                            if (CSJInterstitialAdWrapper.this.getLoaderListener() != null) {
                                CSJInterstitialAdWrapper.this.getLoaderListener().onAdClosed();
                            }
                            if (cSJNewInterstitialAd.getInteractionListener() != null) {
                                cSJNewInterstitialAd.getInteractionListener().onAdClosed();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdShow() {
                        MediationAdEcpmInfo showEcpm;
                        try {
                            try {
                                MediationFullScreenManager mediationManager = tTFullScreenVideoAd.getMediationManager();
                                if (mediationManager != null && (showEcpm = mediationManager.getShowEcpm()) != null) {
                                    CSJInterstitialAdWrapper.this.getSdkAdInfo().setGmShowEcpm(showEcpm.getEcpm());
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                            if (CSJInterstitialAdWrapper.this.getLoaderListener() != null) {
                                CSJInterstitialAdWrapper.this.getLoaderListener().onAdExposure();
                            }
                            if (cSJNewInterstitialAd.getInteractionListener() != null) {
                                cSJNewInterstitialAd.getInteractionListener().onAdExposure();
                            }
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdVideoBarClick() {
                        try {
                            cSJNewInterstitialAd.setClick();
                            if (CSJInterstitialAdWrapper.this.getSdkAdInfo() != null && !TextUtils.isEmpty(CSJInterstitialAdWrapper.this.getSdkAdInfo().getClk())) {
                                LogUtil.d(CSJInterstitialAdWrapper.TAG, "send onAdVideoBarClick");
                                z.a(CSJInterstitialAdWrapper.this.getContext(), f.a(CSJInterstitialAdWrapper.this.getSdkAdInfo().getClk(), cSJNewInterstitialAd), new i());
                            }
                            if (cSJNewInterstitialAd.getInteractionListener() != null) {
                                cSJNewInterstitialAd.getInteractionListener().onAdClicked();
                            }
                            CSJInterstitialAdWrapper.this.getSdkAdInfo().getMsLoadedTime();
                            CSJInterstitialAdWrapper.this.getAdLoader().getPosId();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onSkippedVideo() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onVideoComplete() {
                    }
                });
                SdkHandler.getInstance().runOnUiThread(new l() { // from class: com.meishu.sdk.platform.csj.interstitial.CSJInterstitialAdWrapper.1.2
                    @Override // com.meishu.sdk.core.safe.l
                    public void safeRun() {
                        try {
                            if (CSJInterstitialAdWrapper.this.getLoaderListener() != null) {
                                CSJInterstitialAdWrapper.this.getLoaderListener().onAdLoaded(cSJNewInterstitialAd);
                                CSJInterstitialAdWrapper.this.getLoaderListener().onAdReady(cSJNewInterstitialAd);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
            }
        });
    }

    private void loadOldInterstitial() {
        int width;
        int height;
        float fFloatValue;
        if (this.meishuAdInfo.getWidth() == 0 || this.meishuAdInfo.getHeight() == 0) {
            width = 1080;
            height = 1920;
        } else {
            width = this.meishuAdInfo.getWidth();
            height = this.meishuAdInfo.getHeight();
        }
        DisplayMetrics displayMetrics = StubApp.getOrigApplicationContext(this.context.getApplicationContext()).getResources().getDisplayMetrics();
        Float f = (Float) this.localParams.get("KEY_WIDTH");
        Float f2 = (Float) this.localParams.get("KEY_HEIGHT");
        float fFloatValue2 = 0.0f;
        if (f == null || f2 == null || f.floatValue() == 0.0f) {
            fFloatValue = ((displayMetrics.widthPixels / displayMetrics.density) * 3.0f) / 4.0f;
        } else {
            fFloatValue = f.floatValue();
            fFloatValue2 = f2.floatValue();
        }
        new AdSlot.Builder().setCodeId(getSdkAdInfo().getPid()).setSupportDeepLink(true).setImageAcceptedSize(width, height).setExpressViewAcceptedSize(fFloatValue, fFloatValue2).build();
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        super.destroy();
        TTNativeExpressAd tTNativeExpressAd = this.ttNativeExpressAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        try {
            z.a(((InterstitialAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
            if (!CSJAdConfig.isInitSuccess()) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            loadNewInterstitial();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTtNativeExpressAd(TTNativeExpressAd tTNativeExpressAd) {
        this.ttNativeExpressAd = tTNativeExpressAd;
    }
}
