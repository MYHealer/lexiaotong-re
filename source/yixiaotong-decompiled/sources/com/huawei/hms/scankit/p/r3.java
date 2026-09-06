package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;

/* JADX INFO: compiled from: ISBNResultParser.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class r3 extends x5 {
    @Override // com.huawei.hms.scankit.p.x5
    public HmsScan b(w5 w5Var) {
        if (x5.a(w5Var.c()) != HmsScanBase.EAN13_SCAN_TYPE) {
            return null;
        }
        String strA = x5.a(w5Var);
        if (strA.length() != 13) {
            return null;
        }
        if (strA.startsWith("978") || strA.startsWith("979")) {
            return new HmsScan(w5Var.k(), x5.a(w5Var.c()), strA, HmsScan.ISBN_NUMBER_FORM, w5Var.i(), x5.a(w5Var.j()), null, null);
        }
        return null;
    }
}
