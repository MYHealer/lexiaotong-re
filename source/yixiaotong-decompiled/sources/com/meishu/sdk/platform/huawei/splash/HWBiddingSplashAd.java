package com.meishu.sdk.platform.huawei.splash;

import android.view.ViewGroup;
import com.huawei.hms.ads.splash.SplashAd;
import com.meishu.sdk.core.ad.splash.c;
import com.meishu.sdk.core.utils.o1;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HWBiddingSplashAd extends c {
    private final HWSplashAdWrapper adWrapper;
    private boolean showed;
    private final SplashAd splashAd;

    public HWBiddingSplashAd(HWSplashAdWrapper hWSplashAdWrapper, SplashAd splashAd) {
        super(hWSplashAdWrapper, "HW");
        this.adWrapper = hWSplashAdWrapper;
        this.splashAd = splashAd;
    }

    @Override // com.meishu.sdk.core.ad.splash.c, com.meishu.sdk.core.ad.splash.ISplashAd
    public void showAd(ViewGroup viewGroup) {
        if (this.showed || this.adView == null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(this.adView, -1, -1);
        this.showed = true;
        viewGroup.bringToFront();
        SplashAd splashAd = this.splashAd;
        if (splashAd != null) {
            splashAd.showAd(false);
        }
        super.showAd(viewGroup);
        o1.a(viewGroup, this.adWrapper.getAdLoader().getPosId(), this.adWrapper.getSdkAdInfo().getMsLoadedTime());
    }
}
