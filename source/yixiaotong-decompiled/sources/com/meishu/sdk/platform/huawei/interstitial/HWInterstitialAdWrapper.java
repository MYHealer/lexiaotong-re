package com.meishu.sdk.platform.huawei.interstitial;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.BiddingParam;
import com.huawei.hms.ads.InterstitialAd;
import com.huawei.hms.ads.ReportUrlListener;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.ad.interstitial.b;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.huawei.HWPlatformError;
import com.unionpay.tsmservice.data.Constant;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HWInterstitialAdWrapper extends BasePlatformLoader<InterstitialAdLoader, b> {
    private static final String TAG = "HWInterstitialAdWrapper";
    private HWInterstitialAd hwInterstitialAd;
    private InterstitialAd interstitialAd;
    private boolean isBidding;

    public HWInterstitialAdWrapper(InterstitialAdLoader interstitialAdLoader, SdkAdInfo sdkAdInfo) {
        super(interstitialAdLoader, sdkAdInfo);
        this.isBidding = true;
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        z.a(((InterstitialAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
        InterstitialAd interstitialAd = new InterstitialAd(((InterstitialAdLoader) this.adLoader).getContext());
        this.interstitialAd = interstitialAd;
        interstitialAd.setAdId(getSdkAdInfo().getPid());
        AdParam.Builder builder = new AdParam.Builder();
        if (this.isBidding) {
            try {
                builder.addBiddingParamMap(getSdkAdInfo().getPid(), new BiddingParam.Builder().setBidFloor(Float.valueOf(getSdkAdInfo().getPrice() / 100.0f)).setBidFloorCur(Constant.KEY_CURRENCYTYPE_CNY).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
            builder.setTMax(3000);
        }
        AdParam adParamBuild = builder.build();
        this.interstitialAd.setAdListener(new AdListener() { // from class: com.meishu.sdk.platform.huawei.interstitial.HWInterstitialAdWrapper.1
            @Override // com.huawei.hms.ads.AdListener
            public void onAdClicked() {
                if (!TextUtils.isEmpty(HWInterstitialAdWrapper.this.getSdkAdInfo().getClk()) && HWInterstitialAdWrapper.this.hwInterstitialAd != null) {
                    LogUtil.d(HWInterstitialAdWrapper.TAG, "send onAdClicked");
                    a.a(HWInterstitialAdWrapper.this.getContext(), f.a(HWInterstitialAdWrapper.this.getSdkAdInfo().getClk(), HWInterstitialAdWrapper.this.hwInterstitialAd));
                }
                if (HWInterstitialAdWrapper.this.hwInterstitialAd.getInteractionListener() != null) {
                    HWInterstitialAdWrapper.this.hwInterstitialAd.getInteractionListener().onAdClicked();
                }
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdClosed() {
                if (HWInterstitialAdWrapper.this.getLoaderListener() != null) {
                    HWInterstitialAdWrapper.this.getLoaderListener().onAdClosed();
                }
                if (HWInterstitialAdWrapper.this.hwInterstitialAd.getInteractionListener() != null) {
                    HWInterstitialAdWrapper.this.hwInterstitialAd.getInteractionListener().onAdClosed();
                }
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdFailed(int i) {
                LogUtil.e(HWInterstitialAdWrapper.TAG, "onAdFailed: " + i);
                new HWPlatformError("加载出错", i, HWInterstitialAdWrapper.this.getSdkAdInfo()).post(HWInterstitialAdWrapper.this.loadListener);
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdImpression() {
                LogUtil.e(HWInterstitialAdWrapper.TAG, "onAdImpression: ");
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdLeave() {
                Log.e(HWInterstitialAdWrapper.TAG, "onAdLeave: ");
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdLoaded() {
                try {
                    if (HWInterstitialAdWrapper.this.getSdkAdInfo() != null) {
                        HWInterstitialAdWrapper.this.getSdkAdInfo().setEcpm(String.valueOf((int) (HWInterstitialAdWrapper.this.interstitialAd.getBiddingInfo().getPrice().floatValue() * 100.0f)));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                HWInterstitialAdWrapper hWInterstitialAdWrapper = HWInterstitialAdWrapper.this;
                hWInterstitialAdWrapper.hwInterstitialAd = new HWInterstitialAd(hWInterstitialAdWrapper, hWInterstitialAdWrapper.interstitialAd);
                if (HWInterstitialAdWrapper.this.getLoaderListener() != null) {
                    HWInterstitialAdWrapper.this.getLoaderListener().onAdLoaded(HWInterstitialAdWrapper.this.hwInterstitialAd);
                    HWInterstitialAdWrapper.this.getLoaderListener().onAdReady(HWInterstitialAdWrapper.this.hwInterstitialAd);
                }
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdOpened() {
                if (HWInterstitialAdWrapper.this.getLoaderListener() != null) {
                    HWInterstitialAdWrapper.this.getLoaderListener().onAdExposure();
                }
                if (HWInterstitialAdWrapper.this.hwInterstitialAd.getInteractionListener() != null) {
                    HWInterstitialAdWrapper.this.hwInterstitialAd.getInteractionListener().onAdExposure();
                }
            }
        });
        this.interstitialAd.loadAd(adParamBuild);
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        BiddingInfo biddingInfo;
        try {
            InterstitialAd interstitialAd = this.interstitialAd;
            if (interstitialAd != null && (biddingInfo = interstitialAd.getBiddingInfo()) != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put("SECOND_PRICE", Float.valueOf((t0.a((int) (biddingInfo.getPrice().floatValue() * 100.0f), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice()) * 1.0f) / 100.0f));
                    map.put("AUCTION_CURRENCY", Constant.KEY_CURRENCYTYPE_CNY);
                    this.interstitialAd.sendBiddingSuccess(map, new ReportUrlListener() { // from class: com.meishu.sdk.platform.huawei.interstitial.HWInterstitialAdWrapper.2
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
                    this.interstitialAd.sendBiddingFailed(map2, new ReportUrlListener() { // from class: com.meishu.sdk.platform.huawei.interstitial.HWInterstitialAdWrapper.3
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
