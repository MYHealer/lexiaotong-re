package com.hihonor.adsdk.base.g.j.d;

import com.hihonor.adsdk.base.HnAds;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class u0 extends e1 {
    public u0(String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar, int i, String str2, String str3) {
        super(str, aVar);
        this.hnadsd.put("code", String.valueOf(i));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadst, str2);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadse, str);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsu, HnAds.get().getCfg().getAppId());
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.K0, str3);
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.v;
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
