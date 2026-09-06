package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: GenericGFPoly.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class z2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y2 f4386a;
    private final int[] b;

    z2(y2 y2Var, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f4386a = y2Var;
        int length = iArr.length;
        int i = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.b = iArr;
            return;
        }
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.b = new int[]{0};
            return;
        }
        int i2 = length - i;
        int[] iArr2 = new int[i2];
        this.b = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, i2);
    }

    int[] a() {
        return this.b;
    }

    int b() {
        return this.b.length - 1;
    }

    boolean c() {
        return this.b[0] == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(b() * 8);
        for (int iB = b(); iB >= 0; iB--) {
            int iB2 = b(iB);
            if (iB2 != 0) {
                if (iB2 < 0) {
                    sb.append(" - ");
                    iB2 = -iB2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iB == 0 || iB2 != 1) {
                    int iC = this.f4386a.c(iB2);
                    if (iC == 0) {
                        sb.append('1');
                    } else if (iC == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(iC);
                    }
                }
                if (iB != 0) {
                    if (iB == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iB);
                    }
                }
            }
        }
        return sb.toString();
    }

    int a(int i) {
        if (i == 0) {
            return b(0);
        }
        if (i == 1) {
            int iA = 0;
            for (int i2 : this.b) {
                iA = y2.a(iA, i2);
            }
            return iA;
        }
        int[] iArr = this.b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            iA2 = y2.a(this.f4386a.c(i, iA2), this.b[i3]);
        }
        return iA2;
    }

    int b(int i) {
        int[] iArr = this.b;
        return iArr[(iArr.length - 1) - i];
    }

    z2 c(z2 z2Var) {
        if (!this.f4386a.equals(z2Var.f4386a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (c() || z2Var.c()) {
            return this.f4386a.d();
        }
        int[] iArr = this.b;
        int length = iArr.length;
        int[] iArr2 = z2Var.b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                iArr3[i4] = y2.a(iArr3[i4], this.f4386a.c(i2, iArr2[i3]));
            }
        }
        return new z2(this.f4386a, iArr3);
    }

    z2[] b(z2 z2Var) {
        if (this.f4386a.equals(z2Var.f4386a)) {
            if (!z2Var.c()) {
                z2 z2VarD = this.f4386a.d();
                int iB = this.f4386a.b(z2Var.b(z2Var.b()));
                z2 z2VarA = this;
                while (z2VarA.b() >= z2Var.b() && !z2VarA.c()) {
                    int iB2 = z2VarA.b() - z2Var.b();
                    int iC = this.f4386a.c(z2VarA.b(z2VarA.b()), iB);
                    z2 z2VarA2 = z2Var.a(iB2, iC);
                    z2VarD = z2VarD.a(this.f4386a.b(iB2, iC));
                    z2VarA = z2VarA.a(z2VarA2);
                }
                return new z2[]{z2VarD, z2VarA};
            }
            throw new IllegalArgumentException("Divide by 0");
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    z2 a(z2 z2Var) {
        if (this.f4386a.equals(z2Var.f4386a)) {
            if (c()) {
                return z2Var;
            }
            if (z2Var.c()) {
                return this;
            }
            int[] iArr = this.b;
            int[] iArr2 = z2Var.b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr3[i] = y2.a(iArr2[i - length], iArr[i]);
            }
            return new z2(this.f4386a, iArr3);
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    z2 c(int i) {
        if (i == 0) {
            return this.f4386a.d();
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f4386a.c(this.b[i2], i);
        }
        return new z2(this.f4386a, iArr);
    }

    z2 a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f4386a.d();
        }
        int length = this.b.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f4386a.c(this.b[i3], i2);
        }
        return new z2(this.f4386a, iArr);
    }
}
