package com.meishu.sdk.platform.ks.draw;

import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.meishu.sdk.core.ad.draw.DrawAdLoader;
import com.meishu.sdk.core.ad.draw.a;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.ks.KSPlatformError;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KSDrawAdWrapper extends BasePlatformLoader<DrawAdLoader, a> {
    private KsDrawAd drawAd;

    public KSDrawAdWrapper(DrawAdLoader drawAdLoader, SdkAdInfo sdkAdInfo) {
        super(drawAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        try {
            z.a(StubApp.getOrigApplicationContext(((DrawAdLoader) this.adLoader).getContext().getApplicationContext()), h0.a(getSdkAdInfo().getReq()), new i());
            KsScene ksSceneBuild = new KsScene.Builder(Long.parseLong(this.sdkAdInfo.getPid())).build();
            final KSDrawAd kSDrawAd = new KSDrawAd(this);
            KsAdSDK.getLoadManager().loadDrawAd(ksSceneBuild, new KsLoadManager.DrawAdListener() { // from class: com.meishu.sdk.platform.ks.draw.KSDrawAdWrapper.1
                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public void onDrawAdLoad(List<KsDrawAd> list) {
                    if (list != null) {
                        try {
                            if (list.isEmpty()) {
                                return;
                            }
                            KSDrawAdWrapper.this.drawAd = list.get(0);
                            kSDrawAd.setAdView(KSDrawAdWrapper.this.drawAd.getDrawView(KSDrawAdWrapper.this.getContext()));
                            KSDrawAdWrapper.this.drawAd.setAdInteractionListener(new KSDrawListenerImpl(KSDrawAdWrapper.this, kSDrawAd));
                            if (KSDrawAdWrapper.this.getLoaderListener() != null) {
                                KSDrawAdWrapper.this.getLoaderListener().onAdLoaded(kSDrawAd);
                                KSDrawAdWrapper.this.getLoaderListener().onAdReady(kSDrawAd);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public void onError(int i, String str) {
                    try {
                        new KSPlatformError(str, Integer.valueOf(i), KSDrawAdWrapper.this.getSdkAdInfo()).post(KSDrawAdWrapper.this.getLoaderListener());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            KsDrawAd ksDrawAd = this.drawAd;
            if (ksDrawAd != null) {
                if (z) {
                    ksDrawAd.setBidEcpm(ksDrawAd.getECPM(), t0.a(this.drawAd.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice()));
                } else {
                    AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                    adExposureFailedReason.setAdnType(3);
                    adExposureFailedReason.setWinEcpm(i);
                    this.drawAd.reportAdExposureFailed(2, adExposureFailedReason);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
