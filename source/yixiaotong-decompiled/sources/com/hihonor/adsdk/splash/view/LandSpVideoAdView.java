package com.hihonor.adsdk.splash.view;

import android.content.Context;
import android.util.AttributeSet;
import com.hihonor.adsdk.splash.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class LandSpVideoAdView extends BaseSplashAdView {
    public LandSpVideoAdView(Context context) {
        super(context);
    }

    @Override // com.hihonor.adsdk.splash.view.BaseSplashAdView
    protected int getContentView() {
        return R.layout.honor_ads_view_splash_video_ad_land;
    }

    @Override // com.hihonor.adsdk.splash.view.BaseSplashAdView
    protected void m() {
        setVideoView(1);
        setBackgroundColor(-16777216);
    }

    public LandSpVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LandSpVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
