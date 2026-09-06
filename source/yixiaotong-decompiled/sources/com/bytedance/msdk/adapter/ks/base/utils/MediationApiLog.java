package com.bytedance.msdk.adapter.ks.base.utils;

import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class MediationApiLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f3090a = false;
    private static String b = "Tme";

    public static void e(String str) {
        if (f3090a) {
            Log.e(b, str);
        }
    }

    public static void e(String str, String str2) {
        if (f3090a) {
            Log.e(str, str2);
        }
    }

    public static void i(String str) {
        if (f3090a) {
            Log.i(b, str);
        }
    }

    public static void i(String str, String str2) {
        if (f3090a) {
            Log.i(str, str2);
        }
    }

    public static void setDebug(Boolean bool) {
        f3090a = bool.booleanValue();
    }
}
