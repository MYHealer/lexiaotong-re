package com.meishu.sdk.platform.huawei.banner;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.banner.BannerView;
import com.meishu.sdk.core.ad.banner.a;
import com.meishu.sdk.core.loader.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HWBannerAd extends a {
    private static final String TAG = "HWBannerAd";
    private BannerView bannerView;

    public HWBannerAd(d dVar, BannerView bannerView) {
        super(dVar, "HW");
        this.bannerView = bannerView;
    }

    @Override // com.meishu.sdk.core.ad.banner.a, com.meishu.sdk.core.ad.banner.IBannerAd
    public void showAd(Activity activity, ViewGroup viewGroup) {
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
    }

    @Override // com.meishu.sdk.core.ad.banner.a, com.meishu.sdk.core.ad.banner.IBannerAd
    public void showAd(ViewGroup viewGroup) {
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
    }
}
