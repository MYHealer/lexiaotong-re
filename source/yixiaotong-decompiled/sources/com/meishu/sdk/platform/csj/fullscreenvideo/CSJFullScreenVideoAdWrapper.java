package com.meishu.sdk.platform.csj.fullscreenvideo;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager;
import com.meishu.sdk.core.ad.fullscreenvideo.FullScreenVideoAdLoader;
import com.meishu.sdk.core.ad.fullscreenvideo.c;
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
public class CSJFullScreenVideoAdWrapper extends BasePlatformLoader<FullScreenVideoAdLoader, c> {
    private static final String TAG = "OPPOInterstitialAdLoader";
    private final Context activity;
    private TTAdNative adNative;
    private MeishuAdInfo meishuAdInfo;

    public CSJFullScreenVideoAdWrapper(FullScreenVideoAdLoader fullScreenVideoAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        super(fullScreenVideoAdLoader, sdkAdInfo);
        this.activity = fullScreenVideoAdLoader.getContext();
        this.meishuAdInfo = meishuAdInfo;
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        if (this.adNative != null) {
            this.adNative = null;
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        int width;
        int height;
        int i;
        try {
            z.a(StubApp.getOrigApplicationContext(getAdLoader().getContext().getApplicationContext()), h0.a(getSdkAdInfo().getReq()), new i());
            if (this.meishuAdInfo.getWidth() == 0 || this.meishuAdInfo.getHeight() == 0 || this.meishuAdInfo.getWidth() <= 0 || this.meishuAdInfo.getHeight() <= 0) {
                try {
                    DisplayMetrics displayMetrics = ((FullScreenVideoAdLoader) this.adLoader).getContext().getResources().getDisplayMetrics();
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
            final CSJFullScreenVideoAd cSJFullScreenVideoAd = new CSJFullScreenVideoAd(this);
            this.adNative = CSJAdConfig.getTtAdManager().createAdNative(getAdLoader().getContext());
            this.adNative.loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(getSdkAdInfo().getPid()).setExpressViewAcceptedSize(width, height).setSupportDeepLink(true).build(), new TTAdNative.FullScreenVideoAdListener() { // from class: com.meishu.sdk.platform.csj.fullscreenvideo.CSJFullScreenVideoAdWrapper.1
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
                public void onError(int i3, String str) {
                    try {
                        new CSJPlatformError(str, Integer.valueOf(i3), CSJFullScreenVideoAdWrapper.this.getSdkAdInfo()).post(CSJFullScreenVideoAdWrapper.this.getLoaderListener());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
                public void onFullScreenVideoAdLoad(final TTFullScreenVideoAd tTFullScreenVideoAd) {
                    if (tTFullScreenVideoAd == null) {
                        return;
                    }
                    tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.meishu.sdk.platform.csj.fullscreenvideo.CSJFullScreenVideoAdWrapper.1.1
                        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onAdClose() {
                            try {
                                if (CSJFullScreenVideoAdWrapper.this.getLoaderListener() != null) {
                                    CSJFullScreenVideoAdWrapper.this.getLoaderListener().onAdClosed();
                                }
                                if (cSJFullScreenVideoAd.getInteractionListener() != null) {
                                    cSJFullScreenVideoAd.getInteractionListener().onAdClosed();
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
                                        CSJFullScreenVideoAdWrapper.this.getSdkAdInfo().setGmShowEcpm(showEcpm.getEcpm());
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                if (CSJFullScreenVideoAdWrapper.this.getLoaderListener() != null) {
                                    CSJFullScreenVideoAdWrapper.this.getLoaderListener().onAdExposure();
                                }
                                if (cSJFullScreenVideoAd.getInteractionListener() != null) {
                                    cSJFullScreenVideoAd.getInteractionListener().onAdExposure();
                                }
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onAdVideoBarClick() {
                            try {
                                if (CSJFullScreenVideoAdWrapper.this.getSdkAdInfo() != null && !TextUtils.isEmpty(CSJFullScreenVideoAdWrapper.this.getSdkAdInfo().getClk())) {
                                    LogUtil.d(CSJFullScreenVideoAdWrapper.TAG, "send onAdVideoBarClick");
                                    z.a(CSJFullScreenVideoAdWrapper.this.getContext(), f.a(CSJFullScreenVideoAdWrapper.this.getSdkAdInfo().getClk(), cSJFullScreenVideoAd), new i());
                                }
                                if (cSJFullScreenVideoAd.getInteractionListener() != null) {
                                    cSJFullScreenVideoAd.getInteractionListener().onAdClicked();
                                }
                                CSJFullScreenVideoAdWrapper.this.getSdkAdInfo().getMsLoadedTime();
                                CSJFullScreenVideoAdWrapper.this.getAdLoader().getPosId();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onSkippedVideo() {
                            try {
                                if (cSJFullScreenVideoAd.getMediaListener() != null) {
                                    cSJFullScreenVideoAd.getMediaListener().onSkippedVideo();
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onVideoComplete() {
                            try {
                                if (cSJFullScreenVideoAd.getMediaListener() != null) {
                                    cSJFullScreenVideoAd.getMediaListener().onVideoCompleted();
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                    try {
                        cSJFullScreenVideoAd.setTTFullScreenVideoAd(tTFullScreenVideoAd);
                        SdkHandler.getInstance().runOnUiThread(new l() { // from class: com.meishu.sdk.platform.csj.fullscreenvideo.CSJFullScreenVideoAdWrapper.1.2
                            @Override // com.meishu.sdk.core.safe.l
                            public void safeRun() {
                                if (CSJFullScreenVideoAdWrapper.this.getLoaderListener() != null) {
                                    CSJFullScreenVideoAdWrapper.this.getLoaderListener().onAdLoaded(cSJFullScreenVideoAd);
                                    CSJFullScreenVideoAdWrapper.this.getLoaderListener().onAdReady(cSJFullScreenVideoAd);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
                public void onFullScreenVideoCached() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
                public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
