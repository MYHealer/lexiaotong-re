package com.hihonor.secure.android.common.ssl.util;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class i {
    private static final String FILE_NAME = "aegis";
    private static SharedPreferences ao;

    public static synchronized SharedPreferences f(Context context) {
        if (ao == null) {
            ao = context.createDeviceProtectedStorageContext().getSharedPreferences(FILE_NAME, 0);
        }
        return ao;
    }

    public static void a(String str, long j, Context context) {
        f(context).edit().putLong(str, j).apply();
    }

    public static long b(String str, long j, Context context) {
        return f(context).getLong(str, j);
    }

    public static void a(String str, int i, Context context) {
        f(context).edit().putInt(str, i).apply();
    }

    public static int b(String str, int i, Context context) {
        return f(context).getInt(str, i);
    }

    public static void a(String str, String str2, Context context) {
        f(context).edit().putString(str, str2).apply();
    }

    public static String b(String str, String str2, Context context) {
        return f(context).getString(str, str2);
    }

    public static void a(String str, Context context) {
        f(context).edit().remove(str).apply();
    }

    public static void g(Context context) {
        f(context).edit().clear().apply();
    }
}
