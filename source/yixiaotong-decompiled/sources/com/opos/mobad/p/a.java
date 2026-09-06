package com.opos.mobad.p;

import android.app.Activity;
import android.view.View;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.utils.AdHelper;
import com.stub.StubApp;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends com.opos.mobad.q.b implements com.opos.mobad.ad.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.mobad.b f7244a;
    private final b b;
    private final String c;
    private String d;
    private final com.opos.mobad.ad.f.f g;
    private int h;
    private AdHelper.AdHelperData i;

    /* JADX INFO: renamed from: com.opos.mobad.p.a$2, reason: invalid class name */
    class AnonymousClass2 implements com.opos.mobad.model.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7246a;

        AnonymousClass2(String str) {
            this.f7246a = str;
        }

        @Override // com.opos.mobad.model.b.a
        public void a(final int i, final AdHelper.AdHelperData adHelperData) {
            if (adHelperData == null || adHelperData.f7215a.a() != 0) {
                a.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.p.a.2.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        a.this.d = AnonymousClass2.this.f7246a;
                        a.this.h = i;
                        if (adHelperData != null) {
                            a.this.i = adHelperData;
                            com.opos.cmn.an.f.a.b("InterHotSplashStateAd", "fetchAd success");
                            final f.a aVarA = f.a(a.this.g, adHelperData);
                            if (aVarA != null) {
                                a.this.a(new Runnable() { // from class: com.opos.mobad.p.a.2.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        a.this.a(aVarA, AnonymousClass2.this.f7246a);
                                    }
                                });
                            } else {
                                com.opos.cmn.an.f.a.c("InterHotSplashStateAd", "splashVo data is null!");
                            }
                        }
                        return true;
                    }
                });
                return;
            }
            a.this.f7244a.j().a(a.this.c, 6, adHelperData.c.f(), adHelperData.c.b(), adHelperData.d.X(), adHelperData.c.a(), adHelperData.c.O());
            a.this.h = adHelperData.f7215a.c();
            a.this.d(-1, com.opos.mobad.ad.a.a(-1));
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i, String str, AdData adData) {
            com.opos.cmn.an.f.a.b("InterHotSplashStateAd", "fetchAd failed,[code, msg] = " + i + "," + str);
            if (adData != null) {
                a.this.h = adData.c();
            }
            a.this.c(i, str);
        }
    }

    public a(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.ad.f.c cVar, com.opos.mobad.ad.f.f fVar, com.opos.mobad.cmn.a.b bVar2, com.opos.mobad.cmn.func.adhandler.f fVar2) {
        super(cVar);
        com.opos.mobad.b bVarC = bVar.c();
        this.f7244a = bVarC;
        this.c = str;
        this.g = fVar;
        com.opos.mobad.cmn.func.adhandler.a aVar2 = new com.opos.mobad.cmn.func.adhandler.a(bVarC, str, aVar, fVar2);
        if (cVar instanceof com.opos.mobad.ad.f) {
            aVar2.a((com.opos.mobad.ad.f) cVar);
        }
        this.b = new b(bVarC, str, aVar2, new d() { // from class: com.opos.mobad.p.a.1
            @Override // com.opos.mobad.cmn.func.a.a.b
            public void a(int i, String str2) {
                a.this.d(i, str2);
            }

            @Override // com.opos.mobad.ad.l.b
            public void a(long j) {
                a.this.l();
            }

            @Override // com.opos.mobad.ad.l.b
            public void a(String str2) {
                a.this.e(str2);
            }

            @Override // com.opos.mobad.cmn.func.a.a.b
            public void d() {
                a.this.m();
            }
        }, bVar2);
    }

    private static com.opos.mobad.template.d a(f.a aVar) {
        final com.opos.mobad.ad.f.d dVarB = aVar.b();
        if (dVarB != null) {
            return new com.opos.mobad.template.d() { // from class: com.opos.mobad.p.a.3
                @Override // com.opos.mobad.template.d
                public View a() {
                    return dVarB.a();
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f.a aVar, String str) {
        if (this.b != null) {
            this.b.a(aVar, com.opos.mobad.ui.c.b.a().a(this.f7244a.b(), aVar.b, null), e.a(aVar, this.f7244a.b(), aVar.f7260a), a(aVar), str);
        }
    }

    @Override // com.opos.mobad.ad.f.a
    public void a(Activity activity) {
        this.b.a(activity);
        com.opos.mobad.cmn.func.b.e.a(this.f7244a, this.c, this.d, this.i);
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b() {
        com.opos.cmn.an.f.a.b("InterHotSplashStateAd", "destroyAd");
        super.b();
        b bVar = this.b;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b(String str) {
        super.a(str, 3000);
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i) {
        return b(str, i, (List<String>) null);
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i, List<String> list) {
        this.h = 0;
        com.opos.mobad.model.b.a(StubApp.getOrigApplicationContext(this.f7244a.b().getApplicationContext())).a(this.f7244a, this.c, 6, str, i, new AnonymousClass2(str), list);
        return true;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void c(int i) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.b(i);
        }
    }

    @Override // com.opos.mobad.q.j
    protected boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int e() {
        AdHelper.AdHelperData adHelperData;
        return (!d() || (adHelperData = this.i) == null) ? super.e() : adHelperData.c.ab();
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int f() {
        AdHelper.AdHelperData adHelperData;
        return (!d() || (adHelperData = this.i) == null) ? super.f() : adHelperData.c.ac();
    }

    @Override // com.opos.mobad.ad.f.b
    public View g() {
        b bVar;
        if (!g.d() || 5 == c() || (bVar = this.b) == null) {
            return null;
        }
        return bVar.a();
    }
}
