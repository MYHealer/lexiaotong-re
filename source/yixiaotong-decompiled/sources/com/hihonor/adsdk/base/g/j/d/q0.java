package com.hihonor.adsdk.base.g.j.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class q0 extends e1 {
    public q0(int i, String str, String str2) {
        super("", com.hihonor.adsdk.base.g.j.g.b.hnadsb());
        this.hnadsd.put("error_code", str);
        this.hnadsd.put("type", String.valueOf(i));
        this.hnadsd.put("msg", str2);
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.j;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsb() {
        return 1;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsc() {
        return 0;
    }

    public q0(c cVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.put("error_code", cVar.hnadss());
        this.hnadsd.put("type", cVar.p());
        this.hnadsd.put("msg", cVar.hnadst());
    }
}
