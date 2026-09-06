package com.hihonor.adsdk.base.g.k.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends k0 {
    private static final String hnadsd = "AdTrackClick";

    public b(int i, int i2, int i3, int i4, int i5, float f, int i6) {
        this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadsc, i + "");
        this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadsd, i2 + "");
        this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadse, i3 + "");
        this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadsf, i4 + "");
        this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadsg, f + "");
        this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadsp, com.hihonor.adsdk.common.f.z.hnadsa("{\"type\":\"" + i5 + "\",\"clickSubType\":\"" + i6 + "\"}"));
    }

    @Override // com.hihonor.adsdk.base.g.k.c.k0
    public int hnadsb() {
        return 2;
    }
}
