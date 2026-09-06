package com.meishu.sdk.platform.huawei.recycler;

import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.AdCloseBtnClickListener;
import com.huawei.hms.ads.AdFeedbackListener;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.BiddingParam;
import com.huawei.hms.ads.ReportUrlListener;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeAdLoader;
import com.huawei.hms.ads.nativead.NativeView;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.ad.recycler.a;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.huawei.HWPlatformError;
import com.stub.StubApp;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HWRecyclerAdWrapper extends BasePlatformLoader<RecyclerMixAdLoader, a> {
    private static final String TAG = "HWRecyclerAdWrapper";
    private static final int TEMPLATE_AD = 99;
    private volatile boolean hasExposed;
    private boolean isBidding;
    private NativeAd mNativeAd;

    public HWRecyclerAdWrapper(RecyclerMixAdLoader recyclerMixAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        super(recyclerMixAdLoader, sdkAdInfo);
        this.isBidding = true;
    }

    private void loadNativeAD(int i) {
        NativeAdLoader.Builder builder = new NativeAdLoader.Builder(getContext(), getSdkAdInfo().getPid());
        final ArrayList arrayList = new ArrayList();
        builder.setNativeAdLoadedListener(new NativeAd.NativeAdLoadedListener() { // from class: com.meishu.sdk.platform.huawei.recycler.HWRecyclerAdWrapper.2
            @Override // com.huawei.hms.ads.nativead.NativeAd.NativeAdLoadedListener
            public void onNativeAdLoaded(NativeAd nativeAd) {
                HWRecyclerAdWrapper.this.mNativeAd = nativeAd;
                if (nativeAd != null) {
                    BiddingInfo biddingInfo = nativeAd.getBiddingInfo();
                    try {
                        if (HWRecyclerAdWrapper.this.getSdkAdInfo() != null && biddingInfo != null) {
                            HWRecyclerAdWrapper.this.getSdkAdInfo().setEcpm(String.valueOf((int) (biddingInfo.getPrice().floatValue() * 100.0f)));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    LogUtil.d(HWRecyclerAdWrapper.TAG, com.meishu.sdk.activity.a.a("createType=").append(nativeAd.getCreativeType()).toString());
                    if (nativeAd.getCreativeType() != 99) {
                        arrayList.add(new HWNativeAdData(HWRecyclerAdWrapper.this, nativeAd));
                        return;
                    }
                    HWExpressAd hWExpressAd = new HWExpressAd(HWRecyclerAdWrapper.this);
                    NativeView nativeView = new NativeView(HWRecyclerAdWrapper.this.context);
                    nativeView.setAdFeedbackListener(new AdFeedbackListener() { // from class: com.meishu.sdk.platform.huawei.recycler.HWRecyclerAdWrapper.2.1
                        @Override // com.huawei.hms.ads.AdFeedbackListener
                        public void onAdDisliked() {
                        }

                        @Override // com.huawei.hms.ads.AdFeedbackListener
                        public void onAdFeedbackShowFailed() {
                        }

                        @Override // com.huawei.hms.ads.AdFeedbackListener
                        public void onAdLiked() {
                        }
                    });
                    nativeView.setAdCloseBtnClickListener(new AdCloseBtnClickListener() { // from class: com.meishu.sdk.platform.huawei.recycler.HWRecyclerAdWrapper.2.2
                        @Override // com.huawei.hms.ads.AdCloseBtnClickListener
                        public void onCloseBtnClick() {
                            HWExpressAd hWExpressAd2 = (HWExpressAd) arrayList.get(0);
                            try {
                                View adView = hWExpressAd2.getAdView();
                                if (adView != null && adView.getParent() != null) {
                                    ((ViewGroup) adView.getParent()).removeView(adView);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            if (hWExpressAd2.getRecylcerAdInteractionListener() != null) {
                                hWExpressAd2.getRecylcerAdInteractionListener().onAdClosed();
                            }
                        }
                    });
                    nativeView.setNativeAd(nativeAd);
                    hWExpressAd.setAdView(nativeView);
                    arrayList.add(hWExpressAd);
                }
            }
        }).setAdListener(new AdListener() { // from class: com.meishu.sdk.platform.huawei.recycler.HWRecyclerAdWrapper.1
            @Override // com.huawei.hms.ads.AdListener
            public void onAdClicked() {
                super.onAdClicked();
                LogUtil.d(HWRecyclerAdWrapper.TAG, "onAdClicked: ");
                try {
                    if (HWRecyclerAdWrapper.this.mNativeAd == null || HWRecyclerAdWrapper.this.mNativeAd.getCreativeType() != 99) {
                        HWNativeAdData hWNativeAdData = (HWNativeAdData) arrayList.get(0);
                        if (HWRecyclerAdWrapper.this.getSdkAdInfo() != null) {
                            LogUtil.d(HWRecyclerAdWrapper.TAG, "send onADClicked");
                            z.a(StubApp.getOrigApplicationContext(HWRecyclerAdWrapper.this.getContext().getApplicationContext()), f.a(HWRecyclerAdWrapper.this.getSdkAdInfo().getClk(), hWNativeAdData), new i());
                        }
                        if (hWNativeAdData.getRecylcerAdInteractionListener() != null) {
                            hWNativeAdData.getRecylcerAdInteractionListener().onAdClicked();
                            return;
                        }
                        return;
                    }
                    HWExpressAd hWExpressAd = (HWExpressAd) arrayList.get(0);
                    if (HWRecyclerAdWrapper.this.getSdkAdInfo() != null) {
                        LogUtil.d(HWRecyclerAdWrapper.TAG, "send onADClicked");
                        z.a(StubApp.getOrigApplicationContext(HWRecyclerAdWrapper.this.getContext().getApplicationContext()), f.a(HWRecyclerAdWrapper.this.getSdkAdInfo().getClk(), hWExpressAd), new i());
                    }
                    if (hWExpressAd.getRecylcerAdInteractionListener() != null) {
                        hWExpressAd.getRecylcerAdInteractionListener().onAdClicked();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdClosed() {
                super.onAdClosed();
                LogUtil.d(HWRecyclerAdWrapper.TAG, "onAdClosed: ");
                if (HWRecyclerAdWrapper.this.mNativeAd == null || HWRecyclerAdWrapper.this.mNativeAd.getCreativeType() != 99) {
                    try {
                        HWNativeAdData hWNativeAdData = (HWNativeAdData) arrayList.get(0);
                        if (hWNativeAdData.getRecylcerAdInteractionListener() != null) {
                            hWNativeAdData.getRecylcerAdInteractionListener().onAdClosed();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdFailed(int i2) {
                LogUtil.d(HWRecyclerAdWrapper.TAG, "onAdFailed: " + i2);
                new HWPlatformError("onAdFailed", i2, HWRecyclerAdWrapper.this.getSdkAdInfo()).post(HWRecyclerAdWrapper.this.getLoaderListener());
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdImpression() {
                super.onAdImpression();
                if (HWRecyclerAdWrapper.this.getLoaderListener() == null || HWRecyclerAdWrapper.this.hasExposed) {
                    return;
                }
                LogUtil.d(HWRecyclerAdWrapper.TAG, "onAdImpression: ");
                HWRecyclerAdWrapper.this.hasExposed = true;
                HWRecyclerAdWrapper.this.getLoaderListener().onAdExposure();
                try {
                    HWNativeAdData hWNativeAdData = (HWNativeAdData) arrayList.get(0);
                    if (hWNativeAdData.getRecylcerAdInteractionListener() != null) {
                        hWNativeAdData.getRecylcerAdInteractionListener().onAdExposure();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdLoaded() {
                if (arrayList.size() > 0) {
                    HWRecyclerAdWrapper.this.getLoaderListener().onAdLoaded(arrayList);
                    HWRecyclerAdWrapper.this.getLoaderListener().onAdReady(arrayList);
                }
            }
        });
        NativeAdLoader nativeAdLoaderBuild = builder.build();
        AdParam.Builder builder2 = new AdParam.Builder();
        if (this.isBidding) {
            try {
                builder2.addBiddingParamMap(getSdkAdInfo().getPid(), new BiddingParam.Builder().setBidFloor(Float.valueOf(getSdkAdInfo().getPrice() / 100.0f)).setBidFloorCur(Constant.KEY_CURRENCYTYPE_CNY).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
            builder2.setTMax(3000);
        }
        builder2.setSupportTemplate(true);
        nativeAdLoaderBuild.loadAd(builder2.build());
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        com.meishu.sdk.core.loader.a.a(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), h0.a(getSdkAdInfo().getReq()));
        try {
            loadNativeAD(((RecyclerMixAdLoader) this.adLoader).getFetchCount() <= 0 ? 1 : ((RecyclerMixAdLoader) this.adLoader).getFetchCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        BiddingInfo biddingInfo;
        try {
            NativeAd nativeAd = this.mNativeAd;
            if (nativeAd != null && (biddingInfo = nativeAd.getBiddingInfo()) != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put("SECOND_PRICE", Float.valueOf((t0.a((int) (biddingInfo.getPrice().floatValue() * 100.0f), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice()) * 1.0f) / 100.0f));
                    map.put("AUCTION_CURRENCY", Constant.KEY_CURRENCYTYPE_CNY);
                    this.mNativeAd.sendBiddingSuccess(map, new ReportUrlListener() { // from class: com.meishu.sdk.platform.huawei.recycler.HWRecyclerAdWrapper.3
                        @Override // com.huawei.hms.ads.ReportUrlListener
                        public void reportFailed(String str, int i2) {
                        }

                        @Override // com.huawei.hms.ads.ReportUrlListener
                        public void reportSuccess() {
                        }
                    });
                } else {
                    HashMap map2 = new HashMap();
                    map2.put("AUCTION_PRICE", Float.valueOf((i * 1.0f) / 100.0f));
                    map2.put("AUCTION_CURRENCY", Constant.KEY_CURRENCYTYPE_CNY);
                    map2.put("AUCTION_LOSS", 102);
                    map2.put("AUCTION_CP_ID", "100");
                    this.mNativeAd.sendBiddingFailed(map2, new ReportUrlListener() { // from class: com.meishu.sdk.platform.huawei.recycler.HWRecyclerAdWrapper.4
                        @Override // com.huawei.hms.ads.ReportUrlListener
                        public void reportFailed(String str, int i2) {
                        }

                        @Override // com.huawei.hms.ads.ReportUrlListener
                        public void reportSuccess() {
                        }
                    });
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
