package com.opos.mobad.h;

import android.app.Activity;
import android.os.RemoteException;
import android.text.TextUtils;
import com.opos.mobad.ad.f;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.utils.AdHelper;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends com.opos.mobad.q.c implements com.opos.mobad.ad.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f7022a;
    private com.opos.mobad.h.a b;
    private String c;
    private String d;
    private com.opos.mobad.ad.c.e g;
    private AdHelper.AdHelperData h;
    private int i;
    private int j;
    private com.opos.mobad.cmn.func.adhandler.a.c k;
    private com.opos.mobad.cmn.func.a l;
    private com.opos.mobad.cmn.func.adhandler.a m;
    private com.opos.mobad.video.player.d n;
    private BinderC0968b o;
    private com.opos.mobad.video.player.b.c p;

    private class a extends com.opos.mobad.video.player.b.c implements com.opos.mobad.ad.b.a, f {
        private com.opos.mobad.ad.c.b b;

        public a(com.opos.mobad.ad.c.b bVar) {
            this.b = bVar;
        }

        private void e() {
            if (b.this.h == null || b.this.h.d == null || b.this.h.d.Q() != 0 || TextUtils.isEmpty(b.this.h.d.u())) {
                return;
            }
            b.this.m.a(b.this.h.c, null, b.this.o);
        }

        @Override // com.opos.mobad.cmn.func.a.a.b
        public void a(int i, String str) {
            b.this.d(i, str);
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(long j) {
            b.this.p();
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
            b.this.q();
        }

        @Override // com.opos.mobad.ad.f
        public void a(Map<String, String> map) {
            com.opos.mobad.ad.c.b bVar = this.b;
            if (bVar instanceof f) {
                ((f) bVar).a(map);
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void c() {
            com.opos.mobad.ad.c.b bVar = this.b;
            if (bVar instanceof com.opos.mobad.ad.b.a) {
                ((com.opos.mobad.ad.b.a) bVar).c();
            }
        }

        @Override // com.opos.mobad.cmn.func.a.a.b
        public void d() {
            com.opos.mobad.h.a aVar = b.this.b;
            if (aVar != null) {
                aVar.a();
            }
            b.this.m();
        }

        @Override // com.opos.mobad.video.player.b.c, com.opos.mobad.m.d.a
        public void g_() {
            e();
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.h.b$b, reason: collision with other inner class name */
    private class BinderC0968b extends com.opos.mobad.t.a.AbstractBinderC0999a {
        private BinderC0968b() {
        }

        @Override // com.opos.mobad.t.a
        public void a() {
            if (b.this.c() == 5) {
                return;
            }
            com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.h.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    com.opos.mobad.h.a aVar = b.this.b;
                    if (aVar != null) {
                        aVar.a();
                    }
                    b.this.m();
                }
            });
        }

        @Override // com.opos.mobad.t.a
        public void a(com.opos.mobad.t.b bVar) {
        }

        @Override // com.opos.mobad.t.a
        public void a(Map map) throws RemoteException {
        }
    }

    public b(Activity activity, com.opos.mobad.b bVar, String str, com.opos.mobad.ad.c.e eVar, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.ad.c.b bVar2, com.opos.mobad.video.player.d dVar, com.opos.mobad.cmn.func.adhandler.f fVar) {
        super(bVar2);
        this.f7022a = bVar.c();
        this.c = str;
        this.g = eVar;
        this.l = aVar;
        this.p = new a(bVar2);
        com.opos.mobad.cmn.func.adhandler.a aVar2 = new com.opos.mobad.cmn.func.adhandler.a(bVar, this.c, this.l, fVar);
        this.m = aVar2;
        if (bVar2 instanceof f) {
            aVar2.a((f) bVar2);
        }
        com.opos.mobad.cmn.func.adhandler.a.c cVarB = g.b(activity);
        this.k = cVarB;
        this.m.a(cVarB);
        this.n = dVar;
        this.o = new BinderC0968b();
    }

    private int a(AdHelper.AdHelperData adHelperData) {
        if (!com.opos.mobad.ui.c.f.a(adHelperData.d.Z())) {
            return 10000;
        }
        if (adHelperData.c.t() == 1 && TextUtils.isEmpty(com.opos.cmn.d.d.a(this.f7022a.b(), adHelperData.e.a(), adHelperData.e.b()))) {
            com.opos.cmn.an.f.a.b("InterInterstitialAd", "illegal cache url");
            return 10408;
        }
        if (!com.opos.cmn.an.h.c.a.d(this.f7022a.b())) {
            com.opos.cmn.an.f.a.b("InterInterstitialAd", "no net");
            return 10403;
        }
        if (System.currentTimeMillis() <= adHelperData.c.u()) {
            return 10000;
        }
        com.opos.cmn.an.f.a.b("InterInterstitialAd", "exp time");
        return 10404;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.opos.mobad.ad.c.e.b g() {
        com.opos.mobad.ad.c.e eVar = this.g;
        return eVar != null ? eVar.c : com.opos.mobad.ad.c.e.b.NORMAL;
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public synchronized void b() {
        com.opos.cmn.an.f.a.b("InterInterstitialAd", "destroyAd");
        if (g.d()) {
            com.opos.mobad.cmn.func.adhandler.a.c cVar = this.k;
            if (cVar != null) {
                cVar.a();
                this.k = null;
            }
            com.opos.mobad.h.a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
            super.b();
        }
        if (this.f7022a != null) {
            this.f7022a = null;
        }
    }

    @Override // com.opos.mobad.q.k
    protected boolean b(Activity activity) {
        com.opos.cmn.an.f.a.b("InterInterstitialAd", "doShow()");
        com.opos.mobad.cmn.func.b.e.a(this.f7022a, this.c, this.d, this.h);
        if (com.opos.cmn.i.b.a(activity)) {
            d(-1, "Activity is null or activity is finishing.");
            com.opos.cmn.an.f.a.b("InterInterstitialAd", "doShow() show but activity error");
            return false;
        }
        AdHelper.AdHelperData adHelperData = this.h;
        if (adHelperData == null) {
            d(-1, com.opos.mobad.ad.a.a(-1));
            com.opos.cmn.an.f.a.b("InterInterstitialAd", "doShow() show but data null");
            return false;
        }
        if (adHelperData != null && adHelperData.f7215a.a() == 0) {
            this.f7022a.j().a(this.c, 2, this.h.c.f(), this.h.c.b(), this.h.d.X(), this.h.c.a(), this.h.c.O());
            d(-1, com.opos.mobad.ad.a.a(-1));
            com.opos.cmn.an.f.a.b("InterInterstitialAd", "doShow() show but vip");
            return false;
        }
        int iA = a(this.h);
        if (10000 != iA) {
            com.opos.cmn.an.f.a.b("InterInterstitialAd", "illegal play video condition");
            d(iA, com.opos.mobad.ad.a.a(iA));
            return false;
        }
        com.opos.mobad.h.a aVarA = c.a(activity, this.f7022a, this.c, g(), this.p, this.n, this.m, this.h, this.j);
        this.b = aVarA;
        return aVarA.a(activity, this.d);
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i) {
        return b(str, i, (List<String>) null);
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(final String str, int i, List<String> list) {
        com.opos.cmn.an.f.a.b("InterInterstitialAd", "doLoad");
        this.i = 0;
        this.j = 0;
        com.opos.mobad.model.b.a(StubApp.getOrigApplicationContext(this.f7022a.b().getApplicationContext())).a(this.f7022a, this.c, 2, str, i, new com.opos.mobad.model.b.a() { // from class: com.opos.mobad.h.b.1
            @Override // com.opos.mobad.model.b.a
            public void a(final int i2, final AdHelper.AdHelperData adHelperData) {
                b.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.h.b.1.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        com.opos.cmn.an.f.a.b("InterInterstitialAd", " call load succ");
                        b.this.i = i2;
                        b.this.h = adHelperData;
                        b.this.d = str;
                        return true;
                    }
                });
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i2, String str2, AdData adData) {
                b.this.c(i2, str2);
                if (adData != null) {
                    b.this.i = adData.c();
                }
                try {
                    if (b.this.g() == com.opos.mobad.ad.c.e.b.INSTANT_EXIT) {
                        b.this.f7022a.i().b(b.this.c);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("InterInterstitialAd", "reportDefaultInstantExit()", e);
                }
            }
        }, list);
        return true;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void c(int i) {
        this.j = i;
    }

    @Override // com.opos.mobad.q.j
    protected boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int e() {
        AdHelper.AdHelperData adHelperData;
        return (!d() || (adHelperData = this.h) == null) ? super.e() : adHelperData.c.ab();
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int f() {
        AdHelper.AdHelperData adHelperData;
        return (!d() || (adHelperData = this.h) == null) ? super.f() : adHelperData.c.ac();
    }
}
