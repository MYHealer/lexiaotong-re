package com.hihonor.adsdk.base.g.j.d;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class q extends e1 {
    public q(LinkedHashMap<String, String> linkedHashMap, int i, int i2, int i3, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.putAll(linkedHashMap);
        this.hnadsd.put("error_code", String.valueOf(i3));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, String.valueOf(i));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsh, String.valueOf(i2));
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.h;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsb() {
        return 1;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsc() {
        return 0;
    }

    public q(c cVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.put("error_code", cVar.hnadss());
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, cVar.c());
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsh, cVar.hnadsq());
    }
}
