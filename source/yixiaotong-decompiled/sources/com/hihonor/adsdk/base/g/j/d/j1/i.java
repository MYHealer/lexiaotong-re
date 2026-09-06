package com.hihonor.adsdk.base.g.j.d.j1;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class i extends a {
    public i(com.hihonor.adsdk.base.bean.b bVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar, List<String> list, List<String> list2) {
        super(bVar, str, aVar);
        this.hnadsd.put("ad_id", com.hihonor.adsdk.base.j.g.hnadsa(list));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsp, com.hihonor.adsdk.base.j.g.hnadsa(list2));
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.hnadse;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsb() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsc() {
        return 1;
    }

    public i(com.hihonor.adsdk.base.g.j.d.c cVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsd, cVar != null ? cVar.hnadsw() + "" : "");
    }
}
