package com.hihonor.secure.android.common.encrypt.keystore.rsa;

import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.hihonor.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class RSAEncryptKS {
    private static final String C = "AndroidKeyStore";
    private static final String G = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
    private static final int H = 2048;
    private static final int I = 3072;
    private static final String TAG = "RSAEncryptKS";
    private static final String i = "";

    private static boolean isBuildVersionHigherThan22() {
        return true;
    }

    @Deprecated
    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(encrypt(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e) {
            b.f(TAG, "UnsupportedEncodingException: " + e.getMessage());
            return "";
        }
    }

    @Deprecated
    public static String decrpyt(String str, String str2) {
        try {
            return new String(decrpyt(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            b.f(TAG, "UnsupportedEncodingException: " + e.getMessage());
            return "";
        } catch (Exception e2) {
            b.f(TAG, "Exception: " + e2.getMessage());
            return "";
        }
    }

    @Deprecated
    public static byte[] encrypt(String str, byte[] bArr) {
        return a(str, bArr, false);
    }

    @Deprecated
    public static byte[] decrpyt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.f(TAG, "alias or encrypted content is null");
            return bArr2;
        }
        if (!isBuildVersionHigherThan22()) {
            b.f(TAG, "sdk version is too low");
            return bArr2;
        }
        PrivateKey privateKey = getPrivateKey(str);
        if (privateKey == null) {
            b.f(TAG, "Private key is null");
            return bArr2;
        }
        try {
            Cipher cipher = Cipher.getInstance(G);
            cipher.init(2, privateKey, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec(MessageDigestAlgorithms.SHA_1), PSource.PSpecified.DEFAULT));
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException e) {
            b.f(TAG, "InvalidAlgorithmParameterException: " + e.getMessage());
            return bArr2;
        } catch (InvalidKeyException e2) {
            b.f(TAG, "InvalidKeyException: " + e2.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e3) {
            b.f(TAG, "NoSuchAlgorithmException: " + e3.getMessage());
            return bArr2;
        } catch (BadPaddingException e4) {
            b.f(TAG, "BadPaddingException: " + e4.getMessage());
            return bArr2;
        } catch (IllegalBlockSizeException e5) {
            b.f(TAG, "IllegalBlockSizeException: " + e5.getMessage());
            return bArr2;
        } catch (NoSuchPaddingException e6) {
            b.f(TAG, "NoSuchPaddingException: " + e6.getMessage());
            return bArr2;
        } catch (Exception e7) {
            b.f(TAG, "Exception: " + e7.getMessage());
            return bArr2;
        }
    }

    public static String encryptNew(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(encryptNew(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e) {
            b.f(TAG, "UnsupportedEncodingException: " + e.getMessage());
            return "";
        }
    }

    public static String decrpytNew(String str, String str2) {
        try {
            return new String(decrpytNew(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            b.f(TAG, "UnsupportedEncodingException: " + e.getMessage());
            return "";
        } catch (Exception e2) {
            b.f(TAG, "Exception: " + e2.getMessage());
            return "";
        }
    }

    public static byte[] encryptNew(String str, byte[] bArr) {
        return a(str, bArr, true);
    }

    public static byte[] decrpytNew(String str, byte[] bArr) {
        return decrpyt(str, bArr);
    }

    private static byte[] a(String str, byte[] bArr, boolean z) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.f(TAG, "alias or content is null");
            return bArr2;
        }
        if (!isBuildVersionHigherThan22()) {
            b.f(TAG, "sdk version is too low");
            return bArr2;
        }
        PublicKey publicKeyB = b(str, z);
        if (publicKeyB == null) {
            b.f(TAG, "Public key is null");
            return bArr2;
        }
        try {
            Cipher cipher = Cipher.getInstance(G);
            cipher.init(1, publicKeyB, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec(MessageDigestAlgorithms.SHA_1), PSource.PSpecified.DEFAULT));
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException e) {
            b.f(TAG, "InvalidAlgorithmParameterException: " + e.getMessage());
            return bArr2;
        } catch (InvalidKeyException e2) {
            b.f(TAG, "InvalidKeyException: " + e2.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e3) {
            b.f(TAG, "NoSuchAlgorithmException: " + e3.getMessage());
            return bArr2;
        } catch (BadPaddingException e4) {
            b.f(TAG, "BadPaddingException: " + e4.getMessage());
            return bArr2;
        } catch (IllegalBlockSizeException e5) {
            b.f(TAG, "IllegalBlockSizeException: " + e5.getMessage());
            return bArr2;
        } catch (NoSuchPaddingException e6) {
            b.f(TAG, "NoSuchPaddingException: " + e6.getMessage());
            return bArr2;
        } catch (Exception e7) {
            b.f(TAG, "Exception: " + e7.getMessage());
            return bArr2;
        }
    }

    private static synchronized KeyPair a(String str, boolean z) {
        KeyPair keyPairGenerateKeyPair = null;
        if (g(str)) {
            b.f(TAG, "Key pair exits");
            return null;
        }
        b.d(TAG, "generate key pair.");
        try {
            try {
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", C);
                if (!z) {
                    keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests("SHA-256", MessageDigestAlgorithms.SHA_512).setEncryptionPaddings("OAEPPadding").setKeySize(2048).build());
                } else {
                    keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests("SHA-256", MessageDigestAlgorithms.SHA_512).setEncryptionPaddings("OAEPPadding").setKeySize(I).build());
                }
                keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
            } catch (NoSuchAlgorithmException e) {
                b.f(TAG, "NoSuchAlgorithmException: " + e.getMessage());
            } catch (NoSuchProviderException e2) {
                b.f(TAG, "NoSuchProviderException: " + e2.getMessage());
            }
        } catch (InvalidAlgorithmParameterException e3) {
            b.f(TAG, "InvalidAlgorithmParameterException: " + e3.getMessage());
        } catch (Exception e4) {
            b.f(TAG, "Exception: " + e4.getMessage());
        }
        return keyPairGenerateKeyPair;
    }

    private static PublicKey b(String str, boolean z) {
        if (!g(str)) {
            a(str, z);
        }
        Certificate certificateF = f(str);
        if (certificateF != null) {
            return certificateF.getPublicKey();
        }
        return null;
    }

    private static Certificate f(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance(C);
            keyStore.load(null);
            return keyStore.getCertificate(str);
        } catch (IOException e) {
            b.f(TAG, "IOException: " + e.getMessage());
            return null;
        } catch (KeyStoreException e2) {
            b.f(TAG, "KeyStoreException: " + e2.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e3) {
            b.f(TAG, "NoSuchAlgorithmException: " + e3.getMessage());
            return null;
        } catch (CertificateException e4) {
            b.f(TAG, "CertificateException: " + e4.getMessage());
            return null;
        } catch (Exception e5) {
            b.f(TAG, "Exception: " + e5.getMessage());
            return null;
        }
    }

    private static PrivateKey getPrivateKey(String str) {
        if (!g(str)) {
            return null;
        }
        try {
            KeyStore keyStore = KeyStore.getInstance(C);
            keyStore.load(null);
            return (PrivateKey) keyStore.getKey(str, null);
        } catch (IOException e) {
            b.f(TAG, "IOException: " + e.getMessage());
            return null;
        } catch (KeyStoreException e2) {
            b.f(TAG, "KeyStoreException: " + e2.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e3) {
            b.f(TAG, "NoSuchAlgorithmException: " + e3.getMessage());
            return null;
        } catch (UnrecoverableKeyException e4) {
            b.f(TAG, "UnrecoverableKeyException: " + e4.getMessage());
            return null;
        } catch (CertificateException e5) {
            b.f(TAG, "CertificateException: " + e5.getMessage());
            return null;
        } catch (Exception e6) {
            b.f(TAG, "Exception: " + e6.getMessage());
            return null;
        }
    }

    private static boolean g(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance(C);
            keyStore.load(null);
            return keyStore.getKey(str, null) != null;
        } catch (IOException e) {
            b.f(TAG, "IOException: " + e.getMessage());
            return false;
        } catch (KeyStoreException e2) {
            b.f(TAG, "KeyStoreException: " + e2.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e3) {
            b.f(TAG, "NoSuchAlgorithmException: " + e3.getMessage());
            return false;
        } catch (UnrecoverableKeyException e4) {
            b.f(TAG, "UnrecoverableKeyException: " + e4.getMessage());
            return false;
        } catch (CertificateException e5) {
            b.f(TAG, "CertificateException: " + e5.getMessage());
            return false;
        } catch (Exception e6) {
            b.f(TAG, "Exception: " + e6.getMessage());
            return false;
        }
    }
}
