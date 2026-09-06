package com.opos.mobad.g.a.a;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class r<P> implements com.opos.mobad.ad.d.a<P> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6941a;
    private final p b;

    public r(int i, p pVar) {
        this.f6941a = i;
        this.b = pVar;
    }

    @Override // com.opos.mobad.ad.d.a
    public void a(int i, String str) {
        com.opos.cmn.an.f.a.a("delegator", "delegator onAdFailed adChannel:" + this.f6941a + ", code:" + i + ", msg:" + str);
        p pVar = this.b;
        int i2 = this.f6941a;
        pVar.a(m.a(i2, i2, i, str));
    }

    @Override // com.opos.mobad.ad.d.a
    public void a(List<P> list) {
        HashMap map;
        p pVar = this.b;
        if (!(pVar instanceof s)) {
            if (pVar instanceof t) {
                map = ((t) pVar).f6943a;
            } else {
                com.opos.cmn.an.f.a.a("delegator", "delegator instance error");
            }
            com.opos.cmn.an.f.a.a("delegator", "delegator onAdReady:" + this.f6941a);
            this.b.d(this.f6941a);
        }
        map = ((s) pVar).f6942a;
        map.put(Integer.valueOf(this.f6941a), list);
        com.opos.cmn.an.f.a.a("delegator", "delegator onAdReady:" + this.f6941a);
        this.b.d(this.f6941a);
    }
}
