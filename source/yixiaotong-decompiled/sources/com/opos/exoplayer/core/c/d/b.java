package com.opos.exoplayer.core.c.d;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.base.Ascii;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.i.w;
import com.opos.exoplayer.core.i.y;
import com.opos.exoplayer.core.o;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class b implements com.opos.exoplayer.core.c.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.opos.exoplayer.core.c.h f6297a = new a();
    private static final int b = y.f("seig");
    private static final byte[] c = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final Format d = Format.a((String) null, MimeTypes.APPLICATION_EMSG, Long.MAX_VALUE);
    private int A;
    private long B;
    private long C;
    private c D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private com.opos.exoplayer.core.c.g I;
    private n[] J;
    private n[] K;
    private boolean L;
    private final int e;
    private final e f;
    private final List<Format> g;
    private final DrmInitData h;
    private final SparseArray<c> i;
    private final p j;
    private final p k;
    private final p l;
    private final p m;
    private final p n;
    private final w o;
    private final p p;
    private final byte[] q;
    private final Stack<g.a> r;
    private final ArrayDeque<C0910b> s;
    private final n t;
    private int u;
    private int v;
    private long w;
    private int x;
    private p y;
    private long z;

    static class a implements com.opos.exoplayer.core.c.h {
        a() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new b()};
        }
    }

    /* JADX INFO: renamed from: com.opos.exoplayer.core.c.d.b$b, reason: collision with other inner class name */
    private static final class C0910b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f6298a;
        public final int b;

        public C0910b(long j, int i) {
            this.f6298a = j;
            this.b = i;
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f6299a = new l();
        public final n b;
        public e c;
        public i d;
        public int e;
        public int f;
        public int g;

        public c(n nVar) {
            this.b = nVar;
        }

        public void a() {
            this.f6299a.a();
            this.e = 0;
            this.g = 0;
            this.f = 0;
        }

        public void a(e eVar, i iVar) {
            this.c = (e) com.opos.exoplayer.core.i.a.a(eVar);
            this.d = (i) com.opos.exoplayer.core.i.a.a(iVar);
            this.b.a(eVar.f);
            a();
        }

        public void a(DrmInitData drmInitData) {
            f fVarA = this.c.a(this.f6299a.f6315a.f6312a);
            this.b.a(this.c.f.a(drmInitData.a(fVarA != null ? fVarA.b : null)));
        }
    }

    public b() {
        this(0);
    }

    public b(int i) {
        this(i, null);
    }

    public b(int i, w wVar) {
        this(i, wVar, null, null);
    }

    public b(int i, w wVar, e eVar, DrmInitData drmInitData) {
        this(i, wVar, eVar, drmInitData, Collections.emptyList());
    }

    public b(int i, w wVar, e eVar, DrmInitData drmInitData, List<Format> list) {
        this(i, wVar, eVar, drmInitData, list, null);
    }

    public b(int i, w wVar, e eVar, DrmInitData drmInitData, List<Format> list, n nVar) {
        this.e = i | (eVar != null ? 8 : 0);
        this.o = wVar;
        this.f = eVar;
        this.h = drmInitData;
        this.g = Collections.unmodifiableList(list);
        this.t = nVar;
        this.p = new p(16);
        this.j = new p(com.opos.exoplayer.core.i.n.f6506a);
        this.k = new p(5);
        this.l = new p();
        this.m = new p(1);
        this.n = new p();
        this.q = new byte[16];
        this.r = new Stack<>();
        this.s = new ArrayDeque<>();
        this.i = new SparseArray<>();
        this.B = -9223372036854775807L;
        this.C = -9223372036854775807L;
        a();
    }

    private int a(c cVar) {
        p pVar;
        l lVar = cVar.f6299a;
        int i = lVar.f6315a.f6312a;
        f fVarA = lVar.o;
        if (fVarA == null) {
            fVarA = cVar.c.a(i);
        }
        int length = fVarA.d;
        if (length != 0) {
            pVar = lVar.q;
        } else {
            byte[] bArr = fVarA.e;
            this.n.a(bArr, bArr.length);
            pVar = this.n;
            length = bArr.length;
        }
        boolean z = lVar.n[cVar.e];
        this.m.f6510a[0] = (byte) ((z ? 128 : 0) | length);
        this.m.c(0);
        n nVar = cVar.b;
        nVar.a(this.m, 1);
        nVar.a(pVar, length);
        if (!z) {
            return length + 1;
        }
        p pVar2 = lVar.q;
        int iH = pVar2.h();
        pVar2.d(-2);
        int i2 = (iH * 6) + 2;
        nVar.a(pVar2, i2);
        return length + 1 + i2;
    }

    private static int a(c cVar, int i, long j, int i2, p pVar, int i3) {
        int iO;
        boolean z;
        pVar.c(8);
        int iB = g.b(pVar.o());
        e eVar = cVar.c;
        l lVar = cVar.f6299a;
        i iVar = lVar.f6315a;
        lVar.h[i] = pVar.u();
        long[] jArr = lVar.g;
        long j2 = lVar.c;
        jArr[i] = j2;
        if ((iB & 1) != 0) {
            jArr[i] = j2 + ((long) pVar.o());
        }
        boolean z2 = (iB & 4) != 0;
        int iU = iVar.d;
        if (z2) {
            iU = pVar.u();
        }
        boolean z3 = (iB & 256) != 0;
        boolean z4 = (iB & 512) != 0;
        boolean z5 = (iB & 1024) != 0;
        boolean z6 = (iB & 2048) != 0;
        long[] jArr2 = eVar.h;
        long jD = 0;
        if (jArr2 != null && jArr2.length == 1 && jArr2[0] == 0) {
            jD = y.d(eVar.i[0], 1000L, eVar.c);
        }
        int[] iArr = lVar.i;
        int[] iArr2 = lVar.j;
        long[] jArr3 = lVar.k;
        boolean[] zArr = lVar.l;
        int i4 = iU;
        boolean z7 = eVar.b == 2 && (i2 & 1) != 0;
        int i5 = i3 + lVar.h[i];
        long j3 = eVar.c;
        long j4 = jD;
        long j5 = i > 0 ? lVar.s : j;
        int i6 = i3;
        while (i6 < i5) {
            int iU2 = z3 ? pVar.u() : iVar.b;
            int iU3 = z4 ? pVar.u() : iVar.c;
            if (i6 == 0 && z2) {
                iO = i4;
            } else {
                iO = z5 ? pVar.o() : iVar.d;
            }
            boolean z8 = z6;
            if (z6) {
                iArr2[i6] = (int) ((((long) pVar.o()) * 1000) / j3);
                z = false;
            } else {
                z = false;
                iArr2[i6] = 0;
            }
            jArr3[i6] = y.d(j5, 1000L, j3) - j4;
            iArr[i6] = iU3;
            zArr[i6] = (((iO >> 16) & 1) != 0 || (z7 && i6 != 0)) ? z : true;
            j5 += (long) iU2;
            i6++;
            z3 = z3;
            z4 = z4;
            z2 = z2;
            z6 = z8;
            i5 = i5;
        }
        int i7 = i5;
        lVar.s = j5;
        return i7;
    }

    private static Pair<Long, com.opos.exoplayer.core.c.a> a(p pVar, long j) throws o {
        long jW;
        long jW2;
        pVar.c(8);
        int iA = g.a(pVar.o());
        pVar.d(4);
        long jM = pVar.m();
        if (iA == 0) {
            jW = pVar.m();
            jW2 = pVar.m();
        } else {
            jW = pVar.w();
            jW2 = pVar.w();
        }
        long j2 = jW;
        long j3 = j + jW2;
        long jD = y.d(j2, 1000000L, jM);
        pVar.d(2);
        int iH = pVar.h();
        int[] iArr = new int[iH];
        long[] jArr = new long[iH];
        long[] jArr2 = new long[iH];
        long[] jArr3 = new long[iH];
        long j4 = jD;
        int i = 0;
        long j5 = j2;
        while (i < iH) {
            int iO = pVar.o();
            if ((iO & Integer.MIN_VALUE) != 0) {
                throw new o("Unhandled indirect reference");
            }
            long jM2 = pVar.m();
            iArr[i] = iO & Integer.MAX_VALUE;
            jArr[i] = j3;
            jArr3[i] = j4;
            long j6 = j5 + jM2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i2 = iH;
            int[] iArr2 = iArr;
            long jD2 = y.d(j6, 1000000L, jM);
            jArr4[i] = jD2 - jArr5[i];
            pVar.d(4);
            j3 += (long) iArr2[i];
            i++;
            iArr = iArr2;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            iH = i2;
            j5 = j6;
            j4 = jD2;
        }
        return Pair.create(Long.valueOf(jD), new com.opos.exoplayer.core.c.a(iArr, jArr, jArr2, jArr3));
    }

    private static c a(SparseArray<c> sparseArray) {
        int size = sparseArray.size();
        c cVar = null;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            c cVarValueAt = sparseArray.valueAt(i);
            int i2 = cVarValueAt.g;
            l lVar = cVarValueAt.f6299a;
            if (i2 != lVar.e) {
                long j2 = lVar.g[i2];
                if (j2 < j) {
                    cVar = cVarValueAt;
                    j = j2;
                }
            }
        }
        return cVar;
    }

    private static c a(p pVar, SparseArray<c> sparseArray, int i) {
        pVar.c(8);
        int iB = g.b(pVar.o());
        int iO = pVar.o();
        if ((i & 8) != 0) {
            iO = 0;
        }
        c cVar = sparseArray.get(iO);
        if (cVar == null) {
            return null;
        }
        if ((iB & 1) != 0) {
            long jW = pVar.w();
            l lVar = cVar.f6299a;
            lVar.c = jW;
            lVar.d = jW;
        }
        i iVar = cVar.d;
        cVar.f6299a.f6315a = new i((iB & 2) != 0 ? pVar.u() - 1 : iVar.f6312a, (iB & 8) != 0 ? pVar.u() : iVar.b, (iB & 16) != 0 ? pVar.u() : iVar.c, (iB & 32) != 0 ? pVar.u() : iVar.d);
        return cVar;
    }

    private static DrmInitData a(List<g.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            g.b bVar = list.get(i);
            if (bVar.aO == g.U) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.aP.f6510a;
                UUID uuidA = d.a(bArr);
                if (uuidA == null) {
                    com.opos.cmn.an.f.a.c("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuidA, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private void a() {
        this.u = 0;
        this.x = 0;
    }

    private void a(long j) throws o {
        while (!this.r.isEmpty() && this.r.peek().aP == j) {
            a(this.r.pop());
        }
        a();
    }

    private static void a(f fVar, p pVar, l lVar) throws o {
        int i;
        int i2 = fVar.d;
        pVar.c(8);
        if ((g.b(pVar.o()) & 1) == 1) {
            pVar.d(8);
        }
        int iG = pVar.g();
        int iU = pVar.u();
        if (iU != lVar.f) {
            throw new o("Length mismatch: " + iU + ", " + lVar.f);
        }
        if (iG == 0) {
            boolean[] zArr = lVar.n;
            i = 0;
            for (int i3 = 0; i3 < iU; i3++) {
                int iG2 = pVar.g();
                i += iG2;
                zArr[i3] = iG2 > i2;
            }
        } else {
            i = iG * iU;
            Arrays.fill(lVar.n, 0, iU, iG > i2);
        }
        lVar.a(i);
    }

    private void a(g.a aVar) throws o {
        int i = aVar.aO;
        if (i == g.B) {
            b(aVar);
        } else if (i == g.K) {
            c(aVar);
        } else {
            if (this.r.isEmpty()) {
                return;
            }
            this.r.peek().a(aVar);
        }
    }

    private static void a(g.a aVar, SparseArray<c> sparseArray, int i, byte[] bArr) throws o {
        int size = aVar.aR.size();
        for (int i2 = 0; i2 < size; i2++) {
            g.a aVar2 = aVar.aR.get(i2);
            if (aVar2.aO == g.L) {
                b(aVar2, sparseArray, i, bArr);
            }
        }
    }

    private static void a(g.a aVar, c cVar, long j, int i) {
        List<g.b> list = aVar.aQ;
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            g.b bVar = list.get(i4);
            if (bVar.aO == g.z) {
                p pVar = bVar.aP;
                pVar.c(12);
                int iU = pVar.u();
                if (iU > 0) {
                    i3 += iU;
                    i2++;
                }
            }
        }
        cVar.g = 0;
        cVar.f = 0;
        cVar.e = 0;
        cVar.f6299a.a(i2, i3);
        int i5 = 0;
        int iA = 0;
        for (int i6 = 0; i6 < size; i6++) {
            g.b bVar2 = list.get(i6);
            if (bVar2.aO == g.z) {
                iA = a(cVar, i5, j, i, bVar2.aP, iA);
                i5++;
            }
        }
    }

    private void a(g.b bVar, long j) throws o {
        if (!this.r.isEmpty()) {
            this.r.peek().a(bVar);
            return;
        }
        int i = bVar.aO;
        if (i != g.A) {
            if (i == g.aF) {
                a(bVar.aP);
            }
        } else {
            Pair<Long, com.opos.exoplayer.core.c.a> pairA = a(bVar.aP, j);
            this.C = ((Long) pairA.first).longValue();
            this.I.a((com.opos.exoplayer.core.c.l) pairA.second);
            this.L = true;
        }
    }

    private void a(p pVar) {
        n[] nVarArr = this.J;
        if (nVarArr == null || nVarArr.length == 0) {
            return;
        }
        pVar.c(12);
        int iB = pVar.b();
        pVar.y();
        pVar.y();
        long jD = y.d(pVar.m(), 1000000L, pVar.m());
        for (n nVar : this.J) {
            pVar.c(12);
            nVar.a(pVar, iB);
        }
        if (this.C == -9223372036854775807L) {
            this.s.addLast(new C0910b(jD, iB));
            this.A += iB;
            return;
        }
        for (n nVar2 : this.J) {
            nVar2.a(this.C + jD, 1, iB, 0, null);
        }
    }

    private static void a(p pVar, int i, l lVar) throws o {
        pVar.c(i + 8);
        int iB = g.b(pVar.o());
        if ((iB & 1) != 0) {
            throw new o("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (iB & 2) != 0;
        int iU = pVar.u();
        if (iU != lVar.f) {
            throw new o("Length mismatch: " + iU + ", " + lVar.f);
        }
        Arrays.fill(lVar.n, 0, iU, z);
        lVar.a(pVar.b());
        lVar.a(pVar);
    }

    private static void a(p pVar, l lVar) throws o {
        pVar.c(8);
        int iO = pVar.o();
        if ((g.b(iO) & 1) == 1) {
            pVar.d(8);
        }
        int iU = pVar.u();
        if (iU != 1) {
            throw new o("Unexpected saio entry count: " + iU);
        }
        lVar.d += g.a(iO) == 0 ? pVar.m() : pVar.w();
    }

    private static void a(p pVar, l lVar, byte[] bArr) throws o {
        pVar.c(8);
        pVar.a(bArr, 0, 16);
        if (Arrays.equals(bArr, c)) {
            a(pVar, 16, lVar);
        }
    }

    private static void a(p pVar, p pVar2, String str, l lVar) throws o {
        byte[] bArr;
        pVar.c(8);
        int iO = pVar.o();
        int iO2 = pVar.o();
        int i = b;
        if (iO2 != i) {
            return;
        }
        if (g.a(iO) == 1) {
            pVar.d(4);
        }
        if (pVar.o() != 1) {
            throw new o("Entry count in sbgp != 1 (unsupported).");
        }
        pVar2.c(8);
        int iO3 = pVar2.o();
        if (pVar2.o() != i) {
            return;
        }
        int iA = g.a(iO3);
        if (iA == 1) {
            if (pVar2.m() == 0) {
                throw new o("Variable length description in sgpd found (unsupported)");
            }
        } else if (iA >= 2) {
            pVar2.d(4);
        }
        if (pVar2.m() != 1) {
            throw new o("Entry count in sgpd != 1 (unsupported).");
        }
        pVar2.d(1);
        int iG = pVar2.g();
        int i2 = (iG & 240) >> 4;
        int i3 = iG & 15;
        boolean z = pVar2.g() == 1;
        if (z) {
            int iG2 = pVar2.g();
            byte[] bArr2 = new byte[16];
            pVar2.a(bArr2, 0, 16);
            if (z && iG2 == 0) {
                int iG3 = pVar2.g();
                byte[] bArr3 = new byte[iG3];
                pVar2.a(bArr3, 0, iG3);
                bArr = bArr3;
            } else {
                bArr = null;
            }
            lVar.m = true;
            lVar.o = new f(z, str, iG2, bArr2, i2, i3, bArr);
        }
    }

    private static boolean a(int i) {
        return i == g.S || i == g.R || i == g.C || i == g.A || i == g.T || i == g.w || i == g.x || i == g.O || i == g.y || i == g.z || i == g.U || i == g.ac || i == g.ad || i == g.ah || i == g.ag || i == g.ae || i == g.af || i == g.Q || i == g.N || i == g.aF;
    }

    private static Pair<Integer, i> b(p pVar) {
        pVar.c(12);
        return Pair.create(Integer.valueOf(pVar.o()), new i(pVar.u() - 1, pVar.u(), pVar.u(), pVar.o()));
    }

    private void b() {
        int i;
        if (this.J == null) {
            n[] nVarArr = new n[2];
            this.J = nVarArr;
            n nVar = this.t;
            if (nVar != null) {
                nVarArr[0] = nVar;
                i = 1;
            } else {
                i = 0;
            }
            if ((this.e & 4) != 0) {
                nVarArr[i] = this.I.a(this.i.size(), 4);
                i++;
            }
            n[] nVarArr2 = (n[]) Arrays.copyOf(this.J, i);
            this.J = nVarArr2;
            for (n nVar2 : nVarArr2) {
                nVar2.a(d);
            }
        }
        if (this.K == null) {
            this.K = new n[this.g.size()];
            for (int i2 = 0; i2 < this.K.length; i2++) {
                n nVarA = this.I.a(this.i.size() + 1 + i2, 3);
                nVarA.a(this.g.get(i2));
                this.K[i2] = nVarA;
            }
        }
    }

    private void b(long j) {
        while (!this.s.isEmpty()) {
            C0910b c0910bRemoveFirst = this.s.removeFirst();
            this.A -= c0910bRemoveFirst.b;
            for (n nVar : this.J) {
                nVar.a(c0910bRemoveFirst.f6298a + j, 1, c0910bRemoveFirst.b, this.A, null);
            }
        }
    }

    private void b(g.a aVar) {
        int i;
        int i2;
        int i3 = 0;
        com.opos.exoplayer.core.i.a.b(this.f == null, "Unexpected moov box.");
        DrmInitData drmInitDataA = this.h;
        if (drmInitDataA == null) {
            drmInitDataA = a(aVar.aQ);
        }
        g.a aVarE = aVar.e(g.M);
        SparseArray sparseArray = new SparseArray();
        int size = aVarE.aQ.size();
        long jC = -9223372036854775807L;
        for (int i4 = 0; i4 < size; i4++) {
            g.b bVar = aVarE.aQ.get(i4);
            int i5 = bVar.aO;
            if (i5 == g.y) {
                Pair<Integer, i> pairB = b(bVar.aP);
                sparseArray.put(((Integer) pairB.first).intValue(), pairB.second);
            } else if (i5 == g.N) {
                jC = c(bVar.aP);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = aVar.aR.size();
        int i6 = 0;
        while (i6 < size2) {
            g.a aVar2 = aVar.aR.get(i6);
            if (aVar2.aO == g.D) {
                i = i6;
                i2 = size2;
                e eVarA = h.a(aVar2, aVar.d(g.C), jC, drmInitDataA, (this.e & 16) != 0, false);
                if (eVarA != null) {
                    sparseArray2.put(eVarA.f6303a, eVarA);
                }
            } else {
                i = i6;
                i2 = size2;
            }
            i6 = i + 1;
            size2 = i2;
        }
        int size3 = sparseArray2.size();
        if (this.i.size() != 0) {
            com.opos.exoplayer.core.i.a.b(this.i.size() == size3);
            while (i3 < size3) {
                e eVar = (e) sparseArray2.valueAt(i3);
                this.i.get(eVar.f6303a).a(eVar, (i) sparseArray.get(eVar.f6303a));
                i3++;
            }
            return;
        }
        while (i3 < size3) {
            e eVar2 = (e) sparseArray2.valueAt(i3);
            c cVar = new c(this.I.a(i3, eVar2.b));
            cVar.a(eVar2, (i) sparseArray.get(eVar2.f6303a));
            this.i.put(eVar2.f6303a, cVar);
            this.B = Math.max(this.B, eVar2.e);
            i3++;
        }
        b();
        this.I.a();
    }

    private static void b(g.a aVar, SparseArray<c> sparseArray, int i, byte[] bArr) throws o {
        c cVarA = a(aVar.d(g.x).aP, sparseArray, i);
        if (cVarA == null) {
            return;
        }
        l lVar = cVarA.f6299a;
        long jD = lVar.s;
        cVarA.a();
        if (aVar.d(g.w) != null && (i & 2) == 0) {
            jD = d(aVar.d(g.w).aP);
        }
        a(aVar, cVarA, jD, i);
        f fVarA = cVarA.c.a(lVar.f6315a.f6312a);
        g.b bVarD = aVar.d(g.ac);
        if (bVarD != null) {
            a(fVarA, bVarD.aP, lVar);
        }
        g.b bVarD2 = aVar.d(g.ad);
        if (bVarD2 != null) {
            a(bVarD2.aP, lVar);
        }
        g.b bVarD3 = aVar.d(g.ah);
        if (bVarD3 != null) {
            b(bVarD3.aP, lVar);
        }
        g.b bVarD4 = aVar.d(g.ae);
        g.b bVarD5 = aVar.d(g.af);
        if (bVarD4 != null && bVarD5 != null) {
            a(bVarD4.aP, bVarD5.aP, fVarA != null ? fVarA.b : null, lVar);
        }
        int size = aVar.aQ.size();
        for (int i2 = 0; i2 < size; i2++) {
            g.b bVar = aVar.aQ.get(i2);
            if (bVar.aO == g.ag) {
                a(bVar.aP, lVar, bArr);
            }
        }
    }

    private static void b(p pVar, l lVar) throws o {
        a(pVar, 0, lVar);
    }

    private static boolean b(int i) {
        return i == g.B || i == g.D || i == g.E || i == g.F || i == g.G || i == g.K || i == g.L || i == g.M || i == g.P;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0080  */
    /* JADX WARN: Code duplicated, block: B:26:0x008e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0097 A[LOOP:0: B:27:0x0095->B:28:0x0097, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:31:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:33:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:40:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:42:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:44:0x0106  */
    /* JADX WARN: Code duplicated, block: B:46:0x010a  */
    /* JADX WARN: Code duplicated, block: B:48:0x0110  */
    /* JADX WARN: Code duplicated, block: B:49:0x0124  */
    /* JADX WARN: Code duplicated, block: B:51:0x012c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0134  */
    /* JADX WARN: Code duplicated, block: B:55:0x013a  */
    /* JADX WARN: Code duplicated, block: B:58:0x013f  */
    /* JADX WARN: Code duplicated, block: B:60:0x0147  */
    private boolean b(com.opos.exoplayer.core.c.f fVar) throws o {
        long jC;
        long jC2;
        int i;
        long j;
        long jC3;
        int size;
        int i2;
        if (this.x == 0) {
            if (!fVar.a(this.p.f6510a, 0, 8, true)) {
                return false;
            }
            this.x = 8;
            this.p.c(0);
            this.w = this.p.m();
            this.v = this.p.o();
        }
        long j2 = this.w;
        if (j2 != 1) {
            if (j2 == 0) {
                long jD = fVar.d();
                if (jD == -1 && !this.r.isEmpty()) {
                    jD = this.r.peek().aP;
                }
                if (jD != -1) {
                    jC = (jD - fVar.c()) + ((long) this.x);
                }
            }
            if (this.w >= this.x) {
                throw new o("Atom size less than header length (unsupported).");
            }
            jC2 = fVar.c() - ((long) this.x);
            if (this.v == g.K) {
                size = this.i.size();
                for (i2 = 0; i2 < size; i2++) {
                    l lVar = this.i.valueAt(i2).f6299a;
                    lVar.b = jC2;
                    lVar.d = jC2;
                    lVar.c = jC2;
                }
            }
            i = this.v;
            if (i == g.h) {
                this.D = null;
                this.z = this.w + jC2;
                if (!this.L) {
                    this.I.a(new com.opos.exoplayer.core.c.l.b(this.B, jC2));
                    this.L = true;
                }
                this.u = 2;
                return true;
            }
            if (b(i)) {
                jC3 = (fVar.c() + this.w) - 8;
                this.r.add(new g.a(this.v, jC3));
                if (this.w == this.x) {
                    a(jC3);
                } else {
                    a();
                }
            } else {
                if (a(this.v)) {
                    if (this.x == 8) {
                        throw new o("Leaf atom defines extended atom size (unsupported).");
                    }
                    j = this.w;
                    if (j <= 2147483647L) {
                        throw new o("Leaf atom with length > 2147483647 (unsupported).");
                    }
                    this.y = new p((int) j);
                    System.arraycopy(this.p.f6510a, 0, this.y.f6510a, 0, 8);
                } else {
                    if (this.w <= 2147483647L) {
                        throw new o("Skipping atom with length > 2147483647 (unsupported).");
                    }
                    this.y = null;
                }
                this.u = 1;
            }
            return true;
        }
        fVar.b(this.p.f6510a, 8, 8);
        this.x += 8;
        jC = this.p.w();
        this.w = jC;
        if (this.w >= this.x) {
            throw new o("Atom size less than header length (unsupported).");
        }
        jC2 = fVar.c() - ((long) this.x);
        if (this.v == g.K) {
            size = this.i.size();
            while (i2 < size) {
                l lVar2 = this.i.valueAt(i2).f6299a;
                lVar2.b = jC2;
                lVar2.d = jC2;
                lVar2.c = jC2;
            }
        }
        i = this.v;
        if (i == g.h) {
            this.D = null;
            this.z = this.w + jC2;
            if (!this.L) {
                this.I.a(new com.opos.exoplayer.core.c.l.b(this.B, jC2));
                this.L = true;
            }
            this.u = 2;
            return true;
        }
        if (b(i)) {
            jC3 = (fVar.c() + this.w) - 8;
            this.r.add(new g.a(this.v, jC3));
            if (this.w == this.x) {
                a(jC3);
            } else {
                a();
            }
        } else {
            if (a(this.v)) {
                if (this.x == 8) {
                    throw new o("Leaf atom defines extended atom size (unsupported).");
                }
                j = this.w;
                if (j <= 2147483647L) {
                    throw new o("Leaf atom with length > 2147483647 (unsupported).");
                }
                this.y = new p((int) j);
                System.arraycopy(this.p.f6510a, 0, this.y.f6510a, 0, 8);
            } else {
                if (this.w <= 2147483647L) {
                    throw new o("Skipping atom with length > 2147483647 (unsupported).");
                }
                this.y = null;
            }
            this.u = 1;
        }
        return true;
    }

    private static long c(p pVar) {
        pVar.c(8);
        return g.a(pVar.o()) == 0 ? pVar.m() : pVar.w();
    }

    private void c(g.a aVar) throws o {
        a(aVar, this.i, this.e, this.q);
        DrmInitData drmInitDataA = this.h != null ? null : a(aVar.aQ);
        if (drmInitDataA != null) {
            int size = this.i.size();
            for (int i = 0; i < size; i++) {
                this.i.valueAt(i).a(drmInitDataA);
            }
        }
    }

    private void c(com.opos.exoplayer.core.c.f fVar) throws o {
        int i = ((int) this.w) - this.x;
        p pVar = this.y;
        if (pVar != null) {
            fVar.b(pVar.f6510a, 8, i);
            a(new g.b(this.v, this.y), fVar.c());
        } else {
            fVar.b(i);
        }
        a(fVar.c());
    }

    private static long d(p pVar) {
        pVar.c(8);
        return g.a(pVar.o()) == 1 ? pVar.w() : pVar.m();
    }

    private void d(com.opos.exoplayer.core.c.f fVar) throws o {
        int size = this.i.size();
        c cVarValueAt = null;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            l lVar = this.i.valueAt(i).f6299a;
            if (lVar.r) {
                long j2 = lVar.d;
                if (j2 < j) {
                    cVarValueAt = this.i.valueAt(i);
                    j = j2;
                }
            }
        }
        if (cVarValueAt == null) {
            this.u = 3;
            return;
        }
        int iC = (int) (j - fVar.c());
        if (iC < 0) {
            throw new o("Offset to encryption data was negative.");
        }
        fVar.b(iC);
        cVarValueAt.f6299a.a(fVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private boolean e(com.opos.exoplayer.core.c.f fVar) throws o {
        int i;
        n.a aVar;
        int iA;
        int i2 = 4;
        int i3 = 1;
        int i4 = 0;
        if (this.u == 3) {
            if (this.D == null) {
                c cVarA = a(this.i);
                if (cVarA == null) {
                    int iC = (int) (this.z - fVar.c());
                    if (iC < 0) {
                        throw new o("Offset to end of mdat was negative.");
                    }
                    fVar.b(iC);
                    a();
                    return false;
                }
                int iC2 = (int) (cVarA.f6299a.g[cVarA.g] - fVar.c());
                if (iC2 < 0) {
                    com.opos.cmn.an.f.a.c("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    iC2 = 0;
                }
                fVar.b(iC2);
                this.D = cVarA;
            }
            c cVar = this.D;
            l lVar = cVar.f6299a;
            this.E = lVar.i[cVar.e];
            if (lVar.m) {
                int iA2 = a(cVar);
                this.F = iA2;
                this.E += iA2;
            } else {
                this.F = 0;
            }
            if (this.D.c.g == 1) {
                this.E -= 8;
                fVar.b(8);
            }
            this.u = 4;
            this.G = 0;
        }
        c cVar2 = this.D;
        l lVar2 = cVar2.f6299a;
        e eVar = cVar2.c;
        n nVar = cVar2.b;
        int i5 = cVar2.e;
        int i6 = eVar.j;
        if (i6 == 0) {
            while (true) {
                int i7 = this.F;
                int i8 = this.E;
                if (i7 >= i8) {
                    break;
                }
                this.F += nVar.a(fVar, i8 - i7, false);
            }
        } else {
            byte[] bArr = this.k.f6510a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i9 = i6 + 1;
            int i10 = 4 - i6;
            while (this.F < this.E) {
                int i11 = this.G;
                if (i11 == 0) {
                    fVar.b(bArr, i10, i9);
                    this.k.c(i4);
                    this.G = this.k.u() - i3;
                    this.j.c(i4);
                    nVar.a(this.j, i2);
                    nVar.a(this.k, i3);
                    this.H = (this.K.length <= 0 || !com.opos.exoplayer.core.i.n.a(eVar.f.f, bArr[i2])) ? i4 : i3;
                    this.F += 5;
                    this.E += i10;
                } else {
                    if (this.H) {
                        this.l.a(i11);
                        fVar.b(this.l.f6510a, i4, this.G);
                        nVar.a(this.l, this.G);
                        iA = this.G;
                        p pVar = this.l;
                        int iA3 = com.opos.exoplayer.core.i.n.a(pVar.f6510a, pVar.c());
                        this.l.c(MimeTypes.VIDEO_H265.equals(eVar.f.f) ? 1 : 0);
                        this.l.b(iA3);
                        com.opos.exoplayer.core.f.a.c.a(lVar2.b(i5) * 1000, this.l, this.K);
                    } else {
                        iA = nVar.a(fVar, i11, i4);
                    }
                    this.F += iA;
                    this.G -= iA;
                    i2 = 4;
                    i3 = 1;
                    i4 = 0;
                }
            }
        }
        long jB = lVar2.b(i5) * 1000;
        w wVar = this.o;
        if (wVar != null) {
            jB = wVar.e(jB);
        }
        boolean z = lVar2.l[i5];
        if (lVar2.m) {
            int i12 = (z ? 1 : 0) | 1073741824;
            f fVarA = lVar2.o;
            if (fVarA == null) {
                fVarA = eVar.a(lVar2.f6315a.f6312a);
            }
            i = i12;
            aVar = fVarA.c;
        } else {
            i = z ? 1 : 0;
            aVar = null;
        }
        nVar.a(jB, i, this.E, 0, aVar);
        b(jB);
        c cVar3 = this.D;
        cVar3.e++;
        cVar3.f++;
        int i13 = cVar3.f;
        int[] iArr = lVar2.h;
        int i14 = cVar3.g;
        if (i13 == iArr[i14]) {
            cVar3.g = i14 + 1;
            cVar3.f = 0;
            this.D = null;
        }
        this.u = 3;
        return true;
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) throws o {
        while (true) {
            int i = this.u;
            if (i != 0) {
                if (i == 1) {
                    c(fVar);
                } else if (i == 2) {
                    d(fVar);
                } else if (e(fVar)) {
                    return 0;
                }
            } else if (!b(fVar)) {
                return -1;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j, long j2) {
        int size = this.i.size();
        for (int i = 0; i < size; i++) {
            this.i.valueAt(i).a();
        }
        this.s.clear();
        this.A = 0;
        this.r.clear();
        a();
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.I = gVar;
        e eVar = this.f;
        if (eVar != null) {
            c cVar = new c(gVar.a(0, eVar.b));
            cVar.a(this.f, new i(0, 0, 0, 0));
            this.i.put(0, cVar);
            b();
            this.I.a();
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        return k.a(fVar);
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
