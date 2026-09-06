package com.hihonor.adsdk.base.j.n;

import android.location.Location;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e extends a {
    private static final String hnadsf = "LocationHandlerImp";
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
        hnadsa(this.hnadse, this.hnadsd);
    }

    @Override // com.hihonor.adsdk.base.j.n.b
    public void stopLocation(long j) {
        hnadsa(j, new Runnable() { // from class: com.hihonor.adsdk.base.j.n.e$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadse();
            }
        });
    }
}
