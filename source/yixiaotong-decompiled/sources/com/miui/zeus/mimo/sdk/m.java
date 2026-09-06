package com.miui.zeus.mimo.sdk;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import com.google.common.base.Ascii;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f5524a = 1;
    public static String b;

    static {
        Looper.getMainLooper().getThread().getId();
        b = "";
    }

    public static String a(String str) {
        return ("".equals(b) ? ijiami_1011.s.s.s.d(new byte[]{32, 124, Ascii.DC4, 50, 117, 103, 38, 45, 40, 79}, "a89b92") : b) + str;
    }

    public static String a(String str, Throwable th) {
        return str + IOUtils.LINE_SEPARATOR_UNIX + Patterns.IP_ADDRESS.matcher(Log.getStackTraceString(th)).replaceAll(ijiami_1011.s.s.s.d(new byte[]{Ascii.EM, Ascii.US, Ascii.ESC, 79, Ascii.RS, Ascii.GS, 75}, "311a43"));
    }

    public static void a(String str, String str2) {
        if (f5524a >= 3) {
            a(a(str), str2, 3);
        }
    }

    public static void a(String str, String str2, int i) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        int length = str2.length() / 3000;
        int i2 = 0;
        while (i2 <= length) {
            int i3 = i2 * 3000;
            i2++;
            int iMin = Math.min(str2.length(), i2 * 3000);
            if (i3 < iMin) {
                String strSubstring = str2.substring(i3, iMin);
                if (i == 0) {
                    Log.e(str, strSubstring);
                } else if (i == 1) {
                    Log.w(str, strSubstring);
                } else if (i == 2) {
                    Log.i(str, strSubstring);
                } else if (i == 3) {
                    Log.d(str, strSubstring);
                } else if (i == 4) {
                    Log.v(str, strSubstring);
                }
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (f5524a >= 3) {
            Log.d(a(str), a(str2, th));
        }
    }

    public static void b(String str, String str2) {
        if (f5524a >= 0) {
            a(a(str), str2, 0);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (f5524a >= 0) {
            Log.e(a(str), a(str2, th));
        }
    }

    public static String c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return !str.contains(str2) ? str : str.substring(str.lastIndexOf(str2) + 1);
    }

    public static void c(String str, String str2, Throwable th) {
        if (f5524a >= 1) {
            Log.w(a(str), a(str2, th));
        }
    }

    public static void d(String str, String str2) {
        if (f5524a >= 2) {
            a(a(str), str2, 2);
        }
    }

    public static void e(String str, String str2) {
        if (f5524a >= 1) {
            a(a(str), str2, 1);
        }
    }
}
