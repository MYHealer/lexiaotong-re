package com.hihonor.adsdk.base.g.j.d;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class x extends e1 {
    public x(LinkedHashMap<String, String> linkedHashMap, int i, String str, String str2, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str2, aVar);
        this.hnadsd.putAll(linkedHashMap);
        this.hnadsd.put("error_code", String.valueOf(i));
        this.hnadsd.put("msg", str);
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.g;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsb() {
        return 1;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsc() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public boolean hnadsd() {
        return false;
    }

    public x(String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar, int i, String str2) {
        super(str, aVar);
        this.hnadsd.put("error_code", String.valueOf(i));
        this.hnadsd.put("msg", str2);
    }

    public x(c cVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.put("error_code", cVar.hnadss());
        this.hnadsd.put("msg", cVar.hnadst());
    }
}
