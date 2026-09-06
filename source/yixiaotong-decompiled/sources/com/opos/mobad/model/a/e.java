package com.opos.mobad.model.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.b.a.aa;
import com.opos.mobad.b.a.ab;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.CustomInfoData;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e {
    private static volatile e b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.mobad.model.e.i f7153a;

    private e(Context context) {
        this.f7153a = new com.opos.mobad.model.e.e(context);
    }

    public static e a(Context context) {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e(context);
                }
            }
        }
        return b;
    }

    private AdData a(com.opos.mobad.b bVar, com.opos.mobad.model.c.c cVar, com.opos.mobad.model.c.d dVar, boolean z, i iVar, Set<com.opos.mobad.model.c.e> set, Set<com.opos.mobad.model.c.e> set2) {
        List<ab> list;
        ab abVar;
        int i;
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
                CustomInfoData customInfoData = new CustomInfoData(dVar.r());
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (i4 < listH.size() && i3 < 1) {
                    com.opos.mobad.b.a.b bVar2 = listH.get(i4);
                    if (bVar2 == null || (list = bVar2.D) == null || list.size() <= 0 || (abVar = list.get(i2)) == null) {
                        i = i2;
                    } else {
                        if (a(bVar, bVar2, abVar, z, iVar)) {
                            if (iVar != null) {
                                iVar.a(abVar, bVar2.G);
                                iVar.a(abVar, bVar2.aj);
                                iVar.a(abVar, bVar2.ai);
                            }
                            MaterialFileData materialFileDataA = b.a(bVar, bVar2, set, !z, iVar);
                            MaterialFileData materialFileDataA2 = b.a(bVar, bVar2.aj, set, !z, iVar);
                            MaterialFileData materialFileDataA3 = b.a(bVar, bVar2.ai, set, !z, iVar);
                            int i5 = i3;
                            i4 = i4;
                            i = 0;
                            customInfoData = customInfoData;
                            AdItemData adItemData = new AdItemData(bVar2, b.a(bVar, abVar, set, set2, !z, iVar), materialFileDataA, dVar.k(), dVar.i(), dVar.j(), cVar.a(), customInfoData, cVar.e(), cVar.i(), dVar.s(), dVar.t(), "");
                            adItemData.b(materialFileDataA2);
                            adItemData.c(materialFileDataA3);
                            if (dVar.a()) {
                                adItemData.M();
                            }
                            arrayList.add(adItemData);
                            i3 = i5 + 1;
                        } else {
                            i = 0;
                        }
                        i4++;
                        i2 = i;
                        customInfoData = customInfoData;
                    }
                    i3 = i3;
                    i4++;
                    i2 = i;
                    customInfoData = customInfoData;
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
            com.opos.cmn.an.f.a.c("FallBackAdLoader", "", e);
            return new AdData(-1, "unknown error.");
        }
    }

    private void a(com.opos.mobad.b bVar, AdData adData, com.opos.mobad.model.d.a aVar, g gVar) {
        if (adData != null && aVar != null) {
            aVar.a(adData.d(), adData.e(), adData, new Object[0]);
        }
        if (adData == null || gVar == null) {
            return;
        }
        if (adData.d() != 10000) {
            gVar.b(bVar, adData.d());
        } else {
            gVar.c(bVar);
        }
    }

    private boolean a(com.opos.mobad.b bVar, com.opos.mobad.b.a.b bVar2, ab abVar, boolean z, i iVar) {
        if (!b.a(bVar.b(), abVar, iVar)) {
            return false;
        }
        if (!a.a(abVar)) {
            if (iVar != null) {
                iVar.b(abVar);
            }
            return false;
        }
        if (b.b(abVar) && !com.opos.mobad.cmn.func.b.i.a(bVar.b())) {
            if (iVar != null) {
                iVar.c(abVar);
            }
            return false;
        }
        if (!b.a(abVar)) {
            return true;
        }
        List<aa> list = abVar.ar;
        if (list == null || list.size() <= 0) {
            if (iVar != null) {
                iVar.d(abVar);
            }
            return false;
        }
        if (b.a(bVar, bVar2, list)) {
            return true;
        }
        com.opos.mobad.model.utils.d.a(bVar.b(), abVar);
        return true;
    }

    public void a(final com.opos.mobad.b bVar, final com.opos.mobad.model.b.c cVar, final String str, final com.opos.mobad.model.c.c cVar2, final com.opos.mobad.model.d.a aVar, final boolean z) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.a.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.opos.mobad.model.c.d dVar;
                g gVar;
                boolean z2;
                com.opos.mobad.model.c.d dVarA = com.opos.mobad.model.e.c.a().a(bVar.b());
                if (dVarA == null || z) {
                    com.opos.cmn.an.f.a.a("FallBackAdLoader", "fetch new fallback ad, isRefresh = " + z);
                    com.opos.mobad.model.c.c cVar3 = cVar2;
                    g gVar2 = new g(str, cVar3 != null ? cVar3.a() : "", false);
                    com.opos.mobad.model.b.a.a aVar2 = new com.opos.mobad.model.b.a.a(bVar, cVar);
                    if (!TextUtils.isEmpty(str)) {
                        dVarA = aVar2.a(str, cVar2, gVar2);
                    }
                    dVar = dVarA;
                    gVar = gVar2;
                    z2 = true;
                } else {
                    dVar = dVarA;
                    z2 = false;
                    gVar = null;
                }
                e.this.a(bVar, cVar2, dVar, z2, aVar, gVar);
            }
        });
    }

    protected final void a(com.opos.mobad.b bVar, com.opos.mobad.model.c.c cVar, com.opos.mobad.model.c.d dVar, boolean z, com.opos.mobad.model.d.a aVar, g gVar) {
        if (gVar != null) {
            gVar.b();
        }
        HashSet hashSet = new HashSet();
        AdData adDataA = a(bVar, cVar, dVar, z, gVar, hashSet, new HashSet());
        if (gVar != null) {
            gVar.c();
        }
        com.opos.cmn.an.f.a.b("FallBackAdLoader", "handleLoadResult AdData:", adDataA);
        a(bVar, hashSet, dVar, adDataA, aVar, z, gVar);
    }

    public void a(com.opos.mobad.b bVar, Set<com.opos.mobad.model.c.e> set, com.opos.mobad.model.c.d dVar, AdData adData, com.opos.mobad.model.d.a aVar, boolean z, g gVar) {
        if (adData == null || adData.d() != 10000) {
            com.opos.cmn.an.f.a.a("FallBackAdLoader", "adData is unavailable");
            a(bVar, adData, aVar, gVar);
            return;
        }
        if (z) {
            com.opos.mobad.model.e.c.a().a(bVar, dVar, dVar.c().s, 5);
            com.opos.mobad.model.utils.d.b(bVar.b(), adData);
        }
        if (set == null || set.size() <= 0) {
            com.opos.cmn.an.f.a.a("FallBackAdLoader", "do not need download material");
            if (gVar != null) {
                gVar.d();
            }
            a(bVar, adData, aVar, gVar);
            return;
        }
        boolean zA = (set == null || set.size() <= 0) ? true : this.f7153a.a(set, gVar, new CustomInfoData(dVar.r()));
        if (gVar != null) {
            gVar.d();
        }
        if (zA) {
            com.opos.cmn.an.f.a.a("FallBackAdLoader", "download material success");
            a(bVar, adData, aVar, gVar);
        } else {
            com.opos.cmn.an.f.a.a("FallBackAdLoader", "download material failed");
            a(bVar, new AdData(10011, "download material failed", adData.g(), adData.c()), aVar, gVar);
        }
    }
}
