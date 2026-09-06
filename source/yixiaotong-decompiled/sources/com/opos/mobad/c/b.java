package com.opos.mobad.c;

import android.content.Context;
import android.util.Log;
import com.opos.mobad.c.e.n;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f6708a;
    private volatile boolean b = false;
    private f c;
    private com.opos.mobad.c.a.d d;
    private com.opos.mobad.service.c.a e;
    private com.opos.mobad.c.a f;
    private g g;
    private com.opos.mobad.c.a.b h;
    private com.opos.mobad.c.d.a i;
    private n j;
    private com.opos.mobad.c.b.a k;
    private com.opos.mobad.service.tasks.c l;
    private com.opos.mobad.c.c.a m;

    private static class a implements com.opos.mobad.service.tasks.a.InterfaceC0997a {
        private a() {
        }

        @Override // com.opos.mobad.service.tasks.a.InterfaceC0997a
        public boolean a() {
            return !b.a().B();
        }

        @Override // com.opos.mobad.service.tasks.a.InterfaceC0997a
        public boolean b() {
            return com.opos.mobad.service.e.b.n().i();
        }

        @Override // com.opos.mobad.service.tasks.a.InterfaceC0997a
        public boolean c() {
            return com.opos.mobad.service.e.b.n().g();
        }

        @Override // com.opos.mobad.service.tasks.a.InterfaceC0997a
        public boolean d() {
            return com.opos.mobad.service.e.b.n().d();
        }

        @Override // com.opos.mobad.service.tasks.a.InterfaceC0997a
        public boolean e() {
            return com.opos.mobad.service.e.b.n().b();
        }

        @Override // com.opos.mobad.service.tasks.a.InterfaceC0997a
        public String f() {
            return com.opos.mobad.service.e.b.n().h();
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.c.b$b, reason: collision with other inner class name */
    public static class C0944b implements com.opos.mobad.service.b.d.a {
        @Override // com.opos.mobad.service.b.d.a
        public void a(String str, int i) {
            b.f().d().d(str, i);
        }
    }

    private b() {
        c cVar = new c();
        this.d = new com.opos.mobad.c.a.d(cVar);
        this.e = new com.opos.mobad.service.c.a();
        this.f = new com.opos.mobad.c.a(cVar);
        this.g = new g(cVar);
        this.h = new com.opos.mobad.c.a.b();
        this.i = new com.opos.mobad.c.d.a(cVar);
        this.j = new n(cVar);
        this.k = new com.opos.mobad.c.b.a(cVar);
        this.l = new com.opos.mobad.service.tasks.c(cVar);
        this.m = new com.opos.mobad.c.c.a(cVar);
        this.c = new f();
    }

    public static final com.opos.mobad.c.a.d a() {
        return n().d;
    }

    private final synchronized void a(Context context, e eVar, com.opos.mobad.service.e.d.f fVar, com.opos.mobad.service.e.d.InterfaceC0994d interfaceC0994d, com.opos.mobad.service.e.d.g gVar, com.opos.mobad.service.e.d.e eVar2, String str, com.opos.mobad.service.e.d.c cVar, com.opos.mobad.ad.e eVar3) {
        try {
            if (this.b) {
                com.opos.cmn.an.f.a.b("bService", "init() but had initialized.");
                return;
            }
            com.opos.mobad.ad.e cVar2 = eVar3 == null ? new com.opos.mobad.service.e.c() : eVar3;
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            k().a(eVar, str, cVar, cVar2.k(), cVar2.l(), cVar2.m());
            com.opos.mobad.service.d.a(origApplicationContext, eVar.f6714a, eVar.h, eVar.j);
            h().a();
            com.opos.mobad.service.d.a(origApplicationContext, eVar.g, eVar.h, eVar.l, cVar2);
            a().a(origApplicationContext, eVar.b, eVar.c, eVar.k, fVar.a(), eVar.f);
            f().a(origApplicationContext, eVar.b, fVar.a(), fVar.c());
            d().a(origApplicationContext, eVar.b, fVar.a(), eVar.k);
            com.opos.mobad.ad.e eVar4 = cVar2;
            com.opos.mobad.service.d.a(origApplicationContext, interfaceC0994d, gVar, fVar, eVar2, new C0944b(), eVar4);
            e().a(origApplicationContext);
            b().a(origApplicationContext, eVar.b, eVar.c, eVar.k, fVar.a());
            g().a(origApplicationContext);
            this.b = true;
            a(origApplicationContext, eVar.h, eVar.i);
            com.opos.cmn.an.f.a.b("bService", "init() custom default provider:", Boolean.valueOf(eVar4 instanceof com.opos.mobad.service.e.c));
        } catch (Exception e) {
            Log.e("bService", "init() fail", e);
            this.b = false;
            m();
        }
    }

    private void a(final Context context, final boolean z, final int i) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.i().a(StubApp.getOrigApplicationContext(context.getApplicationContext()), z, i, new a());
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("bService", "", e);
                }
            }
        });
    }

    public static final void a(Context context, boolean z, com.opos.mobad.service.e.d.a aVar, com.opos.mobad.service.e.d.f fVar, boolean z2, boolean z3, int i, com.opos.mobad.service.e.d.InterfaceC0994d interfaceC0994d, com.opos.mobad.service.e.d.g gVar, com.opos.mobad.service.e.d.c cVar, com.opos.mobad.ad.e eVar) {
        n().a(context, new e.a().a(z).a(aVar.a()).b(aVar.b()).a(aVar.d()).c(aVar.c()).b(z2).c(z3).b(i).c(0).d("CN").a(), fVar, interfaceC0994d, gVar, null, null, cVar, eVar);
    }

    public static final com.opos.mobad.service.c.a b() {
        return n().e;
    }

    public static final com.opos.mobad.c.a c() {
        return n().f;
    }

    public static final com.opos.mobad.c.a.b d() {
        return n().h;
    }

    public static final g e() {
        return n().g;
    }

    public static final com.opos.mobad.c.d.a f() {
        return n().i;
    }

    public static final n g() {
        return n().j;
    }

    public static final com.opos.mobad.c.b.a h() {
        return n().k;
    }

    public static final com.opos.mobad.service.tasks.c i() {
        return n().l;
    }

    public static final com.opos.mobad.c.c.a j() {
        return n().m;
    }

    public static final f k() {
        return n().c;
    }

    public static final boolean l() {
        return n().b;
    }

    public static final void m() {
        com.opos.mobad.service.d.a();
        synchronized (b.class) {
            b bVar = f6708a;
            if (bVar != null) {
                bVar.o();
                f6708a = null;
            }
        }
    }

    private static b n() {
        b bVar = f6708a;
        if (bVar == null) {
            synchronized (b.class) {
                bVar = new b();
                f6708a = bVar;
            }
        }
        return bVar;
    }

    private void o() {
        f fVarK = k();
        if (fVarK != null) {
            fVarK.o();
        }
        i().a();
        c().a();
    }
}
