package com.opos.cmn.an.c;

import android.os.Build;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {
    public static String a() {
        return Build.MODEL != null ? Build.MODEL : "";
    }

    public static int b() {
        return Build.VERSION.SDK_INT;
    }

    public static String c() {
        return Build.VERSION.RELEASE != null ? Build.VERSION.RELEASE : "";
    }

    public static String d() {
        return Build.BRAND != null ? Build.BRAND : "";
    }

    public static String e() {
        return Build.MANUFACTURER != null ? Build.MANUFACTURER : "";
    }
}
