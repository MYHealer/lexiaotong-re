package com.meishu.sdk.platform.huawei.banner;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.banner.BannerView;
import com.meishu.sdk.core.ad.banner.BannerAdLoader;
import com.meishu.sdk.core.ad.banner.b;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.huawei.HWPlatformError;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HWBannerAdWrapper extends BasePlatformLoader<BannerAdLoader, b> {
    private static final String TAG = "HWBannerAdWrapper";
    private HWBannerAd hwBannerAd;
    private boolean isExposured;

    public HWBannerAdWrapper(BannerAdLoader bannerAdLoader, SdkAdInfo sdkAdInfo) {
        super(bannerAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        z.a(StubApp.getOrigApplicationContext(((BannerAdLoader) this.adLoader).getContext().getApplicationContext()), h0.a(getSdkAdInfo().getReq()), new i());
        SdkHandler.runOnMainThread(new Runnable() { // from class: com.meishu.sdk.platform.huawei.banner.HWBannerAdWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                final BannerView bannerView = new BannerView(((BannerAdLoader) HWBannerAdWrapper.this.adLoader).getContext());
                bannerView.setAdId(HWBannerAdWrapper.this.getSdkAdInfo().getPid());
                bannerView.setBannerAdSize(BannerAdSize.BANNER_SIZE_360_57);
                bannerView.setBannerRefresh(0L);
                AdParam adParamBuild = new AdParam.Builder().build();
                bannerView.setAdListener(new AdListener() { // from class: com.meishu.sdk.platform.huawei.banner.HWBannerAdWrapper.1.1
                    @Override // com.huawei.hms.ads.AdListener
                    public void onAdClicked() {
                        Log.e(HWBannerAdWrapper.TAG, "onAdClicked: ");
                        if (!TextUtils.isEmpty(HWBannerAdWrapper.this.getSdkAdInfo().getClk()) && HWBannerAdWrapper.this.hwBannerAd != null) {
                            LogUtil.d(HWBannerAdWrapper.TAG, "send onAdClicked");
                            a.a(HWBannerAdWrapper.this.getContext(), f.a(HWBannerAdWrapper.this.getSdkAdInfo().getClk(), HWBannerAdWrapper.this.hwBannerAd));
                        }
                        if (HWBannerAdWrapper.this.hwBannerAd.getInteractionListener() != null) {
                            HWBannerAdWrapper.this.hwBannerAd.getInteractionListener().onAdClicked();
                        }
                    }

                    @Override // com.huawei.hms.ads.AdListener
                    public void onAdClosed() {
                        Log.e(HWBannerAdWrapper.TAG, "onAdClosed: ");
                        if (HWBannerAdWrapper.this.getLoaderListener() != null) {
                            HWBannerAdWrapper.this.getLoaderListener().onAdClosed();
                        }
                        if (HWBannerAdWrapper.this.hwBannerAd.getInteractionListener() != null) {
                            HWBannerAdWrapper.this.hwBannerAd.getInteractionListener().onAdClosed();
                        }
                    }

                    @Override // com.huawei.hms.ads.AdListener
                    public void onAdFailed(int i) {
                        LogUtil.e(HWBannerAdWrapper.TAG, "onAdFailed: errorCode=" + i);
                        new HWPlatformError("加载出错", i, HWBannerAdWrapper.this.getSdkAdInfo()).post(HWBannerAdWrapper.this.loadListener);
                    }

                    @Override // com.huawei.hms.ads.AdListener
                    public void onAdImpression() {
                        if (HWBannerAdWrapper.this.getLoaderListener() == null || HWBannerAdWrapper.this.isExposured) {
                            return;
                        }
                        HWBannerAdWrapper.this.isExposured = true;
                        HWBannerAdWrapper.this.getLoaderListener().onAdExposure();
                        if (HWBannerAdWrapper.this.hwBannerAd.getInteractionListener() != null) {
                            HWBannerAdWrapper.this.hwBannerAd.getInteractionListener().onAdExposure();
                        }
                    }

                    @Override // com.huawei.hms.ads.AdListener
                    public void onAdLeave() {
                    }

                    @Override // com.huawei.hms.ads.AdListener
                    public void onAdLoaded() {
                        HWBannerAdWrapper hWBannerAdWrapper = HWBannerAdWrapper.this;
                        hWBannerAdWrapper.hwBannerAd = new HWBannerAd(hWBannerAdWrapper, bannerView);
                        HWBannerAdWrapper.this.hwBannerAd.setAdView(bannerView);
                        if (HWBannerAdWrapper.this.getLoaderListener() != null) {
                            HWBannerAdWrapper.this.getLoaderListener().onAdLoaded(HWBannerAdWrapper.this.hwBannerAd);
                            HWBannerAdWrapper.this.getLoaderListener().onAdReady(HWBannerAdWrapper.this.hwBannerAd);
                        }
                    }

                    @Override // com.huawei.hms.ads.AdListener
                    public void onAdOpened() {
                    }
                });
                bannerView.loadAd(adParamBuild);
            }
        });
    }
}
