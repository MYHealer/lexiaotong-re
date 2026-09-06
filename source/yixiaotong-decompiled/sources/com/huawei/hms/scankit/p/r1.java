package com.huawei.hms.scankit.p;

import java.util.Formatter;

/* JADX INFO: compiled from: DetectionResult.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f4332a;
    private final s1[] b;
    private z c;
    private final int d;

    r1(k kVar, z zVar) {
        this.f4332a = kVar;
        int iA = kVar.a();
        this.d = iA;
        this.c = zVar;
        this.b = new s1[iA + 2];
    }

    private void a(s1 s1Var) throws a {
        if (s1Var != null) {
            try {
                ((t1) s1Var).a(this.f4332a);
            } catch (ClassCastException unused) {
                throw a.a();
            }
        }
    }

    private int b() {
        c();
        return d() + e();
    }

    private void c() {
        s1[] s1VarArr = this.b;
        s1 s1Var = s1VarArr[0];
        if (s1Var == null || s1VarArr[this.d + 1] == null) {
            return;
        }
        u0[] u0VarArrB = s1Var.b();
        u0[] u0VarArrB2 = this.b[this.d + 1].b();
        for (int i = 0; i < u0VarArrB.length; i++) {
            u0 u0Var = u0VarArrB[i];
            if (u0Var != null && u0VarArrB2[i] != null && u0Var.c() == u0VarArrB2[i].c()) {
                for (int i2 = 1; i2 <= this.d; i2++) {
                    u0 u0Var2 = this.b[i2].b()[i];
                    if (u0Var2 != null) {
                        u0Var2.b(u0VarArrB[i].c());
                        if (!u0Var2.g()) {
                            this.b[i2].b()[i] = null;
                        }
                    }
                }
            }
        }
    }

    private int d() {
        s1 s1Var = this.b[0];
        if (s1Var == null) {
            return 0;
        }
        u0[] u0VarArrB = s1Var.b();
        int i = 0;
        for (int i2 = 0; i2 < u0VarArrB.length; i2++) {
            u0 u0Var = u0VarArrB[i2];
            if (u0Var != null) {
                int iC = u0Var.c();
                int iA = 0;
                for (int i3 = 1; i3 < this.d + 1 && iA < 2; i3++) {
                    u0 u0Var2 = this.b[i3].b()[i2];
                    if (u0Var2 != null) {
                        iA = a(iC, iA, u0Var2);
                        if (!u0Var2.g()) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    private int e() {
        s1 s1Var = this.b[this.d + 1];
        if (s1Var == null) {
            return 0;
        }
        u0[] u0VarArrB = s1Var.b();
        int i = 0;
        for (int i2 = 0; i2 < u0VarArrB.length; i2++) {
            u0 u0Var = u0VarArrB[i2];
            if (u0Var != null) {
                int iC = u0Var.c();
                int iA = 0;
                for (int i3 = this.d + 1; i3 > 0 && iA < 2; i3--) {
                    u0 u0Var2 = this.b[i3].b()[i2];
                    if (u0Var2 != null) {
                        iA = a(iC, iA, u0Var2);
                        if (!u0Var2.g()) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    void a(z zVar) {
        this.c = zVar;
    }

    int f() {
        return this.d;
    }

    int g() {
        return this.f4332a.b();
    }

    int h() {
        return this.f4332a.c();
    }

    z i() {
        return this.c;
    }

    s1[] j() throws a {
        a(this.b[0]);
        a(this.b[this.d + 1]);
        int i = 928;
        while (true) {
            int iA = a();
            if (iA <= 0 || iA >= i) {
                break;
            }
            i = iA;
        }
        return this.b;
    }

    public String toString() {
        s1[] s1VarArr = this.b;
        s1 s1Var = s1VarArr[0];
        if (s1Var == null) {
            s1Var = s1VarArr[this.d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < s1Var.b().length; i++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i));
                for (int i2 = 0; i2 < this.d + 2; i2++) {
                    s1 s1Var2 = this.b[i2];
                    if (s1Var2 == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        u0 u0Var = s1Var2.b()[i];
                        if (u0Var == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(u0Var.c()), Integer.valueOf(u0Var.e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    formatter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }

    private int a() {
        int iB = b();
        if (iB == 0) {
            return 0;
        }
        for (int i = 1; i < this.d + 1; i++) {
            u0[] u0VarArrB = this.b[i].b();
            for (int i2 = 0; i2 < u0VarArrB.length; i2++) {
                u0 u0Var = u0VarArrB[i2];
                if (u0Var != null && !u0Var.g()) {
                    a(i, i2, u0VarArrB);
                }
            }
        }
        return iB;
    }

    private static int a(int i, int i2, u0 u0Var) {
        if (u0Var == null || u0Var.g()) {
            return i2;
        }
        if (!u0Var.a(i)) {
            return i2 + 1;
        }
        u0Var.b(i);
        return 0;
    }

    private void a(int i, int i2, u0[] u0VarArr) {
        u0 u0Var = u0VarArr[i2];
        u0[] u0VarArrB = this.b[i - 1].b();
        s1 s1Var = this.b[i + 1];
        u0[] u0VarArrB2 = s1Var != null ? s1Var.b() : u0VarArrB;
        u0[] u0VarArr2 = new u0[14];
        u0VarArr2[2] = u0VarArrB[i2];
        u0VarArr2[3] = u0VarArrB2[i2];
        if (i2 > 0) {
            int i3 = i2 - 1;
            u0VarArr2[0] = u0VarArr[i3];
            u0VarArr2[4] = u0VarArrB[i3];
            u0VarArr2[5] = u0VarArrB2[i3];
        }
        if (i2 > 1) {
            int i4 = i2 - 2;
            u0VarArr2[8] = u0VarArr[i4];
            u0VarArr2[10] = u0VarArrB[i4];
            u0VarArr2[11] = u0VarArrB2[i4];
        }
        if (i2 < u0VarArr.length - 1) {
            int i5 = i2 + 1;
            u0VarArr2[1] = u0VarArr[i5];
            u0VarArr2[6] = u0VarArrB[i5];
            u0VarArr2[7] = u0VarArrB2[i5];
        }
        if (i2 < u0VarArr.length - 2) {
            int i6 = i2 + 2;
            u0VarArr2[9] = u0VarArr[i6];
            u0VarArr2[12] = u0VarArrB[i6];
            u0VarArr2[13] = u0VarArrB2[i6];
        }
        for (int i7 = 0; i7 < 14 && !a(u0Var, u0VarArr2[i7]); i7++) {
        }
    }

    private static boolean a(u0 u0Var, u0 u0Var2) {
        if (u0Var2 == null || !u0Var2.g() || u0Var2.a() != u0Var.a()) {
            return false;
        }
        u0Var.b(u0Var2.c());
        return true;
    }

    void a(int i, s1 s1Var) {
        this.b[i] = s1Var;
    }

    s1 a(int i) {
        return this.b[i];
    }
}
