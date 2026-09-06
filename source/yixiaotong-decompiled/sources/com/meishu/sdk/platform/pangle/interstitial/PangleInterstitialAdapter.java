package com.meishu.sdk.platform.pangle.interstitial;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialRequest;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.platform.custom.interstitial.MsCustomInterstitialAdapter;
import com.meishu.sdk.platform.pangle.PangleInitManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class PangleInterstitialAdapter extends MsCustomInterstitialAdapter {
    private PangleInterstitialAd pangleInterstitialAd;

    public PangleInterstitialAdapter(InterstitialAdLoader interstitialAdLoader, SdkAdInfo sdkAdInfo) {
        super(interstitialAdLoader, sdkAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAdWithCallback(String str) {
        PAGInterstitialAd.loadAd(str, new PAGInterstitialRequest(), new PAGInterstitialAdLoadListener() { // from class: com.meishu.sdk.platform.pangle.interstitial.PangleInterstitialAdapter.2
            public void onError(int i, String str2) {
                PangleInterstitialAdapter.this.onError(i, str2);
            }

            public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
                PangleInterstitialAdapter pangleInterstitialAdapter = PangleInterstitialAdapter.this;
                pangleInterstitialAdapter.pangleInterstitialAd = new PangleInterstitialAd(pangleInterstitialAdapter, pAGInterstitialAd);
                pAGInterstitialAd.setAdInteractionListener(new PAGInterstitialAdInteractionListener() { // from class: com.meishu.sdk.platform.pangle.interstitial.PangleInterstitialAdapter.2.1
                    public void onAdClicked() {
                        if (PangleInterstitialAdapter.this.pangleInterstitialAd != null) {
                            PangleInterstitialAdapter pangleInterstitialAdapter2 = PangleInterstitialAdapter.this;
                            pangleInterstitialAdapter2.onAdClick(pangleInterstitialAdapter2.pangleInterstitialAd);
                        }
                    }

                    public void onAdDismissed() {
                        if (PangleInterstitialAdapter.this.pangleInterstitialAd != null) {
                            PangleInterstitialAdapter pangleInterstitialAdapter2 = PangleInterstitialAdapter.this;
                            pangleInterstitialAdapter2.onAdClosed(pangleInterstitialAdapter2.pangleInterstitialAd);
                        }
                    }

                    public void onAdShowed() {
                        if (PangleInterstitialAdapter.this.pangleInterstitialAd != null) {
                            PangleInterstitialAdapter pangleInterstitialAdapter2 = PangleInterstitialAdapter.this;
                            pangleInterstitialAdapter2.onAdExposure(pangleInterstitialAdapter2.pangleInterstitialAd);
                        }
                    }
                });
                PangleInterstitialAdapter pangleInterstitialAdapter2 = PangleInterstitialAdapter.this;
                pangleInterstitialAdapter2.onRenderSuccess(pangleInterstitialAdapter2.pangleInterstitialAd);
            }
        });
    }

    @Override // com.meishu.sdk.platform.custom.interstitial.MsCustomInterstitialAdapter
    public void loadCustomAd(String str, String str2, final String str3, String str4) {
        PangleInitManager.getInstance().initSdk(this.context, str, new PangleInitManager.InitCallback() { // from class: com.meishu.sdk.platform.pangle.interstitial.PangleInterstitialAdapter.1
            @Override // com.meishu.sdk.platform.pangle.PangleInitManager.InitCallback
            public void onError(int i, String str5) {
            }

            @Override // com.meishu.sdk.platform.pangle.PangleInitManager.InitCallback
            public void onSuccess() {
                PangleInterstitialAdapter.this.loadAdWithCallback(str3);
            }
        });
    }
}
