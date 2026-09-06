package com.opos.mobad.q;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class a extends j implements com.opos.mobad.ad.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.a.c f7282a;

    public a(com.opos.mobad.ad.a.c cVar) {
        super(cVar);
        this.f7282a = cVar;
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b() {
        if (this.f7282a != null) {
            this.f7282a = null;
        }
        super.b();
    }

    protected final void h() {
        com.opos.mobad.ad.a.c cVar;
        if (5 == c() || (cVar = this.f7282a) == null) {
            return;
        }
        cVar.a(0L);
    }

    protected final void i() {
        com.opos.mobad.ad.a.c cVar;
        if (c() == 5 || (cVar = this.f7282a) == null) {
            return;
        }
        cVar.a("");
    }
}
