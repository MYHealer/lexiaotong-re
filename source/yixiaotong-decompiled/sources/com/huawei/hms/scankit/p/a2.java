package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.List;

/* JADX INFO: compiled from: DetectorRotate.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static l4 f4212a;
    private static p b;

    public static List<y1> a(boolean z, p pVar, int i, boolean z2) {
        int iE = pVar.e();
        int iC = pVar.c();
        byte[] bArrB = pVar.a().c().b();
        l4 l4Var = new l4();
        f4212a = l4Var;
        l4Var.a(z, bArrB, iC, iE, i, z2);
        return f4212a.f4303a;
    }

    public static boolean a(boolean z, p pVar, y1 y1Var) throws a {
        float fI;
        int iE = pVar.e();
        int iC = pVar.c();
        float[] fArr = {y1Var.j(), y1Var.k(), y1Var.f(), y1Var.c()};
        if (z) {
            y1Var.n = Math.max(y1Var.m(), y1Var.l());
            y1Var.o = Math.min(y1Var.m(), y1Var.l());
            fI = y1Var.i();
            if (y1Var.g() == 11.0f || y1Var.g() == 0.0f) {
                fI = 0.0f;
            }
            y1Var.v = Math.max(fArr[2], fArr[3]);
            y1Var.r = (int) Math.max(((double) fArr[0]) - (((double) fArr[2]) * 0.5d), 0.0d);
            y1Var.s = (int) Math.max(((double) fArr[1]) - (((double) fArr[3]) * 0.5d), 0.0d);
        } else {
            fI = y1Var.i();
            y1Var.v = Math.max(fArr[2], fArr[3]);
            y1Var.r = (int) y1Var.d();
            y1Var.s = (int) y1Var.e();
        }
        y1Var.p = Math.min(iE - y1Var.r, (int) fArr[2]);
        int iMin = Math.min(iC - y1Var.s, (int) fArr[3]);
        y1Var.q = iMin;
        int i = y1Var.p;
        if (i > 0 && iMin > 0) {
            p pVarA = pVar.a(y1Var.r, y1Var.s, i, iMin);
            b = pVarA;
            a(pVarA, fI, y1Var, fArr);
            return true;
        }
        throw a.a("crop_w <= 0 || crop_h <= 0");
    }

    private static void a(p pVar, float f, y1 y1Var, float[] fArr) {
        float fMin;
        float fMax;
        float radians = (float) Math.toRadians(f);
        double d = radians;
        int iAbs = (int) ((((double) y1Var.p) * Math.abs(Math.sin(d))) + (((double) y1Var.q) * Math.abs(Math.cos(d))));
        int iAbs2 = (int) ((((double) y1Var.q) * Math.abs(Math.sin(d))) + (((double) y1Var.p) * Math.abs(Math.cos(d))));
        float[] fArr2 = y1Var.m;
        fArr2[0] = iAbs2 * 0.5f;
        fArr2[1] = iAbs * 0.5f;
        fArr2[2] = (iAbs2 - y1Var.p) * 0.5f;
        fArr2[3] = (iAbs - y1Var.q) * 0.5f;
        fArr2[4] = radians;
        if (f == 0.0f) {
            y1Var.t = 0;
            y1Var.u = 0;
            y1Var.l = pVar;
            return;
        }
        p pVar2 = new p(new a3(new j5(LoadOpencvJNIUtil.imageRotate(pVar.a().c().b(), y1Var.q, y1Var.p, iAbs, iAbs2, f, 1.0d), iAbs2, iAbs, 0, 0, iAbs2, iAbs, false)));
        if ((y1Var.g() == 3.0f || y1Var.g() == 4.0f) && pVar2.c() > pVar2.e()) {
            fMin = Math.min(fArr[2], fArr[3]);
            fMax = Math.max(fArr[2], fArr[3]);
        } else {
            fMin = Math.max(fArr[2], fArr[3]);
            fMax = Math.min(fArr[2], fArr[3]);
        }
        y1Var.t = (int) Math.max((((double) iAbs2) * 0.5d) - (((double) fMin) * 0.5d), 0.0d);
        y1Var.u = (int) Math.max((((double) iAbs) * 0.5d) - (((double) fMax) * 0.5d), 0.0d);
        y1Var.l = pVar2.a(y1Var.t, y1Var.u, Math.min(iAbs2 - y1Var.t, (int) fMin), Math.min(iAbs - y1Var.u, (int) fMax));
    }

    public static void a(s sVar, w5 w5Var, float f, y1 y1Var) {
        int iC;
        int iC2;
        y5[] y5VarArrJ = w5Var.j();
        float fMin = Math.min(y5VarArrJ[0].b(), y5VarArrJ[1].b());
        float fMax = Math.max(y5VarArrJ[0].b(), y5VarArrJ[1].b());
        float fC = y5VarArrJ[0].c();
        if (fMax > sVar.e() - 1) {
            fMax = sVar.e() - 1;
        }
        float f2 = fMax;
        float fC2 = fC > ((float) (sVar.c() - 1)) ? sVar.c() - 1 : fC;
        int iC3 = sVar.c();
        try {
            int[] iArrA = a(sVar, y5VarArrJ, fMin, f2, fC2, iC3, new int[iC3]);
            iC = iArrA[0];
            iC2 = iArrA[1];
        } catch (IndexOutOfBoundsException unused) {
            iC = (int) y5VarArrJ[0].c();
            iC2 = (int) y5VarArrJ[0].c();
        }
        float f3 = iC;
        float f4 = iC2;
        y5[] y5VarArr = {new y5(fMin, f3), new y5(f2, f3), new y5(f2, f4), new y5(fMin, f4)};
        if (y1Var != null) {
            a(y5VarArr, f, y1Var);
        }
        w5Var.a();
        w5Var.a(y5VarArr);
    }

    private static int[] a(s sVar, y5[] y5VarArr, float f, float f2, float f3, int i, int[] iArr) {
        int i2;
        int iC;
        int iC2;
        int i3 = (int) f;
        int i4 = i3;
        int i5 = 0;
        while (true) {
            i2 = ((int) f2) - 1;
            if (i4 >= i2) {
                break;
            }
            int i6 = (int) f3;
            boolean zB = sVar.b(i4, i6);
            i4++;
            if (sVar.b(i4, i6) ^ zB) {
                i5++;
            }
        }
        int i7 = 0;
        for (int i8 = 0; i8 < i; i8++) {
            int i9 = i3;
            int i10 = 0;
            while (i9 < i2) {
                boolean zB2 = sVar.b(i9, i8);
                i9++;
                if (zB2 ^ sVar.b(i9, i8)) {
                    i10++;
                }
            }
            float f4 = i5;
            if (i10 > 1.5f * f4) {
                i10 = 0;
            }
            if (i10 < f4 * 0.5f) {
                i10 = 0;
            }
            iArr[i8] = i10;
            if (i10 > i7) {
                i7 = i10;
            }
        }
        if (i7 > 0) {
            float[] fArr = new float[i];
            for (int i11 = 0; i11 < i; i11++) {
                fArr[i11] = iArr[i11] / i7;
            }
            float f5 = 0.0f;
            for (int i12 = 0; i12 < i; i12++) {
                f5 += fArr[i12];
            }
            float f6 = f5 / i;
            if (f6 > 1.0d) {
                f6 = 0.99f;
            }
            iC = (int) f3;
            iC2 = iC;
            while (true) {
                if (iC2 < 0) {
                    iC2 = 0;
                    break;
                }
                if (fArr[iC2] < f6) {
                    break;
                }
                iC2--;
            }
            while (true) {
                if (iC >= i) {
                    iC = 0;
                    break;
                }
                if (fArr[iC] < f6) {
                    break;
                }
                iC++;
            }
        } else {
            iC = 0;
            iC2 = 0;
        }
        if (iC2 == 0 && iC == 0) {
            iC2 = ((int) y5VarArr[0].c()) + (-10) < 0 ? 0 : ((int) y5VarArr[0].c()) - 10;
            iC = i - 1;
            if (((int) y5VarArr[0].c()) + 10 <= iC) {
                iC = ((int) y5VarArr[0].c()) + 10;
            }
        }
        return new int[]{iC2, iC};
    }

    private static y5 a(float f, float f2, y1 y1Var) {
        float[] fArr = y1Var.m;
        if (fArr != null && fArr.length == 5) {
            float f3 = -fArr[4];
            double d = f - fArr[0];
            double d2 = f3;
            double dCos = (d * Math.cos(d2)) + (((double) (f2 - y1Var.m[1])) * Math.sin(d2));
            float f4 = y1Var.m[0];
            int i = (int) (dCos + ((double) f4));
            int iSin = (int) ((((double) (-(f - f4))) * Math.sin(d2)) + (((double) (f2 - y1Var.m[1])) * Math.cos(d2)) + ((double) y1Var.m[1]));
            float[] fArr2 = y1Var.m;
            return new y5((i - fArr2[2]) + y1Var.r, (iSin - fArr2[3]) + y1Var.s);
        }
        return new y5(f, f2);
    }

    public static void a(y5[] y5VarArr, float f, y1 y1Var) {
        if (y1Var == null || y5VarArr == null) {
            return;
        }
        for (int i = 0; i < y5VarArr.length; i++) {
            y5VarArr[i] = a((y5VarArr[i].b() * f) + y1Var.t, (y5VarArr[i].c() * f) + y1Var.u, y1Var);
        }
    }
}
