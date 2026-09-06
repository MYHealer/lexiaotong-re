package com.miui.zeus.mimo.sdk;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import com.google.common.base.Ascii;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class q9 {
    public static String a(String str) {
        return ijiami_1011.s.s.s.d(new byte[]{114, 116, Ascii.GS, 99, 123, 51, 38, 45, 40, 79}, "30037f") + str;
    }

    public static void a(String str, String str2) {
        a(a(str), str2, 0);
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
        Log.e(a(str), str2 + IOUtils.LINE_SEPARATOR_UNIX + Patterns.IP_ADDRESS.matcher(Log.getStackTraceString(th)).replaceAll(ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN, Ascii.GS, 75, 74, 72, Ascii.EM, 75}, "23adb7")));
    }
}
