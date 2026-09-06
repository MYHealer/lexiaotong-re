package com.opos.exoplayer.core.c.g;

import com.opos.exoplayer.core.c.f;
import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.i.y;
import com.opos.exoplayer.core.o;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class c {

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6366a;
        public final long b;

        private a(int i, long j) {
            this.f6366a = i;
            this.b = j;
        }

        public static a a(f fVar, p pVar) {
            fVar.c(pVar.f6510a, 0, 8);
            pVar.c(0);
            return new a(pVar.o(), pVar.n());
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c8  */
    public static b a(f fVar) throws o {
        a aVarA;
        int i;
        StringBuilder sbAppend;
        StringBuilder sbAppend2;
        com.opos.exoplayer.core.i.a.a(fVar);
        p pVar = new p(16);
        if (a.a(fVar, pVar).f6366a != y.f("RIFF")) {
            return null;
        }
        int iB = 0;
        fVar.c(pVar.f6510a, 0, 4);
        pVar.c(0);
        int iO = pVar.o();
        if (iO != y.f("WAVE")) {
            sbAppend2 = new StringBuilder("Unsupported RIFF format: ").append(iO);
        } else {
            while (true) {
                aVarA = a.a(fVar, pVar);
                if (aVarA.f6366a == y.f("fmt ")) {
                    break;
                }
                fVar.c((int) aVarA.b);
            }
            com.opos.exoplayer.core.i.a.b(aVarA.b >= 16);
            fVar.c(pVar.f6510a, 0, 16);
            pVar.c(0);
            int i2 = pVar.i();
            int i3 = pVar.i();
            int iV = pVar.v();
            int iV2 = pVar.v();
            int i4 = pVar.i();
            int i5 = pVar.i();
            int i6 = (i3 * i5) / 8;
            if (i4 != i6) {
                throw new o("Expected block alignment: " + i6 + "; got: " + i4);
            }
            if (i2 == 1) {
                iB = y.b(i5);
                if (i != 0) {
                    fVar.c(((int) aVarA.b) - 16);
                    return new b(i3, iV, iV2, i4, i5, i);
                }
                sbAppend = new StringBuilder("Unsupported WAV bit depth ").append(i5).append(" for type ");
            } else if (i2 == 3) {
                i = i5 == 32 ? 4 : iB;
                if (i != 0) {
                    fVar.c(((int) aVarA.b) - 16);
                    return new b(i3, iV, iV2, i4, i5, i);
                }
                sbAppend = new StringBuilder("Unsupported WAV bit depth ").append(i5).append(" for type ");
            } else if (i2 != 65534) {
                sbAppend = new StringBuilder("Unsupported WAV format type: ");
            } else {
                iB = y.b(i5);
                if (i != 0) {
                    fVar.c(((int) aVarA.b) - 16);
                    return new b(i3, iV, iV2, i4, i5, i);
                }
                sbAppend = new StringBuilder("Unsupported WAV bit depth ").append(i5).append(" for type ");
            }
            sbAppend2 = sbAppend.append(i2);
        }
        com.opos.cmn.an.f.a.d("WavHeaderReader", sbAppend2.toString());
        return null;
    }

    public static void a(f fVar, b bVar) throws o {
        com.opos.exoplayer.core.i.a.a(fVar);
        com.opos.exoplayer.core.i.a.a(bVar);
        fVar.a();
        p pVar = new p(8);
        while (true) {
            a aVarA = a.a(fVar, pVar);
            if (aVarA.f6366a == y.f("data")) {
                fVar.b(8);
                bVar.a(fVar.c(), aVarA.b);
                return;
            }
            com.opos.cmn.an.f.a.c("WavHeaderReader", "Ignoring unknown WAV chunk: " + aVarA.f6366a);
            long j = aVarA.b + 8;
            if (aVarA.f6366a == y.f("RIFF")) {
                j = 12;
            }
            if (j > 2147483647L) {
                throw new o("Chunk is too large (~2GB+) to skip; id: " + aVarA.f6366a);
            }
            fVar.b((int) j);
        }
    }
}
