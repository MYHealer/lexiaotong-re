package com.opos.exoplayer.core;

import android.util.Pair;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z.a f6268a = new z.a();
    private final z.b b = new z.b();
    private long c;
    private z d;
    private int e;
    private boolean f;
    private ac g;
    private ac h;
    private ac i;
    private int j;

    private ad a(int i, int i2, int i3, long j, long j2) {
        com.opos.exoplayer.core.e.e.b bVar = new com.opos.exoplayer.core.e.e.b(i, i2, i3, j2);
        boolean zB = b(bVar, Long.MIN_VALUE);
        boolean zA = a(bVar, zB);
        return new ad(bVar, i3 == this.f6268a.b(i2) ? this.f6268a.e() : 0L, Long.MIN_VALUE, j, this.d.a(bVar.f6391a, this.f6268a).c(bVar.b, bVar.c), zB, zA);
    }

    private ad a(ac acVar, long j) {
        int i;
        long j2;
        long j3;
        ad adVar = acVar.h;
        if (adVar.f) {
            int iA = this.d.a(adVar.f6267a.f6391a, this.f6268a, this.b, this.e, this.f);
            if (iA == -1) {
                return null;
            }
            int i2 = this.d.a(iA, this.f6268a, true).c;
            Object obj = this.f6268a.b;
            long j4 = adVar.f6267a.d;
            long j5 = 0;
            if (this.d.a(i2, this.b).f == iA) {
                Pair<Integer, Long> pairA = this.d.a(this.b, this.f6268a, i2, -9223372036854775807L, Math.max(0L, (acVar.a() + adVar.e) - j));
                if (pairA == null) {
                    return null;
                }
                int iIntValue = ((Integer) pairA.first).intValue();
                long jLongValue = ((Long) pairA.second).longValue();
                ac acVar2 = acVar.i;
                if (acVar2 == null || !acVar2.b.equals(obj)) {
                    j3 = this.c;
                    this.c = 1 + j3;
                } else {
                    j3 = acVar.i.h.f6267a.d;
                }
                j5 = jLongValue;
                j2 = j3;
                i = iIntValue;
            } else {
                i = iA;
                j2 = j4;
            }
            long j6 = j5;
            return a(a(i, j6, j2), j6, j5);
        }
        com.opos.exoplayer.core.e.e.b bVar = adVar.f6267a;
        this.d.a(bVar.f6391a, this.f6268a);
        if (bVar.a()) {
            int i3 = bVar.b;
            int iD = this.f6268a.d(i3);
            if (iD == -1) {
                return null;
            }
            int iA2 = this.f6268a.a(i3, bVar.c);
            if (iA2 >= iD) {
                return b(bVar.f6391a, adVar.d, bVar.d);
            }
            if (this.f6268a.b(i3, iA2)) {
                return a(bVar.f6391a, i3, iA2, adVar.d, bVar.d);
            }
            return null;
        }
        long j7 = adVar.c;
        if (j7 != Long.MIN_VALUE) {
            int iA3 = this.f6268a.a(j7);
            if (iA3 == -1) {
                return b(bVar.f6391a, adVar.c, bVar.d);
            }
            int iB = this.f6268a.b(iA3);
            if (this.f6268a.b(iA3, iB)) {
                return a(bVar.f6391a, iA3, iB, adVar.c, bVar.d);
            }
            return null;
        }
        int iD2 = this.f6268a.d();
        if (iD2 == 0) {
            return null;
        }
        int i4 = iD2 - 1;
        if (this.f6268a.a(i4) != Long.MIN_VALUE || this.f6268a.c(i4)) {
            return null;
        }
        int iB2 = this.f6268a.b(i4);
        if (!this.f6268a.b(i4, iB2)) {
            return null;
        }
        return a(bVar.f6391a, i4, iB2, this.f6268a.a(), bVar.d);
    }

    private ad a(ad adVar, com.opos.exoplayer.core.e.e.b bVar) {
        long j;
        long jA;
        long j2 = adVar.b;
        long j3 = adVar.c;
        boolean zB = b(bVar, j3);
        boolean zA = a(bVar, zB);
        this.d.a(bVar.f6391a, this.f6268a);
        if (!bVar.a()) {
            if (j3 == Long.MIN_VALUE) {
                jA = this.f6268a.a();
            } else {
                j = j3;
            }
            return new ad(bVar, j2, j3, adVar.d, j, zB, zA);
        }
        jA = this.f6268a.c(bVar.b, bVar.c);
        j = jA;
        return new ad(bVar, j2, j3, adVar.d, j, zB, zA);
    }

    private ad a(af afVar) {
        return a(afVar.c, afVar.e, afVar.d);
    }

    private ad a(com.opos.exoplayer.core.e.e.b bVar, long j, long j2) {
        this.d.a(bVar.f6391a, this.f6268a);
        if (!bVar.a()) {
            return b(bVar.f6391a, j2, bVar.d);
        }
        if (this.f6268a.b(bVar.b, bVar.c)) {
            return a(bVar.f6391a, bVar.b, bVar.c, j, bVar.d);
        }
        return null;
    }

    private com.opos.exoplayer.core.e.e.b a(int i, long j, long j2) {
        this.d.a(i, this.f6268a);
        int iA = this.f6268a.a(j);
        return iA == -1 ? new com.opos.exoplayer.core.e.e.b(i, j2) : new com.opos.exoplayer.core.e.e.b(i, iA, this.f6268a.b(iA), j2);
    }

    private boolean a(ac acVar, ad adVar) {
        ad adVar2 = acVar.h;
        return adVar2.b == adVar.b && adVar2.c == adVar.c && adVar2.f6267a.equals(adVar.f6267a);
    }

    private boolean a(com.opos.exoplayer.core.e.e.b bVar, boolean z) {
        return !this.d.a(this.d.a(bVar.f6391a, this.f6268a).c, this.b).e && this.d.b(bVar.f6391a, this.f6268a, this.b, this.e, this.f) && z;
    }

    private long b(int i) {
        Object obj = this.d.a(i, this.f6268a, true).b;
        for (ac acVarE = e(); acVarE != null; acVarE = acVarE.i) {
            if (acVarE.b.equals(obj)) {
                return acVarE.h.f6267a.d;
            }
        }
        int i2 = this.f6268a.c;
        for (ac acVarE2 = e(); acVarE2 != null; acVarE2 = acVarE2.i) {
            int iA = this.d.a(acVarE2.b);
            if (iA != -1 && this.d.a(iA, this.f6268a).c == i2) {
                return acVarE2.h.f6267a.d;
            }
        }
        long j = this.c;
        this.c = 1 + j;
        return j;
    }

    private ad b(int i, long j, long j2) {
        com.opos.exoplayer.core.e.e.b bVar = new com.opos.exoplayer.core.e.e.b(i, j2);
        this.d.a(bVar.f6391a, this.f6268a);
        int iB = this.f6268a.b(j);
        long jA = iB == -1 ? Long.MIN_VALUE : this.f6268a.a(iB);
        boolean zB = b(bVar, jA);
        return new ad(bVar, j, jA, -9223372036854775807L, jA == Long.MIN_VALUE ? this.f6268a.a() : jA, zB, a(bVar, zB));
    }

    private boolean b(com.opos.exoplayer.core.e.e.b bVar, long j) {
        int iD = this.d.a(bVar.f6391a, this.f6268a).d();
        if (iD == 0) {
            return true;
        }
        int i = iD - 1;
        boolean zA = bVar.a();
        if (this.f6268a.a(i) != Long.MIN_VALUE) {
            return !zA && j == Long.MIN_VALUE;
        }
        int iD2 = this.f6268a.d(i);
        if (iD2 == -1) {
            return false;
        }
        if (zA && bVar.b == i && bVar.c == iD2 - 1) {
            return true;
        }
        return !zA && this.f6268a.b(i) == iD2;
    }

    private boolean j() {
        ac acVar;
        ac acVarE = e();
        if (acVarE == null) {
            return true;
        }
        while (true) {
            int iA = this.d.a(acVarE.h.f6267a.f6391a, this.f6268a, this.b, this.e, this.f);
            while (true) {
                ac acVar2 = acVarE.i;
                if (acVar2 == null || acVarE.h.f) {
                    break;
                }
                acVarE = acVar2;
            }
            if (iA == -1 || (acVar = acVarE.i) == null || acVar.h.f6267a.f6391a != iA) {
                break;
            }
            acVarE = acVar;
        }
        boolean zA = a(acVarE);
        ad adVar = acVarE.h;
        acVarE.h = a(adVar, adVar.f6267a);
        return (zA && f()) ? false : true;
    }

    public ad a(long j, af afVar) {
        ac acVar = this.i;
        return acVar == null ? a(afVar) : a(acVar, j);
    }

    public ad a(ad adVar, int i) {
        return a(adVar, adVar.f6267a.a(i));
    }

    public com.opos.exoplayer.core.e.d a(u[] uVarArr, long j, com.opos.exoplayer.core.g.h hVar, com.opos.exoplayer.core.h.b bVar, com.opos.exoplayer.core.e.e eVar, Object obj, ad adVar) {
        ac acVar = this.i;
        ac acVar2 = new ac(uVarArr, acVar == null ? adVar.b + j : acVar.a() + this.i.h.e, hVar, bVar, eVar, obj, adVar);
        if (this.i != null) {
            com.opos.exoplayer.core.i.a.b(f());
            this.i.i = acVar2;
        }
        this.i = acVar2;
        this.j++;
        return acVar2.f6266a;
    }

    public com.opos.exoplayer.core.e.e.b a(int i, long j) {
        return a(i, j, b(i));
    }

    public com.opos.exoplayer.core.g.i a(float f) {
        return this.i.a(f);
    }

    public void a(long j) {
        ac acVar = this.i;
        if (acVar != null) {
            acVar.c(j);
        }
    }

    public void a(z zVar) {
        this.d = zVar;
    }

    public boolean a() {
        ac acVar = this.i;
        return acVar == null || (!acVar.h.g && acVar.b() && this.i.h.e != -9223372036854775807L && this.j < 100);
    }

    public boolean a(int i) {
        this.e = i;
        return j();
    }

    public boolean a(ac acVar) {
        boolean z = false;
        com.opos.exoplayer.core.i.a.b(acVar != null);
        this.i = acVar;
        while (true) {
            acVar = acVar.i;
            if (acVar == null) {
                this.i.i = null;
                return z;
            }
            if (acVar == this.h) {
                this.h = this.g;
                z = true;
            }
            acVar.d();
            this.j--;
        }
    }

    public boolean a(com.opos.exoplayer.core.e.d dVar) {
        ac acVar = this.i;
        return acVar != null && acVar.f6266a == dVar;
    }

    public boolean a(com.opos.exoplayer.core.e.e.b bVar, long j) {
        ad adVarA;
        int i = bVar.f6391a;
        ac acVar = null;
        int iA = i;
        for (ac acVarE = e(); acVarE != null; acVarE = acVarE.i) {
            if (acVar != null) {
                if (iA != -1 && acVarE.b.equals(this.d.a(iA, this.f6268a, true).b) && (adVarA = a(acVar, j)) != null) {
                    acVarE.h = a(acVarE.h, iA);
                    if (!a(acVarE, adVarA)) {
                    }
                }
                return true ^ a(acVar);
            }
            acVarE.h = a(acVarE.h, iA);
            if (acVarE.h.f) {
                iA = this.d.a(iA, this.f6268a, this.b, this.e, this.f);
            }
            acVar = acVarE;
        }
        return true;
    }

    public boolean a(boolean z) {
        this.f = z;
        return j();
    }

    public ac b() {
        return this.i;
    }

    public ac c() {
        return this.g;
    }

    public ac d() {
        return this.h;
    }

    public ac e() {
        return f() ? this.g : this.i;
    }

    public boolean f() {
        return this.g != null;
    }

    public ac g() {
        ac acVar = this.h;
        com.opos.exoplayer.core.i.a.b((acVar == null || acVar.i == null) ? false : true);
        ac acVar2 = this.h.i;
        this.h = acVar2;
        return acVar2;
    }

    public ac h() {
        ac acVar = this.g;
        if (acVar != null) {
            if (acVar == this.h) {
                this.h = acVar.i;
            }
            this.g.d();
            this.g = this.g.i;
            int i = this.j - 1;
            this.j = i;
            if (i == 0) {
                this.i = null;
            }
        } else {
            ac acVar2 = this.i;
            this.g = acVar2;
            this.h = acVar2;
        }
        return this.g;
    }

    public void i() {
        ac acVarE = e();
        if (acVarE != null) {
            acVarE.d();
            a(acVarE);
        }
        this.g = null;
        this.i = null;
        this.h = null;
        this.j = 0;
    }
}
