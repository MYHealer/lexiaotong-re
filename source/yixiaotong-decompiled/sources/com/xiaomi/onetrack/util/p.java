package com.xiaomi.onetrack.util;

import android.text.TextUtils;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f9551a = false;
    public static boolean b = false;
    public static boolean c = false;
    private static final int d = 3000;
    private static final String e = ijiami_1011.s.s.s.d(new byte[]{123, 95, 0, 108, 70, 88, 2, 15, 75, 35, 65, 12, Ascii.EM}, "41e849");
    private static final int f = 0;
    private static final int g = 1;
    private static final int h = 2;
    private static final int i = 3;
    private static final int j = 4;
    private static boolean k;
    private static boolean l;
    private static boolean m;
    private static boolean n;

    public static String a(String str) {
        return e + str;
    }

    public static void a() {
        try {
            String strE = com.xiaomi.onetrack.f.a.e();
            String strA = ab.a(ijiami_1011.s.s.s.d(new byte[]{83, 3, 81, 71, 6, Ascii.EM, 14, 10, 3, Ascii.SYN, 67, 4, 84, 13, Ascii.GS, 94, 14, 80}, "7f32a7"));
            boolean z = true;
            l = (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strE) || !TextUtils.equals(strE, strA)) ? false : true;
            String strA2 = ab.a(ijiami_1011.s.s.s.d(new byte[]{82, 83, 4, 17, 82, Ascii.ESC, 14, 10, 3, Ascii.SYN, 67, 4, 85, 93, 72, 17, 69, 89, 14, 5, 2}, "66fd55"));
            b = (TextUtils.isEmpty(strA2) || TextUtils.isEmpty(strE) || !TextUtils.equals(strE, strA2)) ? false : true;
            String strA3 = ab.a(ijiami_1011.s.s.s.d(new byte[]{2, 92, 83, 17, 3, Ascii.RS, 14, 10, 3, Ascii.SYN, 67, 4, 5, 82, Ascii.US, 16, 1, 67, Ascii.NAK}, "f91dd0"));
            if (TextUtils.isEmpty(strA3) || TextUtils.isEmpty(strE) || !TextUtils.equals(strE, strA3)) {
                z = false;
            }
            n = z;
            b();
            c();
        } catch (Exception e2) {
            Log.e(ijiami_1011.s.s.s.d(new byte[]{118, 93, 80, 48, 75, 4, 2, 15, 53, 6, 90}, "935d9e"), ijiami_1011.s.s.s.d(new byte[]{121, 10, 6, 48, 70, 80, 13, 68, Ascii.NAK, Ascii.SYN, 80, 17, 92, 6, 65, 12, 92, 80, Ascii.NAK, 13, 7, 14, 88, Ascii.US, 80, Ascii.ETB, 91, 69}, "5eae29") + e2.toString());
        }
        Log.d(ijiami_1011.s.s.s.d(new byte[]{44, 10, 92, 98, 70, 89, 2, 15, 53, 6, 90}, "cd9648"), ijiami_1011.s.s.s.d(new byte[]{15, 14, 83, 17, 94, 90, 91, 68}, "ca4114") + l + ijiami_1011.s.s.s.d(new byte[]{73, 69, 70, Ascii.SYN, 12, 2, 10, 68, 19, Ascii.DC2, 93, 10, 4, 1, Ascii.ETB, 12, 11, 91, 65}, "ee7cea") + b);
    }

    public static void a(String str, String str2) {
        if (f9551a) {
            a(a(str), str2, 3);
        }
    }

    private static void a(String str, String str2, int i2) {
        if (str2 == null) {
            return;
        }
        int i3 = 0;
        while (i3 <= str2.length() / 3000) {
            int i4 = i3 * 3000;
            i3++;
            int iMin = Math.min(str2.length(), i3 * 3000);
            if (i4 < iMin) {
                String strSubstring = str2.substring(i4, iMin);
                if (i2 == 0) {
                    Log.e(str, strSubstring);
                } else if (i2 == 1) {
                    Log.w(str, strSubstring);
                } else if (i2 == 2) {
                    Log.i(str, strSubstring);
                } else if (i2 == 3) {
                    Log.d(str, strSubstring);
                } else if (i2 == 4) {
                    Log.v(str, strSubstring);
                }
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (f9551a) {
            Log.d(a(str), str2, th);
        }
    }

    public static void a(boolean z) {
        k = z;
        b();
    }

    private static void b() {
        f9551a = k || l;
        Log.d(ijiami_1011.s.s.s.d(new byte[]{43, 89, 80, 100, Ascii.ETB, 89, 2, 15, 53, 6, 90}, "d750e8"), ijiami_1011.s.s.s.d(new byte[]{17, Ascii.NAK, 0, 82, 77, 93, 37, 1, 4, Ascii.ETB, 86, 54, 19, 12, 16, 80, 81, Ascii.CAN, Ascii.DC2, 33, 8, 3, 83, 9, 1, 95, 68}, "ded398") + f9551a + ijiami_1011.s.s.s.d(new byte[]{19, 74, 37, 85, 0, 68, 6, 41, 9, 6, 84, -118, -113, -93}, "39a0b1") + k + ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, Ascii.ETB, 115, 92, 3, 68, 6, 52, Ascii.DC4, 13, 65, 0, 70, 16, 78, -42, -35, -85}, "4d79a1") + l);
    }

    public static void b(String str, String str2) {
        if (f9551a) {
            a(a(str), str2, 0);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (f9551a) {
            Log.e(a(str), str2, th);
        }
    }

    public static void b(boolean z) {
        m = z;
        c();
    }

    private static void c() {
        c = m || n;
        Log.d(ijiami_1011.s.s.s.d(new byte[]{120, 94, 0, 55, 66, 7, 2, 15, 53, 6, 90}, "70ec0f"), ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, 66, 87, 80, 65, 3, 53, 1, Ascii.NAK, Ascii.SYN, 98, Ascii.DC2, 8, 70, 80, 89, Ascii.NAK, Ascii.NAK, 53, 1, Ascii.NAK, Ascii.SYN, 116, 11, 0, 80, 95, 84, 15, 70}, "a2315f") + c + ijiami_1011.s.s.s.d(new byte[]{16, 66, 99, 0, 66, Ascii.DC2, 44, 11, 2, 7, -34, -39, -86}, "017e1f") + m + ijiami_1011.s.s.s.d(new byte[]{68, 17, 98, 92, SignedBytes.MAX_POWER_OF_TWO, 17, 49, Ascii.SYN, 9, Ascii.DC2, 84, Ascii.ETB, 16, Ascii.ESC, -39, -123, -87}, "db693e") + n);
    }

    public static void c(String str, String str2) {
        if (f9551a) {
            a(a(str), str2, 1);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (f9551a) {
            Log.w(a(str), str2, th);
        }
    }

    public static void d(String str, String str2) {
        if (f9551a) {
            a(a(str), str2, 2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (f9551a) {
            Log.i(a(str), str2, th);
        }
    }
}
