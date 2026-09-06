package com.opos.mobad.c.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6726a;
    private m b;
    private m c;
    private LruCache<String, m> d;
    private LruCache<String, m> e;
    private LruCache<String, m> f;
    private com.opos.cmn.i.a g;
    private com.opos.cmn.i.a h;
    private com.opos.cmn.i.a i;
    private com.opos.cmn.i.a j;
    private com.opos.cmn.i.a k;
    private String l;
    private String m;
    private String n;
    private String o;
    private Throwable p;
    private o q;
    private com.opos.mobad.c.d r;

    public n(com.opos.mobad.c.d dVar) {
        this.r = dVar;
    }

    private m d(final String str) {
        m mVar;
        m mVar2 = this.f.get(str);
        if (mVar2 != null) {
            return mVar2;
        }
        synchronized (this.f) {
            mVar = this.f.get(str);
            if (mVar == null) {
                mVar = new m(180000, 10, new m.a() { // from class: com.opos.mobad.c.e.n.8
                    @Override // com.opos.mobad.c.e.m.a
                    public void a(m mVar3) {
                        n.this.q.a(str, mVar3.d());
                    }
                });
                this.f.put(str, mVar);
            }
        }
        return mVar;
    }

    public void a(Context context) {
        this.f6726a = context;
        this.q = new o(this.r, context);
        this.c = new m(180000, 10, new m.a() { // from class: com.opos.mobad.c.e.n.1
            @Override // com.opos.mobad.c.e.m.a
            public void a(m mVar) {
                n.this.q.b(mVar.c(), mVar.d());
            }
        });
        this.b = new m(180000, 10, new m.a() { // from class: com.opos.mobad.c.e.n.2
            @Override // com.opos.mobad.c.e.m.a
            public void a(m mVar) {
                n.this.q.a(mVar.c(), mVar.d());
            }
        });
        this.d = new LruCache<>(10);
        this.e = new LruCache<>(10);
        this.f = new LruCache<>(10);
        this.g = new com.opos.cmn.i.a(new com.opos.cmn.i.a.b() { // from class: com.opos.mobad.c.e.n.3
            @Override // com.opos.cmn.i.a.b
            public void a(com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
                String str = n.this.l;
                if (TextUtils.isEmpty(str)) {
                    interfaceC0895a.b();
                } else {
                    n.this.q.a(str);
                    interfaceC0895a.a();
                }
            }
        }, 0, 180000);
        this.h = new com.opos.cmn.i.a(new com.opos.cmn.i.a.b() { // from class: com.opos.mobad.c.e.n.4
            @Override // com.opos.cmn.i.a.b
            public void a(com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
                String str = n.this.m;
                if (TextUtils.isEmpty(str)) {
                    interfaceC0895a.b();
                } else {
                    n.this.q.b(str);
                    interfaceC0895a.a();
                }
            }
        }, 0, 180000);
        this.i = new com.opos.cmn.i.a(new com.opos.cmn.i.a.b() { // from class: com.opos.mobad.c.e.n.5
            @Override // com.opos.cmn.i.a.b
            public void a(com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
                String str = n.this.n;
                if (TextUtils.isEmpty(str)) {
                    interfaceC0895a.b();
                } else {
                    n.this.q.c(str);
                    interfaceC0895a.a();
                }
            }
        }, 0, 180000);
        this.j = new com.opos.cmn.i.a(new com.opos.cmn.i.a.b() { // from class: com.opos.mobad.c.e.n.6
            @Override // com.opos.cmn.i.a.b
            public void a(com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
                String str = n.this.o;
                if (TextUtils.isEmpty(str)) {
                    interfaceC0895a.b();
                } else {
                    n.this.q.d(str);
                    interfaceC0895a.a();
                }
            }
        }, 0, 180000);
        this.k = new com.opos.cmn.i.a(new com.opos.cmn.i.a.b() { // from class: com.opos.mobad.c.e.n.7
            @Override // com.opos.cmn.i.a.b
            public void a(com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
                Throwable th = n.this.p;
                if (th == null) {
                    interfaceC0895a.b();
                    return;
                }
                n.this.q.b(th);
                n.this.p = null;
                interfaceC0895a.a();
            }
        }, 0, 180000);
    }

    public void a(String str) {
    }

    public void a(Throwable th) {
        o oVar = this.q;
        if (oVar != null) {
            oVar.a(th);
        }
    }

    public void a(boolean z) {
        if (this.f6726a == null) {
            return;
        }
        if (z) {
            this.b.a();
        }
        this.b.b();
    }

    public void b(String str) {
    }

    public void b(Throwable th) {
        if (this.q == null || th == null) {
            return;
        }
        this.p = th;
        this.k.a();
    }

    public void b(boolean z) {
        if (this.f6726a == null) {
            return;
        }
        if (z) {
            this.c.a();
        }
        this.c.b();
    }

    public void c(String str) {
        if (this.f6726a == null || TextUtils.isEmpty(str)) {
            return;
        }
        d(str).b();
    }
}
