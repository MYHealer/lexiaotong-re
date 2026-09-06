package com.meishu.sdk.platform.pangle.splash;

import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenRequest;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.platform.custom.splash.MsCustomSplashAdapter;
import com.meishu.sdk.platform.pangle.PangleInitManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class PangleSplashAdapter extends MsCustomSplashAdapter {
    private PangleSplashAd pangleSplashAd;

    public PangleSplashAdapter(SplashAdLoader splashAdLoader, SdkAdInfo sdkAdInfo) {
        super(splashAdLoader, sdkAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAdWithCallback(String str) {
        PAGAppOpenRequest pAGAppOpenRequest = new PAGAppOpenRequest();
        pAGAppOpenRequest.setTimeout(5000);
        PAGAppOpenAd.loadAd(str, pAGAppOpenRequest, new PAGAppOpenAdLoadListener() { // from class: com.meishu.sdk.platform.pangle.splash.PangleSplashAdapter.2
            public void onError(int i, String str2) {
                PangleSplashAdapter.this.onError(i, str2);
            }

            public void onAdLoaded(PAGAppOpenAd pAGAppOpenAd) {
                if (pAGAppOpenAd != null) {
                    PangleSplashAdapter pangleSplashAdapter = PangleSplashAdapter.this;
                    pangleSplashAdapter.pangleSplashAd = new PangleSplashAd(pangleSplashAdapter, pAGAppOpenAd);
                    pAGAppOpenAd.setAdInteractionCallback(new PAGAppOpenAdInteractionCallback() { // from class: com.meishu.sdk.platform.pangle.splash.PangleSplashAdapter.2.1
                        public void onAdClicked() {
                            if (PangleSplashAdapter.this.pangleSplashAd != null) {
                                PangleSplashAdapter pangleSplashAdapter2 = PangleSplashAdapter.this;
                                pangleSplashAdapter2.onAdClick(pangleSplashAdapter2.pangleSplashAd);
                            }
                        }

                        public void onAdDismissed() {
                            if (PangleSplashAdapter.this.pangleSplashAd != null) {
                                PangleSplashAdapter pangleSplashAdapter2 = PangleSplashAdapter.this;
                                pangleSplashAdapter2.onAdSkip(pangleSplashAdapter2.pangleSplashAd);
                            }
                        }

                        public void onAdShowFailed(PAGErrorModel pAGErrorModel) {
                            if (PangleSplashAdapter.this.pangleSplashAd != null) {
                                PangleSplashAdapter.this.onRenderFail(pAGErrorModel.getErrorCode(), pAGErrorModel.getErrorMessage());
                            }
                        }

                        public void onAdShowed() {
                            if (PangleSplashAdapter.this.pangleSplashAd != null) {
                                PangleSplashAdapter pangleSplashAdapter2 = PangleSplashAdapter.this;
                                pangleSplashAdapter2.onAdExposure(pangleSplashAdapter2.pangleSplashAd);
                            }
                        }
                    });
                    PangleSplashAdapter pangleSplashAdapter2 = PangleSplashAdapter.this;
                    pangleSplashAdapter2.onRenderSuccess(null, pangleSplashAdapter2.pangleSplashAd);
                }
            }
        });
    }

    @Override // com.meishu.sdk.platform.custom.splash.MsCustomSplashAdapter
    public void loadCustomAd(String str, String str2, final String str3, String str4) {
        PangleInitManager.getInstance().initSdk(this.context, str, new PangleInitManager.InitCallback() { // from class: com.meishu.sdk.platform.pangle.splash.PangleSplashAdapter.1
            @Override // com.meishu.sdk.platform.pangle.PangleInitManager.InitCallback
            public void onError(int i, String str5) {
            }

            @Override // com.meishu.sdk.platform.pangle.PangleInitManager.InitCallback
            public void onSuccess() {
                PangleSplashAdapter.this.loadAdWithCallback(str3);
            }
        });
    }
}
