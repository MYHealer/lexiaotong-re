package com.meishu.sdk.platform.ks.fullscreenvideo;

import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.meishu.sdk.core.ad.fullscreenvideo.FullScreenVideoAdLoader;
import com.meishu.sdk.core.ad.fullscreenvideo.c;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.ks.KSPlatformError;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KSFullScreenAdWrapper extends BasePlatformLoader<FullScreenVideoAdLoader, c> {
    private static final String TAG = "KSFullScreenAdWrapper";
    private KsFullScreenVideoAd videoAd;

    public KSFullScreenAdWrapper(FullScreenVideoAdLoader fullScreenVideoAdLoader, SdkAdInfo sdkAdInfo) {
        super(fullScreenVideoAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        try {
            z.a(((FullScreenVideoAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
            KsAdSDK.getLoadManager().loadFullScreenVideoAd(new KsScene.Builder(Long.parseLong(this.sdkAdInfo.getPid())).build(), new KsLoadManager.FullScreenVideoAdListener() { // from class: com.meishu.sdk.platform.ks.fullscreenvideo.KSFullScreenAdWrapper.1
                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public void onError(int i, String str) {
                    try {
                        LogUtil.e(KSFullScreenAdWrapper.TAG, "i=" + i + ",s=" + str);
                        new KSPlatformError(str, Integer.valueOf(i), KSFullScreenAdWrapper.this.sdkAdInfo).post(KSFullScreenAdWrapper.this.loadListener);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public void onFullScreenVideoAdLoad(List<KsFullScreenVideoAd> list) {
                    if (list != null) {
                        try {
                            if (list.size() > 0) {
                                KSFullScreenAdWrapper.this.videoAd = list.get(0);
                                KsFullScreenAd ksFullScreenAd = new KsFullScreenAd(KSFullScreenAdWrapper.this.videoAd, KSFullScreenAdWrapper.this);
                                KSFullScreenAdWrapper.this.videoAd.setFullScreenVideoAdInteractionListener(new KSFullScreenVideoAdInteractionListener(ksFullScreenAd));
                                if (KSFullScreenAdWrapper.this.loadListener != null) {
                                    try {
                                        KSFullScreenAdWrapper.this.sdkAdInfo.setEcpm(String.valueOf(KSFullScreenAdWrapper.this.videoAd.getECPM()));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    ((c) KSFullScreenAdWrapper.this.loadListener).onAdLoaded(ksFullScreenAd);
                                    ((c) KSFullScreenAdWrapper.this.loadListener).onAdReady(ksFullScreenAd);
                                }
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public void onFullScreenVideoResult(List<KsFullScreenVideoAd> list) {
                }

                public void onRequestResult(int i) {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            KsFullScreenVideoAd ksFullScreenVideoAd = this.videoAd;
            if (ksFullScreenVideoAd != null) {
                if (z) {
                    ksFullScreenVideoAd.setBidEcpm(ksFullScreenVideoAd.getECPM(), t0.a(this.videoAd.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice()));
                } else {
                    AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                    adExposureFailedReason.setAdnType(3);
                    adExposureFailedReason.setWinEcpm(i);
                    this.videoAd.reportAdExposureFailed(2, adExposureFailedReason);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
