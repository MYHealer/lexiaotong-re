package com.meishu.sdk.platform.jd.banner;

import android.view.ViewGroup;
import com.jd.ad.sdk.banner.JADBanner;
import com.meishu.sdk.core.ad.banner.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class JDBannerAd extends a {
    private JDBannerAdWrapper adWrapper;
    private JADBanner bannerAd;

    public JDBannerAd(JDBannerAdWrapper jDBannerAdWrapper) {
        super(jDBannerAdWrapper, "JD");
        this.adWrapper = jDBannerAdWrapper;
    }

    public JADBanner getBannerAd() {
        return this.bannerAd;
    }

    public void setJDBanner(JADBanner jADBanner) {
        this.bannerAd = jADBanner;
    }

    @Override // com.meishu.sdk.core.ad.banner.a, com.meishu.sdk.core.ad.banner.IBannerAd
    public void showAd(ViewGroup viewGroup) {
        try {
            if (getAdView() == null) {
                return;
            }
            if (getAdView().getParent() != null) {
                ((ViewGroup) getAdView().getParent()).removeView(getAdView());
            }
            viewGroup.removeAllViews();
            ViewGroup.LayoutParams layoutParams = getAdView().getLayoutParams();
            layoutParams.width = -1;
            getAdView().setLayoutParams(layoutParams);
            viewGroup.addView(getAdView());
            super.showAd(viewGroup);
        } catch (Throwable unused) {
        }
    }
}
