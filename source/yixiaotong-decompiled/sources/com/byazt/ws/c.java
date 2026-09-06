package com.byazt.ws;

import com.kuaishou.weapon.p0.bg;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 2290, 20})
public class c {
    public static String c(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder(".");
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            if (i2 > 0 && i2 % i == 0 && i2 != bArr.length - 1) {
                sb.append(bg.j);
            }
        }
        return sb.toString();
    }

    public static byte[] c(String str) {
        String strReplaceAll = str.replaceAll("/", "").replaceAll("\\.", "");
        int length = strReplaceAll.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(strReplaceAll.charAt(i), 16) << 4) + Character.digit(strReplaceAll.charAt(i + 1), 16));
        }
        return bArr;
    }
}
