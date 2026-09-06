package com.meishu.sdk.platform.ks.reward;

import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.meishu.sdk.core.ad.reward.RewardAdMediaListener;
import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.ad.reward.a;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.ks.KSPlatformError;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KSRewardVideoAdWrapper extends BasePlatformLoader<RewardVideoLoader, a> {
    private RewardAdMediaListener apiRewardAdMediaListener;
    private KsRewardVideoAd mRewardVideoAd;

    public KSRewardVideoAdWrapper(RewardVideoLoader rewardVideoLoader, SdkAdInfo sdkAdInfo) {
        super(rewardVideoLoader, sdkAdInfo);
    }

    public RewardAdMediaListener getApiRewardAdMediaListener() {
        return this.apiRewardAdMediaListener;
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        try {
            z.a(((RewardVideoLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
            KsAdSDK.getLoadManager().loadRewardVideoAd(new KsScene.Builder(Long.parseLong(this.sdkAdInfo.getPid())).build(), new KsLoadManager.RewardVideoAdListener() { // from class: com.meishu.sdk.platform.ks.reward.KSRewardVideoAdWrapper.1
                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public void onError(int i, String str) {
                    new KSPlatformError(str, Integer.valueOf(i), KSRewardVideoAdWrapper.this.sdkAdInfo).post(KSRewardVideoAdWrapper.this.loadListener);
                }

                public void onRequestResult(int i) {
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public void onRewardVideoAdLoad(List<KsRewardVideoAd> list) {
                    if (list != null) {
                        try {
                            if (list.size() > 0) {
                                KSRewardVideoAdWrapper.this.mRewardVideoAd = list.get(0);
                                KSRewardAd kSRewardAd = new KSRewardAd(KSRewardVideoAdWrapper.this.mRewardVideoAd, KSRewardVideoAdWrapper.this);
                                KSRewardVideoAdWrapper.this.mRewardVideoAd.setRewardAdInteractionListener(new KSInteractionListener(kSRewardAd));
                                if (KSRewardVideoAdWrapper.this.loadListener != null) {
                                    try {
                                        KSRewardVideoAdWrapper.this.sdkAdInfo.setEcpm(String.valueOf(KSRewardVideoAdWrapper.this.mRewardVideoAd.getECPM()));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    ((a) KSRewardVideoAdWrapper.this.loadListener).onAdLoaded(kSRewardAd);
                                    ((a) KSRewardVideoAdWrapper.this.loadListener).onAdReady(kSRewardAd);
                                }
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public void onRewardVideoResult(List<KsRewardVideoAd> list) {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setApiRewardAdMediaListener(RewardAdMediaListener rewardAdMediaListener) {
        this.apiRewardAdMediaListener = rewardAdMediaListener;
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            KsRewardVideoAd ksRewardVideoAd = this.mRewardVideoAd;
            if (ksRewardVideoAd != null) {
                if (z) {
                    ksRewardVideoAd.setBidEcpm(ksRewardVideoAd.getECPM(), t0.a(this.mRewardVideoAd.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice()));
                } else {
                    AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                    adExposureFailedReason.setAdnType(3);
                    adExposureFailedReason.setWinEcpm(i);
                    this.mRewardVideoAd.reportAdExposureFailed(2, adExposureFailedReason);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
