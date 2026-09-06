package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* JADX INFO: compiled from: EAN13Writer.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class f2 extends t6 {
    @Override // com.huawei.hms.scankit.p.p4, com.huawei.hms.scankit.p.g7
    public s a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<k2, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.p4
    public boolean[] a(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + s6.b(str);
            } catch (a e) {
                throw new IllegalArgumentException(e);
            }
        } else if (length == 13) {
            try {
                if (!s6.a((CharSequence) str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (a unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got " + length);
        }
        int i = e2.j[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int iA = p4.a(zArr, 0, s6.c, true);
        for (int i2 = 1; i2 <= 6; i2++) {
            int iDigit = Character.digit(str.charAt(i2), 10);
            if (((i >> (6 - i2)) & 1) == 1) {
                iDigit += 10;
            }
            iA += p4.a(zArr, iA, s6.g[iDigit], false);
        }
        int iA2 = iA + p4.a(zArr, iA, s6.d, false);
        for (int i3 = 7; i3 <= 12; i3++) {
            iA2 += p4.a(zArr, iA2, s6.f[Character.digit(str.charAt(i3), 10)], true);
        }
        p4.a(zArr, iA2, s6.c, true);
        return zArr;
    }
}
