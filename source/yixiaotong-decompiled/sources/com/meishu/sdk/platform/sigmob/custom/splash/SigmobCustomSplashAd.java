package com.meishu.sdk.platform.sigmob.custom.splash;

import android.view.ViewGroup;
import com.meishu.sdk.platform.custom.splash.MsCustomSplashAd;
import com.meishu.sdk.platform.custom.splash.MsCustomSplashAdapter;
import com.sigmob.windad.Splash.WindSplashAD;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SigmobCustomSplashAd extends MsCustomSplashAd {
    private MsCustomSplashAdapter adWrapper;
    private WindSplashAD mWindSplashAD;

    public SigmobCustomSplashAd(MsCustomSplashAdapter msCustomSplashAdapter) {
        super(msCustomSplashAdapter);
        this.adWrapper = msCustomSplashAdapter;
    }

    public void setSplashAD(WindSplashAD windSplashAD) {
        this.mWindSplashAD = windSplashAD;
    }

    @Override // com.meishu.sdk.core.ad.splash.c, com.meishu.sdk.core.ad.splash.ISplashAd
    public void showAd(ViewGroup viewGroup) {
        if (this.mWindSplashAD != null) {
            try {
                MsCustomSplashAdapter msCustomSplashAdapter = this.adWrapper;
                if (msCustomSplashAdapter != null && msCustomSplashAdapter.getSdkAdInfo() != null && "bidding".equals(this.adWrapper.getSdkAdInfo().getOtype())) {
                    WindSplashAD windSplashAD = this.mWindSplashAD;
                    windSplashAD.setBidEcpm(Integer.parseInt(windSplashAD.getEcpm()));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.mWindSplashAD.show(viewGroup);
            super.showAd(viewGroup);
        }
    }
}
