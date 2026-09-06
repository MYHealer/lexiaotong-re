package com.hihonor.adsdk.interstitial;

import com.hihonor.adsdk.base.api.interstitial.InterstitialAdLoadListener;
import com.hihonor.adsdk.base.api.interstitial.InterstitialExpressAd;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d extends com.hihonor.adsdk.base.mediation.core.imp.c<InterstitialExpressAd, c> {
    private static final String b = "InterstitialManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterstitialAdLoadListener f3533a;

    public d(InterstitialAdLoadListener interstitialAdLoadListener) {
        this.f3533a = interstitialAdLoadListener;
    }

    @Override // com.hihonor.adsdk.base.mediation.core.imp.c
    protected void hnadsa(List<InterstitialExpressAd> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(b, "callBackSuccess", new Object[0]);
        if (this.f3533a != null) {
            hnadsa((List) list, true);
            this.f3533a.onAdLoaded(list.get(0));
        }
        a.a().a(this.hnadsa.getSlotId());
    }

    @Override // com.hihonor.adsdk.base.mediation.core.imp.c
    public int hnadsd() {
        return 5;
    }

    @Override // com.hihonor.adsdk.base.mediation.core.imp.c
    protected void hnadsa(String str, String str2) {
        com.hihonor.adsdk.common.b.b.hnadsc(b, "callBackFail errorCode:" + str + "; errorMsg:" + str2, new Object[0]);
        if (this.f3533a != null) {
            hnadsb(str, str2);
            this.f3533a.onFailed(str, str2);
        }
        a.a().a(this.hnadsa.getSlotId());
    }
}
