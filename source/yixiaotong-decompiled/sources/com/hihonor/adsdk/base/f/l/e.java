package com.hihonor.adsdk.base.f.l;

import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.base.init.i;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class e extends c {
    public e(BaseAd baseAd) {
        super(baseAd);
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected void hnadsa(final com.hihonor.adsdk.base.f.a.b bVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "start dp mini app internal.", new Object[0]);
        if (!hnadsc()) {
            hnadsa(false, 1008, i.hnadsa(), "DpMiniAppHandler Unable to call startInternal, Cause by BaseAd is null.", bVar);
            return;
        }
        if (hnadsi()) {
            com.hihonor.adsdk.base.i.e.hnadsa(this.hnadsa).hnadsa(true).hnadsb().hnadsa(new com.hihonor.adsdk.base.i.c() { // from class: com.hihonor.adsdk.base.f.l.e$$ExternalSyntheticLambda0
                @Override // com.hihonor.adsdk.base.i.c
                public final void hnadsa(com.hihonor.adsdk.base.i.i.b bVar2) {
                    this.f$0.hnadsa(bVar, bVar2);
                }
            }).start();
            return;
        }
        String str = String.format(Locale.ENGLISH, "startMiniAppFail#Start mini app fail. %s APP is not install", hnadsf());
        new com.hihonor.adsdk.base.g.j.d.b(this.hnadsa.getSequence(), this.hnadsa.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsa)).hnadsb(hnadsh()).hnadsa(0).hnadsa(this.hnadsa.getDeeplinkUrl()).hnadse();
        hnadsa(hnadsh(), 0, new com.hihonor.adsdk.base.g.j.d.h1.b());
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), str, new Object[0]);
        hnadsa(false, ErrorCode.c.hnadsa, 0, str, bVar);
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected boolean hnadsd() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(com.hihonor.adsdk.base.f.a.b bVar, com.hihonor.adsdk.base.i.i.b bVar2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "DpMiniAppHandler# call StartAppEngine result code=" + bVar2.hnadsa() + ", msg= " + bVar2.hnadsc(), new Object[0]);
        if (bVar2.hnadsa() == 0) {
            hnadsa(true, 0, bVar2.hnadsd(), "Success", bVar);
            AdListener adListener = this.hnadsa.getAdListener();
            if (adListener != null) {
                adListener.onMiniAppStarted();
                return;
            }
            return;
        }
        hnadsa(false, bVar2.hnadsa(), bVar2.hnadsd(), bVar2.hnadsc(), bVar);
    }
}
