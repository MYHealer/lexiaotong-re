package com.opos.exoplayer.core.i;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class u implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f6515a;
    private boolean b;
    private long c;
    private long d;
    private com.opos.exoplayer.core.p e = com.opos.exoplayer.core.p.f6545a;

    public u(e eVar) {
        this.f6515a = eVar;
    }

    @Override // com.opos.exoplayer.core.i.l
    public com.opos.exoplayer.core.p a(com.opos.exoplayer.core.p pVar) {
        if (this.b) {
            a(d());
        }
        this.e = pVar;
        return pVar;
    }

    public void a() {
        if (this.b) {
            return;
        }
        this.d = this.f6515a.a();
        this.b = true;
    }

    public void a(long j) {
        this.c = j;
        if (this.b) {
            this.d = this.f6515a.a();
        }
    }

    public void b() {
        if (this.b) {
            a(d());
            this.b = false;
        }
    }

    @Override // com.opos.exoplayer.core.i.l
    public long d() {
        long j = this.c;
        if (!this.b) {
            return j;
        }
        long jA = this.f6515a.a() - this.d;
        com.opos.exoplayer.core.p pVar = this.e;
        return j + (pVar.b == 1.0f ? com.opos.exoplayer.core.b.b(jA) : pVar.a(jA));
    }

    @Override // com.opos.exoplayer.core.i.l
    public com.opos.exoplayer.core.p e() {
        return this.e;
    }
}
