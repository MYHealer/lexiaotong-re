package com.hihonor.secure.android.common.encrypt.keystore.aes;

import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.hihonor.secure.android.common.encrypt.utils.HexUtil;
import com.hihonor.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AesGcmKS {
    private static final String C = "AndroidKeyStore";
    private static final int F = 256;
    private static final String TAG = "AesGcmKS";
    private static final String i = "";
    private static final String l = "AES/GCM/NoPadding";
    private static final int n = 12;

    private static boolean isBuildVersionHigherThan22() {
        return true;
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.f(TAG, "alias or encrypt content is null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            b.f(TAG, "encrypt: UnsupportedEncodingException : " + e.getMessage());
            return "";
        }
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.f(TAG, "alias or encrypt content is null");
            return "";
        }
        try {
            return new String(decrypt(str, HexUtil.hexStr2ByteArray(str2)), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            b.f(TAG, "decrypt: UnsupportedEncodingException : " + e.getMessage());
            return "";
        }
    }

    private static synchronized SecretKey e(String str) {
        SecretKey secretKeyGenerateKey;
        secretKeyGenerateKey = null;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    KeyStore keyStore = KeyStore.getInstance(C);
                                    keyStore.load(null);
                                    Key key = keyStore.getKey(str, null);
                                    if (key != null && (key instanceof SecretKey)) {
                                        secretKeyGenerateKey = (SecretKey) key;
                                    } else {
                                        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", C);
                                        keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build());
                                        secretKeyGenerateKey = keyGenerator.generateKey();
                                    }
                                } catch (Exception e) {
                                    b.f(TAG, "Exception: " + e.getMessage());
                                }
                            } catch (NoSuchProviderException e2) {
                                b.f(TAG, "NoSuchProviderException : " + e2.getMessage());
                            }
                        } catch (NoSuchAlgorithmException e3) {
                            b.f(TAG, "NoSuchAlgorithmException : " + e3.getMessage());
                        }
                    } catch (UnrecoverableKeyException e4) {
                        b.f(TAG, "UnrecoverableKeyException : " + e4.getMessage());
                    }
                } catch (CertificateException e5) {
                    b.f(TAG, "CertificateException : " + e5.getMessage());
                }
            } catch (InvalidAlgorithmParameterException e6) {
                b.f(TAG, "InvalidAlgorithmParameterException : " + e6.getMessage());
            }
        } catch (IOException e7) {
            b.f(TAG, "IOException : " + e7.getMessage());
        } catch (KeyStoreException e8) {
            b.f(TAG, "KeyStoreException : " + e8.getMessage());
        }
        return secretKeyGenerateKey;
    }

    public static byte[] encrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.f(TAG, "alias or encrypt content is null");
            return bArr2;
        }
        if (!isBuildVersionHigherThan22()) {
            b.f(TAG, "sdk version is too low");
            return bArr2;
        }
        try {
            Cipher cipher = Cipher.getInstance(l);
            SecretKey secretKeyE = e(str);
            if (secretKeyE == null) {
                b.f(TAG, "Encrypt secret key is null");
                return bArr2;
            }
            cipher.init(1, secretKeyE);
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            byte[] iv = cipher.getIV();
            if (iv != null && iv.length == 12) {
                byte[] bArrCopyOf = Arrays.copyOf(iv, iv.length + bArrDoFinal.length);
                System.arraycopy(bArrDoFinal, 0, bArrCopyOf, iv.length, bArrDoFinal.length);
                return bArrCopyOf;
            }
            b.f(TAG, "IV is invalid.");
            return bArr2;
        } catch (InvalidKeyException e) {
            b.f(TAG, "InvalidKeyException : " + e.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e2) {
            b.f(TAG, "NoSuchAlgorithmException : " + e2.getMessage());
            return bArr2;
        } catch (BadPaddingException e3) {
            b.f(TAG, "BadPaddingException : " + e3.getMessage());
            return bArr2;
        } catch (IllegalBlockSizeException e4) {
            b.f(TAG, "IllegalBlockSizeException : " + e4.getMessage());
            return bArr2;
        } catch (NoSuchPaddingException e5) {
            b.f(TAG, "NoSuchPaddingException : " + e5.getMessage());
            return bArr2;
        } catch (Exception e6) {
            b.f(TAG, "Exception: " + e6.getMessage());
            return bArr2;
        }
    }

    public static byte[] decrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.f(TAG, "alias or encrypt content is null");
            return bArr2;
        }
        if (!isBuildVersionHigherThan22()) {
            b.f(TAG, "sdk version is too low");
            return bArr2;
        }
        if (bArr.length <= 12) {
            b.f(TAG, "Decrypt source data is invalid.");
            return bArr2;
        }
        SecretKey secretKeyE = e(str);
        if (secretKeyE == null) {
            b.f(TAG, "Decrypt secret key is null");
            return bArr2;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 12);
        try {
            Cipher cipher = Cipher.getInstance(l);
            cipher.init(2, secretKeyE, new GCMParameterSpec(128, bArrCopyOf));
            return cipher.doFinal(bArr, 12, bArr.length - 12);
        } catch (InvalidAlgorithmParameterException e) {
            b.f(TAG, "InvalidAlgorithmParameterException : " + e.getMessage());
            return bArr2;
        } catch (InvalidKeyException e2) {
            b.f(TAG, "InvalidKeyException : " + e2.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e3) {
            b.f(TAG, "NoSuchAlgorithmException : " + e3.getMessage());
            return bArr2;
        } catch (BadPaddingException e4) {
            b.f(TAG, "BadPaddingException : " + e4.getMessage());
            return bArr2;
        } catch (IllegalBlockSizeException e5) {
            b.f(TAG, "IllegalBlockSizeException : " + e5.getMessage());
            return bArr2;
        } catch (NoSuchPaddingException e6) {
            b.f(TAG, "NoSuchPaddingException : " + e6.getMessage());
            return bArr2;
        } catch (Exception e7) {
            b.f(TAG, "Exception: " + e7.getMessage());
            return bArr2;
        }
    }
}
