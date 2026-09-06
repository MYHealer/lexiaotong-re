package com.adprof.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PackageInfo f1396a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f696a;
    public static String b;
    public static String c;

    public static PackageInfo a(Context context) {
        if (f1396a == null) {
            PackageManager packageManager = context != null ? context.getPackageManager() : null;
            String strM713a = m713a(context);
            if (packageManager == null || strM713a == null) {
                return null;
            }
            try {
                f1396a = packageManager.getPackageInfo(strM713a, 0);
            } catch (Throwable unused) {
            }
        }
        return f1396a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m713a(Context context) {
        if (context == null) {
            return null;
        }
        if (!TextUtils.isEmpty(f696a)) {
            return f696a;
        }
        String packageName = context.getPackageName();
        f696a = packageName;
        return packageName;
    }
}
