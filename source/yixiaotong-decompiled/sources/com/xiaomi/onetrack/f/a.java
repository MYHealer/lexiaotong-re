package com.xiaomi.onetrack.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.xiaomi.onetrack.util.j;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f9489a;
    private static Context b;
    private static int c;
    private static String d;
    private static String e;
    private static long f;
    private static volatile boolean g;

    public static Context a() {
        if (!j.d(f9489a)) {
            return f9489a;
        }
        Context context = b;
        if (context != null) {
            return context;
        }
        synchronized (a.class) {
            if (b == null) {
                b = j.a(f9489a);
            }
        }
        return b;
    }

    public static PackageInfo a(Context context, String str, int i) {
        try {
            return context.getPackageManager().getPackageInfo(str, i);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void a(Context context) {
        if (g) {
            return;
        }
        synchronized (a.class) {
            if (g) {
                return;
            }
            f9489a = context;
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(f9489a.getPackageName(), 0);
                c = packageInfo.versionCode;
                d = packageInfo.versionName;
                f = packageInfo.lastUpdateTime;
                e = f9489a.getPackageName();
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
            g = true;
        }
    }

    public static boolean a(Context context, String str) {
        try {
            return a(a(context, str, 0).applicationInfo);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) != 0;
    }

    public static Context b() {
        return f9489a;
    }

    public static boolean b(Context context, String str) {
        PackageInfo packageInfoA = a(context, str, 0);
        return (packageInfoA == null || packageInfoA.applicationInfo == null) ? false : true;
    }

    public static String c() {
        return d;
    }

    public static String c(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            return packageManager.getApplicationInfo(str, 0).loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int d() {
        return c;
    }

    public static String e() {
        return e;
    }

    public static long f() {
        return f;
    }
}
