package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* JADX INFO: compiled from: QRCodeWriter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class p5 implements g7 {
    @Override // com.huawei.hms.scankit.p.g7
    public s a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<k2, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        }
        r2 r2VarValueOf = r2.L;
        Boolean bool = Boolean.FALSE;
        int i3 = 4;
        if (map != null) {
            k2 k2Var = k2.ERROR_CORRECTION;
            if (map.containsKey(k2Var)) {
                r2VarValueOf = r2.valueOf(map.get(k2Var).toString());
            }
            k2 k2Var2 = k2.MARGIN;
            i3 = map.containsKey(k2Var2) ? Integer.parseInt(map.get(k2Var2).toString()) : 4;
            k2 k2Var3 = k2.LOGO;
            if (map.containsKey(k2Var3)) {
                bool = (Boolean) map.get(k2Var3);
            }
        }
        return a(m2.a(str, r2VarValueOf, map), i, i2, i3, bool.booleanValue());
    }

    private static s a(m5 m5Var, int i, int i2, int i3, boolean z) {
        int iMax;
        int iMax2;
        int iMin;
        a0 a0VarA = m5Var.a();
        if (a0VarA != null) {
            int iC = a0VarA.c();
            int iB = a0VarA.b();
            if (z) {
                iMax = Math.max(i, iC);
                iMax2 = Math.max(i2, iB);
                int i4 = i3 * 2;
                iMin = Math.min((iMax - i4) / iC, (iMax2 - i4) / iB);
            } else {
                int i5 = i3 * 2;
                int i6 = iC + i5;
                int i7 = i5 + iB;
                iMax = Math.max(i, i6);
                iMax2 = Math.max(i2, i7);
                iMin = Math.min(iMax / i6, iMax2 / i7);
            }
            int i8 = (iMax - (iC * iMin)) / 2;
            int i9 = (iMax2 - (iB * iMin)) / 2;
            s sVar = new s(iMax, iMax2);
            int i10 = 0;
            while (i10 < iB) {
                int i11 = 0;
                int i12 = i8;
                while (i11 < iC) {
                    if (a0VarA.a(i11, i10) == 1) {
                        sVar.a(i12, i9, iMin, iMin);
                    }
                    i11++;
                    i12 += iMin;
                }
                i10++;
                i9 += iMin;
            }
            return sVar;
        }
        throw new IllegalStateException();
    }
}
