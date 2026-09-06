package com.hihonor.adsdk.picturetextad;

import com.hihonor.adsdk.base.api.feed.PictureTextAdLoadListener;
import com.hihonor.adsdk.base.api.feed.PictureTextExpressAd;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
class b extends com.hihonor.adsdk.base.mediation.core.imp.c<PictureTextExpressAd, a> {
    private static final String b = "NaManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PictureTextAdLoadListener f3540a;

    public b(PictureTextAdLoadListener pictureTextAdLoadListener) {
        this.f3540a = pictureTextAdLoadListener;
    }

    @Override // com.hihonor.adsdk.base.mediation.core.imp.c
    protected void hnadsa(List<PictureTextExpressAd> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(b, "#callBackSuccess", new Object[0]);
        if (this.f3540a != null) {
            hnadsa((List) list, false);
            this.f3540a.onAdLoaded(list);
        }
        d.a().a(this.hnadsa.getSlotId());
    }

    @Override // com.hihonor.adsdk.base.mediation.core.imp.c
    public int hnadsd() {
        return 2;
    }

    @Override // com.hihonor.adsdk.base.mediation.core.imp.c
    protected void hnadsa(String str, String str2) {
        com.hihonor.adsdk.common.b.b.hnadsc(b, "callBackFail errorCode:" + str + "; errorMsg:" + str2, new Object[0]);
        if (this.f3540a != null) {
            hnadsb(str, str2);
            this.f3540a.onFailed(str, str2);
        }
        d.a().a(this.hnadsa.getSlotId());
    }
}
