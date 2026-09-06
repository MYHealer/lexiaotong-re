package com.hihonor.secure.android.common.encrypt.aes;

import android.text.TextUtils;
import com.hihonor.secure.android.common.encrypt.utils.EncryptUtil;
import com.hihonor.secure.android.common.encrypt.utils.HexUtil;
import com.hihonor.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class AesCbc {
    private static final String TAG = "AesCbc";
    private static final String f = "security:";
    private static final String g = "AES/CBC/PKCS5Padding";
    private static final String h = "AES";
    private static final String i = "";
    private static final int j = 16;
    private static final int k = 16;

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.f(TAG, "cbc encrypt param is not right");
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
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.f(TAG, "content or key is null");
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
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16) {
            b.f(TAG, "cbc encrypt param is not right");
            return "";
        }
        byte[] bArrGenerateSecureRandom = EncryptUtil.generateSecureRandom(16);
        byte[] bArrA = a(str, bArr, bArrGenerateSecureRandom);
        return (bArrA == null || bArrA.length == 0) ? "" : a(HexUtil.byteArray2HexStr(bArrGenerateSecureRandom), HexUtil.byteArray2HexStr(bArrA));
    }

    public static String decrypt(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String strA = a(str);
            String strB = b(str);
            if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strB)) {
                b.f(TAG, "ivParameter or encrypedWord is null");
            } else {
                return decrypt(strB, bArr, HexUtil.hexStr2ByteArray(strA));
            }
        }
        return "";
    }

    public static String encrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            b.f(TAG, "cbc encrypt param is not right");
            return "";
        }
        byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] bArrHexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (bArrHexStr2ByteArray.length < 16 || bArrHexStr2ByteArray2.length < 16) {
            b.f(TAG, "key length or ivParameter length is not right");
            return "";
        }
        return encrypt(str, bArrHexStr2ByteArray, bArrHexStr2ByteArray2);
    }

    public static String decrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            b.f(TAG, "cbc decrypt param is not right");
            return "";
        }
        byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] bArrHexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (bArrHexStr2ByteArray.length < 16 || bArrHexStr2ByteArray2.length < 16) {
            b.f(TAG, "key length or ivParameter is not right");
            return "";
        }
        return decrypt(str, bArrHexStr2ByteArray, bArrHexStr2ByteArray2);
    }

    public static String encrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16 || bArr2 == null || bArr2.length < 16) {
            b.f(TAG, "cbc encrypt param is not right");
            return "";
        }
        return HexUtil.byteArray2HexStr(a(str, bArr, bArr2));
    }

    private static byte[] a(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            b.f(TAG, "cbc encrypt param is not right");
            return new byte[0];
        }
        try {
            return encrypt(str.getBytes("UTF-8"), bArr, bArr2);
        } catch (UnsupportedEncodingException e) {
            b.f(TAG, " cbc encrypt data error" + e.getMessage());
            return new byte[0];
        }
    }

    public static String decrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16 || bArr2 == null || bArr2.length < 16) {
            b.f(TAG, "cbc decrypt param is not right");
            return "";
        }
        try {
            return new String(decrypt(HexUtil.hexStr2ByteArray(str), bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            b.f(TAG, " cbc decrypt data error" + e.getMessage());
            return "";
        }
    }

    private static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return str2.substring(0, 6) + str.substring(0, 6) + str2.substring(6, 10) + str.substring(6, 16) + str2.substring(10, 16) + str.substring(16) + str2.substring(16);
            } catch (Exception e) {
                b.f(TAG, "mix exception: " + e.getMessage());
            }
        }
        return "";
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length < 16 || bArr3 == null || bArr3.length < 16) {
            b.f(TAG, "cbc encrypt param is not right");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, h);
        try {
            Cipher cipher = Cipher.getInstance(g);
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException e) {
            b.f(TAG, "InvalidAlgorithmParameterException: " + e.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e2) {
            b.f(TAG, "InvalidKeyException: " + e2.getMessage());
            return new byte[0];
        } catch (NoSuchAlgorithmException e3) {
            b.f(TAG, "NoSuchAlgorithmException: " + e3.getMessage());
            return new byte[0];
        } catch (BadPaddingException e4) {
            b.f(TAG, "BadPaddingException: " + e4.getMessage());
            return new byte[0];
        } catch (IllegalBlockSizeException e5) {
            b.f(TAG, "IllegalBlockSizeException: " + e5.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e6) {
            b.f(TAG, "NoSuchPaddingException: " + e6.getMessage());
            return new byte[0];
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length < 16 || bArr3 == null || bArr3.length < 16) {
            b.f(TAG, "cbc decrypt param is not right");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, h);
        try {
            Cipher cipher = Cipher.getInstance(g);
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException e) {
            b.f(TAG, "InvalidAlgorithmParameterException: " + e.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e2) {
            b.f(TAG, "InvalidKeyException: " + e2.getMessage());
            return new byte[0];
        } catch (NoSuchAlgorithmException e3) {
            b.f(TAG, "NoSuchAlgorithmException: " + e3.getMessage());
            return new byte[0];
        } catch (BadPaddingException e4) {
            b.f(TAG, "BadPaddingException: " + e4.getMessage());
            return new byte[0];
        } catch (IllegalBlockSizeException e5) {
            b.f(TAG, "IllegalBlockSizeException: " + e5.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e6) {
            b.f(TAG, "NoSuchPaddingException: " + e6.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] bArrGenerateSecureRandom = EncryptUtil.generateSecureRandom(16);
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
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        return bArr2;
    }

    private static byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length - 16];
        System.arraycopy(bArr, 16, bArr2, 0, bArr.length - 16);
        return bArr2;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(6, 12) + str.substring(16, 26) + str.substring(32, 48);
        } catch (Exception e) {
            b.f(TAG, "getIv exception : " + e.getMessage());
            return "";
        }
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(0, 6) + str.substring(12, 16) + str.substring(26, 32) + str.substring(48);
        } catch (Exception e) {
            b.f(TAG, "get encryptword exception : " + e.getMessage());
            return "";
        }
    }

    static String c(String str) {
        return (TextUtils.isEmpty(str) || str.indexOf(f) == -1) ? "" : str.substring(9);
    }

    static byte[] c(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            b.f(TAG, "stripCryptHead: exception : " + e.getMessage());
            str = "";
        }
        if (!str.startsWith(f)) {
            return new byte[0];
        }
        if (bArr.length <= 9) {
            return new byte[0];
        }
        int length = bArr.length - 9;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 9, bArr2, 0, length);
        return bArr2;
    }

    public static String decryptWithCryptHead(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String strC = c(str);
            if ("".equals(strC)) {
                return "";
            }
            int iIndexOf = strC.indexOf(58);
            if (iIndexOf >= 0) {
                return decrypt(HexUtil.byteArray2HexStr(HexUtil.hexStr2ByteArray(strC.substring(iIndexOf + 1))), bArr, HexUtil.hexStr2ByteArray(strC.substring(0, iIndexOf)));
            }
            b.f(TAG, " cbc cipherText data missing colon");
        }
        return "";
    }

    public static String decryptWithCryptHead(byte[] bArr, byte[] bArr2) {
        try {
            return new String(decryptWithCryptHeadReturnByte(bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            b.f(TAG, "decryptWithCryptHead UnsupportedEncodingException ");
            return "";
        }
    }

    public static byte[] decryptWithCryptHeadReturnByte(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < 16) {
            return new byte[0];
        }
        byte[] bArrC = c(bArr);
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
        b.f(TAG, " cbc cipherText data missing colon");
        return new byte[0];
    }

    private static int d(byte[] bArr) {
        return bArr[16] == 58 ? 16 : -1;
    }
}
