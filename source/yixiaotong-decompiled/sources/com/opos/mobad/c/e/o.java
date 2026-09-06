package com.opos.mobad.c.e;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.provider.record.CacheEntity;
import com.stub.StubApp;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.c.d f6735a;
    private Context b;
    private m c = new m(1, 1, 80, 0.0d, new m.a() { // from class: com.opos.mobad.c.e.o.1
        @Override // com.opos.mobad.c.e.m.a
        public void a(m mVar) {
            o.this.e.a();
        }
    });
    private m d = new m(1, 1, 30, 0.0d, new m.a() { // from class: com.opos.mobad.c.e.o.2
        @Override // com.opos.mobad.c.e.m.a
        public void a(m mVar) {
            o.this.e.a();
        }
    });
    private com.opos.cmn.i.a e = new com.opos.cmn.i.a(new com.opos.cmn.i.a.b() { // from class: com.opos.mobad.c.e.o.3
        @Override // com.opos.cmn.i.a.b
        public void a(com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
            o.this.c();
            interfaceC0895a.a();
        }
    }, 0, 180000);
    private com.opos.cmn.i.a f = new com.opos.cmn.i.a(new com.opos.cmn.i.a.b() { // from class: com.opos.mobad.c.e.o.4
        @Override // com.opos.cmn.i.a.b
        public void a(com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
            o.this.d();
            interfaceC0895a.a();
        }
    });
    private com.opos.mobad.provider.record.a g;
    private l h;
    private k i;
    private j j;
    private j k;
    private j l;
    private j m;
    private com.opos.mobad.service.i.b n;
    private k o;

    o(com.opos.mobad.c.d dVar, Context context) {
        this.f6735a = dVar;
        this.b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.g = new com.opos.mobad.provider.record.a(context);
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.c.e.o.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CacheEntity cacheEntityA = o.this.g.a();
                    o.this.c.a(cacheEntityA.f7271a, cacheEntityA.b);
                    CacheEntity cacheEntityB = o.this.g.b();
                    o.this.d.a(cacheEntityB.f7271a, cacheEntityB.b);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("", "", e);
                }
            }
        });
        a();
    }

    private void a() {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.e.o.6
            @Override // java.lang.Runnable
            public void run() {
                o oVar;
                try {
                    int iF = o.this.g.f();
                    com.opos.cmn.an.f.a.b("watch", "check cr amount:" + iF);
                    if (iF >= 5) {
                        oVar = o.this;
                    } else {
                        long jG = o.this.g.g();
                        com.opos.cmn.an.f.a.b("watch", "check cr time:" + jG);
                        if (jG <= 0 || System.currentTimeMillis() - jG <= 86400000) {
                            return;
                        } else {
                            oVar = o.this;
                        }
                    }
                    oVar.a(iF);
                } catch (Throwable th) {
                    com.opos.cmn.an.f.a.b("watch", "report cr fail", th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) throws Exception {
        String strH = this.g.h();
        String strI = this.g.i();
        this.f6735a.d().d().a(i, strH, !TextUtils.isEmpty(strI) ? new JSONObject(strI) : null);
        this.g.a((String) null);
    }

    private void b() {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.e.o.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    o.this.g.c();
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("", "", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f6735a.d().d().a(this.c.c(), this.c.d(), this.d.c(), this.d.d());
        b();
    }

    private void c(final int i, final int i2) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.e.o.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    o.this.g.a(new CacheEntity(i, i2));
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("", "", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.i != null) {
            this.f6735a.d().d().b(this.i.f6723a, this.i.b);
            this.i = null;
            return;
        }
        if (this.h != null) {
            this.f6735a.d().d().a(this.h.f6724a, this.h.b);
            this.h = null;
            return;
        }
        j jVar = this.j;
        if (jVar != null) {
            this.f6735a.d().d().a(jVar.f6722a);
            this.j = null;
        }
        j jVar2 = this.k;
        if (jVar2 != null) {
            this.f6735a.d().d().b(jVar2.f6722a);
            this.k = null;
        }
        j jVar3 = this.l;
        if (jVar3 != null) {
            this.f6735a.d().d().c(jVar3.f6722a);
            this.l = null;
        }
        j jVar4 = this.m;
        if (jVar4 != null) {
            this.f6735a.d().d().d(jVar4.f6722a);
            this.m = null;
        }
        e();
        if (this.o != null) {
            this.f6735a.d().d().c(this.o.f6723a, this.o.b);
            this.o = null;
        }
    }

    private void d(final int i, final int i2) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.e.o.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    o.this.g.b(new CacheEntity(i, i2));
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("", "", e);
                }
            }
        });
    }

    private void e() {
        try {
            com.opos.mobad.service.i.b bVar = this.n;
            if (bVar != null) {
                this.n = null;
                StringWriter stringWriter = new StringWriter();
                bVar.f7389a.printStackTrace(new PrintWriter(stringWriter));
                this.f6735a.d().d().f(stringWriter.toString());
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("watch", "record strategy but exception", th);
        }
    }

    public void a(int i, int i2) {
        this.c.a(i, i2);
        c(i + this.c.c(), i2 + this.c.d());
    }

    public void a(String str) {
        this.j = new j(str);
        this.f.a();
    }

    public void a(String str, int i) {
        this.o = new k(str, i);
        this.f.a();
    }

    public void a(Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            this.g.a(stringWriter.toString(), com.opos.mobad.s.d.a(this.b));
        } catch (Throwable th2) {
            com.opos.cmn.an.f.a.b("watch", "add cr fail", th2);
        }
    }

    public void b(int i, int i2) {
        d(this.d.c() + i, this.d.d() + i2);
        this.d.a(i, i2);
    }

    public void b(String str) {
        this.k = new j(str);
        this.f.a();
    }

    public void b(Throwable th) {
        if (th == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("", "record strategy error");
        this.n = new com.opos.mobad.service.i.b(th);
        this.f.a();
    }

    public void c(String str) {
        this.l = new j(str);
        this.f.a();
    }

    public void d(String str) {
        this.m = new j(str);
        this.f.a();
    }
}
