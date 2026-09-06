package com.opos.exoplayer.core;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class f implements com.opos.exoplayer.core.i.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.exoplayer.core.i.u f6411a;
    private final a b;
    private t c;
    private com.opos.exoplayer.core.i.l d;

    public interface a {
        void a(p pVar);
    }

    public f(a aVar, com.opos.exoplayer.core.i.e eVar) {
        this.b = aVar;
        this.f6411a = new com.opos.exoplayer.core.i.u(eVar);
    }

    private void f() {
        this.f6411a.a(this.d.d());
        p pVarE = this.d.e();
        if (pVarE.equals(this.f6411a.e())) {
            return;
        }
        this.f6411a.a(pVarE);
        this.b.a(pVarE);
    }

    private boolean g() {
        t tVar = this.c;
        return (tVar == null || tVar.u() || (!this.c.t() && this.c.g())) ? false : true;
    }

    @Override // com.opos.exoplayer.core.i.l
    public p a(p pVar) {
        com.opos.exoplayer.core.i.l lVar = this.d;
        if (lVar != null) {
            pVar = lVar.a(pVar);
        }
        this.f6411a.a(pVar);
        this.b.a(pVar);
        return pVar;
    }

    public void a() {
        this.f6411a.a();
    }

    public void a(long j) {
        this.f6411a.a(j);
    }

    public void a(t tVar) throws h {
        com.opos.exoplayer.core.i.l lVar;
        com.opos.exoplayer.core.i.l lVarC = tVar.c();
        if (lVarC == null || lVarC == (lVar = this.d)) {
            return;
        }
        if (lVar != null) {
            throw h.a(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.d = lVarC;
        this.c = tVar;
        lVarC.a(this.f6411a.e());
        f();
    }

    public void b() {
        this.f6411a.b();
    }

    public void b(t tVar) {
        if (tVar == this.c) {
            this.d = null;
            this.c = null;
        }
    }

    public long c() {
        if (!g()) {
            return this.f6411a.d();
        }
        f();
        return this.d.d();
    }

    @Override // com.opos.exoplayer.core.i.l
    public long d() {
        return g() ? this.d.d() : this.f6411a.d();
    }

    @Override // com.opos.exoplayer.core.i.l
    public p e() {
        com.opos.exoplayer.core.i.l lVar = this.d;
        return lVar != null ? lVar.e() : this.f6411a.e();
    }
}
