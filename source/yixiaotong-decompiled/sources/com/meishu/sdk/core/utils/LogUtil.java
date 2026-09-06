package com.meishu.sdk.core.utils;

import android.util.Log;
import com.meishu.sdk.core.AdSdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class LogUtil {
    public static final String TAG = "MeishuSdk";

    public static void d(String str, String str2) {
        if (AdSdk.adConfig() != null && AdSdk.adConfig().enableDebug()) {
            Log.d(getTag(str), "" + str2);
        }
    }

    public static void dev(String str, String str2) {
    }

    public static void dev(String str, Throwable th) {
    }

    public static void e(String str, String str2) {
        Log.e(getTag(str), "" + str2);
    }

    private static String getTag(String str) {
        return new StringBuffer("MeishuSdk_").append(str).toString();
    }

    public static void i(String str, String str2, Throwable th) {
        if (AdSdk.adConfig() != null && AdSdk.adConfig().enableDebug()) {
            Log.i(getTag(str), "" + str2, th);
        }
    }

    public static void w(String str, String str2) {
        Log.w(getTag(str), "" + str2);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e(getTag(str), "" + str2, th);
    }

    public static void i(String str, String str2) {
        if (AdSdk.adConfig() != null && AdSdk.adConfig().enableDebug()) {
            Log.i(getTag(str), "" + str2);
        }
    }
}
