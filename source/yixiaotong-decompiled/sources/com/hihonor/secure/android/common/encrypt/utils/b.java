package com.hihonor.secure.android.common.encrypt.utils;

import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    private static final String TAG = "SecurityComp10105302: ";

    public static void c(String str, String str2) {
    }

    public static void b(String str, String str2) {
        Log.v(i(str), str2);
    }

    public static void d(String str, String str2) {
        Log.i(i(str), str2);
    }

    public static void e(String str, String str2) {
        Log.w(i(str), str2);
    }

    public static void f(String str, String str2) {
        Log.e(i(str), str2);
    }

    public static void a(String str, String str2, Throwable th) {
        Log.e(i(str), str2, th);
    }

    private static String i(String str) {
        return TAG + str;
    }
}
