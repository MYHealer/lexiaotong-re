package com.huawei.hms.scankit.p;

import java.util.List;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class x6 {
    public static List<w5> a(List<w5> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int size = list.size() - 1; size > i; size--) {
                w5 w5Var = list.get(i);
                w5 w5Var2 = list.get(size);
                if (w5Var.k().equals(w5Var2.k()) && a(w5Var.j(), w5Var2.j()) > 0.5d) {
                    list.remove(size);
                }
            }
        }
        return list;
    }

    public static float a(y5[] y5VarArr, y5[] y5VarArr2) {
        float fB = Float.MIN_VALUE;
        float fB2 = Float.MAX_VALUE;
        float fB3 = Float.MIN_VALUE;
        float fC = Float.MIN_VALUE;
        float fB4 = Float.MAX_VALUE;
        float fC2 = Float.MAX_VALUE;
        for (y5 y5Var : y5VarArr) {
            if (y5Var.b() > fB3) {
                fB3 = y5Var.b();
            }
            if (y5Var.b() < fB4) {
                fB4 = y5Var.b();
            }
            if (y5Var.c() > fC) {
                fC = y5Var.c();
            }
            if (y5Var.c() < fC2) {
                fC2 = y5Var.c();
            }
        }
        float fC3 = Float.MIN_VALUE;
        float fC4 = Float.MAX_VALUE;
        for (y5 y5Var2 : y5VarArr2) {
            if (y5Var2.b() > fB) {
                fB = y5Var2.b();
            }
            if (y5Var2.b() < fB2) {
                fB2 = y5Var2.b();
            }
            if (y5Var2.c() > fC3) {
                fC3 = y5Var2.c();
            }
            if (y5Var2.c() < fC4) {
                fC4 = y5Var2.c();
            }
        }
        float f = (fB < fB3 ? fB : fB3) - (fB2 > fB4 ? fB2 : fB4);
        float f2 = (fC3 < fC ? fC3 : fC) - (fC4 > fC2 ? fC4 : fC2);
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        float f3 = f * f2;
        return f3 / ((((fB3 - fB4) * (fC - fC2)) + ((fB - fB2) * (fC3 - fC4))) - f3);
    }
}
