package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f4365a = {0, 4, 1, 5};
    private static final int[] b = {6, 2, 7, 3};
    private static final int[] c = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] d = {7, 1, 1, 3, 1, 1, 1, 2, 1};
    private static boolean e;

    public static u4 a(p pVar, Map<f1, ?> map, boolean z) throws a {
        s sVarB = pVar.b();
        a(false);
        List<y5[]> listA = a(z, sVarB);
        if (listA.isEmpty()) {
            sVarB = sVarB.clone();
            sVarB.f();
            listA = a(z, sVarB);
            a(true);
        }
        return new u4(sVarB, listA);
    }

    public static void a(boolean z) {
        e = z;
    }

    public static boolean a() {
        return e;
    }

    private static List<y5[]> a(boolean z, s sVar) {
        int iB;
        float fC;
        ArrayList<y5[]> arrayList = new ArrayList();
        int iMax = 0;
        int i = 0;
        loop0: while (true) {
            int i2 = i;
            while (iMax < sVar.c()) {
                y5[] y5VarArrA = a(sVar, iMax, i);
                if (y5VarArrA[0] == null && y5VarArrA[3] == null) {
                    if (i2 == 0) {
                        break;
                    }
                    for (y5[] y5VarArr : arrayList) {
                        y5 y5Var = y5VarArr[1];
                        if (y5Var != null) {
                            iMax = (int) Math.max(iMax, y5Var.c());
                        }
                        y5 y5Var2 = y5VarArr[3];
                        if (y5Var2 != null) {
                            iMax = Math.max(iMax, (int) y5Var2.c());
                        }
                    }
                    iMax += 5;
                    i = 0;
                } else {
                    arrayList.add(y5VarArrA);
                    if (!z) {
                        break loop0;
                    }
                    y5 y5Var3 = y5VarArrA[2];
                    if (y5Var3 != null) {
                        iB = (int) y5Var3.b();
                        fC = y5VarArrA[2].c();
                    } else {
                        iB = (int) y5VarArrA[4].b();
                        fC = y5VarArrA[4].c();
                    }
                    iMax = (int) fC;
                    i = iB;
                    i2 = 1;
                }
            }
            break loop0;
        }
        return arrayList;
    }

    private static y5[] a(s sVar, int i, int i2) {
        int iC = sVar.c();
        int iE = sVar.e();
        y5[] y5VarArr = new y5[8];
        a(y5VarArr, a(sVar, iC, iE, i, i2, c), f4365a);
        y5 y5Var = y5VarArr[4];
        if (y5Var != null) {
            i2 = (int) y5Var.b();
            i = (int) y5VarArr[4].c();
        }
        a(y5VarArr, a(sVar, iC, iE, i, i2, d), b);
        return y5VarArr;
    }

    private static void a(y5[] y5VarArr, y5[] y5VarArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            y5VarArr[iArr[i]] = y5VarArr2[i];
        }
    }

    private static y5[] a(s sVar, int i, int i2, int i3, int i4, int[] iArr) {
        boolean z;
        int i5;
        y5[] y5VarArr = new y5[4];
        int[] iArr2 = new int[iArr.length];
        int i6 = i3;
        while (true) {
            if (i6 >= i) {
                z = false;
                break;
            }
            int[] iArrA = a(sVar, i4, i6, i2, false, iArr, iArr2);
            if (iArrA != null) {
                int i7 = i6;
                int[] iArr3 = iArrA;
                while (i7 > 0) {
                    int i8 = i7 - 1;
                    int[] iArrA2 = a(sVar, i4, i8, i2, false, iArr, iArr2);
                    if (iArrA2 == null) {
                        break;
                    }
                    iArr3 = iArrA2;
                    i7 = i8;
                }
                float f = i7;
                y5VarArr[0] = new y5(iArr3[0], f);
                y5VarArr[1] = new y5(iArr3[1], f);
                z = true;
                i6 = i7;
                break;
            }
            i6 += 5;
        }
        int i9 = i6 + 1;
        if (z) {
            int[] iArr4 = {(int) y5VarArr[0].b(), (int) y5VarArr[1].b()};
            int i10 = i9;
            int i11 = 0;
            while (true) {
                if (i10 >= i) {
                    i5 = i11;
                    break;
                }
                int i12 = i11;
                int[] iArrA3 = a(sVar, iArr4[0], i10, i2, false, iArr, iArr2);
                if (iArrA3 == null || Math.abs(iArr4[0] - iArrA3[0]) >= 5 || Math.abs(iArr4[1] - iArrA3[1]) >= 5) {
                    i5 = i12;
                    if (i5 > 25) {
                        break;
                    }
                    i11 = i5 + 1;
                } else {
                    iArr4 = iArrA3;
                    i11 = 0;
                }
                i10++;
            }
            i9 = i10 - (i5 + 1);
            float f2 = i9;
            y5VarArr[2] = new y5(iArr4[0], f2);
            y5VarArr[3] = new y5(iArr4[1], f2);
        }
        if (i9 - i6 < 10) {
            Arrays.fill(y5VarArr, (Object) null);
        }
        return y5VarArr;
    }

    private static int[] a(s sVar, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (sVar.b(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int length = iArr.length;
        boolean z2 = z;
        int i6 = 0;
        int i7 = i;
        while (i < i3) {
            if (sVar.b(i, i2) != z2) {
                iArr2[i6] = iArr2[i6] + 1;
            } else {
                if (i6 != length - 1) {
                    i6++;
                } else {
                    if (a(iArr2, iArr, 0.8f) < 0.42f) {
                        return new int[]{i7, i};
                    }
                    i7 += iArr2[0] + iArr2[1];
                    int i8 = i6 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i8);
                    iArr2[i8] = 0;
                    iArr2[i6] = 0;
                    i6--;
                }
                iArr2[i6] = 1;
                z2 = !z2;
            }
            i++;
        }
        if (i6 != length - 1 || a(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i7, i - 1};
    }

    private static float a(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = iArr2[i4] * f3;
            float f7 = i5;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }
}
