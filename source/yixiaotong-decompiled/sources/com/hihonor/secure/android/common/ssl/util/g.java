package com.hihonor.secure.android.common.ssl.util;

import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g {
    private static final String TAG = "SecurityCompSSL10205311beta: ";

    public static void b(String str, String str2) {
    }

    public static void a(String str, String str2) {
        Log.v(f(str), str2);
    }

    public static void c(String str, String str2) {
        Log.i(f(str), str2);
    }

    public static void d(String str, String str2) {
        Log.w(f(str), str2);
    }

    public static void e(String str, String str2) {
        Log.e(f(str), str2);
    }

    public static void a(String str, String str2, Throwable th) {
        Log.e(f(str), str2, th);
    }

    private static String f(String str) {
        return TAG + str;
    }
}
