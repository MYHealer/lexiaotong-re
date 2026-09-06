package com.adprof.sdk;

import android.os.Build;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class b8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f1068a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Float f88a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Integer f89a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f90a;
    public static Integer b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static String f91b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;

    public static String a() {
        if (f == null) {
            DisplayMetrics displayMetrics = AdprofSdk.getInstance().getContext().getResources().getDisplayMetrics();
            f = displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
        }
        return f;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0055  */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m582a() {
        boolean z;
        if (f1068a == null) {
            String str = Build.FINGERPRINT;
            if (str.startsWith("generic") || str.startsWith("unknown")) {
                z = true;
            } else {
                String str2 = Build.MODEL;
                if (str2.contains("google_sdk") || str2.contains("Emulator") || str2.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || ((Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT))) {
                    z = true;
                } else {
                    z = false;
                }
            }
            f1068a = Boolean.valueOf(z);
        }
        return f1068a.booleanValue();
    }
}
