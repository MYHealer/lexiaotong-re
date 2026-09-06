package com.huawei.openalliance.ad.utils;

import android.text.TextUtils;
import com.huawei.hms.ads.fh;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class y {
    private static final String Code = "";
    private static final String V = "HexUtil";

    public static String Code(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static byte[] Code(String str) {
        StringBuilder sb;
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        try {
            byte[] bytes = upperCase.getBytes("UTF-8");
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (((byte) (Byte.decode("0x" + new String(new byte[]{bytes[i2]}, "UTF-8")).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[i2 + 1]}, "UTF-8")).byteValue());
            }
        } catch (NumberFormatException e) {
            e = e;
            sb = new StringBuilder("hex string 2 byte: ");
            fh.Z(V, sb.append(e.getClass().getSimpleName()).toString());
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder("hex string 2 byte: ");
            fh.Z(V, sb.append(e.getClass().getSimpleName()).toString());
        }
        return bArr;
    }
}
