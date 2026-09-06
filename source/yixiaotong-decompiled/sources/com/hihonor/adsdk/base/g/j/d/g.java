package com.hihonor.adsdk.base.g.j.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g extends e1 {
    public g(String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar, String str2) {
        super(str, aVar);
        this.hnadsd.put("msg", str2);
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.hnadsz;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsb() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsc() {
        return 1;
    }

    public g(c cVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.put("type", cVar.p());
        this.hnadsd.put("msg", cVar.hnadst());
    }
}
