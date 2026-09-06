package com.meishu.sdk.platform.csj.banner;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.csj.CSJPlatformError;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJBannerListenerImpl implements TTAdNative.NativeExpressAdListener {
    private static final String TAG = "CSJBannerListenerImpl";
    private CSJBannerAdWrapper adNativeWrapper;

    public CSJBannerListenerImpl(CSJBannerAdWrapper cSJBannerAdWrapper) {
        this.adNativeWrapper = cSJBannerAdWrapper;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onError(int i, String str) {
        try {
            LogUtil.e(TAG, "onError, code: " + i + ", msg: " + str);
            new CSJPlatformError(str, Integer.valueOf(i), this.adNativeWrapper.getSdkAdInfo()).post(this.adNativeWrapper.getLoaderListener());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                final TTNativeExpressAd tTNativeExpressAd = list.get(0);
                this.adNativeWrapper.setTtNativeExpressAd(tTNativeExpressAd);
                final CSJBannerAd cSJBannerAd = new CSJBannerAd(this.adNativeWrapper.getSdkAdInfo(), this.adNativeWrapper.getLoaderListener(), this.adNativeWrapper, tTNativeExpressAd);
                tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.meishu.sdk.platform.csj.banner.CSJBannerListenerImpl.1
                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdClicked(View view, int i) {
                        try {
                            if (CSJBannerListenerImpl.this.adNativeWrapper != null && !TextUtils.isEmpty(CSJBannerListenerImpl.this.adNativeWrapper.getSdkAdInfo().getClk())) {
                                LogUtil.d(CSJBannerListenerImpl.TAG, "send onAdClicked");
                                z.a(CSJBannerListenerImpl.this.adNativeWrapper.getContext(), f.a(CSJBannerListenerImpl.this.adNativeWrapper.getSdkAdInfo().getClk(), cSJBannerAd), new i());
                            }
                            if (cSJBannerAd.getInteractionListener() != null) {
                                cSJBannerAd.getInteractionListener().onAdClicked();
                            }
                            CSJBannerListenerImpl.this.adNativeWrapper.getSdkAdInfo().getMsLoadedTime();
                            CSJBannerListenerImpl.this.adNativeWrapper.getAdLoader().getPosId();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdShow(View view, int i) {
                        MediationAdEcpmInfo showEcpm;
                        try {
                            try {
                                MediationNativeManager mediationManager = tTNativeExpressAd.getMediationManager();
                                if (mediationManager != null && (showEcpm = mediationManager.getShowEcpm()) != null) {
                                    CSJBannerListenerImpl.this.adNativeWrapper.getSdkAdInfo().setGmShowEcpm(showEcpm.getEcpm());
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                            h0.a(CSJBannerListenerImpl.this.adNativeWrapper.getSdkAdInfo(), cSJBannerAd.getAdView());
                            if (CSJBannerListenerImpl.this.adNativeWrapper.getLoaderListener() != null) {
                                CSJBannerListenerImpl.this.adNativeWrapper.getLoaderListener().onAdExposure();
                            }
                            if (cSJBannerAd.getInteractionListener() != null) {
                                cSJBannerAd.getInteractionListener().onAdExposure();
                            }
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderFail(View view, String str, int i) {
                        try {
                            z.a(CSJBannerListenerImpl.this.adNativeWrapper.getSdkAdInfo().getErr(), Integer.valueOf(i), str);
                            if (CSJBannerListenerImpl.this.adNativeWrapper.getLoaderListener() != null) {
                                CSJBannerListenerImpl.this.adNativeWrapper.getLoaderListener().onAdError();
                                CSJBannerListenerImpl.this.adNativeWrapper.getLoaderListener().onAdRenderFail(str, i);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderSuccess(View view, float f, float f2) {
                        try {
                            cSJBannerAd.setAdView(view);
                            if (CSJBannerListenerImpl.this.adNativeWrapper.getLoaderListener() != null) {
                                CSJBannerListenerImpl.this.adNativeWrapper.getLoaderListener().onAdLoaded(cSJBannerAd);
                                CSJBannerListenerImpl.this.adNativeWrapper.getLoaderListener().onAdReady(cSJBannerAd);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                tTNativeExpressAd.render();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
