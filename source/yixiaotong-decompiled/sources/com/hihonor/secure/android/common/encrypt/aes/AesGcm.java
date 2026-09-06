package com.hihonor.secure.android.common.encrypt.aes;

import android.text.TextUtils;
import com.hihonor.secure.android.common.encrypt.utils.EncryptUtil;
import com.hihonor.secure.android.common.encrypt.utils.HexUtil;
import com.hihonor.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class AesGcm {
    private static final String TAG = "AesGcm";
    private static final String f = "security:";
    private static final String h = "AES";
    private static final String i = "";
    private static final String l = "AES/GCM/NoPadding";
    private static final int m = 16;
    private static final int n = 12;
    private static final int o = 2;

    public static boolean isBuildVersionHigherThan19() {
        return true;
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !isBuildVersionHigherThan19()) {
            return "";
        }
        byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        if (bArrHexStr2ByteArray.length < 16) {
            b.f(TAG, "key length is not right");
            return "";
        }
        return encrypt(str, bArrHexStr2ByteArray);
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !isBuildVersionHigherThan19()) {
            return "";
        }
        byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        if (bArrHexStr2ByteArray.length < 16) {
            b.f(TAG, "key length is not right");
            return "";
        }
        return decrypt(str, bArrHexStr2ByteArray);
    }

    public static String encrypt(String str, byte[] bArr) {
        byte[] bArrGenerateSecureRandom;
        byte[] bArrA;
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16 || !isBuildVersionHigherThan19() || (bArrA = a(str, bArr, (bArrGenerateSecureRandom = EncryptUtil.generateSecureRandom(12)))) == null || bArrA.length == 0) {
            return "";
        }
        return HexUtil.byteArray2HexStr(bArrGenerateSecureRandom) + HexUtil.byteArray2HexStr(bArrA);
    }

    public static String decrypt(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16 && isBuildVersionHigherThan19()) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, h);
                Cipher cipher = Cipher.getInstance(l);
                String strA = a(str);
                String strB = b(str);
                if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strB)) {
                    cipher.init(2, secretKeySpec, getGcmAlgorithmParams(HexUtil.hexStr2ByteArray(strA)));
                    return new String(cipher.doFinal(HexUtil.hexStr2ByteArray(strB)), "UTF-8");
                }
                b.f(TAG, "ivParameter or encrypedWord is null");
                return "";
            } catch (UnsupportedEncodingException | GeneralSecurityException e) {
                b.f(TAG, "GCM decrypt data exception: " + e.getMessage());
            }
        }
        return "";
    }

    public static String encrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || !isBuildVersionHigherThan19()) {
            b.f(TAG, "gcm encrypt parameter is not right");
            return "";
        }
        byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] bArrHexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (bArrHexStr2ByteArray.length < 16 || str3.length() < 12) {
            b.f(TAG, "key length or iv length is not right");
            return "";
        }
        return encrypt(str, bArrHexStr2ByteArray, bArrHexStr2ByteArray2);
    }

    public static String decrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || !isBuildVersionHigherThan19()) {
            b.f(TAG, "gcm decrypt param is not right");
            return "";
        }
        byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] bArrHexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (bArrHexStr2ByteArray.length < 16 || bArrHexStr2ByteArray2.length < 12) {
            b.f(TAG, "key length or iv length is not right");
            return "";
        }
        return decrypt(str, bArrHexStr2ByteArray, bArrHexStr2ByteArray2);
    }

    public static String encrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16 || bArr2 == null || bArr2.length < 12 || !isBuildVersionHigherThan19()) {
            b.f(TAG, "gcm encrypt param is not right");
            return "";
        }
        return HexUtil.byteArray2HexStr(a(str, bArr, bArr2));
    }

    public static String decrypt(String str, byte[] bArr, byte[] bArr2) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16 && bArr2 != null && bArr2.length >= 12 && isBuildVersionHigherThan19()) {
            try {
                return new String(decrypt(HexUtil.hexStr2ByteArray(str), bArr, bArr2), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                b.f(TAG, "GCM decrypt data exception: " + e.getMessage());
            }
        }
        return "";
    }

    private static byte[] a(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16 || bArr2 == null || bArr2.length < 12 || !isBuildVersionHigherThan19()) {
            b.f(TAG, "gcm encrypt param is not right");
            return new byte[0];
        }
        try {
            return encrypt(str.getBytes("UTF-8"), bArr, bArr2);
        } catch (UnsupportedEncodingException e) {
            b.f(TAG, "GCM encrypt data error" + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length < 16 || bArr3 == null || bArr3.length < 12 || !isBuildVersionHigherThan19()) {
            b.f(TAG, "gcm encrypt param is not right");
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, h);
            Cipher cipher = Cipher.getInstance(l);
            cipher.init(1, secretKeySpec, getGcmAlgorithmParams(bArr3));
            return cipher.doFinal(bArr);
        } catch (GeneralSecurityException e) {
            b.f(TAG, "GCM encrypt data error" + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length < 16 || !isBuildVersionHigherThan19()) {
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, h);
            Cipher cipher = Cipher.getInstance(l);
            cipher.init(2, secretKeySpec, getGcmAlgorithmParams(bArr3));
            return cipher.doFinal(bArr);
        } catch (GeneralSecurityException e) {
            b.f(TAG, "GCM decrypt data exception: " + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] bArrGenerateSecureRandom = EncryptUtil.generateSecureRandom(12);
        return a(bArrGenerateSecureRandom, encrypt(bArr, bArr2, bArrGenerateSecureRandom));
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return decrypt(b(bArr), bArr2, a(bArr));
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[12];
        System.arraycopy(bArr, 0, bArr2, 0, 12);
        return bArr2;
    }

    private static byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length - 12];
        System.arraycopy(bArr, 12, bArr2, 0, bArr.length - 12);
        return bArr2;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 24) {
            b.f(TAG, "IV is invalid.");
            return "";
        }
        return str.substring(0, 24);
    }

    private static String b(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 24) ? "" : str.substring(24);
    }

    public static String decryptWithCryptHead(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String strC = AesCbc.c(str);
            if ("".equals(strC)) {
                return "";
            }
            int iIndexOf = strC.indexOf(58);
            if (iIndexOf >= 0) {
                return decrypt(HexUtil.byteArray2HexStr(HexUtil.hexStr2ByteArray(strC.substring(iIndexOf + 1))), bArr, HexUtil.hexStr2ByteArray(strC.substring(0, iIndexOf)));
            }
            b.f(TAG, " gcm cipherText data missing colon");
        }
        return "";
    }

    public static String decryptWithCryptHead(byte[] bArr, byte[] bArr2) {
        try {
            return new String(decryptWithCryptHeadReturnByte(bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            b.f(TAG, "UnsupportedEncodingException");
            return "";
        }
    }

    public static byte[] decryptWithCryptHeadReturnByte(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < 16) {
            return new byte[0];
        }
        byte[] bArrC = AesCbc.c(bArr);
        if (bArrC.length == 0) {
            return new byte[0];
        }
        int iD = d(bArrC);
        if (iD >= 0) {
            byte[] bArrCopyOf = Arrays.copyOf(bArrC, iD);
            int length = (bArrC.length - bArrCopyOf.length) - 1;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArrC, iD + 1, bArr3, 0, length);
            return decrypt(bArr3, bArr2, bArrCopyOf);
        }
        b.f(TAG, " gcm cipherText data missing colon");
        return new byte[0];
    }

    private static int d(byte[] bArr) {
        return bArr[12] == 58 ? 12 : -1;
    }

    public static AlgorithmParameterSpec getGcmAlgorithmParams(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }
}
