package com.opos.mobad.model.a;

import com.opos.mobad.b.a.aa;
import com.opos.mobad.b.a.ab;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.CustomInfoData;
import com.opos.mobad.model.data.InteractiveData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.model.e.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class a extends com.opos.mobad.model.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected g f7146a;
    protected final boolean b;
    protected com.opos.mobad.model.c.c c;
    private com.opos.mobad.b d;
    private String e;
    private com.opos.mobad.model.e.i f;
    private com.opos.mobad.model.c.d g;
    private AdData h;
    private Set<String> i;
    private Set<com.opos.mobad.model.c.e> j;
    private Set<com.opos.mobad.model.c.e> k;

    public a(com.opos.mobad.b bVar, String str, com.opos.mobad.model.c.c cVar, boolean z, g gVar, com.opos.mobad.model.e.g.a aVar) {
        super(aVar);
        this.i = new HashSet();
        this.d = bVar;
        this.e = str;
        this.c = cVar;
        this.b = z;
        this.f7146a = gVar;
        this.f = new com.opos.mobad.model.e.e(this.d.b());
    }

    private AdData a(com.opos.mobad.model.c.c cVar, com.opos.mobad.model.c.d dVar, boolean z, i iVar, Set<com.opos.mobad.model.c.e> set, Set<com.opos.mobad.model.c.e> set2) {
        List<ab> list;
        ab abVar;
        int i;
        int i2;
        CustomInfoData customInfoData;
        try {
            if (dVar == null) {
                return new AdData(10001, "net response is null.");
            }
            if (dVar.f() != 0) {
                return new AdData(dVar.f(), dVar.g(), dVar.l(), dVar.m());
            }
            List<com.opos.mobad.b.a.b> listH = dVar.h();
            if (listH != null && listH.size() > 0) {
                if (dVar.i() <= System.currentTimeMillis()) {
                    return new AdData(10003, com.opos.mobad.ad.a.a(10003), dVar.l(), dVar.m());
                }
                ArrayList arrayList = new ArrayList();
                int iMax = Math.max(1, dVar.e());
                CustomInfoData customInfoData2 = new CustomInfoData(dVar.r());
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i5 < listH.size() && i4 < iMax) {
                    com.opos.mobad.b.a.b bVar = listH.get(i5);
                    if (bVar == null || (list = bVar.D) == null || list.size() <= 0 || (abVar = list.get(i3)) == null) {
                        i = i4;
                        i2 = i3;
                        customInfoData = customInfoData2;
                    } else {
                        i = i4;
                        if (a(cVar.e(), bVar, abVar, false, iVar)) {
                            this.i.add(abVar.aV);
                            iVar.a(abVar, bVar.G);
                            iVar.a(abVar, bVar.aj);
                            iVar.a(abVar, bVar.ai);
                            MaterialFileData materialFileDataA = b.a(this.d, bVar, set, z, iVar);
                            MaterialFileData materialFileDataA2 = b.a(this.d, bVar.aj, set, z, iVar);
                            MaterialFileData materialFileDataA3 = b.a(this.d, bVar.ai, set, z, iVar);
                            i2 = 0;
                            customInfoData = customInfoData2;
                            AdItemData adItemData = new AdItemData(bVar, b.a(this.d, abVar, set, set2, z, iVar), materialFileDataA, dVar.k(), dVar.i(), dVar.j(), cVar.a(), customInfoData, cVar.e(), cVar.i(), dVar.s(), dVar.t(), "");
                            adItemData.b(materialFileDataA2);
                            adItemData.c(materialFileDataA3);
                            if (dVar.a()) {
                                adItemData.M();
                            }
                            arrayList.add(adItemData);
                            i++;
                        } else {
                            customInfoData = customInfoData2;
                            i2 = 0;
                        }
                    }
                    i5++;
                    i3 = i2;
                    i4 = i;
                    customInfoData2 = customInfoData;
                }
                if (arrayList.size() <= 0) {
                    return new AdData(10004, "adItemList is null.", dVar.l(), dVar.m());
                }
                AdData adData = new AdData(dVar.f(), dVar.g(), dVar.l(), dVar.m());
                adData.a(dVar.i());
                adData.a(dVar.o());
                adData.d(dVar.n());
                adData.a(arrayList);
                adData.b(10000);
                adData.a("ok.");
                return adData;
            }
            return new AdData(10002, "response ad list is null.", dVar.l(), dVar.m());
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ALoader", "", (Throwable) e);
            return new AdData(-1, "unknown error.");
        }
    }

    private void a(MaterialData materialData) {
        List<String> list;
        InteractiveData interactiveDataAd = materialData.ad();
        if (interactiveDataAd == null || (list = interactiveDataAd.e) == null || list.isEmpty()) {
            return;
        }
        o.a(this.d.b(), list);
    }

    private void a(List<AdItemData> list) {
        MaterialData materialData;
        com.opos.cmn.an.f.a.b("ALoader", "prepare web" + list);
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<AdItemData> it = list.iterator();
        while (it.hasNext()) {
            List<MaterialData> listI = it.next().i();
            if (listI != null && listI.size() > 0 && (materialData = listI.get(0)) != null) {
                o.a(this.d.b(), materialData.i, materialData.h);
                a(materialData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, com.opos.mobad.b.a.b bVar, ab abVar, boolean z, i iVar) {
        if (!b.a(this.d.b(), abVar, iVar)) {
            return false;
        }
        if (!a(abVar)) {
            if (iVar != null) {
                iVar.b(abVar);
            }
            return false;
        }
        if (b.b(abVar) && !com.opos.mobad.cmn.func.b.i.a(this.d.b())) {
            if (iVar != null) {
                iVar.c(abVar);
            }
            return false;
        }
        if (!b.a(abVar)) {
            if (abVar.W != null && abVar.W.size() > 0) {
                return true;
            }
            if (abVar.T != null && abVar.T.size() > 0) {
                return true;
            }
            if (abVar.bb != null && abVar.bb.size() > 0) {
                return true;
            }
            if (iVar != null) {
                iVar.b(abVar);
            }
            return false;
        }
        List<aa> list = abVar.ar;
        if (list == null || list.size() <= 0) {
            if (iVar != null) {
                iVar.d(abVar);
            }
            return false;
        }
        if ((i == 3 || i == 6) && bVar.P != null && com.opos.mobad.b.a.b.d.PLAY_CACHE.getValue() != bVar.P.getValue()) {
            if (iVar != null) {
                iVar.f(abVar);
            }
            return false;
        }
        if (b.a(this.d, bVar, list)) {
            return true;
        }
        if (iVar != null) {
            iVar.e(abVar);
        }
        if (!z) {
            b(abVar);
        }
        return z;
    }

    public static boolean a(ab abVar) {
        String str;
        if (!c(abVar) || abVar.ay != ab.d.DOWNLOADER) {
            str = "is not downloader mat";
        } else {
            if (abVar.ay != ab.d.DOWNLOADER) {
                com.opos.cmn.an.f.a.b("ALoader", "is invalid downloader mat");
                return false;
            }
            str = "is downloader mat";
        }
        com.opos.cmn.an.f.a.b("ALoader", str);
        return true;
    }

    private boolean a(final g gVar) {
        Set<com.opos.mobad.model.c.e> set = this.k;
        if (set == null || set.size() <= 0) {
            return false;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.f.a(a.this.k, null);
                g gVar2 = gVar;
                if (gVar2 != null) {
                    gVar2.e();
                    gVar.b(a.this.d);
                }
            }
        });
        return true;
    }

    private static boolean c(ab abVar) {
        return abVar.S == ab.i.DOWNLOAD || abVar.av == ab.i.DOWNLOAD || abVar.aw == ab.i.DOWNLOAD || abVar.aJ == ab.i.DOWNLOAD || abVar.aK == ab.i.DOWNLOAD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!a(this.f7146a)) {
            this.f7146a.b(this.d);
        }
        d(this.h);
    }

    @Override // com.opos.mobad.model.e.a
    public void a() {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.j == null || a.this.j.size() <= 0) {
                    com.opos.cmn.an.f.a.b("ALoader", "resource available");
                    a.this.f7146a.d();
                    a.this.f();
                    return;
                }
                boolean zA = (a.this.j == null || a.this.j.size() <= 0) ? true : a.this.f.a(a.this.j, a.this.f7146a, new CustomInfoData(a.this.g.r()));
                a.this.f7146a.d();
                if (zA) {
                    a.this.f();
                    return;
                }
                AdData adData = new AdData(10011, "download material failed", a.this.h.g(), a.this.h.c());
                a.this.f7146a.a(a.this.d, adData.d());
                a.this.c(adData);
            }
        });
    }

    protected abstract void a(com.opos.mobad.model.c.c cVar);

    protected final void a(final com.opos.mobad.model.c.d dVar) {
        this.f7146a.b();
        final HashSet hashSet = new HashSet();
        final HashSet hashSet2 = new HashSet();
        final AdData adDataA = a(this.c, dVar, !this.b, this.f7146a, hashSet, hashSet2);
        this.f7146a.c();
        com.opos.cmn.an.f.a.b("ALoader", "load data:" + adDataA);
        if (adDataA == null || adDataA.d() != 10000) {
            this.f7146a.a(this.d, adDataA != null ? adDataA.d() : -1);
            b(adDataA);
        } else {
            a(new Callable<Boolean>() { // from class: com.opos.mobad.model.a.a.1
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean call() throws Exception {
                    a.this.j = hashSet;
                    a.this.k = hashSet2;
                    a.this.h = adDataA;
                    a.this.g = dVar;
                    return true;
                }
            }, adDataA);
            if (j() == 8) {
                this.f7146a.a(this.d);
            }
        }
    }

    public void a(final boolean z) {
        final List<com.opos.mobad.b.a.b> listH;
        com.opos.cmn.an.f.a.b("ALoader", this + ",cache:" + z);
        com.opos.mobad.model.c.d dVar = this.g;
        if (dVar != null && (listH = dVar.h()) != null && listH.size() > 0 && this.g.b() > 0) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.a.a.4
                @Override // java.lang.Runnable
                public void run() {
                    ab abVar;
                    com.opos.cmn.an.f.a.b("ALoader", "cache list");
                    ArrayList arrayList = new ArrayList();
                    for (com.opos.mobad.b.a.b bVar : listH) {
                        if (bVar.D != null && bVar.D.size() > 0 && (abVar = bVar.D.get(0)) != null && (!z || !a.this.i.contains(abVar.aV))) {
                            a aVar = a.this;
                            if (aVar.a(aVar.c.e(), bVar, abVar, true, null)) {
                                arrayList.add(bVar);
                                if (arrayList.size() >= a.this.g.b()) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                    a.this.d.k().a(a.this.d, a.this.e, a.this.g, arrayList, a.this.c.e(), a.this.b);
                }
            });
        }
    }

    @Override // com.opos.mobad.model.e.a
    protected void b() {
        if (j() != 3) {
            return;
        }
        this.f7146a.a(this.d);
    }

    protected abstract void b(ab abVar);

    public void c() {
        AdData adData;
        if (j() != 6 || (adData = this.h) == null) {
            return;
        }
        a(adData.f());
    }

    public boolean d() {
        StringBuilder sb = new StringBuilder("resource size:");
        Set<com.opos.mobad.model.c.e> set = this.j;
        com.opos.cmn.an.f.a.b("ALoader", sb.append(set == null ? 0 : set.size()).toString());
        Set<com.opos.mobad.model.c.e> set2 = this.j;
        return set2 == null || set2.size() <= 0;
    }

    @Override // com.opos.mobad.model.e.a
    protected void e() {
        a(this.c);
    }
}
