package com.alipay.sdk.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f1640a = "DESede/CBC/PKCS5Padding";

    public static byte[] a(String str, byte[] bArr, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
            Cipher cipher = Cipher.getInstance(f1640a);
            cipher.init(1, secretKeySpec, new IvParameterSpec(d.a(cipher, str2)));
            return cipher.doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
            Cipher cipher = Cipher.getInstance(f1640a);
            cipher.init(2, secretKeySpec, new IvParameterSpec(d.a(cipher, str2)));
            return cipher.doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str, String str2, String str3) {
        try {
            return a.a(a(str, str2.getBytes(), str3));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(String str, String str2, String str3) {
        try {
            return new String(b(str, a.a(str2), str3));
        } catch (Exception unused) {
            return null;
        }
    }
}
