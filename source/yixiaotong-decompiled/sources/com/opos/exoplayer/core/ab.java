package com.opos.exoplayer.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class ab implements Handler.Callback, com.opos.exoplayer.core.e.d.a, com.opos.exoplayer.core.e.e.a, com.opos.exoplayer.core.f.a, com.opos.exoplayer.core.g.h.a, r.a {
    private int A;
    private boolean B;
    private int C;
    private f D;
    private long E;
    private int F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t[] f6259a;
    private final u[] b;
    private final com.opos.exoplayer.core.g.h c;
    private final com.opos.exoplayer.core.g.i d;
    private final n e;
    private final com.opos.exoplayer.core.i.j f;
    private final HandlerThread g;
    private final Handler h;
    private final i i;
    private final z.b j;
    private final z.a k;
    private final long l;
    private final boolean m;
    private final com.opos.exoplayer.core.f n;
    private final ArrayList<d> p;
    private final com.opos.exoplayer.core.i.e q;
    private af t;
    private com.opos.exoplayer.core.e.e u;
    private t[] v;
    private boolean w;
    private boolean y;
    private boolean z;
    private volatile boolean x = false;
    private long G = 500;
    private final ae r = new ae();
    private x s = x.e;
    private final e o = new e(null);

    class a implements com.opos.exoplayer.core.i.v<Boolean> {
        a() {
        }

        @Override // com.opos.exoplayer.core.i.v
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean b() {
            return Boolean.valueOf(ab.this.w);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f6261a;

        b(r rVar) {
            this.f6261a = rVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ab.this.e(this.f6261a);
            } catch (h e) {
                com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
                throw new RuntimeException(e);
            }
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.opos.exoplayer.core.e.e f6262a;
        public final z b;
        public final Object c;

        public c(com.opos.exoplayer.core.e.e eVar, z zVar, Object obj) {
            this.f6262a = eVar;
            this.b = zVar;
            this.c = obj;
        }
    }

    private static final class d implements Comparable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r f6263a;
        public int b;
        public long c;
        public Object d;

        public d(r rVar) {
            this.f6263a = rVar;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            Object obj = this.d;
            if ((obj == null) != (dVar.d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.b - dVar.b;
            return i != 0 ? i : com.opos.exoplayer.core.i.y.a(this.c, dVar.c);
        }

        public void a(int i, long j, Object obj) {
            this.b = i;
            this.c = j;
            this.d = obj;
        }
    }

    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private af f6264a;
        private int b;
        private boolean c;
        private int d;

        private e() {
        }

        /* synthetic */ e(a aVar) {
            this();
        }

        public void a(int i) {
            this.b += i;
        }

        public boolean a(af afVar) {
            return afVar != this.f6264a || this.b > 0 || this.c;
        }

        public void b(int i) {
            if (this.c && this.d != 4) {
                com.opos.exoplayer.core.i.a.a(i == 4);
            } else {
                this.c = true;
                this.d = i;
            }
        }

        public void b(af afVar) {
            this.f6264a = afVar;
            this.b = 0;
            this.c = false;
        }
    }

    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z f6265a;
        public final int b;
        public final long c;

        public f(z zVar, int i, long j) {
            this.f6265a = zVar;
            this.b = i;
            this.c = j;
        }
    }

    public ab(t[] tVarArr, com.opos.exoplayer.core.g.h hVar, com.opos.exoplayer.core.g.i iVar, n nVar, boolean z, int i, boolean z2, Handler handler, i iVar2, com.opos.exoplayer.core.i.e eVar) {
        this.f6259a = tVarArr;
        this.c = hVar;
        this.d = iVar;
        this.e = nVar;
        this.y = z;
        this.A = i;
        this.B = z2;
        this.h = handler;
        this.i = iVar2;
        this.q = eVar;
        this.l = nVar.e();
        this.m = nVar.f();
        this.t = new af(z.f6569a, -9223372036854775807L, iVar);
        this.b = new u[tVarArr.length];
        for (int i2 = 0; i2 < tVarArr.length; i2++) {
            tVarArr[i2].a(i2);
            this.b[i2] = tVarArr[i2].b();
        }
        this.n = new com.opos.exoplayer.core.f(this, eVar);
        this.p = new ArrayList<>();
        this.v = new t[0];
        this.j = new z.b();
        this.k = new z.a();
        hVar.a((com.opos.exoplayer.core.g.h.a) this);
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.g = handlerThread;
        handlerThread.start();
        this.f = eVar.a(handlerThread.getLooper(), this);
    }

    private int a(int i, z zVar, z zVar2) {
        int iC = zVar.c();
        int iA = i;
        int iA2 = -1;
        for (int i2 = 0; i2 < iC && iA2 == -1; i2++) {
            iA = zVar.a(iA, this.k, this.j, this.A, this.B);
            if (iA == -1) {
                break;
            }
            iA2 = zVar2.a(zVar.a(iA, this.k, true).b);
        }
        return iA2;
    }

    private long a(com.opos.exoplayer.core.e.e.b bVar, long j) {
        return a(bVar, j, this.r.c() != this.r.d());
    }

    private long a(com.opos.exoplayer.core.e.e.b bVar, long j, boolean z) throws h {
        e();
        this.z = false;
        b(2);
        ac acVarC = this.r.c();
        ac acVarH = acVarC;
        while (acVarH != null) {
            if (a(bVar, j, acVarH)) {
                this.r.a(acVarH);
                break;
            }
            acVarH = this.r.h();
        }
        if (acVarC != acVarH || z) {
            for (t tVar : this.v) {
                b(tVar);
            }
            this.v = new t[0];
            acVarC = null;
        }
        if (acVarH != null) {
            a(acVarC);
            if (acVarH.g) {
                long jB = acVarH.f6266a.b(j);
                acVarH.f6266a.a(jB - this.l, this.m);
                j = jB;
            }
            a(j);
            q();
        } else {
            this.r.i();
            a(j);
        }
        this.f.a(2);
        return j;
    }

    private Pair<Integer, Long> a(f fVar, boolean z) {
        int iA;
        z zVar = this.t.f6269a;
        z zVar2 = fVar.f6265a;
        if (zVar.a()) {
            return null;
        }
        if (zVar2.a()) {
            zVar2 = zVar;
        }
        try {
            Pair<Integer, Long> pairA = zVar2.a(this.j, this.k, fVar.b, fVar.c);
            if (zVar == zVar2) {
                return pairA;
            }
            int iA2 = zVar.a(zVar2.a(((Integer) pairA.first).intValue(), this.k, true).b);
            if (iA2 != -1) {
                return Pair.create(Integer.valueOf(iA2), pairA.second);
            }
            if (!z || (iA = a(((Integer) pairA.first).intValue(), zVar2, zVar)) == -1) {
                return null;
            }
            return b(zVar, zVar.a(iA, this.k).c, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new m(zVar, fVar.b, fVar.c);
        }
    }

    private void a(float f2) {
        for (ac acVarE = this.r.e(); acVarE != null; acVarE = acVarE.i) {
            com.opos.exoplayer.core.g.i iVar = acVarE.j;
            if (iVar != null) {
                for (com.opos.exoplayer.core.g.f fVar : iVar.c.a()) {
                    if (fVar != null) {
                        fVar.a(f2);
                    }
                }
            }
        }
    }

    private void a(int i, boolean z, int i2) throws h {
        ac acVarC = this.r.c();
        t tVar = this.f6259a[i];
        this.v[i2] = tVar;
        if (tVar.a_() == 0) {
            com.opos.exoplayer.core.g.i iVar = acVarC.j;
            v vVar = iVar.e[i];
            Format[] formatArrA = a(iVar.c.a(i));
            boolean z2 = this.y && this.t.f == 3;
            tVar.a(vVar, formatArrA, acVarC.c[i], this.E, !z && z2, acVarC.a());
            this.n.a(tVar);
            if (z2) {
                tVar.b_();
            }
        }
    }

    private void a(long j) {
        long jA = !this.r.f() ? j + 60000000 : this.r.c().a(j);
        this.E = jA;
        this.n.a(jA);
        for (t tVar : this.v) {
            tVar.a(this.E);
        }
    }

    private void a(long j, long j2) {
        this.f.b(2);
        this.f.a(2, j + j2);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0066 A[PHI: r10 r11 r14
  0x0066: PHI (r10v5 com.opos.exoplayer.core.af) = (r10v2 com.opos.exoplayer.core.af), (r10v6 com.opos.exoplayer.core.af) binds: [B:23:0x00a5, B:13:0x0064] A[DONT_GENERATE, DONT_INLINE]
  0x0066: PHI (r11v11 com.opos.exoplayer.core.e.e$b) = (r11v8 com.opos.exoplayer.core.e.e$b), (r11v12 com.opos.exoplayer.core.e.e$b) binds: [B:23:0x00a5, B:13:0x0064] A[DONT_GENERATE, DONT_INLINE]
  0x0066: PHI (r14v4 long) = (r14v1 long), (r14v5 long) binds: [B:23:0x00a5, B:13:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:15:0x0068 A[PHI: r10 r11 r14
  0x0068: PHI (r10v3 com.opos.exoplayer.core.af) = (r10v2 com.opos.exoplayer.core.af), (r10v6 com.opos.exoplayer.core.af) binds: [B:23:0x00a5, B:13:0x0064] A[DONT_GENERATE, DONT_INLINE]
  0x0068: PHI (r11v9 com.opos.exoplayer.core.e.e$b) = (r11v8 com.opos.exoplayer.core.e.e$b), (r11v12 com.opos.exoplayer.core.e.e$b) binds: [B:23:0x00a5, B:13:0x0064] A[DONT_GENERATE, DONT_INLINE]
  0x0068: PHI (r14v2 long) = (r14v1 long), (r14v5 long) binds: [B:23:0x00a5, B:13:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    private void a(c cVar) throws h {
        af afVarA;
        long jLongValue;
        com.opos.exoplayer.core.e.e.b bVarA;
        af afVar;
        long j;
        if (cVar.f6262a != this.u) {
            return;
        }
        z zVar = this.t.f6269a;
        z zVar2 = cVar.b;
        Object obj = cVar.c;
        this.r.a(zVar2);
        this.t = this.t.a(zVar2, obj);
        j();
        int i = this.C;
        if (i > 0) {
            this.o.a(i);
            this.C = 0;
            f fVar = this.D;
            if (fVar != null) {
                Pair<Integer, Long> pairA = a(fVar, true);
                this.D = null;
                if (pairA != null) {
                    int iIntValue = ((Integer) pairA.first).intValue();
                    jLongValue = ((Long) pairA.second).longValue();
                    bVarA = this.r.a(iIntValue, jLongValue);
                    afVar = this.t;
                    if (bVarA.a()) {
                        j = 0;
                    } else {
                        j = jLongValue;
                    }
                }
                n();
                return;
            }
            if (this.t.d == -9223372036854775807L) {
                if (!zVar2.a()) {
                    Pair<Integer, Long> pairB = b(zVar2, zVar2.b(this.B), -9223372036854775807L);
                    int iIntValue2 = ((Integer) pairB.first).intValue();
                    jLongValue = ((Long) pairB.second).longValue();
                    bVarA = this.r.a(iIntValue2, jLongValue);
                    afVar = this.t;
                    if (bVarA.a()) {
                        j = 0;
                    } else {
                        j = jLongValue;
                    }
                }
                n();
                return;
            }
            return;
            this.t = afVar.a(bVarA, j, jLongValue);
            return;
        }
        af afVar2 = this.t;
        int i2 = afVar2.c.f6391a;
        long j2 = afVar2.e;
        if (zVar.a()) {
            if (zVar2.a()) {
                return;
            }
            com.opos.exoplayer.core.e.e.b bVarA2 = this.r.a(i2, j2);
            this.t = this.t.a(bVarA2, bVarA2.a() ? 0L : j2, j2);
            return;
        }
        ac acVarE = this.r.e();
        int iA = zVar2.a(acVarE == null ? zVar.a(i2, this.k, true).b : acVarE.b);
        if (iA != -1) {
            if (iA != i2) {
                this.t = this.t.a(iA);
            }
            com.opos.exoplayer.core.e.e.b bVar = this.t.c;
            if (bVar.a()) {
                com.opos.exoplayer.core.e.e.b bVarA3 = this.r.a(iA, j2);
                if (!bVarA3.equals(bVar)) {
                    afVarA = this.t.a(bVarA3, a(bVarA3, bVarA3.a() ? 0L : j2), j2);
                }
            }
            if (this.r.a(bVar, this.E)) {
                return;
            }
            e(false);
            return;
        }
        int iA2 = a(i2, zVar, zVar2);
        if (iA2 == -1) {
            n();
            return;
        }
        Pair<Integer, Long> pairB2 = b(zVar2, zVar2.a(iA2, this.k).c, -9223372036854775807L);
        int iIntValue3 = ((Integer) pairB2.first).intValue();
        long jLongValue2 = ((Long) pairB2.second).longValue();
        com.opos.exoplayer.core.e.e.b bVarA4 = this.r.a(iIntValue3, jLongValue2);
        zVar2.a(iIntValue3, this.k, true);
        if (acVarE != null) {
            Object obj2 = this.k.b;
            loop0: while (true) {
                ad adVarA = acVarE.h.a(-1);
                while (true) {
                    acVarE.h = adVarA;
                    acVarE = acVarE.i;
                    if (acVarE == null) {
                        break loop0;
                    } else if (acVarE.b.equals(obj2)) {
                        adVarA = this.r.a(acVarE.h, iIntValue3);
                    }
                }
            }
        }
        afVarA = this.t.a(bVarA4, a(bVarA4, bVarA4.a() ? 0L : jLongValue2), jLongValue2);
        this.t = afVarA;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00d4 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
    private void a(f fVar) {
        long jLongValue;
        boolean z;
        com.opos.exoplayer.core.e.e.b bVar;
        long j;
        long j2;
        af afVarA;
        long jA;
        boolean z2 = true;
        this.o.a(1);
        Pair<Integer, Long> pairA = a(fVar, true);
        if (pairA == null) {
            bVar = new com.opos.exoplayer.core.e.e.b(i());
            z = true;
            jLongValue = -9223372036854775807L;
            j = -9223372036854775807L;
        } else {
            int iIntValue = ((Integer) pairA.first).intValue();
            long jLongValue2 = ((Long) pairA.second).longValue();
            com.opos.exoplayer.core.e.e.b bVarA = this.r.a(iIntValue, jLongValue2);
            if (bVarA.a()) {
                z = true;
                jLongValue = 0;
            } else {
                jLongValue = ((Long) pairA.second).longValue();
                z = fVar.c == -9223372036854775807L;
            }
            bVar = bVarA;
            j = jLongValue2;
        }
        try {
            if (this.u != null && this.C <= 0) {
                if (jLongValue == -9223372036854775807L) {
                    b(4);
                    a(false, true, false);
                } else {
                    if (bVar.equals(this.t.c)) {
                        ac acVarC = this.r.c();
                        jA = (acVarC == null || jLongValue == 0) ? jLongValue : acVarC.f6266a.a(jLongValue, this.s);
                        if (com.opos.exoplayer.core.b.a(jA) == com.opos.exoplayer.core.b.a(this.t.i)) {
                            afVarA = this.t.a(bVar, this.t.i, j);
                            if (z) {
                                return;
                            } else {
                                return;
                            }
                        }
                    } else {
                        jA = jLongValue;
                    }
                    long jA2 = a(bVar, jA);
                    if (jLongValue == jA2) {
                        z2 = false;
                    }
                    z |= z2;
                    j2 = jA2;
                }
                afVarA = this.t.a(bVar, j2, j);
            }
            this.D = fVar;
            j2 = jLongValue;
            afVarA = this.t.a(bVar, j2, j);
        } finally {
            this.t = this.t.a(bVar, jLongValue, j);
            if (z) {
                this.o.b(2);
            }
        }
    }

    private void a(ac acVar) throws h {
        ac acVarC = this.r.c();
        if (acVarC == null || acVar == acVarC) {
            return;
        }
        boolean[] zArr = new boolean[this.f6259a.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            t[] tVarArr = this.f6259a;
            if (i >= tVarArr.length) {
                this.t = this.t.a(acVarC.j);
                a(zArr, i2);
                return;
            }
            t tVar = tVarArr[i];
            zArr[i] = tVar.a_() != 0;
            if (acVarC.j.b[i]) {
                i2++;
            }
            if (zArr[i] && (!acVarC.j.b[i] || (tVar.i() && tVar.f() == acVar.c[i]))) {
                b(tVar);
            }
            i++;
        }
    }

    private void a(com.opos.exoplayer.core.g.i iVar) {
        this.e.a(this.f6259a, iVar.f6476a, iVar.c);
    }

    private synchronized void a(com.opos.exoplayer.core.i.v<Boolean> vVar, long j) {
        long jA = this.q.a() + j;
        boolean z = false;
        while (!vVar.b().booleanValue() && j > 0) {
            try {
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = jA - this.q.a();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private void a(t tVar) {
        if (tVar.a_() == 2) {
            tVar.k();
        }
    }

    private void a(x xVar) {
        this.s = xVar;
    }

    private void a(boolean z, boolean z2) {
        a(true, z, z);
        this.o.a(this.C + (z2 ? 1 : 0));
        this.C = 0;
        this.e.b();
        b(1);
    }

    private void a(boolean z, boolean z2, boolean z3) {
        com.opos.exoplayer.core.e.e eVar;
        this.f.b(2);
        this.z = false;
        this.n.b();
        this.E = 60000000L;
        for (t tVar : this.v) {
            try {
                b(tVar);
            } catch (h | RuntimeException e2) {
                com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Stop failed.", e2);
            }
        }
        this.v = new t[0];
        this.r.i();
        b(false);
        if (z2) {
            this.D = null;
        }
        if (z3) {
            this.r.a(z.f6569a);
            Iterator<d> it = this.p.iterator();
            while (it.hasNext()) {
                it.next().f6263a.a(false);
            }
            this.p.clear();
            this.F = 0;
        }
        z zVar = z3 ? z.f6569a : this.t.f6269a;
        Object obj = z3 ? null : this.t.b;
        com.opos.exoplayer.core.e.e.b bVar = z2 ? new com.opos.exoplayer.core.e.e.b(i()) : this.t.c;
        long j = z2 ? -9223372036854775807L : this.t.i;
        long j2 = z2 ? -9223372036854775807L : this.t.e;
        af afVar = this.t;
        this.t = new af(zVar, obj, bVar, j, j2, afVar.f, false, z3 ? this.d : afVar.h);
        if (!z || (eVar = this.u) == null) {
            return;
        }
        eVar.b();
        this.u = null;
    }

    private void a(boolean[] zArr, int i) throws h {
        this.v = new t[i];
        ac acVarC = this.r.c();
        int i2 = 0;
        for (int i3 = 0; i3 < this.f6259a.length; i3++) {
            if (acVarC.j.b[i3]) {
                a(i3, zArr[i3], i2);
                i2++;
            }
        }
    }

    private boolean a(d dVar) {
        Object obj = dVar.d;
        if (obj == null) {
            Pair<Integer, Long> pairA = a(new f(dVar.f6263a.a(), dVar.f6263a.g(), com.opos.exoplayer.core.b.b(dVar.f6263a.f())), false);
            if (pairA == null) {
                return false;
            }
            dVar.a(((Integer) pairA.first).intValue(), ((Long) pairA.second).longValue(), this.t.f6269a.a(((Integer) pairA.first).intValue(), this.k, true).b);
        } else {
            int iA = this.t.f6269a.a(obj);
            if (iA == -1) {
                return false;
            }
            dVar.b = iA;
        }
        return true;
    }

    private boolean a(com.opos.exoplayer.core.e.e.b bVar, long j, ac acVar) {
        if (!bVar.equals(acVar.h.f6267a) || !acVar.f) {
            return false;
        }
        this.t.f6269a.a(acVar.h.f6267a.f6391a, this.k);
        int iB = this.k.b(j);
        return iB == -1 || this.k.a(iB) == acVar.h.c;
    }

    private static Format[] a(com.opos.exoplayer.core.g.f fVar) {
        int iE = fVar != null ? fVar.e() : 0;
        Format[] formatArr = new Format[iE];
        for (int i = 0; i < iE; i++) {
            formatArr[i] = fVar.a(i);
        }
        return formatArr;
    }

    private Pair<Integer, Long> b(z zVar, int i, long j) {
        return zVar.a(this.j, this.k, i, j);
    }

    private void b(int i) {
        af afVar = this.t;
        if (afVar.f != i) {
            this.t = afVar.b(i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0071 A[LOOP:1: B:29:0x0072->B:28:0x0071, LOOP_END] */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0072, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0090 -> B:27:0x0066). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(long j, long j2) {
        ab abVar;
        d dVar;
        d dVar2;
        if (this.p.isEmpty() || this.t.c.a()) {
            return;
        }
        if (this.t.d == j) {
            j--;
        }
        int i = this.t.c.f6391a;
        int i2 = this.F;
        if (i2 > 0) {
            dVar = this.p.get(i2 - 1);
            abVar = this;
        } else {
            abVar = this;
            dVar = null;
        }
        while (dVar != null) {
            int i3 = dVar.b;
            if (i3 <= i && (i3 != i || dVar.c <= j)) {
                break;
            }
            int i4 = abVar.F;
            int i5 = i4 - 1;
            abVar.F = i5;
            if (i5 > 0) {
                dVar = abVar.p.get(i4 - 2);
            } else {
                abVar = abVar;
                dVar = null;
            }
        }
        if (abVar.F < abVar.p.size()) {
            dVar2 = abVar.p.get(abVar.F);
        } else {
            dVar2 = null;
        }
        while (true) {
            if (dVar2 == null && dVar2.d != null) {
                int i6 = dVar2.b;
                if (i6 < i || (i6 == i && dVar2.c <= j)) {
                    int i7 = abVar.F + 1;
                    abVar.F = i7;
                    if (i7 < abVar.p.size()) {
                        dVar2 = abVar.p.get(abVar.F);
                    } else {
                        dVar2 = null;
                    }
                    if (dVar2 == null) {
                    }
                }
            }
            while (dVar2 != null && dVar2.d != null && dVar2.b == i) {
                long j3 = dVar2.c;
                if (j3 <= j || j3 > j2) {
                    return;
                }
                abVar.c(dVar2.f6263a);
                if (dVar2.f6263a.h()) {
                    abVar.p.remove(abVar.F);
                } else {
                    abVar.F++;
                }
                dVar2 = abVar.F < abVar.p.size() ? abVar.p.get(abVar.F) : null;
            }
            return;
        }
    }

    private void b(com.opos.exoplayer.core.e.e eVar, boolean z, boolean z2) {
        this.C++;
        a(true, z, z2);
        this.e.a();
        this.u = eVar;
        b(2);
        eVar.a(this.i, true, this);
        this.f.a(2);
    }

    private void b(p pVar) {
        this.n.a(pVar);
    }

    private void b(r rVar) {
        if (rVar.f() == -9223372036854775807L) {
            c(rVar);
            return;
        }
        if (this.u == null || this.C > 0) {
            this.p.add(new d(rVar));
            return;
        }
        d dVar = new d(rVar);
        if (!a(dVar)) {
            rVar.a(false);
        } else {
            this.p.add(dVar);
            Collections.sort(this.p);
        }
    }

    private void b(t tVar) {
        this.n.b(tVar);
        a(tVar);
        tVar.l();
    }

    private void b(boolean z) {
        af afVar = this.t;
        if (afVar.g != z) {
            this.t = afVar.a(z);
        }
    }

    private void c() {
        if (this.o.a(this.t)) {
            this.h.obtainMessage(0, this.o.b, this.o.c ? this.o.d : -1, this.t).sendToTarget();
            this.o.b(this.t);
        }
    }

    private void c(int i) throws h {
        this.A = i;
        if (this.r.a(i)) {
            return;
        }
        e(true);
    }

    private void c(com.opos.exoplayer.core.e.d dVar) throws h {
        if (this.r.a(dVar)) {
            a(this.r.a(this.n.e().b));
            if (!this.r.f()) {
                a(this.r.h().h.b);
                a((ac) null);
            }
            q();
        }
    }

    private void c(r rVar) {
        if (rVar.e().getLooper() != this.f.a()) {
            this.f.a(15, rVar).sendToTarget();
            return;
        }
        e(rVar);
        int i = this.t.f;
        if (i == 3 || i == 2) {
            this.f.a(2);
        }
    }

    private void c(boolean z) {
        this.z = false;
        this.y = z;
        if (!z) {
            e();
            f();
            return;
        }
        int i = this.t.f;
        if (i == 3) {
            d();
        } else if (i != 2) {
            return;
        }
        this.f.a(2);
    }

    private boolean c(t tVar) {
        ac acVar = this.r.d().i;
        return acVar != null && acVar.f && tVar.g();
    }

    private void d() {
        this.z = false;
        this.n.a();
        for (t tVar : this.v) {
            tVar.b_();
        }
    }

    private void d(com.opos.exoplayer.core.e.d dVar) {
        if (this.r.a(dVar)) {
            this.r.a(this.E);
            q();
        }
    }

    private void d(r rVar) {
        rVar.e().post(new b(rVar));
    }

    private void d(boolean z) throws h {
        this.B = z;
        if (this.r.a(z)) {
            return;
        }
        e(true);
    }

    private void e() {
        this.n.b();
        for (t tVar : this.v) {
            a(tVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(r rVar) {
        try {
            rVar.b().a(rVar.c(), rVar.d());
        } finally {
            rVar.a(true);
        }
    }

    private void e(boolean z) throws h {
        com.opos.exoplayer.core.e.e.b bVar = this.r.c().h.f6267a;
        long jA = a(bVar, this.t.i, true);
        if (jA != this.t.i) {
            af afVar = this.t;
            this.t = afVar.a(bVar, jA, afVar.e);
            if (z) {
                this.o.b(4);
            }
        }
    }

    private void f() {
        if (this.r.f()) {
            ac acVarC = this.r.c();
            long jC = acVarC.f6266a.c();
            if (jC != -9223372036854775807L) {
                a(jC);
                if (jC != this.t.i) {
                    af afVar = this.t;
                    this.t = afVar.a(afVar.c, jC, afVar.e);
                    this.o.b(4);
                }
            } else {
                long jC2 = this.n.c();
                this.E = jC2;
                long jB = acVarC.b(jC2);
                b(this.t.i, jB);
                this.t.i = jB;
            }
            this.t.j = this.v.length == 0 ? acVarC.h.e : acVarC.a(true);
        }
    }

    private boolean f(boolean z) {
        if (this.v.length == 0) {
            return l();
        }
        if (!z) {
            return false;
        }
        if (!this.t.g) {
            return true;
        }
        ac acVarB = this.r.b();
        long jA = acVarB.a(!acVarB.h.g);
        return jA == Long.MIN_VALUE || this.e.a(jA - acVarB.b(this.E), this.n.e().b, this.z);
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ef A[LOOP:1: B:61:0x00ed->B:62:0x00ef, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:72:0x0110 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:74:0x0118  */
    /* JADX WARN: Instruction removed from duplicated block: B:60:0x00e9, please report this as an issue */
    private void g() throws h {
        int i;
        int i2;
        long jB = this.q.b();
        o();
        if (!this.r.f()) {
            m();
            a(jB, 10L);
            return;
        }
        ac acVarC = this.r.c();
        com.opos.exoplayer.core.i.x.a("doSomeWork");
        f();
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        acVarC.f6266a.a(this.t.i - this.l, this.m);
        boolean z = true;
        boolean z2 = true;
        for (t tVar : this.v) {
            tVar.a(this.E, jElapsedRealtime);
            z2 = z2 && tVar.u();
            boolean z3 = tVar.t() || tVar.u() || c(tVar);
            if (!z3) {
                tVar.j();
            }
            z = z && z3;
        }
        if (!z) {
            m();
        }
        long j = acVarC.h.e;
        if (!z2 || ((j != -9223372036854775807L && j > this.t.i) || !acVarC.h.g)) {
            if (this.t.f == 2 && f(z)) {
                b(3);
                if (this.y) {
                    d();
                }
            } else if (this.t.f == 3 && (this.v.length != 0 ? !z : !l())) {
                this.z = this.y;
                b(2);
            }
            if (this.t.f == 2) {
                for (t tVar2 : this.v) {
                    tVar2.j();
                }
            }
            if ((!this.y && this.t.f == 3) || (i = this.t.f) == 2) {
                a(jB, 10L);
            } else if (this.v.length != 0 || i == 4) {
                this.f.b(2);
            } else {
                a(jB, 1000L);
            }
            com.opos.exoplayer.core.i.x.a();
        }
        b(4);
        e();
        if (this.t.f == 2) {
            while (i2 < r6) {
                tVar2.j();
            }
        }
        if (!this.y) {
            if (this.v.length != 0) {
                this.f.b(2);
            } else {
                this.f.b(2);
            }
        } else if (this.v.length != 0) {
            this.f.b(2);
        } else {
            this.f.b(2);
        }
        com.opos.exoplayer.core.i.x.a();
    }

    private void h() {
        a(true, true, true);
        this.e.c();
        b(1);
        this.g.quit();
        synchronized (this) {
            this.w = true;
            notifyAll();
        }
    }

    private int i() {
        z zVar = this.t.f6269a;
        if (zVar.a()) {
            return 0;
        }
        return zVar.a(zVar.b(this.B), this.j).f;
    }

    private void j() {
        for (int size = this.p.size() - 1; size >= 0; size--) {
            if (!a(this.p.get(size))) {
                this.p.get(size).f6263a.a(false);
                this.p.remove(size);
            }
        }
        Collections.sort(this.p);
    }

    private void k() throws h {
        if (this.r.f()) {
            float f2 = this.n.e().b;
            ac acVarD = this.r.d();
            boolean z = true;
            for (ac acVarC = this.r.c(); acVarC != null && acVarC.f; acVarC = acVarC.i) {
                if (acVarC.b(f2)) {
                    if (z) {
                        ac acVarC2 = this.r.c();
                        boolean zA = this.r.a(acVarC2);
                        boolean[] zArr = new boolean[this.f6259a.length];
                        long jA = acVarC2.a(this.t.i, zA, zArr);
                        a(acVarC2.j);
                        af afVar = this.t;
                        if (afVar.f != 4 && jA != afVar.i) {
                            af afVar2 = this.t;
                            this.t = afVar2.a(afVar2.c, jA, afVar2.e);
                            this.o.b(4);
                            a(jA);
                        }
                        boolean[] zArr2 = new boolean[this.f6259a.length];
                        int i = 0;
                        int i2 = 0;
                        while (true) {
                            t[] tVarArr = this.f6259a;
                            if (i >= tVarArr.length) {
                                break;
                            }
                            t tVar = tVarArr[i];
                            zArr2[i] = tVar.a_() != 0;
                            com.opos.exoplayer.core.e.i iVar = acVarC2.c[i];
                            if (iVar != null) {
                                i2++;
                            }
                            if (zArr2[i]) {
                                if (iVar != tVar.f()) {
                                    b(tVar);
                                } else if (zArr[i]) {
                                    tVar.a(this.E);
                                }
                            }
                            i++;
                        }
                        this.t = this.t.a(acVarC2.j);
                        a(zArr2, i2);
                    } else {
                        this.r.a(acVarC);
                        if (acVarC.f) {
                            acVarC.a(Math.max(acVarC.h.b, acVarC.b(this.E)), false);
                            a(acVarC.j);
                        }
                    }
                    if (this.t.f != 4) {
                        q();
                        f();
                        this.f.a(2);
                        return;
                    }
                    return;
                }
                if (acVarC == acVarD) {
                    z = false;
                }
            }
        }
    }

    private boolean l() {
        ac acVar;
        ac acVarC = this.r.c();
        long j = acVarC.h.e;
        return j == -9223372036854775807L || this.t.i < j || ((acVar = acVarC.i) != null && (acVar.f || acVar.h.f6267a.a()));
    }

    private void m() {
        ac acVarB = this.r.b();
        ac acVarD = this.r.d();
        if (acVarB == null || acVarB.f) {
            return;
        }
        if (acVarD == null || acVarD.i == acVarB) {
            for (t tVar : this.v) {
                if (!tVar.g()) {
                    return;
                }
            }
            acVarB.f6266a.c_();
        }
    }

    private void n() {
        b(4);
        a(false, true, false);
    }

    /* JADX WARN: Code duplicated, block: B:74:0x0102  */
    private void o() throws h {
        com.opos.exoplayer.core.e.e eVar = this.u;
        if (eVar == null) {
            return;
        }
        if (this.C > 0) {
            eVar.a();
            return;
        }
        p();
        ac acVarB = this.r.b();
        int i = 0;
        if (acVarB == null || acVarB.b()) {
            b(false);
        } else if (!this.t.g) {
            q();
        }
        if (!this.r.f()) {
            return;
        }
        ac acVarC = this.r.c();
        ac acVarD = this.r.d();
        boolean z = false;
        while (this.y && acVarC != acVarD && this.E >= acVarC.i.e) {
            if (z) {
                c();
            }
            int i2 = acVarC.h.f ? 0 : 3;
            ac acVarH = this.r.h();
            a(acVarC);
            af afVar = this.t;
            ad adVar = acVarH.h;
            this.t = afVar.a(adVar.f6267a, adVar.b, adVar.d);
            this.o.b(i2);
            f();
            acVarC = acVarH;
            z = true;
        }
        if (acVarD.h.g) {
            while (true) {
                t[] tVarArr = this.f6259a;
                if (i >= tVarArr.length) {
                    return;
                }
                t tVar = tVarArr[i];
                com.opos.exoplayer.core.e.i iVar = acVarD.c[i];
                if (iVar != null && tVar.f() == iVar && tVar.g()) {
                    tVar.h();
                }
                i++;
            }
        } else {
            ac acVar = acVarD.i;
            if (acVar == null || !acVar.f) {
                return;
            }
            int i3 = 0;
            while (true) {
                t[] tVarArr2 = this.f6259a;
                if (i3 < tVarArr2.length) {
                    t tVar2 = tVarArr2[i3];
                    com.opos.exoplayer.core.e.i iVar2 = acVarD.c[i3];
                    if (tVar2.f() != iVar2) {
                        return;
                    }
                    if (iVar2 != null && !tVar2.g()) {
                        return;
                    } else {
                        i3++;
                    }
                } else {
                    com.opos.exoplayer.core.g.i iVar3 = acVarD.j;
                    ac acVarG = this.r.g();
                    com.opos.exoplayer.core.g.i iVar4 = acVarG.j;
                    boolean z2 = acVarG.f6266a.c() != -9223372036854775807L;
                    int i4 = 0;
                    while (true) {
                        t[] tVarArr3 = this.f6259a;
                        if (i4 >= tVarArr3.length) {
                            return;
                        }
                        t tVar3 = tVarArr3[i4];
                        if (iVar3.b[i4]) {
                            if (z2) {
                                tVar3.h();
                            } else if (!tVar3.i()) {
                                com.opos.exoplayer.core.g.f fVarA = iVar4.c.a(i4);
                                boolean z3 = iVar4.b[i4];
                                boolean z4 = this.b[i4].a() == 5;
                                v vVar = iVar3.e[i4];
                                v vVar2 = iVar4.e[i4];
                                if (z3 && vVar2.equals(vVar) && !z4) {
                                    tVar3.a(a(fVarA), acVarG.c[i4], acVarG.a());
                                } else {
                                    tVar3.h();
                                }
                            }
                        }
                        i4++;
                    }
                }
            }
        }
    }

    private void p() {
        this.r.a(this.E);
        if (this.r.a()) {
            ad adVarA = this.r.a(this.E, this.t);
            if (adVarA == null) {
                this.u.a();
                return;
            }
            this.r.a(this.b, 60000000L, this.c, this.e.d(), this.u, this.t.f6269a.a(adVarA.f6267a.f6391a, this.k, true).b, adVarA).a(this, adVarA.b);
            b(true);
        }
    }

    private void q() {
        ac acVarB = this.r.b();
        long jC = acVarB.c();
        if (jC == Long.MIN_VALUE) {
            b(false);
            return;
        }
        boolean zA = this.e.a(jC - acVarB.b(this.E), this.n.e().b);
        b(zA);
        if (zA) {
            acVarB.d(this.E);
        }
    }

    public synchronized void a() {
        this.x = true;
        if (this.w) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f.a(7);
        a(new a(), this.G);
        com.opos.cmn.an.f.a.a("ExoPlayerImplInternal", "release success:" + this.w + " costTime:" + (System.currentTimeMillis() - jCurrentTimeMillis) + " releaseTimeoutMs:" + this.G);
    }

    public void a(int i) {
        this.f.a(12, i, 0).sendToTarget();
    }

    @Override // com.opos.exoplayer.core.e.d.a
    public void a(com.opos.exoplayer.core.e.d dVar) {
        this.f.a(9, dVar).sendToTarget();
    }

    @Override // com.opos.exoplayer.core.e.e.a
    public void a(com.opos.exoplayer.core.e.e eVar, z zVar, Object obj) {
        this.f.a(8, new c(eVar, zVar, obj)).sendToTarget();
    }

    public void a(com.opos.exoplayer.core.e.e eVar, boolean z, boolean z2) {
        this.f.a(0, z ? 1 : 0, z2 ? 1 : 0, eVar).sendToTarget();
    }

    @Override // com.opos.exoplayer.core.f.a
    public void a(p pVar) {
        this.h.obtainMessage(1, pVar).sendToTarget();
        a(pVar.b);
    }

    @Override // com.opos.exoplayer.core.r.a
    public synchronized void a(r rVar) {
        if (!this.x && !this.w) {
            this.f.a(14, rVar).sendToTarget();
            return;
        }
        com.opos.cmn.an.f.a.c("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        rVar.a(false);
    }

    public void a(z zVar, int i, long j) {
        this.f.a(3, new f(zVar, i, j)).sendToTarget();
    }

    public void a(boolean z) {
        this.f.a(1, z ? 1 : 0, 0).sendToTarget();
    }

    public Looper b() {
        return this.g.getLooper();
    }

    @Override // com.opos.exoplayer.core.e.j.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(com.opos.exoplayer.core.e.d dVar) {
        this.f.a(10, dVar).sendToTarget();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        String strA;
        h e2;
        try {
            switch (message.what) {
                case 0:
                    b((com.opos.exoplayer.core.e.e) message.obj, message.arg1 != 0, message.arg2 != 0);
                    break;
                case 1:
                    c(message.arg1 != 0);
                    break;
                case 2:
                    g();
                    break;
                case 3:
                    a((f) message.obj);
                    break;
                case 4:
                    b((p) message.obj);
                    break;
                case 5:
                    a((x) message.obj);
                    break;
                case 6:
                    a(message.arg1 != 0, true);
                    break;
                case 7:
                    h();
                    return true;
                case 8:
                    a((c) message.obj);
                    break;
                case 9:
                    c((com.opos.exoplayer.core.e.d) message.obj);
                    break;
                case 10:
                    d((com.opos.exoplayer.core.e.d) message.obj);
                    break;
                case 11:
                    k();
                    break;
                case 12:
                    c(message.arg1);
                    break;
                case 13:
                    d(message.arg1 != 0);
                    break;
                case 14:
                    b((r) message.obj);
                    break;
                case 15:
                    d((r) message.obj);
                    break;
                default:
                    return false;
            }
            c();
        } catch (h e3) {
            e2 = e3;
            com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Playback error.", e2);
            a(false, false);
            this.h.obtainMessage(2, e2).sendToTarget();
            c();
        } catch (IOException e4) {
            com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Source error.", e4);
            a(false, false);
            strA = com.opos.exoplayer.core.i.y.a(e4);
            com.opos.cmn.an.f.a.a("ExoPlayerImplInternal", "Exception class name = " + strA);
            e2 = h.a(e4);
            e2.a(strA);
            this.h.obtainMessage(2, e2).sendToTarget();
            c();
        } catch (RuntimeException e5) {
            com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Internal runtime error.", e5);
            a(false, false);
            strA = com.opos.exoplayer.core.i.y.a(e5);
            com.opos.cmn.an.f.a.a("ExoPlayerImplInternal", "Exception class name = " + strA);
            e2 = h.a(e5);
            e2.a(strA);
            this.h.obtainMessage(2, e2).sendToTarget();
            c();
        }
        return true;
    }
}
