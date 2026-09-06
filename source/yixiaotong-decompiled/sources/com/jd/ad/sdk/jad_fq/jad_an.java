package com.jd.ad.sdk.jad_fq;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an {
    public static String jad_an(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (str.length() <= 59) {
            return "";
        }
        String strSubstring = str.substring(0, 59);
        String strSubstring2 = str.substring(59);
        String strJad_cp = jad_cp(strSubstring);
        String strJad_dq = jad_dq(strSubstring);
        SecretKeySpec secretKeySpec = new SecretKeySpec(strJad_cp.getBytes("UTF-8"), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(strJad_dq.getBytes("UTF-8"));
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return new String(cipher.doFinal(Base64.decode(strSubstring2, 8)), "UTF-8");
    }

    public static byte[] jad_bo(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        int iNextInt = new SecureRandom().nextInt(10);
        String strSubstring = "abcdefghij".substring(iNextInt, iNextInt + 1);
        StringBuilder sb = new StringBuilder(58);
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < 58; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(secureRandom.nextInt(62)));
        }
        String str2 = strSubstring + sb.toString();
        String strJad_cp = jad_cp(str2);
        String strJad_dq = jad_dq(str2);
        SecretKeySpec secretKeySpec = new SecretKeySpec(strJad_cp.getBytes("UTF-8"), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(strJad_dq.getBytes("UTF-8"));
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, ivParameterSpec);
        return (str2 + Base64.encodeToString(cipher.doFinal(str.getBytes("UTF-8")), 11)).getBytes(StandardCharsets.UTF_8);
    }

    public static String jad_cp(String str) {
        int iIndexOf;
        return (str == null || (iIndexOf = "abcdefghij".indexOf(str.substring(0, 1))) == -1) ? "" : str.substring(iIndexOf + 1, iIndexOf + 33);
    }

    public static String jad_dq(String str) {
        int iIndexOf;
        return (str == null || (iIndexOf = "abcdefghij".indexOf(str.substring(0, 1))) == -1) ? "" : str.substring(iIndexOf + 33, iIndexOf + 49);
    }
}
