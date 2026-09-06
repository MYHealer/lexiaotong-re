package com.hihonor.adsdk.base.g.j.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class s0 extends e1 {
    public s0(int i, String str, String str2, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str2, aVar);
        this.hnadsd.put("error_code", String.valueOf(i));
        this.hnadsd.put("msg", str);
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.hnadsf;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsb() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsc() {
        return 1;
    }

    public s0(c cVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.put("error_code", String.valueOf(cVar.hnadss()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadst, cVar.hnadst());
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.S, String.valueOf(cVar.hnadsg()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.R, String.valueOf(cVar.hnadsc()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.T, cVar.hnadsf());
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.U, String.valueOf(cVar.hnadse()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.V, String.valueOf(cVar.hnadsd()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.W, String.valueOf(cVar.hnadsi()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.X, String.valueOf(cVar.hnadsj()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.Y, String.valueOf(cVar.hnadsh()));
    }
}
