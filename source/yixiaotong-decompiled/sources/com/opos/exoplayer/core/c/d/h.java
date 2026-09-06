package com.opos.exoplayer.core.c.d;

import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.i.y;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.o;
import com.opos.exoplayer.core.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f6306a = y.f("vide");
    private static final int b = y.f("soun");
    private static final int c = y.f("text");
    private static final int d = y.f("sbtl");
    private static final int e = y.f("subt");
    private static final int f = y.f("clcp");
    private static final int g = y.f("meta");

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6307a;
        public int b;
        public int c;
        public long d;
        private final boolean e;
        private final p f;
        private final p g;
        private int h;
        private int i;

        public a(p pVar, p pVar2, boolean z) {
            this.g = pVar;
            this.f = pVar2;
            this.e = z;
            pVar2.c(12);
            this.f6307a = pVar2.u();
            pVar.c(12);
            this.i = pVar.u();
            com.opos.exoplayer.core.i.a.b(pVar.o() == 1, "first_chunk must be 1");
            this.b = -1;
        }

        public boolean a() {
            int i = this.b + 1;
            this.b = i;
            if (i == this.f6307a) {
                return false;
            }
            this.d = this.e ? this.f.w() : this.f.m();
            if (this.b == this.h) {
                this.c = this.g.u();
                this.g.d(4);
                int i2 = this.i - 1;
                this.i = i2;
                this.h = i2 > 0 ? this.g.u() - 1 : -1;
            }
            return true;
        }
    }

    private interface b {
        int a();

        int b();

        boolean c();
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.opos.exoplayer.core.c.d.f[] f6308a;
        public Format b;
        public int c;
        public int d = 0;

        public c(int i) {
            this.f6308a = new com.opos.exoplayer.core.c.d.f[i];
        }
    }

    static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f6309a;
        private final int b;
        private final p c;

        public d(g.b bVar) {
            p pVar = bVar.aP;
            this.c = pVar;
            pVar.c(12);
            this.f6309a = pVar.u();
            this.b = pVar.u();
        }

        @Override // com.opos.exoplayer.core.c.d.h.b
        public int a() {
            return this.b;
        }

        @Override // com.opos.exoplayer.core.c.d.h.b
        public int b() {
            int i = this.f6309a;
            return i == 0 ? this.c.u() : i;
        }

        @Override // com.opos.exoplayer.core.c.d.h.b
        public boolean c() {
            return this.f6309a != 0;
        }
    }

    static final class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p f6310a;
        private final int b;
        private final int c;
        private int d;
        private int e;

        public e(g.b bVar) {
            p pVar = bVar.aP;
            this.f6310a = pVar;
            pVar.c(12);
            this.c = pVar.u() & 255;
            this.b = pVar.u();
        }

        @Override // com.opos.exoplayer.core.c.d.h.b
        public int a() {
            return this.b;
        }

        @Override // com.opos.exoplayer.core.c.d.h.b
        public int b() {
            int i = this.c;
            if (i == 8) {
                return this.f6310a.g();
            }
            if (i == 16) {
                return this.f6310a.h();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.e & 15;
            }
            int iG = this.f6310a.g();
            this.e = iG;
            return (iG & 240) >> 4;
        }

        @Override // com.opos.exoplayer.core.c.d.h.b
        public boolean c() {
            return false;
        }
    }

    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f6311a;
        private final long b;
        private final int c;

        public f(int i, long j, int i2) {
            this.f6311a = i;
            this.b = j;
            this.c = i2;
        }
    }

    private static long a(p pVar) {
        pVar.c(8);
        pVar.d(g.a(pVar.o()) != 0 ? 16 : 8);
        return pVar.m();
    }

    private static Pair<long[], long[]> a(g.a aVar) {
        g.b bVarD;
        if (aVar == null || (bVarD = aVar.d(g.Q)) == null) {
            return Pair.create(null, null);
        }
        p pVar = bVarD.aP;
        pVar.c(8);
        int iA = g.a(pVar.o());
        int iU = pVar.u();
        long[] jArr = new long[iU];
        long[] jArr2 = new long[iU];
        for (int i = 0; i < iU; i++) {
            jArr[i] = iA == 1 ? pVar.w() : pVar.m();
            jArr2[i] = iA == 1 ? pVar.q() : pVar.o();
            if (pVar.j() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            pVar.d(2);
        }
        return Pair.create(jArr, jArr2);
    }

    static Pair<Integer, com.opos.exoplayer.core.c.d.f> a(p pVar, int i, int i2) {
        int i3 = i + 8;
        int i4 = -1;
        int i5 = 0;
        String strE = null;
        Integer numValueOf = null;
        while (i3 - i < i2) {
            pVar.c(i3);
            int iO = pVar.o();
            int iO2 = pVar.o();
            if (iO2 == g.ab) {
                numValueOf = Integer.valueOf(pVar.o());
            } else if (iO2 == g.W) {
                pVar.d(4);
                strE = pVar.e(4);
            } else if (iO2 == g.X) {
                i4 = i3;
                i5 = iO;
            }
            i3 += iO;
        }
        if (!C.CENC_TYPE_cenc.equals(strE) && !C.CENC_TYPE_cbc1.equals(strE) && !C.CENC_TYPE_cens.equals(strE) && !C.CENC_TYPE_cbcs.equals(strE)) {
            return null;
        }
        com.opos.exoplayer.core.i.a.a(numValueOf != null, "frma atom is mandatory");
        com.opos.exoplayer.core.i.a.a(i4 != -1, "schi atom is mandatory");
        com.opos.exoplayer.core.c.d.f fVarA = a(pVar, i4, i5, strE);
        com.opos.exoplayer.core.i.a.a(fVarA != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, fVarA);
    }

    public static com.opos.exoplayer.core.c.d.e a(g.a aVar, g.b bVar, long j, DrmInitData drmInitData, boolean z, boolean z2) {
        long[] jArr;
        long[] jArr2;
        g.a aVarE = aVar.e(g.E);
        int iC = c(aVarE.d(g.S).aP);
        if (iC == -1) {
            return null;
        }
        f fVarB = b(aVar.d(g.O).aP);
        long j2 = j == -9223372036854775807L ? fVarB.b : j;
        long jA = a(bVar.aP);
        long jD = j2 != -9223372036854775807L ? y.d(j2, 1000000L, jA) : -9223372036854775807L;
        g.a aVarE2 = aVarE.e(g.F).e(g.G);
        Pair<Long, String> pairD = d(aVarE.d(g.R).aP);
        c cVarA = a(aVarE2.d(g.T).aP, fVarB.f6311a, fVarB.c, (String) pairD.second, drmInitData, z2);
        if (z) {
            jArr = null;
            jArr2 = null;
        } else {
            Pair<long[], long[]> pairA = a(aVar.e(g.P));
            long[] jArr3 = (long[]) pairA.first;
            jArr2 = (long[]) pairA.second;
            jArr = jArr3;
        }
        if (cVarA.b == null) {
            return null;
        }
        return new com.opos.exoplayer.core.c.d.e(fVarB.f6311a, iC, ((Long) pairD.first).longValue(), jA, jD, cVarA.b, cVarA.d, cVarA.f6308a, cVarA.c, jArr, jArr2);
    }

    private static com.opos.exoplayer.core.c.d.f a(p pVar, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            pVar.c(i5);
            int iO = pVar.o();
            if (pVar.o() == g.Y) {
                int iA = g.a(pVar.o());
                pVar.d(1);
                if (iA == 0) {
                    pVar.d(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int iG = pVar.g();
                    i3 = iG & 15;
                    i4 = (iG & 240) >> 4;
                }
                boolean z = pVar.g() == 1;
                int iG2 = pVar.g();
                byte[] bArr2 = new byte[16];
                pVar.a(bArr2, 0, 16);
                if (z && iG2 == 0) {
                    int iG3 = pVar.g();
                    bArr = new byte[iG3];
                    pVar.a(bArr, 0, iG3);
                }
                return new com.opos.exoplayer.core.c.d.f(z, str, iG2, bArr2, i4, i3, bArr);
            }
            i5 += iO;
        }
    }

    private static c a(p pVar, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws o {
        pVar.c(12);
        int iO = pVar.o();
        c cVar = new c(iO);
        for (int i3 = 0; i3 < iO; i3++) {
            int iD = pVar.d();
            int iO2 = pVar.o();
            com.opos.exoplayer.core.i.a.a(iO2 > 0, "childAtomSize should be positive");
            int iO3 = pVar.o();
            if (iO3 == g.b || iO3 == g.c || iO3 == g.Z || iO3 == g.ak || iO3 == g.d || iO3 == g.e || iO3 == g.f || iO3 == g.aJ || iO3 == g.aK) {
                a(pVar, iO3, iD, iO2, i, i2, drmInitData, cVar, i3);
            } else if (iO3 == g.i || iO3 == g.aa || iO3 == g.n || iO3 == g.p || iO3 == g.r || iO3 == g.u || iO3 == g.s || iO3 == g.t || iO3 == g.ax || iO3 == g.ay || iO3 == g.l || iO3 == g.m || iO3 == g.j || iO3 == g.aN) {
                a(pVar, iO3, iD, iO2, i, str, z, drmInitData, cVar, i3);
            } else if (iO3 == g.aj || iO3 == g.at || iO3 == g.au || iO3 == g.av || iO3 == g.aw) {
                a(pVar, iO3, iD, iO2, i, str, cVar);
            } else if (iO3 == g.aM) {
                cVar.b = Format.a(Integer.toString(i), MimeTypes.APPLICATION_CAMERA_MOTION, (String) null, -1, (DrmInitData) null);
            }
            pVar.c(iD + iO2);
        }
        return cVar;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:48:0x00fe A[ADDED_TO_REGION, LOOP:1: B:48:0x00fe->B:49:0x0100, LOOP_START, PHI: r14 r15 r23 r27
  0x00fe: PHI (r14v18 int) = (r14v16 int), (r14v23 int) binds: [B:47:0x00fc, B:49:0x0100] A[DONT_GENERATE, DONT_INLINE]
  0x00fe: PHI (r15v12 int) = (r15v11 int), (r15v16 int) binds: [B:47:0x00fc, B:49:0x0100] A[DONT_GENERATE, DONT_INLINE]
  0x00fe: PHI (r23v9 int) = (r23v8 int), (r23v12 int) binds: [B:47:0x00fc, B:49:0x0100] A[DONT_GENERATE, DONT_INLINE]
  0x00fe: PHI (r27v7 long) = (r27v6 long), (r27v9 long) binds: [B:47:0x00fc, B:49:0x0100] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:49:0x0100 A[LOOP:1: B:48:0x00fe->B:49:0x0100, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x011e A[ADDED_TO_REGION, LOOP:2: B:52:0x011e->B:54:0x0122, LOOP_START, PHI: r16 r21 r22
  0x011e: PHI (r16v11 int) = (r16v7 int), (r16v12 int) binds: [B:51:0x011c, B:54:0x0122] A[DONT_GENERATE, DONT_INLINE]
  0x011e: PHI (r21v15 int) = (r21v13 int), (r21v17 int) binds: [B:51:0x011c, B:54:0x0122] A[DONT_GENERATE, DONT_INLINE]
  0x011e: PHI (r22v15 int) = (r22v10 int), (r22v16 int) binds: [B:51:0x011c, B:54:0x0122] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:58:0x013d  */
    /* JADX WARN: Code duplicated, block: B:61:0x0146  */
    /* JADX WARN: Code duplicated, block: B:62:0x0148  */
    /* JADX WARN: Code duplicated, block: B:65:0x014d  */
    /* JADX WARN: Code duplicated, block: B:67:0x0154  */
    /* JADX WARN: Code duplicated, block: B:75:0x019b  */
    /* JADX WARN: Code duplicated, block: B:76:0x019d  */
    /* JADX WARN: Code duplicated, block: B:79:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:81:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:91:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:93:0x020d  */
    /* JADX WARN: Code duplicated, block: B:96:0x021e A[LOOP:9: B:94:0x0218->B:96:0x021e, LOOP_END] */
    public static m a(com.opos.exoplayer.core.c.d.e eVar, g.a aVar, com.opos.exoplayer.core.c.i iVar) {
        b eVar2;
        boolean z;
        int iU;
        int iU2;
        boolean z2;
        com.opos.exoplayer.core.c.d.e eVar3;
        int i;
        String str;
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        int i2;
        long[] jArr3;
        int[] iArr3;
        long j;
        long[] jArr4;
        int[] iArr4;
        int[] iArr5;
        int i3;
        long jD;
        long[] jArr5;
        int[] iArr6;
        int[] iArr7;
        int[] iArr8;
        int[] iArr9;
        int iO;
        long j2;
        long j3;
        int i4;
        int i5;
        int iU3;
        int iO2;
        int i6;
        int i7;
        int iU4;
        int i8;
        int i9;
        boolean z3;
        int i10;
        boolean z4;
        int iB;
        int i11;
        int iU5;
        g.b bVarD = aVar.d(g.ap);
        if (bVarD != null) {
            eVar2 = new d(bVarD);
        } else {
            g.b bVarD2 = aVar.d(g.aq);
            if (bVarD2 == null) {
                throw new o("Track has no sample table size information");
            }
            eVar2 = new e(bVarD2);
        }
        int iA = eVar2.a();
        if (iA == 0) {
            return new m(new long[0], new int[0], 0, new long[0], new int[0], -9223372036854775807L);
        }
        g.b bVarD3 = aVar.d(g.ar);
        if (bVarD3 == null) {
            bVarD3 = aVar.d(g.as);
            z = true;
        } else {
            z = false;
        }
        p pVar = bVarD3.aP;
        p pVar2 = aVar.d(g.ao).aP;
        p pVar3 = aVar.d(g.al).aP;
        g.b bVarD4 = aVar.d(g.am);
        p pVar4 = null;
        p pVar5 = bVarD4 != null ? bVarD4.aP : null;
        g.b bVarD5 = aVar.d(g.an);
        p pVar6 = bVarD5 != null ? bVarD5.aP : null;
        a aVar2 = new a(pVar2, pVar, z);
        pVar3.c(12);
        int iU6 = pVar3.u() - 1;
        int iU7 = pVar3.u();
        int iU8 = pVar3.u();
        if (pVar6 != null) {
            pVar6.c(12);
            iU = pVar6.u();
        } else {
            iU = 0;
        }
        int iU9 = -1;
        if (pVar5 != null) {
            pVar5.c(12);
            iU2 = pVar5.u();
            iU9 = iU2 > 0 ? pVar5.u() - 1 : -1;
            if (!eVar2.c() && MimeTypes.AUDIO_RAW.equals(eVar.f.f) && iU6 == 0 && iU == 0 && iU2 == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            long j4 = 0;
            if (z2) {
                eVar3 = eVar;
                i = iA;
                b bVar = eVar2;
                str = "AtomParsers";
                int i12 = aVar2.f6307a;
                jArr = new long[i12];
                iArr = new int[i12];
                while (aVar2.a()) {
                    int i13 = aVar2.b;
                    jArr[i13] = aVar2.d;
                    iArr[i13] = aVar2.c;
                }
                com.opos.exoplayer.core.c.d.a.C0909a c0909aA = com.opos.exoplayer.core.c.d.a.a(bVar.b(), jArr, iArr, iU8);
                jArr2 = c0909aA.f6296a;
                iArr2 = c0909aA.b;
                i2 = c0909aA.c;
                jArr3 = c0909aA.d;
                iArr3 = c0909aA.e;
                j = c0909aA.f;
            } else {
                jArr2 = new long[iA];
                iArr2 = new int[iA];
                int i14 = iU2;
                jArr3 = new long[iA];
                iArr3 = new int[iA];
                iO = iU8;
                j2 = 0;
                j3 = 0;
                i4 = iU6;
                i5 = 0;
                i2 = 0;
                iU3 = 0;
                iO2 = 0;
                i6 = 0;
                i7 = i14;
                iU4 = iU9;
                i8 = iU;
                i9 = iU7;
                while (i5 < iA) {
                    while (i6 == 0) {
                        com.opos.exoplayer.core.i.a.b(aVar2.a());
                        j3 = aVar2.d;
                        i6 = aVar2.c;
                        i4 = i4;
                        i9 = i9;
                    }
                    int i15 = i4;
                    int i16 = i9;
                    if (pVar6 != null) {
                        while (iU3 == 0 && i8 > 0) {
                            iU3 = pVar6.u();
                            iO2 = pVar6.o();
                            i8--;
                        }
                        iU3--;
                    }
                    int i17 = iO2;
                    jArr2[i5] = j3;
                    iB = eVar2.b();
                    iArr2[i5] = iB;
                    int i18 = iA;
                    if (iB > i2) {
                        i2 = iB;
                    }
                    b bVar2 = eVar2;
                    jArr3[i5] = j2 + ((long) i17);
                    if (pVar4 == null) {
                        i11 = 1;
                    } else {
                        i11 = 0;
                    }
                    iArr3[i5] = i11;
                    if (i5 == iU4) {
                        iArr3[i5] = 1;
                        i7--;
                        if (i7 > 0) {
                            iU4 = pVar4.u() - 1;
                        }
                    }
                    j2 += (long) iO;
                    iU5 = i16 - 1;
                    if (iU5 != 0 && i15 > 0) {
                        i15--;
                        iU5 = pVar3.u();
                        iO = pVar3.o();
                    }
                    int i19 = iU5;
                    j3 += (long) iArr2[i5];
                    i6--;
                    i5++;
                    eVar2 = bVar2;
                    iA = i18;
                    iO = iO;
                    i9 = i19;
                    iO2 = i17;
                    i4 = i15;
                }
                int i20 = i4;
                int i21 = i9;
                int i22 = iO2;
                i = iA;
                j = j2 + ((long) i22);
                if (iU3 == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                com.opos.exoplayer.core.i.a.a(z3);
                while (i8 > 0) {
                    if (pVar6.u() == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    com.opos.exoplayer.core.i.a.a(z4);
                    pVar6.o();
                    i8--;
                }
                if (i7 == 0 || i21 != 0) {
                    i10 = i6;
                } else {
                    i10 = i6;
                    if (i10 == 0 && i20 == 0) {
                        eVar3 = eVar;
                        str = "AtomParsers";
                    }
                }
                eVar3 = eVar;
                str = "AtomParsers";
                com.opos.cmn.an.f.a.c(str, "Inconsistent stbl box for track " + eVar3.f6303a + ": remainingSynchronizationSamples " + i7 + ", remainingSamplesAtTimestampDelta " + i21 + ", remainingSamplesInChunk " + i10 + ", remainingTimestampDeltaChanges " + i20);
            }
            jArr4 = jArr3;
            iArr4 = iArr2;
            iArr5 = iArr3;
            i3 = i2;
            jD = y.d(j, 1000000L, eVar3.c);
            if (eVar3.h != null || iVar.a()) {
                y.a(jArr4, 1000000L, eVar3.c);
                return new m(jArr2, iArr4, i3, jArr4, iArr5, jD);
            }
            long[] jArr6 = eVar3.h;
            if (jArr6.length == 1 && eVar3.b == 1 && jArr4.length >= 2) {
                long j5 = eVar3.i[0];
                long jD2 = y.d(jArr6[0], eVar3.c, eVar3.d) + j5;
                long j6 = jArr4[0];
                if (j6 <= j5 && j5 < jArr4[1] && jArr4[jArr4.length - 1] < jD2 && jD2 <= j) {
                    long j7 = j - jD2;
                    long jD3 = y.d(j5 - j6, eVar3.f.s, eVar3.c);
                    long jD4 = y.d(j7, eVar3.f.s, eVar3.c);
                    if ((jD3 != 0 || jD4 != 0) && jD3 <= 2147483647L && jD4 <= 2147483647L) {
                        iVar.b = (int) jD3;
                        iVar.c = (int) jD4;
                        y.a(jArr4, 1000000L, eVar3.c);
                        return new m(jArr2, iArr4, i3, jArr4, iArr5, jD);
                    }
                }
            }
            long[] jArr7 = eVar3.h;
            if (jArr7.length == 1 && jArr7[0] == 0) {
                long j8 = eVar3.i[0];
                for (int i23 = 0; i23 < jArr4.length; i23++) {
                    jArr4[i23] = y.d(jArr4[i23] - j8, 1000000L, eVar3.c);
                }
                return new m(jArr2, iArr4, i3, jArr4, iArr5, y.d(j - j8, 1000000L, eVar3.c));
            }
            boolean z5 = eVar3.b == 1;
            int i24 = 0;
            int i25 = 0;
            boolean z6 = false;
            int i26 = 0;
            while (true) {
                long[] jArr8 = eVar3.h;
                if (i26 >= jArr8.length) {
                    break;
                }
                long j9 = eVar3.i[i26];
                if (j9 != -1) {
                    long jD5 = y.d(jArr8[i26], eVar3.c, eVar3.d);
                    int iB2 = y.b(jArr4, j9, true, true);
                    int iB3 = y.b(jArr4, j9 + jD5, z5, false);
                    i24 += iB3 - iB2;
                    z6 = (i25 != iB2) | z6;
                    i25 = iB3;
                }
                i26++;
                iArr5 = iArr5;
                str = str;
                iArr4 = iArr4;
            }
            int[] iArr10 = iArr4;
            String str2 = str;
            int[] iArr11 = iArr5;
            boolean z7 = (i24 != i) | z6;
            long[] jArr9 = z7 ? new long[i24] : jArr2;
            int[] iArr12 = z7 ? new int[i24] : iArr10;
            int i27 = z7 ? 0 : i3;
            int[] iArr13 = z7 ? new int[i24] : iArr11;
            long[] jArr10 = new long[i24];
            int i28 = i27;
            int i29 = 0;
            int i30 = 0;
            while (true) {
                long[] jArr11 = eVar3.h;
                if (i29 >= jArr11.length) {
                    break;
                }
                int i31 = i28;
                int[] iArr14 = iArr11;
                long j10 = eVar3.i[i29];
                long j11 = jArr11[i29];
                if (j10 != -1) {
                    int[] iArr15 = iArr13;
                    long jD6 = y.d(j11, eVar3.c, eVar3.d) + j10;
                    int iB4 = y.b(jArr4, j10, true, true);
                    int iB5 = y.b(jArr4, jD6, z5, false);
                    if (z7) {
                        int i32 = iB5 - iB4;
                        System.arraycopy(jArr2, iB4, jArr9, i30, i32);
                        iArr6 = iArr10;
                        System.arraycopy(iArr6, iB4, iArr12, i30, i32);
                        iArr9 = iArr14;
                        iArr8 = iArr15;
                        System.arraycopy(iArr9, iB4, iArr8, i30, i32);
                    } else {
                        iArr6 = iArr10;
                        iArr9 = iArr14;
                        iArr8 = iArr15;
                    }
                    int i33 = i31;
                    while (true) {
                        jArr5 = jArr2;
                        iArr7 = iArr9;
                        if (iB4 >= iB5) {
                            break;
                        }
                        long j12 = j10;
                        jArr10[i30] = y.d(j4, 1000000L, eVar3.d) + y.d(jArr4[iB4] - j10, 1000000L, eVar3.c);
                        if (z7 && iArr12[i30] > i33) {
                            i33 = iArr6[iB4];
                        }
                        i30++;
                        iB4++;
                        jArr2 = jArr5;
                        j10 = j12;
                        iArr9 = iArr7;
                    }
                    i28 = i33;
                } else {
                    jArr5 = jArr2;
                    iArr6 = iArr10;
                    iArr7 = iArr14;
                    jArr9 = jArr9;
                    z5 = z5;
                    iArr8 = iArr13;
                    i28 = i31;
                }
                j4 += j11;
                i29++;
                iArr13 = iArr8;
                z5 = z5;
                jArr9 = jArr9;
                jArr2 = jArr5;
                iArr11 = iArr7;
                iArr10 = iArr6;
            }
            long[] jArr12 = jArr9;
            long[] jArr13 = jArr2;
            int[] iArr16 = iArr13;
            int i34 = i28;
            int[] iArr17 = iArr11;
            int[] iArr18 = iArr10;
            long jD7 = y.d(j4, 1000000L, eVar3.c);
            boolean z8 = false;
            for (int i35 = 0; i35 < iArr16.length && !z8; i35++) {
                z8 |= (iArr16[i35] & 1) != 0;
            }
            if (z8) {
                return new m(jArr12, iArr12, i34, jArr10, iArr16, jD7);
            }
            com.opos.cmn.an.f.a.c(str2, "Ignoring edit list: Edited sample sequence does not contain a sync sample.");
            y.a(jArr4, 1000000L, eVar3.c);
            return new m(jArr13, iArr18, i3, jArr4, iArr17, jD);
        }
        iU2 = 0;
        pVar4 = pVar5;
        if (!eVar2.c()) {
            z2 = false;
        } else {
            z2 = false;
        }
        long j13 = 0;
        if (z2) {
            jArr2 = new long[iA];
            iArr2 = new int[iA];
            int i110 = iU2;
            jArr3 = new long[iA];
            iArr3 = new int[iA];
            iO = iU8;
            j2 = 0;
            j3 = 0;
            i4 = iU6;
            i5 = 0;
            i2 = 0;
            iU3 = 0;
            iO2 = 0;
            i6 = 0;
            i7 = i110;
            iU4 = iU9;
            i8 = iU;
            i9 = iU7;
            while (i5 < iA) {
                while (i6 == 0) {
                    com.opos.exoplayer.core.i.a.b(aVar2.a());
                    j3 = aVar2.d;
                    i6 = aVar2.c;
                    i4 = i4;
                    i9 = i9;
                }
                int i111 = i4;
                int i112 = i9;
                if (pVar6 != null) {
                    while (iU3 == 0) {
                        iU3 = pVar6.u();
                        iO2 = pVar6.o();
                        i8--;
                    }
                    iU3--;
                }
                int i113 = iO2;
                jArr2[i5] = j3;
                iB = eVar2.b();
                iArr2[i5] = iB;
                int i114 = iA;
                if (iB > i2) {
                    i2 = iB;
                }
                b bVar3 = eVar2;
                jArr3[i5] = j2 + ((long) i113);
                if (pVar4 == null) {
                    i11 = 1;
                } else {
                    i11 = 0;
                }
                iArr3[i5] = i11;
                if (i5 == iU4) {
                    iArr3[i5] = 1;
                    i7--;
                    if (i7 > 0) {
                        iU4 = pVar4.u() - 1;
                    }
                }
                j2 += (long) iO;
                iU5 = i112 - 1;
                if (iU5 != 0) {
                }
                int i115 = iU5;
                j3 += (long) iArr2[i5];
                i6--;
                i5++;
                eVar2 = bVar3;
                iA = i114;
                iO = iO;
                i9 = i115;
                iO2 = i113;
                i4 = i111;
            }
            int i210 = i4;
            int i211 = i9;
            int i212 = iO2;
            i = iA;
            j = j2 + ((long) i212);
            if (iU3 == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            com.opos.exoplayer.core.i.a.a(z3);
            while (i8 > 0) {
                if (pVar6.u() == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                com.opos.exoplayer.core.i.a.a(z4);
                pVar6.o();
                i8--;
            }
            if (i7 == 0) {
                i10 = i6;
                eVar3 = eVar;
                str = "AtomParsers";
                com.opos.cmn.an.f.a.c(str, "Inconsistent stbl box for track " + eVar3.f6303a + ": remainingSynchronizationSamples " + i7 + ", remainingSamplesAtTimestampDelta " + i211 + ", remainingSamplesInChunk " + i10 + ", remainingTimestampDeltaChanges " + i210);
            } else {
                i10 = i6;
                eVar3 = eVar;
                str = "AtomParsers";
                com.opos.cmn.an.f.a.c(str, "Inconsistent stbl box for track " + eVar3.f6303a + ": remainingSynchronizationSamples " + i7 + ", remainingSamplesAtTimestampDelta " + i211 + ", remainingSamplesInChunk " + i10 + ", remainingTimestampDeltaChanges " + i210);
            }
        } else {
            eVar3 = eVar;
            i = iA;
            b bVar4 = eVar2;
            str = "AtomParsers";
            int i116 = aVar2.f6307a;
            jArr = new long[i116];
            iArr = new int[i116];
            while (aVar2.a()) {
                int i117 = aVar2.b;
                jArr[i117] = aVar2.d;
                iArr[i117] = aVar2.c;
            }
            com.opos.exoplayer.core.c.d.a.C0909a c0909aA2 = com.opos.exoplayer.core.c.d.a.a(bVar4.b(), jArr, iArr, iU8);
            jArr2 = c0909aA2.f6296a;
            iArr2 = c0909aA2.b;
            i2 = c0909aA2.c;
            jArr3 = c0909aA2.d;
            iArr3 = c0909aA2.e;
            j = c0909aA2.f;
        }
        jArr4 = jArr3;
        iArr4 = iArr2;
        iArr5 = iArr3;
        i3 = i2;
        jD = y.d(j, 1000000L, eVar3.c);
        if (eVar3.h != null) {
        }
        y.a(jArr4, 1000000L, eVar3.c);
        return new m(jArr2, iArr4, i3, jArr4, iArr5, jD);
    }

    public static Metadata a(g.b bVar, boolean z) {
        if (z) {
            return null;
        }
        p pVar = bVar.aP;
        pVar.c(8);
        while (pVar.b() >= 8) {
            int iD = pVar.d();
            int iO = pVar.o();
            if (pVar.o() == g.aA) {
                pVar.c(iD);
                return a(pVar, iD + iO);
            }
            pVar.d(iO - 8);
        }
        return null;
    }

    private static Metadata a(p pVar, int i) {
        pVar.d(12);
        while (pVar.d() < i) {
            int iD = pVar.d();
            int iO = pVar.o();
            if (pVar.o() == g.aB) {
                pVar.c(iD);
                return b(pVar, iD + iO);
            }
            pVar.d(iO - 8);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:78:0x013c A[PHI: r13
  0x013c: PHI (r13v2 int) = (r13v1 int), (r13v3 int) binds: [B:72:0x0131, B:74:0x0134] A[DONT_GENERATE, DONT_INLINE]] */
    private static void a(p pVar, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, c cVar, int i6) throws o {
        DrmInitData drmInitDataA = drmInitData;
        pVar.c(i2 + 16);
        pVar.d(16);
        int iH = pVar.h();
        int iH2 = pVar.h();
        pVar.d(50);
        int iD = pVar.d();
        String str = null;
        int iIntValue = i;
        if (iIntValue == g.Z) {
            Pair<Integer, com.opos.exoplayer.core.c.d.f> pairC = c(pVar, i2, i3);
            if (pairC != null) {
                iIntValue = ((Integer) pairC.first).intValue();
                drmInitDataA = drmInitDataA == null ? null : drmInitDataA.a(((com.opos.exoplayer.core.c.d.f) pairC.second).b);
                cVar.f6308a[i6] = (com.opos.exoplayer.core.c.d.f) pairC.second;
            }
            pVar.c(iD);
        }
        DrmInitData drmInitData2 = drmInitDataA;
        float fC = 1.0f;
        List<byte[]> listSingletonList = null;
        byte[] bArrD = null;
        int i7 = -1;
        boolean z = false;
        while (iD - i2 < i3) {
            pVar.c(iD);
            int iD2 = pVar.d();
            int iO = pVar.o();
            if (iO == 0 && pVar.d() - i2 == i3) {
                break;
            }
            int i8 = 1;
            com.opos.exoplayer.core.i.a.a(iO > 0, "childAtomSize should be positive");
            int iO2 = pVar.o();
            if (iO2 == g.H) {
                com.opos.exoplayer.core.i.a.b(str == null);
                pVar.c(iD2 + 8);
                com.opos.exoplayer.core.video.a aVarA = com.opos.exoplayer.core.video.a.a(pVar);
                listSingletonList = aVarA.f6551a;
                cVar.c = aVarA.b;
                str = MimeTypes.VIDEO_H264;
                if (!z) {
                    fC = aVarA.e;
                }
            } else if (iO2 == g.I) {
                com.opos.exoplayer.core.i.a.b(str == null);
                pVar.c(iD2 + 8);
                com.opos.exoplayer.core.video.b bVarA = com.opos.exoplayer.core.video.b.a(pVar);
                listSingletonList = bVarA.f6552a;
                cVar.c = bVarA.b;
                str = MimeTypes.VIDEO_H265;
            } else if (iO2 == g.aL) {
                com.opos.exoplayer.core.i.a.b(str == null);
                str = iIntValue == g.aJ ? MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_VP9;
            } else if (iO2 == g.g) {
                com.opos.exoplayer.core.i.a.b(str == null);
                str = MimeTypes.VIDEO_H263;
            } else if (iO2 == g.J) {
                com.opos.exoplayer.core.i.a.b(str == null);
                Pair<String, byte[]> pairD = d(pVar, iD2);
                str = (String) pairD.first;
                listSingletonList = Collections.singletonList(pairD.second);
            } else if (iO2 == g.ai) {
                fC = c(pVar, iD2);
                z = true;
            } else if (iO2 == g.aH) {
                bArrD = d(pVar, iD2, iO);
            } else if (iO2 == g.aG) {
                int iG = pVar.g();
                pVar.d(3);
                if (iG == 0) {
                    int iG2 = pVar.g();
                    if (iG2 == 0) {
                        i7 = 0;
                    } else if (iG2 != 1) {
                        i8 = 2;
                        if (iG2 == 2) {
                            i7 = i8;
                        } else if (iG2 == 3) {
                            i7 = 3;
                        }
                    } else {
                        i7 = i8;
                    }
                }
            }
            iD += iO;
        }
        if (str == null) {
            return;
        }
        cVar.b = Format.a(Integer.toString(i4), str, (String) null, -1, -1, iH, iH2, -1.0f, listSingletonList, i5, fC, bArrD, i7, (ColorInfo) null, drmInitData2);
    }

    private static void a(p pVar, int i, int i2, int i3, int i4, String str, c cVar) {
        pVar.c(i2 + 16);
        int i5 = g.aj;
        String str2 = MimeTypes.APPLICATION_TTML;
        List listSingletonList = null;
        long j = Long.MAX_VALUE;
        if (i != i5) {
            if (i == g.at) {
                int i6 = i3 - 16;
                byte[] bArr = new byte[i6];
                pVar.a(bArr, 0, i6);
                listSingletonList = Collections.singletonList(bArr);
                str2 = MimeTypes.APPLICATION_TX3G;
            } else if (i == g.au) {
                str2 = MimeTypes.APPLICATION_MP4VTT;
            } else if (i == g.av) {
                j = 0;
            } else {
                if (i != g.aw) {
                    throw new IllegalStateException();
                }
                cVar.d = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            }
        }
        cVar.b = Format.a(Integer.toString(i4), str2, null, -1, 0, str, -1, null, j, listSingletonList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void a(p pVar, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, c cVar, int i5) {
        int iH;
        int iS;
        int iU;
        String str2;
        int i6;
        int i7;
        String str3;
        String str4;
        DrmInitData drmInitData2;
        boolean z2;
        int i8;
        int i9;
        int i10;
        Format formatB;
        int i11 = i2;
        DrmInitData drmInitDataA = drmInitData;
        pVar.c(i11 + 16);
        int i12 = 0;
        if (z) {
            iH = pVar.h();
            pVar.d(6);
        } else {
            pVar.d(8);
            iH = 0;
        }
        int i13 = 2;
        boolean z3 = true;
        if (iH == 0 || iH == 1) {
            int iH2 = pVar.h();
            pVar.d(6);
            iS = pVar.s();
            if (iH == 1) {
                pVar.d(16);
            }
            iU = iH2;
        } else {
            if (iH != 2) {
                return;
            }
            pVar.d(16);
            iS = (int) Math.round(pVar.x());
            iU = pVar.u();
            pVar.d(20);
        }
        int iD = pVar.d();
        int iIntValue = i;
        if (iIntValue == g.aa) {
            Pair<Integer, com.opos.exoplayer.core.c.d.f> pairC = c(pVar, i11, i3);
            if (pairC != null) {
                iIntValue = ((Integer) pairC.first).intValue();
                drmInitDataA = drmInitDataA == null ? null : drmInitDataA.a(((com.opos.exoplayer.core.c.d.f) pairC.second).b);
                cVar.f6308a[i5] = (com.opos.exoplayer.core.c.d.f) pairC.second;
            }
            pVar.c(iD);
        }
        DrmInitData drmInitData3 = drmInitDataA;
        int i14 = g.n;
        String str5 = MimeTypes.AUDIO_RAW;
        if (iIntValue == i14) {
            str2 = MimeTypes.AUDIO_AC3;
        } else if (iIntValue == g.p) {
            str2 = MimeTypes.AUDIO_E_AC3;
        } else if (iIntValue == g.r) {
            str2 = MimeTypes.AUDIO_DTS;
        } else if (iIntValue == g.s || iIntValue == g.t) {
            str2 = MimeTypes.AUDIO_DTS_HD;
        } else if (iIntValue == g.u) {
            str2 = MimeTypes.AUDIO_DTS_EXPRESS;
        } else if (iIntValue == g.ax) {
            str2 = MimeTypes.AUDIO_AMR_NB;
        } else if (iIntValue == g.ay) {
            str2 = MimeTypes.AUDIO_AMR_WB;
        } else if (iIntValue == g.l || iIntValue == g.m) {
            str2 = MimeTypes.AUDIO_RAW;
        } else if (iIntValue == g.j) {
            str2 = MimeTypes.AUDIO_MPEG;
        } else {
            str2 = iIntValue == g.aN ? MimeTypes.AUDIO_ALAC : null;
        }
        String str6 = str2;
        int iIntValue2 = iS;
        int iIntValue3 = iU;
        int i15 = iD;
        byte[] bArr = null;
        while (i15 - i11 < i3) {
            pVar.c(i15);
            int iO = pVar.o();
            com.opos.exoplayer.core.i.a.a(iO > 0 ? z3 : i12, "childAtomSize should be positive");
            int iO2 = pVar.o();
            if (iO2 == g.J || (z && iO2 == g.k)) {
                i6 = iO;
                i7 = i15;
                str3 = str6;
                str4 = str5;
                drmInitData2 = drmInitData3;
                z2 = z3;
                i8 = i13;
                i9 = i12;
                int iB = iO2 == g.J ? i7 : b(pVar, i7, i6);
                if (iB != -1) {
                    Pair<String, byte[]> pairD = d(pVar, iB);
                    str6 = (String) pairD.first;
                    bArr = (byte[]) pairD.second;
                    if (MimeTypes.AUDIO_AAC.equals(str6)) {
                        Pair<Integer, Integer> pairA = com.opos.exoplayer.core.i.f.a(bArr);
                        iIntValue2 = ((Integer) pairA.first).intValue();
                        iIntValue3 = ((Integer) pairA.second).intValue();
                    }
                }
                i15 = i7 + i6;
                i12 = i9;
                drmInitData3 = drmInitData2;
                z3 = z2;
                i13 = i8;
                str5 = str4;
                i11 = i2;
            } else {
                if (iO2 == g.o) {
                    pVar.c(i15 + 8);
                    formatB = com.opos.exoplayer.core.a.a.a(pVar, Integer.toString(i4), str, drmInitData3);
                } else if (iO2 == g.q) {
                    pVar.c(i15 + 8);
                    formatB = com.opos.exoplayer.core.a.a.b(pVar, Integer.toString(i4), str, drmInitData3);
                } else {
                    if (iO2 == g.v) {
                        i10 = i15;
                        str3 = str6;
                        str4 = str5;
                        drmInitData2 = drmInitData3;
                        z2 = z3;
                        i8 = i13;
                        i9 = i12;
                        cVar.b = Format.a(Integer.toString(i4), str6, null, -1, -1, iIntValue3, iIntValue2, null, drmInitData2, 0, str);
                        i6 = iO;
                    } else {
                        i10 = i15;
                        str3 = str6;
                        str4 = str5;
                        drmInitData2 = drmInitData3;
                        z2 = z3;
                        i8 = i13;
                        i9 = i12;
                        i6 = iO;
                        if (iO2 == g.aN) {
                            byte[] bArr2 = new byte[i6];
                            i7 = i10;
                            pVar.c(i7);
                            pVar.a(bArr2, i9, i6);
                            bArr = bArr2;
                        }
                    }
                    i7 = i10;
                }
                cVar.b = formatB;
                i6 = iO;
                i7 = i15;
                str3 = str6;
                str4 = str5;
                drmInitData2 = drmInitData3;
                z2 = z3;
                i8 = i13;
                i9 = i12;
            }
            str6 = str3;
            i15 = i7 + i6;
            i12 = i9;
            drmInitData3 = drmInitData2;
            z3 = z2;
            i13 = i8;
            str5 = str4;
            i11 = i2;
        }
        String str7 = str6;
        String str8 = str5;
        DrmInitData drmInitData4 = drmInitData3;
        int i16 = i13;
        if (cVar.b != null || str7 == null) {
            return;
        }
        cVar.b = Format.a(Integer.toString(i4), str7, (String) null, -1, -1, iIntValue3, iIntValue2, str8.equals(str7) ? i16 : -1, (List<byte[]>) (bArr != null ? Collections.singletonList(bArr) : null), drmInitData4, 0, str);
    }

    private static int b(p pVar, int i, int i2) {
        int iD = pVar.d();
        while (iD - i < i2) {
            pVar.c(iD);
            int iO = pVar.o();
            com.opos.exoplayer.core.i.a.a(iO > 0, "childAtomSize should be positive");
            if (pVar.o() == g.J) {
                return iD;
            }
            iD += iO;
        }
        return -1;
    }

    private static f b(p pVar) {
        long j;
        pVar.c(8);
        int iA = g.a(pVar.o());
        pVar.d(iA == 0 ? 8 : 16);
        int iO = pVar.o();
        pVar.d(4);
        int iD = pVar.d();
        int i = iA == 0 ? 4 : 8;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            j = -9223372036854775807L;
            if (i3 >= i) {
                pVar.d(i);
                break;
            }
            if (pVar.f6510a[iD + i3] != -1) {
                long jM = iA == 0 ? pVar.m() : pVar.w();
                if (jM == 0) {
                    break;
                }
                j = jM;
                break;
            }
            i3++;
        }
        pVar.d(16);
        int iO2 = pVar.o();
        int iO3 = pVar.o();
        pVar.d(4);
        int iO4 = pVar.o();
        int iO5 = pVar.o();
        if (iO2 == 0 && iO3 == 65536 && iO4 == -65536 && iO5 == 0) {
            i2 = 90;
        } else if (iO2 == 0 && iO3 == -65536 && iO4 == 65536 && iO5 == 0) {
            i2 = 270;
        } else if (iO2 == -65536 && iO3 == 0 && iO4 == 0 && iO5 == -65536) {
            i2 = 180;
        }
        return new f(iO, j, i2);
    }

    private static Metadata b(p pVar, int i) {
        pVar.d(8);
        ArrayList arrayList = new ArrayList();
        while (pVar.d() < i) {
            Metadata.Entry entryA = j.a(pVar);
            if (entryA != null) {
                arrayList.add(entryA);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static float c(p pVar, int i) {
        pVar.c(i + 8);
        return pVar.u() / pVar.u();
    }

    private static int c(p pVar) {
        pVar.c(16);
        int iO = pVar.o();
        if (iO == b) {
            return 1;
        }
        if (iO == f6306a) {
            return 2;
        }
        if (iO == c || iO == d || iO == e || iO == f) {
            return 3;
        }
        return iO == g ? 4 : -1;
    }

    private static Pair<Integer, com.opos.exoplayer.core.c.d.f> c(p pVar, int i, int i2) {
        Pair<Integer, com.opos.exoplayer.core.c.d.f> pairA;
        int iD = pVar.d();
        while (iD - i < i2) {
            pVar.c(iD);
            int iO = pVar.o();
            com.opos.exoplayer.core.i.a.a(iO > 0, "childAtomSize should be positive");
            if (pVar.o() == g.V && (pairA = a(pVar, iD, iO)) != null) {
                return pairA;
            }
            iD += iO;
        }
        return null;
    }

    private static Pair<Long, String> d(p pVar) {
        pVar.c(8);
        int iA = g.a(pVar.o());
        pVar.d(iA == 0 ? 8 : 16);
        long jM = pVar.m();
        pVar.d(iA == 0 ? 4 : 8);
        int iH = pVar.h();
        return Pair.create(Long.valueOf(jM), "" + ((char) (((iH >> 10) & 31) + 96)) + ((char) (((iH >> 5) & 31) + 96)) + ((char) ((iH & 31) + 96)));
    }

    private static Pair<String, byte[]> d(p pVar, int i) {
        pVar.c(i + 12);
        pVar.d(1);
        e(pVar);
        pVar.d(2);
        int iG = pVar.g();
        if ((iG & 128) != 0) {
            pVar.d(2);
        }
        if ((iG & 64) != 0) {
            pVar.d(pVar.h());
        }
        if ((iG & 32) != 0) {
            pVar.d(2);
        }
        pVar.d(1);
        e(pVar);
        String strA = com.opos.exoplayer.core.i.m.a(pVar.g());
        if (MimeTypes.AUDIO_MPEG.equals(strA) || MimeTypes.AUDIO_DTS.equals(strA) || MimeTypes.AUDIO_DTS_HD.equals(strA)) {
            return Pair.create(strA, null);
        }
        pVar.d(12);
        pVar.d(1);
        int iE = e(pVar);
        byte[] bArr = new byte[iE];
        pVar.a(bArr, 0, iE);
        return Pair.create(strA, bArr);
    }

    private static byte[] d(p pVar, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            pVar.c(i3);
            int iO = pVar.o();
            if (pVar.o() == g.aI) {
                return Arrays.copyOfRange(pVar.f6510a, i3, iO + i3);
            }
            i3 += iO;
        }
        return null;
    }

    private static int e(p pVar) {
        int iG = pVar.g();
        int i = iG & 127;
        while ((iG & 128) == 128) {
            iG = pVar.g();
            i = (i << 7) | (iG & 127);
        }
        return i;
    }
}
