package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
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
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class AesCbcKS {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4520a = "CBCKS";
    private static final String b = "AndroidKeyStore";
    private static final String c = "AES/CBC/PKCS7Padding";
    private static final String d = "";
    private static final int e = 16;
    private static final int f = 256;
    private static Map<String, SecretKey> g = new HashMap();

    private static synchronized SecretKey a(String str) {
        SecretKey secretKey;
        SecretKey secretKeyGenerateKey;
        b.c(f4520a, "load key");
        secretKey = null;
        try {
            try {
                try {
                    try {
                        try {
                            KeyStore keyStore = KeyStore.getInstance(b);
                            keyStore.load(null);
                            Key key = keyStore.getKey(str, null);
                            if (key == null || !(key instanceof SecretKey)) {
                                b.c(f4520a, "generate key");
                                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", b);
                                keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setKeySize(256).build());
                                secretKeyGenerateKey = keyGenerator.generateKey();
                            } else {
                                secretKeyGenerateKey = (SecretKey) key;
                            }
                            secretKey = secretKeyGenerateKey;
                        } catch (NoSuchProviderException e2) {
                            b.b(f4520a, "NoSuchProviderException: " + e2.getMessage());
                        }
                    } catch (KeyStoreException e3) {
                        b.b(f4520a, "KeyStoreException: " + e3.getMessage());
                    }
                } catch (IOException e4) {
                    b.b(f4520a, "IOException: " + e4.getMessage());
                } catch (InvalidAlgorithmParameterException e5) {
                    b.b(f4520a, "InvalidAlgorithmParameterException: " + e5.getMessage());
                }
            } catch (NoSuchAlgorithmException e6) {
                b.b(f4520a, "NoSuchAlgorithmException: " + e6.getMessage());
            } catch (UnrecoverableKeyException e7) {
                b.b(f4520a, "UnrecoverableKeyException: " + e7.getMessage());
            }
        } catch (CertificateException e8) {
            b.b(f4520a, "CertificateException: " + e8.getMessage());
        } catch (Exception e9) {
            b.b(f4520a, "Exception: " + e9.getMessage());
        }
        g.put(str, secretKey);
        return secretKey;
    }

    private static boolean a() {
        return true;
    }

    private static SecretKey b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (g.get(str) == null) {
            a(str);
        }
        return g.get(str);
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(f4520a, "alias or encrypt content is null");
            return "";
        }
        try {
            return new String(decrypt(str, HexUtil.hexStr2ByteArray(str2)), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            b.b(f4520a, "encrypt: UnsupportedEncodingException");
            return "";
        }
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            b.b(f4520a, "encrypt 1 content is null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException unused) {
            b.b(f4520a, "encrypt: UnsupportedEncodingException");
            return "";
        }
    }

    public static byte[] encrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(f4520a, "sdk version is too low");
                return bArr2;
            }
            try {
                Cipher cipher = Cipher.getInstance(c);
                SecretKey secretKeyB = b(str);
                if (secretKeyB == null) {
                    b.b(f4520a, "encrypt secret key is null");
                    return bArr2;
                }
                cipher.init(1, secretKeyB);
                byte[] bArrDoFinal = cipher.doFinal(bArr);
                byte[] iv = cipher.getIV();
                if (iv != null && iv.length == 16) {
                    byte[] bArrCopyOf = Arrays.copyOf(iv, iv.length + bArrDoFinal.length);
                    System.arraycopy(bArrDoFinal, 0, bArrCopyOf, iv.length, bArrDoFinal.length);
                    return bArrCopyOf;
                }
                b.b(f4520a, "IV is invalid.");
                return bArr2;
            } catch (InvalidKeyException e2) {
                b.b(f4520a, "InvalidKeyException: " + e2.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e3) {
                b.b(f4520a, "NoSuchAlgorithmException: " + e3.getMessage());
                return bArr2;
            } catch (BadPaddingException e4) {
                b.b(f4520a, "BadPaddingException: " + e4.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e5) {
                b.b(f4520a, "IllegalBlockSizeException: " + e5.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e6) {
                b.b(f4520a, "NoSuchPaddingException: " + e6.getMessage());
                return bArr2;
            } catch (Exception e7) {
                b.b(f4520a, "Exception: " + e7.getMessage());
                return bArr2;
            }
        }
        b.b(f4520a, "alias or encrypt content is null");
        return bArr2;
    }

    public static byte[] decrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(f4520a, "sdk version is too low");
                return bArr2;
            }
            if (bArr.length <= 16) {
                b.b(f4520a, "Decrypt source data is invalid.");
                return bArr2;
            }
            SecretKey secretKeyB = b(str);
            if (secretKeyB == null) {
                b.b(f4520a, "decrypt secret key is null");
                return bArr2;
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 16);
            try {
                Cipher cipher = Cipher.getInstance(c);
                cipher.init(2, secretKeyB, new IvParameterSpec(bArrCopyOf));
                return cipher.doFinal(bArr, 16, bArr.length - 16);
            } catch (InvalidAlgorithmParameterException e2) {
                b.b(f4520a, "InvalidAlgorithmParameterException: " + e2.getMessage());
                return bArr2;
            } catch (InvalidKeyException e3) {
                b.b(f4520a, "InvalidKeyException: " + e3.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e4) {
                b.b(f4520a, "NoSuchAlgorithmException: " + e4.getMessage());
                return bArr2;
            } catch (BadPaddingException e5) {
                b.b(f4520a, "BadPaddingException: " + e5.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e6) {
                b.b(f4520a, "IllegalBlockSizeException: " + e6.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e7) {
                b.b(f4520a, "NoSuchPaddingException: " + e7.getMessage());
                return bArr2;
            } catch (Exception e8) {
                b.b(f4520a, "Exception: " + e8.getMessage());
                return bArr2;
            }
        }
        b.b(f4520a, "alias or encrypt content is null");
        return bArr2;
    }
}
