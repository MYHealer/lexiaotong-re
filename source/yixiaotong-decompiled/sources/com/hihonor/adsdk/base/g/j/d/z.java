package com.hihonor.adsdk.base.g.j.d;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class z extends e1 {
    public z(LinkedHashMap<String, String> linkedHashMap, int i, int i2, int i3, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.putAll(linkedHashMap);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, String.valueOf(i));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsh, String.valueOf(i2));
        this.hnadsd.put("type", String.valueOf(i3));
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.hnadsm;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsb() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsc() {
        return 1;
    }

    public z(c cVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, cVar.c());
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsh, cVar.hnadsq());
        this.hnadsd.put("type", String.valueOf(1));
    }
}
