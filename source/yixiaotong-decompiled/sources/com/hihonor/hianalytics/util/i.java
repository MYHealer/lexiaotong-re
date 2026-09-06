package com.hihonor.hianalytics.util;

import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.secure.android.common.encrypt.hash.SHA;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f3717a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(String str) {
        return SHA.sha256Encrypt(str);
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            char[] cArr = f3717a;
            sb.append(cArr[(b & 240) >> 4]).append(cArr[b & 15]);
        }
        return sb.toString();
    }

    public static byte[] a(String str, String str2) {
        String str3;
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(Charset.forName("UTF-8")), "HmacSHA256");
        try {
            Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
            mac.init(secretKeySpec);
            return mac.doFinal(bytes);
        } catch (InvalidKeyException unused) {
            str3 = "Exception has happened when digest2byte,From Invalid key!";
            j2.g("HiAnalyticsHexUtil", str3);
            return new byte[0];
        } catch (NoSuchAlgorithmException unused2) {
            str3 = "When digest2byte executed Exception has happened!From Algorithm error !";
            j2.g("HiAnalyticsHexUtil", str3);
            return new byte[0];
        }
    }
}
