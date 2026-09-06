package com.opos.exoplayer.core;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.opos.exoplayer.core.e.d f6266a;
    public final Object b;
    public final com.opos.exoplayer.core.e.i[] c;
    public final boolean[] d;
    public long e;
    public boolean f;
    public boolean g;
    public ad h;
    public ac i;
    public com.opos.exoplayer.core.g.i j;
    private final u[] k;
    private final com.opos.exoplayer.core.g.h l;
    private final com.opos.exoplayer.core.e.e m;
    private com.opos.exoplayer.core.g.i n;

    public ac(u[] uVarArr, long j, com.opos.exoplayer.core.g.h hVar, com.opos.exoplayer.core.h.b bVar, com.opos.exoplayer.core.e.e eVar, Object obj, ad adVar) {
        this.k = uVarArr;
        this.e = j - adVar.b;
        this.l = hVar;
        this.m = eVar;
        this.b = com.opos.exoplayer.core.i.a.a(obj);
        this.h = adVar;
        this.c = new com.opos.exoplayer.core.e.i[uVarArr.length];
        this.d = new boolean[uVarArr.length];
        com.opos.exoplayer.core.e.d dVarA = eVar.a(adVar.f6267a, bVar);
        if (adVar.c != Long.MIN_VALUE) {
            com.opos.exoplayer.core.e.a aVar = new com.opos.exoplayer.core.e.a(dVarA, true);
            aVar.a(0L, adVar.c);
            dVarA = aVar;
        }
        this.f6266a = dVarA;
    }

    private void a(com.opos.exoplayer.core.g.i iVar) {
        com.opos.exoplayer.core.g.i iVar2 = this.n;
        if (iVar2 != null) {
            c(iVar2);
        }
        this.n = iVar;
        if (iVar != null) {
            b(iVar);
        }
    }

    private void a(com.opos.exoplayer.core.e.i[] iVarArr) {
        int i = 0;
        while (true) {
            u[] uVarArr = this.k;
            if (i >= uVarArr.length) {
                return;
            }
            if (uVarArr[i].a() == 5) {
                iVarArr[i] = null;
            }
            i++;
        }
    }

    private void b(com.opos.exoplayer.core.g.i iVar) {
        int i = 0;
        while (true) {
            boolean[] zArr = iVar.b;
            if (i >= zArr.length) {
                return;
            }
            boolean z = zArr[i];
            com.opos.exoplayer.core.g.f fVarA = iVar.c.a(i);
            if (z && fVarA != null) {
                fVarA.a();
            }
            i++;
        }
    }

    private void b(com.opos.exoplayer.core.e.i[] iVarArr) {
        int i = 0;
        while (true) {
            u[] uVarArr = this.k;
            if (i >= uVarArr.length) {
                return;
            }
            if (uVarArr[i].a() == 5 && this.j.b[i]) {
                iVarArr[i] = new com.opos.exoplayer.core.e.b();
            }
            i++;
        }
    }

    private void c(com.opos.exoplayer.core.g.i iVar) {
        int i = 0;
        while (true) {
            boolean[] zArr = iVar.b;
            if (i >= zArr.length) {
                return;
            }
            boolean z = zArr[i];
            com.opos.exoplayer.core.g.f fVarA = iVar.c.a(i);
            if (z && fVarA != null) {
                fVarA.c();
            }
            i++;
        }
    }

    public long a() {
        return this.e;
    }

    public long a(long j) {
        return j + a();
    }

    public long a(long j, boolean z) {
        return a(j, z, new boolean[this.k.length]);
    }

    public long a(long j, boolean z, boolean[] zArr) {
        com.opos.exoplayer.core.g.g gVar = this.j.c;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= gVar.f6474a) {
                break;
            }
            boolean[] zArr2 = this.d;
            if (z || !this.j.a(this.n, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        a(this.c);
        a(this.j);
        long jA = this.f6266a.a(gVar.a(), this.d, this.c, zArr, j);
        b(this.c);
        this.g = false;
        int i2 = 0;
        while (true) {
            com.opos.exoplayer.core.e.i[] iVarArr = this.c;
            if (i2 >= iVarArr.length) {
                return jA;
            }
            if (iVarArr[i2] != null) {
                com.opos.exoplayer.core.i.a.b(this.j.b[i2]);
                if (this.k[i2].a() != 5) {
                    this.g = true;
                }
            } else {
                com.opos.exoplayer.core.i.a.b(gVar.a(i2) == null);
            }
            i2++;
        }
    }

    public long a(boolean z) {
        if (!this.f) {
            return this.h.b;
        }
        long jD = this.f6266a.d();
        return (jD == Long.MIN_VALUE && z) ? this.h.e : jD;
    }

    public com.opos.exoplayer.core.g.i a(float f) {
        this.f = true;
        b(f);
        long jA = a(this.h.b, false);
        long j = this.e;
        ad adVar = this.h;
        this.e = j + (adVar.b - jA);
        this.h = adVar.a(jA);
        return this.j;
    }

    public long b(long j) {
        return j - a();
    }

    public boolean b() {
        return this.f && (!this.g || this.f6266a.d() == Long.MIN_VALUE);
    }

    public boolean b(float f) {
        com.opos.exoplayer.core.g.i iVarA = this.l.a(this.k, this.f6266a.b());
        if (iVarA.a(this.n)) {
            return false;
        }
        this.j = iVarA;
        for (com.opos.exoplayer.core.g.f fVar : iVarA.c.a()) {
            if (fVar != null) {
                fVar.a(f);
            }
        }
        return true;
    }

    public long c() {
        if (this.f) {
            return this.f6266a.e();
        }
        return 0L;
    }

    public void c(long j) {
        if (this.f) {
            this.f6266a.a(b(j));
        }
    }

    public void d() {
        com.opos.exoplayer.core.e.e eVar;
        com.opos.exoplayer.core.e.d dVar;
        a((com.opos.exoplayer.core.g.i) null);
        try {
            if (this.h.c != Long.MIN_VALUE) {
                eVar = this.m;
                dVar = ((com.opos.exoplayer.core.e.a) this.f6266a).f6385a;
            } else {
                eVar = this.m;
                dVar = this.f6266a;
            }
            eVar.a(dVar);
        } catch (RuntimeException e) {
            com.opos.cmn.an.f.a.d("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public void d(long j) {
        this.f6266a.c(b(j));
    }
}
