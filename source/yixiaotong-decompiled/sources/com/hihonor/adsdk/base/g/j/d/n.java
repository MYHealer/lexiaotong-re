package com.hihonor.adsdk.base.g.j.d;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class n extends e1 {
    public n(LinkedHashMap<String, String> linkedHashMap, int i, int i2, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.putAll(linkedHashMap);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, String.valueOf(i));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsh, String.valueOf(i2));
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.hnadsk;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsb() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsc() {
        return 1;
    }

    public n(c cVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, cVar.hnadsq());
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsh, cVar.hnadsq());
    }
}
