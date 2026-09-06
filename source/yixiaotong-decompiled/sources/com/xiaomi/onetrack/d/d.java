package com.xiaomi.onetrack.d;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9485a = s.d(new byte[]{34, 93, 2, 84, 67, 70, 52, 16, 15, 14}, "f4e102");
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr, boolean z) {
        return new String(a(bArr, z ? b : c));
    }

    private static MessageDigest a() {
        return a(s.d(new byte[]{125, 34, 5}, "0f0dc6"));
    }

    public static MessageDigest a(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static byte[] a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        return a().digest(bArr);
    }

    private static char[] a(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[bArr.length << 1];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b2 & 240) >>> 4];
            i += 2;
            cArr2[i2] = cArr[b2 & 15];
        }
        return cArr2;
    }

    public static String b(byte[] bArr) {
        return a(a(bArr), true);
    }

    private static MessageDigest b() {
        return a(s.d(new byte[]{54, 126, 39, Ascii.ESC, 7, 12, 87}, "e6f659"));
    }

    public static byte[] b(String str) {
        return a(a(str, s.d(new byte[]{108, 96, 127, 78, 89}, "949cad")));
    }

    public static String c(String str) {
        return a(b(str), true);
    }

    private static MessageDigest c() {
        return a(s.d(new byte[]{107, 46, 113, 83}, "8f0b7e"));
    }

    public static byte[] c(byte[] bArr) {
        return b().digest(bArr);
    }

    public static String d(String str) {
        return a(g(str), true);
    }

    public static String d(byte[] bArr) {
        return a(c(bArr), true);
    }

    public static String e(String str) {
        return a(f(str), true);
    }

    public static String e(byte[] bArr) {
        String str;
        if (bArr != null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(s.d(new byte[]{46, 34, 81}, "cfd611"));
                messageDigest.update(bArr);
                str = String.format(s.d(new byte[]{67, 82, 66, 8, 7, 2, 57}, "fcf840"), new BigInteger(1, messageDigest.digest()));
            } catch (Exception e) {
                p.b(f9485a, s.d(new byte[]{2, 6, 66, 127, 124, 0, 65, 1, Ascii.RS, 1, 84, Ascii.NAK, 17, 10, 89, 92, 2, Ascii.NAK}, "ec6285") + e);
                str = "";
            }
        } else {
            str = "";
        }
        return str.toLowerCase();
    }

    public static byte[] f(String str) {
        return c(a(str, s.d(new byte[]{100, 102, 127, 78, 93}, "129ceb")));
    }

    public static byte[] g(String str) {
        return c().digest(a(str, s.d(new byte[]{96, 96, 118, 26, 8}, "54070e")));
    }

    public static String h(String str) {
        return TextUtils.isEmpty(str) ? "" : e(str.getBytes());
    }
}
