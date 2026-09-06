package com.meishu.sdk.platform.csj.draw;

import android.app.Activity;
import android.util.DisplayMetrics;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.meishu.sdk.core.ad.draw.DrawAdLoader;
import com.meishu.sdk.core.ad.draw.a;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.m;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.csj.CSJAdConfig;
import com.meishu.sdk.platform.csj.CSJPlatformError;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJDrawAdWrapper extends BasePlatformLoader<DrawAdLoader, a> {
    private static final String TAG = "CSJDrawAdWrapper";
    private MeishuAdInfo meishuAdInfo;
    private TTAdNative ttAdNative;
    private TTNativeExpressAd ttNativeExpressAd;

    public CSJDrawAdWrapper(DrawAdLoader drawAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        super(drawAdLoader, sdkAdInfo);
        this.ttAdNative = CSJAdConfig.getTtAdManager().createAdNative(drawAdLoader.getContext());
        this.meishuAdInfo = meishuAdInfo;
    }

    private void loadExpressAd(int i, int i2) {
        try {
            this.ttAdNative.loadExpressDrawFeedAd(new AdSlot.Builder().setCodeId(getSdkAdInfo().getPid()).setSupportDeepLink(true).setImageAcceptedSize(i, i2).setExpressViewAcceptedSize(m.b(((DrawAdLoader) this.adLoader).getContext(), i), m.b(((DrawAdLoader) this.adLoader).getContext(), i2)).build(), new CSJDrawListenerImpl(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void loadMediationExpressAd(int i, int i2) {
        this.ttAdNative.loadDrawFeedAd(new AdSlot.Builder().setCodeId(getSdkAdInfo().getPid()).setImageAcceptedSize(i, i2).setAdCount(1).build(), new TTAdNative.DrawFeedAdListener() { // from class: com.meishu.sdk.platform.csj.draw.CSJDrawAdWrapper.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
            public void onDrawFeedAdLoad(List<TTDrawFeedAd> list) {
                if (list == null || list.size() <= 0) {
                    try {
                        LogUtil.e(CSJDrawAdWrapper.TAG, "onError, code: -1, msg: ad list is null");
                        new CSJPlatformError("ad list is null", -1, CSJDrawAdWrapper.this.getSdkAdInfo()).post(CSJDrawAdWrapper.this.getLoaderListener());
                        return;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return;
                    }
                }
                CSJDrawMediationAd cSJDrawMediationAd = new CSJDrawMediationAd(CSJDrawAdWrapper.this, list.get(0));
                if (CSJDrawAdWrapper.this.getLoaderListener() != null) {
                    CSJDrawAdWrapper.this.getLoaderListener().onAdLoaded(cSJDrawMediationAd);
                    CSJDrawAdWrapper.this.getLoaderListener().onAdReady(cSJDrawMediationAd);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
            public void onError(int i3, String str) {
                try {
                    LogUtil.e(CSJDrawAdWrapper.TAG, "onError, code: " + i3 + ", msg: " + str);
                    new CSJPlatformError(str, Integer.valueOf(i3), CSJDrawAdWrapper.this.getSdkAdInfo()).post(CSJDrawAdWrapper.this.getLoaderListener());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private void loadNativeAd(int i, int i2) {
        try {
            CSJAdConfig.getTtAdManager().createAdNative(getContext()).loadDrawFeedAd(new AdSlot.Builder().setCodeId(getSdkAdInfo().getPid()).setImageAcceptedSize(i, i2).setAdCount(1).build(), new TTAdNative.DrawFeedAdListener() { // from class: com.meishu.sdk.platform.csj.draw.CSJDrawAdWrapper.2
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
                public void onDrawFeedAdLoad(List<TTDrawFeedAd> list) {
                    if (list != null) {
                        try {
                            if (list.isEmpty()) {
                                return;
                            }
                            TTDrawFeedAd tTDrawFeedAd = list.get(0);
                            final CSJNativeDrawAd cSJNativeDrawAd = new CSJNativeDrawAd(CSJDrawAdWrapper.this, tTDrawFeedAd);
                            cSJNativeDrawAd.setAdView(tTDrawFeedAd.getAdView());
                            if (CSJDrawAdWrapper.this.getContext() instanceof Activity) {
                                tTDrawFeedAd.setActivityForDownloadApp((Activity) CSJDrawAdWrapper.this.getContext());
                            }
                            tTDrawFeedAd.setVideoAdListener(new TTFeedAd.VideoAdListener() { // from class: com.meishu.sdk.platform.csj.draw.CSJDrawAdWrapper.2.1
                                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                                public void onProgressUpdate(long j, long j2) {
                                    try {
                                        if (cSJNativeDrawAd.getDrawVideoListener() != null) {
                                            cSJNativeDrawAd.getDrawVideoListener().onProgressUpdate(j, j2);
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                                public void onVideoAdComplete(TTFeedAd tTFeedAd) {
                                    try {
                                        if (cSJNativeDrawAd.getDrawVideoListener() != null) {
                                            cSJNativeDrawAd.getDrawVideoListener().playCompletion();
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                                public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
                                    try {
                                        if (cSJNativeDrawAd.getDrawVideoListener() != null) {
                                            cSJNativeDrawAd.getDrawVideoListener().playResume();
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                                public void onVideoAdPaused(TTFeedAd tTFeedAd) {
                                    try {
                                        if (cSJNativeDrawAd.getDrawVideoListener() != null) {
                                            cSJNativeDrawAd.getDrawVideoListener().playPause();
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                                public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
                                    try {
                                        if (cSJNativeDrawAd.getDrawVideoListener() != null) {
                                            cSJNativeDrawAd.getDrawVideoListener().playRenderingStart();
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                                public void onVideoError(int i3, int i4) {
                                    try {
                                        if (cSJNativeDrawAd.getDrawVideoListener() != null) {
                                            cSJNativeDrawAd.getDrawVideoListener().onVideoError(i3, i4);
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                                public void onVideoLoad(TTFeedAd tTFeedAd) {
                                    try {
                                        if (cSJNativeDrawAd.getDrawVideoListener() != null) {
                                            cSJNativeDrawAd.getDrawVideoListener().onVideoLoad();
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            });
                            if (CSJDrawAdWrapper.this.getLoaderListener() != null) {
                                CSJDrawAdWrapper.this.getLoaderListener().onAdLoaded(cSJNativeDrawAd);
                                CSJDrawAdWrapper.this.getLoaderListener().onAdReady(cSJNativeDrawAd);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
                public void onError(int i3, String str) {
                    try {
                        LogUtil.e(CSJDrawAdWrapper.TAG, "onError, code: " + i3 + ", msg: " + str);
                        new CSJPlatformError(str, Integer.valueOf(i3), CSJDrawAdWrapper.this.getSdkAdInfo()).post(CSJDrawAdWrapper.this.getLoaderListener());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        super.destroy();
        TTNativeExpressAd tTNativeExpressAd = this.ttNativeExpressAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        try {
            z.a(StubApp.getOrigApplicationContext(((DrawAdLoader) this.adLoader).getContext().getApplicationContext()), h0.a(getSdkAdInfo().getReq()), new i());
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            int iIntValue = displayMetrics.widthPixels;
            int iIntValue2 = displayMetrics.heightPixels;
            if (getAdLoader().getAccept_ad_width() != null && getAdLoader().getAccept_ad_width().intValue() > 0 && getAdLoader().getAccept_ad_height() != null && getAdLoader().getAccept_ad_height().intValue() > 0) {
                iIntValue = getAdLoader().getAccept_ad_width().intValue();
                iIntValue2 = getAdLoader().getAccept_ad_height().intValue();
            }
            if (getSdkAdInfo().getDrawing() == 1) {
                loadNativeAd(iIntValue, iIntValue2);
            } else if (this.sdkAdInfo.isCsjGM()) {
                loadMediationExpressAd(iIntValue, iIntValue2);
            } else {
                loadExpressAd(iIntValue, iIntValue2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTtNativeExpressAd(TTNativeExpressAd tTNativeExpressAd) {
        this.ttNativeExpressAd = tTNativeExpressAd;
    }
}
