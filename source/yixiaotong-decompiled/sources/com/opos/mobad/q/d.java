package com.opos.mobad.q;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class d extends k implements com.opos.mobad.ad.c.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.c.d f7283a;

    public d(com.opos.mobad.ad.c.d dVar) {
        super(dVar);
        this.f7283a = dVar;
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b() {
        this.f7283a = null;
        super.b();
    }

    protected final void g() {
        com.opos.mobad.ad.c.d dVar;
        if (c() == 5 || (dVar = this.f7283a) == null) {
            return;
        }
        dVar.c();
    }
}
