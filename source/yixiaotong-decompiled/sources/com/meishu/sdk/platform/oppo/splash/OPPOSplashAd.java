package com.meishu.sdk.platform.oppo.splash;

import android.view.ViewGroup;
import com.byazt.bv.BaseConstants;
import com.heytap.msp.mobad.api.ad.SplashAd;
import com.meishu.sdk.core.ad.splash.c;
import com.meishu.sdk.core.loader.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
class OPPOSplashAd extends c {
    private SplashAd splashAd;

    public OPPOSplashAd(d dVar) {
        super(dVar, BaseConstants.ROM_OPPO_UPPER_CONSTANT);
    }

    public void setOPPOSplashAd(SplashAd splashAd) {
        this.splashAd = splashAd;
    }

    @Override // com.meishu.sdk.core.ad.splash.c, com.meishu.sdk.core.ad.splash.ISplashAd
    public void showAd(ViewGroup viewGroup) {
    }

    public void destroy() {
        SplashAd splashAd = this.splashAd;
        if (splashAd != null) {
            splashAd.destroyAd();
        }
    }
}
