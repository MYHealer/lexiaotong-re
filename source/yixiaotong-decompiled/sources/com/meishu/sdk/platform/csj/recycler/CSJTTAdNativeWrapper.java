package com.meishu.sdk.platform.csj.recycler;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.ad.recycler.a;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.g0;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.csj.CSJAdConfig;
import com.meishu.sdk.platform.csj.CSJPlatformError;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJTTAdNativeWrapper extends BasePlatformLoader<RecyclerMixAdLoader, a> {
    private static final String TAG = "CSJTTAdNativeWrapper";
    private CSJFeedAdListener listener;
    private MeishuAdInfo meishuAdInfo;
    private TTAdNative ttAdNative;

    public CSJTTAdNativeWrapper(RecyclerMixAdLoader recyclerMixAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        super(recyclerMixAdLoader, sdkAdInfo);
        this.ttAdNative = CSJAdConfig.getTtAdManager().createAdNative(StubApp.getOrigApplicationContext(recyclerMixAdLoader.getContext().getApplicationContext()));
        this.meishuAdInfo = meishuAdInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMediationExpressAd(AdSlot adSlot) {
        this.ttAdNative.loadFeedAd(adSlot, new TTAdNative.FeedAdListener() { // from class: com.meishu.sdk.platform.csj.recycler.CSJTTAdNativeWrapper.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str) {
                try {
                    new CSJPlatformError(str, Integer.valueOf(i), CSJTTAdNativeWrapper.this.getSdkAdInfo()).post(CSJTTAdNativeWrapper.this.loadListener);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                if (list != null) {
                    try {
                        if (CSJTTAdNativeWrapper.this.getLoaderListener() != null) {
                            ArrayList arrayList = new ArrayList();
                            for (final TTFeedAd tTFeedAd : list) {
                                final MediationNativeManager mediationManager = tTFeedAd.getMediationManager();
                                if (mediationManager != null && mediationManager.isExpress()) {
                                    final CSJMediationExpressAd cSJMediationExpressAd = new CSJMediationExpressAd(CSJTTAdNativeWrapper.this, tTFeedAd);
                                    arrayList.add(cSJMediationExpressAd);
                                    tTFeedAd.setExpressRenderListener(new MediationExpressRenderListener() { // from class: com.meishu.sdk.platform.csj.recycler.CSJTTAdNativeWrapper.2.1
                                        @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
                                        public void onAdClick() {
                                            try {
                                                if (!TextUtils.isEmpty(CSJTTAdNativeWrapper.this.getSdkAdInfo().getClk())) {
                                                    LogUtil.d(CSJTTAdNativeWrapper.TAG, "send onAdClicked");
                                                    z.a(StubApp.getOrigApplicationContext(CSJTTAdNativeWrapper.this.getContext().getApplicationContext()), f.a(CSJTTAdNativeWrapper.this.getSdkAdInfo().getClk(), cSJMediationExpressAd), new i());
                                                }
                                                CSJTTAdNativeWrapper.this.getSdkAdInfo().getMsLoadedTime();
                                                CSJTTAdNativeWrapper.this.getAdLoader().getPosId();
                                                if (cSJMediationExpressAd.getRecylcerAdInteractionListener() != null) {
                                                    cSJMediationExpressAd.getRecylcerAdInteractionListener().onAdClicked();
                                                }
                                            } catch (Throwable th) {
                                                th.printStackTrace();
                                            }
                                        }

                                        @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
                                        public void onAdShow() {
                                            try {
                                                CSJTTAdNativeWrapper.this.getSdkAdInfo().setGmShowEcpm(mediationManager.getShowEcpm().getEcpm());
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                            try {
                                                h0.a(CSJTTAdNativeWrapper.this.getSdkAdInfo(), cSJMediationExpressAd.getAdView());
                                                if (CSJTTAdNativeWrapper.this.getLoaderListener() != null && !cSJMediationExpressAd.isHasExposed()) {
                                                    cSJMediationExpressAd.setHasExposed(true);
                                                    CSJTTAdNativeWrapper.this.getLoaderListener().onAdExposure();
                                                }
                                                if (cSJMediationExpressAd.getRecylcerAdInteractionListener() != null) {
                                                    cSJMediationExpressAd.getRecylcerAdInteractionListener().onAdExposure();
                                                }
                                            } catch (Throwable th) {
                                                th.printStackTrace();
                                            }
                                        }

                                        @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
                                        public void onRenderFail(View view, String str, int i) {
                                            try {
                                                if (cSJMediationExpressAd.getRecylcerAdInteractionListener() != null) {
                                                    cSJMediationExpressAd.getRecylcerAdInteractionListener().onAdRenderFailed();
                                                }
                                            } catch (Throwable th) {
                                                th.printStackTrace();
                                            }
                                        }

                                        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.ExpressRenderListener
                                        public void onRenderSuccess(View view, float f, float f2, boolean z) {
                                            try {
                                                cSJMediationExpressAd.setAdView(tTFeedAd.getAdView());
                                                ArrayList arrayList2 = new ArrayList();
                                                arrayList2.add(cSJMediationExpressAd);
                                                CSJTTAdNativeWrapper.this.getLoaderListener().onAdReady(arrayList2);
                                            } catch (Throwable th) {
                                                th.printStackTrace();
                                            }
                                        }
                                    });
                                    tTFeedAd.render();
                                }
                            }
                            CSJTTAdNativeWrapper.this.getLoaderListener().onAdLoaded(arrayList);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        this.context = null;
        this.ttAdNative = null;
        CSJFeedAdListener cSJFeedAdListener = this.listener;
        if (cSJFeedAdListener != null) {
            cSJFeedAdListener.destroy();
            this.listener = null;
        }
    }

    public a getAdListener() {
        return (a) this.loadListener;
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        ExecutorService executorService = g0.f4905a;
        g0.b.f4906a.a(new l() { // from class: com.meishu.sdk.platform.csj.recycler.CSJTTAdNativeWrapper.1
            /* JADX WARN: Code restructure failed: missing block: B:41:0x018d, code lost:
            
                if (r2 == 100000) goto L42;
             */
            @Override // com.meishu.sdk.core.safe.l
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void safeRun() {
                float fIntValue;
                float f;
                try {
                    z.a(StubApp.getOrigApplicationContext(CSJTTAdNativeWrapper.this.getContext().getApplicationContext()), h0.a(CSJTTAdNativeWrapper.this.getSdkAdInfo().getReq()), new i());
                    if (!CSJAdConfig.isInitSuccess()) {
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int fetchCount = CSJTTAdNativeWrapper.this.getAdLoader().getFetchCount() <= 0 ? 1 : CSJTTAdNativeWrapper.this.getAdLoader().getFetchCount();
                    if (CSJTTAdNativeWrapper.this.meishuAdInfo.getWidth() != 0 && CSJTTAdNativeWrapper.this.meishuAdInfo.getHeight() != 0) {
                        CSJTTAdNativeWrapper.this.meishuAdInfo.getWidth();
                        CSJTTAdNativeWrapper.this.meishuAdInfo.getHeight();
                    }
                    DisplayMetrics displayMetrics = StubApp.getOrigApplicationContext(CSJTTAdNativeWrapper.this.context.getApplicationContext()).getResources().getDisplayMetrics();
                    if (CSJTTAdNativeWrapper.this.getAdLoader().getAccept_ad_width() == null || CSJTTAdNativeWrapper.this.getAdLoader().getAccept_ad_width().intValue() <= 0) {
                        fIntValue = displayMetrics.widthPixels;
                        f = displayMetrics.density;
                    } else {
                        fIntValue = CSJTTAdNativeWrapper.this.getAdLoader().getAccept_ad_width().intValue();
                        f = displayMetrics.density;
                    }
                    AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(CSJTTAdNativeWrapper.this.getSdkAdInfo().getPid()).setSupportDeepLink(true).setImageAcceptedSize(720, 1080).setExpressViewAcceptedSize(fIntValue / f, (CSJTTAdNativeWrapper.this.getAdLoader().getAccept_ad_height() == null || CSJTTAdNativeWrapper.this.getAdLoader().getAccept_ad_height().intValue() <= 0) ? 0.0f : CSJTTAdNativeWrapper.this.getAdLoader().getAccept_ad_height().intValue() / displayMetrics.density).setIsAutoPlay(CSJTTAdNativeWrapper.this.getAdLoader().getIsVideoAutoPlay()).setAdCount(fetchCount).build();
                    CSJTTAdNativeWrapper cSJTTAdNativeWrapper = CSJTTAdNativeWrapper.this;
                    cSJTTAdNativeWrapper.listener = new CSJFeedAdListener(cSJTTAdNativeWrapper, (a) cSJTTAdNativeWrapper.loadListener);
                    int adPatternType = CSJTTAdNativeWrapper.this.getAdLoader().getAdPatternType();
                    if (adPatternType == 200000) {
                        int drawing = CSJTTAdNativeWrapper.this.getSdkAdInfo().getDrawing();
                        if (drawing == 1) {
                            CSJTTAdNativeWrapper.this.ttAdNative.loadFeedAd(adSlotBuild, CSJTTAdNativeWrapper.this.listener);
                            return;
                        }
                        if (drawing != 2) {
                            new CSJPlatformError("信息流模式不支持", -1, CSJTTAdNativeWrapper.this.getSdkAdInfo()).post(CSJTTAdNativeWrapper.this.loadListener);
                        } else if (CSJTTAdNativeWrapper.this.sdkAdInfo.isCsjGM()) {
                            CSJTTAdNativeWrapper.this.loadMediationExpressAd(adSlotBuild);
                        } else {
                            CSJTTAdNativeWrapper.this.ttAdNative.loadNativeExpressAd(adSlotBuild, CSJTTAdNativeWrapper.this.listener);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
