package com.meishu.sdk.platform.pangle.banner;

import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerRequest;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.meishu.sdk.core.ad.banner.BannerAdLoader;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.platform.custom.banner.MsCustomBannerAdapter;
import com.meishu.sdk.platform.pangle.PangleInitManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class PangleBannerAdapter extends MsCustomBannerAdapter {
    private Map<String, Object> extMap;
    private PangleBannerAd pangleBannerAd;

    public PangleBannerAdapter(BannerAdLoader bannerAdLoader, SdkAdInfo sdkAdInfo) {
        super(bannerAdLoader, sdkAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAdWithCallback(String str) {
        String str2;
        PAGBannerSize pAGBannerSize = PAGBannerSize.BANNER_W_320_H_50;
        Map<String, Object> map = this.extMap;
        if (map != null && map.containsKey("banner_wh") && (str2 = (String) this.extMap.get("banner_wh")) != null) {
            if ("300_250".equals(str2)) {
                pAGBannerSize = PAGBannerSize.BANNER_W_300_H_250;
            } else if ("728_90".equals(str2)) {
                pAGBannerSize = PAGBannerSize.BANNER_W_728_H_90;
            }
        }
        PAGBannerAd.loadAd(str, new PAGBannerRequest(pAGBannerSize), new PAGBannerAdLoadListener() { // from class: com.meishu.sdk.platform.pangle.banner.PangleBannerAdapter.3
            public void onError(int i, String str3) {
                onError(i, str3);
            }

            public void onAdLoaded(PAGBannerAd pAGBannerAd) {
                PangleBannerAdapter pangleBannerAdapter = PangleBannerAdapter.this;
                pangleBannerAdapter.pangleBannerAd = new PangleBannerAd(pangleBannerAdapter, pAGBannerAd);
                if (pAGBannerAd != null) {
                    pAGBannerAd.setAdInteractionListener(new PAGBannerAdInteractionListener() { // from class: com.meishu.sdk.platform.pangle.banner.PangleBannerAdapter.3.1
                        public void onAdClicked() {
                            PangleBannerAdapter pangleBannerAdapter2 = PangleBannerAdapter.this;
                            pangleBannerAdapter2.onAdClick(pangleBannerAdapter2.pangleBannerAd);
                        }

                        public void onAdDismissed() {
                        }

                        public void onAdShowed() {
                            if (PangleBannerAdapter.this.pangleBannerAd != null) {
                                PangleBannerAdapter pangleBannerAdapter2 = PangleBannerAdapter.this;
                                pangleBannerAdapter2.onAdExposure(pangleBannerAdapter2.pangleBannerAd);
                            }
                        }
                    });
                }
                if (pAGBannerAd == null || PangleBannerAdapter.this.pangleBannerAd == null) {
                    return;
                }
                PangleBannerAdapter.this.onRenderSuccess(pAGBannerAd.getBannerView(), PangleBannerAdapter.this.pangleBannerAd);
            }
        });
    }

    @Override // com.meishu.sdk.platform.custom.banner.MsCustomBannerAdapter
    public void destory() {
    }

    @Override // com.meishu.sdk.platform.custom.banner.MsCustomBannerAdapter
    public void loadCustomAd(String str, String str2, final String str3, String str4) {
        try {
            this.extMap = (Map) new Gson().fromJson(str4, new TypeToken<HashMap<String, Object>>() { // from class: com.meishu.sdk.platform.pangle.banner.PangleBannerAdapter.1
            }.getType());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        PangleInitManager.getInstance().initSdk(this.context, str, new PangleInitManager.InitCallback() { // from class: com.meishu.sdk.platform.pangle.banner.PangleBannerAdapter.2
            @Override // com.meishu.sdk.platform.pangle.PangleInitManager.InitCallback
            public void onError(int i, String str5) {
            }

            @Override // com.meishu.sdk.platform.pangle.PangleInitManager.InitCallback
            public void onSuccess() {
                PangleBannerAdapter.this.loadAdWithCallback(str3);
            }
        });
    }
}
