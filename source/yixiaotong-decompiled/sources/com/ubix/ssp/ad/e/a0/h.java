package com.ubix.ssp.ad.e.a0;

import android.text.TextUtils;
import com.yfanads.android.libs.utils.Util;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class h {
    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals("")) {
            try {
                String str2 = "";
                for (byte b : MessageDigest.getInstance("MD5").digest(str.getBytes())) {
                    String hexString = Integer.toHexString(b & 255);
                    if (hexString.length() == 1) {
                        hexString = "0" + hexString;
                    }
                    str2 = str2 + hexString;
                }
                return str2;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String a(String str, String str2) {
        try {
            if (str2 == null) {
                System.out.print("Key为空null");
                return null;
            }
            if (str2.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), "AES");
            Cipher cipher = Cipher.getInstance(Util.ALGORITHM7);
            cipher.init(1, secretKeySpec);
            return a(cipher.doFinal(str.getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i <= length - 1; i++) {
            char cForDigit = Character.forDigit((bArr[i] >> 4) & 15, 16);
            char cForDigit2 = Character.forDigit(bArr[i] & 15, 16);
            sb.append(cForDigit);
            sb.append(cForDigit2);
        }
        return sb.toString();
    }
}
