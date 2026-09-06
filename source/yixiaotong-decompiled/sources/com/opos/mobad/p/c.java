package com.opos.mobad.p;

import android.app.Activity;
import android.view.View;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.q.i;
import com.stub.StubApp;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends i implements com.opos.mobad.ad.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.mobad.b f7253a;
    private final b b;
    private final String c;
    private com.opos.mobad.ad.f.f d;
    private int g;
    private AdHelper.AdHelperData h;

    /* JADX INFO: renamed from: com.opos.mobad.p.c$2, reason: invalid class name */
    class AnonymousClass2 implements com.opos.mobad.model.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7255a;

        AnonymousClass2(String str) {
            this.f7255a = str;
        }

        @Override // com.opos.mobad.model.b.a
        public void a(final int i, final AdHelper.AdHelperData adHelperData) {
            if (adHelperData == null || adHelperData.f7215a.a() != 0) {
                c.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.p.c.2.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        c.this.g = i;
                        if (adHelperData != null) {
                            c.this.h = adHelperData;
                            com.opos.cmn.an.f.a.b("InterSplash$StateAd", "fetchAd success");
                            final f.a aVarA = f.a(c.this.d, adHelperData);
                            if (aVarA != null) {
                                c.this.a(new Runnable() { // from class: com.opos.mobad.p.c.2.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        c.this.a(aVarA, AnonymousClass2.this.f7255a);
                                    }
                                });
                            } else {
                                com.opos.cmn.an.f.a.c("InterSplash$StateAd", "splashVo data is null!");
                            }
                        }
                        return true;
                    }
                });
                return;
            }
            c.this.f7253a.j().a(c.this.c, 3, adHelperData.c.f(), adHelperData.c.b(), adHelperData.d.X(), adHelperData.c.a(), adHelperData.c.O());
            c.this.g = adHelperData.f7215a.c();
            c.this.d(-1, com.opos.mobad.ad.a.a(-1));
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i, String str, AdData adData) {
            com.opos.cmn.an.f.a.b("InterSplash$StateAd", "fetchAd failed,[code, msg] = " + i + "," + str);
            if (adData != null) {
                c.this.g = adData.c();
            }
            c.this.c(i, str);
        }
    }

    public c(Activity activity, com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.ad.f.c cVar, com.opos.mobad.ad.f.f fVar, com.opos.mobad.cmn.func.adhandler.f fVar2) {
        super(cVar);
        com.opos.mobad.b bVarC = bVar.c();
        this.f7253a = bVarC;
        this.c = str;
        this.d = fVar;
        b bVar2 = new b(bVarC, str, new com.opos.mobad.cmn.func.adhandler.a(bVarC, str, aVar, fVar2), new d() { // from class: com.opos.mobad.p.c.1
            @Override // com.opos.mobad.cmn.func.a.a.b
            public void a(int i, String str2) {
                c.this.d(i, str2);
            }

            @Override // com.opos.mobad.ad.l.b
            public void a(long j) {
                c.this.l();
            }

            @Override // com.opos.mobad.ad.l.b
            public void a(String str2) {
                c.this.e(str2);
            }

            @Override // com.opos.mobad.cmn.func.a.a.b
            public void d() {
                c.this.m();
            }
        });
        this.b = bVar2;
        bVar2.a(activity);
    }

    private static com.opos.mobad.template.d a(f.a aVar) {
        final com.opos.mobad.ad.f.d dVarB = aVar.b();
        if (dVarB != null) {
            return new com.opos.mobad.template.d() { // from class: com.opos.mobad.p.c.3
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
            this.b.a(aVar, com.opos.mobad.ui.c.b.a().a(this.f7253a.b(), aVar.b, null), e.a(aVar, this.f7253a.b(), aVar.f7260a), a(aVar), str);
        }
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b() {
        com.opos.cmn.an.f.a.b("InterSplash$StateAd", "destroyAd");
        super.b();
        if (g.d()) {
            this.b.b();
        }
        this.d = null;
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b(String str) {
        super.a(str, 3000);
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i) {
        this.g = 0;
        com.opos.mobad.model.b.a(StubApp.getOrigApplicationContext(this.f7253a.b().getApplicationContext())).a(this.f7253a, this.c, 3, str, i, new AnonymousClass2(str));
        return true;
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

    @Override // com.opos.mobad.ad.f.b
    public View g() {
        b bVar;
        if (!g.d() || 5 == c() || (bVar = this.b) == null) {
            return null;
        }
        return bVar.a();
    }
}
