package com.hihonor.adsdk.base.g.j.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class i extends f1 {
    public i(String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar, com.hihonor.adsdk.base.g.j.d.h1.b bVar, int i, String str2) {
        super(str, aVar);
        hnadsa(bVar);
        this.hnadsd.put("error_code", String.valueOf(i));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadst, str2);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.X0, String.valueOf(0));
        this.hnadsd.put("cost_time", String.valueOf(0));
    }

    public i hnadsa(int i) {
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.X0, String.valueOf(i));
        return this;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.hnadsx;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsb() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsc() {
        return 1;
    }

    public i hnadsa(long j) {
        this.hnadsd.put("cost_time", String.valueOf(j));
        return this;
    }

    public i hnadsa(String str) {
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.C, str);
        return this;
    }
}
