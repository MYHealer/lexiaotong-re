package com.hihonor.adsdk.splash.view;

import android.content.Context;
import android.util.AttributeSet;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.splash.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class VerticalSpImageAdView extends BaseSplashAdView {
    public VerticalSpImageAdView(Context context) {
        super(context);
    }

    @Override // com.hihonor.adsdk.splash.view.BaseSplashAdView
    protected int getContentView() {
        return R.layout.honor_ads_view_splash_image_ad;
    }

    @Override // com.hihonor.adsdk.splash.view.BaseSplashAdView
    protected void m() {
        BaseAd baseAd = this.f3585a;
        if (baseAd != null) {
            setImageView(baseAd);
        }
    }

    public VerticalSpImageAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VerticalSpImageAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
