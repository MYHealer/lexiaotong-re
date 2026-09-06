package com.hihonor.adsdk.base.g.j.d.j1;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends a {
    public c(com.hihonor.adsdk.base.bean.b bVar, String str, String str2, String str3, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(bVar, str3, aVar);
        this.hnadsd.put("msg", str2);
        this.hnadsd.put("error_code", str);
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.hnadsd;
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
