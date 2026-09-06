package com.opos.exoplayer.core.e;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a implements d, d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f6385a;
    long b;
    long c;
    private d.a d;
    private C0917a[] e = new C0917a[0];
    private long f;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.e.a$a, reason: collision with other inner class name */
    private final class C0917a implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f6386a;
        private boolean c;

        public C0917a(i iVar) {
            this.f6386a = iVar;
        }

        @Override // com.opos.exoplayer.core.e.i
        public int a(long j) {
            if (a.this.f()) {
                return -3;
            }
            return this.f6386a.a(a.this.b + j);
        }

        @Override // com.opos.exoplayer.core.e.i
        public int a(com.opos.exoplayer.core.l lVar, com.opos.exoplayer.core.b.e eVar, boolean z) {
            if (a.this.f()) {
                return -3;
            }
            if (this.c) {
                eVar.a_(4);
                return -4;
            }
            int iA = this.f6386a.a(lVar, eVar, z);
            if (iA == -5) {
                Format format = lVar.f6520a;
                if (format.u != -1 || format.v != -1) {
                    lVar.f6520a = format.a(a.this.b != 0 ? 0 : format.u, a.this.c == Long.MIN_VALUE ? format.v : 0);
                }
                return -5;
            }
            long j = a.this.c;
            if (j == Long.MIN_VALUE || ((iA != -4 || eVar.c < j) && !(iA == -3 && a.this.d() == Long.MIN_VALUE))) {
                if (iA == -4 && !eVar.c()) {
                    eVar.c -= a.this.b;
                }
                return iA;
            }
            eVar.a();
            eVar.a_(4);
            this.c = true;
            return -4;
        }

        public void a() {
            this.c = false;
        }

        @Override // com.opos.exoplayer.core.e.i
        public boolean b() {
            return !a.this.f() && this.f6386a.b();
        }

        @Override // com.opos.exoplayer.core.e.i
        public void c() {
            this.f6386a.c();
        }
    }

    public a(d dVar, boolean z) {
        this.f6385a = dVar;
        this.f = z ? 0L : -9223372036854775807L;
        this.b = -9223372036854775807L;
        this.c = -9223372036854775807L;
    }

    private static boolean a(long j, com.opos.exoplayer.core.g.f[] fVarArr) {
        if (j != 0) {
            for (com.opos.exoplayer.core.g.f fVar : fVarArr) {
                if (fVar != null && !com.opos.exoplayer.core.i.m.a(fVar.f().f)) {
                    return true;
                }
            }
        }
        return false;
    }

    private x b(long j, x xVar) {
        long jMin = Math.min(j - this.b, xVar.f);
        long j2 = this.c;
        long jMin2 = j2 == Long.MIN_VALUE ? xVar.g : Math.min(j2 - j, xVar.g);
        return (jMin == xVar.f && jMin2 == xVar.g) ? xVar : new x(jMin, jMin2);
    }

    @Override // com.opos.exoplayer.core.e.d
    public long a(long j, x xVar) {
        long j2 = this.b;
        if (j == j2) {
            return 0L;
        }
        long j3 = j + j2;
        return this.f6385a.a(j3, b(j3, xVar)) - this.b;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x006b  */
    @Override // com.opos.exoplayer.core.e.d
    public long a(com.opos.exoplayer.core.g.f[] fVarArr, boolean[] zArr, i[] iVarArr, boolean[] zArr2, long j) {
        boolean z;
        this.e = new C0917a[iVarArr.length];
        i[] iVarArr2 = new i[iVarArr.length];
        int i = 0;
        while (true) {
            i iVar = null;
            if (i >= iVarArr.length) {
                break;
            }
            C0917a[] c0917aArr = this.e;
            C0917a c0917a = (C0917a) iVarArr[i];
            c0917aArr[i] = c0917a;
            if (c0917a != null) {
                iVar = c0917a.f6386a;
            }
            iVarArr2[i] = iVar;
            i++;
        }
        long jA = this.f6385a.a(fVarArr, zArr, iVarArr2, zArr2, j + this.b) - this.b;
        this.f = (f() && j == 0 && a(this.b, fVarArr)) ? jA : -9223372036854775807L;
        if (jA != j) {
            if (jA >= 0) {
                long j2 = this.c;
                z = j2 == Long.MIN_VALUE || this.b + jA <= j2;
            }
        }
        com.opos.exoplayer.core.i.a.b(z);
        for (int i2 = 0; i2 < iVarArr.length; i2++) {
            if (iVarArr2[i2] == null) {
                this.e[i2] = null;
            } else if (iVarArr[i2] == null || this.e[i2].f6386a != iVarArr2[i2]) {
                this.e[i2] = new C0917a(iVarArr2[i2]);
            }
            iVarArr[i2] = this.e[i2];
        }
        return jA;
    }

    @Override // com.opos.exoplayer.core.e.d
    public void a(long j) {
        this.f6385a.a(j + this.b);
    }

    public void a(long j, long j2) {
        this.b = j;
        this.c = j2;
    }

    @Override // com.opos.exoplayer.core.e.d
    public void a(long j, boolean z) {
        this.f6385a.a(j + this.b, z);
    }

    @Override // com.opos.exoplayer.core.e.d
    public void a(d.a aVar, long j) {
        this.d = aVar;
        this.f6385a.a(this, this.b + j);
    }

    @Override // com.opos.exoplayer.core.e.d.a
    public void a(d dVar) {
        com.opos.exoplayer.core.i.a.b((this.b == -9223372036854775807L || this.c == -9223372036854775807L) ? false : true);
        this.d.a((d) this);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    @Override // com.opos.exoplayer.core.e.d
    public long b(long j) {
        this.f = -9223372036854775807L;
        boolean z = false;
        for (C0917a c0917a : this.e) {
            if (c0917a != null) {
                c0917a.a();
            }
        }
        long j2 = j + this.b;
        long jB = this.f6385a.b(j2);
        if (jB == j2) {
            z = true;
        } else if (jB >= this.b) {
            long j3 = this.c;
            if (j3 == Long.MIN_VALUE || jB <= j3) {
                z = true;
            }
        }
        com.opos.exoplayer.core.i.a.b(z);
        return jB - this.b;
    }

    @Override // com.opos.exoplayer.core.e.d
    public m b() {
        return this.f6385a.b();
    }

    @Override // com.opos.exoplayer.core.e.j.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(d dVar) {
        this.d.a(this);
    }

    @Override // com.opos.exoplayer.core.e.d
    public long c() {
        if (f()) {
            long j = this.f;
            this.f = -9223372036854775807L;
            long jC = c();
            return jC != -9223372036854775807L ? jC : j;
        }
        long jC2 = this.f6385a.c();
        if (jC2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = true;
        com.opos.exoplayer.core.i.a.b(jC2 >= this.b);
        long j2 = this.c;
        if (j2 != Long.MIN_VALUE && jC2 > j2) {
            z = false;
        }
        com.opos.exoplayer.core.i.a.b(z);
        return jC2 - this.b;
    }

    @Override // com.opos.exoplayer.core.e.d
    public boolean c(long j) {
        return this.f6385a.c(j + this.b);
    }

    @Override // com.opos.exoplayer.core.e.d
    public void c_() {
        this.f6385a.c_();
    }

    @Override // com.opos.exoplayer.core.e.d
    public long d() {
        long jD = this.f6385a.d();
        if (jD != Long.MIN_VALUE) {
            long j = this.c;
            if (j == Long.MIN_VALUE || jD < j) {
                return Math.max(0L, jD - this.b);
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.opos.exoplayer.core.e.d
    public long e() {
        long jE = this.f6385a.e();
        if (jE != Long.MIN_VALUE) {
            long j = this.c;
            if (j == Long.MIN_VALUE || jE < j) {
                return jE - this.b;
            }
        }
        return Long.MIN_VALUE;
    }

    boolean f() {
        return this.f != -9223372036854775807L;
    }
}
