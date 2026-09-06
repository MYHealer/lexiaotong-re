package com.hihonor.secure.android.common.encrypt.keystore.rsa;

import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
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
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class RSASignKS {
    private static final String C = "AndroidKeyStore";
    private static final int H = 2048;
    private static final int I = 3072;
    private static final String J = "SHA256withRSA/PSS";
    private static final String TAG = "RSASignKS";
    private static final String i = "";

    public static boolean isBuildVersionHigherThan22() {
        return true;
    }

    @Deprecated
    public static String sign(String str, String str2) {
        try {
            return Base64.encodeToString(sign(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "sign UnsupportedEncodingException : " + e.getMessage());
            return "";
        }
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, String str3) {
        try {
            return verifySign(str, str2.getBytes("UTF-8"), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "verifySign UnsupportedEncodingException: " + e.getMessage());
            return false;
        } catch (Exception e2) {
            b.f(TAG, "base64 decode Exception" + e2.getMessage());
            return false;
        }
    }

    public static String signNew(String str, String str2) {
        try {
            return Base64.encodeToString(signNew(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "sign UnsupportedEncodingException : " + e.getMessage());
            return "";
        }
    }

    public static boolean verifySignNew(String str, String str2, String str3) {
        try {
            return verifySignNew(str, str2.getBytes("UTF-8"), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "verifySign UnsupportedEncodingException: " + e.getMessage());
            return false;
        } catch (Exception e2) {
            b.f(TAG, "base64 decode Exception" + e2.getMessage());
            return false;
        }
    }

    @Deprecated
    public static byte[] sign(String str, byte[] bArr) {
        return b(str, bArr, false);
    }

    @Deprecated
    public static boolean verifySign(String str, byte[] bArr, byte[] bArr2) {
        return a(str, bArr, bArr2, false);
    }

    public static byte[] signNew(String str, byte[] bArr) {
        return b(str, bArr, true);
    }

    public static boolean verifySignNew(String str, byte[] bArr, byte[] bArr2) {
        return a(str, bArr, bArr2, true);
    }

    private static byte[] b(String str, byte[] bArr, boolean z) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.f(TAG, "alias or content is null");
            return bArr2;
        }
        if (!isBuildVersionHigherThan22()) {
            b.f(TAG, "sdk version is too low");
            return bArr2;
        }
        KeyStore.Entry entryC = c(str, z);
        if (!(entryC instanceof KeyStore.PrivateKeyEntry)) {
            b.f(TAG, "Not an instance of a PrivateKeyEntry");
            return bArr2;
        }
        try {
            Signature signature = Signature.getInstance(J);
            signature.initSign(((KeyStore.PrivateKeyEntry) entryC).getPrivateKey());
            signature.update(bArr);
            return signature.sign();
        } catch (InvalidKeyException e) {
            b.f(TAG, "InvalidKeyException: " + e.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e2) {
            b.f(TAG, "NoSuchAlgorithmException: " + e2.getMessage());
            return bArr2;
        } catch (SignatureException e3) {
            b.f(TAG, "SignatureException: " + e3.getMessage());
            return bArr2;
        } catch (Exception e4) {
            b.f(TAG, "Exception: " + e4.getMessage());
            return bArr2;
        }
    }

    private static boolean a(String str, byte[] bArr, byte[] bArr2, boolean z) {
        if (TextUtils.isEmpty(str) || bArr == null || bArr2 == null) {
            b.f(TAG, "alias or content or sign value is null");
            return false;
        }
        if (!isBuildVersionHigherThan22()) {
            b.f(TAG, "sdk version is too low");
            return false;
        }
        KeyStore.Entry entryC = c(str, z);
        if (!(entryC instanceof KeyStore.PrivateKeyEntry)) {
            b.f(TAG, "Not an instance of a PrivateKeyEntry");
            return false;
        }
        try {
            Signature signature = Signature.getInstance(J);
            signature.initVerify(((KeyStore.PrivateKeyEntry) entryC).getCertificate());
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (InvalidKeyException e) {
            b.f(TAG, "InvalidKeyException: " + e.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e2) {
            b.f(TAG, "NoSuchAlgorithmException: " + e2.getMessage());
            return false;
        } catch (SignatureException e3) {
            b.f(TAG, "SignatureException: " + e3.getMessage());
            return false;
        } catch (Exception e4) {
            b.f(TAG, "Exception: " + e4.getMessage());
            return false;
        }
    }

    private static synchronized KeyPair a(String str, boolean z) {
        KeyPair keyPairGenerateKeyPair = null;
        if (g(str)) {
            b.f(TAG, "Key pair exits");
            return null;
        }
        try {
            try {
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", C);
                if (!z) {
                    keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 12).setDigests("SHA-256", MessageDigestAlgorithms.SHA_512).setSignaturePaddings("PSS").setKeySize(2048).build());
                } else {
                    keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 12).setDigests("SHA-256", MessageDigestAlgorithms.SHA_512).setSignaturePaddings("PSS").setKeySize(I).build());
                }
                keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
            } catch (NoSuchProviderException e) {
                b.f(TAG, "NoSuchProviderException: " + e.getMessage());
            }
        } catch (InvalidAlgorithmParameterException e2) {
            b.f(TAG, "InvalidAlgorithmParameterException: " + e2.getMessage());
        } catch (NoSuchAlgorithmException e3) {
            b.f(TAG, "NoSuchAlgorithmException: " + e3.getMessage());
        }
        return keyPairGenerateKeyPair;
    }

    private static KeyStore.Entry c(String str, boolean z) {
        if (!g(str)) {
            a(str, z);
        }
        try {
            KeyStore keyStore = KeyStore.getInstance(C);
            keyStore.load(null);
            return keyStore.getEntry(str, null);
        } catch (IOException e) {
            b.f(TAG, "IOException: " + e.getMessage());
            return null;
        } catch (KeyStoreException e2) {
            b.f(TAG, "KeyStoreException: " + e2.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e3) {
            b.f(TAG, "NoSuchAlgorithmException: " + e3.getMessage());
            return null;
        } catch (UnrecoverableEntryException e4) {
            b.f(TAG, "UnrecoverableEntryException: " + e4.getMessage());
            return null;
        } catch (CertificateException e5) {
            b.f(TAG, "CertificateException: " + e5.getMessage());
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
        }
    }
}
