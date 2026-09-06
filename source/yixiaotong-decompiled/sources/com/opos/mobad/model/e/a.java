package com.opos.mobad.model.e;

import com.opos.mobad.model.data.AdData;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g.a f7199a;
    private com.opos.mobad.q.o b = new com.opos.mobad.q.o.a(1).a("ALoader").a(1, 2, 8).a(2, 3, 4, 8).a(3, 5, 8).a(4, 8).a(5, 6, 7, 8).a(6, 8).a(7, 8).a();

    public a(g.a aVar) {
        this.f7199a = aVar;
    }

    protected abstract void a();

    protected boolean a(Callable<Boolean> callable, AdData adData) {
        int iA = this.b.a(3, callable);
        if (iA != 3) {
            if (iA != 8) {
                com.opos.cmn.an.f.a.c("ALoader", "error state:" + iA + ":3");
            }
            return false;
        }
        g.a aVar = this.f7199a;
        if (aVar == null) {
            return true;
        }
        aVar.a(adData);
        return true;
    }

    protected abstract void b();

    protected boolean b(AdData adData) {
        int iA = this.b.a(4);
        if (iA != 4) {
            if (iA == 8) {
                return false;
            }
            com.opos.cmn.an.f.a.c("ALoader", "error state:" + iA + ":4");
            return false;
        }
        g.a aVar = this.f7199a;
        if (aVar == null) {
            return true;
        }
        aVar.b(adData);
        return true;
    }

    protected void c(AdData adData) {
        int iA = this.b.a(7);
        if (iA != 7) {
            if (iA != 8) {
                com.opos.cmn.an.f.a.c("ALoader", "error state:" + iA + ":7");
            }
        } else {
            g.a aVar = this.f7199a;
            if (aVar != null) {
                aVar.d(adData);
            }
        }
    }

    protected void d(AdData adData) {
        int iA = this.b.a(6);
        if (iA != 6) {
            if (iA != 8) {
                com.opos.cmn.an.f.a.c("ALoader", "error state:" + iA + ":7");
            }
        } else {
            g.a aVar = this.f7199a;
            if (aVar != null) {
                aVar.c(adData);
            }
        }
    }

    protected abstract void e();

    protected boolean e(AdData adData) {
        int iA = this.b.a(2, 3);
        if (iA != 3) {
            if (iA != 8) {
                com.opos.cmn.an.f.a.c("ALoader", "error state:" + iA + ":3");
            }
            return false;
        }
        g.a aVar = this.f7199a;
        if (aVar == null) {
            return true;
        }
        aVar.a(adData);
        return true;
    }

    @Override // com.opos.mobad.model.e.g
    public void g() {
        int iA = this.b.a(2, new Callable<Boolean>() { // from class: com.opos.mobad.model.e.a.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                a.this.e();
                return true;
            }
        });
        if (iA != 2) {
            com.opos.cmn.an.f.a.b("ALoader", "error state:" + iA + ":2");
        }
    }

    @Override // com.opos.mobad.model.e.g
    public void h() {
        int iA = this.b.a(5);
        if (5 != iA) {
            com.opos.cmn.an.f.a.b("ALoader", "error state:" + iA + ":5");
        } else {
            a();
        }
    }

    public void i() {
        this.b.a(8, new Callable<Boolean>() { // from class: com.opos.mobad.model.e.a.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                a.this.b();
                return true;
            }
        });
    }

    public int j() {
        return this.b.a();
    }
}
