package com.hihonor.adsdk.base.g.j.d;

import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class f1 extends e1 {
    public f1(String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
    }

    public void hnadsa(com.hihonor.adsdk.base.g.j.d.h1.b bVar) {
        if (bVar != null) {
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, bVar.hnadsd());
            this.hnadsd.put("type", bVar.hnadsc());
            this.hnadsd.put("cost_time", bVar.hnadsb());
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.C, bVar.hnadsg());
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.C0, bVar.hnadsf());
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.D0, bVar.hnadsh());
            if (Objects.nonNull(bVar.hnadsk())) {
                this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.d1, String.valueOf(bVar.hnadsk()));
            }
            if (Objects.nonNull(bVar.hnadsa())) {
                this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.f1, String.valueOf(bVar.hnadsa()));
            }
            if (Objects.nonNull(bVar.hnadse())) {
                this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.e1, String.valueOf(bVar.hnadse()));
            }
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.z0, String.valueOf(bVar.hnadsj()));
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.A0, String.valueOf(bVar.hnadsi()));
        }
    }
}
