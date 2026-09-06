package com.opos.exoplayer.core.e;

import android.net.Uri;
import android.os.Handler;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.h.r;
import com.opos.exoplayer.core.i.y;
import com.opos.exoplayer.core.x;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class o implements com.opos.exoplayer.core.c.g, com.opos.exoplayer.core.e.d, h.a, r.a<c>, r.c {
    private boolean[] A;
    private boolean[] B;
    private boolean[] C;
    private boolean D;
    private long F;
    private boolean H;
    private int I;
    private boolean J;
    private boolean K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f6405a;
    private final com.opos.exoplayer.core.h.g b;
    private final int c;
    private final com.opos.exoplayer.core.e.f.a d;
    private final e e;
    private final com.opos.exoplayer.core.h.b f;
    private final String g;
    private final long h;
    private final d j;
    private com.opos.exoplayer.core.e.d.a o;
    private com.opos.exoplayer.core.c.l p;
    private boolean s;
    private boolean t;
    private int u;
    private boolean v;
    private boolean w;
    private int x;
    private m y;
    private final r i = new r("Loader:ExtractorMediaPeriod");
    private final com.opos.exoplayer.core.i.h k = new com.opos.exoplayer.core.i.h();
    private final Runnable l = new a();
    private final Runnable m = new b();
    private final Handler n = new Handler();
    private int[] r = new int[0];
    private h[] q = new h[0];
    private long G = -9223372036854775807L;
    private long E = -1;
    private long z = -9223372036854775807L;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.j();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (o.this.K) {
                return;
            }
            o.this.o.a(o.this);
        }
    }

    final class c implements r.b {
        private final Uri b;
        private final com.opos.exoplayer.core.h.g c;
        private final d d;
        private final com.opos.exoplayer.core.i.h e;
        private volatile boolean g;
        private long i;
        private com.opos.exoplayer.core.h.i j;
        private long l;
        private final com.opos.exoplayer.core.c.k f = new com.opos.exoplayer.core.c.k();
        private boolean h = true;
        private long k = -1;

        public c(Uri uri, com.opos.exoplayer.core.h.g gVar, d dVar, com.opos.exoplayer.core.i.h hVar) {
            this.b = (Uri) com.opos.exoplayer.core.i.a.a(uri);
            this.c = (com.opos.exoplayer.core.h.g) com.opos.exoplayer.core.i.a.a(gVar);
            this.d = (d) com.opos.exoplayer.core.i.a.a(dVar);
            this.e = hVar;
        }

        @Override // com.opos.exoplayer.core.h.r.b
        public void a() {
            this.g = true;
        }

        public void a(long j, long j2) {
            this.f.f6369a = j;
            this.i = j2;
            this.h = true;
        }

        @Override // com.opos.exoplayer.core.h.r.b
        public boolean b() {
            return this.g;
        }

        @Override // com.opos.exoplayer.core.h.r.b
        public void c() throws Throwable {
            com.opos.exoplayer.core.c.b bVar;
            int iA = 0;
            while (iA == 0 && !this.g) {
                try {
                    long jC = this.f.f6369a;
                    com.opos.exoplayer.core.h.i iVar = new com.opos.exoplayer.core.h.i(this.b, jC, -1L, o.this.g);
                    this.j = iVar;
                    long jA = this.c.a(iVar);
                    this.k = jA;
                    if (jA != -1) {
                        this.k = jA + jC;
                    }
                    bVar = new com.opos.exoplayer.core.c.b(this.c, jC, this.k);
                    try {
                        com.opos.exoplayer.core.c.e eVarA = this.d.a(bVar, this.c.a());
                        if (this.h) {
                            eVarA.a(jC, this.i);
                            this.h = false;
                        }
                        while (iA == 0 && !this.g) {
                            this.e.c();
                            iA = eVarA.a(bVar, this.f);
                            if (bVar.c() > o.this.h + jC) {
                                jC = bVar.c();
                                this.e.b();
                                o.this.n.post(o.this.m);
                            }
                        }
                        if (iA == 1) {
                            iA = 0;
                        } else {
                            this.f.f6369a = bVar.c();
                            this.l = this.f.f6369a - this.j.c;
                        }
                        y.a(this.c);
                    } catch (Throwable th) {
                        th = th;
                        if (iA != 1 && bVar != null) {
                            this.f.f6369a = bVar.c();
                            this.l = this.f.f6369a - this.j.c;
                        }
                        y.a(this.c);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bVar = null;
                }
            }
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.opos.exoplayer.core.c.e[] f6409a;
        private final com.opos.exoplayer.core.c.g b;
        private com.opos.exoplayer.core.c.e c;

        public d(com.opos.exoplayer.core.c.e[] eVarArr, com.opos.exoplayer.core.c.g gVar) {
            this.f6409a = eVarArr;
            this.b = gVar;
        }

        public com.opos.exoplayer.core.c.e a(com.opos.exoplayer.core.c.f fVar, Uri uri) throws n {
            com.opos.exoplayer.core.c.e eVar = this.c;
            if (eVar != null) {
                return eVar;
            }
            for (com.opos.exoplayer.core.c.e eVar2 : this.f6409a) {
                try {
                    if (eVar2.a(fVar)) {
                        this.c = eVar2;
                        fVar.a();
                        break;
                    }
                    continue;
                } catch (EOFException unused) {
                } catch (Throwable th) {
                    fVar.a();
                    throw th;
                }
                fVar.a();
            }
            com.opos.exoplayer.core.c.e eVar3 = this.c;
            if (eVar3 == null) {
                throw new n("None of the available extractors (" + y.a(this.f6409a) + ") could read the stream.", uri);
            }
            eVar3.a(this.b);
            return this.c;
        }

        public void a() {
            com.opos.exoplayer.core.c.e eVar = this.c;
            if (eVar != null) {
                eVar.c();
                this.c = null;
            }
        }
    }

    interface e {
        void a(long j, boolean z);
    }

    private final class f implements i {
        private final int b;

        public f(int i) {
            this.b = i;
        }

        @Override // com.opos.exoplayer.core.e.i
        public int a(long j) {
            return o.this.a(this.b, j);
        }

        @Override // com.opos.exoplayer.core.e.i
        public int a(com.opos.exoplayer.core.l lVar, com.opos.exoplayer.core.b.e eVar, boolean z) {
            return o.this.a(this.b, lVar, eVar, z);
        }

        @Override // com.opos.exoplayer.core.e.i
        public boolean b() {
            return o.this.a(this.b);
        }

        @Override // com.opos.exoplayer.core.e.i
        public void c() throws IOException {
            o.this.h();
        }
    }

    public o(Uri uri, com.opos.exoplayer.core.h.g gVar, com.opos.exoplayer.core.c.e[] eVarArr, int i, com.opos.exoplayer.core.e.f.a aVar, e eVar, com.opos.exoplayer.core.h.b bVar, String str, int i2) {
        this.f6405a = uri;
        this.b = gVar;
        this.c = i;
        this.d = aVar;
        this.e = eVar;
        this.f = bVar;
        this.g = str;
        this.h = i2;
        this.j = new d(eVarArr, this);
        this.u = i == -1 ? 3 : i;
    }

    private void a(c cVar) {
        if (this.E == -1) {
            this.E = cVar.k;
        }
    }

    private boolean a(c cVar, int i) {
        com.opos.exoplayer.core.c.l lVar;
        if (this.E != -1 || ((lVar = this.p) != null && lVar.b() != -9223372036854775807L)) {
            this.I = i;
            return true;
        }
        if (this.t && !i()) {
            this.H = true;
            return false;
        }
        this.w = this.t;
        this.F = 0L;
        this.I = 0;
        for (h hVar : this.q) {
            hVar.a();
        }
        cVar.a(0L, 0L);
        return true;
    }

    private static boolean a(IOException iOException) {
        return iOException instanceof n;
    }

    private void b(int i) {
        if (this.C[i]) {
            return;
        }
        Format formatA = this.y.a(i).a(0);
        this.d.a(com.opos.exoplayer.core.i.m.e(formatA.f), formatA, 0, null, this.F);
        this.C[i] = true;
    }

    private void c(int i) {
        if (this.H && this.B[i] && !this.q[i].c()) {
            this.G = 0L;
            this.H = false;
            this.w = true;
            this.F = 0L;
            this.I = 0;
            for (h hVar : this.q) {
                hVar.a();
            }
            this.o.a(this);
        }
    }

    private boolean d(long j) {
        int length = this.q.length;
        for (int i = 0; i < length; i++) {
            h hVar = this.q[i];
            hVar.g();
            if (hVar.b(j, true, false) == -1 && (this.B[i] || !this.D)) {
                return false;
            }
        }
        return true;
    }

    private boolean i() {
        return this.w || n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.K || this.t || this.p == null || !this.s) {
            return;
        }
        for (h hVar : this.q) {
            if (hVar.e() == null) {
                return;
            }
        }
        this.k.b();
        int length = this.q.length;
        l[] lVarArr = new l[length];
        this.B = new boolean[length];
        this.A = new boolean[length];
        this.C = new boolean[length];
        this.z = this.p.b();
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            Format formatE = this.q[i].e();
            lVarArr[i] = new l(formatE);
            String str = formatE.f;
            if (!com.opos.exoplayer.core.i.m.b(str) && !com.opos.exoplayer.core.i.m.a(str)) {
                z = false;
            }
            this.B[i] = z;
            this.D = z | this.D;
            i++;
        }
        this.y = new m(lVarArr);
        if (this.c == -1 && this.E == -1 && this.p.b() == -9223372036854775807L) {
            this.u = 6;
        }
        this.t = true;
        this.e.a(this.z, this.p.a());
        this.o.a((com.opos.exoplayer.core.e.d) this);
    }

    private void k() {
        c cVar = new c(this.f6405a, this.b, this.j, this.k);
        if (this.t) {
            com.opos.exoplayer.core.i.a.b(n());
            long j = this.z;
            if (j != -9223372036854775807L && this.G >= j) {
                this.J = true;
                this.G = -9223372036854775807L;
                return;
            } else {
                cVar.a(this.p.b(this.G).f6370a.c, this.G);
                this.G = -9223372036854775807L;
            }
        }
        this.I = l();
        this.d.a(cVar.j, 1, -1, null, 0, null, cVar.i, this.z, this.i.a(cVar, this, this.u));
    }

    private int l() {
        int iB = 0;
        for (h hVar : this.q) {
            iB += hVar.b();
        }
        return iB;
    }

    private long m() {
        long jMax = Long.MIN_VALUE;
        for (h hVar : this.q) {
            jMax = Math.max(jMax, hVar.f());
        }
        return jMax;
    }

    private boolean n() {
        return this.G != -9223372036854775807L;
    }

    int a(int i, long j) {
        int i2 = 0;
        if (i()) {
            return 0;
        }
        h hVar = this.q[i];
        if (!this.J || j <= hVar.f()) {
            int iB = hVar.b(j, true, true);
            if (iB != -1) {
                i2 = iB;
            }
        } else {
            i2 = hVar.i();
        }
        if (i2 > 0) {
            b(i);
        } else {
            c(i);
        }
        return i2;
    }

    int a(int i, com.opos.exoplayer.core.l lVar, com.opos.exoplayer.core.b.e eVar, boolean z) {
        if (i()) {
            return -3;
        }
        int iA = this.q[i].a(lVar, eVar, z, this.J, this.F);
        if (iA == -4) {
            b(i);
        } else if (iA == -3) {
            c(i);
        }
        return iA;
    }

    @Override // com.opos.exoplayer.core.h.r.a
    public int a(c cVar, long j, long j2, IOException iOException) {
        boolean zA = a(iOException);
        this.d.a(cVar.j, 1, -1, null, 0, null, cVar.i, this.z, j, j2, cVar.l, iOException, zA);
        a(cVar);
        if (zA) {
            return 3;
        }
        int iL = l();
        boolean z = iL > this.I;
        if (a(cVar, iL)) {
            return z ? 1 : 0;
        }
        return 2;
    }

    @Override // com.opos.exoplayer.core.e.d
    public long a(long j, x xVar) {
        if (!this.p.a()) {
            return 0L;
        }
        com.opos.exoplayer.core.c.l.a aVarB = this.p.b(j);
        return y.a(j, xVar, aVarB.f6370a.b, aVarB.b.b);
    }

    @Override // com.opos.exoplayer.core.e.d
    public long a(com.opos.exoplayer.core.g.f[] fVarArr, boolean[] zArr, i[] iVarArr, boolean[] zArr2, long j) {
        com.opos.exoplayer.core.g.f fVar;
        com.opos.exoplayer.core.i.a.b(this.t);
        int i = this.x;
        int i2 = 0;
        for (int i3 = 0; i3 < fVarArr.length; i3++) {
            i iVar = iVarArr[i3];
            if (iVar != null && (fVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((f) iVar).b;
                com.opos.exoplayer.core.i.a.b(this.A[i4]);
                this.x--;
                this.A[i4] = false;
                iVarArr[i3] = null;
            }
        }
        boolean z = !this.v ? j == 0 : i != 0;
        for (int i5 = 0; i5 < fVarArr.length; i5++) {
            if (iVarArr[i5] == null && (fVar = fVarArr[i5]) != null) {
                com.opos.exoplayer.core.i.a.b(fVar.e() == 1);
                com.opos.exoplayer.core.i.a.b(fVar.b(0) == 0);
                int iA = this.y.a(fVar.d());
                com.opos.exoplayer.core.i.a.b(!this.A[iA]);
                this.x++;
                this.A[iA] = true;
                iVarArr[i5] = new f(iA);
                zArr2[i5] = true;
                if (!z) {
                    h hVar = this.q[iA];
                    hVar.g();
                    z = hVar.b(j, true, true) == -1 && hVar.d() != 0;
                }
            }
        }
        if (this.x == 0) {
            this.H = false;
            this.w = false;
            if (this.i.a()) {
                h[] hVarArr = this.q;
                int length = hVarArr.length;
                while (i2 < length) {
                    hVarArr[i2].h();
                    i2++;
                }
                this.i.b();
            } else {
                h[] hVarArr2 = this.q;
                int length2 = hVarArr2.length;
                while (i2 < length2) {
                    hVarArr2[i2].a();
                    i2++;
                }
            }
        } else if (z) {
            j = b(j);
            while (i2 < iVarArr.length) {
                if (iVarArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.v = true;
        return j;
    }

    @Override // com.opos.exoplayer.core.c.g
    public com.opos.exoplayer.core.c.n a(int i, int i2) {
        int length = this.q.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.r[i3] == i) {
                return this.q[i3];
            }
        }
        h hVar = new h(this.f);
        hVar.a(this);
        int i4 = length + 1;
        int[] iArrCopyOf = Arrays.copyOf(this.r, i4);
        this.r = iArrCopyOf;
        iArrCopyOf[length] = i;
        h[] hVarArr = (h[]) Arrays.copyOf(this.q, i4);
        this.q = hVarArr;
        hVarArr[length] = hVar;
        return hVar;
    }

    @Override // com.opos.exoplayer.core.c.g
    public void a() {
        this.s = true;
        this.n.post(this.l);
    }

    @Override // com.opos.exoplayer.core.e.d
    public void a(long j) {
    }

    @Override // com.opos.exoplayer.core.e.d
    public void a(long j, boolean z) {
        int length = this.q.length;
        for (int i = 0; i < length; i++) {
            this.q[i].a(j, z, this.A[i]);
        }
    }

    @Override // com.opos.exoplayer.core.e.h.a
    public void a(Format format) {
        this.n.post(this.l);
    }

    @Override // com.opos.exoplayer.core.c.g
    public void a(com.opos.exoplayer.core.c.l lVar) {
        this.p = lVar;
        this.n.post(this.l);
    }

    @Override // com.opos.exoplayer.core.e.d
    public void a(com.opos.exoplayer.core.e.d.a aVar, long j) {
        this.o = aVar;
        this.k.a();
        k();
    }

    @Override // com.opos.exoplayer.core.h.r.a
    public void a(c cVar, long j, long j2) {
        if (this.z == -9223372036854775807L) {
            long jM = m();
            long j3 = jM == Long.MIN_VALUE ? 0L : jM + ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.z = j3;
            this.e.a(j3, this.p.a());
        }
        this.d.a(cVar.j, 1, -1, null, 0, null, cVar.i, this.z, j, j2, cVar.l);
        a(cVar);
        this.J = true;
        this.o.a(this);
    }

    @Override // com.opos.exoplayer.core.h.r.a
    public void a(c cVar, long j, long j2, boolean z) {
        this.d.b(cVar.j, 1, -1, null, 0, null, cVar.i, this.z, j, j2, cVar.l);
        if (z) {
            return;
        }
        a(cVar);
        for (h hVar : this.q) {
            hVar.a();
        }
        if (this.x > 0) {
            this.o.a(this);
        }
    }

    boolean a(int i) {
        return !i() && (this.J || this.q[i].c());
    }

    @Override // com.opos.exoplayer.core.e.d
    public long b(long j) {
        if (!this.p.a()) {
            j = 0;
        }
        this.F = j;
        this.w = false;
        if (!n() && d(j)) {
            return j;
        }
        this.H = false;
        this.G = j;
        this.J = false;
        if (this.i.a()) {
            this.i.b();
        } else {
            for (h hVar : this.q) {
                hVar.a();
            }
        }
        return j;
    }

    @Override // com.opos.exoplayer.core.e.d
    public m b() {
        return this.y;
    }

    @Override // com.opos.exoplayer.core.e.d
    public long c() {
        if (!this.w) {
            return -9223372036854775807L;
        }
        if (!this.J && l() <= this.I) {
            return -9223372036854775807L;
        }
        this.w = false;
        return this.F;
    }

    @Override // com.opos.exoplayer.core.e.d
    public boolean c(long j) {
        if (this.J || this.H) {
            return false;
        }
        if (this.t && this.x == 0) {
            return false;
        }
        boolean zA = this.k.a();
        if (this.i.a()) {
            return zA;
        }
        k();
        return true;
    }

    @Override // com.opos.exoplayer.core.e.d
    public void c_() throws IOException {
        h();
    }

    @Override // com.opos.exoplayer.core.e.d
    public long d() {
        long jM;
        if (this.J) {
            return Long.MIN_VALUE;
        }
        if (n()) {
            return this.G;
        }
        if (this.D) {
            int length = this.q.length;
            jM = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (this.B[i]) {
                    jM = Math.min(jM, this.q[i].f());
                }
            }
        } else {
            jM = m();
        }
        return jM == Long.MIN_VALUE ? this.F : jM;
    }

    @Override // com.opos.exoplayer.core.e.d
    public long e() {
        if (this.x == 0) {
            return Long.MIN_VALUE;
        }
        return d();
    }

    public void f() {
        if (this.t) {
            for (h hVar : this.q) {
                hVar.h();
            }
        }
        this.i.a(this);
        this.n.removeCallbacksAndMessages(null);
        this.K = true;
    }

    @Override // com.opos.exoplayer.core.h.r.c
    public void g() {
        for (h hVar : this.q) {
            hVar.a();
        }
        this.j.a();
    }

    void h() throws IOException {
        this.i.a(this.u);
    }
}
