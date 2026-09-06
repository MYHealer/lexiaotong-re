package com.meishu.sdk.platform.pangle.banner;

import android.app.Activity;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.meishu.sdk.platform.custom.banner.MsCustomBannerAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class PangleBannerAd extends MsCustomBannerAd {
    private PAGBannerAd bannerAd;

    public PangleBannerAd(PangleBannerAdapter pangleBannerAdapter, PAGBannerAd pAGBannerAd) {
        super(pangleBannerAdapter);
        this.bannerAd = pAGBannerAd;
    }

    @Override // com.meishu.sdk.core.ad.banner.a, com.meishu.sdk.core.ad.banner.IBannerAd
    public void showAd(Activity activity, ViewGroup viewGroup) {
        if (this.adView.getParent() != null && (this.adView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.adView.getParent()).removeView(this.adView);
        }
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            viewGroup.addView(this.adView);
        }
        super.showAd(activity, viewGroup);
    }

    @Override // com.meishu.sdk.core.ad.banner.a, com.meishu.sdk.core.ad.banner.IBannerAd
    public void showAd(ViewGroup viewGroup) {
        if (this.adView.getParent() != null && (this.adView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.adView.getParent()).removeView(this.adView);
        }
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            viewGroup.addView(this.adView);
        }
        super.showAd(viewGroup);
    }
}
