package com.hihonor.adsdk.base.j.n;

import android.location.Location;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.init.HnAdConfig;
import com.hihonor.adsdk.base.init.HnCustomController;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d extends a {
    private static final String hnadsf = "LocationHandlerForMediaInfoImp";
    private final a.C0442a hnadsd = new a.C0442a("network");
    private final a.C0442a hnadse = new a.C0442a("gps");

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadse() {
        hnadsa(this.hnadsa, this.hnadse, this.hnadsd);
    }

    @Override // com.hihonor.adsdk.base.j.n.a
    protected void hnadsa(Location location) {
        hnadsa(this.hnadsa, this.hnadse, this.hnadsd);
    }

    @Override // com.hihonor.adsdk.base.j.n.a
    protected String hnadsc() {
        return hnadsf;
    }

    @Override // com.hihonor.adsdk.base.j.n.b
    public void startLocation() {
        HnCustomController customController;
        HnAdConfig cfg = HnAds.get().getCfg();
        if (cfg != null && (customController = cfg.getCustomController()) != null && customController.getLocation() != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "startLocation, use user location", new Object[0]);
            j.hnadsb().hnadsa(customController.getLocation());
        } else if (com.hihonor.adsdk.base.j.i.hnadsb()) {
            hnadsa(this.hnadse, this.hnadsd);
        } else {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsf, "startLocation, location can not use", new Object[0]);
        }
    }

    @Override // com.hihonor.adsdk.base.j.n.b
    public void stopLocation(long j) {
        hnadsa(j, new Runnable() { // from class: com.hihonor.adsdk.base.j.n.d$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadse();
            }
        });
    }
}
