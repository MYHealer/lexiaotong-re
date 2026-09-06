package com.hihonor.updater.installsdk.c;

import android.util.Log;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3734a = "updater-install-sdk";

    public static void a(String str, String str2) {
        Log.d(f3734a, (str == null ? "" : str + x.bQ) + str2);
    }

    public static void b(String str, String str2) {
        Log.e(f3734a, (str == null ? "" : str + x.bQ) + str2);
    }

    public static void c(String str, String str2) {
        Log.i(f3734a, (str == null ? "" : str + x.bQ) + str2);
    }

    public static void d(String str, String str2) {
        Log.w(f3734a, (str == null ? "" : str + x.bQ) + str2);
    }
}
