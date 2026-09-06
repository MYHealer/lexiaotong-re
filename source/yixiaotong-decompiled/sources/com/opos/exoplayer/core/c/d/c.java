package com.opos.exoplayer.core.c.d;

import android.support.v4.media.session.PlaybackStateCompat;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.i.y;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.o;
import java.util.ArrayList;
import java.util.Stack;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class c implements com.opos.exoplayer.core.c.e, com.opos.exoplayer.core.c.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.opos.exoplayer.core.c.h f6300a = new a();
    private static final int b = y.f("qt  ");
    private final int c;
    private final p d;
    private final p e;
    private final p f;
    private final Stack<g.a> g;
    private int h;
    private int i;
    private long j;
    private int k;
    private p l;
    private int m;
    private int n;
    private int o;
    private com.opos.exoplayer.core.c.g p;
    private b[] q;
    private long[][] r;
    private int s;
    private long t;
    private boolean u;

    static class a implements com.opos.exoplayer.core.c.h {
        a() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new c()};
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f6301a;
        public final m b;
        public final n c;
        public int d;

        public b(e eVar, m mVar, n nVar) {
            this.f6301a = eVar;
            this.b = mVar;
            this.c = nVar;
        }
    }

    public c() {
        this(0);
    }

    public c(int i) {
        this.c = i;
        this.f = new p(16);
        this.g = new Stack<>();
        this.d = new p(com.opos.exoplayer.core.i.n.f6506a);
        this.e = new p(4);
        this.m = -1;
    }

    private static int a(m mVar, long j) {
        int iA = mVar.a(j);
        return iA == -1 ? mVar.b(j) : iA;
    }

    private static long a(m mVar, long j, long j2) {
        int iA = a(mVar, j);
        return iA == -1 ? j2 : Math.min(mVar.b[iA], j2);
    }

    private void a(long j) {
        while (!this.g.isEmpty() && this.g.peek().aP == j) {
            g.a aVarPop = this.g.pop();
            if (aVarPop.aO == g.B) {
                a(aVarPop);
                this.g.clear();
                this.h = 2;
            } else if (!this.g.isEmpty()) {
                this.g.peek().a(aVarPop);
            }
        }
        if (this.h != 2) {
            d();
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x007f  */
    private void a(g.a aVar) {
        Metadata metadataA;
        ArrayList arrayList = new ArrayList();
        com.opos.exoplayer.core.c.i iVar = new com.opos.exoplayer.core.c.i();
        g.b bVarD = aVar.d(g.az);
        if (bVarD != null) {
            metadataA = h.a(bVarD, this.u);
            if (metadataA != null) {
                iVar.a(metadataA);
            }
        } else {
            metadataA = null;
        }
        long jMax = -9223372036854775807L;
        int size = -1;
        for (int i = 0; i < aVar.aR.size(); i++) {
            g.a aVar2 = aVar.aR.get(i);
            if (aVar2.aO == g.D) {
                e eVarA = h.a(aVar2, aVar.d(g.C), -9223372036854775807L, (DrmInitData) null, (this.c & 1) != 0, this.u);
                if (eVarA != null) {
                    m mVarA = h.a(eVarA, aVar2.e(g.E).e(g.F).e(g.G), iVar);
                    if (mVarA.f6316a != 0) {
                        b bVar = new b(eVarA, mVarA, this.p.a(i, eVarA.b));
                        Format formatA = eVarA.f.a(mVarA.d + 30);
                        if (eVarA.b == 1) {
                            if (iVar.a()) {
                                formatA = formatA.a(iVar.b, iVar.c);
                            }
                            if (metadataA != null) {
                                formatA = formatA.a(metadataA);
                            }
                        }
                        bVar.c.a(formatA);
                        long j = eVarA.e;
                        if (j == -9223372036854775807L) {
                            j = mVarA.g;
                        }
                        jMax = Math.max(jMax, j);
                        if (eVarA.b == 2 && size == -1) {
                            size = arrayList.size();
                        }
                        arrayList.add(bVar);
                    }
                }
            }
        }
        this.s = size;
        this.t = jMax;
        b[] bVarArr = (b[]) arrayList.toArray(new b[arrayList.size()]);
        this.q = bVarArr;
        this.r = a(bVarArr);
        this.p.a();
        this.p.a(this);
    }

    private static boolean a(int i) {
        return i == g.R || i == g.C || i == g.S || i == g.T || i == g.al || i == g.am || i == g.an || i == g.Q || i == g.ao || i == g.ap || i == g.aq || i == g.ar || i == g.as || i == g.O || i == g.f6305a || i == g.az;
    }

    private static boolean a(p pVar) {
        pVar.c(8);
        if (pVar.o() == b) {
            return true;
        }
        pVar.d(4);
        while (pVar.b() > 0) {
            if (pVar.o() == b) {
                return true;
            }
        }
        return false;
    }

    private static long[][] a(b[] bVarArr) {
        long[][] jArr = new long[bVarArr.length][];
        int[] iArr = new int[bVarArr.length];
        long[] jArr2 = new long[bVarArr.length];
        boolean[] zArr = new boolean[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            jArr[i] = new long[bVarArr[i].b.f6316a];
            jArr2[i] = bVarArr[i].b.e[0];
        }
        long j = 0;
        int i2 = 0;
        while (i2 < bVarArr.length) {
            long j2 = Long.MAX_VALUE;
            int i3 = -1;
            for (int i4 = 0; i4 < bVarArr.length; i4++) {
                if (!zArr[i4]) {
                    long j3 = jArr2[i4];
                    if (j3 <= j2) {
                        i3 = i4;
                        j2 = j3;
                    }
                }
            }
            int i5 = iArr[i3];
            jArr[i3][i5] = j;
            j += (long) bVarArr[i3].b.c[i5];
            int i6 = i5 + 1;
            iArr[i3] = i6;
            if (i6 < jArr[i3].length) {
                jArr2[i3] = bVarArr[i3].b.e[i6];
            } else {
                zArr[i3] = true;
                i2++;
            }
        }
        return jArr;
    }

    private static boolean b(int i) {
        return i == g.B || i == g.D || i == g.E || i == g.F || i == g.G || i == g.P;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0080  */
    /* JADX WARN: Code duplicated, block: B:26:0x0088  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:29:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:30:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:34:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:35:0x00be  */
    /* JADX WARN: Code duplicated, block: B:38:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:39:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ed  */
    private boolean b(com.opos.exoplayer.core.c.f fVar) throws o {
        long jC;
        boolean z;
        boolean z2;
        long jC2;
        if (this.k == 0) {
            if (!fVar.a(this.f.f6510a, 0, 8, true)) {
                return false;
            }
            this.k = 8;
            this.f.c(0);
            this.j = this.f.m();
            this.i = this.f.o();
        }
        long j = this.j;
        if (j != 1) {
            if (j == 0) {
                long jD = fVar.d();
                if (jD == -1 && !this.g.isEmpty()) {
                    jD = this.g.peek().aP;
                }
                if (jD != -1) {
                    jC = (jD - fVar.c()) + ((long) this.k);
                }
            }
            if (this.j >= this.k) {
                throw new o("Atom size less than header length (unsupported).");
            }
            if (b(this.i)) {
                jC2 = (fVar.c() + this.j) - ((long) this.k);
                this.g.add(new g.a(this.i, jC2));
                if (this.j == this.k) {
                    a(jC2);
                } else {
                    d();
                }
            } else {
                if (a(this.i)) {
                    if (this.k == 8) {
                        z = true;
                    } else {
                        z = false;
                    }
                    com.opos.exoplayer.core.i.a.b(z);
                    if (this.j <= 2147483647L) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    com.opos.exoplayer.core.i.a.b(z2);
                    this.l = new p((int) this.j);
                    System.arraycopy(this.f.f6510a, 0, this.l.f6510a, 0, 8);
                } else {
                    this.l = null;
                }
                this.h = 1;
            }
            return true;
        }
        fVar.b(this.f.f6510a, 8, 8);
        this.k += 8;
        jC = this.f.w();
        this.j = jC;
        if (this.j >= this.k) {
            throw new o("Atom size less than header length (unsupported).");
        }
        if (b(this.i)) {
            jC2 = (fVar.c() + this.j) - ((long) this.k);
            this.g.add(new g.a(this.i, jC2));
            if (this.j == this.k) {
                a(jC2);
            } else {
                d();
            }
        } else {
            if (a(this.i)) {
                if (this.k == 8) {
                    z = true;
                } else {
                    z = false;
                }
                com.opos.exoplayer.core.i.a.b(z);
                if (this.j <= 2147483647L) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                com.opos.exoplayer.core.i.a.b(z2);
                this.l = new p((int) this.j);
                System.arraycopy(this.f.f6510a, 0, this.l.f6510a, 0, 8);
            } else {
                this.l = null;
            }
            this.h = 1;
        }
        return true;
    }

    private boolean b(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        boolean z;
        long j = this.j - ((long) this.k);
        long jC = fVar.c() + j;
        p pVar = this.l;
        if (pVar == null) {
            if (j < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                fVar.b((int) j);
            } else {
                kVar.f6369a = fVar.c() + j;
                z = true;
            }
            a(jC);
            return (z || this.h == 2) ? false : true;
        }
        fVar.b(pVar.f6510a, this.k, (int) j);
        if (this.i == g.f6305a) {
            this.u = a(this.l);
        } else if (!this.g.isEmpty()) {
            this.g.peek().a(new g.b(this.i, this.l));
        }
        z = false;
        a(jC);
        if (z) {
        }
    }

    private int c(long j) {
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        while (true) {
            b[] bVarArr = this.q;
            if (i3 >= bVarArr.length) {
                break;
            }
            b bVar = bVarArr[i3];
            int i4 = bVar.d;
            m mVar = bVar.b;
            if (i4 != mVar.f6316a) {
                long j5 = mVar.b[i4];
                long j6 = this.r[i3][i4];
                long j7 = j5 - j;
                boolean z3 = j7 < 0 || j7 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                if ((!z3 && z2) || (z3 == z2 && j7 < j4)) {
                    z2 = z3;
                    j4 = j7;
                    i = i3;
                    j3 = j6;
                }
                if (j6 < j2) {
                    z = z3;
                    i2 = i3;
                    j2 = j6;
                }
            }
            i3++;
        }
        return (j2 == Long.MAX_VALUE || !z || j3 < j2 + 10485760) ? i : i2;
    }

    private int c(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        long jC = fVar.c();
        if (this.m == -1) {
            int iC = c(jC);
            this.m = iC;
            if (iC == -1) {
                return -1;
            }
        }
        b bVar = this.q[this.m];
        n nVar = bVar.c;
        int i = bVar.d;
        m mVar = bVar.b;
        long j = mVar.b[i];
        int i2 = mVar.c[i];
        long j2 = (j - jC) + ((long) this.n);
        if (j2 < 0 || j2 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            kVar.f6369a = j;
            return 1;
        }
        if (bVar.f6301a.g == 1) {
            j2 += 8;
            i2 -= 8;
        }
        fVar.b((int) j2);
        int i3 = bVar.f6301a.j;
        if (i3 == 0) {
            while (true) {
                int i4 = this.n;
                if (i4 >= i2) {
                    break;
                }
                int iA = nVar.a(fVar, i2 - i4, false);
                this.n += iA;
                this.o -= iA;
            }
        } else {
            byte[] bArr = this.e.f6510a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i5 = 4 - i3;
            while (this.n < i2) {
                int i6 = this.o;
                if (i6 == 0) {
                    fVar.b(this.e.f6510a, i5, i3);
                    this.e.c(0);
                    this.o = this.e.u();
                    this.d.c(0);
                    nVar.a(this.d, 4);
                    this.n += 4;
                    i2 += i5;
                } else {
                    int iA2 = nVar.a(fVar, i6, false);
                    this.n += iA2;
                    this.o -= iA2;
                }
            }
        }
        m mVar2 = bVar.b;
        nVar.a(mVar2.e[i], mVar2.f[i], i2, 0, null);
        bVar.d++;
        this.m = -1;
        this.n = 0;
        this.o = 0;
        return 0;
    }

    private void d() {
        this.h = 0;
        this.k = 0;
    }

    private void d(long j) {
        for (b bVar : this.q) {
            m mVar = bVar.b;
            int iA = mVar.a(j);
            if (iA == -1) {
                iA = mVar.b(j);
            }
            bVar.d = iA;
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        while (true) {
            int i = this.h;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return c(fVar, kVar);
                    }
                    throw new IllegalStateException();
                }
                if (b(fVar, kVar)) {
                    return 1;
                }
            } else if (!b(fVar)) {
                return -1;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j, long j2) {
        this.g.clear();
        this.k = 0;
        this.m = -1;
        this.n = 0;
        this.o = 0;
        if (j == 0) {
            d();
        } else if (this.q != null) {
            d(j2);
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.p = gVar;
    }

    @Override // com.opos.exoplayer.core.c.l
    public boolean a() {
        return true;
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        return k.b(fVar);
    }

    @Override // com.opos.exoplayer.core.c.l
    public long b() {
        return this.t;
    }

    @Override // com.opos.exoplayer.core.c.l
    public com.opos.exoplayer.core.c.l.a b(long j) {
        long j2;
        long j3;
        int iB;
        b[] bVarArr = this.q;
        if (bVarArr.length == 0) {
            return new com.opos.exoplayer.core.c.l.a(com.opos.exoplayer.core.c.m.f6372a);
        }
        int i = this.s;
        long jA = -1;
        if (i != -1) {
            m mVar = bVarArr[i].b;
            int iA = a(mVar, j);
            if (iA == -1) {
                return new com.opos.exoplayer.core.c.l.a(com.opos.exoplayer.core.c.m.f6372a);
            }
            long j4 = mVar.e[iA];
            j2 = mVar.b[iA];
            if (j4 >= j || iA >= mVar.f6316a - 1 || (iB = mVar.b(j)) == -1 || iB == iA) {
                j3 = -9223372036854775807L;
            } else {
                j3 = mVar.e[iB];
                jA = mVar.b[iB];
            }
            j = j4;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            b[] bVarArr2 = this.q;
            if (i2 >= bVarArr2.length) {
                break;
            }
            if (i2 != this.s) {
                m mVar2 = bVarArr2[i2].b;
                long jA2 = a(mVar2, j, j2);
                if (j3 != -9223372036854775807L) {
                    jA = a(mVar2, j3, jA);
                }
                j2 = jA2;
            }
            i2++;
        }
        com.opos.exoplayer.core.c.m mVar3 = new com.opos.exoplayer.core.c.m(j, j2);
        return j3 == -9223372036854775807L ? new com.opos.exoplayer.core.c.l.a(mVar3) : new com.opos.exoplayer.core.c.l.a(mVar3, new com.opos.exoplayer.core.c.m(j3, jA));
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
