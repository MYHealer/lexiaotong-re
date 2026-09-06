package com.hihonor.adsdk.base.g.j.d;

import com.hihonor.adsdk.base.api.BaseAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class j extends f1 {
    public j(BaseAd baseAd, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar, int i, int i2) {
        super(str, aVar);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, String.valueOf(i));
        this.hnadsd.put("type", String.valueOf(i2));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.L0, String.valueOf(baseAd.getItemPosition()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.X0, String.valueOf(0));
        this.hnadsd.put("cost_time", String.valueOf(0));
        this.hnadsd.put("code", String.valueOf(0));
    }

    public j hnadsa(int i) {
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.X0, String.valueOf(i));
        return this;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.hnadsw;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsb() {
        return 0;
    }

    public j hnadsb(int i) {
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, String.valueOf(i));
        return this;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsc() {
        return 1;
    }

    public j hnadsc(int i) {
        this.hnadsd.put("type", String.valueOf(i));
        return this;
    }

    public j hnadsa(long j) {
        this.hnadsd.put("cost_time", String.valueOf(j));
        return this;
    }

    public j hnadsa(String str) {
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.C, str);
        return this;
    }

    public j(BaseAd baseAd, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar, com.hihonor.adsdk.base.g.j.d.h1.b bVar) {
        super(str, aVar);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.L0, String.valueOf(baseAd.getItemPosition()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.X0, String.valueOf(0));
        this.hnadsd.put("code", String.valueOf(0));
        hnadsa(bVar);
    }

    public j(c cVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadse, cVar.hnadsl());
        this.hnadsd.put("ad_type", String.valueOf(cVar.hnadsk()));
        this.hnadsd.put("request_id", cVar.f());
        this.hnadsd.put("ad_id", cVar.hnadsb());
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.X0, String.valueOf(0));
        this.hnadsd.put("cost_time", String.valueOf(0));
        this.hnadsd.put("code", String.valueOf(0));
    }

    public j(com.hihonor.adsdk.base.i.d dVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, String.valueOf(dVar.hnadsj()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.L0, String.valueOf(dVar.hnadsi()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadse, dVar.hnadsc());
        this.hnadsd.put("ad_type", String.valueOf(dVar.hnadsb()));
        this.hnadsd.put("request_id", dVar.hnadso());
        this.hnadsd.put("ad_id", dVar.hnadsa());
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.X0, String.valueOf(0));
        this.hnadsd.put("cost_time", String.valueOf(0));
        this.hnadsd.put("code", String.valueOf(0));
    }
}
