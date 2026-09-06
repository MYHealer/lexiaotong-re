package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* JADX INFO: compiled from: UPCAReader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class n6 extends s6 {
    private final s6 h = new e2();

    @Override // com.huawei.hms.scankit.p.s6
    public boolean a(int i, int i2, r rVar) {
        return rVar.a(i2, (i2 - i) + i2, false, false);
    }

    @Override // com.huawei.hms.scankit.p.s6
    public w5 a(int i, r rVar, int[] iArr, Map<f1, ?> map) throws a {
        return a(this.h.a(i, rVar, iArr, map));
    }

    @Override // com.huawei.hms.scankit.p.s6, com.huawei.hms.scankit.p.o4
    public w5 a(int i, r rVar, Map<f1, ?> map) throws a {
        return a(this.h.a(i, rVar, map));
    }

    @Override // com.huawei.hms.scankit.p.o4, com.huawei.hms.scankit.p.s5
    public w5 a(p pVar, Map<f1, ?> map) throws a {
        return a(this.h.a(pVar, map));
    }

    @Override // com.huawei.hms.scankit.p.s6
    BarcodeFormat a() {
        return BarcodeFormat.UPC_A;
    }

    @Override // com.huawei.hms.scankit.p.s6
    protected int a(r rVar, int[] iArr, StringBuilder sb) throws a {
        return this.h.a(rVar, iArr, sb);
    }

    private static w5 a(w5 w5Var) throws a {
        String strK = w5Var.k();
        if (strK.charAt(0) == '0') {
            return new w5(strK.substring(1), null, w5Var.j(), BarcodeFormat.UPC_A);
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.s6
    boolean a(int[] iArr, int[] iArr2) throws a {
        int i = iArr2[1];
        int i2 = i - iArr2[0];
        int i3 = iArr[1];
        int i4 = iArr[0];
        return Math.abs(((int) Math.round(((double) (i - i4)) / (((double) (i2 + (i3 - i4))) / 6.0d))) + (-113)) <= 5;
    }
}
