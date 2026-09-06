package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* JADX INFO: compiled from: AztecWriter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class i implements g7 {
    @Override // com.huawei.hms.scankit.p.g7
    public s a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<k2, ?> map) {
        Charset charsetForName = StandardCharsets.ISO_8859_1;
        int i3 = 33;
        int i4 = 0;
        int i5 = 4;
        if (map != null) {
            k2 k2Var = k2.CHARACTER_SET;
            if (map.containsKey(k2Var)) {
                charsetForName = Charset.forName(map.get(k2Var).toString());
            }
            k2 k2Var2 = k2.ERROR_CORRECTION;
            i3 = map.containsKey(k2Var2) ? Integer.parseInt(map.get(k2Var2).toString()) : 33;
            k2 k2Var3 = k2.AZTEC_LAYERS;
            i4 = map.containsKey(k2Var3) ? Integer.parseInt(map.get(k2Var3).toString()) : 0;
            k2 k2Var4 = k2.MARGIN;
            if (map.containsKey(k2Var4)) {
                i5 = Integer.parseInt(map.get(k2Var4).toString());
            }
        }
        return a(str, barcodeFormat, i, i2, charsetForName, i3, i4, i5);
    }

    private static s a(String str, BarcodeFormat barcodeFormat, int i, int i2, Charset charset, int i3, int i4, int i5) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return a(n2.a(str.getBytes(charset), i3, i4), i, i2, i5);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
    }

    private static s a(f fVar, int i, int i2, int i3) {
        s sVarA = fVar.a();
        if (sVarA != null) {
            int iE = sVarA.e();
            int iC = sVarA.c();
            int i4 = i3 * 2;
            int i5 = iE + i4;
            int i6 = i4 + iC;
            int iMax = Math.max(i, i5);
            int iMax2 = Math.max(i2, i6);
            int iMin = Math.min(iMax / i5, iMax2 / i6);
            int i7 = (iMax - (iE * iMin)) / 2;
            int i8 = (iMax2 - (iC * iMin)) / 2;
            s sVar = new s(iMax, iMax2);
            int i9 = 0;
            while (i9 < iC) {
                int i10 = 0;
                int i11 = i7;
                while (i10 < iE) {
                    if (sVarA.b(i10, i9)) {
                        sVar.a(i11, i8, iMin, iMin);
                    }
                    i10++;
                    i11 += iMin;
                }
                i9++;
                i8 += iMin;
            }
            return sVar;
        }
        throw new IllegalStateException();
    }
}
