package com.adprof.sdk;

import android.text.TextUtils;
import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f1181a = StandardCharsets.UTF_8;

    public static String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Exception e) {
            pk.b(e.getMessage());
            return "";
        }
    }

    public static String a(String str, String str2) {
        byte[] bArrM630a = m630a(str, str2);
        if (bArrM630a == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrM630a) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }

    public static String a(String str, String str2, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            m628a(str2);
            byte[] bArrA = a(z ? Base64.decode(str, 0) : m629a(str), str2);
            if (bArrA != null) {
                return new String(bArrA, StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            pk.b(e.getMessage());
        }
        return "";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m628a(String str) {
        int length = str.length();
        if (length != 16 && length != 24 && length != 32) {
            throw new IllegalArgumentException("密钥长度必须为 16、24 或 32 字节（对应 AES-128、AES-192、AES-256）");
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m629a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m630a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b(str.getBytes(f1181a), str2);
    }

    public static byte[] a(byte[] bArr, String str) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    m628a(str);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(m629a(str), "AES");
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    int blockSize = cipher.getBlockSize();
                    if (bArr.length < blockSize) {
                        return null;
                    }
                    byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, blockSize);
                    byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, blockSize, bArr.length);
                    cipher.init(2, secretKeySpec, new IvParameterSpec(bArrCopyOfRange));
                    return cipher.doFinal(bArrCopyOfRange2);
                }
            } catch (Exception e) {
                pk.b(e.getMessage());
            }
        }
        return null;
    }

    public static byte[] b(byte[] bArr, String str) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    m628a(str);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(m629a(str), "AES");
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    int blockSize = cipher.getBlockSize();
                    pk.d("blockSize=" + blockSize);
                    byte[] bArr2 = new byte[blockSize];
                    new SecureRandom().nextBytes(bArr2);
                    cipher.init(1, secretKeySpec, new IvParameterSpec(bArr2));
                    byte[] bArrDoFinal = cipher.doFinal(bArr);
                    byte[] bArr3 = new byte[bArrDoFinal.length + blockSize];
                    System.arraycopy(bArr2, 0, bArr3, 0, blockSize);
                    System.arraycopy(bArrDoFinal, 0, bArr3, blockSize, bArrDoFinal.length);
                    return bArr3;
                }
            } catch (Exception e) {
                pk.b(e.getMessage());
            }
        }
        return null;
    }
}
