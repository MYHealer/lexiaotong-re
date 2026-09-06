package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.o;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a implements com.opos.exoplayer.core.c.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.opos.exoplayer.core.c.h f6317a = new C0911a();
    private com.opos.exoplayer.core.c.g b;
    private i c;
    private boolean d;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.c.e.a$a, reason: collision with other inner class name */
    static class C0911a implements com.opos.exoplayer.core.c.h {
        C0911a() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new a()};
        }
    }

    private static p a(p pVar) {
        pVar.c(0);
        return pVar;
    }

    private boolean b(com.opos.exoplayer.core.c.f fVar) {
        i hVar;
        f fVar2 = new f();
        if (fVar2.a(fVar, true) && (fVar2.b & 2) == 2) {
            int iMin = Math.min(fVar2.f, 8);
            p pVar = new p(iMin);
            fVar.c(pVar.f6510a, 0, iMin);
            if (d.a(a(pVar))) {
                hVar = new d();
            } else if (k.a(a(pVar))) {
                hVar = new k();
            } else if (h.a(a(pVar))) {
                hVar = new h();
            }
            this.c = hVar;
            return true;
        }
        return false;
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) throws o {
        if (this.c == null) {
            if (!b(fVar)) {
                throw new o("Failed to determine bitstream type");
            }
            fVar.a();
        }
        if (!this.d) {
            n nVarA = this.b.a(0, 1);
            this.b.a();
            this.c.a(this.b, nVarA);
            this.d = true;
        }
        return this.c.a(fVar, kVar);
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j, long j2) {
        i iVar = this.c;
        if (iVar != null) {
            iVar.a(j, j2);
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.b = gVar;
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        try {
            return b(fVar);
        } catch (o unused) {
            return false;
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
