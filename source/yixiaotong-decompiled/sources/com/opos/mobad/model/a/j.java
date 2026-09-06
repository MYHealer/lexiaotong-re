package com.opos.mobad.model.a;

import com.google.android.exoplayer2.C;
import com.opos.cmn.i.n;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class j extends com.opos.mobad.model.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f7159a;
    private m b;
    private com.opos.mobad.model.e.g c;
    private com.opos.mobad.model.c.c d;
    private int e;
    private int f;
    private AdData g;
    private AdData h;
    private CountDownLatch i;
    private CountDownLatch j;
    private n k;
    private boolean l;
    private com.opos.mobad.model.e.f m;
    private com.opos.mobad.b n;

    private static class a implements com.opos.mobad.model.e.g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.opos.mobad.model.e.h.a f7164a;

        public a(com.opos.mobad.model.e.h.a aVar) {
            this.f7164a = aVar;
        }

        @Override // com.opos.mobad.model.e.g.a
        public void a(AdData adData) {
            com.opos.mobad.model.e.h.a aVar = this.f7164a;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.opos.mobad.model.e.g.a
        public void b(AdData adData) {
            com.opos.mobad.model.e.h.a aVar = this.f7164a;
            if (aVar != null) {
                aVar.a(adData);
            }
        }

        @Override // com.opos.mobad.model.e.g.a
        public void c(AdData adData) {
            com.opos.mobad.model.e.h.a aVar = this.f7164a;
            if (aVar != null) {
                aVar.b(adData);
            }
        }

        @Override // com.opos.mobad.model.e.g.a
        public void d(AdData adData) {
            com.opos.mobad.model.e.h.a aVar = this.f7164a;
            if (aVar != null) {
                aVar.c(adData);
            }
        }
    }

    public j(com.opos.mobad.b bVar, String str, String str2, com.opos.mobad.model.c.c cVar, boolean z, com.opos.mobad.model.b.c cVar2, int i, int i2, com.opos.mobad.model.e.h.a aVar) {
        super(new a(aVar));
        this.i = new CountDownLatch(2);
        this.j = new CountDownLatch(2);
        this.l = false;
        this.n = bVar;
        this.d = cVar;
        this.m = new com.opos.mobad.model.e.f(str, str2);
        this.e = i;
        this.f = Math.max(i2, 0);
        this.k = new n(com.opos.mobad.service.c.a(), new Runnable() { // from class: com.opos.mobad.model.a.j.1
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("mLoader", "total timeout");
                j.this.l = true;
                j.this.l();
            }
        });
        this.f7159a = new c(bVar, str, str2, cVar, z, new com.opos.mobad.model.e.g.a() { // from class: com.opos.mobad.model.a.j.2
            @Override // com.opos.mobad.model.e.g.a
            public void a(AdData adData) {
                j.this.h = adData;
                j.this.i.countDown();
                com.opos.cmn.an.f.a.b("mLoader", "cache loaded");
                j.this.j.countDown();
                j.this.j.countDown();
            }

            @Override // com.opos.mobad.model.e.g.a
            public void b(AdData adData) {
                j.this.i.countDown();
                com.opos.cmn.an.f.a.b("mLoader", "cache load fail");
                j.this.h = adData;
                j.this.j.countDown();
            }

            @Override // com.opos.mobad.model.e.g.a
            public void c(AdData adData) {
                if (j.this.c == j.this.f7159a) {
                    j.this.k.a();
                    j.this.d(adData);
                }
            }

            @Override // com.opos.mobad.model.e.g.a
            public void d(AdData adData) {
                if (j.this.c == j.this.f7159a) {
                    j.this.k.a();
                    j.this.c(adData);
                }
            }
        });
        this.b = new m(bVar, str, str2, cVar, z, new com.opos.mobad.model.e.g.a() { // from class: com.opos.mobad.model.a.j.3
            @Override // com.opos.mobad.model.e.g.a
            public void a(AdData adData) {
                com.opos.cmn.an.f.a.b("mLoader", "sync loaded");
                j.this.g = adData;
                j.this.i.countDown();
                j.this.j.countDown();
                j.this.j.countDown();
            }

            @Override // com.opos.mobad.model.e.g.a
            public void b(AdData adData) {
                com.opos.cmn.an.f.a.b("mLoader", "sync load fail");
                j.this.g = adData;
                j.this.i.countDown();
                j.this.j.countDown();
            }

            @Override // com.opos.mobad.model.e.g.a
            public void c(AdData adData) {
                if (j.this.c == j.this.b) {
                    j.this.k.a();
                    j.this.d(adData);
                }
            }

            @Override // com.opos.mobad.model.e.g.a
            public void d(AdData adData) {
                com.opos.mobad.model.e.f fVar;
                int i3;
                if (j.this.c == j.this.b) {
                    j.this.k.a();
                    if (j.this.l || !j.this.m()) {
                        if (j.this.l) {
                            fVar = j.this.m;
                            i3 = 4;
                        } else {
                            fVar = j.this.m;
                            i3 = 3;
                        }
                        fVar.c(i3);
                        j.this.c(adData);
                    }
                }
            }
        }, cVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        if (this.b.j() == 3 && this.f7159a.j() == 3) {
            com.opos.cmn.an.f.a.b("mLoader", "bid between sync and cache");
            if (a(this.g) >= a(this.h)) {
                this.m.d(1);
                d();
                return true;
            }
            this.m.d(2);
            f();
            return true;
        }
        if (this.b.j() == 3) {
            this.m.a(1);
            d();
            return true;
        }
        if (this.f7159a.j() != 3) {
            this.m.d(4);
            return false;
        }
        this.m.a(2);
        f();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.opos.cmn.an.f.a.b("mLoader", "select sync");
        if (!e(this.g)) {
            com.opos.cmn.an.f.a.c("mLoader", "select fail");
        } else {
            this.c = this.b;
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.opos.cmn.an.f.a.b("mLoader", "select cache");
        if (!e(this.h)) {
            com.opos.cmn.an.f.a.c("mLoader", "select fail");
        } else {
            this.c = this.f7159a;
            h();
        }
    }

    private void k() {
        c cVar = this.f7159a;
        this.c = cVar;
        cVar.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        com.opos.mobad.model.e.f fVar;
        int i;
        if (j() == 5) {
            i = 3;
            if (this.f7159a.j() == 3 && this.f7159a.d()) {
                com.opos.cmn.an.f.a.b("mLoader", "timeout to use cache");
                k();
                fVar = this.m;
                i = 2;
            } else {
                fVar = this.m;
            }
        } else {
            fVar = this.m;
            i = 4;
        }
        fVar.b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        if (j() != 5 || this.f7159a.j() != 3) {
            return false;
        }
        com.opos.cmn.an.f.a.b("mLoader", "change to cache");
        this.m.c(2);
        k();
        return true;
    }

    public int a(AdData adData) {
        if (adData == null || adData.f().size() <= 0 || adData.f().get(0) == null) {
            return 0;
        }
        return adData.f().get(0).ab();
    }

    @Override // com.opos.mobad.model.e.a
    protected void a() {
        com.opos.mobad.model.e.g gVar = this.c;
        if (gVar != null) {
            gVar.h();
        } else {
            com.opos.cmn.an.f.a.b("mLoader", "load with target null");
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a2  */
    @Override // com.opos.mobad.model.e.a
    protected void b() {
        this.k.a();
        if (j() == 6) {
            com.opos.mobad.model.e.g gVar = this.c;
            m mVar = this.b;
            if (gVar == mVar) {
                mVar.c();
            } else {
                c cVar = this.f7159a;
                if (gVar == cVar) {
                    cVar.c();
                }
            }
        }
        if (j() == 6 || j() == 7) {
            com.opos.mobad.model.e.g gVar2 = this.c;
            m mVar2 = this.b;
            if (gVar2 == mVar2) {
                if ((this.f7159a.j() == 3 && this.f7159a.d()) || this.f7159a.j() == 6) {
                    this.f7159a.a(false);
                }
            } else if (gVar2 == this.f7159a) {
                if (mVar2.j() != 7) {
                    if (this.b.j() == 3 || this.b.j() == 6) {
                        this.b.a(false);
                    } else {
                        this.f7159a.a(true);
                    }
                }
            }
            this.b.a(true);
        } else if (this.f7159a.j() == 3 || this.f7159a.j() == 6) {
            this.f7159a.a(false);
        } else if (this.b.j() == 3 || this.b.j() == 6) {
            this.b.a(false);
        } else {
            this.f7159a.f();
        }
        c cVar2 = this.f7159a;
        if (cVar2 != null) {
            cVar2.i();
        }
        m mVar3 = this.b;
        if (mVar3 != null) {
            mVar3.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.mobad.model.e.a
    public boolean b(AdData adData) {
        com.opos.cmn.an.f.a.b("mLoader", "onLoadFail");
        if (adData == null) {
            adData = new AdData(-1, "unknown error.");
        }
        this.m.a(this.n, adData.d(), adData.e(), this.c == this.f7159a, this.d.i(), this.d.k(), this.d.j());
        return super.b(adData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.mobad.model.e.a
    public void c(AdData adData) {
        com.opos.cmn.an.f.a.b("mLoader", "onLoadResourceFail");
        this.m.a(this.n, adData.d(), adData.e(), this.c == this.f7159a, this.d.i(), this.d.k(), this.d.j());
        super.c(adData);
        i();
    }

    @Override // com.opos.mobad.model.e.a
    protected void d(AdData adData) {
        String strC;
        int iAb;
        com.opos.cmn.an.f.a.b("mLoader", "onLoadResourceSucc");
        if (adData == null || adData.f().size() <= 0 || adData.f().get(0) == null) {
            strC = "";
            iAb = 0;
        } else {
            AdItemData adItemData = adData.f().get(0);
            strC = adItemData.c();
            iAb = adItemData.ab();
        }
        this.m.a(this.n, strC, this.c == this.f7159a, this.d.i(), iAb, this.d.k(), this.d.j());
        super.d(adData);
        i();
    }

    @Override // com.opos.mobad.model.e.a
    protected void e() {
        int i = this.e;
        if (i >= 30) {
            this.k.a(i - 30);
        }
        com.opos.cmn.an.f.a.b("mLoader", "request:" + this.f + ",total:" + this.e);
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.a.j.4
            @Override // java.lang.Runnable
            public void run() {
                boolean zAwait;
                com.opos.mobad.model.e.f fVar;
                int i2;
                j jVar;
                AdData adData;
                j.this.f7159a.g();
                j.this.b.g();
                try {
                    zAwait = j.this.i.await(j.this.f <= j.this.e ? j.this.f : j.this.e, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    com.opos.cmn.an.f.a.b("mLoader", "request await", e);
                    zAwait = false;
                }
                com.opos.cmn.an.f.a.b("mLoader", "request priority timeout:" + zAwait);
                boolean zC = j.this.c();
                if (zC) {
                    return;
                }
                try {
                    zC = j.this.j.await(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e2) {
                    com.opos.cmn.an.f.a.b("mLoader", "total await", e2);
                }
                com.opos.cmn.an.f.a.b("mLoader", "request timeout:" + zC);
                j jVar2 = j.this;
                if (zC) {
                    i2 = 3;
                    if (jVar2.b.j() == 3) {
                        j.this.m.a(1);
                        j.this.d();
                        return;
                    } else {
                        if (j.this.f7159a.j() == 3) {
                            j.this.m.a(2);
                            j.this.f();
                            return;
                        }
                        fVar = j.this.m;
                    }
                } else {
                    fVar = jVar2.m;
                    i2 = 4;
                }
                fVar.a(i2);
                if (j.this.g != null) {
                    jVar = j.this;
                    adData = jVar.g;
                } else if (j.this.h != null) {
                    jVar = j.this;
                    adData = jVar.h;
                } else {
                    jVar = j.this;
                    adData = null;
                }
                jVar.b(adData);
                j.this.i();
            }
        });
    }
}
