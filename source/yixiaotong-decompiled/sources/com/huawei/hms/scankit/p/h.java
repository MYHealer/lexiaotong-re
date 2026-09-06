package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* JADX INFO: compiled from: AztecReader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class h implements s5 {
    @Override // com.huawei.hms.scankit.p.s5
    public w5 a(p pVar, Map<f1, ?> map) throws a {
        y5[] y5VarArrD;
        z5 z5Var;
        u1 u1Var = new u1(pVar.b());
        o1 o1VarA = null;
        try {
            g gVarA = u1Var.a(false);
            y5VarArrD = gVarA.d();
            try {
                o1 o1VarA2 = new l1().a(gVarA, map);
                e = null;
                o1VarA = o1VarA2;
            } catch (a e) {
                e = e;
            }
        } catch (a e2) {
            e = e2;
            y5VarArrD = null;
        }
        if (o1VarA == null) {
            try {
                g gVarA2 = u1Var.a(true);
                y5VarArrD = gVarA2.d();
                o1VarA = new l1().a(gVarA2, map);
            } catch (a e3) {
                if (y5VarArrD != null && !b3.c) {
                    return new w5(null, null, 0, (y5[]) y5VarArrD.clone(), BarcodeFormat.AZTEC, System.currentTimeMillis());
                }
                if (e != null) {
                    throw e;
                }
                throw e3;
            }
        }
        y5[] y5VarArr = y5VarArrD;
        if (map != null && (z5Var = (z5) map.get(f1.NEED_RESULT_POINT_CALLBACK)) != null && y5VarArr != null) {
            for (y5 y5Var : y5VarArr) {
                z5Var.a(y5Var);
            }
        }
        return new w5(o1VarA.d(), o1VarA.c(), o1VarA.a(), y5VarArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
    }
}
