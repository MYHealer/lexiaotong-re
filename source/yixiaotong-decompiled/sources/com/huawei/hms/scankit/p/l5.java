package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;

/* JADX INFO: compiled from: ProductResultParser.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class l5 extends x5 {
    @Override // com.huawei.hms.scankit.p.x5
    public HmsScan b(w5 w5Var) {
        int iA = x5.a(w5Var.c());
        if (iA != HmsScanBase.EAN13_SCAN_TYPE && iA != HmsScanBase.EAN8_SCAN_TYPE && iA != HmsScanBase.UPCCODE_A_SCAN_TYPE && iA != HmsScanBase.UPCCODE_E_SCAN_TYPE) {
            return null;
        }
        String strA = x5.a(w5Var);
        if (x5.b(strA, strA.length())) {
            return new HmsScan(strA, x5.a(w5Var.c()), strA, HmsScan.ARTICLE_NUMBER_FORM, w5Var.i(), x5.a(w5Var.j()), null, null);
        }
        return null;
    }
}
