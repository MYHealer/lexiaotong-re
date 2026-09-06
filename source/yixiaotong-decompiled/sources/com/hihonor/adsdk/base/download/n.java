package com.hihonor.adsdk.base.download;

import com.hihonor.adsdk.base.g.j.d.n0;
import com.hihonor.adsdk.base.g.j.d.r;
import com.hihonor.adsdk.base.g.j.d.s;
import com.hihonor.adsdk.base.g.j.d.u;
import com.hihonor.adsdk.base.g.j.d.v;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class n {
    private static final String hnadsa = "ReportDownloadClickManager";
    private static volatile n hnadsb;

    public void hnadsb(g gVar, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportAdEventDownloadReStartClick", new Object[0]);
        if (gVar == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportAdEventDownloadReStartClick downloadInfo is null", new Object[0]);
        } else {
            new r(com.hihonor.adsdk.base.g.j.g.c.hnadsa(gVar), gVar.i(), i, gVar.hnadsc(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(gVar)).hnadse();
        }
    }

    public void hnadsc(g gVar, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportAdEventDownloadReStartState", new Object[0]);
        if (gVar == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportAdEventDownloadReStartState downloadInfo is null", new Object[0]);
        } else {
            new s(com.hihonor.adsdk.base.g.j.g.c.hnadsa(gVar), gVar.i(), i, gVar.hnadsc(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(gVar)).hnadse();
        }
    }

    public void hnadsd(g gVar, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportAdEventDownloadTrigger", new Object[0]);
        if (gVar == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportAdEventDownloadTrigger downloadInfo is null", new Object[0]);
        } else {
            new u(com.hihonor.adsdk.base.g.j.g.c.hnadsa(gVar), gVar.i(), i, gVar.hnadsc(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(gVar)).hnadse();
        }
    }

    public void hnadse(g gVar, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportAdEventDownloadWaitClick", new Object[0]);
        if (gVar == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportAdEventDownloadWaitClick downloadInfo is null", new Object[0]);
        } else {
            new v(com.hihonor.adsdk.base.g.j.g.c.hnadsa(gVar), gVar.i(), i, gVar.hnadsc(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(gVar)).hnadse();
        }
    }

    public void hnadsf(g gVar, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportAdEventRecoverTrigger", new Object[0]);
        if (gVar == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportAdEventRecoverTrigger downloadInfo is null", new Object[0]);
        } else {
            new n0(com.hihonor.adsdk.base.g.j.g.c.hnadsa(gVar), gVar.i(), i, gVar.hnadsc(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(gVar)).hnadse();
        }
    }

    public static n hnadsa() {
        if (hnadsb == null) {
            synchronized (n.class) {
                if (hnadsb == null) {
                    hnadsb = new n();
                }
            }
        }
        return hnadsb;
    }

    public void hnadsa(g gVar, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportAdEventDownloadPausedClick", new Object[0]);
        if (gVar == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportAdEventDownloadPausedClick downloadInfo is null", new Object[0]);
        } else {
            new com.hihonor.adsdk.base.g.j.d.p(com.hihonor.adsdk.base.g.j.g.c.hnadsa(gVar), gVar.i(), i, gVar.hnadsc(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(gVar)).hnadse();
        }
    }
}
