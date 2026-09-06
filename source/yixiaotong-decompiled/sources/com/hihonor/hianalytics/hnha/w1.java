package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import com.hihonor.secure.android.common.encrypt.utils.EncryptUtil;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public abstract class w1 {
    private static byte a(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static String a() {
        return "a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
    }

    public static String a(byte[] bArr) {
        return com.hihonor.hianalytics.util.i.a(bArr);
    }

    public static byte[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (a(charArray[i2 + 1]) | (a(charArray[i2]) << 4));
        }
        return bArr;
    }

    public static String b() {
        byte[] bArrGenerateSecureRandom;
        try {
            bArrGenerateSecureRandom = EncryptUtil.generateSecureRandom(16);
        } catch (Exception e) {
            j2.e("HianalyticsSDK", "HexUtil initAESRandomKey Exception:" + e.getMessage());
            bArrGenerateSecureRandom = null;
        }
        return a(bArrGenerateSecureRandom);
    }

    public static String c() {
        byte[] bArrGenerateSecureRandom;
        try {
            bArrGenerateSecureRandom = EncryptUtil.generateSecureRandom(128);
        } catch (Exception e) {
            j2.e("HianalyticsSDK", "HexUtil initAssembly Exception:" + e.getMessage());
            bArrGenerateSecureRandom = null;
        }
        return a(bArrGenerateSecureRandom);
    }
}
