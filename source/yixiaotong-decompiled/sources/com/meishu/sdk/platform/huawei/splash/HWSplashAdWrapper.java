package com.meishu.sdk.platform.huawei.splash;

import android.os.Handler;
import android.text.TextUtils;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.BiddingParam;
import com.huawei.hms.ads.ReportUrlListener;
import com.huawei.hms.ads.splash.SplashAd;
import com.huawei.hms.ads.splash.SplashAdDisplayListener;
import com.huawei.hms.ads.splash.SplashView;
import com.huawei.hms.ads.splash.listener.SplashListener;
import com.huawei.hms.ads.splash.listener.SplashLoadListener;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.ad.splash.d;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.a;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.huawei.HWPlatformError;
import com.unionpay.tsmservice.data.Constant;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HWSplashAdWrapper extends BasePlatformLoader<SplashAdLoader, d> {
    private static final String TAG = "HWSplashAdWrapper";
    private HWBiddingSplashAd biddingSplashAd;
    private HWSplashAd hwSplashAd;
    private boolean isAdClosed;
    private boolean isAdShowed;
    private SplashAd splashAd;

    /* JADX INFO: renamed from: com.meishu.sdk.platform.huawei.splash.HWSplashAdWrapper$2, reason: invalid class name */
    public class AnonymousClass2 implements SplashLoadListener {
        public AnonymousClass2() {
        }

        @Override // com.huawei.hms.ads.splash.listener.SplashLoadListener
        public void onAdFailed(int i) {
            new HWPlatformError("加载出错,code=" + i, i, HWSplashAdWrapper.this.getSdkAdInfo()).post(HWSplashAdWrapper.this.loadListener);
        }

        @Override // com.huawei.hms.ads.splash.listener.SplashLoadListener
        public void onAdLoaded() {
            try {
                HWSplashAdWrapper hWSplashAdWrapper = HWSplashAdWrapper.this;
                hWSplashAdWrapper.biddingSplashAd = new HWBiddingSplashAd(hWSplashAdWrapper, hWSplashAdWrapper.splashAd);
                try {
                    if (HWSplashAdWrapper.this.getSdkAdInfo() != null) {
                        HWSplashAdWrapper.this.getSdkAdInfo().setEcpm(String.valueOf((int) (HWSplashAdWrapper.this.splashAd.getBiddingInfo().getPrice().floatValue() * 100.0f)));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                SplashView splashViewM974getSplashView = HWSplashAdWrapper.this.splashAd.m974getSplashView();
                HWSplashAdWrapper.this.biddingSplashAd.setAdView(splashViewM974getSplashView);
                splashViewM974getSplashView.setAdDisplayListener(new SplashAdDisplayListener() { // from class: com.meishu.sdk.platform.huawei.splash.HWSplashAdWrapper.2.1
                    @Override // com.huawei.hms.ads.splash.SplashAdDisplayListener
                    public void onAdClick() {
                        if (HWSplashAdWrapper.this.getSdkAdInfo() != null && !TextUtils.isEmpty(HWSplashAdWrapper.this.getSdkAdInfo().getClk())) {
                            LogUtil.d(HWSplashAdWrapper.TAG, "send onAdClicked");
                            a.a(HWSplashAdWrapper.this.getContext(), f.a(HWSplashAdWrapper.this.getSdkAdInfo().getClk(), HWSplashAdWrapper.this.biddingSplashAd));
                            HWSplashAdWrapper.this.getSdkAdInfo().getMsLoadedTime();
                            HWSplashAdWrapper.this.getAdLoader().getPosId();
                        }
                        if (HWSplashAdWrapper.this.biddingSplashAd != null && HWSplashAdWrapper.this.biddingSplashAd.getInteractionListener() != null) {
                            HWSplashAdWrapper.this.biddingSplashAd.getInteractionListener().onAdClicked();
                        }
                        SdkHandler.getInstance().postDelay(new l() { // from class: com.meishu.sdk.platform.huawei.splash.HWSplashAdWrapper.2.1.1
                            @Override // com.meishu.sdk.core.safe.l
                            public void safeRun() {
                                if (HWSplashAdWrapper.this.getLoaderListener() != null) {
                                    HWSplashAdWrapper.this.getLoaderListener().onAdClosed();
                                }
                                if (HWSplashAdWrapper.this.biddingSplashAd == null || HWSplashAdWrapper.this.biddingSplashAd.getInteractionListener() == null) {
                                    return;
                                }
                                HWSplashAdWrapper.this.biddingSplashAd.getInteractionListener().onAdClosed();
                            }
                        }, 1500L);
                    }
                });
                if (HWSplashAdWrapper.this.getLoaderListener() != null) {
                    HWSplashAdWrapper.this.getLoaderListener().onAdLoaded(HWSplashAdWrapper.this.biddingSplashAd);
                    HWSplashAdWrapper.this.getLoaderListener().onAdReady(HWSplashAdWrapper.this.biddingSplashAd);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.meishu.sdk.platform.huawei.splash.HWSplashAdWrapper$3, reason: invalid class name */
    public class AnonymousClass3 extends SplashView.SplashAdLoadListener {
        public final /* synthetic */ SplashView val$splashView;

        public AnonymousClass3(SplashView splashView) {
            this.val$splashView = splashView;
        }

        @Override // com.huawei.hms.ads.splash.SplashView.SplashAdLoadListener
        public void onAdDismissed() {
            LogUtil.e(HWSplashAdWrapper.TAG, "onAdDismissed: ");
            HWSplashAdWrapper.this.isAdClosed = true;
            if (HWSplashAdWrapper.this.isAdShowed) {
                new Handler().postDelayed(new l() { // from class: com.meishu.sdk.platform.huawei.splash.HWSplashAdWrapper.3.2
                    @Override // com.meishu.sdk.core.safe.l
                    public void safeRun() {
                        if (HWSplashAdWrapper.this.getLoaderListener() != null) {
                            HWSplashAdWrapper.this.getLoaderListener().onAdClosed();
                        }
                        if (HWSplashAdWrapper.this.hwSplashAd == null || HWSplashAdWrapper.this.hwSplashAd.getInteractionListener() == null) {
                            return;
                        }
                        HWSplashAdWrapper.this.hwSplashAd.getInteractionListener().onAdClosed();
                    }
                }, 800L);
            }
        }

        @Override // com.huawei.hms.ads.splash.SplashView.SplashAdLoadListener
        public void onAdFailedToLoad(int i) {
            LogUtil.e(HWSplashAdWrapper.TAG, "onAdFailedToLoad: " + i);
            new HWPlatformError("加载出错", i, HWSplashAdWrapper.this.getSdkAdInfo()).post(HWSplashAdWrapper.this.loadListener);
        }

        @Override // com.huawei.hms.ads.splash.SplashView.SplashAdLoadListener
        public void onAdLoaded() {
            HWSplashAdWrapper hWSplashAdWrapper = HWSplashAdWrapper.this;
            hWSplashAdWrapper.hwSplashAd = new HWSplashAd(hWSplashAdWrapper);
            HWSplashAdWrapper.this.hwSplashAd.setOnAdShowListener(new HWSplashAd.IAdShowListener() { // from class: com.meishu.sdk.platform.huawei.splash.HWSplashAdWrapper.3.1
                @Override // com.meishu.sdk.platform.huawei.splash.HWSplashAd.IAdShowListener
                public void onShow() {
                    HWSplashAdWrapper.this.isAdShowed = true;
                    if (HWSplashAdWrapper.this.isAdClosed) {
                        new Handler().postDelayed(new l() { // from class: com.meishu.sdk.platform.huawei.splash.HWSplashAdWrapper.3.1.1
                            @Override // com.meishu.sdk.core.safe.l
                            public void safeRun() {
                                if (HWSplashAdWrapper.this.getLoaderListener() != null) {
                                    HWSplashAdWrapper.this.getLoaderListener().onAdClosed();
                                }
                                if (HWSplashAdWrapper.this.hwSplashAd == null || HWSplashAdWrapper.this.hwSplashAd.getInteractionListener() == null) {
                                    return;
                                }
                                HWSplashAdWrapper.this.hwSplashAd.getInteractionListener().onAdClosed();
                            }
                        }, 800L);
                    }
                }
            });
            HWSplashAdWrapper.this.hwSplashAd.setAdView(this.val$splashView);
            if (HWSplashAdWrapper.this.getLoaderListener() != null) {
                HWSplashAdWrapper.this.getLoaderListener().onAdLoaded(HWSplashAdWrapper.this.hwSplashAd);
                HWSplashAdWrapper.this.getLoaderListener().onAdReady(HWSplashAdWrapper.this.hwSplashAd);
            }
        }
    }

    public HWSplashAdWrapper(SplashAdLoader splashAdLoader, SdkAdInfo sdkAdInfo) {
        super(splashAdLoader, sdkAdInfo);
    }

    private void loadBiddingAd() {
        AdParam.Builder builder = new AdParam.Builder();
        try {
            builder.addBiddingParamMap(getSdkAdInfo().getPid(), new BiddingParam.Builder().setBidFloor(Float.valueOf(getSdkAdInfo().getPrice() / 100.0f)).setBidFloorCur(Constant.KEY_CURRENCYTYPE_CNY).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        builder.setTMax(3000);
        SplashAd splashAd = new SplashAd(this.context);
        this.splashAd = splashAd;
        splashAd.setAdParam(getSdkAdInfo().getPid(), 1, builder.build());
        this.splashAd.setAudioFocusType(1);
        this.splashAd.setSplashListener(new SplashListener() { // from class: com.meishu.sdk.platform.huawei.splash.HWSplashAdWrapper.1
            @Override // com.huawei.hms.ads.splash.listener.SplashListener
            public void onAdDismissed() {
                LogUtil.d(HWSplashAdWrapper.TAG, "onAdDismissed");
                if (HWSplashAdWrapper.this.getLoaderListener() != null) {
                    HWSplashAdWrapper.this.getLoaderListener().onAdClosed();
                }
                if (HWSplashAdWrapper.this.biddingSplashAd == null || HWSplashAdWrapper.this.biddingSplashAd.getInteractionListener() == null) {
                    return;
                }
                HWSplashAdWrapper.this.biddingSplashAd.getInteractionListener().onAdClosed();
            }

            @Override // com.huawei.hms.ads.splash.listener.SplashListener
            public void onAdError(int i) {
            }

            @Override // com.huawei.hms.ads.splash.listener.SplashListener
            public void onAdShowStart() {
                LogUtil.d(HWSplashAdWrapper.TAG, "onAdShowStart");
                if (HWSplashAdWrapper.this.getLoaderListener() != null) {
                    HWSplashAdWrapper.this.getLoaderListener().onAdExposure();
                }
                if (HWSplashAdWrapper.this.biddingSplashAd == null || HWSplashAdWrapper.this.biddingSplashAd.getInteractionListener() == null) {
                    return;
                }
                HWSplashAdWrapper.this.biddingSplashAd.getInteractionListener().onAdExposure();
            }
        });
        this.splashAd.loadAd(new AnonymousClass2());
    }

    private void loadNormalAd() {
        SplashView splashView = new SplashView(((SplashAdLoader) this.adLoader).getContext());
        AdParam adParamBuild = new AdParam.Builder().build();
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(splashView);
        splashView.setAdDisplayListener(new SplashAdDisplayListener() { // from class: com.meishu.sdk.platform.huawei.splash.HWSplashAdWrapper.4
            @Override // com.huawei.hms.ads.splash.SplashAdDisplayListener
            public void onAdClick() {
                LogUtil.e(HWSplashAdWrapper.TAG, "onAdClick: ");
                if (HWSplashAdWrapper.this.isAdShowed) {
                    if (HWSplashAdWrapper.this.getSdkAdInfo() != null && !TextUtils.isEmpty(HWSplashAdWrapper.this.getSdkAdInfo().getClk())) {
                        LogUtil.d(HWSplashAdWrapper.TAG, "send onAdClicked");
                        a.a(HWSplashAdWrapper.this.getContext(), f.a(HWSplashAdWrapper.this.getSdkAdInfo().getClk(), HWSplashAdWrapper.this.hwSplashAd));
                        HWSplashAdWrapper.this.getSdkAdInfo().getMsLoadedTime();
                        HWSplashAdWrapper.this.getAdLoader().getPosId();
                    }
                    if (HWSplashAdWrapper.this.hwSplashAd != null && HWSplashAdWrapper.this.hwSplashAd.getInteractionListener() != null) {
                        HWSplashAdWrapper.this.hwSplashAd.getInteractionListener().onAdClicked();
                    }
                    if (HWSplashAdWrapper.this.getLoaderListener() != null) {
                        HWSplashAdWrapper.this.getLoaderListener().onAdClosed();
                    }
                    if (HWSplashAdWrapper.this.hwSplashAd == null || HWSplashAdWrapper.this.hwSplashAd.getInteractionListener() == null) {
                        return;
                    }
                    HWSplashAdWrapper.this.hwSplashAd.getInteractionListener().onAdClosed();
                }
            }

            @Override // com.huawei.hms.ads.splash.SplashAdDisplayListener
            public void onAdShowed() {
                LogUtil.e(HWSplashAdWrapper.TAG, "onAdShowed: ");
            }
        });
        splashView.setAudioFocusType(1);
        splashView.load(getSdkAdInfo().getPid(), 1, adParamBuild, anonymousClass3);
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        a.a(((SplashAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()));
        loadBiddingAd();
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        BiddingInfo biddingInfo;
        try {
            SplashAd splashAd = this.splashAd;
            if (splashAd != null && (biddingInfo = splashAd.getBiddingInfo()) != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put("SECOND_PRICE", Float.valueOf((t0.a((int) (biddingInfo.getPrice().floatValue() * 100.0f), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice()) * 1.0f) / 100.0f));
                    map.put("AUCTION_CURRENCY", Constant.KEY_CURRENCYTYPE_CNY);
                    this.splashAd.sendBiddingSuccess(map, new ReportUrlListener() { // from class: com.meishu.sdk.platform.huawei.splash.HWSplashAdWrapper.5
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
                    this.splashAd.sendBiddingFailed(map2, new ReportUrlListener() { // from class: com.meishu.sdk.platform.huawei.splash.HWSplashAdWrapper.6
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
