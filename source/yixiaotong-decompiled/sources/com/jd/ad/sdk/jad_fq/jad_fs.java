package com.jd.ad.sdk.jad_fq;

import android.text.TextUtils;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_fs {
    public static final char[] jad_an = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String jad_an(String str) {
        byte[] bArrDecode;
        return (TextUtils.isEmpty(str) || (bArrDecode = Base64.decode(str.getBytes(), 10)) == null) ? "" : new String(bArrDecode);
    }

    public static String jad_bo(String str) {
        byte[] bArrDigest;
        int length;
        if (str == null || str.length() == 0) {
            return "";
        }
        byte[] bytes = str.getBytes();
        if (bytes == null || bytes.length <= 0) {
            bArrDigest = null;
        } else {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bytes);
                bArrDigest = messageDigest.digest();
            } catch (NoSuchAlgorithmException unused) {
                bArrDigest = null;
            }
        }
        if (bArrDigest == null || (length = bArrDigest.length) <= 0) {
            return "";
        }
        char[] cArr = new char[length << 1];
        int i = 0;
        for (byte b : bArrDigest) {
            int i2 = i + 1;
            char[] cArr2 = jad_an;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }
}
