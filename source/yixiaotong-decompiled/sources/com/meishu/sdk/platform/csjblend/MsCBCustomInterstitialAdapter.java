package com.meishu.sdk.platform.csjblend;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.interstitial.MediationCustomInterstitialLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.meishu.sdk.activity.a;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.interstitial.InterstitialAd;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdEventListener;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.meishu.sdk.core.utils.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsCBCustomInterstitialAdapter extends MediationCustomInterstitialLoader {
    private static final String TAG = "MsCBCCustomInterstitial";
    private InterstitialAd interstitialAd;
    private boolean calledLoadSuccess = false;
    private boolean calledExposure = false;

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.interstitial.MediationCustomInterstitialLoader
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        InterstitialAd interstitialAd = this.interstitialAd;
        return (interstitialAd == null || !interstitialAd.isAdValid()) ? MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED : MediationConstant.AdIsReadyStatus.AD_IS_READY;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
        LogUtil.d(TAG, a.a("开始加载gromore自定义平台插屏，pid=").append(mediationCustomServiceConfig.getADNNetworkSlotId()).toString());
        this.calledLoadSuccess = false;
        this.calledExposure = false;
        new InterstitialAdLoader((Activity) context, new MsAdSlot.Builder().setPid(mediationCustomServiceConfig.getADNNetworkSlotId()).setIsClickToClose(false).build(), new InterstitialAdEventListener() { // from class: com.meishu.sdk.platform.csjblend.MsCBCustomInterstitialAdapter.1
            @Override // com.meishu.sdk.core.ad.IAdEventListener
            public void onAdError(AdErrorInfo adErrorInfo) {
                MsCBCustomInterstitialAdapter.this.callLoadFail(-1, "loadAdError");
            }

            @Override // com.meishu.sdk.core.ad.IAdEventListener
            public void onAdReady(InterstitialAd interstitialAd) {
                double d;
                try {
                    MsCBCustomInterstitialAdapter.this.interstitialAd = interstitialAd;
                    if (interstitialAd != null) {
                        interstitialAd.setInteractionListener(new InteractionListener() { // from class: com.meishu.sdk.platform.csjblend.MsCBCustomInterstitialAdapter.1.1
                            @Override // com.meishu.sdk.core.loader.InteractionListener
                            public void onAdClicked() {
                                MsCBCustomInterstitialAdapter.this.callInterstitialAdClick();
                            }

                            @Override // com.meishu.sdk.core.loader.InteractionListener
                            public void onAdClosed() {
                                MsCBCustomInterstitialAdapter.this.callInterstitialClosed();
                                MsCBCustomInterstitialAdapter.this.interstitialAd = null;
                            }

                            @Override // com.meishu.sdk.core.loader.InteractionListener
                            public void onAdExposure() {
                                if (MsCBCustomInterstitialAdapter.this.calledExposure) {
                                    return;
                                }
                                MsCBCustomInterstitialAdapter.this.calledExposure = true;
                                MsCBCustomInterstitialAdapter.this.callInterstitialShow();
                            }
                        });
                        if (!MsCBCustomInterstitialAdapter.this.isClientBidding()) {
                            if (MsCBCustomInterstitialAdapter.this.calledLoadSuccess) {
                                return;
                            }
                            MsCBCustomInterstitialAdapter.this.calledLoadSuccess = true;
                            MsCBCustomInterstitialAdapter.this.callLoadSuccess();
                            return;
                        }
                        if (interstitialAd.getData() != null) {
                            try {
                                d = Double.parseDouble(interstitialAd.getData().getEcpm());
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                                d = 0.0d;
                            }
                        } else {
                            d = 0.0d;
                        }
                        if (MsCBCustomInterstitialAdapter.this.calledLoadSuccess) {
                            return;
                        }
                        MsCBCustomInterstitialAdapter.this.calledLoadSuccess = true;
                        MsCBCustomInterstitialAdapter.this.callLoadSuccess(d);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }).loadAd();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.interstitial.MediationCustomInterstitialLoader
    public void showAd(Activity activity) {
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            interstitialAd.showAd(activity);
        }
    }
}
