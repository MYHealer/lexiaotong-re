package com.hihonor.adsdk.base.widget.web.b;

import android.os.SystemClock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends a {
    private static final String hnadsg = "PermissionWebViewReport";
    private static final long hnadsh = 0;
    private int hnadsf = 0;

    public void hnadsb(int i) {
        this.hnadsf = i;
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.a
    protected String hnadsc() {
        return hnadsg;
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.a
    protected com.hihonor.adsdk.base.g.j.d.h1.b hnadsb(int i, String str) {
        com.hihonor.adsdk.base.g.j.d.h1.b bVar = new com.hihonor.adsdk.base.g.j.d.h1.b();
        if (this.hnadsa != 0) {
            bVar.hnadsa(String.valueOf(SystemClock.elapsedRealtime() - this.hnadsa));
        }
        bVar.hnadsc(String.valueOf(this.hnadsd.getSequence()));
        bVar.hnadse(str);
        bVar.hnadsb(hnadsb());
        return bVar;
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.a
    protected String hnadsb() {
        return String.valueOf(this.hnadsf);
    }
}
