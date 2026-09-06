package com.meishu.sdk.platform.ks.interstitial;

import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.ad.interstitial.b;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.ks.KSPlatformError;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KSIntersititialAdWrapper extends BasePlatformLoader<InterstitialAdLoader, b> {
    private static final String TAG = "KSIntersititialAdWrappe";
    private KsInterstitialAd mKsInterstitialAd;

    public KSIntersititialAdWrapper(InterstitialAdLoader interstitialAdLoader, SdkAdInfo sdkAdInfo) {
        super(interstitialAdLoader, sdkAdInfo);
    }

    private void loadExpress() {
        KsAdSDK.getLoadManager().loadInterstitialAd(new KsScene.Builder(Long.parseLong(this.sdkAdInfo.getPid())).build(), new KsLoadManager.InterstitialAdListener() { // from class: com.meishu.sdk.platform.ks.interstitial.KSIntersititialAdWrapper.1
            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            public void onError(int i, String str) {
                try {
                    new KSPlatformError(str, Integer.valueOf(i), KSIntersititialAdWrapper.this.sdkAdInfo).post(KSIntersititialAdWrapper.this.loadListener);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            public void onInterstitialAdLoad(List<KsInterstitialAd> list) {
                if (list != null) {
                    try {
                        if (list.size() > 0) {
                            KSIntersititialAdWrapper.this.mKsInterstitialAd = list.get(0);
                            KsIntersititialAd ksIntersititialAd = new KsIntersititialAd(KSIntersititialAdWrapper.this.mKsInterstitialAd, KSIntersititialAdWrapper.this);
                            KSIntersititialAdWrapper.this.mKsInterstitialAd.setAdInteractionListener(new KsIntersititialListener(ksIntersititialAd));
                            if (KSIntersititialAdWrapper.this.loadListener != null) {
                                try {
                                    KSIntersititialAdWrapper.this.sdkAdInfo.setEcpm(String.valueOf(KSIntersititialAdWrapper.this.mKsInterstitialAd.getECPM()));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                ((b) KSIntersititialAdWrapper.this.loadListener).onAdLoaded(ksIntersititialAd);
                                ((b) KSIntersititialAdWrapper.this.loadListener).onAdReady(ksIntersititialAd);
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            public void onRequestResult(int i) {
            }
        });
    }

    private void loadNative() {
        try {
            KsAdSDK.getLoadManager().loadNativeAd(new KsScene.Builder(Long.parseLong(this.sdkAdInfo.getPid())).adNum(1).build(), new KsLoadManager.NativeAdListener() { // from class: com.meishu.sdk.platform.ks.interstitial.KSIntersititialAdWrapper.2
                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public void onError(int i, String str) {
                    try {
                        LogUtil.e(KSIntersititialAdWrapper.TAG, str + "" + i);
                        new KSPlatformError(str, Integer.valueOf(i), KSIntersititialAdWrapper.this.sdkAdInfo).post(KSIntersititialAdWrapper.this.loadListener);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public void onNativeAdLoad(List<KsNativeAd> list) {
                    if (list != null) {
                        try {
                            if (list.size() != 0) {
                                if (KSIntersititialAdWrapper.this.getLoaderListener() != null) {
                                    Iterator<KsNativeAd> it = list.iterator();
                                    while (it.hasNext()) {
                                        KSIntersititialAdWrapper.this.sdkAdInfo.setEcpm(String.valueOf(it.next().getECPM()));
                                    }
                                    KsNativeIntersititialAd ksNativeIntersititialAd = new KsNativeIntersititialAd(KSIntersititialAdWrapper.this, list.get(0));
                                    KSIntersititialAdWrapper.this.getLoaderListener().onAdLoaded(ksNativeIntersititialAd);
                                    KSIntersititialAdWrapper.this.getLoaderListener().onAdReady(ksNativeIntersititialAd);
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    }
                    LogUtil.e(KSIntersititialAdWrapper.TAG, "onNativeAdLoad ksNativeAdList is null");
                    if (KSIntersititialAdWrapper.this.getLoaderListener() != null) {
                        KSIntersititialAdWrapper.this.getLoaderListener().onAdError();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        try {
            z.a(((InterstitialAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
            if (this.sdkAdInfo.getDrawing() == 1) {
                loadNative();
            } else {
                loadExpress();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            KsInterstitialAd ksInterstitialAd = this.mKsInterstitialAd;
            if (ksInterstitialAd != null) {
                if (z) {
                    ksInterstitialAd.setBidEcpm(ksInterstitialAd.getECPM(), t0.a(this.mKsInterstitialAd.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice()));
                } else {
                    AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                    adExposureFailedReason.setAdnType(3);
                    adExposureFailedReason.setWinEcpm(i);
                    this.mKsInterstitialAd.reportAdExposureFailed(2, adExposureFailedReason);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
