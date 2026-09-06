package com.ubix.ssp.ad.e.a0;

import android.util.Base64;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f8625a = new String(Base64.decode("MTIzNDU2Nzg5", 0)).concat(new String(Base64.decode("MDEyMzQ1Ng==", 0)));
    private static String b = new String(Base64.decode("MTIzNDU2Nzg5", 0)).concat(new String(Base64.decode("MDEyMzQ1Ng==", 0)));

    public static String a(byte[] bArr) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(f8625a.getBytes(Charset.forName("UTF-8")), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(b.getBytes(Charset.forName("UTF-8"))));
            return new String(cipher.doFinal(bArr));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b(byte[] bArr) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(f8625a.getBytes(Charset.forName("UTF-8")), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(b.getBytes(Charset.forName("UTF-8"))));
            return new String(Base64.encode(cipher.doFinal(bArr), 10));
        } catch (Exception unused) {
            return "";
        }
    }
}
