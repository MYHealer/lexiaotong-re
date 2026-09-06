package com.hihonor.adsdk.base.g.k.c;

import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.init.HnAdConfig;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class l0 extends m0 {
    private static final String hnadse = "PowerSwitchTrack";

    @Override // com.hihonor.adsdk.base.g.k.c.k0
    public void hnadsa(String str, String str2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "onReportWorkFlow enter. adUnit=" + str + ", req:" + str2, new Object[0]);
        HnAdConfig cfg = HnAds.get().getCfg();
        if (cfg == null || cfg.getCustomController() == null || cfg.getCustomController().isRecordTrackReq()) {
            super.hnadsa(str, str2);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "execute track report, but isSupportTrackingComplementReq falseand trackingType is : " + hnadsb(), new Object[0]);
        }
    }
}
