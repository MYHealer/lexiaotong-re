package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* JADX INFO: compiled from: EAN8Writer.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class h2 extends t6 {
    @Override // com.huawei.hms.scankit.p.p4, com.huawei.hms.scankit.p.g7
    public s a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<k2, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_8) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.p4
    public boolean[] a(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + s6.b(str);
            } catch (a e) {
                throw new IllegalArgumentException(e);
            }
        } else if (length == 8) {
            try {
                if (!s6.a((CharSequence) str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (a unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + length);
        }
        boolean[] zArr = new boolean[67];
        int iA = p4.a(zArr, 0, s6.c, true);
        for (int i = 0; i <= 3; i++) {
            iA += p4.a(zArr, iA, s6.f[Character.digit(str.charAt(i), 10)], false);
        }
        int iA2 = iA + p4.a(zArr, iA, s6.d, false);
        for (int i2 = 4; i2 <= 7; i2++) {
            iA2 += p4.a(zArr, iA2, s6.f[Character.digit(str.charAt(i2), 10)], true);
        }
        p4.a(zArr, iA2, s6.c, true);
        return zArr;
    }
}
