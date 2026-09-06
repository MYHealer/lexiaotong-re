package com.hihonor.adsdk.base.mediation.core.imp.f;

import com.hihonor.adsdk.base.api.reward.RewardAdLoadListener;
import com.hihonor.adsdk.base.api.reward.RewardExpressAd;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends com.hihonor.adsdk.base.mediation.core.imp.c<RewardExpressAd, b> {
    private static final String hnadsn = "RewardManager";
    private RewardAdLoadListener hnadsm;

    public c(RewardAdLoadListener rewardAdLoadListener) {
        this.hnadsm = rewardAdLoadListener;
    }

    @Override // com.hihonor.adsdk.base.mediation.core.imp.c
    protected void hnadsa(List<RewardExpressAd> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsn, "#callBackSuccess", new Object[0]);
        if (this.hnadsm != null) {
            hnadsa((List) list, true);
            this.hnadsm.onLoadSuccess(list.get(0));
        }
        a.hnadsa().hnadsa(this.hnadsa.getSlotId());
    }

    @Override // com.hihonor.adsdk.base.mediation.core.imp.c
    public int hnadsd() {
        return 4;
    }

    @Override // com.hihonor.adsdk.base.mediation.core.imp.c
    protected void hnadsa(String str, String str2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsn, "callBackFail errorCode:" + str + "; errorMsg:" + str2, new Object[0]);
        if (this.hnadsm != null) {
            hnadsb(str, str2);
            this.hnadsm.onFailed(str, str2);
        }
        a.hnadsa().hnadsa(this.hnadsa.getSlotId());
    }
}
