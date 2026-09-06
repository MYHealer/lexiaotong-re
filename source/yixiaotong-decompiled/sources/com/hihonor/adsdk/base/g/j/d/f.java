package com.hihonor.adsdk.base.g.j.d;

import com.hihonor.adsdk.base.api.BaseAd;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class f extends e1 {
    public f(BaseAd baseAd, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar, int i, int i2) {
        super(str, aVar);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, String.valueOf(baseAd.getSequence()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsh, i + "");
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.L0, String.valueOf(baseAd.getItemPosition()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsi, i2 + "");
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.hnadsh;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsb() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsc() {
        return 1;
    }

    public f(LinkedHashMap<String, String> linkedHashMap, int i, int i2, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar, int i3) {
        super(str, aVar);
        this.hnadsd.putAll(linkedHashMap);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, i + "");
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsh, i2 + "");
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsi, i3 + "");
    }

    public f(c cVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, cVar.c());
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsh, cVar.hnadsq());
        this.hnadsd.put("msg", cVar.hnadst());
    }
}
