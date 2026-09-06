package com.huawei.hms.scankit.p;

import java.util.Formatter;

/* JADX INFO: compiled from: DetectionResultColumn.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z f4339a;
    private final u0[] b;

    s1(z zVar) {
        this.f4339a = new z(zVar);
        this.b = new u0[(zVar.d() - zVar.f()) + 1];
    }

    final z a() {
        return this.f4339a;
    }

    final void a(int i, u0 u0Var) {
        this.b[c(i)] = u0Var;
    }

    final u0 b(int i) {
        u0 u0Var;
        u0 u0Var2;
        u0 u0VarA = a(i);
        if (u0VarA != null) {
            return u0VarA;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int iC = c(i) - i2;
            if (iC >= 0 && (u0Var2 = this.b[iC]) != null) {
                return u0Var2;
            }
            int iC2 = c(i) + i2;
            u0[] u0VarArr = this.b;
            if (iC2 < u0VarArr.length && (u0Var = u0VarArr[iC2]) != null) {
                return u0Var;
            }
        }
        return null;
    }

    final u0[] b() {
        return this.b;
    }

    final int c(int i) {
        return i - this.f4339a.f();
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i = 0;
            for (u0 u0Var : this.b) {
                if (u0Var == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i));
                    i++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i), Integer.valueOf(u0Var.c()), Integer.valueOf(u0Var.e()));
                    i++;
                }
            }
            String string = formatter.toString();
            formatter.close();
            return string;
        } catch (Throwable th) {
            try {
                formatter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    final u0 a(int i) {
        return this.b[c(i)];
    }
}
