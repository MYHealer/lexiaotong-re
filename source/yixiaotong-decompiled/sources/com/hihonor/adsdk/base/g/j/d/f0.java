package com.hihonor.adsdk.base.g.j.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class f0 extends e1 {
    public f0(String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar, int i, String str2) {
        super(str, aVar);
        this.hnadsd.put("error_code", String.valueOf(i));
        this.hnadsd.put("msg", str2);
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.n;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsb() {
        return 1;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsc() {
        return 0;
    }
}
