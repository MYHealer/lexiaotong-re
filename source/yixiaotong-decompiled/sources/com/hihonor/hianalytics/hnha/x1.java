package com.hihonor.hianalytics.hnha;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class x1 {

    public static class a extends Exception {
        public a() {
            super("Fail to encrypt with RSA");
        }
    }

    public static String a(String str, String str2) {
        try {
            return b(str, str2);
        } catch (a unused) {
            j2.g("RsaCryPter", "rsaEncrypt(): Fail to encrypt with RSA!");
            return "";
        }
    }

    private static PublicKey a(String str) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(w1.a(str)));
    }

    private static byte[] a(String str, byte[] bArr) throws a {
        try {
            PublicKey publicKeyA = a(str);
            if (publicKeyA == null) {
                throw new UnsupportedEncodingException();
            }
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
            cipher.init(1, publicKeyA);
            return cipher.doFinal(bArr);
        } catch (UnsupportedEncodingException unused) {
            j2.g("RsaCryPter", "rsaEncrypt(): getBytes - Unsupported coding format!");
            throw new a();
        } catch (InvalidKeyException unused2) {
            j2.g("RsaCryPter", "rsaEncrypt(): init - Invalid key!");
            throw new a();
        } catch (NoSuchAlgorithmException unused3) {
            j2.g("RsaCryPter", "rsaEncrypt(): getInstance - No such algorithm,transformation");
            throw new a();
        } catch (InvalidKeySpecException unused4) {
            j2.g("RsaCryPter", "rsaEncrypt(): Invalid key specification");
            throw new a();
        } catch (BadPaddingException unused5) {
            j2.g("RsaCryPter", "rsaEncrypt():False filling parameters!");
            throw new a();
        } catch (IllegalBlockSizeException unused6) {
            j2.g("RsaCryPter", "rsaEncrypt(): doFinal - The provided block is not filled with");
            throw new a();
        } catch (NoSuchPaddingException unused7) {
            j2.g("RsaCryPter", "rsaEncrypt():  No such filling parameters ");
            throw new a();
        }
    }

    private static String b(String str, String str2) throws a {
        try {
            return w1.a(a(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException unused) {
            j2.g("RsaCryPter", "rsaEncrypt(): Unsupported Encoding - utf-8!");
            throw new a();
        }
    }
}
