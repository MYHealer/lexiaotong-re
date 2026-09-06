package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.Map;

/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f4372a;
    private z5 b;

    public x1(s sVar) {
        this.f4372a = sVar;
    }

    private static i5 a(y5 y5Var, y5 y5Var2, y5 y5Var3, y5 y5Var4, y5 y5Var5, int i) {
        float fB;
        float fC;
        float fB2;
        float fC2;
        float f = i - 3.5f;
        if (y5Var4 != null) {
            float fB3 = y5Var4.b();
            fB = fB3;
            fC = y5Var4.c();
            fB2 = y5Var5.b();
            fC2 = y5Var5.c();
        } else {
            fB = (y5Var2.b() - y5Var.b()) + y5Var3.b();
            fC = (y5Var2.c() - y5Var.c()) + y5Var3.c();
            fB2 = f;
            fC2 = fB2;
        }
        return i5.a(3.5f, 3.5f, f, 3.5f, fB2, fC2, 3.5f, f, y5Var.b(), y5Var.c(), y5Var2.b(), y5Var2.c(), fB, fC, y5Var3.b(), y5Var3.c());
    }

    private float b(int i, int i2, int i3, int i4) {
        float fE;
        float fC;
        float fA = a(i, i2, i3, i4);
        int iE = i - (i3 - i);
        int iC = 0;
        if (iE < 0) {
            fE = i / (i - iE);
            iE = 0;
        } else if (iE >= this.f4372a.e()) {
            fE = ((this.f4372a.e() - 1) - i) / (iE - i);
            iE = this.f4372a.e() - 1;
        } else {
            fE = 1.0f;
        }
        float f = i2;
        int i5 = (int) (f - ((i4 - i2) * fE));
        if (i5 < 0) {
            fC = f / (i2 - i5);
        } else if (i5 >= this.f4372a.c()) {
            fC = ((this.f4372a.c() - 1) - i2) / (i5 - i2);
            iC = this.f4372a.c() - 1;
        } else {
            iC = i5;
            fC = 1.0f;
        }
        float fA2 = a(i, i2, (int) (i + ((iE - i) * fC)), iC);
        if (Math.max(fA, fA2) > ((double) Math.min(fA, fA2)) * 1.5d) {
            return Float.NaN;
        }
        return (fA + fA2) - 1.0f;
    }

    private static s a(s sVar, i5 i5Var, int i) throws a {
        return c3.a().a(sVar, i, i, i5Var, true);
    }

    private static int a(y5 y5Var, y5 y5Var2, y5 y5Var3, float f) throws a {
        int iA;
        try {
            iA = ((b4.a(y5.a(y5Var, y5Var2) / f) + b4.a(y5.a(y5Var, y5Var3) / f)) / 2) + 7;
            int i = iA & 3;
            if (i != 0) {
                if (i != 2) {
                    if (i != 3) {
                        return iA;
                    }
                    throw a.a();
                }
                return iA - 1;
            }
        } catch (a unused) {
            int iA2 = (((int) (y5.a(y5Var, y5Var2) / f)) + ((int) (y5.a(y5Var, y5Var3) / f))) / 2;
            iA = iA2 + 7;
            int i2 = iA & 3;
            if (i2 != 0) {
                if (i2 != 2) {
                    return i2 != 3 ? iA : iA2 + 9;
                }
            }
            return iA + 1;
        }
        return iA + 1;
    }

    public final z1 a(Map<f1, ?> map) throws a {
        this.b = map == null ? null : (z5) map.get(f1.NEED_RESULT_POINT_CALLBACK);
        return a(new u2(this.f4372a, this.b).b());
    }

    protected final z1 a(v2 v2Var) throws a {
        t2 t2VarB = v2Var.b();
        t2 t2VarC = v2Var.c();
        t2 t2VarA = v2Var.a();
        try {
            float fA = a(t2VarB, t2VarC, t2VarA);
            if (fA >= 1.0f) {
                return a(t2VarB, t2VarC, t2VarA, fA);
            }
            throw a.a();
        } catch (a unused) {
            float fE = ((t2VarB.e() + t2VarC.e()) + t2VarA.e()) / 3.0f;
            if (fE >= 1.0f) {
                return a(t2VarB, t2VarC, t2VarA, fE);
            }
            throw a.a();
        }
    }

    private z1 a(t2 t2Var, t2 t2Var2, t2 t2Var3, float f) throws a {
        d[] dVarArr;
        int iA;
        int iA2 = a((y5) t2Var, (y5) t2Var2, (y5) t2Var3, f);
        b3.s.push(Integer.valueOf(iA2));
        c7 c7VarB = c7.b(iA2);
        if (b3.o && b3.c) {
            return a(t2Var, t2Var2, t2Var3, f, iA2);
        }
        int iD = c7VarB.d() - 7;
        int length = c7VarB.c().length;
        int i = length * length;
        d[] dVarArr2 = new d[i];
        d[] dVarArr3 = new d[i];
        d[] dVarArr4 = new d[2];
        if (c7VarB.c().length > 0) {
            dVarArr = dVarArr4;
            iA = a(t2Var, t2Var2, t2Var3, f, iA2, c7VarB, dVarArr2, dVarArr3, length, iD, dVarArr);
        } else {
            dVarArr = dVarArr4;
            iA = 0;
        }
        d dVar = dVarArr[0];
        i5 i5VarA = a(t2Var, t2Var2, t2Var3, dVar, dVarArr[1], iA2);
        if (b3.l && b3.i) {
            a(i5VarA, length, iA2, t2Var, t2Var2, t2Var3, dVarArr2, iA, dVarArr3);
        }
        s sVarA = a(this.f4372a, i5VarA, iA2);
        y5[] y5VarArr = dVar == null ? new y5[]{t2Var3, t2Var, t2Var2} : new y5[]{t2Var3, t2Var, t2Var2, dVar};
        float f2 = iA2;
        float[] fArr = {0.0f, 0.0f, f2, 0.0f, f2, f2, 0.0f, f2};
        i5VarA.a(fArr);
        return new z1(sVarA, y5VarArr, new y5[]{a(new y5(fArr[6], fArr[7])), a(new y5(fArr[0], fArr[1], t2Var.d())), a(new y5(fArr[r8], fArr[3], t2Var2.d())), a(new y5(fArr[4], fArr[5], t2Var3.d()))}, f);
    }

    private int a(t2 t2Var, t2 t2Var2, t2 t2Var3, float f, int i, c7 c7Var, d[] dVarArr, d[] dVarArr2, int i2, int i3, d[] dVarArr3) {
        int i4;
        int i5;
        float fB = (t2Var2.b() - t2Var.b()) + t2Var3.b();
        float fC = (t2Var2.c() - t2Var.c()) + t2Var3.c();
        float f2 = i3;
        float f3 = 3.0f / f2;
        float f4 = 1.0f - f3;
        int iB = (int) (t2Var.b() + ((fB - t2Var.b()) * f4));
        int iC = (int) (t2Var.c() + (f4 * (fC - t2Var.c())));
        if (b3.r[0] && i3 == 22) {
            i5 = 8;
            i4 = 2;
        } else {
            i4 = 4;
            i5 = 16;
        }
        for (int i6 = i4; i6 <= i5; i6 <<= 1) {
            try {
                dVarArr3[0] = a(f, iB, iC, i6);
                break;
            } catch (a unused) {
            }
        }
        float f5 = i - 6.5f;
        dVarArr3[1] = new d(f5, f5, t2Var3.e());
        d dVar = dVarArr3[0];
        if (dVar != null && b4.a(iB, iC, dVar.b(), dVarArr3[0].c()) > f * 4.0f) {
            dVarArr3[0] = null;
        }
        if (dVarArr3[0] == null && i2 > 2) {
            int i7 = i2 - 2;
            dVarArr3[1] = new d(c7Var.c()[i7] + 0.5f, f5, t2Var3.e());
            int iC2 = (int) (t2Var3.c() - (f3 * (t2Var3.c() - t2Var.c())));
            int iB2 = (int) ((((c7Var.c()[i7] - 3.0f) / f2) * (t2Var2.b() - t2Var.b())) + t2Var3.b());
            while (i4 <= i5) {
                try {
                    dVarArr3[0] = a(f, iB2, iC2, i4);
                    break;
                } catch (a unused2) {
                    i4 <<= 1;
                }
            }
            d dVar2 = dVarArr3[0];
            if (dVar2 != null && b4.a(iB2, iC2, dVar2.b(), dVarArr3[0].c()) > f * 4.0f) {
                dVarArr3[0] = null;
            }
        }
        if (b3.l && b3.i) {
            return a(c7Var, i3, t2Var2, t2Var, t2Var3, f, i2, 0, dVarArr, dVarArr2);
        }
        return 0;
    }

    private int a(c7 c7Var, int i, t2 t2Var, t2 t2Var2, t2 t2Var3, float f, int i2, int i3, d[] dVarArr, d[] dVarArr2) {
        int i4;
        int i5;
        int i6;
        float f2;
        int i7 = i3;
        int i8 = 0;
        while (i8 < i2) {
            if (i8 == 0) {
                i4 = i2 - 1;
                i5 = 1;
            } else {
                i4 = i2;
                i5 = 0;
            }
            int i9 = i8 != i2 + (-1) ? i5 : 1;
            float f3 = 3.0f;
            float f4 = i;
            float fB = (((c7Var.c()[i8] - 3.0f) * (t2Var.b() - t2Var2.b())) / f4) + t2Var2.b();
            float fC = (((c7Var.c()[i8] - 3.0f) * (t2Var.c() - t2Var2.c())) / f4) + t2Var2.c();
            while (i9 < i4) {
                int iC = (int) (fC - (((c7Var.c()[i9] - f3) * (t2Var2.c() - t2Var3.c())) / f4));
                int iB = (int) (fB - (((c7Var.c()[i9] - f3) * (t2Var2.b() - t2Var3.b())) / f4));
                int i10 = 4;
                int i11 = 4;
                while (true) {
                    if (i11 > i10) {
                        i6 = i4;
                        f2 = fB;
                        break;
                    }
                    int i12 = (i8 * i2) + i9;
                    try {
                        dVarArr[i12] = a(f, iB, iC, i11);
                        i6 = i4;
                        try {
                            f2 = fB;
                            try {
                                dVarArr2[i12] = new d(c7Var.c()[i8] + 0.5f, c7Var.c()[i9] + 0.5f, t2Var3.e());
                                i7++;
                                break;
                            } catch (a unused) {
                                continue;
                                i11 <<= 1;
                                i2 = i2;
                                fB = f2;
                                i4 = i6;
                                i10 = 4;
                            }
                        } catch (a unused2) {
                            f2 = fB;
                        }
                    } catch (a unused3) {
                        i6 = i4;
                    }
                    i11 <<= 1;
                    i2 = i2;
                    fB = f2;
                    i4 = i6;
                    i10 = 4;
                }
                i9++;
                i2 = i2;
                fB = f2;
                i4 = i6;
                f3 = 3.0f;
            }
            i8++;
        }
        return i7;
    }

    private void a(i5 i5Var, int i, int i2, t2 t2Var, t2 t2Var2, t2 t2Var3, d[] dVarArr, int i3, d[] dVarArr2) {
        int i4 = i3 + 3;
        int i5 = i4 * 2;
        float[] fArr = new float[i5];
        float[] fArr2 = new float[i5];
        fArr[0] = t2Var.b();
        fArr[1] = t2Var.c();
        fArr[2] = t2Var2.b();
        fArr[3] = t2Var2.c();
        fArr[4] = t2Var3.b();
        fArr[5] = t2Var3.c();
        fArr2[0] = 3.5f;
        fArr2[1] = 3.5f;
        float f = i2 - 3.5f;
        fArr2[2] = f;
        fArr2[3] = 3.5f;
        fArr2[4] = 3.5f;
        fArr2[5] = f;
        int i6 = 6;
        int i7 = 6;
        for (int i8 = 0; i8 < i * i; i8++) {
            d dVar = dVarArr[i8];
            if (dVar != null) {
                int i9 = i7 + 1;
                fArr[i7] = dVar.b();
                i7 += 2;
                fArr[i9] = dVarArr[i8].c();
                int i10 = i6 + 1;
                fArr2[i6] = dVarArr2[i8].b();
                i6 += 2;
                fArr2[i10] = dVarArr2[i8].c();
            }
        }
        float[] fArrQuadFitting = LoadOpencvJNIUtil.QuadFitting(fArr2, i4, fArr);
        if (fArrQuadFitting.length != 0) {
            i5Var.a(fArrQuadFitting[0], fArrQuadFitting[1], fArrQuadFitting[2], fArrQuadFitting[3], fArrQuadFitting[4], fArrQuadFitting[5], fArrQuadFitting[6], fArrQuadFitting[7], fArrQuadFitting[8], fArrQuadFitting[9], fArrQuadFitting[10], fArrQuadFitting[11], fArrQuadFitting[12], fArrQuadFitting[13]);
        }
    }

    private z1 a(t2 t2Var, t2 t2Var2, t2 t2Var3, float f, int i) {
        s sVar = new s(i, i);
        float f2 = i;
        float fC = this.f4372a.c() / f2;
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                double d = ((double) fC) * 0.5d;
                int i4 = (int) (((double) (i3 * fC)) + d);
                int i5 = (int) (((double) (i2 * fC)) + d);
                if (i4 >= -1 && i4 <= this.f4372a.e() && i5 >= -1 && i5 <= this.f4372a.c()) {
                    if (this.f4372a.b(i4, i5)) {
                        sVar.c(i3, i2);
                    }
                } else {
                    sVar.c(i3, i2);
                }
            }
        }
        y5[] y5VarArr = {t2Var3, t2Var, t2Var2};
        float[] fArr = {0.0f, 0.0f, f2, 0.0f, f2, f2, 0.0f, f2};
        a(t2Var, t2Var2, t2Var3, null, null, i).a(fArr);
        return new z1(sVar, y5VarArr, new y5[]{a(new y5(fArr[6], fArr[7])), a(new y5(fArr[0], fArr[1])), a(new y5(fArr[2], fArr[3])), a(new y5(fArr[4], fArr[5]))}, f);
    }

    protected final float a(y5 y5Var, y5 y5Var2, y5 y5Var3) {
        return (a(y5Var, y5Var2) + a(y5Var, y5Var3)) / 2.0f;
    }

    private float a(y5 y5Var, y5 y5Var2) {
        float fB = b((int) y5Var.b(), (int) y5Var.c(), (int) y5Var2.b(), (int) y5Var2.c());
        float fB2 = b((int) y5Var2.b(), (int) y5Var2.c(), (int) y5Var.b(), (int) y5Var.c());
        if (Float.isNaN(fB)) {
            return fB2 / 7.0f;
        }
        return Float.isNaN(fB2) ? fB / 7.0f : (fB + fB2) / 14.0f;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0088  */
    /* JADX WARN: Code duplicated, block: B:43:0x008f A[RETURN] */
    private float a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = 1;
        boolean z = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z) {
            i6 = i;
            i5 = i2;
            i8 = i3;
            i7 = i4;
        } else {
            i5 = i;
            i6 = i2;
            i7 = i3;
            i8 = i4;
        }
        int iAbs = Math.abs(i7 - i5);
        int iAbs2 = Math.abs(i8 - i6);
        int i11 = 2;
        int i12 = (-iAbs) / 2;
        int i13 = i5 < i7 ? 1 : -1;
        int i14 = i6 < i8 ? 1 : -1;
        int i15 = i7 + i13;
        int i16 = i5;
        int i17 = i6;
        int i18 = 0;
        while (i16 != i15) {
            if ((i18 == i10 ? i10 : 0) == this.f4372a.b(z ? i17 : i16, z ? i16 : i17)) {
                if (i18 == 2) {
                    return b4.a(i16, i17, i5, i6);
                }
                i18++;
            }
            i12 += iAbs2;
            if (i12 > 0) {
                if (i17 == i8) {
                    i9 = 2;
                    if (i18 == i9) {
                        return b4.a(i15, i8, i5, i6);
                    }
                    return Float.NaN;
                }
                i17 += i14;
                i12 -= iAbs;
            }
            i16 += i13;
            i15 = i15;
            z = z;
            i10 = 1;
            i11 = 2;
        }
        i15 = i15;
        i9 = i11;
        if (i18 == i9) {
            return b4.a(i15, i8, i5, i6);
        }
        return Float.NaN;
    }

    protected final d a(float f, int i, int i2, float f2) throws a {
        int i3 = (int) (f2 * f);
        int iMax = Math.max(0, i - i3);
        int iMin = Math.min(this.f4372a.e() - 1, i + i3) - iMax;
        float f3 = 3.0f * f;
        if (iMin >= f3) {
            int iMax2 = Math.max(0, i2 - i3);
            int iMin2 = Math.min(this.f4372a.c() - 1, i2 + i3) - iMax2;
            if (iMin2 >= f3) {
                return new e(this.f4372a, iMax, iMax2, iMin, iMin2, f, this.b).a();
            }
            throw a.a();
        }
        throw a.a();
    }

    private y5 a(y5 y5Var) {
        float fB = y5Var.b();
        float fC = y5Var.c();
        int iE = this.f4372a.e() - 1;
        int iC = this.f4372a.c() - 1;
        if (fB < 0.0f) {
            fB = 0.0f;
        }
        float f = iE;
        if (fB > f) {
            fB = f;
        }
        if (fC < 0.0f) {
            fC = 0.0f;
        }
        float f2 = iC;
        if (fC > f2) {
            fC = f2;
        }
        return new y5(fB, fC, y5Var.d());
    }
}
