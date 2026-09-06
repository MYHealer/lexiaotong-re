package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: ErrorCorrection.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e4 f4327a = e4.f;

    public int a(int[] iArr, int i, int[] iArr2) throws a {
        f4 f4Var = new f4(this.f4327a, iArr);
        int[] iArr3 = new int[i];
        boolean z = false;
        for (int i2 = i; i2 > 0; i2--) {
            int iA = f4Var.a(this.f4327a.a(i2));
            iArr3[i - i2] = iA;
            if (iA != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        f4 f4VarA = this.f4327a.a();
        if (iArr2 != null) {
            for (int i3 : iArr2) {
                int iA2 = this.f4327a.a((iArr.length - 1) - i3);
                e4 e4Var = this.f4327a;
                f4VarA = f4VarA.b(new f4(e4Var, new int[]{e4Var.d(0, iA2), 1}));
            }
        }
        f4[] f4VarArrA = a(this.f4327a.b(i, 1), new f4(this.f4327a, iArr3), i);
        f4 f4Var2 = f4VarArrA[0];
        f4 f4Var3 = f4VarArrA[1];
        int[] iArrA = a(f4Var2);
        int[] iArrA2 = a(f4Var3, f4Var2, iArrA);
        for (int i4 = 0; i4 < iArrA.length; i4++) {
            int length = (iArr.length - 1) - this.f4327a.c(iArrA[i4]);
            if (length < 0) {
                throw a.a();
            }
            iArr[length] = this.f4327a.d(iArr[length], iArrA2[i4]);
        }
        return iArrA.length;
    }

    private f4[] a(f4 f4Var, f4 f4Var2, int i) throws a {
        if (f4Var.a() >= f4Var2.a()) {
            f4Var2 = f4Var;
            f4Var = f4Var2;
        }
        f4 f4VarC = this.f4327a.c();
        f4 f4VarA = this.f4327a.a();
        while (f4Var.a() >= i / 2) {
            if (!f4Var.b()) {
                f4 f4VarC2 = this.f4327a.c();
                int iB = this.f4327a.b(f4Var.b(f4Var.a()));
                while (f4Var2.a() >= f4Var.a() && !f4Var2.b()) {
                    int iA = f4Var2.a() - f4Var.a();
                    int iC = this.f4327a.c(f4Var2.b(f4Var2.a()), iB);
                    f4VarC2 = f4VarC2.a(this.f4327a.b(iA, iC));
                    f4Var2 = f4Var2.c(f4Var.a(iA, iC));
                }
                f4 f4VarC3 = f4VarC2.b(f4VarA).c(f4VarC).c();
                f4 f4Var3 = f4Var2;
                f4Var2 = f4Var;
                f4Var = f4Var3;
                f4VarC = f4VarA;
                f4VarA = f4VarC3;
            } else {
                throw a.a();
            }
        }
        int iB2 = f4VarA.b(0);
        if (iB2 != 0) {
            int iB3 = this.f4327a.b(iB2);
            return new f4[]{f4VarA.c(iB3), f4Var.c(iB3)};
        }
        throw a.a();
    }

    private int[] a(f4 f4Var) throws a {
        int iA = f4Var.a();
        int[] iArr = new int[iA];
        int i = 0;
        for (int i2 = 1; i2 < this.f4327a.b() && i < iA; i2++) {
            if (f4Var.a(i2) == 0) {
                iArr[i] = this.f4327a.b(i2);
                i++;
            }
        }
        if (i == iA) {
            return iArr;
        }
        throw a.a();
    }

    private int[] a(f4 f4Var, f4 f4Var2, int[] iArr) {
        int iA = f4Var2.a();
        int[] iArr2 = new int[iA];
        for (int i = 1; i <= iA; i++) {
            iArr2[iA - i] = this.f4327a.c(i, f4Var2.b(i));
        }
        f4 f4Var3 = new f4(this.f4327a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int iB = this.f4327a.b(iArr[i2]);
            iArr3[i2] = this.f4327a.c(this.f4327a.d(0, f4Var.a(iB)), this.f4327a.b(f4Var3.a(iB)));
        }
        return iArr3;
    }
}
