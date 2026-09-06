package com.meishu.sdk.platform.sigmob.custom.interstitial;

import android.app.Activity;
import com.meishu.sdk.platform.custom.interstitial.MsCustomInterstitialAd;
import com.meishu.sdk.platform.custom.interstitial.MsCustomInterstitialAdapter;
import com.sigmob.windad.newInterstitial.WindNewInterstitialAd;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SigmobCustomInterstitialAd extends MsCustomInterstitialAd {
    private MsCustomInterstitialAdapter adWrapper;
    private WindNewInterstitialAd windNewInterstitialAd;

    public SigmobCustomInterstitialAd(MsCustomInterstitialAdapter msCustomInterstitialAdapter, WindNewInterstitialAd windNewInterstitialAd) {
        super(msCustomInterstitialAdapter);
        this.adWrapper = msCustomInterstitialAdapter;
        this.windNewInterstitialAd = windNewInterstitialAd;
    }

    @Override // com.meishu.sdk.platform.custom.interstitial.MsCustomInterstitialAd, com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd() {
        WindNewInterstitialAd windNewInterstitialAd = this.windNewInterstitialAd;
        if (windNewInterstitialAd == null || !windNewInterstitialAd.isReady()) {
            return;
        }
        try {
            MsCustomInterstitialAdapter msCustomInterstitialAdapter = this.adWrapper;
            if (msCustomInterstitialAdapter != null && msCustomInterstitialAdapter.getSdkAdInfo() != null && "bidding".equals(this.adWrapper.getSdkAdInfo().getOtype())) {
                WindNewInterstitialAd windNewInterstitialAd2 = this.windNewInterstitialAd;
                windNewInterstitialAd2.setBidEcpm(Integer.parseInt(windNewInterstitialAd2.getEcpm()));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.windNewInterstitialAd.show((HashMap) null);
        super.showAd();
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd(Activity activity) {
        WindNewInterstitialAd windNewInterstitialAd = this.windNewInterstitialAd;
        if (windNewInterstitialAd == null || !windNewInterstitialAd.isReady()) {
            return;
        }
        try {
            MsCustomInterstitialAdapter msCustomInterstitialAdapter = this.adWrapper;
            if (msCustomInterstitialAdapter != null && msCustomInterstitialAdapter.getSdkAdInfo() != null && "bidding".equals(this.adWrapper.getSdkAdInfo().getOtype())) {
                WindNewInterstitialAd windNewInterstitialAd2 = this.windNewInterstitialAd;
                windNewInterstitialAd2.setBidEcpm(Integer.parseInt(windNewInterstitialAd2.getEcpm()));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.windNewInterstitialAd.show((HashMap) null);
        super.showAd(activity);
    }
}
