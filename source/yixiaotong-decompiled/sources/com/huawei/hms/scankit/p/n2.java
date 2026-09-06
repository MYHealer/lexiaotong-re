package com.huawei.hms.scankit.p;

import java.util.Locale;

/* JADX INFO: compiled from: Encoder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f4313a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int a(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static f a(byte[] bArr, int i, int i2) {
        r rVarA;
        int i3;
        boolean z;
        int iAbs;
        int iA;
        int i4;
        r rVarA2 = new l3(bArr).a();
        int iE = ((rVarA2.e() * i) / 100) + 11;
        int iE2 = rVarA2.e() + iE;
        int i5 = 4;
        int i6 = 0;
        if (i2 != 0) {
            boolean z2 = i2 < 0;
            iAbs = Math.abs(i2);
            if (iAbs > (z2 ? 4 : 32)) {
                throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Illegal value %s for layers", Integer.valueOf(i2)));
            }
            iA = a(iAbs, z2);
            i3 = f4313a[iAbs];
            int i7 = iA - (iA % i3);
            rVarA = a(rVarA2, i3);
            if (rVarA.e() + iE > i7) {
                z = z2;
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
            if (z2) {
                z = z2;
                if (rVarA.e() > i3 * 64) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            }
        } else {
            r rVarA3 = null;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                if (i8 > 32) {
                    throw new IllegalArgumentException("Data too large for an Aztec code");
                }
                boolean z3 = i8 <= 3 ? 1 : i6;
                int i10 = z3 != 0 ? i8 + 1 : i8;
                int iA2 = a(i10, z3);
                if (iE2 <= iA2) {
                    if (rVarA3 == null || i9 != f4313a[i10]) {
                        int i11 = f4313a[i10];
                        i9 = i11;
                        rVarA3 = a(rVarA2, i11);
                    }
                    int i12 = iA2 - (iA2 % i9);
                    if ((z3 == 0 || rVarA3.e() <= i9 * 64) && rVarA3.e() + iE <= i12) {
                        rVarA = rVarA3;
                        i3 = i9;
                        z = z3;
                        iAbs = i10;
                        iA = iA2;
                        break;
                    }
                }
                i8++;
                i5 = 4;
                i6 = 0;
            }
        }
        r rVarB = b(rVarA, iA, i3);
        int iE3 = rVarA.e() / i3;
        r rVarA4 = a(z, iAbs, iE3);
        int i13 = (z ? 11 : 14) + (iAbs * 4);
        int[] iArr = new int[i13];
        int i14 = 2;
        if (z) {
            for (int i15 = i6; i15 < i13; i15++) {
                iArr[i15] = i15;
            }
            i4 = i13;
        } else {
            int i16 = i13 / 2;
            i4 = i13 + 1 + (((i16 - 1) / 15) * 2);
            int i17 = i4 / 2;
            for (int i18 = i6; i18 < i16; i18++) {
                int i19 = (i18 / 15) + i18;
                iArr[(i16 - i18) - 1] = (i17 - i19) - 1;
                iArr[i16 + i18] = i19 + i17 + 1;
            }
        }
        s sVar = new s(i4);
        int i20 = i6;
        int i21 = i20;
        while (i20 < iAbs) {
            int i22 = ((iAbs - i20) * i5) + (z ? 9 : 12);
            int i23 = i6;
            while (i23 < i22) {
                int i24 = i23 * 2;
                while (i6 < i14) {
                    if (rVarB.b(i21 + i24 + i6)) {
                        int i25 = i20 * 2;
                        sVar.c(iArr[i25 + i6], iArr[i25 + i23]);
                    }
                    if (rVarB.b((i22 * 2) + i21 + i24 + i6)) {
                        int i26 = i20 * 2;
                        sVar.c(iArr[i26 + i23], iArr[((i13 - 1) - i26) - i6]);
                    }
                    if (rVarB.b((i22 * 4) + i21 + i24 + i6)) {
                        int i27 = (i13 - 1) - (i20 * 2);
                        sVar.c(iArr[i27 - i6], iArr[i27 - i23]);
                    }
                    if (rVarB.b((i22 * 6) + i21 + i24 + i6)) {
                        int i28 = i20 * 2;
                        sVar.c(iArr[((i13 - 1) - i28) - i23], iArr[i28 + i6]);
                    }
                    i6++;
                    i14 = 2;
                }
                i23++;
                i6 = 0;
                i14 = 2;
            }
            i21 += i22 * 8;
            i20++;
            i5 = 4;
            i6 = 0;
            i14 = 2;
        }
        a(sVar, z, i4, rVarA4);
        if (z) {
            a(sVar, i4 / 2, 5);
        } else {
            int i29 = i4 / 2;
            a(sVar, i29, 7);
            int i30 = 0;
            int i31 = 0;
            while (i30 < (i13 / 2) - 1) {
                for (int i32 = i29 & 1; i32 < i4; i32 += 2) {
                    int i33 = i29 - i31;
                    sVar.c(i33, i32);
                    int i34 = i29 + i31;
                    sVar.c(i34, i32);
                    sVar.c(i32, i33);
                    sVar.c(i32, i34);
                }
                i30 += 15;
                i31 += 16;
            }
        }
        f fVar = new f();
        fVar.a(z);
        fVar.c(i4);
        fVar.b(iAbs);
        fVar.a(iE3);
        fVar.a(sVar);
        return fVar;
    }

    private static r b(r rVar, int i, int i2) {
        int iE = rVar.e() / i2;
        u5 u5Var = new u5(a(i2));
        int i3 = i / i2;
        int[] iArrA = a(rVar, i2, i3);
        u5Var.a(iArrA, i3 - iE);
        r rVar2 = new r();
        rVar2.a(0, i % i2);
        for (int i4 : iArrA) {
            rVar2.a(i4, i2);
        }
        return rVar2;
    }

    private static void a(s sVar, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 <= i6) {
                    sVar.c(i5, i4);
                    sVar.c(i5, i6);
                    sVar.c(i4, i5);
                    sVar.c(i6, i5);
                    i5++;
                }
            }
        }
        int i7 = i - i2;
        sVar.c(i7, i7);
        int i8 = i7 + 1;
        sVar.c(i8, i7);
        sVar.c(i7, i8);
        int i9 = i + i2;
        sVar.c(i9, i7);
        sVar.c(i9, i8);
        sVar.c(i9, i9 - 1);
    }

    static r a(boolean z, int i, int i2) {
        r rVar = new r();
        if (z) {
            rVar.a(i - 1, 2);
            rVar.a(i2 - 1, 6);
            return b(rVar, 28, 4);
        }
        rVar.a(i - 1, 5);
        rVar.a(i2 - 1, 11);
        return b(rVar, 40, 4);
    }

    private static void a(s sVar, boolean z, int i, r rVar) {
        int i2 = i / 2;
        int i3 = 0;
        if (z) {
            while (i3 < 7) {
                int i4 = (i2 - 3) + i3;
                if (rVar.b(i3)) {
                    sVar.c(i4, i2 - 5);
                }
                if (rVar.b(i3 + 7)) {
                    sVar.c(i2 + 5, i4);
                }
                if (rVar.b(20 - i3)) {
                    sVar.c(i4, i2 + 5);
                }
                if (rVar.b(27 - i3)) {
                    sVar.c(i2 - 5, i4);
                }
                i3++;
            }
            return;
        }
        while (i3 < 10) {
            int i5 = (i2 - 5) + i3 + (i3 / 5);
            if (rVar.b(i3)) {
                sVar.c(i5, i2 - 7);
            }
            if (rVar.b(i3 + 10)) {
                sVar.c(i2 + 7, i5);
            }
            if (rVar.b(29 - i3)) {
                sVar.c(i5, i2 + 7);
            }
            if (rVar.b(39 - i3)) {
                sVar.c(i2 - 7, i5);
            }
            i3++;
        }
    }

    private static int[] a(r rVar, int i, int i2) {
        int[] iArr = new int[i2];
        int iE = rVar.e() / i;
        for (int i3 = 0; i3 < iE; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4 |= rVar.b((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    private static y2 a(int i) {
        if (i == 4) {
            return y2.k;
        }
        if (i == 6) {
            return y2.j;
        }
        if (i == 8) {
            return y2.n;
        }
        if (i == 10) {
            return y2.i;
        }
        if (i == 12) {
            return y2.h;
        }
        throw new IllegalArgumentException("Unsupported word size " + i);
    }

    static r a(r rVar, int i) {
        r rVar2 = new r();
        int iE = rVar.e();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < iE) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= iE || rVar.b(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 == i2) {
                rVar2.a(i7, i);
            } else {
                if (i7 == 0) {
                    rVar2.a(i4 | 1, i);
                } else {
                    rVar2.a(i4, i);
                }
                i3 += i;
            }
            i3--;
            i3 += i;
        }
        return rVar2;
    }
}
