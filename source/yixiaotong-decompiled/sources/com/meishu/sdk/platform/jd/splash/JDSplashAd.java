package com.meishu.sdk.platform.jd.splash;

import android.view.ViewGroup;
import com.jd.ad.sdk.splash.JADSplash;
import com.meishu.sdk.core.ad.splash.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class JDSplashAd extends c {
    private JDSplashAdWrapper adWrapper;
    private ViewGroup container;
    private boolean showed;
    private JADSplash splashAd;

    public JDSplashAd(JDSplashAdWrapper jDSplashAdWrapper, ViewGroup viewGroup) {
        super(jDSplashAdWrapper, "JD");
        this.adWrapper = jDSplashAdWrapper;
        this.container = viewGroup;
    }

    public JADSplash getSplashAd() {
        return this.splashAd;
    }

    public void setSplashAD(JADSplash jADSplash) {
        this.splashAd = jADSplash;
    }

    @Override // com.meishu.sdk.core.ad.splash.c, com.meishu.sdk.core.ad.splash.ISplashAd
    public void showAd(ViewGroup viewGroup) {
        if (this.showed) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(this.adView, -1, -1);
        this.showed = true;
        super.showAd(viewGroup);
    }
}
