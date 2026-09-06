package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: compiled from: PDF417Writer.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a5 implements g7 {
    @Override // com.huawei.hms.scankit.p.g7
    public s a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<k2, ?> map) throws WriterException {
        if (barcodeFormat != BarcodeFormat.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + barcodeFormat);
        }
        r4 r4Var = new r4();
        int i3 = 30;
        int i4 = 2;
        if (map != null) {
            k2 k2Var = k2.PDF417_COMPACT;
            if (map.containsKey(k2Var)) {
                r4Var.a(Boolean.valueOf(map.get(k2Var).toString()).booleanValue());
            }
            k2 k2Var2 = k2.PDF417_COMPACTION;
            if (map.containsKey(k2Var2)) {
                r4Var.a(v0.valueOf(map.get(k2Var2).toString()));
            }
            k2 k2Var3 = k2.PDF417_DIMENSIONS;
            if (map.containsKey(k2Var3)) {
                c2 c2Var = (c2) map.get(k2Var3);
                r4Var.b(c2Var.a(), c2Var.c(), c2Var.b(), c2Var.d());
            }
            k2 k2Var4 = k2.MARGIN;
            i3 = map.containsKey(k2Var4) ? Integer.parseInt(map.get(k2Var4).toString()) : 30;
            k2 k2Var5 = k2.ERROR_CORRECTION;
            i4 = map.containsKey(k2Var5) ? Integer.parseInt(map.get(k2Var5).toString()) : 2;
            k2 k2Var6 = k2.CHARACTER_SET;
            if (map.containsKey(k2Var6)) {
                r4Var.a(Charset.forName(map.get(k2Var6).toString()));
            }
        }
        return a(r4Var, str, i4, i, i2, i3);
    }

    private static s a(r4 r4Var, String str, int i, int i2, int i3, int i4) throws WriterException {
        r4Var.a(str, i);
        byte[][] bArrA = r4Var.a().a(1, 4);
        int length = i2 / bArrA[0].length;
        int length2 = i3 / bArrA.length;
        if (length >= length2) {
            length = length2;
        }
        if (length > 1) {
            return a(r4Var.a().a(length, length * 4), i4);
        }
        return a(bArrA, i4);
    }

    private static s a(byte[][] bArr, int i) {
        int i2 = i * 2;
        s sVar = new s(bArr[0].length + i2, bArr.length + i2);
        sVar.a();
        int iC = (sVar.c() - i) - 1;
        int i3 = 0;
        while (i3 < bArr.length) {
            byte[] bArr2 = bArr[i3];
            for (int i4 = 0; i4 < bArr[0].length; i4++) {
                if (bArr2[i4] == 1) {
                    sVar.c(i4 + i, iC);
                }
            }
            i3++;
            iC--;
        }
        return sVar;
    }
}
