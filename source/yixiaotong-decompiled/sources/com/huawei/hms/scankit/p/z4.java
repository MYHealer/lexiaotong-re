package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: PDF417ScanningDecoder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class z4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q2 f4387a = new q2();

    public static o1 a(s sVar, y5 y5Var, y5 y5Var2, y5 y5Var3, y5 y5Var4, int i, int i2, Map<f1, ?> map) throws a {
        z zVar = new z(sVar, y5Var, y5Var2, y5Var3, y5Var4);
        t1 t1VarA = null;
        t1 t1VarA2 = null;
        boolean z = true;
        while (true) {
            z zVar2 = zVar;
            if (y5Var != null) {
                t1VarA = a(sVar, zVar2, y5Var, true, i, i2);
            }
            if (y5Var3 != null) {
                t1VarA2 = a(sVar, zVar2, y5Var3, false, i, i2);
            }
            r1 r1VarB = b(t1VarA, t1VarA2);
            if (r1VarB == null) {
                throw a.a();
            }
            zVar = r1VarB.i();
            if (!z || zVar == null || (zVar.f() >= zVar2.f() && zVar.d() <= zVar2.d())) {
                r1VarB.a(zVar2);
                int iF = r1VarB.f() + 1;
                r1VarB.a(0, t1VarA);
                r1VarB.a(iF, t1VarA2);
                a(r1VarB, t1VarA, zVar2, iF, sVar, i, i2);
                return a(r1VarB, map);
            }
            z = false;
        }
    }

    private static boolean a(int i, int i2, int i3) {
        return i2 + (-2) <= i && i <= i3 + 2;
    }

    private static r1 b(t1 t1Var, t1 t1Var2) throws a {
        k kVarA;
        if ((t1Var == null && t1Var2 == null) || (kVarA = a(t1Var, t1Var2)) == null) {
            return null;
        }
        return new r1(kVarA, z.a(a(t1Var), a(t1Var2)));
    }

    private static int c(int i) {
        return 2 << i;
    }

    private static int b(int[] iArr) {
        int iMax = -1;
        for (int i : iArr) {
            iMax = Math.max(iMax, i);
        }
        return iMax;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0013 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x0015  */
    /* JADX WARN: Code duplicated, block: B:28:0x0027 A[EDGE_INSN: B:28:0x0027->B:16:0x0027 BREAK  A[LOOP:0: B:7:0x000c->B:31:0x000c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0022 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x001b A[SYNTHETIC] */
    private static int[] b(s sVar, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        int i6 = 0;
        boolean z2 = z;
        while (true) {
            if (!z) {
                if (i3 < i) {
                    break;
                }
                if (i6 < 8) {
                    break;
                    break;
                }
                if (sVar.b(i3, i4) == z2) {
                    iArr[i6] = iArr[i6] + 1;
                    i3 += i5;
                } else {
                    i6++;
                    z2 = !z2;
                }
            } else {
                if (i3 >= i2) {
                    break;
                }
                if (i6 < 8) {
                    break;
                }
                if (sVar.b(i3, i4) == z2) {
                    iArr[i6] = iArr[i6] + 1;
                    i3 += i5;
                } else {
                    i6++;
                    z2 = !z2;
                }
            }
        }
        if (i6 != 8) {
            if (z) {
                i = i2;
            }
            if (i3 != i || i6 != 7) {
                return null;
            }
        }
        return iArr;
    }

    private static int b(int i) {
        return a(a(i));
    }

    private static void a(r1 r1Var, t1 t1Var, z zVar, int i, s sVar, int i2, int i3) {
        s1 t1Var2;
        int i4;
        int i5;
        int i6;
        int i7;
        s1 s1Var;
        boolean z = t1Var != null;
        int i8 = i2;
        int i9 = i3;
        for (int i10 = 1; i10 <= i; i10++) {
            int i11 = z ? i10 : i - i10;
            if (r1Var.a(i11) == null) {
                if (i11 != 0 && i11 != i) {
                    t1Var2 = new s1(zVar);
                } else {
                    t1Var2 = new t1(zVar, i11 == 0);
                }
                s1 s1Var2 = t1Var2;
                r1Var.a(i11, s1Var2);
                int i12 = -1;
                int i13 = i8;
                int iMax = i9;
                int iF = zVar.f();
                int i14 = -1;
                while (iF <= zVar.d()) {
                    int iA = a(r1Var, i11, iF, z);
                    if (iA < 0 || iA > zVar.c()) {
                        if (i14 == i12) {
                            i5 = iF;
                            i6 = i13;
                            i7 = i12;
                            s1Var = s1Var2;
                        } else {
                            i4 = i14;
                        }
                        i13 = i6;
                        i4 = i14;
                        iF = i5 + 1;
                        s1Var2 = s1Var;
                        i14 = i4;
                        i12 = i7;
                    } else {
                        i4 = iA;
                    }
                    int i15 = iF;
                    int i16 = iMax;
                    int i17 = i13;
                    i7 = i12;
                    s1Var = s1Var2;
                    u0 u0VarA = a(sVar, zVar.e(), zVar.c(), z, i4, i15, i17, i16);
                    i5 = i15;
                    if (u0VarA != null) {
                        s1Var.a(i5, u0VarA);
                        int iMin = Math.min(i17, u0VarA.f());
                        iMax = Math.max(i16, u0VarA.f());
                        i13 = iMin;
                    } else {
                        iMax = i16;
                        i6 = i17;
                        i13 = i6;
                        i4 = i14;
                    }
                    iF = i5 + 1;
                    s1Var2 = s1Var;
                    i14 = i4;
                    i12 = i7;
                }
                i8 = i13;
                i9 = iMax;
            }
        }
    }

    private static z a(t1 t1Var) throws a {
        int[] iArrD;
        if (t1Var == null || (iArrD = t1Var.d()) == null) {
            return null;
        }
        int iB = b(iArrD);
        int i = 0;
        int i2 = 0;
        for (int i3 : iArrD) {
            i2 += iB - i3;
            if (i3 > 0) {
                break;
            }
        }
        u0[] u0VarArrB = t1Var.b();
        for (int i4 = 0; i2 > 0 && u0VarArrB[i4] == null; i4++) {
            i2--;
        }
        for (int length = iArrD.length - 1; length >= 0; length--) {
            int i5 = iArrD[length];
            i += iB - i5;
            if (i5 > 0) {
                break;
            }
        }
        for (int length2 = u0VarArrB.length - 1; i > 0 && u0VarArrB[length2] == null; length2--) {
            i--;
        }
        return t1Var.a().a(i2, i, t1Var.e());
    }

    private static k a(t1 t1Var, t1 t1Var2) throws a {
        k kVarC;
        k kVarC2;
        if (t1Var == null || (kVarC = t1Var.c()) == null) {
            if (t1Var2 == null) {
                return null;
            }
            return t1Var2.c();
        }
        if (t1Var2 == null || (kVarC2 = t1Var2.c()) == null || kVarC.a() == kVarC2.a() || kVarC.b() == kVarC2.b() || kVarC.c() == kVarC2.c()) {
            return kVarC;
        }
        return null;
    }

    private static t1 a(s sVar, z zVar, y5 y5Var, boolean z, int i, int i2) {
        int iB;
        t1 t1Var = new t1(zVar, z);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int iB2 = (int) y5Var.b();
            for (int iC = (int) y5Var.c(); iC <= zVar.d() && iC >= zVar.f(); iC += i4) {
                u0 u0VarA = a(sVar, 0, sVar.e(), z, iB2, iC, i, i2);
                if (u0VarA != null) {
                    t1Var.a(iC, u0VarA);
                    if (z) {
                        iB = u0VarA.d();
                    } else {
                        iB = u0VarA.b();
                    }
                    iB2 = iB;
                }
            }
            i3++;
        }
        return t1Var;
    }

    private static void a(r1 r1Var, m[][] mVarArr) throws a {
        m mVar = mVarArr[0][1];
        int[] iArrA = mVar.a();
        int iF = (r1Var.f() * r1Var.h()) - c(r1Var.g());
        if (iArrA.length != 0) {
            if (iArrA[0] != iF) {
                mVar.a(iF);
            }
        } else {
            if (iF >= 1 && iF <= 928) {
                mVar.a(iF);
                return;
            }
            throw a.a();
        }
    }

    private static o1 a(r1 r1Var, Map<f1, ?> map) throws a {
        m[][] mVarArrA = a(r1Var);
        a(r1Var, mVarArrA);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[r1Var.h() * r1Var.f()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < r1Var.h(); i++) {
            int i2 = 0;
            while (i2 < r1Var.f()) {
                int i3 = i2 + 1;
                int[] iArrA = mVarArrA[i][i3].a();
                int iF = (r1Var.f() * i) + i2;
                if (iArrA.length == 0) {
                    arrayList.add(Integer.valueOf(iF));
                } else if (iArrA.length == 1) {
                    iArr[iF] = iArrA[0];
                } else {
                    arrayList3.add(Integer.valueOf(iF));
                    arrayList2.add(iArrA);
                }
                i2 = i3;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i4 = 0; i4 < size; i4++) {
            iArr2[i4] = (int[]) arrayList2.get(i4);
        }
        return a(r1Var.g(), iArr, t4.a(arrayList), t4.a(arrayList3), iArr2, map);
    }

    private static o1 a(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4, Map<f1, ?> map) throws a {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                for (int i4 = 0; i4 < length; i4++) {
                    iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
                }
                try {
                    return a(iArr, i, iArr2, map);
                } catch (a unused) {
                    if (length == 0) {
                        throw a.a();
                    }
                    for (int i5 = 0; i5 < length; i5++) {
                        int i6 = iArr5[i5];
                        if (i6 < iArr4[i5].length - 1) {
                            iArr5[i5] = i6 + 1;
                            break;
                        }
                        iArr5[i5] = 0;
                        if (i5 == length - 1) {
                            throw a.a();
                        }
                    }
                    i2 = i3;
                }
            } else {
                throw a.a();
            }
        }
    }

    private static m[][] a(r1 r1Var) throws a {
        int iC;
        m[][] mVarArr = (m[][]) Array.newInstance((Class<?>) m.class, r1Var.h(), r1Var.f() + 2);
        for (m[] mVarArr2 : mVarArr) {
            int i = 0;
            while (true) {
                if (i < mVarArr2.length) {
                    mVarArr2[i] = new m();
                    i++;
                }
            }
        }
        int i2 = 0;
        for (s1 s1Var : r1Var.j()) {
            if (s1Var != null) {
                for (u0 u0Var : s1Var.b()) {
                    if (u0Var != null && (iC = u0Var.c()) >= 0 && iC < mVarArr.length) {
                        mVarArr[iC][i2].a(u0Var.e());
                    }
                }
            }
            i2++;
        }
        return mVarArr;
    }

    private static boolean a(r1 r1Var, int i) {
        return i >= 0 && i <= r1Var.f() + 1;
    }

    private static int a(r1 r1Var, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        int i4 = i - i3;
        u0 u0VarA = a(r1Var, i4) ? r1Var.a(i4).a(i2) : null;
        if (u0VarA != null) {
            return z ? u0VarA.b() : u0VarA.d();
        }
        u0 u0VarB = r1Var.a(i).b(i2);
        if (u0VarB != null) {
            return z ? u0VarB.d() : u0VarB.b();
        }
        if (a(r1Var, i4)) {
            u0VarB = r1Var.a(i4).b(i2);
        }
        if (u0VarB != null) {
            return z ? u0VarB.b() : u0VarB.d();
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (!a(r1Var, i)) {
                return z ? r1Var.i().e() : r1Var.i().c();
            }
            for (u0 u0Var : r1Var.a(i).b()) {
                if (u0Var != null) {
                    return (z ? u0Var.b() : u0Var.d()) + (i3 * i5 * (u0Var.b() - u0Var.d()));
                }
            }
            i5++;
        }
    }

    private static u0 a(s sVar, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int iD;
        int iA;
        int iA2 = a(sVar, i, i2, z, i3, i4);
        int[] iArrB = b(sVar, i, i2, z, iA2, i4);
        if (iArrB == null) {
            return null;
        }
        int iA3 = b4.a(iArrB);
        if (z) {
            i7 = iA2 + iA3;
        } else {
            for (int i8 = 0; i8 < iArrB.length / 2; i8++) {
                int i9 = iArrB[i8];
                iArrB[i8] = iArrB[(iArrB.length - 1) - i8];
                iArrB[(iArrB.length - 1) - i8] = i9;
            }
            iA2 -= iA3;
            i7 = iA2;
        }
        if (a(iA3, i5, i6) && (iA = t4.a((iD = s4.d(iArrB)))) != -1) {
            return new u0(iA2, i7, b(iD), iA);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0011  */
    /* JADX WARN: Code duplicated, block: B:14:0x0017  */
    /* JADX WARN: Code duplicated, block: B:17:0x0020 A[LOOP:1: B:8:0x000a->B:17:0x0020, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x001f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0022 A[EDGE_INSN: B:24:0x0022->B:18:0x0022 BREAK  A[LOOP:1: B:8:0x000a->B:17:0x0020], SYNTHETIC] */
    private static int a(s sVar, int i, int i2, boolean z, int i3, int i4) {
        int i5 = z ? -1 : 1;
        int i6 = i3;
        for (int i7 = 0; i7 < 2; i7++) {
            while (true) {
                if (!z) {
                    if (i6 >= i2) {
                        break;
                    }
                    if (z == sVar.b(i6, i4)) {
                        break;
                        break;
                    }
                    if (Math.abs(i3 - i6) > 2) {
                        return i3;
                    }
                    i6 += i5;
                } else {
                    if (i6 < i) {
                        break;
                    }
                    if (z == sVar.b(i6, i4)) {
                        break;
                    }
                    if (Math.abs(i3 - i6) > 2) {
                        return i3;
                    }
                    i6 += i5;
                }
            }
            i5 = -i5;
            z = !z;
        }
        return i6;
    }

    private static o1 a(int[] iArr, int i, int[] iArr2, Map<f1, ?> map) throws a {
        if (iArr.length != 0) {
            int i2 = 1 << (i + 1);
            int iA = a(iArr, iArr2, i2);
            a(iArr, i2);
            o1 o1VarA = j1.a(iArr, String.valueOf(i), map);
            o1VarA.b(Integer.valueOf(iA));
            o1VarA.a(Integer.valueOf(iArr2.length));
            return o1VarA;
        }
        throw a.a();
    }

    private static int a(int[] iArr, int[] iArr2, int i) throws a {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return f4387a.a(iArr, i, iArr2);
        }
        throw a.a();
    }

    private static void a(int[] iArr, int i) throws a {
        if (iArr.length >= 4) {
            int i2 = iArr[0];
            if (i2 > iArr.length) {
                throw a.a();
            }
            if (i2 == 0) {
                if (i < iArr.length) {
                    iArr[0] = iArr.length - i;
                    return;
                }
                throw a.a();
            }
            return;
        }
        throw a.a();
    }

    private static int[] a(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    private static int a(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }
}
