package com.hihonor.hianalytics.hnha;

import android.util.Pair;
import com.hihonor.secure.android.common.encrypt.aes.AesCbc;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class s1 {
    public static Pair<byte[], String> a(String str) {
        if (str == null || str.length() < 32) {
            return new Pair<>(new byte[0], str);
        }
        String strSubstring = str.substring(0, 32);
        return new Pair<>(w1.a(strSubstring), str.substring(32));
    }

    public static Pair<Boolean, String> a(String str, String str2) {
        long jA = com.hihonor.hianalytics.util.r.a();
        Pair<byte[], String> pairA = a(str);
        byte[] bArrA = w1.a((String) pairA.second);
        byte[] bArrA2 = w1.a(str2);
        byte[] bArr = (byte[]) pairA.first;
        byte[] bArrDecrypt = AesCbc.decrypt(bArrA, bArrA2, bArr);
        int length = bArrA.length;
        int length2 = bArrA2.length;
        int length3 = bArr == null ? 0 : bArr.length;
        int length4 = bArrDecrypt == null ? 0 : bArrDecrypt.length;
        boolean z = length4 > 0;
        j2.a(z ? 2 : 5, "AesCipher", "decrypt spendTime=" + (com.hihonor.hianalytics.util.r.a() - jA) + ",len1=" + length + ",len2=" + length2 + ",len3=" + length3 + ",len4=" + length4);
        return Pair.create(Boolean.valueOf(z), new String(bArrDecrypt, i.f3644a));
    }

    public static Pair<Boolean, String> b(String str, String str2) {
        long jA = com.hihonor.hianalytics.util.r.a();
        byte[] bytes = str.getBytes(i.f3644a);
        byte[] bArrA = w1.a(str2);
        int length = bytes == null ? 0 : bytes.length;
        int length2 = bArrA.length;
        if (length == 0 || length2 == 0) {
            j2.e("AesCipher", "enCrypt spendTime=" + (com.hihonor.hianalytics.util.r.a() - jA) + ",len1=" + length + ",len2=" + length2);
            return Pair.create(Boolean.TRUE, null);
        }
        byte[] bArrEncrypt = AesCbc.encrypt(bytes, bArrA);
        int length3 = bArrEncrypt == null ? 0 : bArrEncrypt.length;
        boolean z = length3 > 16;
        j2.a(z ? 2 : 5, "AesCipher", "encrypt spendTime=" + (com.hihonor.hianalytics.util.r.a() - jA) + ",len1=" + length + ",len2=" + length2 + ",len3=" + length3);
        return Pair.create(Boolean.valueOf(z), w1.a(bArrEncrypt));
    }
}
