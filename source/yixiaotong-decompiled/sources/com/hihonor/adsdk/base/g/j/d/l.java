package com.hihonor.adsdk.base.g.j.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class l extends e1 {
    public l(String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar, int i, int i2, String str2, String str3, String str4) {
        super(str, aVar);
        this.hnadsd.put("type", String.valueOf(i));
        this.hnadsd.put("result", String.valueOf(i2));
        this.hnadsd.put("error_code", str2);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadst, str3);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.m, str4);
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.H;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsb() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsc() {
        return 1;
    }
}
