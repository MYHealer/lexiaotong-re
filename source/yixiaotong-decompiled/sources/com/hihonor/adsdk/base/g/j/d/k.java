package com.hihonor.adsdk.base.g.j.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class k extends e1 {
    public k(String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar, int i, int i2, long j) {
        super(str, aVar);
        this.hnadsd.put("type", String.valueOf(i));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.w0, String.valueOf(i2));
        if (i2 == 0) {
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.x0, String.valueOf(j));
        } else {
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.x0, String.valueOf(j));
        }
    }

    public k hnadsa(int i) {
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.X0, String.valueOf(i));
        return this;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.x;
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
