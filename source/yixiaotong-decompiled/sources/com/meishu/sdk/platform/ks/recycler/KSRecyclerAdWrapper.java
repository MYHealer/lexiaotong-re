package com.meishu.sdk.platform.ks.recycler;

import android.util.DisplayMetrics;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.ad.recycler.a;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.csj.CSJPlatformError;
import com.meishu.sdk.platform.ks.KSPlatformError;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KSRecyclerAdWrapper extends BasePlatformLoader<RecyclerMixAdLoader, a> {
    private static final String TAG = "KSRecyclerAdWrapper";
    private List<KsFeedAd> expressAdList;
    private boolean isPreRender;
    private List<KsNativeAd> nativeAdList;

    public KSRecyclerAdWrapper(RecyclerMixAdLoader recyclerMixAdLoader, SdkAdInfo sdkAdInfo) {
        super(recyclerMixAdLoader, sdkAdInfo);
    }

    private void loadExpressAd() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (getAdLoader().getAccept_ad_width() == null || getAdLoader().getAccept_ad_width().intValue() <= 0) {
            int i = displayMetrics.widthPixels;
        } else {
            getAdLoader().getAccept_ad_width().intValue();
            float f = displayMetrics.density;
        }
        if (getAdLoader().getAccept_ad_height() != null && getAdLoader().getAccept_ad_height().intValue() > 0) {
            getAdLoader().getAccept_ad_height().intValue();
            float f2 = displayMetrics.density;
        }
        KsAdSDK.getLoadManager().loadConfigFeedAd(new KsScene.Builder(Long.parseLong(getSdkAdInfo().getPid())).adNum(getAdLoader().getFetchCount()).build(), new KsLoadManager.FeedAdListener() { // from class: com.meishu.sdk.platform.ks.recycler.KSRecyclerAdWrapper.2
            @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
            public void onError(int i2, String str) {
                LogUtil.e(KSRecyclerAdWrapper.TAG, str + "" + i2);
                new KSPlatformError(str, Integer.valueOf(i2), KSRecyclerAdWrapper.this.sdkAdInfo).post(KSRecyclerAdWrapper.this.loadListener);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
            public void onFeedAdLoad(List<KsFeedAd> list) {
                KSRecyclerAdWrapper.this.expressAdList = list;
                if (list != null) {
                    try {
                        if (!list.isEmpty()) {
                            if (KSRecyclerAdWrapper.this.getLoaderListener() != null) {
                                ArrayList arrayList = new ArrayList();
                                for (KsFeedAd ksFeedAd : list) {
                                    KSRecyclerAdWrapper.this.sdkAdInfo.setEcpm(String.valueOf(ksFeedAd.getECPM()));
                                    KSExpressFeedAd kSExpressFeedAd = new KSExpressFeedAd(ksFeedAd, KSRecyclerAdWrapper.this);
                                    arrayList.add(kSExpressFeedAd);
                                    ksFeedAd.setAdInteractionListener(new KSExpressListener(KSRecyclerAdWrapper.this, kSExpressFeedAd));
                                }
                                KSRecyclerAdWrapper.this.getLoaderListener().onAdLoaded(arrayList);
                                KSRecyclerAdWrapper.this.getLoaderListener().onAdReady(arrayList);
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return;
                    }
                }
                LogUtil.e(KSRecyclerAdWrapper.TAG, "onNativeAdLoad KSExpressAd is null");
                if (KSRecyclerAdWrapper.this.getLoaderListener() != null) {
                    KSRecyclerAdWrapper.this.getLoaderListener().onAdError();
                }
            }
        });
    }

    private void loadNativeAd() {
        try {
            KsAdSDK.getLoadManager().loadNativeAd(new KsScene.Builder(Long.parseLong(getSdkAdInfo().getPid())).adNum(getAdLoader().getFetchCount()).build(), new KsLoadManager.NativeAdListener() { // from class: com.meishu.sdk.platform.ks.recycler.KSRecyclerAdWrapper.1
                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public void onError(int i, String str) {
                    LogUtil.e(KSRecyclerAdWrapper.TAG, str + "" + i);
                    new KSPlatformError(str, Integer.valueOf(i), KSRecyclerAdWrapper.this.sdkAdInfo).post(KSRecyclerAdWrapper.this.loadListener);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public void onNativeAdLoad(List<KsNativeAd> list) {
                    KSRecyclerAdWrapper.this.nativeAdList = list;
                    if (list == null) {
                        LogUtil.e(KSRecyclerAdWrapper.TAG, "onNativeAdLoad ksNativeAdList is null");
                        if (KSRecyclerAdWrapper.this.getLoaderListener() != null) {
                            KSRecyclerAdWrapper.this.getLoaderListener().onAdError();
                            return;
                        }
                        return;
                    }
                    if (KSRecyclerAdWrapper.this.getLoaderListener() != null) {
                        ArrayList arrayList = new ArrayList();
                        for (KsNativeAd ksNativeAd : list) {
                            KSRecyclerAdWrapper.this.sdkAdInfo.setEcpm(String.valueOf(ksNativeAd.getECPM()));
                            arrayList.add(new KSRecyclerAd(ksNativeAd, KSRecyclerAdWrapper.this));
                        }
                        KSRecyclerAdWrapper.this.getLoaderListener().onAdLoaded(arrayList);
                        KSRecyclerAdWrapper.this.getLoaderListener().onAdReady(arrayList);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        try {
            z.a(getAdLoader().getContext(), h0.a(getSdkAdInfo().getReq()), new i());
            int adPatternType = getAdLoader().getAdPatternType();
            this.isPreRender = false;
            if (adPatternType == 200000) {
                int drawing = getSdkAdInfo().getDrawing();
                if (drawing == 1) {
                    this.isPreRender = false;
                } else {
                    if (drawing != 2) {
                        new CSJPlatformError("信息流模式不支持", -1, getSdkAdInfo()).post(this.loadListener);
                        return;
                    }
                    this.isPreRender = true;
                }
            } else if (adPatternType == 100000) {
                this.isPreRender = true;
            }
            if (this.isPreRender) {
                loadExpressAd();
            } else {
                loadNativeAd();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.isPreRender) {
                List<KsFeedAd> list = this.expressAdList;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (KsFeedAd ksFeedAd : this.expressAdList) {
                    if (z) {
                        ksFeedAd.setBidEcpm(ksFeedAd.getECPM(), t0.a(ksFeedAd.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice()));
                    } else {
                        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                        adExposureFailedReason.setAdnType(3);
                        adExposureFailedReason.setWinEcpm(i);
                        ksFeedAd.reportAdExposureFailed(2, adExposureFailedReason);
                    }
                }
                return;
            }
            List<KsNativeAd> list2 = this.nativeAdList;
            if (list2 == null || list2.size() <= 0) {
                return;
            }
            for (KsNativeAd ksNativeAd : this.nativeAdList) {
                if (z) {
                    ksNativeAd.setBidEcpm(ksNativeAd.getECPM(), t0.a(ksNativeAd.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice()));
                } else {
                    AdExposureFailedReason adExposureFailedReason2 = new AdExposureFailedReason();
                    adExposureFailedReason2.setAdnType(3);
                    adExposureFailedReason2.setWinEcpm(i);
                    ksNativeAd.reportAdExposureFailed(2, adExposureFailedReason2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
