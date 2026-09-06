package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: PDF417Reader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class x4 implements s5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final w5[] f4374a = new w5[0];

    private static int b(y5 y5Var, y5 y5Var2) {
        if (y5Var == null || y5Var2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(y5Var.b() - y5Var2.b());
    }

    @Override // com.huawei.hms.scankit.p.s5
    public w5 a(p pVar, Map<f1, ?> map) throws a {
        w5 w5Var;
        w5[] w5VarArrA = a(pVar, map, false);
        if (w5VarArrA.length == 0 || (w5Var = w5VarArrA[0]) == null) {
            throw a.a();
        }
        return w5Var;
    }

    private static int b(y5[] y5VarArr) {
        return Math.min(Math.min(b(y5VarArr[0], y5VarArr[4]), (b(y5VarArr[6], y5VarArr[2]) * 17) / 18), Math.min(b(y5VarArr[1], y5VarArr[5]), (b(y5VarArr[7], y5VarArr[3]) * 17) / 18));
    }

    private static w5[] a(p pVar, Map<f1, ?> map, boolean z) throws a {
        ArrayList arrayList = new ArrayList();
        u4 u4VarA = w1.a(pVar, map, z);
        for (y5[] y5VarArr : u4VarA.b()) {
            o1 o1VarA = z4.a(u4VarA.a(), y5VarArr[4], y5VarArr[5], y5VarArr[6], y5VarArr[7], b(y5VarArr), a(y5VarArr), map);
            if (w1.a()) {
                for (int i = 0; i < y5VarArr.length; i++) {
                    if (y5VarArr[i] != null) {
                        y5VarArr[i] = new y5((pVar.e() - 1) - y5VarArr[i].b(), (pVar.c() - 1) - y5VarArr[i].c());
                    }
                }
            }
            if (y5VarArr.length == 8) {
                y5 y5Var = y5VarArr[0];
                if (y5Var == null && y5VarArr[1] == null && y5VarArr[4] == null && y5VarArr[5] == null) {
                    y5VarArr[0] = y5VarArr[6];
                    y5VarArr[1] = y5VarArr[7];
                    y5VarArr[4] = y5VarArr[2];
                    y5VarArr[5] = y5VarArr[3];
                } else if (y5VarArr[2] == null && y5VarArr[3] == null && y5VarArr[6] == null && y5VarArr[7] == null) {
                    y5VarArr[2] = y5VarArr[4];
                    y5VarArr[3] = y5VarArr[5];
                    y5VarArr[6] = y5Var;
                    y5VarArr[7] = y5VarArr[1];
                }
                arrayList.add(new w5(o1VarA.d(), o1VarA.c(), y5VarArr, BarcodeFormat.PDF_417));
            } else {
                throw a.a("pdf417 points size incorrect!");
            }
        }
        return (w5[]) arrayList.toArray(f4374a);
    }

    private static int a(y5 y5Var, y5 y5Var2) {
        if (y5Var == null || y5Var2 == null) {
            return 0;
        }
        return (int) Math.abs(y5Var.b() - y5Var2.b());
    }

    private static int a(y5[] y5VarArr) {
        return Math.max(Math.max(a(y5VarArr[0], y5VarArr[4]), (a(y5VarArr[6], y5VarArr[2]) * 17) / 18), Math.max(a(y5VarArr[1], y5VarArr[5]), (a(y5VarArr[7], y5VarArr[3]) * 17) / 18));
    }
}
