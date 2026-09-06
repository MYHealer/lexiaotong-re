package com.meishu.sdk.platform.csj.banner;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.banner.a;
import com.meishu.sdk.core.ad.banner.b;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.j0;
import com.meishu.sdk.core.utils.o1;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJBannerAd extends a {
    private TTNativeExpressAd ad;
    private CSJBannerAdWrapper adNativeWrapper;
    private b bannerAdListener;
    private SdkAdInfo sdkAdInfo;

    public CSJBannerAd(SdkAdInfo sdkAdInfo, b bVar, CSJBannerAdWrapper cSJBannerAdWrapper, TTNativeExpressAd tTNativeExpressAd) {
        super(cSJBannerAdWrapper, MSAdConfig.PLATFORM_CSJ);
        this.sdkAdInfo = sdkAdInfo;
        this.bannerAdListener = bVar;
        this.adNativeWrapper = cSJBannerAdWrapper;
        this.ad = tTNativeExpressAd;
    }

    public b getBannerAdListener() {
        return this.bannerAdListener;
    }

    public SdkAdInfo getSdkAdInfo() {
        return this.sdkAdInfo;
    }

    @Override // com.meishu.sdk.core.ad.banner.a, com.meishu.sdk.core.ad.banner.IBannerAd
    public void showAd(ViewGroup viewGroup) {
        try {
            TTNativeExpressAd tTNativeExpressAd = this.ad;
            if (tTNativeExpressAd != null) {
                if (j0.b) {
                    setAdView(tTNativeExpressAd.getExpressAdView());
                }
                this.ad.setDislikeCallback((Activity) this.adNativeWrapper.getContext(), new CSJBannerDisLikeCallback(this.adNativeWrapper, this.ad, this));
            }
            View view = this.adView;
            if (view == null) {
                return;
            }
            if (view.getParent() != null && (this.adView.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.adView.getParent()).removeView(this.adView);
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(this.adView);
            }
            super.showAd(viewGroup);
            o1.a(viewGroup, this.adNativeWrapper.getAdLoader().getPosId(), this.sdkAdInfo.getMsLoadedTime());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.banner.a, com.meishu.sdk.core.ad.banner.IBannerAd
    public void showAd(Activity activity, ViewGroup viewGroup) {
        try {
            TTNativeExpressAd tTNativeExpressAd = this.ad;
            if (tTNativeExpressAd != null && activity != null) {
                tTNativeExpressAd.setDislikeCallback(activity, new CSJBannerDisLikeCallback(this.adNativeWrapper, tTNativeExpressAd, this));
            }
            TTNativeExpressAd tTNativeExpressAd2 = this.ad;
            if (tTNativeExpressAd2 != null && j0.b) {
                setAdView(tTNativeExpressAd2.getExpressAdView());
            }
            View view = this.adView;
            if (view == null) {
                return;
            }
            if (view.getParent() != null && (this.adView.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.adView.getParent()).removeView(this.adView);
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(this.adView);
            }
            super.showAd(activity, viewGroup);
            o1.a(viewGroup, this.adNativeWrapper.getAdLoader().getPosId(), this.sdkAdInfo.getMsLoadedTime());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
