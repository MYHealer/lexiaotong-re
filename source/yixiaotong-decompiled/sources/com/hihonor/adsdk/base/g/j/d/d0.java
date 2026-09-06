package com.hihonor.adsdk.base.g.j.d;

import com.hihonor.adsdk.base.bean.Address;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d0 extends e1 {
    public d0(String str, Address address, com.hihonor.adsdk.base.bean.d dVar) {
        super("", com.hihonor.adsdk.base.g.j.g.b.hnadsb());
        this.hnadsd.put("provider", str);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.G0, com.hihonor.adsdk.base.j.g.hnadsa(address));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.H0, com.hihonor.adsdk.base.j.g.hnadsa(dVar));
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.z;
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
}
