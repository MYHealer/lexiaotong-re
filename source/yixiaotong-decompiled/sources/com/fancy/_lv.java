package com.fancy;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _lv {
    public static String _a(String str) {
        try {
            _ls._e.getClass();
            byte[] bArr_a = _ls._a(str);
            byte[] bArr = _lu._a;
            int length = bArr_a.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                if (i2 >= 3) {
                    i2 = 0;
                }
                bArr_a[i] = (byte) (bArr_a[i] ^ bArr[i2]);
                i++;
                i2++;
            }
            return new String(bArr_a, Charset.forName("UTF-8"));
        } catch (Exception unused) {
            return "";
        }
    }
}
