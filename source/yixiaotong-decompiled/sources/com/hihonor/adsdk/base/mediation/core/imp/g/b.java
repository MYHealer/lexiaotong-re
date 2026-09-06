package com.hihonor.adsdk.base.mediation.core.imp.g;

import com.hihonor.adsdk.base.api.splash.SplashAdLoadListener;
import com.hihonor.adsdk.base.api.splash.SplashExpressAd;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends com.hihonor.adsdk.base.mediation.core.imp.c<SplashExpressAd, a> {
    private static final String hnadsn = "SpManager";
    private SplashAdLoadListener hnadsm;

    public b(SplashAdLoadListener splashAdLoadListener) {
        this.hnadsm = splashAdLoadListener;
    }

    @Override // com.hihonor.adsdk.base.mediation.core.imp.c
    protected void hnadsa(List<SplashExpressAd> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsn, "#callBackSuccess", new Object[0]);
        if (this.hnadsm != null) {
            hnadsa((List) list, true);
            this.hnadsm.onLoadSuccess(list.get(0));
        }
        c.hnadsa().hnadsa(this.hnadsa.getSlotId());
    }

    @Override // com.hihonor.adsdk.base.mediation.core.imp.c
    public int hnadsd() {
        return 3;
    }

    @Override // com.hihonor.adsdk.base.mediation.core.imp.c
    protected void hnadsa(String str, String str2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsn, "callBackFail errorCode:" + str + "; errorMsg:" + str2, new Object[0]);
        if (this.hnadsm != null) {
            hnadsb(str, str2);
            this.hnadsm.onFailed(str, str2);
        }
        c.hnadsa().hnadsa(this.hnadsa.getSlotId());
    }
}
