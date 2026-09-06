package com.hihonor.adsdk.banner.api;

import android.content.Context;
import android.util.AttributeSet;
import com.hihonor.adsdk.base.api.banner.BannerExpressAd;
import com.hihonor.adsdk.base.widget.base.AdRootView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class BannerAdRootView extends AdRootView<BannerExpressAdImpl> {
    public BannerAdRootView(Context context) {
        super(context);
    }

    @Override // com.hihonor.adsdk.base.widget.base.AdRootView, com.hihonor.adsdk.base.widget.base.BaseAdView
    protected void initView() {
    }

    public void setAd(BannerExpressAd bannerExpressAd) {
        if (bannerExpressAd instanceof BannerExpressAdImpl) {
            bindAd((BannerExpressAdImpl) bannerExpressAd);
            requestLayout();
        }
    }

    public BannerAdRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
