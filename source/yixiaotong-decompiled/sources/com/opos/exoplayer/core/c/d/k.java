package com.opos.exoplayer.core.c.d;

import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.i.y;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f6314a = {y.f("isom"), y.f("iso2"), y.f("iso3"), y.f("iso4"), y.f("iso5"), y.f("iso6"), y.f("avc1"), y.f("hvc1"), y.f("hev1"), y.f("mp41"), y.f("mp42"), y.f("3g2a"), y.f("3g2b"), y.f("3gr6"), y.f("3gs6"), y.f("3ge6"), y.f("3gg6"), y.f("M4V "), y.f("M4A "), y.f("f4v "), y.f("kddi"), y.f("M4VP"), y.f("qt  "), y.f("MSNV")};

    private static boolean a(int i) {
        if ((i >>> 8) == y.f("3gp")) {
            return true;
        }
        for (int i2 : f6314a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(com.opos.exoplayer.core.c.f fVar) {
        return a(fVar, true);
    }

    private static boolean a(com.opos.exoplayer.core.c.f fVar, boolean z) {
        boolean z2;
        boolean z3;
        int i;
        long jD = fVar.d();
        long j = -1;
        if (jD == -1 || jD > 4096) {
            jD = 4096;
        }
        int i2 = (int) jD;
        p pVar = new p(64);
        int i3 = 0;
        boolean z4 = false;
        while (true) {
            if (i3 < i2) {
                pVar.a(8);
                fVar.c(pVar.f6510a, 0, 8);
                long jM = pVar.m();
                int iO = pVar.o();
                if (jM == 1) {
                    fVar.c(pVar.f6510a, 8, 8);
                    pVar.b(16);
                    i = 16;
                    jM = pVar.w();
                } else {
                    if (jM == 0) {
                        long jD2 = fVar.d();
                        if (jD2 != j) {
                            jM = ((long) 8) + (jD2 - fVar.c());
                        }
                    }
                    i = 8;
                }
                long j2 = i;
                if (jM < j2) {
                    return false;
                }
                i3 += i;
                if (iO != g.B) {
                    if (iO == g.K || iO == g.M) {
                        z2 = true;
                        z3 = true;
                        if (!z4 && z == z3) {
                            return z2;
                        }
                    }
                    if ((((long) i3) + jM) - j2 < i2) {
                        int i4 = (int) (jM - j2);
                        i3 += i4;
                        if (iO == g.f6305a) {
                            if (i4 < 8) {
                                return false;
                            }
                            pVar.a(i4);
                            fVar.c(pVar.f6510a, 0, i4);
                            int i5 = i4 / 4;
                            for (int i6 = 0; i6 < i5; i6++) {
                                if (i6 != 1) {
                                    if (a(pVar.o())) {
                                        z4 = true;
                                        break;
                                    }
                                } else {
                                    pVar.d(4);
                                }
                            }
                            if (!z4) {
                                return false;
                            }
                        } else if (i4 != 0) {
                            fVar.c(i4);
                        }
                        j = -1;
                    }
                }
            }
            z2 = true;
            z3 = false;
            return !z4 ? false : false;
        }
    }

    public static boolean b(com.opos.exoplayer.core.c.f fVar) {
        return a(fVar, false);
    }
}
