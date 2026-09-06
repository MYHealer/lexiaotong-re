package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f4359a;
    private final e7 b;

    public v1(s sVar) throws a {
        this.f4359a = sVar;
        this.b = new e7(sVar);
    }

    private y5[] b(y5[] y5VarArr) {
        y5 y5Var = y5VarArr[0];
        y5 y5Var2 = y5VarArr[1];
        y5 y5Var3 = y5VarArr[3];
        y5 y5Var4 = y5VarArr[2];
        int iA = a(y5Var, y5Var2);
        int iA2 = a(y5Var2, y5Var3);
        int iA3 = a(y5Var3, y5Var4);
        int iA4 = a(y5Var4, y5Var);
        y5[] y5VarArr2 = {y5Var4, y5Var, y5Var2, y5Var3};
        if (iA > iA2) {
            y5VarArr2[0] = y5Var;
            y5VarArr2[1] = y5Var2;
            y5VarArr2[2] = y5Var3;
            y5VarArr2[3] = y5Var4;
            iA = iA2;
        }
        if (iA > iA3) {
            y5VarArr2[0] = y5Var2;
            y5VarArr2[1] = y5Var3;
            y5VarArr2[2] = y5Var4;
            y5VarArr2[3] = y5Var;
        } else {
            iA3 = iA;
        }
        if (iA3 > iA4) {
            y5VarArr2[0] = y5Var3;
            y5VarArr2[1] = y5Var4;
            y5VarArr2[2] = y5Var;
            y5VarArr2[3] = y5Var2;
        }
        return y5VarArr2;
    }

    private y5[] c(y5[] y5VarArr) {
        y5 y5Var = y5VarArr[0];
        y5 y5Var2 = y5VarArr[1];
        y5 y5Var3 = y5VarArr[2];
        y5 y5Var4 = y5VarArr[3];
        int iA = (a(y5Var, y5Var4) + 1) * 4;
        if (a(a(y5Var2, y5Var3, iA), y5Var) < a(a(y5Var3, y5Var2, iA), y5Var4)) {
            y5VarArr[0] = y5Var;
            y5VarArr[1] = y5Var2;
            y5VarArr[2] = y5Var3;
            y5VarArr[3] = y5Var4;
        } else {
            y5VarArr[0] = y5Var2;
            y5VarArr[1] = y5Var3;
            y5VarArr[2] = y5Var4;
            y5VarArr[3] = y5Var;
        }
        return y5VarArr;
    }

    private y5[] d(y5[] y5VarArr) {
        y5 y5Var = y5VarArr[0];
        y5 y5Var2 = y5VarArr[1];
        y5 y5Var3 = y5VarArr[2];
        y5 y5Var4 = y5VarArr[3];
        int iA = a(y5Var, y5Var4) + 1;
        y5 y5VarA = a(y5Var, y5Var2, (a(y5Var3, y5Var4) + 1) * 4);
        y5 y5VarA2 = a(y5Var3, y5Var2, iA * 4);
        int iA2 = a(y5VarA, y5Var4);
        int i = iA2 + 1;
        int iA3 = a(y5VarA2, y5Var4);
        int i2 = iA3 + 1;
        if ((i & 1) == 1) {
            i = iA2 + 2;
        }
        if ((i2 & 1) == 1) {
            i2 = iA3 + 2;
        }
        float fB = (((y5Var.b() + y5Var2.b()) + y5Var3.b()) + y5Var4.b()) / 4.0f;
        float fC = (((y5Var.c() + y5Var2.c()) + y5Var3.c()) + y5Var4.c()) / 4.0f;
        y5 y5VarA3 = a(y5Var, fB, fC);
        y5 y5VarA4 = a(y5Var2, fB, fC);
        y5 y5VarA5 = a(y5Var3, fB, fC);
        y5 y5VarA6 = a(y5Var4, fB, fC);
        int i3 = i2 * 4;
        int i4 = i * 4;
        return new y5[]{a(a(y5VarA3, y5VarA4, i3), y5VarA6, i4), a(a(y5VarA4, y5VarA3, i3), y5VarA5, i4), a(a(y5VarA5, y5VarA6, i3), y5VarA4, i4), a(a(y5VarA6, y5VarA5, i3), y5VarA3, i4)};
    }

    public z1 a() throws a {
        int iMax;
        int i;
        y5[] y5VarArrC = c(b(this.b.a()));
        y5 y5VarA = a(y5VarArrC);
        y5VarArrC[3] = y5VarA;
        if (y5VarA == null) {
            throw a.a();
        }
        y5[] y5VarArrD = d(y5VarArrC);
        y5 y5Var = y5VarArrD[0];
        y5 y5Var2 = y5VarArrD[1];
        y5 y5Var3 = y5VarArrD[2];
        y5 y5Var4 = y5VarArrD[3];
        int iA = a(y5Var, y5Var4);
        int i2 = iA + 1;
        int iA2 = a(y5Var3, y5Var4);
        int i3 = iA2 + 1;
        if ((i2 & 1) == 1) {
            i2 = iA + 2;
        }
        if ((i3 & 1) == 1) {
            i3 = iA2 + 2;
        }
        if (i2 * 4 >= i3 * 7 || i3 * 4 >= i2 * 7) {
            iMax = i2;
            i = i3;
        } else {
            iMax = Math.max(i2, i3);
            i = iMax;
        }
        return new z1(a(this.f4359a, y5Var, y5Var2, y5Var3, y5Var4, iMax, i), new y5[]{y5Var, y5Var2, y5Var3, y5Var4});
    }

    private static y5 a(y5 y5Var, y5 y5Var2, int i) {
        float f = i + 1;
        return new y5(y5Var.b() + ((y5Var2.b() - y5Var.b()) / f), y5Var.c() + ((y5Var2.c() - y5Var.c()) / f));
    }

    private static y5 a(y5 y5Var, float f, float f2) {
        float fB = y5Var.b();
        float fC = y5Var.c();
        return new y5(fB < f ? fB - 1.0f : fB + 1.0f, fC < f2 ? fC - 1.0f : fC + 1.0f);
    }

    private y5 a(y5[] y5VarArr) {
        y5 y5Var = y5VarArr[0];
        y5 y5Var2 = y5VarArr[1];
        y5 y5Var3 = y5VarArr[2];
        y5 y5Var4 = y5VarArr[3];
        int iA = a(y5Var, y5Var4);
        y5 y5VarA = a(y5Var, y5Var2, (a(y5Var2, y5Var4) + 1) * 4);
        y5 y5VarA2 = a(y5Var3, y5Var2, (iA + 1) * 4);
        int iA2 = a(y5VarA, y5Var4);
        int iA3 = a(y5VarA2, y5Var4);
        float f = iA2 + 1;
        y5 y5Var5 = new y5(y5Var4.b() + ((y5Var3.b() - y5Var2.b()) / f), y5Var4.c() + ((y5Var3.c() - y5Var2.c()) / f));
        float f2 = iA3 + 1;
        y5 y5Var6 = new y5(y5Var4.b() + ((y5Var.b() - y5Var2.b()) / f2), y5Var4.c() + ((y5Var.c() - y5Var2.c()) / f2));
        if (a(y5Var5)) {
            return (a(y5Var6) && a(y5VarA, y5Var5) + a(y5VarA2, y5Var5) <= a(y5VarA, y5Var6) + a(y5VarA2, y5Var6)) ? y5Var6 : y5Var5;
        }
        if (a(y5Var6)) {
            return y5Var6;
        }
        return null;
    }

    private boolean a(y5 y5Var) {
        return y5Var.b() >= 0.0f && y5Var.b() < ((float) this.f4359a.e()) && y5Var.c() > 0.0f && y5Var.c() < ((float) this.f4359a.c());
    }

    private static s a(s sVar, y5 y5Var, y5 y5Var2, y5 y5Var3, y5 y5Var4, int i, int i2) throws a {
        float f = i - 0.5f;
        float f2 = i2 - 0.5f;
        return c3.a().a(sVar, i, i2, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, y5Var.b(), y5Var.c(), y5Var4.b(), y5Var4.c(), y5Var3.b(), y5Var3.c(), y5Var2.b(), y5Var2.c());
    }

    private int a(y5 y5Var, y5 y5Var2) {
        int i;
        boolean z;
        v1 v1Var = this;
        int iB = (int) y5Var.b();
        int iC = (int) y5Var.c();
        int iB2 = (int) y5Var2.b();
        int iC2 = (int) y5Var2.c();
        boolean z2 = Math.abs(iC2 - iC) > Math.abs(iB2 - iB);
        if (!z2) {
            iC = iB;
            iB = iC;
            iC2 = iB2;
            iB2 = iC2;
        }
        int iAbs = Math.abs(iC2 - iC);
        int iAbs2 = Math.abs(iB2 - iB);
        int i2 = (-iAbs) / 2;
        int i3 = iB < iB2 ? 1 : -1;
        int i4 = iC < iC2 ? 1 : -1;
        boolean zB = v1Var.f4359a.b(z2 ? iB : iC, z2 ? iC : iB);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (iC != iC2) {
            boolean zB2 = v1Var.f4359a.b(z2 ? iB : iC, z2 ? iC : iB);
            i5++;
            if (zB2 != zB) {
                i = iC2;
                z = z2;
                if (i5 > Math.ceil(((double) i6) / 1.5d)) {
                    i7++;
                    i6 -= (i6 - i5) / i7;
                    zB = zB2;
                    i5 = 0;
                }
            } else {
                i = iC2;
                z = z2;
            }
            i2 += iAbs2;
            if (i2 > 0) {
                if (iB == iB2) {
                    break;
                }
                iB += i3;
                i2 -= iAbs;
            }
            iC += i4;
            v1Var = this;
            z2 = z;
            iC2 = i;
        }
        return i7;
    }
}
