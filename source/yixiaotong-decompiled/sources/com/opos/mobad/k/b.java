package com.opos.mobad.k;

import com.opos.mobad.ad.d.m;
import com.opos.mobad.ad.d.q;
import com.opos.mobad.model.data.AdData;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class b extends a {
    protected com.opos.mobad.ad.d.f h;
    protected int i;
    protected volatile String j;

    public b(com.opos.mobad.b bVar, String str, int i, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.ad.d.f fVar, com.opos.mobad.cmn.func.adhandler.f fVar2) {
        super(bVar, str, aVar, fVar2);
        this.i = i;
        this.h = fVar;
    }

    public b(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.ad.d.f fVar, com.opos.mobad.cmn.func.adhandler.f fVar2) {
        super(bVar, str, aVar, fVar2);
        this.h = fVar;
    }

    protected void a(q qVar) {
        if (qVar != null) {
            try {
                com.opos.cmn.an.f.a.b("InterBaseNativeAd", "notifyOnAdFailed nativeAdError=" + qVar.toString());
                b().a(qVar);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("InterBaseNativeAd", "", (Throwable) e);
            }
        }
    }

    protected void a(AdData adData, List<com.opos.mobad.ad.d.d> list) {
        try {
            com.opos.cmn.an.f.a.b("InterBaseNativeAd", "notifyOnAdReady");
            if (adData == null || list == null) {
                return;
            }
            b().a(list);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterBaseNativeAd", "", (Throwable) e);
        }
    }

    public com.opos.mobad.ad.d.f b() {
        com.opos.mobad.ad.d.f fVar = this.h;
        return fVar != null ? fVar : com.opos.mobad.ad.d.f.b;
    }

    public m c() {
        com.opos.mobad.ad.d.f fVar = this.h;
        return (fVar == null || !(fVar instanceof m)) ? m.c : (m) fVar;
    }
}
