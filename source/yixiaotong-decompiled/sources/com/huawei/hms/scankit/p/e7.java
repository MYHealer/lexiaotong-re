package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: WhiteRectangleDetector.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class e7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f4241a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public e7(s sVar) throws a {
        this(sVar, 10, sVar.e() / 2, sVar.c() / 2);
    }

    private y5[] b(int[] iArr) throws a {
        int i = iArr[1] - iArr[0];
        y5 y5VarA = null;
        y5 y5VarA2 = null;
        for (int i2 = 1; y5VarA2 == null && i2 < i; i2++) {
            int i3 = iArr[0];
            int i4 = iArr[3];
            y5VarA2 = a(i3, i4 - i2, i3 + i2, i4);
        }
        if (y5VarA2 == null) {
            throw a.a();
        }
        y5 y5VarA3 = null;
        for (int i5 = 1; y5VarA3 == null && i5 < i; i5++) {
            int i6 = iArr[0];
            int i7 = iArr[2];
            y5VarA3 = a(i6, i7 + i5, i6 + i5, i7);
        }
        if (y5VarA3 == null) {
            throw a.a();
        }
        y5 y5VarA4 = null;
        for (int i8 = 1; y5VarA4 == null && i8 < i; i8++) {
            int i9 = iArr[1];
            int i10 = iArr[2];
            y5VarA4 = a(i9, i10 + i8, i9 - i8, i10);
        }
        if (y5VarA4 == null) {
            throw a.a();
        }
        for (int i11 = 1; y5VarA == null && i11 < i; i11++) {
            int i12 = iArr[1];
            int i13 = iArr[3];
            y5VarA = a(i12, i13 - i11, i12 - i11, i13);
        }
        if (y5VarA != null) {
            return a(y5VarA, y5VarA2, y5VarA4, y5VarA3);
        }
        throw a.a();
    }

    private void c(int[] iArr) {
        while (true) {
            int i = iArr[0];
            if (i < 0) {
                return;
            }
            boolean zA = a(iArr[2], iArr[3], i, false);
            if (zA) {
                iArr[0] = iArr[0] - 1;
                iArr[5] = 1;
                iArr[9] = 1;
            } else if (iArr[9] != 1) {
                iArr[0] = iArr[0] - 1;
            }
            if (!zA && iArr[9] == 1) {
                return;
            }
        }
    }

    private void d(int[] iArr) {
        while (true) {
            int i = iArr[1];
            if (i >= this.c) {
                return;
            }
            boolean zA = a(iArr[2], iArr[3], i, false);
            if (zA) {
                iArr[1] = iArr[1] + 1;
                iArr[5] = 1;
                iArr[7] = 1;
            } else if (iArr[7] != 1) {
                iArr[1] = iArr[1] + 1;
            }
            if (!zA && iArr[7] == 1) {
                return;
            }
        }
    }

    private void e(int[] iArr) {
        while (true) {
            int i = iArr[2];
            if (i < 0) {
                return;
            }
            boolean zA = a(iArr[0], iArr[1], i, true);
            if (zA) {
                iArr[2] = iArr[2] - 1;
                iArr[5] = 1;
                iArr[10] = 1;
            } else if (iArr[10] != 1) {
                iArr[2] = iArr[2] - 1;
            }
            if (!zA && iArr[10] == 1) {
                return;
            }
        }
    }

    public e7(s sVar, int i, int i2, int i3) throws a {
        this.f4241a = sVar;
        int iC = sVar.c();
        this.b = iC;
        int iE = sVar.e();
        this.c = iE;
        int i4 = i / 2;
        int i5 = i2 - i4;
        this.d = i5;
        int i6 = i2 + i4;
        this.e = i6;
        int i7 = i3 - i4;
        this.g = i7;
        int i8 = i3 + i4;
        this.f = i8;
        if (i7 < 0 || i5 < 0 || i8 >= iC || i6 >= iE) {
            throw a.a();
        }
    }

    public y5[] a() throws a {
        int[] iArr = {this.d, this.e, this.g, this.f, 0, 1, 0, 0, 0, 0, 0};
        while (iArr[5] == 1) {
            iArr[5] = 0;
            d(iArr);
            if (iArr[1] >= this.c) {
                iArr[4] = 1;
                break;
            }
            a(iArr);
            if (iArr[3] >= this.b) {
                iArr[4] = 1;
                break;
            }
            c(iArr);
            if (iArr[0] < 0) {
                iArr[4] = 1;
                break;
            }
            e(iArr);
            if (iArr[2] < 0) {
                iArr[4] = 1;
                break;
            }
            if (iArr[5] == 1) {
                iArr[6] = 1;
            }
        }
        if (iArr[4] != 1 && iArr[6] == 1) {
            return b(iArr);
        }
        throw a.a();
    }

    private void a(int[] iArr) {
        while (true) {
            int i = iArr[3];
            if (i >= this.b) {
                return;
            }
            boolean zA = a(iArr[0], iArr[1], i, true);
            if (zA) {
                iArr[3] = iArr[3] + 1;
                iArr[5] = 1;
                iArr[8] = 1;
            } else if (iArr[8] != 1) {
                iArr[3] = iArr[3] + 1;
            }
            if (!zA && iArr[8] == 1) {
                return;
            }
        }
    }

    private y5 a(float f, float f2, float f3, float f4) {
        int iA = b4.a(b4.a(f, f2, f3, f4));
        float f5 = iA;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i = 0; i < iA; i++) {
            float f8 = i;
            int iA2 = b4.a((f8 * f6) + f);
            int iA3 = b4.a((f8 * f7) + f2);
            if (this.f4241a.b(iA2, iA3)) {
                return new y5(iA2, iA3);
            }
        }
        return null;
    }

    private y5[] a(y5 y5Var, y5 y5Var2, y5 y5Var3, y5 y5Var4) {
        float fB = y5Var.b();
        float fC = y5Var.c();
        float fB2 = y5Var2.b();
        float fC2 = y5Var2.c();
        float fB3 = y5Var3.b();
        float fC3 = y5Var3.c();
        float fB4 = y5Var4.b();
        float fC4 = y5Var4.c();
        return fB < ((float) this.c) / 2.0f ? new y5[]{new y5(fB4 - 1.0f, fC4 + 1.0f), new y5(fB2 + 1.0f, fC2 + 1.0f), new y5(fB3 - 1.0f, fC3 - 1.0f), new y5(fB + 1.0f, fC - 1.0f)} : new y5[]{new y5(fB4 + 1.0f, fC4 + 1.0f), new y5(fB2 + 1.0f, fC2 - 1.0f), new y5(fB3 - 1.0f, fC3 + 1.0f), new y5(fB - 1.0f, fC - 1.0f)};
    }

    private boolean a(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.f4241a.b(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.f4241a.b(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }
}
