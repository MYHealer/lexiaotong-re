package com.xiaomi.onetrack.d;

import android.util.Base64;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.util.m;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9482a = s.d(new byte[]{32, 39, 53}, "abf510");
    private static final String b = s.d(new byte[]{35, 112, 96, Ascii.GS, 33, 123, 35, 75, 54, 41, 114, 54, 87, 101, 82, 86, 0, 81, 15, 3}, "b532d8");
    private static final String c = s.d(new byte[]{112, 125, 101}, "1864e7");
    private static KeyGenerator d;

    static {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(s.d(new byte[]{114, 114, 55}, "37d058"));
            d = keyGenerator;
            keyGenerator.init(128);
        } catch (Exception e) {
            p.b(p.a(s.d(new byte[]{117, 32, 53}, "4efd39")), s.d(new byte[]{120, 4, 74, 49, Ascii.ETB, 10, 13, 68, 3}, "9a9dcc"), e);
        }
    }

    public static String a(String str) {
        try {
            char[] charArray = (str + b.f9483a).toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                for (int i2 = 0; i2 < charArray.length - 1; i2++) {
                    char c2 = charArray[i];
                    char c3 = charArray[i2];
                    if (c2 < c3) {
                        charArray[i] = c3;
                        charArray[i2] = c2;
                    }
                }
            }
            return d.h(new String(charArray));
        } catch (Exception unused) {
            p.b(f9482a, s.d(new byte[]{92, 90, 7, 93, 2, 85, 39, Ascii.SYN, 9, 15, 98, 4, 85, SignedBytes.MAX_POWER_OF_TWO, 68}, "94d2f0") + "");
            return "";
        }
    }

    public static String a(String str, String str2) {
        return m.a(e(str, str2));
    }

    public static byte[] a() {
        return d.generateKey().getEncoded();
    }

    private static byte[] a(byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(b(str), f9482a);
            Cipher cipher = Cipher.getInstance(b);
            cipher.init(2, secretKeySpec);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            p.b(p.a(f9482a), s.d(new byte[]{5, 85, 0, SignedBytes.MAX_POWER_OF_TWO, 76, Ascii.DC4, Ascii.NAK, 68, 3, 26, 82, 0, 17, 68, 10, 93, 91, 94}, "a0c25d"), e);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f9482a);
            Cipher cipher = Cipher.getInstance(b);
            cipher.init(1, secretKeySpec);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            p.b(p.a(f9482a), s.d(new byte[]{3, 10, 6, 74, Ascii.FS, 65, Ascii.NAK, 68, 3, 26, 82, 0, Ascii.SYN, 16, 12, 87, 11, 11}, "fde8e1"), e);
            return null;
        }
    }

    public static String b(String str, String str2) {
        return Base64.encodeToString(e(str, str2), 10);
    }

    private static byte[] b(String str) {
        if (str != null) {
            return str.getBytes();
        }
        return null;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f9482a);
            Cipher cipher = Cipher.getInstance(b);
            cipher.init(2, secretKeySpec);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            String str = f9482a;
            p.b(str, s.d(new byte[]{85, 83, 0, Ascii.ETB, 26, Ascii.SYN, Ascii.NAK, 68, 3, 26, 82, 0, 65, 66, 10, 10, 13, 92}, "16cecf"), e);
            p.b(str, s.d(new byte[]{0, 12, 88, 77, 81, 11, Ascii.NAK, 68, 10, 7, 95, 88}, "cc694e") + bArr.length + s.d(new byte[]{Ascii.CAN, Ascii.CAN, SignedBytes.MAX_POWER_OF_TWO, 87, 75, Ascii.SYN, Ascii.SYN, 0, 70, 14, 84, 11, 9}, "48068e") + bArr2.length);
            return null;
        }
    }

    public static String c(String str, String str2) {
        return new String(a(c(str), str2));
    }

    private static byte[] c(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
        }
        return bArr;
    }

    public static String d(String str, String str2) {
        return new String(a(Base64.decode(str, 10), str2));
    }

    private static byte[] e(String str, String str2) {
        return a(str.getBytes(), str2.getBytes());
    }
}
