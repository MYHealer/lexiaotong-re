package com.meishu.sdk.platform.csj.draw;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.draw.DrawAd;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJDrawMediationAd extends DrawAd {
    private static final String TAG = "CSJDrawMediationAd";
    private CSJDrawAdWrapper adWrapper;
    private boolean hasExposed;
    private TTDrawFeedAd mTTFeedAd;

    public CSJDrawMediationAd(CSJDrawAdWrapper cSJDrawAdWrapper, TTDrawFeedAd tTDrawFeedAd) {
        super(cSJDrawAdWrapper, MSAdConfig.PLATFORM_CSJ);
        this.adWrapper = cSJDrawAdWrapper;
        this.mTTFeedAd = tTDrawFeedAd;
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void destroy() {
        super.destroy();
        TTDrawFeedAd tTDrawFeedAd = this.mTTFeedAd;
        if (tTDrawFeedAd != null) {
            tTDrawFeedAd.destroy();
        }
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void showAd(final ViewGroup viewGroup) {
        MediationNativeManager mediationManager;
        TTDrawFeedAd tTDrawFeedAd = this.mTTFeedAd;
        if (tTDrawFeedAd != null && (mediationManager = tTDrawFeedAd.getMediationManager()) != null && mediationManager.isExpress()) {
            this.mTTFeedAd.setVideoAdListener(new TTFeedAd.VideoAdListener() { // from class: com.meishu.sdk.platform.csj.draw.CSJDrawMediationAd.1
                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onProgressUpdate(long j, long j2) {
                    if (CSJDrawMediationAd.this.getDrawVideoListener() != null) {
                        CSJDrawMediationAd.this.getDrawVideoListener().onProgressUpdate(j, j2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdComplete(TTFeedAd tTFeedAd) {
                    if (CSJDrawMediationAd.this.getDrawVideoListener() != null) {
                        CSJDrawMediationAd.this.getDrawVideoListener().playCompletion();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
                    if (CSJDrawMediationAd.this.getDrawVideoListener() != null) {
                        CSJDrawMediationAd.this.getDrawVideoListener().playResume();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdPaused(TTFeedAd tTFeedAd) {
                    if (CSJDrawMediationAd.this.getDrawVideoListener() != null) {
                        CSJDrawMediationAd.this.getDrawVideoListener().playPause();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
                    if (CSJDrawMediationAd.this.getDrawVideoListener() != null) {
                        CSJDrawMediationAd.this.getDrawVideoListener().playRenderingStart();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoError(int i, int i2) {
                    if (CSJDrawMediationAd.this.getDrawVideoListener() != null) {
                        CSJDrawMediationAd.this.getDrawVideoListener().onVideoError(i, i2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoLoad(TTFeedAd tTFeedAd) {
                    if (CSJDrawMediationAd.this.getDrawVideoListener() != null) {
                        CSJDrawMediationAd.this.getDrawVideoListener().onVideoLoad();
                    }
                }
            });
            this.mTTFeedAd.setExpressRenderListener(new MediationExpressRenderListener() { // from class: com.meishu.sdk.platform.csj.draw.CSJDrawMediationAd.2
                @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
                public void onAdClick() {
                    try {
                        LogUtil.d(CSJDrawMediationAd.TAG, "onAdCreativeClick");
                        if (CSJDrawMediationAd.this.adWrapper != null && !TextUtils.isEmpty(CSJDrawMediationAd.this.adWrapper.getSdkAdInfo().getClk())) {
                            LogUtil.d(CSJDrawMediationAd.TAG, "send onAdClicked");
                            z.a(CSJDrawMediationAd.this.adWrapper.getContext(), f.a(CSJDrawMediationAd.this.adWrapper.getSdkAdInfo().getClk(), CSJDrawMediationAd.this), new i());
                        }
                        if (CSJDrawMediationAd.this.getInteractionListener() != null) {
                            CSJDrawMediationAd.this.getInteractionListener().onAdClicked();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
                public void onAdShow() {
                    MediationAdEcpmInfo showEcpm;
                    try {
                        try {
                            MediationNativeManager mediationManager2 = CSJDrawMediationAd.this.mTTFeedAd.getMediationManager();
                            if (mediationManager2 != null && (showEcpm = mediationManager2.getShowEcpm()) != null) {
                                CSJDrawMediationAd.this.adWrapper.getSdkAdInfo().setGmShowEcpm(showEcpm.getEcpm());
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        if (CSJDrawMediationAd.this.hasExposed || CSJDrawMediationAd.this.adWrapper.getLoaderListener() == null) {
                            return;
                        }
                        CSJDrawMediationAd.this.hasExposed = true;
                        CSJDrawMediationAd.this.adWrapper.getLoaderListener().onAdExposure();
                        if (CSJDrawMediationAd.this.getInteractionListener() != null) {
                            CSJDrawMediationAd.this.getInteractionListener().onAdExposure();
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
                public void onRenderFail(View view, String str, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.ExpressRenderListener
                public void onRenderSuccess(View view, float f, float f2, boolean z) {
                    if (CSJDrawMediationAd.this.mTTFeedAd != null) {
                        View adView = CSJDrawMediationAd.this.mTTFeedAd.getAdView();
                        ViewGroup viewGroup2 = viewGroup;
                        if (viewGroup2 != null) {
                            viewGroup2.removeAllViews();
                            if (adView == null) {
                                return;
                            }
                            if (adView.getParent() != null && (adView.getParent() instanceof ViewGroup)) {
                                ((ViewGroup) adView.getParent()).removeView(adView);
                            }
                            viewGroup.addView(adView);
                        }
                    }
                }
            });
            this.mTTFeedAd.render();
        }
        super.showAd(viewGroup);
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void showAd(Activity activity, final ViewGroup viewGroup) {
        MediationNativeManager mediationManager;
        TTDrawFeedAd tTDrawFeedAd = this.mTTFeedAd;
        if (tTDrawFeedAd != null && (mediationManager = tTDrawFeedAd.getMediationManager()) != null && mediationManager.isExpress()) {
            this.mTTFeedAd.setVideoAdListener(new TTFeedAd.VideoAdListener() { // from class: com.meishu.sdk.platform.csj.draw.CSJDrawMediationAd.3
                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onProgressUpdate(long j, long j2) {
                    if (CSJDrawMediationAd.this.getDrawVideoListener() != null) {
                        CSJDrawMediationAd.this.getDrawVideoListener().onProgressUpdate(j, j2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdComplete(TTFeedAd tTFeedAd) {
                    if (CSJDrawMediationAd.this.getDrawVideoListener() != null) {
                        CSJDrawMediationAd.this.getDrawVideoListener().playCompletion();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
                    if (CSJDrawMediationAd.this.getDrawVideoListener() != null) {
                        CSJDrawMediationAd.this.getDrawVideoListener().playResume();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdPaused(TTFeedAd tTFeedAd) {
                    if (CSJDrawMediationAd.this.getDrawVideoListener() != null) {
                        CSJDrawMediationAd.this.getDrawVideoListener().playPause();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
                    if (CSJDrawMediationAd.this.getDrawVideoListener() != null) {
                        CSJDrawMediationAd.this.getDrawVideoListener().playRenderingStart();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoError(int i, int i2) {
                    if (CSJDrawMediationAd.this.getDrawVideoListener() != null) {
                        CSJDrawMediationAd.this.getDrawVideoListener().onVideoError(i, i2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoLoad(TTFeedAd tTFeedAd) {
                    if (CSJDrawMediationAd.this.getDrawVideoListener() != null) {
                        CSJDrawMediationAd.this.getDrawVideoListener().onVideoLoad();
                    }
                }
            });
            this.mTTFeedAd.setExpressRenderListener(new MediationExpressRenderListener() { // from class: com.meishu.sdk.platform.csj.draw.CSJDrawMediationAd.4
                @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
                public void onAdClick() {
                    try {
                        LogUtil.d(CSJDrawMediationAd.TAG, "onAdCreativeClick");
                        if (CSJDrawMediationAd.this.adWrapper != null && !TextUtils.isEmpty(CSJDrawMediationAd.this.adWrapper.getSdkAdInfo().getClk())) {
                            LogUtil.d(CSJDrawMediationAd.TAG, "send onAdClicked");
                            z.a(CSJDrawMediationAd.this.adWrapper.getContext(), f.a(CSJDrawMediationAd.this.adWrapper.getSdkAdInfo().getClk(), CSJDrawMediationAd.this), new i());
                        }
                        if (CSJDrawMediationAd.this.getInteractionListener() != null) {
                            CSJDrawMediationAd.this.getInteractionListener().onAdClicked();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
                public void onAdShow() {
                    MediationAdEcpmInfo showEcpm;
                    try {
                        try {
                            MediationNativeManager mediationManager2 = CSJDrawMediationAd.this.mTTFeedAd.getMediationManager();
                            if (mediationManager2 != null && (showEcpm = mediationManager2.getShowEcpm()) != null) {
                                CSJDrawMediationAd.this.adWrapper.getSdkAdInfo().setGmShowEcpm(showEcpm.getEcpm());
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        if (CSJDrawMediationAd.this.hasExposed || CSJDrawMediationAd.this.adWrapper.getLoaderListener() == null) {
                            return;
                        }
                        CSJDrawMediationAd.this.hasExposed = true;
                        CSJDrawMediationAd.this.adWrapper.getLoaderListener().onAdExposure();
                        if (CSJDrawMediationAd.this.getInteractionListener() != null) {
                            CSJDrawMediationAd.this.getInteractionListener().onAdExposure();
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
                public void onRenderFail(View view, String str, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.ExpressRenderListener
                public void onRenderSuccess(View view, float f, float f2, boolean z) {
                    if (CSJDrawMediationAd.this.mTTFeedAd != null) {
                        View adView = CSJDrawMediationAd.this.mTTFeedAd.getAdView();
                        ViewGroup viewGroup2 = viewGroup;
                        if (viewGroup2 != null) {
                            viewGroup2.removeAllViews();
                            if (adView == null) {
                                return;
                            }
                            if (adView.getParent() != null && (adView.getParent() instanceof ViewGroup)) {
                                ((ViewGroup) adView.getParent()).removeView(adView);
                            }
                            viewGroup.addView(adView);
                        }
                    }
                }
            });
            this.mTTFeedAd.render();
        }
        super.showAd(activity, viewGroup);
    }
}
