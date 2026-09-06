package com.huawei.hms.ads.uiengineloader;

import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3890a = "ppsuiengineloader.";

    public static void a(String str, String str2) {
        Log.d(f3890a.concat(String.valueOf(str)), str2);
    }

    public static void b(String str, String str2) {
        Log.i(f3890a.concat(String.valueOf(str)), str2);
    }

    public static void c(String str, String str2) {
        Log.w(f3890a.concat(String.valueOf(str)), str2);
    }

    public static void d(String str, String str2) {
        Log.e(f3890a.concat(String.valueOf(str)), str2);
    }
}
