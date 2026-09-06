package com.hihonor.adsdk.base.g.j.d;

import com.hihonor.adsdk.base.api.BaseAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class h extends e1 {
    public h(BaseAd baseAd, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsh, String.valueOf(1));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.L0, String.valueOf(baseAd.getItemPosition()));
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.hnadsy;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsb() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsc() {
        return 1;
    }

    public h(BaseAd baseAd, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar, String str2, String str3) {
        super(str, aVar);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsh, String.valueOf(str2));
        this.hnadsd.put("msg", str3);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.L0, String.valueOf(baseAd.getItemPosition()));
    }

    public h(c cVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsh, cVar.hnadsq());
        this.hnadsd.put("msg", cVar.hnadst());
    }
}
