package com.hihonor.adsdk.base.g.j.d;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class o0 extends e1 {
    public o0(LinkedHashMap<String, String> linkedHashMap, int i, int i2, String str, String str2, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str2, aVar);
        this.hnadsd.putAll(linkedHashMap);
        this.hnadsd.put("error_code", String.valueOf(i2));
        this.hnadsd.put("type", String.valueOf(5));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.s0, String.valueOf(i));
        this.hnadsd.put("msg", str);
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
}
