package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: ModulusPoly.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class f4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e4 f4247a;
    private final int[] b;

    f4(e4 e4Var, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f4247a = e4Var;
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

    int a() {
        return this.b.length - 1;
    }

    boolean b() {
        return this.b[0] == 0;
    }

    f4 c(f4 f4Var) {
        if (this.f4247a.equals(f4Var.f4247a)) {
            return f4Var.b() ? this : a(f4Var.c());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(a() * 8);
        for (int iA = a(); iA >= 0; iA--) {
            int iB = b(iA);
            if (iB != 0) {
                if (iB < 0) {
                    sb.append(" - ");
                    iB = -iB;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iA == 0 || iB != 1) {
                    sb.append(iB);
                }
                if (iA != 0) {
                    if (iA == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iA);
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
                iA = this.f4247a.a(iA, i2);
            }
            return iA;
        }
        int[] iArr = this.b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            e4 e4Var = this.f4247a;
            iA2 = e4Var.a(e4Var.c(i, iA2), this.b[i3]);
        }
        return iA2;
    }

    int b(int i) {
        int[] iArr = this.b;
        return iArr[(iArr.length - 1) - i];
    }

    f4 b(f4 f4Var) {
        if (this.f4247a.equals(f4Var.f4247a)) {
            if (!b() && !f4Var.b()) {
                int[] iArr = this.b;
                int length = iArr.length;
                int[] iArr2 = f4Var.b;
                int length2 = iArr2.length;
                int[] iArr3 = new int[(length + length2) - 1];
                for (int i = 0; i < length; i++) {
                    int i2 = iArr[i];
                    for (int i3 = 0; i3 < length2; i3++) {
                        int i4 = i + i3;
                        e4 e4Var = this.f4247a;
                        iArr3[i4] = e4Var.a(iArr3[i4], e4Var.c(i2, iArr2[i3]));
                    }
                }
                return new f4(this.f4247a, iArr3);
            }
            return this.f4247a.c();
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    f4 c() {
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.f4247a.d(0, this.b[i]);
        }
        return new f4(this.f4247a, iArr);
    }

    f4 c(int i) {
        if (i == 0) {
            return this.f4247a.c();
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f4247a.c(this.b[i2], i);
        }
        return new f4(this.f4247a, iArr);
    }

    f4 a(f4 f4Var) {
        if (this.f4247a.equals(f4Var.f4247a)) {
            if (b()) {
                return f4Var;
            }
            if (f4Var.b()) {
                return this;
            }
            int[] iArr = this.b;
            int[] iArr2 = f4Var.b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr3[i] = this.f4247a.a(iArr2[i - length], iArr[i]);
            }
            return new f4(this.f4247a, iArr3);
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    f4 a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f4247a.c();
        }
        int length = this.b.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f4247a.c(this.b[i3], i2);
        }
        return new f4(this.f4247a, iArr);
    }
}
