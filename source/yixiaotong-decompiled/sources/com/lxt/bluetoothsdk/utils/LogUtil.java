package com.lxt.bluetoothsdk.utils;

import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class LogUtil {
    private static boolean mIsDebug = true;
    private static boolean mIsVisable = true;

    public static void setOpenLog(boolean z) {
        mIsVisable = z;
    }

    public static void log_i(String str, String str2) {
        if (mIsDebug) {
            Log.i(str, str2);
        }
    }

    public static void log_e(String str, String str2) {
        if (mIsDebug) {
            Log.e(str, str2);
        }
    }

    public static void log_w(String str, String str2) {
        if (mIsDebug && mIsVisable) {
            Log.w(str, str2);
        }
    }
}
