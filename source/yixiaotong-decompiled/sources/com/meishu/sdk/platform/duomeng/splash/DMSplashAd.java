package com.meishu.sdk.platform.duomeng.splash;

import android.view.ViewGroup;
import com.domob.sdk.platform.interfaces.ad.DMTemplateAd;
import com.meishu.sdk.platform.custom.splash.MsCustomSplashAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class DMSplashAd extends MsCustomSplashAd {
    private DMTemplateAd ad;

    public DMSplashAd(DMSplashAdapter dMSplashAdapter, DMTemplateAd dMTemplateAd) {
        super(dMSplashAdapter);
        this.ad = dMTemplateAd;
    }

    @Override // com.meishu.sdk.core.ad.splash.c, com.meishu.sdk.core.ad.splash.ISplashAd
    public void showAd(ViewGroup viewGroup) {
        DMTemplateAd dMTemplateAd = this.ad;
        if (dMTemplateAd != null) {
            dMTemplateAd.showSplashAd(viewGroup);
        }
        super.showAd(viewGroup);
    }
}
