package com.meishu.sdk.platform.bd.splash;

import android.view.ViewGroup;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.splash.c;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.meishu_ad.splash.SplashSkipView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BDNativeSplashAd extends c {
    private BDSplashAdLoader adWrapper;
    private boolean showed;
    private SplashSkipView splashSkipView;

    public BDNativeSplashAd(BDSplashAdLoader bDSplashAdLoader) {
        super(bDSplashAdLoader, MSAdConfig.PLATFORM_BD);
        this.adWrapper = bDSplashAdLoader;
    }

    public void setSkipView(SplashSkipView splashSkipView) {
        this.splashSkipView = splashSkipView;
    }

    @Override // com.meishu.sdk.core.ad.splash.c, com.meishu.sdk.core.ad.splash.ISplashAd
    public void showAd(ViewGroup viewGroup) {
        try {
            if (this.showed || this.adView == null) {
                return;
            }
            viewGroup.removeAllViews();
            viewGroup.addView(this.adView, -1, -1);
            this.showed = true;
            SplashSkipView splashSkipView = this.splashSkipView;
            if (splashSkipView != null) {
                splashSkipView.c();
            }
            super.showAd(viewGroup);
            o1.a(viewGroup, this.adWrapper.getAdLoader().getPosId(), this.adWrapper.getSdkAdInfo().getMsLoadedTime());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
