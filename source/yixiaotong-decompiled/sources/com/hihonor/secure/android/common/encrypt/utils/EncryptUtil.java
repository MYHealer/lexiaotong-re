package com.hihonor.secure.android.common.encrypt.utils;

import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.prng.SP800SecureRandomBuilder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class EncryptUtil {
    private static final String P = "RSA";
    private static boolean Q = false;
    private static boolean R = true;
    private static final String TAG = "EncryptUtil";

    private static boolean a() {
        return true;
    }

    public static boolean isBouncycastleFlag() {
        return Q;
    }

    public static byte[] generateSecureRandom(int i) {
        if (!Q || !a()) {
            try {
                byte[] bArr = new byte[i];
                new SecureRandom().nextBytes(bArr);
                return bArr;
            } catch (Exception e) {
                b.f(TAG, "generate secure random error" + e.getMessage());
                return new byte[0];
            }
        }
        return b(i);
    }

    public static String generateSecureRandomStr(int i) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(i));
    }

    public static SecureRandom genSecureRandom() {
        if (!Q || !a()) {
            return new SecureRandom();
        }
        return b();
    }

    private static SecureRandom b() {
        try {
            SecureRandom instanceStrong = SecureRandom.getInstanceStrong();
            AESEngine aESEngine = new AESEngine();
            byte[] bArr = new byte[32];
            instanceStrong.nextBytes(bArr);
            return new SP800SecureRandomBuilder(instanceStrong, true).setEntropyBitsRequired(384).buildCTR(aESEngine, 256, bArr, false);
        } catch (NoSuchAlgorithmException unused) {
            b.f(TAG, "NoSuchAlgorithmException");
            return new SecureRandom();
        } catch (Throwable th) {
            if (R) {
                b.f(TAG, "exception : " + th.getMessage() + " , you should implementation bcprov-jdk15on library");
                R = false;
            }
            return new SecureRandom();
        }
    }

    private static byte[] b(int i) {
        b.c(TAG, "generateSecureRandomNew ");
        SecureRandom secureRandomB = b();
        if (secureRandomB == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        secureRandomB.nextBytes(bArr);
        return bArr;
    }

    public static void setBouncycastleFlag(boolean z) {
        b.d(TAG, "setBouncycastleFlag: " + z);
        Q = z;
    }

    public static RSAPublicKey getPublicKey(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance(P).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                b.f(TAG, "load Key Exception:" + e.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            b.f(TAG, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e2) {
            b.f(TAG, "base64 decode Exception" + e2.getMessage());
            return null;
        }
    }

    public static PrivateKey getPrivateKey(String str) {
        try {
            try {
                return KeyFactory.getInstance(P).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                b.f(TAG, "load Key Exception:" + e.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            b.f(TAG, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e2) {
            b.f(TAG, "base64 decode Exception" + e2.getMessage());
            return null;
        }
    }
}
