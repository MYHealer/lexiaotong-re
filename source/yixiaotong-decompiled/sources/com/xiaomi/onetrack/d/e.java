package com.xiaomi.onetrack.d;

import android.os.Build;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class e {
    private static final String b = s.d(new byte[]{100, 16, 84, 102, 71, 94, 13, Ascii.ETB}, "6c5337");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9486a = s.d(new byte[]{43, 125, 119, 83, 46, 112, 81, 35, 37, 49, SignedBytes.MAX_POWER_OF_TWO, 34, 53, 125, 82, 6, 39, 96, 36, 38, 39, 51, 100, 36, 39, 0, 119, 123, 34, 117, 34, 38, 15, 51, 122, 39, 1, 101, 115, 92, 43, 1, 19, 85, 94, 10, 3, 34, 77, 88, 127, 79, 57, 75, 81, 9, 53, 56, 101, 92, 10, 93, 106, 108, 110, 7, 8, 6, 49, 55, 71, 74, 4, 93, 113, 92, 12, 85, Ascii.DC4, 2, 86, Ascii.CAN, 68, 55, 4, 99, 101, 108, 36, 83, 82, Ascii.DC4, 46, 13, 83, Ascii.FS, 37, 123, 81, 66, 81, 125, 17, 50, 8, 14, 87, 93, 37, 81, 115, 108, Ascii.ETB, 83, 51, 46, 14, 26, 125, 92, Ascii.NAK, 95, 127, 76, 12, 100, 80, 53, 7, 111, 70, 34, Ascii.DC2, 91, 122, 79, Ascii.NAK, 103, 51, 80, 33, 0, 114, 10, 87, 121, 114, 97, 14, 107, 89, 60, 50, 10, 124, Ascii.NAK, Ascii.DC4, 70, 0, SignedBytes.MAX_POWER_OF_TWO, 13, 99, 7, Ascii.RS, Ascii.NAK, Ascii.ETB, 8, 34, 40, 98, 4, Ascii.RS, Ascii.ETB, 70, 2, 13, 41, 6, 98, 87, 5, 122, 122, 119, 84, 120, 47, 7, 17, 35, 104, 39, 32, 101, Base64.padSymbol, 12, Ascii.NAK, 122, 17, 3, 62, 36, 94, 32, 12, 99, 98, 93, 42, 86, Ascii.SYN, 41, 17, 43, 117, 36, 55, 117, 114, 56}, "f405c1");
    private static final String c = s.d(new byte[]{52, 54, 116, 77, 33, 112, 35, 75, 54, 41, 114, 54, 87, 53, 84, 6, 0, 90, 15, 3}, "fe5bd3");
    private static final String d = s.d(new byte[]{116, 113}, "62ebd6");
    private static final String e = s.d(new byte[]{107, 101, 118}, "96786b");

    private static RSAPublicKey a(String str) {
        return (RSAPublicKey) (Build.VERSION.SDK_INT >= 28 ? KeyFactory.getInstance(e) : KeyFactory.getInstance(e, d)).generatePublic(new X509EncodedKeySpec(c.a(str)));
    }

    public static byte[] a(byte[] bArr) {
        try {
            RSAPublicKey rSAPublicKeyA = a(f9486a);
            Cipher cipher = Cipher.getInstance(c, d);
            cipher.init(1, rSAPublicKeyA);
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            p.b(p.a(b), s.d(new byte[]{49, 16, 3, 54, 17, 15, 13, Ascii.ETB, 70, 7, 95, 6, 17, 26, Ascii.DC2, Ascii.ETB, 69, 3, Ascii.EM, 7, 3, Ascii.DC2, 69, 12, 12, 13, 88}, "ccbcef"), e2);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            RSAPublicKey rSAPublicKeyB = b(bArr);
            Cipher cipher = Cipher.getInstance(c);
            cipher.init(1, rSAPublicKeyB);
            return cipher.doFinal(bArr2);
        } catch (Exception e2) {
            p.b(b, s.d(new byte[]{96, Ascii.DC2, 80, 51, 17, 12, 13, 68, 3, 12, 82, Ascii.ETB, 75, 17, 69, 70, 0, Ascii.GS, 2, 1, Ascii.SYN, Ascii.SYN, 88, 10, 92, 91}, "2a1fee"), e2);
            return null;
        }
    }

    private static RSAPublicKey b(byte[] bArr) {
        return (RSAPublicKey) KeyFactory.getInstance(e).generatePublic(new X509EncodedKeySpec(bArr));
    }
}
