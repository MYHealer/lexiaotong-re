package com.hihonor.adsdk.base.g.j.d.j1;

import com.hihonor.adsdk.base.g.j.d.e1;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class a extends e1 {
    public a(com.hihonor.adsdk.base.bean.b bVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        if (bVar == null) {
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsd, String.valueOf(-1));
            return;
        }
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.S0, String.valueOf(bVar.hnadsf()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsd, String.valueOf(bVar.hnadse()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.r0, String.valueOf(bVar.hnadsd()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.K0, bVar.hnadsc());
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsf, bVar.hnadsj());
    }

    public a(String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
    }
}
