package com.hihonor.secure.android.common.encrypt.aes;

import com.hihonor.secure.android.common.encrypt.utils.EncryptUtil;
import com.hihonor.secure.android.common.encrypt.utils.HexUtil;
import com.hihonor.secure.android.common.encrypt.utils.b;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class CipherUtil {
    private static final String TAG = "CipherUtil";
    private static final String g = "AES/CBC/PKCS5Padding";
    private static final String h = "AES";
    private static final String i = "";
    private static final int k = 16;
    private static final String l = "AES/GCM/NoPadding";
    private static final int m = 16;
    private static final int n = 12;

    public static Cipher getAesGcmEncryptCipher(byte[] bArr) {
        byte[] bArrGenerateSecureRandom = EncryptUtil.generateSecureRandom(12);
        b.c(TAG, "getEncryptCipher: iv is : " + HexUtil.byteArray2HexStr(bArrGenerateSecureRandom));
        return getAesGcmEncryptCipher(bArr, bArrGenerateSecureRandom);
    }

    public static int getAesGcmEncryptContentLen(byte[] bArr, byte[] bArr2) {
        return getAesGcmEncryptContentLen(bArr, bArr2, EncryptUtil.generateSecureRandom(12));
    }

    public static Cipher getAesGcmDecryptCipher(byte[] bArr, Cipher cipher) {
        return getAesGcmDecryptCipher(bArr, cipher.getIV());
    }

    public static Cipher getAesCbcEncryptCipher(byte[] bArr) {
        return getAesCbcEncryptCipher(bArr, EncryptUtil.generateSecureRandom(16));
    }

    public static int getAesCbcEncryptContentLen(byte[] bArr, byte[] bArr2) {
        return getAesCbcEncryptContentLen(bArr, bArr2, EncryptUtil.generateSecureRandom(16));
    }

    public static Cipher getAesCbcDecryptCipher(byte[] bArr, Cipher cipher) {
        return getAesCbcDecryptCipher(bArr, cipher.getIV());
    }

    public static Cipher getAesGcmEncryptCipher(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, 1);
    }

    public static int getAesGcmEncryptContentLen(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(getAesGcmEncryptCipher(bArr2, bArr3), bArr);
    }

    public static Cipher getAesGcmDecryptCipher(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, 2);
    }

    public static Cipher getAesCbcEncryptCipher(byte[] bArr, byte[] bArr2) {
        return b(bArr, bArr2, 1);
    }

    public static int getAesCbcEncryptContentLen(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(getAesCbcEncryptCipher(bArr2, bArr3), bArr);
    }

    public static Cipher getAesCbcDecryptCipher(byte[] bArr, byte[] bArr2) {
        return b(bArr, bArr2, 2);
    }

    private static Cipher a(byte[] bArr, byte[] bArr2, int i2) {
        return a(bArr, bArr2, i2, l);
    }

    private static Cipher b(byte[] bArr, byte[] bArr2, int i2) {
        return a(bArr, bArr2, i2, g);
    }

    private static Cipher a(byte[] bArr, byte[] bArr2, int i2, String str) {
        AlgorithmParameterSpec ivParameterSpec;
        if (bArr == null || bArr.length < 16 || bArr2 == null || bArr2.length < 12 || !AesGcm.isBuildVersionHigherThan19()) {
            b.f(TAG, "gcm encrypt param is not right");
            return null;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, h);
            Cipher cipher = Cipher.getInstance(str);
            if (l.equals(str)) {
                ivParameterSpec = AesGcm.getGcmAlgorithmParams(bArr2);
            } else {
                ivParameterSpec = new IvParameterSpec(bArr2);
            }
            cipher.init(i2, secretKeySpec, ivParameterSpec);
            return cipher;
        } catch (GeneralSecurityException e) {
            b.f(TAG, "GCM encrypt data error" + e.getMessage());
            return null;
        }
    }

    private static int a(Cipher cipher, byte[] bArr) {
        if (cipher == null || bArr == null) {
            return -1;
        }
        return cipher.getOutputSize(bArr.length);
    }

    public static int getContent(Cipher cipher, byte[] bArr, byte[] bArr2) {
        if (cipher == null || bArr == null) {
            b.f(TAG, "getEncryptCOntent: cipher is null or content is null");
            return -1;
        }
        try {
            return cipher.doFinal(bArr, 0, bArr.length, bArr2);
        } catch (BadPaddingException unused) {
            b.f(TAG, "getContent: BadPaddingException");
            return -1;
        } catch (IllegalBlockSizeException unused2) {
            b.f(TAG, "getContent: IllegalBlockSizeException");
            return -1;
        } catch (ShortBufferException unused3) {
            b.f(TAG, "getContent: ShortBufferException");
            return -1;
        }
    }

    public static byte[] getContent(Cipher cipher, byte[] bArr) {
        if (cipher == null || bArr == null) {
            b.f(TAG, "getEncryptCOntent: cipher is null or content is null");
            return new byte[0];
        }
        try {
            return cipher.doFinal(bArr, 0, bArr.length);
        } catch (BadPaddingException unused) {
            b.f(TAG, "getContent: BadPaddingException");
            return new byte[0];
        } catch (IllegalBlockSizeException unused2) {
            b.f(TAG, "getContent: IllegalBlockSizeException");
            return new byte[0];
        }
    }
}
