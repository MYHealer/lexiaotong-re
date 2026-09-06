package com.meishu.sdk.platform.gdt.fullscreenvideo;

import android.app.Activity;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.meishu.sdk.core.ad.fullscreenvideo.FullScreenVideoAdLoader;
import com.meishu.sdk.core.ad.fullscreenvideo.c;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.serverbidding.S2sbResultBean;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.gdt.GDTPlatformError;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTFullScreenVideoAdWrapper extends BasePlatformLoader<FullScreenVideoAdLoader, c> {
    private static final String TAG = "GDTFullScreenVideoAdWrapper";
    private GDTFullScreenVideoAd gdtFullScreenVideoAd;
    private UnifiedInterstitialADListener listener;
    private UnifiedInterstitialAD unifiedInterstitialAD;

    public GDTFullScreenVideoAdWrapper(FullScreenVideoAdLoader fullScreenVideoAdLoader, SdkAdInfo sdkAdInfo) {
        super(fullScreenVideoAdLoader, sdkAdInfo);
        this.listener = new UnifiedInterstitialADListener() { // from class: com.meishu.sdk.platform.gdt.fullscreenvideo.GDTFullScreenVideoAdWrapper.2
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClicked() {
                try {
                    if (GDTFullScreenVideoAdWrapper.this.getSdkAdInfo() != null && !TextUtils.isEmpty(GDTFullScreenVideoAdWrapper.this.getSdkAdInfo().getClk())) {
                        LogUtil.d(GDTFullScreenVideoAdWrapper.TAG, "send onADClicked");
                        z.a(GDTFullScreenVideoAdWrapper.this.getContext(), f.a(GDTFullScreenVideoAdWrapper.this.getSdkAdInfo().getClk(), GDTFullScreenVideoAdWrapper.this.gdtFullScreenVideoAd), new i());
                        GDTFullScreenVideoAdWrapper.this.getSdkAdInfo().getMsLoadedTime();
                        GDTFullScreenVideoAdWrapper.this.getAdLoader().getPosId();
                    }
                    if (GDTFullScreenVideoAdWrapper.this.gdtFullScreenVideoAd.getInteractionListener() != null) {
                        GDTFullScreenVideoAdWrapper.this.gdtFullScreenVideoAd.getInteractionListener().onAdClicked();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClosed() {
                try {
                    if (GDTFullScreenVideoAdWrapper.this.getLoaderListener() != null) {
                        GDTFullScreenVideoAdWrapper.this.getLoaderListener().onAdClosed();
                    }
                    if (GDTFullScreenVideoAdWrapper.this.gdtFullScreenVideoAd.getInteractionListener() != null) {
                        GDTFullScreenVideoAdWrapper.this.gdtFullScreenVideoAd.getInteractionListener().onAdClosed();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADExposure() {
                try {
                    if (GDTFullScreenVideoAdWrapper.this.getLoaderListener() != null) {
                        GDTFullScreenVideoAdWrapper.this.getLoaderListener().onAdExposure();
                    }
                    if (GDTFullScreenVideoAdWrapper.this.gdtFullScreenVideoAd.getInteractionListener() != null) {
                        GDTFullScreenVideoAdWrapper.this.gdtFullScreenVideoAd.getInteractionListener().onAdExposure();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADLeftApplication() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADOpened() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADReceive() {
                try {
                    if (GDTFullScreenVideoAdWrapper.this.getLoaderListener() != null) {
                        GDTFullScreenVideoAdWrapper.this.sdkAdInfo.setEcpm(String.valueOf(GDTFullScreenVideoAdWrapper.this.unifiedInterstitialAD.getECPM()));
                        GDTFullScreenVideoAdWrapper.this.getLoaderListener().onAdLoaded(GDTFullScreenVideoAdWrapper.this.gdtFullScreenVideoAd);
                        GDTFullScreenVideoAdWrapper.this.getLoaderListener().onAdReady(GDTFullScreenVideoAdWrapper.this.gdtFullScreenVideoAd);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onNoAD(AdError adError) {
                try {
                    LogUtil.e(GDTFullScreenVideoAdWrapper.TAG, "onNoAD " + adError.getErrorMsg() + PPSLabelView.Code + adError.getErrorCode());
                    new GDTPlatformError(adError, GDTFullScreenVideoAdWrapper.this.getSdkAdInfo()).post(GDTFullScreenVideoAdWrapper.this.getLoaderListener());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderFail() {
                try {
                    if (GDTFullScreenVideoAdWrapper.this.getLoaderListener() != null) {
                        GDTFullScreenVideoAdWrapper.this.getLoaderListener().onAdRenderFail("GDTRenderFail", -1);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderSuccess() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onVideoCached() {
            }
        };
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        try {
            z.a(getAdLoader().getContext(), h0.a(getSdkAdInfo().getReq()), new i());
            this.gdtFullScreenVideoAd = new GDTFullScreenVideoAd(this);
            if (!TextUtils.isEmpty(this.sdkAdInfo.getS2sb())) {
                try {
                    this.unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) getContext(), getSdkAdInfo().getPid(), this.listener, null, ((S2sbResultBean) new Gson().fromJson(this.sdkAdInfo.getS2sb(), S2sbResultBean.class)).getToken());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.unifiedInterstitialAD == null) {
                this.unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) getContext(), getSdkAdInfo().getPid(), this.listener);
            }
            this.gdtFullScreenVideoAd.setUnifiedInterstitialAD(this.unifiedInterstitialAD);
            this.unifiedInterstitialAD.setMediaListener(new UnifiedInterstitialMediaListener() { // from class: com.meishu.sdk.platform.gdt.fullscreenvideo.GDTFullScreenVideoAdWrapper.1
                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoComplete() {
                    if (GDTFullScreenVideoAdWrapper.this.gdtFullScreenVideoAd.getMediaListener() != null) {
                        GDTFullScreenVideoAdWrapper.this.gdtFullScreenVideoAd.getMediaListener().onVideoCompleted();
                    }
                }

                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoError(AdError adError) {
                    try {
                        if (GDTFullScreenVideoAdWrapper.this.getLoaderListener() != null) {
                            GDTFullScreenVideoAdWrapper.this.getLoaderListener().onAdRenderFail(adError.getErrorMsg(), adError.getErrorCode());
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoInit() {
                }

                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoLoading() {
                }

                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoPageClose() {
                }

                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoPageOpen() {
                }

                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoPause() {
                }

                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoReady(long j) {
                }

                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoStart() {
                }
            });
            this.unifiedInterstitialAD.setMaxVideoDuration(500);
            this.unifiedInterstitialAD.setMinVideoDuration(5);
            this.unifiedInterstitialAD.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(((FullScreenVideoAdLoader) this.adLoader).getVideoIsMute()).build());
            this.unifiedInterstitialAD.loadFullScreenAD();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.unifiedInterstitialAD != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put("expectCostPrice", Integer.valueOf(this.unifiedInterstitialAD.getECPM()));
                    map.put("highestLossPrice", Integer.valueOf(t0.a(this.unifiedInterstitialAD.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    this.unifiedInterstitialAD.sendWinNotification(map);
                } else {
                    HashMap map2 = new HashMap();
                    map2.put("winPrice", Integer.valueOf(i));
                    map2.put("lossReason", 1);
                    map2.put("adnId", "2");
                    this.unifiedInterstitialAD.sendLossNotification(map2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
