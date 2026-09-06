package com.meishu.sdk.platform.csj.draw;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.csj.CSJPlatformError;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJDrawListenerImpl implements TTAdNative.NativeExpressAdListener {
    private static final String TAG = "CSJDrawListenerImpl";
    private CSJDrawAdWrapper adNativeWrapper;
    private boolean hasExposed;

    public CSJDrawListenerImpl(CSJDrawAdWrapper cSJDrawAdWrapper) {
        this.adNativeWrapper = cSJDrawAdWrapper;
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
                final CSJDrawAd cSJDrawAd = new CSJDrawAd(this.adNativeWrapper.getSdkAdInfo(), this.adNativeWrapper.getLoaderListener(), this.adNativeWrapper, tTNativeExpressAd);
                tTNativeExpressAd.setCanInterruptVideoPlay(true);
                tTNativeExpressAd.setVideoAdListener(new TTNativeExpressAd.ExpressVideoAdListener() { // from class: com.meishu.sdk.platform.csj.draw.CSJDrawListenerImpl.1
                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                    public void onClickRetry() {
                        try {
                            if (cSJDrawAd.getDrawVideoListener() != null) {
                                cSJDrawAd.getDrawVideoListener().onClickRetry();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                    public void onProgressUpdate(long j, long j2) {
                        try {
                            if (cSJDrawAd.getDrawVideoListener() != null) {
                                cSJDrawAd.getDrawVideoListener().onProgressUpdate(j, j2);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                    public void onVideoAdComplete() {
                        try {
                            if (cSJDrawAd.getDrawVideoListener() != null) {
                                cSJDrawAd.getDrawVideoListener().playCompletion();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                    public void onVideoAdContinuePlay() {
                        try {
                            if (cSJDrawAd.getDrawVideoListener() != null) {
                                cSJDrawAd.getDrawVideoListener().playResume();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                    public void onVideoAdPaused() {
                        try {
                            if (cSJDrawAd.getDrawVideoListener() != null) {
                                cSJDrawAd.getDrawVideoListener().playPause();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                    public void onVideoAdStartPlay() {
                        try {
                            if (cSJDrawAd.getDrawVideoListener() != null) {
                                cSJDrawAd.getDrawVideoListener().playRenderingStart();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                    public void onVideoError(int i, int i2) {
                        try {
                            if (cSJDrawAd.getDrawVideoListener() != null) {
                                cSJDrawAd.getDrawVideoListener().onVideoError(i, i2);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                    public void onVideoLoad() {
                        try {
                            if (cSJDrawAd.getDrawVideoListener() != null) {
                                cSJDrawAd.getDrawVideoListener().onVideoLoad();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.meishu.sdk.platform.csj.draw.CSJDrawListenerImpl.2
                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdClicked(View view, int i) {
                        try {
                            if (CSJDrawListenerImpl.this.adNativeWrapper != null && !TextUtils.isEmpty(CSJDrawListenerImpl.this.adNativeWrapper.getSdkAdInfo().getClk())) {
                                LogUtil.d(CSJDrawListenerImpl.TAG, "send onAdClicked");
                                z.a(CSJDrawListenerImpl.this.adNativeWrapper.getContext(), f.a(CSJDrawListenerImpl.this.adNativeWrapper.getSdkAdInfo().getClk(), cSJDrawAd), new i());
                            }
                            if (cSJDrawAd.getInteractionListener() != null) {
                                cSJDrawAd.getInteractionListener().onAdClicked();
                            }
                            CSJDrawListenerImpl.this.adNativeWrapper.getSdkAdInfo().getMsLoadedTime();
                            CSJDrawListenerImpl.this.adNativeWrapper.getAdLoader().getPosId();
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
                                    CSJDrawListenerImpl.this.adNativeWrapper.getSdkAdInfo().setGmShowEcpm(showEcpm.getEcpm());
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                            if (CSJDrawListenerImpl.this.hasExposed || CSJDrawListenerImpl.this.adNativeWrapper.getLoaderListener() == null) {
                                return;
                            }
                            CSJDrawListenerImpl.this.hasExposed = true;
                            CSJDrawListenerImpl.this.adNativeWrapper.getLoaderListener().onAdExposure();
                            if (cSJDrawAd.getInteractionListener() != null) {
                                cSJDrawAd.getInteractionListener().onAdExposure();
                            }
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderFail(View view, String str, int i) {
                        try {
                            z.a(CSJDrawListenerImpl.this.adNativeWrapper.getSdkAdInfo().getErr(), Integer.valueOf(i), str);
                            if (CSJDrawListenerImpl.this.adNativeWrapper.getLoaderListener() != null) {
                                CSJDrawListenerImpl.this.adNativeWrapper.getLoaderListener().onAdError();
                                CSJDrawListenerImpl.this.adNativeWrapper.getLoaderListener().onAdRenderFail(str, i);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderSuccess(View view, float f, float f2) {
                        try {
                            cSJDrawAd.setAdView(view);
                            if (CSJDrawListenerImpl.this.adNativeWrapper.getLoaderListener() != null) {
                                CSJDrawListenerImpl.this.adNativeWrapper.getLoaderListener().onAdLoaded(cSJDrawAd);
                                CSJDrawListenerImpl.this.adNativeWrapper.getLoaderListener().onAdReady(cSJDrawAd);
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
