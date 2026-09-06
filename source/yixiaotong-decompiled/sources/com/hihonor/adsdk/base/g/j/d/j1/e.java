package com.hihonor.adsdk.base.g.j.d.j1;

import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.g.j.d.e1;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e extends e1 {
    public e(com.hihonor.adsdk.base.bean.b bVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar, String str2, String str3, String str4) {
        super(str, aVar);
        hnadsa(str2, str3, str4);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsd, String.valueOf(bVar.hnadse()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.S0, String.valueOf(bVar.hnadsf()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.K0, bVar.hnadsc());
    }

    private void hnadsa(String str, String str2, String str3) {
        this.hnadsd.put("msg", "IS ERR:" + str2);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.Z, str3);
        this.hnadsd.put("type", String.valueOf(3));
        this.hnadsd.put("error_code", str);
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.c;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsb() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsc() {
        return 1;
    }

    public e(com.hihonor.adsdk.base.g.j.d.c cVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar, String str2, String str3, String str4) {
        super(str, aVar);
        hnadsa(str2, str3, str4);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsd, String.valueOf(cVar.hnadsw()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.S0, String.valueOf(cVar.e()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.K0, cVar.hnadsv());
    }

    public e(BaseAd baseAd, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar, Object obj, int i) {
        super(str, aVar);
        this.hnadsd.put("error_code", String.valueOf(i));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, String.valueOf(baseAd.getSequence()));
        this.hnadsd.put("type", String.valueOf(4));
        this.hnadsd.put("msg", com.hihonor.adsdk.base.j.g.hnadsa(obj));
    }
}
