package com.yfanads.android.adx.core.load;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class SPManager {
    public static boolean getBoolean(Context context, String str, boolean z) {
        try {
            return context.getSharedPreferences("adxsdk_api_pref", 0).getBoolean(str, z);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static long getLong(Context context, String str) {
        return getLong(context, str, 0L);
    }

    public static String getString(Context context, String str) {
        return getString(context, str, "");
    }

    public static void save(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("adxsdk_api_pref", 0).edit().putString(str, str2).commit();
        } catch (Throwable unused) {
        }
    }

    public static void saveBoolean(Context context, String str, boolean z) {
        try {
            context.getSharedPreferences("adxsdk_api_pref", 0).edit().putBoolean(str, z).commit();
        } catch (Throwable unused) {
        }
    }

    public static void saveLong(Context context, String str, long j) {
        try {
            context.getSharedPreferences("adxsdk_api_pref", 0).edit().putLong(str, j).commit();
        } catch (Throwable unused) {
        }
    }

    private static long getLong(Context context, String str, long j) {
        try {
            return context.getSharedPreferences("adxsdk_api_pref", 0).getLong(str, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String getString(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("adxsdk_api_pref", 0).getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }
}
