package com.huawei.secure.android.common.encrypt.utils;

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

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class EncryptUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4527a = "EncryptUtil";
    private static final String b = "RSA";
    private static boolean c = false;
    private static boolean d = true;

    private static SecureRandom a() {
        SecureRandom secureRandom;
        b.a(f4527a, "generateSecureRandomNew ");
        try {
            secureRandom = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException unused) {
            b.b(f4527a, "getSecureRandomBytes: NoSuchAlgorithmException");
            secureRandom = null;
        }
        if (secureRandom == null) {
            try {
                secureRandom = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException unused2) {
                b.b(f4527a, "NoSuchAlgorithmException");
                return secureRandom;
            } catch (Throwable th) {
                if (d) {
                    b.b(f4527a, "exception : " + th.getMessage() + " , you should implementation bcprov-jdk15on library");
                    d = false;
                }
                return secureRandom;
            }
        }
        AESEngine aESEngine = new AESEngine();
        byte[] bArr = new byte[32];
        secureRandom.nextBytes(bArr);
        return new SP800SecureRandomBuilder(secureRandom, true).setEntropyBitsRequired(384).buildCTR(aESEngine, 256, bArr, false);
    }

    public static String generateSecureRandomStr(int i) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(i));
    }

    public static PrivateKey getPrivateKey(String str) {
        try {
            try {
                return KeyFactory.getInstance(b).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                b.b(f4527a, "load Key Exception:" + e.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            b.b(f4527a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e2) {
            b.b(f4527a, "base64 decode Exception" + e2.getMessage());
            return null;
        }
    }

    public static RSAPublicKey getPublicKey(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance(b).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                b.b(f4527a, "load Key Exception:" + e.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            b.b(f4527a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e2) {
            b.b(f4527a, "base64 decode Exception" + e2.getMessage());
            return null;
        }
    }

    public static boolean isBouncycastleFlag() {
        return c;
    }

    public static void setBouncycastleFlag(boolean z) {
        b.c(f4527a, "setBouncycastleFlag: " + z);
        c = z;
    }

    public static byte[] generateSecureRandom(int i) {
        SecureRandom secureRandom;
        if (c) {
            return a(i);
        }
        byte[] bArr = new byte[i];
        try {
            secureRandom = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException unused) {
            b.b(f4527a, "getSecureRandomBytes: NoSuchAlgorithmException");
            secureRandom = null;
        }
        if (secureRandom == null) {
            try {
                secureRandom = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException unused2) {
                b.b(f4527a, "getSecureRandomBytes getInstance: NoSuchAlgorithmException");
                return new byte[0];
            } catch (Exception e) {
                b.b(f4527a, "getSecureRandomBytes getInstance: exception : " + e.getMessage());
                return new byte[0];
            }
        }
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    public static SecureRandom genSecureRandom() {
        if (!c) {
            try {
                return SecureRandom.getInstanceStrong();
            } catch (NoSuchAlgorithmException unused) {
                b.b(f4527a, "genSecureRandom: NoSuchAlgorithmException");
                return null;
            }
        }
        return a();
    }

    private static byte[] a(int i) {
        SecureRandom secureRandomA = a();
        if (secureRandomA == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        secureRandomA.nextBytes(bArr);
        return bArr;
    }
}
