package com.opos.mobad.g;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import com.opos.mobad.ad.d.j;
import com.opos.mobad.ad.d.m;
import com.opos.mobad.ad.d.n;
import com.opos.mobad.ad.d.o;
import com.opos.mobad.ad.d.s;
import com.opos.mobad.g.a.l;
import com.opos.mobad.g.b.g;
import com.opos.mobad.g.b.i;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.p;
import com.opos.mobad.q;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.c.a f6908a = new com.opos.mobad.ad.c.a(true, "");
    private AtomicBoolean c = new AtomicBoolean(false);
    private boolean d = false;
    private b b = new b();
    private com.opos.mobad.ad.privacy.a e = a();

    protected a() {
    }

    private com.opos.mobad.ad.b a(com.opos.mobad.g.b.a aVar, com.opos.mobad.c.a.d.a aVar2, com.opos.mobad.ad.c cVar) {
        if (aVar instanceof com.opos.mobad.g.b.b) {
            com.opos.mobad.g.b.b bVar = (com.opos.mobad.g.b.b) aVar;
            Point pointD = com.opos.mobad.c.b.a().d(bVar.f7009a);
            com.opos.mobad.ad.a.a.C0937a c0937a = new com.opos.mobad.ad.a.a.C0937a();
            if (pointD != null) {
                c0937a.a(pointD.x);
                c0937a.b(pointD.y);
            }
            return cVar.a((Activity) bVar.d, bVar.f7009a, aVar2.n, bVar.c, c0937a.a(), (com.opos.mobad.ad.a.c) bVar.e);
        }
        if (aVar instanceof com.opos.mobad.g.b.d) {
            com.opos.mobad.g.b.d dVar = (com.opos.mobad.g.b.d) aVar;
            return cVar.a((Activity) dVar.d, dVar.f7009a, aVar2.n, com.opos.mobad.c.b.a().a(dVar.f7009a) == com.opos.mobad.c.a.d.b, (com.opos.mobad.ad.c.d) dVar.e);
        }
        if (aVar instanceof com.opos.mobad.g.b.c) {
            com.opos.mobad.g.b.c cVar2 = (com.opos.mobad.g.b.c) aVar;
            return cVar.a((Activity) cVar2.d, cVar2.f7009a, aVar2.n, a(cVar2), (com.opos.mobad.ad.c.b) cVar2.e);
        }
        if (aVar instanceof com.opos.mobad.g.b.e) {
            com.opos.mobad.g.b.e eVar = (com.opos.mobad.g.b.e) aVar;
            return cVar.a(eVar.c, eVar.f7009a, aVar2.n, aVar2.q, aVar2.p, (j) eVar.d, this.e);
        }
        if (aVar instanceof g) {
            g gVar = (g) aVar;
            return cVar.a(gVar.c, gVar.e, gVar.f7009a, aVar2.n, (o) gVar.d);
        }
        if (aVar instanceof i) {
            i iVar = (i) aVar;
            return cVar.a(iVar.d, iVar.f7009a, aVar2.n, com.opos.mobad.c.b.a().a(iVar.f7009a) == com.opos.mobad.c.a.d.b, (com.opos.mobad.ad.e.b) iVar.e);
        }
        if (!(aVar instanceof com.opos.mobad.g.b.j)) {
            com.opos.cmn.an.f.a.b("AdBaseFactory", "fail create:" + aVar);
            return null;
        }
        com.opos.mobad.g.b.j jVar = (com.opos.mobad.g.b.j) aVar;
        f fVar = new f();
        com.opos.mobad.ad.f.b bVarA = cVar.a((Activity) jVar.d, jVar.f7009a, aVar2.n, jVar.c, (com.opos.mobad.ad.f.c) jVar.e);
        fVar.a(bVarA);
        return bVarA;
    }

    private com.opos.mobad.ad.b a(com.opos.mobad.g.b.a aVar, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, int i) {
        com.opos.cmn.an.f.a.a("AdBaseFactory", "create ssp posId:" + aVar.f7009a + "," + list + ",reserve =" + aVar2 + "," + i);
        return a(aVar, a(aVar.f7009a, list.get(0)), new d(new com.opos.mobad.g.a.e.c(i, aVar.b), list, aVar2, j, this.b));
    }

    private com.opos.mobad.ad.b a(com.opos.mobad.g.b.a aVar, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, long j2) {
        com.opos.mobad.c.a.d.a aVarA = a(aVar.f7009a, list, aVar2, j);
        com.opos.cmn.an.f.a.a("AdBaseFactory", "create delegator posId:" + aVar.f7009a + "," + list + "," + aVarA);
        return a(aVar, b(aVar.f7009a, list.get(0)), new d(new com.opos.mobad.g.a.e.b(aVar.b), list, aVarA, j2, this.b));
    }

    private com.opos.mobad.ad.c.e a(com.opos.mobad.g.b.c cVar) {
        return new com.opos.mobad.ad.c.e.a().a(com.opos.mobad.c.b.a().a(cVar.f7009a) == com.opos.mobad.c.a.d.b).b(com.opos.mobad.c.b.a().e(cVar.f7009a)).a(cVar.c).a();
    }

    public static com.opos.mobad.ad.privacy.a a() {
        return new com.opos.mobad.cmn.a.c(new q());
    }

    private com.opos.mobad.c.a.d.a a(String str) {
        return new com.opos.mobad.c.a.d.a(com.opos.mobad.c.a.d.a.f6704a, str, 100, 30000L, 0, 0);
    }

    private com.opos.mobad.c.a.d.a a(String str, com.opos.mobad.c.a.d.a aVar) {
        return new com.opos.mobad.c.a.d.a(com.opos.mobad.c.a.d.a.f6704a, str, 100, 30000L, aVar.p, aVar.q);
    }

    private com.opos.mobad.c.a.d.a a(String str, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar, long j) {
        boolean z = false;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z2 = false;
        for (com.opos.mobad.c.a.d.a aVar2 : list) {
            i2 = aVar2.p;
            i3 = aVar2.q;
            i += aVar2.r;
            z = z || com.opos.mobad.c.a.d.a.f6704a == aVar2.m;
            z2 = z2 || (aVar != null && aVar.m == aVar2.m && aVar2.r > 0);
        }
        if (!z && i < 100) {
            list.add(new com.opos.mobad.c.a.d.a(com.opos.mobad.c.a.d.a.f6704a, str, 100 - i, j, i2, i3));
            z = true;
        }
        if (!z2 && aVar != null) {
            return aVar;
        }
        if (z) {
            return null;
        }
        return new com.opos.mobad.c.a.d.a(com.opos.mobad.c.a.d.a.f6704a, str, 100, j, i2, i3);
    }

    private com.opos.mobad.c.a.d.a a(List<com.opos.mobad.c.a.d.a> list, String str, long j) {
        List<com.opos.mobad.c.a.d.a> arrayList = list == null ? new ArrayList<>() : list;
        com.opos.mobad.c.a.d.a aVar = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (com.opos.mobad.c.a.d.a aVar2 : arrayList) {
            if (com.opos.mobad.c.a.d.a.f6704a == aVar2.m) {
                aVar = aVar2;
            }
            i2 = aVar2.p;
            i3 = aVar2.q;
            i += aVar2.r;
        }
        if (aVar != null) {
            return aVar;
        }
        com.opos.mobad.c.a.d.a aVar3 = new com.opos.mobad.c.a.d.a(com.opos.mobad.c.a.d.a.f6704a, str, Math.max(0, 100 - i), j, i2, i3);
        arrayList.add(aVar3);
        return aVar3;
    }

    private com.opos.mobad.ad.b b(com.opos.mobad.g.b.a aVar) {
        com.opos.cmn.an.f.a.a("AdBaseFactory", "create default posId:" + aVar.f7009a);
        ArrayList arrayList = new ArrayList();
        com.opos.mobad.c.a.d.a aVarA = a(aVar.f7009a);
        return a(aVar, aVarA, new d(new com.opos.mobad.g.a.e.b(aVar.b), arrayList, aVarA, 0L, this.b));
    }

    private com.opos.mobad.c.a.d.a b(String str, com.opos.mobad.c.a.d.a aVar) {
        return new com.opos.mobad.c.a.d.a(com.opos.mobad.c.a.d.a.f6704a, str, 100, 30000L, aVar.p, aVar.q);
    }

    private boolean e() {
        if (this.f6908a.f6642a || !com.opos.cmn.a.a.a()) {
            return com.opos.mobad.c.b.a().b();
        }
        com.opos.cmn.an.f.a.b("AdBaseFactory", "check result fail:" + this.f6908a.b);
        return false;
    }

    public com.opos.mobad.ad.a.b a(Activity activity, String str, com.opos.mobad.ad.a.c cVar) {
        return (com.opos.mobad.ad.a.b) a(new com.opos.mobad.g.b.b(activity, str, com.opos.mobad.c.b.a().i(), true, cVar));
    }

    protected com.opos.mobad.ad.b a(com.opos.mobad.g.b.a aVar) {
        com.opos.mobad.g.b.a bVar;
        com.opos.mobad.c.a.d.b bVarA = e() ? com.opos.mobad.c.b.a().a(aVar.f7009a, true) : null;
        if (bVarA == null || bVarA.f6705a == null || bVarA.f6705a.size() <= 0) {
            return b(aVar);
        }
        if (aVar instanceof com.opos.mobad.g.b.b) {
            com.opos.mobad.g.b.b bVar2 = (com.opos.mobad.g.b.b) aVar;
            bVar = new com.opos.mobad.g.b.b((Activity) bVar2.d, aVar.f7009a, aVar.b, false, (com.opos.mobad.ad.a.c) bVar2.e);
        } else {
            bVar = aVar;
        }
        return bVarA.e != 1 ? a(bVar, bVarA.f6705a, a(bVarA.f6705a, aVar.f7009a, bVarA.c), bVarA.d, bVarA.e) : a(bVar, bVarA.f6705a, bVarA.b, bVarA.c, bVarA.d);
    }

    public com.opos.mobad.ad.c.a a(Activity activity, String str, com.opos.mobad.ad.c.e eVar, com.opos.mobad.ad.c.b bVar) {
        com.opos.mobad.ad.c.e.b bVar2 = com.opos.mobad.ad.c.e.b.NORMAL;
        if (eVar != null) {
            bVar2 = eVar.c;
        }
        return (com.opos.mobad.ad.c.a) a((com.opos.mobad.g.b.a) new com.opos.mobad.g.b.c(activity, str, com.opos.mobad.c.b.a().n(), bVar2, bVar));
    }

    public com.opos.mobad.ad.c.c a(Activity activity, String str, com.opos.mobad.ad.c.d dVar) {
        return (com.opos.mobad.ad.c.c) a(new com.opos.mobad.g.b.d(activity, str, com.opos.mobad.c.b.a().p(), dVar));
    }

    public com.opos.mobad.ad.d.c a(Context context, String str, int i, m mVar) {
        com.opos.mobad.ad.c cVarB;
        b bVar = this.b;
        if (bVar == null || (cVarB = bVar.b(com.opos.mobad.c.a.d.a.f6704a)) == null || (cVarB instanceof p)) {
            return null;
        }
        if (cVarB instanceof com.opos.mobad.o) {
            return ((com.opos.mobad.o) cVarB).a(context, str, str, i, mVar);
        }
        if (cVarB instanceof com.opos.mobad.g.a.d.b) {
            return ((com.opos.mobad.g.a.d.b) cVarB).a(context, str, str, i, mVar);
        }
        return null;
    }

    public com.opos.mobad.ad.d.c a(Context context, String str, com.opos.mobad.ad.d.f fVar) {
        com.opos.mobad.ad.c cVarB;
        b bVar = this.b;
        if (bVar == null || (cVarB = bVar.b(com.opos.mobad.c.a.d.a.f6704a)) == null) {
            return null;
        }
        return cVarB.a(context, str, str, fVar);
    }

    public com.opos.mobad.ad.d.g a(Context context, String str, j jVar) {
        return (com.opos.mobad.ad.d.g) a(new com.opos.mobad.g.b.e(context, str, com.opos.mobad.c.b.a().s(), jVar));
    }

    public n a(Context context, String str, s sVar, o oVar) {
        return (n) a(new g(context, str, com.opos.mobad.c.b.a().u(), sVar, oVar));
    }

    public com.opos.mobad.ad.e.a a(Context context, String str, com.opos.mobad.ad.e.b bVar) {
        return (com.opos.mobad.ad.e.a) a(new i(context, str, com.opos.mobad.c.b.a().q(), bVar));
    }

    public com.opos.mobad.ad.f.a a(Context context, String str, com.opos.mobad.ad.f.c cVar, com.opos.mobad.ad.f.f fVar) {
        a(context);
        return new com.opos.mobad.g.a.c(context, str, fVar, cVar, this.b);
    }

    public com.opos.mobad.ad.f.b a(Activity activity, String str, com.opos.mobad.ad.f.c cVar, com.opos.mobad.ad.f.f fVar) {
        a(activity);
        return new l(activity, str, fVar, cVar, this.b);
    }

    public String a(String str, int i) {
        b bVar = this.b;
        if (bVar == null) {
            com.opos.cmn.an.f.a.d("AdBaseFactory", "not init error");
            return null;
        }
        com.opos.mobad.ad.c cVarB = bVar.b(com.opos.mobad.c.a.d.a.f6704a);
        if (cVarB != null) {
            return cVarB.a(str, i);
        }
        com.opos.cmn.an.f.a.a("", "get token but null adCreator");
        return null;
    }

    protected void a(Context context) {
        this.b.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), com.opos.mobad.c.b.a(), this.d);
    }

    protected void a(Context context, Integer num, com.opos.mobad.ad.c cVar) {
        com.opos.cmn.an.f.a.b("AdBaseFactory", "checkAndAddCreator:" + num + ", creator:" + cVar.getClass().getName());
        com.opos.mobad.ad.c.a aVarA = this.b.a(context, num, cVar);
        if (aVarA.f6642a) {
            return;
        }
        this.f6908a = aVarA;
    }

    protected void a(final Context context, final boolean z) {
        this.d = z;
        com.opos.mobad.c.b.a().a(new com.opos.mobad.c.a.d.InterfaceC0943d() { // from class: com.opos.mobad.g.a.1
            @Override // com.opos.mobad.c.a.d.InterfaceC0943d
            public void a(boolean z2) {
                a.this.b.a(context, com.opos.mobad.c.b.a(), z);
                final com.opos.mobad.c.a.a aVarM = com.opos.mobad.c.b.a().m();
                if (!aVarM.a() || z2) {
                    return;
                }
                com.opos.cmn.an.f.a.a("AdBaseFactory", "refresh bottom ad start");
                final com.opos.mobad.b bVarB = com.opos.mobad.d.a().b(context);
                final String strB = aVarM.b();
                if (TextUtils.isEmpty(strB)) {
                    com.opos.cmn.an.f.a.a("AdBaseFactory", "BottomReqAdPosId is empty.");
                } else {
                    com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.g.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.opos.mobad.s.c.b(context, "fallbackAdPosId", strB);
                            com.opos.mobad.model.b.a(context).a(bVarB, strB, new com.opos.mobad.model.b.a() { // from class: com.opos.mobad.g.a.1.1.1
                                @Override // com.opos.mobad.model.b.a
                                public void a(int i, AdHelper.AdHelperData adHelperData) {
                                    com.opos.cmn.an.f.a.a("AdBaseFactory", "refresh bottom ad success");
                                }

                                @Override // com.opos.mobad.model.b.a
                                public void a(int i, String str, AdData adData) {
                                    com.opos.cmn.an.f.a.a("AdBaseFactory", "refresh bottom ad failed, code = " + i, "msg = " + str);
                                }
                            }, aVarM.a());
                        }
                    });
                }
            }
        });
        this.b.a(context, com.opos.mobad.c.b.a(), z);
    }

    public com.opos.mobad.ad.c.a b() {
        return this.f6908a;
    }

    public com.opos.mobad.ad.f.b b(Activity activity, String str, com.opos.mobad.ad.f.c cVar, com.opos.mobad.ad.f.f fVar) {
        a(activity);
        return new l(activity, str, fVar, cVar, this.b);
    }

    public boolean c() {
        return this.b.a();
    }

    protected void d() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.b();
        }
    }
}
