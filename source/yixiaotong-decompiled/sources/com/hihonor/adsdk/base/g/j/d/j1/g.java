package com.hihonor.adsdk.base.g.j.d.j1;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g extends a {
    public g(com.hihonor.adsdk.base.bean.b bVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar, String str2, String str3) {
        super(bVar, str, aVar);
        this.hnadsd.put("error_code", str2);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadst, str3);
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.hnadsb;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsb() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsc() {
        return 1;
    }

    public g(com.hihonor.adsdk.base.g.j.d.c cVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsd, cVar != null ? cVar.hnadsw() + "" : "");
        this.hnadsd.put("error_code", cVar != null ? cVar.hnadss() : "");
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadst, cVar != null ? cVar.hnadst() : "");
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsj, cVar != null ? cVar.hnadsx() : "");
    }
}
