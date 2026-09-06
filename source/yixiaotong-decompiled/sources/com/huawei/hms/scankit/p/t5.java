package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: ReedSolomonDecoder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class t5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y2 f4347a;

    public t5(y2 y2Var) {
        this.f4347a = y2Var;
    }

    public void a(int[] iArr, int i) throws a {
        z2 z2Var = new z2(this.f4347a, iArr);
        int[] iArr2 = new int[i];
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            y2 y2Var = this.f4347a;
            int iA = z2Var.a(y2Var.a(y2Var.a() + i2));
            iArr2[(i - 1) - i2] = iA;
            if (iA != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        z2[] z2VarArrA = a(this.f4347a.b(i, 1), new z2(this.f4347a, iArr2), i);
        z2 z2Var2 = z2VarArrA[0];
        z2 z2Var3 = z2VarArrA[1];
        int[] iArrA = a(z2Var2);
        int[] iArrA2 = a(z2Var3, iArrA);
        for (int i3 = 0; i3 < iArrA.length; i3++) {
            int length = (iArr.length - 1) - this.f4347a.c(iArrA[i3]);
            if (length < 0) {
                throw a.a("Bad error location");
            }
            iArr[length] = y2.a(iArr[length], iArrA2[i3]);
        }
    }

    private z2[] a(z2 z2Var, z2 z2Var2, int i) throws a {
        if (z2Var.b() >= z2Var2.b()) {
            z2Var2 = z2Var;
            z2Var = z2Var2;
        }
        z2 z2VarD = this.f4347a.d();
        z2 z2VarB = this.f4347a.b();
        while (z2Var.b() >= i / 2) {
            if (!z2Var.c()) {
                z2 z2VarD2 = this.f4347a.d();
                int iB = this.f4347a.b(z2Var.b(z2Var.b()));
                while (z2Var2.b() >= z2Var.b() && !z2Var2.c()) {
                    int iB2 = z2Var2.b() - z2Var.b();
                    int iC = this.f4347a.c(z2Var2.b(z2Var2.b()), iB);
                    z2VarD2 = z2VarD2.a(this.f4347a.b(iB2, iC));
                    z2Var2 = z2Var2.a(z2Var.a(iB2, iC));
                }
                z2 z2VarA = z2VarD2.c(z2VarB).a(z2VarD);
                if (z2Var2.b() >= z2Var.b()) {
                    throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
                }
                z2 z2Var3 = z2Var2;
                z2Var2 = z2Var;
                z2Var = z2Var3;
                z2VarD = z2VarB;
                z2VarB = z2VarA;
            } else {
                throw a.a("r_{i-1} was zero");
            }
        }
        int iB3 = z2VarB.b(0);
        if (iB3 != 0) {
            int iB4 = this.f4347a.b(iB3);
            return new z2[]{z2VarB.c(iB4), z2Var.c(iB4)};
        }
        throw a.a("sigmaTilde(0) was zero");
    }

    private int[] a(z2 z2Var) throws a {
        int iB = z2Var.b();
        if (iB == 1) {
            return new int[]{z2Var.b(1)};
        }
        int[] iArr = new int[iB];
        int i = 0;
        for (int i2 = 1; i2 < this.f4347a.c() && i < iB; i2++) {
            if (z2Var.a(i2) == 0) {
                iArr[i] = this.f4347a.b(i2);
                i++;
            }
        }
        if (i == iB) {
            return iArr;
        }
        throw a.a("Error locator degree does not match number of roots");
    }

    private int[] a(z2 z2Var, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int iB = this.f4347a.b(iArr[i]);
            int iC = 1;
            for (int i2 = 0; i2 < length; i2++) {
                if (i != i2) {
                    int iC2 = this.f4347a.c(iArr[i2], iB);
                    iC = this.f4347a.c(iC, (iC2 & 1) == 0 ? iC2 | 1 : iC2 & (-2));
                }
            }
            iArr2[i] = this.f4347a.c(z2Var.a(iB), this.f4347a.b(iC));
            if (this.f4347a.a() != 0) {
                iArr2[i] = this.f4347a.c(iArr2[i], iB);
            }
        }
        return iArr2;
    }
}
