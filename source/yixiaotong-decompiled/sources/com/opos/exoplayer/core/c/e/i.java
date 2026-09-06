package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.i.p;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f6329a = new e();
    private n b;
    private com.opos.exoplayer.core.c.g c;
    private g d;
    private long e;
    private long f;
    private long g;
    private int h;
    private int i;
    private b j;
    private long k;
    private boolean l;
    private boolean m;

    static /* synthetic */ class a {
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Format f6330a;
        g b;

        b() {
        }
    }

    private static final class c implements g {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // com.opos.exoplayer.core.c.e.g
        public long a(long j) {
            return 0L;
        }

        @Override // com.opos.exoplayer.core.c.e.g
        public long a(com.opos.exoplayer.core.c.f fVar) {
            return -1L;
        }

        @Override // com.opos.exoplayer.core.c.e.g
        public l c() {
            return new l.b(-9223372036854775807L);
        }
    }

    private int a(com.opos.exoplayer.core.c.f fVar) {
        while (this.f6329a.a(fVar)) {
            this.k = fVar.c() - this.f;
            boolean zA = a(this.f6329a.c(), this.f, this.j);
            if (zA) {
                this.f = fVar.c();
            }
            if (!zA) {
                Format format = this.j.f6330a;
                this.i = format.s;
                if (!this.m) {
                    this.b.a(format);
                    this.m = true;
                }
                g gVar = this.j.b;
                a aVar = null;
                if (gVar != null) {
                    this.d = gVar;
                } else if (fVar.d() == -1) {
                    this.d = new c(aVar);
                } else {
                    f fVarB = this.f6329a.b();
                    this.d = new com.opos.exoplayer.core.c.e.c(this.f, fVar.d(), this, fVarB.e + fVarB.f, fVarB.c);
                }
                this.j = null;
                this.h = 2;
                this.f6329a.d();
                return 0;
            }
        }
        this.h = 3;
        return -1;
    }

    private int b(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        long jA = this.d.a(fVar);
        if (jA >= 0) {
            kVar.f6369a = jA;
            return 1;
        }
        if (jA < -1) {
            c(-(jA + 2));
        }
        if (!this.l) {
            this.c.a(this.d.c());
            this.l = true;
        }
        if (this.k <= 0 && !this.f6329a.a(fVar)) {
            this.h = 3;
            return -1;
        }
        this.k = 0L;
        p pVarC = this.f6329a.c();
        long jB = b(pVarC);
        if (jB >= 0) {
            long j = this.g;
            if (j + jB >= this.e) {
                long jA2 = a(j);
                this.b.a(pVarC, pVarC.c());
                this.b.a(jA2, 1, pVarC.c(), 0, null);
                this.e = -1L;
            }
        }
        this.g += jB;
        return 0;
    }

    final int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        int i = this.h;
        if (i == 0) {
            return a(fVar);
        }
        if (i != 1) {
            if (i == 2) {
                return b(fVar, kVar);
            }
            throw new IllegalStateException();
        }
        fVar.b((int) this.f);
        this.h = 2;
        return 0;
    }

    protected long a(long j) {
        return (j * 1000000) / ((long) this.i);
    }

    final void a(long j, long j2) {
        this.f6329a.a();
        if (j == 0) {
            a(!this.l);
        } else if (this.h != 0) {
            this.e = this.d.a(j2);
            this.h = 2;
        }
    }

    void a(com.opos.exoplayer.core.c.g gVar, n nVar) {
        this.c = gVar;
        this.b = nVar;
        a(true);
    }

    protected void a(boolean z) {
        int i;
        if (z) {
            this.j = new b();
            this.f = 0L;
            i = 0;
        } else {
            i = 1;
        }
        this.h = i;
        this.e = -1L;
        this.g = 0L;
    }

    protected abstract boolean a(p pVar, long j, b bVar);

    protected long b(long j) {
        return (((long) this.i) * j) / 1000000;
    }

    protected abstract long b(p pVar);

    protected void c(long j) {
        this.g = j;
    }
}
