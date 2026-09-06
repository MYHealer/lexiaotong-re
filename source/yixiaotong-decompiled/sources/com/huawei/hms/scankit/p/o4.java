package com.huawei.hms.scankit.p;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: OneDReader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class o4 implements s5 {
    private w5 b(p pVar, Map<f1, ?> map) throws a {
        int iE = pVar.e();
        int iC = pVar.c();
        r rVar = new r(iE);
        int iMax = Math.max(1, iC >> 5);
        int iIntValue = iC / 2;
        if (map != null) {
            f1 f1Var = f1.PHOTO_MODE_NUM;
            if (map.containsKey(f1Var)) {
                iIntValue += (((Integer) map.get(f1Var)).intValue() * iMax) / 3;
            }
        }
        int i = iIntValue;
        int i2 = 0;
        while (i2 < 15) {
            int i3 = i2 + 1;
            int i4 = i3 / 2;
            if ((i2 & 1) != 0) {
                i4 = -i4;
            }
            int i5 = i + (i4 * iMax);
            if (i5 < 0 || i5 >= iC) {
                break;
            }
            w5 w5VarA = a(pVar, rVar, map, i5, iE);
            if (w5VarA != null && w5VarA.k() != null) {
                return w5VarA;
            }
            i2 = i3;
        }
        throw a.a();
    }

    public abstract w5 a(int i, r rVar, Map<f1, ?> map) throws a;

    @Override // com.huawei.hms.scankit.p.s5
    public w5 a(p pVar, Map<f1, ?> map) throws a {
        return b(pVar, map);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x002f  */
    /* JADX WARN: Code duplicated, block: B:22:0x0033  */
    /* JADX WARN: Code duplicated, block: B:23:0x0035  */
    /* JADX WARN: Code duplicated, block: B:40:0x0048 A[SYNTHETIC] */
    private w5 a(p pVar, r rVar, Map<f1, ?> map, int i, int i2) throws a {
        int i3;
        w5 w5VarA;
        int i4 = 0;
        while (true) {
            int i5 = 3;
            if (i4 >= 3) {
                return null;
            }
            if (i4 == 0) {
                try {
                    rVar = pVar.a(i, rVar);
                    if (a(rVar.d())) {
                        if (b3.c) {
                            i3 = i5;
                        } else {
                            i3 = 1;
                        }
                        w5VarA = a(rVar, i3, map, i, i2);
                        if (w5VarA != null && w5VarA.k() != null) {
                            return w5VarA;
                        }
                    } else {
                        continue;
                    }
                } catch (a unused) {
                    continue;
                }
            } else {
                if (i4 == 1) {
                    rVar = pVar.b().a(i, rVar);
                    i5 = 1;
                } else if (i4 == 2) {
                    if (b3.p) {
                        rVar = pVar.a(i, 1);
                    } else {
                        continue;
                    }
                }
                if (a(rVar.d())) {
                    if (b3.c) {
                        i3 = 1;
                    } else {
                        i3 = i5;
                    }
                    w5VarA = a(rVar, i3, map, i, i2);
                    if (w5VarA != null) {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            i4++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0045  */
    private w5 a(r rVar, int i, Map<f1, ?> map, int i2, int i3) {
        y5[] y5VarArrJ;
        Map<f1, ?> map2 = map;
        for (int i4 = 0; i4 < i; i4++) {
            if (i4 == 0) {
                rVar.c();
            }
            if (i4 == 1) {
                rVar.i();
            }
            if (i4 == 2) {
                rVar.g();
                rVar.j();
            }
            int i5 = 0;
            for (int i6 = 2; i5 < i6; i6 = 2) {
                if (i5 == 1) {
                    rVar.h();
                    if (map2 != null) {
                        f1 f1Var = f1.NEED_RESULT_POINT_CALLBACK;
                        if (map2.containsKey(f1Var)) {
                            EnumMap enumMap = new EnumMap(f1.class);
                            enumMap.putAll(map2);
                            enumMap.remove(f1Var);
                            map2 = enumMap;
                        }
                    }
                }
                try {
                    w5 w5VarA = a(i2, rVar, map2);
                    if (i5 == 1 && (y5VarArrJ = w5VarA.j()) != null) {
                        float f = i3;
                        y5VarArrJ[0] = new y5((f - y5VarArrJ[0].b()) - 1.0f, y5VarArrJ[0].c());
                        y5VarArrJ[1] = new y5((f - y5VarArrJ[1].b()) - 1.0f, y5VarArrJ[1].c());
                    }
                    if (a(w5VarA, i3)) {
                        return w5VarA;
                    }
                    i5++;
                } catch (a unused) {
                    if (i5 == 1) {
                        rVar.h();
                    }
                }
            }
        }
        return null;
    }

    private static boolean a(int[] iArr) {
        int iBitCount = 0;
        int i = 0;
        for (int i2 = 0; i2 < iArr.length && iBitCount < 20; i2++) {
            int i3 = iArr[i2];
            iBitCount += Integer.bitCount((i | (i3 << 1)) ^ i3);
            i = (iArr[i2] >> 31) & 1;
        }
        return iBitCount >= 20;
    }

    private static boolean a(w5 w5Var, int i) {
        y5[] y5VarArrJ = w5Var.j();
        return Math.abs(((double) y5VarArrJ[1].b()) - ((double) y5VarArrJ[0].b())) / ((double) i) > 0.4d;
    }

    protected static void a(r rVar, int i, int[] iArr) throws a {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int iE = rVar.e();
        if (i < iE) {
            boolean z = !rVar.b(i);
            while (i < iE) {
                if (rVar.b(i) == z) {
                    i2++;
                    if (i2 == length) {
                        break;
                    }
                    if (i2 >= 0 && i2 < iArr.length) {
                        iArr[i2] = 1;
                        z = !z;
                    } else {
                        throw a.a();
                    }
                } else if (i2 >= 0 && i2 < iArr.length) {
                    iArr[i2] = iArr[i2] + 1;
                } else {
                    throw a.a();
                }
                i++;
            }
            if (i2 != length) {
                if (i2 != length - 1 || i != iE) {
                    throw a.a();
                }
                return;
            }
            return;
        }
        throw a.a();
    }

    protected static float a(int[] iArr, int[] iArr2, float f) {
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
